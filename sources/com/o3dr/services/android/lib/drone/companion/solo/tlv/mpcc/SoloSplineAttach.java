package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSplineAttach extends TLVPacket {
    public static final Parcelable.Creator<SoloSplineAttach> CREATOR = new Parcelable.Creator<SoloSplineAttach>() {
        public SoloSplineAttach createFromParcel(Parcel parcel) {
            return new SoloSplineAttach(parcel);
        }

        public SoloSplineAttach[] newArray(int i) {
            return new SoloSplineAttach[i];
        }
    };
    public static final int MESSAGE_LENGTH = 4;
    private final int keypointIndex;

    public SoloSplineAttach(int i) {
        super(57, 4);
        this.keypointIndex = i;
    }

    protected SoloSplineAttach(Parcel parcel) {
        super(parcel);
        this.keypointIndex = parcel.readInt();
    }

    public SoloSplineAttach(ByteBuffer byteBuffer) {
        this(byteBuffer.getInt());
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.keypointIndex);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SoloSplineAttach) && super.equals(obj) && ((SoloSplineAttach) obj).keypointIndex == this.keypointIndex) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        int i = this.keypointIndex;
        return hashCode + (((float) i) != 0.0f ? Float.floatToIntBits((float) i) : 0);
    }

    public int getKeypointIndex() {
        return this.keypointIndex;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.keypointIndex);
    }
}
