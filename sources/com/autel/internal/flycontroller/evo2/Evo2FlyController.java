package com.autel.internal.flycontroller.evo2;

import android.util.Log;
import com.autel.AutelNet2.aircraft.engine.BoatModeInfo;
import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
import com.autel.AutelNet2.aircraft.flycontroller.FlyControllerManager2;
import com.autel.AutelNet2.aircraft.flycontroller.engine.AttitudeInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.engine.AuthenInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.engine.ImuCalibrationStateInfo;
import com.autel.AutelNet2.aircraft.flycontroller.engine.ImuStateInfoImpl;
import com.autel.AutelNet2.aircraft.flycontroller.engine.LocalCoordinateInfoImpl;
import com.autel.AutelNet2.aircraft.flycontroller.engine.RtkIntenal;
import com.autel.AutelNet2.aircraft.flycontroller.parser.GPSInfoInternal;
import com.autel.AutelNet2.aircraft.mission.controller.MissionCommonManager2;
import com.autel.AutelNet2.aircraft.mission.engine.BreakPointFlyInfo;
import com.autel.AutelNet2.aircraft.mission.engine.MissionFileInfo;
import com.autel.AutelNet2.aircraft.mission.engine.MotionDelayInfo;
import com.autel.AutelNet2.aircraft.mission.engine.TripodInfo;
import com.autel.AutelNet2.aircraft.mission.enmus.ArmStatus;
import com.autel.AutelNet2.aircraft.visual.VisualModelManager;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.ObstacleAvoidance;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.ViewpointInfo;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualHeartInfo;
import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualSettingAckInfo;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.ReportGoalArea;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.UploadGoalArea;
import com.autel.AutelNet2.aircraft.visual.tracking.entity.VisualWarningInfoImpl;
import com.autel.camera.hardware.BaseCameraAndGimbalHardware;
import com.autel.camera.hardware.XB015CameraAndGimbalHardware;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.RangePair;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.visual.TargetType;
import com.autel.common.camera.visual.TrackTargetArea;
import com.autel.common.camera.visual.TrackingAction;
import com.autel.common.camera.visual.TrackingGoalArea;
import com.autel.common.camera.visual.TrackingState;
import com.autel.common.camera.visual.ViewPointTargetArea;
import com.autel.common.camera.visual.ViewpointAction;
import com.autel.common.camera.visual.VisualWarningInfo;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.AuthInfo;
import com.autel.common.flycontroller.BoatMode;
import com.autel.common.flycontroller.CalibrateIMUStatus;
import com.autel.common.flycontroller.CalibrateIMUStep;
import com.autel.common.flycontroller.DroneLocationType;
import com.autel.common.flycontroller.FmuParameterEvent;
import com.autel.common.flycontroller.RTKSignalType;
import com.autel.common.flycontroller.RtkCoordinateSystem;
import com.autel.common.flycontroller.VisualTrackState;
import com.autel.common.flycontroller.evo.EvoFlyControllerInfo;
import com.autel.common.flycontroller.evo.EvoFlyControllerParameterRangeManager;
import com.autel.common.flycontroller.evo2.MotionDelayParams;
import com.autel.common.flycontroller.evo2.RTKInternal;
import com.autel.common.flycontroller.evo2.TripodParams;
import com.autel.common.flycontroller.visual.AvoidanceRadarInfo;
import com.autel.common.flycontroller.visual.DynamicTrackMode;
import com.autel.common.flycontroller.visual.VisualSettingInfo;
import com.autel.common.flycontroller.visual.VisualSettingSwitchblade;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.evo2.BreakPointMissionInfo;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.flycontroller.AutelFlyController20;
import com.autel.internal.flycontroller.evo.bean.G2FlyControllerInfoImpl;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.error.AutelErrorUtil;
import com.autel.internal.sdk.flycontroller.FileDataType;
import com.autel.internal.sdk.flycontroller.VisualSettingInfoImpl;
import com.autel.sdk.flycontroller.p007rx.RxEvo2FlyController;
import com.autel.sdk10.AutelCommunity.utils.AutelMD5Util;
import com.autel.util.log.AutelLog;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Evo2FlyController extends AutelFlyController20 implements Evo2FlyControllerService {
    private static final String ATTITUDE_INFO_TAG = "addAttitudeInfoListenerTag";
    private static final String GPS_INFO_TAG = "addGPSInfoListenerTag";
    private static final String IMU_STATE_TAG = "addImuStatusListenerTag";
    private static final String LOCAL_COORDINATE_TAG = "LocalCoordinateInfoListenerTag";
    private static final String TrackingTargetListener = "setTrackingTargetListener";
    int height = 240;
    boolean isSelectTarget = false;
    int mCurrentCount = 0;
    int mCurrentID = -1;
    /* access modifiers changed from: private */
    public VisualSettingInfoImpl visualSettingInfo;
    int width = 320;

    public void connect() {
    }

    public RxEvo2FlyController toRx() {
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

    public void sendRtkData(byte[] bArr) {
        FlyControllerManager2.getInstance().uploadRTKData(bArr, (CallbackWithOneParam<Boolean>) null);
    }

    public void setRtkGGAListener(final CallbackWithOneParam<byte[]> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            FlyControllerManager2.getInstance().removeRTKInfoListener(AutelListenerManager.RtkGGAListener);
        } else {
            FlyControllerManager2.getInstance().addRTKInfoListener(AutelListenerManager.RtkGGAListener, new CallbackWithOneParam<byte[]>() {
                public void onSuccess(byte[] bArr) {
                    callbackWithOneParam.onSuccess(bArr);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setRtkInfoListener(final CallbackWithOneParam<RTKInternal> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            FlyControllerManager2.getInstance().removeRTKReportListener(AutelListenerManager.RtkInfoListener);
        } else {
            FlyControllerManager2.getInstance().addRTKReportListener(AutelListenerManager.RtkInfoListener, new CallbackWithOneParam<RtkIntenal>() {
                public void onSuccess(RtkIntenal rtkIntenal) {
                    RTKInternal rTKInternal = new RTKInternal();
                    rTKInternal.altitude = rtkIntenal.getHgt();
                    rTKInternal.altSigma = rtkIntenal.getHgtSigma();
                    rTKInternal.latitude = rtkIntenal.getLat();
                    rTKInternal.longitude = rtkIntenal.getLon();
                    rTKInternal.latSigma = rtkIntenal.getLatSigma();
                    rTKInternal.beidouSta = rtkIntenal.getBeidouSta();
                    rTKInternal.coordinateSys = rtkIntenal.getCoordinateSys();
                    rTKInternal.fixSat = rtkIntenal.getFixSat();
                    rTKInternal.solSta = rtkIntenal.getSolSta();
                    rTKInternal.posType = rtkIntenal.getPosType();
                    rTKInternal.lonSigma = rtkIntenal.getLonSigma();
                    rTKInternal.sVs = rtkIntenal.getSVs();
                    rTKInternal.solnSVs = rtkIntenal.getSolnSVs();
                    rTKInternal.gpsSta = rtkIntenal.getGpsSta();
                    rTKInternal.glonassSta = rtkIntenal.getGlonassSta();
                    rTKInternal.galileoSta = rtkIntenal.getGalileoSta();
                    rTKInternal.inPos = rtkIntenal.getInPos();
                    boolean z = true;
                    if (rtkIntenal.getRTKUsed() != 1) {
                        z = false;
                    }
                    rTKInternal.rtkUsed = z;
                    rTKInternal.locationType = DroneLocationType.find(rtkIntenal.getLocationType());
                    rTKInternal.signalType = RTKSignalType.find(rtkIntenal.getLocationType());
                    callbackWithOneParam.onSuccess(rTKInternal);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setBreakPointMissionListener(final CallbackWithOneParam<RealTimeInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            MissionCommonManager2.getInstance().removeBreakPointInfoListener("setBreakPointMissionListener");
        } else {
            MissionCommonManager2.getInstance().addBreakPointEventListener("setBreakPointMissionListener", new CallbackWithOneParam<BreakPointFlyInfo>() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess(final BreakPointFlyInfo breakPointFlyInfo) {
                    callbackWithOneParam.onSuccess(new BreakPointMissionInfo() {
                        public int getMissionId() {
                            return breakPointFlyInfo.getMissionId();
                        }

                        public int getExecuteIndex() {
                            return breakPointFlyInfo.getExecuteIndex();
                        }

                        public int getMissionType() {
                            return breakPointFlyInfo.getMissionType();
                        }

                        public String getGUID() {
                            return breakPointFlyInfo.getGUID();
                        }
                    });
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

    public void setFlyControllerParameterChangedListener(CallbackWithTwoParams<FmuParameterEvent, Float> callbackWithTwoParams) {
        if (callbackWithTwoParams != null) {
            FlyControllerManager2.getInstance().addFmuParameterListener(AutelListenerManager.FlyControllerParameterChangedListener, callbackWithTwoParams);
        } else {
            FlyControllerManager2.getInstance().removeFmuParameterListener(AutelListenerManager.FlyControllerParameterChangedListener);
        }
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

    public void setTripodParams(TripodParams tripodParams, final CallbackWithNoParam callbackWithNoParam) {
        TripodInfo tripodInfo = new TripodInfo();
        tripodInfo.setHSpeed(tripodParams.horizontalSpeed);
        tripodInfo.setVSpeed(tripodParams.verticalSpeed);
        tripodInfo.setRSpeed(tripodParams.rotateSpeed);
        tripodInfo.setMissionId(tripodParams.missionId);
        MissionCommonManager2.getInstance().setTripodSetting(tripodInfo, new CallbackWithOneParam<Boolean>() {
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

    public void setMotionDelayParams(MotionDelayParams motionDelayParams, final CallbackWithNoParam callbackWithNoParam) {
        MotionDelayInfo motionDelayInfo = new MotionDelayInfo();
        motionDelayInfo.setHSpeed(motionDelayParams.horizontalSpeed);
        motionDelayInfo.setVSpeed(motionDelayParams.verticalSpeed);
        motionDelayInfo.setRSpeed(motionDelayParams.rotateSpeed);
        motionDelayInfo.setTotalTime(motionDelayParams.totalTime);
        motionDelayInfo.setTimelapseType(motionDelayParams.motionDelayType.getValue());
        motionDelayInfo.setMissionId(motionDelayParams.missionId);
        MissionCommonManager2.getInstance().setMotionDelaySetting(motionDelayInfo, new CallbackWithOneParam<Boolean>() {
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

    public void checkNFZ(String str, String str2, final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().checkNFZDigest(str, str2, new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (callbackWithOneParam == null) {
                    return;
                }
                if (commandInfoInternal.errorCode() == 0 || commandInfoInternal.errorCode() == 2) {
                    callbackWithOneParam.onSuccess(false);
                } else {
                    callbackWithOneParam.onSuccess(true);
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

    public void uploadFileData(String str, FileDataType fileDataType, final CallbackWithOneParamProgress<Float> callbackWithOneParamProgress) {
        final File file = new File(str);
        if (!file.exists()) {
            AutelLog.m15082d("UploadFileData ", "file not exist !!!!");
            if (callbackWithOneParamProgress != null) {
                callbackWithOneParamProgress.onFailure(AutelError.MISSION_CURRENT_MISSION_IS_NULL);
                return;
            }
            return;
        }
        MissionFileInfo missionFileInfo = new MissionFileInfo();
        missionFileInfo.setSize(file.length());
        missionFileInfo.setFileName(file.getName());
        missionFileInfo.setType(fileDataType.getValue());
        try {
            missionFileInfo.setMd5(AutelMD5Util.getFileMD5String(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        MissionCommonManager2.getInstance().startUploadFileCmd(missionFileInfo, str, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
                AutelLog.m15082d("UploadFileData ", "onSuccess  - > " + bool);
                if (bool.booleanValue()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        AutelLog.m15082d("UploadFileData ", "start upload file ");
                        MissionCommonManager2.getInstance().uploadMissionFile(fileInputStream, new CallbackWithOneParamProgress<Integer>() {
                            public void onProgress(float f) {
                                AutelLog.m15082d("UploadFileData ", "progress - > " + f);
                                if (callbackWithOneParamProgress != null) {
                                    callbackWithOneParamProgress.onProgress(f);
                                    if (f >= 100.0f && atomicBoolean.compareAndSet(false, true)) {
                                        callbackWithOneParamProgress.onSuccess(Float.valueOf(f));
                                    }
                                }
                            }

                            public void onSuccess(Integer num) {
                                if (callbackWithOneParamProgress != null) {
                                    callbackWithOneParamProgress.onSuccess(Float.valueOf((float) num.intValue()));
                                }
                            }

                            public void onFailure(AutelError autelError) {
                                if (callbackWithOneParamProgress != null) {
                                    callbackWithOneParamProgress.onFailure(autelError);
                                }
                            }
                        });
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                        if (callbackWithOneParamProgress != null) {
                            callbackWithOneParamProgress.onFailure(AutelError.ALBUM_CAMERA_NOT_FIND);
                        }
                    }
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParamProgress callbackWithOneParamProgress = callbackWithOneParamProgress;
                if (callbackWithOneParamProgress != null) {
                    callbackWithOneParamProgress.onFailure(AutelError.COMMON_TIMEOUT);
                }
            }
        });
    }

    public void setGasPedalSensitivity(float f, final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().setGasPedalSensitivity(f, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(true);
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

    public void getGasPedalSensitivity(final CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getGasPedalSensitivity(new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(f);
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

    public void setATTISensitivity(float f, final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().setATTISensitivity(f, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(true);
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

    public void getATTISensitivity(final CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getATTISensitivity(new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(f);
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

    public void setBrakeSensitivity(float f, final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().setBrakeSensitivity(f, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(true);
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

    public void getBrakeSensitivity(final CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getBrakeSensitivity(new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(f);
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

    public void setYawStrokeSensitivity(float f, final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().setYawStrokeSensitivity(f, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(true);
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

    public void getYawStrokeSensitivity(final CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getYawStrokeSensitivity(new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(f);
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

    public void setPitchAndRollSenCoefficient(float f, final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().setPitchAndRollSenCoefficient(f, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(true);
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

    public void getPitchAndRollSenCoefficient(final CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getPitchAndRollSenCoefficient(new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(f);
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

    public void startCalibrationIMU(final CallbackWithTwoParams<CalibrateIMUStep, CalibrateIMUStatus> callbackWithTwoParams) {
        if (callbackWithTwoParams == null) {
            FlyControllerManager2.getInstance().removeIMUCalibrationStateListener("startCalibrationIMUListener");
        } else {
            FlyControllerManager2.getInstance().startImuCalibration(new CallbackWithOneParam<CommandInfoInternal>() {
                public void onSuccess(CommandInfoInternal commandInfoInternal) {
                    if (commandInfoInternal.isSuccess()) {
                        FlyControllerManager2.getInstance().addIMUCalibrationStateListener("startCalibrationIMUListener", new CallbackWithOneParam<ImuCalibrationStateInfo>() {
                            public void onFailure(AutelError autelError) {
                            }

                            public void onSuccess(ImuCalibrationStateInfo imuCalibrationStateInfo) {
                                if (callbackWithTwoParams != null) {
                                    AutelLog.m15082d("CommonCmdRequest", "startCalibrationIMU : " + imuCalibrationStateInfo.getStep() + " status:" + imuCalibrationStateInfo.getStatus());
                                    callbackWithTwoParams.onSuccess(CalibrateIMUStep.find(imuCalibrationStateInfo.getStep()), CalibrateIMUStatus.find(imuCalibrationStateInfo.getStatus()));
                                }
                            }
                        });
                        return;
                    }
                    CallbackWithTwoParams callbackWithTwoParams = callbackWithTwoParams;
                    if (callbackWithTwoParams != null) {
                        callbackWithTwoParams.onFailure(AutelError.COMMAND_FAILED);
                    }
                }

                public void onFailure(AutelError autelError) {
                    CallbackWithTwoParams callbackWithTwoParams = callbackWithTwoParams;
                    if (callbackWithTwoParams != null) {
                        callbackWithTwoParams.onFailure(autelError);
                    }
                }
            });
        }
    }

    public void getRtkAuthInfo(final CallbackWithOneParam<AuthInfo> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getRtkAuthenInfo(new CallbackWithOneParam<AuthenInfo>() {
            public void onSuccess(AuthenInfo authenInfo) {
                if (callbackWithOneParam != null) {
                    AuthInfo authInfo = new AuthInfo();
                    authInfo.deviceType = authenInfo.getDeviceType();
                    authInfo.deviceId = authenInfo.getDeviceId();
                    authInfo.secret = authenInfo.getServiceSecret();
                    authInfo.key = authenInfo.getServiceKey();
                    callbackWithOneParam.onSuccess(authInfo);
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

    public void setUseRTK(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setUseRTK(z, new CallbackWithOneParam<Integer>() {
            public void onSuccess(Integer num) {
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

    public void getUseRTK(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getUseRTK(new CallbackWithOneParam<Integer>() {
            public void onSuccess(Integer num) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    boolean z = true;
                    if (num.intValue() != 1) {
                        z = false;
                    }
                    callbackWithOneParam.onSuccess(Boolean.valueOf(z));
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

    public void setRtkCoordinateSys(RtkCoordinateSystem rtkCoordinateSystem, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setRTKCoordinateSys(rtkCoordinateSystem.getValue(), new CallbackWithOneParam<Integer>() {
            public void onSuccess(Integer num) {
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

    public void setRtkRecvType(int i, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setRTKRecvType(i, new CallbackWithOneParam<Integer>() {
            public void onSuccess(Integer num) {
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

    public void getRtkCoordinateSys(final CallbackWithOneParam<RtkCoordinateSystem> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getRTKCoordinateSys(new CallbackWithOneParam<Integer>() {
            public void onSuccess(Integer num) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(RtkCoordinateSystem.find(num.intValue()));
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

    public void getRtkRecvType(final CallbackWithOneParam<RTKSignalType> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getRTKRecvType(new CallbackWithOneParam<Integer>() {
            public void onSuccess(Integer num) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(RTKSignalType.find(num.intValue()));
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
                Evo2FlyController.this.visualSettingInfo.isAvoidanceEnableWhenTracking = visualHeartInfo.isTrackingAvoidanceEnable();
                Evo2FlyController.this.visualSettingInfo.isAvoidanceSystemEnable = visualHeartInfo.isAvoidanceEnable();
                Evo2FlyController.this.visualSettingInfo.isRadarMapEnable = visualHeartInfo.isShowRadar();
                Evo2FlyController.this.visualSettingInfo.isPullBackEnableWhenTracking = visualHeartInfo.isTrackingBackOffEnable();
                Evo2FlyController.this.visualSettingInfo.isLandingProtectEnable = visualHeartInfo.isLandingProtectionEnable();
                Evo2FlyController.this.visualSettingInfo.isVisualLocationEnable = visualHeartInfo.isOdometerEnable();
                Evo2FlyController.this.visualSettingInfo.isDetectObstacleEnableWhenReturn = visualHeartInfo.isRTHAvoidanceEnable();
                Evo2FlyController.this.visualSettingInfo.isLandingAccuratelyEnable = visualHeartInfo.isLandingAccurateEnable();
                Evo2FlyController.this.visualSettingInfo.isAvoidInHorizontal = visualHeartInfo.isPointFlyLeftRightEnable();
                DynamicTrackMode dynamicTrackMode = DynamicTrackMode.STOP_MODE;
                if (visualHeartInfo.getTrackState() != VisualTrackState.IDLE) {
                    dynamicTrackMode = DynamicTrackMode.COMMON_MODE;
                } else if (visualHeartInfo.isTripodMode()) {
                    dynamicTrackMode = DynamicTrackMode.LOCKED_MODE;
                } else if (visualHeartInfo.isTerrainFollowEnable()) {
                    dynamicTrackMode = DynamicTrackMode.PARALLEL_MODE;
                }
                Evo2FlyController.this.visualSettingInfo.followMode = dynamicTrackMode;
                Evo2FlyController.this.visualSettingInfo.orbitModeState = visualHeartInfo.getOrbitModeState();
                Evo2FlyController.this.visualSettingInfo.visualTrackState = visualHeartInfo.getTrackState();
                Evo2FlyController.this.visualSettingInfo.auxiliaryLedState = visualHeartInfo.getVisualLedState();
                Evo2FlyController.this.visualSettingInfo.visualMainFlyState = visualHeartInfo.getVisualMainFlyState();
                Evo2FlyController.this.visualSettingInfo.visualWarnState = visualHeartInfo.getVisualWarnState();
                Evo2FlyController.this.visualSettingInfo.isImageMode = visualHeartInfo.isCameraMode();
                Evo2FlyController.this.visualSettingInfo.isVisualReady = visualHeartInfo.isVisualReady();
                Evo2FlyController.this.visualSettingInfo.isCalibrationMode = visualHeartInfo.isCalibrationMode();
                Evo2FlyController.this.visualSettingInfo.isGestureRecognizationMode = visualHeartInfo.isGestureRecognizationEnable();
                Evo2FlyController.this.visualSettingInfo.isPointFlyMode = visualHeartInfo.isPointflyMode();
                Evo2FlyController.this.visualSettingInfo.isPointFlyInsideMode = visualHeartInfo.isPointflyInsideMode();
                Evo2FlyController.this.visualSettingInfo.isVisualLimitWhenDark = visualHeartInfo.isVisualLimitWhenDark();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftFontState = visualHeartInfo.isVisualLeftFontState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightFontState = visualHeartInfo.isVisualRightFontState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftNearState = visualHeartInfo.isVisualLeftNearState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightNearState = visualHeartInfo.isVisualRightNearState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftBottomState = visualHeartInfo.isVisualLeftBottomState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightBottomState = visualHeartInfo.isVisualRightBottomState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftRightState = visualHeartInfo.isVisualLeftRightState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightRightState = visualHeartInfo.isVisualRightRightState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftLeftState = visualHeartInfo.isVisualLeftLeftState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightLeftState = visualHeartInfo.isVisualRightLeftState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftTopState = visualHeartInfo.isVisualLeftTopState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightTopState = visualHeartInfo.isVisualRightTopState();
                Evo2FlyController.this.visualSettingInfo.isVisualCalibrationValid = visualHeartInfo.isVisualCalibrationValid();
                Evo2FlyController.this.visualSettingInfo.speed = visualHeartInfo.getSpeed() / 10;
                callbackWithOneParam.onSuccess(Evo2FlyController.this.visualSettingInfo);
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
                    viewPointTargetArea.topLine = viewpointInfo.getPointflyLimitTop();
                    viewPointTargetArea.horizonLine = viewpointInfo.getPointflyHorizon();
                    viewPointTargetArea.bottomLine = viewpointInfo.getPointflyLimitBottom();
                    viewPointTargetArea.pointFlyOnGoing = viewpointInfo.getPointflyOngoing();
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

    public void setVisualSettingParams(VisualSettingSwitchblade visualSettingSwitchblade, int i, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualSettingParams(visualSettingSwitchblade.getCmdValue(), i, new CallbackWithOneParam<VisualSettingAckInfo>() {
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
                Evo2FlyController.this.visualSettingInfo.isAvoidanceEnableWhenTracking = visualHeartInfo.isTrackingAvoidanceEnable();
                Evo2FlyController.this.visualSettingInfo.isAvoidanceSystemEnable = visualHeartInfo.isAvoidanceEnable();
                Evo2FlyController.this.visualSettingInfo.isRadarMapEnable = visualHeartInfo.isShowRadar();
                Evo2FlyController.this.visualSettingInfo.isPullBackEnableWhenTracking = visualHeartInfo.isTrackingBackOffEnable();
                Evo2FlyController.this.visualSettingInfo.isLandingProtectEnable = visualHeartInfo.isLandingProtectionEnable();
                Evo2FlyController.this.visualSettingInfo.isVisualLocationEnable = visualHeartInfo.isOdometerEnable();
                Evo2FlyController.this.visualSettingInfo.isDetectObstacleEnableWhenReturn = visualHeartInfo.isRTHAvoidanceEnable();
                Evo2FlyController.this.visualSettingInfo.isLandingAccuratelyEnable = visualHeartInfo.isLandingAccurateEnable();
                Evo2FlyController.this.visualSettingInfo.isAvoidInHorizontal = visualHeartInfo.isPointFlyLeftRightEnable();
                DynamicTrackMode dynamicTrackMode = DynamicTrackMode.STOP_MODE;
                if (visualHeartInfo.getTrackState() != VisualTrackState.IDLE) {
                    dynamicTrackMode = DynamicTrackMode.COMMON_MODE;
                } else if (visualHeartInfo.isTripodMode()) {
                    dynamicTrackMode = DynamicTrackMode.LOCKED_MODE;
                } else if (visualHeartInfo.isTerrainFollowEnable()) {
                    dynamicTrackMode = DynamicTrackMode.PARALLEL_MODE;
                }
                Evo2FlyController.this.visualSettingInfo.followMode = dynamicTrackMode;
                Evo2FlyController.this.visualSettingInfo.orbitModeState = visualHeartInfo.getOrbitModeState();
                Evo2FlyController.this.visualSettingInfo.visualTrackState = visualHeartInfo.getTrackState();
                Evo2FlyController.this.visualSettingInfo.auxiliaryLedState = visualHeartInfo.getVisualLedState();
                Evo2FlyController.this.visualSettingInfo.visualMainFlyState = visualHeartInfo.getVisualMainFlyState();
                Evo2FlyController.this.visualSettingInfo.visualWarnState = visualHeartInfo.getVisualWarnState();
                Evo2FlyController.this.visualSettingInfo.isImageMode = visualHeartInfo.isCameraMode();
                Evo2FlyController.this.visualSettingInfo.isVisualReady = visualHeartInfo.isVisualReady();
                Evo2FlyController.this.visualSettingInfo.isCalibrationMode = visualHeartInfo.isCalibrationMode();
                Evo2FlyController.this.visualSettingInfo.isGestureRecognizationMode = visualHeartInfo.isGestureRecognizationEnable();
                Evo2FlyController.this.visualSettingInfo.isPointFlyMode = visualHeartInfo.isPointflyMode();
                Evo2FlyController.this.visualSettingInfo.isPointFlyInsideMode = visualHeartInfo.isPointflyInsideMode();
                Evo2FlyController.this.visualSettingInfo.isVisualLimitWhenDark = visualHeartInfo.isVisualLimitWhenDark();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftFontState = visualHeartInfo.isVisualLeftFontState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightFontState = visualHeartInfo.isVisualRightFontState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftNearState = visualHeartInfo.isVisualLeftNearState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightNearState = visualHeartInfo.isVisualRightNearState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftBottomState = visualHeartInfo.isVisualLeftBottomState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightBottomState = visualHeartInfo.isVisualRightBottomState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftRightState = visualHeartInfo.isVisualLeftRightState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightRightState = visualHeartInfo.isVisualRightRightState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftLeftState = visualHeartInfo.isVisualLeftLeftState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightLeftState = visualHeartInfo.isVisualRightLeftState();
                Evo2FlyController.this.visualSettingInfo.isVisualLeftTopState = visualHeartInfo.isVisualLeftTopState();
                Evo2FlyController.this.visualSettingInfo.isVisualRightTopState = visualHeartInfo.isVisualRightTopState();
                Evo2FlyController.this.visualSettingInfo.isVisualCalibrationValid = visualHeartInfo.isVisualCalibrationValid();
                Evo2FlyController.this.visualSettingInfo.speed = visualHeartInfo.getSpeed() / 10;
                callbackWithOneParam.onSuccess(Evo2FlyController.this.visualSettingInfo);
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

    public void setVisualViewPointCoordinate(float f, float f2, float f3, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualViewPointCoord((int) (f * 100.0f), (int) (f2 * 100.0f), new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                Evo2FlyController.this.setVisualResolution();
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

    public void setVisualResolution() {
        MediaMode find = MediaMode.find(CameraXB015Data.instance().getCurrentMode());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        VideoResolution videoResolution = videoMainResolutionAndFps == null ? VideoResolution.UNKNOWN : videoMainResolutionAndFps.resolution;
        PhotoAspectRatio.find(CameraXB015Data.instance().getPicResolution(), CameraProduct.XT701);
        String value = videoResolution.value();
        if (find != MediaMode.UNKNOWN && !SoloControllerUnits.UNKNOWN.equalsIgnoreCase(value)) {
            this.width = Integer.valueOf(value.split("\\*")[0]).intValue();
            this.height = Integer.valueOf(value.split("\\*")[1]).intValue();
        }
        VisualModelManager.instance().setVisualResolution(this.width, this.height, new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                StringBuilder sb = new StringBuilder();
                sb.append("Viewpoint setVisualResolution ");
                sb.append(visualSettingAckInfo.getAck() == 0);
                AutelLog.m15081d(sb.toString());
            }

            public void onFailure(AutelError autelError) {
                AutelLog.m15081d("Viewpoint setVisualResolution onFailure ");
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
        VisualModelManager.instance().setVisualDigitalZoom(i, new CallbackWithOneParam<VisualSettingAckInfo>() {
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

    public void setTrackingMode(TrackingAction trackingAction, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualTrackingAction(trackingAction.getValue(), new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                if (visualSettingAckInfo.getAck() == 0) {
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

    public void setTrackingTargetListener(final CallbackWithTwoParams<List<TrackingGoalArea>, Boolean> callbackWithTwoParams) {
        if (callbackWithTwoParams == null) {
            VisualModelManager.instance().removeTrackingReportListener(TrackingTargetListener);
            return;
        }
        final ArrayList arrayList = new ArrayList();
        VisualModelManager.instance().setTrackingReportListener(TrackingTargetListener, new CallbackWithOneParam<ReportGoalArea>() {
            public void onSuccess(final ReportGoalArea reportGoalArea) {
                if (Evo2FlyController.this.mCurrentID != reportGoalArea.getId()) {
                    Evo2FlyController.this.mCurrentID = reportGoalArea.getId();
                    arrayList.clear();
                    Evo2FlyController.this.mCurrentCount = 0;
                    Evo2FlyController.this.isSelectTarget = false;
                }
                Evo2FlyController.this.mCurrentCount += reportGoalArea.getParams().getCount();
                for (final int i = 0; i < reportGoalArea.getParams().getArealist().size(); i++) {
                    C44731 r0 = new TrackingGoalArea() {
                        public int getId() {
                            return reportGoalArea.getId();
                        }

                        public float getAreaXRatio() {
                            return reportGoalArea.getParams().getArealist().get(i).getStartX();
                        }

                        public float getAreaYRatio() {
                            return reportGoalArea.getParams().getArealist().get(i).getStartY();
                        }

                        public float getWidthRatio() {
                            return reportGoalArea.getParams().getArealist().get(i).getWidth();
                        }

                        public float getHeightRatio() {
                            return reportGoalArea.getParams().getArealist().get(i).getHeight();
                        }

                        public int getStatus() {
                            return reportGoalArea.getParams().getArealist().get(i).getStatus();
                        }

                        public float getDistance() {
                            return reportGoalArea.getParams().getArealist().get(i).getDistance();
                        }

                        public TargetType getTargetType() {
                            return TargetType.find(reportGoalArea.getParams().getArealist().get(i).getTargetType());
                        }

                        public float getConfidence() {
                            return reportGoalArea.getParams().getArealist().get(i).getConfidence();
                        }

                        public List<Integer> getTargetInfo() {
                            return reportGoalArea.getParams().getArealist().get(i).getTargetInfo();
                        }

                        public int getObjId() {
                            return reportGoalArea.getParams().getObjId();
                        }

                        public long getTimestamp() {
                            return reportGoalArea.getParams().getTimestamp();
                        }
                    };
                    if (r0.getStatus() == 1) {
                        Evo2FlyController.this.isSelectTarget = true;
                    }
                    arrayList.add(r0);
                }
                if (Evo2FlyController.this.mCurrentCount == reportGoalArea.getParams().getTotal()) {
                    callbackWithTwoParams.onSuccess(arrayList, Boolean.valueOf(Evo2FlyController.this.isSelectTarget));
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithTwoParams.onFailure(autelError);
            }
        });
    }

    public void setOrbitTargetListener(final CallbackWithOneParam<TrackTargetArea> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            VisualModelManager.instance().removeVisualOrbitTargetAreaListener("setOrbitTargetListener");
        } else {
            VisualModelManager.instance().registerVisualOrbitTargetAreaListener("setOrbitTargetListener", new CallbackWithOneParam<UploadGoalArea>() {
                public void onSuccess(UploadGoalArea uploadGoalArea) {
                    TrackTargetArea trackTargetArea = new TrackTargetArea();
                    trackTargetArea.heightRatio = uploadGoalArea.getHeightRatio();
                    trackTargetArea.widthRatio = uploadGoalArea.getWidthRatio();
                    trackTargetArea.xRatio = uploadGoalArea.getStartX();
                    trackTargetArea.yRatio = uploadGoalArea.getStartY();
                    trackTargetArea.timeStamp = uploadGoalArea.getTimestamp();
                    trackTargetArea.trackingState = TrackingState.find(uploadGoalArea.getStatus());
                    callbackWithOneParam.onSuccess(trackTargetArea);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setViewpointAction(ViewpointAction viewpointAction, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualViewpointAction(viewpointAction.getValue(), new CallbackWithOneParam<VisualSettingAckInfo>() {
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

    public void setVisualViewPointCoordinate(float f, float f2, final CallbackWithNoParam callbackWithNoParam) {
        VisualModelManager.instance().setVisualViewPointCoord((int) (f * 100.0f), (int) (f2 * 100.0f), new CallbackWithOneParam<VisualSettingAckInfo>() {
            public void onSuccess(VisualSettingAckInfo visualSettingAckInfo) {
                Evo2FlyController.this.setVisualResolution();
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
