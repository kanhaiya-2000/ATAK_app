package com.aeryon.java.types;

import java.util.SortedSet;
import java.util.TreeSet;

public enum RSSI_QUALITY_LEVEL {
    GREAT("Great", -49),
    GOOD("Good", -59),
    FAIR("Fair", -69),
    POOR("Poor", Integer.MIN_VALUE);
    
    private static SortedSet<RSSI_QUALITY_LEVEL> set;
    private int rssi;
    private String text;

    static {
        int i;
        set = new TreeSet(new RSSI_QUALITYComparator());
        for (RSSI_QUALITY_LEVEL add : values()) {
            set.add(add);
        }
    }

    private RSSI_QUALITY_LEVEL(String str, int i) {
        this.text = str;
        this.rssi = i;
    }

    public int getRssiCutoff() {
        return this.rssi;
    }

    public String getText() {
        return this.text;
    }

    public static RSSI_QUALITY_LEVEL getRSSIQuality(int i) {
        RSSI_QUALITY_LEVEL rssi_quality_level = POOR;
        for (RSSI_QUALITY_LEVEL rssi_quality_level2 : set) {
            if (i >= rssi_quality_level2.getRssiCutoff()) {
                return rssi_quality_level2;
            }
        }
        return rssi_quality_level;
    }
}
