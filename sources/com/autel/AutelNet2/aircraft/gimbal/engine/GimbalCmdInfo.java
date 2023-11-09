package com.autel.AutelNet2.aircraft.gimbal.engine;

public class GimbalCmdInfo {
    private int Ack;
    private int[] Data = {-1, -1, -1, -1};

    public int getAck() {
        return this.Ack;
    }

    public void setAck(int i) {
        this.Ack = i;
    }

    public int[] getData() {
        return this.Data;
    }

    public void setData(int[] iArr) {
        this.Data = iArr;
    }
}
