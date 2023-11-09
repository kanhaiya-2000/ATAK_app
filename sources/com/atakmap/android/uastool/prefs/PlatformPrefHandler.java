package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.atakmap.android.maps.MapView;

public abstract class PlatformPrefHandler implements SharedPreferences.OnSharedPreferenceChangeListener {
    protected static String TAG = "PlatformPrefHandler";
    protected Context pluginContext;
    protected final UASToolPreferenceFragment prefFragment;
    private final SharedPreferences sharedPrefs;

    public abstract void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str);

    protected PlatformPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        this.prefFragment = uASToolPreferenceFragment;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
        this.sharedPrefs = defaultSharedPreferences;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public void destroy() {
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this);
    }
}
