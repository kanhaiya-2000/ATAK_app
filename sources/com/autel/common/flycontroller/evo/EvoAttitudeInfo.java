package com.autel.common.flycontroller.evo;

import com.autel.common.flycontroller.AttitudeInfo;

public interface EvoAttitudeInfo extends AttitudeInfo {
    double getPitchSpeed();

    double getRollSpeed();

    double getYawSpeed();
}
