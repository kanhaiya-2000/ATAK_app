package com.autel.internal.flycontroller;

import com.autel.AutelNet2.aircraft.engine.LedPilotInfo;
import com.autel.AutelNet2.aircraft.firmware.FirmwareManager;
import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
import com.autel.AutelNet2.aircraft.flycontroller.FlyControllerManager2;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.aircraft.flycontroller.interfaces.IHeartBeatListener;
import com.autel.AutelNet2.aircraft.flycontroller.parser.HeartBeatInfo;
import com.autel.AutelNet2.aircraft.mission.enmus.LocationStatus;
import com.autel.AutelNet2.aircraft.mission.enmus.ReturnStatus;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerVersionInfo;
import com.autel.common.flycontroller.FlyMode;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.sdk.flycontroller.BeginnerMode;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;
import java.util.List;

public abstract class AutelFlyController20 implements AutelFlyControllerService {
    private static final String FlyControllerStatusTag = "FlyControllerStatusTag";
    private static final String TAG = "XStarFlyController20";
    private static final String setVisualHeartListener = "setVisualHeartListener";
    /* access modifiers changed from: private */
    public ARMWarning currentArmWarning;
    /* access modifiers changed from: private */
    public MagnetometerState currentMagnetometer;
    /* access modifiers changed from: private */
    public CalibrateCompassStatus mCalibrateCompassStatus;
    private final String startCalibrateCompassTag = "startCalibrateCompass";

    public void cancelLand(CallbackWithNoParam callbackWithNoParam) {
    }

    public void connect() {
    }

    public void disconnect() {
    }

    public void setWarningListener(final CallbackWithTwoParams<ARMWarning, MagnetometerState> callbackWithTwoParams) {
        if (callbackWithTwoParams != null) {
            this.currentArmWarning = ARMWarning.UNKNOWN;
            this.currentMagnetometer = MagnetometerState.UNKNOWN;
            AircraftHeatBeatManager2.getInstance().addIAutelHeartBeatListener(AutelListenerManager.FlyControllerWarningListener, new IHeartBeatListener() {
                public void onHeartBeatStatus(HeartBeatStatus heartBeatStatus, HeartBeatInfo heartBeatInfo) {
                    MagnetometerState magState = heartBeatInfo.getMagState();
                    ARMWarning armErrorCode = heartBeatInfo.getArmErrorCode();
                    ARMWarning unused = AutelFlyController20.this.currentArmWarning = armErrorCode;
                    MagnetometerState unused2 = AutelFlyController20.this.currentMagnetometer = magState;
                    callbackWithTwoParams.onSuccess(armErrorCode, magState);
                }
            });
            return;
        }
        AircraftHeatBeatManager2.getInstance().removeIAutelHeartBeatListener(AutelListenerManager.FlyControllerWarningListener);
    }

