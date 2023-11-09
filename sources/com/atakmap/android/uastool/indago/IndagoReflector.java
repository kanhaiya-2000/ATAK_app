package com.atakmap.android.uastool.indago;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Surface;
import androidx.core.util.Pair;
import com.atakmap.android.uastool.MpegStreamHandler;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.coremap.log.Log;
import com.partech.pgscmedia.consumers.StatusUpdateConsumer;

public final class IndagoReflector extends Reflector implements MpegStreamHandler.MpegStreamKLVListener, StatusUpdateConsumer {
    private static final String TAG = "IndagoReflector";
    private Thread cotProducerThread = null;

    /* access modifiers changed from: protected */
    public Pair<String, Integer> getVideoEndpointAndPort() {
        return null;
    }

    public void run() {
    }

    public String takePicture(String str, String str2, String str3) {
        return "Images not available on the Indago";
    }

    public IndagoReflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
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
        if (!str.startsWith("uastool.indago.")) {
            return;
        }
        if (str.equals(IndagoPrefHandler.PREF_SRC_ADAPTER) || str.equals(IndagoPrefHandler.PREF_SRC_IP) || str.equals(IndagoPrefHandler.PREF_SRC_PORT)) {
            videoSourceAttributeChanged();
        }
    }

    private void videoSourceAttributeChanged() {
        if (this.previewActive) {
            stopPreview();
            startPreview(this.previewSurface);
        }
    }

    public void startPreview(Surface surface) {
        String string = this.sharedPrefs.getString(IndagoPrefHandler.PREF_SRC_IP, IndagoPrefHandler.DEFAULT_SRC_IP);
        String string2 = this.sharedPrefs.getString(IndagoPrefHandler.PREF_SRC_PORT, IndagoPrefHandler.DEFAULT_SRC_PORT);
        String string3 = this.sharedPrefs.getString(IndagoPrefHandler.PREF_SRC_ADAPTER, (String) null);
        startPreview(surface, "udp://" + string + ":" + string2, string3);
    }
}
