package com.autel.internal.sdk.flycontroller;

import com.autel.common.flycontroller.AuxiliaryLedState;
import com.autel.common.flycontroller.OrbitModeState;
import com.autel.common.flycontroller.VisualTrackState;
import com.autel.common.flycontroller.VisualWarnState;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualMainFlyState;
import com.autel.common.flycontroller.visual.VisualSettingInfo;

public class VisualSettingInfoImpl implements VisualSettingInfo {
    public AuxiliaryLedState auxiliaryLedState = AuxiliaryLedState.UNKNOWN;
    public DynamicTrackMode followMode = DynamicTrackMode.UNKNOWN;
    public boolean isAvoidInHorizontal;
    public boolean isAvoidanceEnableWhenTracking;
    public boolean isAvoidanceSystemEnable;
    public boolean isCalibrationMode;
    public boolean isDetectObstacleEnableWhenReturn;
    public boolean isGestureRecognizationMode;
    public boolean isImageMode;
    public boolean isLandingAccuratelyEnable;
    public boolean isLandingProtectEnable;
    public boolean isPointFlyInsideMode;
    public boolean isPointFlyMode;
    public boolean isPullBackEnableWhenTracking;
    public boolean isRadarMapEnable;
    public boolean isVisualCalibrationValid;
    public boolean isVisualLeftBottomState;
    public boolean isVisualLeftFontState;
    public boolean isVisualLeftLeftState;
    public boolean isVisualLeftNearState;
    public boolean isVisualLeftRightState;
    public boolean isVisualLeftTopState;
    public boolean isVisualLimitWhenDark;
    public boolean isVisualLocationEnable;
    public boolean isVisualReady;
    public boolean isVisualRightBottomState;
    public boolean isVisualRightFontState;
    public boolean isVisualRightLeftState;
    public boolean isVisualRightNearState;
    public boolean isVisualRightRightState;
    public boolean isVisualRightTopState;
    public OrbitModeState orbitModeState = OrbitModeState.UNKNOWN;
    public int speed;
    public VisualMainFlyState visualMainFlyState = VisualMainFlyState.UNKNOWN;
    public VisualTrackState visualTrackState = VisualTrackState.UNKNOWN;
    public VisualWarnState visualWarnState = VisualWarnState.UNKNOWN;

    public boolean isAvoidanceSystemEnable() {
        return this.isAvoidanceSystemEnable;
    }

    public boolean isAvoidanceEnableWhenTracking() {
        return this.isAvoidanceEnableWhenTracking;
    }

    public boolean isRadarMapEnable() {
        return this.isRadarMapEnable;
    }

    public boolean isPullBackEnableWhenTracking() {
        return this.isPullBackEnableWhenTracking;
    }

    public boolean isLandingProtectEnable() {
        return this.isLandingProtectEnable;
    }

    public boolean isVisualLocationEnable() {
        return this.isVisualLocationEnable;
    }

    public boolean isDetectObstacleEnableWhenReturn() {
        return this.isDetectObstacleEnableWhenReturn;
    }

    public boolean isLandingAccuratelyEnable() {
        return this.isLandingAccuratelyEnable;
    }

    public boolean isAvoidInHorizontal() {
        return this.isAvoidInHorizontal;
    }

    public DynamicTrackMode getFollowMode() {
        return this.followMode;
    }

    public VisualMainFlyState getVisualMainFlyState() {
        return this.visualMainFlyState;
    }

    public VisualWarnState getVisualWarnState() {
        return this.visualWarnState;
    }

    public OrbitModeState getOrbitModeState() {
        return this.orbitModeState;
    }

    public boolean isImageMode() {
        return this.isImageMode;
    }

    public boolean isVisualReady() {
        return this.isVisualReady;
    }

    public boolean isCalibrationMode() {
        return this.isCalibrationMode;
    }

    public boolean isPointFlyMode() {
        return this.isPointFlyMode;
    }

    public boolean isPointFlyInsideMode() {
        return this.isPointFlyInsideMode;
    }

    public boolean isGestureRecognizationMode() {
        return this.isGestureRecognizationMode;
    }

    public boolean isVisualLimitWhenDark() {
        return this.isVisualLimitWhenDark;
    }

    public boolean isVisualLeftFontState() {
        return this.isVisualLeftFontState;
    }

    public boolean isVisualRightFontState() {
        return this.isVisualLeftFontState;
    }

    public boolean isVisualLeftNearState() {
        return this.isVisualLeftNearState;
    }

    public boolean isVisualRightNearState() {
        return this.isVisualRightNearState;
    }

    public boolean isVisualLeftBottomState() {
        return this.isVisualLeftBottomState;
    }

    public boolean isVisualRightBottomState() {
        return this.isVisualRightBottomState;
    }

    public boolean isVisualLeftRightState() {
        return this.isVisualLeftRightState;
    }

    public boolean isVisualRightRightState() {
        return this.isVisualRightRightState;
    }

    public boolean isVisualLeftLeftState() {
        return this.isVisualLeftLeftState;
    }

    public boolean isVisualRightLeftState() {
        return this.isVisualRightLeftState;
    }

    public boolean isVisualLeftTopState() {
        return this.isVisualLeftTopState;
    }

    public boolean isVisualRightTopState() {
        return this.isVisualRightTopState;
    }

    public boolean isVisualCalibrationValid() {
        return this.isVisualCalibrationValid;
    }

    public VisualTrackState getVisualTrackState() {
        return this.visualTrackState;
    }

    public AuxiliaryLedState getAuxiliaryLedState() {
        return this.auxiliaryLedState;
    }

    public int getSpeed() {
        return this.speed;
    }
}
