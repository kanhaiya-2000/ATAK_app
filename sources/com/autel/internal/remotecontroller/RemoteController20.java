package com.autel.internal.remotecontroller;

import android.util.Pair;
import com.autel.AutelNet2.aircraft.firmware.FirmwareManager;
import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.aircraft.flycontroller.FlyControllerManager2;
import com.autel.AutelNet2.remotecontroller.RemoteControllerButtonManager2;
import com.autel.AutelNet2.remotecontroller.RemoteControllerManager2;
import com.autel.AutelNet2.remotecontroller.engine.CustomKeyInfo;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.remotecontroller.CustomFunction;
import com.autel.common.remotecontroller.CustomKey;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerConnectState;
import com.autel.common.remotecontroller.RemoteControllerInfo;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.common.remotecontroller.RemoteControllerPairState;
import com.autel.common.remotecontroller.RemoteControllerParameterRangeManager;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.RemoteControllerVersionInfo;
import com.autel.common.remotecontroller.TeachingMode;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.sdk.remotecontroller.p010rx.RxAutelRemoteController;
import java.util.List;

public class RemoteController20 implements RemoteControllerService {
    public void exitPairing() {
    }

    public void getSerialNumber(CallbackWithOneParam<String> callbackWithOneParam) {
    }

    public void setConnectStateListener(CallbackWithOneParam<RemoteControllerConnectState> callbackWithOneParam) {
    }

    public RxAutelRemoteController toRx() {
        return null;
    }

