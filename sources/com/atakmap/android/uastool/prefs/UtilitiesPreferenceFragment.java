package com.atakmap.android.uastool.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import atak.core.ni;
import com.atakmap.android.gui.PanEditTextPreference;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;

public class UtilitiesPreferenceFragment extends ni {
    public static final String DEFAULT_DANGER_LOW_ALT = "23";
    public static final String PREF_CAPTURE_TO_STORAGE = "uastool.pref_capture_to_storage";
    public static final String PREF_DANGER_LOW_ALT = "uastool.pref_agl_danger_low";
    public static final String PREF_DANGER_LOW_ALT_INPUT = "uastool.pref_agl_danger_low_input";
    public static final String PREF_LOG_FLIGHT_DATA = "uastool.pref_log_flight_data";
    public static Context staticPluginContext;
    private final SharedPreferences.OnSharedPreferenceChangeListener prefChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            str.hashCode();
            if (str.equals(AtakPrefConstants.ALT_UNIT_PREF) || str.equals(UtilitiesPreferenceFragment.PREF_DANGER_LOW_ALT_INPUT)) {
                UtilitiesPreferenceFragment.this.updateOnDangerLowChanged();
            }
        }
    };
    private SharedPreferences sharedPrefs;

    public UtilitiesPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.utilities_prefs);
    }

    public UtilitiesPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.utilities_prefs);
        staticPluginContext = context;
        SharedPreferences sharedPrefs2 = UASToolDropDownReceiver.getSharedPrefs();
        this.sharedPrefs = sharedPrefs2;
        SharedPreferences.Editor edit = sharedPrefs2.edit();
        String string = this.sharedPrefs.getString(PREF_DANGER_LOW_ALT, DEFAULT_DANGER_LOW_ALT);
        findPreference(PREF_DANGER_LOW_ALT_INPUT);
        if (UASToolDropDownReceiver.getAltitudeUnits().getType() != 1) {
            try {
                edit.putString(PREF_DANGER_LOW_ALT_INPUT, String.format("%.0f", new Object[]{Double.valueOf(Double.parseDouble(string) * 3.280839895d)}));
            } catch (Exception unused) {
            }
        } else {
            edit.putString(PREF_DANGER_LOW_ALT_INPUT, string);
        }
        edit.apply();
    }

    public void onCreate(Bundle bundle) {
        UtilitiesPreferenceFragment.super.onCreate((Bundle) null);
        String string = this.sharedPrefs.getString(PREF_DANGER_LOW_ALT, DEFAULT_DANGER_LOW_ALT);
        PanEditTextPreference findPreference = findPreference(PREF_DANGER_LOW_ALT_INPUT);
        if (UASToolDropDownReceiver.getAltitudeUnits().getType() != 1) {
            try {
                findPreference.setSummary(String.format("Alert when sending a task if UAS will go below %.0fft AGL", new Object[]{Double.valueOf(Double.parseDouble(string) * 3.280839895d)}));
                findPreference.setTitle("Danger Low Altitude in feet AGL");
                findPreference.setDialogTitle("Danger Low Altitude in Feet AGL");
            } catch (Exception unused) {
            }
        } else {
            findPreference.setSummary(String.format("Alert when sending a task if UAS will go below %sm AGL", new Object[]{string}));
            findPreference.setTitle("Danger Low Altitude in meters AGL");
            findPreference.setDialogTitle("Danger Low Altitude in meters AGL");
        }
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this.prefChangeListener);
    }

    /* access modifiers changed from: private */
    public void updateOnDangerLowChanged() {
        String string = this.sharedPrefs.getString(PREF_DANGER_LOW_ALT_INPUT, DEFAULT_DANGER_LOW_ALT);
        SharedPreferences.Editor edit = this.sharedPrefs.edit();
        PanEditTextPreference findPreference = findPreference(PREF_DANGER_LOW_ALT_INPUT);
        if (UASToolDropDownReceiver.getAltitudeUnits().getType() != 1) {
            try {
                double parseDouble = Double.parseDouble(string);
                edit.putString(PREF_DANGER_LOW_ALT, String.format("%.0f", new Object[]{Double.valueOf(0.3048d * parseDouble)}));
                findPreference.setSummary(String.format("Alert when sending a task if UAS will go below %.0fft AGL", new Object[]{Double.valueOf(parseDouble)}));
                findPreference.setTitle("Danger Low Altitude in feet AGL");
                findPreference.setDialogTitle("Danger Low Altitude in Feet AGL");
            } catch (Exception e) {
                Log.d("PluginPreferenceFragment", "Error setting Altitude", e);
            }
        } else {
            edit.putString(PREF_DANGER_LOW_ALT, string);
            findPreference.setSummary(String.format("Alert when sending a task if UAS will go below %sm AGL", new Object[]{string}));
            findPreference.setTitle("Danger Low Altitude in meters AGL");
            findPreference.setDialogTitle("Danger Low Altitude in meters AGL");
        }
        edit.apply();
    }

    public void onDestroy() {
        UtilitiesPreferenceFragment.super.onDestroy();
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this.prefChangeListener);
    }
}
