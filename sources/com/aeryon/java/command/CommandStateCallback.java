package com.aeryon.java.command;

import com.aeryon.java.types.COMMAND_STATE;

public abstract class CommandStateCallback {
    public abstract void callback(COMMAND_STATE command_state);

    /* access modifiers changed from: protected */
    public void handleNativeCallback(int i) {
        callback(COMMAND_STATE.lookup(i));
    }
}
