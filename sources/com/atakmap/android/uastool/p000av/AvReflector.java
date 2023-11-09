package com.atakmap.android.uastool.p000av;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Surface;
import com.atakmap.android.uastool.MpegStreamHandler;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;

/* renamed from: com.atakmap.android.uastool.av.AvReflector */
public class AvReflector extends Reflector {
    public static final String BROADCAST_IP = "192.168.0.255";

    private String getRxIP() {
        return BROADCAST_IP;
    }

    public void setCaptureToStorage(boolean z) {
    }

    public AvReflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
        super(context, sharedPreferences, uASItem, SUASIntegratorMapComponent.NOTIFICATION_ID);
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(this.sharedPrefs, str);
        if (str.startsWith("uastool.av.") && str.equals(AvPrefHandler.PREF_SRC_ADAPTER)) {
            videoSourceAttributeChanged();
        }
    }

    private void videoSourceAttributeChanged() {
        if (this.previewActive) {
            stopPreview();
            startPreview(this.previewSurface);
        }
    }

    private int getRxPort() {
        AvMonitor avMonitor = (AvMonitor) UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        return avMonitor != null ? avMonitor.getVideoPort(this.uasItem.getUid()) : AvMonitor.VIDEO_PORT_DEFAULT;
    }

    public void startPreview(Surface surface) {
        if (!isPreviewActive()) {
            this.previewActive = true;
            this.previewSurface = surface;
            String rxIP = getRxIP();
            int rxPort = getRxPort();
            if (this.mpegStreamPreview != null) {
                this.mpegStreamPreview = null;
            }
            this.mpegStreamPreview = new MpegStreamHandler(rxIP, rxPort, surface, this.sharedPrefs.getString(AvPrefHandler.PREF_SRC_ADAPTER, (String) null));
            this.mpegStreamPreview.setStatusUpdateConsumer(this);
            this.mpegStreamPreview.setMpegStreamKLVListener(this);
            this.mpegStreamPreview.start();
        }
    }

    public String startLocalCOT() {
        AvMonitor avMonitor = (AvMonitor) UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (avMonitor == null) {
            return null;
        }
        avMonitor.endParser();
        avMonitor.beginParser();
        return null;
    }

    public void cornersUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        AvParser avParser = ((AvMonitor) UASToolDropDownReceiver.getInstance().getPlatformMonitor()).getAvParser();
        if (avParser != null) {
            avParser.cornersUpdate(d, d2, d3, d4, d5, d6, d7, d8);
        }
    }
}
