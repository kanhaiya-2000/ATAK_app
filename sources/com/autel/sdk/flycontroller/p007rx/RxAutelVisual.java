package com.autel.sdk.flycontroller.p007rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.visual.ViewPointTargetArea;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.flycontroller.rx.RxAutelVisual */
public interface RxAutelVisual {
    Observable<VisualSettingInfo> getVisualSettingInfo();

    void setAvoidanceRadarInfoListener(CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam);

    void setViewpointInfoListener(CallbackWithOneParam<ViewPointTargetArea> callbackWithOneParam);

    Observable<Boolean> setVisualFollowMode(DynamicTrackMode dynamicTrackMode);

    Observable<Boolean> setVisualSettingEnable(VisualSettingSwitchblade visualSettingSwitchblade, boolean z);

    void setVisualSettingInfoListener(CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam);

    Observable<Boolean> setVisualViewPointCoordinate(float f, float f2, float f3);

    Observable<Boolean> setVisualViewPointSpeed(float f);

    void setVisualWarnListener(CallbackWithOneParam<VisualWarningInfo> callbackWithOneParam);

    Observable<Boolean> updateVisualResolutionAngle();
}
