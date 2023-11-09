package com.atakmap.android.uastool.mavlink;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import com.atakmap.android.uastool.prefs.MAVLinkPreferenceFragment;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;

public class MAVLinkPrefHandler extends PlatformPrefHandler {
    public static final String DEFAULT_MAVLINK_DIALECT = "AUTO";
    public static final String DEFAULT_MAVLINK_NETWORK_TYPE = "UDP";
    public static final String DEFAULT_PLATFORM_MAVLINK_IP = "127.0.0.1";
    public static final String DEFAULT_PLATFORM_MAVLINK_PORT = "14550";
    public static final int DEFAULT_VIDEO_ACTIVE_URI = 1;
    public static final String DEFAULT_VIDEO_SRC_URI = "rtp://0.0.0.0:5600";
    public static final String DEFAULT_VIDEO_SRC_URI2 = "";
    public static final boolean DEFUALT_MAVLINK_JOYSTICK_DECAY = false;
    public static final boolean DEFUALT_MAVLINK_JOYSTICK_ENABLE = true;
    public static final String PREF_MAVLINK_DIALECT = "uastool.mavlink.pref_dialect";
    public static final String PREF_MAVLINK_JOYSTICK_DECAY = "uastool.mavlink.pref_joystick_decay";
    public static final String PREF_MAVLINK_JOYSTICK_ENABLE = "uastool.mavlink.pref_joystick_enable";
    public static final String PREF_MAVLINK_NETWORK_TYPE = "uastool.mavlink.pref_network_type";
    public static final String PREF_PLATFORM_MAVLINK_IP = "uastool.mavlink.pref_platform_ip";
    public static final String PREF_PLATFORM_MAVLINK_PORT = "uastool.mavlink.pref_platform_port";
    public static final String PREF_PREFIX = "mavlink.";
    public static final String PREF_SRC_ADAPTER = "uastool.mavlink.pref_src_adapter";
    public static final String PREF_VIDEO_ACTIVE_URI = "uastool.mavlink.pref_active_uri";
    public static final String PREF_VIDEO_SRC_URI = "uastool.mavlink.pref_src_uri";
    public static final String PREF_VIDEO_SRC_URI2 = "uastool.mavlink.pref_src_uri2";

    public MAVLinkPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith("uastool.mavlink.")) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1912707300:
                    if (str.equals(PREF_VIDEO_SRC_URI2)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1718322837:
                    if (str.equals(PREF_MAVLINK_DIALECT)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1194662830:
                    if (str.equals(PREF_PLATFORM_MAVLINK_PORT)) {
                        c = 2;
                        break;
                    }
                    break;
                case -1108497223:
                    if (str.equals(PREF_SRC_ADAPTER)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1096214216:
                    if (str.equals(PREF_PLATFORM_MAVLINK_IP)) {
                        c = 4;
                        break;
                    }
                    break;
                case -1031531562:
                    if (str.equals(PREF_VIDEO_SRC_URI)) {
                        c = 5;
                        break;
                    }
                    break;
                case 201747078:
                    if (str.equals(PREF_MAVLINK_NETWORK_TYPE)) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    videoSourceUriChanged2(sharedPreferences.getString(PREF_VIDEO_SRC_URI2, (String) null));
                    return;
                case 1:
                    platformDialectChanged(sharedPreferences.getString(PREF_MAVLINK_DIALECT, (String) null));
                    MAVLinkPreferenceFragment.restartPlatformMonitor();
                    return;
                case 2:
                    platformPortChanged(sharedPreferences.getString(PREF_PLATFORM_MAVLINK_PORT, DEFAULT_PLATFORM_MAVLINK_PORT));
                    MAVLinkPreferenceFragment.restartPlatformMonitor();
                    return;
                case 3:
                    videoSourceAdapterChanged(sharedPreferences.getString(PREF_SRC_ADAPTER, (String) null));
                    return;
                case 4:
                    platformIpChanged(sharedPreferences.getString(PREF_PLATFORM_MAVLINK_IP, "127.0.0.1"));
                    MAVLinkPreferenceFragment.restartPlatformMonitor();
                    return;
                case 5:
                    videoSourceUriChanged(sharedPreferences.getString(PREF_VIDEO_SRC_URI, DEFAULT_VIDEO_SRC_URI));
                    return;
                case 6:
                    platformNetworkTypeChanged(sharedPreferences.getString(PREF_MAVLINK_NETWORK_TYPE, DEFAULT_MAVLINK_NETWORK_TYPE));
                    MAVLinkPreferenceFragment.restartPlatformMonitor();
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

    private void videoSourceUriChanged2(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_VIDEO_SRC_URI2)).setText(str);
    }

    private void platformPortChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_PLATFORM_MAVLINK_PORT)).setText(str);
    }

    private void platformIpChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_PLATFORM_MAVLINK_IP)).setText(str);
    }

    private void platformNetworkTypeChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_MAVLINK_NETWORK_TYPE)).setText(str);
    }

    private void platformDialectChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_MAVLINK_DIALECT)).setText(str);
    }

    public void destroy() {
        super.destroy();
    }
}
