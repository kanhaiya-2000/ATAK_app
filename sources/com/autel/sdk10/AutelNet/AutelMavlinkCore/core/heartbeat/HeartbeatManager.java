package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.heartbeat;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.ardupilotmega.msg_heartbeat;
import com.autel.internal.sdk.flycontroller.HeartBeatStatus;
import com.autel.internal.sdk.heartbeat.IAutelHeartBeatListener;
import com.autel.sdk10.products.info.AutelProductInfoInternal;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HeartbeatManager {
    private static HeartbeatManager mInstance;
    /* access modifiers changed from: private */
    public HeartBeatStatus autelHeartBeatStatus = HeartBeatStatus.ERROR;
    /* access modifiers changed from: private */
    public long heartBeatTimeOut = ((long) ((this.period * 6) * 1000));
    private ScheduledExecutorService heartbeatExecutor;
    private final Runnable heartbeatRunnable = new Runnable() {
        public void run() {
            MavLinkHeartbeat.sendMavHeartbeat();
            if (HeartbeatManager.this.lastHeartBeatTime != 0 && System.currentTimeMillis() - HeartbeatManager.this.lastHeartBeatTime > HeartbeatManager.this.heartBeatTimeOut) {
                HeartBeatStatus unused = HeartbeatManager.this.autelHeartBeatStatus = HeartBeatStatus.ERROR;
                long unused2 = HeartbeatManager.this.lastHeartBeatTime = System.currentTimeMillis();
                HeartbeatManager.this.onHeartBeatCallback();
            }
        }
    };
    private boolean isActive;
    /* access modifiers changed from: private */
    public long lastHeartBeatTime;
    private final ConcurrentHashMap<String, IAutelHeartBeatListener> mListeners = new ConcurrentHashMap<>();
    private int period = 1;

    public static HeartbeatManager getInstance() {
        if (mInstance == null) {
            synchronized (HeartbeatManager.class) {
                mInstance = new HeartbeatManager();
            }
        }
        return mInstance;
    }

    public void addIAutelHeartBeatListener(String str, IAutelHeartBeatListener iAutelHeartBeatListener) {
        this.mListeners.put(str, iAutelHeartBeatListener);
    }

    public void removeIAutelHeartBeatListener(String str) {
        this.mListeners.remove(str);
    }

    /* access modifiers changed from: private */
    public void onHeartBeatCallback() {
        if (this.autelHeartBeatStatus == HeartBeatStatus.ERROR || this.autelHeartBeatStatus == HeartBeatStatus.STOP) {
            AutelProductInfoInternal.getInstance_().setData((msg_heartbeat) null);
        }
        for (IAutelHeartBeatListener onHeartBeatStatus : this.mListeners.values()) {
            onHeartBeatStatus.onHeartBeatStatus(this.autelHeartBeatStatus, AutelProductInfoInternal.getInstance_());
        }
    }

    private HeartbeatManager() {
    }

    public void reportReceivedMessage(MAVLinkMessage mAVLinkMessage) {
        if (!this.mListeners.isEmpty() && this.isActive) {
            AutelProductInfoInternal.getInstance_().setData((msg_heartbeat) mAVLinkMessage);
            if (this.autelHeartBeatStatus == HeartBeatStatus.ERROR || this.autelHeartBeatStatus == HeartBeatStatus.STOP) {
                this.autelHeartBeatStatus = HeartBeatStatus.FIRST;
            } else {
                this.autelHeartBeatStatus = HeartBeatStatus.NORMAL;
            }
            this.lastHeartBeatTime = System.currentTimeMillis();
            onHeartBeatCallback();
        }
    }

    public HeartbeatManager setPeriod(int i) {
        this.period = i;
        this.heartBeatTimeOut = (long) (i * 6 * 1000);
        return getInstance();
    }

    public void setActive(boolean z) {
        if (z != this.isActive) {
            this.isActive = z;
            if (z) {
                try {
                    ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                    this.heartbeatExecutor = newSingleThreadScheduledExecutor;
                    newSingleThreadScheduledExecutor.scheduleWithFixedDelay(this.heartbeatRunnable, 0, (long) this.period, TimeUnit.SECONDS);
                    AutelLog.m15084e(AutelLogTags.TAG_MAVLINK, "******** Heartbeat fire ********");
                } catch (Exception unused) {
                }
            } else {
                ScheduledExecutorService scheduledExecutorService = this.heartbeatExecutor;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    this.heartbeatExecutor = null;
                    this.autelHeartBeatStatus = HeartBeatStatus.STOP;
                    this.lastHeartBeatTime = 0;
                    onHeartBeatCallback();
                    AutelLog.m15084e(AutelLogTags.TAG_MAVLINK, "******** Heartbeat stop ********");
                }
            }
        }
    }
}
