package org.tensorflow.lite.support.tensorbuffer;

import atakplugin.UASTool.civ;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;

public final class TensorBufferFloat extends TensorBuffer {
    private static final DataType DATA_TYPE = DataType.FLOAT32;

    TensorBufferFloat(@civ int[] iArr) {
        super(iArr);
    }

    TensorBufferFloat() {
    }

    public DataType getDataType() {
        return DATA_TYPE;
    }

    @civ
    public float[] getFloatArray() {
        this.buffer.rewind();
        float[] fArr = new float[this.flatSize];
        this.buffer.asFloatBuffer().get(fArr);
        return fArr;
    }

    public float getFloatValue(int i) {
        return this.buffer.getFloat(i << 2);
    }

    @civ
    public int[] getIntArray() {
        this.buffer.rewind();
        float[] fArr = new float[this.flatSize];
        this.buffer.asFloatBuffer().get(fArr);
        int[] iArr = new int[this.flatSize];
        for (int i = 0; i < this.flatSize; i++) {
            iArr[i] = (int) fArr[i];
        }
        return iArr;
    }

    public int getIntValue(int i) {
        return (int) this.buffer.getFloat(i << 2);
    }

    public int getTypeSize() {
        return DATA_TYPE.byteSize();
    }

    public void loadArray(@civ float[] fArr, @civ int[] iArr) {
        SupportPreconditions.checkNotNull(fArr, "The array to be loaded cannot be null.");
        SupportPreconditions.checkArgument(fArr.length == computeFlatSize(iArr), "The size of the array to be loaded does not match the specified shape.");
        resize(iArr);
        this.buffer.rewind();
        this.buffer.asFloatBuffer().put(fArr);
    }

    public void loadArray(@civ int[] iArr, @civ int[] iArr2) {
        SupportPreconditions.checkNotNull(iArr, "The array to be loaded cannot be null.");
        int i = 0;
        SupportPreconditions.checkArgument(iArr.length == computeFlatSize(iArr2), "The size of the array to be loaded does not match the specified shape.");
        resize(iArr2);
        this.buffer.rewind();
        float[] fArr = new float[iArr.length];
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            fArr[i2] = (float) iArr[i];
            i++;
            i2++;
        }
        this.buffer.asFloatBuffer().put(fArr);
    }
}
