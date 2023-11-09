package com.autel.AutelNet2.aircraft.flycontroller.util;

public class SensitiveUtil2 {
    private static final float PARAM_A = 3.4375f;
    private static final float PARAM_B = 7.0625f;
    private static final float PARAM_C = 3.6719f;

    public static float coefficient2Sensitive(float f) {
        return (((PARAM_A * f) - PARAM_B) * f) + PARAM_C;
    }

    public static double sensitive2Coefficient(float f) {
        return (7.0625d - Math.sqrt(Math.pow(7.0625d, 2.0d) - ((double) ((PARAM_C - f) * 13.75f)))) / 6.875d;
    }
}
