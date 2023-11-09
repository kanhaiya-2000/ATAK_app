package com.o3dr.android.client.utils.unit;

public interface UnitProvider {
    public static final String SQUARE_SYMBOL = "²";

    String areaToString(double d);

    String distanceToString(double d);

    String electricChargeToString(double d);

    String speedToString(double d);
}
