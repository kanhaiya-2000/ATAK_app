package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.text.InputFilter;
import android.widget.EditText;
import atak.core.ni;
import com.atakmap.android.uastool.PD100.PD100PrefHandler;
import com.atakmap.android.uastool.PD100.PD100UASItem;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.NetworkPreferenceFragment;

public class PD100PreferenceFragment extends ni {
    private static Context staticPluginContext;

    public PD100PreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.pd100);
    }

    public PD100PreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.pd100);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        PD100PreferenceFragment.super.onCreate((Bundle) null);
        String[] networkDeviceList = NetworkPreferenceFragment.getNetworkDeviceList();
        ListPreference listPreference = (ListPreference) findPreference(PD100PrefHandler.PREF_SRC_ADAPTER);
        listPreference.setEntries(networkDeviceList);
        listPreference.setEntryValues(networkDeviceList);
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(PD100PrefHandler.PREF_SRC_IP);
        editTextPreference.getEditText().setFilters(new InputFilter[]{new NetworkPreferenceFragment.HostnameIpFilter()});
        EditText editText = editTextPreference.getEditText();
        Context context = staticPluginContext;
        editText.addTextChangedListener(new NetworkPreferenceFragment.HostOrIpWatcher(context, editTextPreference, context.getResources().getString(C1877R.string.pref_src_ip_sum)));
    }

    public void onDestroy() {
        PD100PreferenceFragment.super.onDestroy();
    }

    /* renamed from: a */
    public String mo9993a() {
        return a("Tool Preferences", PD100UASItem.DISPLAY_NAME);
    }
}
