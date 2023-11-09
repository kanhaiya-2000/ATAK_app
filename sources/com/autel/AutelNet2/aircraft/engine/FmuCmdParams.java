package com.autel.AutelNet2.aircraft.engine;

public class FmuCmdParams {
    private int data0;

    public FmuCmdParams(int i) {
        setData0(i);
    }

    public int getData0() {
        return this.data0;
    }

    public void setData0(int i) {
        this.data0 = i;
    }
}
