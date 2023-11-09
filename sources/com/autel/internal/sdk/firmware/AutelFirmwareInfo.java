package com.autel.internal.sdk.firmware;

import com.autel.common.CallbackWithOneParam;
import com.autel.internal.sdk.remotecontroller.RemoteControllerVersionPartInfo;

public interface AutelFirmwareInfo {
    void getAircraftComponentSerialNumberVersion(CallbackWithOneParam<AircraftComponentSerialNumberVersionInfo> callbackWithOneParam);

    void getAircraftComponentVersion(CallbackWithOneParam<AircraftComponentVersionInfo> callbackWithOneParam);

    void getRemoteControllerSerialNumberVersion(CallbackWithOneParam<RemoteControllerSerialNumberVersionInfo> callbackWithOneParam);

    void getRemoteControllerVersion(CallbackWithOneParam<RemoteControllerVersionPartInfo> callbackWithOneParam);
}
