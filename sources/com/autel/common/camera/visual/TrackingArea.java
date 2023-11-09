package com.autel.common.camera.visual;

public interface TrackingArea {
    float getAreaXRatio();

    float getAreaYRatio();

    float getConfidence();

    float getHeightRatio();

    int getId();

    int getObjId();

    int getStatus();

    int getTargetType();

    long getTimestamp();

    float getWidthRatio();
}
