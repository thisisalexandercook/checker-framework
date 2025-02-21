package org.checkerframework.runtime;

import java.util.HashMap;
import java.util.Map;

public class DiagnosticsRepository {
    private static final Map<String, Diagnostic> repository = new HashMap<>();

    public static void addDiagnostic(String className, String methodName, Diagnostic diagnostic) {
        repository.put(className + "." + methodName, diagnostic);
    }

    public static Diagnostic getDiagnosticForMethod(String className, String methodName) {
        return repository.get(className + "." + methodName);
    }
}
