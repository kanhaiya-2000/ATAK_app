package org.tensorflow.lite.task.vision.detector;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.support.label.Category;

public abstract class Detection {
    public abstract RectF getBoundingBox();

    public abstract List<Category> getCategories();

    public static Detection create(RectF rectF, List<Category> list) {
        return new AutoValue_Detection(new RectF(rectF), Collections.unmodifiableList(new ArrayList(list)));
    }
}
