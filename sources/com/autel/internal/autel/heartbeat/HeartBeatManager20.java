package com.autel.internal.autel.heartbeat;

import android.util.Log;
import com.autel.AutelNet2.aircraft.flycontroller.AircraftHeatBeatManager2;
import com.autel.AutelNet2.aircraft.flycontroller.interfaces.IHeartBeatListener;
import com.autel.AutelNet2.aircraft.flycontroller.parser.ErrorWarningInternalParser2;
import com.autel.AutelNet2.aircraft.flycontroller.parser.HeartBeatInfo;
import com.autel.AutelNet2.core.ConnectionManager2;
import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.AutelStateManager;
import com.autel.internal.flycontroller.evo.bean.G2FlyControllerInfoImpl;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;
import com.autel.sdk10.AutelNet.AutelBattery.parser.BatteryInfoParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.products.aircraft.AutelAircraftManager;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;

public class HeartBeatManager20 extends AbsHeartBeatManager implements IHeartBeatListener {
    private static final String BeatMonitorTag = "HeartBeatMonitor";
    private IHeartBeatListener heartBeatListener;
    private AutelStateManager internalManager;
    boolean isAirCraft;

    public HeartBeatManager20(AutelStateManager autelStateManager, HeartBeatListener heartBeatListener2) {
        super(autelStateManager, heartBeatListener2);
        this.internalManager = autelStateManager;
        AircraftHeatBeatManager2.getInstance().addIAutelHeartBeatListener(BeatMonitorTag, this);
    }

    public void onHeartBeatStatus(HeartBeatStatus heartBeatStatus, HeartBeatInfo heartBeatInfo) {
        G2FlyControllerInfoImpl.instance().mFlyControllerStatus = heartBeatInfo;
        AutelLog.m15090w("HeartBeatManager20", "20 onHeartBeatStatus " + heartBeatStatus);
        this.internalManager.setHeartBeatStatus(heartBeatStatus);
        int i = C27601.$SwitchMap$com$autel$internal$sdk$flycontroller$HeartBeatStatus[heartBeatStatus.ordinal()];
        boolean z = true;
        if (i == 1) {
            if (!(heartBeatInfo.getProduct() == AutelProductType.X_STAR || heartBeatInfo.getProduct() == AutelProductType.PREMIUM || heartBeatInfo.getProduct() == AutelProductType.EVO || heartBeatInfo.getProduct() == AutelProductType.EVO_2)) {
                z = false;
            }
            this.isAirCraft = z;
            checkFirst();
            ErrorWarningInternalParser2.getInstance().parseErrorWarning(heartBeatInfo.getAlarmStatus1(), heartBeatInfo.getAlarmStatus2());
        } else if (i == 2) {
            checkNormal(AutelServiceVersion.SERVICE_20, heartBeatInfo.getProduct());
            ErrorWarningInternalParser2.getInstance().parseErrorWarning(heartBeatInfo.getAlarmStatus1(), heartBeatInfo.getAlarmStatus2());
        } else if (i == 3) {
            checkEnd();
        } else if (i == 4) {
            checkStop();
        }
    }

    /* renamed from: com.autel.internal.autel.heartbeat.HeartBeatManager20$1 */
    /* synthetic */ class C27601 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$internal$sdk$flycontroller$HeartBeatStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.autel.internal.sdk.flycontroller.HeartBeatStatus[] r0 = com.autel.internal.sdk.flycontroller.HeartBeatStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$internal$sdk$flycontroller$HeartBeatStatus = r0
                com.autel.internal.sdk.flycontroller.HeartBeatStatus r1 = com.autel.internal.sdk.flycontroller.HeartBeatStatus.FIRST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$internal$sdk$flycontroller$HeartBeatStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.internal.sdk.flycontroller.HeartBeatStatus r1 = com.autel.internal.sdk.flycontroller.HeartBeatStatus.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$internal$sdk$flycontroller$HeartBeatStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.internal.sdk.flycontroller.HeartBeatStatus r1 = com.autel.internal.sdk.flycontroller.HeartBeatStatus.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$autel$internal$sdk$flycontroller$HeartBeatStatus     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.internal.sdk.flycontroller.HeartBeatStatus r1 = com.autel.internal.sdk.flycontroller.HeartBeatStatus.STOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.autel.heartbeat.HeartBeatManager20.C27601.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void startBeat() {
        ConnectionManager2.getInstance_().connect();
    }

    /* access modifiers changed from: protected */
    public void stopBeat() {
        Log.d("BaseUdpConnection", "stopBeat disconnect 2");
        ConnectionManager2.getInstance_().disconnect();
    }

    /* access modifiers changed from: protected */
    public void first() {
        if (!this.isAirCraft) {
            AutelAircraftManager.getRCManager().closeConnection();
            AutelAircraftManager.getRCButtonManager().closeConnection();
        }
        AutelLog.m15082d(AutelLogTags.TAG_HTTP_CAMERA, "startProductHeartBeat HEARTBEAT_FIRST " + this.isAirCraft);
        this.internalManager.setRemoteControllerConnected(true);
    }

    /* access modifiers changed from: protected */
    public void normal() {
        this.internalManager.setRemoteControllerConnected(true);
        ErrorWarningInternalParser.getInstance().parseConnectStatus(true);
    }

    /* access modifiers changed from: protected */
    public void end() {
        this.internalManager.setRemoteControllerConnected(false);
        ErrorWarningInternalParser.getInstance().parseConnectStatus(false);
        BatteryInfoParser.getInstance_().clearBatteryHistoryRecords();
        AutelLog.m15082d(AutelLogTags.TAG_HTTP_CAMERA, "startProductHeartBeat HEARTBEAT_STOP");
    }
}
