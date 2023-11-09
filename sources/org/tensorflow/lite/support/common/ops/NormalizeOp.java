package org.tensorflow.lite.support.common.ops;

import atakplugin.UASTool.civ;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.common.TensorOperator;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;
import org.tensorflow.lite.support.tensorbuffer.TensorBufferFloat;

public class NormalizeOp implements TensorOperator {
    private final boolean isIdentityOp;
    private final float[] mean;
    private final int numChannels;
    private final float[] stddev;

    public NormalizeOp(float f, float f2) {
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i == 0 && (f2 == 0.0f || Float.isInfinite(f2))) {
            f2 = 1.0f;
        }
        SupportPreconditions.checkArgument(f2 != 0.0f, "Stddev cannot be zero.");
        this.isIdentityOp = i == 0 && f2 == 1.0f;
        this.mean = new float[]{f};
        this.stddev = new float[]{f2};
        this.numChannels = 1;
    }

    public NormalizeOp(@civ float[] fArr, @civ float[] fArr2) {
        SupportPreconditions.checkNotNull(fArr, "Mean cannot be null");
        SupportPreconditions.checkNotNull(fArr2, "Stddev cannot be null");
        SupportPreconditions.checkArgument(fArr.length == fArr2.length, "Per channel normalization requires same number of means and stddevs");
        SupportPreconditions.checkArgument(fArr.length > 0, "Means and stddevs are empty.");
        this.mean = (float[]) fArr.clone();
        this.stddev = (float[]) fArr2.clone();
        this.numChannels = fArr.length;
        boolean z = true;
        for (int i = 0; i < this.numChannels; i++) {
            SupportPreconditions.checkArgument(this.stddev[i] != 0.0f, "Stddev cannot be zero.");
            if (this.stddev[i] != 1.0f || this.mean[i] != 0.0f) {
                z = false;
            }
        }
        this.isIdentityOp = z;
    }

    @civ
    public TensorBuffer apply(@civ TensorBuffer tensorBuffer) {
        TensorBuffer tensorBuffer2;
        if (this.isIdentityOp) {
            return tensorBuffer;
        }
        int[] shape = tensorBuffer.getShape();
        int i = this.numChannels;
        SupportPreconditions.checkArgument(i == 1 || (shape.length != 0 && shape[shape.length - 1] == i), "Number of means (stddevs) is not same with number of channels (size of last axis).");
        float[] floatArray = tensorBuffer.getFloatArray();
        int i2 = 0;
        for (int i3 = 0; i3 < floatArray.length; i3++) {
            floatArray[i3] = (floatArray[i3] - this.mean[i2]) / this.stddev[i2];
            i2 = (i2 + 1) % this.numChannels;
        }
        if (tensorBuffer.isDynamic()) {
            tensorBuffer2 = TensorBufferFloat.createDynamic(DataType.FLOAT32);
        } else {
            tensorBuffer2 = TensorBufferFloat.createFixedSize(shape, DataType.FLOAT32);
        }
        tensorBuffer2.loadArray(floatArray, shape);
        return tensorBuffer2;
    }
}
