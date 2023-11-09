package com.autel.sdk10.products.aircraft;

import com.autel.sdk10.AutelNet.AutelBattery.BatteryManager;
import com.autel.sdk10.AutelNet.AutelBattery.requestmanager.AutelBatteryRequestManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.controller.AutelFirmVersionRequestManager;
import com.autel.sdk10.AutelNet.AutelFlyController.FlyControllerManager;
import com.autel.sdk10.AutelNet.AutelFlyController.requestmanager.AutelFlyControllerRequestManager;
import com.autel.sdk10.AutelNet.AutelGimbal.GimbalManager;
import com.autel.sdk10.AutelNet.AutelGimbal.requestmanager.AutelGimbalRequestManager;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager;
import com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelMissionCommonRequestManager;
import com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelOrbitMissionRequestManager;
import com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelWaypointMissionRequestManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.controller.AutelRemoteControllerRequestManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.controller.RemoteControllerManager;
import com.autel.sdk10.AutelNet.AutelVirtualJoystick.AutelVirtualJoystickRequestManager;

public final class AutelAircraftRequestManager {
    private AutelAircraftRequestManager() {
    }

    public static AutelFirmVersionRequestManager getAutelFirmVersionRequestManager() {
        return AutelFirmVersionRequestManager.getInstance();
    }

    public static AutelRemoteControllerRequestManager getRCRequestManager() {
        return RemoteControllerManager.getInstance();
    }

    public static AutelBatteryRequestManager getAutelBatteryRequestManager() {
        return BatteryManager.getAutelBatteryRequestManager();
    }

    public static AutelFlyControllerRequestManager getAutelFlyControllerRequestManager() {
        return FlyControllerManager.getAutelFlyControllerRequestManager();
    }

    public static AutelGimbalRequestManager getAutelGimbalRequestManager() {
        return GimbalManager.getAutelGimbalRequestManager();
    }

    public static AutelMissionCommonRequestManager getAutelMissionCommonRequestManager() {
        return MissionManager.getAutelMissonCommonRequestManager();
    }

    public static AutelOrbitMissionRequestManager getAutelOrbitMissionRequestManager() {
        return MissionManager.getAutelOrbitMissionRequestManager();
    }

    public static AutelFollowMissionRequestManager getAutelFollowMissionRequestManager() {
        return MissionManager.getAutelFollowMissionRequestManager();
    }

    public static AutelWaypointMissionRequestManager getAutelWaypointMissionRequestManager() {
        return MissionManager.getAutelWaypointMissionRequestManager();
    }

    public static AutelVirtualJoystickRequestManager getAutelVirtualJoystickRequestManager() {
        return AutelVirtualJoystickRequestManager.getInstance();
    }
}
