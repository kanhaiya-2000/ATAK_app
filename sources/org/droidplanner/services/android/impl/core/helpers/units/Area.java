package org.droidplanner.services.android.impl.core.helpers.units;

import java.util.Locale;

public class Area {
    public static final String SQUARE_SYMBOL = "²";
    private double areaInSqMeters;

    public Area(double d) {
        this.areaInSqMeters = d;
    }

    public double valueInSqMeters() {
        return this.areaInSqMeters;
    }

    public void set(double d) {
        this.areaInSqMeters = d;
    }

    public String toString() {
        double d = this.areaInSqMeters;
        if (d >= 100000.0d) {
            return String.format(Locale.US, "%2.1f km²", new Object[]{Double.valueOf(this.areaInSqMeters / 1000000.0d)});
        } else if (d >= 1.0d) {
            return String.format(Locale.US, "%2.1f m²", new Object[]{Double.valueOf(this.areaInSqMeters)});
        } else if (d >= 1.0E-5d) {
            return String.format(Locale.US, "%2.2f cm²", new Object[]{Double.valueOf(this.areaInSqMeters * 10000.0d)});
        } else {
            return this.areaInSqMeters + " m" + "²";
        }
    }
}
