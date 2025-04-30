/*
 * @test
 * @summary Inherited declaration annotations – new Class-File API (JDK 25+)
 * @requires jdk.version.major >= 25
 *
 * @compile ../SharedUtil/BasePersistUtil.java ../SharedUtil/PersistUtil25.java ../SharedUtil/BaseReferenceInfoUtil.java ReferenceInfoUtilDecl25.java ../SharedUtil/BaseDriver.java ExtDriver25.java BaseImplements.java Implements25.java
 * @run main ExtDriver25 Implements25
 */
public class Implements25 extends BaseImplements {

    @ADescriptions({
        @ADescription(annotation = "org/checkerframework/checker/nullness/qual/EnsuresNonNull")
    })
    public String m1() {
        return m1Body();
    }
}
