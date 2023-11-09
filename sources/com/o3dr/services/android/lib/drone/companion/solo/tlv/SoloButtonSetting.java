package com.o3dr.services.android.lib.drone.companion.solo.tlv;

import android.os.Parcel;
import java.nio.ByteBuffer;

public abstract class SoloButtonSetting extends TLVPacket {
    public static final int MESSAGE_LENGTH = 16;
    private int button;
    private int event;
    private int flightMode;
    private int shotType;

    public SoloButtonSetting(int i, int i2, int i3, int i4, int i5) {
        super(i, 16);
        this.button = i2;
        this.event = i3;
        this.shotType = i4;
        this.flightMode = i5;
    }

    public int getButton() {
        return this.button;
    }

    public void setButton(int i) {
        this.button = i;
    }

    public int getEvent() {
        return this.event;
    }

    public void setEvent(int i) {
        this.event = i;
    }

    public int getShotType() {
        return this.shotType;
    }

    public int getFlightMode() {
        return this.flightMode;
    }

    public void setShotTypeFlightMode(int i, int i2) {
        this.shotType = i;
        this.flightMode = i2;
    }

    /* access modifiers changed from: protected */
    public void getMessageValue(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.button);
        byteBuffer.putInt(this.event);
        byteBuffer.putInt(this.shotType);
        byteBuffer.putInt(this.flightMode);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.button);
        parcel.writeInt(this.event);
        parcel.writeInt(this.shotType);
        parcel.writeInt(this.flightMode);
    }

    protected SoloButtonSetting(Parcel parcel) {
        super(parcel);
        this.button = parcel.readInt();
        this.event = parcel.readInt();
        this.shotType = parcel.readInt();
        this.flightMode = parcel.readInt();
    }
}
