package org.tensorflow.lite.support.image;

import android.graphics.Bitmap;
import android.util.Log;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

final class TensorBufferContainer implements ImageContainer {
    private static final String TAG = "TensorBufferContainer";
    private final TensorBuffer buffer;
    private final ColorSpaceType colorSpaceType;

    static TensorBufferContainer create(TensorBuffer tensorBuffer, ColorSpaceType colorSpaceType2) {
        return new TensorBufferContainer(tensorBuffer, colorSpaceType2);
    }

    private TensorBufferContainer(TensorBuffer tensorBuffer, ColorSpaceType colorSpaceType2) {
        colorSpaceType2.assertShape(tensorBuffer.getShape());
        this.buffer = tensorBuffer;
        this.colorSpaceType = colorSpaceType2;
    }

    public TensorBufferContainer clone() {
        TensorBuffer tensorBuffer = this.buffer;
        return create(TensorBuffer.createFrom(tensorBuffer, tensorBuffer.getDataType()), this.colorSpaceType);
    }

    public Bitmap getBitmap() {
        if (this.buffer.getDataType() != DataType.UINT8) {
            Log.w(TAG, "<Warning> TensorBufferContainer is holding a non-uint8 image. The conversion to Bitmap will cause numeric casting and clamping on the data value.");
        }
        return this.colorSpaceType.convertTensorBufferToBitmap(this.buffer);
    }

    public TensorBuffer getTensorBuffer(DataType dataType) {
        return this.buffer.getDataType() == dataType ? this.buffer : TensorBuffer.createFrom(this.buffer, dataType);
    }

    public int getWidth() {
        return this.colorSpaceType.getWidth(this.buffer.getShape());
    }

    public int getHeight() {
        return this.colorSpaceType.getHeight(this.buffer.getShape());
    }

    public ColorSpaceType getColorSpaceType() {
        return this.colorSpaceType;
    }
}
