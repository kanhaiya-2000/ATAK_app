package com.autel.common.dsp.evo;

public interface DeviceVersionInfo {
    String getBootloader();

    String getComponentName();

    String getHardware();

    String getSerialNumber();

    String getSoftware();
}
