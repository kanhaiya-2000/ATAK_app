package com.autel.sdk10.AutelNet.AutelMission.requestmanager;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.autel.internal.sdk.mission.MissionFinishedAction;
import com.autel.internal.sdk.mission.MissionState;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.BaseRequestManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.MAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelMission.entity.MissionCommonRequestId;
import com.autel.sdk10.AutelNet.AutelRemoteController.interfaces.IAutelRCLongTimeCallback;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;

public class AutelMissionCommonRequestManager extends BaseRequestManager {
    public void takeOff(AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.creareTakeOffPacket());
        waitForResponse(22, iCompletionCallbackWith);
    }

    public void yawRecover(AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        MAVLinkPacket[] createYawRecoverPacket = MAVLinkPacketFactory.createYawRecoverPacket();
        StarLinkClientManager.getInstance_().sendMavPacket(createYawRecoverPacket[0]);
        StarLinkClientManager.getInstance_().sendMavPacket(createYawRecoverPacket[1]);
        waitForResponse(110, iCompletionCallbackWith);
    }

    public void setMissionFlySpeed(float f, AutelCompletionCallback.ICompletionCallbackWith<Float> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createSetMissionFlySpeedPacket(f));
        waitForResponse(109, iCompletionCallbackWith);
    }

    public void goHome(AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createGoHomeMessagePacket());
        waitForResponse(20, iCompletionCallbackWith);
    }

    public void land(AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createLandMessagePacket());
        waitForResponse(21, iCompletionCallbackWith);
    }

    public void halt(AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createHaltMessagePacket());
        waitForResponse(252, iCompletionCallbackWith);
    }

    public void setFlyLocationToHome(AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createSetDroneLocationToHomePacket());
        waitForResponse(179, iCompletionCallbackWith);
    }

    public void setPhoneLocationToHome(float f, float f2, AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createSetPhoneLocationToHomePacket(f, f2));
        waitForResponse(179, iCompletionCallbackWith);
    }

    public void addMissionStateRealTimeInfoListener(String str, final IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MissionState> iAutelRCLongTimeCallbackWith) {
        StarLinkClientManager.getInstance_().addIStarLinkLongTimeCallback(str, 221, new IAutelRCLongTimeCallback.IAutelRCLongTimeCallbackWith<MAVLinkMessage>() {
            public void onReceiveMsg(MAVLinkMessage mAVLinkMessage) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (iAutelRCLongTimeCallbackWith != null) {
                            iAutelRCLongTimeCallbackWith.onReceiveMsg(AutelAircraftInfoManager.getMissionState());
                        }
                    }
                });
            }
        });
    }

    public void removeMissionStateRealTimeInfoListener(String str) {
        StarLinkClientManager.getInstance_().removeIStarLinkCallback(str);
    }

    public void setMissionFinishedType(MissionFinishedAction missionFinishedAction, int i, AutelCompletionCallback.ICompletionCallbackWith<MissionFinishedAction> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createSetMissionFinishedTypePacket(missionFinishedAction.getValue(), (float) i));
        waitForResponse(MissionCommonRequestId.MissionFinishedType, iCompletionCallbackWith);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isReportResponseSucc(final int i, long j, final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return true;
        }
        if (i != 109) {
            if (i != 110) {
                if (i != 1112) {
                    if (MissionManager.getAutelMissionInfoParser().isNewInfo(i, j)) {
                        MsgPostManager.instance().post(new PostRunnable() {
                            /* access modifiers changed from: protected */
                            public void task() {
                                iCompletionCallbackWith.onResult(Integer.valueOf((int) MissionManager.getAutelMissionInfoParser().getResult(i)));
                            }
                        });
                        return true;
                    }
                } else if (MissionManager.getAutelMissionInfoParser().isNewMissonFinishedTypeInfo(j)) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            iCompletionCallbackWith.onResult(MissionManager.getAutelMissionInfo().getAutelMissionFinishedType());
                        }
                    });
                    return true;
                }
            } else if (MissionManager.getAutelMissionInfoParser().isNewYawRecoverInfo(j)) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        iCompletionCallbackWith.onResult(Boolean.valueOf(MissionManager.getAutelMissionInfoParser().isYawRecoverSucc()));
                    }
                });
                return true;
            }
        } else if (MissionManager.getAutelMissionInfoParser().isNewMissionFlySpeedInfo(j)) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    iCompletionCallbackWith.onResult(Float.valueOf(MissionManager.getAutelMissionInfo().getMissionFlySpeed()));
                }
            });
            return true;
        }
        return false;
    }
}