    public void setCalibrateCompassListener(final CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            AircraftHeatBeatManager2.getInstance().addCalibrateCompassListener(AutelListenerManager.CalibrateCompassListener, new CallbackWithOneParam<CalibrateCompassStatus>() {
                public void onSuccess(CalibrateCompassStatus calibrateCompassStatus) {
                    callbackWithOneParam.onSuccess(calibrateCompassStatus);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            AircraftHeatBeatManager2.getInstance().removeCalibrateCompassListener(AutelListenerManager.CalibrateCompassListener);
        }
    }

    public void setBeginnerModeEnable(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setBeginnerMode(z, new CallbackWithOneParam<BeginnerMode>() {
            public void onSuccess(BeginnerMode beginnerMode) {
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

    public void isBeginnerModeEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().queryBeginnerMode(new CallbackWithOneParam<BeginnerMode>() {
            public void onSuccess(BeginnerMode beginnerMode) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                boolean z = true;
                if (beginnerMode.getValue() != 1) {
                    z = false;
                }
                callbackWithOneParam.onSuccess(Boolean.valueOf(z));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setMaxHeight(double d, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setMaxHeight((float) d, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
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

    public void getMaxHeight(CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().queryMaxHeight(callbackWithOneParam);
    }

    public void setMaxRange(double d, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setMaxRange((float) d, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
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

    public void getMaxRange(CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().queryMaxRange(callbackWithOneParam);
    }

    public void setReturnHeight(double d, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setReturnHeight((float) d, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
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

    public void getReturnHeight(CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().queryReturnHeight(callbackWithOneParam);
    }

    public void setMaxHorizontalSpeed(double d, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setHorizontalSpeed((float) d, new CallbackWithOneParam<Float>() {
            public void onSuccess(Float f) {
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

    public void getMaxHorizontalSpeed(CallbackWithOneParam<Float> callbackWithOneParam) {
        FlyControllerManager2.getInstance().queryHorizontalSpeed(callbackWithOneParam);
    }

    public void setAttitudeModeEnable(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setAttiModeSwitch(z, new CallbackWithOneParam<Boolean>() {
            public void onSuccess(Boolean bool) {
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

    public void isAttitudeModeEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        FlyControllerManager2.getInstance().queryAttiModeSwitch(callbackWithOneParam);
    }

    public void setLedPilotLamp(LedPilotLamp ledPilotLamp, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setFmuControllerLedlamp(ledPilotLamp, new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (callbackWithNoParam == null) {
                    return;
                }
                if (commandInfoInternal.isSuccess()) {
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

    public void getLedPilotLamp(final CallbackWithOneParam<LedPilotLamp> callbackWithOneParam) {
        FlyControllerManager2.getInstance().getLedPilotLamp(new CallbackWithOneParam<LedPilotInfo>() {
            public void onSuccess(LedPilotInfo ledPilotInfo) {
                if (ledPilotInfo.isSuccess()) {
                    callbackWithOneParam.onSuccess(LedPilotLamp.find(ledPilotInfo.getData()));
                } else {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void startCalibrateCompass(final CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        AircraftHeatBeatManager2.getInstance().removeCalibrateCompassListener("startCalibrateCompass");
        this.mCalibrateCompassStatus = CalibrateCompassStatus.UNKNOWN;
        FlyControllerManager2.getInstance().startCalibrateCompass(new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (commandInfoInternal.isSuccess()) {
                    AircraftHeatBeatManager2.getInstance().addCalibrateCompassListener("startCalibrateCompass", new CallbackWithOneParam<CalibrateCompassStatus>() {
                        public void onSuccess(CalibrateCompassStatus calibrateCompassStatus) {
                            if (AutelFlyController20.this.mCalibrateCompassStatus != calibrateCompassStatus) {
                                CalibrateCompassStatus unused = AutelFlyController20.this.mCalibrateCompassStatus = calibrateCompassStatus;
                                if (AutelFlyController20.this.mCalibrateCompassStatus == CalibrateCompassStatus.FAILED || AutelFlyController20.this.mCalibrateCompassStatus == CalibrateCompassStatus.SUCCESS || AutelFlyController20.this.mCalibrateCompassStatus == CalibrateCompassStatus.NO_GPS || AutelFlyController20.this.mCalibrateCompassStatus == CalibrateCompassStatus.NORMAL || AutelFlyController20.this.mCalibrateCompassStatus == CalibrateCompassStatus.UNKNOWN) {
                                    AircraftHeatBeatManager2.getInstance().removeCalibrateCompassListener("startCalibrateCompass");
                                }
                                callbackWithOneParam.onSuccess(calibrateCompassStatus);
                            }
                        }

                        public void onFailure(AutelError autelError) {
                            callbackWithOneParam.onFailure(autelError);
                        }
                    });
                } else {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void takeOff(final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().takeOff(new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (commandInfoInternal.isSuccess()) {
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

    public void goHome(final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().goHome(new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (commandInfoInternal.isSuccess()) {
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

    public void land(final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().land(new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (commandInfoInternal.isSuccess()) {
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

    public void cancelReturn(final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().returnToLaunch(ReturnStatus.CANCEL, new CallbackWithOneParam<CommandInfoInternal>() {
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

    public void setAircraftLocationAsHomePoint(final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setLocationToHome(LocationStatus.DRONE, 0, 0, new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (commandInfoInternal.isSuccess()) {
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

    public void setLocationAsHomePoint(double d, double d2, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager2.getInstance().setLocationToHome(LocationStatus.PHONE, (int) (d * 1.0E7d), (int) (d2 * 1.0E7d), new CallbackWithOneParam<CommandInfoInternal>() {
            public void onSuccess(CommandInfoInternal commandInfoInternal) {
                if (commandInfoInternal.isSuccess()) {
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

    public void getSerialNumber(final CallbackWithOneParam<String> callbackWithOneParam) {
        FirmwareManager.instance().getComponentInfo(FirmwareManager.DEV_UAV, new CallbackWithOneParam<FirmwareDeviceInfo.VersionBean>() {
            public void onSuccess(FirmwareDeviceInfo.VersionBean versionBean) {
                callbackWithOneParam.onSuccess(versionBean.getSerialNumber());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVersionInfo(final CallbackWithOneParam<FlyControllerVersionInfo> callbackWithOneParam) {
        FirmwareManager.instance().getDeviceFirmwareInfo(new CallbackWithOneParam<List<FirmwareDeviceInfo.VersionBean>>() {
            public void onSuccess(final List<FirmwareDeviceInfo.VersionBean> list) {
                callbackWithOneParam.onSuccess(new FlyControllerVersionInfo() {
                    public String getSonarVersion() {
                        for (FirmwareDeviceInfo.VersionBean versionBean : list) {
                            if (FirmwareManager.DEV_SONAR.equalsIgnoreCase(versionBean.getComponentName())) {
                                return versionBean.getSoftware();
                            }
                        }
                        return "";
                    }

                    public String getOpticalFlowVersion() {
                        for (FirmwareDeviceInfo.VersionBean versionBean : list) {
                            if (FirmwareManager.DEV_FLOW.equalsIgnoreCase(versionBean.getComponentName())) {
                                return versionBean.getSoftware();
                            }
                        }
                        return "";
                    }

                    public String getFlyControllerVersion() {
                        for (FirmwareDeviceInfo.VersionBean versionBean : list) {
                            if (FirmwareManager.DEV_UAV.equalsIgnoreCase(versionBean.getComponentName())) {
                                return versionBean.getSoftware();
                            }
                        }
                        return "";
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void init(IAutelStateManager iAutelStateManager) {
        FlyControllerManager2.getInstance().init();
    }

    private boolean isGoHome(FlyMode flyMode) {
        return flyMode != null && (flyMode == FlyMode.LANDING || flyMode == FlyMode.NORMAL_GO_HOME || flyMode == FlyMode.EXCEED_RANGE_GO_HOME || flyMode == FlyMode.LOW_BATTERY_GO_HOME || flyMode == FlyMode.MISSION_GO_HOME || flyMode == FlyMode.RC_LOST_GO_HOME);
    }

    public void destroy() {
        FlyControllerManager2.getInstance().destroy();
    }
}
