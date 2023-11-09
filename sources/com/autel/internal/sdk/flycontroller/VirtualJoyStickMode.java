package com.autel.internal.sdk.flycontroller;

public enum VirtualJoyStickMode {
    EXIT(0),
    JOYSTICK(1),
    JOYSTICK_YAW(2),
    UNKNOWN(-1);
    
    private int value;

    private VirtualJoyStickMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static VirtualJoyStickMode find(int i) {
        VirtualJoyStickMode virtualJoyStickMode = EXIT;
        if (virtualJoyStickMode.getValue() == i) {
            return virtualJoyStickMode;
        }
        VirtualJoyStickMode virtualJoyStickMode2 = JOYSTICK;
        if (virtualJoyStickMode2.getValue() == i) {
            return virtualJoyStickMode2;
        }
        VirtualJoyStickMode virtualJoyStickMode3 = JOYSTICK_YAW;
        if (virtualJoyStickMode3.getValue() == i) {
            return virtualJoyStickMode3;
        }
        return UNKNOWN;
    }
}
