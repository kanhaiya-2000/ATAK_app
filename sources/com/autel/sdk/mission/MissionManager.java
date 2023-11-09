package com.autel.sdk.mission;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.sdk.mission.p009rx.RxMissionManager;

public interface MissionManager {
    void cancelMission(int i, CallbackWithNoParam callbackWithNoParam);

    void cancelMission(CallbackWithNoParam callbackWithNoParam);

    void downloadMission(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress);

    void downloadMissionForEvo(CallbackWithOneParamProgress<C2700AutelMission> callbackWithOneParamProgress);

    C2700AutelMission getCurrentMission();

    MissionExecuteState getMissionExecuteState();

    void pauseMission(CallbackWithNoParam callbackWithNoParam);

    void prepareMission(C2700AutelMission autelMission, CallbackWithOneParamProgress<Boolean> callbackWithOneParamProgress);

    void resumeMission(CallbackWithNoParam callbackWithNoParam);

    void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam);

    void startMission(CallbackWithNoParam callbackWithNoParam);

    RxMissionManager toRx();

    void yawRestore(CallbackWithNoParam callbackWithNoParam);
}
