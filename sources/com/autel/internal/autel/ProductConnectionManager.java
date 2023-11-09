package com.autel.internal.autel;

import com.autel.internal.autel.heartbeat.AbsHeartBeatManager;
import com.autel.internal.autel.heartbeat.HeartBeatListener;
import com.autel.internal.autel.heartbeat.HeartBeatManager10;
import com.autel.internal.autel.heartbeat.HeartBeatManager20;
import com.autel.internal.network.usb.proxy.AutelUSBHelper;
import com.autel.sdk.AutelSdkConfig;

public class ProductConnectionManager {
    final String TAG = "ProductConnectionManager";
    private AbsHeartBeatManager heartBeatManager10;
    private AbsHeartBeatManager heartBeatManager20;

    /* renamed from: com.autel.internal.autel.ProductConnectionManager$1 */
    /* synthetic */ class C27461 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$sdk$AutelSdkConfig$VersionDetect;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.autel.sdk.AutelSdkConfig$VersionDetect[] r0 = com.autel.sdk.AutelSdkConfig.VersionDetect.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$sdk$AutelSdkConfig$VersionDetect = r0
                com.autel.sdk.AutelSdkConfig$VersionDetect r1 = com.autel.sdk.AutelSdkConfig.VersionDetect.ONLY_G1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$sdk$AutelSdkConfig$VersionDetect     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.sdk.AutelSdkConfig$VersionDetect r1 = com.autel.sdk.AutelSdkConfig.VersionDetect.ONLY_G2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$autel$sdk$AutelSdkConfig$VersionDetect     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.sdk.AutelSdkConfig$VersionDetect r1 = com.autel.sdk.AutelSdkConfig.VersionDetect.ALL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.autel.ProductConnectionManager.C27461.<clinit>():void");
        }
    }

    public ProductConnectionManager(AutelSdkConfig.VersionDetect versionDetect, AutelStateManager autelStateManager, HeartBeatListener heartBeatListener) {
        int i = C27461.$SwitchMap$com$autel$sdk$AutelSdkConfig$VersionDetect[versionDetect.ordinal()];
        if (i == 1) {
            this.heartBeatManager10 = new HeartBeatManager10(autelStateManager, heartBeatListener);
        } else if (i == 2) {
            this.heartBeatManager20 = new HeartBeatManager20(autelStateManager, heartBeatListener);
        } else if (i == 3) {
            this.heartBeatManager10 = new HeartBeatManager10(autelStateManager, heartBeatListener);
            this.heartBeatManager20 = new HeartBeatManager20(autelStateManager, heartBeatListener);
        }
        AbsHeartBeatManager absHeartBeatManager = this.heartBeatManager10;
        if (absHeartBeatManager != null) {
            absHeartBeatManager.setHeartBeatManager(this.heartBeatManager20);
        }
        AbsHeartBeatManager absHeartBeatManager2 = this.heartBeatManager20;
        if (absHeartBeatManager2 != null) {
            absHeartBeatManager2.setHeartBeatManager(this.heartBeatManager10);
        }
    }

    public void startConnection() {
        if (AutelUSBHelper.instance().isUsbOpened()) {
            closeConnection();
            AbsHeartBeatManager absHeartBeatManager = this.heartBeatManager10;
            if (absHeartBeatManager != null) {
                absHeartBeatManager.startBeatMonitor();
            }
            AbsHeartBeatManager absHeartBeatManager2 = this.heartBeatManager20;
            if (absHeartBeatManager2 != null) {
                absHeartBeatManager2.startBeatMonitor();
            }
        }
    }

    public void startWifiConnection() {
        AbsHeartBeatManager absHeartBeatManager;
        if (!AutelUSBHelper.instance().isUsbOpened() && (absHeartBeatManager = this.heartBeatManager10) != null) {
            absHeartBeatManager.startBeatMonitor();
        }
    }

    public void closeConnection() {
        AbsHeartBeatManager absHeartBeatManager = this.heartBeatManager10;
        if (absHeartBeatManager != null) {
            absHeartBeatManager.stopBeatMonitor();
        }
        AbsHeartBeatManager absHeartBeatManager2 = this.heartBeatManager20;
        if (absHeartBeatManager2 != null) {
            absHeartBeatManager2.stopBeatMonitor();
        }
    }
}
