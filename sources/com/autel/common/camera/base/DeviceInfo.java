package com.autel.common.camera.base;

import com.autel.common.camera.CameraProduct;

public interface DeviceInfo {
    CameraProduct getCameraProduct();

    String getFirmwareVersion();

    String getHardwareId();

    ProtocolVersion getProtocolVersion();

    String getSerialNumber();
}
