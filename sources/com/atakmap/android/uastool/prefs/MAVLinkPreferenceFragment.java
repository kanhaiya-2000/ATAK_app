package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import atak.core.ni;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.mavlink.MAVLinkMonitor;
import com.atakmap.android.uastool.mavlink.MAVLinkPrefHandler;
import com.atakmap.android.uastool.mavlink.MAVLinkUASItem;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.bbn.ccast.mavlink.MavLinkDialectInterface;
import com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle;

public class MAVLinkPreferenceFragment extends ni {
    private static Context staticPluginContext;
    private SharedPreferences sharedPrefs;

    public MAVLinkPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.mavlink);
    }

    public MAVLinkPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.mavlink);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        MAVLinkPreferenceFragment.super.onCreate((Bundle) null);
        this.sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        String[] networkDeviceList = NetworkPreferenceFragment.getNetworkDeviceList();
        ListPreference listPreference = (ListPreference) findPreference(MAVLinkPrefHandler.PREF_SRC_ADAPTER);
        listPreference.setEntries(networkDeviceList);
        listPreference.setEntryValues(networkDeviceList);
        MavlinkVehicle.NETWORK_TYPE[] values = MavlinkVehicle.NETWORK_TYPE.values();
        int length = values.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = values[i].name();
        }
        ListPreference listPreference2 = (ListPreference) findPreference(MAVLinkPrefHandler.PREF_MAVLINK_NETWORK_TYPE);
        listPreference2.setEntries(strArr);
        listPreference2.setEntryValues(strArr);
        ListPreference listPreference3 = (ListPreference) findPreference(MAVLinkPrefHandler.PREF_MAVLINK_DIALECT);
        listPreference3.setEntries(MavLinkDialectInterface.dialectType.names);
        listPreference3.setEntryValues(MavLinkDialectInterface.dialectType.names);
    }

    public void onDestroy() {
        MAVLinkPreferenceFragment.super.onDestroy();
    }

    /* renamed from: a */
    public String mo9977a() {
        return a("Tool Preferences", MAVLinkUASItem.DISPLAY_NAME);
    }

    public static void restartPlatformMonitor() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor instanceof MAVLinkMonitor) {
            ((MAVLinkMonitor) platformMonitor).restart();
        }
    }
}
