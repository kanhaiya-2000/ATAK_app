package com.autel.sdk.flycontroller.p007rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.visual.TrackTargetArea;
import com.autel.common.camera.visual.TrackingAction;
import com.autel.common.camera.visual.TrackingGoalArea;
import com.autel.common.camera.visual.ViewpointAction;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import io.reactivex.Observable;
import java.util.List;

/* renamed from: com.autel.sdk.flycontroller.rx.RxEvo2Visual */
public interface RxEvo2Visual extends RxAutelVisual {
    void setOrbitTargetListener(CallbackWithOneParam<TrackTargetArea> callbackWithOneParam);

    Observable<Boolean> setTrackingMode(TrackingAction trackingAction);

    void setTrackingTargetListener(CallbackWithTwoParams<List<TrackingGoalArea>, Boolean> callbackWithTwoParams);

    Observable<Boolean> setViewpointAction(ViewpointAction viewpointAction);

    Observable<Boolean> setVisualDigitalZoom(int i);

    Observable<Boolean> setVisualSettingParams(VisualSettingSwitchblade visualSettingSwitchblade, int i);

    Observable<Boolean> setVisualViewPointCoordinate(float f, float f2);
}
