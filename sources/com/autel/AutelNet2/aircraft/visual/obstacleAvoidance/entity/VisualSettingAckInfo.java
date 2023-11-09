package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity;

public class VisualSettingAckInfo {
    private int Ack;
    private int Command;

    public int getCommand() {
        return this.Command;
    }

    public void setCommand(int i) {
        this.Command = i;
    }

    public int getAck() {
        return this.Ack;
    }

    public void setAck(int i) {
        this.Ack = i;
    }
}
