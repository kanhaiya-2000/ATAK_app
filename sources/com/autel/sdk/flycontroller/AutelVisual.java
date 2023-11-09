package com.autel.sdk.flycontroller;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.visual.ViewPointTargetArea;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;

public interface AutelVisual {
    void getVisualSettingInfo(CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam);

    void setAvoidanceRadarInfoListener(CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam);

    void setViewpointInfoListener(CallbackWithOneParam<ViewPointTargetArea> callbackWithOneParam);

    void setVisualDigitalZoom(int i, CallbackWithNoParam callbackWithNoParam);

    void setVisualFollowMode(DynamicTrackMode dynamicTrackMode, CallbackWithNoParam callbackWithNoParam);

    void setVisualSettingEnable(VisualSettingSwitchblade visualSettingSwitchblade, boolean z, CallbackWithNoParam callbackWithNoParam);

    void setVisualSettingInfoListener(CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam);

    void setVisualSettingParams(VisualSettingSwitchblade visualSettingSwitchblade, int i, CallbackWithNoParam callbackWithNoParam);

    void setVisualViewPointCoordinate(float f, float f2, float f3, CallbackWithNoParam callbackWithNoParam);

    void setVisualViewPointSpeed(float f, CallbackWithNoParam callbackWithNoParam);

    void setVisualWarnListener(CallbackWithOneParam<VisualWarningInfo> callbackWithOneParam);

    void updateVisualResolutionAngle(CallbackWithNoParam callbackWithNoParam);
}
