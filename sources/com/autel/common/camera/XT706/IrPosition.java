package com.autel.common.camera.XT706;

public class IrPosition {
    private int DeltaX;
    private int DeltaY;

    public IrPosition(int i, int i2) {
        this.DeltaX = i;
        this.DeltaY = i2;
    }

    public int getDeltaX() {
        return this.DeltaX;
    }

    public void setDeltaX(int i) {
        this.DeltaX = i;
    }

    public int getDeltaY() {
        return this.DeltaY;
    }

    public void setDeltaY(int i) {
        this.DeltaY = i;
    }
}
