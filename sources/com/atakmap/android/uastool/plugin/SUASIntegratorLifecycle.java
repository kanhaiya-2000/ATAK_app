package com.atakmap.android.uastool.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.aa;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.prefs.UASToolPreferencesComponent;
import com.atakmap.coremap.log.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import transapps.maps.plugin.lifecycle.Lifecycle;

public class SUASIntegratorLifecycle implements Lifecycle {
    private static final String TAG = "SUASIntegratorLifecycle";
    private MapView mapView = null;
    private final Collection<aa> overlays = new LinkedList();
    private final Context pluginContext;

    public void onFinish() {
    }

    public SUASIntegratorLifecycle(Context context) {
        this.pluginContext = context;
        PluginNativeLoader.init(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (aa onConfigurationChanged : this.overlays) {
            onConfigurationChanged.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Activity activity, transapps.mapi.MapView mapView2) {
        if (mapView2 == null || !(mapView2.getView() instanceof MapView)) {
            Log.w(TAG, "This plugin is only compatible with ATAK MapView");
            return;
        }
        this.mapView = mapView2.getView();
        this.overlays.add(SUASIntegratorMapComponent.getInstance());
        this.overlays.add(new UASToolPreferencesComponent());
        Iterator<aa> it = this.overlays.iterator();
        while (it.hasNext()) {
            try {
                it.next().onCreate(this.pluginContext, activity.getIntent(), this.mapView);
            } catch (Exception e) {
                Log.w(TAG, "Unhandled exception trying to create overlays MapComponent", e);
                it.remove();
            }
        }
    }

    public void onDestroy() {
        for (aa onDestroy : this.overlays) {
            onDestroy.onDestroy(this.pluginContext, this.mapView);
        }
    }

    public void onPause() {
        for (aa onPause : this.overlays) {
            onPause.onPause(this.pluginContext, this.mapView);
        }
    }

    public void onResume() {
        for (aa onResume : this.overlays) {
            onResume.onResume(this.pluginContext, this.mapView);
        }
    }

    public void onStart() {
        for (aa onStart : this.overlays) {
            onStart.onStart(this.pluginContext, this.mapView);
        }
    }

    public void onStop() {
        for (aa onStop : this.overlays) {
            onStop.onStop(this.pluginContext, this.mapView);
        }
    }
}
