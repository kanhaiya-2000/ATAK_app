package com.atakmap.android.uastool.flightlog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import atak.core.lp;
import com.atakmap.android.contact.c;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.o;
import com.atakmap.android.menu.k;
import com.atakmap.android.missionpackage.MissionPackageMapComponent;
import com.atakmap.android.missionpackage.file.MissionPackageManifest;
import com.atakmap.android.missionpackage.file.task.MissionPackageBaseTask;
import com.atakmap.android.overlay.b;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.overlays.mapshot.MapShotController;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.AtakPrefConstants;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.utils.UasMapItemIconUtil;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.user.g;
import com.atakmap.android.util.ae;
import com.atakmap.coremap.conversions.Angle;
import com.atakmap.coremap.conversions.AngleUtilities;
import com.atakmap.coremap.conversions.CoordinateFormatUtilities;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.io.File;

public class FlightLogScreen extends UASToolScreen implements SharedPreferences.OnSharedPreferenceChangeListener {
    private String DASH;
    private TextView altView;
    private TextView commView;
    private TextView dateView;
    private TextView hdrView;
    private Boolean isFLightLogShowing;
    private FlightLogItem lastLogItem;
    /* access modifiers changed from: private */
    public FlightLogAdapter listViewAdapter;
    private TextView locView;
    /* access modifiers changed from: private */
    public MapView mapView;
    private TextView messView;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private TextView spdView;
    /* access modifiers changed from: private */
    public ag uasGroup;
    private int viewIndex;
    /* access modifiers changed from: private */
    public FlightLog viewLog;

