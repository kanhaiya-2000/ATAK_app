package com.o3dr.services.android.lib.drone.companion.solo.tlv.mpcc;

import android.os.Parcel;
import android.os.Parcelable;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import java.nio.ByteBuffer;

public class SoloSplinePathSettings extends TLVPacket {
    public static final int AUTO_POINT_CAMERA = 0;
    public static final Parcelable.Creator<SoloSplinePathSettings> CREATOR = new Parcelable.Creator<SoloSplinePathSettings>() {
        public SoloSplinePathSettings createFromParcel(Parcel parcel) {
            return new SoloSplinePathSettings(parcel);
        }

        public SoloSplinePathSettings[] newArray(int i) {
            return new SoloSplinePathSettings[i];
        }
    };
    public static final int FREE_LOOK = 1;
    public static final int MESSAGE_LENGTH = 8;
    private int cameraControl;
    private float desiredTime;

    public @interface CameraControl {
    }

    public SoloSplinePathSettings(int i, float f) {
        super(55, 8);
        this.cameraControl = i;
        this.desiredTime = f;
    }

    public SoloSplinePathSettings(ByteBuffer byteBuffer) {
        this(byteBuffer.getInt(), (float) byteBuffer.getInt());
    }

    public int getCameraControl() {
        return this.cameraControl;
    }

    public float getDesiredTime() {
        return this.desiredTime;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.cameraControl);
        byteBuffer.putFloat(this.desiredTime);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.cameraControl);
        parcel.writeFloat(this.desiredTime);
    }

    protected SoloSplinePathSettings(Parcel parcel) {
        super(parcel);
        this.cameraControl = parcel.readInt();
        this.desiredTime = parcel.readFloat();
    }

    public String toString() {
        return "SoloSplinePathSettings{cameraControl=" + this.cameraControl + ", desiredTime=" + this.desiredTime + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SoloSplinePathSettings) || !super.equals(obj)) {
            return false;
        }
        SoloSplinePathSettings soloSplinePathSettings = (SoloSplinePathSettings) obj;
        if (this.cameraControl == soloSplinePathSettings.cameraControl && Float.compare(soloSplinePathSettings.desiredTime, this.desiredTime) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((super.hashCode() * 31) + this.cameraControl) * 31;
        float f = this.desiredTime;
        return hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0);
    }
}
