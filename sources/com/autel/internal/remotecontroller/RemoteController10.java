package com.autel.internal.remotecontroller;

import android.util.Log;
import android.util.Pair;
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
import com.autel.internal.AutelListenerManager;
import com.autel.internal.SdkInternalUtils;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.sdk.firmware.AircraftComponentVersionInfo;
import com.autel.internal.sdk.firmware.RemoteControllerSerialNumberVersionInfo;
import com.autel.internal.sdk.remotecontroller.RemoteControllerVersionPartInfo;
import com.autel.sdk.remotecontroller.p010rx.RxAutelRemoteController;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.controller.AutelFirmVersionRequestManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback;
import com.autel.sdk10.AutelNet.AutelFlyController.FlyControllerManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.controller.RemoteControllerButtonManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.controller.RemoteControllerManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCCommandMessage;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.AutelNet.AutelRemoteController.parser.RCRespondMsgParser;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.interfaces.IAutelConnectionStatusListener;
import com.autel.sdk10.products.aircraft.AutelAircraftManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class RemoteController10 implements RemoteControllerService {
    /* access modifiers changed from: private */
    public AtomicBoolean enterBinding = new AtomicBoolean(false);
    private long startBinding = 0;

    public void getRcCustomKey(CallbackWithOneParam<Pair<CustomFunction, CustomFunction>> callbackWithOneParam) {
    }

    public void setRcCustomKey(CustomKey customKey, CustomFunction customFunction, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxAutelRemoteController toRx() {
        return null;
    }

    public void setConnectStateListener(final CallbackWithOneParam<RemoteControllerConnectState> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            AutelAircraftManager.getRCManager().removeIAutelConnectionStatusListener(AutelListenerManager.RemoteControllerConnectStateListener);
        } else {
            AutelAircraftManager.getRCManager().addIAutelConnectionStatusListener(AutelListenerManager.RemoteControllerConnectStateListener, new IAutelConnectionStatusListener() {
                public void onConnect() {
                    callbackWithOneParam.onSuccess(RemoteControllerConnectState.connect);
                }

                public void onDisconnect() {
                    callbackWithOneParam.onSuccess(RemoteControllerConnectState.disconnect);
                }

                public void onReconnect() {
                    callbackWithOneParam.onSuccess(RemoteControllerConnectState.reconnect);
                }
            });
        }
    }

    public void setRemoteButtonControllerListener(final CallbackWithOneParam<RemoteControllerNavigateButtonEvent> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            RemoteControllerButtonManager.getInstance().closeConnection();
            RemoteControllerButtonManager.getInstance().removeRemoteButtonControllerListener(AutelListenerManager.RemoteButtonControllerListener);
            return;
        }
        RemoteControllerButtonManager.getInstance().openConnection();
        RemoteControllerButtonManager.getInstance().addRemoteButtonControllerListener(AutelListenerManager.RemoteButtonControllerListener, new AutelCompletionCallback.ICompletionCallbackWith<RemoteControllerNavigateButtonEvent>() {
            public void onResult(RemoteControllerNavigateButtonEvent remoteControllerNavigateButtonEvent) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(remoteControllerNavigateButtonEvent);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setInfoDataListener(final CallbackWithOneParam<RemoteControllerInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            RemoteControllerManager.getInstance().removeQueryRCInfoDataCallback(AutelListenerManager.RCInfoDataListener);
        } else {
            RemoteControllerManager.getInstance().addQueryRCInfoDataCallback(AutelListenerManager.RCInfoDataListener, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<int[]>() {
                public void onReceiveMsg(final int[] iArr) {
                    if (iArr.length == 4) {
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
                                return " BatteryCapacityPercentage " + getBatteryCapacityPercentage() + " ControllerSignalPercentage " + getControllerSignalPercentage() + " DSPPercentage " + getDSPPercentage() + " StickCalibration " + getStickCalibration();
                            }
                        });
                    }
                }
            });
        }
    }

    public void setControlMenuListener(final CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            RemoteControllerManager.getInstance().removeQueryRCUploadDataCallback(AutelListenerManager.RCControlMenuListener);
        } else {
            RemoteControllerManager.getInstance().addQueryRCUploadDataCallback(AutelListenerManager.RCControlMenuListener, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<int[]>() {
                public void onReceiveMsg(int[] iArr) {
                    callbackWithOneParam.onSuccess(iArr);
                }
            });
        }
    }

    public void setLanguage(RemoteControllerLanguage remoteControllerLanguage, final CallbackWithNoParam callbackWithNoParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCLanguageParams(remoteControllerLanguage.getValue());
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (rCRespondMsgParser.isRCLanguageSetSucc()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
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

    public void getLanguage(final CallbackWithOneParam<RemoteControllerLanguage> callbackWithOneParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCLanguageParams();
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                callbackWithOneParam.onSuccess(rCRespondMsgParser.getRCLanguage());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void exitPairing() {
        this.enterBinding.set(false);
    }

    public void enterPairing(final CallbackWithNoParam callbackWithNoParam) {
        if (this.enterBinding.compareAndSet(false, true)) {
            this.startBinding = System.currentTimeMillis();
            keepBinding(new CallbackWithOneParam<Boolean>() {
                public void onSuccess(Boolean bool) {
                    if (callbackWithNoParam == null) {
                        return;
                    }
                    if (bool.booleanValue()) {
                        callbackWithNoParam.onSuccess();
                    } else {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
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
    }

    /* access modifiers changed from: private */
    public void keepBinding(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (System.currentTimeMillis() - this.startBinding >= 60000) {
            this.enterBinding.set(false);
            if (callbackWithOneParam != null) {
                callbackWithOneParam.onFailure(AutelError.COMMON_TIMEOUT);
                return;
            }
            return;
        }
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCPairModeParams();
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                if (rCRespondMsgParser.isRCBindSucc()) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    if (callbackWithOneParam != null) {
                        callbackWithOneParam.onSuccess(Boolean.valueOf(rCRespondMsgParser.isRCBindSucc()));
                    }
                    RemoteController10.this.enterBinding.set(false);
                } else if (RemoteController10.this.enterBinding.get()) {
                    RemoteController10.this.keepBinding(callbackWithOneParam);
                } else {
                    CallbackWithOneParam callbackWithOneParam2 = callbackWithOneParam;
                    if (callbackWithOneParam2 != null) {
                        callbackWithOneParam2.onFailure(AutelError.COMMON_CANCEL);
                    }
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
                RemoteController10.this.enterBinding.set(false);
            }
        });
    }

    public void getBindState(final CallbackWithOneParam<RemoteControllerPairState> callbackWithOneParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCPairModeParams();
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                callbackWithOneParam.onSuccess(RemoteControllerPairState.find(rCRespondMsgParser.getRCBindMode()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setRFPower(RFPower rFPower, final CallbackWithNoParam callbackWithNoParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRFPowerParams(rFPower.getValue());
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (rCRespondMsgParser.isRFPowerSetSucc()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
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

    public void getRFPower(final CallbackWithOneParam<RFPower> callbackWithOneParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRFPowerParams();
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                callbackWithOneParam.onSuccess(rCRespondMsgParser.getRFPower());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setTeachingMode(TeachingMode teachingMode, final CallbackWithNoParam callbackWithNoParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetTeacherStudentModeParams(teachingMode.getValue());
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (rCRespondMsgParser.isTeacherStudentModeSetSucc()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
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

    public void getTeachingMode(final CallbackWithOneParam<TeachingMode> callbackWithOneParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryTeacherStudentModeParams();
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                callbackWithOneParam.onSuccess(rCRespondMsgParser.getTeacherStudentMode());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setStickCalibration(RemoteControllerStickCalibration remoteControllerStickCalibration, final CallbackWithNoParam callbackWithNoParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCAdjustStepParams(remoteControllerStickCalibration.getValue());
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
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

    public void setParameterUnit(RemoteControllerParameterUnit remoteControllerParameterUnit, final CallbackWithNoParam callbackWithNoParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCLengthUnitParams(remoteControllerParameterUnit.getValue());
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (rCRespondMsgParser.isRCLengthUnitSetSucc()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
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

    public void getLengthUnit(final CallbackWithOneParam<RemoteControllerParameterUnit> callbackWithOneParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCLengthUnitParams();
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                callbackWithOneParam.onSuccess(rCRespondMsgParser.getRCLengthUnit());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setCommandStickMode(RemoteControllerCommandStickMode remoteControllerCommandStickMode, final CallbackWithNoParam callbackWithNoParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetRCControlModelParams(remoteControllerCommandStickMode.getValue());
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (rCRespondMsgParser.isRCControlModelSetSucc()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
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

    public void getCommandStickMode(final CallbackWithOneParam<RemoteControllerCommandStickMode> callbackWithOneParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createQueryRCControlModelParams();
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                callbackWithOneParam.onSuccess(rCRespondMsgParser.getRCControlModel());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setYawCoefficient(final float f, final CallbackWithNoParam callbackWithNoParam) {
        AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentVersion(new IAutelFirmVersionCallback<AircraftComponentVersionInfo>() {
            public void onReceiveVersion(AircraftComponentVersionInfo aircraftComponentVersionInfo) {
                if (SdkInternalUtils.isVersionBigger(10846, aircraftComponentVersionInfo.getFmuVersion())) {
                    FlyControllerManager.getAutelFlyControllerRequestManager().setYawSenCoefficient((double) f, new AutelCompletionCallback.ICompletionCallbackWith<Double>() {
                        public void onResult(Double d) {
                            if (callbackWithNoParam != null) {
                                callbackWithNoParam.onSuccess();
                            }
                        }

                        public void onFailure(AutelError autelError) {
                            if (callbackWithNoParam != null) {
                                callbackWithNoParam.onFailure(autelError);
                            }
                        }
                    });
                    return;
                }
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_IS_NOT_SUPPORTED_FOR_CURRENT_VERSION);
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

    public void getYawCoefficient(final CallbackWithOneParam<Float> callbackWithOneParam) {
        AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentVersion(new IAutelFirmVersionCallback<AircraftComponentVersionInfo>() {
            public void onReceiveVersion(AircraftComponentVersionInfo aircraftComponentVersionInfo) {
                if (SdkInternalUtils.isVersionBigger(10846, aircraftComponentVersionInfo.getFmuVersion())) {
                    FlyControllerManager.getAutelFlyControllerRequestManager().queryYawSenCoefficient(new AutelCompletionCallback.ICompletionCallbackWith<Double>() {
                        public void onResult(Double d) {
                            callbackWithOneParam.onSuccess(Float.valueOf(d.floatValue()));
                        }

                        public void onFailure(AutelError autelError) {
                            callbackWithOneParam.onFailure(autelError);
                        }
                    });
                } else {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_IS_NOT_SUPPORTED_FOR_CURRENT_VERSION);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVersionInfo(final CallbackWithOneParam<RemoteControllerVersionInfo> callbackWithOneParam) {
        AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentVersion(new IAutelFirmVersionCallback<AircraftComponentVersionInfo>() {
            public void onReceiveVersion(final AircraftComponentVersionInfo aircraftComponentVersionInfo) {
                AutelFirmVersionRequestManager.getInstance().requestAutelRCVersion(new IAutelFirmVersionCallback<RemoteControllerVersionPartInfo>() {
                    public void onReceiveVersion(final RemoteControllerVersionPartInfo remoteControllerVersionPartInfo) {
                        callbackWithOneParam.onSuccess(new RemoteControllerVersionInfo() {
                            public String getRepeaterVersion() {
                                return remoteControllerVersionPartInfo.getRepeaterVersion();
                            }

                            public String getRFTXVersion() {
                                return remoteControllerVersionPartInfo.getRFTXVersion();
                            }

                            public String getRemoteControlVersion() {
                                return remoteControllerVersionPartInfo.getRemoteControlVersion();
                            }

                            public String getRFRXVersion() {
                                return aircraftComponentVersionInfo.getRFRXVersion();
                            }

                            public String toString() {
                                return "RepeaterVersion : " + getRepeaterVersion() + ", RFTXVersion : " + getRFTXVersion() + ", RemoteControlVersion : " + getRemoteControlVersion() + ", RFRXVersion : " + getRFRXVersion();
                            }
                        });
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getSerialNumber(final CallbackWithOneParam<String> callbackWithOneParam) {
        AutelFirmVersionRequestManager.getInstance().requestAutelRCSNVersion(new IAutelFirmVersionCallback<RemoteControllerSerialNumberVersionInfo>() {
            public void onReceiveVersion(RemoteControllerSerialNumberVersionInfo remoteControllerSerialNumberVersionInfo) {
                String remoteControlSerialNumber = remoteControllerSerialNumberVersionInfo.getRemoteControlSerialNumber();
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (!RemoteController10.this.notEmpty(remoteControlSerialNumber)) {
                    remoteControlSerialNumber = "N/A";
                }
                callbackWithOneParam.onSuccess(remoteControlSerialNumber);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
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

    public void init(final IAutelStateManager iAutelStateManager) {
        AutelAircraftManager.getRCManager().addIAutelConnectionStatusListener(AutelListenerManager.InitControllerConnectStateListener, new IAutelConnectionStatusListener() {
            public void onConnect() {
                Log.v("getRCManager ", "onConnect " + iAutelStateManager.isRemoteControllerConnected());
                if (!iAutelStateManager.isRemoteControllerConnected()) {
                    iAutelStateManager.setRemoteControllerConnected(true);
                }
            }

            public void onDisconnect() {
                Log.v("getRCManager ", "onDisconnect " + iAutelStateManager.isRemoteControllerConnected());
                if (iAutelStateManager.isRemoteControllerConnected()) {
                    iAutelStateManager.setRemoteControllerConnected(false);
                }
            }

            public void onReconnect() {
                Log.v("getRCManager ", "onReconnect " + iAutelStateManager.isRemoteControllerConnected());
                if (!iAutelStateManager.isRemoteControllerConnected()) {
                    iAutelStateManager.setRemoteControllerConnected(true);
                }
            }
        });
    }

    public void setGimbalDialAdjustSpeed(int i, final CallbackWithNoParam callbackWithNoParam) {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createSetGimbalAdjustSpeedParams(i);
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
            public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                if (!rCRespondMsgParser.isGimbalAdjustSpeedSetSucc()) {
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

            public void onFailure(AutelError autelError) {
                CallbackWithNoParam callbackWithNoParam = callbackWithNoParam;
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(autelError);
                }
            }
        });
    }

    public void getGimbalDialAdjustSpeed(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            RCCommandMessage rCCommandMessage = new RCCommandMessage();
            rCCommandMessage.createQueryGimbalAdjustSpeedParams();
            RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, new AutelCompletionCallback.ICompletionCallbackWith<RCRespondMsgParser>() {
                public void onResult(RCRespondMsgParser rCRespondMsgParser) {
                    callbackWithOneParam.onSuccess(Integer.valueOf(rCRespondMsgParser.getGimbalAdjustSpeed()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void destroy() {
        AutelAircraftManager.getRCManager().removeIAutelConnectionStatusListener(AutelListenerManager.InitControllerConnectStateListener);
        AutelAircraftManager.getRCManager().removeIAutelConnectionStatusListener(AutelListenerManager.RemoteControllerConnectStateListener);
        RemoteControllerButtonManager.getInstance().closeConnection();
        RemoteControllerButtonManager.getInstance().removeRemoteButtonControllerListener(getClass().getSimpleName());
        RemoteControllerManager.getInstance().removeQueryRCInfoDataCallback(getClass().getSimpleName());
    }

    public void connect() {
        RemoteControllerButtonManager.getInstance().closeConnection();
        RemoteControllerManager.getInstance().closeConnection();
        RemoteControllerManager.getInstance().openConnection();
        RemoteControllerButtonManager.getInstance().openConnection();
    }

    public void disconnect() {
        RemoteControllerButtonManager.getInstance().closeConnection();
        RemoteControllerManager.getInstance().closeConnection();
    }

    /* access modifiers changed from: private */
    public boolean notEmpty(String str) {
        return str != null && !"".equals(str);
    }
}
