package com.atakmap.android.uastool.PD100;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import com.atakmap.android.uastool.prefs.PlatformPrefHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;

public class PD100PrefHandler extends PlatformPrefHandler {
    public static final String PREF_COT_TCP_PORT = "uastool.pd100.pref_pd100_cot_tcp_port";
    public static final String PREF_COT_UDP_PORT = "uastool.pd100.pref_pd100_cot_udp_port";
    public static final String PREF_PREFIX_PD100 = "pd100.";
    public static final String PREF_SRC_ADAPTER = "uastool.pd100.pref_src_adapter";
    public static final String PREF_SRC_IP = "uastool.pd100.pref_src_ip";
    public static final String PREF_SRC_PORT = "uastool.pd100.pref_src_port";

    public PD100PrefHandler(UASToolPreferenceFragment uASToolPreferenceFragment) {
        super(uASToolPreferenceFragment);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith("uastool.pd100.")) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -2113803116:
                    if (str.equals(PREF_COT_UDP_PORT)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1683607304:
                    if (str.equals(PREF_SRC_PORT)) {
                        c = 1;
                        break;
                    }
                    break;
                case -475389064:
                    if (str.equals(PREF_SRC_ADAPTER)) {
                        c = 2;
                        break;
                    }
                    break;
                case -449149836:
                    if (str.equals(PREF_COT_TCP_PORT)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1964726110:
                    if (str.equals(PREF_SRC_IP)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    cotUdpPortChanged(sharedPreferences.getString(PREF_COT_UDP_PORT, (String) null));
                    return;
                case 1:
                    videoSourcePortChanged(sharedPreferences.getString(PREF_SRC_PORT, (String) null));
                    return;
                case 2:
                    videoSourceAdapterChanged(sharedPreferences.getString(PREF_SRC_ADAPTER, (String) null));
                    return;
                case 3:
                    cotTcpPortChanged(sharedPreferences.getString(PREF_COT_TCP_PORT, (String) null));
                    return;
                case 4:
                    videoSourceIpChanged(sharedPreferences.getString(PREF_SRC_IP, (String) null));
                    return;
                default:
                    return;
            }
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

    private void cotUdpPortChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_COT_UDP_PORT)).setText(str);
    }

    private void cotTcpPortChanged(String str) {
        ((EditTextPreference) this.prefFragment.findPreference(PREF_COT_TCP_PORT)).setText(str);
    }

    public void destroy() {
        super.destroy();
    }
}
