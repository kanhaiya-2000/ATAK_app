package com.autel.AutelNet2.remotecontroller.message;

import org.json.JSONArray;

public class RCVersionDataPacket extends RCMsgPacket {
    private int[] result;

    public RCVersionDataPacket() {
        setType(16);
    }

    public int[] getVersion() {
        return this.result;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.result = new int[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.result[i2] = jSONArray.getInt(i2);
            }
        }
    }
}
