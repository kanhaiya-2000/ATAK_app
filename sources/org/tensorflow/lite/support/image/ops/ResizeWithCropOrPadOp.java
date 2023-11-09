package org.tensorflow.lite.support.image.ops;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import atakplugin.UASTool.civ;
import org.tensorflow.lite.support.image.ImageOperator;
import org.tensorflow.lite.support.image.TensorImage;

public class ResizeWithCropOrPadOp implements ImageOperator {
    private final Bitmap output;
    private final int targetHeight;
    private final int targetWidth;

    public ResizeWithCropOrPadOp(int i, int i2) {
        this.targetHeight = i;
        this.targetWidth = i2;
        this.output = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
    }

    @civ
    public TensorImage apply(@civ TensorImage tensorImage) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Bitmap bitmap = tensorImage.getBitmap();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i7 = this.targetWidth;
        int i8 = 0;
        if (i7 > width) {
            i3 = (i7 - width) / 2;
            i = i3 + width;
            i2 = width;
            i4 = 0;
        } else {
            i4 = (width - i7) / 2;
            i2 = i4 + i7;
            i = i7;
            i3 = 0;
        }
        int i9 = this.targetHeight;
        if (i9 > height) {
            i6 = (i9 - height) / 2;
            i5 = i6 + height;
        } else {
            int i10 = (height - i9) / 2;
            i8 = i10;
            height = i10 + i9;
            i5 = i9;
            i6 = 0;
        }
        new Canvas(this.output).drawBitmap(bitmap, new Rect(i4, i8, i2, height), new Rect(i3, i6, i, i5), (Paint) null);
        tensorImage.load(this.output);
        return tensorImage;
    }

    public int getOutputImageHeight(int i, int i2) {
        return this.targetHeight;
    }

    public int getOutputImageWidth(int i, int i2) {
        return this.targetWidth;
    }

    public PointF inverseTransform(PointF pointF, int i, int i2) {
        return transformImpl(pointF, this.targetHeight, this.targetWidth, i, i2);
    }

    private static PointF transformImpl(PointF pointF, int i, int i2, int i3, int i4) {
        return new PointF(pointF.x + ((float) ((i4 - i2) / 2)), pointF.y + ((float) ((i3 - i) / 2)));
    }
}
