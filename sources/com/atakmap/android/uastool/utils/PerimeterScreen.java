package com.atakmap.android.uastool.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.bb;
import com.atakmap.android.toolbar.ToolManagerBroadcastReceiver;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.tasks.route.WayPoint;
import com.atakmap.android.uastool.tasks.route.edit.GimbalPitchEdit;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PerimeterScreen extends UASToolScreen {
    private static final int DEFAULT_ALTITUDE = 31;
    public static final int DEFAULT_GIMBAL_PITCH = 90;
    private static final String PERIMETER_SHAPE_CREATION_ACTION = "com.atakmap.android.uastool.utils.perimeterscreen.action.CREATE_SHAPE";
    private EditText altitudeEditText;
    /* access modifiers changed from: private */
    public ShapeListAdapter areaListAdapter;
    private final BroadcastReceiver broadcastReceiver;
    /* access modifiers changed from: private */
    public Button createPerimeterButton;
    private int desiredAglAlt;
    private GimbalPitchEdit gimbalPitchEdit;
    private String platform;
    /* access modifiers changed from: private */
    public UASRoute selectedRoute;

    public static class InputFilterMinMax implements InputFilter {
        private final int max;
        private final int min;

        /* JADX WARNING: Removed duplicated region for block: B:6:0x000e A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean isInRange(int r3, int r4, int r5) {
            /*
                r2 = this;
                r0 = 1
                r1 = 0
                if (r4 <= r3) goto L_0x0009
                if (r5 < r3) goto L_0x000e
                if (r5 > r4) goto L_0x000e
                goto L_0x000f
            L_0x0009:
                if (r5 < r4) goto L_0x000e
                if (r5 > r3) goto L_0x000e
                goto L_0x000f
            L_0x000e:
                r0 = 0
            L_0x000f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.PerimeterScreen.InputFilterMinMax.isInRange(int, int, int):boolean");
        }

        public InputFilterMinMax(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        public InputFilterMinMax(String str, String str2) {
            this.min = Integer.parseInt(str);
            this.max = Integer.parseInt(str2);
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            try {
                if (isInRange(this.min, this.max, Integer.parseInt(spanned.toString() + charSequence.toString()))) {
                    return null;
                }
                return "";
            } catch (NumberFormatException unused) {
                return "";
            }
        }
    }

    public PerimeterScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C22311 r2 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                PerimeterScreen.this.handleShapeCreation(context, intent);
            }
        };
        this.broadcastReceiver = r2;
        TAG = PerimeterScreen.class.getSimpleName();
        AtakBroadcast.a().a(r2, new AtakBroadcast.DocumentedIntentFilter(PERIMETER_SHAPE_CREATION_ACTION));
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
        ((TextView) findViewById(C1877R.C1878id.perimeter_title_text)).setText(C1877R.string.build_perimeter_route);
        ((TextView) findViewById(C1877R.C1878id.altitude_units)).setText("(" + UASToolDropDownReceiver.getAltitudeUnits().getAbbrev() + " " + this.pluginContext.getString(C1877R.string.agl) + ")");
        EditText editText = (EditText) findViewById(C1877R.C1878id.altitude);
        this.altitudeEditText = editText;
        editText.setText(String.valueOf(Utils.altitudeConversionMetersIn(31)));
        GimbalPitchEdit gimbalPitchEdit2 = (GimbalPitchEdit) findViewById(C1877R.C1878id.pointedit_gimbal_pitch_layout);
        this.gimbalPitchEdit = gimbalPitchEdit2;
        gimbalPitchEdit2.init(90, (Integer) null, false);
        if (UASItem.checkCapability(uASItem, this.platform, UASItemCapabilities.CAPABILITY_ROUTE_POINT_GIMBAL_PITCH).booleanValue()) {
            this.gimbalPitchEdit.setVisibility(0);
        } else {
            this.gimbalPitchEdit.setVisibility(8);
        }
        PluginSpinner findViewById = findViewById(C1877R.C1878id.perimeter_shapes_list);
        ShapeListAdapter shapeListAdapter = new ShapeListAdapter(this.pluginContext, new ArrayList());
        this.areaListAdapter = shapeListAdapter;
        findViewById.setAdapter(shapeListAdapter);
        findViewById.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i != 0) {
                    PerimeterScreen.this.shapeSelected((bb) PerimeterScreen.this.areaListAdapter.getItem(i));
                    return;
                }
                UASRoute unused = PerimeterScreen.this.selectedRoute = null;
                PerimeterScreen.this.createPerimeterButton.setEnabled(false);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(PerimeterScreen.TAG, "Shape clicked: Nothing Selected");
            }
        });
        Button button = (Button) findViewById(C1877R.C1878id.create_perimeter_btn);
        this.createPerimeterButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PerimeterScreen.this.lambda$init$0$PerimeterScreen(view);
            }
        });
        ((Button) findViewById(C1877R.C1878id.perimeter_cancel_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PerimeterScreen.this.lambda$init$1$PerimeterScreen(view);
            }
        });
        ((Button) findViewById(C1877R.C1878id.sendArea)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PerimeterScreen.this.lambda$init$2$PerimeterScreen(view);
            }
        });
        loadAreas();
        ((Button) findViewById(C1877R.C1878id.createShape)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PerimeterScreen.this.lambda$init$3$PerimeterScreen(view);
            }
        });
    }

    public /* synthetic */ void lambda$init$0$PerimeterScreen(View view) {
        createPerimeterTask();
    }

    public /* synthetic */ void lambda$init$1$PerimeterScreen(View view) {
        closeScreen();
    }

    public /* synthetic */ void lambda$init$2$PerimeterScreen(View view) {
        loadAreas();
    }

    public /* synthetic */ void lambda$init$3$PerimeterScreen(View view) {
        createShape();
    }

    private void createPerimeterTask() {
        UASRoute uASRoute = this.selectedRoute;
        String uuid = UUID.randomUUID().toString();
        String callsign = UASToolDropDownReceiver.getInstance().getCallsign();
        RouteTask routeTask = new RouteTask(uASRoute, uuid, callsign, UASTask.TASKTYPE.ROUTE + "-" + this.selectedRoute.getName(), this.platform, UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED, "#FFFFFF", false);
        Integer gimbalPitch = this.gimbalPitchEdit.getGimbalPitch();
        if (gimbalPitch != null) {
            routeTask.setGimbalPitch(gimbalPitch.intValue());
        }
        UASTaskStore.getInstance().saveTask(routeTask);
        if (this.myParentFragment instanceof TasksFragment) {
            ((TasksFragment) this.myParentFragment).refreshList(false);
            routeTask.view((UASPoint) null, false);
        }
        closeScreen();
    }

    private void loadAreas() {
        List d = MapView.getMapView().getRootGroup().d("type", "u-d-f");
        d.addAll(MapView.getMapView().getRootGroup().d("type", "u-d-r"));
        d.add(0, (Object) null);
        UASToolDropDownReceiver.toast("Loaded " + d.size() + " shapes.");
        this.areaListAdapter.clear();
        this.areaListAdapter.addAll(d);
        this.areaListAdapter.notifyDataSetChanged();
    }

    public void shapeSelected(bb bbVar) {
        this.desiredAglAlt = Utils.altitudeConversionMetersOut(Double.parseDouble(this.altitudeEditText.getText().toString()));
        UASRoute buildPerimeterRoute = buildPerimeterRoute(bbVar);
        if (buildPerimeterRoute != null) {
            UASToolDropDownReceiver.toast("Perimeter route successfully added.", 0);
            this.selectedRoute = buildPerimeterRoute;
            this.createPerimeterButton.setEnabled(true);
            return;
        }
        UASToolDropDownReceiver.toast("Perimeter route failed.", 0);
        this.selectedRoute = null;
        this.createPerimeterButton.setEnabled(false);
    }

    private UASRoute buildPerimeterRoute(bb bbVar) {
        ArrayList arrayList = new ArrayList();
        float capabilityValueDouble = (float) UASItem.getCapabilityValueDouble((UASItem) null, this.platform, UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, 8.0d);
        GeoPoint[] points = bbVar.getPoints();
        int i = 1;
        for (int i2 = 0; i2 < points.length; i2++) {
            GeoPoint geoPoint = points[i2];
            if (bbVar.getType() != "u-d-r" || i2 < 4) {
                int i3 = i + 1;
                WayPoint fromScratch = WayPoint.fromScratch((UASItem) null, i, geoPoint, this.platform);
                fromScratch.setAGL((float) this.desiredAglAlt);
                fromScratch.setSpeed(capabilityValueDouble);
                fromScratch.setVisible(true);
                fromScratch.setHeading(this.pluginContext.getResources().getStringArray(C1877R.array.waypoint_headings)[1]);
                fromScratch.setLookAtPoint(true);
                arrayList.add(fromScratch);
                i = i3;
            }
        }
        WayPoint fromScratch2 = WayPoint.fromScratch((UASItem) null, i, bbVar.getPoints()[0], this.platform);
        fromScratch2.setAGL((float) this.desiredAglAlt);
        fromScratch2.setSpeed(capabilityValueDouble);
        fromScratch2.setVisible(true);
        fromScratch2.setHeading(this.pluginContext.getResources().getStringArray(C1877R.array.waypoint_headings)[1]);
        fromScratch2.setFinishAction(UASPoint.FINISH_ACTION.NO_ACTION);
        fromScratch2.setLookAtPoint(true);
        arrayList.add(fromScratch2);
        return new UASRoute("Perimeter-" + bbVar.getTitle(), UUID.randomUUID().toString(), (ArrayList<UASPoint>) arrayList);
    }

    private void closeScreen() {
        this.myParentFragment.removeCurrentScreen();
    }

    private void createShape() {
        if (MapView.getMapView() != null) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setAction(PERIMETER_SHAPE_CREATION_ACTION);
            bundle.putParcelable("callback", intent);
            ToolManagerBroadcastReceiver.a().a("com.atakmap.android.drawing.SHAPE_TOOL", bundle);
        }
    }

    /* access modifiers changed from: private */
    public void handleShapeCreation(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(UASTask.COTDETAIL_UID);
            loadAreas();
            shapeSelected(MapView.getMapView().getRootGroup().b(stringExtra));
        } catch (Exception e) {
            Log.d(TAG, "Failed to parse create shape intent: ", e);
        }
    }
}
