package com.autel.internal.video.core.decoder2.common;

public enum FilterType {
    Normal(0),
    OverExposure(1),
    BlackAndWhite(2),
    UNKNOWN(3);
    
    private int filterCode;

    private FilterType(int i) {
        this.filterCode = i;
    }

    public int value() {
        return this.filterCode;
    }

    public static FilterType find(int i) {
        FilterType filterType = Normal;
        if (filterType.value() == i) {
            return filterType;
        }
        FilterType filterType2 = OverExposure;
        if (filterType2.value() == i) {
            return filterType2;
        }
        FilterType filterType3 = BlackAndWhite;
        if (filterType3.value() == i) {
            return filterType3;
        }
        return UNKNOWN;
    }
}
