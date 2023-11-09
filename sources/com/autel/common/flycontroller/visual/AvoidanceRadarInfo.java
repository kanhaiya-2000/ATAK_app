package com.autel.common.flycontroller.visual;

public interface AvoidanceRadarInfo {
    float[] getBottom();

    float[] getFront();

    float[] getLeft();

    float[] getRear();

    float[] getRight();

    long getTimeStamp();

    float[] getTop();
}
