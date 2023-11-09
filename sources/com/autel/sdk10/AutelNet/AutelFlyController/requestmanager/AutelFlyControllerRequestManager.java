package com.autel.sdk10.AutelNet.AutelFlyController.requestmanager;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_highres_imu;
import com.MAVLink.Messages.ardupilotmega.msg_sys_status;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.internal.sdk.flycontroller.AutelAltitudeAndSpeedInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelAttitudeInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelGPSInfoInternal;
import com.autel.internal.sdk.flycontroller.AutelHomeInternal;
import com.autel.internal.sdk.flycontroller.BeginnerMode;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelFlyController.FlyControllerManager;
import com.autel.sdk10.AutelNet.AutelFlyController.enums.FlyControllerRequestCmdName;
import com.autel.sdk10.AutelNet.AutelFlyController.interfaces.IAutelFlyControllerInterfaces;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.AutelNet.AutelFlyController.util.SensitiveUtil;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.BaseRequestManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.MAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.ParamsUtils;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;

public class AutelFlyControllerRequestManager extends BaseRequestManager {
    public void setBeginnerMode(boolean z, AutelCompletionCallback.ICompletionCallbackWith<BeginnerMode> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_Beginner_Mode", (z ? 1 : 0) + "", 9));
        waitForResponse(6, iCompletionCallbackWith);
    }

    public void queryBeginnerMode(AutelCompletionCallback.ICompletionCallbackWith<BeginnerMode> iCompletionCallbackWith) {
        readParameterName("SM_Beginner_Mode");
        waitForResponse(6, iCompletionCallbackWith);
    }

    public void restoreSDLogFrequency(AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_SDLOG_SEN", "0", 9));
        waitForResponse(7, iCompletionCallbackWith);
    }

    public void setMaxHeight(double d, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_Max_Height", d + "", 9));
        waitForResponse(0, iCompletionCallbackWith);
    }

    public void queryMaxHeight(AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        readParameterName("SM_Max_Height");
        waitForResponse(0, iCompletionCallbackWith);
    }

    public void setMaxRange(double d, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_Max_Range", d + "", 9));
        waitForResponse(1, iCompletionCallbackWith);
    }

    public void queryMaxRange(AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        readParameterName("SM_Max_Range");
        waitForResponse(1, iCompletionCallbackWith);
    }

    public void setReturnHeight(double d, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_RTH_Height", d + "", 9));
        waitForResponse(2, iCompletionCallbackWith);
    }

    public void queryReturnHeight(AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        readParameterName("SM_RTH_Height");
        waitForResponse(2, iCompletionCallbackWith);
    }

    public void setHorizontalSpeed(double d, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_Max_v_xy", d + "", 9));
        waitForResponse(3, iCompletionCallbackWith);
    }

    public void queryHorizontalSpeed(AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        readParameterName("SM_Max_v_xy");
        waitForResponse(3, iCompletionCallbackWith);
    }

    public void setAscendSpeed(double d, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_Max_v_z", d + "", 9));
        waitForResponse(4, iCompletionCallbackWith);
    }

    public void queryAscendSpeed(AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        readParameterName("SM_Max_v_z");
        waitForResponse(4, iCompletionCallbackWith);
    }

    public void setDescendSpeed(double d, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_Min_v_z", d + "", 9));
        waitForResponse(5, iCompletionCallbackWith);
    }

    public void queryDescendSpeed(AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        readParameterName("SM_Min_v_z");
        waitForResponse(5, iCompletionCallbackWith);
    }

