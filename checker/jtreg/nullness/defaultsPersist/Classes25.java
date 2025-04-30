/*
 * @test
 * @summary Default-qualifier byte-code tests (Class-File API JDK 25+)
 * @requires jdk.version.major >= 25
 *
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil25.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtil25.java ../SharedUtil/BaseDriver.java Driver25.java BaseClasses.java Classes25.java
 *
 * @run main Driver25 Classes25
 */

import static java.lang.classfile.TypeAnnotation.TargetType.CLASS_TYPE_PARAMETER;
import static java.lang.classfile.TypeAnnotation.TargetType.CLASS_TYPE_PARAMETER_BOUND;

public class Classes25 extends BaseClasses {

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
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
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
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 1,
                boundIndex = 1),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = CLASS_TYPE_PARAMETER_BOUND,
                paramIndex = 1,
                boundIndex = 1)
    })
    public String typeParams4() {
        return typeParams4Body();
    }
}
