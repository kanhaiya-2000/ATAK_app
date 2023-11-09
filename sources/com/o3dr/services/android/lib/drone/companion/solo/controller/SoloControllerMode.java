package com.o3dr.services.android.lib.drone.companion.solo.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SoloControllerMode {
    public static final int MODE_1 = 1;
    public static final int MODE_2 = 2;
    public static final int UNKNOWN_MODE = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControllerMode {
    }

    private SoloControllerMode() {
    }
}
