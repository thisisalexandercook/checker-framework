package org.checkerframework.runtime;

class Diagnostic {
    private final String type;
    private final String message;

    public Diagnostic(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Diagnostic[type=" + type + ", message=" + message + "]";
    }
}
