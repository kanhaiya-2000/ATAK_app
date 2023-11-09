package com.autel.sdk10.AutelSDKManager;

import com.autel.internal.network.NetworkManager;
import com.autel.internal.sdk.AutelBaseApplication;
import com.autel.sdk10.products.AutelProductManager;
import com.autel.sdk10.products.aircraft.AutelAircraftManager;
import com.autel.util.log.AutelBuildConfig;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import com.autel.video.AutelPlayer;

/* renamed from: com.autel.sdk10.AutelSDKManager.AutelSDKManager */
public final class C5068AutelSDKManager {
    private static C5068AutelSDKManager instance_;
    private boolean isInited = false;

    public String getSDKVersion() {
        return AutelBuildConfig.VERSION_NAME;
    }

    public int getSDKVersionCode() {
        return 1;
    }

    public static synchronized C5068AutelSDKManager getInstance() {
        C5068AutelSDKManager autelSDKManager;
        synchronized (C5068AutelSDKManager.class) {
            if (instance_ == null) {
                instance_ = new C5068AutelSDKManager();
            }
            autelSDKManager = instance_;
        }
        return autelSDKManager;
    }

    private C5068AutelSDKManager() {
    }

    public synchronized void init() {
        AutelLog.m15084e(AutelLogTags.TAG, AutelBuildConfig.getVersionInfo());
        NetworkManager.getInstance(AutelBaseApplication.getAppContext()).registerReceiver();
        AutelPlayer.init();
        this.isInited = true;
    }

    public synchronized void exit() {
        NetworkManager.getInstance(AutelBaseApplication.getAppContext()).unregisterReceiver();
        new Thread("AutelSDKManager exit") {
            public void run() {
                C5068AutelSDKManager.this.closeAllConnection();
                AutelPlayer.quit();
                System.exit(0);
            }
        }.start();
        this.isInited = false;
    }

    public synchronized void closeAllConnection() {
        AutelProductManager.closeConnection();
        AutelAircraftManager.getRCManager().closeConnection();
        AutelAircraftManager.getRCButtonManager().closeConnection();
        AutelLog.m15082d(AutelLogTags.CAMERA_STATUS, "closeAllConnection");
    }

    public boolean isInited() {
        return this.isInited;
    }
}
