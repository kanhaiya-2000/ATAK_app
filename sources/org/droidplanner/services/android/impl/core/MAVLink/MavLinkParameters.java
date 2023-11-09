package org.droidplanner.services.android.impl.core.MAVLink;

import com.atakmap.android.uastool.MAVLink.common.msg_param_request_list;
import com.atakmap.android.uastool.MAVLink.common.msg_param_request_read;
import com.atakmap.android.uastool.MAVLink.common.msg_param_set;
import com.o3dr.services.android.lib.drone.property.Parameter;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class MavLinkParameters {
    public static void requestParametersList(MavLinkDrone mavLinkDrone) {
        msg_param_request_list msg_param_request_list = new msg_param_request_list();
        msg_param_request_list.target_system = mavLinkDrone.getSysid();
        msg_param_request_list.target_component = mavLinkDrone.getCompid();
        mavLinkDrone.getMavClient().sendMessage(msg_param_request_list, (ICommandListener) null);
    }

    public static void readParameter(MavLinkDrone mavLinkDrone, String str) {
        msg_param_request_read msg_param_request_read = new msg_param_request_read();
        msg_param_request_read.param_index = -1;
        msg_param_request_read.target_system = mavLinkDrone.getSysid();
        msg_param_request_read.target_component = mavLinkDrone.getCompid();
        msg_param_request_read.setParam_Id(str);
        mavLinkDrone.getMavClient().sendMessage(msg_param_request_read, (ICommandListener) null);
    }

    public static void readParameter(MavLinkDrone mavLinkDrone, int i) {
        msg_param_request_read msg_param_request_read = new msg_param_request_read();
        msg_param_request_read.target_system = mavLinkDrone.getSysid();
        msg_param_request_read.target_component = mavLinkDrone.getCompid();
        msg_param_request_read.param_index = (short) i;
        mavLinkDrone.getMavClient().sendMessage(msg_param_request_read, (ICommandListener) null);
    }

    public static void sendParameter(MavLinkDrone mavLinkDrone, Parameter parameter) {
        sendParameter(mavLinkDrone, parameter.getName(), parameter.getType(), (float) parameter.getValue());
    }

    public static void sendParameter(MavLinkDrone mavLinkDrone, String str, int i, float f) {
        msg_param_set msg_param_set = new msg_param_set();
        msg_param_set.target_system = mavLinkDrone.getSysid();
        msg_param_set.target_component = mavLinkDrone.getCompid();
        msg_param_set.setParam_Id(str);
        msg_param_set.param_type = (short) ((byte) i);
        msg_param_set.param_value = f;
        mavLinkDrone.getMavClient().sendMessage(msg_param_set, (ICommandListener) null);
    }
}
