package com.atakmap.android.uastool.PD100;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Surface;
import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.uastool.MpegStreamHandler;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.prefs.NetworkPreferenceFragment;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.log.Log;

public class PD100Reflector extends Reflector implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final String TAG = "PD100Reflector";
    private boolean isSendingCOTLocal;
    private final long lastCornersUpdate = 0;

    public PD100Reflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
        super(context, sharedPreferences, uASItem, SUASIntegratorMapComponent.NOTIFICATION_ID);
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(this.sharedPrefs, str);
        if (!str.startsWith("uastool.pd100.")) {
            return;
        }
        if (str.equals(PD100PrefHandler.PREF_SRC_ADAPTER) || str.equals(PD100PrefHandler.PREF_SRC_IP) || str.equals(PD100PrefHandler.PREF_SRC_PORT)) {
            videoSourceAttributeChanged();
        }
    }

    private void videoSourceAttributeChanged() {
        if (this.previewActive) {
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(false);
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(true);
        }
    }

    public void updateVideoStream() {
        if (this.previewActive) {
            Log.d(TAG, "updateVideoStream - begin");
            UASToolDropDownReceiver.getInstance().setPreviewEnabled(false);
        }
        UASToolDropDownReceiver.getInstance().setPreviewEnabled(true);
        Log.d(TAG, "updateVideoStream - end");
    }

    public boolean isSendingCOTLocal() {
        return this.isSendingCOTLocal;
    }

    private String getRxIP() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        return (platformMonitor == null || !(platformMonitor instanceof PD100Monitor)) ? "" : ((PD100Monitor) platformMonitor).getActiveVideoIP();
    }

    private int getRxPort() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor == null || !(platformMonitor instanceof PD100Monitor)) {
            return 0;
        }
        return ((PD100Monitor) platformMonitor).getActiveVideoPort();
    }

    private String getRxNetwork() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        return (platformMonitor == null || !(platformMonitor instanceof PD100Monitor)) ? "" : ((PD100Monitor) platformMonitor).getActiveVideoNetwork();
    }

    public void startPreview(Surface surface) {
        if (!this.previewActive) {
            this.previewActive = true;
            this.previewSurface = surface;
            String rxIP = getRxIP();
            int rxPort = getRxPort();
            String rxNetwork = getRxNetwork();
            this.mpegStreamPreview = new MpegStreamHandler(rxIP, rxPort, surface, rxNetwork);
            this.mpegStreamPreview.setStatusUpdateConsumer(this);
            this.mpegStreamPreview.setMpegStreamKLVListener(this);
            this.mpegStreamPreview.start();
            String string = this.sharedPrefs.getString(NetworkPreferenceFragment.PREF_VIDEO_DEST_ADAPTER, (String) null);
            this.localUri = null;
            if (rxNetwork != null && rxNetwork.equals(string) && Utils.isMulticast(rxIP) && isVideoDestLocal()) {
                this.localUri = "udp://" + rxIP + ":" + rxPort;
            }
        }
    }

    public SharedPreferences getSharedPrefs() {
        return this.sharedPrefs;
    }

    public String startLocalCOT() {
        this.isSendingCOTLocal = true;
        return null;
    }

    public void stopLocalCOT() {
        this.isSendingCOTLocal = false;
    }

    /* access modifiers changed from: package-private */
    public void publishCOT(CotEvent cotEvent) {
        if (this.isBroadcasting || this.isSendingCOTLocal) {
            CotEvent updateCotWithDTED = updateCotWithDTED(cotEvent);
            CotMapComponent.i().a(updateCotWithDTED);
            CotMapComponent.h().a(updateCotWithDTED);
        }
    }
}
