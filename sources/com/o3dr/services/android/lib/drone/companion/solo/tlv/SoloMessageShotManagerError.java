package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloMessageShotManagerError extends TLVPacket {
    public static final Parcelable.Creator<SoloMessageShotManagerError> CREATOR = new Parcelable.Creator<SoloMessageShotManagerError>() {
        public SoloMessageShotManagerError createFromParcel(Parcel parcel) {
            return new SoloMessageShotManagerError(parcel);
        }

        public SoloMessageShotManagerError[] newArray(int i) {
            return new SoloMessageShotManagerError[i];
        }
    };
    private final String exceptionInfo;

    public SoloMessageShotManagerError(String str) {
        super(1000, str.length());
        this.exceptionInfo = str;
    }

    public String getExceptionInfo() {
        return this.exceptionInfo;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.put(this.exceptionInfo.getBytes());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.exceptionInfo);
    }

    protected SoloMessageShotManagerError(Parcel parcel) {
        super(parcel);
        this.exceptionInfo = parcel.readString();
    }

    public String toString() {
        return "SoloMessageShotManagerError{exceptionInfo='" + this.exceptionInfo + '\'' + '}';
    }
}
