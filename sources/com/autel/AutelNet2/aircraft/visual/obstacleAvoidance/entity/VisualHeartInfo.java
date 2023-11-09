package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity;

import com.autel.common.flycontroller.AuxiliaryLedState;
import com.autel.common.flycontroller.OrbitModeState;
import com.autel.common.flycontroller.VisualTrackState;
import com.autel.common.flycontroller.VisualWarnState;
import com.autel.common.flycontroller.visual.VisualMainFlyState;
import com.autel.common.flycontroller.visual.VisualWarningStatus;
import com.autel.common.product.AutelProductInfo;
import com.autel.common.product.AutelProductType;

public class VisualHeartInfo implements VisualWarningStatus, AutelProductInfo {
    private int AlarmStatus1;
    private int AlarmStatus2;
    private int Type;
    private int VisionMode;

    public int getType() {
        return this.Type;
    }

    public int getVisionMode() {
        return this.VisionMode;
    }

    public boolean isAvoidanceEnable() {
        return (this.AlarmStatus1 & 1) == 1;
    }

    public boolean isPointFlyLeftRightEnable() {
        return ((this.AlarmStatus1 >> 23) & 1) == 1;
    }

    public boolean isShowRadar() {
        return ((this.AlarmStatus1 >> 1) & 1) == 1;
    }

    public boolean isRTHAvoidanceEnable() {
        return ((this.AlarmStatus1 >> 2) & 1) == 1;
    }

    public boolean isTrackingAvoidanceEnable() {
        return ((this.AlarmStatus1 >> 3) & 1) == 1;
    }

    public boolean isTrackingBackOffEnable() {
        return ((this.AlarmStatus1 >> 4) & 1) == 1;
    }

    public boolean isOdometerEnable() {
        return ((this.AlarmStatus1 >> 5) & 1) == 1;
    }

    public boolean isLandingProtectionEnable() {
        return ((this.AlarmStatus1 >> 6) & 1) == 1;
    }

    public boolean isLandingAccurateEnable() {
        return ((this.AlarmStatus1 >> 7) & 1) == 1;
    }

    public boolean isTerrainFollowEnable() {
        return ((this.AlarmStatus1 >> 8) & 1) == 1;
    }

    public boolean isGestureRecognizationEnable() {
        return ((this.AlarmStatus1 >> 9) & 1) == 1;
    }

    public AuxiliaryLedState getVisualLedState() {
        int i = (this.AlarmStatus1 >> 12) & 3;
        if (i == 3) {
            return (this.Type & 3) == 0 ? AuxiliaryLedState.FLASHING_MODE_1 : AuxiliaryLedState.FLASHING_MODE_2;
        }
        return AuxiliaryLedState.find(i);
    }

    public VisualTrackState getTrackState() {
        return VisualTrackState.find((this.AlarmStatus1 >> 14) & 3);
    }

    public OrbitModeState getOrbitModeState() {
        return OrbitModeState.find((this.AlarmStatus2 >> 6) & 3);
    }

    public boolean isTripodMode() {
        return ((this.AlarmStatus1 >> 17) & 1) == 1;
    }

    public boolean isCameraMode() {
        return ((this.AlarmStatus1 >> 18) & 1) == 1;
    }

    public boolean isVisualReady() {
        return ((this.AlarmStatus1 >> 19) & 1) == 1;
    }

    public boolean isCalibrationMode() {
        return ((this.AlarmStatus1 >> 20) & 1) == 1;
    }

    public boolean isPointflyMode() {
        return ((this.AlarmStatus1 >> 21) & 1) == 1;
    }

    public boolean isPointflyInsideMode() {
        return ((this.AlarmStatus1 >> 22) & 1) == 1;
    }

    public VisualMainFlyState getVisualMainFlyState() {
        return VisualMainFlyState.find(this.AlarmStatus2 & 15);
    }

    public VisualWarnState getVisualWarnState() {
        return VisualWarnState.find((this.AlarmStatus2 >> 8) & 255);
    }

    public boolean isVisualLimitWhenDark() {
        return ((this.AlarmStatus1 >> 11) & 1) == 1;
    }

    public boolean isVisualLeftFontState() {
        return ((this.AlarmStatus2 >> 20) & 1) == 0;
    }

    public boolean isVisualRightFontState() {
        return ((this.AlarmStatus2 >> 21) & 1) == 0;
    }

    public boolean isVisualLeftNearState() {
        return ((this.AlarmStatus2 >> 22) & 1) == 0;
    }

    public boolean isVisualRightNearState() {
        return ((this.AlarmStatus2 >> 23) & 1) == 0;
    }

    public boolean isVisualLeftBottomState() {
        return ((this.AlarmStatus2 >> 24) & 1) == 0;
    }

    public boolean isVisualRightBottomState() {
        return ((this.AlarmStatus2 >> 25) & 1) == 0;
    }

    public boolean isVisualLeftRightState() {
        return ((this.AlarmStatus2 >> 26) & 1) == 0;
    }

    public boolean isVisualRightRightState() {
        return ((this.AlarmStatus2 >> 27) & 1) == 0;
    }

    public boolean isVisualLeftLeftState() {
        return ((this.AlarmStatus2 >> 28) & 1) == 0;
    }

    public boolean isVisualRightLeftState() {
        return ((this.AlarmStatus2 >> 29) & 1) == 0;
    }

    public boolean isVisualLeftTopState() {
        return ((this.AlarmStatus2 >> 30) & 1) == 0;
    }

    public boolean isVisualRightTopState() {
        return ((this.AlarmStatus2 >> 31) & 1) == 0;
    }

    public boolean isVisualCalibrationValid() {
        return ((this.AlarmStatus2 >> 5) & 1) == 1;
    }

    public int getSpeed() {
        return (this.AlarmStatus1 >> 24) & 255;
    }

    public AutelProductType getProduct() {
        return AutelProductType.find(getType());
    }

    public int getAlarmStatus1() {
        return this.AlarmStatus1;
    }

    public void setAlarmStatus1(int i) {
        this.AlarmStatus1 = i;
    }

    public int getAlarmStatus2() {
        return this.AlarmStatus2;
    }

    public void setAlarmStatus2(int i) {
        this.AlarmStatus2 = i;
    }
}
