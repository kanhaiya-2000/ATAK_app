package com.autel.AutelNet2.aircraft.flycontroller.engine;

import com.autel.common.flycontroller.AltitudeAndSpeedInfo;
import com.autel.common.flycontroller.AttitudeInfo;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyHome;
import com.autel.common.flycontroller.GPSInfo;

public class FlyControllerInfoImpl implements FlyControllerInfo {
    private volatile AltitudeAndSpeedInfo mAltitudeAndSpeedInfo;
    private volatile AttitudeInfo mAttitudeInfo;
    private volatile FlyControllerStatus mFlyControllerStatus;
    private volatile FlyHome mFlyHome;
    private volatile GPSInfo mGPSInfo;

    public void setmGPSInfo(GPSInfo gPSInfo) {
        this.mGPSInfo = gPSInfo;
    }

    public void setmAttitudeInfo(AttitudeInfo attitudeInfo) {
        this.mAttitudeInfo = attitudeInfo;
    }

    public void setmAltitudeAndSpeedInfo(AltitudeAndSpeedInfo altitudeAndSpeedInfo) {
        this.mAltitudeAndSpeedInfo = altitudeAndSpeedInfo;
    }

    public void setmFlyHome(FlyHome flyHome) {
        this.mFlyHome = flyHome;
    }

    public void setmFlyControllerStatus(FlyControllerStatus flyControllerStatus) {
        this.mFlyControllerStatus = flyControllerStatus;
    }

    public GPSInfo getGPSInfo() {
        return this.mGPSInfo;
    }

    public AttitudeInfo getAttitudeInfo() {
        return this.mAttitudeInfo;
    }

    public AltitudeAndSpeedInfo getAltitudeAndSpeedInfo() {
        return this.mAltitudeAndSpeedInfo;
    }

    public FlyHome getFlyHome() {
        return this.mFlyHome;
    }

    public FlyControllerStatus getFlyControllerStatus() {
        return this.mFlyControllerStatus;
    }

    public String toString() {
        return "GPSInfo : " + this.mGPSInfo + ", AttitudeInfo : " + this.mAttitudeInfo + ", AltitudeAndSpeedInfo : " + this.mAltitudeAndSpeedInfo + ", FlyHome : " + this.mFlyHome + ", FlyControllerStatus : " + this.mFlyControllerStatus;
    }
}
