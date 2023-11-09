package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.PayloadControlBlock */
public class PayloadControlBlock {
    private boolean controlFiltered;
    private boolean controlFlash;
    private boolean controlFlashCapable;
    private boolean controlFree;
    private boolean controlPanCapable;
    private boolean controlPolarity;
    private boolean controlPower;
    private boolean controlSide;
    private boolean controlTiltCapable;
    private boolean controlUnstow;
    private boolean controlVideo;
    private boolean controlZoomCapable;
    private double pan;
    private double tilt;
    private int type;
    private int zoomIndex;

    public byte[] renderNativeCommand() {
        int i = 3;
        int i2 = isControlZoomCapable() ? 3 : 2;
        if (isControlPanCapable()) {
            i2++;
        }
        if (isControlTiltCapable()) {
            i2++;
        }
        byte[] bArr = new byte[i2];
        bArr[0] = (byte) this.type;
        bArr[1] = getControlByte();
        if (isControlZoomCapable()) {
            bArr[2] = (byte) getZoomIndex();
        } else {
            i = 2;
        }
        if (isControlPanCapable()) {
            bArr[i] = (byte) ((int) getPan());
            i++;
        }
        if (isControlTiltCapable()) {
            bArr[i] = (byte) ((int) getTilt());
        }
        return bArr;
    }

    private byte getControlByte() {
        byte b = this.controlSide ? (byte) 128 : 0;
        int i = this.type;
        if ((i == 6 && this.controlFree) || ((i == 2 || i == 4) && this.controlFlash)) {
            b = (byte) (b + 64);
        }
        if (this.controlTiltCapable) {
            b = (byte) (b + 32);
        }
        if (this.controlPanCapable) {
            b = (byte) (b + 16);
        }
        if (this.controlZoomCapable) {
            b = (byte) (b + 8);
        }
        if ((i == 3 && this.controlPolarity) || ((i == 1 && this.controlFiltered) || ((i == 2 || i == 4) && this.controlFlash))) {
            b = (byte) (b + 4);
        }
        if (this.controlVideo) {
            b = (byte) (b + 2);
        }
        return ((i != 6 || !this.controlUnstow) && (i == 6 || !this.controlPower)) ? b : (byte) (b + 1);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    private int getZoomIndex() {
        return this.zoomIndex;
    }

    public void setZoomIndex(int i) {
        this.zoomIndex = i;
    }

    private double getPan() {
        return this.pan;
    }

    public void setPan(double d) {
        this.pan = d;
    }

    private double getTilt() {
        return this.tilt;
    }

    public void setTilt(double d) {
        this.tilt = d;
    }

    public boolean isControlSide() {
        return this.controlSide;
    }

    public void setControlSide(boolean z) {
        this.controlSide = z;
    }

    public boolean isControlFree() {
        return this.controlFree;
    }

    public void setControlFree(boolean z) {
        this.controlFree = z;
    }

    public boolean isControlFlashCapable() {
        return this.controlFlashCapable;
    }

    public void setControlFlashCapable(boolean z) {
        this.controlFlashCapable = z;
    }

    private boolean isControlTiltCapable() {
        return this.controlTiltCapable;
    }

    public void setControlTiltCapable(boolean z) {
        this.controlTiltCapable = z;
    }

    private boolean isControlPanCapable() {
        return this.controlPanCapable;
    }

    public void setControlPanCapable(boolean z) {
        this.controlPanCapable = z;
    }

    private boolean isControlZoomCapable() {
        return this.controlZoomCapable;
    }

    public void setControlZoomCapable(boolean z) {
        this.controlZoomCapable = z;
    }

    public boolean isControlPolarity() {
        return this.controlPolarity;
    }

    public void setControlPolarity(boolean z) {
        this.controlPolarity = z;
    }

    public boolean isControlFiltered() {
        return this.controlFiltered;
    }

    public void setControlFiltered(boolean z) {
        this.controlFiltered = z;
    }

    public boolean isControlFlash() {
        return this.controlFlash;
    }

    public void setControlFlash(boolean z) {
        this.controlFlash = z;
    }

    public boolean isControlVideo() {
        return this.controlVideo;
    }

    public void setControlVideo(boolean z) {
        this.controlVideo = z;
    }

    public boolean isControlPower() {
        return this.controlPower;
    }

    public void setControlPower(boolean z) {
        this.controlPower = z;
    }

    public boolean isControlUnstow() {
        return this.controlUnstow;
    }

    public void setControlUnstow(boolean z) {
        this.controlUnstow = z;
    }
}
