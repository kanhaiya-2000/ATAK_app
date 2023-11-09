package com.atakmap.android.uastool.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;

public class WaypointSetReceiver extends BroadcastReceiver {
    private static final String TAG = "WaypointSetReceiver";
    private final MapView mMapView = MapView.getMapView();
    private final Context pluginContext;

    public WaypointSetReceiver(Context context) {
        this.pluginContext = context;
    }

    public void onReceive(Context context, Intent intent) {
        if (UASToolDropDownReceiver.getInstance() != null && UASToolDropDownReceiver.getInstance().getPlatformMonitor() != null) {
            UASToolDropDownReceiver.getInstance().getPlatformMonitor().onWaypointSetReceived();
        }
    }
}
