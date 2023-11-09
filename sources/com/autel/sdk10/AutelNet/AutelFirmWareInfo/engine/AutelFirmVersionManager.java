package com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine;

import com.autel.internal.sdk.firmware.AutelAircraftComponentSNVersionInfoInternal;
import com.autel.internal.sdk.firmware.AutelAircraftComponentVersionInfoInternal;
import com.autel.internal.sdk.firmware.AutelRCSNVersionInfoInternal;
import com.autel.internal.sdk.firmware.AutelRCVersionInfoInternal;

public class AutelFirmVersionManager {
    private static AutelFirmVersionManager instance;
    private AutelAircraftComponentSNVersionInfoInternal aircraftComponentSNVersionInfoInternal = new AutelAircraftComponentSNVersionInfoInternal();
    private AutelAircraftComponentVersionInfoInternal aircraftComponentVersionInfoInternal = new AutelAircraftComponentVersionInfoInternal();
    private AutelRCVersionInfoInternal rcVersionInfoInternal = new AutelRCVersionInfoInternal();
    private AutelRCSNVersionInfoInternal rcsnVersionInfoInternal = new AutelRCSNVersionInfoInternal();

    public static AutelFirmVersionManager getInstence() {
        if (instance == null) {
            instance = new AutelFirmVersionManager();
        }
        return instance;
    }

    public AutelAircraftComponentSNVersionInfoInternal getAircraftComponentSNVersionInfoInternal() {
        return this.aircraftComponentSNVersionInfoInternal;
    }

    public AutelAircraftComponentVersionInfoInternal getAircraftComponentVersionInfoInternal() {
        return this.aircraftComponentVersionInfoInternal;
    }

    public AutelRCVersionInfoInternal getRcVersionInfoInternal() {
        return this.rcVersionInfoInternal;
    }

    public AutelRCSNVersionInfoInternal getRcsnVersionInfoInternal() {
        return this.rcsnVersionInfoInternal;
    }
}
