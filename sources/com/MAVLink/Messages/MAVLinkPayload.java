package com.MAVLink.Messages;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

public class MAVLinkPayload {
    public static final int MAX_PAYLOAD_SIZE = 512;
    public int index;
    public ByteBuffer payload = ByteBuffer.allocate(512);

    public ByteBuffer getData() {
        return this.payload;
    }

    public int size() {
        return this.payload.position();
    }

    public void add(byte b) {
        try {
            this.payload.put(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetIndex() {
        this.index = 0;
    }

    public byte getByte() {
        byte b = (byte) ((this.payload.get(this.index + 0) & 255) | 0);
        this.index++;
        return b;
    }

    public short getShort() {
        short s = (short) (((short) (((this.payload.get(this.index + 1) & 255) << 8) | 0)) | (this.payload.get(this.index + 0) & 255));
        this.index += 2;
        return s;
    }

    public int getInt() {
        byte b = ((this.payload.get(this.index + 3) & 255) << Ascii.CAN) | 0 | ((this.payload.get(this.index + 2) & 255) << 16) | ((this.payload.get(this.index + 1) & 255) << 8) | (this.payload.get(this.index + 0) & 255);
        this.index += 4;
        return b;
    }

    public int getParamTypeInt() {
        return ((this.payload.get(3) & 255) << Ascii.CAN) | 0 | ((this.payload.get(2) & 255) << 16) | ((this.payload.get(1) & 255) << 8) | (this.payload.get(0) & 255);
    }

    public short getParamTypeShort() {
        return (short) (((short) (((this.payload.get(this.index + 1) & 255) << 8) | 0)) | (this.payload.get(this.index + 0) & 255));
    }

    public long getLong() {
        long j = ((((long) this.payload.get(this.index + 7)) & 255) << 56) | 0 | ((((long) this.payload.get(this.index + 6)) & 255) << 48) | ((((long) this.payload.get(this.index + 5)) & 255) << 40) | ((((long) this.payload.get(this.index + 4)) & 255) << 32) | ((((long) this.payload.get(this.index + 3)) & 255) << 24) | ((((long) this.payload.get(this.index + 2)) & 255) << 16) | ((((long) this.payload.get(this.index + 1)) & 255) << 8) | (255 & ((long) this.payload.get(this.index + 0)));
        this.index += 8;
        return j;
    }

    public long getLongReverse() {
        long j = ((((long) this.payload.get(this.index + 0)) & 255) << 56) | 0 | ((((long) this.payload.get(this.index + 1)) & 255) << 48) | ((((long) this.payload.get(this.index + 2)) & 255) << 40) | ((((long) this.payload.get(this.index + 3)) & 255) << 32) | ((((long) this.payload.get(this.index + 4)) & 255) << 24) | ((((long) this.payload.get(this.index + 5)) & 255) << 16) | ((((long) this.payload.get(this.index + 6)) & 255) << 8) | (255 & ((long) this.payload.get(this.index + 7)));
        this.index += 8;
        return j;
    }

    public float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public void putByte(byte b) {
        add(b);
    }

    public void putShort(short s) {
        add((byte) (s >> 0));
        add((byte) (s >> 8));
    }

    public void putInt(int i) {
        add((byte) (i >> 0));
        add((byte) (i >> 8));
        add((byte) (i >> 16));
        add((byte) (i >> 24));
    }

    public void putLong(long j) {
        add((byte) ((int) (j >> 0)));
        add((byte) ((int) (j >> 8)));
        add((byte) ((int) (j >> 16)));
        add((byte) ((int) (j >> 24)));
        add((byte) ((int) (j >> 32)));
        add((byte) ((int) (j >> 40)));
        add((byte) ((int) (j >> 48)));
        add((byte) ((int) (j >> 56)));
    }

    public void putFloat(float f) {
        putInt(Float.floatToIntBits(f));
    }
}
