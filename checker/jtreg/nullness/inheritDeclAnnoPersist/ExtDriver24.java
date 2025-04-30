import com.sun.tools.classfile.Annotation;
import com.sun.tools.classfile.ClassFile;

public final class ExtDriver24 extends BaseDriver<Annotation, ClassFile> {

    public ExtDriver24() {
        super(
                (src, main) -> PersistUtil24.compileAndReturn(src, main),
                (cf, ignore) -> new ReferenceInfoUtilDecl24().extendedAnnotationsOf(cf, ignore),
                (exp, act, where) -> ReferenceInfoUtilDecl24.compare(exp, act, where));
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            throw new IllegalArgumentException("usage: ExtDriver24 <HarnessClass>");
        new ExtDriver24().runHarness(args[0]);
    }
}
