package com.autel.AutelNet2.aircraft.flycontroller.engine;

import java.util.List;

public class CmdRecvInfo implements CommandInfoInternal {
    private int Command = -1;
    private List<Integer> Data;
    private int Len;

    public int errorCode() {
        return 0;
    }

    public int getCommand() {
        return this.Command;
    }

    public void setCommand(int i) {
        this.Command = i;
    }

    public int getLen() {
        return this.Len;
    }

    public void setLen(int i) {
        this.Len = i;
    }

    public List<Integer> getData() {
        return this.Data;
    }

    public void setData(List<Integer> list) {
        this.Data = list;
    }

    public boolean isSuccess() {
        return getCommand() >= 0;
    }
}
