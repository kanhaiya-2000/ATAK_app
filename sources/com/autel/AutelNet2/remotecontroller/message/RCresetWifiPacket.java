package com.autel.AutelNet2.remotecontroller.message;

import org.json.JSONArray;

public class RCresetWifiPacket extends RCMsgPacket {
    private boolean isSucc = false;

    public RCresetWifiPacket() {
        setType(21);
    }

    public boolean isResetSucc() {
        return this.isSucc;
    }

    public void parseData(int i, JSONArray jSONArray) {
        this.isSucc = isResultSucc(jSONArray);
    }
}
