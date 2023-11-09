package com.atakmap.android.uastool.r80d;

import android.content.SharedPreferences;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;

public class R80dPrefHandler extends PlatformPrefHandler {
    public static final String DEFAULT_VIDEO_ID = "frontcam";
    public static final String DEFAULT_VIDEO_URI = "rtsp://192.168.3.108:8552/frontcam";
    public static final String PREF_PLATFORM_SERIAL = "uastool.r80d.pref_platform_serial";
    public static final String PREF_PREFIX_R80D = "r80d.";
    public static final String PREF_VIDEO_ID = "uastool.r80d.pref_video_id";
    public static final String PREF_VIDEO_URI = "uastool.r80d.pref_video_uri";

    public R80dPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.startsWith("uastool.r80d.");
    }

    public void destroy() {
        super.destroy();
    }
}
