package com.atakmap.android.uastool.tasks.route;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import atak.core.rd;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.ipc.b;
import com.atakmap.android.toolbar.ToolManagerBroadcastReceiver;
import com.atakmap.android.toolbar.c;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.route.edit.AltitudeEdit;
import com.atakmap.android.uastool.tasks.route.edit.GimbalPitchEdit;
import com.atakmap.android.uastool.tasks.route.edit.LookAtPointEdit;
import com.atakmap.android.uastool.tasks.route.edit.NameEdit;
import com.atakmap.android.uastool.tasks.route.edit.SpeedEdit;
import com.atakmap.android.uastool.tasks.route.edit.TakeoffEdit;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;

public class UASPointEdit extends TaskEdit implements c {
    public static final String SET_COORDS = "com.atakmap.android.uastool.tasks.route.SET_COORDS";
    private static final String TAG = "UASPointEdit";
    private AltitudeEdit altEdit;
    protected SharedPreferences atakPrefs;
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals(UASPointEdit.SET_COORDS)) {
                UASPointEdit.this.setPickPoint(intent);
            }
        }
    };
    private String cancelCoordString;
    private TextView coordText;
    private TextView coordUnitText;
    private GimbalPitchEdit gimbalPitchEdit;
    private LookAtPointEdit lookEdit;
    private NameEdit nameEdit;
    protected UASPoint originalPoint;
    /* access modifiers changed from: private */
    public Button pickButton;
    /* access modifiers changed from: private */
    public String pickCoordString;
    protected String pickPrompt;
    protected UASPoint point;
    private SpeedEdit speedEdit;
    private TakeoffEdit takeoffEdit;

    public UASPointEdit(Context context) {
        super(context);
    }

    public UASPointEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UASPointEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(TasksFragment tasksFragment, UASItem uASItem, RouteTask routeTask, UASPoint uASPoint) {
        super.init(tasksFragment, uASItem, routeTask);
        routeTask.view(uASPoint, false);
        this.point = uASPoint;
        this.originalPoint = uASPoint.copy(uASPoint.getName(), uASPoint.getIndex(), false);
        this.pickCoordString = this.pluginContext.getResources().getString(C1877R.string.pointedit_coord_pick);
        this.cancelCoordString = this.pluginContext.getResources().getString(C1877R.string.pointedit_coord_cancel);
        this.pickPrompt = this.pluginContext.getResources().getString(C1877R.string.pointedit_pickprompt);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.point != null) {
            this.atakPrefs = UASToolDropDownReceiver.getInstance().getAtakPrefs();
            NameEdit nameEdit2 = (NameEdit) findViewById(C1877R.C1878id.pointedit_name_layout);
            this.nameEdit = nameEdit2;
            nameEdit2.init(this.point.getName(), false);
            SpeedEdit speedEdit2 = (SpeedEdit) findViewById(C1877R.C1878id.pointedit_speed_layout);
            this.speedEdit = speedEdit2;
            speedEdit2.init((int) this.point.getSpeed(), TasksFragment.getSpeedLimit(UASItemCapabilities.VALUE_ROUTE_SPEED_MIN, this.uasItem, this.uasTask.getPlatform()), TasksFragment.getSpeedLimit(UASItemCapabilities.VALUE_ROUTE_SPEED_MAX, this.uasItem, this.uasTask.getPlatform()), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_SPEED).booleanValue()) {
                this.speedEdit.setVisibility(0);
            } else {
                this.speedEdit.setVisibility(8);
                this.speedEdit.setSpeed(0);
            }
            TextView textView = (TextView) findViewById(C1877R.C1878id.pointedit_value_coord);
            this.coordText = textView;
            textView.setEnabled(false);
            this.coordText.setText(TasksFragment.convertCoordsToDisplay(this.point.C()));
            TextView textView2 = (TextView) findViewById(C1877R.C1878id.pointedit_units_coord);
            this.coordUnitText = textView2;
            textView2.setText("(" + UASToolDropDownReceiver.getInstance().getCoordFormat().getDisplayName() + ")");
            Button button = (Button) findViewById(C1877R.C1878id.pointedit_pick_coord);
            this.pickButton = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UASPointEdit uASPointEdit = UASPointEdit.this;
                    uASPointEdit.pickCoordinate(uASPointEdit.pickButton.getText().equals(UASPointEdit.this.pickCoordString));
                }
            });
            this.pickButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    UASPointEdit.this.showHelp("Pick Point Coordinates", "Allows user to change coordinates of a point by clicking on the map.");
                    return true;
                }
            });
            AltitudeEdit altitudeEdit = (AltitudeEdit) findViewById(C1877R.C1878id.pointedit_alt_layout);
            this.altEdit = altitudeEdit;
            altitudeEdit.init((int) this.point.getAGL(), this.point, TasksFragment.getAltitudeLimit(UASItemCapabilities.VALUE_ROUTE_AGL_MIN, this.uasItem, this.uasTask.getPlatform()), TasksFragment.getAltitudeLimit(UASItemCapabilities.VALUE_ROUTE_AGL_MAX, this.uasItem, this.uasTask.getPlatform()), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ALTITUDE).booleanValue()) {
                this.altEdit.setVisibility(0);
            } else {
                this.altEdit.setVisibility(8);
                this.altEdit.setAltitude((int) UASItem.getCapabilityValueDouble(this.uasItem, this.uasItem.getPlatformType(), UASItemCapabilities.VALUE_ROUTE_AGL_DEFAULT, 0.0d));
            }
            LookAtPointEdit lookAtPointEdit = (LookAtPointEdit) findViewById(C1877R.C1878id.pointedit_look_layout);
            this.lookEdit = lookAtPointEdit;
            lookAtPointEdit.init(this.point.getLookAtPoint(), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_LOOKATPOINT).booleanValue()) {
                this.lookEdit.setVisibility(0);
            } else {
                this.lookEdit.setVisibility(8);
                this.lookEdit.setLookAtPoint(false);
            }
            TakeoffEdit takeoffEdit2 = (TakeoffEdit) findViewById(C1877R.C1878id.pointedit_takeoff_layout);
            this.takeoffEdit = takeoffEdit2;
            takeoffEdit2.init(this.point.getTakeoff(), false);
            if (this.point.getIndex() != 1 || !UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_TAKEOFF).booleanValue()) {
                this.takeoffEdit.setVisibility(8);
                this.takeoffEdit.setTakeoff(false);
            } else {
                this.takeoffEdit.setVisibility(0);
            }
            GimbalPitchEdit gimbalPitchEdit2 = (GimbalPitchEdit) findViewById(C1877R.C1878id.pointedit_gimbal_pitch_layout);
            this.gimbalPitchEdit = gimbalPitchEdit2;
            gimbalPitchEdit2.init(90, this.point.getGimbalPitch(), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_GIMBAL_PITCH).booleanValue()) {
                this.gimbalPitchEdit.setVisibility(0);
                return;
            }
            this.gimbalPitchEdit.setVisibility(8);
            this.gimbalPitchEdit.setGimbalPitch((Integer) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void pickCoordinate(boolean z) {
        ToolManagerBroadcastReceiver.a().b();
        if (z) {
            startPickTool();
        }
    }

    /* access modifiers changed from: protected */
    public void startPickTool() {
        ToolManagerBroadcastReceiver.a().a(this);
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter.a(SET_COORDS, "Broadcast when new point coordinates have been selected", new b[]{new b("point", "point string", false, String.class)});
        AtakBroadcast.a().a(this.broadcastReceiver, documentedIntentFilter);
        Bundle bundle = new Bundle();
        bundle.putParcelable("callback", new Intent(SET_COORDS));
        ToolManagerBroadcastReceiver.a().a("MapClickTool", bundle);
        rd.a().a(this.pickPrompt);
    }

    /* renamed from: a */
    public void mo10508a(com.atakmap.android.toolbar.b bVar, Bundle bundle) {
        disableWhilePicking(true);
        this.uasTask.view(this.point, true);
        this.pickButton.setText(this.cancelCoordString);
        this.pickButton.setTextColor(TaskEdit.viewColor);
    }

    /* renamed from: a */
    public void mo10507a(com.atakmap.android.toolbar.b bVar) {
        rd.a().d();
        disableWhilePicking(false);
        this.uasTask.view((UASPoint) null, false);
        this.pickButton.setText(this.pickCoordString);
        this.pickButton.setTextColor(-1);
        ToolManagerBroadcastReceiver.a().b(this);
    }

    /* access modifiers changed from: protected */
    public void setPickPoint(Intent intent) {
        AtakBroadcast.a().a(this.broadcastReceiver);
        GeoPoint parseGeoPoint = GeoPoint.parseGeoPoint(intent.getStringExtra("point"));
        if (parseGeoPoint != null && parseGeoPoint.isValid()) {
            ElevationManager.b bVar = new ElevationManager.b();
            bVar.e = 1;
            bVar.g = true;
            this.point.a(new GeoPoint(parseGeoPoint.getLatitude(), parseGeoPoint.getLongitude(), ElevationManager.a(parseGeoPoint.getLatitude(), parseGeoPoint.getLongitude(), bVar), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE));
            this.coordText.setText(TasksFragment.convertCoordsToDisplay(this.point.C()));
            this.uasTask.view(this.point, false);
        }
    }

    /* access modifiers changed from: protected */
    public void disableWhilePicking(boolean z) {
        this.nameEdit.disable(z);
        this.speedEdit.disable(z);
        this.altEdit.disable(z);
        this.lookEdit.disable(z);
        this.takeoffEdit.disable(z);
        this.gimbalPitchEdit.disable(z);
    }

    public void save() {
        AtakBroadcast.a().a(this.broadcastReceiver);
        this.point.setName(this.nameEdit.getName());
        this.point.setSpeed((float) this.speedEdit.getSpeed());
        this.point.setAGL((float) this.altEdit.getAltitude());
        this.point.setLookAtPoint(this.lookEdit.getLookAtPoint());
        this.point.setTakeoff(this.takeoffEdit.getTakeoff());
        if (this.gimbalPitchEdit.getGimbalPitch() != null) {
            this.point.setGimbalPitch(this.gimbalPitchEdit.getGimbalPitch().intValue());
        }
        saveTask(this.uasTask);
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putInt(UASToolPreferenceFragment.ROUTE_PREF_UASPOINT_ALTITUDE, this.altEdit.getAltitude());
        edit.putInt(UASToolPreferenceFragment.ROUTE_PREF_UASPOINT_SPEED, this.speedEdit.getSpeed());
        edit.apply();
        super.save();
        this.myTaskFragment.editTask(this.uasTask);
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        AtakBroadcast.a().a(this.broadcastReceiver);
        ((RouteTask) this.uasTask).getRoute().removePoint(this.point, false);
        ((RouteTask) this.uasTask).getRoute().addPoint(this.originalPoint);
        super.cancel();
        this.myTaskFragment.editTask(this.uasTask);
    }

    public void refresh() {
        super.refresh();
        this.nameEdit.refresh();
        this.speedEdit.refresh();
        this.altEdit.refresh();
        this.lookEdit.refresh();
        this.takeoffEdit.refresh();
        this.gimbalPitchEdit.refresh();
        this.coordText.setText(TasksFragment.convertCoordsToDisplay(this.point.C()));
        TextView textView = this.coordUnitText;
        textView.setText("(" + UASToolDropDownReceiver.getInstance().getCoordFormat().getDisplayName() + ")");
        invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean onBackButton() {
        cancel();
        return true;
    }
}
