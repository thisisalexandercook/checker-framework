public abstract class BaseExtends {
    protected static String wrap(String... method) {
        return "class Test extends Super {"
                + System.lineSeparator()
                + String.join(System.lineSeparator(), method)
                + System.lineSeparator()
                + "}";
    }

    protected static String m1Body() {
        return wrap("@Override void setf() { f = new Object(); }");
    }

    protected static String m2Body() {
        return wrap("@Override void setg() {}");
    }

    protected static String m3Body() {
        return wrap("@Pure @Override void seth() {}");
    }
}
