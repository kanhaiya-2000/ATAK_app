package com.autel.sdk10.AutelNet.AutelGimbal.enums;

public final class GimbalRequestCmdName {
    public static final String GIMBAL_WORK_MODE = "PTZ_WORK_MODE";

    private GimbalRequestCmdName() {
    }

    public static boolean isGimbalRequestCmdName(String str) {
        return str.equals(GIMBAL_WORK_MODE);
    }
}
