/*
 * @test
 * @summary Inherited declaration annotations (Class-File API 25+)
 * @requires jdk.version.major >= 25
 *
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil25.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtilDecl25.java ../SharedUtil/BaseDriver.java ExtDriver25.java BaseExtends.java Extends25.java
 * @run main ExtDriver25 Extends25
 */
public class Extends25 extends BaseExtends {

    @ADescriptions({
        @ADescription(annotation = "org/checkerframework/checker/nullness/qual/EnsuresNonNull")
    })
    public String m1() {
        return m1Body();
    }

    @ADescriptions({})
    public String m2() {
        return m2Body();
    }

    @ADescriptions({
        @ADescription(annotation = "org/checkerframework/dataflow/qual/Pure"),
        @ADescription(annotation = "org/checkerframework/dataflow/qual/SideEffectFree")
    })
    public String m3() {
        return m3Body();
    }
}
