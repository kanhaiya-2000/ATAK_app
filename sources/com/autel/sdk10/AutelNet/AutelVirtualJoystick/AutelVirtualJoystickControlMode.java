package com.autel.sdk10.AutelNet.AutelVirtualJoystick;

public enum AutelVirtualJoystickControlMode {
    EXIT(0),
    JOYSTICK(1),
    JOYSTICK_YAW(2);
    
    private int value;

    private AutelVirtualJoystickControlMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static AutelVirtualJoystickControlMode find(int i) {
        AutelVirtualJoystickControlMode autelVirtualJoystickControlMode = EXIT;
        if (autelVirtualJoystickControlMode.getValue() == i) {
            return autelVirtualJoystickControlMode;
        }
        AutelVirtualJoystickControlMode autelVirtualJoystickControlMode2 = JOYSTICK;
        if (autelVirtualJoystickControlMode2.getValue() == i) {
            return autelVirtualJoystickControlMode2;
        }
        AutelVirtualJoystickControlMode autelVirtualJoystickControlMode3 = JOYSTICK_YAW;
        if (autelVirtualJoystickControlMode3.getValue() == i) {
            return autelVirtualJoystickControlMode3;
        }
        return null;
    }
}
