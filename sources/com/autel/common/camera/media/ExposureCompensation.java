package com.autel.common.camera.media;

import indago.serialization.JsonValueConstants;

public enum ExposureCompensation {
    POSITIVE_3p0("+3.0", "3.0"),
    POSITIVE_2p7("+2.7", "2.7"),
    POSITIVE_2p3("+2.3", "2.3"),
    POSITIVE_2p0("+2.0", "2.0"),
    POSITIVE_1p7("+1.7", "1.7"),
    POSITIVE_1p3("+1.3", "1.3"),
    POSITIVE_1p0("+1.0", "1.0"),
    POSITIVE_0p7("+0.7", "0.7"),
    POSITIVE_0p3("+0.3", "0.3"),
    POSITIVE_0("±0", JsonValueConstants.VERSION),
    NEGATIVE_0p3("-0.3", "-0.3"),
    NEGATIVE_0p7("-0.7", "-0.7"),
    NEGATIVE_1p0("-1.0", "-1.0"),
    NEGATIVE_1p3("-1.3", "-1.3"),
    NEGATIVE_1p7("-1.7", "-1.7"),
    NEGATIVE_2p0("-2.0", "-2.0"),
    NEGATIVE_2p3("-2.3", "-2.3"),
    NEGATIVE_2p7("-2.7", "-2.7"),
    NEGATIVE_3p0("-3.0", "-3.0"),
    UNKNOWN("", "");
    
    private String value;
    private String value20;

    private ExposureCompensation(String str, String str2) {
        this.value = str;
        this.value20 = str2;
    }

    public String getValue() {
        return this.value;
    }

    public String getValue20() {
        return this.value20;
    }

    public static ExposureCompensation find(String str) {
        ExposureCompensation exposureCompensation = POSITIVE_3p0;
        if (exposureCompensation.getValue().equals(str) || exposureCompensation.getValue20().equals(str)) {
            return exposureCompensation;
        }
        ExposureCompensation exposureCompensation2 = POSITIVE_2p7;
        if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
            exposureCompensation2 = POSITIVE_2p3;
            if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                exposureCompensation2 = POSITIVE_2p0;
                if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                    exposureCompensation2 = POSITIVE_1p7;
                    if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                        exposureCompensation2 = POSITIVE_1p3;
                        if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                            exposureCompensation2 = POSITIVE_1p0;
                            if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                exposureCompensation2 = POSITIVE_0p7;
                                if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                    exposureCompensation2 = POSITIVE_0p3;
                                    if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                        exposureCompensation2 = POSITIVE_0;
                                        if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                            exposureCompensation2 = NEGATIVE_0p3;
                                            if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                                exposureCompensation2 = NEGATIVE_0p7;
                                                if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                                    exposureCompensation2 = NEGATIVE_1p0;
                                                    if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                                        exposureCompensation2 = NEGATIVE_1p3;
                                                        if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                                            exposureCompensation2 = NEGATIVE_1p7;
                                                            if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                                                exposureCompensation2 = NEGATIVE_2p0;
                                                                if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                                                    exposureCompensation2 = NEGATIVE_2p3;
                                                                    if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                                                        exposureCompensation2 = NEGATIVE_2p7;
                                                                        if (!exposureCompensation2.getValue().equals(str) && !exposureCompensation2.getValue20().equals(str)) {
                                                                            exposureCompensation2 = NEGATIVE_3p0;
                                                                            return (exposureCompensation2.getValue().equals(str) || exposureCompensation2.getValue20().equals(str)) ? exposureCompensation2 : exposureCompensation;
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
