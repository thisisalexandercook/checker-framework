import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.StringJoiner;

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
