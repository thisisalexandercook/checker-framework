/*
 * @test
 * @summary Inherited declaration annotations (Class-File API 11-24)
 * @requires jdk.version.major <= 24
 *
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil24.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtilDecl24.java ../SharedUtil/BaseDriver.java ExtDriver24.java BaseExtends.java Extends24.java
 * @run main ExtDriver24 Extends24
 */
public class Extends24 extends BaseExtends {

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
