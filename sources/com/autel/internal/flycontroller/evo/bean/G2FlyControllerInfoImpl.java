package com.autel.internal.flycontroller.evo.bean;

import com.autel.AutelNet2.aircraft.flycontroller.engine.AttitudeInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.engine.ImuStateInfoImpl;
import com.autel.AutelNet2.aircraft.flycontroller.engine.LocalCoordinateInfoImpl;
import com.autel.AutelNet2.aircraft.flycontroller.parser.GPSInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.parser.HeartBeatInfo;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.evo.EvoAttitudeInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoGpsInfo;
import com.autel.common.flycontroller.evo.ImuStateInfo;
import com.autel.common.flycontroller.evo.LocalCoordinateInfo;

public class G2FlyControllerInfoImpl implements EvoFlyControllerInfo {
    private static G2FlyControllerInfoImpl infoImpl;
    public FlyControllerStatus mFlyControllerStatus = new HeartBeatInfo();
    public EvoAttitudeInfo mG2AttitudeInfo = new AttitudeInfoInternal();
    public EvoGpsInfo mG2GpsInfo = new GPSInfoInternal();
    public ImuStateInfo mImuStateInfo = new ImuStateInfoImpl();
    public LocalCoordinateInfo mLocalCoordinateInfo = new LocalCoordinateInfoImpl();

    private G2FlyControllerInfoImpl() {
    }

    public static G2FlyControllerInfoImpl instance() {
        if (infoImpl == null) {
            synchronized (G2FlyControllerInfoImpl.class) {
                if (infoImpl == null) {
                    infoImpl = new G2FlyControllerInfoImpl();
                }
            }
        }
        return infoImpl;
    }

    public EvoGpsInfo getGpsInfo() {
        return this.mG2GpsInfo;
    }

    public ImuStateInfo getImuStateInfo() {
        return this.mImuStateInfo;
    }

    public EvoAttitudeInfo getAttitudeInfo() {
        return this.mG2AttitudeInfo;
    }

    public LocalCoordinateInfo getLocalCoordinateInfo() {
        return this.mLocalCoordinateInfo;
    }

    public FlyControllerStatus getFlyControllerStatus() {
        return this.mFlyControllerStatus;
    }

    public String toString() {
        return "mG2GpsInfo : " + this.mG2GpsInfo + ", mImuStateInfo : " + this.mImuStateInfo + ", mG2AttitudeInfo : " + this.mG2AttitudeInfo + ", mLocalCoordinateInfo : " + this.mLocalCoordinateInfo + " \n\n";
    }
}
