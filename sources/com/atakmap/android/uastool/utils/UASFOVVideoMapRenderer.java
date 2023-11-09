package com.atakmap.android.uastool.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import atak.core.agl;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.overlays.moasic.GLSurfaceLayer;
import com.atakmap.android.uastool.overlays.moasic.SurfaceLayer;
import com.atakmap.android.uastool.pagers.status.StatusArrayList;
import com.atakmap.android.uastool.utils.GLVideoConsumer;
import com.atakmap.coremap.log.Log;
import com.atakmap.map.layer.opengl.GLLayerFactory;

public class UASFOVVideoMapRenderer implements Runnable {
    private final String TAG = "UASFOVRenderer";
    private UASItem currentUAS;
    private GLVideoConsumer mapImageMonitor;

    public UASFOVVideoMapRenderer(UASItem uASItem) {
        if (uASItem != null) {
            this.currentUAS = uASItem;
        } else {
            this.currentUAS = StatusArrayList.getInstance().getDefaultUasItem();
        }
    }

    private void startOffscreenVideoConsumer() {
        try {
            if (UASToolDropDownReceiver.getReflector() != null) {
                this.mapImageMonitor = new GLVideoConsumer(UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(), UASToolDropDownReceiver.getReflector().usesYUVTexture());
            } else {
                this.mapImageMonitor = new GLVideoConsumer(UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(), false);
            }
        } catch (agl unused) {
            Log.e("UASFOVRenderer", "VideoConsumer init failed");
        }
        try {
            this.mapImageMonitor.start();
        } catch (GLVideoConsumer.VideoConsumerException unused2) {
            this.mapImageMonitor = null;
            Log.e("UASFOVRenderer", "VideoConsumer start failed");
        }
        UASToolDropDownReceiver.getInstance().getOffscreenDirector().a(this.mapImageMonitor);
    }

    private void stopOffscreenVideoConsumer() {
        UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(this.mapImageMonitor);
        this.mapImageMonitor.stop();
        this.mapImageMonitor = null;
    }

    public void run() {
        GLLayerFactory.a(GLSurfaceLayer.SPI);
        startOffscreenVideoConsumer();
        SurfaceLayer surfaceLayer = null;
        boolean z = false;
        while (!z && !Thread.interrupted()) {
            FieldOfView computeFov = this.currentUAS.computeFov();
            Bitmap currentBitmap = this.mapImageMonitor.getCurrentBitmap();
            if (surfaceLayer == null) {
                if (computeFov != null && computeFov.isValid() && currentBitmap != null && !currentBitmap.isRecycled()) {
                    surfaceLayer = new SurfaceLayer(UASToolDropDownReceiver.getInstance().getPluginContext(), computeFov, "UASFOVRenderer", currentBitmap);
                    MapView.getMapView().a(MapView.a.c, surfaceLayer);
                    AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.REFRESH_HIERARCHY"));
                }
            } else if (computeFov == null || !computeFov.isValid()) {
                surfaceLayer.setVisible(false);
            } else {
                surfaceLayer.update(computeFov, currentBitmap);
                surfaceLayer.setVisible(true);
            }
            if (currentBitmap != null) {
                currentBitmap.recycle();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (surfaceLayer != null) {
            MapView.getMapView().b(MapView.a.c, surfaceLayer);
            AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.REFRESH_HIERARCHY"));
        }
        stopOffscreenVideoConsumer();
        this.currentUAS = null;
        Log.d("UASVideoThread", "Thread Exited Normally!");
    }
}
