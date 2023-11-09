package com.atakmap.android.uastool.tasks.route;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.edit.WayFinishEdit;
import com.atakmap.android.uastool.tasks.route.edit.WayFlightEdit;
import com.atakmap.android.uastool.tasks.route.edit.WayGotoEdit;
import com.atakmap.android.uastool.tasks.route.edit.WayHeadingEdit;

public class WayPointEdit extends UASPointEdit {
    private static final String TAG = "WayPointEdit";
    private Button cancelButton;
    private Button saveButton;
    WayFinishEdit wayFinishEdit;
    WayFlightEdit wayFlightEdit;
    WayGotoEdit wayGotoEdit;
    WayHeadingEdit wayHeadingEdit;

    public WayPointEdit(Context context) {
        super(context);
    }

    public WayPointEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WayPointEdit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.point != null) {
            WayPoint wayPoint = (WayPoint) this.point;
            WayHeadingEdit wayHeadingEdit2 = (WayHeadingEdit) findViewById(C1877R.C1878id.wayedit_heading_layout);
            this.wayHeadingEdit = wayHeadingEdit2;
            wayHeadingEdit2.init(wayPoint.getHeading(), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_HEADING).booleanValue()) {
                this.wayHeadingEdit.setVisibility(0);
            } else {
                this.wayHeadingEdit.setVisibility(8);
                this.wayHeadingEdit.setHeading(getResources().getStringArray(C1877R.array.waypoint_headings)[0]);
            }
            WayFlightEdit wayFlightEdit2 = (WayFlightEdit) findViewById(C1877R.C1878id.wayedit_flightmode_layout);
            this.wayFlightEdit = wayFlightEdit2;
            wayFlightEdit2.init(wayPoint.getFlightMode(), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_FLIGHTMODE).booleanValue()) {
                this.wayFlightEdit.setVisibility(0);
            } else {
                this.wayFlightEdit.setVisibility(8);
                this.wayFlightEdit.setFlightMode(getResources().getStringArray(C1877R.array.waypoint_flightmodes)[0]);
            }
            WayGotoEdit wayGotoEdit2 = (WayGotoEdit) findViewById(C1877R.C1878id.wayedit_goto_layout);
            this.wayGotoEdit = wayGotoEdit2;
            wayGotoEdit2.init(wayPoint.getGotoMode(), false);
            if (UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_GOTOMODE).booleanValue()) {
                this.wayGotoEdit.setVisibility(0);
            } else {
                this.wayGotoEdit.setVisibility(8);
                this.wayGotoEdit.setGotoMode(getResources().getStringArray(C1877R.array.waypoint_gotomodes)[0]);
            }
            WayFinishEdit wayFinishEdit2 = (WayFinishEdit) findViewById(C1877R.C1878id.wayedit_finish_layout);
            this.wayFinishEdit = wayFinishEdit2;
            wayFinishEdit2.init(wayPoint.getFinishAction(), false);
            if (!UASItem.checkCapability(this.uasItem, this.uasTask.getPlatform(), UASItemCapabilities.CAPABILITY_ROUTE_POINT_FINISHACTION).booleanValue() || this.point.getIndex() != ((RouteTask) this.uasTask).getRoute().getPointCnt()) {
                this.wayFinishEdit.setVisibility(8);
                this.wayFinishEdit.setFinish(UASPoint.FINISH_ACTION.values()[0]);
            } else {
                this.wayFinishEdit.setVisibility(0);
            }
            Button button = (Button) findViewById(C1877R.C1878id.pointedit_button_cancel);
            this.cancelButton = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    WayPointEdit.this.cancel();
                }
            });
            this.cancelButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    WayPointEdit.this.showHelp("Cancel WayPoint Edit", "Cancel and exit the editing of the waypoint");
                    return true;
                }
            });
            Button button2 = (Button) findViewById(C1877R.C1878id.pointedit_button_save);
            this.saveButton = button2;
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    WayPointEdit.this.save();
                }
            });
            this.saveButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    WayPointEdit.this.showHelp("Save WayPoint Edit", "Save and exit the editing of the waypoint");
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
        this.wayHeadingEdit.disable(z);
        this.wayFlightEdit.disable(z);
        this.wayGotoEdit.disable(z);
        this.wayFinishEdit.disable(z);
        this.saveButton.setEnabled(!z);
        this.cancelButton.setEnabled(!z);
    }

    public void save() {
        WayPoint wayPoint = (WayPoint) this.point;
        wayPoint.setHeading(this.wayHeadingEdit.getHeading());
        wayPoint.setFlightMode(this.wayFlightEdit.getFlightMode());
        wayPoint.setGotoMode(this.wayGotoEdit.getGotoMode());
        wayPoint.setFinishAction(this.wayFinishEdit.getFinish());
        super.save();
    }

    public void cancel() {
        super.cancel();
    }

    public void refresh() {
        super.refresh();
        this.wayHeadingEdit.refresh();
        this.wayFlightEdit.refresh();
        this.wayGotoEdit.refresh();
        this.wayFinishEdit.refresh();
        invalidate();
    }
}
