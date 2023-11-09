package org.droidplanner.services.android.impl.core.MAVLink.command.doCmd;

import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_digicam_control;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_control;
import com.atakmap.android.uastool.MAVLink.common.msg_command_long;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_set_current;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class MavLinkDoCmds {
    public static void setVehicleHome(MavLinkDrone mavLinkDrone, LatLongAlt latLongAlt, ICommandListener iCommandListener) {
        if (mavLinkDrone != null && latLongAlt != null) {
            msg_command_long msg_command_long = new msg_command_long();
            msg_command_long.target_system = mavLinkDrone.getSysid();
            msg_command_long.target_component = mavLinkDrone.getCompid();
            msg_command_long.command = 179;
            msg_command_long.param5 = (float) latLongAlt.getLatitude();
            msg_command_long.param6 = (float) latLongAlt.getLongitude();
            msg_command_long.param7 = (float) latLongAlt.getAltitude();
            mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
        }
    }

    public static void setROI(MavLinkDrone mavLinkDrone, LatLongAlt latLongAlt, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            msg_command_long msg_command_long = new msg_command_long();
            msg_command_long.target_system = mavLinkDrone.getSysid();
            msg_command_long.target_component = mavLinkDrone.getCompid();
            msg_command_long.command = 201;
            msg_command_long.param5 = (float) latLongAlt.getLatitude();
            msg_command_long.param6 = (float) latLongAlt.getLongitude();
            msg_command_long.param7 = (float) latLongAlt.getAltitude();
            mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
        }
    }

    public static void resetROI(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            setROI(mavLinkDrone, new LatLongAlt(0.0d, 0.0d, 0.0d), iCommandListener);
        }
    }

    public static void triggerCamera(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone != null) {
            msg_digicam_control msg_digicam_control = new msg_digicam_control();
            msg_digicam_control.target_system = mavLinkDrone.getSysid();
            msg_digicam_control.target_component = mavLinkDrone.getCompid();
            msg_digicam_control.shot = 1;
            mavLinkDrone.getMavClient().sendMessage(msg_digicam_control, (ICommandListener) null);
        }
    }

    public static void empCommand(MavLinkDrone mavLinkDrone, boolean z, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            msg_command_long msg_command_long = new msg_command_long();
            msg_command_long.target_system = mavLinkDrone.getSysid();
            msg_command_long.target_component = mavLinkDrone.getCompid();
            msg_command_long.command = MAV_CMD.MAV_CMD_DO_GRIPPER;
            msg_command_long.param2 = z ? 0.0f : 1.0f;
            mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
        }
    }

    public static void setRelay(MavLinkDrone mavLinkDrone, int i, boolean z, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            msg_command_long msg_command_long = new msg_command_long();
            msg_command_long.target_system = mavLinkDrone.getSysid();
            msg_command_long.target_component = mavLinkDrone.getCompid();
            msg_command_long.command = 181;
            msg_command_long.param1 = (float) i;
            msg_command_long.param2 = z ? 1.0f : 0.0f;
            mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
        }
    }

    public static void setServo(MavLinkDrone mavLinkDrone, int i, int i2, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            msg_command_long msg_command_long = new msg_command_long();
            msg_command_long.target_system = mavLinkDrone.getSysid();
            msg_command_long.target_component = mavLinkDrone.getCompid();
            msg_command_long.command = 183;
            msg_command_long.param1 = (float) i;
            msg_command_long.param2 = (float) i2;
            mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
        }
    }

    public static void setGimbalOrientation(MavLinkDrone mavLinkDrone, float f, float f2, float f3, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            msg_mount_control msg_mount_control = new msg_mount_control();
            msg_mount_control.target_system = mavLinkDrone.getSysid();
            msg_mount_control.target_component = mavLinkDrone.getCompid();
            msg_mount_control.input_a = (int) (f * 100.0f);
            msg_mount_control.input_b = (int) (f2 * 100.0f);
            msg_mount_control.input_c = (int) (f3 * 100.0f);
            mavLinkDrone.getMavClient().sendMessage(msg_mount_control, iCommandListener);
        }
    }

    public static void gotoWaypoint(MavLinkDrone mavLinkDrone, int i, ICommandListener iCommandListener) {
        if (mavLinkDrone != null) {
            msg_mission_set_current msg_mission_set_current = new msg_mission_set_current();
            msg_mission_set_current.seq = i;
            mavLinkDrone.getMavClient().sendMessage(msg_mission_set_current, iCommandListener);
        }
    }
}
