package com.autel.AutelNet2.utils;

import java.util.UUID;

public class AutelMathUtils {
    private static UUID uuid;

    public static double convert(double d, int i) {
        double pow = (double) ((int) Math.pow(10.0d, (double) i));
        return (((double) Math.round(d * pow)) * 1.0d) / pow;
    }

    public static double convertSubDouble(double d, int i) {
        int indexOf = String.valueOf(d).indexOf(".") + 1;
        if (i == 0) {
            indexOf--;
        }
        return Double.parseDouble(String.valueOf(d).substring(0, indexOf + i));
    }

    public static int convert(int i) {
        return ((i - 1024) * 200) / 1330;
    }

    public static int convertT(int i) {
        return ((i * 1330) / 200) + 1024;
    }

    public static String getUUID() {
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
        return uuid.toString();
    }
}
