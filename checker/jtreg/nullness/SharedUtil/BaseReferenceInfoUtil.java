import java.util.*;

/**
 * Generic reference-info utility. Parameter A = annotation node type (old API →
 * com.sun.tools.classfile.TypeAnnotation, new API → java.lang.classfile.TypeAnnotation). Parameter
 * CF = class-file model (old API → ClassFile, new API → ClassModel).
 */
abstract class BaseReferenceInfoUtil<A, CF> {

    @FunctionalInterface
    interface Harvester<A, CF> {
        List<A> harvest(CF model, boolean ignoreConstructors) throws Exception;
    }

    protected final Harvester<A, CF> harvester;

    protected BaseReferenceInfoUtil(Harvester<A, CF> h) {
        this.harvester = h;
    }

    public List<A> extendedAnnotationsOf(CF model, boolean ignoreCtors) throws Exception {
        return harvester.harvest(model, ignoreCtors);
    }

    public <E> boolean compare(
            List<E> expected,
            List<A> actual,
            String where,
            java.util.function.BiPredicate<E, A> match) {

        if (actual.size() != expected.size())
            throw new ComparisonException("count mismatch @" + where, expected, actual);

        outer:
        for (E e : expected) {
            for (A a : actual) if (match.test(e, a)) continue outer;
            throw new ComparisonException("missing anno @" + where, expected, actual);
        }
        return true;
    }

    static final class ComparisonException extends RuntimeException {
        final Object exp, act;

        ComparisonException(String msg, Object e, Object a) {
            super(msg);
            exp = e;
            act = a;
        }

        public String toString() {
            return "%s%n  expected: %s%n  found: %s".formatted(getMessage(), exp, act);
        }
    }
}
