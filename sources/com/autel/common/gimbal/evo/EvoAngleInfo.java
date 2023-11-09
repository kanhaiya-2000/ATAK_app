package com.autel.common.gimbal.evo;

import com.autel.common.gimbal.GimbalAngleInfo;
import com.autel.common.gimbal.GimbalState;

public interface EvoAngleInfo extends GimbalAngleInfo {
    GimbalState getGimbalState();

    float getPitchSpeed();

    float getRoll();

    float getRollSpeed();

    float getYaw();

    float getYawSpeed();
}
