package com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageTypes;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloInspectMoveVehicle extends TLVPacket {
    public static final Parcelable.Creator<SoloInspectMoveVehicle> CREATOR = new Parcelable.Creator<SoloInspectMoveVehicle>() {
        public SoloInspectMoveVehicle createFromParcel(Parcel parcel) {
            return new SoloInspectMoveVehicle(parcel);
        }

        public SoloInspectMoveVehicle[] newArray(int i) {
            return new SoloInspectMoveVehicle[i];
        }
    };

    /* renamed from: vx */
    private float f8606vx;

    /* renamed from: vy */
    private float f8607vy;

    /* renamed from: vz */
    private float f8608vz;

    public SoloInspectMoveVehicle(float f, float f2, float f3) {
        super(TLVMessageTypes.TYPE_SOLO_INSPECT_MOVE_VEHICLE, 12);
        this.f8606vx = f;
        this.f8607vy = f2;
        this.f8608vz = f3;
    }

    public SoloInspectMoveVehicle(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
    }

    public float getVx() {
        return this.f8606vx;
    }

    public float getVy() {
        return this.f8607vy;
    }

    public float getVz() {
        return this.f8608vz;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoloInspectMoveVehicle) || !super.equals(obj)) {
            return false;
        }
        SoloInspectMoveVehicle soloInspectMoveVehicle = (SoloInspectMoveVehicle) obj;
        if (Float.compare(soloInspectMoveVehicle.f8606vx, this.f8606vx) == 0 && Float.compare(soloInspectMoveVehicle.f8607vy, this.f8607vy) == 0 && Float.compare(soloInspectMoveVehicle.f8608vz, this.f8608vz) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        float f = this.f8606vx;
        int i = 0;
        int floatToIntBits = (hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.f8607vy;
        int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.f8608vz;
        if (f3 != 0.0f) {
            i = Float.floatToIntBits(f3);
        }
        return floatToIntBits2 + i;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putFloat(this.f8606vx);
        byteBuffer.putFloat(this.f8607vy);
        byteBuffer.putFloat(this.f8608vz);
    }

    protected SoloInspectMoveVehicle(Parcel parcel) {
        super(parcel);
        this.f8606vx = parcel.readFloat();
        this.f8607vy = parcel.readFloat();
        this.f8608vz = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f8606vx);
        parcel.writeFloat(this.f8607vy);
        parcel.writeFloat(this.f8608vz);
    }
}
