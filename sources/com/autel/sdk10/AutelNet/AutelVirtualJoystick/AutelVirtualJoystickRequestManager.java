package com.autel.sdk10.AutelNet.AutelVirtualJoystick;

import com.MAVLink.Messages.MAVLinkMessage;
import com.autel.common.battery.BatteryWarning;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.flycontroller.MainFlyState;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.MAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;

public class AutelVirtualJoystickRequestManager {
    private static AutelVirtualJoystickRequestManager instance;

    public static AutelVirtualJoystickRequestManager getInstance() {
        if (instance == null) {
            instance = new AutelVirtualJoystickRequestManager();
        }
        return instance;
    }

    private AutelVirtualJoystickRequestManager() {
    }

    public void switchVirtualJoystickControlMode(AutelVirtualJoystickControlMode autelVirtualJoystickControlMode) {
        if (autelVirtualJoystickControlMode == AutelVirtualJoystickControlMode.EXIT) {
            StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createVirtualJoystickControlModePacket(autelVirtualJoystickControlMode.getValue()));
        } else if (AutelAircraftInfoManager.getFlyControllerStatus().getFlyMode() == FlyMode.DISARM) {
            throw AutelVirtualJoystickException.DISARM;
        } else if (AutelAircraftInfoManager.getFlyControllerStatus().getMainFlyState() != MainFlyState.GPS) {
            throw AutelVirtualJoystickException.NOGPS;
        } else if (AutelAircraftInfoManager.getAutelErrorWarning().getBatteryWarning() == BatteryWarning.NORMAL) {
            StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createVirtualJoystickControlModePacket(autelVirtualJoystickControlMode.getValue()));
        } else {
            throw AutelVirtualJoystickException.BADBATTERY;
        }
    }

    public void uploadVirtualJoystickState(AutelVirtualJoystickState autelVirtualJoystickState) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createVirtualJoystickStatePacket(autelVirtualJoystickState));
    }

    public void uploadVirtualJoystickYawModeState(int i, float f) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createVirtualJoystickYawModeStatePacket(i, f));
    }

    public void addVirtualJoystickControlModeListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<AutelVirtualJoystickControlMode> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 1, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(VirtualJoystickParser.getInstance_().getVirtualJoystickControlMode());
                        }
                    }
                });
            }
        });
    }

    public void removeVirtualJoystickControlModeListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }
}
