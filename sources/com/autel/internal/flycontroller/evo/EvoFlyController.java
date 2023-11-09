package com.autel.internal.flycontroller.evo;

import android.util.Log;
import com.autel.AutelNet2.aircraft.engine.BoatModeInfo;
import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
import com.autel.AutelNet2.aircraft.flycontroller.FlyControllerManager2;
import com.autel.AutelNet2.aircraft.flycontroller.engine.AttitudeInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.engine.ImuStateInfoImpl;
import com.autel.AutelNet2.aircraft.flycontroller.engine.LocalCoordinateInfoImpl;
import com.autel.AutelNet2.aircraft.flycontroller.parser.GPSInfoInternal;
import com.autel.AutelNet2.aircraft.mission.controller.MissionCommonManager2;
import com.autel.AutelNet2.aircraft.mission.enmus.ArmStatus;
import com.autel.AutelNet2.aircraft.visual.VisualModelManager;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.ObstacleAvoidance;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.ViewpointInfo;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualHeartInfo;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualSettingAckInfo;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.VisualWarningInfoImpl;
import com.autel.camera.hardware.BaseCameraAndGimbalHardware;
import com.autel.camera.hardware.XB015CameraAndGimbalHardware;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.visual.ViewPointTargetArea;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.VisualTrackState;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.flycontroller.AutelFlyController20;
import com.autel.internal.flycontroller.evo.bean.G2FlyControllerInfoImpl;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.internal.sdk.flycontroller.VisualSettingInfoImpl;
import com.autel.sdk.flycontroller.p007rx.RxEvoFlyController;

public class EvoFlyController extends AutelFlyController20 implements EvoFlyControllerService {
    private static final String ATTITUDE_INFO_TAG = "addAttitudeInfoListenerTag";
    private static final String GPS_INFO_TAG = "addGPSInfoListenerTag";
    private static final String IMU_STATE_TAG = "addImuStatusListenerTag";
    private static final String LOCAL_COORDINATE_TAG = "LocalCoordinateInfoListenerTag";
    private static final String TrackingTargetListener = "setTrackingTargetListener";
    /* access modifiers changed from: private */
    public VisualSettingInfoImpl visualSettingInfo;

    public void connect() {
    }

    public void setVisualSettingParams(VisualSettingSwitchblade visualSettingSwitchblade, int i, CallbackWithNoParam callbackWithNoParam) {
    }

    public RxEvoFlyController toRx() {
        return null;
    }

