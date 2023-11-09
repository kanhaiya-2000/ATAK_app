package com.autel.sdk10.AutelNet.AutelVirtualJoystick;

public class AutelVirtualJoystickState {
    public float pitchStick;
    public int pitchType;
    public float rollStick;
    public int rollType;
    public float verticalStick;
    public int verticalType;
    public float yawStick;
    public int yawType;

    public float getCtrModeMask() {
        int i = 0;
        int i2 = this.yawType == 0 ? 0 : 1;
        int i3 = this.rollType == 0 ? 0 : 2;
        int i4 = this.pitchType == 0 ? 0 : 4;
        if (this.verticalType != 0) {
            i = 8;
        }
        return (float) (i2 | i3 | i4 | i);
    }
}
