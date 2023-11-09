package org.tensorflow.lite.support.image;

import android.graphics.Bitmap;
import java.util.Arrays;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public enum ColorSpaceType {
    RGB {
        private static final int CHANNEL_VALUE = 3;

        /* access modifiers changed from: package-private */
        public int getChannelValue() {
            return 3;
        }

        /* access modifiers changed from: package-private */
        public String getShapeInfoMessage() {
            return "The shape of a RGB image should be (h, w, c) or (1, h, w, c), and channels representing R, G, B in order. ";
        }

        /* access modifiers changed from: package-private */
        public Bitmap convertTensorBufferToBitmap(TensorBuffer tensorBuffer) {
            return ImageConversions.convertRgbTensorBufferToBitmap(tensorBuffer);
        }

        /* access modifiers changed from: package-private */
        public int[] getNormalizedShape(int[] iArr) {
            int length = iArr.length;
            if (length == 3) {
                return ColorSpaceType.insertValue(iArr, 0, 1);
            }
            if (length == 4) {
                return iArr;
            }
            throw new IllegalArgumentException(getShapeInfoMessage() + "The provided image shape is " + Arrays.toString(iArr));
        }

        /* access modifiers changed from: package-private */
        public Bitmap.Config toBitmapConfig() {
            return Bitmap.Config.ARGB_8888;
        }
    },
    GRAYSCALE {
        private static final int CHANNEL_VALUE = 1;

        /* access modifiers changed from: package-private */
        public int getChannelValue() {
            return 1;
        }

        /* access modifiers changed from: package-private */
        public String getShapeInfoMessage() {
            return "The shape of a grayscale image should be (h, w) or (1, h, w, 1). ";
        }

        /* access modifiers changed from: package-private */
        public Bitmap convertTensorBufferToBitmap(TensorBuffer tensorBuffer) {
            return ImageConversions.convertGrayscaleTensorBufferToBitmap(tensorBuffer);
        }

        /* access modifiers changed from: package-private */
        public int[] getNormalizedShape(int[] iArr) {
            int length = iArr.length;
            if (length == 2) {
                return ColorSpaceType.insertValue(ColorSpaceType.insertValue(iArr, 0, 1), 3, 1);
            }
            if (length == 4) {
                return iArr;
            }
            throw new IllegalArgumentException(getShapeInfoMessage() + "The provided image shape is " + Arrays.toString(iArr));
        }

        /* access modifiers changed from: package-private */
        public Bitmap.Config toBitmapConfig() {
            return Bitmap.Config.ALPHA_8;
        }
    };
    
    private static final int BATCH_DIM = 0;
    private static final int BATCH_VALUE = 1;
    private static final int CHANNEL_DIM = 3;
    private static final int HEIGHT_DIM = 1;
    private static final int WIDTH_DIM = 2;

    /* access modifiers changed from: package-private */
    public abstract Bitmap convertTensorBufferToBitmap(TensorBuffer tensorBuffer);

    /* access modifiers changed from: package-private */
    public abstract int getChannelValue();

    /* access modifiers changed from: package-private */
    public abstract int[] getNormalizedShape(int[] iArr);

    /* access modifiers changed from: package-private */
    public abstract String getShapeInfoMessage();

    /* access modifiers changed from: package-private */
    public abstract Bitmap.Config toBitmapConfig();

    /* renamed from: org.tensorflow.lite.support.image.ColorSpaceType$3 */
    /* synthetic */ class C60333 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$graphics$Bitmap$Config = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$Config     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.tensorflow.lite.support.image.ColorSpaceType.C60333.<clinit>():void");
        }
    }

    static ColorSpaceType fromBitmapConfig(Bitmap.Config config) {
        int i = C60333.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1) {
            return RGB;
        }
        if (i == 2) {
            return GRAYSCALE;
        }
        throw new IllegalArgumentException("Bitmap configuration: " + config + ", is not supported yet.");
    }

    /* access modifiers changed from: package-private */
    public void assertShape(int[] iArr) {
        boolean isValidNormalizedShape = isValidNormalizedShape(getNormalizedShape(iArr));
        SupportPreconditions.checkArgument(isValidNormalizedShape, getShapeInfoMessage() + "The provided image shape is " + Arrays.toString(iArr));
    }

    /* access modifiers changed from: package-private */
    public int getWidth(int[] iArr) {
        assertShape(iArr);
        return getNormalizedShape(iArr)[2];
    }

    /* access modifiers changed from: package-private */
    public int getHeight(int[] iArr) {
        assertShape(iArr);
        return getNormalizedShape(iArr)[1];
    }

    /* access modifiers changed from: private */
    public static int[] insertValue(int[] iArr, int i, int i2) {
        int length = iArr.length + 1;
        int[] iArr2 = new int[length];
        for (int i3 = 0; i3 < i; i3++) {
            iArr2[i3] = iArr[i3];
        }
        iArr2[i] = i2;
        while (true) {
            i++;
            if (i >= length) {
                return iArr2;
            }
            iArr2[i] = iArr[i - 1];
        }
    }

    /* access modifiers changed from: protected */
    public boolean isValidNormalizedShape(int[] iArr) {
        return iArr[0] == 1 && iArr[1] > 0 && iArr[2] > 0 && iArr[3] == getChannelValue();
    }
}
