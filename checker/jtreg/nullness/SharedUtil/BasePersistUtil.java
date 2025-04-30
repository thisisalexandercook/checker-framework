import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.StringJoiner;

/**
 * Utility class that can be shared between {@code com.sun.tools.classfile} and new {@code
 * java.lang.classfile}.
 *
 * <p>The class performs three independent tasks needed by every test:
 *
 * <ol>
 *   <li><b>Source discovery</b> – {@link #testClassOf(Method)} inspects the test-harness method for
 *       a {@link TestClass} annotation and tells the driver which binary to parse (defaults to
 *       {@code "Test"}).
 *   <li><b>Source generation & compilation</b> – {@link #wrap(String)} turns a compact Java snippet
 *       into a full compilation unit, adding the standard imports used in the Checker Framework
 *       tests.<br>
 *       {@link #writeTestFile(String)} writes that unit to {@code Test.java}.<br>
 *       {@link #compileTestFile(File,String)} invokes <i>javac + CF</i> and returns the resulting
 *       <code>.class</code> file.
 *   <li><b>I/O helpers</b> – all file handling is kept here so concrete persist utils only need to
 *       convert the compiled bytes into their respective class-file model.
 * </ol>
 */
abstract class BasePersistUtil {

    static String testClassOf(Method m) {
        TestClass tc = m.getAnnotation(TestClass.class);
        return (tc != null ? tc.value() : "Test");
    }

    static File writeTestFile(String fullSrc) throws IOException {
        File f = new File("Test.java");
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
            pw.println(fullSrc);
        }
        return f;
    }

    static File compileTestFile(File src, String mainClass) {
        int rc =
                com.sun.tools.javac.Main.compile(
                        new String[] {
                            "-AnoJreVersionCheck",
                            "-g",
                            "-processor",
                            "org.checkerframework.checker.nullness.NullnessChecker",
                            src.getPath()
                        });
        if (rc != 0) throw new Error("compilation failed, rc=" + rc);
        return new File(src.getParent(), mainClass + ".class");
    }

    static String wrap(String snippet) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        sj.add("");
        sj.add("import java.util.*;");
        sj.add("import java.lang.annotation.*;");
        sj.add("import org.checkerframework.framework.qual.DefaultQualifier;");
        sj.add("import org.checkerframework.checker.nullness.qual.*;");
        sj.add("import org.checkerframework.dataflow.qual.*;");
        sj.add("");

        boolean snippetOnly =
                !(snippet.startsWith("class") || snippet.contains(" class"))
                        && !snippet.contains("interface")
                        && !snippet.contains("enum");
        if (snippetOnly) sj.add("class Test {");
        sj.add(snippet);
        if (snippetOnly) {
            sj.add("}");
            sj.add("");
        }

        return sj.toString();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestClass {
    String value() default "Test";
}
