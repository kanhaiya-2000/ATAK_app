package org.tensorflow.lite.support.image.ops;

import android.graphics.Bitmap;
import android.graphics.PointF;
import atakplugin.UASTool.civ;
import org.tensorflow.lite.support.image.ImageOperator;
import org.tensorflow.lite.support.image.TensorImage;

public class ResizeOp implements ImageOperator {
    private final int targetHeight;
    private final int targetWidth;
    private final boolean useBilinear;

    public enum ResizeMethod {
        BILINEAR,
        NEAREST_NEIGHBOR
    }

    public ResizeOp(int i, int i2, ResizeMethod resizeMethod) {
        this.targetHeight = i;
        this.targetWidth = i2;
        this.useBilinear = resizeMethod == ResizeMethod.BILINEAR;
    }

    @civ
    public TensorImage apply(@civ TensorImage tensorImage) {
        tensorImage.load(Bitmap.createScaledBitmap(tensorImage.getBitmap(), this.targetWidth, this.targetHeight, this.useBilinear));
        return tensorImage;
    }

    public int getOutputImageHeight(int i, int i2) {
        return this.targetHeight;
    }

    public int getOutputImageWidth(int i, int i2) {
        return this.targetWidth;
    }

    public PointF inverseTransform(PointF pointF, int i, int i2) {
        return new PointF((pointF.x * ((float) i2)) / ((float) this.targetWidth), (pointF.y * ((float) i)) / ((float) this.targetHeight));
    }
}
