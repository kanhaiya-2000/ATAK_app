package com.autel.common.camera.XT706;

public enum ImageMode {
    MANUAL(0),
    AUTO1(1),
    AUTO2(2),
    UNKNOWN(-1);
    
    private final int value;

    private ImageMode(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }

    public static ImageMode find(int i) {
        ImageMode imageMode = MANUAL;
        if (imageMode.value() == i) {
            return imageMode;
        }
        ImageMode imageMode2 = AUTO1;
        if (imageMode2.value() == i) {
            return imageMode2;
        }
        ImageMode imageMode3 = AUTO2;
        if (imageMode3.value() == i) {
            return imageMode3;
        }
        return UNKNOWN;
    }
}
