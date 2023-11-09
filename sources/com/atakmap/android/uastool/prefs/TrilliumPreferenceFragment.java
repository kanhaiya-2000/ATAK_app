package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.os.Bundle;
import android.preference.ListPreference;
import atak.core.ni;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.trillium.TrilliumPrefHandler;
import com.atakmap.android.uastool.trillium.TrilliumUASItem;

public class TrilliumPreferenceFragment extends ni {
    private static Context staticPluginContext;

    public TrilliumPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.trillium);
    }

    public TrilliumPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.trillium);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        TrilliumPreferenceFragment.super.onCreate((Bundle) null);
        String[] networkDeviceList = NetworkPreferenceFragment.getNetworkDeviceList();
        ListPreference listPreference = (ListPreference) findPreference(TrilliumPrefHandler.PREF_SRC_ADAPTER);
        listPreference.setEntries(networkDeviceList);
        listPreference.setEntryValues(networkDeviceList);
        String[] strArr = {TrilliumUASItem.DISPLAY_NAME, "UASTool"};
        ListPreference listPreference2 = (ListPreference) findPreference(TrilliumPrefHandler.PREF_CORNERS_SRC);
        listPreference2.setEntries(strArr);
        listPreference2.setEntryValues(strArr);
    }

    public void onDestroy() {
        TrilliumPreferenceFragment.super.onDestroy();
    }

    /* renamed from: a */
    public String mo9998a() {
        return a("Tool Preferences", "Trillium/Orion Settings");
    }
}
