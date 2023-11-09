package com.autel.internal.product;

import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.battery.C4928AutelBattery;
import com.autel.sdk.dsp.C4929AutelDsp;
import com.autel.sdk.flycontroller.C4930AutelFlyController;
import com.autel.sdk.gimbal.C4931AutelGimbal;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk.remotecontroller.C4932AutelRemoteController;

public class UnknownProduct extends BaseProductImpl {
    public C4928AutelBattery getBattery() {
        return null;
    }

    public C4929AutelDsp getDsp() {
        return null;
    }

    public C4930AutelFlyController getFlyController() {
        return null;
    }

    public C4931AutelGimbal getGimbal() {
        return null;
    }

    public MissionManager getMissionManager() {
        return null;
    }

    public C4932AutelRemoteController getRemoteController() {
        return null;
    }

    public void productConnected() {
    }

    public void productDestroy() {
    }

    public void productDisconnect() {
    }

    public void productInit() {
    }

    public UnknownProduct(IAutelStateManager iAutelStateManager, AutelServiceVersion autelServiceVersion) {
        super(iAutelStateManager);
        this.serviceVersion = autelServiceVersion;
    }

    public AutelProductType getType() {
        return AutelProductType.UNKNOWN;
    }
}
