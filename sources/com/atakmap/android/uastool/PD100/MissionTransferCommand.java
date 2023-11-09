package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class MissionTransferCommand {
    private static final String TAG = "MissionTransferCommand";
    byte[] missIdBytes;
    String missIdStr = new String(this.missIdBytes);
    short wyPtNum;

    public MissionTransferCommand(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        byte[] bArr2 = new byte[20];
        this.missIdBytes = bArr2;
        wrap.get(bArr2);
        Log.d(TAG, "Mission ID: " + this.missIdStr);
        byte b = wrap.get();
        Log.d(TAG, "Mission Plan Mode: " + b);
        this.wyPtNum = wrap.getShort();
        Log.d(TAG, "Waypoint Number: " + this.wyPtNum);
    }
}
