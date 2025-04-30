import java.io.PrintStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic harness that drives the jtreg byte-code tests.
 *
 * <p>The class is parametrised so it can work with either of the two class-file APIs used in the
 * suite:
 *
 * <ul>
 *   <li><b>A</b> – the annotation node type<br>
 *       {@code com.sun.tools.classfile.TypeAnnotation} for JDK&nbsp;11-24<br>
 *       {@code java.lang.classfile.TypeAnnotation} for JDK&nbsp;25+
 *   <li><b>CF</b> – the in-memory class-file model<br>
 *       {@code com.sun.tools.classfile.ClassFile} for the old API<br>
 *       {@code java.lang.classfile.ClassModel} for the new API
 * </ul>
 *
 * Concrete driver wrappers (e.g.&nbsp;{@code Driver24}, {@code Driver25}) plug in three
 * lambdas—compile, harvest, compare—so the core logic in this class remains unchanged across JDK
 * versions.
 */
public abstract class BaseDriver<A, CF> {

    @FunctionalInterface
    interface Compiler<CF> {
        CF compile(String src, String mainClass) throws Exception;
    }

    @FunctionalInterface
    interface Harvester<A, CF> {
        List<A> harvest(CF model, boolean ignoreConstructors) throws Exception;
    }

    @FunctionalInterface
    interface Comparator<A> {
        boolean same(List<String> expected, List<A> actual, String where) throws Exception;
    }

    protected final Compiler<CF> compile;
    protected final Harvester<A, CF> harvest;
    protected final Comparator<A> compare;

    public static final int NOT_SET = -888;

    protected BaseDriver(Compiler<CF> c, Harvester<A, CF> h, Comparator<A> cmp) {
        this.compile = c;
        this.harvest = h;
        this.compare = cmp;
    }

    public void runHarness(String harnessName) throws Exception {
        Class<?> harness =
                Class.forName(harnessName).getDeclaredConstructor().newInstance().getClass();
        run(harness);
    }

    void run(Object harness) throws Exception {
        PrintStream out = System.out;
        int pass = 0, fail = 0;
        Class<?> H = harness.getClass();
        out.println("Tests for " + H.getName());

        for (Method m : H.getMethods()) {
            List<String> expected = expectedOf(m);
            if (expected == null) continue;
            if (m.getReturnType() != String.class)
                throw new IllegalArgumentException("Test method must return String: " + m);

            String snippet = (String) m.invoke(harness);
            String fullSrc = BasePersistUtil.wrap(snippet);
            CF model = compile.compile(fullSrc, BasePersistUtil.testClassOf(m));

            boolean ignoreCtors = !H.getName().equals("Constructors");
            List<A> actual = harvest.harvest(model, ignoreCtors);

            String where = "method=" + m.getName();
            try {
                compare.same(expected, actual, where);
                out.println("PASSED: " + m.getName());
                ++pass;
            } catch (Throwable t) {
                out.println("FAILED: " + m.getName());
                out.println("    " + t.getMessage());
                ++fail;
            }
        }

        out.printf("%n%d total tests: %d PASSED, %d FAILED%n", pass + fail, pass, fail);
        if (fail != 0) throw new RuntimeException(fail + " tests failed");
    }

    private List<String> expectedOf(Method m) {
        ADescription one = m.getAnnotation(ADescription.class);
        ADescriptions many = m.getAnnotation(ADescriptions.class);
        if (one == null && many == null) return null;

        List<String> list = new ArrayList<>();
        if (one != null) list.add(one.annotation());
        if (many != null) for (ADescription d : many.value()) list.add(d.annotation());
        return list;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ADescription {
    String annotation();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ADescriptions {
    ADescription[] value() default {};
}
