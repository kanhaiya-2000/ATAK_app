package com.o3dr.services.android.lib.drone.attribute.error;

public class CommandExecutionError {
    public static final int COMMAND_DENIED = 2;
    public static final int COMMAND_FAILED = 4;
    public static final int COMMAND_TEMPORARILY_REJECTED = 1;
    public static final int COMMAND_UNSUPPORTED = 3;

    private CommandExecutionError() {
    }
}
