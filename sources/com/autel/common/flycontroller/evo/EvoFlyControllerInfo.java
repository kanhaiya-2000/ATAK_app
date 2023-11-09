package com.autel.common.flycontroller.evo;

import com.autel.common.flycontroller.FlyControllerStatus;

public interface EvoFlyControllerInfo {
    EvoAttitudeInfo getAttitudeInfo();

    FlyControllerStatus getFlyControllerStatus();

    EvoGpsInfo getGpsInfo();

    ImuStateInfo getImuStateInfo();

    LocalCoordinateInfo getLocalCoordinateInfo();
}
