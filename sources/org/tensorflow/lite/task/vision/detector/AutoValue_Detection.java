package org.tensorflow.lite.task.vision.detector;

import android.graphics.RectF;
import java.util.List;
import java.util.Objects;
import org.tensorflow.lite.support.label.Category;

final class AutoValue_Detection extends Detection {
    private final RectF boundingBox;
    private final List<Category> categories;

    AutoValue_Detection(RectF rectF, List<Category> list) {
        Objects.requireNonNull(rectF, "Null boundingBox");
        this.boundingBox = rectF;
        Objects.requireNonNull(list, "Null categories");
        this.categories = list;
    }

    public RectF getBoundingBox() {
        return this.boundingBox;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public String toString() {
        return "Detection{boundingBox=" + this.boundingBox + ", categories=" + this.categories + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Detection)) {
            return false;
        }
        Detection detection = (Detection) obj;
        if (!this.boundingBox.equals(detection.getBoundingBox()) || !this.categories.equals(detection.getCategories())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.boundingBox.hashCode() ^ 1000003) * 1000003) ^ this.categories.hashCode();
    }
}
