package org.tensorflow.lite.support.tensorbuffer;

import atakplugin.UASTool.civ;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.SupportPreconditions;

public abstract class TensorBuffer {
    protected ByteBuffer buffer;
    protected int flatSize = -1;
    protected final boolean isDynamic = true;
    protected int[] shape;

    public abstract DataType getDataType();

    @civ
    public abstract float[] getFloatArray();

    public abstract float getFloatValue(int i);

    @civ
    public abstract int[] getIntArray();

    public abstract int getIntValue(int i);

    public abstract int getTypeSize();

    public abstract void loadArray(@civ float[] fArr, @civ int[] iArr);

    public abstract void loadArray(@civ int[] iArr, @civ int[] iArr2);

    /* renamed from: org.tensorflow.lite.support.tensorbuffer.TensorBuffer$1 */
    /* synthetic */ class C60371 {
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
                org.tensorflow.lite.DataType r1 = org.tensorflow.lite.DataType.FLOAT32     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$tensorflow$lite$DataType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.tensorflow.lite.DataType r1 = org.tensorflow.lite.DataType.UINT8     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.tensorflow.lite.support.tensorbuffer.TensorBuffer.C60371.<clinit>():void");
        }
    }

    @civ
    public static TensorBuffer createFixedSize(@civ int[] iArr, DataType dataType) {
        int i = C60371.$SwitchMap$org$tensorflow$lite$DataType[dataType.ordinal()];
        if (i == 1) {
            return new TensorBufferFloat(iArr);
        }
        if (i == 2) {
            return new TensorBufferUint8(iArr);
        }
        throw new AssertionError("TensorBuffer does not support data type: " + dataType);
    }

    @civ
    public static TensorBuffer createDynamic(DataType dataType) {
        int i = C60371.$SwitchMap$org$tensorflow$lite$DataType[dataType.ordinal()];
        if (i == 1) {
            return new TensorBufferFloat();
        }
        if (i == 2) {
            return new TensorBufferUint8();
        }
        throw new AssertionError("TensorBuffer does not support data type: " + dataType);
    }

    @civ
    public static TensorBuffer createFrom(@civ TensorBuffer tensorBuffer, DataType dataType) {
        TensorBuffer tensorBuffer2;
        SupportPreconditions.checkNotNull(tensorBuffer, "Cannot create a buffer from null");
        if (tensorBuffer.isDynamic()) {
            tensorBuffer2 = createDynamic(dataType);
        } else {
            tensorBuffer2 = createFixedSize(tensorBuffer.shape, dataType);
        }
        if (tensorBuffer.getDataType() == DataType.FLOAT32 && dataType == DataType.FLOAT32) {
            tensorBuffer2.loadArray(tensorBuffer.getFloatArray(), tensorBuffer.shape);
        } else {
            tensorBuffer2.loadArray(tensorBuffer.getIntArray(), tensorBuffer.shape);
        }
        return tensorBuffer2;
    }

    @civ
    public ByteBuffer getBuffer() {
        return this.buffer;
    }

    public int getFlatSize() {
        assertShapeIsCorect();
        return this.flatSize;
    }

    @civ
    public int[] getShape() {
        assertShapeIsCorect();
        int[] iArr = this.shape;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public boolean isDynamic() {
        return this.isDynamic;
    }

    public void loadArray(@civ int[] iArr) {
        loadArray(iArr, this.shape);
    }

    public void loadArray(@civ float[] fArr) {
        loadArray(fArr, this.shape);
    }

    public void loadBuffer(@civ ByteBuffer byteBuffer, @civ int[] iArr) {
        SupportPreconditions.checkNotNull(byteBuffer, "Byte buffer cannot be null.");
        SupportPreconditions.checkArgument(byteBuffer.limit() == getTypeSize() * computeFlatSize(iArr), "The size of byte buffer and the shape do not match.");
        resize(iArr);
        byteBuffer.rewind();
        this.buffer = byteBuffer;
    }

    public void loadBuffer(@civ ByteBuffer byteBuffer) {
        loadBuffer(byteBuffer, this.shape);
    }

    protected TensorBuffer(@civ int[] iArr) {
        allocateMemory(iArr);
    }

    protected TensorBuffer() {
        allocateMemory(new int[]{0});
    }

    protected static int computeFlatSize(@civ int[] iArr) {
        SupportPreconditions.checkNotNull(iArr, "Shape cannot be null.");
        int i = 1;
        for (int i2 : iArr) {
            i *= i2;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void resize(@civ int[] iArr) {
        if (this.isDynamic) {
            allocateMemory(iArr);
            return;
        }
        SupportPreconditions.checkArgument(Arrays.equals(iArr, this.shape));
        this.shape = (int[]) iArr.clone();
    }

    private void allocateMemory(@civ int[] iArr) {
        SupportPreconditions.checkNotNull(iArr, "TensorBuffer shape cannot be null.");
        SupportPreconditions.checkArgument(isShapeValid(iArr), "Values in TensorBuffer shape should be non-negative.");
        int computeFlatSize = computeFlatSize(iArr);
        this.shape = (int[]) iArr.clone();
        if (this.flatSize != computeFlatSize) {
            this.flatSize = computeFlatSize;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(computeFlatSize * getTypeSize());
            this.buffer = allocateDirect;
            allocateDirect.order(ByteOrder.nativeOrder());
        }
    }

    private void assertShapeIsCorect() {
        SupportPreconditions.checkState(this.buffer.limit() == getTypeSize() * computeFlatSize(this.shape), String.format("The size of underlying ByteBuffer (%d) and the shape (%s) do not match. The ByteBuffer may have been changed.", new Object[]{Integer.valueOf(this.buffer.limit()), Arrays.toString(this.shape)}));
    }

    private static boolean isShapeValid(@civ int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        for (int i : iArr) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
