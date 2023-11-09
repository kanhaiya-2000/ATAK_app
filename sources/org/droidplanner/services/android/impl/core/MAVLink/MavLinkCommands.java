package org.droidplanner.services.android.impl.core.MAVLink;

import com.atakmap.android.uastool.MAVLink.common.msg_command_long;
import com.atakmap.android.uastool.MAVLink.common.msg_manual_control;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.MAVLink.common.msg_set_mode;
import com.atakmap.android.uastool.MAVLink.common.msg_set_position_target_global_int;
import com.atakmap.android.uastool.MAVLink.common.msg_set_position_target_local_ned;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.variables.ApmModes;

public class MavLinkCommands {
    public static final int EMERGENCY_DISARM_MAGIC_NUMBER = 21196;
    private static final int MAVLINK_SET_POS_TYPE_MASK_ACC_IGNORE = 448;
    private static final int MAVLINK_SET_POS_TYPE_MASK_POS_IGNORE = 7;
    private static final int MAVLINK_SET_POS_TYPE_MASK_VEL_IGNORE = 56;

    public static void changeMissionSpeed(MavLinkDrone mavLinkDrone, float f, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 178;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = f;
        msg_command_long.param3 = 0.0f;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void setGuidedMode(MavLinkDrone mavLinkDrone, double d, double d2, double d3) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.seq = 0;
        msg_mission_item.current = 2;
        msg_mission_item.frame = 3;
        msg_mission_item.command = 16;
        msg_mission_item.param1 = 0.0f;
        msg_mission_item.param2 = 0.0f;
        msg_mission_item.param3 = 0.0f;
        msg_mission_item.param4 = 0.0f;
        msg_mission_item.f8319x = (float) d;
        msg_mission_item.f8320y = (float) d2;
        msg_mission_item.f8321z = (float) d3;
        msg_mission_item.autocontinue = 1;
        msg_mission_item.target_system = mavLinkDrone.getSysid();
        msg_mission_item.target_component = mavLinkDrone.getCompid();
        mavLinkDrone.getMavClient().sendMessage(msg_mission_item, (ICommandListener) null);
    }

    public static void sendGuidedPosition(MavLinkDrone mavLinkDrone, double d, double d2, double d3) {
        msg_set_position_target_global_int msg_set_position_target_global_int = new msg_set_position_target_global_int();
        msg_set_position_target_global_int.type_mask = 504;
        msg_set_position_target_global_int.coordinate_frame = 6;
        msg_set_position_target_global_int.lat_int = (int) (d * 1.0E7d);
        msg_set_position_target_global_int.lon_int = (int) (d2 * 1.0E7d);
        msg_set_position_target_global_int.alt = (float) d3;
        msg_set_position_target_global_int.target_system = mavLinkDrone.getSysid();
        msg_set_position_target_global_int.target_component = mavLinkDrone.getCompid();
        mavLinkDrone.getMavClient().sendMessage(msg_set_position_target_global_int, (ICommandListener) null);
    }

    public static void sendGuidedVelocity(MavLinkDrone mavLinkDrone, double d, double d2, double d3) {
        msg_set_position_target_global_int msg_set_position_target_global_int = new msg_set_position_target_global_int();
        msg_set_position_target_global_int.type_mask = 455;
        msg_set_position_target_global_int.coordinate_frame = 6;
        msg_set_position_target_global_int.f8339vx = (float) d;
        msg_set_position_target_global_int.f8340vy = (float) d2;
        msg_set_position_target_global_int.f8341vz = (float) d3;
        msg_set_position_target_global_int.target_system = mavLinkDrone.getSysid();
        msg_set_position_target_global_int.target_component = mavLinkDrone.getCompid();
        mavLinkDrone.getMavClient().sendMessage(msg_set_position_target_global_int, (ICommandListener) null);
    }

