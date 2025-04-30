import com.sun.tools.classfile.ClassFile;

import java.lang.reflect.Method;

public final class PersistUtil24 extends BasePersistUtil {

    public static ClassFile compileAndReturn(String src, String main) throws Exception {
        var f = BasePersistUtil.writeTestFile(src);
        var cls = BasePersistUtil.compileTestFile(f, main);
        return ClassFile.read(cls);
    }

    public static String wrap(String s) {
        return BasePersistUtil.wrap(s);
    }

    public static String testClassOf(Method m) {
        return BasePersistUtil.testClassOf(m);
    }
}
