package com.atakmap.android.uastool.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import atak.core.rd;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ae;
import com.atakmap.android.maps.af;
import com.atakmap.android.maps.ai;
import com.atakmap.android.routes.RouteMapReceiver;
import com.atakmap.android.routes.e;
import com.atakmap.coremap.log.Log;

public class AddRouteReceiver extends BroadcastReceiver implements af.a {
    private static final String TAG = "AddRouteReceiver";
    private boolean isListening;

    public AddRouteReceiver(Context context) {
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("com.atakmap.android.uastool.ADD_ROUTE")) {
            addMapListeners();
        }
    }

    private synchronized void addMapListeners() {
        if (!this.isListening) {
            this.isListening = true;
            af mapEventDispatcher = MapView.getMapView().getMapEventDispatcher();
            mapEventDispatcher.a();
            mapEventDispatcher.a("map_click");
            mapEventDispatcher.a("map_lngpress");
            mapEventDispatcher.a("item_click");
            mapEventDispatcher.a("item_lngpress");
            mapEventDispatcher.c("map_click", this);
            mapEventDispatcher.c("map_lngpress", this);
            mapEventDispatcher.c("item_click", this);
            mapEventDispatcher.c("item_lngpress", this);
            MapView.getMapView().getMapTouchController().d(true);
            rd.b().a("Select a Route Item on the map");
        }
    }

    private synchronized void removeMapListeners() {
        if (this.isListening) {
            this.isListening = false;
            MapView.getMapView().getMapTouchController().d(false);
            MapView.getMapView().getMapEventDispatcher().c();
            MapView.getMapView().getMapEventDispatcher().b();
            rd.b().d();
        }
    }

    public void onMapEvent(ae aeVar) {
        String str;
        String metaString;
        ai b = aeVar.b();
        if (b instanceof e) {
            str = b.getUID();
        } else {
            str = b.getMetaString("parent_route_uid", (String) null);
            if (str != null) {
                b = MapView.getMapView().a(str);
                Log.d(TAG, "found a parent_route_uid");
            }
        }
        if (str != null && !str.isEmpty() && (metaString = b.getMetaString("title", (String) null)) != null) {
            RouteMapReceiver.a().c(metaString);
            removeMapListeners();
        }
    }
}
