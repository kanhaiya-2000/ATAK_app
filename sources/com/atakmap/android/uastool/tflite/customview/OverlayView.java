package com.atakmap.android.uastool.tflite.customview;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.tflite.DetectorActivity;
import com.atakmap.coremap.log.Log;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class OverlayView extends View implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String TAG = "OverlayView";
    static DetectorActivity detectorActivity = new DetectorActivity();
    private final List<DrawCallback> callbacks = new LinkedList();
    protected Future<?> trackerOsdHandle = null;
    protected final ScheduledExecutorService trackerOsdScheduler = Executors.newSingleThreadScheduledExecutor();

    public interface DrawCallback {
        void drawCallback(Canvas canvas);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addCallback(DrawCallback drawCallback) {
        this.callbacks.add(drawCallback);
    }

    public synchronized void draw(Canvas canvas) {
        super.draw(canvas);
        for (DrawCallback drawCallback : this.callbacks) {
            drawCallback.drawCallback(canvas);
        }
    }

    public void setUASItem(UASItem uASItem) {
        detectorActivity.setUASItem(uASItem);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void stopOSD() {
        Log.d(TAG, "stopOSD");
        Future<?> future = this.trackerOsdHandle;
        if (future != null) {
            future.cancel(false);
            this.trackerOsdHandle = null;
        }
        DetectorActivity detectorActivity2 = detectorActivity;
        if (detectorActivity2 != null) {
            detectorActivity2.dispose();
        }
    }

    public void startOSD() {
        Log.d(TAG, "startOSD");
        resize();
        if (UASToolDropDownReceiver.getSharedPrefs().getBoolean(UIPreferenceFragment.PREF_UI_DETECTION_ON, UIPreferenceFragment.DEFAULT_UI_DETECTION_ON.booleanValue()) && this.trackerOsdHandle == null) {
            try {
                DetectorActivity detectorActivity2 = detectorActivity;
                if (detectorActivity2 != null) {
                    detectorActivity2.init();
                }
                this.trackerOsdHandle = this.trackerOsdScheduler.scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        try {
                            if (OverlayView.detectorActivity.isReady()) {
                                if (UASToolDropDownReceiver.getReflector().isPreviewActive()) {
                                    OverlayView.detectorActivity.processImage((Bitmap) null);
                                    return;
                                }
                            }
                            Log.d(OverlayView.TAG, "Detector is not ready");
                        } catch (Throwable th) {
                            Log.d(OverlayView.TAG, "OSD Scheduler Exception: ", th);
                        }
                    }
                }, 500, 1000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                Log.e(TAG, "error starting tracker: ", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void runInBackground(Runnable runnable) {
        new Thread(runnable).start();
    }

    public void resize() {
        detectorActivity.init_detector(getWidth(), getHeight(), 90);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (!str.equals(UIPreferenceFragment.PREF_UI_DETECTION_ON)) {
            return;
        }
        if (sharedPreferences.getBoolean(UIPreferenceFragment.PREF_UI_DETECTION_ON, UIPreferenceFragment.DEFAULT_UI_DETECTION_ON.booleanValue()) && this.trackerOsdHandle == null) {
            startOSD();
        } else if (this.trackerOsdHandle != null) {
            stopOSD();
        }
    }
}
