package com.autel.common.camera.media;

import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.trillium.TrilliumPrefHandler;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum FocusDistance {
    Distance_100_METRIC(UIPreferenceFragment.DEFAULT_UI_SCALE, "127"),
    Distance_200_METRIC("200", "254"),
    Distance_300_METRIC("300", "381"),
    Distance_400_METRIC("400", "508"),
    Distance_500_METRIC(TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_VIDEO_BUFFERING, "635"),
    Distance_600_METRIC("600", "762"),
    Distance_700_METRIC("700", "889"),
    Distance_800_METRIC("800", "1016"),
    Distance_900_METRIC("900", "1143"),
    Distance_1000_METRIC("1000", "1270"),
    Distance_2000_METRIC("2000", "2540"),
    Distance_3000_METRIC("3000", "3810"),
    Distance_4000_METRIC("4000", "5080"),
    Distance_5000_METRIC("5000", "6350"),
    Distance_6000_METRIC("6000", "7620"),
    Distance_7000_METRIC("7000", "8890"),
    Distance_8000_METRIC("8000", "10160"),
    Distance_9000_METRIC("9000", "11430"),
    Distance_10000_METRIC("10000", "12700"),
    Distance_20000_METRIC("20000", "25400"),
    Distance_30000_METRIC("30000", "38100"),
    Distance_40000_METRIC("40000", "50800"),
    Distance_50000_METRIC("50000", "63500"),
    Distance_60000_METRIC("60000", "76200"),
    Distance_70000_METRIC("70000", "88900"),
    Distance_80000_METRIC("80000", "101600"),
    Distance_90000_METRIC("90000", "114300"),
    Distance_100000_METRIC("100000", "127000"),
    Distance_MAX_METRIC("-1", "-1"),
    UNKNOWN(SoloControllerUnits.UNKNOWN, SoloControllerUnits.UNKNOWN);
    
    private String imperialValue;
    private String metricValue;

    private FocusDistance(String str, String str2) {
        this.metricValue = str;
        this.imperialValue = str2;
    }

    public String getMetricValue() {
        return this.metricValue;
    }

    public String getImperialValue() {
        return this.imperialValue;
    }

    public static FocusDistance find(String str) {
        FocusDistance focusDistance = Distance_100_METRIC;
        if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
            focusDistance = Distance_200_METRIC;
            if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                focusDistance = Distance_300_METRIC;
                if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                    focusDistance = Distance_400_METRIC;
                    if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                        focusDistance = Distance_500_METRIC;
                        if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                            focusDistance = Distance_600_METRIC;
                            if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                focusDistance = Distance_700_METRIC;
                                if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                    focusDistance = Distance_800_METRIC;
                                    if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                        focusDistance = Distance_900_METRIC;
                                        if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                            focusDistance = Distance_1000_METRIC;
                                            if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                focusDistance = Distance_2000_METRIC;
                                                if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                    focusDistance = Distance_3000_METRIC;
                                                    if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                        focusDistance = Distance_4000_METRIC;
                                                        if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                            focusDistance = Distance_5000_METRIC;
                                                            if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                focusDistance = Distance_6000_METRIC;
                                                                if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                    focusDistance = Distance_7000_METRIC;
                                                                    if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                        focusDistance = Distance_8000_METRIC;
                                                                        if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                            focusDistance = Distance_9000_METRIC;
                                                                            if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                focusDistance = Distance_10000_METRIC;
                                                                                if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                    focusDistance = Distance_20000_METRIC;
                                                                                    if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                        focusDistance = Distance_30000_METRIC;
                                                                                        if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                            focusDistance = Distance_40000_METRIC;
                                                                                            if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                                focusDistance = Distance_50000_METRIC;
                                                                                                if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                                    focusDistance = Distance_60000_METRIC;
                                                                                                    if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                                        focusDistance = Distance_70000_METRIC;
                                                                                                        if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                                            focusDistance = Distance_80000_METRIC;
                                                                                                            if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                                                focusDistance = Distance_90000_METRIC;
                                                                                                                if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                                                    focusDistance = Distance_100000_METRIC;
                                                                                                                    if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                                                        focusDistance = Distance_MAX_METRIC;
                                                                                                                        if (!focusDistance.getMetricValue().equals(str) && !focusDistance.getImperialValue().equals(str)) {
                                                                                                                            return UNKNOWN;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return focusDistance;
    }
}
