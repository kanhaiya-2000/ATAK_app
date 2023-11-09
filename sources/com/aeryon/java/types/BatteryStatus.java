package com.aeryon.java.types;

public class BatteryStatus {
    private int charge;
    private int chargeRemaining;
    private int health;
    private long lastUpdated;
    private float temperature;
    private int timeRemaining;

    public BatteryStatus(long j, int i, int i2, int i3, float f, int i4) {
        this.lastUpdated = j;
        this.health = i;
        this.chargeRemaining = i2;
        this.timeRemaining = i3;
        this.temperature = f;
        this.charge = i4;
    }

    public int getChargeRemaining() {
        return this.chargeRemaining;
    }

    public String toString() {
        return "Last Updated: " + this.lastUpdated + "ms" + ", Health: " + this.health + "%" + ", Charge Remaining: " + this.chargeRemaining + "%" + ", Time Remaining: " + this.timeRemaining + " seconds" + ", Charge" + this.charge + " mAh" + ", Temperature: " + this.temperature + " C";
    }

    public int getTimeRemaining() {
        return this.timeRemaining;
    }
}
