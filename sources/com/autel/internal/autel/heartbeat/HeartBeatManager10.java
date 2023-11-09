package com.autel.internal.autel.heartbeat;

import android.util.Log;
import com.autel.common.product.AutelProductInfo;
import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.AutelStateManager;
import com.autel.internal.network.usb.proxy.AutelUSBHelper;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;
import com.autel.internal.sdk.heartbeat.IAutelHeartBeatListener;
import com.autel.sdk10.AutelNet.AutelBattery.parser.BatteryInfoParser;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.ErrorWarningInternalParser;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;
import com.autel.sdk10.products.aircraft.AutelAircraftManager;
import com.autel.sdk10.products.info.FirmwareConnectStatus;
import com.autel.sdk10.products.requestmanager.AutelProductRequestManager;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;

public class HeartBeatManager10 extends AbsHeartBeatManager implements IAutelHeartBeatListener {
    private static final String BeatMonitorTag = "HeartBeatMonitor";
    private IAutelHeartBeatListener heartBeatListener;
    boolean isAirCraft;

    private void openCameraConnect() {
    }

    public HeartBeatManager10(AutelStateManager autelStateManager, HeartBeatListener heartBeatListener2) {
        super(autelStateManager, heartBeatListener2);
    }

    public void onHeartBeatStatus(HeartBeatStatus heartBeatStatus, AutelProductInfo autelProductInfo) {
        Log.v("testuuuu", "onHeartBeatStatus<<<<<<<<<<<<<< " + heartBeatStatus);
        this.internalManager.setHeartBeatStatus(heartBeatStatus);
        int i = C27591.$SwitchMap$com$autel$internal$sdk$flycontroller$HeartBeatStatus[heartBeatStatus.ordinal()];
        boolean z = true;
        if (i == 1) {
            if (!(autelProductInfo.getProduct() == AutelProductType.X_STAR || autelProductInfo.getProduct() == AutelProductType.PREMIUM || autelProductInfo.getProduct() == AutelProductType.EVO)) {
                z = false;
            }
            this.isAirCraft = z;
            checkFirst();
        } else if (i == 2) {
            checkNormal(AutelServiceVersion.SERVICE_10, autelProductInfo.getProduct());
        } else if (i == 3) {
            checkEnd();
        } else if (i == 4) {
            checkStop();
        }
    }

    /* renamed from: com.autel.internal.autel.heartbeat.HeartBeatManager10$1 */
    /* synthetic */ class C27591 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.autel.heartbeat.HeartBeatManager10.C27591.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void startBeat() {
        AutelProductRequestManager.addIAutelHeartBeatListener(BeatMonitorTag, this);
        Log.v("logTest", "startBeat for wifi " + AutelUSBHelper.instance().isUsbOpened());
        StarLinkClientManager.getInstance_().openConnection();
    }

    /* access modifiers changed from: protected */
    public void stopBeat() {
        StarLinkClientManager.getInstance_().closeConnection();
        AutelProductRequestManager.removeIAutelHeartBeatListener(BeatMonitorTag);
    }

    /* access modifiers changed from: protected */
    public void first() {
        if (this.isAirCraft) {
            AutelLog.m15082d(AutelLogTags.TAG_HTTP_CAMERA, "startProductHeartBeat HEARTBEAT_FIRST " + this.isAirCraft);
            openCameraConnect();
        } else {
            AutelAircraftManager.getRCManager().closeConnection();
            AutelAircraftManager.getRCButtonManager().closeConnection();
            AutelLog.m15082d(AutelLogTags.TAG_HTTP_CAMERA, "startProductHeartBeat HEARTBEAT_FIRST " + this.isAirCraft);
        }
        FirmwareConnectStatus.getInstance().setAircraftHeartBeatNormal(true);
    }

    /* access modifiers changed from: protected */
    public void normal() {
        openCameraConnect();
        ErrorWarningInternalParser.getInstance().parseConnectStatus(true);
        FirmwareConnectStatus.getInstance().setAircraftHeartBeatNormal(true);
    }

    /* access modifiers changed from: protected */
    public void end() {
        ErrorWarningInternalParser.getInstance().parseConnectStatus(false);
        BatteryInfoParser.getInstance_().clearBatteryHistoryRecords();
        AutelLog.m15082d(AutelLogTags.TAG_HTTP_CAMERA, "startProductHeartBeat HEARTBEAT_STOP");
        FirmwareConnectStatus.getInstance().setAircraftHeartBeatNormal(false);
    }
}
