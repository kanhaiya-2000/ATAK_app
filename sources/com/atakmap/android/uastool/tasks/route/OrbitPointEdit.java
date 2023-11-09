package com.atakmap.android.uastool.tasks.route;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.edit.OrbitClockwiseEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitCountEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitFinishEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitHeadingEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitRadiusEdit;
import com.atakmap.android.uastool.tasks.route.edit.OrbitSpeedEdit;

public class OrbitPointEdit extends UASPointEdit {
    private static final String TAG = "OrbitPointEdit";
    private Button cancelButton;
    private OrbitClockwiseEdit orbitClockwiseEdit;
    private OrbitCountEdit orbitCountEdit;
    private OrbitFinishEdit orbitFinishEdit;
    private OrbitHeadingEdit orbitHeadingEdit;
    private OrbitRadiusEdit orbitRadiusEdit;
    private OrbitSpeedEdit orbitSpeedEdit;
    private Button saveButton;

    public OrbitPointEdit(Context context) {
        super(context);
    }

    public OrbitPointEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OrbitPointEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.point != null) {
            OrbitPoint orbitPoint = (OrbitPoint) this.point;
            OrbitRadiusEdit orbitRadiusEdit2 = (OrbitRadiusEdit) findViewById(C1877R.C1878id.orbitedit_radius_layout);
            this.orbitRadiusEdit = orbitRadiusEdit2;
            orbitRadiusEdit2.init((int) orbitPoint.getOrbitRadius(), TasksFragment.getRadiusLimit(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MIN, this.uasItem, this.uasTask.getPlatform()), TasksFragment.getRadiusLimit(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MAX, this.uasItem, this.uasTask.getPlatform()), false, (RouteTask) this.uasTask, orbitPoint);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_RADIUS).booleanValue()) {
                this.orbitRadiusEdit.setVisibility(0);
            } else {
                this.orbitRadiusEdit.setVisibility(8);
                this.orbitRadiusEdit.setRadius(0);
            }
            this.orbitSpeedEdit = (OrbitSpeedEdit) findViewById(C1877R.C1878id.orbitedit_speed_layout);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_SPEED).booleanValue()) {
                this.orbitSpeedEdit.setVisibility(0);
                this.orbitSpeedEdit.setOrbitRadiusEdit(this.orbitRadiusEdit);
                this.orbitRadiusEdit.setOrbitSpeedEdit(this.orbitSpeedEdit);
                this.orbitSpeedEdit.init((int) orbitPoint.getOrbitSpeed(), TasksFragment.getOrbitSpeedLimit(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MIN, this.uasItem, this.uasTask.getPlatform()), TasksFragment.getOrbitSpeedLimit(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MAX, this.uasItem, this.uasTask.getPlatform()), UASItem.getCapabilityValueString(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_UNITSTYPE, OrbitPoint.ORBITSPEED_UNITS_ANGULAR), false);
            } else {
                this.orbitSpeedEdit.setVisibility(8);
                this.orbitSpeedEdit.setSpeed(0);
            }
            this.orbitCountEdit = (OrbitCountEdit) findViewById(C1877R.C1878id.orbitedit_count_layout);
            int orbitCountLimit = TasksFragment.getOrbitCountLimit(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MIN, this.uasItem, this.uasTask.getPlatform());
            int orbitCountLimit2 = TasksFragment.getOrbitCountLimit(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MAX, this.uasItem, this.uasTask.getPlatform());
            if (orbitCountLimit == 0 && this.point.getIndex() != ((RouteTask) this.uasTask).getRoute().getPointCnt()) {
                orbitCountLimit = 1;
            }
            this.orbitCountEdit.init(orbitPoint.getOrbitCount(), orbitCountLimit, orbitCountLimit2, false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_COUNT).booleanValue()) {
                this.orbitCountEdit.setVisibility(0);
            } else {
                this.orbitCountEdit.setVisibility(8);
                this.orbitCountEdit.setCount(0);
            }
            OrbitClockwiseEdit orbitClockwiseEdit2 = (OrbitClockwiseEdit) findViewById(C1877R.C1878id.orbitedit_clockwise_layout);
            this.orbitClockwiseEdit = orbitClockwiseEdit2;
            orbitClockwiseEdit2.init(orbitPoint.getOrbitClockwise(), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_CLOCKWISE).booleanValue()) {
                this.orbitClockwiseEdit.setVisibility(0);
            } else {
                this.orbitClockwiseEdit.setVisibility(8);
                this.orbitClockwiseEdit.setClockwise(false);
            }
            OrbitHeadingEdit orbitHeadingEdit2 = (OrbitHeadingEdit) findViewById(C1877R.C1878id.orbitedit_heading_layout);
            this.orbitHeadingEdit = orbitHeadingEdit2;
            orbitHeadingEdit2.init(orbitPoint.getHeading(), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_HEADING).booleanValue()) {
                this.orbitHeadingEdit.setVisibility(0);
            } else {
                this.orbitHeadingEdit.setVisibility(8);
                this.orbitHeadingEdit.setHeading(getResources().getStringArray(C1877R.array.orbitpoint_headings)[0]);
            }
            OrbitFinishEdit orbitFinishEdit2 = (OrbitFinishEdit) findViewById(C1877R.C1878id.orbitedit_finish_layout);
            this.orbitFinishEdit = orbitFinishEdit2;
            orbitFinishEdit2.init(orbitPoint.getFinishAction(), false);
            if (!UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_FINISHACTION).booleanValue() || this.point.getIndex() != ((RouteTask) this.uasTask).getRoute().getPointCnt()) {
                this.orbitFinishEdit.setVisibility(8);
                this.orbitFinishEdit.setFinish(UASPoint.FINISH_ACTION.fromCotValue(getResources().getStringArray(C1877R.array.orbitpoint_finishactions)[0]));
            } else {
                this.orbitFinishEdit.setVisibility(0);
            }
            Button button = (Button) findViewById(C1877R.C1878id.pointedit_button_cancel);
            this.cancelButton = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OrbitPointEdit.this.cancel();
                }
            });
            this.cancelButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    OrbitPointEdit.this.showHelp("Cancel OrbitPoint Edit", "Cancel and exit the editing of the orbitpoint");
                    return true;
                }
            });
            Button button2 = (Button) findViewById(C1877R.C1878id.pointedit_button_save);
            this.saveButton = button2;
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OrbitPointEdit.this.save();
                }
            });
            this.saveButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    OrbitPointEdit.this.showHelp("Save OrbitPoint Edit", "Save and exit the editing of the orbitpoint");
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void disableWhilePicking(boolean z) {
        super.disableWhilePicking(z);
        this.orbitRadiusEdit.disable(z);
        this.orbitSpeedEdit.disable(z);
        this.orbitCountEdit.disable(z);
        this.orbitClockwiseEdit.disable(z);
        this.orbitHeadingEdit.disable(z);
        this.orbitFinishEdit.disable(z);
        this.saveButton.setEnabled(!z);
        this.cancelButton.setEnabled(!z);
    }

    public void save() {
        OrbitPoint orbitPoint = (OrbitPoint) this.point;
        orbitPoint.setOrbitRadius((float) this.orbitRadiusEdit.getRadius());
        orbitPoint.setOrbitSpeed((float) this.orbitSpeedEdit.getSpeed());
        orbitPoint.setOrbitCount(this.orbitCountEdit.getCount());
        orbitPoint.setOrbitClockwise(this.orbitClockwiseEdit.getClockwise());
        orbitPoint.setHeading(this.orbitHeadingEdit.getHeading());
        orbitPoint.setFinishAction(this.orbitFinishEdit.getFinish());
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putInt(UASToolPreferenceFragment.ROUTE_PREF_ORBIT_SPEED, this.orbitSpeedEdit.getSpeed());
        edit.putInt(UASToolPreferenceFragment.ROUTE_PREF_ORBIT_RADIUS, this.orbitRadiusEdit.getRadius() * (this.orbitClockwiseEdit.getClockwise() ? 1 : -1));
        edit.apply();
        super.save();
    }

    public void cancel() {
        super.cancel();
    }

    public void refresh() {
        super.refresh();
        this.orbitRadiusEdit.refresh();
        this.orbitSpeedEdit.refresh();
        this.orbitCountEdit.refresh();
        this.orbitClockwiseEdit.refresh();
        this.orbitHeadingEdit.refresh();
        this.orbitFinishEdit.refresh();
        invalidate();
    }
}
