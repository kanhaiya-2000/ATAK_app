package com.autel.sdk10.AutelNet.AutelMission.requestmanager;

import com.autel.internal.sdk.mission.AutelOrbit;
import com.autel.internal.sdk.mission.MissionStatus;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.BaseRequestManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.MAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.AutelNet.AutelMission.entity.MissionCommonRequestId;
import com.autel.sdk10.AutelNet.AutelMission.interfaces.AutelMissionInterface;
import com.autel.sdk10.interfaces.AutelCompletionCallback;

public class AutelOrbitMissionRequestManager extends BaseRequestManager {
    public void setOrbitMissionStatus(MissionStatus missionStatus, AutelCompletionCallback.ICompletionCallbackWith<Integer> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createControlOrbitMisssionPacket(missionStatus.getValue()));
        waitForResponse(107, iCompletionCallbackWith);
    }

    public void setMyLocationToOrbit(AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createSetMyLocationToOrbitPacket());
        waitForResponse(MissionCommonRequestId.MyLocationToOrbit, iCompletionCallbackWith);
    }

    public void startOrbitMission(AutelOrbit autelOrbit, AutelCompletionCallback.ICompletionCallbackWith<Boolean> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createOrbitPointToAPMPacket(autelOrbit));
        waitForResponse(106, iCompletionCallbackWith);
    }

    public void requestOrbitData(AutelCompletionCallback.ICompletionCallbackWith<AutelOrbit> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createRequestFollowPointDataPacket());
        waitForResponse(111, iCompletionCallbackWith);
    }

    public void addRealTimeOrbitInfoListener(String str, AutelMissionInterface.IOrbitRealtimeInfoListener iOrbitRealtimeInfoListener) {
        MissionManager.getAutelOrbitMissionInfoParser().addRealTimeOrbitInfoListener(str, iOrbitRealtimeInfoListener);
    }

    public void removeRealTimeOrbitInfoListener(String str) {
        MissionManager.getAutelOrbitMissionInfoParser().removeRealTimeOrbitInfoListener(str);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isReportResponseSucc(final int i, long j, final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return true;
        }
        if (i != 106) {
            if (i == 111) {
                if (MissionManager.getAutelMissionInfoParser().isNewOrbitInfo(j)) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            iCompletionCallbackWith.onResult(MissionManager.getAutelMissionInfo().getAutelOrbit());
                        }
                    });
                    return true;
                }
                return false;
            } else if (i == 1110) {
                if (MissionManager.getAutelMissionInfoParser().isNewOrbitWiseInfo(j)) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            iCompletionCallbackWith.onResult(MissionManager.getAutelMissionInfo().getAutelOrbitWise());
                        }
                    });
                    return true;
                }
                return false;
            } else if (i != 1111) {
                if (MissionManager.getAutelMissionInfoParser().isNewInfo(i, j)) {
                    MsgPostManager.instance().post(new PostRunnable() {
                        /* access modifiers changed from: protected */
                        public void task() {
                            iCompletionCallbackWith.onResult(Integer.valueOf((int) MissionManager.getAutelMissionInfoParser().getResult(i)));
                        }
                    });
                    return true;
                }
                return false;
            }
        }
        if (MissionManager.getAutelMissionInfoParser().isNewInfo(i, j)) {
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    iCompletionCallbackWith.onResult(Boolean.valueOf(MissionManager.getAutelMissionInfoParser().getResult(i) == 0.0f));
                }
            });
            return true;
        }
        return false;
    }
}
