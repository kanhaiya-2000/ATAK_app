package com.autel.AutelNet2.remotecontroller.message;

import com.autel.AutelNet2.utils.BytesUtils;
import org.json.JSONArray;

public class RCGimbalAnglePacket extends RCMsgPacket {
    private int angle;
    private boolean isSucc = false;

    public RCGimbalAnglePacket() {
        setType(12);
    }

    public void setAngle(int i) {
        setType(11);
        byte[] bytes = BytesUtils.getBytes(i);
        addData(bytes[0]);
        addData(bytes[1]);
        addData(bytes[2]);
        addData(bytes[3]);
    }

    public int getAngle() {
        return this.angle;
    }

    public boolean isSucc() {
        return this.isSucc;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (i == 11) {
            this.isSucc = isResultSucc(jSONArray);
        } else if (i == 12) {
            this.angle = decodeResultFor4Byte(jSONArray);
        }
    }

    private static int decodeResultFor4Byte(JSONArray jSONArray) {
        byte[] bArr = new byte[4];
        for (int i = 0; i < jSONArray.length(); i++) {
            bArr[i] = (byte) jSONArray.getInt(i);
        }
        return BytesUtils.getInt(bArr);
    }
}
