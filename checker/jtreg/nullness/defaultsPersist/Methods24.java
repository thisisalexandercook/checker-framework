/*
 * @test
 * @summary Default-qualifier method tests – old Class-File API (JDK 11-24)
 * @requires jdk.version.major <= 24
 *
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil24.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtil24.java ../SharedUtil/BaseDriver.java Driver24.java BaseMethods.java Methods24.java
 * @compile Methods24.java
 * @run main Driver24 Methods24
 */

import static com.sun.tools.classfile.TypeAnnotation.TargetType.METHOD_FORMAL_PARAMETER;
import static com.sun.tools.classfile.TypeAnnotation.TargetType.METHOD_RECEIVER;

public class Methods24 extends BaseMethods {

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
