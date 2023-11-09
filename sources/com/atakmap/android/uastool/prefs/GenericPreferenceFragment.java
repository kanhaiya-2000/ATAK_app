package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.text.InputFilter;
import android.widget.EditText;
import atak.core.ni;
import com.atakmap.android.uastool.generic.GenericPrefHandler;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.NetworkPreferenceFragment;

public class GenericPreferenceFragment extends ni {
    private static Context staticPluginContext;

    public GenericPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.generic);
    }

    public GenericPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.generic);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        GenericPreferenceFragment.super.onCreate((Bundle) null);
        String[] networkDeviceList = NetworkPreferenceFragment.getNetworkDeviceList();
        ListPreference listPreference = (ListPreference) findPreference(GenericPrefHandler.PREF_SRC_ADAPTER);
        listPreference.setEntries(networkDeviceList);
        listPreference.setEntryValues(networkDeviceList);
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(GenericPrefHandler.PREF_COT_DEST_IP);
        editTextPreference.getEditText().setFilters(new InputFilter[]{new NetworkPreferenceFragment.HostnameIpFilter()});
        EditText editText = editTextPreference.getEditText();
        Context context = staticPluginContext;
        editText.addTextChangedListener(new NetworkPreferenceFragment.HostOrIpWatcher(context, editTextPreference, context.getResources().getString(C1877R.string.pref_cot_dst_ip)));
    }

    public void onDestroy() {
        GenericPreferenceFragment.super.onDestroy();
    }

    /* renamed from: a */
    public String mo9959a() {
        return a("Tool Preferences", "Generic UAV");
    }
}
