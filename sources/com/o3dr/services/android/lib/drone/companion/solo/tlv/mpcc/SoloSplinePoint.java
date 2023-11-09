package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSplinePoint extends TLVPacket {
    public static final Parcelable.Creator<SoloSplinePoint> CREATOR = new Parcelable.Creator<SoloSplinePoint>() {
        public SoloSplinePoint createFromParcel(Parcel parcel) {
            return new SoloSplinePoint(parcel);
        }

        public SoloSplinePoint[] newArray(int i) {
            return new SoloSplinePoint[i];
        }
    };
    public static final int MESSAGE_LENGTH = 44;
    public static final short STATUS_DUPLICATE_INDEX_ERROR = -3;
    public static final short STATUS_KEYPOINTS_TOO_CLOSE_ERROR = -2;
    public static final short STATUS_MODE_ERROR = -1;
    public static final short STATUS_SUCCESS = 0;
    private float absAltReference;
    private LatLongAlt coordinate;
    private int index;
    private float pitch;
    private short status;
    private float uPosition;
    private short version;
    private float yaw;

    public SoloSplinePoint(short s, float f, int i, LatLongAlt latLongAlt, float f2, float f3, float f4, short s2) {
        super(52, 44);
        this.version = s;
        this.absAltReference = f;
        this.coordinate = latLongAlt;
        this.index = i;
        this.pitch = f2;
        this.status = s2;
        this.uPosition = f4;
        this.yaw = f3;
    }

    public SoloSplinePoint(ByteBuffer byteBuffer) {
        this(byteBuffer.getShort(), byteBuffer.getFloat(), byteBuffer.getInt(), new LatLongAlt(byteBuffer.getDouble(), byteBuffer.getDouble(), (double) byteBuffer.getFloat()), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getFloat(), byteBuffer.getShort());
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putShort(this.version);
        byteBuffer.putFloat(this.absAltReference);
        byteBuffer.putInt(this.index);
        byteBuffer.putDouble(this.coordinate.getLatitude());
        byteBuffer.putDouble(this.coordinate.getLongitude());
        byteBuffer.putFloat((float) this.coordinate.getAltitude());
        byteBuffer.putFloat(this.pitch);
        byteBuffer.putFloat(this.yaw);
        byteBuffer.putFloat(this.uPosition);
        byteBuffer.putShort(this.status);
    }

    public short getVersion() {
        return this.version;
    }

    public float getAbsAltReference() {
        return this.absAltReference;
    }

    public LatLongAlt getCoordinate() {
        return this.coordinate;
    }

    public int getIndex() {
        return this.index;
    }

    public float getPitch() {
        return this.pitch;
    }

    public short getStatus() {
        return this.status;
    }

    public float getUPosition() {
        return this.uPosition;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.version);
        parcel.writeFloat(this.absAltReference);
        parcel.writeInt(this.index);
        parcel.writeParcelable(this.coordinate, 0);
        parcel.writeFloat(this.pitch);
        parcel.writeFloat(this.yaw);
        parcel.writeFloat(this.uPosition);
        parcel.writeInt(this.status);
    }

    protected SoloSplinePoint(Parcel parcel) {
        super(parcel);
        this.version = (short) parcel.readInt();
        this.absAltReference = parcel.readFloat();
        this.index = parcel.readInt();
        this.coordinate = (LatLongAlt) parcel.readParcelable(LatLongAlt.class.getClassLoader());
        this.pitch = parcel.readFloat();
        this.yaw = parcel.readFloat();
        this.uPosition = parcel.readFloat();
        this.status = (short) parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        SoloSplinePoint soloSplinePoint = (SoloSplinePoint) obj;
        if (this.version == soloSplinePoint.version && Float.compare(soloSplinePoint.absAltReference, this.absAltReference) == 0 && this.index == soloSplinePoint.index && Float.compare(soloSplinePoint.pitch, this.pitch) == 0 && Float.compare(soloSplinePoint.yaw, this.yaw) == 0 && Float.compare(soloSplinePoint.uPosition, this.uPosition) == 0 && this.status == soloSplinePoint.status) {
            return this.coordinate.equals(soloSplinePoint.coordinate);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((super.hashCode() * 31) + this.version) * 31;
        float f = this.absAltReference;
        int i = 0;
        int floatToIntBits = (((((hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.index) * 31) + this.coordinate.hashCode()) * 31;
        float f2 = this.pitch;
        int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.yaw;
        int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.uPosition;
        if (f4 != 0.0f) {
            i = Float.floatToIntBits(f4);
        }
        return ((floatToIntBits3 + i) * 31) + this.status;
    }

    public String toString() {
        return "SoloSplinePoint{version=" + this.version + ", absAltReference=" + this.absAltReference + ", index=" + this.index + ", coordinate=" + this.coordinate + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", uPosition=" + this.uPosition + ", status=" + this.status + '}';
    }
}
