package org.tensorflow.lite.task.vision.segmenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.support.image.TensorImage;

public abstract class Segmentation {
    public abstract List<ColoredLabel> getColoredLabels();

    public abstract List<TensorImage> getMasks();

    public abstract OutputType getOutputType();

    static Segmentation create(OutputType outputType, List<TensorImage> list, List<ColoredLabel> list2) {
        outputType.assertMasksMatchColoredLabels(list, list2);
        return new AutoValue_Segmentation(outputType, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)));
    }
}