    public void setRemoteButtonControllerListener(final CallbackWithOneParam<RemoteControllerNavigateButtonEvent> callbackWithOneParam) {
        RemoteControllerButtonManager2.getInstance().registeRCButtonMessageListener("RemoteController20", new CallbackWithOneParam<RemoteControllerNavigateButtonEvent>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(RemoteControllerNavigateButtonEvent remoteControllerNavigateButtonEvent) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(remoteControllerNavigateButtonEvent);
                }
            }
        });
    }

    public void setInfoDataListener(final CallbackWithOneParam<RemoteControllerInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            RemoteControllerManager2.getInstance().unRegisteRCInfoDataCallback("RemoteController20");
        } else {
            RemoteControllerManager2.getInstance().registeRCInfoDataCallback("RemoteController20", new CallbackWithOneParam<int[]>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(final int[] iArr) {
                    if (iArr.length >= 4) {
                        callbackWithOneParam.onSuccess(new RemoteControllerInfo() {
                            public int getBatteryCapacityPercentage() {
                                return iArr[0];
                            }

                            public int getControllerSignalPercentage() {
                                return iArr[1];
                            }

                            public int getDSPPercentage() {
                                return iArr[2];
                            }

                            public RemoteControllerStickCalibration getStickCalibration() {
                                return RemoteControllerStickCalibration.find(iArr[3]);
                            }

                            public String toString() {
                                return "BatteryCapacityPercentage : " + getBatteryCapacityPercentage() + ", ControllerSignalPercentage : " + getControllerSignalPercentage() + ", getDSPPercentage : " + getDSPPercentage() + ", StickCalibration : " + getStickCalibration();
                            }
                        });
                    } else {
                        callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    }
                }
            });
        }
    }

    public void setControlMenuListener(final CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            RemoteControllerManager2.getInstance().unRegistRCUploadDataCallback("setControlMenuListener");
        } else {
            RemoteControllerManager2.getInstance().registeRCUploadDataCallback("setControlMenuListener", new CallbackWithOneParam<int[]>() {
                public void onSuccess(int[] iArr) {
                    callbackWithOneParam.onSuccess(iArr);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setLanguage(RemoteControllerLanguage remoteControllerLanguage, final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().setRCLanguage(remoteControllerLanguage, new CallbackWithOneParam<Boolean>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(Boolean bool) {
                if (!bool.booleanValue()) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                        return;
                    }
                    return;
                }
                CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
                if (callbackWithNoParam2 != null) {
                    callbackWithNoParam2.onSuccess();
                }
            }
        });
    }

    public void getLanguage(CallbackWithOneParam<RemoteControllerLanguage> callbackWithOneParam) {
        RemoteControllerManager2.getInstance().queryRCLanguage(callbackWithOneParam);
    }

    public void enterPairing(final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().startRCBinding(new CallbackWithOneParam<Boolean>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(Boolean bool) {
                if (!bool.booleanValue()) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                        return;
                    }
                    return;
                }
                CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
                if (callbackWithNoParam2 != null) {
                    callbackWithNoParam2.onSuccess();
                }
            }
        });
    }

    public void getBindState(CallbackWithOneParam<RemoteControllerPairState> callbackWithOneParam) {
        RemoteControllerManager2.getInstance().queryRCBindMode(callbackWithOneParam);
    }

    public void setRFPower(RFPower rFPower, final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().setRFPower(rFPower, new CallbackWithOneParam<Boolean>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(Boolean bool) {
                if (!bool.booleanValue()) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                        return;
                    }
                    return;
                }
                CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
                if (callbackWithNoParam2 != null) {
                    callbackWithNoParam2.onSuccess();
                }
            }
        });
    }

    public void getRFPower(CallbackWithOneParam<RFPower> callbackWithOneParam) {
        RemoteControllerManager2.getInstance().queryRFPower(callbackWithOneParam);
    }

    public void setTeachingMode(TeachingMode teachingMode, final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().setTeacherStudentMode(teachingMode, new CallbackWithOneParam<Boolean>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(Boolean bool) {
                if (!bool.booleanValue()) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                        return;
                    }
                    return;
                }
                CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
                if (callbackWithNoParam2 != null) {
                    callbackWithNoParam2.onSuccess();
                }
            }
        });
    }

    public void getTeachingMode(CallbackWithOneParam<TeachingMode> callbackWithOneParam) {
        RemoteControllerManager2.getInstance().queryTeacherStudentMode(callbackWithOneParam);
    }

    public void setStickCalibration(RemoteControllerStickCalibration remoteControllerStickCalibration, final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().setRCCalibrationStep(remoteControllerStickCalibration, new CallbackWithOneParam<int[]>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(int[] iArr) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }
        });
    }

    public void setParameterUnit(RemoteControllerParameterUnit remoteControllerParameterUnit, final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().setRCLengthUnit(remoteControllerParameterUnit, new CallbackWithOneParam<Boolean>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(Boolean bool) {
                if (!bool.booleanValue()) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                        return;
                    }
                    return;
                }
                CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
                if (callbackWithNoParam2 != null) {
                    callbackWithNoParam2.onSuccess();
                }
            }
        });
    }

    public void getLengthUnit(CallbackWithOneParam<RemoteControllerParameterUnit> callbackWithOneParam) {
        RemoteControllerManager2.getInstance().queryRCLengthUnit(callbackWithOneParam);
    }

    public void setCommandStickMode(RemoteControllerCommandStickMode remoteControllerCommandStickMode, final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().setRCCommandStickMode(remoteControllerCommandStickMode, new CallbackWithOneParam<Boolean>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(Boolean bool) {
                if (!bool.booleanValue()) {
                    CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                        return;
                    }
                    return;
                }
                CallbackWithNoParam callbackWithNoParam2 = callbackWithNoParam;
                if (callbackWithNoParam2 != null) {
                    callbackWithNoParam2.onSuccess();
                }
            }
        });
    }

    public void getCommandStickMode(CallbackWithOneParam<RemoteControllerCommandStickMode> callbackWithOneParam) {
        RemoteControllerManager2.getInstance().queryRCCommandStickMode(callbackWithOneParam);
    }

    public void setYawCoefficient(float f, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setYawSenCoefficient(f, new CallbackWithOneParam<Float>() {
            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }

            public void onSuccess(Float f) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onSuccess();
                }
            }
        });
    }

    public void getYawCoefficient(CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().queryYawSenCoefficient(callbackWithOneParam);
    }

    public void getVersionInfo(final CallbackWithOneParam<RemoteControllerVersionInfo> callbackWithOneParam) {
        FirmwareManager.instance().getDeviceFirmwareInfo(new CallbackWithOneParam<List<FirmwareDeviceInfo.VersionBean>>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(final List<FirmwareDeviceInfo.VersionBean> list) {
                callbackWithOneParam.onSuccess(new RemoteControllerVersionInfo() {
                    public String getRFRXVersion() {
                        return null;
                    }

                    public String getRFTXVersion() {
                        return null;
                    }

                    public String getRepeaterVersion() {
                        return null;
                    }

                    public String getRemoteControlVersion() {
                        FirmwareDeviceInfo.VersionBean access$000 = RemoteController20.this.getVersionBean(list, FirmwareManager.DEV_RC);
                        return access$000 != null ? access$000.getSoftware() : "";
                    }
                });
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

    public RemoteControllerParameterRangeManager getParameterRangeManager() {
        return new RemoteControllerParameterRangeManager() {
            public RangePair<Float> getYawCoefficient() {
                return new RangePair<Float>() {
                    public Float getValueFrom() {
                        return Float.valueOf(0.2f);
                    }

                    public Float getValueTo() {
                        return Float.valueOf(0.7f);
                    }
                };
            }

            public RangePair<Integer> getDialAdjustSpeed() {
                return new RangePair<Integer>() {
                    public Integer getValueFrom() {
                        return 0;
                    }

                    public Integer getValueTo() {
                        return 100;
                    }
                };
            }
        };
    }

    public void setGimbalDialAdjustSpeed(int i, final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().setGimbalWheelAdjustSpeed(i, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (callbackWithNoParam != null) {
                    if (bool.booleanValue()) {
                        callbackWithNoParam.onSuccess();
                    } else {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                    }
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

    public void getGimbalDialAdjustSpeed(CallbackWithOneParam<Integer> callbackWithOneParam) {
        RemoteControllerManager2.getInstance().queryGimbalWheelAdjustSpeed(callbackWithOneParam);
    }

    public void setRcCustomKey(CustomKey customKey, CustomFunction customFunction, final CallbackWithNoParam callbackWithNoParam) {
        RemoteControllerManager2.getInstance().setCustomKey(customKey, customFunction, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getRcCustomKey(final CallbackWithOneParam<Pair<CustomFunction, CustomFunction>> callbackWithOneParam) {
        RemoteControllerManager2.getInstance().getCustomKey(new CallbackWithOneParam<CustomKeyInfo>() {
            public void onSuccess(CustomKeyInfo customKeyInfo) {
                if (callbackWithOneParam == null || customKeyInfo == null || customKeyInfo.getStatus() != 0 || customKeyInfo.getResult() == null || customKeyInfo.getResult().size() <= 1) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
                        return;
                    }
                    return;
                }
                CustomKeyInfo.CusKey cusKey = customKeyInfo.getResult().get(0);
                CustomKeyInfo.CusKey cusKey2 = customKeyInfo.getResult().get(1);
                CustomFunction customFunction = CustomFunction.UNKNOWN;
                CustomFunction customFunction2 = CustomFunction.UNKNOWN;
                if (cusKey != null && cusKey.getKey().equals("A")) {
                    customFunction = CustomFunction.find(cusKey.getFunc());
                }
                if (cusKey2 != null && cusKey2.getKey().equals("B")) {
                    customFunction2 = CustomFunction.find(cusKey2.getFunc());
                }
                callbackWithOneParam.onSuccess(new Pair(customFunction, customFunction2));
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void init(IAutelStateManager iAutelStateManager) {
        RemoteControllerManager2.getInstance().init();
    }

    public void destroy() {
        RemoteControllerManager2.getInstance().destroy();
    }

    public void connect() {
        RemoteControllerManager2.getInstance().init();
    }

    public void disconnect() {
        RemoteControllerManager2.getInstance().destroy();
    }
}
