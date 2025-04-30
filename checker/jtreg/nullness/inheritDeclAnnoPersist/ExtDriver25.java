import java.lang.classfile.Annotation;
import java.lang.classfile.ClassModel;

public final class ExtDriver25 extends BaseDriver<Annotation, ClassModel> {

    public ExtDriver25() {
        super(
                (src, main) -> PersistUtil25.compileAndReturn(src, main),
                (cm, ignore) -> new ReferenceInfoUtilDecl25().extendedAnnotationsOf(cm, ignore),
                (exp, act, where) -> ReferenceInfoUtilDecl25.compare(exp, act, where));
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            throw new IllegalArgumentException("usage: ExtDriver25 <HarnessClass>");
        new ExtDriver25().runHarness(args[0]);
    }
}
