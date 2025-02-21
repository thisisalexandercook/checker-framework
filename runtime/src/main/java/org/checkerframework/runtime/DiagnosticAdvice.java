package org.checkerframework.runtime;

import net.bytebuddy.asm.Advice;

public class DiagnosticAdvice {

    @Advice.OnMethodExit
    public static void onExit(
            @Advice.Return(readOnly = false) String returnedValue,
            @Advice.Origin("#t") String className,
            @Advice.Origin("#m") String methodName) {

        RuntimeAgent.checkNullness(returnedValue, className, methodName);
    }
}
