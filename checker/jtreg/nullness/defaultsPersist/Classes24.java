/*
 * @test
 * @summary Default-qualifier byte-code tests (old Class-File API, JDK 11-24)
 * @requires jdk.version.major <= 24
 *
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil24.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtil24.java ../SharedUtil/BaseDriver.java Driver24.java BaseClasses.java Classes24.java
 * @run main Driver24 Classes24
 */

import static com.sun.tools.classfile.TypeAnnotation.TargetType.CLASS_TYPE_PARAMETER;
import static com.sun.tools.classfile.TypeAnnotation.TargetType.CLASS_TYPE_PARAMETER_BOUND;

public class Classes24 extends BaseClasses {

    @TADescriptions({
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/Nullable",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0)
    })
    public String typeParams1() {
        return typeParams1Body();
    }

    @TADescriptions({
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0)
    })
    public String typeParams2() {
        return typeParams2Body();
    }

    @TADescriptions({
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 1),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 1),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 1)
    })
    public String typeParams3() {
        return typeParams3Body();
    }

    @TADescriptions({
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/Nullable",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 0,
                boundIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 1),
        @TADescription(
                annotation = "org.checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 1),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER,
                paramIndex = 1),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 1,
                boundIndex = 1),
        @TADescription(
                annotation = "org.checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 1,
                boundIndex = 1),
        @TADescription(
                annotation = "org.checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 1,
                boundIndex = 1)
    })
    public String typeParams4() {
        return typeParams4Body();
    }
}