    public void setVisualWarnListener(final CallbackWithOneParam<VisualWarningInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().removeVisualWarningListener(AutelListenerManager.VisualWarnListener);
        } else {
            VisualModelManager.instance().setVisualWarningListener(AutelListenerManager.VisualWarnListener, new CallbackWithOneParam<VisualWarningInfoImpl>() {
                public void onSuccess(VisualWarningInfoImpl visualWarningInfoImpl) {
                    callbackWithOneParam.onSuccess(visualWarningInfoImpl);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setFlyControllerInfoListener(final CallbackWithOneParam<EvoFlyControllerInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            FlyControllerManager2.getInstance().removeGPSInfoListener(GPS_INFO_TAG);
            FlyControllerManager2.getInstance().removeImuStatusListener(IMU_STATE_TAG);
            FlyControllerManager2.getInstance().removeAttitudeInfoListener(ATTITUDE_INFO_TAG);
            FlyControllerManager2.getInstance().removeLocalCoordinateInfoListener(LOCAL_COORDINATE_TAG);
            return;
        }
        FlyControllerManager2.getInstance().addGPSInfoListener(GPS_INFO_TAG, new CallbackWithOneParam<GPSInfoInternal>() {
            public void onSuccess(GPSInfoInternal gPSInfoInternal) {
                G2FlyControllerInfoImpl.instance().mG2GpsInfo = gPSInfoInternal;
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
        FlyControllerManager2.getInstance().addImuStatusListener(IMU_STATE_TAG, new CallbackWithOneParam<ImuStateInfoImpl>() {
            public void onSuccess(ImuStateInfoImpl imuStateInfoImpl) {
                G2FlyControllerInfoImpl.instance().mImuStateInfo = imuStateInfoImpl;
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
        FlyControllerManager2.getInstance().addAttitudeInfoListener(ATTITUDE_INFO_TAG, new CallbackWithOneParam<AttitudeInfoInternal>() {
            public void onSuccess(AttitudeInfoInternal attitudeInfoInternal) {
                G2FlyControllerInfoImpl.instance().mG2AttitudeInfo = attitudeInfoInternal;
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
        FlyControllerManager2.getInstance().addLocalCoordinateInfoListener(LOCAL_COORDINATE_TAG, new CallbackWithOneParam<LocalCoordinateInfoImpl>() {
            public void onSuccess(LocalCoordinateInfoImpl localCoordinateInfoImpl) {
                G2FlyControllerInfoImpl.instance().mLocalCoordinateInfo = localCoordinateInfoImpl;
                callbackWithOneParam.onSuccess(G2FlyControllerInfoImpl.instance());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void droneArmed(final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().DoArmAction(ArmStatus.ARM, new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (callbackWithNoParam != null) {
                    if (commandInfoInternal.isSuccess()) {
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

    public void droneDisarmed(final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().DoArmAction(ArmStatus.DISARM, new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (callbackWithNoParam != null) {
                    if (commandInfoInternal.isSuccess()) {
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

    public EvoFlyControllerParameterRangeManager getParameterRangeManager() {
        return new EvoFlyControllerParameterRangeManager() {
            public RangePair<Float> getHeightRange() {
                return new RangePair<Float>() {
                    public Float getValueFrom() {
                        return Float.valueOf(30.0f);
                    }

                    public Float getValueTo() {
                        return Float.valueOf(2000.0f);
                    }
                };
            }

            public RangePair<Float> getRangeOfMaxRange() {
                return new RangePair<Float>() {
                    public Float getValueFrom() {
                        return Float.valueOf(30.0f);
                    }

                    public Float getValueTo() {
                        return Float.valueOf(10000.0f);
                    }
                };
            }

            public RangePair<Float> getHorizontalSpeedRange() {
                return new RangePair<Float>() {
                    public Float getValueFrom() {
                        return Float.valueOf(0.0f);
                    }

                    public Float getValueTo() {
                        return Float.valueOf(25.0f);
                    }
                };
            }

            public RangePair<Float> getReturnHeightRange() {
                return new RangePair<Float>() {
                    public Float getValueFrom() {
                        return Float.valueOf(30.0f);
                    }

                    public Float getValueTo() {
                        return Float.valueOf(800.0f);
                    }
                };
            }
        };
    }

    public void setAircraftHeadingDirection(int i, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setFlightControllerDirect(i, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_UNKNOWN);
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

    public void setBoatMode(BoatMode boatMode, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setBoatMode(boatMode, new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (callbackWithNoParam != null) {
                    if (commandInfoInternal.isSuccess()) {
                        callbackWithNoParam.onSuccess();
                    } else {
                        callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                    }
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getBoatMode(final CallbackWithOneParam<BoatMode> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getBoatMode(new CallbackWithOneParam<BoatModeInfo>() {
            public void onSuccess(BoatModeInfo boatModeInfo) {
                if (callbackWithOneParam != null) {
                    if (boatModeInfo.isSuccess()) {
                        callbackWithOneParam.onSuccess(BoatMode.find(boatModeInfo.getData()));
                    } else {
                        callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    }
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public boolean isSupportBoatMode() {
        return AircraftHeatBeatManager2.getInstance().getHeartBeatInfo().getVersionId() > 1;
    }

    public void cancelMission(int i, final CallbackWithNoParam callbackWithNoParam) {
        MissionCommonManager2.getInstance().operateStopMissionByCmd(i, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelErrorUtil.createCommandFailedError("cancel callback result is false"));
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

    public void destroy() {
        FlyControllerManager2.getInstance().destroy();
    }

    public void disconnect() {
        Log.d("BaseUdpConnection", "disconnect g2");
    }

    public void setAvoidanceRadarInfoListener(final CallbackWithOneParam<AvoidanceRadarInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().removeObstacleAvoidanceListener(AutelListenerManager.RadarInfoListener);
        } else {
            VisualModelManager.instance().setObstacleAvoidanceListener(AutelListenerManager.RadarInfoListener, new CallbackWithOneParam<ObstacleAvoidance>() {
                public void onSuccess(ObstacleAvoidance obstacleAvoidance) {
                    callbackWithOneParam.onSuccess(obstacleAvoidance);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setVisualSettingInfoListener(final CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().removeVisualHeartListener(AutelListenerManager.VisualSettingInfoListener);
            return;
        }
        if (this.visualSettingInfo == null) {
            this.visualSettingInfo = new VisualSettingInfoImpl();
        }
        VisualModelManager.instance().setVisualHeartListener(AutelListenerManager.VisualSettingInfoListener, new CallbackWithOneParam<VisualHeartInfo>() {
            public void onSuccess(VisualHeartInfo visualHeartInfo) {
                EvoFlyController.this.visualSettingInfo.isAvoidanceEnableWhenTracking = visualHeartInfo.isTrackingAvoidanceEnable();
                EvoFlyController.this.visualSettingInfo.isAvoidanceSystemEnable = visualHeartInfo.isAvoidanceEnable();
                EvoFlyController.this.visualSettingInfo.isRadarMapEnable = visualHeartInfo.isShowRadar();
                EvoFlyController.this.visualSettingInfo.isPullBackEnableWhenTracking = visualHeartInfo.isTrackingBackOffEnable();
                EvoFlyController.this.visualSettingInfo.isLandingProtectEnable = visualHeartInfo.isLandingProtectionEnable();
                EvoFlyController.this.visualSettingInfo.isVisualLocationEnable = visualHeartInfo.isOdometerEnable();
                EvoFlyController.this.visualSettingInfo.isDetectObstacleEnableWhenReturn = visualHeartInfo.isRTHAvoidanceEnable();
                EvoFlyController.this.visualSettingInfo.isLandingAccuratelyEnable = visualHeartInfo.isLandingAccurateEnable();
                EvoFlyController.this.visualSettingInfo.isAvoidInHorizontal = visualHeartInfo.isPointFlyLeftRightEnable();
                DynamicTrackMode dynamicTrackMode = DynamicTrackMode.STOP_MODE;
                if (visualHeartInfo.getTrackState() != VisualTrackState.IDLE) {
                    dynamicTrackMode = DynamicTrackMode.COMMON_MODE;
                } else if (visualHeartInfo.isTripodMode()) {
                    dynamicTrackMode = DynamicTrackMode.LOCKED_MODE;
                } else if (visualHeartInfo.isTerrainFollowEnable()) {
                    dynamicTrackMode = DynamicTrackMode.PARALLEL_MODE;
                }
                EvoFlyController.this.visualSettingInfo.visualTrackState = visualHeartInfo.getTrackState();
                EvoFlyController.this.visualSettingInfo.followMode = dynamicTrackMode;
                EvoFlyController.this.visualSettingInfo.orbitModeState = visualHeartInfo.getOrbitModeState();
                EvoFlyController.this.visualSettingInfo.visualMainFlyState = visualHeartInfo.getVisualMainFlyState();
                EvoFlyController.this.visualSettingInfo.visualWarnState = visualHeartInfo.getVisualWarnState();
                EvoFlyController.this.visualSettingInfo.isImageMode = visualHeartInfo.isCameraMode();
                EvoFlyController.this.visualSettingInfo.isVisualReady = visualHeartInfo.isVisualReady();
                EvoFlyController.this.visualSettingInfo.isCalibrationMode = visualHeartInfo.isCalibrationMode();
                EvoFlyController.this.visualSettingInfo.isGestureRecognizationMode = visualHeartInfo.isGestureRecognizationEnable();
                EvoFlyController.this.visualSettingInfo.isPointFlyMode = visualHeartInfo.isPointflyMode();
                EvoFlyController.this.visualSettingInfo.isPointFlyInsideMode = visualHeartInfo.isPointflyInsideMode();
                EvoFlyController.this.visualSettingInfo.speed = visualHeartInfo.getSpeed() / 10;
                callbackWithOneParam.onSuccess(EvoFlyController.this.visualSettingInfo);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setViewpointInfoListener(final CallbackWithOneParam<ViewPointTargetArea> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().removeViewpointTargetAreaListener("setViewpointInfoListener");
        } else {
            VisualModelManager.instance().setViewpointTargetAreaListener("setViewpointInfoListener", new CallbackWithOneParam<ViewpointInfo>() {
                public void onSuccess(ViewpointInfo viewpointInfo) {
                    ViewPointTargetArea viewPointTargetArea = new ViewPointTargetArea();
                    viewPointTargetArea.xRatio = viewpointInfo.getPointflyScaleX();
                    viewPointTargetArea.yRatio = viewpointInfo.getPointflyScaleY();
                    callbackWithOneParam.onSuccess(viewPointTargetArea);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setVisualSettingEnable(VisualSettingSwitchblade visualSettingSwitchblade, boolean z, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualSettingSwitchblade(visualSettingSwitchblade.getCmdValue(), z, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo == null || visualSettingAckInfo.getAck() != 0) {
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

    public void getVisualSettingInfo(final CallbackWithOneParam<VisualSettingInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().removeVisualHeartListener(AutelListenerManager.VisualHeartListener);
            return;
        }
        if (this.visualSettingInfo == null) {
            this.visualSettingInfo = new VisualSettingInfoImpl();
        }
        VisualModelManager.instance().setVisualHeartListener(AutelListenerManager.VisualHeartListener, new CallbackWithOneParam<VisualHeartInfo>() {
            public void onSuccess(VisualHeartInfo visualHeartInfo) {
                EvoFlyController.this.visualSettingInfo.isAvoidanceEnableWhenTracking = visualHeartInfo.isTrackingAvoidanceEnable();
                EvoFlyController.this.visualSettingInfo.isAvoidanceSystemEnable = visualHeartInfo.isAvoidanceEnable();
                EvoFlyController.this.visualSettingInfo.isRadarMapEnable = visualHeartInfo.isShowRadar();
                EvoFlyController.this.visualSettingInfo.isPullBackEnableWhenTracking = visualHeartInfo.isTrackingBackOffEnable();
                EvoFlyController.this.visualSettingInfo.isLandingProtectEnable = visualHeartInfo.isLandingProtectionEnable();
                EvoFlyController.this.visualSettingInfo.isVisualLocationEnable = visualHeartInfo.isOdometerEnable();
                EvoFlyController.this.visualSettingInfo.isDetectObstacleEnableWhenReturn = visualHeartInfo.isRTHAvoidanceEnable();
                EvoFlyController.this.visualSettingInfo.isLandingAccuratelyEnable = visualHeartInfo.isLandingAccurateEnable();
                EvoFlyController.this.visualSettingInfo.isAvoidInHorizontal = visualHeartInfo.isPointFlyLeftRightEnable();
                DynamicTrackMode dynamicTrackMode = DynamicTrackMode.STOP_MODE;
                if (visualHeartInfo.getTrackState() != VisualTrackState.IDLE) {
                    dynamicTrackMode = DynamicTrackMode.COMMON_MODE;
                } else if (visualHeartInfo.isTripodMode()) {
                    dynamicTrackMode = DynamicTrackMode.LOCKED_MODE;
                } else if (visualHeartInfo.isTerrainFollowEnable()) {
                    dynamicTrackMode = DynamicTrackMode.PARALLEL_MODE;
                }
                EvoFlyController.this.visualSettingInfo.visualTrackState = visualHeartInfo.getTrackState();
                EvoFlyController.this.visualSettingInfo.followMode = dynamicTrackMode;
                EvoFlyController.this.visualSettingInfo.orbitModeState = visualHeartInfo.getOrbitModeState();
                EvoFlyController.this.visualSettingInfo.visualMainFlyState = visualHeartInfo.getVisualMainFlyState();
                EvoFlyController.this.visualSettingInfo.visualWarnState = visualHeartInfo.getVisualWarnState();
                EvoFlyController.this.visualSettingInfo.isImageMode = visualHeartInfo.isCameraMode();
                EvoFlyController.this.visualSettingInfo.isVisualReady = visualHeartInfo.isVisualReady();
                EvoFlyController.this.visualSettingInfo.isCalibrationMode = visualHeartInfo.isCalibrationMode();
                EvoFlyController.this.visualSettingInfo.isGestureRecognizationMode = visualHeartInfo.isGestureRecognizationEnable();
                EvoFlyController.this.visualSettingInfo.isPointFlyMode = visualHeartInfo.isPointflyMode();
                EvoFlyController.this.visualSettingInfo.isPointFlyInsideMode = visualHeartInfo.isPointflyInsideMode();
                EvoFlyController.this.visualSettingInfo.speed = visualHeartInfo.getSpeed() / 10;
                callbackWithOneParam.onSuccess(EvoFlyController.this.visualSettingInfo);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setVisualFollowMode(DynamicTrackMode dynamicTrackMode, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualTrackingFightMode(dynamicTrackMode.getMode(), new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        });
    }

    public void setVisualViewPointCoordinate(final float f, final float f2, float f3, final CallbackWithNoParam callbackWithNoParam) {
        MediaMode find = MediaMode.find(CameraXB015Data.instance().getCurrentMode());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        VideoResolution videoResolution = videoMainResolutionAndFps == null ? VideoResolution.UNKNOWN : videoMainResolutionAndFps.resolution;
        PhotoAspectRatio find2 = PhotoAspectRatio.find(CameraXB015Data.instance().getPicResolution(), CameraProduct.XB015);
        if (find == MediaMode.UNKNOWN || videoResolution == VideoResolution.UNKNOWN || find2 == PhotoAspectRatio.UNKNOWN) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            return;
        }
        if (!(BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL instanceof XB015CameraAndGimbalHardware)) {
            BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL = new XB015CameraAndGimbalHardware();
        }
        int intValue = Integer.valueOf(videoResolution.value().split("\\*")[1]).intValue();
        if (f3 == 90.0f) {
            f3 -= 1.0f;
        }
        VisualModelManager.instance().setVisualFlyAngle(((int) ((BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL.updateHorizontalLineHeight(intValue, f3) - f2) * BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL.getVerticalAngle())) + 90, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    VisualModelManager.instance().setVisualViewPointCoord((int) (f * 100.0f), (int) (f2 * 100.0f), new CallbackWithOneParam<VisualSettingAckInfo>() {
                        public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                            if (visualSettingAckInfo.getAck() == 0) {
                                callbackWithNoParam.onSuccess();
                            } else {
                                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                            }
                        }

                        public void onFailure(AutelError autelError) {
                            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                        }
                    });
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        });
    }

    public void setVisualViewPointSpeed(float f, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualViewPointSpeed(f, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        });
    }

    public void setVisualDigitalZoom(int i, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualViewPointSpeed((float) i, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        });
    }

    public void updateVisualResolutionAngle(final CallbackWithNoParam callbackWithNoParam) {
        if (!(BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL instanceof XB015CameraAndGimbalHardware)) {
            BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL = new XB015CameraAndGimbalHardware();
        }
        VisualModelManager.instance().setVisualResolutionAngle((int) (BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL.getHorizontalAngle() * 10.0f), (int) (BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL.getVerticalAngle() * 10.0f), new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
                    callbackWithNoParam.onSuccess();
                } else {
                    callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        });
    }
}
