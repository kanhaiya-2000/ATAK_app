package com.autel.AutelNet2.aircraft.visual.tracking.entity;

import com.autel.common.camera.visual.TrackingArea;

public class UploadGoalArea implements TrackingArea {
    private float Confidence;
    private float Distance = 0.0f;
    private float Height = 0.0f;
    private float Hight = 0.0f;
    private float StartX = 0.0f;
    private float StartY = 0.0f;
    private int Status = -1;
    private int TargetType;
    private long Timestamp = 0;
    private float Width = 0.0f;

    /* renamed from: id */
    private int f8436id = -1;
    private int objId;

    public void setObjId(int i) {
        this.objId = i;
    }

    public void setStartX(float f) {
        this.StartX = f;
    }

    public float getStartX() {
        return this.StartX;
    }

    public void setStartY(float f) {
        this.StartY = f;
    }

    public float getStartY() {
        return this.StartY;
    }

    public void setWidthRatio(float f) {
        this.Width = f;
    }

    public int getId() {
        return this.f8436id;
    }

    public int getObjId() {
        return this.objId;
    }

    public void setId(int i) {
        this.f8436id = i;
    }

    public float getAreaXRatio() {
        return this.StartX;
    }

    public float getAreaYRatio() {
        return this.StartY;
    }

    public float getWidthRatio() {
        return this.Width;
    }

    public float getHeightRatio() {
        float f = this.Height;
        if (f != 0.0f) {
            return f;
        }
        return this.Hight;
    }

    public int getTargetType() {
        return this.TargetType;
    }

    public float getConfidence() {
        return this.Confidence;
    }

    public void setHightRatio(float f) {
        this.Hight = f;
        this.Height = f;
    }

    public float getHightRatio() {
        return this.Hight;
    }

    public void setDistance(float f) {
        this.Distance = f;
    }

    public float getDistance() {
        return this.Distance;
    }

    public void setTimestamp(long j) {
        this.Timestamp = j;
    }

    public long getTimestamp() {
        return this.Timestamp;
    }

    public void setStatus(int i) {
        this.Status = i;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setTargetType(int i) {
        this.TargetType = i;
    }

    public void setConfidence(float f) {
        this.Confidence = f;
    }

    public String toString() {
        return "StartX=" + this.StartX + " StartY=" + this.StartY + " Width=" + this.StartX + " Hight=" + this.Hight + " Distance=" + this.Distance + " status=" + this.Status;
    }
}
