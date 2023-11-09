package com.autel.sdk10.AutelNet.AutelBattery.requestmanager;

import com.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_rtcm_data;
import com.autel.common.battery.BatteryState;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.firmware.AircraftComponentVersionInfo;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelBattery.BatteryManager;
import com.autel.sdk10.AutelNet.AutelBattery.enums.BatteryRequestCmdName;
import com.autel.sdk10.AutelNet.AutelBattery.parser.BatteryInfoParser;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback;
import com.autel.sdk10.AutelNet.AutelGimbal.parser.GimbalInfoParser;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.BaseRequestManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.GimbalMAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkparameter.ParamsUtils;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import com.autel.sdk10.products.aircraft.AutelAircraftRequestManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutelBatteryRequestManager extends BaseRequestManager {
    /* access modifiers changed from: private */
    public int[] history_flags = {227, 228};
    private ExecutorService switchPool;
    private ExecutorService threadPool = Executors.newSingleThreadExecutor();

    public void setLowBatteryWarning(float f, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter(BatteryRequestCmdName.LOW_BATTERY_WARNING, f + "", 9));
        waitForResponse(0, iCompletionCallbackWith);
    }

    public void queryLowBatteryWarning(AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        readParameterName(BatteryRequestCmdName.LOW_BATTERY_WARNING);
        waitForResponse(1, iCompletionCallbackWith);
    }

    public void setCriticalBatteryWarning(float f, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        sendParameter(ParamsUtils.getParameter(BatteryRequestCmdName.CRITICAL_BATTERY_WARNING, f + "", 9));
        waitForResponse(2, iCompletionCallbackWith);
    }

    public void queryCriticalBatteryWarning(AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        readParameterName(BatteryRequestCmdName.CRITICAL_BATTERY_WARNING);
        waitForResponse(3, iCompletionCallbackWith);
    }

    public void setBatteryDischargeDay(int i, final AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createSetBatteryDischargeDayPacket((byte) i));
        checkValueValid(iCompletionCallbackWith);
        waitForResponse(4, new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                AutelBatteryRequestManager.this.switchToGimbalMsg();
                AutelBatteryRequestManager.this.callbackResult(iCompletionCallbackWith, num);
            }

            public void onFailure(AutelError autelError) {
                AutelBatteryRequestManager.this.switchToGimbalMsg();
                AutelBatteryRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void queryBatteryDischargeDay(final AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createQueryBatteryDischargeDayPacket());
        checkValueValid(iCompletionCallbackWith);
        waitForResponse(5, new AutelCompletionCallback.ICompletionCallbackWith<Integer>() {
            public void onResult(Integer num) {
                AutelBatteryRequestManager.this.switchToGimbalMsg();
                AutelBatteryRequestManager.this.callbackResult(iCompletionCallbackWith, num);
            }

            public void onFailure(AutelError autelError) {
                AutelBatteryRequestManager.this.switchToGimbalMsg();
                AutelBatteryRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
            }
        });
    }

    public void qureyBatteryHistory(final AutelCompletionCallback.ICompletionCallbackWith<int[]> iCompletionCallbackWith) {
        checkValueValid(iCompletionCallbackWith);
        if (AutelAircraftInfoManager.getAircraftComponentVersionInfo().getBatteryVersion() == null) {
            AutelAircraftRequestManager.getAutelFirmVersionRequestManager().requestAutelAircraftComponentVersion(new IAutelFirmVersionCallback<AircraftComponentVersionInfo>() {
                public void onReceiveVersion(AircraftComponentVersionInfo aircraftComponentVersionInfo) {
                    if (AutelBatteryRequestManager.this.getCallback(iCompletionCallbackWith) != null) {
                        AutelBatteryRequestManager.this.qureyBatteryHistory(iCompletionCallbackWith);
                    }
                    AutelBatteryRequestManager.this.removeCallback(iCompletionCallbackWith);
                }

                public void onFailure(AutelError autelError) {
                    AutelBatteryRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
                }
            });
            return;
        }
        if (!BatteryInfoParser.getInstance_().isBatteryVersionAboveV522()) {
            this.history_flags = new int[]{227, 228, 229, 230, 231, 232, msg_gps_rtcm_data.MAVLINK_MSG_ID_GPS_RTCM_DATA};
        }
        if (getCallback(iCompletionCallbackWith) != null) {
            waitForResponseWithDelay(6, ((long) (this.history_flags.length - 1)) * 1500, new AutelCompletionCallback.ICompletionCallbackWith<int[]>() {
                public void onResult(int[] iArr) {
                    AutelBatteryRequestManager.this.switchToGimbalMsg();
                    AutelBatteryRequestManager.this.callbackResult(iCompletionCallbackWith, iArr);
                }

                public void onFailure(AutelError autelError) {
                    AutelBatteryRequestManager.this.switchToGimbalMsg();
                    AutelBatteryRequestManager.this.callbackFailure(iCompletionCallbackWith, autelError);
                }
            });
        }
        this.threadPool.execute(new Runnable() {
            public void run() {
                int i = 0;
                while (i < AutelBatteryRequestManager.this.history_flags.length && AutelBatteryRequestManager.this.getCallback(iCompletionCallbackWith) != null) {
                    StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createQueryBatteryHistoryPacket(AutelBatteryRequestManager.this.history_flags[i]));
                    int i2 = i + 1;
                    if (i >= AutelBatteryRequestManager.this.history_flags.length) {
                        break;
                    }
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i = i2;
                }
                if (AutelBatteryRequestManager.this.getCallback(iCompletionCallbackWith) == null) {
                    AutelBatteryRequestManager.this.switchToGimbalMsg();
                }
            }
        });
    }

    public void removeQureyBatteryHistoryCallback() {
        removeCallback(6);
        AutelAircraftRequestManager.getAutelFirmVersionRequestManager().cancelRequestAutelAircraftComponentVersion();
        switchToGimbalMsg();
    }

    /* access modifiers changed from: private */
    public void switchToGimbalMsg() {
        final long currentTimeMillis = System.currentTimeMillis();
        StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createSwitchToGimbalMsg());
        if (this.switchPool == null) {
            this.switchPool = Executors.newSingleThreadExecutor();
        }
        this.switchPool.execute(new Runnable() {
            public void run() {
                int i = 0;
                while (i <= 5) {
                    try {
                        Thread.sleep(300);
                        if (!GimbalInfoParser.getInstance_().isNewGimbalInfo(currentTimeMillis)) {
                            StarLinkClientManager.getInstance_().sendMavPacket(GimbalMAVLinkPacketFactory.createSwitchToGimbalMsg());
                            i++;
                        } else {
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });
    }

    public void addBatteryRealTimeDataListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<BatteryState> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 214, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(AutelAircraftInfoManager.getAutelBatteryInfo());
                        }
                    }
                });
            }
        });
    }

    public void removeBatteryRealTimeDataListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    /* access modifiers changed from: protected */
    public boolean isReportResponseSucc(final int i, long j, final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return true;
        }
        if (!BatteryManager.getAutelBatteryInfoParser().isNewInfo(i, j)) {
            return false;
        }
        MsgPostManager.instance().post(new PostRunnable() {
            /* access modifiers changed from: protected */
            public void task() {
                switch (i) {
                    case 0:
                    case 1:
                        iCompletionCallbackWith.onResult(Float.valueOf((float) AutelAircraftInfoManager.getAutelBatteryInfo().getLowBatteryWarning()));
                        return;
                    case 2:
                    case 3:
                        iCompletionCallbackWith.onResult(Float.valueOf((float) AutelAircraftInfoManager.getAutelBatteryInfo().getCriticalBatteryWarning()));
                        return;
                    case 4:
                    case 5:
                        iCompletionCallbackWith.onResult(Integer.valueOf(AutelAircraftInfoManager.getAutelBatteryInfo().getDischargeDay()));
                        return;
                    case 6:
                        iCompletionCallbackWith.onResult(AutelAircraftInfoManager.getAutelBatteryInfo().getBatteryHistoryRecords());
                        return;
                    default:
                        return;
                }
            }
        });
        return true;
    }
}
