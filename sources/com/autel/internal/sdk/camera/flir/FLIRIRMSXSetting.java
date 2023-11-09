package com.autel.internal.sdk.camera.flir;

public class FLIRIRMSXSetting {
    private int PosX;
    private int PosY;
    private boolean enable;
    private int strength;

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int i) {
        this.strength = i;
    }

    public void setPosX(int i) {
        this.PosX = i;
    }

    public void setPosY(int i) {
        this.PosY = i;
    }

    public int getPosX() {
        return this.PosX;
    }

    public int getPosY() {
        return this.PosY;
    }

    public String toString() {
        return "enable = " + this.enable + " strength = " + this.strength + " PosX = " + this.PosX + " PosY = " + this.PosY;
    }
}
