package com.autel.internal.flycontroller.evo;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.visual.ViewPointTargetArea;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import com.autel.internal.flycontroller.RxAutelFlyControllerImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.flycontroller.EvoFlyController;
import com.autel.sdk.flycontroller.p007rx.RxEvoFlyController;
import io.reactivex.Observable;

public class RxEvoFlyControllerImpl extends RxAutelFlyControllerImpl implements RxEvoFlyController {
    /* access modifiers changed from: private */
    public EvoFlyController flyController;

    public Observable<VisualSettingInfo> getVisualSettingInfo() {
        return null;
    }

    public RxEvoFlyControllerImpl(EvoFlyController evoFlyController) {
        super(evoFlyController);
        this.flyController = evoFlyController;
    }

    public void setVisualWarnListener(CallbackWithOneParam<VisualWarningInfo> callbackWithOneParam) {
        this.flyController.setVisualWarnListener(callbackWithOneParam);
    }

    public void setAvoidanceRadarInfoListener(CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam) {
        this.flyController.setAvoidanceRadarInfoListener(callbackWithOneParam);
    }

    public void setVisualSettingInfoListener(CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam) {
        this.flyController.setVisualSettingInfoListener(callbackWithOneParam);
    }

    public void setViewpointInfoListener(CallbackWithOneParam<ViewPointTargetArea> callbackWithOneParam) {
        this.flyController.setViewpointInfoListener(callbackWithOneParam);
    }

    public void setRadarInfoListener(CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam) {
        this.flyController.setAvoidanceRadarInfoListener(callbackWithOneParam);
    }

    public void setFlyControllerInfoListener(CallbackWithOneParam<EvoFlyControllerInfo> callbackWithOneParam) {
        this.flyController.setFlyControllerInfoListener(callbackWithOneParam);
    }

    public Observable<Boolean> droneArmed() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.droneArmed(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C43941.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C43941.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> droneDisarmed() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.droneDisarmed(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C44032.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C44032.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualSettingEnable(final VisualSettingSwitchblade visualSettingSwitchblade, final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.setVisualSettingEnable(visualSettingSwitchblade, z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C44053.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C44053.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VisualSettingInfo> isVisualSettingEnable() {
        return new RxLock<VisualSettingInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.getVisualSettingInfo(new CallbackWithOneParam<VisualSettingInfo>() {
                    public void onSuccess(VisualSettingInfo visualSettingInfo) {
                        C44074.this.setData(visualSettingInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C44074.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAircraftHeadingDirection(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.setAircraftHeadingDirection(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C44095.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C44095.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setBoatMode(final BoatMode boatMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.setBoatMode(boatMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C44116.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C44116.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<BoatMode> getBoatMode() {
        return new RxLock<BoatMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.getBoatMode(new CallbackWithOneParam<BoatMode>() {
                    public void onSuccess(BoatMode boatMode) {
                        C44137.this.setData(boatMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C44137.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public boolean isSupportBoatMode() {
        return this.flyController.isSupportBoatMode();
    }

    public Observable<Boolean> cancelMission(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.cancelMission(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C44158.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C44158.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualFollowMode(final DynamicTrackMode dynamicTrackMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.setVisualFollowMode(dynamicTrackMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C44179.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C44179.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualViewPointCoordinate(final float f, final float f2, final float f3) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.setVisualViewPointCoordinate(f, f2, f3, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C439610.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C439610.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> updateVisualResolutionAngle() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.updateVisualResolutionAngle(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C439811.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C439811.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualViewPointSpeed(final float f) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvoFlyControllerImpl.this.flyController.setVisualViewPointSpeed(f, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C440012.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C440012.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<EvoFlyControllerParameterRangeManager> getParameterRangeManager() {
        return new RxLock<EvoFlyControllerParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                EvoFlyControllerParameterRangeManager parameterRangeManager = RxEvoFlyControllerImpl.this.flyController.getParameterRangeManager();
                if (RxEvoFlyControllerImpl.this.flyController == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(parameterRangeManager);
                }
            }
        }.fire();
    }
}
