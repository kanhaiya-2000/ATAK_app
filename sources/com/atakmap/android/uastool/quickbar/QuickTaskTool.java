package com.atakmap.android.uastool.quickbar;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import atak.core.rd;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ae;
import com.atakmap.android.maps.af;
import com.atakmap.android.maps.av;
import com.atakmap.android.toolbar.b;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;

public class QuickTaskTool extends b implements af.a {
    public static String TAG = "QuickTaskTool";
    public static final String TOOL_NAME = "com.atakmap.android.uastool.quickbar.QuickTaskTool.TASK_PLACEMENT_TOOL";
    private static QuickTaskToolCallback mQuickTaskCallback;
    private boolean isClickBlocked;

    public interface QuickTaskToolCallback {
        void onTaskComplete(GeoPoint geoPoint);
    }

    public void dispose() {
    }

    public QuickTaskTool(MapView mapView) {
        super(mapView, TOOL_NAME);
    }

    public void onMapEvent(ae aeVar) {
        String a = aeVar.a();
        a.hashCode();
        char c = 65535;
        switch (a.hashCode()) {
            case -1967011492:
                if (a.equals("item_click")) {
                    c = 0;
                    break;
                }
                break;
            case -1853166651:
                if (a.equals("map_confirmed_click")) {
                    c = 1;
                    break;
                }
                break;
            case 1240553701:
                if (a.equals("map_click")) {
                    c = 2;
                    break;
                }
                break;
            case 1390310268:
                if (a.equals("item_confirmed_click")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (aeVar.b() instanceof av) {
                    av b = aeVar.b();
                    GeoPoint C = b.C();
                    String str = TAG;
                    Log.d(str, b.getMetaString(FlightLogger.LOG_CALLSIGN, "None") + " clicked Location: " + C.toString());
                    QuickTaskToolCallback quickTaskToolCallback = mQuickTaskCallback;
                    if (quickTaskToolCallback != null) {
                        quickTaskToolCallback.onTaskComplete(C);
                    }
                } else {
                    UASToolDropDownReceiver.toast("Could not determine of item clicked");
                    Log.d(TAG, "Could not determine of item clicked");
                }
                this.isClickBlocked = true;
                onToolEnd();
                aeVar.h().putBoolean("eventNotHandled", false);
                return;
            case 1:
                if (!this.isClickBlocked) {
                    Point d = aeVar.d();
                    GeoPoint geoPoint = this._mapView.inverse((float) d.x, (float) d.y).get();
                    String str2 = TAG;
                    Log.d(str2, "Map clicked Location: " + geoPoint.toString());
                    QuickTaskToolCallback quickTaskToolCallback2 = mQuickTaskCallback;
                    if (quickTaskToolCallback2 != null) {
                        quickTaskToolCallback2.onTaskComplete(geoPoint);
                    }
                    this.isClickBlocked = true;
                    onToolEnd();
                    return;
                }
                return;
            case 2:
                this.isClickBlocked = false;
                return;
            case 3:
                if (aeVar.b() instanceof av) {
                    aeVar.h().putBoolean("eventNotHandled", false);
                    return;
                } else {
                    aeVar.h().putBoolean("eventNotHandled", true);
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onToolBegin(Bundle bundle) {
        addMapListener();
        rd.b().a("Tap the map to place the action point.");
        return QuickTaskTool.super.onToolBegin(bundle);
    }

    /* access modifiers changed from: protected */
    public void onToolEnd() {
        rd.b().d();
        this._mapView.getMapEventDispatcher().b();
    }

    private void addMapListener() {
        this._mapView.getMapEventDispatcher().a();
        this._mapView.getMapEventDispatcher().a("item_lngpress");
        this._mapView.getMapEventDispatcher().a("map_lngpress");
        this._mapView.getMapEventDispatcher().a("map_click");
        this._mapView.getMapEventDispatcher().a("map_confirmed_click");
        this._mapView.getMapEventDispatcher().a("item_click");
        this._mapView.getMapEventDispatcher().a("item_dbltap");
        this._mapView.getMapEventDispatcher().c("item_click", this);
        this._mapView.getMapEventDispatcher().c("map_click", this);
        this._mapView.getMapEventDispatcher().c("map_confirmed_click", this);
        this._mapView.getMapEventDispatcher().c("item_dbltap", this);
        this._mapView.getMapEventDispatcher().c("item_confirmed_click", this);
        this._mapView.getMapEventDispatcher().c("item_lngpress", this);
    }

    public static void begin(QuickTaskToolCallback quickTaskToolCallback) {
        mQuickTaskCallback = quickTaskToolCallback;
        Intent intent = new Intent();
        intent.setAction("com.atakmap.android.maps.toolbar.BEGIN_TOOL");
        intent.putExtra("tool", TOOL_NAME);
        AtakBroadcast.a().a(intent);
    }

    public static void end() {
        Intent intent = new Intent();
        intent.setAction("com.atakmap.android.maps.toolbar.END_TOOL");
        intent.putExtra("tool", TOOL_NAME);
        AtakBroadcast.a().a(intent);
    }
}
