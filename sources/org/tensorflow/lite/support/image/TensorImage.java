package org.tensorflow.lite.support.image;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public class TensorImage {
    private ImageContainer container;
    private final DataType dataType;

    public TensorImage() {
        this(DataType.UINT8);
    }

    public TensorImage(DataType dataType2) {
        this.container = null;
        SupportPreconditions.checkArgument(dataType2 == DataType.UINT8 || dataType2 == DataType.FLOAT32, "Illegal data type for TensorImage: Only FLOAT32 and UINT8 are accepted");
        this.dataType = dataType2;
    }

    public static TensorImage fromBitmap(Bitmap bitmap) {
        TensorImage tensorImage = new TensorImage();
        tensorImage.load(bitmap);
        return tensorImage;
    }

    public static TensorImage createFrom(TensorImage tensorImage, DataType dataType2) {
        TensorImage tensorImage2 = new TensorImage(dataType2);
        tensorImage2.container = tensorImage.container.clone();
        return tensorImage2;
    }

    public void load(Bitmap bitmap) {
        this.container = BitmapContainer.create(bitmap);
    }

    public void load(float[] fArr, int[] iArr) {
        TensorBuffer createDynamic = TensorBuffer.createDynamic(getDataType());
        createDynamic.loadArray(fArr, iArr);
        load(createDynamic);
    }

    public void load(int[] iArr, int[] iArr2) {
        TensorBuffer createDynamic = TensorBuffer.createDynamic(getDataType());
        createDynamic.loadArray(iArr, iArr2);
        load(createDynamic);
    }

    public void load(TensorBuffer tensorBuffer) {
        load(tensorBuffer, ColorSpaceType.RGB);
    }

    public void load(TensorBuffer tensorBuffer, ColorSpaceType colorSpaceType) {
        this.container = TensorBufferContainer.create(tensorBuffer, colorSpaceType);
    }

    public Bitmap getBitmap() {
        ImageContainer imageContainer = this.container;
        if (imageContainer != null) {
            return imageContainer.getBitmap();
        }
        throw new IllegalStateException("No image has been loaded yet.");
    }

    public ByteBuffer getBuffer() {
        return getTensorBuffer().getBuffer();
    }

    public TensorBuffer getTensorBuffer() {
        ImageContainer imageContainer = this.container;
        if (imageContainer != null) {
            return imageContainer.getTensorBuffer(this.dataType);
        }
        throw new IllegalStateException("No image has been loaded yet.");
    }

    public DataType getDataType() {
        return this.dataType;
    }

    public ColorSpaceType getColorSpaceType() {
        ImageContainer imageContainer = this.container;
        if (imageContainer != null) {
            return imageContainer.getColorSpaceType();
        }
        throw new IllegalStateException("No image has been loaded yet.");
    }

    public int getWidth() {
        ImageContainer imageContainer = this.container;
        if (imageContainer != null) {
            return imageContainer.getWidth();
        }
        throw new IllegalStateException("No image has been loaded yet.");
    }

    public int getHeight() {
        ImageContainer imageContainer = this.container;
        if (imageContainer != null) {
            return imageContainer.getHeight();
        }
        throw new IllegalStateException("No image has been loaded yet.");
    }
}
