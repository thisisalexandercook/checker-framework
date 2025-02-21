package org.checkerframework.runtime;

import static net.bytebuddy.matcher.ElementMatchers.isMethod;
import static net.bytebuddy.matcher.ElementMatchers.not;
import static net.bytebuddy.matcher.ElementMatchers.returns;

import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.JavaModule;

public class RuntimeAgent {

    /** premain is called before the main application starts (when using -javaagent). */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Runtime Agent initialized (method-level).");

        // Example: Suppose nullness diagnostic for "DummyTest.getString".
        DiagnosticsRepository.addDiagnostic(
                "DummyTest",
                "getString",
                new Diagnostic("Nullness", "Open obligation: variable must not be null."));

        // Build a set of class names to instrument.
        Set<String> classesToInstrument = new HashSet<>();
        classesToInstrument.add("DummyTest");

        new AgentBuilder.Default()
                .with(AgentBuilder.Listener.StreamWriting.toSystemOut())
                .type(
                        typeDescription -> {
                            System.out.println("Saw type: " + typeDescription.getName());
                            boolean shouldMatch =
                                    classesToInstrument.contains(typeDescription.getSimpleName());
                            if (shouldMatch) {
                                System.out.println("Will instrument: " + typeDescription.getName());
                            }
                            return shouldMatch;
                        })
                .transform(
                        new AgentBuilder.Transformer() {
                            @Override
                            public DynamicType.Builder<?> transform(
                                    DynamicType.Builder<?> builder,
                                    TypeDescription typeDescription,
                                    ClassLoader classLoader,
                                    JavaModule module,
                                    ProtectionDomain protectionDomain) {
                                // Exclude void-returning methods to avoid "Cannot assign void to
                                // class..." errors.
                                ElementMatcher<? super MethodDescription> methodMatcher =
                                        isMethod().and(not(returns(void.class)));

                                System.out.println(
                                        "Transforming: "
                                                + typeDescription.getName()
                                                + " with matcher that excludes void returns.");

                                return builder.visit(
                                        Advice.to(DiagnosticAdvice.class).on(methodMatcher));
                            }
                        })
                .installOn(inst);
    }

    public static void checkNullness(String returnedValue, String className, String methodName) {
        Diagnostic diag = DiagnosticsRepository.getDiagnosticForMethod(className, methodName);
        if (diag != null) {
            System.out.println(
                    "Encountered diagnostic in " + className + "." + methodName + " -> " + diag);
            if ("Nullness".equals(diag.getType()) && returnedValue == null) {
                throw new NullPointerException(
                        "Nullness check failed in "
                                + className
                                + "."
                                + methodName
                                + ": "
                                + diag.getMessage());
            }
        }
    }
}
