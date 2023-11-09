package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class SoloPanoOptions extends TLVPacket {
    public static final Parcelable.Creator<SoloPanoOptions> CREATOR = new Parcelable.Creator<SoloPanoOptions>() {
        public SoloPanoOptions createFromParcel(Parcel parcel) {
            return new SoloPanoOptions(parcel);
        }

        public SoloPanoOptions[] newArray(int i) {
            return new SoloPanoOptions[i];
        }
    };
    public static final int MESSAGE_LENGTH = 12;
    private static final int PANO_OFF_VALUE = 0;
    private static final int PANO_ON_VALUE = 1;
    public static final int PANO_PREFERENCE_CYLINDRICAL = 0;
    public static final int PANO_PREFERENCE_SPHERICAL = 1;
    public static final int PANO_PREFERENCE_VIDEO = 2;
    private float cameraFOV;
    private float degreesPerSecondYawSpeed;
    private boolean isRunning;
    private short panAngle;
    private int panoPreference;

    public @interface PanoPreference {
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean z) {
        this.isRunning = z;
    }

    public int getPanoPreference() {
        return this.panoPreference;
    }

    public void setPanoPreference(int i) {
        this.panoPreference = i;
    }

    public short getPanAngle() {
        return this.panAngle;
    }

    public void setPanAngle(short s) {
        this.panAngle = s;
    }

    public float getDegreesPerSecondYawSpeed() {
        return this.degreesPerSecondYawSpeed;
    }

    public void setDegreesPerSecondYawSpeed(float f) {
        this.degreesPerSecondYawSpeed = f;
    }

    public float getCameraFOV() {
        return this.cameraFOV;
    }

    public void setCameraFOV(float f) {
        this.cameraFOV = f;
    }

    public SoloPanoOptions(int i, boolean z, short s, float f, float f2) {
        super(22, 12);
        this.panoPreference = i;
        this.isRunning = z;
        this.panAngle = s;
        this.degreesPerSecondYawSpeed = f;
        this.cameraFOV = f2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    SoloPanoOptions(ByteBuffer byteBuffer) {
        this(byteBuffer.get(), byteBuffer.get() != 1 ? false : true, byteBuffer.getShort(), byteBuffer.getFloat(), byteBuffer.getFloat());
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) this.panoPreference);
        byteBuffer.put(this.isRunning ? (byte) 1 : 0);
        byteBuffer.putShort(this.panAngle);
        byteBuffer.putFloat(this.degreesPerSecondYawSpeed);
        byteBuffer.putFloat(this.cameraFOV);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) this.panoPreference);
        parcel.writeByte(this.isRunning ? (byte) 1 : 0);
        parcel.writeInt(this.panAngle);
        parcel.writeFloat(this.degreesPerSecondYawSpeed);
        parcel.writeFloat(this.cameraFOV);
    }

    protected SoloPanoOptions(Parcel parcel) {
        super(parcel);
        this.panoPreference = parcel.readByte();
        this.isRunning = parcel.readByte() != 0;
        this.panAngle = (short) parcel.readInt();
        this.degreesPerSecondYawSpeed = parcel.readFloat();
        this.cameraFOV = parcel.readFloat();
    }

    public String toString() {
        return "SoloPanoOptions{panoPreference=" + this.panoPreference + "isRunning=" + this.isRunning + "panAngle=" + this.panAngle + "degreesPerSecondYawSpeed=" + this.degreesPerSecondYawSpeed + "cameraFOV=" + this.cameraFOV + '}';
    }
}
