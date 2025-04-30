import com.sun.tools.classfile.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public final class ReferenceInfoUtil24 extends BaseReferenceInfoUtil<TypeAnnotation, ClassFile> {

    public ReferenceInfoUtil24() {
        super(ReferenceInfoUtil24::harvest);
    }

    public static boolean compare(
            List<String> expected, List<TypeAnnotation> actual, String where) {

        BiPredicate<String, TypeAnnotation> nameMatch =
                (want, ta) -> ("L" + want + ";").equals(ta.annotation.toString());

        return new ReferenceInfoUtil24().compare(expected, actual, where, nameMatch);
    }

    private static List<TypeAnnotation> harvest(ClassFile cf, boolean ignoreCtors)
            throws Exception {
        List<TypeAnnotation> out = new ArrayList<>();

        add(cf, cf.attributes, out);
        for (Field f : cf.fields) add(cf, f.attributes, out);

        for (Method m : cf.methods) {
            if (ignoreCtors && m.getName(cf.constant_pool).equals("<init>")) {
                continue;
            }

            add(cf, m.attributes, out);

            int cIdx = m.attributes.getIndex(cf.constant_pool, Attribute.Code);
            if (cIdx != -1) {
                Attribute a = m.attributes.get(cIdx);
                if (a instanceof Code_attribute code) {
                    add(cf, code.attributes, out);
                }
            }
        }
        return out;
    }

    private static void add(ClassFile cf, Attributes attrs, List<TypeAnnotation> sink)
            throws Exception {

        int visIdx = attrs.getIndex(cf.constant_pool, Attribute.RuntimeVisibleTypeAnnotations);
        int invisIdx = attrs.getIndex(cf.constant_pool, Attribute.RuntimeInvisibleTypeAnnotations);

        if (visIdx != -1) {
            RuntimeTypeAnnotations_attribute vis =
                    (RuntimeTypeAnnotations_attribute) attrs.get(visIdx);
            sink.addAll(Arrays.asList(vis.annotations));
        }
        if (invisIdx != -1) {
            RuntimeTypeAnnotations_attribute invis =
                    (RuntimeTypeAnnotations_attribute) attrs.get(invisIdx);
            sink.addAll(Arrays.asList(invis.annotations));
        }
    }
}
