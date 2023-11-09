package com.autel.sdk.mission.p009rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.RealTimeInfo;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.mission.rx.RxMissionManager */
public interface RxMissionManager {
    Observable<Boolean> cancelMission();

    Observable<Boolean> cancelMission(int i);

    Observable<C2700AutelMission> downloadMission();

    Observable<C2700AutelMission> downloadMissionForEvo();

    Observable<C2700AutelMission> getCurrentMission();

    Observable<MissionExecuteState> getMissionExecuteState();

    Observable<Boolean> pauseMission();

    Observable<Boolean> prepareMission(C2700AutelMission autelMission);

    Observable<Boolean> resumeMission();

    void setRealTimeInfoListener(CallbackWithOneParam<RealTimeInfo> callbackWithOneParam);

    Observable<Boolean> startMission();

    Observable<Boolean> yawRestore();
}
