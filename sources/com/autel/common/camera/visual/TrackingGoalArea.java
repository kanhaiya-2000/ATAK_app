package com.autel.common.camera.visual;

import java.util.List;

public interface TrackingGoalArea {
    float getAreaXRatio();

    float getAreaYRatio();

    float getConfidence();

    float getDistance();

    float getHeightRatio();

    int getId();

    int getObjId();

    int getStatus();

    List<Integer> getTargetInfo();

    TargetType getTargetType();

    long getTimestamp();

    float getWidthRatio();
}
