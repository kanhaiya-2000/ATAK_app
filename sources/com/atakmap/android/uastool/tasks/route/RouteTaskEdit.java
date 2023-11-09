package com.atakmap.android.uastool.tasks.route;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import atak.core.rd;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.ipc.b;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.toolbar.ToolManagerBroadcastReceiver;
import com.atakmap.android.toolbar.c;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import java.util.ArrayList;

public class RouteTaskEdit extends TaskEdit implements c, RouteTask.RouteTaskChangedListener {
    public static final String SET_ORBITPOINT = "com.atakmap.android.uastool.tasks.route.SET_ORBITPOINT";
    public static final String SET_SENTINELPOINT = "com.atakmap.android.uastool.tasks.route.SET_SENTINELPOINT";
    public static final String SET_WAYPOINT = "com.atakmap.android.uastool.tasks.route.SET_WAYPOINT";
    /* access modifiers changed from: private */
    public static final String TAG = "RouteTaskEdit";
    private ImageButton addButton;
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                action.hashCode();
                char c = 65535;
                switch (action.hashCode()) {
                    case -1581163616:
                        if (action.equals(RouteTaskEdit.SET_SENTINELPOINT)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -498318419:
                        if (action.equals(RouteTaskEdit.SET_WAYPOINT)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -135368654:
                        if (action.equals(RouteTaskEdit.SET_ORBITPOINT)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        RouteTaskEdit.this.setPickPoint(intent, UASPoint.POINTTYPE.SENTINELPOINT);
                        return;
                    case 1:
                        RouteTaskEdit.this.setPickPoint(intent, UASPoint.POINTTYPE.WAYPOINT);
                        return;
                    case 2:
                        RouteTaskEdit.this.setPickPoint(intent, UASPoint.POINTTYPE.ORBITPOINT);
                        return;
                    default:
                        UASToolDropDownReceiver.toast("Unknown add point type: " + action, 0);
                        return;
                }
            }
        }
    };
    private Button cancelButton;
    private ImageButton colorButton;
    private ImageButton deleteAllButton;
    /* access modifiers changed from: private */
    public boolean isMultiMode;
    /* access modifiers changed from: private */
    public ImageButton multiButton;
    private Button nameButton;
    private String newName;
    /* access modifiers changed from: private */
    public String newPlatform;
    private int oldColor;
    private ArrayList<UASPoint> originalPts;
    private ImageButton platformButton;
    private ListView pointList;
    private UASPointAdapter pointsAdapter;
    private Button saveButton;
    private Button selectAllButton;

