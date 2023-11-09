package com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageTypes;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloInspectStart extends TLVPacket {
    public static final Parcelable.Creator<SoloInspectStart> CREATOR = new Parcelable.Creator<SoloInspectStart>() {
        public SoloInspectStart createFromParcel(Parcel parcel) {
            return new SoloInspectStart(parcel);
        }

        public SoloInspectStart[] newArray(int i) {
            return new SoloInspectStart[i];
        }
    };
    private float alt;

    public SoloInspectStart(float f) {
        super(TLVMessageTypes.TYPE_SOLO_INSPECT_START, 4);
        this.alt = f;
    }

    public SoloInspectStart(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat());
    }

    public float getAlt() {
        return this.alt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SoloInspectStart) && super.equals(obj) && Float.compare(((SoloInspectStart) obj).alt, this.alt) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        float f = this.alt;
        return hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0);
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putFloat(this.alt);
    }

    protected SoloInspectStart(Parcel parcel) {
        super(parcel);
        this.alt = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.alt);
    }
}
