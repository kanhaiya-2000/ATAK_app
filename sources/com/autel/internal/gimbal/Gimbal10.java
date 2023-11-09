package com.autel.internal.gimbal;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalParameterRangeManager;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.GimbalVersionInfo;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.sdk.firmware.AircraftComponentVersionInfo;
import com.autel.sdk.gimbal.p008rx.RxAutelGimbal;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.controller.AutelFirmVersionRequestManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback;
import com.autel.sdk10.AutelNet.AutelGimbal.GimbalManager;
import com.autel.sdk10.interfaces.AutelCompletionCallback;

public abstract class Gimbal10 implements GimbalService {
    protected static final String gimbalAngleListenerTag = "gimbalAngleListener";
    protected static final String gimbalStateListenerTag = "gimbalStateListener";
    protected GimbalState currentGimbalState = GimbalState.UNKNOWN;
    protected GimbalParameterRangeManager rangeManager = null;

    public void connect() {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void getGimbalLimitUpward(CallbackWithOneParam<Boolean> callbackWithOneParam) {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public void setGimbalLimitUpward(boolean z, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxAutelGimbal toRx() {
        return null;
    }

    public void setGimbalWorkMode(GimbalWorkMode gimbalWorkMode, final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager.getAutelGimbalRequestManager().setGimbalWorkMode(gimbalWorkMode, new AutelCompletionCallback.ICompletionCallbackWith<GimbalWorkMode>() {
            public void onResult(GimbalWorkMode gimbalWorkMode) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getGimbalWorkMode(final CallbackWithOneParam<GimbalWorkMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            GimbalManager.getAutelGimbalRequestManager().queryGimbalWorkMode(new AutelCompletionCallback.ICompletionCallbackWith<GimbalWorkMode>() {
                public void onResult(GimbalWorkMode gimbalWorkMode) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onSuccess(gimbalWorkMode);
                    }
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                }
            });
        }
    }

    public void getVersionInfo(final CallbackWithOneParam<GimbalVersionInfo> callbackWithOneParam) {
        AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentVersion(new IAutelFirmVersionCallback<AircraftComponentVersionInfo>() {
            public void onReceiveVersion(final AircraftComponentVersionInfo aircraftComponentVersionInfo) {
                callbackWithOneParam.onSuccess(new GimbalVersionInfo() {
                    public String getGimbalSerialNumber() {
                        return null;
                    }

                    public String getYawESCVersion() {
                        return aircraftComponentVersionInfo.getGimbalYawESCVersion();
                    }

                    public String getRollESCVersion() {
                        return aircraftComponentVersionInfo.getGimbalRollESCVersion();
                    }

                    public String getPitchESCVersion() {
                        return aircraftComponentVersionInfo.getGimbalPitchESCVersion();
                    }

                    public String getBootloaderVersion() {
                        return aircraftComponentVersionInfo.getGimbalBootloaderVersion();
                    }

                    public String getGimbalVersion() {
                        return aircraftComponentVersionInfo.getGimbalVersion();
                    }

                    public String toString() {
                        return "YawESCVersion : " + getYawESCVersion() + ", RollESCVersion : " + getRollESCVersion() + ", PitchESCVersion : " + getPitchESCVersion() + ", BootloaderVersion : " + getBootloaderVersion() + ", GimbalVersion : " + getGimbalVersion();
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }
}
