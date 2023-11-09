package com.atakmap.android.uastool.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import atak.core.rd;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.p000av.AvMonitor;
import com.atakmap.android.uastool.p000av.PayloadBlock;
import com.atakmap.android.uastool.p000av.PayloadCommandFrame;
import com.atakmap.android.uastool.p000av.PayloadControlBlock;
import com.atakmap.android.uastool.p000av.UplinkComm;

public class PayloadConfigReceiver extends BroadcastReceiver {
    private static final String TAG = "PayloadConfigReceiver";
    private final rd instructions = rd.a();

    public PayloadConfigReceiver(Context context) {
    }

    public void onReceive(Context context, Intent intent) {
        sendConfigChange(true, 0);
    }

    private void sendConfigChange(boolean z, int i) {
        PayloadCommandFrame payloadCommandFrame = new PayloadCommandFrame();
        PayloadControlBlock payloadControlBlock = new PayloadControlBlock();
        payloadControlBlock.setType(PayloadBlock.PayloadType.GIMBAL.ordinal());
        payloadControlBlock.setControlUnstow(true);
        payloadControlBlock.setControlSide(z);
        payloadCommandFrame.addPayloadControlBlock(payloadControlBlock);
        PayloadControlBlock payloadControlBlock2 = new PayloadControlBlock();
        payloadControlBlock2.setType(PayloadBlock.PayloadType.EO_COLOR_CAMERA.ordinal());
        payloadControlBlock2.setControlZoomCapable(true);
        payloadControlBlock2.setZoomIndex(i);
        payloadCommandFrame.addPayloadControlBlock(payloadControlBlock2);
        UplinkComm avUplinkComm = ((AvMonitor) UASToolDropDownReceiver.getInstance().getPlatformMonitor()).getAvUplinkComm();
        if (avUplinkComm != null) {
            avUplinkComm.AddToSend((GCSUplinkMessage) payloadCommandFrame);
        }
    }

    public void test1() {
        sendConfigChange(true, 0);
    }

    public void test2() {
        sendConfigChange(false, 4);
    }
}
