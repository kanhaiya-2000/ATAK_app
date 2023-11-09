package org.tensorflow.lite.task.vision.classifier;

import android.content.Context;
import android.graphics.Rect;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.task.core.BaseTaskApi;
import org.tensorflow.lite.task.core.TaskJniUtils;
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions;

public final class ImageClassifier extends BaseTaskApi {
    private static final String IMAGE_CLASSIFIER_NATIVE_LIB = "task_vision_jni";
    private static final int OPTIONAL_FD_LENGTH = -1;
    private static final int OPTIONAL_FD_OFFSET = -1;

    private static native List<Classifications> classifyNative(long j, ByteBuffer byteBuffer, int i, int i2, int[] iArr, int i3);

    private native void deinitJni(long j);

    /* access modifiers changed from: private */
    public static native long initJniWithByteBuffer(ByteBuffer byteBuffer, ImageClassifierOptions imageClassifierOptions);

    /* access modifiers changed from: private */
    public static native long initJniWithModelFdAndOptions(int i, long j, long j2, ImageClassifierOptions imageClassifierOptions);

    public static ImageClassifier createFromFile(Context context, String str) {
        return createFromFileAndOptions(context, str, ImageClassifierOptions.builder().build());
    }

    public static ImageClassifier createFromFile(File file) {
        return createFromFileAndOptions(file, ImageClassifierOptions.builder().build());
    }

    public static ImageClassifier createFromBuffer(ByteBuffer byteBuffer) {
        return createFromBufferAndOptions(byteBuffer, ImageClassifierOptions.builder().build());
    }

    public static ImageClassifier createFromFileAndOptions(Context context, String str, ImageClassifierOptions imageClassifierOptions) {
        return new ImageClassifier(TaskJniUtils.createHandleFromFdAndOptions(context, new TaskJniUtils.FdAndOptionsHandleProvider<ImageClassifierOptions>() {
            public long createHandle(int i, long j, long j2, ImageClassifierOptions imageClassifierOptions) {
                return ImageClassifier.initJniWithModelFdAndOptions(i, j, j2, imageClassifierOptions);
            }
        }, IMAGE_CLASSIFIER_NATIVE_LIB, str, imageClassifierOptions));
    }

    public static ImageClassifier createFromFileAndOptions(File file, final ImageClassifierOptions imageClassifierOptions) {
        final ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        try {
            ImageClassifier imageClassifier = new ImageClassifier(TaskJniUtils.createHandleFromLibrary(new TaskJniUtils.EmptyHandleProvider() {
                public long createHandle() {
                    return ImageClassifier.initJniWithModelFdAndOptions(open.getFd(), -1, -1, imageClassifierOptions);
                }
            }, IMAGE_CLASSIFIER_NATIVE_LIB));
            if (open != null) {
                open.close();
            }
            return imageClassifier;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static ImageClassifier createFromBufferAndOptions(final ByteBuffer byteBuffer, final ImageClassifierOptions imageClassifierOptions) {
        if (byteBuffer.isDirect() || (byteBuffer instanceof MappedByteBuffer)) {
            return new ImageClassifier(TaskJniUtils.createHandleFromLibrary(new TaskJniUtils.EmptyHandleProvider() {
                public long createHandle() {
                    return ImageClassifier.initJniWithByteBuffer(byteBuffer, imageClassifierOptions);
                }
            }, IMAGE_CLASSIFIER_NATIVE_LIB));
        }
        throw new IllegalArgumentException("The model buffer should be either a direct ByteBuffer or a MappedByteBuffer.");
    }

    private ImageClassifier(long j) {
        super(j);
    }

    public static class ImageClassifierOptions {
        private final String displayNamesLocale;
        private final boolean isScoreThresholdSet;
        private final List<String> labelAllowList;
        private final List<String> labelDenyList;
        private final int maxResults;
        private final int numThreads;
        private final float scoreThreshold;

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            /* access modifiers changed from: private */
            public String displayNamesLocale;
            /* access modifiers changed from: private */
            public boolean isScoreThresholdSet;
            /* access modifiers changed from: private */
            public List<String> labelAllowList;
            /* access modifiers changed from: private */
            public List<String> labelDenyList;
            /* access modifiers changed from: private */
            public int maxResults;
            /* access modifiers changed from: private */
            public int numThreads;
            /* access modifiers changed from: private */
            public float scoreThreshold;

            private Builder() {
                this.displayNamesLocale = "en";
                this.maxResults = -1;
                this.isScoreThresholdSet = false;
                this.labelAllowList = new ArrayList();
                this.labelDenyList = new ArrayList();
                this.numThreads = -1;
            }

            public Builder setDisplayNamesLocale(String str) {
                this.displayNamesLocale = str;
                return this;
            }

            public Builder setMaxResults(int i) {
                if (i != 0) {
                    this.maxResults = i;
                    return this;
                }
                throw new IllegalArgumentException("maxResults cannot be 0.");
            }

            public Builder setScoreThreshold(float f) {
                this.scoreThreshold = f;
                this.isScoreThresholdSet = true;
                return this;
            }

            public Builder setLabelAllowList(List<String> list) {
                this.labelAllowList = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public Builder setLabelDenyList(List<String> list) {
                this.labelDenyList = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public Builder setNumThreads(int i) {
                this.numThreads = i;
                return this;
            }

            public ImageClassifierOptions build() {
                return new ImageClassifierOptions(this);
            }
        }

        public String getDisplayNamesLocale() {
            return this.displayNamesLocale;
        }

        public int getMaxResults() {
            return this.maxResults;
        }

        public float getScoreThreshold() {
            return this.scoreThreshold;
        }

        public boolean getIsScoreThresholdSet() {
            return this.isScoreThresholdSet;
        }

        public List<String> getLabelAllowList() {
            return new ArrayList(this.labelAllowList);
        }

        public List<String> getLabelDenyList() {
            return new ArrayList(this.labelDenyList);
        }

        public int getNumThreads() {
            return this.numThreads;
        }

        private ImageClassifierOptions(Builder builder) {
            this.displayNamesLocale = builder.displayNamesLocale;
            this.maxResults = builder.maxResults;
            this.scoreThreshold = builder.scoreThreshold;
            this.isScoreThresholdSet = builder.isScoreThresholdSet;
            this.labelAllowList = builder.labelAllowList;
            this.labelDenyList = builder.labelDenyList;
            this.numThreads = builder.numThreads;
        }
    }

    public List<Classifications> classify(TensorImage tensorImage) {
        return classify(tensorImage, ImageProcessingOptions.builder().build());
    }

    public List<Classifications> classify(TensorImage tensorImage, ImageProcessingOptions imageProcessingOptions) {
        Rect rect;
        checkNotClosed();
        if (tensorImage.getDataType() != DataType.UINT8) {
            tensorImage = TensorImage.createFrom(tensorImage, DataType.UINT8);
        }
        if (imageProcessingOptions.getRoi().isEmpty()) {
            rect = new Rect(0, 0, tensorImage.getWidth(), tensorImage.getHeight());
        } else {
            rect = imageProcessingOptions.getRoi();
        }
        return classifyNative(getNativeHandle(), tensorImage.getBuffer(), tensorImage.getWidth(), tensorImage.getHeight(), new int[]{rect.left, rect.top, rect.width(), rect.height()}, imageProcessingOptions.getOrientation().getValue());
    }

    /* access modifiers changed from: protected */
    public void deinit(long j) {
        deinitJni(j);
    }
}
