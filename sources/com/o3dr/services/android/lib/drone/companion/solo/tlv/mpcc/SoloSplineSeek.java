package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSplineSeek extends TLVPacket {
    public static final Parcelable.Creator<SoloSplineSeek> CREATOR = new Parcelable.Creator<SoloSplineSeek>() {
        public SoloSplineSeek createFromParcel(Parcel parcel) {
            return new SoloSplineSeek(parcel);
        }

        public SoloSplineSeek[] newArray(int i) {
            return new SoloSplineSeek[i];
        }
    };
    public static final int MESSAGE_LENGTH = 8;
    private int cruiseState;
    private float uPosition;

    public SoloSplineSeek(float f, int i) {
        super(53, 8);
        this.uPosition = f;
        this.cruiseState = i;
    }

    public SoloSplineSeek(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat(), byteBuffer.getInt());
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putFloat(this.uPosition);
        byteBuffer.putInt(this.cruiseState);
    }

    public float getUPosition() {
        return this.uPosition;
    }

    public int getCruiseState() {
        return this.cruiseState;
    }

    public String toString() {
        return "SoloSplineSeek{uPosition=" + this.uPosition + ", cruiseState=" + this.cruiseState + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.uPosition);
        parcel.writeInt(this.cruiseState);
    }

    protected SoloSplineSeek(Parcel parcel) {
        super(parcel);
        this.uPosition = parcel.readFloat();
        this.cruiseState = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        SoloSplineSeek soloSplineSeek = (SoloSplineSeek) obj;
        if (Float.compare(soloSplineSeek.uPosition, this.uPosition) == 0 && this.cruiseState == soloSplineSeek.cruiseState) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        float f = this.uPosition;
        return ((hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.cruiseState;
    }
}
