package com.autel.internal.flycontroller;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_command_ack;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerVersionInfo;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.sdk.firmware.AircraftComponentSerialNumberVersionInfo;
import com.autel.internal.sdk.firmware.AircraftComponentVersionInfo;
import com.autel.internal.sdk.flycontroller.AutelFlyControllerStatusInternal;
import com.autel.internal.sdk.flycontroller.AutelWarningInternal;
import com.autel.internal.sdk.flycontroller.BeginnerMode;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.controller.AutelFirmVersionRequestManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback;
import com.autel.sdk10.AutelNet.AutelFlyController.FlyControllerManager;
import com.autel.sdk10.AutelNet.AutelFlyController.interfaces.IAutelFlyControllerInterfaces;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.MAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AutelFlyController10 implements AutelFlyControllerService {
    /* access modifiers changed from: private */
    public ARMWarning currentArmWarning;
    /* access modifiers changed from: private */
    public MagnetometerState currentMagnetometer;
    private AtomicBoolean startCalibrate = new AtomicBoolean(false);
    final String startCalibrateCompassListener = "startCalibrateCompassTag";

    public void connect() {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public void setWarningListener(final CallbackWithTwoParams<ARMWarning, MagnetometerState> callbackWithTwoParams) {
        if (callbackWithTwoParams == null) {
            ErrorWarningInternalParser.getInstance().removeIFlyControllerErrorWarningListener(AutelListenerManager.FlyControllerWarningListener);
            return;
        }
        this.currentArmWarning = ARMWarning.UNKNOWN;
        this.currentMagnetometer = MagnetometerState.UNKNOWN;
        ErrorWarningInternalParser.getInstance().addIFlyControllerErrorWarningListener(AutelListenerManager.FlyControllerWarningListener, new IAutelFlyControllerInterfaces.IFlyControllerErrorWarningListener() {
            public void onErrorWarning(AutelWarningInternal autelWarningInternal) {
                if (AutelFlyController10.this.currentArmWarning != autelWarningInternal.getArmErrorCode() || AutelFlyController10.this.currentMagnetometer != autelWarningInternal.getMagnetometerState()) {
                    ARMWarning unused = AutelFlyController10.this.currentArmWarning = autelWarningInternal.getArmErrorCode();
                    callbackWithTwoParams.onSuccess(autelWarningInternal.getArmErrorCode(), autelWarningInternal.getMagnetometerState());
                }
            }
        });
    }

    public void setCalibrateCompassListener(final CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            StarLinkClientManager.getInstance_().removeIStarLinkCallback(AutelListenerManager.CalibrateCompassListener);
        } else {
            StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(AutelListenerManager.CalibrateCompassListener, 1, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
                public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                    CalibrateCompassStatus access$200 = AutelFlyController10.this.parseResultForCalibrateCompassStatus(mAVLinkMessage);
                    if (access$200 == null) {
                        callbackWithOneParam.onFailure(AutelError.COMMON_UNKNOWN);
                    } else {
                        callbackWithOneParam.onSuccess(access$200);
                    }
                }
            });
        }
    }

    public void setBeginnerModeEnable(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        AutelFlyControllerStatusInternal flyControllerStatus = AutelAircraftInfoManager.getFlyControllerStatus();
        if (flyControllerStatus == null || flyControllerStatus.getFlyMode() == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            }
        } else if (flyControllerStatus.getFlyMode().getValue() < 3) {
            FlyControllerManager.getAutelFlyControllerRequestManager().setBeginnerMode(z, new AutelCompletionCallback.ICompletionCallbackWith<BeginnerMode>() {
                public void onResult(BeginnerMode beginnerMode) {
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
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.FLY_BEGIN_MODE_CHANGE_FAILED_WHEN_FLYING);
        }
    }

    public void isBeginnerModeEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            FlyControllerManager.getAutelFlyControllerRequestManager().queryBeginnerMode(new AutelCompletionCallback.ICompletionCallbackWith<BeginnerMode>() {
                public void onResult(BeginnerMode beginnerMode) {
                    callbackWithOneParam.onSuccess(Boolean.valueOf(beginnerMode == BeginnerMode.ENABLED));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setMaxHeight(double d, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager.getAutelFlyControllerRequestManager().setMaxHeight(d, new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
            public void onResult(Float f) {
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

    public void getMaxHeight(final CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            FlyControllerManager.getAutelFlyControllerRequestManager().queryMaxHeight(new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
                public void onResult(Float f) {
                    callbackWithOneParam.onSuccess(f);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setMaxRange(double d, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager.getAutelFlyControllerRequestManager().setMaxRange(d, new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
            public void onResult(Float f) {
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

    public void getMaxRange(final CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            FlyControllerManager.getAutelFlyControllerRequestManager().queryMaxRange(new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
                public void onResult(Float f) {
                    callbackWithOneParam.onSuccess(f);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setReturnHeight(double d, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager.getAutelFlyControllerRequestManager().setReturnHeight(d, new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
            public void onResult(Float f) {
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

    public void getReturnHeight(final CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            FlyControllerManager.getAutelFlyControllerRequestManager().queryReturnHeight(new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
                public void onResult(Float f) {
                    callbackWithOneParam.onSuccess(f);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setMaxHorizontalSpeed(double d, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager.getAutelFlyControllerRequestManager().setHorizontalSpeed(d, new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
            public void onResult(Float f) {
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

    public void getMaxHorizontalSpeed(final CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            FlyControllerManager.getAutelFlyControllerRequestManager().queryHorizontalSpeed(new AutelCompletionCallback.ICompletionCallbackWith<Float>() {
                public void onResult(Float f) {
                    callbackWithOneParam.onSuccess(f);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setAttitudeModeEnable(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        FlyControllerManager.getAutelFlyControllerRequestManager().setAttiModeSwitch(z ? 1 : 0, new AutelCompletionCallback.ICompletionCallbackWith<Boolean>() {
            public void onResult(Boolean bool) {
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

    public void isAttitudeModeEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            FlyControllerManager.getAutelFlyControllerRequestManager().queryAttiModeSwitch(new AutelCompletionCallback.ICompletionCallbackWith<Boolean>() {
                public void onResult(Boolean bool) {
                    callbackWithOneParam.onSuccess(bool);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setLedPilotLamp(LedPilotLamp ledPilotLamp, final CallbackWithNoParam callbackWithNoParam) {
        if (ledPilotLamp != null) {
            StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createControlLEDPacket(ledPilotLamp.getValue()));
            FlyControllerManager.getAutelFlyControllerRequestManager().queryLedPilotLamp(new AutelCompletionCallback.ICompletionCallbackWith<LedPilotLamp>() {
                public void onResult(LedPilotLamp ledPilotLamp) {
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
    }

    public void getLedPilotLamp(final CallbackWithOneParam<LedPilotLamp> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            FlyControllerManager.getAutelFlyControllerRequestManager().queryLedPilotLamp(new AutelCompletionCallback.ICompletionCallbackWith<LedPilotLamp>() {
                public void onResult(LedPilotLamp ledPilotLamp) {
                    callbackWithOneParam.onSuccess(AutelAircraftInfoManager.getAutelFlyControllerInfo().getAutelLedPilotLamp());
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void startCalibrateCompass(CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback("startCalibrateCompassTag");
        StarLinkClientManager.getInstance_().removeIStarLinkCallback("startCalibrateCompassTag_ack");
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createCabCompassPacket());
        addCalibrateCompassListener("startCalibrateCompassTag", callbackWithOneParam);
    }

    public void addCalibrateCompassListener(final String str, final CallbackWithOneParam<CalibrateCompassStatus> callbackWithOneParam) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 1, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                final CalibrateCompassStatus access$200 = AutelFlyController10.this.parseResultForCalibrateCompassStatus(mAVLinkMessage);
                if (access$200 == CalibrateCompassStatus.FAILED || access$200 == CalibrateCompassStatus.SUCCESS || access$200 == CalibrateCompassStatus.NO_GPS || access$200 == CalibrateCompassStatus.NORMAL || access$200 == CalibrateCompassStatus.UNKNOWN) {
                    StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
                    StarLinkClientManager instance_ = StarLinkClientManager.getInstance_();
                    instance_.removeIStarLinkCallback(str + "_ack");
                }
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (callbackWithOneParam != null) {
                            callbackWithOneParam.onSuccess(access$200);
                        }
                    }
                });
            }
        });
        StarLinkClientManager instance_ = StarLinkClientManager.getInstance_();
        instance_.addIStarLinkLongTimeCallback(str + "_ack", 77, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                msg_command_ack msg_command_ack = (msg_command_ack) mAVLinkMessage;
                if (msg_command_ack.command == 241 && msg_command_ack.result == 4) {
                    StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
                    StarLinkClientManager instance_ = StarLinkClientManager.getInstance_();
                    instance_.removeIStarLinkCallback(str + "_ack");
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            if (callbackWithOneParam != null) {
                                callbackWithOneParam.onSuccess(CalibrateCompassStatus.NO_GPS);
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public CalibrateCompassStatus parseResultForCalibrateCompassStatus(MAVLinkMessage mAVLinkMessage) {
        switch ((((msg_sys_status) mAVLinkMessage).flight_warning >> 24) & 7) {
            case 0:
                return CalibrateCompassStatus.NORMAL;
            case 1:
                return CalibrateCompassStatus.START_HORIZONTAL;
            case 2:
                return CalibrateCompassStatus.HORIZONTAL_CALCULATE;
            case 3:
                return CalibrateCompassStatus.START_VERTICAL;
            case 4:
                return CalibrateCompassStatus.VERTICAL_CALCULATE;
            case 5:
                return CalibrateCompassStatus.SUCCESS;
            case 6:
                return CalibrateCompassStatus.FAILED;
            default:
                return CalibrateCompassStatus.UNKNOWN;
        }
    }

    public void goHome(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelMissonCommonRequestManager().goHome(new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
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

    public void land(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelMissonCommonRequestManager().land(new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
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

    public void cancelLand(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelMissonCommonRequestManager().halt(new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
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

    public void cancelReturn(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelMissonCommonRequestManager().halt(new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
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

    public void setAircraftLocationAsHomePoint(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelMissonCommonRequestManager().setFlyLocationToHome(new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                if (callbackWithNoParam != null && num.intValue() == 0) {
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

    public void setLocationAsHomePoint(double d, double d2, final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelMissonCommonRequestManager().setPhoneLocationToHome((float) d, (float) d2, new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                if (callbackWithNoParam != null && num.intValue() == 0) {
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

    public void getSerialNumber(final CallbackWithOneParam<String> callbackWithOneParam) {
        AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentSNVersion(new IAutelFirmVersionCallback<AircraftComponentSerialNumberVersionInfo>() {
            public void onReceiveVersion(AircraftComponentSerialNumberVersionInfo aircraftComponentSerialNumberVersionInfo) {
                callbackWithOneParam.onSuccess(aircraftComponentSerialNumberVersionInfo.getFlightControlSerialNumber());
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVersionInfo(final CallbackWithOneParam<FlyControllerVersionInfo> callbackWithOneParam) {
        AutelFirmVersionRequestManager.getInstance().requestAutelAircraftComponentVersion(new IAutelFirmVersionCallback<AircraftComponentVersionInfo>() {
            public void onReceiveVersion(final AircraftComponentVersionInfo aircraftComponentVersionInfo) {
                callbackWithOneParam.onSuccess(new FlyControllerVersionInfo() {
                    public String getSonarVersion() {
                        return aircraftComponentVersionInfo.getSonarVersion();
                    }

                    public String getOpticalFlowVersion() {
                        return aircraftComponentVersionInfo.getOpticalFlowVersion();
                    }

                    public String getFlyControllerVersion() {
                        return aircraftComponentVersionInfo.getFmuVersion();
                    }

                    public String toString() {
                        return "SonarVersion : " + getSonarVersion() + ", OpticalFlowVersion : " + getOpticalFlowVersion() + ", FlyControllerVersion : " + getFlyControllerVersion();
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void takeOff(final CallbackWithNoParam callbackWithNoParam) {
        MissionManager.getAutelMissonCommonRequestManager().takeOff(new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
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
}
