package org.droidplanner.services.android.impl.core.MAVLink;

import com.atakmap.android.uastool.MAVLink.common.msg_rc_channels_override;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class MavLinkRC {
    public static void sendRcOverrideMsg(MavLinkDrone mavLinkDrone, int[] iArr) {
        msg_rc_channels_override msg_rc_channels_override = new msg_rc_channels_override();
        msg_rc_channels_override.chan1_raw = (short) iArr[0];
        msg_rc_channels_override.chan2_raw = (short) iArr[1];
        msg_rc_channels_override.chan3_raw = (short) iArr[2];
        msg_rc_channels_override.chan4_raw = (short) iArr[3];
        msg_rc_channels_override.chan5_raw = (short) iArr[4];
        msg_rc_channels_override.chan6_raw = (short) iArr[5];
        msg_rc_channels_override.chan7_raw = (short) iArr[6];
        msg_rc_channels_override.chan8_raw = (short) iArr[7];
        msg_rc_channels_override.target_system = mavLinkDrone.getSysid();
        msg_rc_channels_override.target_component = mavLinkDrone.getCompid();
        mavLinkDrone.getMavClient().sendMessage(msg_rc_channels_override, (ICommandListener) null);
    }
}
