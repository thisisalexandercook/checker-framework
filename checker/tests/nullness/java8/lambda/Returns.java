import org.checkerframework.checker.nullness.qual.*;

// The return of a lambda is a lambda

interface ConsumerSupplier {
    Consumer get();
}
interface Consumer {
    void method(@Nullable String s);
}

interface SupplierSupplier {
    Supplier get();
}

interface Supplier {
    @NonNull String method();
}

class MetaReturn {

    //:: error: (dereference.of.nullable)
    ConsumerSupplier t1 = () -> (s) -> s.toString();
    ConsumerSupplier t2 = () -> { return (String s) -> {
            //:: error: (dereference.of.nullable)
            s.toString();
        }; };

    SupplierSupplier t3 = () ->
        {
            //:: error: (return.type.incompatible)
            return () -> null;
        };

    SupplierSupplier t4 = () ->
        {
            return ""::toString;
        };
}
