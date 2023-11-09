package com.autel.camera.hardware;

public abstract class BaseCameraAndGimbalHardware {
    public static BaseCameraAndGimbalHardware _BaseCameraAndGimbalHardwareIMPL;

    public abstract float getDiagonalAngle();

    /* access modifiers changed from: package-private */
    public abstract float getDiagonal_Angle_Photo_Normal();

    /* access modifiers changed from: package-private */
    public abstract float getDiagonal_Angle_Video_Above4k();

    /* access modifiers changed from: package-private */
    public abstract float getDiagonal_Angle_Video_Normal();

    public abstract float getH();

    public abstract float getHorizontalAngle();

    /* access modifiers changed from: package-private */
    public abstract float getHorizontal_Angle_Photo_Normal();

    /* access modifiers changed from: package-private */
    public abstract float getHorizontal_Angle_Photo_Normal_16_9();

    /* access modifiers changed from: package-private */
    public abstract float getHorizontal_Angle_Video_Above4k();

    /* access modifiers changed from: package-private */
    public abstract float getHorizontal_Angle_Video_Normal();

    public abstract float getPixelSize();

    public abstract float getValidClickAreaDottedLineHeightRatio();

    public abstract float getVerticalAngle();

    public abstract float getVerticalFOV();

    /* access modifiers changed from: package-private */
    public abstract float getVertical_Angle_Photo_Normal();

    /* access modifiers changed from: package-private */
    public abstract float getVertical_Angle_Photo_Normal_16_9();

    /* access modifiers changed from: package-private */
    public abstract float getVertical_Angle_Video_Above4k();

    /* access modifiers changed from: package-private */
    public abstract float getVertical_Angle_Video_Normal();

    public float updateHorizontalLineHeight(int i, float f) {
        double pixelSize = (double) ((((float) i) * getPixelSize()) / 2000.0f);
        double d = (((double) (f * -1.0f)) * 3.141592653589793d) / 180.0d;
        double h = ((((double) getH()) * Math.tan(d)) + pixelSize) / (pixelSize - (((double) getH()) * Math.tan(d)));
        return (float) (h / (1.0d + h));
    }
}
