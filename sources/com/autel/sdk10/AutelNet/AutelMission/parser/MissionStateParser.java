package com.autel.sdk10.AutelNet.AutelMission.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.mavlink_msg_mission_new_current;
import com.autel.internal.sdk.mission.AutelMissionStateInternal;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;

public class MissionStateParser extends AutelMissionStateInternal {
    private static MissionStateParser instance_;

    private MissionStateParser() {
    }

    public static MissionStateParser getInstance_() {
        if (instance_ == null) {
            instance_ = new MissionStateParser();
        }
        return instance_;
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        mavlink_msg_mission_new_current mavlink_msg_mission_new_current = (mavlink_msg_mission_new_current) mAVLinkMessage;
        setCurrentMissionState(mavlink_msg_mission_new_current.wp_mode);
        byte b = mavlink_msg_mission_new_current.wp_mode;
        if (b == 0) {
            MissionManager.getAutelWaypointMissionInfoParser().parseMAVLinkMessage(mAVLinkMessage);
        } else if (b == 1 || b == 2) {
            MissionManager.getAutelOrbitMissionInfoParser().parseMAVLinkMessage(mAVLinkMessage);
        }
    }
}
