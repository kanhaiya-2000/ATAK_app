package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket;

import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.ardupilotmega.msg_command_long;
import com.MAVLink.Messages.ardupilotmega.msg_param_request_read;
import com.MAVLink.Messages.ardupilotmega.msg_param_set;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.Parameter;

public final class ParametersMavLinkPacketFactory {
    private ParametersMavLinkPacketFactory() {
    }

    public static MAVLinkPacket createSendParameterPacket(Parameter parameter) {
        msg_param_set msg_param_set = new msg_param_set();
        msg_param_set.target_system = 1;
        msg_param_set.target_component = 50;
        msg_param_set.setParam_Id(parameter.getName());
        msg_param_set.param_type = (byte) parameter.getType();
        msg_param_set.param_value = (float) parameter.getValue();
        return msg_param_set.pack();
    }

    public static MAVLinkPacket createReadParameterNamePacket(String str) {
        msg_param_request_read msg_param_request_read = new msg_param_request_read();
        msg_param_request_read.param_index = -1;
        msg_param_request_read.target_system = 1;
        msg_param_request_read.target_component = 50;
        msg_param_request_read.setParam_Id(str);
        return msg_param_request_read.pack();
    }

    public static MAVLinkPacket createConfirmationPacket() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 0;
        msg_command_long.command = 245;
        msg_command_long.param1 = 1.0f;
        msg_command_long.param2 = -1.0f;
        msg_command_long.param3 = -1.0f;
        msg_command_long.param4 = -1.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        msg_command_long.confirmation = 1;
        return msg_command_long.pack();
    }
}
