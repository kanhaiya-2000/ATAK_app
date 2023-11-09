package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloShotOptions extends TLVPacket {
    public static final Parcelable.Creator<SoloShotOptions> CREATOR = new Parcelable.Creator<SoloShotOptions>() {
        public SoloShotOptions createFromParcel(Parcel parcel) {
            return new SoloShotOptions(parcel);
        }

        public SoloShotOptions[] newArray(int i) {
            return new SoloShotOptions[i];
        }
    };
    public static final int DEFAULT_ABS_CRUISE_SPEED = 4;
    public static final int MAX_ABS_CRUISE_SPEED = 8;
    public static final int MIN_ABS_CRUISE_SPEED = 1;
    public static final int PAUSED_CRUISE_SPEED = 0;
    private float cruiseSpeed;

    public SoloShotOptions() {
        this(20, 4, 0.0f);
    }

    public SoloShotOptions(float f) {
        this(20, 4, f);
    }

    protected SoloShotOptions(int i, int i2, float f) {
        super(i, i2);
        this.cruiseSpeed = f;
    }

    public float getCruiseSpeed() {
        return this.cruiseSpeed;
    }

    public void setCruiseSpeed(float f) {
        this.cruiseSpeed = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SoloShotOptions) && super.equals(obj) && Float.compare(((SoloShotOptions) obj).cruiseSpeed, this.cruiseSpeed) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        float f = this.cruiseSpeed;
        return hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0);
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putFloat(this.cruiseSpeed);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.cruiseSpeed);
    }

    protected SoloShotOptions(Parcel parcel) {
        super(parcel);
        this.cruiseSpeed = parcel.readFloat();
    }
}
