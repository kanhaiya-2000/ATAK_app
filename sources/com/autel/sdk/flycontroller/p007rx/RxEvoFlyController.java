package com.autel.sdk.flycontroller.p007rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.flycontroller.rx.RxEvoFlyController */
public interface RxEvoFlyController extends RxAutelFlyController, RxAutelVisual {
    Observable<Boolean> cancelMission(int i);

    Observable<Boolean> droneArmed();

    Observable<Boolean> droneDisarmed();

    Observable<BoatMode> getBoatMode();

    Observable<EvoFlyControllerParameterRangeManager> getParameterRangeManager();

    boolean isSupportBoatMode();

    Observable<VisualSettingInfo> isVisualSettingEnable();

    Observable<Boolean> setAircraftHeadingDirection(int i);

    Observable<Boolean> setBoatMode(BoatMode boatMode);

    void setFlyControllerInfoListener(CallbackWithOneParam<EvoFlyControllerInfo> callbackWithOneParam);

    void setRadarInfoListener(CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam);

    void setVisualWarnListener(CallbackWithOneParam<VisualWarningInfo> callbackWithOneParam);
}
