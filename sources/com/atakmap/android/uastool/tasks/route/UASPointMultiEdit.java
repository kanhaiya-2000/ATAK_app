package com.atakmap.android.uastool.tasks.route;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.route.edit.AltitudeEdit;
import com.atakmap.android.uastool.tasks.route.edit.LookAtPointEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitClockwiseEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitCountEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitHeadingEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitRadiusEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitSpeedEdit;
import com.atakmap.android.uastool.tasks.route.edit.SpeedEdit;
import com.atakmap.android.uastool.tasks.route.edit.WayFlightEdit;
import com.atakmap.android.uastool.tasks.route.edit.WayGotoEdit;
import com.atakmap.android.uastool.tasks.route.edit.WayHeadingEdit;
import java.util.ArrayList;
import java.util.Iterator;

public class UASPointMultiEdit extends TaskEdit {
    private ArrayList<OrbitPoint> allOrbitPoints;
    private AltitudeEdit altEdit;
    private Button cancelButton;
    private OrbitPoint firstOrbitPoint;
    private UASPoint firstPoint;
    private WayPoint firstWayPoint;
    private LookAtPointEdit lookEdit;
    private OrbitClockwiseEdit orbitClockwiseEdit;
    private OrbitCountEdit orbitCountEdit;
    private OrbitHeadingEdit orbitHeadingEdit;
    private OrbitRadiusEdit orbitRadiusEdit;
    private OrbitSpeedEdit orbitSpeedEdit;
    private ArrayList<UASPoint> originalPoints;
    private ArrayList<UASPoint> points;
    private Button saveButton;
    private SpeedEdit speedEdit;
    private WayFlightEdit wayFlightEdit;
    private WayGotoEdit wayGotoEdit;
    private WayHeadingEdit wayHeadingEdit;

    public UASPointMultiEdit(Context context) {
        super(context);
    }

