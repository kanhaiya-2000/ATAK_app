package com.aeryon.java.types;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PowerStatus {
    private int chargeRemaining;
    private boolean charging;
    private Integer flightTimeRemaining;
    private int health;
    private long lastUpdated;
    private TEMPERATURE_STATUS tempStatus;
    private float temperature;
    private int timeRemaining;

    enum TEMPERATURE_STATUS {
        ADK_GOODNESS_LEVEL_Good(3),
        ADK_GOODNESS_LEVEL_Warn(2),
        ADK_GOODNESS_LEVEL_Critical(1),
        ADK_GOODNESS_LEVEL_Last(4),
        ADK_GOODNESS_LEVEL_Unspecified(0);
        
        private static final Map<Integer, TEMPERATURE_STATUS> map = null;
        private final int value;

        static {
            int i;
            HashMap hashMap = new HashMap();
            for (TEMPERATURE_STATUS temperature_status : values()) {
                hashMap.put(Integer.valueOf(temperature_status.getValue()), temperature_status);
            }
            map = Collections.unmodifiableMap(hashMap);
        }

        private TEMPERATURE_STATUS(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static TEMPERATURE_STATUS lookup(int i) {
            TEMPERATURE_STATUS temperature_status = map.get(Integer.valueOf(i));
            return temperature_status == null ? ADK_GOODNESS_LEVEL_Unspecified : temperature_status;
        }
    }

    public PowerStatus(long j, int i, int i2, int i3, boolean z, float f, int i4, int i5) {
        this.lastUpdated = j;
        this.health = i;
        this.chargeRemaining = i2;
        this.timeRemaining = i3;
        this.charging = z;
        this.temperature = f;
        this.flightTimeRemaining = Integer.valueOf(i4);
        this.tempStatus = TEMPERATURE_STATUS.lookup(i5);
    }

    public int getChargeRemaining() {
        return this.chargeRemaining;
    }

    public String toString() {
        return "Last Updated: " + this.lastUpdated + "ms" + ", Health: " + this.health + "%" + ", Charge Remaining: " + this.chargeRemaining + "%" + ", Time Remaining: " + this.timeRemaining + " seconds" + ", Flight Time Remaining: " + this.flightTimeRemaining + " seconds" + ", Charging: " + this.charging + ", Temperature: " + this.temperature + " C" + ", Temperature Status: " + this.tempStatus;
    }

    public int getTimeRemaining() {
        return this.timeRemaining;
    }

    public int getFlightTimeRemaining() {
        return this.flightTimeRemaining.intValue();
    }
}
