package com.autel.sdk10.AutelNet.AutelMission.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.mavlink_msg_mission_new_item;
import com.MAVLink.Messages.ardupilotmega.msg_command_ack;
import com.autel.internal.sdk.mission.AutelOrbit;
import com.autel.internal.sdk.mission.MissionFinishedAction;
import com.autel.sdk10.AutelNet.AutelMission.entity.MissionCommonRequestId;
import com.autel.sdk10.AutelNet.AutelMission.enums.AutelOrbitWise;
import com.autel.sdk10.AutelNet.AutelMission.info.AutelMissionInfo;
import java.util.concurrent.ConcurrentHashMap;

public class MissionInfoParser extends AutelMissionInfo {
    private static MissionInfoParser instance_;
    protected float[] YawRecoverStep = {-1.0f, -1.0f};
    protected final ConcurrentHashMap<Integer, CommandAckResult> msg_command_ack_Maps = new ConcurrentHashMap<>();
    protected long updatetime_Orbit;
    protected long updatetime_OrbitWise;
    protected long updatetime_YawRecoverStep;
    protected long updatetime_missonFinishedType;

    public static MissionInfoParser getInstance_() {
        if (instance_ == null) {
            instance_ = new MissionInfoParser();
        }
        return instance_;
    }

    private MissionInfoParser() {
    }

    public synchronized void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        int i = mAVLinkMessage.msgid;
        if (i == 77) {
            parseACK((msg_command_ack) mAVLinkMessage);
        } else if (i == 222) {
            parseMissionItem((mavlink_msg_mission_new_item) mAVLinkMessage);
        }
    }

    private void parseACK(msg_command_ack msg_command_ack) {
        if (msg_command_ack.result != 3 && msg_command_ack.command != 107) {
            this.msg_command_ack_Maps.put(Integer.valueOf(msg_command_ack.command), new CommandAckResult((float) msg_command_ack.result));
        }
    }

    private void parseMissionItem(mavlink_msg_mission_new_item mavlink_msg_mission_new_item) {
        switch (mavlink_msg_mission_new_item.command) {
            case 106:
                this.msg_command_ack_Maps.put(106, new CommandAckResult(0.0f));
                return;
            case 107:
                this.msg_command_ack_Maps.put(107, new CommandAckResult(mavlink_msg_mission_new_item.param1));
                return;
            case 109:
                switch ((int) mavlink_msg_mission_new_item.param1) {
                    case 130:
                        int i = (int) mavlink_msg_mission_new_item.param2;
                        if (i == 0) {
                            this.autelMissionFinishedType = MissionFinishedAction.HOVER;
                        } else if (i == 1) {
                            this.autelMissionFinishedType = MissionFinishedAction.RETURN_HOME;
                        } else if (i == 2) {
                            this.autelMissionFinishedType = MissionFinishedAction.RETURN_TO_MY_LOCATION;
                        }
                        this.updatetime_missonFinishedType = System.currentTimeMillis();
                        return;
                    case 131:
                        this.missionFlySpeed = mavlink_msg_mission_new_item.param2;
                        this.updatetime_missionFlySpeed = System.currentTimeMillis();
                        return;
                    case 132:
                        this.autelOrbitWise = mavlink_msg_mission_new_item.param2 == ((float) AutelOrbitWise.CLOCKWISE.getValue()) ? AutelOrbitWise.CLOCKWISE : AutelOrbitWise.ANTICLOCKWISE;
                        this.updatetime_OrbitWise = System.currentTimeMillis();
                        return;
                    case 133:
                        this.msg_command_ack_Maps.put(Integer.valueOf(MissionCommonRequestId.MyLocationToOrbit), new CommandAckResult(0.0f));
                        return;
                    default:
                        return;
                }
            case 110:
                if (mavlink_msg_mission_new_item.param1 == 1.0f) {
                    this.YawRecoverStep[0] = mavlink_msg_mission_new_item.param1;
                    return;
                }
                this.YawRecoverStep[1] = mavlink_msg_mission_new_item.param1;
                this.updatetime_YawRecoverStep = System.currentTimeMillis();
                return;
            case 111:
                initAutelOrbit(this.autelOrbit, mavlink_msg_mission_new_item);
                this.updatetime_Orbit = System.currentTimeMillis();
                return;
            default:
                return;
        }
    }

    public boolean isNewInfo(int i, long j) {
        CommandAckResult commandAckResult = this.msg_command_ack_Maps.get(Integer.valueOf(i));
        return commandAckResult != null && commandAckResult.updatetime > j;
    }

    public boolean isNewMissionFlySpeedInfo(long j) {
        return this.updatetime_missionFlySpeed > j;
    }

    public boolean isNewYawRecoverInfo(long j) {
        return this.updatetime_YawRecoverStep > j;
    }

    public boolean isNewOrbitInfo(long j) {
        return this.updatetime_Orbit > j;
    }

    public boolean isNewOrbitWiseInfo(long j) {
        return this.updatetime_OrbitWise > j;
    }

    public boolean isNewMissonFinishedTypeInfo(long j) {
        return this.updatetime_missonFinishedType > j;
    }

    public boolean isYawRecoverSucc() {
        float[] fArr = this.YawRecoverStep;
        if (fArr[0] != 1.0f || fArr[1] != 0.0f) {
            return false;
        }
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.updatetime_YawRecoverStep = 0;
        return true;
    }

    public float getResult(int i) {
        return this.msg_command_ack_Maps.get(Integer.valueOf(i)).result;
    }

    protected class CommandAckResult {
        public float result;
        public long updatetime = System.currentTimeMillis();

        public CommandAckResult(float f) {
            this.result = f;
        }
    }

    private void initAutelOrbit(AutelOrbit autelOrbit, mavlink_msg_mission_new_item mavlink_msg_mission_new_item) {
        autelOrbit.setRadius(mavlink_msg_mission_new_item.param1);
        autelOrbit.setSpeed(mavlink_msg_mission_new_item.param2);
        autelOrbit.setReturnHeight(mavlink_msg_mission_new_item.param3);
        autelOrbit.setRound(mavlink_msg_mission_new_item.param5);
        autelOrbit.setMissionFinishTypeValue(mavlink_msg_mission_new_item.param6);
        autelOrbit.setLat((double) mavlink_msg_mission_new_item.f8114x);
        autelOrbit.setLng((double) mavlink_msg_mission_new_item.f8115y);
    }
}
