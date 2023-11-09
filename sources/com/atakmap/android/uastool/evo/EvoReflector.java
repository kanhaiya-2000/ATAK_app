package com.atakmap.android.uastool.evo;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.utils.AROverlayMuxCallback;
import com.autel.internal.video.core.decoder2.CodecManager;
import com.autel.internal.video.core.decoder2.common.VideoDefaultParams;
import com.partech.mobilevid.g;

public class EvoReflector extends Reflector {
    private Thread cotProducerThread = null;
    private final boolean sendVideo = true;
    private SurfaceTexture surfaceTexture;

    public boolean usesYUVTexture() {
        return false;
    }

    public EvoReflector(Context context, SharedPreferences sharedPreferences, UASItem uASItem) {
        super(context, sharedPreferences, uASItem, SUASIntegratorMapComponent.NOTIFICATION_ID);
        TAG = EvoReflector.class.getSimpleName();
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(this.sharedPrefs, str);
    }

    private void videoSourceAttributeChanged() {
        if (this.previewActive) {
            stopPreview();
            startPreview(this.previewSurface);
        }
    }

    public void run() {
        this.isBroadcasting = true;
    }

    public void startPreview(Surface surface) {
        if (this.surfaceTexture == null) {
            try {
                this.surfaceTexture = UASToolDropDownReceiver.getInstance().getOffscreenDirector().a();
                UASToolDropDownReceiver.getInstance().getOffscreenDirector().a(VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
                Log.d(TAG, "startVideo");
                try {
                    CodecManager.getInstance().initCodec();
                    CodecManager.getInstance().startDecode(this.surfaceTexture, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                this.surfaceTexture = null;
            }
        }
        MapView.getMapView().postDelayed(new Runnable() {
            public void run() {
                EvoReflector.this.streamStarted();
            }
        }, 100);
    }

    public String startLocalCOT() {
        com.atakmap.coremap.log.Log.d(TAG, "Starting local COT");
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
                com.atakmap.coremap.log.Log.d(TAG, "Stopping the Cot Producer");
                this.cotProducerThread.interrupt();
                this.cotProducerThread = null;
            }
        }
    }

    public void stopPreview() {
        try {
            if (this.surfaceTexture != null) {
                CodecManager.getInstance().stopCodec();
            }
        } catch (Throwable unused) {
        }
        this.surfaceTexture = null;
        super.stopPreview();
    }

    public g getMuxCallback() {
        return new AROverlayMuxCallback(this.uasItem);
    }

    public boolean isPreviewActive() {
        return this.surfaceTexture != null;
    }
}
