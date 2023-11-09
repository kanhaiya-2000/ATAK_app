package com.autel.sdk10.AutelNet.AutelFlyController.util;

public class SensitiveUtil {
    private static final double PARAM_A = 3.4375d;
    private static final double PARAM_B = 7.0625d;
    private static final double PARAM_C = 3.6719000339508057d;

    public static double coefficient2Sensitive(double d) {
        return (((PARAM_A * d) - PARAM_B) * d) + PARAM_C;
    }

    public static double sensitive2Coefficient(double d) {
        return (PARAM_B - Math.sqrt(Math.pow(PARAM_B, 2.0d) - ((PARAM_C - d) * 13.75d))) / 6.875d;
    }
}
