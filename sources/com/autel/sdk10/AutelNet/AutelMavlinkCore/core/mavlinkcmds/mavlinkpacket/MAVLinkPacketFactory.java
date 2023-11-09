package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket;

import android.location.Location;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.ardupilotmega.mavlink_msg_mission_new_item;
import com.MAVLink.Messages.ardupilotmega.msg_command_long;
import com.MAVLink.Messages.ardupilotmega.msg_nav_followme;
import com.autel.internal.sdk.mission.AutelOrbit;
import com.autel.sdk10.AutelNet.AutelVirtualJoystick.AutelVirtualJoystickState;

public final class MAVLinkPacketFactory {
    private MAVLinkPacketFactory() {
    }

    public static MAVLinkPacket creareTakeOffPacket() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 22;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket[] createYawRecoverPacket() {
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item.target_system = 1;
        mavlink_msg_mission_new_item.target_component = 0;
        mavlink_msg_mission_new_item.command = 110;
        mavlink_msg_mission_new_item.param1 = 1.0f;
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item2 = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item2.target_system = 1;
        mavlink_msg_mission_new_item2.target_component = 0;
        mavlink_msg_mission_new_item2.command = 110;
        mavlink_msg_mission_new_item2.param1 = 0.0f;
        return new MAVLinkPacket[]{mavlink_msg_mission_new_item.pack(), mavlink_msg_mission_new_item2.pack()};
    }

    public static MAVLinkPacket createClockwisePacket(int i) {
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item.target_system = 1;
        mavlink_msg_mission_new_item.target_component = 0;
        mavlink_msg_mission_new_item.command = 109;
        mavlink_msg_mission_new_item.param1 = 132.0f;
        mavlink_msg_mission_new_item.param2 = (float) i;
        return mavlink_msg_mission_new_item.pack();
    }

    public static MAVLinkPacket createSetMyLocationToOrbitPacket() {
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item.target_system = 1;
        mavlink_msg_mission_new_item.target_component = 0;
        mavlink_msg_mission_new_item.command = 109;
        mavlink_msg_mission_new_item.param1 = 133.0f;
        return mavlink_msg_mission_new_item.pack();
    }

    public static MAVLinkPacket createSetMissionFinishedTypePacket(int i, float f) {
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item.target_system = 1;
        mavlink_msg_mission_new_item.target_component = 0;
        mavlink_msg_mission_new_item.command = 109;
        mavlink_msg_mission_new_item.param1 = 130.0f;
        mavlink_msg_mission_new_item.param2 = (float) i;
        mavlink_msg_mission_new_item.param3 = f;
        mavlink_msg_mission_new_item.param4 = 0.0f;
        mavlink_msg_mission_new_item.param5 = 0;
        mavlink_msg_mission_new_item.param6 = 0;
        return mavlink_msg_mission_new_item.pack();
    }

    public static MAVLinkPacket createSetMissionFlySpeedPacket(float f) {
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item.target_system = 1;
        mavlink_msg_mission_new_item.target_component = 0;
        mavlink_msg_mission_new_item.command = 109;
        mavlink_msg_mission_new_item.param1 = 131.0f;
        mavlink_msg_mission_new_item.param2 = f;
        return mavlink_msg_mission_new_item.pack();
    }

