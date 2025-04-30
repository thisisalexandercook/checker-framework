/*
 * @test
 * @summary Inherited declaration annotations – old Class-File API (JDK 11-24)
 * @requires jdk.version.major <= 24
 *
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil24.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtilDecl24.java ../SharedUtil/BaseDriver.java ExtDriver24.java BaseImplements.java Implements24.java
 * @run main ExtDriver24 Implements24
 */
public class Implements24 extends BaseImplements {

    @ADescriptions({
        @ADescription(annotation = "org/checkerframework/checker/nullness/qual/EnsuresNonNull")
    })
    public String m1() {
        return m1Body();
    }
}
