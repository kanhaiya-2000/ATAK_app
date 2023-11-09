package com.atakmap.android.uastool.pagers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.maps.DoghouseReceiver;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ai;
import com.atakmap.android.routes.RouteMapReceiver;
import com.atakmap.android.routes.e;
import com.atakmap.android.toolbar.ToolManagerBroadcastReceiver;
import com.atakmap.android.toolbar.b;
import com.atakmap.android.toolbar.c;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.observer.ObserverPager;
import com.atakmap.android.uastool.pagers.operator.OperatorPager;
import com.atakmap.android.uastool.pagers.storedtasks.TasksArrayList;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.android.uastool.tasks.route.OrbitPointEdit;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.RouteTaskEdit;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASPointEdit;
import com.atakmap.android.uastool.tasks.route.UASPointMultiEdit;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.tasks.route.UASRouteImport;
import com.atakmap.android.uastool.tasks.route.WayPointEdit;
import com.atakmap.android.uastool.utils.PerimeterScreen;
import com.atakmap.android.uastool.utils.SurveyScreen;
import com.atakmap.commoncommo.CoTSendMethod;
import com.atakmap.coremap.conversions.CoordinateFormatUtilities;
import com.atakmap.coremap.conversions.Span;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class TasksFragment extends UASToolFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String[] SPEED_UNIT_ARRAY = {"mph", "kmph", "kts", "mps"};
    private static final String TAG = TasksFragment.class.getSimpleName();
    protected static SharedPreferences atakPrefs;
    protected static int speedUnits;
    protected AlertDialog contactAlert;
    protected String[] filterPlatforms;
    protected UASTask.PRIORITY[] filterPriorities;
    protected UASTask.STATE[] filterStates;
    protected UASTask.TASKTYPE[] filterTaskTypes;
    protected MODE mode;
    protected ImageButton sortButton;
    protected SORT_MODE sortMode = SORT_MODE.NAME;
    protected TasksAdapter taskAdapter;
    protected TasksArrayList tasks = new TasksArrayList();
    protected int titleId;
    protected TextView titleView;

    public enum MODE {
        LANDING,
        OPERATOR,
        OBSERVER
    }

    public enum SORT_MODE {
        NAME,
        MODIFIED,
        DISTANCE
    }

    public void pause() {
    }

    public void resume() {
    }

    /* access modifiers changed from: protected */
    public void sortTasks(ArrayList<UASTask> arrayList) {
    }

    public void init(Context context, MODE mode2) {
        super.init(context);
        this.mode = mode2;
        if (atakPrefs == null) {
            SharedPreferences atakPrefs2 = UASToolDropDownReceiver.getInstance().getAtakPrefs();
            atakPrefs = atakPrefs2;
            try {
                speedUnits = Integer.parseInt(atakPrefs2.getString("speed_unit_pref", "0"));
            } catch (Exception unused) {
                speedUnits = 0;
            }
            atakPrefs.registerOnSharedPreferenceChangeListener(this);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        SharedPreferences sharedPreferences = atakPrefs;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        }
        super.onDestroyView();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        if (str.equals("speed_unit_pref")) {
            try {
                speedUnits = Integer.parseInt(atakPrefs.getString("speed_unit_pref", "0"));
            } catch (Exception unused) {
                speedUnits = 0;
            }
        }
        refreshList(false);
        if (this.currentScreen != null) {
            this.currentScreen.refresh();
        }
    }

    public MODE getMode() {
        return this.mode;
    }

    /* access modifiers changed from: protected */
    public void setTitle() {
        if (this.titleView != null) {
            int i = C160218.$SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE[this.mode.ordinal()];
            if (i == 1) {
                this.titleView.setText(this.titleId);
            } else if (i != 2 && i != 3) {
                TextView textView = this.titleView;
                textView.setText("Unknown " + this.pluginContext.getResources().getString(this.titleId));
            } else if (this.selectedUASItem != null) {
                TextView textView2 = this.titleView;
                textView2.setText(this.selectedUASItem.getPlatformType() + " " + this.pluginContext.getResources().getString(this.titleId));
            } else {
                TextView textView3 = this.titleView;
                textView3.setText("??? " + this.pluginContext.getResources().getString(this.titleId));
            }
        }
    }

    public void changeTaskState(UASTask uASTask, UASTask.STATE state) {
        if (this.selectedUASItem == null) {
            UASToolDropDownReceiver.toast("Unable to " + state.name() + " task: no UAS", 0);
        } else if (!this.selectedUASItem.getPlatformType().equals(uASTask.getPlatform())) {
            UASToolDropDownReceiver.toast("Unable to " + state.name() + " task: wrong Platform", 0);
        } else {
            UASTask.STATE state2 = uASTask.getState();
            int i = C160218.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE[state.ordinal()];
            if (i == 1 || i == 2) {
                if (state2 == UASTask.STATE.RUNNING || state2 == UASTask.STATE.PAUSED) {
                    this.selectedUASItem.finishedTaskProgress("Task ended", (String) null);
                    this.selectedUASItem.stopTask(uASTask);
                }
            } else if (i != 3) {
                if (i == 4) {
                    if (state2 == UASTask.STATE.PAUSED) {
                        this.selectedUASItem.resumeTask(uASTask);
                    } else if (state2 == UASTask.STATE.RUNNING) {
                        this.selectedUASItem.stopTask(uASTask);
                        this.selectedUASItem.runTask(uASTask);
                        uASTask.setParentUasItem(this.selectedUASItem);
                    } else {
                        UASTask runningRoute = UASTaskStore.getInstance().getRunningRoute(this.selectedUASItem);
                        if (runningRoute != null) {
                            changeTaskState(runningRoute, UASTask.STATE.STORED);
                        }
                        this.selectedUASItem.runTask(uASTask);
                        uASTask.setParentUasItem(this.selectedUASItem);
                    }
                }
            } else if (state2 == UASTask.STATE.RUNNING) {
                this.selectedUASItem.pauseTask(uASTask);
            }
            uASTask.setState(state);
            saveTask(uASTask);
            refreshList(false);
        }
    }

    /* access modifiers changed from: protected */
    public void addNewTask(String str) {
        ArrayList<String> supportingPlatforms = UASItem.getSupportingPlatforms(new String[]{UASItemCapabilities.CAPABILITY_TASK_NEWROUTE, UASItemCapabilities.CAPABILITY_TASK_EXISTROUTE}, false);
        View inflate = LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.new_task_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(C1877R.C1878id.new_task_platform_warn);
        if (TextUtils.isEmpty(str) || str.equals("None Selected") || !supportingPlatforms.contains(str)) {
            textView.setVisibility(0);
            str = supportingPlatforms.get(0);
        } else {
            textView.setVisibility(8);
        }
        final PluginSpinner findViewById = inflate.findViewById(C1877R.C1878id.new_task_platform_value);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, C1877R.layout.spinner_text_white_view, supportingPlatforms);
        arrayAdapter.setDropDownViewResource(17367049);
        findViewById.setAdapter(arrayAdapter);
        findViewById.setSelection(arrayAdapter.getPosition(str));
        ViewPager pager = getPager();
        if ((pager instanceof OperatorPager) || (pager instanceof ObserverPager)) {
            findViewById.setEnabled(false);
        } else {
            findViewById.setEnabled(true);
        }
        final PluginSpinner findViewById2 = inflate.findViewById(C1877R.C1878id.new_task_type_value);
        final ArrayAdapter arrayAdapter2 = new ArrayAdapter(this.pluginContext, C1877R.layout.spinner_text_white_view, UASItem.getSupportedTaskNames(str));
        arrayAdapter2.setDropDownViewResource(17367049);
        findViewById2.setAdapter(arrayAdapter2);
        findViewById2.setSelection(0);
        findViewById.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                arrayAdapter2.clear();
                arrayAdapter2.addAll(UASItem.getSupportedTaskNames((String) arrayAdapter.getItem(i)));
                arrayAdapter2.notifyDataSetChanged();
                findViewById2.setSelection(0);
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setView(inflate);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                TasksFragment.this.handleNewTask((String) findViewById2.getSelectedItem(), (String) findViewById.getSelectedItem());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    private void showSurveySelection(String str) {
        SurveyScreen surveyScreen = (SurveyScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.survey_layout, (ViewGroup) null);
        surveyScreen.setPlatform(str);
        setCurrentScreen(surveyScreen, (UASItem) null, this);
    }

    /* access modifiers changed from: private */
    public void handleNewTask(String str, String str2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1807182982:
                if (str.equals("Survey")) {
                    c = 0;
                    break;
                }
                break;
            case -1726198787:
                if (str.equals("Perimeter")) {
                    c = 1;
                    break;
                }
                break;
            case -83302519:
                if (str.equals("New Route")) {
                    c = 2;
                    break;
                }
                break;
            case 1624916852:
                if (str.equals("Existing Route")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                showSurveySelection(str2);
                return;
            case 1:
                showPerimeterSelection(str2);
                return;
            case 2:
                createNewRouteTask(str2);
                return;
            case 3:
                askCreateATAKRouteTask(str2);
                return;
            default:
                UASToolDropDownReceiver.toast("Unknown task type: " + str, 0);
                return;
        }
    }

    private void showPerimeterSelection(String str) {
        PerimeterScreen perimeterScreen = (PerimeterScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.perimeter_layout, (ViewGroup) null);
        perimeterScreen.setPlatform(str);
        setCurrentScreen(perimeterScreen, (UASItem) null, this);
    }

    /* access modifiers changed from: protected */
    public void askCreateATAKRouteTask(String str) {
        hideAllTaskViews();
        ArrayList g = RouteMapReceiver.a().g();
        if (g == null || g.size() < 1) {
            UASToolDropDownReceiver.toast("No ATAK routes to import", 0);
            return;
        }
        UASRouteImport uASRouteImport = (UASRouteImport) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.uasroute_import, (ViewGroup) null);
        uASRouteImport.init(str);
        setCurrentScreen(uASRouteImport, (UASItem) null, this);
    }

    public void createATAKRouteTaskWithAction(e eVar, String str, UASPoint.FINISH_ACTION finish_action, Float f) {
        String str2;
        UASRoute uASRoute;
        String str3;
        e eVar2 = eVar;
        UASPoint.FINISH_ACTION finish_action2 = finish_action;
        if (TextUtils.isEmpty(str)) {
            if (this.selectedUASItem != null) {
                str3 = this.selectedUASItem.getPlatformType();
            } else {
                str3 = UASToolDropDownReceiver.getInstance().getPlatform();
            }
            str2 = str3;
        } else {
            str2 = str;
        }
        int i = C160218.$SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE[this.mode.ordinal()];
        if (i != 2) {
            uASRoute = i != 3 ? new UASRoute(eVar2, (UASItem) null, str2) : new UASRoute(eVar2, this.selectedUASItem, str2);
        } else {
            uASRoute = new UASRoute(eVar2, (UASItem) null, str2);
        }
        UASRoute uASRoute2 = uASRoute;
        Iterator<UASPoint> it = uASRoute2.getPoints().iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            if (finish_action2 != null) {
                next.setFinishAction(finish_action2);
            }
            if (f != null) {
                GeoPoint C = next.C();
                next.a(new GeoPoint(C.getLatitude(), C.getLongitude(), (double) f.floatValue(), GeoPoint.AltitudeReference.AGL, C.getCE(), C.getLE()));
            }
        }
        String uuid = UUID.randomUUID().toString();
        String callsign = UASToolDropDownReceiver.getInstance().getCallsign();
        RouteTask routeTask = new RouteTask(uASRoute2, uuid, callsign, UASTask.TASKTYPE.ROUTE + "-" + getUTCTimeStamp(), str2, UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED, String.valueOf(-1), false);
        saveTask(routeTask);
        refreshList(false);
        routeTask.view((UASPoint) null, false);
    }

    public void createATAKRouteTask(e eVar, String str) {
        createATAKRouteTaskWithAction(eVar, str, (UASPoint.FINISH_ACTION) null, (Float) null);
    }

    /* access modifiers changed from: protected */
    public void createNewRouteTask(String str) {
        hideAllTaskViews();
        if (MapView.getMapView() != null) {
            final e d = RouteMapReceiver.a().d(UUID.randomUUID().toString());
            d.setTitle(UASTask.TASKTYPE.ROUTE + "-" + getUTCTimeStamp());
            d.setMetaString("entry", UASTask.COTDETAIL_USER);
            RouteMapReceiver.a().c().d(d);
            d.setVisible(true);
            Bundle bundle = new Bundle();
            bundle.putString("routeUID", d.getUID());
            final AtomicInteger atomicInteger = new AtomicInteger(-1);
            final AtomicInteger atomicInteger2 = new AtomicInteger(-1);
            final String str2 = str;
            ToolManagerBroadcastReceiver.a().a(new c() {
                /* renamed from: a */
                public void mo9151a(b bVar, Bundle bundle) {
                    atomicInteger.set(UASToolDropDownReceiver.getInstance().getOperatorPager().getPreviewVisibility());
                    UASToolDropDownReceiver.getInstance().getOperatorPager().setPreviewVisibility(4);
                    atomicInteger2.set(UASToolDropDownReceiver.getInstance().getObserverPager().getPreviewVisibility());
                    UASToolDropDownReceiver.getInstance().getObserverPager().setPreviewVisibility(4);
                }

                /* renamed from: a */
                public void mo9150a(b bVar) {
                    ToolManagerBroadcastReceiver.a().b(this);
                    if (d.getPointMapItems().size() > 0) {
                        TasksFragment.this.createATAKRouteTask(d, str2);
                    } else {
                        UASToolDropDownReceiver.toast("New route creation cancelled", 0);
                    }
                    RouteMapReceiver.a().c().g(d);
                    DoghouseReceiver.b().c().e();
                    if (atomicInteger.get() != -1) {
                        UASToolDropDownReceiver.getInstance().getOperatorPager().setPreviewVisibility(atomicInteger.get());
                    }
                    if (atomicInteger2.get() != -1) {
                        UASToolDropDownReceiver.getInstance().getObserverPager().setPreviewVisibility(atomicInteger2.get());
                    }
                }
            });
            ToolManagerBroadcastReceiver.a().a("com.atakmap.android.maps.route.EDIT_ROUTE", bundle);
        }
    }

    private void hideAllTaskViews() {
        for (int i = 0; i < this.taskAdapter.getCount(); i++) {
            ((UASTask) this.taskAdapter.getItem(i)).hide();
        }
    }

    public void askStoreTask(final UASTask uASTask) {
        new AlertDialog.Builder(getContext()).setTitle("Store Task").setMessage("Adding task to store. Do you want to run the task immediately?").setPositiveButton("Store & Run Now", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                TasksFragment.this.tryToRunTask(uASTask);
                TasksFragment.this.refreshList(false);
            }
        }).setNeutralButton("Store Only", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                TasksFragment.this.storeTask(uASTask);
                TasksFragment.this.refreshList(false);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: protected */
    public void storeTask(UASTask uASTask) {
        changeTaskState(uASTask, UASTask.STATE.STORED);
        UASToolDropDownReceiver.toast("stored task " + uASTask.getName(), 0);
        refreshList(false);
    }

    public void dispatchTask(UASTask uASTask) {
        if (this.selectedUASItem != null) {
            this.selectedUASItem.sendTask(uASTask);
        } else {
            UASToolDropDownReceiver.toast("Unable to send task: no UAS", 0);
        }
        refreshList(false);
    }

    public void askQueueTask(final UASTask uASTask) {
        new AlertDialog.Builder(getContext()).setTitle("Queue Task").setMessage("Adding task to queue. Do you want to run the task immediately?").setPositiveButton("Add & Run Now", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                TasksFragment.this.queueTask(uASTask, true);
                TasksFragment.this.refreshList(false);
            }
        }).setNeutralButton("Add Only", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                TasksFragment.this.queueTask(uASTask, false);
                TasksFragment.this.refreshList(false);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: protected */
    public void queueTask(UASTask uASTask, boolean z) {
        if (z) {
            tryToRunTask(uASTask);
        } else {
            changeTaskState(uASTask, UASTask.STATE.QUEUED);
            UASToolDropDownReceiver.toast("added task " + uASTask.getName() + " to queue", 0);
        }
        refreshList(false);
    }

    public void tryToRunTask(final UASTask uASTask) {
        final UASTask runningRoute = UASTaskStore.getInstance().getRunningRoute();
        if (runningRoute == null) {
            runTask(uASTask);
        } else if (!runningRoute.getUID().equals(uASTask.getUID())) {
            AlertDialog.Builder title = new AlertDialog.Builder(getContext()).setTitle("Task Already Running");
            title.setMessage("Task " + runningRoute.getName() + " is already running. Do you want to stop that task and start running " + uASTask.getName() + "?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (!runningRoute.getTaskType().equals(UASTask.TASKTYPE.QUICKFLY)) {
                        UASTask uASTask = runningRoute;
                        if (!(uASTask instanceof RouteTask) || !((RouteTask) uASTask).getIsQuickTask()) {
                            TasksFragment.this.changeTaskState(runningRoute, UASTask.STATE.QUEUED);
                            TasksFragment.this.changeTaskState(uASTask, UASTask.STATE.RUNNING);
                        }
                    }
                    TasksFragment.this.changeTaskState(runningRoute, UASTask.STATE.STORED);
                    TasksFragment.this.changeTaskState(uASTask, UASTask.STATE.RUNNING);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create().show();
        } else {
            changeTaskState(uASTask, UASTask.STATE.RUNNING);
        }
    }

    public void runTask(final UASTask uASTask) {
        String taskSourceUid;
        if (this.selectedUASItem != null) {
            if (UASItem.checkCapability(this.selectedUASItem, this.selectedUASItem.getPlatformType(), UASItemCapabilities.CAPABILITY_ROUTE_OVERLAY_SHOW).booleanValue()) {
                try {
                    if (UASToolDropDownReceiver.getSharedPrefs().getBoolean(UASToolPreferenceFragment.ROUTES_WAYPOINTS_OVERLAY, false)) {
                        this.selectedUASItem.showRoute();
                    } else {
                        this.selectedUASItem.hideRoute();
                    }
                } catch (Exception e) {
                    UASToolDropDownReceiver.toast(e.getMessage(), 0);
                }
            }
            if (this.selectedUASItem.getPlatformType().equals(uASTask.getPlatform())) {
                if (uASTask.getState().equals(UASTask.STATE.PAUSED)) {
                    changeTaskState(uASTask, UASTask.STATE.RUNNING);
                } else if (uASTask.getTaskType() == UASTask.TASKTYPE.ROUTE) {
                    this.selectedUASItem.validateRouteTask((RouteTask) uASTask, new UASItem.validateCallback() {
                        public void onValidate() {
                            TasksFragment.this.changeTaskState(uASTask, UASTask.STATE.RUNNING);
                        }
                    });
                } else if (uASTask.getTaskType() == UASTask.TASKTYPE.LTCLC_REMOTE) {
                    UASTask ltCLCTask = UASTaskStore.getInstance().getLtCLCTask();
                    if (!(ltCLCTask == null || (taskSourceUid = ltCLCTask.getTaskSourceUid()) == null || taskSourceUid.equals(uASTask.getTaskSourceUid()))) {
                        changeTaskState(ltCLCTask, UASTask.STATE.STORED);
                    }
                    changeTaskState(uASTask, UASTask.STATE.RUNNING);
                } else {
                    changeTaskState(uASTask, UASTask.STATE.RUNNING);
                }
                if (!uASTask.isDeleteOnCompletion()) {
                    uASTask.view((UASPoint) null, false);
                }
            } else {
                UASToolDropDownReceiver.toast("Unable to run task: wrong platform", 0);
            }
        } else {
            UASToolDropDownReceiver.toast("Unable to run task: no UAS", 0);
        }
        refreshList(false);
    }

    public void askStopTask(final UASTask uASTask) {
        if (!uASTask.getTaskType().equals(UASTask.TASKTYPE.LTCLC_REMOTE)) {
            AlertDialog.Builder title = new AlertDialog.Builder(getContext()).setTitle("Stop Task");
            AlertDialog.Builder negativeButton = title.setMessage("Are you sure you want to stop the task " + uASTask.getName() + "?").setPositiveButton("Stop and dequeue", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    TasksFragment.this.changeTaskState(uASTask, UASTask.STATE.STORED);
                }
            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
            if (!uASTask.isDeleteOnCompletion()) {
                negativeButton.setNeutralButton("Stop Only", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        TasksFragment.this.changeTaskState(uASTask, UASTask.STATE.QUEUED);
                    }
                });
            }
            negativeButton.create().show();
            return;
        }
        changeTaskState(uASTask, UASTask.STATE.STORED);
        deleteTask(uASTask);
    }

    public void viewTask(UASTask uASTask) {
        uASTask.view((UASPoint) null, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        r8 = com.atakmap.android.contact.n.a().b(r8.getUID());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendTask(final com.atakmap.android.uastool.tasks.UASTask r11) {
        /*
            r10 = this;
            com.atakmap.android.uastool.pagers.status.StatusArrayList r0 = com.atakmap.android.uastool.pagers.status.StatusArrayList.getInstance()
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            r2 = 0
            java.lang.String r3 = "No UAS Contacts available to send task to"
            if (r1 != 0) goto L_0x0015
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r3, r2)
            return
        L_0x0015:
            android.widget.ScrollView r1 = new android.widget.ScrollView
            android.content.Context r4 = r10.pluginContext
            r1.<init>(r4)
            android.widget.LinearLayout r4 = new android.widget.LinearLayout
            android.content.Context r5 = r10.pluginContext
            r4.<init>(r5)
            r5 = 1
            r4.setOrientation(r5)
            r1.addView(r4)
            android.content.Context r5 = r10.pluginContext
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
        L_0x0030:
            boolean r6 = r0.hasNext()
            r7 = 0
            if (r6 == 0) goto L_0x0085
            java.lang.Object r6 = r0.next()
            com.atakmap.android.uastool.UASItem r6 = (com.atakmap.android.uastool.UASItem) r6
            java.lang.String r8 = r6.getCallsign()
            java.lang.String r9 = com.atakmap.android.uastool.UASToolDropDownReceiver.getUASCallsign()
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 == 0) goto L_0x004c
            goto L_0x0030
        L_0x004c:
            com.atakmap.android.maps.ao r8 = r6.getParent()
            if (r8 != 0) goto L_0x0053
            goto L_0x0030
        L_0x0053:
            com.atakmap.android.contact.n r9 = com.atakmap.android.contact.n.a()
            java.lang.String r8 = r8.getUID()
            com.atakmap.android.contact.c r8 = r9.b(r8)
            if (r8 != 0) goto L_0x0062
            goto L_0x0030
        L_0x0062:
            r9 = 2131165190(0x7f070006, float:1.794459E38)
            android.view.View r7 = r5.inflate(r9, r7)
            r9 = 2131034237(0x7f05007d, float:1.7678986E38)
            android.view.View r9 = r7.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r6 = r6.getCallsign()
            r9.setText(r6)
            com.atakmap.android.uastool.pagers.TasksFragment$14 r6 = new com.atakmap.android.uastool.pagers.TasksFragment$14
            r6.<init>(r8, r11)
            r7.setOnClickListener(r6)
            r4.addView(r7)
            goto L_0x0030
        L_0x0085:
            int r11 = r4.getChildCount()
            if (r11 != 0) goto L_0x008f
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r3, r2)
            return
        L_0x008f:
            android.app.AlertDialog$Builder r11 = new android.app.AlertDialog$Builder
            android.content.Context r0 = r10.getContext()
            r11.<init>(r0)
            java.lang.String r0 = "Select Contact to Send Task"
            android.app.AlertDialog$Builder r11 = r11.setTitle(r0)
            android.app.AlertDialog$Builder r11 = r11.setView(r1)
            java.lang.String r0 = "Cancel"
            android.app.AlertDialog$Builder r11 = r11.setNegativeButton(r0, r7)
            android.app.AlertDialog r11 = r11.create()
            r10.contactAlert = r11
            r11.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.TasksFragment.sendTask(com.atakmap.android.uastool.tasks.UASTask):void");
    }

    /* access modifiers changed from: private */
    public void sendTask(com.atakmap.android.contact.c cVar, UASTask uASTask) {
        CotEvent createBasicEvent = createBasicEvent();
        CotDetail cotDetail = new CotDetail("detail");
        createBasicEvent.setDetail(cotDetail);
        CotDetail cotDetail2 = new CotDetail("UASTaskSend");
        cotDetail2.addChild(uASTask.toCot());
        cotDetail.addChild(cotDetail2);
        createBasicEvent.setDetail(cotDetail);
        CotMapComponent.h().a(createBasicEvent, cVar, CoTSendMethod.ANY);
    }

    private static CotEvent createBasicEvent() {
        CotEvent cotEvent = new CotEvent();
        cotEvent.setType("b-m-p-uasroute");
        cotEvent.setUID(UUID.randomUUID().toString());
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(coordinatedTime.addDays(1));
        cotEvent.setVersion("2.0");
        cotEvent.setHow("m-g");
        cotEvent.setPoint(CotPoint.ZERO);
        cotEvent.setStart(new CoordinatedTime(System.currentTimeMillis()));
        cotEvent.setTime(new CoordinatedTime(System.currentTimeMillis()));
        cotEvent.setStale(new CoordinatedTime(System.currentTimeMillis() + 45000));
        return cotEvent;
    }

    public void hideTask(UASTask uASTask) {
        uASTask.hide();
    }

    public void editTask(UASTask uASTask) {
        RouteTaskEdit routeTaskEdit = (RouteTaskEdit) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.routetask_edit, (ViewGroup) null);
        routeTaskEdit.init(this, this.selectedUASItem, uASTask);
        setCurrentScreen(routeTaskEdit, this.selectedUASItem, this);
    }

    public void editTask(String str) {
        ai b = MapView.getMapView().getRootGroup().b(str);
        if (b != null) {
            RouteTaskEdit routeTaskEdit = (RouteTaskEdit) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.routetask_edit, (ViewGroup) null);
            String str2 = "";
            if (b.hasMetaValue("route_uid")) {
                str2 = b.getMetaString("route_uid", str2);
            }
            UASTask task = UASTaskStore.getInstance().getTask(str2);
            if (task == null || !(task instanceof RouteTask)) {
                UASToolDropDownReceiver.toast("Unable to edit route - couldn't find route", 0);
                return;
            }
            routeTaskEdit.init(this, this.selectedUASItem, task);
            setCurrentScreen(routeTaskEdit, this.selectedUASItem, this);
        }
    }

    public void editPoint(RouteTask routeTask, UASPoint uASPoint) {
        UASPointEdit pointEditScreen = getPointEditScreen(routeTask, uASPoint);
        if (pointEditScreen == null) {
            UASToolDropDownReceiver.toast("Unable to edit point - not yet implemented for platform: " + routeTask.getPlatform(), 0);
            return;
        }
        pointEditScreen.init(this, this.selectedUASItem, routeTask, uASPoint);
        setCurrentScreen(pointEditScreen, this.selectedUASItem, this);
    }

    public void editPoint(String str) {
        ai b = MapView.getMapView().getRootGroup().b(str);
        if (b != null) {
            String str2 = "";
            if (b.hasMetaValue("route_uid")) {
                str2 = b.getMetaString("route_uid", str2);
            }
            UASTask task = UASTaskStore.getInstance().getTask(str2);
            if (task == null || !(task instanceof RouteTask)) {
                UASToolDropDownReceiver.toast("Unable to edit route - couldn't find route", 0);
                return;
            }
            RouteTask routeTask = (RouteTask) task;
            UASPoint pointWithIndex = routeTask.getRoute().getPointWithIndex(b.hasMetaValue("uas_route_id") ? b.getMetaInteger("uas_route_id", 0) : 0);
            UASPointEdit pointEditScreen = getPointEditScreen(routeTask, pointWithIndex);
            if (pointEditScreen == null) {
                UASToolDropDownReceiver.toast("Unable to edit point - not yet implemented for platform: " + task.getPlatform(), 0);
                return;
            }
            pointEditScreen.init(this, this.selectedUASItem, routeTask, pointWithIndex);
            setCurrentScreen(pointEditScreen, this.selectedUASItem, this);
        }
    }

    /* access modifiers changed from: protected */
    public UASPointEdit getPointEditScreen(RouteTask routeTask, UASPoint uASPoint) {
        int i = C160218.f8397x5ed4c682[uASPoint.getPointType().ordinal()];
        if (i == 1) {
            return getWayPointEditScreen(routeTask);
        }
        if (i != 2) {
            return null;
        }
        return getOrbitPointEditScreen(routeTask);
    }

    private UASPointEdit getWayPointEditScreen(RouteTask routeTask) {
        return (WayPointEdit) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.waypoint_edit, (ViewGroup) null);
    }

    private OrbitPointEdit getOrbitPointEditScreen(RouteTask routeTask) {
        return (OrbitPointEdit) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.orbitpoint_edit, (ViewGroup) null);
    }

    public void editPoints(RouteTask routeTask, ArrayList<UASPoint> arrayList) {
        if (arrayList.size() > 0) {
            Iterator<UASPoint> it = arrayList.iterator();
            while (it.hasNext()) {
                UASPoint next = it.next();
            }
            UASPointMultiEdit uASPointMultiEdit = (UASPointMultiEdit) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.uaspoint_multi_edit, (ViewGroup) null);
            uASPointMultiEdit.init(this, this.selectedUASItem, routeTask, arrayList);
            setCurrentScreen(uASPointMultiEdit, this.selectedUASItem, this);
            return;
        }
        UASToolDropDownReceiver.toast("No points selected to edit", 0);
    }

    public void askCopyTask(final UASTask uASTask) {
        final EditText editText = new EditText(getContext());
        new AlertDialog.Builder(getContext()).setTitle("Copy Task").setMessage("Enter a new name for the task").setView(editText).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (editText.getText().toString().trim().isEmpty()) {
                    UASToolDropDownReceiver.toast("Name cannot be blank", 1);
                    return;
                }
                dialogInterface.dismiss();
                TasksFragment.this.copyTask(uASTask, editText.getText().toString());
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
    }

    /* access modifiers changed from: protected */
    public void copyTask(UASTask uASTask, String str) {
        UASToolDropDownReceiver.toast("task " + uASTask.getName() + " copied to " + str, 0);
        saveTask(uASTask.copy(str, true));
    }

    public void askDeleteTask(final UASTask uASTask) {
        if (!uASTask.getTaskType().equals(UASTask.TASKTYPE.LTCLC_REMOTE)) {
            AlertDialog.Builder title = new AlertDialog.Builder(getContext()).setTitle("Delete Task");
            title.setMessage("Are you sure you want to delete the task " + uASTask.getName() + "?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    TasksFragment.this.deleteTask(uASTask);
                }
            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
            return;
        }
        deleteTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void deleteTask(UASTask uASTask) {
        if (uASTask.isViewing()) {
            uASTask.hide();
        }
        UASToolDropDownReceiver.toast("task " + uASTask.getName() + " deleted", 0);
        UASTaskStore.getInstance().deleteTask(uASTask.getUID());
        refreshList(false);
    }

    public void askRemoveTask(final UASTask uASTask) {
        if (uASTask.getState().equals(UASTask.STATE.RUNNING) || uASTask.getState().equals(UASTask.STATE.PAUSED)) {
            AlertDialog.Builder title = new AlertDialog.Builder(getContext()).setTitle("Remove Task");
            title.setMessage("Are you sure you want to remove the task " + uASTask.getName() + " from the queue? The task is currently " + uASTask.getState().name()).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    TasksFragment.this.removeTask(uASTask);
                    TasksFragment.this.refreshList(false);
                }
            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).create().show();
            return;
        }
        removeTask(uASTask);
    }

    /* access modifiers changed from: protected */
    public void removeTask(UASTask uASTask) {
        if (uASTask.getTaskType().equals(UASTask.TASKTYPE.LTCLC_REMOTE) || uASTask.getTaskType().equals(UASTask.TASKTYPE.QUICKFLY)) {
            deleteTask(uASTask);
        } else {
            storeTask(uASTask);
        }
        UASToolDropDownReceiver.toast("task " + uASTask.getName() + " removed from queue", 0);
    }

    public void refreshList(boolean z) {
        if (z) {
            UASToolDropDownReceiver.toast("refreshing task list...", 0);
        }
        TasksAdapter tasksAdapter = this.taskAdapter;
        if (tasksAdapter != null) {
            tasksAdapter.refresh(this.filterPlatforms, this.filterTaskTypes, this.filterPriorities, this.filterStates);
        }
    }

    public void setUASItem(UASItem uASItem) {
        super.setUASItem(uASItem);
        this.filterPlatforms = null;
        if (!this.mode.equals(MODE.LANDING) && this.selectedUASItem != null) {
            this.filterPlatforms = new String[]{this.selectedUASItem.getPlatformType()};
        }
        setTitle();
        refreshList(false);
    }

    public void onPageSelected() {
        super.onPageSelected();
        refreshList(false);
    }

    public void saveTask(UASTask uASTask) {
        UASTaskStore.getInstance().saveTask(uASTask);
        refreshList(false);
    }

    /* access modifiers changed from: protected */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }

    public static String getUTCTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss", LocaleUtil.getCurrent());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(CoordinatedTime.currentDate());
    }

    public static String convertCoordsToDisplay(GeoPoint geoPoint) {
        return CoordinateFormatUtilities.formatToShortString(geoPoint, UASToolDropDownReceiver.getInstance().getCoordFormat());
    }

    public static int getSpeedLimit(String str, UASItem uASItem, String str2) {
        return (int) UASItem.getCapabilityValueDouble(uASItem, str2, str, -1.0d);
    }

    public static String getSpeedUnitsToDisplay() {
        int i = speedUnits;
        if (i == 0) {
            return SPEED_UNIT_ARRAY[0];
        }
        if (i == 1) {
            return SPEED_UNIT_ARRAY[1];
        }
        if (i == 2) {
            return SPEED_UNIT_ARRAY[2];
        }
        if (i != 3) {
            return SPEED_UNIT_ARRAY[0];
        }
        return SPEED_UNIT_ARRAY[3];
    }

    public static int convertSpeedToDisplay(int i) {
        int i2 = speedUnits;
        double d = 2.2369362920544025d;
        if (i2 != 0) {
            if (i2 == 1) {
                d = 3.6d;
            } else if (i2 == 2) {
                d = 1.94384d;
            } else if (i2 == 3) {
                d = 1.0d;
            }
        }
        if (Double.isNaN((double) i)) {
            return -1;
        }
        return ((int) d) * i;
    }

    public static int getAltitudeLimit(String str, UASItem uASItem, String str2) {
        return (int) UASItem.getCapabilityValueDouble(uASItem, str2, str, -1.0d);
    }

    public static int convertAltitudeToDisplay(UASPoint uASPoint) {
        return convertAltitudeToDisplay(uASPoint, uASPoint.getAGL());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int convertAltitudeToDisplay(com.atakmap.android.uastool.tasks.route.UASPoint r5, float r6) {
        /*
            boolean r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.useAglAltitude()
            r1 = 1
            r2 = -1
            if (r0 == 0) goto L_0x000a
            double r5 = (double) r6
            goto L_0x0047
        L_0x000a:
            java.lang.String r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.getAltitudeDisplayPref()
            int r3 = r0.hashCode()
            r4 = 71276(0x1166c, float:9.9879E-41)
            if (r3 == r4) goto L_0x0027
            r4 = 76646(0x12b66, float:1.07404E-40)
            if (r3 == r4) goto L_0x001d
            goto L_0x0031
        L_0x001d:
            java.lang.String r3 = "MSL"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0031
            r0 = 0
            goto L_0x0032
        L_0x0027:
            java.lang.String r3 = "HAE"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0031
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = -1
        L_0x0032:
            if (r0 == 0) goto L_0x003d
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r5.C()
            double r3 = r5.getAltitude()
            goto L_0x0045
        L_0x003d:
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r5.C()
            double r3 = com.atakmap.coremap.maps.conversion.EGM96.getMSL(r5)
        L_0x0045:
            double r5 = (double) r6
            double r5 = r5 + r3
        L_0x0047:
            int[] r0 = com.atakmap.android.uastool.pagers.TasksFragment.C160218.$SwitchMap$com$atakmap$coremap$conversions$Span
            com.atakmap.coremap.conversions.Span r3 = com.atakmap.android.uastool.UASToolDropDownReceiver.getAltitudeUnits()
            int r3 = r3.ordinal()
            r0 = r0[r3]
            if (r0 == r1) goto L_0x005b
            r0 = 4614570213464309537(0x400a3f28fca37f21, double:3.280839895)
            goto L_0x005d
        L_0x005b:
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x005d:
            boolean r3 = java.lang.Double.isNaN(r5)
            if (r3 == 0) goto L_0x0064
            return r2
        L_0x0064:
            double r0 = r0 * r5
            int r5 = (int) r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.TasksFragment.convertAltitudeToDisplay(com.atakmap.android.uastool.tasks.route.UASPoint, float):int");
    }

    /* renamed from: com.atakmap.android.uastool.pagers.TasksFragment$18 */
    /* synthetic */ class C160218 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE;
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE;

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$tasks$route$UASPoint$POINTTYPE */
        static final /* synthetic */ int[] f8397x5ed4c682;
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$coremap$conversions$Span;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|(2:17|18)|19|21|22|23|24|25|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|21|22|23|24|25|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0084 */
        static {
            /*
                com.atakmap.coremap.conversions.Span[] r0 = com.atakmap.coremap.conversions.Span.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$coremap$conversions$Span = r0
                r1 = 1
                com.atakmap.coremap.conversions.Span r2 = com.atakmap.coremap.conversions.Span.METER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$atakmap$coremap$conversions$Span     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.coremap.conversions.Span r3 = com.atakmap.coremap.conversions.Span.FOOT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE[] r2 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f8397x5ed4c682 = r2
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r3 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f8397x5ed4c682     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r3 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.ORBITPOINT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                com.atakmap.android.uastool.tasks.UASTask$STATE[] r2 = com.atakmap.android.uastool.tasks.UASTask.STATE.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE = r2
                com.atakmap.android.uastool.tasks.UASTask$STATE r3 = com.atakmap.android.uastool.tasks.UASTask.STATE.QUEUED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r2 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.atakmap.android.uastool.tasks.UASTask$STATE r3 = com.atakmap.android.uastool.tasks.UASTask.STATE.STORED     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                r2 = 3
                int[] r3 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE     // Catch:{ NoSuchFieldError -> 0x005e }
                com.atakmap.android.uastool.tasks.UASTask$STATE r4 = com.atakmap.android.uastool.tasks.UASTask.STATE.PAUSED     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r3 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$STATE     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.atakmap.android.uastool.tasks.UASTask$STATE r4 = com.atakmap.android.uastool.tasks.UASTask.STATE.RUNNING     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                com.atakmap.android.uastool.pagers.TasksFragment$MODE[] r3 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE = r3
                com.atakmap.android.uastool.pagers.TasksFragment$MODE r4 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.LANDING     // Catch:{ NoSuchFieldError -> 0x007a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r1 = $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.atakmap.android.uastool.pagers.TasksFragment$MODE r3 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.OBSERVER     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$pagers$TasksFragment$MODE     // Catch:{ NoSuchFieldError -> 0x008e }
                com.atakmap.android.uastool.pagers.TasksFragment$MODE r1 = com.atakmap.android.uastool.pagers.TasksFragment.MODE.OPERATOR     // Catch:{ NoSuchFieldError -> 0x008e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.pagers.TasksFragment.C160218.<clinit>():void");
        }
    }

    public static String getRangeUnitsToDisplay() {
        int rangeFormat = UASToolDropDownReceiver.getRangeFormat();
        if (rangeFormat == 1) {
            return Span.METER.getAbbrev();
        }
        if (rangeFormat != 2) {
            return Span.FOOT.getAbbrev();
        }
        return Span.NAUTICALMILE.getAbbrev();
    }

    public static int convertRangeToDisplay(double d) {
        int rangeFormat = UASToolDropDownReceiver.getRangeFormat();
        return new BigDecimal((rangeFormat != 1 ? rangeFormat != 2 ? 3.280839895d : 5.39957E-4d : 1.0d) * d).setScale(0, RoundingMode.HALF_UP).intValue();
    }

    public static int getRadiusLimit(String str, UASItem uASItem, String str2) {
        return (int) UASItem.getCapabilityValueDouble(uASItem, str2, str, -1.0d);
    }

    public static int getOrbitSpeedLimit(String str, UASItem uASItem, String str2) {
        return (int) UASItem.getCapabilityValueDouble(uASItem, str2, str, -1.0d);
    }

    public static int getOrbitCountLimit(String str, UASItem uASItem, String str2) {
        return UASItem.getCapabilityValueInt(uASItem, str2, str, -1);
    }
}