    public static MAVLinkPacket createGoHomeMessagePacket() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 20;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createLandMessagePacket() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 21;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createGoMessagePacket(int i) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 252;
        msg_command_long.param1 = 1.0f;
        msg_command_long.param2 = (float) i;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createHaltMessagePacket() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 252;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 2.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createControlLEDPacket(int i) {
        float f = 0.1f;
        if (i != 0) {
            if (i == 1) {
                f = 0.3f;
            } else if (i == 2) {
                f = 0.6f;
            } else if (i == 3) {
                f = 0.8f;
            }
        }
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 186;
        msg_command_long.param1 = f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createCabCompassPacket() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 241;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 1.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createSwitchFollowPacket(int i, int i2) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 96;
        msg_command_long.param1 = (float) i;
        msg_command_long.param2 = (float) i2;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createFollowFromLocationPacket(Location location) {
        msg_nav_followme msg_nav_followme = new msg_nav_followme();
        msg_nav_followme.lat = (float) location.getLatitude();
        msg_nav_followme.lon = (float) location.getLongitude();
        msg_nav_followme.alt = (float) location.getAltitude();
        msg_nav_followme.angler = (short) ((int) (location.getBearing() * 100.0f));
        msg_nav_followme.eph = (short) ((int) (location.getAccuracy() * 100.0f));
        msg_nav_followme.epv = (short) ((int) (location.getAccuracy() * 100.0f));
        msg_nav_followme.vel = (short) ((int) (location.getSpeed() * 100.0f));
        return msg_nav_followme.pack();
    }

    public static MAVLinkPacket createOrbitPointToAPMPacket(AutelOrbit autelOrbit) {
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item.target_system = 1;
        mavlink_msg_mission_new_item.target_component = 0;
        mavlink_msg_mission_new_item.command = autelOrbit.getCommand();
        mavlink_msg_mission_new_item.param1 = autelOrbit.getRadius();
        mavlink_msg_mission_new_item.param2 = autelOrbit.getSpeed();
        mavlink_msg_mission_new_item.param3 = autelOrbit.getReturnHeight();
        mavlink_msg_mission_new_item.param4 = 0.0f;
        mavlink_msg_mission_new_item.f8114x = (float) autelOrbit.getLat();
        mavlink_msg_mission_new_item.f8115y = (float) autelOrbit.getLng();
        mavlink_msg_mission_new_item.f8116z = 0.0f;
        mavlink_msg_mission_new_item.param5 = autelOrbit.getRound();
        mavlink_msg_mission_new_item.param6 = (short) autelOrbit.getMissonFinishedType();
        return mavlink_msg_mission_new_item.pack();
    }

    public static MAVLinkPacket createControlOrbitMisssionPacket(int i) {
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item.target_system = 1;
        mavlink_msg_mission_new_item.target_component = 0;
        mavlink_msg_mission_new_item.command = 107;
        mavlink_msg_mission_new_item.param1 = (float) i;
        return mavlink_msg_mission_new_item.pack();
    }

    public static MAVLinkPacket createSetDroneLocationToHomePacket() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 179;
        msg_command_long.param1 = 1.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createSetPhoneLocationToHomePacket(float f, float f2) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 179;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = f;
        msg_command_long.param6 = f2;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createOpenFlydataPacket() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 105;
        msg_command_long.param1 = 1.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createRequestFollowPointDataPacket() {
        mavlink_msg_mission_new_item mavlink_msg_mission_new_item = new mavlink_msg_mission_new_item();
        mavlink_msg_mission_new_item.target_system = 1;
        mavlink_msg_mission_new_item.target_component = 0;
        mavlink_msg_mission_new_item.command = 111;
        return mavlink_msg_mission_new_item.pack();
    }

    public static MAVLinkPacket createVirtualJoystickControlModePacket(int i) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 23;
        msg_command_long.param1 = (float) i;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createVirtualJoystickStatePacket(AutelVirtualJoystickState autelVirtualJoystickState) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 24;
        msg_command_long.param1 = autelVirtualJoystickState.getCtrModeMask();
        msg_command_long.param2 = autelVirtualJoystickState.pitchStick;
        msg_command_long.param3 = autelVirtualJoystickState.rollStick;
        msg_command_long.param4 = autelVirtualJoystickState.yawStick;
        msg_command_long.param5 = autelVirtualJoystickState.verticalStick;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }

    public static MAVLinkPacket createVirtualJoystickYawModeStatePacket(int i, float f) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 25;
        msg_command_long.param1 = (float) i;
        msg_command_long.param2 = f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }
}
