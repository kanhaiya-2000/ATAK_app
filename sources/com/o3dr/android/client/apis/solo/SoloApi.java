package com.o3dr.android.client.apis.solo;

import android.os.Bundle;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.drone.companion.solo.action.SoloActions;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.TLVPacket;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;

public abstract class SoloApi extends Api {
    protected final Drone drone;

    protected SoloApi(Drone drone2) {
        this.drone = drone2;
    }

    /* access modifiers changed from: protected */
    public void sendMessage(TLVPacket tLVPacket, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SoloActions.EXTRA_MESSAGE_DATA, tLVPacket);
        this.drone.performAsyncActionOnDroneThread(new Action(SoloActions.ACTION_SEND_MESSAGE, bundle), abstractCommandListener);
    }
}
