package com.autel.internal.sdk.camera.flirInternal;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.DeviceInfo;
import com.autel.common.camera.base.ProtocolVersion;

public class CameraDeviceInfoImpl implements DeviceInfo {
    CameraProduct cameraProduct;
    ProtocolVersion cameraProtocolVersion;
    String firmwareVersion;
    String hardwareId;
    String manufacturer;
    String serialNumber;

    public CameraProduct getCameraProduct() {
        return null;
    }

    public String getFirmwareVersion() {
        return null;
    }

    public String getHardwareId() {
        return null;
    }

    public ProtocolVersion getProtocolVersion() {
        return null;
    }

    public String getSerialNumber() {
        return null;
    }

    public void setCameraProduct(CameraProduct cameraProduct2) {
        this.cameraProduct = cameraProduct2;
    }

    public void setCameraProtocolVersion(ProtocolVersion protocolVersion) {
        this.cameraProtocolVersion = protocolVersion;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setHardwareId(String str) {
        this.hardwareId = str;
    }
}
