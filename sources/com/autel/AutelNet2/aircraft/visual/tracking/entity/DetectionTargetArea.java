package com.autel.AutelNet2.aircraft.visual.tracking.entity;

import java.util.List;

public class DetectionTargetArea {
    private float Confidence = 0.0f;
    private float Distance;
    private float Hight = 0.0f;
    private float StartX = 0.0f;
    private float StartY = 0.0f;
    private int Status;
    private List<Integer> TargetInfo;
    private int TargetType;
    private float Width = 0.0f;

    /* renamed from: id */
    private int f8434id = -1;

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

    public float getWidth() {
        return this.Width;
    }

    public void setWidth(float f) {
        this.Width = f;
    }

    public float getHeight() {
        return this.Hight;
    }

    public void setHeight(float f) {
        this.Hight = f;
    }

    public int getTargetType() {
        return this.TargetType;
    }

    public void setTargetType(int i) {
        this.TargetType = i;
    }

    public float getConfidence() {
        return this.Confidence;
    }

    public void setConfidence(float f) {
        this.Confidence = f;
    }

    public List<Integer> getTargetInfo() {
        return this.TargetInfo;
    }

    public void setTargetInfo(List<Integer> list) {
        this.TargetInfo = list;
    }

    public int getId() {
        return this.f8434id;
    }

    public void setId(int i) {
        this.f8434id = i;
    }

    public float getDistance() {
        return this.Distance;
    }

    public void setDistance(float f) {
        this.Distance = f;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setStatus(int i) {
        this.Status = i;
    }

    public String toString() {
        return "StartX=" + this.StartX + " StartY=" + this.StartY + " Width=" + this.StartX + " Hight=" + this.Hight + " Confidence=" + this.Confidence + " TargetType =" + this.TargetType + " TargetInfo=" + this.TargetInfo;
    }
}
