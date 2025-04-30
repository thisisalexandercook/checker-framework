public abstract class BaseConstructors {

    protected static String paramDefault1Body() {
        return "Test(Object o) {}";
    }

    protected static String retDefault1Body() {
        return "Test() {}";
    }

    protected static String throwsDefault1Body() {
        return "Test() throws Throwable {}";
    }

    protected static String throwsDefault2Body() {
        return "Test() throws ArrayIndexOutOfBoundsException, NullPointerException {}";
    }

    protected static String recvDefault1Body() {
        return "class Outer {  class Inner {  Inner(Outer Outer.this) {}  } }";
    }

    protected static String typeParams1Body() {
        return "<M1> Test(M1 p) {}";
    }

    protected static String typeParams2Body() {
        return "<M1 extends Object> Test(M1 p) {}";
    }

    protected static String typeParams3Body() {
        return "<M2 extends Comparable<M2>> Test(M2 p) {}";
    }
}
