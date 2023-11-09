package com.autel.internal.flycontroller.evo2;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.visual.TrackTargetArea;
import com.autel.common.camera.visual.TrackingAction;
import com.autel.common.camera.visual.TrackingGoalArea;
import com.autel.common.camera.visual.ViewPointTargetArea;
import com.autel.common.camera.visual.ViewpointAction;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.AuthInfo;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.CalibrateIMUStatus;
import com.autel.common.flycontroller.CalibrateIMUStep;
import com.autel.common.flycontroller.FmuParameterEvent;
import com.autel.common.flycontroller.RTKSignalType;
import com.autel.common.flycontroller.RtkCoordinateSystem;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.common.flycontroller.evo2.MotionDelayParams;
import com.autel.common.flycontroller.evo2.TripodParams;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import com.autel.internal.flycontroller.RxAutelFlyControllerImpl;
import com.autel.internal.sdk.flycontroller.FileDataType;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.flycontroller.Evo2FlyController;
import com.autel.sdk.flycontroller.p007rx.RxEvo2FlyController;
import io.reactivex.Observable;
import java.util.List;

public class RxEvo2FlyControllerImpl extends RxAutelFlyControllerImpl implements RxEvo2FlyController {
    /* access modifiers changed from: private */
    public Evo2FlyController flyController;

    public Observable<VisualSettingInfo> getVisualSettingInfo() {
        return null;
    }

    public RxEvo2FlyControllerImpl(Evo2FlyController evo2FlyController) {
        super(evo2FlyController);
        this.flyController = evo2FlyController;
    }

    public void startCalibrationIMU(CallbackWithTwoParams<CalibrateIMUStep, CalibrateIMUStatus> callbackWithTwoParams) {
        this.flyController.startCalibrationIMU(callbackWithTwoParams);
    }

    public void setFlyControllerParameterChangedListener(CallbackWithTwoParams<FmuParameterEvent, Float> callbackWithTwoParams) {
        this.flyController.setFlyControllerParameterChangedListener(callbackWithTwoParams);
    }

    public void setTrackingTargetListener(CallbackWithTwoParams<List<TrackingGoalArea>, Boolean> callbackWithTwoParams) {
        this.flyController.setTrackingTargetListener(callbackWithTwoParams);
    }

    public void setOrbitTargetListener(CallbackWithOneParam<TrackTargetArea> callbackWithOneParam) {
        this.flyController.setOrbitTargetListener(callbackWithOneParam);
    }

