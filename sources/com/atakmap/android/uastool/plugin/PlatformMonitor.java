package com.atakmap.android.uastool.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.log.Log;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class PlatformMonitor extends BroadcastReceiver {
    protected static final int TIMER_MILLIS = 1000;
    private final String TAG = "PlatformMonitor";
    protected String platform;
    /* access modifiers changed from: protected */
    public final Context pluginContext;
    protected final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    protected Future<?> schedulerHandle = null;
    /* access modifiers changed from: protected */
    public OnUASDetectedListener uasDetectedListener;

    public interface OnUASDetectedListener {
        void onUASDetected(List<UASItem> list);
    }

    /* access modifiers changed from: protected */
    public abstract List<UASItem> getDetectedUasList();

    public abstract boolean monitors(String str);

    public void onIncomingCot(CotEvent cotEvent) {
    }

    public void onReceive(Context context, Intent intent) {
    }

    public void onSendRouteReceived(String str) {
    }

    public void onWaypointSetReceived() {
    }

    public abstract void setCaptureToStorage(boolean z);

    public PlatformMonitor(Context context, String str) {
        this.pluginContext = context;
        this.platform = str;
    }

    public void setPlatform(String str) {
        if (!this.platform.equals(str)) {
            this.platform = str;
        }
    }

    public void beginMonitoring(boolean z) {
        UASToolDropDownReceiver.toast("UAS Tool monitoring " + this.platform + " platforms", 0);
        this.schedulerHandle = this.scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    List<UASItem> detectedUasList = PlatformMonitor.this.getDetectedUasList();
                    if (detectedUasList != null && PlatformMonitor.this.uasDetectedListener != null) {
                        PlatformMonitor.this.uasDetectedListener.onUASDetected(detectedUasList);
                    }
                } catch (Exception e) {
                    Log.d("PlatformMonitor", "EXCEPTION in beginMonitoring timer task: ", e);
                }
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

    public void endMonitoring() {
        UASItem defaultUasItem = UASToolDropDownReceiver.getInstance().getDefaultUasItem();
        if (defaultUasItem != null) {
            defaultUasItem.dispose();
        }
        Future<?> future = this.schedulerHandle;
        if (future != null) {
            future.cancel(false);
            this.schedulerHandle = null;
        }
    }

    public void setOnUASDetectedListener(OnUASDetectedListener onUASDetectedListener) {
        this.uasDetectedListener = onUASDetectedListener;
    }
}
