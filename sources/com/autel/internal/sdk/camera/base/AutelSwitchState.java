package com.autel.internal.sdk.camera.base;

public enum AutelSwitchState {
    ON("ON"),
    OFF("OFF");
    
    private final String value;

    private AutelSwitchState(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static AutelSwitchState find(String str) {
        AutelSwitchState autelSwitchState = ON;
        if (autelSwitchState.value().equals(str)) {
            return autelSwitchState;
        }
        AutelSwitchState autelSwitchState2 = OFF;
        if (autelSwitchState2.value().equals(str)) {
            return autelSwitchState2;
        }
        return null;
    }
}
