package com.o3dr.android.client;

import android.os.Bundle;
import com.o3dr.services.android.lib.model.IObserver;

final class DroneObserver extends IObserver.Stub {
    private final Drone drone;

    public DroneObserver(Drone drone2) {
        this.drone = drone2;
    }

    public void onAttributeUpdated(String str, Bundle bundle) {
        this.drone.notifyAttributeUpdated(str, bundle);
    }
}
