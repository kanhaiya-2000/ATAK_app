package com.autel.sdk10.AutelNet.AutelVirtualJoystick;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;

public class VirtualJoystickParser extends AutelVirtualJoystickInfo {
    private static VirtualJoystickParser instance_;

    public static VirtualJoystickParser getInstance_() {
        if (instance_ == null) {
            instance_ = new VirtualJoystickParser();
        }
        return instance_;
    }

    private VirtualJoystickParser() {
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        int i = (((msg_sys_status) mAVLinkMessage).exflags >> 4) & 15;
        if (i == 0) {
            this.virtualJoystickControlMode = AutelVirtualJoystickControlMode.EXIT;
        } else if (i == 1) {
            this.virtualJoystickControlMode = AutelVirtualJoystickControlMode.JOYSTICK;
        } else if (i == 2) {
            this.virtualJoystickControlMode = AutelVirtualJoystickControlMode.JOYSTICK_YAW;
        }
    }
}
