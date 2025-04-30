import com.sun.tools.classfile.ClassFile;
import com.sun.tools.classfile.TypeAnnotation;
import com.sun.tools.classfile.TypeAnnotation.TargetType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class Driver24 extends BaseDriver<TypeAnnotation, ClassFile> {

    public Driver24() {
        super(
                (src, main) -> PersistUtil24.compileAndReturn(src, main),
                (cf, ignore) ->
                        new ReferenceInfoUtil24().extendedAnnotationsOf((ClassFile) cf, ignore),
                (exp, act, where) -> ReferenceInfoUtil24.compare(exp, act, where));
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) throw new IllegalArgumentException("usage: Driver24 <HarnessClass>");
        new Driver24().runHarness(args[0]);
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
