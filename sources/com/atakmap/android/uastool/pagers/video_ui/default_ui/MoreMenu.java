package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import java.util.ArrayList;
import java.util.Iterator;

public class MoreMenu extends PopupMenu implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String TAG = "MoreMenu";
    private final MenuItem flightLogItem;
    private final MenuItem labelsItem;
    private final MenuItem messageLogItem;
    private final MenuItem pairingItem;
    private ArrayList<Integer> platformMenuIds;
    private final MenuItem showARItem;
    private final MenuItem showOSDItem;
    private UASItem uasItem;
    private final MenuItem uiDetectionItem;
    private final MenuItem uiHealthItem;
    private final MenuItem uiLockedItem;
    private final MenuItem uiMiniMapItem;
    private final MenuItem uiPipItem;
    private final MenuItem uiResetItem;
    private final MenuItem uiScaleItem;
    private final MenuItem uiVirtualJoystickItem;

    public MoreMenu(Context context, View view) {
        super(context, view);
        getMenuInflater().inflate(C1877R.menu.menu_more, getMenu());
        setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case C1877R.C1878id.more_flight_log /*2131034783*/:
                        MoreMenu.this.onFlightLogMenu();
                        break;
                    case C1877R.C1878id.more_labels /*2131034784*/:
                        MoreMenu.this.onLabelsMenu();
                        break;
                    case C1877R.C1878id.more_message_log /*2131034785*/:
                        MoreMenu.this.onMessageLogMenu();
                        break;
                    case C1877R.C1878id.more_pair_controller /*2131034786*/:
                        MoreMenu.this.onPairingMenu();
                        break;
                    case C1877R.C1878id.more_show_ar /*2131034787*/:
                        MoreMenu.this.showAR(!menuItem.isChecked());
                        break;
                    case C1877R.C1878id.more_show_osd /*2131034788*/:
                        MoreMenu.this.showOSD(!menuItem.isChecked());
                        break;
                    case C1877R.C1878id.more_ui_locked /*2131034789*/:
                        MoreMenu.this.lockUI(!menuItem.isChecked());
                        break;
                    case C1877R.C1878id.more_ui_reset /*2131034790*/:
                        MoreMenu.this.onUIResetMenu();
                        break;
                    case C1877R.C1878id.more_ui_scale /*2131034791*/:
                        MoreMenu.this.onOSDScaleMenu();
                        break;
                    case C1877R.C1878id.more_ui_show_detection /*2131034792*/:
                        MoreMenu.this.onShowDetection();
                        break;
                    case C1877R.C1878id.more_ui_show_health /*2131034793*/:
                        MoreMenu.this.onShowHealth();
                        break;
                    case C1877R.C1878id.more_ui_show_joystick_virtual /*2131034794*/:
                        MoreMenu.this.onShowVirtualJoystick();
                        break;
                    case C1877R.C1878id.more_ui_show_map /*2131034795*/:
                        MoreMenu.this.onShowMap();
                        break;
                    case C1877R.C1878id.more_ui_show_pip /*2131034796*/:
                        MoreMenu.this.onShowPip();
                        break;
                    default:
                        MoreMenu.this.handlePlatformMoreMenu(menuItem.getTitle().toString());
                        break;
                }
                return true;
            }
        });
        Menu menu = getMenu();
        this.labelsItem = menu.findItem(C1877R.C1878id.more_labels);
        this.messageLogItem = menu.findItem(C1877R.C1878id.more_message_log);
        this.flightLogItem = menu.findItem(C1877R.C1878id.more_flight_log);
        this.pairingItem = menu.findItem(C1877R.C1878id.more_pair_controller);
        this.showOSDItem = menu.findItem(C1877R.C1878id.more_show_osd);
        this.showARItem = menu.findItem(C1877R.C1878id.more_show_ar);
        this.uiLockedItem = menu.findItem(C1877R.C1878id.more_ui_locked);
        this.uiScaleItem = menu.findItem(C1877R.C1878id.more_ui_scale);
        this.uiResetItem = menu.findItem(C1877R.C1878id.more_ui_reset);
        this.uiMiniMapItem = menu.findItem(C1877R.C1878id.more_ui_show_map);
        this.uiDetectionItem = menu.findItem(C1877R.C1878id.more_ui_show_detection);
        this.uiPipItem = menu.findItem(C1877R.C1878id.more_ui_show_pip);
        this.uiHealthItem = menu.findItem(C1877R.C1878id.more_ui_show_health);
        this.uiVirtualJoystickItem = menu.findItem(C1877R.C1878id.more_ui_show_joystick_virtual);
        if (!view.isInEditMode()) {
            UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
        }
    }

    public void setUASItem(UASItem uASItem) {
        this.uasItem = uASItem;
        updateMoreMenu();
    }

    public void updateSize() {
        updateMoreMenu();
    }

    private void updateMoreMenu() {
        ArrayList<String> moreMenuStrings;
        Menu menu = getMenu();
        ArrayList<Integer> arrayList = this.platformMenuIds;
        if (arrayList != null) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                menu.removeItem(it.next().intValue());
            }
            this.platformMenuIds = null;
        }
        boolean isFullscreenVideo = UASToolDropDownReceiver.getInstance().isFullscreenVideo();
        this.labelsItem.setEnabled(!isFullscreenVideo && this.uasItem != null);
        this.messageLogItem.setEnabled(!isFullscreenVideo);
        this.flightLogItem.setEnabled(!isFullscreenVideo);
        this.uiScaleItem.setEnabled(isFullscreenVideo);
        if (UASItem.supportsControllerPairing()) {
            this.pairingItem.setEnabled(!isFullscreenVideo);
        } else {
            this.pairingItem.setEnabled(false);
        }
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        this.uiMiniMapItem.setChecked(sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_MINI_MAP_ON, UIPreferenceFragment.DEFAULT_UI_MINI_MAP_ON.booleanValue()));
        this.uiDetectionItem.setChecked(sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_DETECTION_ON, UIPreferenceFragment.DEFAULT_UI_DETECTION_ON.booleanValue()));
        this.uiPipItem.setChecked(sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_PIP_ON, UIPreferenceFragment.DEFAULT_UI_PIP_ON.booleanValue()));
        UASItem uASItem = this.uasItem;
        if (uASItem == null) {
            this.uiHealthItem.setEnabled(false);
            this.uiHealthItem.setChecked(false);
        } else if (uASItem.supportsHealth()) {
            this.uiHealthItem.setEnabled(true);
            this.uiHealthItem.setChecked(sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_HEALTH_ON, UIPreferenceFragment.DEFAULT_UI_HEALTH_ON.booleanValue()));
        } else {
            this.uiHealthItem.setEnabled(false);
            this.uiHealthItem.setChecked(false);
        }
        this.uiVirtualJoystickItem.setChecked(sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_JOYSTICK_VIRTUAL_ON, UIPreferenceFragment.DEFAULT_UI_JOYSTICK_VIRTUAL_ON.booleanValue()));
        UASItem uASItem2 = this.uasItem;
        if (uASItem2 == null) {
            this.uiVirtualJoystickItem.setEnabled(false);
        } else if (uASItem2.supportsVirtualJoystick()) {
            this.uiVirtualJoystickItem.setEnabled(true);
        } else {
            this.uiVirtualJoystickItem.setEnabled(false);
        }
        this.showOSDItem.setChecked(sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_OSD_ON, UIPreferenceFragment.DEFAULT_UI_OSD_ON.booleanValue()));
        this.showARItem.setEnabled(true);
        this.showARItem.setChecked(sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_AR_ON, UIPreferenceFragment.DEFAULT_UI_AR_ON.booleanValue()));
        this.uiLockedItem.setChecked(sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_LOCKED, UIPreferenceFragment.DEFAULT_UI_LOCKED.booleanValue()));
        UASItem uASItem3 = this.uasItem;
        if (uASItem3 != null && (moreMenuStrings = uASItem3.getMoreMenuStrings(isFullscreenVideo)) != null) {
            this.platformMenuIds = new ArrayList<>();
            Iterator<String> it2 = moreMenuStrings.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                MenuItem add = menu.add(next);
                if (add != null) {
                    this.platformMenuIds.add(Integer.valueOf(add.getItemId()));
                } else {
                    UASToolDropDownReceiver.toast("Bad platform menu item in quickbar: " + next);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onLabelsMenu() {
        if (this.uasItem != null) {
            UASToolDropDownReceiver.getInstance().showOverlaysScreen(this.uasItem);
        }
    }

    /* access modifiers changed from: private */
    public void onMessageLogMenu() {
        UASToolDropDownReceiver.getInstance().showMessagesScreen();
    }

    /* access modifiers changed from: private */
    public void onFlightLogMenu() {
        UASToolDropDownReceiver.getInstance().showFlightLogsScreen();
    }

    /* access modifiers changed from: private */
    public void onPairingMenu() {
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, (String) null);
        if (!TextUtils.isEmpty(string)) {
            UASItem buildItem = UASItem.buildItem("userId", FlightLogger.LOG_CALLSIGN, string, false);
            if (buildItem == null || !UASItem.supportsControllerPairing()) {
                UASToolDropDownReceiver.toast("Platform " + string + " doesn't support controller pairing");
                return;
            }
            buildItem.pairController();
            return;
        }
        UASToolDropDownReceiver.toast("No default platform selected");
    }

    /* access modifiers changed from: private */
    public void showOSD(boolean z) {
        this.showOSDItem.setChecked(z);
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putBoolean(UIPreferenceFragment.PREF_UI_OSD_ON, z);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void showAR(boolean z) {
        this.showARItem.setChecked(z);
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putBoolean(UIPreferenceFragment.PREF_UI_AR_ON, z);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void lockUI(boolean z) {
        this.uiLockedItem.setChecked(z);
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putBoolean(UIPreferenceFragment.PREF_UI_LOCKED, z);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void onShowMap() {
        boolean z = !this.uiMiniMapItem.isChecked();
        this.uiMiniMapItem.setChecked(z);
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putBoolean(UIPreferenceFragment.PREF_UI_MINI_MAP_ON, z);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void onShowDetection() {
        boolean z = !this.uiDetectionItem.isChecked();
        this.uiDetectionItem.setChecked(z);
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putBoolean(UIPreferenceFragment.PREF_UI_DETECTION_ON, z);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void onShowPip() {
        boolean z = !this.uiPipItem.isChecked();
        this.uiPipItem.setChecked(z);
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putBoolean(UIPreferenceFragment.PREF_UI_PIP_ON, z);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void onShowHealth() {
        boolean z = !this.uiHealthItem.isChecked();
        this.uiHealthItem.setChecked(z);
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putBoolean(UIPreferenceFragment.PREF_UI_HEALTH_ON, z);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void onShowVirtualJoystick() {
        boolean z = !this.uiVirtualJoystickItem.isChecked();
        UASItem uASItem = this.uasItem;
        if (uASItem == null) {
            return;
        }
        if (uASItem.setVirtualStickMode(z)) {
            this.uiVirtualJoystickItem.setChecked(z);
            SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
            edit.putBoolean(UIPreferenceFragment.PREF_UI_JOYSTICK_VIRTUAL_ON, z);
            edit.apply();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to ");
        sb.append(z ? "enable" : "disable");
        sb.append(" virtual joystick mode");
        UASToolDropDownReceiver.toast(sb.toString());
    }

    /* access modifiers changed from: private */
    public void onUIResetMenu() {
        showOSD(true);
        showAR(false);
        lockUI(false);
        UASToolDropDownReceiver.getInstance().resetUI();
    }

    /* access modifiers changed from: private */
    public void onOSDScaleMenu() {
        UIPreferenceFragment.showScalePicker(MapView.getMapView().getContext());
    }

    /* access modifiers changed from: private */
    public void handlePlatformMoreMenu(String str) {
        UASItem uASItem = this.uasItem;
        if (uASItem != null) {
            uASItem.handleMoreMenu(str);
            return;
        }
        UASToolDropDownReceiver.toast("No UAS for menu item: " + str);
    }

    public void dispose() {
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1472456180:
                if (str.equals(UIPreferenceFragment.PREF_UI_MINI_MAP_ON)) {
                    c = 0;
                    break;
                }
                break;
            case -849754040:
                if (str.equals(UIPreferenceFragment.PREF_UI_LOCKED)) {
                    c = 1;
                    break;
                }
                break;
            case -760153924:
                if (str.equals(UIPreferenceFragment.PREF_UI_OSD_ON)) {
                    c = 2;
                    break;
                }
                break;
            case -740402491:
                if (str.equals(UIPreferenceFragment.PREF_UI_PIP_ON)) {
                    c = 3;
                    break;
                }
                break;
            case -176031825:
                if (str.equals(UIPreferenceFragment.PREF_UI_AR_ON)) {
                    c = 4;
                    break;
                }
                break;
            case 1789805048:
                if (str.equals(UIPreferenceFragment.PREF_UI_JOYSTICK_VIRTUAL_ON)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                updateMoreMenu();
                return;
            default:
                return;
        }
    }
}