    public RouteTaskEdit(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void init(TasksFragment tasksFragment, UASItem uASItem, UASTask uASTask) {
        super.init(tasksFragment, uASItem, uASTask);
        RouteTask routeTask = (RouteTask) uASTask;
        this.originalPts = routeTask.getRoute().copyPoints(false);
        uASTask.view((UASPoint) null, false);
        routeTask.addOnRouteTaskChangedListener(this);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.routetaskedit_addpoint);
        this.addButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteTaskEdit.this.addPoint();
            }
        });
        this.addButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp("Add Point", "Add a new point to the end of this route");
                return true;
            }
        });
        ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.routetaskedit_delete_all);
        this.deleteAllButton = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteTaskEdit.this.askDeleteAllPoints();
            }
        });
        this.deleteAllButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp("Delete All Points", "Deletes all points in this route");
                return true;
            }
        });
        this.newName = this.uasTask.getName();
        Button button = (Button) findViewById(C1877R.C1878id.routetaskedit_name);
        this.nameButton = button;
        button.setText(this.newName);
        this.nameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteTaskEdit.this.askEditName();
            }
        });
        this.nameButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp("Edit Name", "Edits the name of this route task");
                return true;
            }
        });
        this.isMultiMode = false;
        ImageButton imageButton3 = (ImageButton) findViewById(C1877R.C1878id.routetaskedit_multi);
        this.multiButton = imageButton3;
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteTaskEdit routeTaskEdit = RouteTaskEdit.this;
                routeTaskEdit.toggleMultiSelect(!routeTaskEdit.multiButton.isSelected());
            }
        });
        this.multiButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp("Multi-Point Edit", "Allows editing of multiple points at once");
                return true;
            }
        });
        this.newPlatform = this.uasTask.getPlatform();
        ImageButton imageButton4 = (ImageButton) findViewById(C1877R.C1878id.routetaskedit_platform);
        this.platformButton = imageButton4;
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteTaskEdit.this.selectPlatform();
            }
        });
        this.platformButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp("Platform Type", "Select a platform type for this Route Task");
                return true;
            }
        });
        this.oldColor = this.uasTask.getColor();
        ImageButton imageButton5 = (ImageButton) findViewById(C1877R.C1878id.routetaskedit_color);
        this.colorButton = imageButton5;
        imageButton5.setColorFilter(this.oldColor, PorterDuff.Mode.MULTIPLY);
        this.colorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteTaskEdit.this.changeColor();
            }
        });
        this.colorButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp(CameraParamsConfig.param_Color, "Select a color for this Route Task");
                return true;
            }
        });
        this.pointList = (ListView) findViewById(C1877R.C1878id.routetaskedit_points_list);
        UASPointAdapter uASPointAdapter = new UASPointAdapter(this.pluginContext, this, ((RouteTask) this.uasTask).getRoute().getPoints());
        this.pointsAdapter = uASPointAdapter;
        this.pointList.setAdapter(uASPointAdapter);
        Button button2 = (Button) findViewById(C1877R.C1878id.routetaskedit_cancel);
        this.cancelButton = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (RouteTaskEdit.this.isMultiMode) {
                    RouteTaskEdit.this.toggleMultiSelect(false);
                } else {
                    RouteTaskEdit.this.confirmCancel();
                }
            }
        });
        this.cancelButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp("Cancel Route Task Edit", "Cancel and exit the editing of the route task");
                return true;
            }
        });
        Button button3 = (Button) findViewById(C1877R.C1878id.routetaskedit_selectall);
        this.selectAllButton = button3;
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteTaskEdit.this.selectAll();
            }
        });
        this.selectAllButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp("Select All Points", "Toggles between selecting all points");
                return true;
            }
        });
        Button button4 = (Button) findViewById(C1877R.C1878id.routetaskedit_save);
        this.saveButton = button4;
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteTaskEdit.this.save();
            }
        });
        this.saveButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                RouteTaskEdit.this.showHelp("Save Route Task Edit", "Save and exit the editing of the route task");
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void toggleMultiSelect(boolean z) {
        this.isMultiMode = z;
        this.multiButton.setSelected(z);
        this.pointsAdapter.showMultiSelect(this.isMultiMode);
        if (this.isMultiMode) {
            this.selectAllButton.setVisibility(0);
            this.saveButton.setTextColor(TaskEdit.viewColor);
            this.saveButton.setText(C1877R.string.routetaskedit_multi_start);
            return;
        }
        this.selectAllButton.setVisibility(8);
        this.saveButton.setTextColor(-1);
        this.saveButton.setText(C1877R.string.routetaskedit_save);
    }

    /* access modifiers changed from: private */
    public void selectAll() {
        this.pointsAdapter.selectAll();
    }

    /* access modifiers changed from: protected */
    public void selectPlatform() {
        final ArrayList<String> supportingPlatforms = UASItem.getSupportingPlatforms(new String[]{UASItemCapabilities.CAPABILITY_TASK_NEWROUTE, UASItemCapabilities.CAPABILITY_TASK_EXISTROUTE}, false);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, 17367049, supportingPlatforms.toArray());
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setCancelable(true);
        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String unused = RouteTaskEdit.this.newPlatform = (String) supportingPlatforms.get(i);
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: protected */
    public void setNewColor(int i) {
        this.uasTask.setColor(i);
        this.colorButton.setColorFilter(i, PorterDuff.Mode.MULTIPLY);
        if (this.uasTask.isViewing()) {
            this.uasTask.view((UASPoint) null, false);
        }
    }

    /* access modifiers changed from: protected */
    public void askEditName() {
        final EditText editText = new EditText(MapView.getMapView().getContext());
        editText.setText(this.newName);
        new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Edit Name").setMessage("Enter the name for this route task").setView(editText).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (editText.getText().toString().trim().isEmpty()) {
                    UASToolDropDownReceiver.toast("Name cannot be blank", 1);
                    return;
                }
                dialogInterface.dismiss();
                RouteTaskEdit.this.editName(editText.getText().toString());
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void editName(String str) {
        this.newName = str;
        this.nameButton.setText(str);
    }

    /* access modifiers changed from: private */
    public void addPoint() {
        String[] stringArray = this.pluginContext.getResources().getStringArray(C1877R.array.route_point_types);
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Add New Route Point");
        builder.setItems(stringArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    RouteTaskEdit.this.addNewWayPoint();
                } else if (i == 1) {
                    RouteTaskEdit.this.addNewOrbitPoint();
                } else if (i != 2) {
                    UASToolDropDownReceiver.toast("Unknown add route point type: " + i, 1);
                    String access$1900 = RouteTaskEdit.TAG;
                    Log.w(access$1900, "Unknown add route point type: " + i);
                } else {
                    RouteTaskEdit.this.addNewSentinelPoint();
                }
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void addNewWayPoint() {
        startPickTool(SET_WAYPOINT);
        rd.a().a("click on the map to add a new waypoint");
    }

    /* access modifiers changed from: private */
    public void addNewOrbitPoint() {
        startPickTool(SET_ORBITPOINT);
        rd.a().a("click on the map to add a new orbitpoint");
    }

    /* access modifiers changed from: private */
    public void addNewSentinelPoint() {
        startPickTool(SET_SENTINELPOINT);
        rd.a().a("click on the map to add a new sentinelpoint");
    }

    /* access modifiers changed from: protected */
    public void startPickTool(String str) {
        ToolManagerBroadcastReceiver.a().b();
        ToolManagerBroadcastReceiver.a().a(this);
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter.a(str, "Broadcast when new point has been selected", new b[]{new b("point", "point string", false, String.class)});
        AtakBroadcast.a().a(this.broadcastReceiver, documentedIntentFilter);
        Bundle bundle = new Bundle();
        bundle.putParcelable("callback", new Intent(str));
        ToolManagerBroadcastReceiver.a().a("MapClickTool", bundle);
    }

    /* renamed from: a */
    public void mo10402a(com.atakmap.android.toolbar.b bVar, Bundle bundle) {
        this.uasTask.view((UASPoint) null, false);
        disableWhilePicking(true);
    }

    /* renamed from: a */
    public void mo10401a(com.atakmap.android.toolbar.b bVar) {
        this.uasTask.view((UASPoint) null, false);
        disableWhilePicking(false);
        ToolManagerBroadcastReceiver.a().b(this);
    }

    /* access modifiers changed from: protected */
    public void setPickPoint(Intent intent, UASPoint.POINTTYPE pointtype) {
        AtakBroadcast.a().a(this.broadcastReceiver);
        GeoPoint parseGeoPoint = GeoPoint.parseGeoPoint(intent.getStringExtra("point"));
        if (parseGeoPoint != null && parseGeoPoint.isValid()) {
            ElevationManager.b bVar = new ElevationManager.b();
            bVar.e = 1;
            bVar.g = true;
            GeoPoint geoPoint = new GeoPoint(parseGeoPoint.getLatitude(), parseGeoPoint.getLongitude(), ElevationManager.a(parseGeoPoint.getLatitude(), parseGeoPoint.getLongitude(), bVar), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE);
            int pointCnt = ((RouteTask) this.uasTask).getRoute().getPointCnt();
            UASPoint fromScratch = UASPoint.fromScratch(pointtype, this.uasItem, pointCnt + 1, geoPoint, this.uasTask.getPlatform());
            if (fromScratch != null) {
                UASPoint pointWithIndex = ((RouteTask) this.uasTask).getRoute().getPointWithIndex(pointCnt);
                if (pointWithIndex != null) {
                    if (pointWithIndex instanceof WayPoint) {
                        ((WayPoint) pointWithIndex).setFinishAction("No Action");
                    } else if (pointWithIndex instanceof OrbitPoint) {
                        ((OrbitPoint) pointWithIndex).setFinishAction("No Action");
                    }
                }
                ((RouteTask) this.uasTask).getRoute().addPoint(fromScratch);
                saveTask(this.uasTask);
            }
            refreshList(false);
            this.uasTask.view(fromScratch, false);
        }
    }

    /* access modifiers changed from: protected */
    public void disableWhilePicking(boolean z) {
        refreshList(false);
        this.addButton.setEnabled(!z);
        this.deleteAllButton.setEnabled(!z);
        this.nameButton.setEnabled(!z);
        this.platformButton.setEnabled(!z);
        this.colorButton.setEnabled(!z);
        this.pointList.setEnabled(!z);
        this.pointsAdapter.setEnabled(!z);
        this.cancelButton.setEnabled(!z);
        this.saveButton.setEnabled(!z);
    }

    /* renamed from: com.atakmap.android.uastool.tasks.route.RouteTaskEdit$27 */
    /* synthetic */ class C212827 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$tasks$route$UASPoint$POINTTYPE */
        static final /* synthetic */ int[] f8413x5ed4c682;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE[] r0 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8413x5ed4c682 = r0
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r1 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8413x5ed4c682     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r1 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.ORBITPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.route.RouteTaskEdit.C212827.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void askChangePointType(UASPoint uASPoint) {
        int i = C212827.f8413x5ed4c682[uASPoint.getPointType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                UASToolDropDownReceiver.toast("Unknown point type: " + uASPoint.getPointType(), 0);
                return;
            }
            changePointType(uASPoint, UASPoint.POINTTYPE.WAYPOINT);
        } else if (UASItem.checkCapability((UASItem) null, this.newPlatform, UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT).booleanValue()) {
            changePointType(uASPoint, UASPoint.POINTTYPE.ORBITPOINT);
        }
    }

    private void changePointType(UASPoint uASPoint, UASPoint.POINTTYPE pointtype) {
        UASPoint uASPoint2;
        int i = C212827.f8413x5ed4c682[pointtype.ordinal()];
        if (i == 1) {
            uASPoint2 = new WayPoint(uASPoint, this.newPlatform);
        } else if (i != 2) {
            uASPoint2 = uASPoint;
        } else {
            uASPoint2 = new OrbitPoint(uASPoint, this.newPlatform);
        }
        if (!uASPoint.equals(uASPoint2)) {
            this.pointsAdapter.remove(uASPoint);
            this.pointsAdapter.add(uASPoint2);
            refreshList(false);
        }
    }

    /* access modifiers changed from: protected */
    public void moveDown(UASPoint uASPoint) {
        int count = this.pointsAdapter.getCount();
        if (uASPoint.getIndex() < count) {
            for (int i = 0; i < count; i++) {
                if (uASPoint.getUID().equals(((UASPoint) this.pointsAdapter.getItem(i)).getUID())) {
                    UASPoint uASPoint2 = (UASPoint) this.pointsAdapter.getItem(i + 1);
                    if (uASPoint2 != null) {
                        uASPoint2.setIndex(uASPoint.getIndex());
                        uASPoint.setIndex(uASPoint.getIndex() + 1);
                    } else {
                        UASToolDropDownReceiver.toast("Unable to move point down - no next point", 0);
                        Log.d(TAG, "Unable to move point down - no next point");
                    }
                    refreshList(false);
                    return;
                }
            }
            return;
        }
        Log.d(TAG, "Unable to move point down in list - already at bottom");
    }

    /* access modifiers changed from: protected */
    public void moveUp(UASPoint uASPoint) {
        int count = this.pointsAdapter.getCount();
        if (uASPoint.getIndex() > 1) {
            for (int i = 0; i < count; i++) {
                if (uASPoint.getUID().equals(((UASPoint) this.pointsAdapter.getItem(i)).getUID())) {
                    UASPoint uASPoint2 = (UASPoint) this.pointsAdapter.getItem(i - 1);
                    if (uASPoint2 != null) {
                        uASPoint2.setIndex(uASPoint.getIndex());
                        uASPoint.setIndex(uASPoint.getIndex() - 1);
                    } else {
                        UASToolDropDownReceiver.toast("Unable to move point up - no previous point", 0);
                        Log.d(TAG, "Unable to move point up - no previous point");
                    }
                    refreshList(false);
                    return;
                }
            }
            return;
        }
        Log.d(TAG, "Unable to move point down in list - already at top");
    }

    /* access modifiers changed from: protected */
    public void editPoint(UASPoint uASPoint) {
        this.myTaskFragment.editPoint((RouteTask) this.uasTask, uASPoint);
    }

    /* access modifiers changed from: protected */
    public void askCopyPoint(final UASPoint uASPoint) {
        final EditText editText = new EditText(MapView.getMapView().getContext());
        editText.setText(uASPoint.getPointType().name());
        new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Copy Point").setMessage("Enter a name for the copied point").setView(editText).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                RouteTaskEdit.this.copyPoint(uASPoint, editText.getText().toString());
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void copyPoint(UASPoint uASPoint, String str) {
        UASPoint uASPoint2 = null;
        for (int i = 0; i < this.pointsAdapter.getCount(); i++) {
            UASPoint uASPoint3 = (UASPoint) this.pointsAdapter.getItem(i);
            if (uASPoint2 != null) {
                uASPoint3.setIndex(uASPoint3.getIndex() + 1);
            } else if (uASPoint.getUID().equals(uASPoint3.getUID())) {
                uASPoint2 = uASPoint.copy(str, uASPoint.getIndex() + 1, true);
            }
        }
        if (uASPoint2 != null) {
            this.pointsAdapter.add(uASPoint2);
            refreshList(false);
        }
    }

    /* access modifiers changed from: protected */
    public void askDeletePoint(final UASPoint uASPoint) {
        AlertDialog.Builder title = new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Delete Point");
        title.setMessage("Are you sure you want to delete point " + uASPoint.getName() + "?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                RouteTaskEdit.this.deletePoint(uASPoint);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void deletePoint(UASPoint uASPoint) {
        int count = this.pointsAdapter.getCount();
        UASPoint uASPoint2 = null;
        for (int i = 0; i < count; i++) {
            UASPoint uASPoint3 = (UASPoint) this.pointsAdapter.getItem(i);
            if (uASPoint2 != null) {
                uASPoint3.setIndex(uASPoint3.getIndex() - 1);
                if (uASPoint3.getName().startsWith(OrbitPoint.PREFIX)) {
                    uASPoint3.setName(OrbitPoint.PREFIX + uASPoint3.getIndex());
                } else if (uASPoint3.getName().startsWith(WayPoint.PREFIX)) {
                    uASPoint3.setName(WayPoint.PREFIX + uASPoint3.getIndex());
                } else if (uASPoint3.getName().startsWith(SentinelPoint.PREFIX)) {
                    uASPoint3.setName(SentinelPoint.PREFIX + uASPoint3.getIndex());
                }
            } else if (uASPoint.getUID().equals(uASPoint3.getUID())) {
                uASPoint2 = uASPoint3;
            }
        }
        if (uASPoint2 != null) {
            this.pointsAdapter.remove(uASPoint2);
            refreshList(false);
        }
    }

    /* access modifiers changed from: protected */
    public void askDeleteAllPoints() {
        new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Delete All Points").setMessage("Are you sure you want to delete all points in this route?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                RouteTaskEdit.this.deleteAllPoints();
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: private */
    public void deleteAllPoints() {
        this.pointsAdapter.clear();
        refreshList(false);
    }

    public void saveTask(UASTask uASTask) {
        uASTask.hide();
        super.saveTask(uASTask);
        refreshList(false);
    }

    /* access modifiers changed from: protected */
    public void refreshList(boolean z) {
        if (z) {
            UASToolDropDownReceiver.toast("refreshing route points list...", 0);
        }
        refresh();
    }

    public void refresh() {
        super.refresh();
        UASPointAdapter uASPointAdapter = this.pointsAdapter;
        if (uASPointAdapter != null) {
            uASPointAdapter.sort();
            this.pointsAdapter.refresh();
        }
        this.uasTask.view((UASPoint) null, false);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean isModified() {
        boolean z;
        boolean contentEquals = this.uasTask.getName().contentEquals(this.newName);
        boolean equalsIgnoreCase = this.uasTask.getPlatform().equalsIgnoreCase(this.newPlatform);
        boolean z2 = this.uasTask.getColor() == this.oldColor;
        boolean z3 = ((RouteTask) this.uasTask).getRoute().getPoints().size() == this.originalPts.size();
        if (z3) {
            int i = 0;
            while (true) {
                if (i >= this.originalPts.size()) {
                    break;
                } else if (!this.originalPts.get(i).equals(((RouteTask) this.uasTask).getRoute().getPoints().get(i))) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
        }
        z = true;
        if (!contentEquals || !equalsIgnoreCase || !z2 || !z3 || !z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void save() {
        if (this.isMultiMode) {
            toggleMultiSelect(false);
            this.myTaskFragment.editPoints((RouteTask) this.uasTask, this.pointsAdapter.getSelectedPoints());
        } else if (((RouteTask) this.uasTask).getRoute().getPoints().size() == 0) {
            UASToolDropDownReceiver.toast("Route must have at least 1 point", 0);
        } else {
            AtakBroadcast.a().a(this.broadcastReceiver);
            this.uasTask.hide();
            this.uasTask.setName(this.newName);
            this.uasTask.setPlatform(this.newPlatform);
            if (((RouteTask) this.uasTask).getRoute() != null) {
                ((RouteTask) this.uasTask).getRoute().switchPlatform(this.uasItem, this.newPlatform);
            }
            this.uasTask.setLastModified(System.currentTimeMillis());
            saveTask(this.uasTask);
            super.save();
        }
    }

    /* access modifiers changed from: protected */
    public void confirmCancel() {
        if (((RouteTask) this.uasTask).getRoute().getPoints().size() == 0) {
            cancel();
        } else if (isModified()) {
            new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Quit Without Saving?").setMessage("Exit route editing and discard changes?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    RouteTaskEdit.this.cancel();
                }
            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
        } else {
            cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        AtakBroadcast.a().a(this.broadcastReceiver);
        this.uasTask.setColor(this.oldColor);
        ((RouteTask) this.uasTask).getRoute().setPoints(this.originalPts);
        saveTask(this.uasTask);
        this.uasTask.view((UASPoint) null, false);
        ((RouteTask) this.uasTask).removeOnRouteTaskChangedListener(this);
        super.cancel();
    }

    /* access modifiers changed from: protected */
    public boolean onBackButton() {
        confirmCancel();
        return true;
    }

    public String getPlatform() {
        return this.newPlatform;
    }

    public void onRouteTaskChanged(RouteTask routeTask) {
        if (routeTask.equals(this.uasTask)) {
            refreshList(false);
        }
    }
}
