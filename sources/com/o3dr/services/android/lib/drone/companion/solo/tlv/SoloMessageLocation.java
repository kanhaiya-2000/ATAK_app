package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.nio.ByteBuffer;

public class SoloMessageLocation extends TLVPacket {
    public static final Parcelable.Creator<SoloMessageLocation> CREATOR = new Parcelable.Creator<SoloMessageLocation>() {
        public SoloMessageLocation createFromParcel(Parcel parcel) {
            return new SoloMessageLocation(parcel);
        }

        public SoloMessageLocation[] newArray(int i) {
            return new SoloMessageLocation[i];
        }
    };
    private LatLongAlt coordinate;

    public SoloMessageLocation(double d, double d2, float f) {
        super(2, 20);
        this.coordinate = new LatLongAlt(d, d2, (double) f);
    }

    public SoloMessageLocation(LatLongAlt latLongAlt) {
        super(2, 20);
        this.coordinate = latLongAlt;
    }

    public LatLongAlt getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(LatLongAlt latLongAlt) {
        this.coordinate = latLongAlt;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putDouble(this.coordinate.getLatitude());
        byteBuffer.putDouble(this.coordinate.getLongitude());
        byteBuffer.putFloat((float) this.coordinate.getAltitude());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.coordinate, 0);
    }

    protected SoloMessageLocation(Parcel parcel) {
        super(parcel);
        this.coordinate = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
    }
}
