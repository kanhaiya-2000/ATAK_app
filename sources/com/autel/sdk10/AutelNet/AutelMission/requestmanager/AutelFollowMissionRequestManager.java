package com.autel.sdk10.AutelNet.AutelMission.requestmanager;

import android.location.Location;
import com.autel.common.flycontroller.FlyMode;
import com.autel.internal.sdk.mission.FollowMode;
import com.autel.internal.sdk.mission.FollowSwitch;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.BaseRequestManager;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket.MAVLinkPacketFactory;
import com.autel.sdk10.AutelNet.AutelMission.MissionManager;
import com.autel.sdk10.interfaces.AutelCompletionCallback;
import com.autel.sdk10.products.aircraft.AutelAircraftInfoManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutelFollowMissionRequestManager extends BaseRequestManager {
    private ExecutorService CheckFlyModeThreadPool = Executors.newSingleThreadExecutor();
    private CheckFlyModeRunnable checkFlyModeRunnable;

    public void switchFollow(FollowSwitch followSwitch, FollowMode followMode, AutelCompletionCallback.ICompletionCallbackWith<FollowSwitch> iCompletionCallbackWith) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createSwitchFollowPacket(followSwitch.getValue(), followMode.getValue()));
        removeSwitchFollowCallback();
        ExecutorService executorService = this.CheckFlyModeThreadPool;
        CheckFlyModeRunnable checkFlyModeRunnable2 = new CheckFlyModeRunnable(followSwitch, iCompletionCallbackWith);
        this.checkFlyModeRunnable = checkFlyModeRunnable2;
        executorService.execute(checkFlyModeRunnable2);
    }

    public void removeSwitchFollowCallback() {
        CheckFlyModeRunnable checkFlyModeRunnable2 = this.checkFlyModeRunnable;
        if (checkFlyModeRunnable2 != null) {
            checkFlyModeRunnable2.cancel();
        }
    }

    public void followFromLocation(Location location) {
        StarLinkClientManager.getInstance_().sendMavPacket(MAVLinkPacketFactory.createFollowFromLocationPacket(location));
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isReportResponseSucc(int i, long j, final AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith) {
        if (iCompletionCallbackWith == null) {
            return true;
        }
        if (i == 96) {
            if (MissionManager.getAutelMissionInfoParser().isNewInfo(i, j)) {
                MsgPostManager.instance().post(new PostRunnable() {
                    /* access modifiers changed from: protected */
                    public void task() {
                        if (AutelAircraftInfoManager.getFlyControllerStatus().getFlyMode() == FlyMode.FOLLOW_FOLLOW || AutelAircraftInfoManager.getFlyControllerStatus().getFlyMode() == FlyMode.FOLLOW_HOLD) {
                            iCompletionCallbackWith.onResult(FollowSwitch.ENABLE);
                        } else {
                            iCompletionCallbackWith.onResult(FollowSwitch.DISABLE);
                        }
                    }
                });
            }
        }
        return false;
    }

    private class CheckFlyModeRunnable implements Runnable {
        /* access modifiers changed from: private */
        public FollowSwitch autelFollowSwitch;
        /* access modifiers changed from: private */
        public AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith;
        boolean waiting = true;

        public CheckFlyModeRunnable(FollowSwitch followSwitch, AutelCompletionCallback.ICompletionCallbackWith iCompletionCallbackWith2) {
            boolean unused = AutelFollowMissionRequestManager.this.checkValueValid(iCompletionCallbackWith2);
            this.autelFollowSwitch = followSwitch;
            this.iCompletionCallbackWith = iCompletionCallbackWith2;
        }

        public void cancel() {
            this.waiting = false;
            AutelFollowMissionRequestManager.this.removeCallback(this.iCompletionCallbackWith);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0066 A[Catch:{ Exception -> 0x009b }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0079 A[Catch:{ Exception -> 0x009b }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.lang.String r0 = "CheckFlyMode"
                java.lang.String r1 = "fire"
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r0, (java.lang.String) r1)
                long r1 = java.lang.System.currentTimeMillis()
            L_0x000b:
                boolean r3 = r8.waiting
                if (r3 == 0) goto L_0x00c5
                com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager r3 = com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager.this
                com.autel.sdk10.interfaces.AutelCompletionCallback$ICompletionCallbackWith r4 = r8.iCompletionCallbackWith
                com.autel.sdk10.interfaces.AutelCompletionCallback$ICompletionCallbackWith r3 = r3.getCallback(r4)
                if (r3 == 0) goto L_0x00c5
                r3 = 50
                java.lang.Thread.sleep(r3)     // Catch:{ Exception -> 0x009b }
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x009b }
                long r3 = r3 - r1
                r5 = 10000(0x2710, double:4.9407E-320)
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 > 0) goto L_0x0088
                com.autel.internal.sdk.flycontroller.AutelFlyControllerStatusInternal r3 = com.autel.sdk10.products.aircraft.AutelAircraftInfoManager.getFlyControllerStatus()     // Catch:{ Exception -> 0x009b }
                com.autel.common.flycontroller.FlyMode r3 = r3.getFlyMode()     // Catch:{ Exception -> 0x009b }
                com.autel.common.flycontroller.FlyMode r4 = com.autel.common.flycontroller.FlyMode.FOLLOW_FOLLOW     // Catch:{ Exception -> 0x009b }
                r5 = 1
                if (r3 == r4) goto L_0x0045
                com.autel.internal.sdk.flycontroller.AutelFlyControllerStatusInternal r3 = com.autel.sdk10.products.aircraft.AutelAircraftInfoManager.getFlyControllerStatus()     // Catch:{ Exception -> 0x009b }
                com.autel.common.flycontroller.FlyMode r3 = r3.getFlyMode()     // Catch:{ Exception -> 0x009b }
                com.autel.common.flycontroller.FlyMode r4 = com.autel.common.flycontroller.FlyMode.FOLLOW_HOLD     // Catch:{ Exception -> 0x009b }
                if (r3 != r4) goto L_0x0043
                goto L_0x0045
            L_0x0043:
                r3 = 0
                goto L_0x0046
            L_0x0045:
                r3 = 1
            L_0x0046:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b }
                r4.<init>()     // Catch:{ Exception -> 0x009b }
                java.lang.String r6 = "isFollowOn == "
                r4.append(r6)     // Catch:{ Exception -> 0x009b }
                r4.append(r3)     // Catch:{ Exception -> 0x009b }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x009b }
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x009b }
                int[] r4 = com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager.C50082.$SwitchMap$com$autel$internal$sdk$mission$FollowSwitch     // Catch:{ Exception -> 0x009b }
                com.autel.internal.sdk.mission.FollowSwitch r6 = r8.autelFollowSwitch     // Catch:{ Exception -> 0x009b }
                int r6 = r6.ordinal()     // Catch:{ Exception -> 0x009b }
                r4 = r4[r6]     // Catch:{ Exception -> 0x009b }
                if (r4 == r5) goto L_0x0079
                r5 = 2
                if (r4 == r5) goto L_0x006a
                goto L_0x000b
            L_0x006a:
                if (r3 != 0) goto L_0x000b
                com.autel.internal.sdk.product.datapost.MsgPostManager r3 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ Exception -> 0x009b }
                com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$CheckFlyModeRunnable$2 r4 = new com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$CheckFlyModeRunnable$2     // Catch:{ Exception -> 0x009b }
                r4.<init>()     // Catch:{ Exception -> 0x009b }
                r3.post(r4)     // Catch:{ Exception -> 0x009b }
                goto L_0x000b
            L_0x0079:
                if (r3 == 0) goto L_0x000b
                com.autel.internal.sdk.product.datapost.MsgPostManager r3 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ Exception -> 0x009b }
                com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$CheckFlyModeRunnable$1 r4 = new com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$CheckFlyModeRunnable$1     // Catch:{ Exception -> 0x009b }
                r4.<init>()     // Catch:{ Exception -> 0x009b }
                r3.post(r4)     // Catch:{ Exception -> 0x009b }
                goto L_0x000b
            L_0x0088:
                java.lang.String r3 = "timeout "
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x009b }
                com.autel.internal.sdk.product.datapost.MsgPostManager r3 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()     // Catch:{ Exception -> 0x009b }
                com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$CheckFlyModeRunnable$3 r4 = new com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$CheckFlyModeRunnable$3     // Catch:{ Exception -> 0x009b }
                r4.<init>()     // Catch:{ Exception -> 0x009b }
                r3.post(r4)     // Catch:{ Exception -> 0x009b }
                goto L_0x000b
            L_0x009b:
                r3 = move-exception
                r3.printStackTrace()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Exception "
                r4.append(r5)
                java.lang.String r3 = r3.toString()
                r4.append(r3)
                java.lang.String r3 = r4.toString()
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r0, (java.lang.String) r3)
                com.autel.internal.sdk.product.datapost.MsgPostManager r3 = com.autel.internal.sdk.product.datapost.MsgPostManager.instance()
                com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$CheckFlyModeRunnable$4 r4 = new com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$CheckFlyModeRunnable$4
                r4.<init>()
                r3.post(r4)
                goto L_0x000b
            L_0x00c5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager.CheckFlyModeRunnable.run():void");
        }
    }

    /* renamed from: com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager$2 */
    /* synthetic */ class C50082 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$internal$sdk$mission$FollowSwitch;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.autel.internal.sdk.mission.FollowSwitch[] r0 = com.autel.internal.sdk.mission.FollowSwitch.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$internal$sdk$mission$FollowSwitch = r0
                com.autel.internal.sdk.mission.FollowSwitch r1 = com.autel.internal.sdk.mission.FollowSwitch.ENABLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$internal$sdk$mission$FollowSwitch     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.sdk.mission.FollowSwitch r1 = com.autel.internal.sdk.mission.FollowSwitch.DISABLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager.C50082.<clinit>():void");
        }
    }
}
