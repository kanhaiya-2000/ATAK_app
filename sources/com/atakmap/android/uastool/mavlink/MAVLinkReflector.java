package com.atakmap.android.uastool.mavlink;

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

public class MAVLinkReflector extends Reflector {
    private Thread cotProducerThread = null;
    private final boolean sendVideo = true;

    public MAVLinkReflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
        super(context, sharedPreferences, uASItem, SUASIntegratorMapComponent.NOTIFICATION_ID);
        TAG = MAVLinkReflector.class.getSimpleName();
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this);
        evalLocalUri(this.sharedPrefs.getString(MAVLinkPrefHandler.PREF_SRC_ADAPTER, (String) null), getRxUri());
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(this.sharedPrefs, str);
        if (!str.startsWith("uastool.mavlink.")) {
            return;
        }
        if (str.equals(MAVLinkPrefHandler.PREF_SRC_ADAPTER) || str.equals(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI) || str.equals(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI2) || str.equals(MAVLinkPrefHandler.PREF_VIDEO_ACTIVE_URI)) {
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
        if (this.sharedPrefs.getInt(MAVLinkPrefHandler.PREF_VIDEO_ACTIVE_URI, 1) != 2) {
            return this.sharedPrefs.getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI, MAVLinkPrefHandler.DEFAULT_VIDEO_SRC_URI);
        }
        return this.sharedPrefs.getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI2, "");
    }

    public void startPreview(Surface surface) {
        startPreview(surface, this.uasItem.getVideoUrl(), this.sharedPrefs.getString(MAVLinkPrefHandler.PREF_SRC_ADAPTER, (String) null));
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
