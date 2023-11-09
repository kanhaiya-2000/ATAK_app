package com.autel.common.dsp.evo;

public enum BandMode {
    MODE_1_4G("1.4G"),
    MODE_2_4G("2.4G"),
    MODE_900M("900M"),
    MODE_2_4G_900M("2.4G_900M"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private BandMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static BandMode find(String str) {
        BandMode bandMode = MODE_1_4G;
        if (bandMode.getValue().equals(str)) {
            return bandMode;
        }
        BandMode bandMode2 = MODE_2_4G;
        if (bandMode2.getValue().equals(str)) {
            return bandMode2;
        }
        BandMode bandMode3 = MODE_900M;
        if (bandMode3.getValue().equals(str)) {
            return bandMode3;
        }
        BandMode bandMode4 = MODE_2_4G_900M;
        if (bandMode4.getValue().equals(str)) {
            return bandMode4;
        }
        return UNKNOWN;
    }
}
