package com.autel.AutelNet2.aircraft.engine;

import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;

public class LedPilotInfo implements CommandInfoInternal {
    private int command_ack;
    private int data0;

    public int getCommand_ack() {
        return this.command_ack;
    }

    public void setCommand_ack(int i) {
        this.command_ack = i;
    }

    public int getData() {
        return this.data0;
    }

    public void setData(int i) {
        this.data0 = i;
    }

    public int errorCode() {
        return this.command_ack;
    }

    public boolean isSuccess() {
        return this.command_ack == 0;
    }

    public String toString() {
        return "command_ack=" + this.command_ack + " data=" + this.data0;
    }
}
