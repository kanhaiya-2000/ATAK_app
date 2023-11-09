package com.autel.internal.flycontroller.xstar;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_highres_imu;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.AltitudeAndSpeedInfo;
import com.autel.common.flycontroller.AttitudeInfo;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerConnectState;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.FlyHome;
import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.common.flycontroller.xstar.XStarFlyControllerParameterRangeManager;
import com.autel.common.product.AutelProductInfo;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.flycontroller.AutelFlyController10;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;
import com.autel.internal.sdk.heartbeat.IAutelHeartBeatListener;
import com.autel.sdk.flycontroller.p007rx.RxXStarFlyController;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import com.autel.sdk10.products.requestmanager.AutelProductRequestManager;

public class XStarFlyController extends AutelFlyController10 implements XStarFlyControllerService {
    /* access modifiers changed from: private */
    public FlyControllerConnectState controllerConnectState = FlyControllerConnectState.unknown;
    private ARMWarning currentArmWarning;
    private MagnetometerState currentMagnetometer;
    /* access modifiers changed from: private */
    public FlyControllerInfo flyControllerInfo;

    public void connect() {
    }

    public void destroy() {
    }

    public void disconnect() {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public RxXStarFlyController toRx() {
        return null;
    }

    public void setConnectStateListener(final CallbackWithOneParam<FlyControllerConnectState> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            AutelProductRequestManager.removeIAutelHeartBeatListener(AutelListenerManager.FlyControllerHeartBeatListener);
        } else {
            AutelProductRequestManager.addIAutelHeartBeatListener(AutelListenerManager.FlyControllerHeartBeatListener, new IAutelHeartBeatListener() {
                public void onHeartBeatStatus(HeartBeatStatus heartBeatStatus, AutelProductInfo autelProductInfo) {
                    if (heartBeatStatus == HeartBeatStatus.FIRST || heartBeatStatus == HeartBeatStatus.NORMAL) {
                        if (XStarFlyController.this.controllerConnectState != FlyControllerConnectState.connect) {
                            FlyControllerConnectState unused = XStarFlyController.this.controllerConnectState = FlyControllerConnectState.connect;
                            callbackWithOneParam.onSuccess(XStarFlyController.this.controllerConnectState);
                        }
                    } else if (heartBeatStatus == HeartBeatStatus.ERROR || heartBeatStatus == HeartBeatStatus.STOP) {
                        if (XStarFlyController.this.controllerConnectState != FlyControllerConnectState.disconnect) {
                            FlyControllerConnectState unused2 = XStarFlyController.this.controllerConnectState = FlyControllerConnectState.disconnect;
                            callbackWithOneParam.onSuccess(XStarFlyController.this.controllerConnectState);
                        }
                    } else if (XStarFlyController.this.controllerConnectState != FlyControllerConnectState.unknown) {
                        FlyControllerConnectState unused3 = XStarFlyController.this.controllerConnectState = FlyControllerConnectState.unknown;
                        callbackWithOneParam.onSuccess(XStarFlyController.this.controllerConnectState);
                    }
                }
            });
        }
    }

    public void setFlyControllerInfoListener(final CallbackWithOneParam<FlyControllerInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            this.flyControllerInfo = null;
            StarLinkClientManager.getInstance_().removeIStarLinkCallback("setFlyControllerInfoListener");
            StarLinkClientManager.getInstance_().removeIStarLinkCallback("setAttitudeInfoListener");
            StarLinkClientManager.getInstance_().removeIStarLinkCallback("setAltitudeAndSpeedInfoListener");
            StarLinkClientManager.getInstance_().removeIStarLinkCallback("setHomeInfoListener");
            StarLinkClientManager.getInstance_().removeIStarLinkCallback("setFlyControllerStatusListener");
            return;
        }
        if (this.flyControllerInfo == null) {
            this.flyControllerInfo = new FlyControllerInfo() {
                public GPSInfo getGPSInfo() {
                    return AutelAircraftInfoManager.getAutelFlyControllerGPSInfo();
                }

                public AttitudeInfo getAttitudeInfo() {
                    return AutelAircraftInfoManager.getAutelFlyControllerAttitudeInfo();
                }

                public AltitudeAndSpeedInfo getAltitudeAndSpeedInfo() {
                    return AutelAircraftInfoManager.getAutelFlyControllerAltitudeAndSpeedInfo();
                }

                public FlyHome getFlyHome() {
                    return AutelAircraftInfoManager.getAutelFlyControllerHomeInfo();
                }

                public FlyControllerStatus getFlyControllerStatus() {
                    return AutelAircraftInfoManager.getFlyControllerStatus();
                }

                public String toString() {
                    return "GPSInfo : {" + getGPSInfo() + "}, AttitudeInfo : {" + getAttitudeInfo() + "}, AltitudeAndSpeedInfo : {" + getAltitudeAndSpeedInfo() + "}, FlyHome : {" + getFlyHome() + "}, FlyControllerStatus : {" + getFlyControllerStatus() + "}";
                }
            };
        }
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback("setFlyControllerInfoListener", 24, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                callbackWithOneParam.onSuccess(XStarFlyController.this.flyControllerInfo);
            }
        });
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback("setAttitudeInfoListener", 30, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                callbackWithOneParam.onSuccess(XStarFlyController.this.flyControllerInfo);
            }
        });
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback("setAltitudeAndSpeedInfoListener", 32, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                callbackWithOneParam.onSuccess(XStarFlyController.this.flyControllerInfo);
            }
        });
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback("setHomeInfoListener", 49, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                if (AutelAircraftInfoManager.getAutelFlyControllerHomeInfo().getAutelCoord3D().getLatitude() != 0.0d && AutelAircraftInfoManager.getAutelFlyControllerHomeInfo().getAutelCoord3D().getLongitude() != 0.0d) {
                    callbackWithOneParam.onSuccess(XStarFlyController.this.flyControllerInfo);
                }
            }
        });
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback("setFlyControllerStatusListener", 1, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                callbackWithOneParam.onSuccess(XStarFlyController.this.flyControllerInfo);
            }
        });
    }

    public void setUltraSonicHeightInfoListener(final CallbackWithOneParam<Float> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            StarLinkClientManager.getInstance_().removeIStarLinkCallback("setUltraSonicHeightInfoListener");
        } else {
            StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback("setUltraSonicHeightInfoListener", 105, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
                public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                    callbackWithOneParam.onSuccess(Float.valueOf(((msg_highres_imu) mAVLinkMessage).diff_pressure));
                }
            });
        }
    }

    public XStarFlyControllerParameterRangeManager getParameterRangeManager() {
        return new XStarFlyControllerParameterRangeManager() {
            public RangePair<Float> getHeightRange() {
                return new RangePair<Float>() {
                    public Float getValueFrom() {
                        return Float.valueOf(30.0f);
                    }

                    public Float getValueTo() {
                        return Float.valueOf(800.0f);
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
                        return Float.valueOf(15.0f);
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

    private CalibrateCompassStatus parseResultForCalibrateCompassStatus(MAVLinkMessage mAVLinkMessage) {
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
                return null;
        }
    }
}
