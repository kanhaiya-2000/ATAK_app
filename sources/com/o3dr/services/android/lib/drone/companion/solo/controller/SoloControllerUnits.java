package com.o3dr.services.android.lib.drone.companion.solo.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SoloControllerUnits {
    public static final String IMPERIAL = "imperial";
    public static final String METRIC = "metric";
    public static final String UNKNOWN = "unknown";

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControllerUnit {
    }

    private SoloControllerUnits() {
    }
}
