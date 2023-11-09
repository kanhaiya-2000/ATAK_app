package com.atakmap.android.uastool.pagers.status;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ae;
import com.atakmap.android.maps.af;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.HealthScreen;
import com.atakmap.android.uastool.SUASIntegratorMapComponent;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASConfigSelector;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.pagers.status.StatusArrayList;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.plugin.DroneMarkerDetailHandler;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.utils.InstallAssetApk;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class StatusFragment extends UASToolFragment implements SharedPreferences.OnSharedPreferenceChangeListener, af.a, ao.c, StatusArrayList.NetworkUASItemListener, DroneMarkerDetailHandler.MarkerMetadataListener {
    /* access modifiers changed from: private */
    public static final String TAG = StatusFragment.class.getSimpleName();
    /* access modifiers changed from: private */
    public static final AtomicBoolean needToNotify = new AtomicBoolean(false);
    private static final ScheduledExecutorService notifyScheduler = Executors.newSingleThreadScheduledExecutor();
    private static Future<?> notifySchedulerHandle = null;
    /* access modifiers changed from: private */
    public int checkGPSCnt = 49;
    /* access modifiers changed from: private */
    public StatusAdapter networkUASAdapter;
    private StatusListView networkUASListView;
    protected ImageButton sortButton;
    protected UAS_SORT_MODE sortMode = UAS_SORT_MODE.CALLSIGN;

    public enum UAS_SORT_MODE {
        CALLSIGN,
        UAS_DISTANCE
    }

    public void onIconChanged(ao aoVar) {
    }

    public void onMarkerMetadataUpdate(ao aoVar) {
    }

    static /* synthetic */ int access$708(StatusFragment statusFragment) {
        int i = statusFragment.checkGPSCnt;
        statusFragment.checkGPSCnt = i + 1;
        return i;
    }

    public StatusFragment() {
        UASToolDropDownReceiver.getInstance().addOnMapEventListener(this, "item_refresh");
        UASToolDropDownReceiver.getInstance().addOnMapEventListener(this, "item_added");
        UASToolDropDownReceiver.getInstance().addOnMapEventListener(this, "item_removed");
        SUASIntegratorMapComponent.getInstance().getDroneMarkerDetailHandler().addMarkerMetadataListener(this);
        StatusArrayList.getInstance().addNetworkUASItemListener(this);
    }

    public void dispose() {
        StatusArrayList.getInstance().removeNetworkUASItemListener(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.layoutView = (ViewGroup) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.status_layout, viewGroup, false);
        ImageButton imageButton = (ImageButton) this.layoutView.findViewById(C1877R.C1878id.uas_config_add);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASConfigSelector.getINSTANCE().showAlertDialog(StatusFragment.this.pluginContext);
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StatusFragment.this.showHelp("Platform Configuration", "Select the platform of the locally connected UAS");
                return true;
            }
        });
        ImageButton imageButton2 = (ImageButton) this.layoutView.findViewById(C1877R.C1878id.status_sort_button);
        this.sortButton = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StatusFragment.this.toggleSort();
            }
        });
        this.sortButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                StatusFragment.this.showHelp("Sort UAS List", "Sorts the Network UAS list alphabetically or by distance from user.");
                return true;
            }
        });
        setUpSortButton();
        UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
        this.mainView = this.layoutView.findViewById(C1877R.C1878id.status_main_layout);
        this.networkUASListView = (StatusListView) this.layoutView.findViewById(C1877R.C1878id.network_uas_list);
        StatusAdapter statusAdapter = new StatusAdapter(this.pluginContext, this);
        this.networkUASAdapter = statusAdapter;
        this.networkUASListView.setAdapter(statusAdapter);
        return this.layoutView;
    }

    public void onResume() {
        super.onResume();
        resume();
    }

    public void onPause() {
        super.onPause();
        pause();
    }

    public void pause() {
        killScheduler();
    }

    public void resume() {
        startScheduler();
    }

    public void onPageSelected() {
        super.onPageSelected();
        startScheduler();
    }

    public void onPageUnSelected() {
        super.onPageUnSelected();
        killScheduler();
    }

    public void onDestroyView() {
        super.onDestroyView();
        killScheduler();
        UASToolDropDownReceiver instance = UASToolDropDownReceiver.getInstance();
        if (instance != null) {
            UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
            instance.removeOnMapEventListener(this, "item_refresh");
            instance.removeOnMapEventListener(this, "item_added");
            instance.removeOnMapEventListener(this, "item_removed");
        }
        SUASIntegratorMapComponent.getInstance().getDroneMarkerDetailHandler().removeMarkerMetadataListener(this);
    }

    private void startScheduler() {
        if (notifySchedulerHandle == null) {
            notifySchedulerHandle = notifyScheduler.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    try {
                        if (StatusFragment.needToNotify.compareAndSet(true, false)) {
                            StatusFragment.this.notifyDataSetChanged();
                        }
                    } catch (Exception e) {
                        StatusFragment statusFragment = StatusFragment.this;
                        statusFragment.toast("Status scheduler: " + e.getLocalizedMessage());
                        Log.e(StatusFragment.TAG, "Status scheduler crash: ", e);
                    }
                }
            }, 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    private void killScheduler() {
        Future<?> future = notifySchedulerHandle;
        if (future != null) {
            future.cancel(false);
            notifySchedulerHandle = null;
        }
    }

    public void onMapEvent(ae aeVar) {
        ao b = aeVar.b();
        if (UASItem.isUASMapItem(b)) {
            String a = aeVar.a();
            a.hashCode();
            char c = 65535;
            switch (a.hashCode()) {
                case -1969101612:
                    if (a.equals("item_added")) {
                        c = 0;
                        break;
                    }
                    break;
                case -287510097:
                    if (a.equals("item_refresh")) {
                        c = 1;
                        break;
                    }
                    break;
                case -281118924:
                    if (a.equals("item_removed")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    prepareListData(b);
                    needToNotify.set(true);
                    return;
                case 1:
                    prepareListData(b);
                    needToNotify.set(true);
                    return;
                case 2:
                    StatusArrayList.getInstance().removeBroadcastingUAS(b);
                    needToNotify.set(true);
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void toast(String str) {
        UASToolDropDownReceiver.toast(str, 0);
    }

    private void prepareListData(final ao aoVar) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                UASItem defaultUasItem = StatusArrayList.getInstance().getDefaultUasItem();
                if (defaultUasItem != null && defaultUasItem.isMyMarker(aoVar)) {
                    defaultUasItem.setMarker(aoVar);
                    defaultUasItem.updateStatusData();
                    StatusArrayList.getInstance().removeBroadcastingUAS(aoVar);
                    if (!defaultUasItem.isConnected()) {
                        return;
                    }
                    if (defaultUasItem.hasGPS()) {
                        int unused = StatusFragment.this.checkGPSCnt = 0;
                    } else if (StatusFragment.this.checkGPSCnt > 50) {
                        int unused2 = StatusFragment.this.checkGPSCnt = 0;
                        UASToolDropDownReceiver.toast("UAS does NOT have a GPS signal", 1);
                    } else {
                        StatusFragment.access$708(StatusFragment.this);
                    }
                } else if (StatusArrayList.getInstance().containsBroadcasting(aoVar)) {
                    UASItem broadcasting = StatusArrayList.getInstance().getBroadcasting(aoVar);
                    if (broadcasting != null) {
                        broadcasting.setMarker(aoVar);
                        broadcasting.updateStatusData();
                        return;
                    }
                    StatusFragment.this.toast("Error: unable to update broadcasting UAS");
                } else {
                    UASItem buildItem = UASItem.buildItem(aoVar, false);
                    if (buildItem != null) {
                        buildItem.init();
                        buildItem.updateStatusData();
                        StatusArrayList.getInstance().add(buildItem);
                        ao marker = buildItem.getMarker();
                        if (marker != null) {
                            marker.a(this);
                        }
                    }
                }
            }
        });
    }

    public void gotUASConnection() {
        StatusArrayList.getInstance().gotUASConnection();
    }

    public void lostUASConnection() {
        StatusArrayList.getInstance().lostUASConnection();
    }

    /* access modifiers changed from: private */
    public void notifyDataSetChanged() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (StatusFragment.this.networkUASAdapter != null) {
                    StatusFragment.this.networkUASAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void unlockPlatform(UASItem uASItem) {
        if (uASItem == null) {
            return;
        }
        if (!uASItem.isDefault() || !uASItem.isConnected()) {
            UASToolDropDownReceiver.toast("UAS not connected", 0);
        } else {
            uASItem.unlockPlatform();
        }
    }

    public void showPlatformSettings(UASItem uASItem) {
        if (uASItem == null) {
            return;
        }
        if (!uASItem.isDefault() || !uASItem.isConnected()) {
            UASToolDropDownReceiver.toast("UAS not connected", 0);
            return;
        }
        SettingsScreen platformSettingsScreen = uASItem.getPlatformSettingsScreen(LayoutInflater.from(this.pluginContext));
        if (platformSettingsScreen != null) {
            setCurrentScreen(platformSettingsScreen, uASItem, this);
            return;
        }
        UASToolDropDownReceiver.toast("Platform " + uASItem.getPlatformType() + "does not support settings");
    }

    public void showPlatformHealth(UASItem uASItem) {
        if (uASItem == null) {
            return;
        }
        if (!uASItem.isDefault() || !uASItem.isConnected()) {
            UASToolDropDownReceiver.toast("UAS not connected", 0);
            return;
        }
        HealthScreen platformHealthScreen = uASItem.getPlatformHealthScreen(LayoutInflater.from(this.pluginContext));
        if (platformHealthScreen != null) {
            setCurrentScreen(platformHealthScreen, uASItem, this);
            return;
        }
        UASToolDropDownReceiver.toast("Platform " + uASItem.getPlatformType() + "does not support health");
    }

    public void callsignChanged(String str) {
        StatusArrayList.getInstance().callsignChanged(str);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        String string;
        UASItem buildItem;
        if (str.equals(UASToolPreferenceFragment.PREF_PLATFORM_DETECT) && (string = sharedPreferences.getString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, (String) null)) != null && (buildItem = UASItem.buildItem(UASItem.NO_UID, "", string, false)) != null) {
            String platformType = buildItem.getPlatformType();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext()).edit();
            edit.remove("uastool.DONT_WARN_" + platformType);
            edit.apply();
            if (!InstallAssetApk.getInstance().checkDependencies(platformType)) {
                InstallAssetApk.getInstance().checkAndInstallDependencies(platformType);
            }
        }
    }

    /* access modifiers changed from: private */
    public void toggleSort() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext()).edit();
        int i = C17158.f8402xecfaf28a[this.sortMode.ordinal()];
        if (i == 1) {
            GeoPoint C = MapView.getMapView().getSelfMarker().C();
            if (C == null || C.equals(GeoPoint.ZERO_POINT)) {
                Toast.makeText(MapView.getMapView().getContext(), "No self marker available to sort UAS by distance", 0).show();
            } else {
                this.sortMode = UAS_SORT_MODE.UAS_DISTANCE;
                edit.putString(UASToolPreferenceFragment.PREF_DEFAULT_UAS_SORT, "UAS_DISTANCE");
                this.sortButton.setImageResource(C1877R.drawable.action_sort_prox);
            }
        } else if (i != 2) {
            this.sortMode = UAS_SORT_MODE.CALLSIGN;
            edit.putString(UASToolPreferenceFragment.PREF_DEFAULT_UAS_SORT, UASToolPreferenceFragment.PREF_DEFAULT_UAS_SORT);
            this.sortButton.setImageResource(C1877R.drawable.action_sort);
            Log.e(TAG, "Sort mode set to non-implemented sort, defaulting to alphabetical");
        } else {
            this.sortMode = UAS_SORT_MODE.CALLSIGN;
            edit.putString(UASToolPreferenceFragment.PREF_DEFAULT_UAS_SORT, UASToolPreferenceFragment.PREF_DEFAULT_UAS_SORT);
            this.sortButton.setImageResource(C1877R.drawable.action_sort);
        }
        edit.apply();
        doSort(this.sortMode, true);
        this.networkUASListView.closeAll();
    }

    /* renamed from: com.atakmap.android.uastool.pagers.status.StatusFragment$8 */
    /* synthetic */ class C17158 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$pagers$status$StatusFragment$UAS_SORT_MODE */
        static final /* synthetic */ int[] f8402xecfaf28a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.android.uastool.pagers.status.StatusFragment$UAS_SORT_MODE[] r0 = com.atakmap.android.uastool.pagers.status.StatusFragment.UAS_SORT_MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8402xecfaf28a = r0
                com.atakmap.android.uastool.pagers.status.StatusFragment$UAS_SORT_MODE r1 = com.atakmap.android.uastool.pagers.status.StatusFragment.UAS_SORT_MODE.CALLSIGN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8402xecfaf28a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.pagers.status.StatusFragment$UAS_SORT_MODE r1 = com.atakmap.android.uastool.pagers.status.StatusFragment.UAS_SORT_MODE.UAS_DISTANCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.status.StatusFragment.C17158.<clinit>():void");
        }
    }

    private void doSort(UAS_SORT_MODE uas_sort_mode, boolean z) {
        StatusArrayList.getInstance().sort(uas_sort_mode, z);
    }

    private void setUpSortButton() {
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(UASToolPreferenceFragment.PREF_DEFAULT_UAS_SORT, UASToolPreferenceFragment.PREF_DEFAULT_UAS_SORT);
        string.hashCode();
        if (string.equals("UAS_DISTANCE")) {
            GeoPoint C = MapView.getMapView().getSelfMarker().C();
            if (C == null || C.equals(GeoPoint.ZERO_POINT)) {
                Toast.makeText(MapView.getMapView().getContext(), "No self marker available to sort UAS by distance", 0).show();
                this.sortButton.setImageResource(C1877R.drawable.action_sort);
                this.sortMode = UAS_SORT_MODE.CALLSIGN;
            } else {
                this.sortMode = UAS_SORT_MODE.UAS_DISTANCE;
                this.sortButton.setImageResource(C1877R.drawable.action_sort_prox);
            }
        } else if (!string.equals(UASToolPreferenceFragment.PREF_DEFAULT_UAS_SORT)) {
            this.sortButton.setImageResource(C1877R.drawable.action_sort);
            this.sortMode = UAS_SORT_MODE.CALLSIGN;
        } else {
            this.sortMode = UAS_SORT_MODE.CALLSIGN;
            this.sortButton.setImageResource(C1877R.drawable.action_sort);
        }
        doSort(this.sortMode, true);
    }

    /* access modifiers changed from: private */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }

    public void onUASListChanged() {
        notifyDataSetChanged();
    }
}
