package com.autel.AutelNet2.remotecontroller.message;

import org.json.JSONArray;

public class RCUploadPhoneCompassAnglePacket extends RCMsgPacket {
    public RCUploadPhoneCompassAnglePacket() {
        setType(22);
    }

    public void setPhoneCompassAngle(int i) {
        addData(i);
    }

    public void parseData(int i, JSONArray jSONArray) {
        super.parseData(i, jSONArray);
    }
}
