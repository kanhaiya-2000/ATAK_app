package com.atakmap.android.uastool;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.PD100.PD100Monitor;
import com.atakmap.android.uastool.PD100.PD100PrefHandler;
import com.atakmap.android.uastool.dji.DJIUASItem;
import com.atakmap.android.uastool.generic.GenericPrefHandler;
import com.atakmap.android.uastool.indago.IndagoPrefHandler;
import com.atakmap.android.uastool.mavlink.MAVLinkPrefHandler;
import com.atakmap.android.uastool.mavlink.MavlinkAvahiService;
import com.atakmap.android.uastool.p000av.AvPrefHandler;
import com.atakmap.android.uastool.pagers.avahi.AvahiAdapter;
import com.atakmap.android.uastool.pagers.avahi.AvahiListFragment;
import com.atakmap.android.uastool.pagers.avahi.AvahiServiceInfo;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.NetworkPreferenceFragment;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.r80d.R80DAvahiService;
import com.atakmap.android.uastool.r80d.R80dPrefHandler;
import com.atakmap.android.uastool.trillium.TrilliumPrefHandler;
import com.atakmap.android.uastool.utils.AvahiService;
import com.atakmap.android.uastool.utils.InstallAssetApk;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.log.Log;
import com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle;
import java.util.ArrayList;
import java.util.Map;

public class UASConfigSelector implements SharedPreferences.OnSharedPreferenceChangeListener, AvahiAdapter.AvahiItemSelectedListener {
    private static UASConfigSelector INSTANCE = null;
    private static final String TAG = "UASConfigSelector";
    public static LinearLayout[] config_layouts;
    AvahiListFragment alf;
    /* access modifiers changed from: private */
    public View customLayout;
    private ArrayList<String> platforms = new ArrayList<>();
    private Context pluginContext;
    private AlertDialog selectorDialog;

