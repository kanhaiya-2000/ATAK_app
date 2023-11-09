package com.atakmap.android.uastool.mavlink;

public interface MavLinkTelemetryCallback {
    void onHeartBeat(boolean z, String str);

    void onHomePositonUpdate(double d, double d2, double d3);

    void onPositionUpdate(double d, double d2, double d3, double d4, double d5);

    void onSensorAngleUpdate(double d, double d2, double d3, double d4);
}
