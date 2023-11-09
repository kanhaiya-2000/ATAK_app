package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;

public class ControllerMessageInputReport extends TLVPacket {
    public static final Parcelable.Creator<ControllerMessageInputReport> CREATOR = new Parcelable.Creator<ControllerMessageInputReport>() {
        public ControllerMessageInputReport createFromParcel(Parcel parcel) {
            return new ControllerMessageInputReport(parcel);
        }

        public ControllerMessageInputReport[] newArray(int i) {
            return new ControllerMessageInputReport[i];
        }
    };
    private short battery;
    private short gimbalRate;
    private short gimbalY;
    private double timestamp;

    public ControllerMessageInputReport(double d, short s, short s2, short s3) {
        super(2003, 14);
        this.timestamp = d;
        this.gimbalY = s;
        this.gimbalRate = s2;
        this.battery = s3;
    }

    public double getTimestamp() {
        return this.timestamp;
    }

    public short getGimbalY() {
        return this.gimbalY;
    }

    public short getGimbalRate() {
        return this.gimbalRate;
    }

    public short getBattery() {
        return this.battery;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putDouble(this.timestamp);
        byteBuffer.putShort(this.gimbalY);
        byteBuffer.putShort(this.gimbalRate);
        byteBuffer.putShort(this.battery);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.timestamp);
        parcel.writeInt(this.gimbalY);
        parcel.writeInt(this.gimbalRate);
        parcel.writeInt(this.battery);
    }

    protected ControllerMessageInputReport(Parcel parcel) {
        super(parcel);
        this.timestamp = parcel.readDouble();
        this.gimbalY = (short) parcel.readInt();
        this.gimbalRate = (short) parcel.readInt();
        this.battery = (short) parcel.readInt();
    }

    public String toString() {
        return "ControllerMessageInputReport{battery=" + this.battery + ", timestamp=" + this.timestamp + ", gimbalY=" + this.gimbalY + ", gimbalRate=" + this.gimbalRate + '}';
    }
}
