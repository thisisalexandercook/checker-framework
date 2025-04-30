import java.lang.classfile.*;
import java.lang.classfile.attribute.*;
import java.util.*;
import java.util.function.BiPredicate;

public final class ReferenceInfoUtilDecl25 extends BaseReferenceInfoUtil<Annotation, ClassModel> {

    public ReferenceInfoUtilDecl25() {
        super(ReferenceInfoUtilDecl25::harvest);
    }

    public static boolean compare(List<String> expected, List<Annotation> actual, String where) {

        BiPredicate<String, Annotation> nameMatch =
                (want, ann) -> ("L" + want + ";").equals(ann.className().stringValue());

        return new ReferenceInfoUtilDecl25().compare(expected, actual, where, nameMatch);
    }

    private static List<Annotation> harvest(ClassModel cm, boolean ignoreCtors) {
        List<Annotation> out = new ArrayList<>();
        for (MethodModel m : cm.methods()) {
            if (ignoreCtors && m.methodName().stringValue().equals("<init>")) continue;
            m.findAttribute(Attributes.runtimeVisibleAnnotations())
                    .ifPresent(ra -> ra.annotations().forEach(a -> addIfMissing(out, a)));
        }
        return out;
    }

    private static void addIfMissing(List<Annotation> bag, Annotation a) {
        String desc = a.className().stringValue();
        if (bag.stream().noneMatch(x -> x.className().stringValue().equals(desc))) bag.add(a);
    }
}
