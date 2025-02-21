package org.checkerframework.runtime;

import java.lang.instrument.Instrumentation;
import java.util.Map;

public class RuntimeAgent {

    public static RuntimeDiagnostics diagnostics = new RuntimeDiagnostics();


    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Runtime Agent initialized.");

        // sample diagnostic
        diagnostics.addDiagnostic("DummyTest.java", 20,
                new Diagnostic("Nullness", "Open obligation: variable should not be null."));

        System.out.println("Diagnostics Map Contents:");
        for (Map.Entry<SourceLocation, Diagnostic> entry : diagnostics.getDiagnostics().entrySet()) {
            System.out.println("Location " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}

