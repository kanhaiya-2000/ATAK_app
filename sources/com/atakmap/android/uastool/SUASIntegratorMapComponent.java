package com.atakmap.android.uastool;

import android.content.Context;
import android.content.Intent;
import atak.core.aq;
import com.atakmap.android.dropdown.DropDownMapComponent;
import com.atakmap.android.importexport.ImportExportMapComponent;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.flightlog.FlightLogImporter;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.plugin.DroneMarkerDetailHandler;
import com.atakmap.android.uastool.utils.DocUtils;
import com.atakmap.android.uastool.utils.InstallAssetApk;

public class SUASIntegratorMapComponent extends DropDownMapComponent {
    public static final int NOTIFICATION_ID = 501734;
    private static final String TAG = "SUASIntegratorMapComponent";
    private static SUASIntegratorMapComponent _instance;
    private DroneMarkerDetailHandler droneMarkerDetailHandler;
    private UASToolDropDownReceiver dropDown;
    private FlightLogImporter flightLogImporter;
    private Context pluginContext;

    public Context getPluginContext() {
        return this.pluginContext;
    }

    /* JADX WARNING: type inference failed for: r1v11, types: [com.atakmap.android.uastool.UASToolDropDownReceiver, android.content.BroadcastReceiver] */
    public void onCreate(Context context, Intent intent, MapView mapView) {
        this.pluginContext = context;
        DocUtils.installSupportDocs(context);
        this.pluginContext.setTheme(C1877R.style.ATAKPluginTheme);
        UASToolDropDownReceiver.initialize(mapView, context);
        this.dropDown = UASToolDropDownReceiver.getInstance();
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter.a(UASToolDropDownReceiver.SHOW_UASTOOL, "Show the " + context.getString(C1877R.string.app_name) + " drop-down");
        documentedIntentFilter.a(UASToolDropDownReceiver.TOGGLE_UAS_ROUTE, "Show/hide the selected UAS route");
        documentedIntentFilter.a(UASToolDropDownReceiver.SELECT_UAS_OVERLAY, "Select map overlay items for the selected UAS");
        documentedIntentFilter.a(UASToolDropDownReceiver.SHOW_UAS_LIST, "Show the UAS List for the selected UAS");
        documentedIntentFilter.a(UASToolDropDownReceiver.EDIT_UAS_ROUTE, "Show the view to edit a UAS Route");
        documentedIntentFilter.a(UASToolDropDownReceiver.ROUTE_WAYPOINT_DELETE, "Show the view to remove a UAS Route waypoint");
        documentedIntentFilter.a(UASToolDropDownReceiver.SHOW_WAYPOINT_DETAILS, "Show the view of a specific UAS Route waypoint");
        documentedIntentFilter.a(UASToolDropDownReceiver.SHOW_UAS_TASK_LIST, "Show the UAS Task List for the selected UAS");
        documentedIntentFilter.a(UASToolDropDownReceiver.REJECT_UAS_TASK_POINT, "Reject tasking to the UAS task point for the selected UAS");
        registerReceiver(context, this.dropDown, documentedIntentFilter);
        this.droneMarkerDetailHandler = new DroneMarkerDetailHandler(this.pluginContext);
        aq.a().a(this.droneMarkerDetailHandler.getMetaName(), this.droneMarkerDetailHandler);
        this.flightLogImporter = new FlightLogImporter(".json");
        ImportExportMapComponent.a().a(this.flightLogImporter);
        SUASIntegratorMapComponent.super.onCreate(context, intent, mapView);
        InstallAssetApk.getInstance().checkAndInstallDependencies((String) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroyImpl(Context context, MapView mapView) {
        aq.a().a(this.droneMarkerDetailHandler);
        ImportExportMapComponent.a().b(this.flightLogImporter);
        UASToolDropDownReceiver uASToolDropDownReceiver = this.dropDown;
        if (uASToolDropDownReceiver != null) {
            uASToolDropDownReceiver.dispose();
        }
        SUASIntegratorMapComponent.super.onDestroyImpl(context, mapView);
    }

    public static SUASIntegratorMapComponent getInstance() {
        if (_instance == null) {
            _instance = new SUASIntegratorMapComponent();
        }
        return _instance;
    }

    public DroneMarkerDetailHandler getDroneMarkerDetailHandler() {
        return this.droneMarkerDetailHandler;
    }
}
