package com.autel.internal.firmware;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.sdk.firmware.AircraftComponentSerialNumberVersionInfo;
import com.autel.internal.sdk.firmware.AircraftComponentVersionInfo;
import com.autel.internal.sdk.firmware.RemoteControllerSerialNumberVersionInfo;
import com.autel.internal.sdk.remotecontroller.RemoteControllerVersionPartInfo;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.controller.AutelFirmVersionRequestManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback;

public class FirmwareInfo10 implements FirmwareService {
    public void connect() {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public void getAircraftComponentVersion(final CallbackWithOneParam<AircraftComponentVersionInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentVersion(new IAutelFirmVersionCallback<AircraftComponentVersionInfo>() {
                public void onReceiveVersion(AircraftComponentVersionInfo aircraftComponentVersionInfo) {
                    callbackWithOneParam.onSuccess(aircraftComponentVersionInfo);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getAircraftComponentSerialNumberVersion(final CallbackWithOneParam<AircraftComponentSerialNumberVersionInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentSNVersion(new IAutelFirmVersionCallback<AircraftComponentSerialNumberVersionInfo>() {
                public void onReceiveVersion(AircraftComponentSerialNumberVersionInfo aircraftComponentSerialNumberVersionInfo) {
                    callbackWithOneParam.onSuccess(aircraftComponentSerialNumberVersionInfo);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getRemoteControllerVersion(final CallbackWithOneParam<RemoteControllerVersionPartInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            AutelFirmVersionRequestManager.getInstance().requestAutelRCVersion(new IAutelFirmVersionCallback<RemoteControllerVersionPartInfo>() {
                public void onReceiveVersion(RemoteControllerVersionPartInfo remoteControllerVersionPartInfo) {
                    callbackWithOneParam.onSuccess(remoteControllerVersionPartInfo);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getRemoteControllerSerialNumberVersion(final CallbackWithOneParam<RemoteControllerSerialNumberVersionInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            AutelFirmVersionRequestManager.getInstance().requestAutelRCSNVersion(new IAutelFirmVersionCallback<RemoteControllerSerialNumberVersionInfo>() {
                public void onReceiveVersion(RemoteControllerSerialNumberVersionInfo remoteControllerSerialNumberVersionInfo) {
                    callbackWithOneParam.onSuccess(remoteControllerSerialNumberVersionInfo);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }
}
