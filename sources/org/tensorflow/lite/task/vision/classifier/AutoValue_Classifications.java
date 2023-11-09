package org.tensorflow.lite.task.vision.classifier;

import java.util.List;
import java.util.Objects;
import org.tensorflow.lite.support.label.Category;

final class AutoValue_Classifications extends Classifications {
    private final List<Category> categories;
    private final int headIndex;

    AutoValue_Classifications(List<Category> list, int i) {
        Objects.requireNonNull(list, "Null categories");
        this.categories = list;
        this.headIndex = i;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public int getHeadIndex() {
        return this.headIndex;
    }

    public String toString() {
        return "Classifications{categories=" + this.categories + ", headIndex=" + this.headIndex + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Classifications)) {
            return false;
        }
        Classifications classifications = (Classifications) obj;
        if (!this.categories.equals(classifications.getCategories()) || this.headIndex != classifications.getHeadIndex()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.categories.hashCode() ^ 1000003) * 1000003) ^ this.headIndex;
    }
}
