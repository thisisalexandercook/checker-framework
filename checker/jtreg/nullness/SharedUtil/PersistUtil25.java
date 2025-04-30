import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.nio.file.Files;

public final class PersistUtil25 extends BasePersistUtil {

    public static ClassModel compileAndReturn(String src, String main) throws Exception {
        var f = writeTestFile(src);
        var cls = compileTestFile(f, main);
        byte[] bytes = Files.readAllBytes(cls.toPath());
        return ClassFile.of().parse(bytes);
    }
}
