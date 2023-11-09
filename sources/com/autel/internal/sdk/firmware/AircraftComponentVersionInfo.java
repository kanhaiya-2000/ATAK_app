package com.autel.internal.sdk.firmware;

public interface AircraftComponentVersionInfo {
    String getBatteryVersion();

    String getCameraVersion();

    String getDSPVersion();

    String getFmuVersion();

    String[] getFocESCsVersion();

    String getGimbalBootloaderVersion();

    String getGimbalPitchESCVersion();

    String getGimbalRollESCVersion();

    String getGimbalVersion();

    String getGimbalYawESCVersion();

    String getLensVersion();

    String getOpticalFlowVersion();

    String getRFRXVersion();

    String getRouterVersion();

    String getSonarVersion();

    String getTransferBoardVersion();
}
