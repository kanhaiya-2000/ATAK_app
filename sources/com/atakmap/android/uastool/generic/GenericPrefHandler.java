package com.atakmap.android.uastool.generic;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.utils.Utils;

public class GenericPrefHandler extends PlatformPrefHandler {
    public static final String PREF_COT_DEST_IP = "uastool.generic.pref_cot_dest_ip";
    public static final String PREF_COT_DEST_PORT = "uastool.generic.pref_cot_dest_port";
    public static final String PREF_PREFIX_GENERIC = "generic.";
    public static final String PREF_SRC_ADAPTER = "uastool.generic.pref_src_adapter";
    public static final String PREF_SRC_IP = "uastool.generic.pref_src_ip";
    public static final String PREF_SRC_PORT = "uastool.generic.pref_src_port";
    public static final String PREF_VIDEO_SRC_URI = "uastool.generic.pref_src_uri";

    public GenericPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith("uastool.generic.")) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1125756713:
                    if (str.equals(PREF_COT_DEST_IP)) {
                        c = 0;
                        break;
                    }
                    break;
                case 479768625:
                    if (str.equals(PREF_COT_DEST_PORT)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1343741499:
                    if (str.equals(PREF_VIDEO_SRC_URI)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1847311518:
                    if (str.equals(PREF_SRC_ADAPTER)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    videoSourceURIChanged(sharedPreferences.getString(PREF_VIDEO_SRC_URI, (String) null));
                    break;
                case 3:
                    videoSourceAdapterChanged(sharedPreferences.getString(PREF_SRC_ADAPTER, (String) null));
                    return;
                default:
                    return;
            }
            cotDestinationIpChanged(sharedPreferences.getString(PREF_COT_DEST_IP, (String) null));
            cotDestinationPortChanged(sharedPreferences.getString(PREF_COT_DEST_PORT, (String) null));
        }
    }

    private void videoSourceAdapterChanged(String str) {
        ((ListPreference) this.prefFragment.findPreference(PREF_SRC_ADAPTER)).setValue(str);
    }

    private void videoSourceIpChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_SRC_IP)).setText(str);
    }

    private void videoSourcePortChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_SRC_PORT)).setText(str);
    }

    private void videoSourceURIChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_VIDEO_SRC_URI)).setText(str);
    }

    private void cotDestinationIpChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_COT_DEST_IP)).setText(str);
    }

    private void cotDestinationPortChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_COT_DEST_PORT)).setText(str);
    }

    public static void checkUpdatePref(SharedPreferences sharedPreferences) {
        if (sharedPreferences.contains(PREF_SRC_IP)) {
            String string = sharedPreferences.getString(PREF_SRC_IP, "");
            int parseInt = Utils.parseInt(sharedPreferences.getString(PREF_SRC_PORT, "0"), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(PREF_SRC_PORT);
            edit.remove(PREF_SRC_IP);
            edit.putString(PREF_VIDEO_SRC_URI, "udp://" + string + ":" + parseInt);
            edit.apply();
        }
    }

    public void destroy() {
        super.destroy();
    }
}
