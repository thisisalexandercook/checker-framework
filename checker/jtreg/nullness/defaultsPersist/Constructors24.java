/*
 * @test
 * @summary Default-qualifier constructor tests – old Class-File API (JDK 11-24)
 * @requires jdk.version.major <= 24
 *
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil24.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtil24.java ../SharedUtil/BaseDriver.java Driver24.java BaseConstructors.java Constructors24.java
 * @run main Driver24 Constructors24
 */

import static com.sun.tools.classfile.TypeAnnotation.TargetType.METHOD_FORMAL_PARAMETER;

public class Constructors24 extends BaseConstructors {

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

    @TestClass("Outer$Inner")
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
