package com.o3dr.services.android.lib.drone.companion.solo.tlv.sitescan.inspect;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVMessageTypes;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloInspectSetWaypoint extends TLVPacket {
    public static final Parcelable.Creator<SoloInspectSetWaypoint> CREATOR = new Parcelable.Creator<SoloInspectSetWaypoint>() {
        public SoloInspectSetWaypoint createFromParcel(Parcel parcel) {
            return new SoloInspectSetWaypoint(parcel);
        }

        public SoloInspectSetWaypoint[] newArray(int i) {
            return new SoloInspectSetWaypoint[i];
        }
    };
    private float alt;
    private float lat;
    private float lon;

    public SoloInspectSetWaypoint(float f, float f2, float f3) {
        super(TLVMessageTypes.TYPE_SOLO_INSPECT_SET_WAYPOINT, 12);
        this.lat = f;
        this.lon = f2;
        this.alt = f3;
    }

    public SoloInspectSetWaypoint(ByteBuffer byteBuffer) {
        this(byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat());
    }

    public float getLat() {
        return this.lat;
    }

    public float getLon() {
        return this.lon;
    }

    public float getAlt() {
        return this.alt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoloInspectSetWaypoint) || !super.equals(obj)) {
            return false;
        }
        SoloInspectSetWaypoint soloInspectSetWaypoint = (SoloInspectSetWaypoint) obj;
        if (Float.compare(soloInspectSetWaypoint.lat, this.lat) == 0 && Float.compare(soloInspectSetWaypoint.lon, this.lon) == 0 && Float.compare(soloInspectSetWaypoint.alt, this.alt) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        float f = this.lat;
        int i = 0;
        int floatToIntBits = (hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.lon;
        int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.alt;
        if (f3 != 0.0f) {
            i = Float.floatToIntBits(f3);
        }
        return floatToIntBits2 + i;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putFloat(this.lat);
        byteBuffer.putFloat(this.lon);
        byteBuffer.putFloat(this.alt);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.lat);
        parcel.writeFloat(this.lon);
        parcel.writeFloat(this.alt);
    }

    protected SoloInspectSetWaypoint(Parcel parcel) {
        super(parcel);
        this.lat = parcel.readFloat();
        this.lon = parcel.readFloat();
        this.alt = parcel.readFloat();
    }
}
