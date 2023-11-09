package org.tensorflow.lite.task.vision.segmenter;

import java.util.List;
import java.util.Objects;
import org.tensorflow.lite.support.image.TensorImage;

final class AutoValue_Segmentation extends Segmentation {
    private final List<ColoredLabel> coloredLabels;
    private final List<TensorImage> masks;
    private final OutputType outputType;

    AutoValue_Segmentation(OutputType outputType2, List<TensorImage> list, List<ColoredLabel> list2) {
        Objects.requireNonNull(outputType2, "Null outputType");
        this.outputType = outputType2;
        Objects.requireNonNull(list, "Null masks");
        this.masks = list;
        Objects.requireNonNull(list2, "Null coloredLabels");
        this.coloredLabels = list2;
    }

    public OutputType getOutputType() {
        return this.outputType;
    }

    public List<TensorImage> getMasks() {
        return this.masks;
    }

    public List<ColoredLabel> getColoredLabels() {
        return this.coloredLabels;
    }

    public String toString() {
        return "Segmentation{outputType=" + this.outputType + ", masks=" + this.masks + ", coloredLabels=" + this.coloredLabels + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Segmentation)) {
            return false;
        }
        Segmentation segmentation = (Segmentation) obj;
        if (!this.outputType.equals(segmentation.getOutputType()) || !this.masks.equals(segmentation.getMasks()) || !this.coloredLabels.equals(segmentation.getColoredLabels())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.outputType.hashCode() ^ 1000003) * 1000003) ^ this.masks.hashCode()) * 1000003) ^ this.coloredLabels.hashCode();
    }
}
