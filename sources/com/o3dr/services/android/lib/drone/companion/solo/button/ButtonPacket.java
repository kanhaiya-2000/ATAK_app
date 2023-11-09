package com.o3dr.services.android.lib.drone.companion.solo.button;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ButtonPacket implements Parcelable {
    public static final ByteOrder BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    public static final Parcelable.Creator<ButtonPacket> CREATOR = new Parcelable.Creator<ButtonPacket>() {
        public ButtonPacket createFromParcel(Parcel parcel) {
            return new ButtonPacket(parcel);
        }

        public ButtonPacket[] newArray(int i) {
            return new ButtonPacket[i];
        }
    };
    private static final String TAG = ButtonPacket.class.getSimpleName();
    private byte buttonId;
    private final ByteBuffer byteBuffer;
    private byte eventType;
    private short pressedMask;
    private double timestamp;

    public int describeContents() {
        return 0;
    }

    public ButtonPacket(short s, byte b, byte b2, double d) {
        this.timestamp = -1.0d;
        this.eventType = -1;
        this.buttonId = -1;
        this.pressedMask = -1;
        this.pressedMask = s;
        this.buttonId = b;
        this.eventType = b2;
        this.timestamp = d;
        ByteBuffer allocate = ByteBuffer.allocate(12);
        this.byteBuffer = allocate;
        allocate.order(BYTE_ORDER);
    }

    private ButtonPacket(Parcel parcel) {
        this.timestamp = -1.0d;
        this.eventType = -1;
        this.buttonId = -1;
        this.pressedMask = -1;
        this.timestamp = parcel.readDouble();
        this.eventType = parcel.readByte();
        this.buttonId = parcel.readByte();
        this.pressedMask = ((Short) parcel.readValue(Short.TYPE.getClassLoader())).shortValue();
        ByteBuffer allocate = ByteBuffer.allocate(12);
        this.byteBuffer = allocate;
        allocate.order(BYTE_ORDER);
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final byte[] toBytes() {
        this.byteBuffer.clear();
        this.byteBuffer.putDouble(this.timestamp);
        this.byteBuffer.put(this.buttonId);
        this.byteBuffer.put(this.eventType);
        this.byteBuffer.putShort(this.pressedMask);
        byte[] bArr = new byte[this.byteBuffer.position()];
        this.byteBuffer.rewind();
        this.byteBuffer.get(bArr);
        return bArr;
    }

    public double getTimestamp() {
        return this.timestamp;
    }

    public byte getButtonId() {
        return this.buttonId;
    }

    public short getPressedMask() {
        return this.pressedMask;
    }

    public static ButtonPacket parseButtonPacket(ByteBuffer byteBuffer2) {
        if (byteBuffer2 == null || byteBuffer2.limit() <= 0) {
            return null;
        }
        ByteOrder order = byteBuffer2.order();
        try {
            byteBuffer2.order(BYTE_ORDER);
            double d = byteBuffer2.getDouble();
            return new ButtonPacket(byteBuffer2.getShort(), byteBuffer2.get(), byteBuffer2.get(), d);
        } catch (BufferUnderflowException e) {
            Log.e(TAG, "Invalid data for button packet", e);
            return null;
        } finally {
            byteBuffer2.order(order);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.timestamp);
        parcel.writeByte(this.eventType);
        parcel.writeByte(this.buttonId);
        parcel.writeValue(Short.valueOf(this.pressedMask));
    }
}
