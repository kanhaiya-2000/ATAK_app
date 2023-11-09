package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class ScheduleMessageUpdateCommand {
    private static final String TAG = "ScheduleMessageUpdateCommand";
    private final int datalinkId;
    private final int vsmId;

    public ScheduleMessageUpdateCommand(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        int i3 = wrap.getInt();
        this.vsmId = i3;
        Log.d(TAG, "VSM ID: " + i3);
        int i4 = wrap.getInt();
        this.datalinkId = i4;
        Log.d(TAG, "Data Link ID: " + i4);
        int i5 = wrap.getInt();
        Log.d(TAG, "Requested Message Type: " + i5);
        float f = wrap.getFloat();
        Log.d(TAG, "Frequency: " + f);
    }
}
