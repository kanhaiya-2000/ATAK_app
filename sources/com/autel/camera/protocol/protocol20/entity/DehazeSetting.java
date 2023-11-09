package com.autel.camera.protocol.protocol20.entity;

public class DehazeSetting {
    private String Status;
    private int Strength;

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String str) {
        this.Status = str;
    }

    public int getStrength() {
        return this.Strength;
    }

    public void setStrength(int i) {
        this.Strength = i;
    }
}
