package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.content.Intent;
import com.atakmap.android.maps.AbstractMapComponent;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.app.preferences.v;

public class UASToolPreferencesComponent extends AbstractMapComponent {
    public static final String ASSOCIATION_KEY = "UAS Tool Preference";
    public static final String SHOW_UASTOOL_PREFS = "com.atakmap.android.uastool.UASToolPreferencesComponent.SHOW_PREFS";

    /* access modifiers changed from: protected */
    public void onDestroyImpl(Context context, MapView mapView) {
    }

    public void onPause(Context context, MapView mapView) {
    }

    public void onResume(Context context, MapView mapView) {
    }

    public void onStart(Context context, MapView mapView) {
    }

    public void onStop(Context context, MapView mapView) {
    }

    public void onCreate(Context context, Intent intent, MapView mapView) {
        v.b(new v.a("UAS Tool Preferences", "Adjust the UAS Tool preferences", ASSOCIATION_KEY, context.getResources().getDrawable(C1877R.drawable.ic_launcher), new UASToolPreferenceFragment(context)));
    }
}
