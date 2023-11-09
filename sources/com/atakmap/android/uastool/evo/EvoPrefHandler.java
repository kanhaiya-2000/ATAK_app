package com.atakmap.android.uastool.evo;

import android.content.SharedPreferences;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;

public class EvoPrefHandler extends PlatformPrefHandler {
    public static final String PREF_PREFIX = "evo.";

    public EvoPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith("uastool.evo.")) {
            str.getClass();
        }
    }

    public void destroy() {
        super.destroy();
    }
}
