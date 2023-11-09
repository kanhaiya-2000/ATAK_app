package com.autel.internal.sdk.gimbal;

import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.internal.sdk.util.FormatUtils;

public class AutelGimbalInfo {
    protected float pitch = 0.0f;
    protected float roll = 0.0f;
    private double rollAdjust = -100.0d;
    private GimbalWorkMode workMode;
    protected float yaw = 0.0f;

    /* access modifiers changed from: protected */
    public void setGimbalWorkMode(GimbalWorkMode gimbalWorkMode) {
        this.workMode = gimbalWorkMode;
    }

    /* access modifiers changed from: protected */
    public void setRollAdjust(int i) {
        this.rollAdjust = FormatUtils.doubleFormat(((double) (i - 15000)) * 0.002d);
    }

    public GimbalWorkMode getGimbalWorkMode() {
        return this.workMode;
    }

    public double getRollAdjust() {
        return this.rollAdjust;
    }

    public float getRoll() {
        return this.roll;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getYaw() {
        return this.yaw;
    }
}
