package org.droidplanner.services.android.impl.core.MAVLink;

import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;

public class MavLinkMsgHandler {
    public static final int AUTOPILOT_COMPONENT_ID = 1;
    private final MavLinkDroneManager droneMgr;

    public MavLinkMsgHandler(MavLinkDroneManager mavLinkDroneManager) {
        this.droneMgr = mavLinkDroneManager;
    }

    public void receiveData(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.compid == 1 && mAVLinkMessage.msgid == 0) {
            handleHeartbeat((msg_heartbeat) mAVLinkMessage);
        }
    }

    private void handleHeartbeat(msg_heartbeat msg_heartbeat) {
        short s = msg_heartbeat.autopilot;
        if (s == 3) {
            short s2 = msg_heartbeat.type;
            if (s2 != 0) {
                if (s2 == 1) {
                    this.droneMgr.onVehicleTypeReceived(FirmwareType.ARDU_PLANE);
                    return;
                } else if (!(s2 == 2 || s2 == 3 || s2 == 4)) {
                    if (s2 == 10 || s2 == 11) {
                        this.droneMgr.onVehicleTypeReceived(FirmwareType.ARDU_ROVER);
                        return;
                    }
                    switch (s2) {
                        case 13:
                        case 14:
                        case 15:
                            break;
                        default:
                            return;
                    }
                }
            }
            this.droneMgr.onVehicleTypeReceived(FirmwareType.ARDU_COPTER);
        } else if (s != 12) {
            this.droneMgr.onVehicleTypeReceived(FirmwareType.GENERIC);
        } else {
            this.droneMgr.onVehicleTypeReceived(FirmwareType.PX4_NATIVE);
        }
    }
}
