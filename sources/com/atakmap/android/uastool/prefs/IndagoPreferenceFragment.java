package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.os.Bundle;
import android.preference.ListPreference;
import atak.core.ni;
import com.atakmap.android.uastool.indago.IndagoPrefHandler;
import com.atakmap.android.uastool.indago.IndagoUASItem;
import com.atakmap.android.uastool.plugin.C1877R;

public class IndagoPreferenceFragment extends ni {
    private static Context staticPluginContext;

    public IndagoPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.f8657indago);
    }

    public IndagoPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.f8657indago);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        IndagoPreferenceFragment.super.onCreate((Bundle) null);
        String[] networkDeviceList = NetworkPreferenceFragment.getNetworkDeviceList();
        ListPreference listPreference = (ListPreference) findPreference(IndagoPrefHandler.PREF_SRC_ADAPTER);
        listPreference.setEntries(networkDeviceList);
        listPreference.setEntryValues(networkDeviceList);
    }

    public void onDestroy() {
        IndagoPreferenceFragment.super.onDestroy();
    }

    /* renamed from: a */
    public String mo9968a() {
        return a("Tool Preferences", IndagoUASItem.DISPLAY_NAME_SHORT);
    }
}
