package org.tensorflow.lite.support.common.ops;

import org.tensorflow.lite.support.common.TensorOperator;

public class DequantizeOp extends NormalizeOp implements TensorOperator {
    public DequantizeOp(float f, float f2) {
        super(f, 1.0f / f2);
    }
}
