package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloCableCamOptions extends SoloShotOptions {
    private static final int CAM_INTERPOLATION_DISABLED_VALUE = 0;
    private static final int CAM_INTERPOLATION_ENABLED_VALUE = 1;
    public static final Parcelable.Creator<SoloCableCamOptions> CREATOR = new Parcelable.Creator<SoloCableCamOptions>() {
        public SoloCableCamOptions createFromParcel(Parcel parcel) {
            return new SoloCableCamOptions(parcel);
        }

        public SoloCableCamOptions[] newArray(int i) {
            return new SoloCableCamOptions[i];
        }
    };
    private static final int YAW_DIRECTION_CCW_VALUE = 1;
    private static final int YAW_DIRECTION_CW_VALUE = 0;
    private boolean camInterpolation;
    private boolean yawDirectionClockwise;

    public SoloCableCamOptions(boolean z, boolean z2, float f) {
        super(4, 8, f);
        this.camInterpolation = z;
        this.yawDirectionClockwise = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    SoloCableCamOptions(int i, int i2, float f) {
        this(i == 1, i2 == 0, f);
    }

    public boolean isCamInterpolationOn() {
        return this.camInterpolation;
    }

    public void setCamInterpolation(boolean z) {
        this.camInterpolation = z;
    }

    public boolean isYawDirectionClockWise() {
        return this.yawDirectionClockwise;
    }

    public void setYawDirection(boolean z) {
        this.yawDirectionClockwise = z;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putShort(this.camInterpolation ? (short) 1 : 0);
        byteBuffer.putShort(this.yawDirectionClockwise ^ true ? (short) 1 : 0);
        super.getMessageValue(byteBuffer);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.camInterpolation ? (byte) 1 : 0);
        parcel.writeByte(this.yawDirectionClockwise ? (byte) 1 : 0);
    }

    protected SoloCableCamOptions(Parcel parcel) {
        super(parcel);
        boolean z = true;
        this.camInterpolation = parcel.readByte() != 0;
        this.yawDirectionClockwise = parcel.readByte() == 0 ? false : z;
    }
}
