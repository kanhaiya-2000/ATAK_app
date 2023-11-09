package com.atakmap.android.uastool.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import atak.core.rd;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ae;
import com.atakmap.android.maps.af;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.coremap.log.Log;

public class GimbalLookReceiver extends BroadcastReceiver implements af.a {
    private static final String TAG = "GimbalLookReceiver";
    private final rd instructions = rd.a();
    private boolean isListening;

    public GimbalLookReceiver(Context context) {
    }

    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "handle gimbal look tasking");
        if (intent.getAction().equals("com.atakmap.android.uastool.GIMBAL_LOOK_TASKING")) {
            String stringExtra = intent.getStringExtra(UASTask.COTDETAIL_UID);
            Log.d(TAG, "UID = " + stringExtra);
        }
    }

    private void addMapListeners() {
        if (!this.isListening) {
            this.isListening = true;
            MapView.getMapView().getMapEventDispatcher().a();
            MapView.getMapView().getMapEventDispatcher().a("map_click");
            MapView.getMapView().getMapEventDispatcher().a("map_lngpress");
            MapView.getMapView().getMapEventDispatcher().a("item_click");
            MapView.getMapView().getMapEventDispatcher().a("item_lngpress");
            MapView.getMapView().getMapEventDispatcher().c("map_click", this);
            MapView.getMapView().getMapEventDispatcher().c("map_lngpress", this);
            MapView.getMapView().getMapEventDispatcher().c("item_click", this);
            MapView.getMapView().getMapEventDispatcher().c("item_lngpress", this);
            MapView.getMapView().getMapTouchController().d(true);
            rd.b().a("Tap the new SPI coordinate.");
        }
    }

    private void removeMapListeners() {
        if (this.isListening) {
            this.isListening = false;
            MapView.getMapView().getMapTouchController().d(false);
            MapView.getMapView().getMapEventDispatcher().c();
            MapView.getMapView().getMapEventDispatcher().b();
            rd.b().d();
        }
    }

    public void onMapEvent(ae aeVar) {
        removeMapListeners();
    }
}
