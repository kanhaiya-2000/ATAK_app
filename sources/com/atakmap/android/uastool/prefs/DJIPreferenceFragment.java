package com.atakmap.android.uastool.prefs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.view.ViewGroup;
import android.widget.ListView;
import atak.core.ni;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.AtakGoServiceConnection;
import com.atakmap.android.uastool.dji.DJIMonitor;
import com.atakmap.android.uastool.dji.DJIUASItem;
import com.atakmap.android.uastool.plugin.C1877R;

public class DJIPreferenceFragment extends ni {
    private static final int DEFAULT_RC_MODE = 2;
    public static final String DJIBUTTONS_PREF_C1 = "uastool.djibuttons.saved_c1";
    public static final String DJIBUTTONS_PREF_C2 = "uastool.djibuttons.saved_c2";
    public static final String DJIBUTTONS_PREF_FIVEDDOWN = "uastool.djibuttons.saved_fiveDDown";
    public static final String DJIBUTTONS_PREF_FIVEDIN = "uastool.djibuttons.saved_fiveDIn";
    public static final String DJIBUTTONS_PREF_FIVEDLEFT = "uastool.djibuttons.saved_fiveDLeft";
    public static final String DJIBUTTONS_PREF_FIVEDRIGHT = "uastool.djibuttons.saved_fiveDRight";
    public static final String DJIBUTTONS_PREF_FIVEDUP = "uastool.djibuttons.saved_fiveDUp";
    public static final String DJIPREF_LDM_MODE = "uastool.dji.pref_ldm_mode";
    public static final Boolean DJIPREF_LDM_MODE_DEFAULT = true;
    public static final String DJIPREF_RCSTICK_MODE = "uastool.dji.pref_rc_mode";
    public static final String DJIPREF_SPEAKER_SOUNDNAME = "uastool.dji.pref_speaker_soundname";
    private static final SharedPreferences.OnSharedPreferenceChangeListener prefChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            str.hashCode();
            if (str.equals(DJIPreferenceFragment.DJIPREF_LDM_MODE)) {
                DJIPreferenceFragment.setLDMMode(sharedPreferences.getBoolean(str, DJIPreferenceFragment.DJIPREF_LDM_MODE_DEFAULT.booleanValue()));
            } else if (str.equals(DJIPreferenceFragment.DJIPREF_RCSTICK_MODE)) {
                DJIPreferenceFragment.setRCStickMode(sharedPreferences.getString(str, DJI_RCSTICK_MODE.getDefaultMode().modeName));
            }
        }
    };
    public static AlertDialog rcStickModeDialog;
    private static SharedPreferences sharedPrefs;
    public static Context staticPluginContext;

    public enum DJI_RCSTICK_MODE {
        MODE01(1, "Mode 1", C1877R.drawable.dji_rc_mode01),
        MODE02(2, "Mode 2", C1877R.drawable.dji_rc_mode02),
        MODE03(3, "Mode 3", C1877R.drawable.dji_rc_mode03);
        
        private final int modeDrawableId;
        /* access modifiers changed from: private */
        public final String modeName;
        private final int modeType;

        private DJI_RCSTICK_MODE(int i, String str, int i2) {
            this.modeType = i;
            this.modeName = str;
            this.modeDrawableId = i2;
        }

        public int getModeType() {
            return this.modeType;
        }

        public String getModeName() {
            return this.modeName;
        }

        public int getModeDrawableId() {
            return this.modeDrawableId;
        }

        public static DJI_RCSTICK_MODE getDefaultMode() {
            return MODE02;
        }

        public String toString() {
            return this.modeName;
        }

        public static DJI_RCSTICK_MODE fromString(String str) {
            if (str == null) {
                return null;
            }
            for (DJI_RCSTICK_MODE dji_rcstick_mode : values()) {
                if (dji_rcstick_mode.modeName.equalsIgnoreCase(str)) {
                    return dji_rcstick_mode;
                }
            }
            return null;
        }

        public static DJI_RCSTICK_MODE fromType(int i) {
            if (i < 0) {
                return null;
            }
            for (DJI_RCSTICK_MODE dji_rcstick_mode : values()) {
                if (dji_rcstick_mode.modeType == i) {
                    return dji_rcstick_mode;
                }
            }
            return null;
        }
    }

    public DJIPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.dji);
    }

    public DJIPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.dji);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        DJIPreferenceFragment.super.onCreate((Bundle) null);
        sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        findPreference(DJIPREF_RCSTICK_MODE).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                DJIPreferenceFragment.this.showRCStickModes();
                return true;
            }
        });
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference(DJIPREF_LDM_MODE);
        checkBoxPreference.setSummary(C1877R.string.dji_pref_ldm_sum);
        checkBoxPreference.setEnabled(true);
        checkBoxPreference.setChecked(sharedPrefs.getBoolean(DJIPREF_LDM_MODE, DJIPREF_LDM_MODE_DEFAULT.booleanValue()));
        sharedPrefs.registerOnSharedPreferenceChangeListener(prefChangeListener);
    }

    private static void toast(String str) {
        UASToolDropDownReceiver.toast(str);
    }

    public void showRCStickModes() {
        hideRCStickModes();
        AlertDialog.Builder builder = new AlertDialog.Builder(getView().getContext());
        builder.setTitle("RC Joystick Mode");
        ListView listView = new ListView(this.g);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        listView.setAdapter(new RCStickModeAdapter(this.g, DJI_RCSTICK_MODE.fromString(sharedPrefs.getString(DJIPREF_RCSTICK_MODE, DJI_RCSTICK_MODE.getDefaultMode().modeName))));
        builder.setView(listView);
        AlertDialog create = builder.create();
        rcStickModeDialog = create;
        create.show();
    }

    public static void hideRCStickModes() {
        AlertDialog alertDialog = rcStickModeDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static void setRCStickMode(String str) {
        int i = 1;
        while (true) {
            if (i >= DJI_RCSTICK_MODE.values().length + 1) {
                i = 2;
                break;
            }
            DJI_RCSTICK_MODE fromType = DJI_RCSTICK_MODE.fromType(i);
            if (fromType != null && fromType.modeName.equals(str)) {
                break;
            }
            i++;
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.setRcMode(i);
        }
    }

    public static void setLDMMode(boolean z) {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.register();
        }
    }

    public void onDestroy() {
        DJIPreferenceFragment.super.onDestroy();
        sharedPrefs.unregisterOnSharedPreferenceChangeListener(prefChangeListener);
    }

    /* renamed from: a */
    public String mo9949a() {
        return a("Tool Preferences", DJIUASItem.DISPLAY_NAME);
    }
}
