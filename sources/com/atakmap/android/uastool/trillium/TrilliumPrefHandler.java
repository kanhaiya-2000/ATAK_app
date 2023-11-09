package com.atakmap.android.uastool.trillium;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;

public class TrilliumPrefHandler extends PlatformPrefHandler {
    public static final String DEFAULT_PLATFORM_TRILLIUM_IP = "127.0.0.1";
    public static final String DEFAULT_PLATFORM_TRILLIUM_PORT = "5760";
    public static final String DEFAULT_PLATFORM_TRILLIUM_VIDEO_BUFFERING = "500";
    public static final String PREF_CORNERS_SRC = "uastool.trillium.pref_video_corners_source";
    public static final String PREF_PLATFORM_TRILLIUM_IP = "uastool.trillium.pref_platform_ip";
    public static final String PREF_PLATFORM_TRILLIUM_PORT = "uastool.trillium.pref_platform_port";
    public static final String PREF_PLATFORM_TRILLIUM_VIDEO_BUFFERING = "uastool.trillium.pref_video_buffering";
    public static final String PREF_PREFIX = "trillium.";
    public static final String PREF_SRC_ADAPTER = "uastool.trillium.pref_src_adapter";
    public static final String PREF_VIDEO_SRC_URI = "uastool.trillium.pref_src_uri";

    public TrilliumPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith("uastool.trillium.")) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1268970765:
                    if (str.equals(PREF_CORNERS_SRC)) {
                        c = 0;
                        break;
                    }
                    break;
                case -978455106:
                    if (str.equals(PREF_VIDEO_SRC_URI)) {
                        c = 1;
                        break;
                    }
                    break;
                case 535815435:
                    if (str.equals(PREF_PLATFORM_TRILLIUM_VIDEO_BUFFERING)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1139652666:
                    if (str.equals(PREF_PLATFORM_TRILLIUM_PORT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1946442401:
                    if (str.equals(PREF_SRC_ADAPTER)) {
                        c = 4;
                        break;
                    }
                    break;
                case 1958725408:
                    if (str.equals(PREF_PLATFORM_TRILLIUM_IP)) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    cornersSourceChanged(sharedPreferences.getString(PREF_CORNERS_SRC, (String) null));
                    return;
                case 1:
                    videoSourceUriChanged(sharedPreferences.getString(PREF_VIDEO_SRC_URI, (String) null));
                    return;
                case 2:
                    videoBufferingChanged(sharedPreferences.getString(PREF_PLATFORM_TRILLIUM_VIDEO_BUFFERING, (String) null));
                    return;
                case 3:
                    platformPortChanged(sharedPreferences.getString(PREF_PLATFORM_TRILLIUM_PORT, (String) null));
                    return;
                case 4:
                    videoSourceAdapterChanged(sharedPreferences.getString(PREF_SRC_ADAPTER, (String) null));
                    return;
                case 5:
                    platformIpChanged(sharedPreferences.getString(PREF_PLATFORM_TRILLIUM_IP, (String) null));
                    return;
                default:
                    return;
            }
        }
    }

    private void videoSourceAdapterChanged(String str) {
        ((ListPreference) this.prefFragment.findPreference(PREF_SRC_ADAPTER)).setValue(str);
    }

    private void videoSourceUriChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_VIDEO_SRC_URI)).setText(str);
    }

    private void platformPortChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_PLATFORM_TRILLIUM_PORT)).setText(str);
    }

    private void platformIpChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_PLATFORM_TRILLIUM_IP)).setText(str);
    }

    private void videoBufferingChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_PLATFORM_TRILLIUM_VIDEO_BUFFERING)).setText(str);
    }

    private void cornersSourceChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_CORNERS_SRC)).setText(str);
    }

    public void destroy() {
        super.destroy();
    }
}
