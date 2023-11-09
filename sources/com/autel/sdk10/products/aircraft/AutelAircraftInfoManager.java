package com.autel.sdk10.products.aircraft;

import com.autel.internal.sdk.firmware.AutelAircraftComponentSNVersionInfoInternal;
import com.autel.internal.sdk.firmware.AutelAircraftComponentVersionInfoInternal;
import com.autel.internal.sdk.firmware.AutelRCSNVersionInfoInternal;
import com.autel.internal.sdk.firmware.AutelRCVersionInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelAltitudeAndSpeedInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelAttitudeInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelFlyControllerStatusInternal;
import com.autel.internal.sdk.flycontroller.AutelGPSInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelHomeInternal;
import com.autel.internal.sdk.flycontroller.AutelWarningInternal;
import com.autel.internal.sdk.gimbal.AutelGimbalInfo;
import com.autel.internal.sdk.mission.AutelOrbitRealTimeInfoInternal;
import com.autel.internal.sdk.mission.AutelWaypointRealTimeInfoInternal;
import com.autel.internal.sdk.mission.MissionState;
import com.autel.sdk10.AutelNet.AutelBattery.BatteryManager;
import com.autel.sdk10.AutelNet.AutelBattery.info.AutelBatteryInfo;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmVersionManager;
import com.autel.sdk10.AutelNet.AutelFlyController.FlyControllerManager;
import com.autel.sdk10.AutelNet.AutelFlyController.info.AutelFlyControllerInfo;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.AutelNet.AutelGimbal.GimbalManager;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.info.AutelRemoteControllerInfo;

public final class AutelAircraftInfoManager {
    private AutelAircraftInfoManager() {
    }

    public static AutelAircraftComponentVersionInfoInternal getAircraftComponentVersionInfo() {
        return AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal();
    }

    public static AutelAircraftComponentSNVersionInfoInternal getAircraftComponentSNVersionInfo() {
        return AutelFirmVersionManager.getInstence().getAircraftComponentSNVersionInfoInternal();
    }

    public static AutelRCVersionInfoInternal getRCVersionInfo() {
        return AutelFirmVersionManager.getInstence().getRcVersionInfoInternal();
    }

    public static AutelRCSNVersionInfoInternal getRCSNVersionInfo() {
        return AutelFirmVersionManager.getInstence().getRcsnVersionInfoInternal();
    }

    public static AutelRemoteControllerInfo getRemoteControllerInfo() {
        return AutelRemoteControllerInfo.getInstance();
    }

    public static AutelBatteryInfo getAutelBatteryInfo() {
        return BatteryManager.getAutelBatteryInfo();
    }

    public static AutelFlyControllerStatusInternal getFlyControllerStatus() {
        return FlyControllerManager.getFlyControllerStatus();
    }

    public static AutelGPSInfoInternal getAutelFlyControllerGPSInfo() {
        return FlyControllerManager.getAutelFlyControllerGPSInfo();
    }

    public static AutelAttitudeInfoInternal getAutelFlyControllerAttitudeInfo() {
        return FlyControllerManager.getAutelFlyControllerAttitudeInfo();
    }

    public static AutelAltitudeAndSpeedInfoInternal getAutelFlyControllerAltitudeAndSpeedInfo() {
        return FlyControllerManager.getAutelFlyControllerAltitudeAndSpeedInfo();
    }

    public static AutelFlyControllerInfo getAutelFlyControllerInfo() {
        return FlyControllerManager.getAutelFlyControllerInfo();
    }

    public static AutelHomeInternal getAutelFlyControllerHomeInfo() {
        return FlyControllerManager.getAutelFlyControllerHomeInfo();
    }

    public static AutelGimbalInfo getAutelGimbalInfo() {
        return GimbalManager.getAutelGimbalInfo();
    }

    public static MissionState getMissionState() {
        return MissionManager.getMissionState();
    }

    public static AutelWaypointRealTimeInfoInternal getAutelWaypointRealtimeInfo() {
        return MissionManager.getAutelWaypointRealtimeInfo();
    }

    public static AutelOrbitRealTimeInfoInternal getAutelOrbitRealtimeInfo() {
        return MissionManager.getAutelOrbitRealtimeInfo();
    }

    public static AutelWarningInternal getAutelErrorWarning() {
        return ErrorWarningInternalParser.getInstance();
    }
}
