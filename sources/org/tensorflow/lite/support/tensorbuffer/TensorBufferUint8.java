package org.tensorflow.lite.support.tensorbuffer;

import atakplugin.UASTool.civ;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;

public final class TensorBufferUint8 extends TensorBuffer {
    private static final DataType DATA_TYPE = DataType.UINT8;

    TensorBufferUint8(@civ int[] iArr) {
        super(iArr);
    }

    TensorBufferUint8() {
    }

    public DataType getDataType() {
        return DATA_TYPE;
    }

    @civ
    public float[] getFloatArray() {
        this.buffer.rewind();
        byte[] bArr = new byte[this.flatSize];
        this.buffer.get(bArr);
        float[] fArr = new float[this.flatSize];
        for (int i = 0; i < this.flatSize; i++) {
            fArr[i] = (float) (bArr[i] & 255);
        }
        return fArr;
    }

    public float getFloatValue(int i) {
        return (float) (this.buffer.get(i) & 255);
    }

    @civ
    public int[] getIntArray() {
        this.buffer.rewind();
        byte[] bArr = new byte[this.flatSize];
        this.buffer.get(bArr);
        int[] iArr = new int[this.flatSize];
        for (int i = 0; i < this.flatSize; i++) {
            iArr[i] = bArr[i] & 255;
        }
        return iArr;
    }

    public int getIntValue(int i) {
        return this.buffer.get(i) & 255;
    }

    public int getTypeSize() {
        return DATA_TYPE.byteSize();
    }

    public void loadArray(@civ float[] fArr, @civ int[] iArr) {
        SupportPreconditions.checkNotNull(fArr, "The array to be loaded cannot be null.");
        int i = 0;
        SupportPreconditions.checkArgument(fArr.length == computeFlatSize(iArr), "The size of the array to be loaded does not match the specified shape.");
        resize(iArr);
        this.buffer.rewind();
        byte[] bArr = new byte[fArr.length];
        int length = fArr.length;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) ((int) Math.max(Math.min((double) fArr[i], 255.0d), 0.0d));
            i++;
            i2++;
        }
        this.buffer.put(bArr);
    }

    public void loadArray(@civ int[] iArr, @civ int[] iArr2) {
        SupportPreconditions.checkNotNull(iArr, "The array to be loaded cannot be null.");
        int i = 0;
        SupportPreconditions.checkArgument(iArr.length == computeFlatSize(iArr2), "The size of the array to be loaded does not match the specified shape.");
        resize(iArr2);
        this.buffer.rewind();
        byte[] bArr = new byte[iArr.length];
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) ((int) Math.max(Math.min((float) iArr[i], 255.0f), 0.0f));
            i++;
            i2++;
        }
        this.buffer.put(bArr);
    }
}
