package org.tensorflow.lite.task.vision.segmenter;

import java.util.Objects;
import org.tensorflow.lite.task.vision.segmenter.ImageSegmenter;

final class AutoValue_ImageSegmenter_ImageSegmenterOptions extends ImageSegmenter.ImageSegmenterOptions {
    private final String displayNamesLocale;
    private final int numThreads;
    private final OutputType outputType;

    private AutoValue_ImageSegmenter_ImageSegmenterOptions(String str, OutputType outputType2, int i) {
        this.displayNamesLocale = str;
        this.outputType = outputType2;
        this.numThreads = i;
    }

    public String getDisplayNamesLocale() {
        return this.displayNamesLocale;
    }

    public OutputType getOutputType() {
        return this.outputType;
    }

    public int getNumThreads() {
        return this.numThreads;
    }

    public String toString() {
        return "ImageSegmenterOptions{displayNamesLocale=" + this.displayNamesLocale + ", outputType=" + this.outputType + ", numThreads=" + this.numThreads + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageSegmenter.ImageSegmenterOptions)) {
            return false;
        }
        ImageSegmenter.ImageSegmenterOptions imageSegmenterOptions = (ImageSegmenter.ImageSegmenterOptions) obj;
        if (!this.displayNamesLocale.equals(imageSegmenterOptions.getDisplayNamesLocale()) || !this.outputType.equals(imageSegmenterOptions.getOutputType()) || this.numThreads != imageSegmenterOptions.getNumThreads()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.displayNamesLocale.hashCode() ^ 1000003) * 1000003) ^ this.outputType.hashCode()) * 1000003) ^ this.numThreads;
    }

    static final class Builder extends ImageSegmenter.ImageSegmenterOptions.Builder {
        private String displayNamesLocale;
        private Integer numThreads;
        private OutputType outputType;

        Builder() {
        }

        public ImageSegmenter.ImageSegmenterOptions.Builder setDisplayNamesLocale(String str) {
            Objects.requireNonNull(str, "Null displayNamesLocale");
            this.displayNamesLocale = str;
            return this;
        }

        public ImageSegmenter.ImageSegmenterOptions.Builder setOutputType(OutputType outputType2) {
            Objects.requireNonNull(outputType2, "Null outputType");
            this.outputType = outputType2;
            return this;
        }

        public ImageSegmenter.ImageSegmenterOptions.Builder setNumThreads(int i) {
            this.numThreads = Integer.valueOf(i);
            return this;
        }

        public ImageSegmenter.ImageSegmenterOptions build() {
            String str = "";
            if (this.displayNamesLocale == null) {
                str = str + " displayNamesLocale";
            }
            if (this.outputType == null) {
                str = str + " outputType";
            }
            if (this.numThreads == null) {
                str = str + " numThreads";
            }
            if (str.isEmpty()) {
                return new AutoValue_ImageSegmenter_ImageSegmenterOptions(this.displayNamesLocale, this.outputType, this.numThreads.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
