package com.autel.sdk10.AutelNet.AutelFlyController.info;

import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.internal.sdk.flycontroller.BeginnerMode;

public class AutelFlyControllerInfo {
    protected int SN_Code;
    protected int SN_Disable_Code;
    protected float ascendSpeed;
    protected boolean attiEnable;
    protected BeginnerMode autelBeginnerMode;
    protected LedPilotLamp autelLedPilotLamp;
    protected float descendSpeed;
    protected float horizontalSpeed;
    protected float maxHeight;
    protected float maxRange;
    protected float returnHeight;
    protected int sdLogFrequency;
    protected float yawSensitive;

    public int getSNDisableCode() {
        return this.SN_Disable_Code;
    }

    public int getSNCode() {
        return this.SN_Code;
    }

    public float getMaxHeight() {
        return this.maxHeight;
    }

    public float getMaxRange() {
        return this.maxRange;
    }

    public float getReturnHeight() {
        return this.returnHeight;
    }

    public float getHorizontalSpeed() {
        return this.horizontalSpeed;
    }

    public float getAscendSpeed() {
        return this.ascendSpeed;
    }

    public float getDescendSpeed() {
        return this.descendSpeed;
    }

    public BeginnerMode getAutelBeginnerMode() {
        return this.autelBeginnerMode;
    }

    public int getSdLogFrequency() {
        return this.sdLogFrequency;
    }

    public boolean getAttitudeEnable() {
        return this.attiEnable;
    }

    public LedPilotLamp getAutelLedPilotLamp() {
        return this.autelLedPilotLamp;
    }

    public float getYawSensitive() {
        return this.yawSensitive;
    }
}