    public Observable<Boolean> setTrackingMode(final TrackingAction trackingAction) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setTrackingMode(trackingAction, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C44831.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C44831.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setViewpointAction(final ViewpointAction viewpointAction) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setViewpointAction(viewpointAction, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45052.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45052.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualViewPointCoordinate(final float f, final float f2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setVisualViewPointCoordinate(f, f2, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45273.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45273.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualSettingParams(final VisualSettingSwitchblade visualSettingSwitchblade, final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setVisualSettingParams(visualSettingSwitchblade, i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45484.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45484.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualDigitalZoom(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setVisualDigitalZoom(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45505.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45505.this.setException(autelError);
                    }
                });
            }
        }.fire();
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
                RxEvo2FlyControllerImpl.this.flyController.droneArmed(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45526.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45526.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> droneDisarmed() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.droneDisarmed(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45547.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45547.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualSettingEnable(final VisualSettingSwitchblade visualSettingSwitchblade, final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setVisualSettingEnable(visualSettingSwitchblade, z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C45568.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C45568.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<VisualSettingInfo> isVisualSettingEnable() {
        return new RxLock<VisualSettingInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getVisualSettingInfo(new CallbackWithOneParam<VisualSettingInfo>() {
                    public void onSuccess(VisualSettingInfo visualSettingInfo) {
                        C45589.this.setData(visualSettingInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C45589.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setAircraftHeadingDirection(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setAircraftHeadingDirection(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C448510.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C448510.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setBoatMode(final BoatMode boatMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setBoatMode(boatMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C448711.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C448711.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<BoatMode> getBoatMode() {
        return new RxLock<BoatMode>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getBoatMode(new CallbackWithOneParam<BoatMode>() {
                    public void onSuccess(BoatMode boatMode) {
                        C448912.this.setData(boatMode);
                    }

                    public void onFailure(AutelError autelError) {
                        C448912.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setTripodParams(final TripodParams tripodParams) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setTripodParams(tripodParams, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C449113.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C449113.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setMotionDelayParams(final MotionDelayParams motionDelayParams) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setMotionDelayParams(motionDelayParams, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C449314.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C449314.this.setException(autelError);
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
                RxEvo2FlyControllerImpl.this.flyController.cancelMission(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C449515.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C449515.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> checkNFZ(final String str, final String str2) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.checkNFZ(str, str2, new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C449716.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C449716.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> uploadFileData(final String str, final FileDataType fileDataType) {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.uploadFileData(str, fileDataType, new CallbackWithOneParamProgress<Float>() {
                    public void onSuccess(Float f) {
                    }

                    public void onProgress(float f) {
                        C449917.this.setData(Float.valueOf(f));
                    }

                    public void onFailure(AutelError autelError) {
                        C449917.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setGasPedalSensitivity(final float f) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setGasPedalSensitivity(f, new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C450118.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C450118.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getGasPedalSensitivity() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getGasPedalSensitivity(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C450319.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C450319.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setATTISensitivity(final float f) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setATTISensitivity(f, new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C450720.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C450720.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getATTISensitivity() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getATTISensitivity(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C450921.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C450921.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setBrakeSensitivity(final float f) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setBrakeSensitivity(f, new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C451122.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C451122.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getBrakeSensitivity() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getBrakeSensitivity(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C451323.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C451323.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setYawStrokeSensitivity(final float f) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setYawStrokeSensitivity(f, new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C451524.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C451524.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getYawStrokeSensitivity() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getYawStrokeSensitivity(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C451725.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C451725.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setPitchAndRollSenCoefficient(final float f) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setPitchAndRollSenCoefficient(f, new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C451926.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C451926.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Float> getPitchAndRollSenCoefficient() {
        return new RxLock<Float>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getPitchAndRollSenCoefficient(new CallbackWithOneParam<Float>() {
                    public void onSuccess(Float f) {
                        C452127.this.setData(f);
                    }

                    public void onFailure(AutelError autelError) {
                        C452127.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualFollowMode(final DynamicTrackMode dynamicTrackMode) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setVisualFollowMode(dynamicTrackMode, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C452328.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C452328.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualViewPointCoordinate(final float f, final float f2, final float f3) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setVisualViewPointCoordinate(f, f2, f3, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C452529.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C452529.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> updateVisualResolutionAngle() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.updateVisualResolutionAngle(new CallbackWithNoParam() {
                    public void onSuccess() {
                        C452930.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C452930.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setVisualViewPointSpeed(final float f) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setVisualViewPointSpeed(f, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C453131.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C453131.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<EvoFlyControllerParameterRangeManager> getParameterRangeManager() {
        return new RxLock<EvoFlyControllerParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                EvoFlyControllerParameterRangeManager parameterRangeManager = RxEvo2FlyControllerImpl.this.flyController.getParameterRangeManager();
                if (RxEvo2FlyControllerImpl.this.flyController == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(parameterRangeManager);
                }
            }
        }.fire();
    }

    public Observable<AuthInfo> getRtkAuthInfo() {
        return new RxLock<AuthInfo>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getRtkAuthInfo(new CallbackWithOneParam<AuthInfo>() {
                    public void onSuccess(AuthInfo authInfo) {
                        C453433.this.setData(authInfo);
                    }

                    public void onFailure(AutelError autelError) {
                        C453433.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setUseRTK(final boolean z) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setUseRTK(z, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C453634.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C453634.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> getUseRTK() {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getUseRTK(new CallbackWithOneParam<Boolean>() {
                    public void onSuccess(Boolean bool) {
                        C453835.this.setData(bool);
                    }

                    public void onFailure(AutelError autelError) {
                        C453835.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setRTKRecvType(final int i) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setRtkRecvType(i, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C454036.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C454036.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RTKSignalType> getRTKRecvType() {
        return new RxLock<RTKSignalType>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getRtkRecvType(new CallbackWithOneParam<RTKSignalType>() {
                    public void onSuccess(RTKSignalType rTKSignalType) {
                        C454237.this.setData(rTKSignalType);
                    }

                    public void onFailure(AutelError autelError) {
                        C454237.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<Boolean> setRTKCoordinateSys(final RtkCoordinateSystem rtkCoordinateSystem) {
        return new RxLock<Boolean>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.setRtkCoordinateSys(rtkCoordinateSystem, new CallbackWithNoParam() {
                    public void onSuccess() {
                        C454438.this.setData(true);
                    }

                    public void onFailure(AutelError autelError) {
                        C454438.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }

    public Observable<RtkCoordinateSystem> getRTKCoordinateSys() {
        return new RxLock<RtkCoordinateSystem>() {
            /* access modifiers changed from: protected */
            public void run() {
                RxEvo2FlyControllerImpl.this.flyController.getRtkCoordinateSys(new CallbackWithOneParam<RtkCoordinateSystem>() {
                    public void onSuccess(RtkCoordinateSystem rtkCoordinateSystem) {
                        C454639.this.setData(rtkCoordinateSystem);
                    }

                    public void onFailure(AutelError autelError) {
                        C454639.this.setException(autelError);
                    }
                });
            }
        }.fire();
    }
}
