package com.autel.AutelNet2.remotecontroller.message;

import org.json.JSONArray;

public class RCInfoPacket extends RCMsgPacket {
    private int[] info;

    public int[] getInfo() {
        return this.info;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.info = new int[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.info[i2] = jSONArray.getInt(i2);
            }
        }
    }
}
