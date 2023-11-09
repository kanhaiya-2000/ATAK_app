package com.o3dr.android.client;

import com.o3dr.services.android.lib.mavlink.MavlinkMessageWrapper;
import com.o3dr.services.android.lib.model.IMavlinkObserver;

public abstract class MavlinkObserver extends IMavlinkObserver.Stub {
    public abstract void onMavlinkMessageReceived(MavlinkMessageWrapper mavlinkMessageWrapper);
}
