package org.tensorflow.lite.task.vision.segmenter;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.task.core.BaseTaskApi;
import org.tensorflow.lite.task.core.TaskJniUtils;
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions;
import org.tensorflow.lite.task.vision.segmenter.AutoValue_ImageSegmenter_ImageSegmenterOptions;

public final class ImageSegmenter extends BaseTaskApi {
    private static final String IMAGE_SEGMENTER_NATIVE_LIB = "task_vision_jni";
    private static final int OPTIONAL_FD_LENGTH = -1;
    private static final int OPTIONAL_FD_OFFSET = -1;
    private final OutputType outputType;

    private native void deinitJni(long j);

    /* access modifiers changed from: private */
    public static native long initJniWithByteBuffer(ByteBuffer byteBuffer, String str, int i, int i2);

    /* access modifiers changed from: private */
    public static native long initJniWithModelFdAndOptions(int i, long j, long j2, String str, int i2, int i3);

    private static native void segmentNative(long j, ByteBuffer byteBuffer, int i, int i2, List<byte[]> list, int[] iArr, List<ColoredLabel> list2, int i3);

    public static ImageSegmenter createFromFile(Context context, String str) {
        return createFromFileAndOptions(context, str, ImageSegmenterOptions.builder().build());
    }

    public static ImageSegmenter createFromFile(File file) {
        return createFromFileAndOptions(file, ImageSegmenterOptions.builder().build());
    }

    public static ImageSegmenter createFromBuffer(ByteBuffer byteBuffer) {
        return createFromBufferAndOptions(byteBuffer, ImageSegmenterOptions.builder().build());
    }

    public static ImageSegmenter createFromFileAndOptions(Context context, String str, ImageSegmenterOptions imageSegmenterOptions) {
        AssetFileDescriptor openFd = context.getAssets().openFd(str);
        try {
            ImageSegmenter createFromModelFdAndOptions = createFromModelFdAndOptions(openFd.getParcelFileDescriptor().getFd(), openFd.getLength(), openFd.getStartOffset(), imageSegmenterOptions);
            if (openFd != null) {
                openFd.close();
            }
            return createFromModelFdAndOptions;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static ImageSegmenter createFromFileAndOptions(File file, ImageSegmenterOptions imageSegmenterOptions) {
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        try {
            ImageSegmenter createFromModelFdAndOptions = createFromModelFdAndOptions(open.getFd(), -1, -1, imageSegmenterOptions);
            if (open != null) {
                open.close();
            }
            return createFromModelFdAndOptions;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static ImageSegmenter createFromBufferAndOptions(final ByteBuffer byteBuffer, final ImageSegmenterOptions imageSegmenterOptions) {
        if (byteBuffer.isDirect() || (byteBuffer instanceof MappedByteBuffer)) {
            return new ImageSegmenter(TaskJniUtils.createHandleFromLibrary(new TaskJniUtils.EmptyHandleProvider() {
                public long createHandle() {
                    return ImageSegmenter.initJniWithByteBuffer(byteBuffer, imageSegmenterOptions.getDisplayNamesLocale(), imageSegmenterOptions.getOutputType().getValue(), imageSegmenterOptions.getNumThreads());
                }
            }, IMAGE_SEGMENTER_NATIVE_LIB), imageSegmenterOptions.getOutputType());
        }
        throw new IllegalArgumentException("The model buffer should be either a direct ByteBuffer or a MappedByteBuffer.");
    }

    private ImageSegmenter(long j, OutputType outputType2) {
        super(j);
        this.outputType = outputType2;
    }

    public static abstract class ImageSegmenterOptions {
        private static final String DEFAULT_DISPLAY_NAME_LOCALE = "en";
        private static final OutputType DEFAULT_OUTPUT_TYPE = OutputType.CATEGORY_MASK;
        private static final int NUM_THREADS = -1;

        public static abstract class Builder {
            public abstract ImageSegmenterOptions build();

            public abstract Builder setDisplayNamesLocale(String str);

            public abstract Builder setNumThreads(int i);

            public abstract Builder setOutputType(OutputType outputType);
        }

        public abstract String getDisplayNamesLocale();

        public abstract int getNumThreads();

        public abstract OutputType getOutputType();

        public static Builder builder() {
            return new AutoValue_ImageSegmenter_ImageSegmenterOptions.Builder().setDisplayNamesLocale(DEFAULT_DISPLAY_NAME_LOCALE).setOutputType(DEFAULT_OUTPUT_TYPE).setNumThreads(-1);
        }
    }

    public List<Segmentation> segment(TensorImage tensorImage) {
        return segment(tensorImage, ImageProcessingOptions.builder().build());
    }

    public List<Segmentation> segment(TensorImage tensorImage, ImageProcessingOptions imageProcessingOptions) {
        checkNotClosed();
        if (tensorImage.getDataType() != DataType.UINT8) {
            tensorImage = TensorImage.createFrom(tensorImage, DataType.UINT8);
        }
        ArrayList<byte[]> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int[] iArr = new int[2];
        segmentNative(getNativeHandle(), tensorImage.getBuffer(), tensorImage.getWidth(), tensorImage.getHeight(), arrayList, iArr, arrayList2, imageProcessingOptions.getOrientation().getValue());
        ArrayList arrayList3 = new ArrayList();
        for (byte[] wrap : arrayList) {
            ByteBuffer wrap2 = ByteBuffer.wrap(wrap);
            wrap2.order(ByteOrder.LITTLE_ENDIAN);
            arrayList3.add(wrap2);
        }
        OutputType outputType2 = this.outputType;
        return Arrays.asList(new Segmentation[]{Segmentation.create(outputType2, outputType2.createMasksFromBuffer(arrayList3, iArr), arrayList2)});
    }

    private static ImageSegmenter createFromModelFdAndOptions(int i, long j, long j2, ImageSegmenterOptions imageSegmenterOptions) {
        final int i2 = i;
        final long j3 = j;
        final long j4 = j2;
        final ImageSegmenterOptions imageSegmenterOptions2 = imageSegmenterOptions;
        return new ImageSegmenter(TaskJniUtils.createHandleFromLibrary(new TaskJniUtils.EmptyHandleProvider() {
            public long createHandle() {
                return ImageSegmenter.initJniWithModelFdAndOptions(i2, j3, j4, imageSegmenterOptions2.getDisplayNamesLocale(), imageSegmenterOptions2.getOutputType().getValue(), imageSegmenterOptions2.getNumThreads());
            }
        }, IMAGE_SEGMENTER_NATIVE_LIB), imageSegmenterOptions.getOutputType());
    }

    /* access modifiers changed from: protected */
    public void deinit(long j) {
        deinitJni(j);
    }
}
