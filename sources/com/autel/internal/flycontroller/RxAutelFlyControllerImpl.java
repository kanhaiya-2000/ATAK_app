package com.autel.internal.flycontroller;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerVersionInfo;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.flycontroller.C4930AutelFlyController;
import com.autel.sdk.flycontroller.p007rx.RxAutelFlyController;
import io.reactivex.Observable;

public class RxAutelFlyControllerImpl implements RxAutelFlyController {
    /* access modifiers changed from: private */
    public C4930AutelFlyController mAutelFlyController;

    public RxAutelFlyControllerImpl(C4930AutelFlyController autelFlyController) {
        this.mAutelFlyController = autelFlyController;
    }

    public void setCalibrateCompassListener(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        this.mAutelFlyController.setCalibrateCompassListener(callbackWithOneParam);
    }

    public void setWarningListener(CallbackWithTwoParams<ARMWarning, MagnetometerState> callbackWithTwoParams) {
        this.mAutelFlyController.setWarningListener(callbackWithTwoParams);
    }

    public Observable<Boolean> setBeginnerModeEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setBeginnerModeEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C43191.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C43191.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isBeginnerModeEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.isBeginnerModeEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C43412.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C43412.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMaxHeight(final double d) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setMaxHeight(d, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C43513.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C43513.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getMaxHeight() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.getMaxHeight(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C43534.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C43534.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMaxRange(final double d) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setMaxRange(d, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C43555.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C43555.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getMaxRange() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.getMaxRange(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C43576.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C43576.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setReturnHeight(final double d) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setReturnHeight(d, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C43597.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C43597.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getReturnHeight() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.getReturnHeight(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C43618.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C43618.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMaxHorizontalSpeed(final double d) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setMaxHorizontalSpeed(d, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C43639.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C43639.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getMaxHorizontalSpeed() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.getMaxHorizontalSpeed(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C432110.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C432110.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAttitudeModeEnable(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setAttitudeModeEnable(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C432311.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C432311.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> isAttitudeModeEnable() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.isAttitudeModeEnable(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C432512.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C432512.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setLedPilotLamp(final LedPilotLamp ledPilotLamp) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setLedPilotLamp(ledPilotLamp, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C432713.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C432713.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<LedPilotLamp> getLedPilotLamp() {
        return new RxLock<LedPilotLamp>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.getLedPilotLamp(new CallbackWithOneParam<LedPilotLamp>() {
                    public void onSuccess(LedPilotLamp ledPilotLamp) {
                        C432914.this.setData(ledPilotLamp);
                    }

                    public void onFailure(AutelError autelError) {
                        C432914.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public void startCalibrateCompass(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        this.mAutelFlyController.startCalibrateCompass(callbackWithOneParam);
    }

    public Observable<Boolean> takeOff() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.takeOff(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C433115.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C433115.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> goHome() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.goHome(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C433316.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C433316.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> land() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.land(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C433517.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C433517.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> cancelLand() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.cancelLand(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C433718.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C433718.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> cancelReturn() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.cancelReturn(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C433919.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C433919.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAircraftLocationAsHomePoint() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setAircraftLocationAsHomePoint(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C434320.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C434320.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setLocationAsHomePoint(double d, double d2) {
        final double d3 = d;
        final double d4 = d2;
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.setLocationAsHomePoint(d3, d4, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C434521.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C434521.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<String> getSerialNumber() {
        return new RxLock<String>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.getSerialNumber(new CallbackWithOneParam<String>() {
                    public void onSuccess(String str) {
                        C434722.this.setData(str);
                    }

                    public void onFailure(AutelError autelError) {
                        C434722.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<FlyControllerVersionInfo> getVersionInfo() {
        return new RxLock<FlyControllerVersionInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxAutelFlyControllerImpl.this.mAutelFlyController.getVersionInfo(new CallbackWithOneParam<FlyControllerVersionInfo>() {
                    public void onSuccess(FlyControllerVersionInfo flyControllerVersionInfo) {
                        C434923.this.setData(flyControllerVersionInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C434923.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
