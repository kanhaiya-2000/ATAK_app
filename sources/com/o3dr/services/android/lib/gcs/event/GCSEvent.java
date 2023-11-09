package com.o3dr.services.android.lib.gcs.event;

public class GCSEvent {
    public static final String ACTION_VEHICLE_CONNECTION = "com.o3dr.services.android.lib.gcs.event.action.VEHICLE_CONNECTION";
    public static final String ACTION_VEHICLE_DISCONNECTION = "com.o3dr.services.android.lib.gcs.event.action.VEHICLE_DISCONNECTION";
    public static final String EXTRA_APP_ID = "com.o3dr.services.android.lib.gcs.event.extra.APP_ID";
    public static final String EXTRA_VEHICLE_CONNECTION_PARAMETER = "com.o3dr.services.android.lib.gcs.event.extra.VEHICLE_CONNECTION_PARAMETER";
    private static final String PACKAGE_NAME = "com.o3dr.services.android.lib.gcs.event";

    private GCSEvent() {
    }
}
