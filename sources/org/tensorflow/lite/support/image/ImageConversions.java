package org.tensorflow.lite.support.image;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

class ImageConversions {
    static Bitmap convertRgbTensorBufferToBitmap(TensorBuffer tensorBuffer) {
        int[] shape = tensorBuffer.getShape();
        ColorSpaceType colorSpaceType = ColorSpaceType.RGB;
        colorSpaceType.assertShape(shape);
        int height = colorSpaceType.getHeight(shape);
        int width = colorSpaceType.getWidth(shape);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, colorSpaceType.toBitmapConfig());
        int i = width * height;
        int[] iArr = new int[i];
        int[] intArray = tensorBuffer.getIntArray();
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            iArr[i2] = Color.rgb(intArray[i3], intArray[i4], intArray[i5]);
            i2++;
            i3 = i5 + 1;
        }
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    static Bitmap convertGrayscaleTensorBufferToBitmap(TensorBuffer tensorBuffer) {
        if (tensorBuffer.getDataType() != DataType.UINT8) {
            tensorBuffer = TensorBuffer.createFrom(tensorBuffer, DataType.UINT8);
        }
        int[] shape = tensorBuffer.getShape();
        ColorSpaceType colorSpaceType = ColorSpaceType.GRAYSCALE;
        colorSpaceType.assertShape(shape);
        Bitmap createBitmap = Bitmap.createBitmap(colorSpaceType.getWidth(shape), colorSpaceType.getHeight(shape), colorSpaceType.toBitmapConfig());
        tensorBuffer.getBuffer().rewind();
        createBitmap.copyPixelsFromBuffer(tensorBuffer.getBuffer());
        return createBitmap;
    }

    static void convertBitmapToTensorBuffer(Bitmap bitmap, TensorBuffer tensorBuffer) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        int i2 = 0;
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = i * 3;
        int[] iArr2 = {height, width, 3};
        int i4 = C60341.$SwitchMap$org$tensorflow$lite$DataType[tensorBuffer.getDataType().ordinal()];
        if (i4 == 1) {
            byte[] bArr = new byte[i3];
            int i5 = 0;
            while (i2 < i) {
                int i6 = i5 + 1;
                bArr[i5] = (byte) ((iArr[i2] >> 16) & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((iArr[i2] >> 8) & 255);
                bArr[i7] = (byte) (iArr[i2] & 255);
                i2++;
                i5 = i7 + 1;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3);
            allocateDirect.order(ByteOrder.nativeOrder());
            allocateDirect.put(bArr);
            tensorBuffer.loadBuffer(allocateDirect, iArr2);
        } else if (i4 == 2) {
            float[] fArr = new float[i3];
            int i8 = 0;
            while (i2 < i) {
                int i9 = i8 + 1;
                fArr[i8] = (float) ((iArr[i2] >> 16) & 255);
                int i10 = i9 + 1;
                fArr[i9] = (float) ((iArr[i2] >> 8) & 255);
                fArr[i10] = (float) (iArr[i2] & 255);
                i2++;
                i8 = i10 + 1;
            }
            tensorBuffer.loadArray(fArr, iArr2);
        } else {
            throw new IllegalStateException("The type of TensorBuffer, " + tensorBuffer.getBuffer() + ", is unsupported.");
        }
    }

    /* renamed from: org.tensorflow.lite.support.image.ImageConversions$1 */
    /* synthetic */ class C60341 {
        static final /* synthetic */ int[] $SwitchMap$org$tensorflow$lite$DataType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.tensorflow.lite.DataType[] r0 = org.tensorflow.lite.DataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$tensorflow$lite$DataType = r0
                org.tensorflow.lite.DataType r1 = org.tensorflow.lite.DataType.UINT8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$tensorflow$lite$DataType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.tensorflow.lite.DataType r1 = org.tensorflow.lite.DataType.FLOAT32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.tensorflow.lite.support.image.ImageConversions.C60341.<clinit>():void");
        }
    }

    private ImageConversions() {
    }
}
