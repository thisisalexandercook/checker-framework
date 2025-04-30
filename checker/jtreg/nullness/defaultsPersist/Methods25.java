/*
 * @test
 * @summary Default-qualifier method tests – new Class-File API (JDK 25+)
 * @requires jdk.version.major >= 25
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil25.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtil25.java ../SharedUtil/BaseDriver.java Driver25.java BaseMethods.java Methods25.java
 * @run main Driver25 Methods25
 */

import static java.lang.classfile.TypeAnnotation.TargetType.METHOD_FORMAL_PARAMETER;
import static java.lang.classfile.TypeAnnotation.TargetType.METHOD_RECEIVER;
import static java.lang.classfile.TypeAnnotation.TargetType.METHOD_RETURN;

public class Methods25 extends BaseMethods {

    @TADescriptions({
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = METHOD_FORMAL_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = METHOD_FORMAL_PARAMETER,
                paramIndex = 0),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = METHOD_FORMAL_PARAMETER,
                paramIndex = 0)
    })
    public String paramDefault1() {
        return paramDefault1Body();
    }

    @TADescriptions({
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = METHOD_RETURN),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = METHOD_RETURN),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = METHOD_RETURN)
    })
    public String retDefault1() {
        return retDefault1Body();
    }

    public String throwsDefault1() {
        return throwsDefault1Body();
    }

    public String throwsDefault2() {
        return throwsDefault2Body();
    }

    @TADescriptions({
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/NonNull",
                type = METHOD_RECEIVER),
        @TADescription(
                annotation = "org/checkerframework/checker/initialization/qual/Initialized",
                type = METHOD_RECEIVER),
        @TADescription(
                annotation = "org/checkerframework/checker/nullness/qual/UnknownKeyFor",
                type = METHOD_RECEIVER)
    })
    public String recvDefault1() {
        return recvDefault1Body();
    }

    public String typeParams1() {
        return typeParams1Body();
    }

    public String typeParams2() {
        return typeParams2Body();
    }

    public String typeParams3() {
        return typeParams3Body();
    }
}
