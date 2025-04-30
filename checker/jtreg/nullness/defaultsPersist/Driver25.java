import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.classfile.ClassModel;
import java.lang.classfile.TypeAnnotation;
import java.lang.classfile.TypeAnnotation.TargetType;

public final class Driver25 extends BaseDriver<TypeAnnotation, ClassModel> {

    public Driver25() {
        super(
                (src, main) -> PersistUtil25.compileAndReturn(src, main),
                (cm, ignore) ->
                        new ReferenceInfoUtil25().extendedAnnotationsOf((ClassModel) cm, ignore),
                (exp, act, where) -> ReferenceInfoUtil25.compare(exp, act, where));
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) throw new IllegalArgumentException("usage: Driver25 <HarnessClass>");
        new Driver25().runHarness(args[0]);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TADescription {
    String annotation();

    TargetType type();

    int offset() default BaseDriver.NOT_SET;

    int[] lvarOffset() default {};

    int[] lvarLength() default {};

    int[] lvarIndex() default {};

    int boundIndex() default BaseDriver.NOT_SET;

    int paramIndex() default BaseDriver.NOT_SET;

    int typeIndex() default BaseDriver.NOT_SET;

    int exceptionIndex() default BaseDriver.NOT_SET;

    int[] genericLocation() default {};
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TADescriptions {
    TADescription[] value() default {};
}
