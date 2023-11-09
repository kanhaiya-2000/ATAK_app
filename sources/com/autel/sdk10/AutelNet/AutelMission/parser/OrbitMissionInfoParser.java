package com.autel.sdk10.AutelNet.AutelMission.parser;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.mavlink_msg_mission_new_current;
import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.CurrentMissionState;
import com.autel.internal.sdk.mission.AutelOrbitRealTimeInfoInternal;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelMission.interfaces.AutelMissionInterface;
import java.util.concurrent.ConcurrentHashMap;

public class OrbitMissionInfoParser extends AutelOrbitRealTimeInfoInternal {
    private static OrbitMissionInfoParser instance_;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, AutelMissionInterface.IOrbitRealtimeInfoListener> HpRealTimeInfoListenerMaps = new ConcurrentHashMap<>();

    public static OrbitMissionInfoParser getInstance_() {
        if (instance_ == null) {
            instance_ = new OrbitMissionInfoParser();
        }
        return instance_;
    }

    private OrbitMissionInfoParser() {
    }

    public void parseMAVLinkMessage(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.msgid == 221) {
            mavlink_msg_mission_new_current mavlink_msg_mission_new_current = (mavlink_msg_mission_new_current) mAVLinkMessage;
            setRadius(mavlink_msg_mission_new_current.radius);
            setLap(mavlink_msg_mission_new_current.seq);
            setVelocitySpeed(mavlink_msg_mission_new_current.velocity_sp);
            setCoord(new AutelCoordinate3D((double) ((float) (((double) mavlink_msg_mission_new_current.hotpoint_lat) * 1.0E7d)), (double) ((float) (((double) mavlink_msg_mission_new_current.hotpoint_lng) * 1.0E7d))));
            callbackRealTimeInfo();
        }
    }

    public void addRealTimeOrbitInfoListener(String str, AutelMissionInterface.IOrbitRealtimeInfoListener iOrbitRealtimeInfoListener) {
        this.HpRealTimeInfoListenerMaps.put(str, iOrbitRealtimeInfoListener);
    }

    public void removeRealTimeOrbitInfoListener(String str) {
        this.HpRealTimeInfoListenerMaps.remove(str);
    }

    private void callbackRealTimeInfo() {
        if (!this.HpRealTimeInfoListenerMaps.isEmpty()) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    for (AutelMissionInterface.IOrbitRealtimeInfoListener onOrbitRealtimeInfo : OrbitMissionInfoParser.this.HpRealTimeInfoListenerMaps.values()) {
                        onOrbitRealtimeInfo.onOrbitRealtimeInfo(OrbitMissionInfoParser.this);
                    }
                }
            });
        }
    }

    public CurrentMissionState getCurrentMissionState() {
        return MissionStateParser.getInstance_().getCurrentMissionState();
    }

    public String toString() {
        return "VelocitySpeed = " + getAngularVelocity() + ",Lap = " + getLap() + ",Coord = " + getCoordinate() + ",Radius = " + getRadius() + ",CurrentMissionState =" + getCurrentMissionState();
    }
}
