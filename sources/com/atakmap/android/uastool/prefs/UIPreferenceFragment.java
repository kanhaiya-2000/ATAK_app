package com.atakmap.android.uastool.prefs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import atak.core.ni;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;

public class UIPreferenceFragment extends ni {
    public static final String DEFAULT_OSD_BACKGROUND_COLOR = "#00000000";
    public static final String DEFAULT_OSD_TEXT_COLOR = "#FFFFFFFF";
    public static final String DEFAULT_RETICLE_COLOR = "#D8FFFFFF";
    public static final String DEFAULT_RETICLE_SIZE = "Medium";
    public static final Boolean DEFAULT_UI_AR_ON = false;
    public static final Boolean DEFAULT_UI_COMPASS_LOCKED = false;
    public static final Boolean DEFAULT_UI_DETECTION_ON = false;
    public static final Boolean DEFAULT_UI_GIMBAL_TUNER_ON = false;
    public static final Boolean DEFAULT_UI_HEALTH_ON = false;
    public static final Boolean DEFAULT_UI_JOYSTICK_VIRTUAL_ON = false;
    public static final Boolean DEFAULT_UI_LOCKED = false;
    public static final Boolean DEFAULT_UI_MINI_MAP_ON = true;
    public static final Boolean DEFAULT_UI_OSD_ON = true;
    public static final Boolean DEFAULT_UI_PIP_ON = false;
    public static final String DEFAULT_UI_SCALE = "100";
    public static final String PREFIX_UI_TRANS_X = "uastool.pref_ui_transx_";
    public static final String PREFIX_UI_TRANS_Y = "uastool.pref_ui_transy_";
    public static final String PREF_AGL_OVERRIDE = "uastool.pref_agl_override";
    public static final String PREF_BATTERY_LEVEL_UNITS = "uastool.pref_battery_level_units";
    public static final String PREF_JOYSTICK_VIRTUAL_TYPE = "uastool.pref_joystick_virtual_type";
    public static final String PREF_OSD_BACKGROUND_COLOR = "uastool.pref_osd_background_color";
    public static final String PREF_OSD_TEXT_COLOR = "uastool.pref_osd_text_color";
    public static final String PREF_RETICLE_COLOR = "uastool.pref_reticle_color";
    public static final String PREF_RETICLE_IMAGE = "uastool.pref_reticle_image";
    public static final String PREF_RETICLE_SIZE = "uastool.pref_reticle_size";
    public static final String PREF_UI_AR_ON = "uastool.pref_ui_ar_on";
    public static final String PREF_UI_COMPASS_LOCKED = "uastool.pref_compass_locked";
    public static final String PREF_UI_DETECTION_ON = "uastool.pref_ui_detection_on";
    public static final String PREF_UI_GIMBAL_TUNER_ON = "uastool.pref_ui_gimbal_tuner_on";
    public static final String PREF_UI_HEALTH_ON = "uastool.pref_ui_health_on";
    public static final String PREF_UI_JOYSTICK_VIRTUAL_ON = "uastool.pref_ui_joystick_virtual_on";
    public static final String PREF_UI_LOCKED = "uastool.pref_ui_locked";
    public static final String PREF_UI_MINI_MAP_ON = "uastool.pref_ui_mini_map_on";
    public static final String PREF_UI_OSD_ON = "uastool.pref_ui_osd_on";
    public static final String PREF_UI_PIP_ON = "uastool.pref_ui_pip_on";
    public static final String PREF_UI_SCALE = "uastool.pref_ui_scale";
    public static Context staticPluginContext;

    private void setNewImage(int i, String str) {
    }

