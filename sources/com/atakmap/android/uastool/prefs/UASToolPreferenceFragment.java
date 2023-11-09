package com.atakmap.android.uastool.prefs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.text.TextUtils;
import atak.core.ni;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.status.StatusArrayList;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.DocUtils;

public class UASToolPreferenceFragment extends ni {
    private static final String AV_PREFERENCE = "AV";
    private static final String CAMERA_PREFERENCE = "CAMERA";
    private static final String CONTROLLER_PREFERENCE = "CONTROLLER";
    private static final String DJI_PREFERENCE = "DJI";
    private static final String EVO_PREFERENCE = "Evo";
    private static final String GENERIC_PREFERENCE = "Generic";
    private static final String INDAGO_PREFERENCE = "Indago";
    private static final String MAVLINK_PREFERENCE = "MAVLink";
    private static final String NETWORK_PREFERENCE = "NETWORK";
    private static final String PD100_PREFERENCE = "BH3";
    public static final String PREF_AGL_DONT_WARN = "uastool.AGL_DONT_WARN";
    public static final String PREF_APK_DONT_WARN = "uastool.DONT_WARN";
    public static final String PREF_CALLSIGN = "uastool.pref_callsign";
    public static final String PREF_COT_BROADCAST = "uastool.pref_cot_broadcast";
    public static final String PREF_DEFAULT_TASK_SORT = "NAME";
    public static final String PREF_DEFAULT_UAS_SORT = "CALLSIGN";
    public static final String PREF_DTED_DONT_WARN = "uastool.DTED_DONT_WARN";
    public static final String PREF_PLATFORM_DETECT = "uastool.pref_platform_detect";
    public static final String PREF_PREFIX = "uastool.";
    public static final String QUICKTASK_PREF_ORBIT_RADIUS = "uastool.quicktask.orbitRadius";
    public static final String ROUTES_WAYPOINTS_OVERLAY = "uastool.ROUTES_WAYPOINTS_OVERLAY";
    public static final String ROUTE_PREF_ORBIT_RADIUS = "uastool.route.orbitRadius";
    public static final String ROUTE_PREF_ORBIT_SPEED = "uastool.route.orbitSpeed";
    public static final String ROUTE_PREF_UASPOINT_ALTITUDE = "uastool.route.uaspointAltitude";
    public static final String ROUTE_PREF_UASPOINT_SPEED = "uastool.route.uaspointSpeed";
    private static final String TAG = "UASToolPreferenceFragment";
    private static final String TRILLIUM_PREFERENCE = "Trillium";
    private static final String UI_PREFERENCE = "UI";
    private static final String UTILITIES_PREFERENCE = "UTILITIES";
    /* access modifiers changed from: private */
    public static Context staticPluginContext;
    private final SharedPreferences.OnSharedPreferenceChangeListener prefChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            str.hashCode();
            if (str.equals(UASToolPreferenceFragment.PREF_CALLSIGN)) {
                UASToolPreferenceFragment.this.checkUpdateBroadcastPath();
                StatusArrayList.getInstance().callsignChanged(UASToolPreferenceFragment.this.sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, ""));
            }
        }
    };
    /* access modifiers changed from: private */
    public SharedPreferences sharedPrefs;

    public UASToolPreferenceFragment() {
        super(staticPluginContext, C1877R.C1879xml.uastool_prefs);
    }

    public UASToolPreferenceFragment(Context context) {
        super(context, C1877R.C1879xml.uastool_prefs);
        staticPluginContext = context;
    }

    public void onCreate(Bundle bundle) {
        UASToolPreferenceFragment.super.onCreate((Bundle) null);
        this.sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        findPreference(NETWORK_PREFERENCE).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.NetworkPreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new NetworkPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference(CAMERA_PREFERENCE).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [com.atakmap.android.uastool.prefs.CameraPreferenceFragment, android.preference.PreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new CameraPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference(UI_PREFERENCE).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.UIPreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new UIPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference(UTILITIES_PREFERENCE).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.UtilitiesPreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new UtilitiesPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference(CONTROLLER_PREFERENCE).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [com.atakmap.android.uastool.prefs.ControllerPreferenceFragment, android.preference.PreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new ControllerPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference("DJI").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.DJIPreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new DJIPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference("AV").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.AVPreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new AVPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference("Generic").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.GenericPreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new GenericPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference("BH3").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.PD100PreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new PD100PreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference("Indago").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.IndagoPreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new IndagoPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference("MAVLink").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [android.preference.PreferenceFragment, com.atakmap.android.uastool.prefs.MAVLinkPreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new MAVLinkPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference("Trillium").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [com.atakmap.android.uastool.prefs.TrilliumPreferenceFragment, android.preference.PreferenceFragment] */
            public boolean onPreferenceClick(Preference preference) {
                UASToolPreferenceFragment.this.a(new TrilliumPreferenceFragment(UASToolPreferenceFragment.staticPluginContext));
                return true;
            }
        });
        findPreference("show_guide").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                DocUtils.installSupportDocs(UASToolPreferenceFragment.this.g);
                DocUtils.openSUM(UASToolPreferenceFragment.this.getActivity());
                return true;
            }
        });
        findPreference("show_changelog").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                DocUtils.installSupportDocs(UASToolPreferenceFragment.this.g);
                DocUtils.openChangelog(UASToolPreferenceFragment.this.getActivity());
                return true;
            }
        });
        Preference findPreference = findPreference("uastool_about");
        findPreference.setSummary("9.2 (6a234c98) - [4.4.0] civ release " + this.g.getResources().getString(C1877R.string.mybucket));
        setDefaultValues();
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this.prefChangeListener);
    }

    private void setDefaultValues() {
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(PREF_CALLSIGN);
        if (TextUtils.isEmpty(this.sharedPrefs.getString(PREF_CALLSIGN, (String) null))) {
            editTextPreference.setText("UAS-" + UASToolDropDownReceiver.getInstance().getMapView().getDeviceCallsign());
        }
        ((CheckBoxPreference) findPreference(PREF_COT_BROADCAST)).setChecked(this.sharedPrefs.getBoolean(PREF_COT_BROADCAST, true));
        SharedPreferences.Editor edit = this.sharedPrefs.edit();
        edit.putBoolean(PREF_DTED_DONT_WARN, false);
        edit.putBoolean(ROUTES_WAYPOINTS_OVERLAY, false);
        edit.apply();
    }

    public void onDestroy() {
        UASToolPreferenceFragment.super.onDestroy();
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this.prefChangeListener);
    }

    /* renamed from: a */
    public String mo10001a() {
        return a("Tool Preferences", this.g.getString(C1877R.string.uastool_prefs_title));
    }

    /* access modifiers changed from: private */
    public void checkUpdateBroadcastPath() {
        if (this.sharedPrefs.getString(NetworkPreferenceFragment.PREF_BROADCAST_DESTINATION, this.g.getResources().getStringArray(C1877R.array.video_destination)[0]).contains("Wowza")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Video Broadcast Identifier Update");
            builder.setMessage("Preference used in auto-generated video broadcast Identifier has changed." + "\n\nUpdate Video Broadcast Identifier?");
            builder.setPositiveButton("Yes, Update", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    UASToolPreferenceFragment.this.updateBroadcastPath();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public void updateBroadcastPath() {
        SharedPreferences.Editor edit = this.sharedPrefs.edit();
        edit.putString(NetworkPreferenceFragment.PREF_BROADCAST_PATH, (String) null);
        edit.apply();
        String buildDefaultVideoBroadcastPath = UASToolDropDownReceiver.getInstance().buildDefaultVideoBroadcastPath();
        edit.putString(NetworkPreferenceFragment.PREF_BROADCAST_PATH, buildDefaultVideoBroadcastPath);
        edit.commit();
        if (!TextUtils.isEmpty(buildDefaultVideoBroadcastPath)) {
            checkUpdateObserverUrl();
        }
    }

    private void checkUpdateObserverUrl() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Video Observer URL Update");
        builder.setMessage("Preference used in auto-generated video observer URL has changed." + "\n\nUpdate Video Observer URL?");
        builder.setPositiveButton("Yes, Update", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UASToolPreferenceFragment.this.updateObserverUrl();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void updateObserverUrl() {
        SharedPreferences.Editor edit = this.sharedPrefs.edit();
        edit.putString(NetworkPreferenceFragment.PREF_VIDEO_OBSERVER_URL, (String) null);
        edit.apply();
        edit.putString(NetworkPreferenceFragment.PREF_VIDEO_OBSERVER_URL, UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationUrl());
        edit.commit();
    }
}
