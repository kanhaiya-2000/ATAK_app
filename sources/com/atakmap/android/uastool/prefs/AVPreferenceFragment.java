package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.os.Bundle;
import android.preference.ListPreference;
import atak.core.ni;
import com.atakmap.android.uastool.p000av.AvPrefHandler;
import com.atakmap.android.uastool.p000av.AvUASItem;
import com.atakmap.android.uastool.plugin.C1877R;

public class AVPreferenceFragment extends ni {
    private static Context staticPluginContext;

    public AVPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.f8409av);
    }

    public AVPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.f8409av);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        AVPreferenceFragment.super.onCreate((Bundle) null);
        String[] networkDeviceList = NetworkPreferenceFragment.getNetworkDeviceList();
        ListPreference listPreference = (ListPreference) findPreference(AvPrefHandler.PREF_SRC_ADAPTER);
        listPreference.setEntries(networkDeviceList);
        listPreference.setEntryValues(networkDeviceList);
    }

    public void onDestroy() {
        AVPreferenceFragment.super.onDestroy();
    }

    /* renamed from: a */
    public String mo9899a() {
        return a("Tool Preferences", AvUASItem.DISPLAY_NAME_SHORT);
    }
}
