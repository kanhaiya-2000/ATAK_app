package com.autel.AutelNet2.remotecontroller.message;

import com.autel.AutelNet2.utils.AutelMathUtils;
import com.autel.AutelNet2.utils.BytesUtils;
import org.json.JSONArray;

public class RCUploadDataPacket extends RCMsgPacket {
    private int[] info;

    public RCUploadDataPacket() {
        setType(14);
    }

    public void setMode(int i) {
        addData(i);
    }

    public int[] getInfo() {
        return this.info;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            byte[] bArr = new byte[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                bArr[i2] = (byte) jSONArray.getInt(i2);
            }
            this.info = decodeRemoteTKData(bArr);
        }
    }

    private static int[] decodeRemoteTKData(byte[] bArr) {
        int[] iArr = new int[6];
        if (bArr.length != 12) {
            return iArr;
        }
        for (int i = 0; i < 6; i++) {
            int i2 = i * 2;
            byte[] bArr2 = {bArr[i2], bArr[i2 + 1]};
            if (i < 4) {
                iArr[i] = AutelMathUtils.convert(BytesUtils.getInt(bArr2));
            } else if (i == 4) {
                iArr[i + 1] = BytesUtils.getInt(bArr2);
            } else {
                iArr[i - 1] = AutelMathUtils.convert(BytesUtils.getInt(bArr2));
            }
        }
        return iArr;
    }
}
