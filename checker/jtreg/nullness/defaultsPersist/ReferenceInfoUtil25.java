import java.lang.classfile.AttributedElement;
import java.lang.classfile.Attributes;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;
import java.lang.classfile.TypeAnnotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public final class ReferenceInfoUtil25 extends BaseReferenceInfoUtil<TypeAnnotation, ClassModel> {

    public ReferenceInfoUtil25() {
        super(ReferenceInfoUtil25::harvest);
    }

    private static List<TypeAnnotation> harvest(ClassModel cm, boolean ignoreCtors) {
        List<TypeAnnotation> out = new ArrayList<>();
        add(cm, out);
        cm.fields().forEach(f -> add(f, out));
        for (MethodModel m : cm.methods()) {
            if (ignoreCtors && m.methodName().stringValue().equals("<init>")) continue;
            add(m, out);
            m.findAttribute(Attributes.code()).ifPresent(c -> add(c, out));
        }
        return out;
    }

    public static boolean compare(
            List<String> expected, List<TypeAnnotation> actual, String where) {

        BiPredicate<String, TypeAnnotation> match =
                (want, ta) -> ("L" + want + ";").equals(ta.annotation().className().stringValue());

        return new ReferenceInfoUtil25().compare(expected, actual, where, match);
    }

    private static void add(AttributedElement elt, List<TypeAnnotation> sink) {
        elt.findAttribute(Attributes.runtimeVisibleTypeAnnotations())
                .ifPresent(a -> sink.addAll(a.annotations()));
        elt.findAttribute(Attributes.runtimeInvisibleTypeAnnotations())
                .ifPresent(a -> sink.addAll(a.annotations()));
    }
}
