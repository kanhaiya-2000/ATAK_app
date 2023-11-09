package com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageTypes;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloInspectMoveGimbal extends TLVPacket {
    public static final Parcelable.Creator<SoloInspectMoveGimbal> CREATOR = new Parcelable.Creator<SoloInspectMoveGimbal>() {
        public SoloInspectMoveGimbal createFromParcel(Parcel parcel) {
            return new SoloInspectMoveGimbal(parcel);
        }

        public SoloInspectMoveGimbal[] newArray(int i) {
            return new SoloInspectMoveGimbal[i];
        }
    };
    private float pitch;
    private float roll;
    private float yaw;

    public SoloInspectMoveGimbal(float f, float f2, float f3) {
        super(TLVMessageTypes.TYPE_SOLO_INSPECT_MOVE_GIMBAL, 12);
        this.pitch = f;
        this.roll = f2;
        this.yaw = f3;
    }

    public SoloInspectMoveGimbal(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
    }

    protected SoloInspectMoveGimbal(Parcel parcel) {
        super(parcel);
        this.pitch = parcel.readFloat();
        this.roll = parcel.readFloat();
        this.yaw = parcel.readFloat();
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getRoll() {
        return this.roll;
    }

    public float getYaw() {
        return this.yaw;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoloInspectMoveGimbal) || !super.equals(obj)) {
            return false;
        }
        SoloInspectMoveGimbal soloInspectMoveGimbal = (SoloInspectMoveGimbal) obj;
        if (Float.compare(soloInspectMoveGimbal.pitch, this.pitch) == 0 && Float.compare(soloInspectMoveGimbal.roll, this.roll) == 0 && Float.compare(soloInspectMoveGimbal.yaw, this.yaw) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        float f = this.pitch;
        int i = 0;
        int floatToIntBits = (hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.roll;
        int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.yaw;
        if (f3 != 0.0f) {
            i = Float.floatToIntBits(f3);
        }
        return floatToIntBits2 + i;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putFloat(this.pitch);
        byteBuffer.putFloat(this.roll);
        byteBuffer.putFloat(this.yaw);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.pitch);
        parcel.writeFloat(this.roll);
        parcel.writeFloat(this.yaw);
    }
}
