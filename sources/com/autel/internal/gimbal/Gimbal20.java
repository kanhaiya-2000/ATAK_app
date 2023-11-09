package com.autel.internal.gimbal;

import com.autel.AutelNet2.aircraft.firmware.FirmwareManager;
import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.aircraft.gimbal.controller.GimbalManager2;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalCmdInfo;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalAxisType;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.GimbalVersionInfo;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.gimbal.p008rx.RxAutelGimbal;
import java.util.List;

public abstract class Gimbal20 implements GimbalService {
    protected static final String gimbalAngleListenerTag = "gimbalAngleListener";
    protected static final String gimbalStateListenerTag = "gimbalStateListener";
    protected static final String setGimbalStateListenerTag = "setGimbalStateListener";
    protected GimbalState currentGimbalState = GimbalState.UNKNOWN;

    public void connect() {
    }

    public void disconnect() {
    }

    public RxAutelGimbal toRx() {
        return null;
    }

    public void init(IAutelStateManager iAutelStateManager) {
        GimbalManager2.getInstance().init();
    }

    public void destroy() {
        GimbalManager2.getInstance().destroy();
    }

    public void setGimbalLimitUpward(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager2.getInstance().setGimbalLimitUpward(z, new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (gimbalCmdInfo == null || gimbalCmdInfo.getData()[0] != 0) {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                } else {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getGimbalLimitUpward(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        GimbalManager2.getInstance().getGimbalLimitUpward(new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (gimbalCmdInfo != null) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    boolean z = false;
                    if (gimbalCmdInfo.getData()[0] == 1) {
                        z = true;
                    }
                    callbackWithOneParam.onSuccess(Boolean.valueOf(z));
                    return;
                }
                callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setGimbalWorkMode(GimbalWorkMode gimbalWorkMode, final CallbackWithNoParam callbackWithNoParam) {
        GimbalManager2.getInstance().setGimbalWorkMode(gimbalWorkMode, new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (gimbalCmdInfo == null || gimbalCmdInfo.getData()[0] != 0) {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                } else {
                    callbackWithNoParam.onSuccess();
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getGimbalWorkMode(final CallbackWithOneParam<GimbalWorkMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            GimbalManager2.getInstance().queryGimbalWorkMode(new CallbackWithOneParam<GimbalCmdInfo>() {
                public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                    if (gimbalCmdInfo != null) {
                        callbackWithOneParam.onSuccess(GimbalWorkMode.find(gimbalCmdInfo.getData()[0]));
                    } else {
                        callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getVersionInfo(final CallbackWithOneParam<GimbalVersionInfo> callbackWithOneParam) {
        FirmwareManager.instance().getDeviceFirmwareInfo(new CallbackWithOneParam<List<FirmwareDeviceInfo.VersionBean>>() {
            public void onSuccess(final List<FirmwareDeviceInfo.VersionBean> list) {
                callbackWithOneParam.onSuccess(new GimbalVersionInfo() {
                    public String getYawESCVersion() {
                        FirmwareDeviceInfo.VersionBean access$000 = Gimbal20.this.getVersionBean(list, FirmwareManager.DEV_ESC_YAW);
                        if (access$000 == null) {
                            return "";
                        }
                        return access$000.getSoftware();
                    }

                    public String getRollESCVersion() {
                        FirmwareDeviceInfo.VersionBean access$000 = Gimbal20.this.getVersionBean(list, FirmwareManager.DEV_ESC_ROLL);
                        if (access$000 == null) {
                            return "";
                        }
                        return access$000.getSoftware();
                    }

                    public String getPitchESCVersion() {
                        FirmwareDeviceInfo.VersionBean access$000 = Gimbal20.this.getVersionBean(list, FirmwareManager.DEV_ESC_PITCH);
                        if (access$000 == null) {
                            return "";
                        }
                        return access$000.getSoftware();
                    }

                    public String getBootloaderVersion() {
                        FirmwareDeviceInfo.VersionBean access$000 = Gimbal20.this.getVersionBean(list, FirmwareManager.DEV_GIMBAL);
                        if (access$000 == null) {
                            return "";
                        }
                        return access$000.getBootloader();
                    }

                    public String getGimbalVersion() {
                        FirmwareDeviceInfo.VersionBean access$000 = Gimbal20.this.getVersionBean(list, FirmwareManager.DEV_GIMBAL);
                        if (access$000 == null) {
                            return "";
                        }
                        return access$000.getSoftware();
                    }

                    public String getGimbalSerialNumber() {
                        FirmwareDeviceInfo.VersionBean access$000 = Gimbal20.this.getVersionBean(list, FirmwareManager.DEV_GIMBAL);
                        if (access$000 == null) {
                            return "";
                        }
                        return access$000.getSerialNumber();
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    /* access modifiers changed from: private */
    public FirmwareDeviceInfo.VersionBean getVersionBean(List<FirmwareDeviceInfo.VersionBean> list, String str) {
        if (!(list == null || str == null)) {
            for (FirmwareDeviceInfo.VersionBean next : list) {
                if (str.equals(next.getComponentName())) {
                    return next;
                }
            }
        }
        return null;
    }

    private void resetRollAngle(final CallbackWithOneParam<Double> callbackWithOneParam) {
        GimbalManager2.getInstance().resetGimbalAngle(GimbalAxisType.ROLL, new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (gimbalCmdInfo.getData()[0] == 0) {
                    callbackWithOneParam.onSuccess(Double.valueOf(0.0d));
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    private void setRollAdjustAngle(GimbalRollAngleAdjust gimbalRollAngleAdjust, final CallbackWithOneParam<Double> callbackWithOneParam) {
        GimbalManager2.getInstance().setRollAdjustData(gimbalRollAngleAdjust == GimbalRollAngleAdjust.PLUS ? 20 : -20, new CallbackWithOneParam<GimbalCmdInfo>() {
            public void onSuccess(GimbalCmdInfo gimbalCmdInfo) {
                if (callbackWithOneParam != null) {
                    if (gimbalCmdInfo.getAck() == 0) {
                        callbackWithOneParam.onSuccess(Double.valueOf(0.0d));
                    } else {
                        callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    }
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
