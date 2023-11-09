package com.atakmap.android.uastool.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.bb;
import com.atakmap.android.routes.e;
import com.atakmap.android.toolbar.ToolManagerBroadcastReceiver;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.edit.GimbalPitchEdit;
import com.atakmap.coremap.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyScreen extends UASToolScreen {
    private static final String CUSTOM_CAMERA_NAME = "Custom";
    private static final String CUSTOM_SENSOR_FOCAL_LENGTH_KEY = "UASTOOL_SURVEY_CUSTOM_SENSOR_FOCAL_LENGTH";
    private static final String CUSTOM_SENSOR_HEIGHT_KEY = "UASTOOL_SURVEY_CUSTOM_SENSOR_HEIGHT";
    private static final String CUSTOM_SENSOR_RESOLUTION_KEY = "UASTOOL_SURVEY_CUSTOM_SENSOR_RESOLUTION";
    private static final String CUSTOM_SENSOR_WIDTH_KEY = "UASTOOL_SURVEY_CUSTOM_SENSOR_WIDTH";
    private static final int DEFAULT_ALTITUDE = 31;
    private static final int DEFAULT_COVERAGE_ANGLE = 0;
    public static final int DEFAULT_GIMBAL_PITCH = 90;
    private static final int DEFAULT_OVERLAP = 40;
    private static final int DEFAULT_SIDELAP = 40;
    private static final String SURVEY_SHAPE_CREATION_ACTION = "com.atakmap.android.uastool.utils.surveyscreen.action.CREATE_SHAPE";
    private EditText altitudeEditText;
    /* access modifiers changed from: private */
    public ShapeListAdapter areaListAdapter;
    private PluginSpinner areaListView;
    private final BroadcastReceiver broadcastReceiver;
    private TextWatcher cameraAttrWatcher = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private final Map<String, CameraInfo> cameraInfoMap = new HashMap();
    /* access modifiers changed from: private */
    public PluginSpinner cameraSpinner;
    private EditText coverageAngleEditText;
    /* access modifiers changed from: private */
    public Button createSurveyButton;
    private float desiredAglAlt;
    private GimbalPitchEdit gimbalPitchEdit;
    private Button loadCameraBtn;
    private EditText overlapEditText;
    private String platform;
    private Button savePresetButton;
    private ScrollView scrollView;
    /* access modifiers changed from: private */
    public e selectedRoute;
    private UASItem selectedUasItem;
    private EditText sensorFocalLength;
    private EditText sensorHeight;
    private EditText sensorResolution;
    private EditText sensorWidth;
    private EditText sidelapEditText;

    public SurveyScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C22331 r2 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                SurveyScreen.this.handleShapeCreation(context, intent);
            }
        };
        this.broadcastReceiver = r2;
        TAG = SurveyScreen.class.getSimpleName();
        AtakBroadcast.a().a(r2, new AtakBroadcast.DocumentedIntentFilter(SURVEY_SHAPE_CREATION_ACTION));
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
        this.selectedUasItem = uASItem;
        ((TextView) findViewById(C1877R.C1878id.survey_title_text)).setText(C1877R.string.build_survey_route);
        this.cameraSpinner = findViewById(C1877R.C1878id.survey_camera_spinner);
        this.sensorWidth = (EditText) findViewById(C1877R.C1878id.sensorWidth);
        this.sensorHeight = (EditText) findViewById(C1877R.C1878id.sensorHeight);
        this.sensorResolution = (EditText) findViewById(C1877R.C1878id.sensorResolution);
        this.sensorFocalLength = (EditText) findViewById(C1877R.C1878id.focalLength);
        Button button = (Button) findViewById(C1877R.C1878id.survey_save_camera_preset_btn);
        this.savePresetButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SurveyScreen.this.lambda$init$0$SurveyScreen(view);
            }
        });
        this.scrollView = (ScrollView) findViewById(C1877R.C1878id.survey_scroll);
        if (this.selectedUasItem == null) {
            this.selectedUasItem = UASItem.buildItem(UASItem.NO_UID, "", this.platform, false);
        }
        List<CameraInfo> cameraInfo = this.selectedUasItem.getCameraInfo();
        ArrayList arrayList = new ArrayList();
        for (CameraInfo next : cameraInfo) {
            if (next != null) {
                this.cameraInfoMap.put(next.getName(), next);
                arrayList.add(next.getName());
            }
        }
        arrayList.add(CUSTOM_CAMERA_NAME);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, C1877R.layout.spinner_text, arrayList);
        arrayAdapter.setDropDownViewResource(17367049);
        this.cameraSpinner.setAdapter(arrayAdapter);
        this.cameraSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (((String) SurveyScreen.this.cameraSpinner.getSelectedItem()).equals(SurveyScreen.CUSTOM_CAMERA_NAME)) {
                    SurveyScreen.this.updateCameraFields(true);
                } else {
                    SurveyScreen.this.updateCameraFields(false);
                }
            }
        });
        if (((String) this.cameraSpinner.getSelectedItem()).equals(CUSTOM_CAMERA_NAME)) {
            updateCameraFields(true);
        } else {
            updateCameraFields(false);
        }
        this.sensorWidth.addTextChangedListener(this.cameraAttrWatcher);
        this.sensorHeight.addTextChangedListener(this.cameraAttrWatcher);
        this.sensorResolution.addTextChangedListener(this.cameraAttrWatcher);
        this.sensorFocalLength.addTextChangedListener(this.cameraAttrWatcher);
        EditText editText = (EditText) findViewById(C1877R.C1878id.altitude);
        this.altitudeEditText = editText;
        editText.setText(String.valueOf(Utils.altitudeConversionMetersIn(31)));
        EditText editText2 = (EditText) findViewById(C1877R.C1878id.coverage_angle);
        this.coverageAngleEditText = editText2;
        editText2.setText(String.valueOf(0));
        EditText editText3 = (EditText) findViewById(C1877R.C1878id.overlap);
        this.overlapEditText = editText3;
        editText3.setText(String.valueOf(40));
        EditText editText4 = (EditText) findViewById(C1877R.C1878id.sidelap);
        this.sidelapEditText = editText4;
        editText4.setText(String.valueOf(40));
        GimbalPitchEdit gimbalPitchEdit2 = (GimbalPitchEdit) findViewById(C1877R.C1878id.pointedit_gimbal_pitch_layout);
        this.gimbalPitchEdit = gimbalPitchEdit2;
        gimbalPitchEdit2.init(90, (Integer) null, false);
        if (UASItem.checkCapability(uASItem, this.platform, UASItemCapabilities.CAPABILITY_ROUTE_POINT_GIMBAL_PITCH).booleanValue()) {
            this.gimbalPitchEdit.setVisibility(0);
        } else {
            this.gimbalPitchEdit.setVisibility(8);
        }
        this.areaListView = findViewById(C1877R.C1878id.survey_shapes_list);
        ShapeListAdapter shapeListAdapter = new ShapeListAdapter(this.pluginContext, new ArrayList());
        this.areaListAdapter = shapeListAdapter;
        this.areaListView.setAdapter(shapeListAdapter);
        this.areaListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i != 0) {
                    SurveyScreen.this.shapeSelected((bb) SurveyScreen.this.areaListAdapter.getItem(i));
                    return;
                }
                e unused = SurveyScreen.this.selectedRoute = null;
                SurveyScreen.this.createSurveyButton.setEnabled(false);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(SurveyScreen.TAG, "Shape clicked: Nothing Selected");
            }
        });
        Button button2 = (Button) findViewById(C1877R.C1878id.create_survey_btn);
        this.createSurveyButton = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SurveyScreen.this.lambda$init$1$SurveyScreen(view);
            }
        });
        ((Button) findViewById(C1877R.C1878id.survey_cancel_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SurveyScreen.this.lambda$init$2$SurveyScreen(view);
            }
        });
        ((Button) findViewById(C1877R.C1878id.sendArea)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SurveyScreen.this.lambda$init$3$SurveyScreen(view);
            }
        });
        loadAreas();
        ((Button) findViewById(C1877R.C1878id.createShape)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SurveyScreen.this.lambda$init$4$SurveyScreen(view);
            }
        });
    }

    public /* synthetic */ void lambda$init$0$SurveyScreen(View view) {
        saveCameraPreset();
    }

    public /* synthetic */ void lambda$init$1$SurveyScreen(View view) {
        createSurveyTask();
    }

    public /* synthetic */ void lambda$init$2$SurveyScreen(View view) {
        closeScreen();
    }

    public /* synthetic */ void lambda$init$3$SurveyScreen(View view) {
        loadAreas();
    }

    public /* synthetic */ void lambda$init$4$SurveyScreen(View view) {
        createShape();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x010d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createSurveyTask() {
        /*
            r20 = this;
            r1 = r20
            com.atakmap.android.routes.e r0 = r1.selectedRoute
            com.atakmap.coremap.maps.coords.GeoPoint[] r0 = r0.getPoints()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = r1.platform
            r4 = 0
            java.lang.String r5 = "value.route.speed.default"
            r6 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r5 = com.atakmap.android.uastool.UASItem.getCapabilityValueDouble(r4, r3, r5, r6)
            float r3 = (float) r5
            r5 = 0
            r6 = 0
        L_0x001b:
            int r7 = r0.length
            java.lang.String r8 = "-"
            if (r6 >= r7) goto L_0x0065
            com.atakmap.android.uastool.UASItem r7 = r1.selectedUasItem
            int r9 = r6 + 1
            r6 = r0[r6]
            java.lang.String r10 = r7.getPlatformType()
            com.atakmap.android.uastool.tasks.route.WayPoint r6 = com.atakmap.android.uastool.tasks.route.WayPoint.fromScratch(r7, r9, r6, r10)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            com.atakmap.android.routes.e r10 = r1.selectedRoute
            java.lang.String r10 = r10.getTitle()
            r7.append(r10)
            r7.append(r8)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r6.setName(r7)
            float r7 = r1.desiredAglAlt
            double r7 = (double) r7
            double r7 = atak.core.oe.b.a(r7)
            long r7 = java.lang.Math.round(r7)
            int r8 = (int) r7
            float r7 = (float) r8
            r6.setAGL(r7)
            r6.setSpeed(r3)
            r7 = 1
            r6.setVisible(r7)
            r2.add(r6)
            r6 = r9
            goto L_0x001b
        L_0x0065:
            com.atakmap.android.uastool.tasks.route.UASRoute r11 = new com.atakmap.android.uastool.tasks.route.UASRoute
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Survey-"
            r0.append(r3)
            com.atakmap.android.routes.e r3 = r1.selectedRoute
            java.lang.String r3 = r3.getTitle()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r3 = r3.toString()
            r11.<init>((java.lang.String) r0, (java.lang.String) r3, (java.util.ArrayList<com.atakmap.android.uastool.tasks.route.UASPoint>) r2)
            com.atakmap.android.uastool.tasks.route.RouteTask r2 = new com.atakmap.android.uastool.tasks.route.RouteTask
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r12 = r0.toString()
            com.atakmap.android.uastool.UASToolDropDownReceiver r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()
            java.lang.String r13 = r0.getCallsign()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r3 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.ROUTE
            r0.append(r3)
            r0.append(r8)
            com.atakmap.android.routes.e r3 = r1.selectedRoute
            java.lang.String r3 = r3.getTitle()
            r0.append(r3)
            java.lang.String r14 = r0.toString()
            java.lang.String r15 = r1.platform
            com.atakmap.android.uastool.tasks.UASTask$PRIORITY r16 = com.atakmap.android.uastool.tasks.UASTask.PRIORITY.NORMAL
            com.atakmap.android.uastool.tasks.UASTask$STATE r17 = com.atakmap.android.uastool.tasks.UASTask.STATE.STORED
            r19 = 0
            java.lang.String r18 = "#FFFFFF"
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            com.atakmap.android.uastool.tasks.route.edit.GimbalPitchEdit r0 = r1.gimbalPitchEdit
            java.lang.Integer r0 = r0.getGimbalPitch()
            if (r0 == 0) goto L_0x00d2
            int r0 = r0.intValue()
            r2.setGimbalPitch(r0)
        L_0x00d2:
            r0 = 2131034656(0x7f050220, float:1.7679836E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            android.text.Editable r0 = r0.getText()     // Catch:{ NumberFormatException -> 0x00f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x00f2 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ NumberFormatException -> 0x00f2 }
            if (r3 != 0) goto L_0x00fa
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x00f2 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00f2 }
            goto L_0x00fb
        L_0x00f2:
            r0 = move-exception
            java.lang.String r3 = TAG
            java.lang.String r6 = "Invalid imagery interval set - "
            com.atakmap.coremap.log.Log.d(r3, r6, r0)
        L_0x00fa:
            r0 = r4
        L_0x00fb:
            if (r0 == 0) goto L_0x0100
            r2.setImageryInterval(r0)
        L_0x0100:
            com.atakmap.android.uastool.tasks.UASTaskStore r0 = com.atakmap.android.uastool.tasks.UASTaskStore.getInstance()
            r0.saveTask(r2)
            com.atakmap.android.uastool.pagers.UASToolFragment r0 = r1.myParentFragment
            boolean r0 = r0 instanceof com.atakmap.android.uastool.pagers.TasksFragment
            if (r0 == 0) goto L_0x0117
            com.atakmap.android.uastool.pagers.UASToolFragment r0 = r1.myParentFragment
            com.atakmap.android.uastool.pagers.TasksFragment r0 = (com.atakmap.android.uastool.pagers.TasksFragment) r0
            r0.refreshList(r5)
            r2.view(r4, r5)
        L_0x0117:
            r20.closeScreen()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.SurveyScreen.createSurveyTask():void");
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

    private void saveCameraPreset() {
        double parseDouble = Double.parseDouble(this.sensorWidth.getText().toString());
        double parseDouble2 = Double.parseDouble(this.sensorHeight.getText().toString());
        double parseDouble3 = Double.parseDouble(this.sensorResolution.getText().toString());
        double parseDouble4 = Double.parseDouble(this.sensorFocalLength.getText().toString());
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putFloat(CUSTOM_SENSOR_WIDTH_KEY, (float) parseDouble);
        edit.putFloat(CUSTOM_SENSOR_HEIGHT_KEY, (float) parseDouble2);
        edit.putFloat(CUSTOM_SENSOR_RESOLUTION_KEY, (float) parseDouble3);
        edit.putFloat(CUSTOM_SENSOR_FOCAL_LENGTH_KEY, (float) parseDouble4);
        edit.apply();
        UASToolDropDownReceiver.toast("Saved custom camera preset.");
    }

    /* access modifiers changed from: private */
    public void updateCameraFields(boolean z) {
        if (z) {
            try {
                SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
                double d = (double) sharedPrefs.getFloat(CUSTOM_SENSOR_FOCAL_LENGTH_KEY, 24.0f);
                this.sensorWidth.setText(String.format("%.2f", new Object[]{Double.valueOf((double) sharedPrefs.getFloat(CUSTOM_SENSOR_WIDTH_KEY, 6.3f))}));
                this.sensorHeight.setText(String.format("%.2f", new Object[]{Double.valueOf((double) sharedPrefs.getFloat(CUSTOM_SENSOR_HEIGHT_KEY, 4.7f))}));
                this.sensorResolution.setText(String.format("%.2f", new Object[]{Double.valueOf((double) sharedPrefs.getFloat(CUSTOM_SENSOR_RESOLUTION_KEY, 12.0f))}));
                this.sensorFocalLength.setText(String.format("%.2f", new Object[]{Double.valueOf(d)}));
            } catch (Exception unused) {
            }
        } else {
            CameraInfo cameraInfo = this.cameraInfoMap.get((String) this.cameraSpinner.getSelectedItem());
            this.sensorWidth.setText(Double.toString(cameraInfo.getSensorWidth()));
            this.sensorHeight.setText(Double.toString(cameraInfo.getSensorHeight()));
            this.sensorResolution.setText(Double.toString(cameraInfo.getSensorResolution()));
            this.sensorFocalLength.setText(Double.toString(cameraInfo.getFocalLength()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shapeSelected(com.atakmap.android.maps.bb r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = 2131034125(0x7f05000d, float:1.7678759E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            r2 = 2131034242(0x7f050082, float:1.7678996E38)
            android.view.View r2 = r0.findViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            r3 = 2131034869(0x7f0502f5, float:1.7680268E38)
            android.view.View r3 = r0.findViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r4 = 2131035128(0x7f0503f8, float:1.7680793E38)
            android.view.View r4 = r0.findViewById(r4)
            android.widget.EditText r4 = (android.widget.EditText) r4
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            double r5 = java.lang.Double.parseDouble(r1)
            float r1 = (float) r5
            r0.desiredAglAlt = r1
            android.text.Editable r1 = r2.getText()
            java.lang.String r1 = r1.toString()
            double r1 = java.lang.Double.parseDouble(r1)
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            double r5 = java.lang.Double.parseDouble(r3)
            android.text.Editable r3 = r4.getText()
            java.lang.String r3 = r3.toString()
            double r3 = java.lang.Double.parseDouble(r3)
            com.atakmap.android.uastool.utils.Survey r15 = new com.atakmap.android.uastool.utils.Survey
            float r7 = r0.desiredAglAlt
            double r7 = (double) r7
            double r7 = atak.core.oe.b.a(r7)
            long r7 = java.lang.Math.round(r7)
            double r7 = (double) r7
            java.lang.Double r9 = java.lang.Double.valueOf(r7)
            java.lang.Double r10 = java.lang.Double.valueOf(r1)
            java.lang.Double r11 = java.lang.Double.valueOf(r5)
            java.lang.Double r12 = java.lang.Double.valueOf(r3)
            r7 = r15
            r8 = r19
            r7.<init>(r8, r9, r10, r11, r12)
            com.atakmap.android.gui.PluginSpinner r1 = r0.cameraSpinner
            java.lang.Object r1 = r1.getSelectedItem()
            r8 = r1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r1 = "Custom"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x00d6
            android.widget.EditText r1 = r0.sensorWidth     // Catch:{ Exception -> 0x00cf }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00cf }
            double r9 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00cf }
            android.widget.EditText r1 = r0.sensorHeight     // Catch:{ Exception -> 0x00cf }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00cf }
            double r11 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00cf }
            android.widget.EditText r1 = r0.sensorResolution     // Catch:{ Exception -> 0x00cf }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00cf }
            double r13 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00cf }
            android.widget.EditText r1 = r0.sensorFocalLength     // Catch:{ Exception -> 0x00cf }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00cf }
            double r1 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x00cf }
            r17 = 1
            r7 = r15
            r3 = r15
            r15 = r1
            r7.setCameraDetail(r8, r9, r11, r13, r15, r17)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00f9
        L_0x00cf:
            r3 = r15
        L_0x00d0:
            java.lang.String r1 = "Failed to parse camera values."
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r1)
            goto L_0x00f9
        L_0x00d6:
            r3 = r15
            java.util.Map<java.lang.String, com.atakmap.android.uastool.utils.CameraInfo> r1 = r0.cameraInfoMap
            java.lang.Object r1 = r1.get(r8)
            com.atakmap.android.uastool.utils.CameraInfo r1 = (com.atakmap.android.uastool.utils.CameraInfo) r1
            java.lang.String r8 = r1.getName()
            double r9 = r1.getSensorWidth()
            double r11 = r1.getSensorHeight()
            double r13 = r1.getSensorResolution()
            double r15 = r1.getFocalLength()
            r17 = 1
            r7 = r3
            r7.setCameraDetail(r8, r9, r11, r13, r15, r17)
        L_0x00f9:
            r1 = 0
            com.atakmap.android.routes.e r2 = r3.buildSurveyRoute(r1, r1)
            if (r2 == 0) goto L_0x010e
            java.lang.String r3 = "Survey route successfully added."
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r3, r1)
            r0.selectedRoute = r2
            android.widget.Button r1 = r0.createSurveyButton
            r2 = 1
            r1.setEnabled(r2)
            goto L_0x011b
        L_0x010e:
            java.lang.String r2 = "Survey route failed."
            com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r2, r1)
            r2 = 0
            r0.selectedRoute = r2
            android.widget.Button r2 = r0.createSurveyButton
            r2.setEnabled(r1)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.utils.SurveyScreen.shapeSelected(com.atakmap.android.maps.bb):void");
    }

    private void closeScreen() {
        this.myParentFragment.removeCurrentScreen();
    }

    private void createShape() {
        if (MapView.getMapView() != null) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setAction(SURVEY_SHAPE_CREATION_ACTION);
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
