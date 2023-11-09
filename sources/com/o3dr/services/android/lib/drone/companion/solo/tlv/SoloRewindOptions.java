package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloRewindOptions extends TLVPacket {
    public static final Parcelable.Creator<SoloRewindOptions> CREATOR = new Parcelable.Creator<SoloRewindOptions>() {
        public SoloRewindOptions createFromParcel(Parcel parcel) {
            return new SoloRewindOptions(parcel);
        }

        public SoloRewindOptions[] newArray(int i) {
            return new SoloRewindOptions[i];
        }
    };
    public static final int MESSAGE_LENGTH = 6;
    public static final int RETURN_AND_HOVER = 1;
    public static final int RETURN_AND_LAND = 0;
    private boolean isRewindEnabled;
    private int returnPreference;
    private float rewindDistance;

    public @interface ReturnPreference {
    }

    public float getRewindDistance() {
        return this.rewindDistance;
    }

    public void setRewindDistance(float f) {
        this.rewindDistance = f;
    }

    public int getReturnPreference() {
        return this.returnPreference;
    }

    public void setReturnPreference(int i) {
        this.returnPreference = i;
    }

    public boolean isRewindEnabled() {
        return this.isRewindEnabled;
    }

    public void setRewindEnabled(boolean z) {
        this.isRewindEnabled = z;
    }

    public SoloRewindOptions(boolean z, int i, float f) {
        super(24, 6);
        this.isRewindEnabled = z;
        this.returnPreference = i;
        this.rewindDistance = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    SoloRewindOptions(ByteBuffer byteBuffer) {
        this(byteBuffer.get() != 1 ? false : true, byteBuffer.get(), byteBuffer.getFloat());
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.put(this.isRewindEnabled ? (byte) 1 : 0);
        byteBuffer.put((byte) this.returnPreference);
        byteBuffer.putFloat(this.rewindDistance);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.isRewindEnabled ? (byte) 1 : 0);
        parcel.writeByte((byte) this.returnPreference);
        parcel.writeFloat(this.rewindDistance);
    }

    protected SoloRewindOptions(Parcel parcel) {
        super(parcel);
        this.isRewindEnabled = parcel.readByte() != 0;
        this.returnPreference = parcel.readByte();
        this.rewindDistance = parcel.readFloat();
    }

    public String toString() {
        return "SoloRewindOptions{isRewindEnabled=" + this.isRewindEnabled + "returnPreference=" + this.returnPreference + "rewindDistance=" + this.rewindDistance + '}';
    }
}