    public UASPointMultiEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UASPointMultiEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(TasksFragment tasksFragment, UASItem uASItem, RouteTask routeTask, ArrayList<UASPoint> arrayList) {
        super.init(tasksFragment, uASItem, routeTask);
        routeTask.view((UASPoint) null, false);
        this.points = arrayList;
        this.originalPoints = new ArrayList<>();
        Iterator<UASPoint> it = arrayList.iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            this.originalPoints.add(next.copy(next.getName(), next.getIndex(), false));
        }
        this.firstPoint = null;
        this.firstWayPoint = null;
        this.firstOrbitPoint = null;
        this.allOrbitPoints = new ArrayList<>();
        Iterator<UASPoint> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            UASPoint next2 = it2.next();
            if (this.firstPoint == null) {
                this.firstPoint = next2;
            }
            if (next2 instanceof WayPoint) {
                if (this.firstWayPoint == null) {
                    this.firstWayPoint = (WayPoint) next2;
                }
            } else if (next2 instanceof OrbitPoint) {
                OrbitPoint orbitPoint = (OrbitPoint) next2;
                this.allOrbitPoints.add(orbitPoint);
                if (this.firstOrbitPoint == null) {
                    this.firstOrbitPoint = orbitPoint;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.points != null) {
            this.speedEdit = (SpeedEdit) findViewById(C1877R.C1878id.pointedit_speed_layout);
            this.altEdit = (AltitudeEdit) findViewById(C1877R.C1878id.pointedit_alt_layout);
            this.lookEdit = (LookAtPointEdit) findViewById(C1877R.C1878id.pointedit_look_layout);
            UASPoint uASPoint = this.firstPoint;
            if (uASPoint != null) {
                this.speedEdit.init((int) uASPoint.getSpeed(), TasksFragment.getSpeedLimit(UASItemCapabilities.VALUE_ROUTE_SPEED_MIN, this.uasItem, this.uasTask.getPlatform()), TasksFragment.getSpeedLimit(UASItemCapabilities.VALUE_ROUTE_SPEED_MAX, this.uasItem, this.uasTask.getPlatform()), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_SPEED).booleanValue()) {
                    this.speedEdit.setVisibility(0);
                } else {
                    this.speedEdit.setVisibility(8);
                    this.speedEdit.setSpeed(0);
                }
                this.altEdit.init((int) this.firstPoint.getAGL(), this.firstPoint, TasksFragment.getAltitudeLimit(UASItemCapabilities.VALUE_ROUTE_AGL_MIN, this.uasItem, this.uasTask.getPlatform()), TasksFragment.getAltitudeLimit(UASItemCapabilities.VALUE_ROUTE_AGL_MAX, this.uasItem, this.uasTask.getPlatform()), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ALTITUDE).booleanValue()) {
                    this.altEdit.setVisibility(0);
                } else {
                    this.altEdit.setVisibility(8);
                    this.altEdit.setAltitude(0);
                }
                this.lookEdit.init(this.firstPoint.getLookAtPoint(), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_LOOKATPOINT).booleanValue()) {
                    this.lookEdit.setVisibility(0);
                } else {
                    this.lookEdit.setVisibility(8);
                    this.lookEdit.setLookAtPoint(false);
                }
            } else {
                this.speedEdit.setVisibility(8);
                this.altEdit.setVisibility(8);
                this.lookEdit.setVisibility(8);
            }
            View findViewById = findViewById(C1877R.C1878id.multiedit_waypoint_layout);
            this.wayHeadingEdit = (WayHeadingEdit) findViewById(C1877R.C1878id.wayedit_heading_layout);
            this.wayFlightEdit = (WayFlightEdit) findViewById(C1877R.C1878id.wayedit_flightmode_layout);
            this.wayGotoEdit = (WayGotoEdit) findViewById(C1877R.C1878id.wayedit_goto_layout);
            if (this.firstWayPoint != null) {
                findViewById.setVisibility(0);
                this.wayHeadingEdit.init(this.firstWayPoint.getHeading(), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_HEADING).booleanValue()) {
                    this.wayHeadingEdit.setVisibility(0);
                } else {
                    this.wayHeadingEdit.setVisibility(8);
                    this.wayHeadingEdit.setHeading(getResources().getStringArray(C1877R.array.waypoint_headings)[0]);
                }
                this.wayFlightEdit.init(this.firstWayPoint.getFlightMode(), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_FLIGHTMODE).booleanValue()) {
                    this.wayFlightEdit.setVisibility(0);
                } else {
                    this.wayFlightEdit.setVisibility(8);
                    this.wayFlightEdit.setFlightMode(getResources().getStringArray(C1877R.array.waypoint_flightmodes)[0]);
                }
                this.wayGotoEdit.init(this.firstWayPoint.getGotoMode(), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_GOTOMODE).booleanValue()) {
                    this.wayGotoEdit.setVisibility(0);
                } else {
                    this.wayGotoEdit.setVisibility(8);
                    this.wayGotoEdit.setGotoMode(getResources().getStringArray(C1877R.array.waypoint_gotomodes)[0]);
                }
            } else {
                findViewById.setVisibility(8);
                this.wayHeadingEdit.setVisibility(8);
                this.wayFlightEdit.setVisibility(8);
                this.wayGotoEdit.setVisibility(8);
            }
            View findViewById2 = findViewById(C1877R.C1878id.multiedit_orbitpoint_layout);
            this.orbitRadiusEdit = (OrbitRadiusEdit) findViewById(C1877R.C1878id.orbitedit_radius_layout);
            this.orbitSpeedEdit = (OrbitSpeedEdit) findViewById(C1877R.C1878id.orbitedit_speed_layout);
            this.orbitCountEdit = (OrbitCountEdit) findViewById(C1877R.C1878id.orbitedit_count_layout);
            this.orbitClockwiseEdit = (OrbitClockwiseEdit) findViewById(C1877R.C1878id.orbitedit_clockwise_layout);
            this.orbitHeadingEdit = (OrbitHeadingEdit) findViewById(C1877R.C1878id.orbitedit_heading_layout);
            if (this.firstOrbitPoint != null) {
                findViewById2.setVisibility(0);
                this.orbitRadiusEdit.init((int) this.firstOrbitPoint.getOrbitRadius(), TasksFragment.getRadiusLimit(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MIN, this.uasItem, this.uasTask.getPlatform()), TasksFragment.getRadiusLimit(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MAX, this.uasItem, this.uasTask.getPlatform()), true, (RouteTask) this.uasTask, this.allOrbitPoints);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_RADIUS).booleanValue()) {
                    this.orbitRadiusEdit.setVisibility(0);
                } else {
                    this.orbitRadiusEdit.setVisibility(8);
                    this.orbitRadiusEdit.setRadius(0);
                }
                this.orbitSpeedEdit.setOrbitRadiusEdit(this.orbitRadiusEdit);
                this.orbitRadiusEdit.setOrbitSpeedEdit(this.orbitSpeedEdit);
                this.orbitSpeedEdit.init((int) this.firstOrbitPoint.getOrbitSpeed(), TasksFragment.getOrbitSpeedLimit(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MIN, this.uasItem, this.uasTask.getPlatform()), TasksFragment.getOrbitSpeedLimit(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MAX, this.uasItem, this.uasTask.getPlatform()), UASItem.getCapabilityValueString(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_UNITSTYPE, OrbitPoint.ORBITSPEED_UNITS_ANGULAR), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_SPEED).booleanValue()) {
                    this.orbitSpeedEdit.setVisibility(0);
                } else {
                    this.orbitSpeedEdit.setVisibility(8);
                    this.orbitSpeedEdit.setSpeed(0);
                }
                int orbitCountLimit = TasksFragment.getOrbitCountLimit(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MIN, this.uasItem, this.uasTask.getPlatform());
                int orbitCountLimit2 = TasksFragment.getOrbitCountLimit(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MAX, this.uasItem, this.uasTask.getPlatform());
                if (orbitCountLimit == 0) {
                    orbitCountLimit = 1;
                }
                this.orbitCountEdit.init(this.firstOrbitPoint.getOrbitCount(), orbitCountLimit, orbitCountLimit2, true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_COUNT).booleanValue()) {
                    this.orbitCountEdit.setVisibility(0);
                } else {
                    this.orbitCountEdit.setVisibility(8);
                    this.orbitCountEdit.setCount(0);
                }
                this.orbitClockwiseEdit.init(this.firstOrbitPoint.getOrbitClockwise(), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_CLOCKWISE).booleanValue()) {
                    this.orbitClockwiseEdit.setVisibility(0);
                } else {
                    this.orbitClockwiseEdit.setVisibility(8);
                    this.orbitClockwiseEdit.setClockwise(false);
                }
                this.orbitHeadingEdit.init(this.firstOrbitPoint.getHeading(), true);
                if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_HEADING).booleanValue()) {
                    this.orbitHeadingEdit.setVisibility(0);
                } else {
                    this.orbitHeadingEdit.setVisibility(8);
                    this.orbitHeadingEdit.setHeading(getResources().getStringArray(C1877R.array.orbitpoint_headings)[0]);
                }
            } else {
                findViewById2.setVisibility(8);
                this.orbitRadiusEdit.setVisibility(8);
                this.orbitSpeedEdit.setVisibility(8);
                this.orbitCountEdit.setVisibility(8);
                this.orbitClockwiseEdit.setVisibility(8);
                this.orbitHeadingEdit.setVisibility(8);
            }
            Button button = (Button) findViewById(C1877R.C1878id.pointedit_button_cancel);
            this.cancelButton = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UASPointMultiEdit.this.cancel();
                }
            });
            this.cancelButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    UASPointMultiEdit.this.showHelp("Cancel Multi-Point Edit", "Cancel and exit the editing of the points");
                    return true;
                }
            });
            Button button2 = (Button) findViewById(C1877R.C1878id.pointedit_button_save);
            this.saveButton = button2;
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    UASPointMultiEdit.this.save();
                }
            });
            this.saveButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    UASPointMultiEdit.this.showHelp("Save Multi-Point Edit", "Save and exit the editing of the points");
                    return true;
                }
            });
        }
    }

    public void refresh() {
        super.refresh();
        this.speedEdit.refresh();
        this.altEdit.refresh();
        this.lookEdit.refresh();
        this.wayHeadingEdit.refresh();
        this.wayFlightEdit.refresh();
        this.wayGotoEdit.refresh();
        this.orbitRadiusEdit.refresh();
        this.orbitSpeedEdit.refresh();
        this.orbitCountEdit.refresh();
        this.orbitClockwiseEdit.refresh();
        this.orbitHeadingEdit.refresh();
    }

    public void save() {
        Iterator<UASPoint> it = this.points.iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            if (this.speedEdit.isMultiSelected()) {
                next.setSpeed((float) this.speedEdit.getSpeed());
            }
            if (this.altEdit.isMultiSelected()) {
                next.setAGL((float) this.altEdit.getAltitude());
            }
            if (this.lookEdit.isMultiSelected()) {
                next.setLookAtPoint(this.lookEdit.getLookAtPoint());
            }
            if (next instanceof WayPoint) {
                WayPoint wayPoint = (WayPoint) next;
                if (this.wayHeadingEdit.isMultiSelected()) {
                    wayPoint.setHeading(this.wayHeadingEdit.getHeading());
                }
                if (this.wayFlightEdit.isMultiSelected()) {
                    wayPoint.setFlightMode(this.wayFlightEdit.getFlightMode());
                }
                if (this.wayGotoEdit.isMultiSelected()) {
                    wayPoint.setGotoMode(this.wayGotoEdit.getGotoMode());
                }
            } else if (next instanceof OrbitPoint) {
                OrbitPoint orbitPoint = (OrbitPoint) next;
                if (this.orbitRadiusEdit.isMultiSelected()) {
                    orbitPoint.setOrbitRadius((float) this.orbitRadiusEdit.getRadius());
                }
                if (this.orbitSpeedEdit.isMultiSelected()) {
                    orbitPoint.setOrbitSpeed((float) this.orbitSpeedEdit.getSpeed());
                }
                if (this.orbitCountEdit.isMultiSelected()) {
                    orbitPoint.setOrbitCount(this.orbitCountEdit.getCount());
                }
                if (this.orbitClockwiseEdit.isMultiSelected()) {
                    orbitPoint.setOrbitClockwise(this.orbitClockwiseEdit.getClockwise());
                }
                if (this.orbitHeadingEdit.isMultiSelected()) {
                    orbitPoint.setHeading(this.orbitHeadingEdit.getHeading());
                }
            }
        }
        saveTask(this.uasTask);
        super.save();
        this.myTaskFragment.editTask(this.uasTask);
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        super.cancel();
        ((RouteTask) this.uasTask).getRoute().exchangePoints(this.originalPoints);
        this.myTaskFragment.editTask(this.uasTask);
    }

    /* access modifiers changed from: protected */
    public boolean onBackButton() {
        cancel();
        return true;
    }
}
