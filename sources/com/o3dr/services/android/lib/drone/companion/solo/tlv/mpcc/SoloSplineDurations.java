package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSplineDurations extends TLVPacket {
    public static final Parcelable.Creator<SoloSplineDurations> CREATOR = new Parcelable.Creator<SoloSplineDurations>() {
        public SoloSplineDurations createFromParcel(Parcel parcel) {
            return new SoloSplineDurations(parcel);
        }

        public SoloSplineDurations[] newArray(int i) {
            return new SoloSplineDurations[i];
        }
    };
    public static final int MESSAGE_LENGTH = 8;
    private float maxTime;
    private float minTime;

    public SoloSplineDurations(float f, float f2) {
        super(56, 8);
        this.maxTime = f2;
        this.minTime = f;
    }

    public SoloSplineDurations(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat(), byteBuffer.getFloat());
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putFloat(this.minTime);
        byteBuffer.putFloat(this.maxTime);
    }

    public float getMaxTime() {
        return this.maxTime;
    }

    public float getMinTime() {
        return this.minTime;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.minTime);
        parcel.writeFloat(this.maxTime);
    }

    protected SoloSplineDurations(Parcel parcel) {
        super(parcel);
        this.minTime = parcel.readFloat();
        this.maxTime = parcel.readFloat();
    }

    public String toString() {
        return "SoloSplineDurations{minTime=" + this.minTime + ", maxTime=" + this.maxTime + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        SoloSplineDurations soloSplineDurations = (SoloSplineDurations) obj;
        if (Float.compare(soloSplineDurations.minTime, this.minTime) == 0 && Float.compare(soloSplineDurations.maxTime, this.maxTime) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        float f = this.minTime;
        int i = 0;
        int floatToIntBits = (hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.maxTime;
        if (f2 != 0.0f) {
            i = Float.floatToIntBits(f2);
        }
        return floatToIntBits + i;
    }
}
