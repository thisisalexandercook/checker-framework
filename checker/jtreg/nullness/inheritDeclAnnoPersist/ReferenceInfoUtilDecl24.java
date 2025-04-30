import com.sun.tools.classfile.*;

import java.util.*;
import java.util.function.BiPredicate;

public final class ReferenceInfoUtilDecl24 extends BaseReferenceInfoUtil<Annotation, ClassFile> {

    public ReferenceInfoUtilDecl24() {
        super(ReferenceInfoUtilDecl24::harvest);
    }

    public static boolean compare(List<String> expected, List<Annotation> actual, String where) {

        BiPredicate<String, Annotation> nameMatch =
                (want, ann) -> ann.toString().contains('L' + want + ';');

        return new ReferenceInfoUtilDecl24().compare(expected, actual, where, nameMatch);
    }

    private static List<Annotation> harvest(ClassFile cf, boolean ignoreCtors) throws Exception {

        List<Annotation> out = new ArrayList<>();

        for (Method m : cf.methods) {
            if (ignoreCtors && m.getName(cf.constant_pool).equals("<init>")) continue;

            RuntimeAnnotations_attribute ra =
                    (RuntimeAnnotations_attribute)
                            m.attributes.get(Attribute.RuntimeVisibleAnnotations);

            if (ra != null) for (Annotation a : ra.annotations) addIfMissing(cf, out, a);
        }
        return out;
    }

    private static void addIfMissing(ClassFile cf, List<Annotation> bag, Annotation a) {

        String desc = descriptorOf(cf, a);

        boolean absent = bag.stream().noneMatch(x -> descriptorOf(cf, x).equals(desc));

        if (absent) bag.add(a);
    }

    private static String descriptorOf(ClassFile cf, Annotation ann) {
        try {
            return cf.constant_pool.getUTF8Value(ann.type_index);
        } catch (ConstantPool.InvalidIndex | ConstantPool.UnexpectedEntry ex) {
            throw new RuntimeException(ex);
        }
    }
}
