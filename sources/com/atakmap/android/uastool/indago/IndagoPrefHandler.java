package com.atakmap.android.uastool.indago;

import android.content.SharedPreferences;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;

public class IndagoPrefHandler extends PlatformPrefHandler {
    public static final String DEFAULT_SRC_IP = "224.100.10.10";
    public static final String DEFAULT_SRC_PORT = "3001";
    public static final String DEFAULT_VCT_IP = "10.1.0.4";
    public static final String DEFAULT_VCT_PORT = "9339";
    public static final String PREF_PREFIX_INDAGO = "indago.";
    public static final String PREF_SRC_ADAPTER = "uastool.indago.pref_src_adapter";
    public static final String PREF_SRC_IP = "uastool.indago.pref_src_ip";
    public static final String PREF_SRC_PORT = "uastool.indago.pref_src_port";
    public static final String PREF_VCT_IP = "uastool.indago.pref_indago_vct_ip";
    public static final String PREF_VCT_PORT = "uastool.indago.pref_indago_vct_port";

    public IndagoPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.startsWith("uastool.indago.");
    }

    public void destroy() {
        super.destroy();
    }
}
