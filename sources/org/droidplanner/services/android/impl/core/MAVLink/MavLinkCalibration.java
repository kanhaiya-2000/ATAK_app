package org.droidplanner.services.android.impl.core.MAVLink;

import com.atakmap.android.uastool.MAVLink.common.msg_command_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_command_long;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class MavLinkCalibration {
    public static void sendCalibrationAckMessage(MavLinkDrone mavLinkDrone, int i) {
        msg_command_ack msg_command_ack = new msg_command_ack();
        msg_command_ack.command = i;
        msg_command_ack.result = 1;
        mavLinkDrone.getMavClient().sendMessage(msg_command_ack, (ICommandListener) null);
    }

    public static void startAccelerometerCalibration(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = 241;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 1.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 0;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void startMagnetometerCalibration(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        startMagnetometerCalibration(mavLinkDrone, false, false, 0, iCommandListener);
    }

    public static void startMagnetometerCalibration(MavLinkDrone mavLinkDrone, boolean z, boolean z2, int i, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = MAV_CMD.MAV_CMD_DO_START_MAG_CAL;
        msg_command_long.param1 = 0.0f;
        float f = 1.0f;
        msg_command_long.param2 = z ? 1.0f : 0.0f;
        if (!z2) {
            f = 0.0f;
        }
        msg_command_long.param3 = f;
        msg_command_long.param4 = i > 0 ? (float) i : 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void cancelMagnetometerCalibration(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = MAV_CMD.MAV_CMD_DO_CANCEL_MAG_CAL;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }

    public static void acceptMagnetometerCalibration(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = mavLinkDrone.getSysid();
        msg_command_long.target_component = mavLinkDrone.getCompid();
        msg_command_long.command = MAV_CMD.MAV_CMD_DO_ACCEPT_MAG_CAL;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        mavLinkDrone.getMavClient().sendMessage(msg_command_long, iCommandListener);
    }
}
