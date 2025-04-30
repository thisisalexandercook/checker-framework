import java.util.List;

/**
 * Generic helper used by all test-suite reference-info utilities.
 *
 * <p>The class does <em>two</em> things only:
 *
 * <ol>
 *   <li><strong>Harvest</strong> – delegate to an API-specific lambda that extracts the annotations
 *       of interest from a class-file model ({@code CF}).
 *   <li><strong>Compare</strong> – check that the harvested annotations match an expected list,
 *       using a caller-supplied {@link java.util.function.BiPredicate BiPredicate} to define
 *       “equality”.
 * </ol>
 */
abstract class BaseReferenceInfoUtil<A, CF> {

    @FunctionalInterface
    interface Harvester<A, CF> {
        List<A> harvest(CF model, boolean ignoreConstructors) throws Exception;
    }

    private final Harvester<A, CF> harvester;

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
            throw new ComparisonException("missing annotation @" + where, expected, actual);
        }
        return true;
    }

    static final class ComparisonException extends RuntimeException {
        final Object expected;
        final Object found;

        ComparisonException(String msg, Object exp, Object act) {
            super(msg);
            this.expected = exp;
            this.found = act;
        }

        @Override
        public String toString() {
            return "%s%n  expected: %s%n  found: %s".formatted(getMessage(), expected, found);
        }
    }
}