    public void setAttiModeSwitch(int i, AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter("SM_EN_ATT_MODE", i + "", 9));
        waitForResponse(8, iCompletionCallbackWith);
    }

    public void queryAttiModeSwitch(AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        readParameterName("SM_EN_ATT_MODE");
        waitForResponse(8, iCompletionCallbackWith);
    }

    public void readFlyData() {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createOpenFlydataPacket());
    }

    public void queryLedPilotLamp(AutelCompletionCallback.ICompletionCallbackWith<LedPilotLamp> iCompletionCallbackWith) {
        waitForResponse(9, iCompletionCallbackWith);
    }

    public void setYawSenCoefficient(double d, AutelCompletionCallback.ICompletionCallbackWith<Double> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter(FlyControllerRequestCmdName.RC_YAW_SEN, SensitiveUtil.coefficient2Sensitive(d) + "", 9));
        waitForResponse(12, iCompletionCallbackWith);
    }

    public void queryYawSenCoefficient(AutelCompletionCallback.ICompletionCallbackWith<Double> iCompletionCallbackWith) {
        readParameterName(FlyControllerRequestCmdName.RC_YAW_SEN);
        waitForResponse(12, iCompletionCallbackWith);
    }

    public void addLedLampListener(LedPilotLamp ledPilotLamp, String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<LedPilotLamp> iAutelRCLongTimeCallbackWith) {
        if (ledPilotLamp != null) {
            StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createControlLEDPacket(ledPilotLamp.getValue()));
        }
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 1, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(AutelAircraftInfoManager.getAutelFlyControllerInfo().getAutelLedPilotLamp());
                        }
                    }
                });
            }
        });
    }

    public void removeLedLampListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void startCalibrateCompass() {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createCabCompassPacket());
    }

    public void addCalibrateCompassListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<CalibrateCompassStatus> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 1, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(final MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(AutelFlyControllerRequestManager.this.parseResultForCalibrateCompassStatus(mAVLinkMessage));
                        }
                    }
                });
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
                return null;
        }
    }

    public void removeCalibrateCompassListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void addGPSInfoListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<AutelGPSInfoInternal> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 24, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(AutelAircraftInfoManager.getAutelFlyControllerGPSInfo());
                        }
                    }
                });
            }
        });
    }

    public void removeGPSInfoListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void addAttitudeInfoListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<AutelAttitudeInfoInternal> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 30, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(AutelAircraftInfoManager.getAutelFlyControllerAttitudeInfo());
                        }
                    }
                });
            }
        });
    }

    public void removeAttitudeInfoListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void addAltitudeAndSpeedInfoListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<AutelAltitudeAndSpeedInfoInternal> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 32, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(AutelAircraftInfoManager.getAutelFlyControllerAltitudeAndSpeedInfo());
                        }
                    }
                });
            }
        });
    }

    public void removeAltitudeAndSpeedInfoListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void addHomeInfoListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<AutelHomeInternal> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 49, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null && AutelAircraftInfoManager.getAutelFlyControllerHomeInfo().isValid() && AutelAircraftInfoManager.getAutelFlyControllerHomeInfo().getAutelCoord3D().getLatitude() != 0.0d && AutelAircraftInfoManager.getAutelFlyControllerHomeInfo().getAutelCoord3D().getLongitude() != 0.0d) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(AutelAircraftInfoManager.getAutelFlyControllerHomeInfo());
                        }
                    }
                });
            }
        });
    }

    public void removeHomeInfoListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void addFCHeightInfoListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<Float> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 105, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(final MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(Float.valueOf(((msg_highres_imu) mAVLinkMessage).diff_pressure));
                        }
                    }
                });
            }
        });
    }

    public void removeFCHeightInfoListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void addFlyControllerStatusListener(String str, final IAutelFlyControllerInterfaces.IFlyControllerStatusListener iFlyControllerStatusListener) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 1, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iFlyControllerStatusListener != null) {
                            iFlyControllerStatusListener.onFlyControllerStatus(AutelAircraftInfoManager.getFlyControllerStatus());
                        }
                    }
                });
            }
        });
    }

    public void removeFlyControllerStatusListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void addFlyControllerErrorWarningListener(String str, IAutelFlyControllerInterfaces.IFlyControllerErrorWarningListener iFlyControllerErrorWarningListener) {
        ErrorWarningInternalParser.getInstance().addIFlyControllerErrorWarningListener(str, iFlyControllerErrorWarningListener);
    }

    public void removeFlyControllerErrorWarningListener(String str) {
        ErrorWarningInternalParser.getInstance().removeIFlyControllerErrorWarningListener(str);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isReportResponseSucc(final int i, long j, final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return true;
        }
        if (!FlyControllerManager.getAutelFlyControllerInfoParser().isNewInfo(i, j)) {
            return false;
        }
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                int i = i;
                if (i != 12) {
                    switch (i) {
                        case 0:
                            iCompletionCallbackWith.onResult(Float.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getMaxHeight()));
                            return;
                        case 1:
                            iCompletionCallbackWith.onResult(Float.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getMaxRange()));
                            return;
                        case 2:
                            iCompletionCallbackWith.onResult(Float.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getReturnHeight()));
                            return;
                        case 3:
                            iCompletionCallbackWith.onResult(Float.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getHorizontalSpeed()));
                            return;
                        case 4:
                            iCompletionCallbackWith.onResult(Float.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getAscendSpeed()));
                            return;
                        case 5:
                            iCompletionCallbackWith.onResult(Float.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getDescendSpeed()));
                            return;
                        case 6:
                            iCompletionCallbackWith.onResult(AutelAircraftInfoManager.getAutelFlyControllerInfo().getAutelBeginnerMode());
                            return;
                        case 7:
                            iCompletionCallbackWith.onResult(Integer.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getSdLogFrequency()));
                            return;
                        case 8:
                            iCompletionCallbackWith.onResult(Boolean.valueOf(AutelAircraftInfoManager.getAutelFlyControllerInfo().getAttitudeEnable()));
                            return;
                        case 9:
                            iCompletionCallbackWith.onResult(AutelAircraftInfoManager.getAutelFlyControllerInfo().getAutelLedPilotLamp());
                            return;
                        default:
                            return;
                    }
                } else {
                    iCompletionCallbackWith.onResult(Double.valueOf((double) AutelAircraftInfoManager.getAutelFlyControllerInfo().getYawSensitive()));
                }
            }
        });
        return true;
    }
}
