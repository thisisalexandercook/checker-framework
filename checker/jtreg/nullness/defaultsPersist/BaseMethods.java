public abstract class BaseMethods {
    protected static String paramDefault1Body() {
        return "void pm1(Object o) {}";
    }

    protected static String retDefault1Body() {
        return "Object rm1() { return new Object(); }";
    }

    protected static String throwsDefault1Body() {
        return "void tm1() throws Throwable {}";
    }

    protected static String throwsDefault2Body() {
        return "void tm2() throws ArrayIndexOutOfBoundsException, NullPointerException {}";
    }

    protected static String recvDefault1Body() {
        return "void rd1(Test this) {}";
    }

    protected static String typeParams1Body() {
        return "<M1> void foo(M1 p) {}";
    }

    protected static String typeParams2Body() {
        return "<M1 extends Object> void foo(M1 p) {}";
    }

    protected static String typeParams3Body() {
        return "<M2 extends Comparable<M2>> void bar(M2 p) {}";
    }
}
