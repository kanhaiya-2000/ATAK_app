package org.tensorflow.lite.support.image;

import android.graphics.RectF;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public final class BoundingBoxUtil {

    public enum CoordinateType {
        RATIO,
        PIXEL
    }

    public enum Type {
        BOUNDARIES,
        UPPER_LEFT,
        CENTER
    }

    public static List<RectF> convert(TensorBuffer tensorBuffer, int[] iArr, int i, Type type, CoordinateType coordinateType, int i2, int i3) {
        int[] iArr2 = iArr;
        int i4 = i;
        int[] shape = tensorBuffer.getShape();
        SupportPreconditions.checkArgument(i4 >= (-shape.length) && i4 < shape.length, String.format("Axis %d is not in range (-(D+1), D), where D is the number of dimensions of input tensor (shape=%s)", new Object[]{Integer.valueOf(i), Arrays.toString(shape)}));
        if (i4 < 0) {
            i4 += shape.length;
        }
        SupportPreconditions.checkArgument(shape[i4] == 4, String.format("Size of bounding box dimension %d is not 4. Got %d in shape %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(shape[i4]), Arrays.toString(shape)}));
        SupportPreconditions.checkArgument(iArr2.length == 4, String.format("Bounding box index array length %d is not 4. Got index array %s", new Object[]{Integer.valueOf(iArr2.length), Arrays.toString(iArr)}));
        boolean z = tensorBuffer.getDataType() == DataType.FLOAT32;
        SupportPreconditions.checkArgument(z, "Bounding Boxes only create from FLOAT32 buffers. Got: " + tensorBuffer.getDataType().name());
        ArrayList arrayList = new ArrayList();
        int i5 = 1;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 *= shape[i6];
        }
        int i7 = 1;
        for (int i8 = i4 + 1; i8 < shape.length; i8++) {
            i7 *= shape[i8];
        }
        float[] fArr = new float[4];
        ByteBuffer buffer = tensorBuffer.getBuffer();
        buffer.rewind();
        FloatBuffer asFloatBuffer = buffer.asFloatBuffer();
        for (int i9 = 0; i9 < i5; i9++) {
            for (int i10 = 0; i10 < i7; i10++) {
                for (int i11 = 0; i11 < 4; i11++) {
                    fArr[i11] = asFloatBuffer.get((((i9 * 4) + i11) * i7) + i10);
                }
                arrayList.add(convertOneBoundingBox(fArr, iArr, type, coordinateType, i2, i3));
            }
        }
        buffer.rewind();
        return arrayList;
    }

    private static RectF convertOneBoundingBox(float[] fArr, int[] iArr, Type type, CoordinateType coordinateType, int i, int i2) {
        float[] fArr2 = new float[4];
        for (int i3 = 0; i3 < 4; i3++) {
            fArr2[i3] = fArr[iArr[i3]];
        }
        return convertOneBoundingBox(fArr2, type, coordinateType, i, i2);
    }

    /* renamed from: org.tensorflow.lite.support.image.BoundingBoxUtil$1 */
    /* synthetic */ class C60301 {

        /* renamed from: $SwitchMap$org$tensorflow$lite$support$image$BoundingBoxUtil$Type */
        static final /* synthetic */ int[] f8656xf6ea506c;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.tensorflow.lite.support.image.BoundingBoxUtil$Type[] r0 = org.tensorflow.lite.support.image.BoundingBoxUtil.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8656xf6ea506c = r0
                org.tensorflow.lite.support.image.BoundingBoxUtil$Type r1 = org.tensorflow.lite.support.image.BoundingBoxUtil.Type.BOUNDARIES     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8656xf6ea506c     // Catch:{ NoSuchFieldError -> 0x001d }
                org.tensorflow.lite.support.image.BoundingBoxUtil$Type r1 = org.tensorflow.lite.support.image.BoundingBoxUtil.Type.UPPER_LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8656xf6ea506c     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.tensorflow.lite.support.image.BoundingBoxUtil$Type r1 = org.tensorflow.lite.support.image.BoundingBoxUtil.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.tensorflow.lite.support.image.BoundingBoxUtil.C60301.<clinit>():void");
        }
    }

    private static RectF convertOneBoundingBox(float[] fArr, Type type, CoordinateType coordinateType, int i, int i2) {
        int i3 = C60301.f8656xf6ea506c[type.ordinal()];
        if (i3 == 1) {
            return convertFromBoundaries(fArr, coordinateType, i, i2);
        }
        if (i3 == 2) {
            return convertFromUpperLeft(fArr, coordinateType, i, i2);
        }
        if (i3 == 3) {
            return convertFromCenter(fArr, coordinateType, i, i2);
        }
        throw new IllegalArgumentException("Cannot recognize BoundingBox.Type " + type);
    }

    private static RectF convertFromBoundaries(float[] fArr, CoordinateType coordinateType, int i, int i2) {
        return getRectF(fArr[0], fArr[1], fArr[2], fArr[3], i, i2, coordinateType);
    }

    private static RectF convertFromUpperLeft(float[] fArr, CoordinateType coordinateType, int i, int i2) {
        return getRectF(fArr[0], fArr[1], fArr[0] + fArr[2], fArr[1] + fArr[3], i, i2, coordinateType);
    }

    private static RectF convertFromCenter(float[] fArr, CoordinateType coordinateType, int i, int i2) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2] / 2.0f;
        float f4 = fArr[3] / 2.0f;
        return getRectF(f - f3, f2 - f4, f + f3, f2 + f4, i, i2, coordinateType);
    }

    private static RectF getRectF(float f, float f2, float f3, float f4, int i, int i2, CoordinateType coordinateType) {
        if (coordinateType == CoordinateType.PIXEL) {
            return new RectF(f, f2, f3, f4);
        }
        if (coordinateType == CoordinateType.RATIO) {
            float f5 = (float) i2;
            float f6 = (float) i;
            return new RectF(f * f5, f2 * f6, f3 * f5, f4 * f6);
        }
        throw new IllegalArgumentException("Cannot convert coordinate type " + coordinateType);
    }

    private BoundingBoxUtil() {
    }
}
