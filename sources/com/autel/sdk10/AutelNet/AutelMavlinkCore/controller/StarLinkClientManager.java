package com.autel.sdk10.AutelNet.AutelMavlinkCore.controller;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.ardupilotmega.msg_param_value;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.autel.sdk10.AutelNet.AutelBattery.BatteryManager;
import com.autel.sdk10.AutelNet.AutelBattery.enums.BatteryRequestCmdName;
import com.autel.sdk10.AutelNet.AutelFlyController.FlyControllerManager;
import com.autel.sdk10.AutelNet.AutelFlyController.enums.FlyControllerRequestCmdName;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.AutelFlyControllerInfoParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.AutelNet.AutelGimbal.GimbalManager;
import com.autel.sdk10.AutelNet.AutelGimbal.enums.GimbalRequestCmdName;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.heartbeat.HeartbeatManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.Parameter;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavlinkUdpSocket;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.interfaces.IMavLinkConnectionListener;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.AutelNet.AutelVirtualJoystick.VirtualJoystickParser;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import java.util.concurrent.ConcurrentHashMap;

public class StarLinkClientManager {
    private static StarLinkClientManager instance_;
    private final int ALL_MESSAGE = 0;
    private final String TAG = "StarLinkClientManager";
    private ConcurrentHashMap<String, LongTimeListenerMapValue> allMessageCallbackMaps = new ConcurrentHashMap<>();

    public static synchronized StarLinkClientManager getInstance_() {
        StarLinkClientManager starLinkClientManager;
        synchronized (StarLinkClientManager.class) {
            if (instance_ == null) {
                instance_ = new StarLinkClientManager();
            }
            starLinkClientManager = instance_;
        }
        return starLinkClientManager;
    }

    private StarLinkClientManager() {
        MavlinkUdpSocket.getInstance_().addIMavLinkConnectionListener("StarLinkClientManager", new IMavLinkConnectionListener() {
            public void onComError(String str) {
            }

            public void onConnect() {
            }

            public void onDisconnect() {
            }

            public void onReceiveMessage(MAVLinkMessage mAVLinkMessage) {
                StarLinkClientManager.this.parseMAVLinkMessage(mAVLinkMessage);
            }
        });
    }

    public void openConnection() {
        MavlinkUdpSocket.getInstance_().connect();
        HeartbeatManager.getInstance().setActive(true);
    }

    public void closeConnection() {
        MavlinkUdpSocket.getInstance_().disconnect();
        HeartbeatManager.getInstance().setActive(false);
    }

    public boolean isConnected() {
        return MavlinkUdpSocket.getInstance_().isConnected();
    }

    public void sendMavPacket(MAVLinkPacket mAVLinkPacket) {
        MavlinkUdpSocket.getInstance_().sendMavPacket(mAVLinkPacket);
    }

    public void addIStarLinkAllMessageCallback(String str, IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage> iAutelRCLongTimeCallbackWith) {
        addIStarLinkLongTimeCallback(str, 0, iAutelRCLongTimeCallbackWith);
    }

    public void removeIStarLinkAllMessageCallback(String str) {
        this.allMessageCallbackMaps.remove(str);
    }

    public void addIStarLinkLongTimeCallback(String str, int i, IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage> iAutelRCLongTimeCallbackWith) {
        if (!this.allMessageCallbackMaps.containsKey(str)) {
            this.allMessageCallbackMaps.put(str, new LongTimeListenerMapValue(i, iAutelRCLongTimeCallbackWith));
        }
    }

    public void removeIStarLinkCallback(String str) {
        this.allMessageCallbackMaps.remove(str);
    }

    class LongTimeListenerMapValue {
        IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage> iAutelRCLongTimeCallbackWith;
        int msgId;

