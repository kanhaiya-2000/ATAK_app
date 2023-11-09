package com.autel.camera.protocol.protocol20.entity;

public class TrackingStatus {
    private String action;
    private String state;

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }
}
