package com.atakmap.android.uastool.p000av;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.atakmap.android.uastool.av.PayloadBlock */
public class PayloadBlock {
    private double hfov;
    private double pan;
    private int status;
    private double tilt;
    private PayloadType type;
    private double vfov;
    private List<ZoomData> zoomData = null;
    private int zoomIndex;
    private int zoomLimit;

    /* renamed from: com.atakmap.android.uastool.av.PayloadBlock$PayloadType */
    public enum PayloadType {
        RESERVED,
        EO_COLOR_CAMERA,
        VISIBLE_LASER_ILLUMINATOR,
        IR_CAMERA,
        IR_LASER,
        I2_CAMERA,
        GIMBAL;

        static PayloadType fromInteger(int i) {
            switch (i) {
                case 0:
                    return RESERVED;
                case 1:
                    return EO_COLOR_CAMERA;
                case 2:
                    return VISIBLE_LASER_ILLUMINATOR;
                case 3:
                    return IR_CAMERA;
                case 4:
                    return IR_LASER;
                case 5:
                    return I2_CAMERA;
                case 6:
                    return GIMBAL;
                default:
                    return RESERVED;
            }
        }

        static String getDescription(PayloadType payloadType) {
            switch (payloadType) {
                case EO_COLOR_CAMERA:
                    return "EO Color Camera";
                case VISIBLE_LASER_ILLUMINATOR:
                    return "Visible Laser Illuminator";
                case IR_CAMERA:
                    return "IR Camera";
                case IR_LASER:
                    return "IR Laser";
                case I2_CAMERA:
                    return "I2 Camera";
                case GIMBAL:
                    return "Gimbal";
                default:
                    return "Reserved";
            }
        }
    }

    public int parseNative(byte[] bArr, int i) {
        this.zoomData = new ArrayList();
        int i2 = 0;
        this.type = PayloadType.fromInteger(bArr[0]);
        this.status = bArr[1] & 255;
        this.hfov = GCSMessage.radiansToDegrees(GCSMessage.getDouble(bArr[2], bArr[3], 1.0E-4d));
        this.vfov = GCSMessage.radiansToDegrees(GCSMessage.getDouble(bArr[4], bArr[5], 1.0E-4d));
        if (getZoomCapable() && i > 6) {
            int i3 = (bArr[6] & 240) >> 4;
            this.zoomLimit = i3;
            this.zoomIndex = bArr[6] & Ascii.f8523SI;
            int i4 = (i3 * 4) + 1;
            if (i3 <= 0 || i <= i4 + 6) {
                return i;
            }
            while (i2 < this.zoomLimit) {
                int i5 = i2 * 4;
                this.hfov = GCSMessage.radiansToDegrees(GCSMessage.getDouble(bArr[i5 + 7], bArr[i5 + 8], 1.0E-4d));
                double radiansToDegrees = GCSMessage.radiansToDegrees(GCSMessage.getDouble(bArr[i5 + 9], bArr[i5 + 10], 1.0E-4d));
                this.vfov = radiansToDegrees;
                this.zoomData.add(new ZoomData(i2, this.hfov, radiansToDegrees));
                i2++;
            }
            i2 = i4;
        }
        int i6 = i2 + 10;
        if (i >= i6) {
            this.pan = GCSMessage.radiansToDegrees(GCSMessage.getDouble(bArr[i2 + 6], bArr[i2 + 7], 1.0E-4d));
            this.tilt = GCSMessage.radiansToDegrees(GCSMessage.getDouble(bArr[i2 + 8], bArr[i2 + 9], 1.0E-4d));
        }
        return i6;
    }

    public PayloadType getType() {
        return this.type;
    }

    public void setType(PayloadType payloadType) {
        this.type = payloadType;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public double getHfov() {
        return this.hfov;
    }

    public void setHfov(double d) {
        this.hfov = d;
    }

    public double getVfov() {
        return this.vfov;
    }

    public void setVfov(double d) {
        this.vfov = d;
    }

    public int getZoomLimit() {
        return this.zoomLimit;
    }

    public void setZoomLimit(int i) {
        this.zoomLimit = i;
    }

    public int getZoomIndex() {
        return this.zoomIndex;
    }

    public void setZoomIndex(int i) {
        this.zoomIndex = i;
    }

    public List<ZoomData> getZoomData() {
        return this.zoomData;
    }

    public void setZoomData(List<ZoomData> list) {
        this.zoomData = list;
    }

    public double getPan() {
        return this.pan;
    }

    public void setPan(double d) {
        this.pan = d;
    }

    public double getTilt() {
        return this.tilt;
    }

    public void setTilt(double d) {
        this.tilt = d;
    }

    public String getModel() {
        return PayloadType.getDescription(this.type);
    }

    public boolean getSideLook() {
        return (this.status & 128) > 0;
    }

    public boolean getFree() {
        return (this.status & 64) > 0;
    }

    public boolean getFlashCapable() {
        return (this.status & 64) > 0;
    }

    public boolean getTiltCapable() {
        return (this.status & 32) > 0;
    }

    public boolean getPanCapable() {
        return (this.status & 16) > 0;
    }

    public boolean getZoomCapable() {
        return (this.status & 8) > 0;
    }

    public boolean getPolarity() {
        return (this.status & 4) > 0;
    }

    public boolean getFiltered() {
        return (this.status & 4) > 0;
    }

    public boolean getFlash() {
        return (this.status & 4) > 0;
    }

    public boolean getVideo() {
        return (this.status & 2) > 0;
    }

    public boolean getGimbalTransition() {
        return (this.status & 2) > 0;
    }

    public boolean getPower() {
        return (this.status & 1) > 0;
    }

    public boolean getUnstow() {
        return (this.status & 1) > 0;
    }
}
