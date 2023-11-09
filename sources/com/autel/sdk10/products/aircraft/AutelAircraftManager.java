package com.autel.sdk10.products.aircraft;

import com.autel.sdk10.AutelNet.AutelRemoteController.controller.RemoteControllerButtonManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.controller.RemoteControllerManager;

public final class AutelAircraftManager {
    private AutelAircraftManager() {
    }

    public static RemoteControllerManager getRCManager() {
        return RemoteControllerManager.getInstance();
    }

    public static RemoteControllerButtonManager getRCButtonManager() {
        return RemoteControllerButtonManager.getInstance();
    }
}
