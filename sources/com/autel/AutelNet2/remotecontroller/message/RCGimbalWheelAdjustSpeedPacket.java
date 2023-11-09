package com.autel.AutelNet2.remotecontroller.message;

import com.autel.AutelNet2.utils.BytesUtils;
import org.json.JSONArray;

public class RCGimbalWheelAdjustSpeedPacket extends RCMsgPacket {
    private int speed;
    private boolean succ = false;

    public RCGimbalWheelAdjustSpeedPacket() {
        setType(2);
    }

    public void setSpeed(int i) {
        this.speed = i;
        setType(1);
        byte[] bytes = BytesUtils.getBytes(i);
        addData(bytes[0]);
        addData(bytes[1]);
        addData(bytes[2]);
        addData(bytes[3]);
    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean isSucc() {
        return this.succ;
    }

    private static int decodeResultFor4Byte(JSONArray jSONArray) {
        byte[] bArr = new byte[4];
        for (int i = 0; i < jSONArray.length(); i++) {
            bArr[i] = (byte) jSONArray.getInt(i);
        }
        return BytesUtils.getInt(bArr);
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (i == 1) {
            this.succ = isResultSucc(jSONArray);
        } else if (i == 2) {
            this.speed = decodeResultFor4Byte(jSONArray);
        }
    }
}
