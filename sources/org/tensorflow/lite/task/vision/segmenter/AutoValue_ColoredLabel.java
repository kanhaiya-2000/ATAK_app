package org.tensorflow.lite.task.vision.segmenter;

import java.util.Objects;

final class AutoValue_ColoredLabel extends ColoredLabel {
    private final int argb;
    private final String displayName;
    private final String label;

    AutoValue_ColoredLabel(String str, String str2, int i) {
        Objects.requireNonNull(str, "Null label");
        this.label = str;
        Objects.requireNonNull(str2, "Null displayName");
        this.displayName = str2;
        this.argb = i;
    }

    public String getlabel() {
        return this.label;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getArgb() {
        return this.argb;
    }

    public String toString() {
        return "ColoredLabel{label=" + this.label + ", displayName=" + this.displayName + ", argb=" + this.argb + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ColoredLabel)) {
            return false;
        }
        ColoredLabel coloredLabel = (ColoredLabel) obj;
        if (!this.label.equals(coloredLabel.getlabel()) || !this.displayName.equals(coloredLabel.getDisplayName()) || this.argb != coloredLabel.getArgb()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.label.hashCode() ^ 1000003) * 1000003) ^ this.displayName.hashCode()) * 1000003) ^ this.argb;
    }
}