    public FlightLogScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = FlightLogScreen.class.getSimpleName();
        UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.DASH = this.pluginContext.getResources().getString(C1877R.string.dashdashdash);
        this.isFLightLogShowing = false;
        this.lastLogItem = null;
        MapView mapView2 = UASToolDropDownReceiver.getInstance().getMapView();
        this.mapView = mapView2;
        ag c = mapView2.getRootGroup().c(MapShotController.UAS_GROUP_NAME);
        this.uasGroup = c;
        if (c == null) {
            this.uasGroup = new o(MapShotController.UAS_GROUP_NAME);
            this.mapView.getMapOverlayManager().f(new b(this.mapView, this.uasGroup));
        }
        ((ImageButton) findViewById(C1877R.C1878id.flightlog_refresh)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FlightLogScreen.this.refreshList(true);
            }
        });
        ((ImageButton) findViewById(C1877R.C1878id.flightlog_delete_all)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FlightLogScreen.this.askDeleteAllLogs();
            }
        });
        FlightLogAdapter flightLogAdapter = new FlightLogAdapter(this.pluginContext, this, FlightLogger.getInstance().getLogNames(true));
        this.listViewAdapter = flightLogAdapter;
        ((ListView) findViewById(C1877R.C1878id.flightlog_list)).setAdapter(flightLogAdapter);
        refresh();
    }

    public void refresh() {
        refreshList(false);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
        hideAllFlightLog();
    }

    public void viewLog(FlightLog flightLog, LinearLayout linearLayout) {
        this.viewLog = flightLog;
        this.viewIndex = 0;
        this.prevButton = (ImageButton) linearLayout.findViewById(C1877R.C1878id.flightlog_view_prev);
        this.nextButton = (ImageButton) linearLayout.findViewById(C1877R.C1878id.flightlog_view_next);
        this.dateView = (TextView) linearLayout.findViewById(C1877R.C1878id.flightlog_data_values_date);
        this.locView = (TextView) linearLayout.findViewById(C1877R.C1878id.flightlog_data_values_loc);
        this.altView = (TextView) linearLayout.findViewById(C1877R.C1878id.flightlog_data_values_alt);
        this.spdView = (TextView) linearLayout.findViewById(C1877R.C1878id.flightlog_data_values_spd);
        this.hdrView = (TextView) linearLayout.findViewById(C1877R.C1878id.flightlog_data_values_head);
        this.messView = (TextView) linearLayout.findViewById(C1877R.C1878id.flightlog_data_values_mess);
        this.commView = (TextView) linearLayout.findViewById(C1877R.C1878id.flightlog_data_values_comm);
        FlightLogItem item = this.viewLog.getItem(this.viewIndex);
        if (item != null) {
            fillLogView(item.getDateTime(), item.getLatitude(), item.getLongitude(), item.getAltitude(), item.getSpeed(), item.getHeading(), item.getMessage(), item.getCommand());
        } else {
            String str = this.DASH;
            fillLogView(str, str, str, str, str, str, str, str);
        }
        updateViewButtons();
    }

    public void viewLogPrev() {
        FlightLog flightLog = this.viewLog;
        if (flightLog != null) {
            int i = this.viewIndex - 1;
            this.viewIndex = i;
            if (i < 0) {
                this.viewIndex = 0;
            } else {
                FlightLogItem item = flightLog.getItem(i);
                if (item != null) {
                    fillLogView(item.getDateTime(), item.getLatitude(), item.getLongitude(), item.getAltitude(), item.getSpeed(), item.getHeading(), item.getMessage(), item.getCommand());
                    changeMarkerIcon(item);
                } else {
                    String str = this.DASH;
                    fillLogView(str, str, str, str, str, str, str, str);
                }
            }
            updateViewButtons();
            return;
        }
        UASToolDropDownReceiver.toast("Missing flight log to view data", 0);
    }

    public void viewLogNext() {
        FlightLog flightLog = this.viewLog;
        if (flightLog != null) {
            int i = this.viewIndex + 1;
            this.viewIndex = i;
            if (i >= flightLog.getItemCount()) {
                this.viewIndex = this.viewLog.getItemCount() - 1;
            } else {
                FlightLogItem item = this.viewLog.getItem(this.viewIndex);
                if (item != null) {
                    fillLogView(item.getDateTime(), item.getLatitude(), item.getLongitude(), item.getAltitude(), item.getSpeed(), item.getHeading(), item.getMessage(), item.getCommand());
                    changeMarkerIcon(item);
                } else {
                    String str = this.DASH;
                    fillLogView(str, str, str, str, str, str, str, str);
                }
            }
            updateViewButtons();
            return;
        }
        UASToolDropDownReceiver.toast("Missing flight log to view data", 0);
    }

    public void viewLogIndex(int i) {
        FlightLog flightLog = this.viewLog;
        if (flightLog != null) {
            FlightLogItem item = flightLog.getItem(i);
            if (item != null) {
                this.viewIndex = i;
                fillLogView(item.getDateTime(), item.getLatitude(), item.getLongitude(), item.getAltitude(), item.getSpeed(), item.getHeading(), item.getMessage(), item.getCommand());
                changeMarkerIcon(item);
            } else {
                UASToolDropDownReceiver.toast("Flight log index out of bounds: " + i, 0);
                String str = this.DASH;
                fillLogView(str, str, str, str, str, str, str, str);
            }
            updateViewButtons();
            return;
        }
        UASToolDropDownReceiver.toast("Missing flight log to view data", 0);
    }

    private void fillLogView(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.dateView.setText(str);
        this.locView.setText(formatCoordinateText(str2, str3, str4));
        if (!str4.isEmpty()) {
            this.altView.setText(formatAltitudeText(str2, str3, str4));
        } else {
            this.altView.setText(this.DASH);
        }
        if (!str5.isEmpty()) {
            this.spdView.setText(formatSpeedText(str5));
        } else {
            this.spdView.setText(this.DASH);
        }
        if (!str6.isEmpty()) {
            this.hdrView.setText(formatHeadingText(str6, str2, str3));
        } else {
            this.hdrView.setText(this.DASH);
        }
        this.messView.setText(str7);
        this.commView.setText(str8);
    }

    private void updateViewButtons() {
        int i = this.viewIndex;
        if (i <= 0) {
            this.prevButton.setEnabled(false);
            this.nextButton.setEnabled(true);
        } else if (i >= this.viewLog.getItemCount() - 1) {
            this.prevButton.setEnabled(true);
            this.nextButton.setEnabled(false);
        } else {
            this.prevButton.setEnabled(true);
            this.nextButton.setEnabled(true);
        }
    }

    public void askDeleteLog(final FlightLog flightLog) {
        AlertDialog.Builder title = new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Delete Log");
        title.setMessage("Are you sure you want to delete flight log " + flightLog.getFileTitle() + "?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FlightLogScreen.this.removeLogMarkers(flightLog);
                FlightLogScreen.this.deleteLog(flightLog);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void deleteLog(FlightLog flightLog) {
        if (!FlightLogger.getInstance().deleteLogFile(flightLog.getFileName())) {
            UASToolDropDownReceiver.toast("Failed to delete flight log: " + flightLog.getFileName(), 0);
            String str = TAG;
            Log.w(str, "Failed to delete flight log: " + flightLog.getFileName());
        }
        refreshList(false);
    }

    public synchronized void sendLog(final FlightLog flightLog) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    MissionPackageManifest a = lp.a(flightLog.getFileName(), true, true, (String) null);
                    File file = new File(flightLog.getFilePath());
                    if (FileSystemUtils.isFile(file)) {
                        a.addFile(file, FlightLogImporter.LOG_FILE_ID + flightLog.getUid());
                        MissionPackageMapComponent.a().c().save(a, new MissionPackageBaseTask.Callback() {
                            public void onMissionPackageTaskComplete(MissionPackageBaseTask missionPackageBaseTask, boolean z) {
                                if (!z || missionPackageBaseTask == null || missionPackageBaseTask.getManifest() == null) {
                                    Log.w(FlightLogScreen.TAG, "Failed to export flight log data package");
                                    UASToolDropDownReceiver.toast("Failed to export flight log data package", 0);
                                    return;
                                }
                                lp.a(FlightLogScreen.this.mapView.getContext(), missionPackageBaseTask.getManifest(), (Class) null, (c[]) null, true);
                            }
                        });
                        return;
                    }
                    Log.w(FlightLogScreen.TAG, "Failed to add flight log to data package");
                    UASToolDropDownReceiver.toast("Failed to add flight log to data package", 0);
                } catch (Exception e) {
                    Log.e(FlightLogScreen.TAG, "Error removing flight log marker ", e);
                }
            }
        }).start();
    }

    public void askDeleteAllLogs() {
        new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Delete All Logs").setMessage("Are you sure you want to delete all flight logs?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FlightLogScreen.this.deleteAllLogs();
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void deleteAllLogs() {
        FlightLogger.getInstance().deleteAllLogFiles();
        removeAllLogMarkers();
        refreshList(false);
    }

    public void refreshList(final boolean z) {
        ((Activity) this.mapView.getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (z) {
                    UASToolDropDownReceiver.toast("refreshing flight log list...", 0);
                }
                if (FlightLogScreen.this.listViewAdapter != null) {
                    FlightLogScreen.this.listViewAdapter.clear();
                    FlightLogScreen.this.listViewAdapter.addAll(FlightLogger.getInstance().getLogNames(true));
                    FlightLogScreen.this.listViewAdapter.refresh();
                    FlightLogScreen.this.listViewAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public ao createFlightLogMarker(String str, FlightLogItem flightLogItem) {
        if (flightLogItem == null) {
            return null;
        }
        g.a aVar = new g.a(new GeoPoint(Double.parseDouble(flightLogItem.getLatitude()), Double.parseDouble(flightLogItem.getLongitude()), Double.parseDouble(flightLogItem.getAltitude())));
        aVar.a("b-m-p-w-uas-log");
        aVar.b(flightLogItem.getUID());
        aVar.a(-1);
        aVar.f(false);
        aVar.d(true);
        aVar.e(false);
        aVar.e(str);
        ao a = aVar.a();
        a.setEditable(true);
        a.setMovable(false);
        a.b(false);
        a.c(false);
        a.setMetaString(UASPoint.COTDETAIL_LAT, flightLogItem.getLatitude());
        a.setMetaString(UASPoint.COTDETAIL_LON, flightLogItem.getLongitude());
        a.setMetaString(UASPoint.COTDETAIL_ALT, flightLogItem.getAltitude());
        a.setMetaString(UASPoint.COTDETAIL_SPEED, flightLogItem.getSpeed());
        a.setMetaString("heading", flightLogItem.getHeading());
        a.setMetaBoolean("removable", true);
        a.setMetaBoolean("markerIcon", true);
        a.setMetaString("menu", "");
        a.setTitle(str);
        a.a(UasMapItemIconUtil.buildIcon(C1877R.drawable.ic_self_white, UasMapItemIconUtil.ICON_SIZE.SMALLER, UasMapItemIconUtil.ICON_ANCHOR.BOTTOM_CENTER, -1));
        a.c(a.k() | 1 | 32);
        if (flightLogItem.getHeading().isEmpty()) {
            return a;
        }
        a.a(Double.parseDouble(flightLogItem.getHeading()), Double.parseDouble(flightLogItem.getSpeed()));
        return a;
    }

    /* access modifiers changed from: private */
    public void changeMarkerIcon(FlightLogItem flightLogItem) {
        if (flightLogItem != null) {
            try {
                FlightLogItem flightLogItem2 = this.lastLogItem;
                if (flightLogItem2 != null) {
                    ao b = this.uasGroup.b(flightLogItem2.getUID());
                    if (b != null) {
                        b.a(UasMapItemIconUtil.buildIcon(C1877R.drawable.ic_self_white, UasMapItemIconUtil.ICON_SIZE.SMALLER, UasMapItemIconUtil.ICON_ANCHOR.BOTTOM_CENTER, -1));
                        b.setMetaString("zindex", "1");
                        b.setMetaString("menu", "");
                        b.b(false);
                        b.c(false);
                    }
                }
                ao b2 = this.uasGroup.b(flightLogItem.getUID());
                if (b2 != null) {
                    b2.a(UasMapItemIconUtil.buildIcon(C1877R.drawable.uav_rotary, UasMapItemIconUtil.ICON_SIZE.SMALL, UasMapItemIconUtil.ICON_ANCHOR.BOTTOM_CENTER, -256));
                    b2.setMetaString("zindex", "9999");
                    b2.setMetaString("menu", getMenu());
                    b2.b(true);
                    b2.c(true);
                    b2.c(1 | b2.k() | 32);
                    if (!flightLogItem.getHeading().isEmpty()) {
                        b2.a(Double.parseDouble(flightLogItem.getHeading()), Double.parseDouble(flightLogItem.getSpeed()));
                    }
                    this.mapView.getMapController().panTo(b2.C(), false);
                }
            } catch (Exception e) {
                Log.e(TAG, "Error changing flight log marker ", e);
            }
            this.lastLogItem = flightLogItem;
        }
    }

    public void displayFlightLog() {
        removeAllLogMarkers();
        drawAllLogMarkers();
    }

    public void hideAllFlightLog() {
        removeAllLogMarkers();
    }

    public void hideFlightLog(FlightLog flightLog) {
        removeLogMarkers(flightLog);
    }

    private synchronized void drawAllLogMarkers() {
        if (!this.isFLightLogShowing.booleanValue()) {
            this.isFLightLogShowing = true;
            new Thread(new Runnable() {
                public void run() {
                    int i = 0;
                    while (i < FlightLogScreen.this.viewLog.getItemCount()) {
                        try {
                            FlightLogItem item = FlightLogScreen.this.viewLog.getItem(i);
                            if (item != null) {
                                if (i == 0) {
                                    FlightLogScreen.this.panToPoint(item);
                                }
                                FlightLogScreen flightLogScreen = FlightLogScreen.this;
                                ao access$1000 = flightLogScreen.createFlightLogMarker(flightLogScreen.viewLog.getCallsign(), item);
                                if (access$1000 != null) {
                                    FlightLogScreen.this.uasGroup.d(access$1000);
                                }
                            }
                            i++;
                        } catch (Exception e) {
                            Log.e(FlightLogScreen.TAG, "Error creating flight log marker ", e);
                            return;
                        }
                    }
                    FlightLogItem item2 = FlightLogScreen.this.viewLog.getItem(0);
                    if (item2 != null) {
                        FlightLogScreen.this.changeMarkerIcon(item2);
                    }
                }
            }).start();
        }
    }

    private synchronized void removeAllLogMarkers() {
        if (this.isFLightLogShowing.booleanValue()) {
            this.isFLightLogShowing = false;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        for (ao aoVar : FlightLogScreen.this.uasGroup.d("type", "b-m-p-w-uas-log")) {
                            if (aoVar != null) {
                                FlightLogScreen.this.uasGroup.g(aoVar);
                            }
                        }
                    } catch (Exception e) {
                        Log.e(FlightLogScreen.TAG, "Error removing flight log marker ", e);
                    }
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void removeLogMarkers(final FlightLog flightLog) {
        if (this.isFLightLogShowing.booleanValue() && flightLog != null) {
            this.isFLightLogShowing = false;
            new Thread(new Runnable() {
                public void run() {
                    ao b;
                    int i = 0;
                    while (i < flightLog.getItemCount()) {
                        try {
                            FlightLogItem item = flightLog.getItem(i);
                            if (!(item == null || (b = FlightLogScreen.this.uasGroup.b(item.getUID())) == null)) {
                                ao aoVar = b;
                                if (aoVar.getUID().equals(item.getUID())) {
                                    FlightLogScreen.this.uasGroup.g(aoVar);
                                }
                            }
                            i++;
                        } catch (Exception e) {
                            Log.e(FlightLogScreen.TAG, "Error removing flight log marker ", e);
                            return;
                        }
                    }
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    public void panToPoint(FlightLogItem flightLogItem) {
        if (flightLogItem != null) {
            this.mapView.getMapController().panTo(new GeoPoint(Double.parseDouble(flightLogItem.getLatitude()), Double.parseDouble(flightLogItem.getLongitude()), Double.parseDouble(flightLogItem.getAltitude())), true);
        }
    }

    private String getMenu() {
        return k.a(this.pluginContext, "menus/flight_log_menu.xml");
    }

    private String formatCoordinateText(String str, String str2, String str3) {
        if (str.isEmpty() || str.equals(this.DASH) || str2.isEmpty() || str2.equals(this.DASH) || str3.isEmpty() || str3.equals(this.DASH)) {
            return this.DASH;
        }
        return CoordinateFormatUtilities.formatToShortString(new GeoPoint(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(str3)), UASToolDropDownReceiver.getInstance().getCoordFormat());
    }

    public String formatAltitudeText(String str, String str2, String str3) {
        if (str.isEmpty() || str.equals(this.DASH) || str2.isEmpty() || str2.equals(this.DASH) || str3.isEmpty() || str3.equals(this.DASH)) {
            return this.DASH;
        }
        return UASToolDropDownReceiver.formatAltitude(new GeoPoint(Double.parseDouble(str), Double.parseDouble(str2), Double.parseDouble(str3)));
    }

    public String formatSpeedText(String str) {
        if (str.isEmpty() || str.equals(this.DASH)) {
            return this.DASH;
        }
        return ae.a().a(Double.parseDouble(str));
    }

    private String formatHeadingText(String str, String str2, String str3) {
        if (str.isEmpty() || str.equals(this.DASH)) {
            return this.DASH;
        }
        Angle bearingFormat = UASToolDropDownReceiver.getInstance().getBearingFormat();
        if (bearingFormat == null) {
            return this.DASH;
        }
        if (str2 == null || str3 == null || str2.isEmpty() || str3.isEmpty()) {
            return AngleUtilities.format(Double.parseDouble(str), bearingFormat, true);
        }
        return Utils.formatHeading(new GeoPoint(Double.parseDouble(str2), Double.parseDouble(str3)), Double.parseDouble(str));
    }

    private boolean compareGeoPoint(GeoPoint geoPoint, GeoPoint geoPoint2) {
        Boolean bool = false;
        if (geoPoint != null && geoPoint2 != null && geoPoint2.getLatitude() == geoPoint.getLatitude() && geoPoint2.getLongitude() == geoPoint.getLongitude() && geoPoint2.getAltitude() == geoPoint.getAltitude()) {
            bool = true;
        }
        return bool.booleanValue();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        if (str.equals(AtakPrefConstants.RAB_UNITS_PREF) || str.equals(AtakPrefConstants.NORTH_REF_PREF)) {
            refreshList(true);
        }
    }
}
