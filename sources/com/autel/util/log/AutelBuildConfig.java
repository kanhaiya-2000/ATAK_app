package com.autel.util.log;

public final class AutelBuildConfig {
    public static final boolean DEBUG = false;
    private static final String SDK_TEST_VERSION = "4.3";
    private static final String UPDATETIME = "2016-09-12 14:00";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "AUTEL SDK VERSION 1.0.0";

    public static String getVersionInfo() {
        return VERSION_NAME;
    }
}
