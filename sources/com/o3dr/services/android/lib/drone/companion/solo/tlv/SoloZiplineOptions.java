package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloZiplineOptions extends SoloShotOptions {
    public static final Parcelable.Creator<SoloZiplineOptions> CREATOR = new Parcelable.Creator<SoloZiplineOptions>() {
        public SoloZiplineOptions createFromParcel(Parcel parcel) {
            return new SoloZiplineOptions(parcel);
        }

        public SoloZiplineOptions[] newArray(int i) {
            return new SoloZiplineOptions[i];
        }
    };
    public static final int MESSAGE_LENGTH = 6;
    private boolean cameraLock;
    private boolean is3D;

    public boolean is3D() {
        return this.is3D;
    }

    public void setIs3D(boolean z) {
        this.is3D = z;
    }

    public boolean isCameraLock() {
        return this.cameraLock;
    }

    public void setCameraLock(boolean z) {
        this.cameraLock = z;
    }

    public SoloZiplineOptions(float f, boolean z, boolean z2) {
        super(23, 6, f);
        this.is3D = z;
        this.cameraLock = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    SoloZiplineOptions(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat(), byteBuffer.get() == 1, byteBuffer.get() == 1);
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        super.getMessageValue(byteBuffer);
        byteBuffer.put(this.is3D ? (byte) 1 : 0);
        byteBuffer.put(this.cameraLock ? (byte) 1 : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.is3D ? (byte) 1 : 0);
        parcel.writeByte(this.cameraLock ? (byte) 1 : 0);
    }

    protected SoloZiplineOptions(Parcel parcel) {
        super(parcel);
        boolean z = true;
        this.is3D = parcel.readByte() != 0;
        this.cameraLock = parcel.readByte() == 0 ? false : z;
    }

    public String toString() {
        return "SoloZiplineOptions{cruiseSpeed=" + getCruiseSpeed() + "is3D=" + this.is3D + "cameraLock=" + this.cameraLock + '}';
    }
}
