class BaseClasses {
    protected String typeParams1Body() { // class <T1>
        return "class Test <T1> {}";
    }

    protected String typeParams2Body() { // class <T1 extends Object>
        return "class Test<T1 extends Object> {}";
    }

    protected String typeParams3Body() { // class <T2 extends Comparable<T2>>
        return "class Test<T2 extends Comparable<T2>> {}";
    }

    protected String typeParams4Body() { // class <T1, T2 extends Comparable<T2>>
        return "class Test<T1, T2 extends Comparable<T2>> {}";
    }
}
