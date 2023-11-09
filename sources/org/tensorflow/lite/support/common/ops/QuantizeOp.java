package org.tensorflow.lite.support.common.ops;

import org.tensorflow.lite.support.common.TensorOperator;

public class QuantizeOp extends NormalizeOp implements TensorOperator {
    public QuantizeOp(float f, float f2) {
        super((-f) * f2, f2);
    }
}
