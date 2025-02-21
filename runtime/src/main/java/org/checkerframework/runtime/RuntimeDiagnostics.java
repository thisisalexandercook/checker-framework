package org.checkerframework.runtime;

import java.util.Map;
import java.util.HashMap;


/**
 * Maintains a mapping from source locations to diagnostics.
 */
public class RuntimeDiagnostics {
    private final Map<SourceLocation, Diagnostic> diagnosticsMap = new HashMap<>();

    /**
     * Adds a diagnostic entry for a given source file and line.
     */
    public void addDiagnostic(String file, int line, Diagnostic diagnostic) {
        diagnosticsMap.put(new SourceLocation(file, line), diagnostic);
    }

    /**
     * Returns the current diagnostics map.
     */
    public Map<SourceLocation, Diagnostic> getDiagnostics() {
        return diagnosticsMap;
    }
}
