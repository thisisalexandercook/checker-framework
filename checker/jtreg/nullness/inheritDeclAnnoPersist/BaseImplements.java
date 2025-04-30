public abstract class BaseImplements {
    protected static String wrap(String... lines) {
        return String.join(
                System.lineSeparator(),
                "class Test extends AbstractClass {",
                String.join(System.lineSeparator(), lines),
                "}");
    }

    protected static String m1Body() {
        return wrap(
                "public Test() { f = new Object(); }",
                "@Override public void setf() { f = new Object(); }",
                "@Override public void setg() {}");
    }
}
