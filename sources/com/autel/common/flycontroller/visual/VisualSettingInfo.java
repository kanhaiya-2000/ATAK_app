package com.autel.common.flycontroller.visual;

import com.autel.common.flycontroller.AuxiliaryLedState;
import com.autel.common.flycontroller.OrbitModeState;
import com.autel.common.flycontroller.VisualTrackState;
import com.autel.common.flycontroller.VisualWarnState;

public interface VisualSettingInfo {
    AuxiliaryLedState getAuxiliaryLedState();

    DynamicTrackMode getFollowMode();

    OrbitModeState getOrbitModeState();

    int getSpeed();

    VisualMainFlyState getVisualMainFlyState();

    VisualTrackState getVisualTrackState();

    VisualWarnState getVisualWarnState();

    boolean isAvoidInHorizontal();

    boolean isAvoidanceEnableWhenTracking();

    boolean isAvoidanceSystemEnable();

    boolean isCalibrationMode();

    boolean isDetectObstacleEnableWhenReturn();

    boolean isGestureRecognizationMode();

    boolean isImageMode();

    boolean isLandingAccuratelyEnable();

    boolean isLandingProtectEnable();

    boolean isPointFlyInsideMode();

    boolean isPointFlyMode();

    boolean isPullBackEnableWhenTracking();

    boolean isRadarMapEnable();

    boolean isVisualCalibrationValid();

    boolean isVisualLeftBottomState();

    boolean isVisualLeftFontState();

    boolean isVisualLeftLeftState();

    boolean isVisualLeftNearState();

    boolean isVisualLeftRightState();

    boolean isVisualLeftTopState();

    boolean isVisualLimitWhenDark();

    boolean isVisualLocationEnable();

    boolean isVisualReady();

    boolean isVisualRightBottomState();

    boolean isVisualRightFontState();

    boolean isVisualRightLeftState();

    boolean isVisualRightNearState();

    boolean isVisualRightRightState();

    boolean isVisualRightTopState();
}
