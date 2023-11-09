package com.autel.internal.remotecontroller;

import android.util.Pair;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.remotecontroller.CustomFunction;
import com.autel.common.remotecontroller.CustomKey;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerConnectState;
import com.autel.common.remotecontroller.RemoteControllerInfo;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.common.remotecontroller.RemoteControllerParameterRangeManager;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.RemoteControllerVersionInfo;
import com.autel.common.remotecontroller.TeachingMode;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.remotecontroller.C4932AutelRemoteController;
import com.autel.sdk.remotecontroller.p010rx.RxAutelRemoteController;
import io.reactivex.Observable;

public class RxRemoteControllerImpl implements RxAutelRemoteController {
    /* access modifiers changed from: private */
    public C4932AutelRemoteController mRemoteController;

    public RxRemoteControllerImpl(C4932AutelRemoteController autelRemoteController) {
        this.mRemoteController = autelRemoteController;
    }

    public void setConnectStateListener(CallbackWithOneParam<RemoteControllerConnectState> callbackWithOneParam) {
        this.mRemoteController.setConnectStateListener(callbackWithOneParam);
    }

    public void setRemoteButtonControllerListener(CallbackWithOneParam<RemoteControllerNavigateButtonEvent> callbackWithOneParam) {
        this.mRemoteController.setRemoteButtonControllerListener(callbackWithOneParam);
    }

    public void setInfoDataListener(CallbackWithOneParam<RemoteControllerInfo> callbackWithOneParam) {
        this.mRemoteController.setInfoDataListener(callbackWithOneParam);
    }

    public void setControlMenuListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.mRemoteController.setControlMenuListener(callbackWithOneParam);
    }

    public Observable<Boolean> setLanguage(final RemoteControllerLanguage remoteControllerLanguage) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setLanguage(remoteControllerLanguage, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C48501.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C48501.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RemoteControllerLanguage> getLanguage() {
        return new RxLock<RemoteControllerLanguage>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getLanguage(new CallbackWithOneParam<RemoteControllerLanguage>() {
                    public void onSuccess(RemoteControllerLanguage remoteControllerLanguage) {
                        C48712.this.setData(remoteControllerLanguage);
                    }

                    public void onFailure(AutelError autelError) {
                        C48712.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public void exitBinding() {
        this.mRemoteController.exitPairing();
    }

    public Observable<Boolean> enterBinding() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.enterPairing(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C48773.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C48773.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setRFPower(final RFPower rFPower) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setRFPower(rFPower, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C48794.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C48794.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RFPower> getRFPower() {
        return new RxLock<RFPower>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getRFPower(new CallbackWithOneParam<RFPower>() {
                    public void onSuccess(RFPower rFPower) {
                        C48815.this.setData(rFPower);
                    }

                    public void onFailure(AutelError autelError) {
                        C48815.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setTeachingMode(final TeachingMode teachingMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setTeachingMode(teachingMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C48836.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C48836.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<TeachingMode> getTeachingMode() {
        return new RxLock<TeachingMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getTeachingMode(new CallbackWithOneParam<TeachingMode>() {
                    public void onSuccess(TeachingMode teachingMode) {
                        C48857.this.setData(teachingMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C48857.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setStickCalibration(final RemoteControllerStickCalibration remoteControllerStickCalibration) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setStickCalibration(remoteControllerStickCalibration, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C48878.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C48878.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setParameterUnit(final RemoteControllerParameterUnit remoteControllerParameterUnit) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setParameterUnit(remoteControllerParameterUnit, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C48899.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C48899.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RemoteControllerParameterUnit> getLengthUnit() {
        return new RxLock<RemoteControllerParameterUnit>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getLengthUnit(new CallbackWithOneParam<RemoteControllerParameterUnit>() {
                    public void onSuccess(RemoteControllerParameterUnit remoteControllerParameterUnit) {
                        C485210.this.setData(remoteControllerParameterUnit);
                    }

                    public void onFailure(AutelError autelError) {
                        C485210.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setCommandStickMode(final RemoteControllerCommandStickMode remoteControllerCommandStickMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setCommandStickMode(remoteControllerCommandStickMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C485411.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C485411.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RemoteControllerCommandStickMode> getCommandStickMode() {
        return new RxLock<RemoteControllerCommandStickMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getCommandStickMode(new CallbackWithOneParam<RemoteControllerCommandStickMode>() {
                    public void onSuccess(RemoteControllerCommandStickMode remoteControllerCommandStickMode) {
                        C485612.this.setData(remoteControllerCommandStickMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C485612.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setYawCoefficient(final float f) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setYawCoefficient(f, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C485813.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C485813.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getYawCoefficient() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getYawCoefficient(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C486014.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C486014.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RemoteControllerVersionInfo> getVersionInfo() {
        return new RxLock<RemoteControllerVersionInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getVersionInfo(new CallbackWithOneParam<RemoteControllerVersionInfo>() {
                    public void onSuccess(RemoteControllerVersionInfo remoteControllerVersionInfo) {
                        C486215.this.setData(remoteControllerVersionInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C486215.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<String> getSerialNumber() {
        return new RxLock<String>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getSerialNumber(new CallbackWithOneParam<String>() {
                    public void onSuccess(String str) {
                        C486416.this.setData(str);
                    }

                    public void onFailure(AutelError autelError) {
                        C486416.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RemoteControllerParameterRangeManager> getParameterSupport() {
        return new RxLock<RemoteControllerParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                RemoteControllerParameterRangeManager parameterRangeManager = RxRemoteControllerImpl.this.mRemoteController.getParameterRangeManager();
                if (parameterRangeManager == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(parameterRangeManager);
                }
            }
        }.fire();
    }

    public Observable<Boolean> setGimbalDialAdjustSpeed(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setGimbalDialAdjustSpeed(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C486718.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C486718.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Integer> getGimbalDialAdjustSpeed() {
        return new RxLock<Integer>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getGimbalDialAdjustSpeed(new CallbackWithOneParam<Integer>() {
                    public void onSuccess(Integer num) {
                        C486919.this.setData(num);
                    }

                    public void onFailure(AutelError autelError) {
                        C486919.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setRcCustomKey(final CustomKey customKey, final CustomFunction customFunction) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.setRcCustomKey(customKey, customFunction, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C487320.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C487320.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Pair<CustomFunction, CustomFunction>> getRcCustomKey() {
        return new RxLock<Pair<CustomFunction, CustomFunction>>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxRemoteControllerImpl.this.mRemoteController.getRcCustomKey(new CallbackWithOneParam<Pair<CustomFunction, CustomFunction>>() {
                    public void onSuccess(Pair<CustomFunction, CustomFunction> pair) {
                        C487521.this.setData(pair);
                    }

                    public void onFailure(AutelError autelError) {
                        C487521.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
