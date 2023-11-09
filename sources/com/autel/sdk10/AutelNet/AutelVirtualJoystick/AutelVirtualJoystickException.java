package com.autel.sdk10.AutelNet.AutelVirtualJoystick;

public class AutelVirtualJoystickException extends Exception {
    public static final AutelVirtualJoystickException BADBATTERY = new AutelVirtualJoystickException(103, "Low battery or unknown battery");
    public static final AutelVirtualJoystickException DISARM = new AutelVirtualJoystickException(101, "Please arm the motors before entering into virtual joystick mode");
    public static final AutelVirtualJoystickException NOGPS = new AutelVirtualJoystickException(102, "No GPS signal or GPS is in abnormal condition");
    protected int errorCode;

    private AutelVirtualJoystickException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
