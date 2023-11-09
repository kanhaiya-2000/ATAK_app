package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.nio.ByteBuffer;

public class SoloCableCamWaypoint extends TLVPacket {
    public static final Parcelable.Creator<SoloCableCamWaypoint> CREATOR = new Parcelable.Creator<SoloCableCamWaypoint>() {
        public SoloCableCamWaypoint createFromParcel(Parcel parcel) {
            return new SoloCableCamWaypoint(parcel);
        }

        public SoloCableCamWaypoint[] newArray(int i) {
            return new SoloCableCamWaypoint[i];
        }
    };
    private LatLongAlt coordinate;
    private float degreesYaw;
    private float pitch;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SoloCableCamWaypoint(double d, double d2, float f, float f2, float f3) {
        super(1001, 28);
        this.coordinate = new LatLongAlt(d, d2, (double) f);
        this.degreesYaw = f2;
        this.pitch = f3;
    }

    public LatLongAlt getCoordinate() {
        return this.coordinate;
    }

    public float getDegreesYaw() {
        return this.degreesYaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putDouble(this.coordinate.getLatitude());
        byteBuffer.putDouble(this.coordinate.getLongitude());
        byteBuffer.putFloat((float) this.coordinate.getAltitude());
        byteBuffer.putFloat(this.degreesYaw);
        byteBuffer.putFloat(this.pitch);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.coordinate, 0);
        parcel.writeFloat(this.degreesYaw);
        parcel.writeFloat(this.pitch);
    }

    protected SoloCableCamWaypoint(Parcel parcel) {
        super(parcel);
        this.coordinate = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
        this.degreesYaw = parcel.readFloat();
        this.pitch = parcel.readFloat();
    }
}
