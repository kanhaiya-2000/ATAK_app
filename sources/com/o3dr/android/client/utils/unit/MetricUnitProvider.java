package com.o3dr.android.client.utils.unit;

import java.util.Locale;

public class MetricUnitProvider implements UnitProvider {
    public String areaToString(double d) {
        double abs = Math.abs(d);
        if (abs >= 100000.0d) {
            return String.format(Locale.US, "%2.1f km²", new Object[]{Double.valueOf(d / 1000000.0d)});
        } else if (abs >= 1.0d) {
            return String.format(Locale.US, "%2.1f m²", new Object[]{Double.valueOf(d)});
        } else if (abs >= 1.0E-5d) {
            return String.format(Locale.US, "%2.2f cm²", new Object[]{Double.valueOf(d * 10000.0d)});
        } else {
            return d + " m" + "²";
        }
    }

    public String distanceToString(double d) {
        double abs = Math.abs(d);
        if (abs >= 1000.0d) {
            return String.format(Locale.US, "%2.1f km", new Object[]{Double.valueOf(d / 1000.0d)});
        } else if (abs >= 0.1d) {
            return String.format(Locale.US, "%2.1f m", new Object[]{Double.valueOf(d)});
        } else if (abs >= 0.001d) {
            return String.format(Locale.US, "%2.1f mm", new Object[]{Double.valueOf(d * 1000.0d)});
        } else {
            return d + " m";
        }
    }

    public String speedToString(double d) {
        return String.format(Locale.US, "%2.1f m/s", new Object[]{Double.valueOf(d)});
    }

    public String electricChargeToString(double d) {
        if (Math.abs(d) >= 1000.0d) {
            return String.format(Locale.US, "%2.0f Ah", new Object[]{Double.valueOf(d / 1000.0d)});
        }
        return String.format(Locale.ENGLISH, "%2.0f mAh", new Object[]{Double.valueOf(d)});
    }
}
