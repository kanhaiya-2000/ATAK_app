package com.autel.internal.autel.heartbeat;

import android.util.Log;
import com.autel.common.product.AutelProductType;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.autel.AutelStateManager;
import com.autel.internal.sdk.product.datapost.MsgPostManager;
import com.autel.internal.sdk.product.datapost.PostRunnable;
import com.autel.util.log.AutelLog;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbsHeartBeatManager implements IHeartBeatManager {
    final int HEART_END = 3;
    final int HEART_FIRST = 1;
    final int HEART_NORMAL = 2;
    private IHeartBeatManager beatManager;
    /* access modifiers changed from: private */
    public HeartBeatListener heartBeatListener;
    private AtomicBoolean heartStarted = new AtomicBoolean(false);
    private volatile int heartState = 0;
    protected AutelStateManager internalManager;

    /* access modifiers changed from: protected */
    public abstract void end();

    /* access modifiers changed from: protected */
    public abstract void first();

    /* access modifiers changed from: protected */
    public abstract void normal();

    /* access modifiers changed from: protected */
    public abstract void startBeat();

    /* access modifiers changed from: protected */
    public abstract void stopBeat();

    public void setHeartBeatManager(IHeartBeatManager iHeartBeatManager) {
        this.beatManager = iHeartBeatManager;
    }

    public AbsHeartBeatManager(AutelStateManager autelStateManager, HeartBeatListener heartBeatListener2) {
        this.heartBeatListener = heartBeatListener2;
        this.internalManager = autelStateManager;
    }

    public void startBeatMonitor() {
        if (this.heartStarted.compareAndSet(false, true)) {
            Log.v("BaseUdpConnection", "begin fire  >>>>>>>>>>>>>>  " + this.heartStarted.get());
            startBeat();
        }
    }

    public void stopBeatMonitor() {
        Log.v("testuuuu", "stopBeatMonitor<<<<<<<<<<<<<< " + this.heartStarted.get());
        if (this.heartStarted.compareAndSet(true, false)) {
            stopBeat();
        }
    }

    /* access modifiers changed from: protected */
    public void checkFirst() {
        AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "checkFirst " + this.heartState + " to " + 1);
        this.heartState = 1;
        this.internalManager.setAircraftConnected(true);
        first();
    }

    /* access modifiers changed from: protected */
    public void checkNormal(final AutelServiceVersion autelServiceVersion, final AutelProductType autelProductType) {
        if (this.heartState != 2) {
            this.heartState = 2;
            IHeartBeatManager iHeartBeatManager = this.beatManager;
            if (iHeartBeatManager != null) {
                iHeartBeatManager.stopBeatMonitor();
            }
            this.internalManager.setAircraftConnected(true);
            normal();
            AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "checkNormal !HEART_NORMAL to HEART_NORMAL");
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    if (AbsHeartBeatManager.this.heartBeatListener != null) {
                        AbsHeartBeatManager.this.heartBeatListener.connect(autelServiceVersion, autelProductType);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void checkEnd() {
        Log.v("BaseUdpConnection", "begin fire  >>>>>>>>>>>>>>  " + this.heartStarted.get());
        if (this.heartState == 2) {
            this.heartState = 3;
            AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "checkEnd HEART_NORMAL to HEART_END");
            this.internalManager.setAircraftConnected(false);
            end();
            IHeartBeatManager iHeartBeatManager = this.beatManager;
            if (iHeartBeatManager != null) {
                iHeartBeatManager.startBeatMonitor();
            }
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    if (AbsHeartBeatManager.this.heartBeatListener != null) {
                        AbsHeartBeatManager.this.heartBeatListener.disconnect();
                    }
                }
            });
            stopBeatMonitor();
            startBeatMonitor();
        }
    }

    /* access modifiers changed from: protected */
    public void checkStop() {
        if (this.heartState == 2) {
            this.heartState = 3;
            AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "checkStop HEART_NORMAL to HEART_END");
            this.internalManager.setAircraftConnected(false);
            end();
            IHeartBeatManager iHeartBeatManager = this.beatManager;
            if (iHeartBeatManager != null) {
                iHeartBeatManager.startBeatMonitor();
            }
            MsgPostManager.instance().post(new PostRunnable() {
                /* access modifiers changed from: protected */
                public void task() {
                    if (AbsHeartBeatManager.this.heartBeatListener != null) {
                        AbsHeartBeatManager.this.heartBeatListener.disconnect();
                    }
                }
            });
        }
    }
}
