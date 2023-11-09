package org.tensorflow.lite.task.core.vision;

import android.graphics.Rect;
import java.util.Objects;
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions;

final class AutoValue_ImageProcessingOptions extends ImageProcessingOptions {
    private final ImageProcessingOptions.Orientation orientation;
    private final Rect roi;

    private AutoValue_ImageProcessingOptions(Rect rect, ImageProcessingOptions.Orientation orientation2) {
        this.roi = rect;
        this.orientation = orientation2;
    }

    public Rect getRoi() {
        return this.roi;
    }

    public ImageProcessingOptions.Orientation getOrientation() {
        return this.orientation;
    }

    public String toString() {
        return "ImageProcessingOptions{roi=" + this.roi + ", orientation=" + this.orientation + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageProcessingOptions)) {
            return false;
        }
        ImageProcessingOptions imageProcessingOptions = (ImageProcessingOptions) obj;
        if (!this.roi.equals(imageProcessingOptions.getRoi()) || !this.orientation.equals(imageProcessingOptions.getOrientation())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.roi.hashCode() ^ 1000003) * 1000003) ^ this.orientation.hashCode();
    }

    static final class Builder extends ImageProcessingOptions.Builder {
        private ImageProcessingOptions.Orientation orientation;
        private Rect roi;

        Builder() {
        }

        public ImageProcessingOptions.Builder setRoi(Rect rect) {
            Objects.requireNonNull(rect, "Null roi");
            this.roi = rect;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Rect getRoi() {
            Rect rect = this.roi;
            if (rect != null) {
                return rect;
            }
            throw new IllegalStateException("Property \"roi\" has not been set");
        }

        public ImageProcessingOptions.Builder setOrientation(ImageProcessingOptions.Orientation orientation2) {
            Objects.requireNonNull(orientation2, "Null orientation");
            this.orientation = orientation2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public ImageProcessingOptions autoBuild() {
            String str = "";
            if (this.roi == null) {
                str = str + " roi";
            }
            if (this.orientation == null) {
                str = str + " orientation";
            }
            if (str.isEmpty()) {
                return new AutoValue_ImageProcessingOptions(this.roi, this.orientation);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
