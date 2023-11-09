package com.google.common.p011io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: com.google.common.io.LittleEndianDataInputStream */
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    public LittleEndianDataInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
    }

    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    public void readFully(byte[] bArr) {
        ByteStreams.readFully(this, bArr);
    }

    public void readFully(byte[] bArr, int i, int i2) {
        ByteStreams.readFully(this, bArr, i, i2);
    }

    public int skipBytes(int i) {
        return (int) this.in.skip((long) i);
    }

    public int readUnsignedByte() {
        int read = this.in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    public int readUnsignedShort() {
        return Ints.fromBytes((byte) 0, (byte) 0, readAndCheckByte(), readAndCheckByte());
    }

    public int readInt() {
        byte readAndCheckByte = readAndCheckByte();
        byte readAndCheckByte2 = readAndCheckByte();
        return Ints.fromBytes(readAndCheckByte(), readAndCheckByte(), readAndCheckByte2, readAndCheckByte);
    }

    public long readLong() {
        byte readAndCheckByte = readAndCheckByte();
        byte readAndCheckByte2 = readAndCheckByte();
        byte readAndCheckByte3 = readAndCheckByte();
        byte readAndCheckByte4 = readAndCheckByte();
        byte readAndCheckByte5 = readAndCheckByte();
        byte readAndCheckByte6 = readAndCheckByte();
        return Longs.fromBytes(readAndCheckByte(), readAndCheckByte(), readAndCheckByte6, readAndCheckByte5, readAndCheckByte4, readAndCheckByte3, readAndCheckByte2, readAndCheckByte);
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public String readUTF() {
        return new DataInputStream(this.in).readUTF();
    }

    public short readShort() {
        return (short) readUnsignedShort();
    }

    public char readChar() {
        return (char) readUnsignedShort();
    }

    public byte readByte() {
        return (byte) readUnsignedByte();
    }

    public boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    private byte readAndCheckByte() {
        int read = this.in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }
}
