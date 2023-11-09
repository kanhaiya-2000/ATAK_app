package com.atakmap.android.uastool.prefs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.widget.SeekBar;
import atak.core.ni;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CameraPreferenceFragment extends ni {
    public static final int AR_ONLY = 2;
    public static final int DEFAULT_MAX_OPEN_MAPSHOTS = 10;
    public static final boolean DEFAULT_OBJECTDETECTION_MAPSHOT = false;
    public static final boolean DEFAULT_OBJECTDETECTION_VIBRATE = false;
    public static final int HUD_AND_AR = 0;
    public static final int HUD_ONLY = 1;
    public static final int MAX_MAX_OPEN_MAPSHOTS = 20;
    public static final int MIN_MAX_OPEN_MAPSHOTS = 1;
    public static final int NO_HUD_NO_AR = 3;
    public static final String PREF_CAMERA_FOV_OVERIDE_HORIZONTAL = "uastool.pref_fov_override_horizontal";
    public static final String PREF_CAMERA_FOV_OVERIDE_MODE = "uastool.pref_fov_override_mode";
    public static final String PREF_CAMERA_FOV_OVERIDE_VERTICAL = "uastool.pref_fov_override_vertical";
    public static final String PREF_CAMERA_MAPSHOT_SAVE_MODE = "uastool.pref_mapshot_save_mode";
    public static final String PREF_CAMERA_MAX_OPEN_MAPSHOTS = "uastool.pref_max_open_mapshots";
    public static final String PREF_CAMERA_OBJECTDETECTION_MAPSHOT = "uastool.pref_objectdetection_mapshot";
    public static final String PREF_CAMERA_OBJECTDETECTION_VIBRATE = "uastool.pref_objectdetection_vibrate";
    public static Context staticPluginContext;
    /* access modifiers changed from: private */
    public String maxOpenMapshotsMessage;
    private final SharedPreferences.OnSharedPreferenceChangeListener prefChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            str.hashCode();
            if (str.equals(CameraPreferenceFragment.PREF_CAMERA_MAX_OPEN_MAPSHOTS)) {
                UASToolDropDownReceiver.toast(CameraPreferenceFragment.this.maxOpenMapshotsMessage);
            } else if (str.equals(CameraPreferenceFragment.PREF_CAMERA_FOV_OVERIDE_MODE)) {
                CameraPreferenceFragment.this.setCameraFOVState();
            }
        }
    };
    private SharedPreferences sharedPrefs;

    public CameraPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.camera_prefs);
    }

    public CameraPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.camera_prefs);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        CameraPreferenceFragment.super.onCreate((Bundle) null);
        this.sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        updateOnMode();
        findPreference(PREF_CAMERA_MAPSHOT_SAVE_MODE).setValue(this.sharedPrefs.getString(PREF_CAMERA_MAPSHOT_SAVE_MODE, Integer.toString(3)));
        findPreference(PREF_CAMERA_MAX_OPEN_MAPSHOTS).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                CameraPreferenceFragment.showSliderDialog(CameraPreferenceFragment.this.getView().getContext(), CameraPreferenceFragment.staticPluginContext.getResources().getString(C1877R.string.pref_max_open_mapshots), CameraPreferenceFragment.PREF_CAMERA_MAX_OPEN_MAPSHOTS, 10, 1, 20);
                return true;
            }
        });
        this.maxOpenMapshotsMessage = staticPluginContext.getResources().getString(C1877R.string.pref_max_open_mapshots_message);
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this.prefChangeListener);
    }

    public void onDestroy() {
        CameraPreferenceFragment.super.onDestroy();
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this.prefChangeListener);
    }

    private void updateOnMode() {
        boolean equals = this.sharedPrefs.getString(PREF_CAMERA_FOV_OVERIDE_MODE, "Disabled").equals("Custom");
        Preference findPreference = findPreference(PREF_CAMERA_FOV_OVERIDE_VERTICAL);
        Preference findPreference2 = findPreference(PREF_CAMERA_FOV_OVERIDE_HORIZONTAL);
        a(findPreference, equals);
        a(findPreference2, equals);
    }

    /* access modifiers changed from: private */
    public void setCameraFOVState() {
        String string = this.sharedPrefs.getString(PREF_CAMERA_FOV_OVERIDE_MODE, "Disabled");
        if (!"Custom".equals(string) && !"Disabled".equals(string)) {
            Matcher matcher = Pattern.compile("([0-9]*\\.?[0-9]*)x([0-9]*\\.?[0-9]*).*").matcher(string);
            if (matcher.matches() && matcher.groupCount() == 2) {
                SharedPreferences.Editor edit = this.sharedPrefs.edit();
                Log.d("PluginPreferenceFragment", "Setting FOV to (" + matcher.group(1) + "x" + matcher.group(2) + ")");
                edit.putString(PREF_CAMERA_FOV_OVERIDE_HORIZONTAL, matcher.group(1));
                edit.putString(PREF_CAMERA_FOV_OVERIDE_VERTICAL, matcher.group(2));
                edit.apply();
            }
        }
        updateOnMode();
    }

    public static void showSliderDialog(Context context, final String str, final String str2, int i, final int i2, int i3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        try {
            int i4 = UASToolDropDownReceiver.getSharedPrefs().getInt(str2, i);
            final SeekBar seekBar = new SeekBar(context);
            seekBar.setMax(i3 - i2);
            seekBar.setProgress(i4 - i2);
            seekBar.setPadding(60, 40, 60, 0);
            builder.setTitle(str + ": " + i4);
            builder.setCancelable(true);
            builder.setView(seekBar);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    CameraPreferenceFragment.setSliderPref(str2, seekBar.getProgress() + i2);
                    dialogInterface.dismiss();
                }
            });
            final AlertDialog create = builder.create();
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        AlertDialog alertDialog = create;
                        alertDialog.setTitle(str + ": " + (i + i2));
                    }
                }
            });
            create.show();
        } catch (Exception unused) {
            UASToolDropDownReceiver.toast("Please clear prefs file before using this pref");
        }
    }

    /* access modifiers changed from: private */
    public static void setSliderPref(String str, int i) {
        UASToolDropDownReceiver.getSharedPrefs().edit().putInt(str, i).apply();
    }
}
