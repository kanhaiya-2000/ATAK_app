package com.atakmap.android.uastool.mavlink;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.quickbar.QuickTaskTool;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.bbn.ccast.mavlink.MavLinkDialectInterface;
import com.bbn.ccast.mavlink.MavLinkThread;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class MAVLinkSettingsScreen extends SettingsScreen implements MavLinkParameterChangedCallback, MavLinkTelemetryCallback {
    /* access modifiers changed from: private */
    public static final ArrayList<String> comLossActionStates;
    /* access modifiers changed from: private */
    public static final ArrayList<String> comLossWithRcActionStates;
    /* access modifiers changed from: private */
    public static final ArrayList<String> geoFenceLimitActionStates;
    /* access modifiers changed from: private */
    public static final ArrayList<String> lowBatteryActionStates;
    /* access modifiers changed from: private */
    public PluginSpinner comlostSpinner;
    /* access modifiers changed from: private */
    public TextView comlostValue;
    /* access modifiers changed from: private */
    public PluginSpinner comlostWithRcSpinner;
    /* access modifiers changed from: private */
    public TextView comlostWithRcValue;
    private TextView compassStateValue;
    private ImageButton cruiseSpeedButton;
    /* access modifiers changed from: private */
    public EditText cruiseSpeedText;
    /* access modifiers changed from: private */
    public TextView cruiseSpeedValue;
    /* access modifiers changed from: private */
    public final AtomicBoolean disableSpinnerListeners = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public PluginSpinner geoFenceLimitActionSpinner;
    /* access modifiers changed from: private */
    public TextView geoFenceLimitActionValue;
    private ImageButton goHomeAltButton;
    /* access modifiers changed from: private */
    public EditText goHomeAltText;
    /* access modifiers changed from: private */
    public TextView goHomeAltValue;
    private ImageButton goHomePctButton;
    /* access modifiers changed from: private */
    public EditText goHomePctText;
    /* access modifiers changed from: private */
    public TextView goHomePctValue;
    private ImageButton landNowPctButton;
    /* access modifiers changed from: private */
    public EditText landNowPctText;
    /* access modifiers changed from: private */
    public TextView landNowPctValue;
    private ImageButton lowBatPctButton;
    /* access modifiers changed from: private */
    public EditText lowBatPctText;
    /* access modifiers changed from: private */
    public TextView lowBatPctValue;
    /* access modifiers changed from: private */
    public PluginSpinner lowBatteryActionSpinner;
    /* access modifiers changed from: private */
    public TextView lowBatteryActionValue;
    private ImageButton maxAltButton;
    /* access modifiers changed from: private */
    public EditText maxAltText;
    /* access modifiers changed from: private */
    public TextView maxAltValue;
    private ImageButton maxDistButton;
    /* access modifiers changed from: private */
    public EditText maxDistText;
    /* access modifiers changed from: private */
    public TextView maxDistValue;
    private ImageButton maxManualSpeedButton;
    /* access modifiers changed from: private */
    public EditText maxManualSpeedText;
    /* access modifiers changed from: private */
    public TextView maxManualSpeedValue;
    private ImageButton maxSpeedButton;
    /* access modifiers changed from: private */
    public EditText maxSpeedText;
    /* access modifiers changed from: private */
    public TextView maxSpeedValue;
    private Button setHomeButton;
    private TextView setHomeTextValue;
    private ImageButton takeoffAltButton;
    /* access modifiers changed from: private */
    public EditText takeoffAltText;
    /* access modifiers changed from: private */
    public TextView takeoffAltValue;

    public void onHeartBeat(boolean z, String str) {
    }

    public void onPositionUpdate(double d, double d2, double d3, double d4, double d5) {
    }

    public void onSensorAngleUpdate(double d, double d2, double d3, double d4) {
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        lowBatteryActionStates = arrayList;
        arrayList.add(HttpHeaders.WARNING);
        arrayList.add("Return To Home");
        arrayList.add("Land Now");
        ArrayList<String> arrayList2 = new ArrayList<>();
        geoFenceLimitActionStates = arrayList2;
        arrayList2.add("None");
        arrayList2.add(HttpHeaders.WARNING);
        arrayList2.add("Loiter");
        arrayList2.add("Return To Home");
        arrayList2.add("Terminate");
        ArrayList<String> arrayList3 = new ArrayList<>();
        comLossActionStates = arrayList3;
        arrayList3.add("Disabled");
        arrayList3.add("Hold");
        arrayList3.add("Return To Home");
        arrayList3.add("Terminate");
        arrayList3.add("Lockdown");
        ArrayList<String> arrayList4 = new ArrayList<>();
        comLossWithRcActionStates = arrayList4;
        arrayList4.add("Position Mode");
        arrayList4.add("Altitude Mode");
        arrayList4.add("Manual");
        arrayList4.add("Return To Home");
        arrayList4.add("Land Now");
        arrayList4.add("Hold Mode");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        final MavLinkThread mavLinkThread = getMavLinkThread();
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_refresh_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.getPlatformSettings();
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Refresh All", "Retrieves all current settings stored on the UAS.");
                return true;
            }
        });
        ((TextView) findViewById(C1877R.C1878id.mavlinksettings_takeoff_alt_text)).setText("Takeoff Altitude (" + this.altUnits.getAbbrev() + "AGL)");
        this.takeoffAltValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_takeoff_alt_value);
        this.takeoffAltButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_takeoff_alt_button);
        EditText editText = (EditText) findViewById(C1877R.C1878id.mavlinksettings_takeoff_alt_edit);
        this.takeoffAltText = editText;
        editText.setSelectAllOnFocus(true);
        this.takeoffAltButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.TAKEOFF_ALT), MAVLinkSettingsScreen.this.takeoffAltText, (double) MAVLinkSettingsScreen.this.altMultiplier);
            }
        });
        this.takeoffAltButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Maximum Altitude", "Set the takeoff altitude of the aircraft. AGL");
                return true;
            }
        });
        this.compassStateValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_calibcompass_value);
        ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_calibcompass_button);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkCompassCalibScreen mAVLinkCompassCalibScreen = (MAVLinkCompassCalibScreen) LayoutInflater.from(MAVLinkSettingsScreen.this.pluginContext).inflate(C1877R.layout.mavlink_compass_screen, (ViewGroup) null);
                mAVLinkCompassCalibScreen.setUASItem((MAVLinkUASItem) MAVLinkSettingsScreen.this.uasItem);
                MAVLinkSettingsScreen.this.myParentFragment.setCurrentScreen(mAVLinkCompassCalibScreen, MAVLinkSettingsScreen.this.uasItem, MAVLinkSettingsScreen.this.myParentFragment);
            }
        });
        imageButton2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                MAVLinkSettingsScreen.this.showHelp("Calibrate Compass", "Allows the user to calibrate the compass on the UAS.");
                return true;
            }
        });
        ((TextView) findViewById(C1877R.C1878id.mavlinksettings_maxalt_text)).setText("Max Altitude (" + this.altUnits.getAbbrev() + "AGL)");
        this.maxAltValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_maxalt_value);
        this.maxAltButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_maxalt_button);
        EditText editText2 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_maxalt_edit);
        this.maxAltText = editText2;
        editText2.setSelectAllOnFocus(true);
        this.maxAltButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_ALT), MAVLinkSettingsScreen.this.maxAltText, (double) MAVLinkSettingsScreen.this.altMultiplier);
            }
        });
        this.maxAltButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Maximum Altitude", "Set the maximum altitude of the aircraft. AGL");
                return true;
            }
        });
        ((TextView) findViewById(C1877R.C1878id.mavlinksettings_maxdist_text)).setText("Max Dist Restrict (" + this.rangeUnits.getAbbrev() + ")");
        this.maxDistValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_maxdist_value);
        this.maxDistButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_maxdist_button);
        EditText editText3 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_maxdist_edit);
        this.maxDistText = editText3;
        editText3.setSelectAllOnFocus(true);
        this.maxDistButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen mAVLinkSettingsScreen = MAVLinkSettingsScreen.this;
                mAVLinkSettingsScreen.tryParseUpdate("GF_MAX_HOR_DIST", mAVLinkSettingsScreen.maxDistText, (double) MAVLinkSettingsScreen.this.rangeMultiplier);
            }
        });
        this.maxDistButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver instance = UASToolDropDownReceiver.getInstance();
                instance.helpPopup("Maximum Distance", "Set the maximum distance of the aircraft. Distance value must be between " + MAVLinkSettingsScreen.this.rangeUnits.getAbbrev() + ".");
                return true;
            }
        });
        this.lowBatPctValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_lowbatt_value);
        this.lowBatPctButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_lowbatt_button);
        EditText editText4 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_lowbatt_edit);
        this.lowBatPctText = editText4;
        editText4.setSelectAllOnFocus(true);
        this.lowBatPctButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.BATTERY_LOW_PERCENT), MAVLinkSettingsScreen.this.lowBatPctText, (double) MAVLinkSettingsScreen.this.percentMultiplier);
            }
        });
        this.lowBatPctButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Low Battery Percentage", "Set the Low Battery Percentage of the aircraft. Battery percentage value must be between 4 to 12. The Low Battery Percentage must always be greater than the Land Now Battery Percentage.");
                return true;
            }
        });
        this.goHomePctValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_gohomebatt_value);
        this.goHomePctButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_gohomebatt_button);
        EditText editText5 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_gohomebatt_edit);
        this.goHomePctText = editText5;
        editText5.setSelectAllOnFocus(true);
        this.goHomePctButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.BATERY_CRITCAL_PERCENT), MAVLinkSettingsScreen.this.goHomePctText, (double) MAVLinkSettingsScreen.this.percentMultiplier);
            }
        });
        this.goHomePctButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Go Home Battery Percentage", "Set the Go Home Battery Percentage of the aircraft. Battery percentage value must be between 5 to 10. The Go Home Battery Percentage must always be greater than the Land Now Battery Percentage.");
                return true;
            }
        });
        this.landNowPctValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_landbatt_value);
        this.landNowPctButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_landbatt_button);
        EditText editText6 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_landbatt_edit);
        this.landNowPctText = editText6;
        editText6.setSelectAllOnFocus(true);
        this.landNowPctButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.BATERY_EMERGENCY_PERCENT), MAVLinkSettingsScreen.this.landNowPctText, (double) MAVLinkSettingsScreen.this.percentMultiplier);
            }
        });
        this.landNowPctButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Land Now Battery Percentage", "Set the Land Now Battery Percentage of the aircraft. Battery percentage value must be between 3 to 7. The Land Now Battery Percentage must always be less than the Go Home Battery Percentage.");
                return true;
            }
        });
        ((TextView) findViewById(C1877R.C1878id.mavlinksettings_gohomealt_text)).setText("Go Home Altitude (" + this.altUnits.getAbbrev() + "AGL)");
        this.goHomeAltValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_gohomealt_value);
        this.goHomeAltButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_gohomealt_button);
        EditText editText7 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_gohomealt_edit);
        this.goHomeAltText = editText7;
        editText7.setSelectAllOnFocus(true);
        this.goHomeAltButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.RETURN_ALT), MAVLinkSettingsScreen.this.goHomeAltText, (double) MAVLinkSettingsScreen.this.altMultiplier);
            }
        });
        this.goHomeAltButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver instance = UASToolDropDownReceiver.getInstance();
                instance.helpPopup("Go Home Altitude", "Set the go home altitude of the aircraft." + MAVLinkSettingsScreen.this.altUnits.getAbbrev() + "AGL.");
                return true;
            }
        });
        this.cruiseSpeedValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_cruisespeed_value);
        ((TextView) findViewById(C1877R.C1878id.mavlinksettings_cruisespeed_text)).setText("Cruise Speed (" + this.speedUnits + ")");
        this.cruiseSpeedButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_cruisespeed_button);
        EditText editText8 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_cruisespeed_edit);
        this.cruiseSpeedText = editText8;
        editText8.setSelectAllOnFocus(true);
        this.cruiseSpeedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.CRUSE_VEL), MAVLinkSettingsScreen.this.cruiseSpeedText, (double) MAVLinkSettingsScreen.this.speedMultiplier);
            }
        });
        this.cruiseSpeedButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Cruise Speed", "Set the cruise speed of the aircraft.");
                return true;
            }
        });
        this.maxSpeedValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_maxspeed_value);
        ((TextView) findViewById(C1877R.C1878id.mavlinksettings_maxspeed_text)).setText("Max Speed (" + this.speedUnits + ")");
        this.maxSpeedButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_maxspeed_button);
        EditText editText9 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_maxspeed_edit);
        this.maxSpeedText = editText9;
        editText9.setSelectAllOnFocus(true);
        this.maxSpeedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_VEL), MAVLinkSettingsScreen.this.maxSpeedText, (double) MAVLinkSettingsScreen.this.speedMultiplier);
            }
        });
        this.maxSpeedButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Max Speed", "Set the Max speed of the aircraft.");
                return true;
            }
        });
        this.maxManualSpeedValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_max_manual_speed_value);
        ((TextView) findViewById(C1877R.C1878id.mavlinksettings_max_manual_speed_text)).setText("Max Manual Speed (" + this.speedUnits + ")");
        this.maxManualSpeedButton = (ImageButton) findViewById(C1877R.C1878id.mavlinksettings_max_manual_speed_button);
        EditText editText10 = (EditText) findViewById(C1877R.C1878id.mavlinksettings_max_manual_speed_edit);
        this.maxManualSpeedText = editText10;
        editText10.setSelectAllOnFocus(true);
        this.maxManualSpeedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_MANUAL_VEL), MAVLinkSettingsScreen.this.maxManualSpeedText, (double) MAVLinkSettingsScreen.this.speedMultiplier);
            }
        });
        this.maxManualSpeedButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Max Manual Speed", "Set the Max speed of the aircraft when using joystick control.");
                return true;
            }
        });
        this.geoFenceLimitActionValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_geofencelimitaction_value);
        this.geoFenceLimitActionSpinner = findViewById(C1877R.C1878id.mavlinksettings_geofencelimitaction_spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, 17367048, geoFenceLimitActionStates);
        arrayAdapter.setDropDownViewResource(17367049);
        this.geoFenceLimitActionSpinner.setAdapter(arrayAdapter);
        this.geoFenceLimitActionSpinner.post(new Runnable() {
            public void run() {
                MAVLinkSettingsScreen.this.geoFenceLimitActionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (!MAVLinkSettingsScreen.this.disableSpinnerListeners.get()) {
                            MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.GEOFENCE_ACTION), MAVLinkSettingsScreen.this.geoFenceLimitActionSpinner);
                        }
                    }
                });
            }
        });
        this.comlostValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_connloss_action_value);
        this.comlostSpinner = findViewById(C1877R.C1878id.mavlinksettings_connloss_action_spinner);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this.pluginContext, 17367048, comLossActionStates);
        arrayAdapter2.setDropDownViewResource(17367049);
        this.comlostSpinner.setAdapter(arrayAdapter2);
        this.comlostSpinner.post(new Runnable() {
            public void run() {
                MAVLinkSettingsScreen.this.comlostSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (!MAVLinkSettingsScreen.this.disableSpinnerListeners.get()) {
                            MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.DATALINK_LOST_ACTION), MAVLinkSettingsScreen.this.comlostSpinner);
                        }
                    }
                });
            }
        });
        this.comlostWithRcValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_connloss_with_rc_value);
        this.comlostWithRcSpinner = findViewById(C1877R.C1878id.mavlinksettings_connloss_with_rc_spinner);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this.pluginContext, 17367048, comLossWithRcActionStates);
        arrayAdapter3.setDropDownViewResource(17367049);
        this.comlostWithRcSpinner.setAdapter(arrayAdapter3);
        this.comlostWithRcSpinner.post(new Runnable() {
            public void run() {
                MAVLinkSettingsScreen.this.comlostWithRcSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (!MAVLinkSettingsScreen.this.disableSpinnerListeners.get()) {
                            MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.DATALINK_LOST_WITHRC_ACTION), MAVLinkSettingsScreen.this.comlostWithRcSpinner);
                        }
                    }
                });
            }
        });
        this.lowBatteryActionValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_lowbatteryaction_value);
        this.lowBatteryActionSpinner = findViewById(C1877R.C1878id.mavlinksettings_lowbatteryaction_spinner);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(this.pluginContext, 17367048, lowBatteryActionStates);
        arrayAdapter4.setDropDownViewResource(17367049);
        this.lowBatteryActionSpinner.setAdapter(arrayAdapter4);
        this.lowBatteryActionSpinner.post(new Runnable() {
            public void run() {
                MAVLinkSettingsScreen.this.lowBatteryActionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (!MAVLinkSettingsScreen.this.disableSpinnerListeners.get()) {
                            MAVLinkSettingsScreen.this.tryParseUpdate(mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.LOW_BATTERY_ACTION), MAVLinkSettingsScreen.this.lowBatteryActionSpinner);
                        }
                    }
                });
            }
        });
        this.setHomeTextValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_set_home_value);
        Button button = (Button) findViewById(C1877R.C1878id.mavlinksettings_set_home_button);
        this.setHomeButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MAVLinkSettingsScreen.this.onMoveHomeButton();
            }
        });
        this.setHomeButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Move Home Position", "Moves the home position by tapping on the map.");
                return true;
            }
        });
        getPlatformSettings();
    }

    public MAVLinkSettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = MAVLinkSettingsScreen.class.getSimpleName();
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread != null) {
            mavLinkThread.addSettingsListener(this);
            mavLinkThread.addTelemetryListener(this);
        }
    }

    public void destroy() {
        super.destroy();
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread != null) {
            mavLinkThread.removeSettingsListener(this);
            mavLinkThread.removeTelemetryListener(this);
        }
    }

    /* access modifiers changed from: private */
    public void getPlatformSettings() {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread != null) {
            try {
                mavLinkThread.sendRequestParams();
            } catch (Exception unused) {
                UASToolDropDownReceiver.toast("Unable to request Settings", 0);
            }
        }
    }

    public void tryParseUpdate(String str, Spinner spinner) {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread == null) {
            UASToolDropDownReceiver.toast("Error setting " + str + ". No connection.", 0);
            return;
        }
        try {
            mavLinkThread.setParameter_int(str, spinner.getSelectedItemPosition());
        } catch (Exception unused) {
        }
    }

    public void tryParseUpdate(String str, TextView textView, double d) {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread == null) {
            UASToolDropDownReceiver.toast("Error setting " + str + ". No connection.", 0);
            return;
        }
        try {
            mavLinkThread.setParameter_float(str, (float) ((1.0d / d) * Double.parseDouble(textView.getText().toString())));
        } catch (Exception unused) {
            UASToolDropDownReceiver.toast("Error setting " + str, 0);
            textView.setText("" + mavLinkThread.getParamValue(str));
        }
    }

    public void onParameterChanged(final String str, final Float f) {
        if (f != null) {
            final MavLinkThread mavLinkThread = getMavLinkThread();
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    Integer valueOf = Integer.valueOf(f.intValue());
                    Float f = f;
                    MAVLinkSettingsScreen.this.disableSpinnerListeners.set(true);
                    if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.RETURN_ALT).equals(str)) {
                        MAVLinkSettingsScreen.this.goHomeAltValue.setText(String.format("%d%s", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.altMultiplier)), MAVLinkSettingsScreen.this.altUnits.getAbbrev()}));
                        MAVLinkSettingsScreen.this.goHomeAltText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.altMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_DIST).equals(str)) {
                        MAVLinkSettingsScreen.this.maxDistValue.setText(String.format("%d%s", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.rangeMultiplier)), MAVLinkSettingsScreen.this.rangeUnits.getAbbrev()}));
                        MAVLinkSettingsScreen.this.maxDistText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.rangeMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_ALT).equals(str)) {
                        MAVLinkSettingsScreen.this.maxAltValue.setText(String.format("%d%s", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.altMultiplier)), MAVLinkSettingsScreen.this.altUnits.getAbbrev()}));
                        MAVLinkSettingsScreen.this.maxAltText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.altMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.TAKEOFF_ALT).equals(str)) {
                        MAVLinkSettingsScreen.this.takeoffAltValue.setText(String.format("%d%s", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.altMultiplier)), MAVLinkSettingsScreen.this.altUnits.getAbbrev()}));
                        MAVLinkSettingsScreen.this.takeoffAltText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.altMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.CRUSE_VEL).equals(str)) {
                        MAVLinkSettingsScreen.this.cruiseSpeedValue.setText(String.format("%d%s", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.speedMultiplier)), MAVLinkSettingsScreen.this.speedUnits}));
                        MAVLinkSettingsScreen.this.cruiseSpeedText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.speedMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_VEL).equals(str)) {
                        MAVLinkSettingsScreen.this.maxSpeedValue.setText(String.format("%d%s", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.speedMultiplier)), MAVLinkSettingsScreen.this.speedUnits}));
                        MAVLinkSettingsScreen.this.maxSpeedText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.speedMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_MANUAL_VEL).equals(str)) {
                        MAVLinkSettingsScreen.this.maxManualSpeedValue.setText(String.format("%d%s", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.speedMultiplier)), MAVLinkSettingsScreen.this.speedUnits}));
                        MAVLinkSettingsScreen.this.maxManualSpeedText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.speedMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.BATTERY_LOW_PERCENT).equals(str)) {
                        MAVLinkSettingsScreen.this.lowBatPctValue.setText(String.format("%d%%", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.percentMultiplier))}));
                        MAVLinkSettingsScreen.this.lowBatPctText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.percentMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.BATERY_CRITCAL_PERCENT).equals(str)) {
                        MAVLinkSettingsScreen.this.goHomePctValue.setText(String.format("%d%%", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.percentMultiplier))}));
                        MAVLinkSettingsScreen.this.goHomePctText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.percentMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.BATERY_EMERGENCY_PERCENT).equals(str)) {
                        MAVLinkSettingsScreen.this.landNowPctValue.setText(String.format("%d%%", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.percentMultiplier))}));
                        MAVLinkSettingsScreen.this.landNowPctText.setText(String.format("%d", new Object[]{Long.valueOf((long) (f.floatValue() * MAVLinkSettingsScreen.this.percentMultiplier))}));
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.LOW_BATTERY_ACTION).equals(str)) {
                        try {
                            MAVLinkSettingsScreen.this.lowBatteryActionValue.setText((CharSequence) MAVLinkSettingsScreen.lowBatteryActionStates.get(valueOf.intValue()));
                            MAVLinkSettingsScreen.this.lowBatteryActionSpinner.setSelection(valueOf.intValue());
                        } catch (Exception e) {
                            Log.d(MAVLinkSettingsScreen.TAG, e.getMessage());
                        }
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.GEOFENCE_ACTION).equals(str)) {
                        try {
                            MAVLinkSettingsScreen.this.geoFenceLimitActionValue.setText((CharSequence) MAVLinkSettingsScreen.geoFenceLimitActionStates.get(valueOf.intValue()));
                            MAVLinkSettingsScreen.this.geoFenceLimitActionSpinner.setSelection(valueOf.intValue());
                        } catch (Exception e2) {
                            Log.d(MAVLinkSettingsScreen.TAG, e2.getMessage());
                        }
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.DATALINK_LOST_ACTION).equals(str)) {
                        try {
                            MAVLinkSettingsScreen.this.comlostValue.setText((CharSequence) MAVLinkSettingsScreen.comLossActionStates.get(valueOf.intValue()));
                            MAVLinkSettingsScreen.this.comlostSpinner.setSelection(valueOf.intValue());
                        } catch (Exception e3) {
                            Log.d(MAVLinkSettingsScreen.TAG, e3.getMessage());
                        }
                    } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.DATALINK_LOST_WITHRC_ACTION).equals(str)) {
                        try {
                            MAVLinkSettingsScreen.this.comlostWithRcValue.setText((CharSequence) MAVLinkSettingsScreen.comLossWithRcActionStates.get(valueOf.intValue()));
                            MAVLinkSettingsScreen.this.comlostWithRcSpinner.setSelection(valueOf.intValue());
                        } catch (Exception e4) {
                            Log.d(MAVLinkSettingsScreen.TAG, e4.getMessage());
                        }
                    }
                    MAVLinkSettingsScreen.this.disableSpinnerListeners.set(false);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onMoveHomeButton() {
        Log.d(TAG, "onMoveHomeButton");
        UASToolDropDownReceiver.getInstance().dismissFullscreen();
        QuickTaskTool.begin(new QuickTaskTool.QuickTaskToolCallback() {
            public void onTaskComplete(GeoPoint geoPoint) {
                String access$8400 = MAVLinkSettingsScreen.TAG;
                Log.d(access$8400, "MoveHomePositon: " + geoPoint.toString());
                ((MAVLinkUASItem) MAVLinkSettingsScreen.this.uasItem).setHomePosition(geoPoint);
                QuickTaskTool.end();
            }
        });
    }

    public void onHomePositonUpdate(double d, double d2, double d3) {
        try {
            this.setHomeTextValue.setText(TasksFragment.convertCoordsToDisplay(new GeoPoint(d, d2, d3)));
        } catch (Exception unused) {
            this.setHomeTextValue.setText("Unknown");
        }
    }

    /* access modifiers changed from: private */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }

    private MavLinkThread getMavLinkThread() {
        if (this.uasItem instanceof MAVLinkUASItem) {
            return ((MAVLinkUASItem) this.uasItem).getMavLinkThread();
        }
        return null;
    }
}
