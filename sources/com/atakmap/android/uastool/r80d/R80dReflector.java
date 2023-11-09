package com.atakmap.android.uastool.r80d;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Surface;
import com.atakmap.android.uastool.MpegStreamHandler;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.utils.AROverlayMuxCallback;
import com.atakmap.coremap.log.Log;
import com.partech.mobilevid.g;

public final class R80dReflector extends Reflector {
    private static final String TAG = "R80dReflector";
    private Thread cotProducerThread = null;
    private String currentURI;
    private final MpegStreamHandler streamHandler = null;
    private final Object videoSyncRoot = new Object();

    public R80dReflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
        super(context, sharedPreferences, uASItem, SUASIntegratorMapComponent.NOTIFICATION_ID);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public String startLocalCOT() {
        Log.d(TAG, "Starting local COT");
        synchronized (this) {
            if (this.cotProducerThread == null) {
                Thread thread = new Thread(new Reflector.CotProducer(this.uasItem));
                this.cotProducerThread = thread;
                thread.start();
            }
        }
        return null;
    }

    public void stopLocalCOT() {
        synchronized (this) {
            if (this.cotProducerThread != null) {
                Log.d(TAG, "Stopping the Cot Producer");
                this.cotProducerThread.interrupt();
                this.cotProducerThread = null;
            }
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(this.sharedPrefs, str);
        if (str.startsWith("uastool.r80d.") && str.equals(R80dPrefHandler.PREF_VIDEO_URI)) {
            videoSourceAttributeChanged();
        }
    }

    private void videoSourceAttributeChanged() {
        if (this.previewActive) {
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(false);
        }
        UASToolDropDownReceiver.getInstance().setPreviewEnabled(true);
    }

    public void startPreview(Surface surface) {
        String string = this.sharedPrefs.getString(R80dPrefHandler.PREF_VIDEO_URI, R80dPrefHandler.DEFAULT_VIDEO_URI);
        if (!this.previewActive) {
            try {
                this.previewSurface = surface;
                this.currentURI = string;
                String str = TAG;
                Log.d(str, "Starting R80D Video preview: " + string);
                this.mpegStreamPreview = new MpegStreamHandler(string, surface);
                this.mpegStreamPreview.setStatusUpdateConsumer(this);
                this.mpegStreamPreview.setMpegStreamKLVListener(this);
                this.mpegStreamPreview.start();
                this.previewActive = true;
            } catch (Exception unused) {
                UASToolDropDownReceiver.toast("Invalid URI: " + string, 1);
                if (this.currentStatusListener != null) {
                    this.currentStatusListener.onStartupFailed();
                }
                stopPreview();
            }
        }
    }

    public g getMuxCallback() {
        return new AROverlayMuxCallback(this.uasItem);
    }

    public void destroy() {
        super.destroy();
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this);
    }
}
