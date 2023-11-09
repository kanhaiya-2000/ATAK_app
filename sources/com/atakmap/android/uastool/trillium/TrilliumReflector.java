package com.atakmap.android.uastool.trillium;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Surface;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.utils.AROverlayMuxCallback;
import com.atakmap.coremap.log.Log;
import com.partech.mobilevid.g;

public class TrilliumReflector extends Reflector {
    private Thread cotProducerThread = null;
    private final boolean sendVideo = true;

    public TrilliumReflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
        super(context, sharedPreferences, uASItem, SUASIntegratorMapComponent.NOTIFICATION_ID);
        TAG = TrilliumReflector.class.getSimpleName();
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this);
        evalLocalUri(this.sharedPrefs.getString(TrilliumPrefHandler.PREF_SRC_ADAPTER, (String) null), getRxUri());
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(this.sharedPrefs, str);
        if (!str.startsWith("uastool.trillium.")) {
            return;
        }
        if (str.equals(TrilliumPrefHandler.PREF_SRC_ADAPTER) || str.equals(TrilliumPrefHandler.PREF_VIDEO_SRC_URI)) {
            videoSourceAttributeChanged();
        }
    }

    private void videoSourceAttributeChanged() {
        if (this.previewActive) {
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(false);
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(true);
        }
    }

    public void run() {
        this.isBroadcasting = true;
    }

    private String getRxUri() {
        return this.sharedPrefs.getString(TrilliumPrefHandler.PREF_VIDEO_SRC_URI, "");
    }

    public void startPreview(Surface surface) {
        String rxUri = getRxUri();
        String string = this.sharedPrefs.getString(TrilliumPrefHandler.PREF_SRC_ADAPTER, (String) null);
        int i = 500;
        try {
            i = (int) Double.parseDouble(this.sharedPrefs.getString(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_VIDEO_BUFFERING, TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_VIDEO_BUFFERING));
        } catch (Exception unused) {
            String str = TAG;
            Log.e(str, "Error parsing video buffer, defaulting to " + 500 + "ms");
        }
        startPreview(surface, rxUri, string, i);
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

    public g getMuxCallback() {
        return new AROverlayMuxCallback(this.uasItem);
    }
}
