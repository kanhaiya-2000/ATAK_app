package com.autel.sdk10.AutelNet.AutelFlyController;

import com.autel.internal.sdk.flycontroller.AutelAltitudeAndSpeedInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelAttitudeInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelFlyControllerStatusInternal;
import com.autel.internal.sdk.flycontroller.AutelGPSInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelHomeInternal;
import com.autel.sdk10.AutelNet.AutelFlyController.info.AutelFlyControllerInfo;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.AltitudeAndSpeedInfoInternalParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.AttitudeInfoInternalParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.AutelFlyControllerInfoParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.FlyControllerStatusInternalParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.GPSInfoInternalParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.HomeParser;
import com.autel.sdk10.AutelNet.AutelFlyController.requestmanager.AutelFlyControllerRequestManager;

public final class FlyControllerManager {
    private static AutelFlyControllerRequestManager manager;

    private FlyControllerManager() {
    }

    public static AutelFlyControllerRequestManager getAutelFlyControllerRequestManager() {
        if (manager == null) {
            manager = new AutelFlyControllerRequestManager();
        }
        return manager;
    }

    public static AutelFlyControllerInfo getAutelFlyControllerInfo() {
        return AutelFlyControllerInfoParser.getInstance_();
    }

    public static AutelFlyControllerInfoParser getAutelFlyControllerInfoParser() {
        return AutelFlyControllerInfoParser.getInstance_();
    }

    public static AutelGPSInfoInternal getAutelFlyControllerGPSInfo() {
        return GPSInfoInternalParser.getInstance_();
    }

    public static GPSInfoInternalParser getAutelFlyControllerGPSInfoParser() {
        return GPSInfoInternalParser.getInstance_();
    }

    public static AutelAttitudeInfoInternal getAutelFlyControllerAttitudeInfo() {
        return AttitudeInfoInternalParser.getInstance_();
    }

    public static AttitudeInfoInternalParser getAutelFlyControllerAttitudeInfoParser() {
        return AttitudeInfoInternalParser.getInstance_();
    }

    public static AutelAltitudeAndSpeedInfoInternal getAutelFlyControllerAltitudeAndSpeedInfo() {
        return AltitudeAndSpeedInfoInternalParser.getInstance_();
    }

    public static AltitudeAndSpeedInfoInternalParser getAutelFlyControllerAltitudeAndSpeedInfoParser() {
        return AltitudeAndSpeedInfoInternalParser.getInstance_();
    }

    public static AutelHomeInternal getAutelFlyControllerHomeInfo() {
        return HomeParser.getInstance_();
    }

    public static HomeParser getAutelFlyControllerHomeInfoParser() {
        return HomeParser.getInstance_();
    }

    public static AutelFlyControllerStatusInternal getFlyControllerStatus() {
        return FlyControllerStatusInternalParser.getInstance_();
    }

    public static FlyControllerStatusInternalParser getFlyControllerStatusParser() {
        return FlyControllerStatusInternalParser.getInstance_();
    }
}
