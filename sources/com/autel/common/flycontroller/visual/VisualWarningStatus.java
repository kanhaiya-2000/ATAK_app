package com.autel.common.flycontroller.visual;

import com.autel.common.flycontroller.AuxiliaryLedState;
import com.autel.common.flycontroller.OrbitModeState;
import com.autel.common.flycontroller.VisualTrackState;
import com.autel.common.flycontroller.VisualWarnState;

public interface VisualWarningStatus {
    OrbitModeState getOrbitModeState();

    int getSpeed();

    VisualTrackState getTrackState();

    AuxiliaryLedState getVisualLedState();

    VisualMainFlyState getVisualMainFlyState();

    VisualWarnState getVisualWarnState();

    boolean isAvoidanceEnable();

    boolean isCalibrationMode();

    boolean isCameraMode();

    boolean isGestureRecognizationEnable();

    boolean isLandingAccurateEnable();

    boolean isLandingProtectionEnable();

    boolean isOdometerEnable();

    boolean isPointFlyLeftRightEnable();

    boolean isPointflyInsideMode();

    boolean isPointflyMode();

    boolean isRTHAvoidanceEnable();

    boolean isShowRadar();

    boolean isTerrainFollowEnable();

    boolean isTrackingAvoidanceEnable();

    boolean isTrackingBackOffEnable();

    boolean isTripodMode();

    boolean isVisualCalibrationValid();

    boolean isVisualLeftBottomState();

    boolean isVisualLeftFontState();

    boolean isVisualLeftLeftState();

    boolean isVisualLeftNearState();

    boolean isVisualLeftRightState();

    boolean isVisualLeftTopState();

    boolean isVisualLimitWhenDark();

    boolean isVisualReady();

    boolean isVisualRightBottomState();

    boolean isVisualRightFontState();

    boolean isVisualRightLeftState();

    boolean isVisualRightNearState();

    boolean isVisualRightRightState();

    boolean isVisualRightTopState();
}
