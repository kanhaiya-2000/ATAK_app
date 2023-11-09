package com.atakmap.android.uastool.MAVLink.Messages;

import java.nio.ByteBuffer;

public class MAVLinkPayload {
    public static final int MAX_PAYLOAD_SIZE = 255;
    private static final short UNSIGNED_BYTE_MAX_VALUE = 255;
    private static final byte UNSIGNED_BYTE_MIN_VALUE = 0;
    private static final long UNSIGNED_INT_MAX_VALUE = 4294967295L;
    private static final int UNSIGNED_INT_MIN_VALUE = 0;
    private static final long UNSIGNED_LONG_MIN_VALUE = 0;
    private static final int UNSIGNED_SHORT_MAX_VALUE = 65535;
    private static final short UNSIGNED_SHORT_MIN_VALUE = 0;
    public int index;
    public final ByteBuffer payload;

    public MAVLinkPayload(int i) {
        if (i > 255) {
            this.payload = ByteBuffer.allocate(255);
        } else {
            this.payload = ByteBuffer.allocate(i);
        }
    }

    public ByteBuffer getData() {
        return this.payload;
    }

    public int size() {
        return this.payload.position();
    }

    public void add(byte b) {
        this.payload.put(b);
    }

    public int get(int i) {
        if (i < this.payload.limit()) {
            return this.payload.get(i);
        }
        return 0;
    }

    public void resetIndex() {
        this.index = 0;
    }

    public byte getByte() {
        byte b = (byte) ((get(this.index + 0) & 255) | 0);
        this.index++;
        return b;
    }

    public short getUnsignedByte() {
        short s = (short) ((get(this.index + 0) & 255) | 0);
        this.index++;
        return s;
    }

    public short getShort() {
        short s = (short) (((short) (((get(this.index + 1) & 255) << 8) | 0)) | (get(this.index + 0) & UNSIGNED_BYTE_MAX_VALUE));
        this.index += 2;
        return s;
    }

    public int getUnsignedShort() {
        int i = ((get(this.index + 1) & 255) << 8) | 0 | (get(this.index + 0) & 255);
        this.index += 2;
        return i;
    }

    public int getInt() {
        int i = ((get(this.index + 3) & 255) << 24) | 0 | ((get(this.index + 2) & 255) << 16) | ((get(this.index + 1) & 255) << 8) | (get(this.index + 0) & 255);
        this.index += 4;
        return i;
    }

    public long getUnsignedInt() {
        long j = ((((long) get(this.index + 3)) & 255) << 24) | 0 | ((((long) get(this.index + 2)) & 255) << 16) | ((((long) get(this.index + 1)) & 255) << 8) | (255 & ((long) get(this.index + 0)));
        this.index += 4;
        return j;
    }

    public long getLong() {
        long j = ((((long) get(this.index + 7)) & 255) << 56) | 0 | ((((long) get(this.index + 6)) & 255) << 48) | ((((long) get(this.index + 5)) & 255) << 40) | ((((long) get(this.index + 4)) & 255) << 32) | ((((long) get(this.index + 3)) & 255) << 24) | ((((long) get(this.index + 2)) & 255) << 16) | ((((long) get(this.index + 1)) & 255) << 8) | (255 & ((long) get(this.index + 0)));
        this.index += 8;
        return j;
    }

    public long getUnsignedLong() {
        return getLong();
    }

    public long getLongReverse() {
        long j = ((((long) get(this.index + 0)) & 255) << 56) | 0 | ((((long) get(this.index + 1)) & 255) << 48) | ((((long) get(this.index + 2)) & 255) << 40) | ((((long) get(this.index + 3)) & 255) << 32) | ((((long) get(this.index + 4)) & 255) << 24) | ((((long) get(this.index + 5)) & 255) << 16) | ((((long) get(this.index + 6)) & 255) << 8) | (255 & ((long) get(this.index + 7)));
        this.index += 8;
        return j;
    }

    public float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public void putByte(byte b) {
        add(b);
    }

    public void putUnsignedByte(short s) {
        if (s < 0 || s > 255) {
            throw new IllegalArgumentException("Value is outside of the range of an unsigned byte: " + s);
        }
        putByte((byte) s);
    }

    public void putShort(short s) {
        add((byte) (s >> 0));
        add((byte) (s >> 8));
    }

    public void putUnsignedShort(int i) {
        if (i < 0 || i > UNSIGNED_SHORT_MAX_VALUE) {
            throw new IllegalArgumentException("Value is outside of the range of an unsigned short: " + i);
        }
        putShort((short) i);
    }

    public void putInt(int i) {
        add((byte) (i >> 0));
        add((byte) (i >> 8));
        add((byte) (i >> 16));
        add((byte) (i >> 24));
    }

    public void putUnsignedInt(long j) {
        if (j < 0 || j > UNSIGNED_INT_MAX_VALUE) {
            throw new IllegalArgumentException("Value is outside of the range of an unsigned int: " + j);
        }
        putInt((int) j);
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

    public void putUnsignedLong(long j) {
        if (j >= 0) {
            putLong(j);
            return;
        }
        throw new IllegalArgumentException("Value is outside of the range of an unsigned long: " + j);
    }

    public void putFloat(float f) {
        putInt(Float.floatToIntBits(f));
    }
}
