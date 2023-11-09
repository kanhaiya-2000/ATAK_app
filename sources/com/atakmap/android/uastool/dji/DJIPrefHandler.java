package com.atakmap.android.uastool.dji;

import android.content.SharedPreferences;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.coremap.log.Log;

public class DJIPrefHandler extends PlatformPrefHandler {
    public static final String PREF_PREFIX_DJI = "dji.";

    private DJIPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
        TAG = DJIPrefHandler.class.getSimpleName();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        String str2 = TAG;
        Log.d(str2, "onSharedPreferenceChanged: " + str);
        if (str.startsWith("uastool.dji.")) {
            String str3 = TAG;
            Log.d(str3, ".dji. pref changed: " + str);
        }
    }

    public void destroy() {
        super.destroy();
    }
}
