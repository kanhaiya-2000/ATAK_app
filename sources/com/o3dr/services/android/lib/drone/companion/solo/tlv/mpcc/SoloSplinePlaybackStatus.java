package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSplinePlaybackStatus extends TLVPacket {
    public static final Parcelable.Creator<SoloSplinePlaybackStatus> CREATOR = new Parcelable.Creator<SoloSplinePlaybackStatus>() {
        public SoloSplinePlaybackStatus createFromParcel(Parcel parcel) {
            return new SoloSplinePlaybackStatus(parcel);
        }

        public SoloSplinePlaybackStatus[] newArray(int i) {
            return new SoloSplinePlaybackStatus[i];
        }
    };
    public static final int MESSAGE_LENGTH = 8;
    private int cruiseState;
    private float uPosition;

    public SoloSplinePlaybackStatus(float f, int i) {
        super(54, 8);
        this.uPosition = f;
        this.cruiseState = i;
    }

    public SoloSplinePlaybackStatus(ByteBuffer byteBuffer) {
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

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.uPosition);
        parcel.writeInt(this.cruiseState);
    }

    protected SoloSplinePlaybackStatus(Parcel parcel) {
        super(parcel);
        this.uPosition = parcel.readFloat();
        this.cruiseState = parcel.readInt();
    }

    public String toString() {
        return "SoloSplinePlaybackStatus{uPosition=" + this.uPosition + ", cruiseState=" + this.cruiseState + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoloSplinePlaybackStatus) || !super.equals(obj)) {
            return false;
        }
        SoloSplinePlaybackStatus soloSplinePlaybackStatus = (SoloSplinePlaybackStatus) obj;
        if (Float.compare(soloSplinePlaybackStatus.uPosition, this.uPosition) == 0 && this.cruiseState == soloSplinePlaybackStatus.cruiseState) {
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
