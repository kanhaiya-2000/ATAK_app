package com.atakmap.android.uastool.r80d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.aeryon.java.command.CommandStateCallback;
import com.aeryon.java.types.Aircraft;
import com.aeryon.java.types.COMMAND_STATE;
import com.aeryon.java.types.FAULT_ACTION;
import com.aeryon.java.types.LIGHT_FAULT_MODE;
import com.aeryon.java.types.LIGHT_MODE;
import com.aeryon.java.types.Vec3dLLA;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.quickbar.QuickTaskTool;
import com.atakmap.android.uastool.r80d.R80dSettingsScreenCallback;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.ae;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.ArrayList;

public class R80dSettingsScreen extends SettingsScreen {
    /* access modifiers changed from: private */
    public PluginSpinner connLossSpinner;
    /* access modifiers changed from: private */
    public TextView connLossValue;
    private ImageButton cruiseSpeedButton;
    /* access modifiers changed from: private */
    public EditText cruiseSpeedText;
    /* access modifiers changed from: private */
    public TextView cruiseSpeedValue;
    /* access modifiers changed from: private */
    public PluginSpinner faultActionSpinner;
    /* access modifiers changed from: private */
    public TextView faultActionValue;
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
    /* access modifiers changed from: private */
    public PluginSpinner ledFaultSpinner;
    /* access modifiers changed from: private */
    public TextView ledFaultValue;
    /* access modifiers changed from: private */
    public PluginSpinner ledsSpinner;
    /* access modifiers changed from: private */
    public TextView ledsValue;
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
    private ImageButton recoverySpeedButton;
    /* access modifiers changed from: private */
    public EditText recoverySpeedText;
    /* access modifiers changed from: private */
    public TextView recoverySpeedValue;
    private Button setHomeButton;
    private TextView setHomeTextValue;
    /* access modifiers changed from: private */
    public Boolean spinnerUpdateBlocked;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.spinnerUpdateBlocked = false;
        ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.r80dsettings_refresh_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80dSettingsScreen.this.getPlatformSettings();
            }
        });
        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Refresh All", "Retrieves all current settings stored on the UAS.");
                return true;
            }
        });
        this.setHomeTextValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_set_home_value);
        Button button = (Button) findViewById(C1877R.C1878id.r80dsettings_set_home_button);
        this.setHomeButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80dSettingsScreen.this.onMoveHomeButton();
            }
        });
        this.setHomeButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Move Home Position", "Moves the home position by tapping on the map.");
                return true;
            }
        });
        TextView textView = (TextView) findViewById(C1877R.C1878id.r80dsettings_maxalt_text);
        this.maxAltValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_maxalt_value);
        this.maxAltButton = (ImageButton) findViewById(C1877R.C1878id.r80dsettings_maxalt_button);
        EditText editText = (EditText) findViewById(C1877R.C1878id.r80dsettings_maxalt_edit);
        this.maxAltText = editText;
        editText.setSelectAllOnFocus(true);
        this.maxAltButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.maxAltValue, R80dSettingsScreen.this.maxAltText.getText().toString(), (double) R80dSettingsScreen.this.altMultiplier, R80dSettingsScreenCallback.R80ValueType.MAX_ALT);
            }
        });
        this.maxAltButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Maximum Altitude", "Set the maximum altitude of the aircraft. AGL");
                return true;
            }
        });
        TextView textView2 = (TextView) findViewById(C1877R.C1878id.r80dsettings_maxdist_text);
        this.maxDistValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_maxdist_value);
        this.maxDistButton = (ImageButton) findViewById(C1877R.C1878id.r80dsettings_maxdist_button);
        EditText editText2 = (EditText) findViewById(C1877R.C1878id.r80dsettings_maxdist_edit);
        this.maxDistText = editText2;
        editText2.setSelectAllOnFocus(true);
        this.maxDistButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.maxDistValue, R80dSettingsScreen.this.maxDistText.getText().toString(), (double) R80dSettingsScreen.this.rangeMultiplier, R80dSettingsScreenCallback.R80ValueType.MAX_DIST);
            }
        });
        this.maxDistButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Maximum Distance", "Set the maximum distance of the aircraft. Distance value must be between .");
                return true;
            }
        });
        this.goHomePctValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_gohomebatt_value);
        this.goHomePctButton = (ImageButton) findViewById(C1877R.C1878id.r80dsettings_gohomebatt_button);
        EditText editText3 = (EditText) findViewById(C1877R.C1878id.r80dsettings_gohomebatt_edit);
        this.goHomePctText = editText3;
        editText3.setSelectAllOnFocus(true);
        this.goHomePctButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.goHomePctValue, R80dSettingsScreen.this.goHomePctText.getText().toString(), 1.0d, R80dSettingsScreenCallback.R80ValueType.HOME_PCT);
            }
        });
        this.goHomePctButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Go Home Battery Margin", "Set the Go Home Battery Margin of the aircraft. Battery Margin value is how many seconds of reserve flight time left when the aircraft will automatically return to home/land");
                return true;
            }
        });
        ((TextView) findViewById(C1877R.C1878id.r80dsettings_gohomealt_text)).setText("Go Home Altitude (AGL)");
        this.goHomeAltValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_gohomealt_value);
        this.goHomeAltButton = (ImageButton) findViewById(C1877R.C1878id.r80dsettings_gohomealt_button);
        EditText editText4 = (EditText) findViewById(C1877R.C1878id.r80dsettings_gohomealt_edit);
        this.goHomeAltText = editText4;
        editText4.setSelectAllOnFocus(true);
        this.goHomeAltButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.goHomeAltValue, R80dSettingsScreen.this.goHomeAltText.getText().toString(), (double) R80dSettingsScreen.this.altMultiplier, R80dSettingsScreenCallback.R80ValueType.HOME_ALT);
            }
        });
        this.goHomeAltButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Go Home Altitude", "Set the go home altitude of the aircraft. Altitude value must be between AGL.");
                return true;
            }
        });
        this.cruiseSpeedValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_cruisespeed_value);
        this.cruiseSpeedButton = (ImageButton) findViewById(C1877R.C1878id.r80dsettings_cruisespeed_button);
        EditText editText5 = (EditText) findViewById(C1877R.C1878id.r80dsettings_cruisespeed_edit);
        this.cruiseSpeedText = editText5;
        editText5.setSelectAllOnFocus(true);
        this.cruiseSpeedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.cruiseSpeedValue, R80dSettingsScreen.this.cruiseSpeedText.getText().toString(), (double) R80dSettingsScreen.this.speedMultiplier, R80dSettingsScreenCallback.R80ValueType.CRUISE_SPEED);
            }
        });
        this.cruiseSpeedButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Cruise Speed", "Set the cruise speed of the aircraft.");
                return true;
            }
        });
        this.recoverySpeedValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_recoveryspeed_value);
        this.recoverySpeedButton = (ImageButton) findViewById(C1877R.C1878id.r80dsettings_recoveryspeed_button);
        EditText editText6 = (EditText) findViewById(C1877R.C1878id.r80dsettings_recoveryspeed_edit);
        this.recoverySpeedText = editText6;
        editText6.setSelectAllOnFocus(true);
        this.recoverySpeedButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.recoverySpeedValue, R80dSettingsScreen.this.recoverySpeedText.getText().toString(), (double) R80dSettingsScreen.this.speedMultiplier, R80dSettingsScreenCallback.R80ValueType.HOME_SPEED);
            }
        });
        this.recoverySpeedButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                UASToolDropDownReceiver.getInstance().helpPopup("Cruise Speed", "Set the speed of the aircraft when returning to home.");
                return true;
            }
        });
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            if (LIGHT_MODE.fromInt(i) != null) {
                arrayList.add(LIGHT_MODE.fromInt(i).toString());
            }
        }
        this.ledsValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_led_value);
        this.ledsSpinner = findViewById(C1877R.C1878id.r80dsettings_leds_spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.pluginContext, 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(17367049);
        this.ledsSpinner.setAdapter(arrayAdapter);
        this.ledsSpinner.post(new Runnable() {
            public void run() {
                R80dSettingsScreen.this.ledsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (!R80dSettingsScreen.this.spinnerUpdateBlocked.booleanValue()) {
                            R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.ledsValue, Integer.toString(i), 1.0d, R80dSettingsScreenCallback.R80ValueType.LED_VALUE);
                        }
                    }
                });
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < 3; i2++) {
            if (LIGHT_FAULT_MODE.fromInt(i2) != null) {
                arrayList2.add(LIGHT_FAULT_MODE.fromInt(i2).toString());
            }
        }
        this.ledFaultValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_ledfault_value);
        this.ledFaultSpinner = findViewById(C1877R.C1878id.r80dsettings_ledfault_spinner);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this.pluginContext, 17367048, arrayList2);
        arrayAdapter2.setDropDownViewResource(17367049);
        this.ledFaultSpinner.setAdapter(arrayAdapter2);
        this.ledFaultSpinner.post(new Runnable() {
            public void run() {
                R80dSettingsScreen.this.ledFaultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (!R80dSettingsScreen.this.spinnerUpdateBlocked.booleanValue()) {
                            R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.ledFaultValue, Integer.toString(i), 1.0d, R80dSettingsScreenCallback.R80ValueType.LED_FAULT);
                        }
                    }
                });
            }
        });
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < 3; i3++) {
            if (FAULT_ACTION.fromInt(i3) != null) {
                arrayList3.add(FAULT_ACTION.fromInt(i3).toString());
            }
        }
        this.faultActionValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_faultaction_value);
        this.faultActionSpinner = findViewById(C1877R.C1878id.r80dsettings_faultaction_spinner);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this.pluginContext, 17367048, arrayList3);
        arrayAdapter3.setDropDownViewResource(17367049);
        this.faultActionSpinner.setAdapter(arrayAdapter3);
        this.faultActionSpinner.post(new Runnable() {
            public void run() {
                R80dSettingsScreen.this.faultActionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (!R80dSettingsScreen.this.spinnerUpdateBlocked.booleanValue()) {
                            R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.faultActionValue, Integer.toString(i), 1.0d, R80dSettingsScreenCallback.R80ValueType.FAULT_ACTION);
                        }
                    }
                });
            }
        });
        this.connLossValue = (TextView) findViewById(C1877R.C1878id.r80dsettings_connloss_value);
        this.connLossSpinner = findViewById(C1877R.C1878id.r80dsettings_connloss_spinner);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(this.pluginContext, 17367048, arrayList3);
        arrayAdapter4.setDropDownViewResource(17367049);
        this.connLossSpinner.setAdapter(arrayAdapter4);
        this.connLossSpinner.post(new Runnable() {
            public void run() {
                R80dSettingsScreen.this.connLossSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        if (!R80dSettingsScreen.this.spinnerUpdateBlocked.booleanValue()) {
                            R80dSettingsScreenCallback.tryParseUpdate(R80dSettingsScreen.this.getConnection(), R80dSettingsScreen.this.connLossValue, Integer.toString(i), 1.0d, R80dSettingsScreenCallback.R80ValueType.COMMS_LOSS_ACTION);
                        }
                    }
                });
            }
        });
        getPlatformSettings();
        getConnection().requestNavigationControl(new CommandStateCallback() {
            public void callback(COMMAND_STATE command_state) {
            }
        });
    }

    public R80dSettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = R80dSettingsScreen.class.getSimpleName();
    }

    /* access modifiers changed from: private */
    public void onMoveHomeButton() {
        Log.d(TAG, "onMoveHomeButton");
        UASToolDropDownReceiver.getInstance().dismissFullscreen();
        QuickTaskTool.begin(new QuickTaskTool.QuickTaskToolCallback() {
            public void onTaskComplete(GeoPoint geoPoint) {
                String access$2900 = R80dSettingsScreen.TAG;
                Log.d(access$2900, "MoveHomePositon: " + geoPoint.toString());
                ((R80dUASItem) R80dSettingsScreen.this.uasItem).setHomePosition(geoPoint);
                QuickTaskTool.end();
            }
        });
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
    }

    public void destroy() {
        super.destroy();
    }

    /* access modifiers changed from: private */
    public void getPlatformSettings() {
        if (getConnection() != null) {
            this.spinnerUpdateBlocked = true;
            this.recoverySpeedValue.setText(ae.a().a((double) getConnection().getRecoverySpeed()));
            this.recoverySpeedText.setText(printableValue((double) getConnection().getRecoverySpeed(), (double) this.speedMultiplier));
            this.maxAltValue.setText(Utils.formatAlt((double) getConnection().getMaxAltitude()));
            this.maxAltText.setText(printableValue((double) getConnection().getMaxAltitude(), (double) this.altMultiplier));
            this.goHomeAltValue.setText(Utils.formatAlt((double) getConnection().getMinimumSafeAltitude()));
            this.goHomeAltText.setText(printableValue((double) getConnection().getMinimumSafeAltitude(), (double) this.altMultiplier));
            this.maxDistValue.setText(Utils.formatRange((double) getConnection().getMaximumRange()));
            this.maxDistText.setText(printableValue((double) getConnection().getMaximumRange(), (double) this.rangeMultiplier));
            TextView textView = this.goHomePctValue;
            textView.setText(getConnection().getBatteryMargin() + "s");
            EditText editText = this.goHomePctText;
            editText.setText("" + getConnection().getBatteryMargin());
            FAULT_ACTION inFlightFaultAction = getConnection().getInFlightFaultAction();
            this.faultActionValue.setText(inFlightFaultAction.toString());
            this.faultActionSpinner.setSelection(inFlightFaultAction.toInt());
            LIGHT_MODE lightMode = getConnection().getLightMode();
            this.ledsValue.setText(lightMode.toString());
            this.ledsSpinner.setSelection(lightMode.toInt());
            LIGHT_FAULT_MODE lightFaultMode = getConnection().getLightFaultMode();
            this.ledFaultValue.setText(lightFaultMode.toString());
            this.ledFaultSpinner.setSelection(lightFaultMode.toInt());
            FAULT_ACTION commsLossAction = getConnection().getCommsLossAction();
            this.connLossValue.setText(commsLossAction.toString());
            this.connLossSpinner.setSelection(commsLossAction.toInt());
            this.cruiseSpeedValue.setText(ae.a().a((double) getConnection().getCruiseSpeed()));
            this.cruiseSpeedText.setText(printableValue((double) getConnection().getCruiseSpeed(), (double) this.speedMultiplier));
            Vec3dLLA homePosition = getConnection().getHomePosition();
            try {
                this.setHomeTextValue.setText(TasksFragment.convertCoordsToDisplay(new GeoPoint(homePosition.getLatitude(), homePosition.getLatitude())));
            } catch (Exception unused) {
                this.setHomeTextValue.setText("Unknown");
            }
            this.spinnerUpdateBlocked = false;
        }
    }

    /* access modifiers changed from: private */
    public Aircraft getConnection() {
        return R80dUASItem.getConnection(this.uasItem);
    }
}
