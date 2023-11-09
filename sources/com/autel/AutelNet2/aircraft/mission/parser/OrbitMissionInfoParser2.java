package com.autel.AutelNet2.aircraft.mission.parser;

import com.autel.AutelNet2.aircraft.mission.message.MissionStatusPacket;
import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.xstar.OrbitRealTimeInfo;
import com.autel.internal.sdk.mission.AutelOrbitRealTimeInfoInternal;

public class OrbitMissionInfoParser2 extends AutelOrbitRealTimeInfoInternal {
    private static OrbitMissionInfoParser2 mInstance;

    public static OrbitMissionInfoParser2 getInstance() {
        if (mInstance == null) {
            mInstance = new OrbitMissionInfoParser2();
        }
        return mInstance;
    }

    public OrbitRealTimeInfo parseData(MissionStatusPacket missionStatusPacket) {
        setRadius(missionStatusPacket.radius);
        setLap(missionStatusPacket.seq);
        setVelocitySpeed(missionStatusPacket.velocity_sp);
        setCoord(new AutelCoordinate3D((double) ((float) (((double) missionStatusPacket.hotpoint_lat) * 1.0E7d)), (double) ((float) (((double) missionStatusPacket.hotpoint_lng) * 1.0E7d))));
        return this;
    }
}
