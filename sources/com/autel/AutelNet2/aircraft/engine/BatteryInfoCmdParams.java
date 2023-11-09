package com.autel.AutelNet2.aircraft.engine;

import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;

public class BatteryInfoCmdParams implements CommandInfoInternal {
    private int Ack;
    private int DischargeDays;
    private int LoopTimes;
    private int MaxVoltage;
    private int MinVoltage;
    private String Version;

    public int getAck() {
        return this.Ack;
    }

    public void setAck(int i) {
        this.Ack = i;
    }

    public String getVersion() {
        return this.Version;
    }

    public void setVersion(String str) {
        this.Version = str;
    }

    public int getLoopTimes() {
        return this.LoopTimes;
    }

    public void setLoopTimes(int i) {
        this.LoopTimes = i;
    }

    public int getDischargeDays() {
        return this.DischargeDays;
    }

    public void setDischargeDays(int i) {
        this.DischargeDays = i;
    }

    public int errorCode() {
        return this.Ack;
    }

    public boolean isSuccess() {
        return getAck() == 0;
    }

    public int getMaxVoltage() {
        return this.MaxVoltage;
    }

    public void setMaxVoltage(int i) {
        this.MaxVoltage = i;
    }

    public int getMinVoltage() {
        return this.MinVoltage;
    }

    public void setMinVoltage(int i) {
        this.MinVoltage = i;
    }

    public String toString() {
        return "Version=" + this.Version + " LoopTimes=" + this.LoopTimes + " amount= DischargeDays=" + this.DischargeDays + " Ack=" + this.Ack + " MaxVoltage=" + this.MaxVoltage + " MinVoltage=" + this.MinVoltage;
    }
}
