package com.autel.common.gimbal;

public interface GimbalVersionInfo {
    String getBootloaderVersion();

    String getGimbalSerialNumber();

    String getGimbalVersion();

    String getPitchESCVersion();

    String getRollESCVersion();

    String getYawESCVersion();
}
