package org.tensorflow.lite.support.common.ops;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.common.TensorOperator;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public class CastOp implements TensorOperator {
    private final DataType destinationType;

    public CastOp(DataType dataType) {
        boolean z = dataType == DataType.UINT8 || dataType == DataType.FLOAT32;
        SupportPreconditions.checkArgument(z, "Destination type " + dataType + " is not supported.");
        this.destinationType = dataType;
    }

    public TensorBuffer apply(TensorBuffer tensorBuffer) {
        DataType dataType = tensorBuffer.getDataType();
        DataType dataType2 = this.destinationType;
        if (dataType == dataType2) {
            return tensorBuffer;
        }
        return TensorBuffer.createFrom(tensorBuffer, dataType2);
    }
}
