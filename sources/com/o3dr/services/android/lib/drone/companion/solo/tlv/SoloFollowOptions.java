package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloFollowOptions extends SoloShotOptions {
    public static final Parcelable.Creator<SoloFollowOptions> CREATOR = new Parcelable.Creator<SoloFollowOptions>() {
        public SoloFollowOptions createFromParcel(Parcel parcel) {
            return new SoloFollowOptions(parcel);
        }

        public SoloFollowOptions[] newArray(int i) {
            return new SoloFollowOptions[i];
        }
    };
    private static final int LOOK_AT_DISABLED_VALUE = 0;
    protected static final int LOOK_AT_ENABLED_VALUE = 1;
    private boolean lookAt;

    public SoloFollowOptions(float f, boolean z) {
        this(19, 8, f, z);
    }

    protected SoloFollowOptions(int i, int i2, float f, boolean z) {
        super(i, i2, f);
        this.lookAt = z;
    }

    public SoloFollowOptions() {
        this(0.0f, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    SoloFollowOptions(float f, int i) {
        this(f, i != 1 ? false : true);
    }

    SoloFollowOptions(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat(), byteBuffer.getInt());
    }

    public boolean isLookAt() {
        return this.lookAt;
    }

    public void setLookAt(boolean z) {
        this.lookAt = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SoloFollowOptions) && super.equals(obj) && this.lookAt == ((SoloFollowOptions) obj).lookAt) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.lookAt ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        super.getMessageValue(byteBuffer);
        byteBuffer.putInt(this.lookAt ? 1 : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.lookAt ? (byte) 1 : 0);
    }

    protected SoloFollowOptions(Parcel parcel) {
        super(parcel);
        this.lookAt = parcel.readByte() != 0;
    }

    public String toString() {
        return "SoloFollowOptions{lookAt=" + this.lookAt + '}';
    }
}
