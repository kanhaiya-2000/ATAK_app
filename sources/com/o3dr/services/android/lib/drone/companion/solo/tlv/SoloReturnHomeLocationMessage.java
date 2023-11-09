package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.nio.ByteBuffer;

public class SoloReturnHomeLocationMessage extends TLVPacket {
    public static final Parcelable.Creator<SoloReturnHomeLocationMessage> CREATOR = new Parcelable.Creator<SoloReturnHomeLocationMessage>() {
        public SoloReturnHomeLocationMessage createFromParcel(Parcel parcel) {
            return new SoloReturnHomeLocationMessage(parcel);
        }

        public SoloReturnHomeLocationMessage[] newArray(int i) {
            return new SoloReturnHomeLocationMessage[i];
        }
    };
    private LatLongAlt coordinate;

    public SoloReturnHomeLocationMessage(double d, double d2, float f) {
        super(26, 20);
        this.coordinate = new LatLongAlt(d, d2, (double) f);
    }

    public SoloReturnHomeLocationMessage(LatLongAlt latLongAlt) {
        super(26, 20);
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
        parcel.writeParcelable(this.coordinate, i);
    }

    protected SoloReturnHomeLocationMessage(Parcel parcel) {
        super(parcel);
        this.coordinate = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
    }
}