    public static UASConfigSelector getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UASConfigSelector();
        }
        return INSTANCE;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1194662830:
                if (str.equals(MAVLinkPrefHandler.PREF_PLATFORM_MAVLINK_PORT)) {
                    c = 0;
                    break;
                }
                break;
            case -1096214216:
                if (str.equals(MAVLinkPrefHandler.PREF_PLATFORM_MAVLINK_IP)) {
                    c = 1;
                    break;
                }
                break;
            case 201747078:
                if (str.equals(MAVLinkPrefHandler.PREF_MAVLINK_NETWORK_TYPE)) {
                    c = 2;
                    break;
                }
                break;
            case 328759337:
                if (str.equals(R80dPrefHandler.PREF_PLATFORM_SERIAL)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                cyclePlatformMonitor();
                return;
            default:
                return;
        }
    }

    enum CONFIG_ID {
        NONE(0),
        DJI(1),
        AV(2),
        PD100(3),
        INDAGO(4),
        MAVLINK(5),
        R80D(6),
        GENERIC(7),
        TRILLIUM(8),
        EVO(9);
        
        public final int value;

        private CONFIG_ID(int i) {
            this.value = i;
        }
    }

    public void init(Context context) {
        this.pluginContext = context;
        this.customLayout = LayoutInflater.from(context).inflate(C1877R.layout.uas_config_selector, (ViewGroup) null);
        this.alf = new AvahiListFragment(this.pluginContext);
        ArrayList<String> platformList = UASItem.getPlatformList();
        this.platforms = platformList;
        if (!platformList.get(0).equals("None Selected")) {
            this.platforms.add(0, "None Selected");
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, C1877R.layout.spinner_text_white_view, this.platforms);
        arrayAdapter.setDropDownViewResource(17367049);
        this.customLayout.findViewById(C1877R.C1878id.config_platform_spinner).setAdapter(arrayAdapter);
        LinearLayout[] linearLayoutArr = new LinearLayout[this.platforms.size()];
        config_layouts = linearLayoutArr;
        linearLayoutArr[CONFIG_ID.DJI.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_DJI);
        config_layouts[CONFIG_ID.AV.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_AV_PUMA);
        config_layouts[CONFIG_ID.PD100.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_PD100);
        config_layouts[CONFIG_ID.INDAGO.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_indago);
        config_layouts[CONFIG_ID.MAVLINK.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_mavlink);
        config_layouts[CONFIG_ID.R80D.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_R80D);
        config_layouts[CONFIG_ID.GENERIC.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_generic);
        config_layouts[CONFIG_ID.TRILLIUM.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_trillium);
        config_layouts[CONFIG_ID.EVO.value] = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_evo);
        int i = 1;
        while (true) {
            LinearLayout[] linearLayoutArr2 = config_layouts;
            if (i < linearLayoutArr2.length) {
                linearLayoutArr2[i].setVisibility(8);
                i++;
            } else {
                return;
            }
        }
    }

    public void showAlertDialog(Context context) {
        init(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setView(this.customLayout);
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        final PluginSpinner findViewById = this.customLayout.findViewById(C1877R.C1878id.config_platform_spinner);
        final SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        findViewById.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                UASConfigSelector.this.toggleConfigScreen(i);
                ((TextView) UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.config_DJI_TextView)).setText(InstallAssetApk.getInstance().checkDependencies(DJIUASItem.DISPLAY_NAME) ? "No Additional Settings" : "Install or update support apps");
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UASConfigSelector.checkPutTextPref(AvPrefHandler.PREF_SRC_ADAPTER, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.av_video_source_adapter), edit);
                UASConfigSelector.checkPutTextPref(PD100PrefHandler.PREF_SRC_ADAPTER, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.pd100_video_source_adapter), edit);
                UASConfigSelector.checkPutTextPref(PD100PrefHandler.PREF_SRC_IP, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.pd100_video_ip), edit);
                UASConfigSelector.checkPutTextPref(PD100PrefHandler.PREF_SRC_PORT, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.pd100_video_port), edit);
                UASConfigSelector.checkPutTextPref(PD100PrefHandler.PREF_COT_TCP_PORT, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.pd100_cot_tcp_port), edit);
                UASConfigSelector.checkPutTextPref(PD100PrefHandler.PREF_COT_UDP_PORT, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.pd100_cot_udp_port), edit);
                UASConfigSelector.checkPutTextPref(IndagoPrefHandler.PREF_SRC_ADAPTER, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.indago_video_source_adapter), edit);
                UASConfigSelector.checkPutTextPref(IndagoPrefHandler.PREF_VCT_IP, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.indago_vct_ip), edit);
                UASConfigSelector.checkPutTextPref(IndagoPrefHandler.PREF_VCT_PORT, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.indago_vct_port), edit);
                UASConfigSelector.checkPutTextPref(IndagoPrefHandler.PREF_SRC_IP, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.indago_video_ip), edit);
                UASConfigSelector.checkPutTextPref(IndagoPrefHandler.PREF_SRC_PORT, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.indago_video_port), edit);
                UASConfigSelector.checkPutTextPref(MAVLinkPrefHandler.PREF_MAVLINK_NETWORK_TYPE, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.mavlink_network_type), edit);
                UASConfigSelector.checkPutTextPref(MAVLinkPrefHandler.PREF_SRC_ADAPTER, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.mavlink_video_source_adapter), edit);
                UASConfigSelector.checkPutTextPref(MAVLinkPrefHandler.PREF_PLATFORM_MAVLINK_IP, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.mavlink_ip), edit);
                UASConfigSelector.checkPutTextPref(MAVLinkPrefHandler.PREF_PLATFORM_MAVLINK_PORT, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.mavlink_port), edit);
                UASConfigSelector.checkPutTextPref(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.mavlink_video_uri), edit);
                UASConfigSelector.checkPutTextPref(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI2, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.mavlink_video_uri2), edit);
                UASConfigSelector.checkPutTextPref(GenericPrefHandler.PREF_SRC_ADAPTER, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.generic_video_source_adapter), edit);
                UASConfigSelector.checkPutTextPref(GenericPrefHandler.PREF_VIDEO_SRC_URI, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.generic_video_uri), edit);
                UASConfigSelector.checkPutTextPref(GenericPrefHandler.PREF_COT_DEST_IP, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.generic_cot_dst_ip), edit);
                UASConfigSelector.checkPutTextPref(GenericPrefHandler.PREF_COT_DEST_PORT, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.generic_cot_dst_port), edit);
                UASConfigSelector.checkPutTextPref(R80dPrefHandler.PREF_PLATFORM_SERIAL, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.r80d_platform_serial), edit);
                UASConfigSelector.checkPutTextPref(TrilliumPrefHandler.PREF_SRC_ADAPTER, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.trillium_video_source_adapter), edit);
                UASConfigSelector.checkPutTextPref(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_IP, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.trillium_sdk_ip), edit);
                UASConfigSelector.checkPutTextPref(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_PORT, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.trillium_sdk_port), edit);
                UASConfigSelector.checkPutTextPref(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_VIDEO_BUFFERING, UASConfigSelector.this.customLayout.findViewById(C1877R.C1878id.trillium_video_buffering), edit);
                UASConfigSelector.checkPutTextPref(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, findViewById, edit);
                if (UASConfigSelector.this.alf != null) {
                    if (UASConfigSelector.this.alf.getListAdapter() != null) {
                        UASConfigSelector.this.alf.getListAdapter().removeItemSelectedListener(UASConfigSelector.this);
                    }
                    UASConfigSelector.this.alf.save();
                    UASConfigSelector.this.alf.dispose();
                }
                edit.apply();
                defaultSharedPreferences.unregisterOnSharedPreferenceChangeListener(UASConfigSelector.this);
            }
        });
        builder.setCancelable(true);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (UASConfigSelector.this.alf != null) {
                    if (UASConfigSelector.this.alf.getListAdapter() != null) {
                        UASConfigSelector.this.alf.getListAdapter().removeItemSelectedListener(UASConfigSelector.this);
                    }
                    UASConfigSelector.this.alf.dispose();
                }
                defaultSharedPreferences.unregisterOnSharedPreferenceChangeListener(UASConfigSelector.this);
            }
        });
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.config_DJI_TextView)).setText(InstallAssetApk.getInstance().checkDependencies(DJIUASItem.DISPLAY_NAME) ? "No Additional Settings" : "Install or update support apps");
        populateNetworkDropdown(this.customLayout.findViewById(C1877R.C1878id.av_video_source_adapter), defaultSharedPreferences.getString(AvPrefHandler.PREF_SRC_ADAPTER, ""));
        populateNetworkDropdown(this.customLayout.findViewById(C1877R.C1878id.pd100_video_source_adapter), defaultSharedPreferences.getString(PD100PrefHandler.PREF_SRC_ADAPTER, ""));
        TextView textView = (TextView) this.customLayout.findViewById(C1877R.C1878id.pd100_video_ip);
        textView.setText(defaultSharedPreferences.getString(PD100PrefHandler.PREF_SRC_IP, ""));
        textView.setFilters(new InputFilter[]{new NetworkPreferenceFragment.HostnameIpFilter()});
        textView.addTextChangedListener(new NetworkPreferenceFragment.HostOrIpWatcher(textView));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.pd100_video_port)).setText(defaultSharedPreferences.getString(PD100PrefHandler.PREF_SRC_PORT, ""));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.pd100_cot_udp_port)).setText(defaultSharedPreferences.getString(PD100PrefHandler.PREF_COT_UDP_PORT, ""));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.pd100_cot_tcp_port)).setText(defaultSharedPreferences.getString(PD100PrefHandler.PREF_COT_TCP_PORT, ""));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.indago_vct_ip)).setText(defaultSharedPreferences.getString(IndagoPrefHandler.PREF_VCT_IP, IndagoPrefHandler.DEFAULT_VCT_IP));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.indago_vct_port)).setText(defaultSharedPreferences.getString(IndagoPrefHandler.PREF_VCT_PORT, IndagoPrefHandler.DEFAULT_VCT_PORT));
        populateNetworkDropdown(this.customLayout.findViewById(C1877R.C1878id.indago_video_source_adapter), defaultSharedPreferences.getString(IndagoPrefHandler.PREF_SRC_ADAPTER, ""));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.indago_video_ip)).setText(defaultSharedPreferences.getString(IndagoPrefHandler.PREF_SRC_IP, IndagoPrefHandler.DEFAULT_SRC_IP));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.indago_video_port)).setText(defaultSharedPreferences.getString(IndagoPrefHandler.PREF_SRC_PORT, IndagoPrefHandler.DEFAULT_SRC_PORT));
        populateMavLinkNetworkType(this.customLayout.findViewById(C1877R.C1878id.mavlink_network_type), defaultSharedPreferences.getString(MAVLinkPrefHandler.PREF_MAVLINK_NETWORK_TYPE, MAVLinkPrefHandler.DEFAULT_MAVLINK_NETWORK_TYPE));
        populateNetworkDropdown(this.customLayout.findViewById(C1877R.C1878id.mavlink_video_source_adapter), defaultSharedPreferences.getString(MAVLinkPrefHandler.PREF_SRC_ADAPTER, ""));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.mavlink_ip)).setText(defaultSharedPreferences.getString(MAVLinkPrefHandler.PREF_PLATFORM_MAVLINK_IP, "127.0.0.1"));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.mavlink_port)).setText(defaultSharedPreferences.getString(MAVLinkPrefHandler.PREF_PLATFORM_MAVLINK_PORT, MAVLinkPrefHandler.DEFAULT_PLATFORM_MAVLINK_PORT));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.mavlink_video_uri)).setText(defaultSharedPreferences.getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI, MAVLinkPrefHandler.DEFAULT_VIDEO_SRC_URI));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.mavlink_video_uri2)).setText(defaultSharedPreferences.getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI2, ""));
        PluginSpinner findViewById2 = this.customLayout.findViewById(C1877R.C1878id.mavlink_network_type);
        boolean z = !findViewById2.getSelectedItem().equals(MAVLinkPrefHandler.DEFAULT_MAVLINK_DIALECT);
        boolean z2 = z && (findViewById2.getSelectedItem().equals("UDP_CLIENT") || findViewById2.getSelectedItem().equals("TCP"));
        boolean z3 = z && !findViewById2.getSelectedItem().equals("SERIAL");
        final LinearLayout linearLayout = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_layout_mavlink_ip);
        final LinearLayout linearLayout2 = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_layout_mavlink_port);
        final LinearLayout linearLayout3 = (LinearLayout) this.customLayout.findViewById(C1877R.C1878id.config_layout_mavlink_video);
        int i = 8;
        linearLayout.setVisibility(z2 ? 0 : 8);
        linearLayout2.setVisibility(z3 ? 0 : 8);
        if (z) {
            i = 0;
        }
        linearLayout3.setVisibility(i);
        final PluginSpinner pluginSpinner = findViewById2;
        findViewById2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                boolean z = true;
                boolean z2 = !pluginSpinner.getSelectedItem().equals(MAVLinkPrefHandler.DEFAULT_MAVLINK_DIALECT);
                int i2 = 0;
                boolean z3 = z2 && (pluginSpinner.getSelectedItem().equals("UDP_CLIENT") || pluginSpinner.getSelectedItem().equals("TCP"));
                if (!z2 || pluginSpinner.getSelectedItem().equals("SERIAL")) {
                    z = false;
                }
                linearLayout.setVisibility(z3 ? 0 : 8);
                linearLayout2.setVisibility(z ? 0 : 8);
                LinearLayout linearLayout = linearLayout3;
                if (!z2) {
                    i2 = 8;
                }
                linearLayout.setVisibility(i2);
            }
        });
        toggleConfigScreen(defaultSharedPreferences.getString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, this.platforms.get(0)));
        populateNetworkDropdown(this.customLayout.findViewById(C1877R.C1878id.generic_video_source_adapter), defaultSharedPreferences.getString(GenericPrefHandler.PREF_SRC_ADAPTER, ""));
        GenericPrefHandler.checkUpdatePref(defaultSharedPreferences);
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.generic_video_uri)).setText(defaultSharedPreferences.getString(GenericPrefHandler.PREF_VIDEO_SRC_URI, ""));
        TextView textView2 = (TextView) this.customLayout.findViewById(C1877R.C1878id.generic_cot_dst_ip);
        textView2.setText(defaultSharedPreferences.getString(PD100PrefHandler.PREF_SRC_IP, ""));
        textView2.setFilters(new InputFilter[]{new NetworkPreferenceFragment.HostnameIpFilter()});
        textView2.addTextChangedListener(new NetworkPreferenceFragment.HostOrIpWatcher(textView2));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.generic_cot_dst_port)).setText(defaultSharedPreferences.getString(GenericPrefHandler.PREF_COT_DEST_PORT, ""));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.r80d_platform_serial)).setText(defaultSharedPreferences.getString(R80dPrefHandler.PREF_PLATFORM_SERIAL, ""));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.trillium_sdk_ip)).setText(defaultSharedPreferences.getString(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_IP, "127.0.0.1"));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.trillium_sdk_port)).setText(defaultSharedPreferences.getString(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_PORT, TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_PORT));
        ((TextView) this.customLayout.findViewById(C1877R.C1878id.trillium_video_buffering)).setText(defaultSharedPreferences.getString(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_VIDEO_BUFFERING, TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_VIDEO_BUFFERING));
        populateNetworkDropdown(this.customLayout.findViewById(C1877R.C1878id.trillium_video_source_adapter), defaultSharedPreferences.getString(TrilliumPrefHandler.PREF_SRC_ADAPTER, ""));
        AlertDialog create = builder.create();
        this.selectorDialog = create;
        create.show();
    }

    /* access modifiers changed from: private */
    public void toggleConfigScreen(int i) {
        if (this.alf.getListAdapter() != null) {
            this.alf.getListAdapter().removeItemSelectedListener(this);
            this.alf.dispose();
        }
        this.alf.setVisibility(8);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
        PluginSpinner findViewById = this.customLayout.findViewById(C1877R.C1878id.config_platform_spinner);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        for (int i2 = 1; i2 < this.platforms.size(); i2++) {
            int i3 = 0;
            if (i == i2 && i2 == CONFIG_ID.MAVLINK.value) {
                this.alf.init(this.customLayout.findViewById(C1877R.C1878id.avahi_list_layout), new MavlinkAvahiService(MapView.getMapView().getContext()));
                this.alf.getListAdapter().addItemSelectedListener(this);
                this.alf.setVisibility(0);
            } else if (i == i2 && i2 == CONFIG_ID.R80D.value) {
                checkPutTextPref(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, findViewById, edit);
                this.alf.init(this.customLayout.findViewById(C1877R.C1878id.avahi_list_layout), new R80DAvahiService(MapView.getMapView().getContext()));
                this.alf.getListAdapter().addItemSelectedListener(this);
                this.alf.setVisibility(0);
            } else if (i == i2 && i2 == CONFIG_ID.PD100.value) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(AvahiService.SERVICE_TYPE_BH3_4586);
                arrayList.add(AvahiService.SERVICE_TYPE_COT_UDP);
                this.alf.init(this.customLayout.findViewById(C1877R.C1878id.avahi_list_layout), new AvahiService(MapView.getMapView().getContext(), arrayList));
                this.alf.getListAdapter().addItemSelectedListener(this);
                this.alf.setVisibility(0);
            }
            LinearLayout linearLayout = config_layouts[i2];
            if (i != i2) {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        }
        edit.apply();
    }

    private void toggleConfigScreen(String str) {
        int indexOf = this.platforms.indexOf(str);
        toggleConfigScreen(indexOf);
        this.customLayout.findViewById(C1877R.C1878id.config_platform_spinner).setSelection(indexOf);
    }

    /* access modifiers changed from: private */
    public static void checkPutTextPref(String str, View view, SharedPreferences.Editor editor) {
        TextView textView;
        try {
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else if (view instanceof PluginSpinner) {
                textView = (TextView) ((PluginSpinner) view).getSelectedView();
            } else {
                String str2 = TAG;
                Log.e(str2, "Cannot load preference:" + str);
                return;
            }
            if (textView.getText() == null) {
                return;
            }
            if (textView.getText().toString().trim().length() == 0) {
                editor.remove(str);
            } else {
                editor.putString(str, textView.getText().toString().trim());
            }
        } catch (Exception e) {
            String str3 = TAG;
            Log.e(str3, "Error Saving preference: " + e.getMessage());
        }
    }

    private void populateMavLinkNetworkType(PluginSpinner pluginSpinner, String str) {
        MavlinkVehicle.NETWORK_TYPE[] values = MavlinkVehicle.NETWORK_TYPE.values();
        int length = values.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = values[i].name();
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, C1877R.layout.spinner_text_white_view, strArr);
        arrayAdapter.setDropDownViewResource(17367049);
        pluginSpinner.setAdapter(arrayAdapter);
        if (str != null) {
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equals(strArr[i2])) {
                    pluginSpinner.setSelection(i2);
                }
            }
        }
    }

    private void populateNetworkDropdown(PluginSpinner pluginSpinner, String str) {
        String[] networkDeviceList = NetworkPreferenceFragment.getNetworkDeviceList();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, C1877R.layout.spinner_text_white_view, networkDeviceList);
        arrayAdapter.setDropDownViewResource(17367049);
        pluginSpinner.setAdapter(arrayAdapter);
        if (str != null) {
            for (int i = 0; i < networkDeviceList.length; i++) {
                if (str.equals(networkDeviceList[i])) {
                    pluginSpinner.setSelection(i);
                }
            }
        }
    }

    public void onAvahiItemSelected(AvahiServiceInfo avahiServiceInfo) {
        byte[] address;
        String str = TAG;
        Log.d(str, "onAvahiItemSelected: " + avahiServiceInfo.getServiceName());
        PluginSpinner findViewById = this.customLayout.findViewById(C1877R.C1878id.config_platform_spinner);
        if (findViewById.getSelectedItemPosition() == CONFIG_ID.MAVLINK.value) {
            if (avahiServiceInfo.getServiceType().contains("_mavlink")) {
                TextView textView = (TextView) this.customLayout.findViewById(C1877R.C1878id.mavlink_ip);
                TextView textView2 = (TextView) this.customLayout.findViewById(C1877R.C1878id.mavlink_port);
                TextView textView3 = (TextView) this.customLayout.findViewById(C1877R.C1878id.mavlink_video_uri);
                TextView textView4 = (TextView) this.customLayout.findViewById(C1877R.C1878id.mavlink_video_uri2);
                PluginSpinner findViewById2 = this.customLayout.findViewById(C1877R.C1878id.mavlink_network_type);
                if (avahiServiceInfo.getServiceType().contains("client")) {
                    findViewById2.setSelection(MavlinkVehicle.NETWORK_TYPE.UDP_CLIENT.index);
                } else if (avahiServiceInfo.getServiceType().contains("udp")) {
                    findViewById2.setSelection(MavlinkVehicle.NETWORK_TYPE.UDP.index);
                } else if (avahiServiceInfo.getServiceType().contains("tcp")) {
                    findViewById2.setSelection(MavlinkVehicle.NETWORK_TYPE.TCP.index);
                }
                textView2.setText(avahiServiceInfo.getPort() + "");
                Map<String, String> attributes = avahiServiceInfo.getAttributes();
                if (attributes != null) {
                    for (String next : attributes.keySet()) {
                        if (next.equals("uri") || next.equals("camera1")) {
                            textView3.setText(attributes.get(next));
                        } else if (next.equals("uri2") || next.equals("camera2")) {
                            textView4.setText(attributes.get(next));
                        }
                    }
                }
                if (attributes.containsKey("ip")) {
                    textView.setText(attributes.get("ip"));
                } else if (avahiServiceInfo.getHost() != null && (address = avahiServiceInfo.getHost().getAddress()) != null && address.length >= 4) {
                    textView.setText(String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(address[0] & 255), Integer.valueOf(address[1] & 255), Integer.valueOf(address[2] & 255), Integer.valueOf(address[3] & 255)}));
                }
            }
        } else if (findViewById.getSelectedItemPosition() == CONFIG_ID.R80D.value) {
            TextView textView5 = (TextView) this.customLayout.findViewById(C1877R.C1878id.r80d_platform_serial);
            if (avahiServiceInfo.getPort() == 0) {
                textView5.setText("");
                return;
            }
            textView5.setText(avahiServiceInfo.getPort() + "");
        } else if (findViewById.getSelectedItemPosition() == CONFIG_ID.PD100.value) {
            Log.d(str, "onAvahiItemSelected: BH3");
            if (avahiServiceInfo.getServiceType().contains(AvahiService.SERVICE_TYPE_BH3_4586)) {
                Log.d(str, "onAvahiItemSelected: BH3 4586");
                this.selectorDialog.getButton(-1).performClick();
                PD100Monitor.waitForPlatformSwitch(avahiServiceInfo.getServiceName(), avahiServiceInfo.getAttributes().get("tx_address"), Utils.parseInt(avahiServiceInfo.getAttributes().get("tx_port"), 0), avahiServiceInfo.getIpAddress(), avahiServiceInfo.getPort(), avahiServiceInfo.getHost(), PD100Monitor.ProtocolSelection.STANAG4586);
            }
            if (avahiServiceInfo.getServiceType().contains(AvahiService.SERVICE_TYPE_COT_UDP)) {
                Log.d(str, "onAvahiItemSelected: BH3 cot");
                this.selectorDialog.getButton(-1).performClick();
                PD100Monitor.waitForPlatformSwitch(avahiServiceInfo.getServiceName(), avahiServiceInfo.getAttributes().get("tx_address"), Utils.parseInt(avahiServiceInfo.getAttributes().get("tx_port"), 0), avahiServiceInfo.getIpAddress(), avahiServiceInfo.getPort(), avahiServiceInfo.getHost(), PD100Monitor.ProtocolSelection.COT);
            }
        }
    }

    public static void cyclePlatformMonitor() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
        String string = defaultSharedPreferences.getString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, "None Selected");
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, "None Selected");
        edit.apply();
        edit.putString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, string);
        edit.commit();
    }
}
