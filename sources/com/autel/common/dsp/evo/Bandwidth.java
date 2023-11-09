package com.autel.common.dsp.evo;

public enum Bandwidth {
    WIDTH_3M("3M"),
    WIDTH_5M("5M"),
    WIDTH_10M("10M"),
    WIDTH_20M("20M"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private Bandwidth(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static Bandwidth find(String str) {
        Bandwidth bandwidth = WIDTH_3M;
        if (bandwidth.getValue().equals(str)) {
            return bandwidth;
        }
        Bandwidth bandwidth2 = WIDTH_5M;
        if (bandwidth2.getValue().equals(str)) {
            return bandwidth2;
        }
        Bandwidth bandwidth3 = WIDTH_10M;
        if (bandwidth3.getValue().equals(str)) {
            return bandwidth3;
        }
        Bandwidth bandwidth4 = WIDTH_20M;
        if (bandwidth4.getValue().equals(str)) {
            return bandwidth4;
        }
        return UNKNOWN;
    }
}
