package com.atakmap.android.uastool.p000av;

import android.content.SharedPreferences;
import android.preference.ListPreference;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;

/* renamed from: com.atakmap.android.uastool.av.AvPrefHandler */
public class AvPrefHandler extends PlatformPrefHandler {
    public static final String PREF_PREFIX_AV = "av.";
    public static final String PREF_SRC_ADAPTER = "uastool.av.pref_src_adapter";

    public AvPrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith("uastool.av.") && str.equals(PREF_SRC_ADAPTER)) {
            videoSourceAdapterChanged(sharedPreferences.getString(PREF_SRC_ADAPTER, (String) null));
        }
    }

    private void videoSourceAdapterChanged(String str) {
        ((ListPreference) this.prefFragment.findPreference(PREF_SRC_ADAPTER)).setValue(str);
    }

    public void destroy() {
        super.destroy();
    }
}
