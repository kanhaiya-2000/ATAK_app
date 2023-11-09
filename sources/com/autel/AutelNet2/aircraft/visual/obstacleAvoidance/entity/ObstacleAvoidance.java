package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity;

import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;

public class ObstacleAvoidance implements AvoidanceRadarInfo {
    private long TimeStamp;
    private float[] bottom;
    private float[] front;
    private float[] left;
    private float[] rear;
    private float[] right;
    private float[] top;

    public long getTimeStamp() {
        return this.TimeStamp;
    }

    public float[] getFront() {
        return this.front;
    }

    public float[] getRear() {
        return this.rear;
    }

    public float[] getLeft() {
        return this.left;
    }

    public float[] getRight() {
        return this.right;
    }

    public float[] getTop() {
        return this.top;
    }

    public float[] getBottom() {
        return this.bottom;
    }
}
