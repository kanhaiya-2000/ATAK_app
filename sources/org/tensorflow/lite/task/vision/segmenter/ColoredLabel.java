package org.tensorflow.lite.task.vision.segmenter;

import android.graphics.Color;

public abstract class ColoredLabel {
    public abstract int getArgb();

    public abstract String getDisplayName();

    public abstract String getlabel();

    public static ColoredLabel create(String str, String str2, int i) {
        return new AutoValue_ColoredLabel(str, str2, i);
    }

    public static ColoredLabel create(String str, String str2, Color color) {
        return new AutoValue_ColoredLabel(str, str2, color.toArgb());
    }

    public Color getColor() {
        return Color.valueOf(getArgb());
    }
}