        public LongTimeListenerMapValue(int i, IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage> iAutelRCLongTimeCallbackWith2) {
            this.msgId = i;
            this.iAutelRCLongTimeCallbackWith = iAutelRCLongTimeCallbackWith2;
        }
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        int i = mAVLinkMessage.msgid;
        if (i == 0) {
            HeartbeatManager.getInstance().reportReceivedMessage(mAVLinkMessage);
        } else if (i == 1) {
            AutelAircraftInfoManager.getAircraftComponentVersionInfo().setFmu(((msg_sys_status) mAVLinkMessage).getVersion());
            FlyControllerManager.getFlyControllerStatusParser().parseMAVLinkMessage(mAVLinkMessage);
            ErrorWarningInternalParser.getInstance().parseMAVLinkMessage(mAVLinkMessage);
            AutelFlyControllerInfoParser.getInstance_().parseMAVLinkMessage(mAVLinkMessage);
            VirtualJoystickParser.getInstance_().parseMAVLinkMessage(mAVLinkMessage);
        } else if (i == 22) {
            parseParamValue(mAVLinkMessage);
        } else if (i == 24) {
            FlyControllerManager.getAutelFlyControllerGPSInfoParser().parseMAVLinkMessage(mAVLinkMessage);
        } else if (i == 30) {
            FlyControllerManager.getAutelFlyControllerAttitudeInfoParser().parseMAVLinkMessage(mAVLinkMessage);
        } else if (i != 32) {
            if (!(i == 42 || i == 44)) {
                if (i == 49) {
                    FlyControllerManager.getAutelFlyControllerHomeInfoParser().parseMAVLinkMessage(mAVLinkMessage);
                } else if (i == 77) {
                    MissionManager.getAutelMissionInfoParser().parseMAVLinkMessage(mAVLinkMessage);
                } else if (i == 200) {
                    GimbalManager.getAutelGimbalInfoParser().parseMAVLinkMessage(mAVLinkMessage);
                    BatteryManager.getAutelBatteryInfoParser().parseMAVLinkMessage(mAVLinkMessage);
                } else if (i == 214) {
                    BatteryManager.getAutelBatteryInfoParser().parseMAVLinkMessage(mAVLinkMessage);
                } else if (!(i == 39 || i == 40 || i == 46 || i == 47)) {
                    if (i == 221) {
                        MissionManager.getAutelWaypointMissionInfoParser().parseMAVLinkMessage(mAVLinkMessage);
                        MissionManager.getMissionStateParser().parseMAVLinkMessage(mAVLinkMessage);
                        ErrorWarningInternalParser.getInstance().parseGPSandDistanceErrorCode(mAVLinkMessage);
                    } else if (i == 222) {
                        MissionManager.getAutelMissionInfoParser().parseMAVLinkMessage(mAVLinkMessage);
                    }
                }
            }
            MissionManager.getAutelWaypointMissionInfoParser().parseMAVLinkMessage(mAVLinkMessage);
        } else {
            FlyControllerManager.getAutelFlyControllerAltitudeAndSpeedInfoParser().parseMAVLinkMessage(mAVLinkMessage);
        }
        reportReceivedMessage(mAVLinkMessage);
    }

    private void parseParamValue(MAVLinkMessage mAVLinkMessage) {
        Parameter parameter = new Parameter((msg_param_value) mAVLinkMessage);
        if (GimbalRequestCmdName.isGimbalRequestCmdName(parameter.getName())) {
            GimbalManager.getAutelGimbalInfoParser().parseParamValue(parameter);
        } else if (BatteryRequestCmdName.isBatteryRequestCmdName(parameter.getName())) {
            BatteryManager.getAutelBatteryInfoParser().parseParamValue(parameter);
        } else if (FlyControllerRequestCmdName.isFlyControllerRequestCmdName(parameter.getName())) {
            FlyControllerManager.getAutelFlyControllerInfoParser().parseParamValue(parameter);
        }
    }

    private void reportReceivedMessage(MAVLinkMessage mAVLinkMessage) {
        if (!this.allMessageCallbackMaps.isEmpty()) {
            for (LongTimeListenerMapValue next : this.allMessageCallbackMaps.values()) {
                if (next.msgId == mAVLinkMessage.msgid || (next.msgId == 0 && next.iAutelRCLongTimeCallbackWith != null)) {
                    next.iAutelRCLongTimeCallbackWith.onReceiveMsg(mAVLinkMessage);
                }
            }
        }
    }
}
