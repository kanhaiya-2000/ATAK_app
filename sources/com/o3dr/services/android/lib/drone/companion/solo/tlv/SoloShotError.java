package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloShotError extends TLVPacket {
    public static final Parcelable.Creator<SoloShotError> CREATOR = new Parcelable.Creator<SoloShotError>() {
        public SoloShotError createFromParcel(Parcel parcel) {
            return new SoloShotError(parcel);
        }

        public SoloShotError[] newArray(int i) {
            return new SoloShotError[i];
        }
    };
    public static final int SHOT_ERROR_BAD_EKF = 0;
    public static final int SHOT_ERROR_UNARMED = 1;
    private int errorType;

    public SoloShotError(int i) {
        super(20, 4);
        this.errorType = i;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.errorType);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.errorType);
    }

    protected SoloShotError(Parcel parcel) {
        super(parcel);
        this.errorType = parcel.readInt();
    }
}
