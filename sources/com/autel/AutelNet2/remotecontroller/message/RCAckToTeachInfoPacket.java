package com.autel.AutelNet2.remotecontroller.message;

import org.json.JSONArray;

public class RCAckToTeachInfoPacket extends RCMsgPacket {
    public RCAckToTeachInfoPacket() {
        setType(23);
    }

    public void parseData(int i, JSONArray jSONArray) {
        super.parseData(i, jSONArray);
    }
}
