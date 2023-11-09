package org.tensorflow.lite.support.image.ops;

import android.graphics.PointF;
import atakplugin.UASTool.civ;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.common.TensorOperator;
import org.tensorflow.lite.support.image.ImageOperator;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public class TensorOperatorWrapper implements ImageOperator {
    private final TensorOperator tensorOp;

    public int getOutputImageHeight(int i, int i2) {
        return i;
    }

    public int getOutputImageWidth(int i, int i2) {
        return i2;
    }

    public PointF inverseTransform(PointF pointF, int i, int i2) {
        return pointF;
    }

    public TensorOperatorWrapper(TensorOperator tensorOperator) {
        this.tensorOp = tensorOperator;
    }

    @civ
    public TensorImage apply(@civ TensorImage tensorImage) {
        SupportPreconditions.checkNotNull(tensorImage, "Op cannot apply on null image.");
        TensorBuffer apply = this.tensorOp.apply(tensorImage.getTensorBuffer());
        TensorImage tensorImage2 = new TensorImage(apply.getDataType());
        tensorImage2.load(apply);
        return tensorImage2;
    }
}