    public UIPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.ui_prefs);
    }

    public UIPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.ui_prefs);
        staticPluginContext = context;
    }

    public static int getDefaultReticleId() {
        try {
            return C1877R.drawable.class.getField("reticle_01").getInt((Object) null);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void onCreate(Bundle bundle) {
        UIPreferenceFragment.super.onCreate((Bundle) null);
        final int defaultReticleId = getDefaultReticleId();
        findPreference(PREF_RETICLE_IMAGE).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                UIPreferenceFragment.this.showImagePicker(UIPreferenceFragment.PREF_RETICLE_IMAGE, defaultReticleId);
                return true;
            }
        });
        findPreference(PREF_RETICLE_COLOR).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                UIPreferenceFragment.this.showColorPicker(UIPreferenceFragment.PREF_RETICLE_COLOR, UIPreferenceFragment.DEFAULT_RETICLE_COLOR);
                return true;
            }
        });
        findPreference(PREF_OSD_BACKGROUND_COLOR).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                UIPreferenceFragment.this.showColorPicker(UIPreferenceFragment.PREF_OSD_BACKGROUND_COLOR, UIPreferenceFragment.DEFAULT_OSD_BACKGROUND_COLOR);
                return true;
            }
        });
        findPreference(PREF_OSD_TEXT_COLOR).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                UIPreferenceFragment.this.showColorPicker(UIPreferenceFragment.PREF_OSD_TEXT_COLOR, UIPreferenceFragment.DEFAULT_OSD_TEXT_COLOR);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void showColorPicker(final String str, String str2) {
        final AlphaColorPicker alphaColorPicker = new AlphaColorPicker(MapView.getMapView().getContext(), Color.parseColor(UASToolDropDownReceiver.getSharedPrefs().getString(str, str2)));
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(getActivity()).setTitle("Choose Color").setMessage("Move the sliders to choose a color").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                UIPreferenceFragment.this.setNewColor(alphaColorPicker.getColor(), str);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
        negativeButton.setView(alphaColorPicker);
        negativeButton.create().show();
    }

    private String convertIntARGBToString(int i) {
        return String.format("#%08X", new Object[]{Integer.valueOf(i)});
    }

    /* access modifiers changed from: private */
    public void setNewColor(int i, String str) {
        UASToolDropDownReceiver.getSharedPrefs().edit().putString(str, convertIntARGBToString(i)).apply();
    }

    /* access modifiers changed from: private */
    public void showImagePicker(String str, int i) {
        ImageListPreferenceView imageListPreferenceView = new ImageListPreferenceView(this.g, UASToolDropDownReceiver.getSharedPrefs().getInt(str, i));
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(getActivity()).setTitle("Choose Reticle Image").setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
        negativeButton.setView(imageListPreferenceView);
        AlertDialog create = negativeButton.create();
        imageListPreferenceView.setDialog(create);
        create.show();
    }

    public static void showScalePicker(final Context context) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView((UIScalePicker) LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.video_ui_pref_scale, (ViewGroup) null));
                builder.create().show();
            }
        });
    }

    protected static void setScale(int i) {
        if (i < 1 || i > 100) {
            UASToolDropDownReceiver.toast("Scale value " + i + " outside scale range (1-100)");
            return;
        }
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putString(PREF_UI_SCALE, String.valueOf(i));
        edit.apply();
    }

    public static void askResetUI(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Reset UI?");
        builder.setMessage("Do you want to reset the UI to factory settings?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UIPreferenceFragment.resetUI();
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    public static void resetUI() {
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(PREF_RETICLE_COLOR, DEFAULT_RETICLE_COLOR);
        edit.putString(PREF_OSD_BACKGROUND_COLOR, DEFAULT_OSD_BACKGROUND_COLOR);
        edit.putBoolean(PREF_UI_OSD_ON, DEFAULT_UI_OSD_ON.booleanValue());
        edit.putBoolean(PREF_UI_AR_ON, DEFAULT_UI_AR_ON.booleanValue());
        edit.putString(PREF_UI_SCALE, DEFAULT_UI_SCALE);
        edit.putBoolean(PREF_UI_LOCKED, DEFAULT_UI_LOCKED.booleanValue());
        edit.putBoolean(PREF_UI_COMPASS_LOCKED, DEFAULT_UI_COMPASS_LOCKED.booleanValue());
        for (String next : sharedPrefs.getAll().keySet()) {
            if (next.contains(PREFIX_UI_TRANS_X) || next.contains(PREFIX_UI_TRANS_Y)) {
                edit.remove(next);
            }
        }
        edit.apply();
    }

    public void onDestroy() {
        UIPreferenceFragment.super.onDestroy();
    }

    /* renamed from: a */
    public String mo10029a() {
        return a("Tool Preferences", "UI");
    }
}
