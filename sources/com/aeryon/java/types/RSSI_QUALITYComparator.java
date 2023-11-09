package com.aeryon.java.types;

import java.util.Comparator;

class RSSI_QUALITYComparator implements Comparator<RSSI_QUALITY_LEVEL> {
    RSSI_QUALITYComparator() {
    }

    public int compare(RSSI_QUALITY_LEVEL rssi_quality_level, RSSI_QUALITY_LEVEL rssi_quality_level2) {
        return rssi_quality_level2.getRssiCutoff() - rssi_quality_level.getRssiCutoff();
    }
}