    public static void setVelocityInLocalFrame(MavLinkDrone mavLinkDrone, float f, float f2, float f3, ICommandListener iCommandListener) {
        msg_set_position_target_local_ned msg_set_position_target_local_ned = new msg_set_position_target_local_ned();
        msg_set_position_target_local_ned.type_mask = 455;
        msg_set_position_target_local_ned.f8342vx = f;
        msg_set_position_target_local_ned.f8343vy = f2;
        msg_set_position_target_local_ned.f8344vz = f3;
        msg_set_position_target_local_ned.target_system = mavLinkDrone.getSysid();
        msg_set_position_target_local_ned.target_component = mavLinkDrone.getCompid();
        mavLinkDrone.getMavClient().sendMessage(msg_set_position_target_local_ned, iCommandListener);
    }

    public static void sendGuidedPositionAndVelocity(MavLinkDrone mavLinkDrone, double d, double d2, double d3, double d4, double d5, double d6) {
        msg_set_position_target_global_int msg_set_position_target_global_int = new msg_set_position_target_global_int();
        msg_set_position_target_global_int.type_mask = MAVLINK_SET_POS_TYPE_MASK_ACC_IGNORE;
        msg_set_position_target_global_int.coordinate_frame = 6;
        msg_set_position_target_global_int.lat_int = (int) (d * 1.0E7d);
        msg_set_position_target_global_int.lon_int = (int) (d2 * 1.0E7d);
        msg_set_position_target_global_int.alt = (float) d3;
        msg_set_position_target_global_int.f8339vx = (float) d4;
        msg_set_position_target_global_int.f8340vy = (float) d5;
        msg_set_position_target_global_int.f8341vz = (float) d6;
        msg_set_position_target_global_int.target_system = mavLinkDrone.getSysid();
        msg_set_position_target_global_int.target_component = mavLinkDrone.getCompid();
        mavLinkDrone.getMavClient().sendMessage(msg_set_position_target_global_int, (ICommandListener) null);
    }

    public static void changeFlightMode(MavLinkDrone mavLinkDrone, ApmModes apmModes, ICommandListener iCommandListener) {
        msg_set_mode msg_set_mode = new msg_set_mode();
        msg_set_mode.target_system = mavLinkDrone.getSysid();
        msg_set_mode.base_mode = 1;
        msg_set_mode.custom_mode = apmModes.getNumber();
        mavLinkDrone.getMavClient().sendMessage(msg_set_mode, iCommandListener);
    }

    public static void setConditionYaw(MavLinkDrone mavLinkDrone, float f, float f2, boolean z, boolean z2, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 115;
        msg_command_long.param1 = f;
        msg_command_long.param2 = f2;
        float f3 = 1.0f;
        msg_command_long.param3 = z ? 1.0f : -1.0f;
        if (!z2) {
            f3 = 0.0f;
        }
        msg_command_long.param4 = f3;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void sendManualControl(MavLinkDrone mavLinkDrone, short s, short s2, short s3, short s4, int i, ICommandListener iCommandListener) {
        msg_manual_control msg_manual_control = new msg_manual_control();
        msg_manual_control.target = mavLinkDrone.getSysid();
        msg_manual_control.f8316x = s;
        msg_manual_control.f8317y = s2;
        msg_manual_control.f8318z = s3;
        msg_manual_control.f8315r = s4;
        msg_manual_control.buttons = i;
        mavLinkDrone.getMavClient().sendMessage(msg_manual_control, iCommandListener);
    }

    public static void sendTakeoff(MavLinkDrone mavLinkDrone, double d, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 22;
        msg_command_long.param7 = (float) d;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void sendNavLand(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 21;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void sendNavRTL(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 20;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void sendPause(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 252;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 2.0f;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void startMission(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 300;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void sendArmMessage(MavLinkDrone mavLinkDrone, boolean z, boolean z2, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 400;
        msg_command_long.param1 = z ? 1.0f : 0.0f;
        msg_command_long.param2 = z2 ? 21196.0f : 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 0;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void sendFlightTermination(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 185;
        msg_command_long.param1 = 1.0f;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }
}
