package com.atakmap.android.uastool.overlays;

class OverlayOption {
    private final String name;
    private boolean value;

    OverlayOption(String str, boolean z) {
        this.name = str;
        this.value = z;
    }

    public String getName() {
        return this.name;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean z) {
        this.value = z;
    }
}
