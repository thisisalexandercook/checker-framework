package org.checkerframework.runtime;

import java.util.Objects;


 /**
 * Encapsulates a source location (file name and line number).
 */
class SourceLocation {
    private final String file;
    private final int line;

    public SourceLocation(String file, int line) {
        this.file = file;
        this.line = line;
    }

    public String getFile() {
        return file;
    }

    public int getLine() {
        return line;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SourceLocation)) return false;
        SourceLocation other = (SourceLocation) obj;
        return line == other.line && Objects.equals(file, other.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, line);
    }

    @Override
    public String toString() {
        return file + ":" + line;
    }
}
