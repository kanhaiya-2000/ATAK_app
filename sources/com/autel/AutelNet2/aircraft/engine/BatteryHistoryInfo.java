package com.autel.AutelNet2.aircraft.engine;

import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;

public class BatteryHistoryInfo implements CommandInfoInternal {
    private int command_ack;
    private String data;

    public int getCommand_ack() {
        return this.command_ack;
    }

    public void setCommand_ack(int i) {
        this.command_ack = i;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public int errorCode() {
        return this.command_ack;
    }

    public boolean isSuccess() {
        return this.command_ack == 0;
    }

    public String toString() {
        return "command_ack=" + this.command_ack + " data=" + this.data;
    }
}
