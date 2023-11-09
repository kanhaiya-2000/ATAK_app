package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import atak.core.oe;
import com.atakmap.android.atakgo.dji.IDjiAtakInterface;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.plugin.BuildConfig;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.AtakPrefConstants;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.util.a;
import com.atakmap.coremap.conversions.Span;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DJISettingsScreen extends SettingsScreen {
    private static final String LIGHTBRIDGE_CHANNELMODE_AUTO = "Auto";
    private static final String LIGHTBRIDGE_CHANNELMODE_MANUAL = "Manual";
    private static final String LIGHTBRIDGE_DATARATE_10 = "10 Mbps";
    private static final String LIGHTBRIDGE_DATARATE_4 = "4 Mbps";
    private static final String LIGHTBRIDGE_DATARATE_6 = "6 Mbps";
    private static final String LIGHTBRIDGE_DATARATE_8 = "8 Mbps";
    private static final String LIGHTBRIDGE_FREQUENCYBAND_24 = "2.4 GHz";
    private static final String LIGHTBRIDGE_FREQUENCYBAND_57 = "5.7 GHz";
    private static final String LIGHTBRIDGE_FREQUENCYBAND_58 = "5.8 GHz";
    private static final String LIGHTBRIDGE_TRANSMISSIONMODE_HI = "High Quality";
    private static final String LIGHTBRIDGE_TRANSMISSIONMODE_LO = "Low Latency";
    private static final int MSG_ERROR = 2;
    private static final int MSG_GOOD = 0;
    private static final int MSG_WARN = 1;
    private static final String OCUSYNC_CHANNELBANDWIDTH_10 = "10 MHz";
    private static final String OCUSYNC_CHANNELBANDWIDTH_20 = "20 MHz";
    private static final String OCUSYNC_CHANNELBANDWIDTH_40 = "40 MHz";
    private static final String OCUSYNC_CHANNELMODE_AUTO = "Auto";
    private static final String OCUSYNC_CHANNELMODE_MANUAL = "Manual";
    private static final String OCUSYNC_FREQUENCYBAND_24 = "2.4 GHz";
    private static final String OCUSYNC_FREQUENCYBAND_58 = "5.8 GHz";
    private static final String OCUSYNC_FREQUENCYBAND_DUAL = "Dual";
    private static String TAG = "DJISettingsScreen";
    private static final String WIFI_CHANNELMODE_AUTO = "Auto";
    private static final String WIFI_CHANNELMODE_CUSTOM = "Custom";
    private static final String WIFI_DATARATE_1 = "1 Mbps";
    private static final String WIFI_DATARATE_2 = "2 Mbps";
    private static final String WIFI_DATARATE_4 = "4 Mbps";
    private static final String WIFI_FREQUENCYBAND_24 = "2.4 GHz";
    private static final String WIFI_FREQUENCYBAND_5 = "5 GHz";
    private static final String WIFI_FREQUENCYBAND_DUAL = "Dual";
    private ImageButton accelStateButton;
    private TextView accelStateValue;
    private ImageButton activateButton;
    /* access modifiers changed from: private */
    public TextView activateValue;
    private ImageButton activeAvoidButton;
    private CheckBox activeAvoidCheck;
    private TextView activeAvoidValue;
    /* access modifiers changed from: private */
    public Span altUnits;
    private ImageButton collAvoidButton;
    private CheckBox collAvoidCheck;
    private TextView collAvoidValue;
    private ImageButton compassStateButton;
    private TextView compassStateValue;
    /* access modifiers changed from: private */
    public String[] connLossArray;
    private ImageButton connLossButton;
    /* access modifiers changed from: private */
    public AlertDialog connLossDialog;
    /* access modifiers changed from: private */
    public TextView connLossText;
    private TextView connLossValue;
    /* access modifiers changed from: private */
    public ImageButton formatSDButton;
    /* access modifiers changed from: private */
    public TextView formatSDValue;
    /* access modifiers changed from: private */
    public ImageButton formatStorageButton;
    /* access modifiers changed from: private */
    public TextView formatStorageValue;
    private ImageButton gimbalStateButton;
    private TextView gimbalStateValue;
    private ImageButton goHomeAltButton;
    private int goHomeAltHigh;
    private int goHomeAltLow;
    private EditText goHomeAltText;
    private TextView goHomeAltValue;
    private ImageButton goHomePctButton;
    private int goHomePctHigh;
    private int goHomePctLow;
    private EditText goHomePctText;
    private TextView goHomePctValue;
    private ImageButton gyroStateButton;
    private TextView gyroStateValue;
    /* access modifiers changed from: private */
    public int homeAltHigh;
    /* access modifiers changed from: private */
    public int homeAltLow;
    private ImageButton landNowPctButton;
    private int landNowPctHigh;
    private int landNowPctLow;
    private EditText landNowPctText;
    private TextView landNowPctValue;
    private ImageButton landProtectButton;
    private CheckBox landProtectCheck;
    private TextView landProtectValue;
    private ImageButton landingGearButton;
    private CheckBox landingGearCheck;
    private TextView landingGearValue;
    /* access modifiers changed from: private */
    public String[] lightBridgeChannelModeArray;
    private ImageButton lightBridgeChannelModeButton;
    /* access modifiers changed from: private */
    public AlertDialog lightBridgeChannelModeDialog;
    /* access modifiers changed from: private */
    public TextView lightBridgeChannelModeText;
    private TextView lightBridgeChannelModeValue;
    /* access modifiers changed from: private */
    public int lightBridgeChannelNumHi;
    /* access modifiers changed from: private */
    public int lightBridgeChannelNumLow;
    private ImageButton lightBridgeChannelNumberButton;
    private TextView lightBridgeChannelNumberText;
    private TextView lightBridgeChannelNumberValue;
    /* access modifiers changed from: private */
    public String[] lightBridgeDataRateArray;
    private ImageButton lightBridgeDataRateButton;
    /* access modifiers changed from: private */
    public AlertDialog lightBridgeDataRateDialog;
    /* access modifiers changed from: private */
    public TextView lightBridgeDataRateText;
    private TextView lightBridgeDataRateValue;
    /* access modifiers changed from: private */
    public String[] lightBridgeFrequencyBandArray;
    private ImageButton lightBridgeFrequencyBandButton;
    private AlertDialog lightBridgeFrequencyBandDialog;
    /* access modifiers changed from: private */
    public TextView lightBridgeFrequencyBandText;
    private TextView lightBridgeFrequencyBandValue;
    /* access modifiers changed from: private */
    public String[] lightBridgeTransmissionModeArray;
    private ImageButton lightBridgeTransmissionModeButton;
    /* access modifiers changed from: private */
    public AlertDialog lightBridgeTransmissionModeDialog;
    /* access modifiers changed from: private */
    public TextView lightBridgeTransmissionModeText;
    private TextView lightBridgeTransmissionModeValue;
    /* access modifiers changed from: private */
    public RelativeLayout loadingLayout;
    private ImageButton maxAltButton;
    /* access modifiers changed from: private */
    public int maxAltHigh;
    /* access modifiers changed from: private */
    public int maxAltLow;
    private EditText maxAltText;
    private TextView maxAltValue;
    private ImageButton maxDistButton;
    /* access modifiers changed from: private */
    public double maxDistHigh;
    /* access modifiers changed from: private */
    public double maxDistLow;
    private EditText maxDistText;
    private TextView maxDistValue;
    private TextView msgsText;
    /* access modifiers changed from: private */
    public String[] ocuSyncChannelBandwidthArray;
    private ImageButton ocuSyncChannelBandwidthButton;
    /* access modifiers changed from: private */
    public AlertDialog ocuSyncChannelBandwidthDialog;
    /* access modifiers changed from: private */
    public TextView ocuSyncChannelBandwidthText;
    private TextView ocuSyncChannelBandwidthValue;
    /* access modifiers changed from: private */
    public String[] ocuSyncChannelModeArray;
    private ImageButton ocuSyncChannelModeButton;
    /* access modifiers changed from: private */
    public AlertDialog ocuSyncChannelModeDialog;
    /* access modifiers changed from: private */
    public TextView ocuSyncChannelModeText;
    private TextView ocuSyncChannelModeValue;
    /* access modifiers changed from: private */
    public int ocuSyncChannelNumHi;
    /* access modifiers changed from: private */
    public int ocuSyncChannelNumLow;
    private ImageButton ocuSyncChannelNumberButton;
    private TextView ocuSyncChannelNumberText;
    private TextView ocuSyncChannelNumberValue;
    /* access modifiers changed from: private */
    public String[] ocuSyncFrequencyBandArray;
    private ImageButton ocuSyncFrequencyBandButton;
    private AlertDialog ocuSyncFrequencyBandDialog;
    /* access modifiers changed from: private */
    public TextView ocuSyncFrequencyBandText;
    private TextView ocuSyncFrequencyBandValue;
    private ImageButton precisionLandButton;
    private CheckBox precisionLandCheck;
    private TextView precisionLandValue;
    /* access modifiers changed from: private */
    public Span rangeUnits;
    private ImageButton rezFPSButton;
    private HashMap<String, String> rezFPSMap;
    /* access modifiers changed from: private */
    public TextView rezFPSText;
    private TextView rezFPSValue;
    private ImageButton unlockButton;
    /* access modifiers changed from: private */
    public TextView unlockValue;
    private ImageButton visionPosButton;
    private CheckBox visionPosCheck;
    private TextView visionPosValue;
    private int[] wiFiChannelNumbers;
    /* access modifiers changed from: private */
    public String[] wifiChannelModeArray;
    private ImageButton wifiChannelModeButton;
    /* access modifiers changed from: private */
    public AlertDialog wifiChannelModeDialog;
    /* access modifiers changed from: private */
    public TextView wifiChannelModeText;
    private TextView wifiChannelModeValue;
    private ImageButton wifiChannelNumberButton;
    private TextView wifiChannelNumberText;
    private TextView wifiChannelNumberValue;
    /* access modifiers changed from: private */
    public String[] wifiDataRateArray;
    private ImageButton wifiDataRateButton;
    /* access modifiers changed from: private */
    public AlertDialog wifiDataRateDialog;
    /* access modifiers changed from: private */
    public TextView wifiDataRateText;
    private TextView wifiDataRateValue;
    /* access modifiers changed from: private */
    public String[] wifiFrequencyBandArray;
    private ImageButton wifiFrequencyBandButton;
    /* access modifiers changed from: private */
    public AlertDialog wifiFrequencyBandDialog;
    /* access modifiers changed from: private */
    public TextView wifiFrequencyBandText;
    private TextView wifiFrequencyBandValue;
    private ImageButton wifiPasswordButton;
    private EditText wifiPasswordText;
    private TextView wifiPasswordValue;
    private ImageButton wifiSSIDButton;
    private EditText wifiSSIDText;
    private TextView wifiSSIDValue;

    public DJISettingsScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TAG = DJISettingsScreen.class.getSimpleName();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SharedPreferences sharedPrefs = !isInEditMode() ? UASToolDropDownReceiver.getSharedPrefs() : null;
        if (sharedPrefs != null) {
            if (Integer.parseInt(sharedPrefs.getString(AtakPrefConstants.ALT_UNIT_PREF, String.valueOf(0))) != 1) {
                this.altUnits = Span.FOOT;
                this.maxAltLow = 66;
                this.maxAltHigh = 1640;
                this.homeAltLow = 66;
                this.homeAltHigh = 1640;
            } else {
                this.altUnits = Span.METER;
                this.maxAltLow = 20;
                this.maxAltHigh = 500;
                this.homeAltLow = 20;
                this.homeAltHigh = 500;
            }
            int parseInt = Integer.parseInt(sharedPrefs.getString(AtakPrefConstants.RAB_UNIT_PREF, String.valueOf(1)));
            if (parseInt == 1) {
                this.rangeUnits = Span.METER;
                this.maxDistLow = 15.0d;
                this.maxDistHigh = 8000.0d;
            } else if (parseInt != 2) {
                this.rangeUnits = Span.FOOT;
                this.maxDistLow = 50.0d;
                this.maxDistHigh = 26246.0d;
            } else {
                this.rangeUnits = Span.NAUTICALMILE;
                this.maxDistLow = 0.0081d;
                this.maxDistHigh = 4.31d;
            }
            this.goHomePctLow = 5;
            this.goHomePctHigh = 50;
            this.goHomeAltLow = 20;
            this.goHomeAltHigh = 500;
            this.landNowPctLow = 10;
            this.landNowPctHigh = 45;
            this.loadingLayout = (RelativeLayout) findViewById(C1877R.C1878id.djisettings_wait_layout);
            ImageButton imageButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_refresh_button);
            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.getPlatformSettings();
                }
            });
            imageButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Refresh All", "Retrieves all current settings stored on the UAS.");
                    return true;
                }
            });
            TextView textView = (TextView) findViewById(C1877R.C1878id.djisettings_msg_text);
            this.msgsText = textView;
            textView.setText("");
            ((TextView) findViewById(C1877R.C1878id.djisettings_buttons_value)).setText("");
            ImageButton imageButton2 = (ImageButton) findViewById(C1877R.C1878id.djisettings_buttons_button);
            imageButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.showCustomButtons();
                }
            });
            imageButton2.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Customize Buttons", "Allows the user to customize buttons on the UAS remote controller.");
                    return true;
                }
            });
            this.accelStateValue = (TextView) findViewById(C1877R.C1878id.djisettings_calibaccel_value);
            ImageButton imageButton3 = (ImageButton) findViewById(C1877R.C1878id.djisettings_calibaccel_button);
            this.accelStateButton = imageButton3;
            imageButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.showAccelCalib();
                }
            });
            this.accelStateButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Calibrate Accelerometer", "Allows the user to calibrate the accelerometer on the UAS.");
                    return true;
                }
            });
            this.gyroStateValue = (TextView) findViewById(C1877R.C1878id.djisettings_calibgyro_value);
            ImageButton imageButton4 = (ImageButton) findViewById(C1877R.C1878id.djisettings_calibgyro_button);
            this.gyroStateButton = imageButton4;
            imageButton4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.showGyroCalib();
                }
            });
            this.gyroStateButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Calibrate Gyroscope", "Allows the user to calibrate the gyroscope on the UAS.");
                    return true;
                }
            });
            this.compassStateValue = (TextView) findViewById(C1877R.C1878id.djisettings_calibcompass_value);
            ImageButton imageButton5 = (ImageButton) findViewById(C1877R.C1878id.djisettings_calibcompass_button);
            this.compassStateButton = imageButton5;
            imageButton5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.showCompassCalib();
                }
            });
            this.compassStateButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Calibrate Compass", "Allows the user to calibrate the compass on the UAS.");
                    return true;
                }
            });
            this.gimbalStateValue = (TextView) findViewById(C1877R.C1878id.djisettings_calibgimbal_value);
            ImageButton imageButton6 = (ImageButton) findViewById(C1877R.C1878id.djisettings_calibgimbal_button);
            this.gimbalStateButton = imageButton6;
            imageButton6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.showGimbalCalib();
                }
            });
            this.gimbalStateButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Calibrate Gimbal", "Allows the user to calibrate the gimbal on the UAS.");
                    return true;
                }
            });
            this.landingGearValue = (TextView) findViewById(C1877R.C1878id.djisettings_landinggear_value);
            this.landingGearCheck = (CheckBox) findViewById(C1877R.C1878id.djisettings_landinggear_check);
            ImageButton imageButton7 = (ImageButton) findViewById(C1877R.C1878id.djisettings_landinggear_button);
            this.landingGearButton = imageButton7;
            imageButton7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setRestrictLandingGear();
                }
            });
            this.landingGearButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Restrict Landing Gear", "Restricts the landing gear of the aircraft from retracting on takeoff and extending during landing.");
                    return true;
                }
            });
            ((TextView) findViewById(C1877R.C1878id.djisettings_maxalt_text)).setText("Max Altitude (" + this.altUnits.getAbbrev() + "AGL)");
            this.maxAltValue = (TextView) findViewById(C1877R.C1878id.djisettings_maxalt_value);
            this.maxAltButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_maxalt_button);
            EditText editText = (EditText) findViewById(C1877R.C1878id.djisettings_maxalt_edit);
            this.maxAltText = editText;
            editText.setSelectAllOnFocus(true);
            this.maxAltButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setMaxAltitude();
                }
            });
            this.maxAltButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen dJISettingsScreen = DJISettingsScreen.this;
                    dJISettingsScreen.showHelp("Maximum Altitude", "Set the maximum altitude of the aircraft. Altitude value must be between " + DJISettingsScreen.this.maxAltLow + " to " + DJISettingsScreen.this.maxAltHigh + " " + DJISettingsScreen.this.altUnits.getAbbrev() + "AGL.");
                    return true;
                }
            });
            ((TextView) findViewById(C1877R.C1878id.djisettings_maxdist_text)).setText("Max Dist Restrict (" + this.rangeUnits.getAbbrev() + ")");
            this.maxDistValue = (TextView) findViewById(C1877R.C1878id.djisettings_maxdist_value);
            this.maxDistButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_maxdist_button);
            EditText editText2 = (EditText) findViewById(C1877R.C1878id.djisettings_maxdist_edit);
            this.maxDistText = editText2;
            editText2.setSelectAllOnFocus(true);
            this.maxDistButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setMaxDistance();
                }
            });
            this.maxDistButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen dJISettingsScreen = DJISettingsScreen.this;
                    dJISettingsScreen.showHelp("Maximum Distance", "Set the maximum distance of the aircraft. Distance value must be between " + DJISettingsScreen.this.maxDistLow + " to " + DJISettingsScreen.this.maxDistHigh + " " + DJISettingsScreen.this.rangeUnits.getAbbrev() + ".");
                    return true;
                }
            });
            this.goHomePctValue = (TextView) findViewById(C1877R.C1878id.djisettings_gohomebatt_value);
            this.goHomePctButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_gohomebatt_button);
            EditText editText3 = (EditText) findViewById(C1877R.C1878id.djisettings_gohomebatt_edit);
            this.goHomePctText = editText3;
            editText3.setSelectAllOnFocus(true);
            this.goHomePctButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setGoHomeBatteryPct();
                }
            });
            this.goHomePctButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Go Home Battery Percentage", "Set the Go Home Battery Percentage of the aircraft. Battery percentage value must be between 15 to 50. The Go Home Battery Percentage must always be at least 5 greater than the Land Now Battery Percentage.");
                    return true;
                }
            });
            ((TextView) findViewById(C1877R.C1878id.djisettings_gohomealt_text)).setText("Go Home Altitude (" + this.altUnits.getAbbrev() + "AGL)");
            this.goHomeAltValue = (TextView) findViewById(C1877R.C1878id.djisettings_gohomealt_value);
            this.goHomeAltButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_gohomealt_button);
            EditText editText4 = (EditText) findViewById(C1877R.C1878id.djisettings_gohomealt_edit);
            this.goHomeAltText = editText4;
            editText4.setSelectAllOnFocus(true);
            this.goHomeAltButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setGoHomeAltitude();
                }
            });
            this.goHomeAltButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen dJISettingsScreen = DJISettingsScreen.this;
                    dJISettingsScreen.showHelp("Go Home Altitude", "Set the go home altitude of the aircraft. Altitude value must be between " + DJISettingsScreen.this.homeAltLow + " to " + DJISettingsScreen.this.homeAltHigh + " " + DJISettingsScreen.this.altUnits.getAbbrev() + "AGL.");
                    return true;
                }
            });
            this.landNowPctValue = (TextView) findViewById(C1877R.C1878id.djisettings_landbatt_value);
            this.landNowPctButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_landbatt_button);
            EditText editText5 = (EditText) findViewById(C1877R.C1878id.djisettings_landbatt_edit);
            this.landNowPctText = editText5;
            editText5.setSelectAllOnFocus(true);
            this.landNowPctButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setLandNowBatteryPct();
                }
            });
            this.landNowPctButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Land Now Battery Percentage", "Set the Land Now Battery Percentage of the aircraft. Battery percentage value must be between 10 to 45. The Land Now Battery Percentage must always be at least 5 less than the Go Home Battery Percentage.");
                    return true;
                }
            });
            this.connLossArray = getResources().getStringArray(C1877R.array.djisettings_connloss_behavior);
            AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder.setTitle("Connection Loss Behavior");
            builder.setItems(this.connLossArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.connLossText.setText(DJISettingsScreen.this.connLossArray[i]);
                }
            });
            this.connLossDialog = builder.create();
            this.connLossValue = (TextView) findViewById(C1877R.C1878id.djisettings_connloss_value);
            this.connLossButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_connloss_button);
            TextView textView2 = (TextView) findViewById(C1877R.C1878id.djisettings_connloss_current);
            this.connLossText = textView2;
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.connLossDialog.show();
                }
            });
            this.connLossButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setConnLossBehav();
                }
            });
            this.connLossButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Connection Loss Behavior", "Set the behavior of the aircraft when its radio connection goes out.");
                    return true;
                }
            });
            this.collAvoidValue = (TextView) findViewById(C1877R.C1878id.djisettings_collision_value);
            this.collAvoidButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_collision_button);
            this.collAvoidCheck = (CheckBox) findViewById(C1877R.C1878id.djisettings_collision_check);
            this.collAvoidButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setCollAvoid();
                }
            });
            this.collAvoidButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Collision Avoidance", "Turn aircraft collision avoidance of stationary objects On/Off.");
                    return true;
                }
            });
            this.activeAvoidValue = (TextView) findViewById(C1877R.C1878id.djisettings_active_value);
            this.activeAvoidButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_active_button);
            this.activeAvoidCheck = (CheckBox) findViewById(C1877R.C1878id.djisettings_active_check);
            this.activeAvoidButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setActiveAvoid();
                }
            });
            this.activeAvoidButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Active Avoidance", "Turn aircraft active avoidance of moving objects On/Off. UAS needs to be flying when turning on Active Avoidance. Collision Avoidance also needs to be on for Active Avoidance to work.");
                    return true;
                }
            });
            this.visionPosValue = (TextView) findViewById(C1877R.C1878id.djisettings_vision_value);
            this.visionPosButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_vision_button);
            this.visionPosCheck = (CheckBox) findViewById(C1877R.C1878id.djisettings_vision_check);
            this.visionPosButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setVisionPos();
                }
            });
            this.visionPosButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Vision Positioning", "Turn aircraft vision positioning On/Off.");
                    return true;
                }
            });
            this.precisionLandValue = (TextView) findViewById(C1877R.C1878id.djisettings_precision_value);
            this.precisionLandButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_precision_button);
            this.precisionLandCheck = (CheckBox) findViewById(C1877R.C1878id.djisettings_precision_check);
            this.precisionLandButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setPrecLand();
                }
            });
            this.precisionLandButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Precision Landing", "Turn aircraft precision landing On/Off.");
                    return true;
                }
            });
            this.landProtectValue = (TextView) findViewById(C1877R.C1878id.djisettings_landing_value);
            this.landProtectButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_landing_button);
            this.landProtectCheck = (CheckBox) findViewById(C1877R.C1878id.djisettings_landing_check);
            this.landProtectButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setLandProt();
                }
            });
            this.landProtectButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Landing Protection", "Turn aircraft landing protection On/Off.");
                    return true;
                }
            });
            this.wifiSSIDValue = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_ssid_value);
            this.wifiSSIDButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_wifi_ssid_button);
            EditText editText6 = (EditText) findViewById(C1877R.C1878id.djisettings_wifi_ssid_edit);
            this.wifiSSIDText = editText6;
            editText6.setSelectAllOnFocus(true);
            this.wifiSSIDButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setWiFiSSID();
                }
            });
            this.wifiSSIDButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("WiFi SSID", "Sets the WiFi SSID. The setting will take effect only after the product reboots.");
                    return true;
                }
            });
            this.wifiPasswordValue = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_pwd_value);
            this.wifiPasswordButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_wifi_pwd_button);
            EditText editText7 = (EditText) findViewById(C1877R.C1878id.djisettings_wifi_pwd_edit);
            this.wifiPasswordText = editText7;
            editText7.setSelectAllOnFocus(true);
            this.wifiPasswordButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setWiFiPassword();
                }
            });
            this.wifiPasswordButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("WiFi Password", "Sets the WiFi password. It must be at least 8 characters and can only includes alphabetic characters and numbers.");
                    return true;
                }
            });
            this.wifiFrequencyBandArray = new String[]{"2.4 GHz", WIFI_FREQUENCYBAND_5, "Dual"};
            AlertDialog.Builder builder2 = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder2.setTitle("WiFi Frequency Band");
            builder2.setItems(this.wifiFrequencyBandArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.wifiFrequencyBandText.setText(DJISettingsScreen.this.wifiFrequencyBandArray[i]);
                }
            });
            this.wifiFrequencyBandDialog = builder2.create();
            this.wifiFrequencyBandValue = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_frequencyband_value);
            this.wifiFrequencyBandButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_wifi_frequencyband_button);
            TextView textView3 = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_frequencyband_edit);
            this.wifiFrequencyBandText = textView3;
            textView3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.wifiFrequencyBandDialog.show();
                }
            });
            this.wifiFrequencyBandButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setWiFiFrequencyBand();
                }
            });
            this.wifiFrequencyBandButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("WiFi Frequency Band", "Sets the WiFi frequency band.");
                    return true;
                }
            });
            this.wifiChannelModeArray = new String[]{"Auto", WIFI_CHANNELMODE_CUSTOM};
            AlertDialog.Builder builder3 = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder3.setTitle("WiFi Channel Mode");
            builder3.setItems(this.wifiChannelModeArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.wifiChannelModeText.setText(DJISettingsScreen.this.wifiChannelModeArray[i]);
                }
            });
            this.wifiChannelModeDialog = builder3.create();
            this.wifiChannelModeValue = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_channelmode_value);
            this.wifiChannelModeButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_wifi_channelmode_button);
            TextView textView4 = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_channelmode_edit);
            this.wifiChannelModeText = textView4;
            textView4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.wifiChannelModeDialog.show();
                }
            });
            this.wifiChannelModeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setWiFiChannelMode();
                }
            });
            this.wifiChannelModeButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("WiFi Channel Mode", "Sets the WiFi channel selection mode.");
                    return true;
                }
            });
            this.wifiChannelNumberValue = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_channelnumber_value);
            this.wifiChannelNumberButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_wifi_channelnumber_button);
            TextView textView5 = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_channelnumber_edit);
            this.wifiChannelNumberText = textView5;
            textView5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.toast("Unable to set DJI WiFi channel number");
                }
            });
            this.wifiChannelNumberButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setWiFiChannelNumber();
                }
            });
            this.wifiChannelNumberButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("WiFi Channel Number", "Sets the WiFi channel. When a new channel is set, the WiFi on the product will reboot. The channel can only be changed when the product is not flying.");
                    return true;
                }
            });
            this.wifiDataRateArray = new String[]{WIFI_DATARATE_1, WIFI_DATARATE_2, "4 Mbps"};
            AlertDialog.Builder builder4 = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder4.setTitle("WiFi Data Rate");
            builder4.setItems(this.wifiDataRateArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.wifiDataRateText.setText(DJISettingsScreen.this.wifiDataRateArray[i]);
                }
            });
            this.wifiDataRateDialog = builder4.create();
            this.wifiDataRateValue = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_datarate_value);
            this.wifiDataRateButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_wifi_datarate_button);
            TextView textView6 = (TextView) findViewById(C1877R.C1878id.djisettings_wifi_datarate_edit);
            this.wifiDataRateText = textView6;
            textView6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.wifiDataRateDialog.show();
                }
            });
            this.wifiDataRateButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setWiFiDataRate();
                }
            });
            this.wifiDataRateButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("WiFi Data Rate", "WiFi data rate. Lower rates are used for longer ranges, but will have lower video quality.");
                    return true;
                }
            });
            this.ocuSyncChannelModeArray = new String[]{"Auto", "Manual"};
            AlertDialog.Builder builder5 = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder5.setTitle("OcuSync Channel Mode");
            builder5.setItems(this.ocuSyncChannelModeArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.ocuSyncChannelModeText.setText(DJISettingsScreen.this.ocuSyncChannelModeArray[i]);
                }
            });
            this.ocuSyncChannelModeDialog = builder5.create();
            this.ocuSyncChannelModeValue = (TextView) findViewById(C1877R.C1878id.djisettings_ocusync_channelmode_value);
            this.ocuSyncChannelModeButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_ocusync_channelmode_button);
            TextView textView7 = (TextView) findViewById(C1877R.C1878id.djisettings_ocusync_channelmode_edit);
            this.ocuSyncChannelModeText = textView7;
            textView7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.ocuSyncChannelModeDialog.show();
                }
            });
            this.ocuSyncChannelModeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setOcuSyncChannelMode();
                }
            });
            this.ocuSyncChannelModeButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("OcuSync Channel Mode", "Sets the OcuSync channel selection mode. Setting channel bandwidth and number only available in Manual mode.");
                    return true;
                }
            });
            this.ocuSyncChannelBandwidthArray = getOcuSyncChannelBandwidths();
            AlertDialog.Builder builder6 = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder6.setTitle("OcuSync Channel Bandwidth");
            builder6.setItems(this.ocuSyncChannelBandwidthArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.ocuSyncChannelBandwidthText.setText(DJISettingsScreen.this.ocuSyncChannelBandwidthArray[i]);
                }
            });
            this.ocuSyncChannelBandwidthDialog = builder6.create();
            this.ocuSyncChannelBandwidthValue = (TextView) findViewById(C1877R.C1878id.djisettings_ocusync_channelbandwidth_value);
            this.ocuSyncChannelBandwidthButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_ocusync_channelbandwidth_button);
            TextView textView8 = (TextView) findViewById(C1877R.C1878id.djisettings_ocusync_channelbandwidth_edit);
            this.ocuSyncChannelBandwidthText = textView8;
            textView8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.ocuSyncChannelBandwidthDialog.show();
                }
            });
            this.ocuSyncChannelBandwidthButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setOcuSyncChannelBandwidth();
                }
            });
            this.ocuSyncChannelBandwidthButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("OcuSync Channel Bandwidth", "Sets the OcuSync channel bandwidth. Only available when channel mode is MANUAL.");
                    return true;
                }
            });
            this.ocuSyncChannelNumberValue = (TextView) findViewById(C1877R.C1878id.djisettings_ocusync_channelnumber_value);
            this.ocuSyncChannelNumberButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_ocusync_channelnumber_button);
            TextView textView9 = (TextView) findViewById(C1877R.C1878id.djisettings_ocusync_channelnumber_edit);
            this.ocuSyncChannelNumberText = textView9;
            textView9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.toast("Unable to set DJI OcuSync channel number");
                }
            });
            this.ocuSyncChannelNumberButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setOcuSyncChannelNumber();
                }
            });
            this.ocuSyncChannelNumberButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen dJISettingsScreen = DJISettingsScreen.this;
                    dJISettingsScreen.showHelp("OcuSync Channel Number", "Sets the OcuSync channel number. Available range is " + DJISettingsScreen.this.ocuSyncChannelNumLow + "-" + DJISettingsScreen.this.ocuSyncChannelNumHi + ". Only available when channel mode is MANUAL.");
                    return true;
                }
            });
            this.ocuSyncFrequencyBandArray = getOcuSyncFrequencyBands();
            this.ocuSyncFrequencyBandValue = (TextView) findViewById(C1877R.C1878id.djisettings_ocusync_frequencyband_value);
            this.ocuSyncFrequencyBandButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_ocusync_frequencyband_button);
            TextView textView10 = (TextView) findViewById(C1877R.C1878id.djisettings_ocusync_frequencyband_edit);
            this.ocuSyncFrequencyBandText = textView10;
            textView10.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.chooseOcuSyncFrequencyBand();
                }
            });
            this.ocuSyncFrequencyBandButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setOcuSyncFrequencyBand();
                }
            });
            this.ocuSyncFrequencyBandButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("OcuSync Frequency Band", "Sets the OcuSync frequency band. Dual band only available in Auto mode (for some models).");
                    return true;
                }
            });
            this.lightBridgeChannelModeArray = new String[]{"Auto", "Manual"};
            AlertDialog.Builder builder7 = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder7.setTitle("LightBridge Channel Mode");
            builder7.setItems(this.lightBridgeChannelModeArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.lightBridgeChannelModeText.setText(DJISettingsScreen.this.lightBridgeChannelModeArray[i]);
                }
            });
            this.lightBridgeChannelModeDialog = builder7.create();
            this.lightBridgeChannelModeValue = (TextView) findViewById(C1877R.C1878id.djisettings_lb_channelmode_value);
            this.lightBridgeChannelModeButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_lb_channelmode_button);
            TextView textView11 = (TextView) findViewById(C1877R.C1878id.djisettings_lb_channelmode_edit);
            this.lightBridgeChannelModeText = textView11;
            textView11.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.lightBridgeChannelModeDialog.show();
                }
            });
            this.lightBridgeChannelModeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setLightBridgeChannelMode();
                }
            });
            this.lightBridgeChannelModeButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("LightBridge Channel Mode", "Sets the LightBridge downlink channel selection mode.");
                    return true;
                }
            });
            this.lightBridgeChannelNumberValue = (TextView) findViewById(C1877R.C1878id.djisettings_lb_channelnumber_value);
            this.lightBridgeChannelNumberButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_lb_channelnumber_button);
            TextView textView12 = (TextView) findViewById(C1877R.C1878id.djisettings_lb_channelnumber_edit);
            this.lightBridgeChannelNumberText = textView12;
            textView12.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.toast("Unable to set DJI LightBridge channel number");
                }
            });
            this.lightBridgeChannelNumberButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setLightBridgeChannelNumber();
                }
            });
            this.lightBridgeChannelNumberButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen dJISettingsScreen = DJISettingsScreen.this;
                    dJISettingsScreen.showHelp("LightBridge Channel Number", "Sets the LightBridge fixed downlink channel number. Available range is " + DJISettingsScreen.this.lightBridgeChannelNumLow + "-" + DJISettingsScreen.this.lightBridgeChannelNumHi + ". Only available when channel mode is MANUAL.");
                    return true;
                }
            });
            this.lightBridgeDataRateArray = new String[]{"4 Mbps", LIGHTBRIDGE_DATARATE_6, LIGHTBRIDGE_DATARATE_8, LIGHTBRIDGE_DATARATE_10};
            AlertDialog.Builder builder8 = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder8.setTitle("LightBridge Data Rate");
            builder8.setItems(this.lightBridgeDataRateArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.lightBridgeDataRateText.setText(DJISettingsScreen.this.lightBridgeDataRateArray[i]);
                }
            });
            this.lightBridgeDataRateDialog = builder8.create();
            this.lightBridgeDataRateValue = (TextView) findViewById(C1877R.C1878id.djisettings_lb_datarate_value);
            this.lightBridgeDataRateButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_lb_datarate_button);
            TextView textView13 = (TextView) findViewById(C1877R.C1878id.djisettings_lb_datarate_edit);
            this.lightBridgeDataRateText = textView13;
            textView13.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.lightBridgeDataRateDialog.show();
                }
            });
            this.lightBridgeDataRateButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setLightBridgeDataRate();
                }
            });
            this.lightBridgeDataRateButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("LightBridge Data Rate", "Sets the LightBridge downlink data rate (throughput). Higher data rates increase the quality of video transmission, but can only be used at shorter ranges.");
                    return true;
                }
            });
            this.lightBridgeTransmissionModeArray = new String[]{LIGHTBRIDGE_TRANSMISSIONMODE_HI, LIGHTBRIDGE_TRANSMISSIONMODE_LO};
            AlertDialog.Builder builder9 = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder9.setTitle("LightBridge Transmission Mode");
            builder9.setItems(this.lightBridgeTransmissionModeArray, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DJISettingsScreen.this.lightBridgeTransmissionModeText.setText(DJISettingsScreen.this.lightBridgeTransmissionModeArray[i]);
                }
            });
            this.lightBridgeTransmissionModeDialog = builder9.create();
            this.lightBridgeTransmissionModeValue = (TextView) findViewById(C1877R.C1878id.djisettings_lb_transmissionmode_value);
            this.lightBridgeTransmissionModeButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_lb_transmissionmode_button);
            TextView textView14 = (TextView) findViewById(C1877R.C1878id.djisettings_lb_transmissionmode_edit);
            this.lightBridgeTransmissionModeText = textView14;
            textView14.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.lightBridgeTransmissionModeDialog.show();
                }
            });
            this.lightBridgeTransmissionModeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setLightBridgeTransmissionMode();
                }
            });
            this.lightBridgeTransmissionModeButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("LightBridge Transmission Mode", "Sets LightBridge FPV video quality vs latency preference. This mode only affects the FPV camera and not the camera on the HD Gimbal.");
                    return true;
                }
            });
            this.lightBridgeFrequencyBandArray = getLightBridgeFrequencyBands();
            this.lightBridgeFrequencyBandValue = (TextView) findViewById(C1877R.C1878id.djisettings_lb_frequencyband_value);
            this.lightBridgeFrequencyBandButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_lb_frequencyband_button);
            TextView textView15 = (TextView) findViewById(C1877R.C1878id.djisettings_lb_frequencyband_edit);
            this.lightBridgeFrequencyBandText = textView15;
            textView15.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.chooseLightBridgeFrequencyBand();
                }
            });
            this.lightBridgeFrequencyBandButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setLightBridgeFrequencyBand();
                }
            });
            this.lightBridgeFrequencyBandButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("LightBridge Frequency Band", "Sets the LightBridge frequency band.");
                    return true;
                }
            });
            this.rezFPSValue = (TextView) findViewById(C1877R.C1878id.djisettings_rez_value);
            this.rezFPSButton = (ImageButton) findViewById(C1877R.C1878id.djisettings_rez_button);
            TextView textView16 = (TextView) findViewById(C1877R.C1878id.djisettings_rez_current);
            this.rezFPSText = textView16;
            textView16.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.showRezFPSDialog();
                }
            });
            this.rezFPSButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.setResFPS();
                }
            });
            this.rezFPSButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Resolution - Frame Rate", "Set the resolution and frame rate of the camera output.");
                    return true;
                }
            });
            TextView textView17 = (TextView) findViewById(C1877R.C1878id.djisettings_sdcard_value);
            this.formatSDValue = textView17;
            textView17.setText("");
            ImageButton imageButton8 = (ImageButton) findViewById(C1877R.C1878id.djisettings_sdcard_button);
            this.formatSDButton = imageButton8;
            imageButton8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.askSDCardFormat();
                }
            });
            this.formatSDButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Format SD Card", "Formats the SD card on the UAS.");
                    return true;
                }
            });
            TextView textView18 = (TextView) findViewById(C1877R.C1878id.djisettings_storage_value);
            this.formatStorageValue = textView18;
            textView18.setText("");
            ImageButton imageButton9 = (ImageButton) findViewById(C1877R.C1878id.djisettings_storage_button);
            this.formatStorageButton = imageButton9;
            imageButton9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    DJISettingsScreen.this.setMessage("", 0);
                    DJISettingsScreen.this.askInternalFormat();
                }
            });
            this.formatStorageButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Format Internal Storage", "Formats the internal storage on the UAS.");
                    return true;
                }
            });
            TextView textView19 = (TextView) findViewById(C1877R.C1878id.djisettings_activate_value);
            this.activateValue = textView19;
            textView19.setText("");
            ImageButton imageButton10 = (ImageButton) findViewById(C1877R.C1878id.djisettings_activate_button);
            this.activateButton = imageButton10;
            imageButton10.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    IDjiAtakInterface service;
                    DJISettingsScreen.this.setMessage("", 0);
                    AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                    if (serviceConnection != null && (service = serviceConnection.getService()) != null) {
                        try {
                            service.setPlatformActivated(true);
                            UASToolDropDownReceiver.toast("Activating UAS...", 0);
                        } catch (RemoteException unused) {
                            UASToolDropDownReceiver.toast("Activate UAS Failed.", 0);
                        }
                    }
                }
            });
            this.activateButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Activate UAS", "Attempts to activate the connected DJI UAS platform.");
                    return true;
                }
            });
            TextView textView20 = (TextView) findViewById(C1877R.C1878id.djisettings_unlock_value);
            this.unlockValue = textView20;
            textView20.setText("");
            ImageButton imageButton11 = (ImageButton) findViewById(C1877R.C1878id.djisettings_unlock_button);
            this.unlockButton = imageButton11;
            imageButton11.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    IDjiAtakInterface service;
                    DJISettingsScreen.this.setMessage("", 0);
                    AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                    if (serviceConnection != null && (service = serviceConnection.getService()) != null) {
                        try {
                            service.unlockPlatform();
                            UASToolDropDownReceiver.toast("Unlocking UAS...", 0);
                        } catch (RemoteException unused) {
                            UASToolDropDownReceiver.toast("Unlock UAS Failed.", 0);
                        }
                    }
                }
            });
            this.unlockButton.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    DJISettingsScreen.this.showHelp("Unlock UAS", "Attempts to unlock the connected DJI UAS platform.");
                    return true;
                }
            });
            LinearLayout linearLayout = (LinearLayout) findViewById(C1877R.C1878id.djisettings_activate_layout);
            LinearLayout linearLayout2 = (LinearLayout) findViewById(C1877R.C1878id.djisettings_unlock_layout);
            String j = a.j();
            if (j == null || j.equalsIgnoreCase(BuildConfig.FLAVOR)) {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(8);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    DJISettingsScreen.this.getPlatformSettings();
                }
            }, 500);
        }
    }

    /* access modifiers changed from: private */
    public void toast(String str) {
        UASToolDropDownReceiver.toast(str);
    }

    /* access modifiers changed from: private */
    public void getPlatformSettings() {
        setMessage("", 0);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                DJISettingsScreen.this.loadingLayout.setVisibility(0);
                String unused = DJISettingsScreen.this.getAccelState();
                String unused2 = DJISettingsScreen.this.getGyroState();
                String unused3 = DJISettingsScreen.this.getCompassState();
                String unused4 = DJISettingsScreen.this.getGimbalMode();
                boolean unused5 = DJISettingsScreen.this.getRestrictLandingGear();
                int unused6 = DJISettingsScreen.this.getMaxAltitude();
                int unused7 = DJISettingsScreen.this.getMaxDistance();
                int unused8 = DJISettingsScreen.this.getGoHomeBatteryPct();
                int unused9 = DJISettingsScreen.this.getGoHomeAltitude();
                int unused10 = DJISettingsScreen.this.getLandNowBatteryPct();
                String unused11 = DJISettingsScreen.this.getConnLossBehav();
                boolean unused12 = DJISettingsScreen.this.getCollAvoid();
                boolean unused13 = DJISettingsScreen.this.getActiveAvoid();
                boolean unused14 = DJISettingsScreen.this.getVisionPos();
                boolean unused15 = DJISettingsScreen.this.getPrecLand();
                boolean unused16 = DJISettingsScreen.this.getLandProt();
                DJISettingsScreen.this.getWiFi();
                DJISettingsScreen.this.getOcuSync();
                DJISettingsScreen.this.getLightBridge();
                DJISettingsScreen.this.getResFPSList();
                String unused17 = DJISettingsScreen.this.getResFPS();
                DJISettingsScreen.this.formatSDValue.setText("");
                DJISettingsScreen.this.formatStorageValue.setText("");
                DJISettingsScreen.this.activateValue.setText("");
                DJISettingsScreen.this.unlockValue.setText("");
                DJISettingsScreen.this.loadingLayout.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    public String getAccelState() {
        String str;
        this.accelStateValue.setTextColor(-256);
        this.accelStateValue.setText(C1877R.string.dashdashdash);
        this.accelStateButton.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            str = serviceConnection.getAccelState();
            this.accelStateValue.setText(str);
            if (str.equals("NORMAL_BIAS") || str.equals("MEDIUM_BIAS")) {
                this.accelStateValue.setTextColor(TaskEdit.viewColor);
            } else if (str.equals("IN_MOTION")) {
                this.accelStateValue.setTextColor(-256);
            } else {
                this.accelStateValue.setTextColor(-65536);
            }
        } else {
            this.accelStateValue.setTextColor(-65536);
            this.accelStateValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Accel State failed", 2);
            str = "";
        }
        this.accelStateButton.setEnabled(true);
        return str;
    }

    /* access modifiers changed from: private */
    public String getGyroState() {
        String str;
        this.gyroStateValue.setTextColor(-256);
        this.gyroStateValue.setText(C1877R.string.dashdashdash);
        this.gyroStateButton.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            str = serviceConnection.getGyroState();
            this.gyroStateValue.setText(str);
            if (str.equals("NORMAL_BIAS") || str.equals("MEDIUM_BIAS")) {
                this.gyroStateValue.setTextColor(TaskEdit.viewColor);
            } else if (str.equals("IN_MOTION")) {
                this.gyroStateValue.setTextColor(-256);
            } else {
                this.gyroStateValue.setTextColor(-65536);
            }
        } else {
            this.gyroStateValue.setTextColor(-65536);
            this.gyroStateValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Gyro State failed", 2);
            str = "";
        }
        this.gyroStateButton.setEnabled(true);
        return str;
    }

    /* access modifiers changed from: private */
    public String getCompassState() {
        String str;
        this.compassStateValue.setTextColor(-256);
        this.compassStateValue.setText(C1877R.string.dashdashdash);
        this.compassStateButton.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            str = serviceConnection.getCompassState();
            if (str.equals("Needs calibration")) {
                this.compassStateValue.setTextColor(TaskEdit.viewColor);
                this.compassStateValue.setText("Calibrated");
            } else if (str.equals("Calibrated")) {
                this.compassStateValue.setTextColor(-256);
                this.compassStateValue.setText("Needs calibration");
            } else {
                this.compassStateValue.setTextColor(-65536);
                this.compassStateValue.setText(str);
            }
        } else {
            this.compassStateValue.setTextColor(-65536);
            this.compassStateValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Compass State failed", 2);
            str = "";
        }
        this.compassStateButton.setEnabled(true);
        return str;
    }

    /* access modifiers changed from: private */
    public String getGimbalMode() {
        String str;
        this.gimbalStateValue.setTextColor(-256);
        this.gimbalStateValue.setText(C1877R.string.dashdashdash);
        this.gimbalStateButton.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            str = serviceConnection.getGimbalMode();
            this.gimbalStateValue.setText(str);
            if (str.equals("FPV") || str.equals("FREE") || str.equals("YAW_FOLLOW")) {
                this.gimbalStateValue.setTextColor(TaskEdit.viewColor);
            } else if (str.equals("UNKNOWN")) {
                this.gimbalStateValue.setTextColor(-256);
            } else {
                this.gimbalStateValue.setTextColor(-65536);
            }
        } else {
            this.gimbalStateValue.setTextColor(-65536);
            this.gimbalStateValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Gimbal State failed", 2);
            str = "";
        }
        this.gimbalStateButton.setEnabled(true);
        return str;
    }

    /* access modifiers changed from: private */
    public boolean getRestrictLandingGear() {
        int i = -256;
        this.landingGearValue.setTextColor(-256);
        this.landingGearValue.setText(C1877R.string.dashdashdash);
        this.landingGearCheck.setEnabled(false);
        this.landingGearButton.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            this.landingGearValue.setTextColor(-65536);
            this.landingGearValue.setText(shortenErrorMsg("No UAS connected"));
            this.landingGearCheck.setChecked(false);
            setMessage("Get Restrict Landing Gear failed", 2);
        } else if (serviceConnection.hasLandingGear()) {
            boolean restrictLandingGear = serviceConnection.getRestrictLandingGear();
            TextView textView = this.landingGearValue;
            if (restrictLandingGear) {
                i = TaskEdit.viewColor;
            }
            textView.setTextColor(i);
            this.landingGearValue.setText(restrictLandingGear ? "on" : "off");
            this.landingGearCheck.setChecked(restrictLandingGear);
            this.landingGearCheck.setEnabled(true);
            this.landingGearButton.setEnabled(true);
        } else {
            this.landingGearValue.setTextColor(-256);
            this.landingGearValue.setText("not available");
            this.landingGearCheck.setChecked(false);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void setRestrictLandingGear() {
        int i = -256;
        this.landingGearValue.setTextColor(-256);
        this.landingGearValue.setText(C1877R.string.dashdashdash);
        this.landingGearCheck.setEnabled(false);
        this.landingGearButton.setEnabled(false);
        boolean isChecked = this.landingGearCheck.isChecked();
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            this.landingGearValue.setTextColor(-65536);
            this.landingGearValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Set Restrict Landing Gear failed", 2);
        } else if (!serviceConnection.hasLandingGear()) {
            this.landingGearValue.setTextColor(-256);
            this.landingGearValue.setText("not available");
            this.landingGearCheck.setChecked(false);
        } else if (!serviceConnection.setRestrictLandingGear(isChecked)) {
            this.landingGearValue.setTextColor(-65536);
            this.landingGearValue.setText(shortenErrorMsg("Error"));
            this.landingGearCheck.setEnabled(true);
            this.landingGearButton.setEnabled(true);
            setMessage("Set Restrict Landing Gear failed", 2);
        } else {
            TextView textView = this.landingGearValue;
            if (isChecked) {
                i = TaskEdit.viewColor;
            }
            textView.setTextColor(i);
            this.landingGearValue.setText(isChecked ? "restricted" : "not restricted");
            this.landingGearCheck.setEnabled(true);
            this.landingGearButton.setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public int getMaxAltitude() {
        this.maxAltValue.setTextColor(-256);
        this.maxAltValue.setText(C1877R.string.dashdashdash);
        int i = 0;
        this.maxAltButton.setEnabled(false);
        this.maxAltText.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            int maxAltitude = serviceConnection.getMaxAltitude();
            this.uasItem.setPlatformValue(UASItemCapabilities.VALUE_ROUTE_AGL_MAX, String.valueOf(maxAltitude));
            i = this.altUnits == Span.FOOT ? (int) Math.round(oe.d.a((double) maxAltitude)) : maxAltitude;
            String valueOf = String.valueOf(i);
            this.maxAltText.setText(valueOf);
            this.maxAltValue.setTextColor(TaskEdit.viewColor);
            this.maxAltValue.setText(valueOf);
        } else {
            this.maxAltText.setText("");
            this.maxAltValue.setTextColor(-65536);
            this.maxAltValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Max Altitude failed", 2);
        }
        this.maxAltButton.setEnabled(true);
        this.maxAltText.setEnabled(true);
        return i;
    }

    /* access modifiers changed from: private */
    public void setMaxAltitude() {
        this.maxAltValue.setTextColor(-256);
        this.maxAltValue.setText(C1877R.string.dashdashdash);
        this.maxAltButton.setEnabled(false);
        this.maxAltText.setEnabled(false);
        String obj = this.maxAltText.getText().toString();
        if (TextUtils.isEmpty(obj) || !TextUtils.isDigitsOnly(obj)) {
            toast("Please enter only integers");
            this.maxAltValue.setText("Enter only integers");
        } else {
            int parseInt = Integer.parseInt(obj);
            if (parseInt < this.maxAltLow || parseInt > this.maxAltHigh) {
                toast("Please enter an integer between " + this.maxAltLow + "-" + this.maxAltHigh + " : " + parseInt);
                TextView textView = this.maxAltValue;
                StringBuilder sb = new StringBuilder();
                sb.append("Enter an integer between ");
                sb.append(this.maxAltLow);
                sb.append("-");
                sb.append(this.maxAltHigh);
                textView.setText(sb.toString());
            } else {
                int round = this.altUnits == Span.FOOT ? (int) Math.round(oe.b.a((double) parseInt)) : parseInt;
                AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                if (serviceConnection != null) {
                    String maxAltitude = serviceConnection.setMaxAltitude(round);
                    if (TextUtils.isEmpty(maxAltitude)) {
                        this.maxAltValue.setTextColor(TaskEdit.viewColor);
                        if (this.altUnits == Span.FOOT) {
                            parseInt = (int) Math.round(oe.d.a((double) round));
                        }
                        this.maxAltValue.setText(String.valueOf(parseInt));
                    } else {
                        this.maxAltValue.setTextColor(-65536);
                        this.maxAltValue.setText(maxAltitude);
                        setMessage("Set Max Altitude returned ERROR", 2);
                    }
                } else {
                    this.maxAltValue.setTextColor(-65536);
                    this.maxAltValue.setText(shortenErrorMsg("No UAS connected"));
                    setMessage("Set Max Altitude failed", 2);
                }
            }
        }
        this.maxAltButton.setEnabled(true);
        this.maxAltText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public int getMaxDistance() {
        long round;
        this.maxDistValue.setTextColor(-256);
        this.maxDistValue.setText(C1877R.string.dashdashdash);
        int i = 0;
        this.maxDistButton.setEnabled(false);
        this.maxDistText.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            int maxDistance = serviceConnection.getMaxDistance();
            if (this.rangeUnits == Span.FOOT) {
                round = Math.round(oe.d.a((double) maxDistance));
            } else if (this.rangeUnits == Span.NAUTICALMILE) {
                round = Math.round(((double) maxDistance) / 1852.0d);
            } else {
                i = maxDistance;
                String valueOf = String.valueOf(i);
                this.maxDistText.setText(valueOf);
                this.maxDistValue.setTextColor(TaskEdit.viewColor);
                this.maxDistValue.setText(valueOf);
            }
            i = (int) round;
            String valueOf2 = String.valueOf(i);
            this.maxDistText.setText(valueOf2);
            this.maxDistValue.setTextColor(TaskEdit.viewColor);
            this.maxDistValue.setText(valueOf2);
        } else {
            this.maxDistText.setText("");
            this.maxDistValue.setTextColor(-65536);
            this.maxDistValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Max Distance failed", 2);
        }
        this.maxDistButton.setEnabled(true);
        this.maxDistText.setEnabled(true);
        return i;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMaxDistance() {
        /*
            r8 = this;
            android.widget.TextView r0 = r8.maxDistValue
            r1 = -256(0xffffffffffffff00, float:NaN)
            r0.setTextColor(r1)
            android.widget.TextView r0 = r8.maxDistValue
            r1 = 2131361827(0x7f0a0023, float:1.8343417E38)
            r0.setText(r1)
            android.widget.ImageButton r0 = r8.maxDistButton
            r1 = 0
            r0.setEnabled(r1)
            android.widget.EditText r0 = r8.maxDistText
            r0.setEnabled(r1)
            android.widget.EditText r0 = r8.maxDistText
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x011b
            boolean r1 = android.text.TextUtils.isDigitsOnly(r0)
            if (r1 != 0) goto L_0x0032
            goto L_0x011b
        L_0x0032:
            int r0 = java.lang.Integer.parseInt(r0)
            double r1 = (double) r0
            double r3 = r8.maxDistLow
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00d2
            double r3 = r8.maxDistHigh
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0045
            goto L_0x00d2
        L_0x0045:
            com.atakmap.coremap.conversions.Span r3 = r8.rangeUnits
            com.atakmap.coremap.conversions.Span r4 = com.atakmap.coremap.conversions.Span.FOOT
            r5 = 4655859997584916480(0x409cf00000000000, double:1852.0)
            if (r3 != r4) goto L_0x005a
            double r1 = atak.core.oe.b.a(r1)
            long r1 = java.lang.Math.round(r1)
        L_0x0058:
            int r2 = (int) r1
            goto L_0x0068
        L_0x005a:
            com.atakmap.coremap.conversions.Span r3 = r8.rangeUnits
            com.atakmap.coremap.conversions.Span r4 = com.atakmap.coremap.conversions.Span.NAUTICALMILE
            if (r3 != r4) goto L_0x0067
            double r1 = r1 * r5
            long r1 = java.lang.Math.round(r1)
            goto L_0x0058
        L_0x0067:
            r2 = r0
        L_0x0068:
            com.atakmap.android.uastool.dji.AtakGoServiceConnection r1 = com.atakmap.android.uastool.dji.DJIMonitor.getServiceConnection()
            r3 = 2
            r4 = -65536(0xffffffffffff0000, float:NaN)
            if (r1 == 0) goto L_0x00bc
            java.lang.String r1 = r1.setMaxDistance(r2)
            boolean r7 = android.text.TextUtils.isEmpty(r1)
            if (r7 == 0) goto L_0x00ac
            android.widget.TextView r1 = r8.maxDistValue
            r3 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            r1.setTextColor(r3)
            com.atakmap.coremap.conversions.Span r1 = r8.rangeUnits
            com.atakmap.coremap.conversions.Span r3 = com.atakmap.coremap.conversions.Span.FOOT
            if (r1 != r3) goto L_0x0094
            double r0 = (double) r2
            double r0 = atak.core.oe.d.a(r0)
            long r0 = java.lang.Math.round(r0)
        L_0x0092:
            int r0 = (int) r0
            goto L_0x00a1
        L_0x0094:
            com.atakmap.coremap.conversions.Span r1 = r8.rangeUnits
            com.atakmap.coremap.conversions.Span r3 = com.atakmap.coremap.conversions.Span.NAUTICALMILE
            if (r1 != r3) goto L_0x00a1
            double r0 = (double) r2
            double r0 = r0 / r5
            long r0 = java.lang.Math.round(r0)
            goto L_0x0092
        L_0x00a1:
            android.widget.TextView r1 = r8.maxDistValue
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.setText(r0)
            goto L_0x0127
        L_0x00ac:
            android.widget.TextView r0 = r8.maxDistValue
            r0.setTextColor(r4)
            android.widget.TextView r0 = r8.maxDistValue
            r0.setText(r1)
            java.lang.String r0 = "Set Max Distance returned ERROR"
            r8.setMessage(r0, r3)
            goto L_0x0127
        L_0x00bc:
            android.widget.TextView r0 = r8.maxDistValue
            r0.setTextColor(r4)
            android.widget.TextView r0 = r8.maxDistValue
            java.lang.String r1 = "No UAS connected"
            java.lang.String r1 = r8.shortenErrorMsg(r1)
            r0.setText(r1)
            java.lang.String r0 = "Set Max Distance failed"
            r8.setMessage(r0, r3)
            goto L_0x0127
        L_0x00d2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Please enter an integer between "
            r1.append(r2)
            double r2 = r8.maxDistLow
            r1.append(r2)
            java.lang.String r2 = "-"
            r1.append(r2)
            double r3 = r8.maxDistHigh
            r1.append(r3)
            java.lang.String r3 = " : "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.toast(r0)
            android.widget.TextView r0 = r8.maxDistValue
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Enter an integer between "
            r1.append(r3)
            double r3 = r8.maxDistLow
            r1.append(r3)
            r1.append(r2)
            double r2 = r8.maxDistHigh
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            goto L_0x0127
        L_0x011b:
            java.lang.String r0 = "Please enter only integers"
            r8.toast(r0)
            android.widget.TextView r0 = r8.maxDistValue
            java.lang.String r1 = "Enter only integers"
            r0.setText(r1)
        L_0x0127:
            android.widget.ImageButton r0 = r8.maxDistButton
            r1 = 1
            r0.setEnabled(r1)
            android.widget.EditText r0 = r8.maxDistText
            r0.setEnabled(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJISettingsScreen.setMaxDistance():void");
    }

    /* access modifiers changed from: private */
    public void setGoHomeBatteryPct() {
        this.goHomePctValue.setTextColor(-256);
        this.goHomePctValue.setText(C1877R.string.dashdashdash);
        this.goHomePctButton.setEnabled(false);
        this.goHomePctText.setEnabled(false);
        String obj = this.goHomePctText.getText().toString();
        if (TextUtils.isEmpty(obj) || !TextUtils.isDigitsOnly(obj)) {
            toast("Please enter only integers");
            this.goHomePctValue.setText("Enter only integers");
        } else {
            int parseInt = Integer.parseInt(obj);
            if (parseInt < this.goHomePctLow || parseInt > this.goHomePctHigh) {
                toast("Please enter an integer between " + this.goHomePctLow + "-" + this.goHomePctHigh + " : " + parseInt);
                TextView textView = this.goHomePctValue;
                StringBuilder sb = new StringBuilder();
                sb.append("Enter an integer between ");
                sb.append(this.goHomePctLow);
                sb.append("-");
                sb.append(this.goHomePctHigh);
                textView.setText(sb.toString());
            } else {
                AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                if (serviceConnection != null) {
                    String goHomeBattPct = serviceConnection.setGoHomeBattPct(parseInt);
                    if (TextUtils.isEmpty(goHomeBattPct)) {
                        this.goHomePctValue.setTextColor(TaskEdit.viewColor);
                        this.goHomePctValue.setText(String.valueOf(parseInt));
                    } else {
                        this.goHomePctValue.setTextColor(-65536);
                        this.goHomePctValue.setText(goHomeBattPct);
                        setMessage("Set Go Home Battery Pct returned ERROR", 2);
                    }
                } else {
                    this.goHomePctValue.setTextColor(-65536);
                    this.goHomePctValue.setText(shortenErrorMsg("No UAS connected"));
                    setMessage("Set Go Home Battery Pct failed", 2);
                }
            }
        }
        this.goHomePctButton.setEnabled(true);
        this.goHomePctText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public int getGoHomeBatteryPct() {
        this.goHomePctValue.setTextColor(-256);
        this.goHomePctValue.setText(C1877R.string.dashdashdash);
        int i = 0;
        this.goHomePctButton.setEnabled(false);
        this.goHomePctText.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            i = serviceConnection.getGoHomeBattPct();
            String valueOf = String.valueOf(i);
            this.goHomePctText.setText(valueOf);
            this.goHomePctValue.setTextColor(TaskEdit.viewColor);
            this.goHomePctValue.setText(valueOf);
        } else {
            this.goHomePctText.setText("");
            this.goHomePctValue.setTextColor(-65536);
            this.goHomePctValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Go Home Battery % failed", 2);
        }
        this.goHomePctButton.setEnabled(true);
        this.goHomePctText.setEnabled(true);
        return i;
    }

    /* access modifiers changed from: private */
    public void setGoHomeAltitude() {
        this.goHomeAltValue.setTextColor(-256);
        this.goHomeAltValue.setText(C1877R.string.dashdashdash);
        this.goHomeAltButton.setEnabled(false);
        this.goHomeAltText.setEnabled(false);
        String obj = this.goHomeAltText.getText().toString();
        if (TextUtils.isEmpty(obj) || !TextUtils.isDigitsOnly(obj)) {
            toast("Please enter only integers");
            this.goHomeAltValue.setText("Enter only integers");
        } else {
            int parseInt = Integer.parseInt(obj);
            if (parseInt < this.goHomeAltLow || parseInt > this.goHomeAltHigh) {
                toast("Please enter an integer between " + this.goHomeAltLow + "-" + this.goHomeAltHigh + " : " + parseInt);
                TextView textView = this.goHomeAltValue;
                StringBuilder sb = new StringBuilder();
                sb.append("Enter an integer between ");
                sb.append(this.goHomeAltLow);
                sb.append("-");
                sb.append(this.goHomeAltHigh);
                textView.setText(sb.toString());
            } else {
                int round = this.altUnits == Span.FOOT ? (int) Math.round(oe.b.a((double) parseInt)) : parseInt;
                AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                if (serviceConnection != null) {
                    String goHomeAlt = serviceConnection.setGoHomeAlt(round);
                    if (TextUtils.isEmpty(goHomeAlt)) {
                        this.goHomeAltValue.setTextColor(TaskEdit.viewColor);
                        if (this.altUnits == Span.FOOT) {
                            parseInt = (int) Math.round(oe.d.a((double) round));
                        }
                        this.goHomeAltValue.setText(String.valueOf(parseInt));
                    } else {
                        this.goHomeAltValue.setTextColor(-65536);
                        this.goHomeAltValue.setText(goHomeAlt);
                        setMessage("Set Go Home Altitude returned ERROR", 2);
                    }
                } else {
                    this.goHomeAltValue.setTextColor(-65536);
                    this.goHomeAltValue.setText(shortenErrorMsg("No UAS connected"));
                    setMessage("Set Go Home Altitude failed", 2);
                }
            }
        }
        this.goHomeAltButton.setEnabled(true);
        this.goHomeAltText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public int getGoHomeAltitude() {
        this.goHomeAltValue.setTextColor(-256);
        this.goHomeAltValue.setText(C1877R.string.dashdashdash);
        int i = 0;
        this.goHomeAltButton.setEnabled(false);
        this.goHomeAltText.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            int goHomeAlt = serviceConnection.getGoHomeAlt();
            i = this.altUnits == Span.FOOT ? (int) Math.round(oe.d.a((double) goHomeAlt)) : goHomeAlt;
            String valueOf = String.valueOf(i);
            this.goHomeAltText.setText(valueOf);
            this.goHomeAltValue.setTextColor(TaskEdit.viewColor);
            this.goHomeAltValue.setText(valueOf);
        } else {
            this.goHomeAltText.setText("");
            this.goHomeAltValue.setTextColor(-65536);
            this.goHomeAltValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Go Home Altitude failed", 2);
        }
        this.goHomeAltButton.setEnabled(true);
        this.goHomeAltText.setEnabled(true);
        return i;
    }

    /* access modifiers changed from: private */
    public void setLandNowBatteryPct() {
        this.landNowPctValue.setTextColor(-256);
        this.landNowPctValue.setText(C1877R.string.dashdashdash);
        this.landNowPctButton.setEnabled(false);
        this.landNowPctText.setEnabled(false);
        this.landNowPctLow = 10;
        int goHomeBatteryPct = getGoHomeBatteryPct() - 5;
        this.landNowPctHigh = goHomeBatteryPct;
        if (goHomeBatteryPct < 10) {
            this.landNowPctHigh = 10;
        }
        String obj = this.landNowPctText.getText().toString();
        if (TextUtils.isEmpty(obj) || !TextUtils.isDigitsOnly(obj)) {
            toast("Please enter only integers");
            this.landNowPctValue.setText("Enter only integers");
        } else {
            int parseInt = Integer.parseInt(obj);
            if (parseInt < this.landNowPctLow || parseInt > this.landNowPctHigh) {
                toast("Please enter an integer between " + this.landNowPctLow + "-" + this.landNowPctHigh + " : " + parseInt);
                TextView textView = this.landNowPctValue;
                StringBuilder sb = new StringBuilder();
                sb.append("Enter an integer between ");
                sb.append(this.landNowPctLow);
                sb.append("-");
                sb.append(this.landNowPctHigh);
                textView.setText(sb.toString());
            } else {
                AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                if (serviceConnection != null) {
                    String landNowBattPct = serviceConnection.setLandNowBattPct(parseInt);
                    if (TextUtils.isEmpty(landNowBattPct)) {
                        this.landNowPctValue.setTextColor(TaskEdit.viewColor);
                        this.landNowPctValue.setText(String.valueOf(parseInt));
                    } else {
                        this.landNowPctValue.setTextColor(-65536);
                        this.landNowPctValue.setText(landNowBattPct);
                        setMessage("Set Land Now Battery Pct returned ERROR", 2);
                    }
                } else {
                    this.landNowPctValue.setTextColor(-65536);
                    this.landNowPctValue.setText(shortenErrorMsg("No UAS connected"));
                    setMessage("Set Land Now Battery Pct failed", 2);
                }
            }
        }
        this.landNowPctButton.setEnabled(true);
        this.landNowPctText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public int getLandNowBatteryPct() {
        this.landNowPctValue.setTextColor(-256);
        this.landNowPctValue.setText(C1877R.string.dashdashdash);
        int i = 0;
        this.landNowPctButton.setEnabled(false);
        this.landNowPctText.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            i = serviceConnection.getLandNowBattPct();
            String valueOf = String.valueOf(i);
            this.landNowPctText.setText(valueOf);
            this.landNowPctValue.setTextColor(TaskEdit.viewColor);
            this.landNowPctValue.setText(valueOf);
        } else {
            this.landNowPctText.setText("");
            this.landNowPctValue.setTextColor(-65536);
            this.landNowPctValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Land Now Battery % failed", 2);
        }
        this.landNowPctButton.setEnabled(true);
        this.landNowPctText.setEnabled(true);
        return i;
    }

    /* access modifiers changed from: private */
    public void setConnLossBehav() {
        this.connLossValue.setTextColor(-256);
        this.connLossValue.setText(C1877R.string.dashdashdash);
        this.connLossButton.setEnabled(false);
        this.connLossText.setEnabled(false);
        String charSequence = this.connLossText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a behavior");
            this.connLossValue.setText("Select a behavior");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String connLossBehav = serviceConnection.setConnLossBehav(charSequence);
                if (TextUtils.isEmpty(connLossBehav)) {
                    this.connLossValue.setTextColor(TaskEdit.viewColor);
                    this.connLossValue.setText(String.valueOf(charSequence));
                } else {
                    this.connLossValue.setTextColor(-65536);
                    this.connLossValue.setText(connLossBehav);
                    setMessage("Set Conn Loss Behavior returned ERROR", 2);
                }
            } else {
                this.connLossValue.setTextColor(-65536);
                this.connLossValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set Conn Loss Behavior failed", 2);
            }
        }
        this.connLossButton.setEnabled(true);
        this.connLossText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public String getConnLossBehav() {
        this.connLossValue.setTextColor(-256);
        this.connLossValue.setText(C1877R.string.dashdashdash);
        this.connLossButton.setEnabled(false);
        this.connLossText.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        String str = "";
        if (serviceConnection != null) {
            str = serviceConnection.getConnLossBehav();
            this.connLossText.setText(str);
            this.connLossValue.setTextColor(TaskEdit.viewColor);
            this.connLossValue.setText(str);
        } else {
            this.connLossText.setText(str);
            this.connLossValue.setTextColor(-65536);
            this.connLossValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Conn Loss Behavior failed", 2);
        }
        this.connLossButton.setEnabled(true);
        this.connLossText.setEnabled(true);
        return str;
    }

    /* access modifiers changed from: private */
    public void setCollAvoid() {
        int i = -256;
        this.collAvoidValue.setTextColor(-256);
        this.collAvoidValue.setText(C1877R.string.dashdashdash);
        this.collAvoidButton.setEnabled(false);
        this.collAvoidCheck.setEnabled(false);
        boolean isChecked = this.collAvoidCheck.isChecked();
        String str = "Off";
        if (isChecked) {
            getActiveAvoid();
        } else {
            this.activeAvoidValue.setText(str);
            this.activeAvoidValue.setTextColor(-256);
            this.activeAvoidButton.setEnabled(false);
            this.activeAvoidCheck.setChecked(false);
            this.activeAvoidCheck.setEnabled(false);
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            String collAvoid = serviceConnection.setCollAvoid(isChecked);
            if (TextUtils.isEmpty(collAvoid)) {
                TextView textView = this.collAvoidValue;
                if (isChecked) {
                    i = TaskEdit.viewColor;
                }
                textView.setTextColor(i);
                TextView textView2 = this.collAvoidValue;
                if (isChecked) {
                    str = "On";
                }
                textView2.setText(str);
            } else {
                this.collAvoidValue.setTextColor(-65536);
                this.collAvoidValue.setText(collAvoid);
                setMessage("Set Coll Avoid returned ERROR", 2);
            }
        } else {
            this.collAvoidValue.setTextColor(-65536);
            this.collAvoidValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Set Coll Avoid failed", 2);
        }
        this.collAvoidButton.setEnabled(true);
        this.collAvoidCheck.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public boolean getCollAvoid() {
        int i = -256;
        this.collAvoidValue.setTextColor(-256);
        this.collAvoidValue.setText(C1877R.string.dashdashdash);
        boolean z = false;
        this.collAvoidButton.setEnabled(false);
        this.collAvoidCheck.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            boolean collAvoid = serviceConnection.getCollAvoid();
            String str = "Off";
            if (collAvoid) {
                getActiveAvoid();
            } else {
                this.activeAvoidValue.setText(str);
                this.activeAvoidValue.setTextColor(-256);
                this.activeAvoidButton.setEnabled(false);
                this.activeAvoidCheck.setChecked(false);
                this.activeAvoidCheck.setEnabled(false);
            }
            this.collAvoidCheck.setChecked(collAvoid);
            TextView textView = this.collAvoidValue;
            if (collAvoid) {
                i = TaskEdit.viewColor;
            }
            textView.setTextColor(i);
            TextView textView2 = this.collAvoidValue;
            if (collAvoid) {
                str = "On";
            }
            textView2.setText(str);
            z = collAvoid;
        } else {
            this.collAvoidCheck.setChecked(false);
            this.collAvoidValue.setTextColor(-65536);
            this.collAvoidValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Coll Avoid failed", 2);
        }
        this.collAvoidButton.setEnabled(true);
        this.collAvoidCheck.setEnabled(true);
        return z;
    }

    /* access modifiers changed from: private */
    public void setActiveAvoid() {
        int i = -256;
        this.activeAvoidValue.setTextColor(-256);
        this.activeAvoidValue.setText(C1877R.string.dashdashdash);
        this.activeAvoidButton.setEnabled(false);
        this.activeAvoidCheck.setEnabled(false);
        boolean isChecked = this.activeAvoidCheck.isChecked();
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            String activeAvoid = serviceConnection.setActiveAvoid(isChecked);
            if (TextUtils.isEmpty(activeAvoid)) {
                TextView textView = this.activeAvoidValue;
                if (isChecked) {
                    i = TaskEdit.viewColor;
                }
                textView.setTextColor(i);
                this.activeAvoidValue.setText(isChecked ? "On" : "Off");
            } else {
                this.activeAvoidValue.setTextColor(-65536);
                this.activeAvoidValue.setText(activeAvoid);
                setMessage("Set Active Avoid returned ERROR", 2);
            }
        } else {
            this.activeAvoidValue.setTextColor(-65536);
            this.activeAvoidValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Set Active Avoid failed", 2);
        }
        this.activeAvoidButton.setEnabled(true);
        this.activeAvoidCheck.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public boolean getActiveAvoid() {
        int i = -256;
        this.activeAvoidValue.setTextColor(-256);
        this.activeAvoidValue.setText(C1877R.string.dashdashdash);
        boolean z = false;
        this.activeAvoidButton.setEnabled(false);
        this.activeAvoidCheck.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            z = serviceConnection.getActiveAvoid();
            this.activeAvoidCheck.setChecked(z);
            TextView textView = this.activeAvoidValue;
            if (z) {
                i = TaskEdit.viewColor;
            }
            textView.setTextColor(i);
            this.activeAvoidValue.setText(z ? "On" : "Off");
        } else {
            this.activeAvoidCheck.setChecked(false);
            this.activeAvoidValue.setTextColor(-65536);
            this.activeAvoidValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Active Avoid failed", 2);
        }
        this.activeAvoidButton.setEnabled(true);
        this.activeAvoidCheck.setEnabled(true);
        return z;
    }

    /* access modifiers changed from: private */
    public void setVisionPos() {
        int i = -256;
        this.visionPosValue.setTextColor(-256);
        this.visionPosValue.setText(C1877R.string.dashdashdash);
        this.visionPosButton.setEnabled(false);
        this.visionPosCheck.setEnabled(false);
        boolean isChecked = this.visionPosCheck.isChecked();
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            String visionPos = serviceConnection.setVisionPos(isChecked);
            if (TextUtils.isEmpty(visionPos)) {
                TextView textView = this.visionPosValue;
                if (isChecked) {
                    i = TaskEdit.viewColor;
                }
                textView.setTextColor(i);
                this.visionPosValue.setText(isChecked ? "On" : "Off");
            } else {
                this.visionPosValue.setTextColor(-65536);
                this.visionPosValue.setText(visionPos);
                setMessage("Set Vision Pos returned ERROR", 2);
            }
        } else {
            this.visionPosValue.setTextColor(-65536);
            this.visionPosValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Set Vision Pos failed", 2);
        }
        this.visionPosButton.setEnabled(true);
        this.visionPosCheck.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public boolean getVisionPos() {
        int i = -256;
        this.visionPosValue.setTextColor(-256);
        this.visionPosValue.setText(C1877R.string.dashdashdash);
        boolean z = false;
        this.visionPosButton.setEnabled(false);
        this.visionPosCheck.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            z = serviceConnection.getVisionPos();
            this.visionPosCheck.setChecked(z);
            TextView textView = this.visionPosValue;
            if (z) {
                i = TaskEdit.viewColor;
            }
            textView.setTextColor(i);
            this.visionPosValue.setText(z ? "On" : "Off");
        } else {
            this.visionPosCheck.setChecked(false);
            this.visionPosValue.setTextColor(-65536);
            this.visionPosValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Vision Pos failed", 2);
        }
        this.visionPosButton.setEnabled(true);
        this.visionPosCheck.setEnabled(true);
        return z;
    }

    /* access modifiers changed from: private */
    public void setPrecLand() {
        int i = -256;
        this.precisionLandValue.setTextColor(-256);
        this.precisionLandValue.setText(C1877R.string.dashdashdash);
        this.precisionLandButton.setEnabled(false);
        this.precisionLandCheck.setEnabled(false);
        boolean isChecked = this.precisionLandCheck.isChecked();
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            String precLand = serviceConnection.setPrecLand(isChecked);
            if (TextUtils.isEmpty(precLand)) {
                TextView textView = this.precisionLandValue;
                if (isChecked) {
                    i = TaskEdit.viewColor;
                }
                textView.setTextColor(i);
                this.precisionLandValue.setText(isChecked ? "On" : "Off");
            } else {
                this.precisionLandValue.setTextColor(-65536);
                this.precisionLandValue.setText(precLand);
                setMessage("Set Prec Land returned ERROR", 2);
            }
        } else {
            this.precisionLandValue.setTextColor(-65536);
            this.precisionLandValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Set Prec Land failed", 2);
        }
        this.precisionLandButton.setEnabled(true);
        this.precisionLandCheck.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public boolean getPrecLand() {
        int i = -256;
        this.precisionLandValue.setTextColor(-256);
        this.precisionLandValue.setText(C1877R.string.dashdashdash);
        boolean z = false;
        this.precisionLandButton.setEnabled(false);
        this.precisionLandCheck.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            z = serviceConnection.getPrecLand();
            this.precisionLandCheck.setChecked(z);
            TextView textView = this.precisionLandValue;
            if (z) {
                i = TaskEdit.viewColor;
            }
            textView.setTextColor(i);
            this.precisionLandValue.setText(z ? "On" : "Off");
        } else {
            this.precisionLandCheck.setChecked(false);
            this.precisionLandValue.setTextColor(-65536);
            this.precisionLandValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Prec Land failed", 2);
        }
        this.precisionLandButton.setEnabled(true);
        this.precisionLandCheck.setEnabled(true);
        return z;
    }

    /* access modifiers changed from: private */
    public void setLandProt() {
        int i = -256;
        this.landProtectValue.setTextColor(-256);
        this.landProtectValue.setText(C1877R.string.dashdashdash);
        this.landProtectButton.setEnabled(false);
        this.landProtectCheck.setEnabled(false);
        boolean isChecked = this.landProtectCheck.isChecked();
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            String landProt = serviceConnection.setLandProt(isChecked);
            if (TextUtils.isEmpty(landProt)) {
                TextView textView = this.landProtectValue;
                if (isChecked) {
                    i = TaskEdit.viewColor;
                }
                textView.setTextColor(i);
                this.landProtectValue.setText(isChecked ? "On" : "Off");
            } else {
                this.landProtectValue.setTextColor(-65536);
                this.landProtectValue.setText(landProt);
                setMessage("Set Land Prot returned ERROR", 2);
            }
        } else {
            this.landProtectValue.setTextColor(-65536);
            this.landProtectValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Set Land Prot failed", 2);
        }
        this.landProtectButton.setEnabled(true);
        this.landProtectCheck.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public boolean getLandProt() {
        int i = -256;
        this.landProtectValue.setTextColor(-256);
        this.landProtectValue.setText(C1877R.string.dashdashdash);
        boolean z = false;
        this.landProtectButton.setEnabled(false);
        this.landProtectCheck.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            z = serviceConnection.getLandProt();
            this.landProtectCheck.setChecked(z);
            TextView textView = this.landProtectValue;
            if (z) {
                i = TaskEdit.viewColor;
            }
            textView.setTextColor(i);
            this.landProtectValue.setText(z ? "On" : "Off");
        } else {
            this.landProtectCheck.setChecked(false);
            this.landProtectValue.setTextColor(-65536);
            this.landProtectValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Land Prot failed", 2);
        }
        this.landProtectButton.setEnabled(true);
        this.landProtectCheck.setEnabled(true);
        return z;
    }

    /* access modifiers changed from: private */
    public void getWiFi() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            boolean hasWiFi = serviceConnection.hasWiFi();
            getWiFiSSID(hasWiFi);
            getWiFiPassword(hasWiFi);
            getWiFiChannelMode(hasWiFi);
            getWiFiChannelNumber(hasWiFi);
            getWiFiFrequencyBand(hasWiFi);
            getWiFiDataRate(hasWiFi);
            return;
        }
        getWiFiSSID(false);
        getWiFiPassword(false);
        getWiFiChannelMode(false);
        getWiFiChannelNumber(false);
        getWiFiFrequencyBand(false);
        getWiFiDataRate(false);
    }

    private String getWiFiSSID(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiSSID = serviceConnection.getWiFiSSID();
                this.wifiSSIDValue.setText(wiFiSSID);
                this.wifiSSIDValue.setTextColor(TaskEdit.viewColor);
                this.wifiSSIDText.setText(wiFiSSID);
                this.wifiSSIDText.setEnabled(true);
                this.wifiSSIDButton.setEnabled(true);
                return wiFiSSID;
            }
            this.wifiSSIDValue.setText("No UAS connected");
            this.wifiSSIDValue.setTextColor(-65536);
            this.wifiSSIDText.setText("");
            this.wifiSSIDText.setEnabled(false);
            this.wifiSSIDButton.setEnabled(false);
            return "";
        }
        this.wifiSSIDValue.setText("not available");
        this.wifiSSIDValue.setTextColor(-256);
        this.wifiSSIDText.setText("");
        this.wifiSSIDText.setEnabled(false);
        this.wifiSSIDButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setWiFiSSID() {
        this.wifiSSIDValue.setTextColor(-256);
        this.wifiSSIDValue.setText(C1877R.string.dashdashdash);
        this.wifiSSIDButton.setEnabled(false);
        this.wifiSSIDText.setEnabled(false);
        String obj = this.wifiSSIDText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            toast("Please enter a WiFi SSID");
            this.wifiSSIDValue.setText("Enter a WiFi SSID");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiSSID = serviceConnection.setWiFiSSID(obj);
                if (TextUtils.isEmpty(wiFiSSID)) {
                    this.wifiSSIDValue.setTextColor(TaskEdit.viewColor);
                    this.wifiSSIDValue.setText(String.valueOf(obj));
                } else {
                    this.wifiSSIDValue.setTextColor(-65536);
                    this.wifiSSIDValue.setText(wiFiSSID);
                    setMessage("Set WiFi SSID returned ERROR", 2);
                }
            } else {
                this.wifiSSIDValue.setTextColor(-65536);
                this.wifiSSIDValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set WiFi SSID failed", 2);
            }
        }
        this.wifiSSIDButton.setEnabled(true);
        this.wifiSSIDText.setEnabled(true);
    }

    private String getWiFiPassword(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiPassword = serviceConnection.getWiFiPassword();
                this.wifiPasswordValue.setText(wiFiPassword);
                this.wifiPasswordValue.setTextColor(TaskEdit.viewColor);
                this.wifiPasswordText.setText(wiFiPassword);
                this.wifiPasswordText.setEnabled(true);
                this.wifiPasswordButton.setEnabled(true);
                return wiFiPassword;
            }
            this.wifiPasswordValue.setText("No UAS connected");
            this.wifiPasswordValue.setTextColor(-65536);
            this.wifiPasswordText.setText("");
            this.wifiPasswordText.setEnabled(false);
            this.wifiPasswordButton.setEnabled(false);
            return "";
        }
        this.wifiPasswordValue.setText("not available");
        this.wifiPasswordValue.setTextColor(-256);
        this.wifiPasswordText.setText("");
        this.wifiPasswordText.setEnabled(false);
        this.wifiPasswordButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setWiFiPassword() {
        this.wifiPasswordValue.setTextColor(-256);
        this.wifiPasswordValue.setText(C1877R.string.dashdashdash);
        this.wifiPasswordButton.setEnabled(false);
        this.wifiPasswordText.setEnabled(false);
        String obj = this.wifiPasswordText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            toast("Please enter a WiFi password");
            this.wifiPasswordValue.setText("Enter a WiFi password");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiPassword = serviceConnection.setWiFiPassword(obj);
                if (TextUtils.isEmpty(wiFiPassword)) {
                    this.wifiPasswordValue.setTextColor(TaskEdit.viewColor);
                    this.wifiPasswordValue.setText(String.valueOf(obj));
                } else {
                    this.wifiPasswordValue.setTextColor(-65536);
                    this.wifiPasswordValue.setText(wiFiPassword);
                    setMessage("Set WiFi password returned ERROR", 2);
                }
            } else {
                this.wifiPasswordValue.setTextColor(-65536);
                this.wifiPasswordValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set WiFi password failed", 2);
            }
        }
        this.wifiPasswordButton.setEnabled(true);
        this.wifiPasswordText.setEnabled(true);
    }

    private String getWiFiFrequencyBand(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiFrequencyBand = serviceConnection.getWiFiFrequencyBand();
                this.wifiFrequencyBandValue.setText(wiFiFrequencyBand);
                this.wifiFrequencyBandValue.setTextColor(TaskEdit.viewColor);
                this.wifiFrequencyBandText.setText(wiFiFrequencyBand);
                this.wifiFrequencyBandText.setEnabled(true);
                this.wifiFrequencyBandButton.setEnabled(true);
                return wiFiFrequencyBand;
            }
            this.wifiFrequencyBandValue.setText("No UAS connected");
            this.wifiFrequencyBandValue.setTextColor(-65536);
            this.wifiFrequencyBandText.setText("");
            this.wifiFrequencyBandText.setEnabled(false);
            this.wifiFrequencyBandButton.setEnabled(false);
            return "";
        }
        this.wifiFrequencyBandValue.setText("not available");
        this.wifiFrequencyBandValue.setTextColor(-256);
        this.wifiFrequencyBandText.setText("");
        this.wifiFrequencyBandText.setEnabled(false);
        this.wifiFrequencyBandButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setWiFiFrequencyBand() {
        this.wifiFrequencyBandValue.setTextColor(-256);
        this.wifiFrequencyBandValue.setText(C1877R.string.dashdashdash);
        this.wifiFrequencyBandButton.setEnabled(false);
        this.wifiFrequencyBandText.setEnabled(false);
        String charSequence = this.wifiFrequencyBandText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a WiFi frequency band");
            this.wifiFrequencyBandValue.setText("Select a WiFi frequency band");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiFrequencyBand = serviceConnection.setWiFiFrequencyBand(charSequence);
                if (TextUtils.isEmpty(wiFiFrequencyBand)) {
                    this.wifiFrequencyBandValue.setTextColor(TaskEdit.viewColor);
                    this.wifiFrequencyBandValue.setText(String.valueOf(charSequence));
                } else {
                    this.wifiFrequencyBandValue.setTextColor(-65536);
                    this.wifiFrequencyBandValue.setText(wiFiFrequencyBand);
                    setMessage("Set WiFi frequency band returned ERROR", 2);
                }
            } else {
                this.wifiFrequencyBandValue.setTextColor(-65536);
                this.wifiFrequencyBandValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set WiFi frequency band failed", 2);
            }
        }
        this.wifiPasswordButton.setEnabled(true);
        this.wifiFrequencyBandText.setEnabled(true);
    }

    private String getWiFiChannelMode(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiChannelMode = serviceConnection.getWiFiChannelMode();
                this.wifiChannelModeValue.setText(wiFiChannelMode);
                this.wifiChannelModeValue.setTextColor(TaskEdit.viewColor);
                this.wifiChannelModeText.setText(wiFiChannelMode);
                this.wifiChannelModeText.setEnabled(true);
                this.wifiChannelModeButton.setEnabled(true);
                return wiFiChannelMode;
            }
            this.wifiChannelModeValue.setText("No UAS connected");
            this.wifiChannelModeValue.setTextColor(-65536);
            this.wifiChannelModeText.setText("");
            this.wifiChannelModeText.setEnabled(false);
            this.wifiChannelModeButton.setEnabled(false);
            return "";
        }
        this.wifiChannelModeValue.setText("not available");
        this.wifiChannelModeValue.setTextColor(-256);
        this.wifiChannelModeText.setText("");
        this.wifiChannelModeText.setEnabled(false);
        this.wifiChannelModeButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setWiFiChannelMode() {
        this.wifiChannelModeValue.setTextColor(-256);
        this.wifiChannelModeValue.setText(C1877R.string.dashdashdash);
        this.wifiChannelModeButton.setEnabled(false);
        this.wifiChannelModeText.setEnabled(false);
        String charSequence = this.wifiChannelModeText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a WiFi channel mode");
            this.wifiChannelModeValue.setText("Select a WiFi channel mode");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiChannelMode = serviceConnection.setWiFiChannelMode(charSequence);
                if (TextUtils.isEmpty(wiFiChannelMode)) {
                    this.wifiChannelModeValue.setTextColor(TaskEdit.viewColor);
                    this.wifiChannelModeValue.setText(String.valueOf(charSequence));
                } else {
                    this.wifiChannelModeValue.setTextColor(-65536);
                    this.wifiChannelModeValue.setText(wiFiChannelMode);
                    setMessage("Set WiFi channel mode returned ERROR", 2);
                }
            } else {
                this.wifiChannelModeValue.setTextColor(-65536);
                this.wifiChannelModeValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set WiFi channel mode failed", 2);
            }
        }
        this.wifiChannelModeButton.setEnabled(true);
        this.wifiChannelModeText.setEnabled(true);
    }

    private int getWiFiChannelNumber(boolean z) {
        String str = "";
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                int wiFiChannelNumber = serviceConnection.getWiFiChannelNumber();
                if (wiFiChannelNumber > -1) {
                    str = String.valueOf(wiFiChannelNumber);
                }
                this.wifiChannelNumberValue.setText(str);
                this.wifiChannelNumberValue.setTextColor(TaskEdit.viewColor);
                this.wifiChannelNumberText.setText(str);
                this.wifiChannelNumberText.setEnabled(true);
                this.wifiChannelNumberButton.setEnabled(true);
                getWiFiChannelNumbers();
                return wiFiChannelNumber;
            }
            this.wifiChannelNumberValue.setText("No UAS connected");
            this.wifiChannelNumberValue.setTextColor(-65536);
            this.wifiChannelNumberText.setText(str);
            this.wifiChannelNumberText.setEnabled(false);
            this.wifiChannelNumberButton.setEnabled(false);
            return -1;
        }
        this.wifiChannelNumberValue.setText("not available");
        this.wifiChannelNumberValue.setTextColor(-256);
        this.wifiChannelNumberText.setText(str);
        this.wifiChannelNumberText.setEnabled(false);
        this.wifiChannelNumberButton.setEnabled(false);
        return -1;
    }

    private int[] getWiFiChannelNumbers() {
        int[] iArr = {-1};
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return iArr;
        }
        int[] wiFiChannelNumbers2 = serviceConnection.getWiFiChannelNumbers();
        this.wiFiChannelNumbers = wiFiChannelNumbers2;
        return wiFiChannelNumbers2;
    }

    /* access modifiers changed from: private */
    public void setWiFiChannelNumber() {
        toast("Unable to set DJI WiFi channel number");
        this.wifiChannelNumberValue.setTextColor(-256);
        this.wifiChannelNumberValue.setText(C1877R.string.dashdashdash);
        this.wifiChannelNumberButton.setEnabled(false);
        this.wifiChannelNumberText.setEnabled(false);
        try {
            int parseInt = Integer.parseInt(this.wifiChannelNumberText.getText().toString());
            if (parseInt < 0) {
                toast("Please select a channel number");
                this.wifiChannelNumberValue.setText("Select a channel number");
            } else {
                AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                if (serviceConnection != null) {
                    String wiFiChannelNumber = serviceConnection.setWiFiChannelNumber(parseInt);
                    if (TextUtils.isEmpty(wiFiChannelNumber)) {
                        this.wifiChannelNumberValue.setTextColor(TaskEdit.viewColor);
                        this.wifiChannelNumberValue.setText(String.valueOf(parseInt));
                    } else {
                        this.wifiChannelNumberValue.setTextColor(-65536);
                        this.wifiChannelNumberValue.setText(wiFiChannelNumber);
                        setMessage("Set WiFi Channel Number returned ERROR", 2);
                    }
                } else {
                    this.wifiChannelNumberValue.setTextColor(-65536);
                    this.wifiChannelNumberValue.setText(shortenErrorMsg("No UAS connected"));
                    setMessage("Set WiFi Channel Number failed", 2);
                }
            }
            this.wifiChannelNumberButton.setEnabled(true);
            this.wifiChannelNumberText.setEnabled(true);
        } catch (NumberFormatException unused) {
            toast("Invalid channel number: " + -1);
            this.wifiChannelNumberValue.setText("Invalid channel number");
            this.wifiChannelNumberButton.setEnabled(true);
            this.wifiChannelNumberText.setEnabled(true);
        }
    }

    private String getWiFiDataRate(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiDataRate = serviceConnection.getWiFiDataRate();
                this.wifiDataRateValue.setText(wiFiDataRate);
                this.wifiDataRateValue.setTextColor(TaskEdit.viewColor);
                this.wifiDataRateText.setText(wiFiDataRate);
                this.wifiDataRateText.setEnabled(true);
                this.wifiDataRateButton.setEnabled(true);
                return wiFiDataRate;
            }
            this.wifiDataRateValue.setText("No UAS connected");
            this.wifiDataRateValue.setTextColor(-65536);
            this.wifiDataRateText.setText("");
            this.wifiDataRateText.setEnabled(false);
            this.wifiDataRateButton.setEnabled(false);
            return "";
        }
        this.wifiDataRateValue.setText("not available");
        this.wifiDataRateValue.setTextColor(-256);
        this.wifiDataRateText.setText("");
        this.wifiDataRateText.setEnabled(false);
        this.wifiDataRateButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setWiFiDataRate() {
        this.wifiDataRateValue.setTextColor(-256);
        this.wifiDataRateValue.setText(C1877R.string.dashdashdash);
        this.wifiDataRateButton.setEnabled(false);
        this.wifiDataRateText.setEnabled(false);
        String charSequence = this.wifiDataRateText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a WiFi data rate");
            this.wifiDataRateValue.setText("Select a WiFi data rate");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String wiFiDataRate = serviceConnection.setWiFiDataRate(charSequence);
                if (TextUtils.isEmpty(wiFiDataRate)) {
                    this.wifiDataRateValue.setTextColor(TaskEdit.viewColor);
                    this.wifiDataRateValue.setText(String.valueOf(charSequence));
                } else {
                    this.wifiDataRateValue.setTextColor(-65536);
                    this.wifiDataRateValue.setText(wiFiDataRate);
                    setMessage("Set WiFi data rate returned ERROR", 2);
                }
            } else {
                this.wifiDataRateValue.setTextColor(-65536);
                this.wifiDataRateValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set WiFi data rate failed", 2);
            }
        }
        this.wifiDataRateButton.setEnabled(true);
        this.wifiDataRateText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public void getOcuSync() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            boolean hasOcuSync = serviceConnection.hasOcuSync();
            String ocuSyncChannelMode = getOcuSyncChannelMode(hasOcuSync);
            getOcuSyncChannelBandwidth(hasOcuSync, ocuSyncChannelMode);
            getOcuSyncChannelNumber(hasOcuSync, ocuSyncChannelMode);
            getOcuSyncFrequencyBand(hasOcuSync);
            return;
        }
        getOcuSyncChannelMode(false);
        getOcuSyncChannelBandwidth(false, (String) null);
        getOcuSyncChannelNumber(false, (String) null);
        getOcuSyncFrequencyBand(false);
    }

    private String getOcuSyncChannelMode(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String ocuSyncChannelMode = serviceConnection.getOcuSyncChannelMode();
                this.ocuSyncChannelModeValue.setText(ocuSyncChannelMode);
                this.ocuSyncChannelModeValue.setTextColor(TaskEdit.viewColor);
                this.ocuSyncChannelModeText.setText(ocuSyncChannelMode);
                this.ocuSyncChannelModeText.setEnabled(true);
                this.ocuSyncChannelModeButton.setEnabled(true);
                return ocuSyncChannelMode;
            }
            this.ocuSyncChannelModeValue.setText("No UAS connected");
            this.ocuSyncChannelModeValue.setTextColor(-65536);
            this.ocuSyncChannelModeText.setText("");
            this.ocuSyncChannelModeText.setEnabled(false);
            this.ocuSyncChannelModeButton.setEnabled(false);
            return "";
        }
        this.ocuSyncChannelModeValue.setText("not available");
        this.ocuSyncChannelModeValue.setTextColor(-256);
        this.ocuSyncChannelModeText.setText("");
        this.ocuSyncChannelModeText.setEnabled(false);
        this.ocuSyncChannelModeButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setOcuSyncChannelMode() {
        this.ocuSyncChannelModeValue.setTextColor(-256);
        this.ocuSyncChannelModeValue.setText(C1877R.string.dashdashdash);
        this.ocuSyncChannelModeButton.setEnabled(false);
        this.ocuSyncChannelModeText.setEnabled(false);
        String charSequence = this.ocuSyncChannelModeText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a channel mode");
            this.ocuSyncChannelModeValue.setText("Select a channel mode");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String ocuSyncChannelMode = serviceConnection.setOcuSyncChannelMode(charSequence);
                if (TextUtils.isEmpty(ocuSyncChannelMode)) {
                    this.ocuSyncChannelModeValue.setTextColor(TaskEdit.viewColor);
                    this.ocuSyncChannelModeValue.setText(String.valueOf(charSequence));
                } else {
                    this.ocuSyncChannelModeValue.setTextColor(-65536);
                    this.ocuSyncChannelModeValue.setText(ocuSyncChannelMode);
                    setMessage("Set OcuSync Channel Mode returned ERROR", 2);
                }
                getOcuSyncChannelBandwidth(true, charSequence);
                getOcuSyncChannelNumber(true, charSequence);
                getOcuSyncFrequencyBand(true);
            } else {
                this.ocuSyncChannelModeValue.setTextColor(-65536);
                this.ocuSyncChannelModeValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set OcuSync Channel Mode failed", 2);
            }
        }
        this.ocuSyncChannelModeButton.setEnabled(true);
        this.ocuSyncChannelModeText.setEnabled(true);
    }

    private String getOcuSyncChannelBandwidth(boolean z, String str) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String ocuSyncChannelBandwidth = serviceConnection.getOcuSyncChannelBandwidth();
                if (str.equals("Manual")) {
                    this.ocuSyncChannelBandwidthValue.setText(ocuSyncChannelBandwidth);
                    this.ocuSyncChannelBandwidthText.setText(ocuSyncChannelBandwidth);
                    this.ocuSyncChannelBandwidthValue.setTextColor(TaskEdit.viewColor);
                    this.ocuSyncChannelBandwidthText.setEnabled(true);
                    this.ocuSyncChannelBandwidthButton.setEnabled(true);
                } else {
                    TextView textView = this.ocuSyncChannelBandwidthValue;
                    textView.setText(ocuSyncChannelBandwidth + " (auto)");
                    this.ocuSyncChannelBandwidthText.setText(ocuSyncChannelBandwidth);
                    this.ocuSyncChannelBandwidthValue.setTextColor(-256);
                    this.ocuSyncChannelBandwidthText.setEnabled(false);
                    this.ocuSyncChannelBandwidthButton.setEnabled(false);
                }
                return ocuSyncChannelBandwidth;
            }
            this.ocuSyncChannelBandwidthValue.setText("No UAS connected");
            this.ocuSyncChannelBandwidthValue.setTextColor(-65536);
            this.ocuSyncChannelBandwidthText.setText("");
            this.ocuSyncChannelBandwidthText.setEnabled(false);
            this.ocuSyncChannelBandwidthButton.setEnabled(false);
            return "";
        }
        this.ocuSyncChannelBandwidthValue.setText("not available");
        this.ocuSyncChannelBandwidthValue.setTextColor(-256);
        this.ocuSyncChannelBandwidthText.setText("");
        this.ocuSyncChannelBandwidthText.setEnabled(false);
        this.ocuSyncChannelBandwidthButton.setEnabled(false);
        return "";
    }

    private String[] getOcuSyncChannelBandwidths() {
        String[] strArr = {"none"};
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        return serviceConnection != null ? serviceConnection.getOcuSyncChannelBandwidths() : strArr;
    }

    /* access modifiers changed from: private */
    public void setOcuSyncChannelBandwidth() {
        this.ocuSyncChannelBandwidthValue.setTextColor(-256);
        this.ocuSyncChannelBandwidthValue.setText(C1877R.string.dashdashdash);
        this.ocuSyncChannelBandwidthButton.setEnabled(false);
        this.ocuSyncChannelBandwidthText.setEnabled(false);
        String charSequence = this.ocuSyncChannelBandwidthText.getText().toString();
        String charSequence2 = this.ocuSyncChannelModeText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a channel bandwidth");
            this.ocuSyncChannelBandwidthValue.setText("Select a channel bandwidth");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String ocuSyncChannelBandwidth = serviceConnection.setOcuSyncChannelBandwidth(charSequence);
                if (TextUtils.isEmpty(ocuSyncChannelBandwidth)) {
                    this.ocuSyncChannelBandwidthValue.setTextColor(TaskEdit.viewColor);
                    this.ocuSyncChannelBandwidthValue.setText(String.valueOf(charSequence));
                } else {
                    this.ocuSyncChannelBandwidthValue.setTextColor(-65536);
                    this.ocuSyncChannelBandwidthValue.setText(ocuSyncChannelBandwidth);
                    setMessage("Set OcuSync Channel Bandwidth returned ERROR", 2);
                }
                getOcuSyncChannelNumber(true, charSequence2);
                getOcuSyncFrequencyBand(true);
            } else {
                this.ocuSyncChannelBandwidthValue.setTextColor(-65536);
                this.ocuSyncChannelBandwidthValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set OcuSync Channel Bandwidth failed", 2);
            }
        }
        this.ocuSyncChannelBandwidthButton.setEnabled(true);
        this.ocuSyncChannelBandwidthText.setEnabled(true);
    }

    private int getOcuSyncChannelNumber(boolean z, String str) {
        String str2 = "";
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                int ocuSyncChannelNumber = serviceConnection.getOcuSyncChannelNumber();
                if (ocuSyncChannelNumber > -1) {
                    str2 = String.valueOf(ocuSyncChannelNumber);
                }
                if (str.equals("Manual")) {
                    this.ocuSyncChannelNumberValue.setText(str2);
                    this.ocuSyncChannelNumberValue.setTextColor(TaskEdit.viewColor);
                    this.ocuSyncChannelNumberText.setText(str2);
                    this.ocuSyncChannelNumberText.setEnabled(true);
                    this.ocuSyncChannelNumberButton.setEnabled(true);
                } else {
                    TextView textView = this.ocuSyncChannelNumberValue;
                    textView.setText(str2 + " (auto)");
                    this.ocuSyncChannelNumberValue.setTextColor(-256);
                    this.ocuSyncChannelNumberText.setText(str2);
                    this.ocuSyncChannelNumberText.setEnabled(false);
                    this.ocuSyncChannelNumberButton.setEnabled(false);
                }
                getOcuSyncChannelNumberRange();
                return ocuSyncChannelNumber;
            }
            this.ocuSyncChannelNumberValue.setText("No UAS connected");
            this.ocuSyncChannelNumberValue.setTextColor(-65536);
            this.ocuSyncChannelNumberText.setText(str2);
            this.ocuSyncChannelNumberText.setEnabled(false);
            this.ocuSyncChannelNumberButton.setEnabled(false);
            return -1;
        }
        this.ocuSyncChannelNumberValue.setText("not available");
        this.ocuSyncChannelNumberValue.setTextColor(-256);
        this.ocuSyncChannelNumberText.setText(str2);
        this.ocuSyncChannelNumberText.setEnabled(false);
        this.ocuSyncChannelNumberButton.setEnabled(false);
        return -1;
    }

    private int[] getOcuSyncChannelNumberRange() {
        int[] iArr = {-1, -1};
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return iArr;
        }
        int[] ocuSyncChannelNumberRange = serviceConnection.getOcuSyncChannelNumberRange();
        this.ocuSyncChannelNumLow = ocuSyncChannelNumberRange[0];
        this.ocuSyncChannelNumHi = ocuSyncChannelNumberRange[1];
        return ocuSyncChannelNumberRange;
    }

    /* access modifiers changed from: private */
    public void setOcuSyncChannelNumber() {
        toast("Unable to set DJI OcuSync channel number");
    }

    private String getOcuSyncFrequencyBand(boolean z) {
        if (z) {
            String upperCase = this.uasItem.getModelName().toUpperCase();
            if (upperCase.equals("PHANTOM 4 PRO V2") || upperCase.startsWith("MAVIC 2")) {
                AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
                if (serviceConnection != null) {
                    String ocuSyncFrequencyBand = serviceConnection.getOcuSyncFrequencyBand();
                    this.ocuSyncFrequencyBandValue.setText(ocuSyncFrequencyBand);
                    this.ocuSyncFrequencyBandValue.setTextColor(TaskEdit.viewColor);
                    this.ocuSyncFrequencyBandText.setText(ocuSyncFrequencyBand);
                    this.ocuSyncFrequencyBandText.setEnabled(true);
                    this.ocuSyncFrequencyBandButton.setEnabled(true);
                    this.ocuSyncFrequencyBandArray = getOcuSyncFrequencyBands();
                    return ocuSyncFrequencyBand;
                }
                this.ocuSyncFrequencyBandValue.setText("No UAS connected");
                this.ocuSyncFrequencyBandValue.setTextColor(-65536);
                this.ocuSyncFrequencyBandText.setText("");
                this.ocuSyncFrequencyBandText.setEnabled(false);
                this.ocuSyncFrequencyBandButton.setEnabled(false);
                return "";
            }
            this.ocuSyncFrequencyBandValue.setText("2.4");
            this.ocuSyncFrequencyBandValue.setTextColor(-256);
            this.ocuSyncFrequencyBandText.setText("2.4");
            this.ocuSyncFrequencyBandText.setEnabled(false);
            this.ocuSyncFrequencyBandButton.setEnabled(false);
            return "";
        }
        this.ocuSyncFrequencyBandValue.setText("not available");
        this.ocuSyncFrequencyBandValue.setTextColor(-256);
        this.ocuSyncFrequencyBandText.setText("");
        this.ocuSyncFrequencyBandText.setEnabled(false);
        this.ocuSyncFrequencyBandButton.setEnabled(false);
        return "";
    }

    private String[] getOcuSyncFrequencyBands() {
        String[] strArr = {"none"};
        String upperCase = this.uasItem.getModelName().toUpperCase();
        if (!upperCase.equals("PHANTOM 4 PRO V2") && !upperCase.startsWith("MAVIC 2")) {
            return new String[]{"2.4"};
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        return serviceConnection != null ? serviceConnection.getOcuSyncFrequencyBands() : strArr;
    }

    /* access modifiers changed from: private */
    public void chooseOcuSyncFrequencyBand() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("OcuSync Frequency Band");
        builder.setItems(this.ocuSyncFrequencyBandArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISettingsScreen.this.ocuSyncFrequencyBandText.setText(DJISettingsScreen.this.ocuSyncFrequencyBandArray[i]);
            }
        });
        AlertDialog create = builder.create();
        this.ocuSyncFrequencyBandDialog = create;
        create.show();
    }

    /* access modifiers changed from: private */
    public void setOcuSyncFrequencyBand() {
        this.ocuSyncFrequencyBandValue.setTextColor(-256);
        this.ocuSyncFrequencyBandValue.setText(C1877R.string.dashdashdash);
        this.ocuSyncFrequencyBandButton.setEnabled(false);
        this.ocuSyncFrequencyBandText.setEnabled(false);
        String charSequence = this.ocuSyncFrequencyBandText.getText().toString();
        String charSequence2 = this.ocuSyncChannelModeText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a frequency band");
            this.ocuSyncFrequencyBandValue.setText("Select a frequency band");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String ocuSyncFrequencyBand = serviceConnection.setOcuSyncFrequencyBand(charSequence);
                if (TextUtils.isEmpty(ocuSyncFrequencyBand)) {
                    this.ocuSyncFrequencyBandValue.setTextColor(TaskEdit.viewColor);
                    this.ocuSyncFrequencyBandValue.setText(String.valueOf(charSequence));
                } else {
                    this.ocuSyncFrequencyBandValue.setTextColor(-65536);
                    this.ocuSyncFrequencyBandValue.setText(ocuSyncFrequencyBand);
                    setMessage("Set OcuSync Frequency Band returned ERROR", 2);
                }
                getOcuSyncChannelNumber(true, charSequence2);
            } else {
                this.ocuSyncFrequencyBandValue.setTextColor(-65536);
                this.ocuSyncFrequencyBandValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set OcuSync Frequency Band failed", 2);
            }
        }
        this.ocuSyncFrequencyBandButton.setEnabled(true);
        this.ocuSyncFrequencyBandText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public void getLightBridge() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            boolean hasLightBridge = serviceConnection.hasLightBridge();
            getLightBridgeChannelNumber(hasLightBridge, getLightBridgeChannelMode(hasLightBridge));
            getLightBridgeDataRate(hasLightBridge);
            getLightBridgeTransmissionMode(hasLightBridge);
            getLightBridgeFrequencyBand(hasLightBridge);
            return;
        }
        getLightBridgeChannelMode(false);
        getLightBridgeChannelNumber(false, (String) null);
        getLightBridgeDataRate(false);
        getLightBridgeTransmissionMode(false);
        getLightBridgeFrequencyBand(false);
    }

    private String getLightBridgeChannelMode(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String lightBridgeChannelMode = serviceConnection.getLightBridgeChannelMode();
                this.lightBridgeChannelModeValue.setText(lightBridgeChannelMode);
                this.lightBridgeChannelModeValue.setTextColor(TaskEdit.viewColor);
                this.lightBridgeChannelModeText.setText(lightBridgeChannelMode);
                this.lightBridgeChannelModeText.setEnabled(true);
                this.lightBridgeChannelModeButton.setEnabled(true);
                return lightBridgeChannelMode;
            }
            this.lightBridgeChannelModeValue.setText("No UAS connected");
            this.lightBridgeChannelModeValue.setTextColor(-65536);
            this.lightBridgeChannelModeText.setText("");
            this.lightBridgeChannelModeText.setEnabled(false);
            this.lightBridgeChannelModeButton.setEnabled(false);
            return "";
        }
        this.lightBridgeChannelModeValue.setText("not available");
        this.lightBridgeChannelModeValue.setTextColor(-256);
        this.lightBridgeChannelModeText.setText("");
        this.lightBridgeChannelModeText.setEnabled(false);
        this.lightBridgeChannelModeButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setLightBridgeChannelMode() {
        this.lightBridgeChannelModeValue.setTextColor(-256);
        this.lightBridgeChannelModeValue.setText(C1877R.string.dashdashdash);
        this.lightBridgeChannelModeButton.setEnabled(false);
        this.lightBridgeChannelModeText.setEnabled(false);
        String charSequence = this.lightBridgeChannelModeText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a channel mode");
            this.lightBridgeChannelModeValue.setText("Select a channel mode");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String lightBridgeChannelMode = serviceConnection.setLightBridgeChannelMode(charSequence);
                if (TextUtils.isEmpty(lightBridgeChannelMode)) {
                    this.lightBridgeChannelModeValue.setTextColor(TaskEdit.viewColor);
                    this.lightBridgeChannelModeValue.setText(String.valueOf(charSequence));
                } else {
                    this.lightBridgeChannelModeValue.setTextColor(-65536);
                    this.lightBridgeChannelModeValue.setText(lightBridgeChannelMode);
                    setMessage("Set LightBridge Channel Mode returned ERROR", 2);
                }
                getLightBridgeChannelNumber(true, charSequence);
                getLightBridgeFrequencyBand(true);
            } else {
                this.lightBridgeChannelModeValue.setTextColor(-65536);
                this.lightBridgeChannelModeValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set LightBridge Channel Mode failed", 2);
            }
        }
        this.lightBridgeChannelModeButton.setEnabled(true);
        this.lightBridgeChannelModeText.setEnabled(true);
    }

    private int getLightBridgeChannelNumber(boolean z, String str) {
        String str2 = "";
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                int lightBridgeChannelNumber = serviceConnection.getLightBridgeChannelNumber();
                if (lightBridgeChannelNumber > -1) {
                    str2 = String.valueOf(lightBridgeChannelNumber);
                }
                if (str.equals("Manual")) {
                    this.lightBridgeChannelNumberValue.setText(str2);
                    this.lightBridgeChannelNumberValue.setTextColor(TaskEdit.viewColor);
                    this.lightBridgeChannelNumberText.setText(str2);
                    this.lightBridgeChannelNumberText.setEnabled(true);
                    this.lightBridgeChannelNumberButton.setEnabled(true);
                } else {
                    TextView textView = this.lightBridgeChannelNumberValue;
                    textView.setText(str2 + " (auto)");
                    this.lightBridgeChannelNumberValue.setTextColor(-256);
                    this.lightBridgeChannelNumberText.setText(str2);
                    this.lightBridgeChannelNumberText.setEnabled(false);
                    this.lightBridgeChannelNumberButton.setEnabled(false);
                }
                getLightBridgeChannelNumberRange();
                return lightBridgeChannelNumber;
            }
            this.lightBridgeChannelNumberValue.setText("No UAS connected");
            this.lightBridgeChannelNumberValue.setTextColor(-65536);
            this.lightBridgeChannelNumberText.setText(str2);
            this.lightBridgeChannelNumberText.setEnabled(false);
            this.lightBridgeChannelNumberButton.setEnabled(false);
            return -1;
        }
        this.lightBridgeChannelNumberValue.setText("not available");
        this.lightBridgeChannelNumberValue.setTextColor(-256);
        this.lightBridgeChannelNumberText.setText(str2);
        this.lightBridgeChannelNumberText.setEnabled(false);
        this.lightBridgeChannelNumberButton.setEnabled(false);
        return -1;
    }

    private int[] getLightBridgeChannelNumberRange() {
        int[] iArr = {-1, -1};
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return iArr;
        }
        int[] ocuSyncChannelNumberRange = serviceConnection.getOcuSyncChannelNumberRange();
        this.lightBridgeChannelNumLow = ocuSyncChannelNumberRange[0];
        this.lightBridgeChannelNumHi = ocuSyncChannelNumberRange[1];
        return ocuSyncChannelNumberRange;
    }

    /* access modifiers changed from: private */
    public void setLightBridgeChannelNumber() {
        toast("Unable to set DJI LightBridge channel number");
    }

    private String getLightBridgeDataRate(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String lightBridgeDataRate = serviceConnection.getLightBridgeDataRate();
                this.lightBridgeDataRateValue.setText(lightBridgeDataRate);
                this.lightBridgeDataRateValue.setTextColor(TaskEdit.viewColor);
                this.lightBridgeDataRateText.setText(lightBridgeDataRate);
                this.lightBridgeDataRateText.setEnabled(true);
                this.lightBridgeDataRateButton.setEnabled(true);
                return lightBridgeDataRate;
            }
            this.lightBridgeDataRateValue.setText("No UAS connected");
            this.lightBridgeDataRateValue.setTextColor(-65536);
            this.lightBridgeDataRateText.setText("");
            this.lightBridgeDataRateText.setEnabled(false);
            this.lightBridgeDataRateButton.setEnabled(false);
            return "";
        }
        this.lightBridgeDataRateValue.setText("not available");
        this.lightBridgeDataRateValue.setTextColor(-256);
        this.lightBridgeDataRateText.setText("");
        this.lightBridgeDataRateText.setEnabled(false);
        this.lightBridgeDataRateButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setLightBridgeDataRate() {
        this.lightBridgeDataRateValue.setTextColor(-256);
        this.lightBridgeDataRateValue.setText(C1877R.string.dashdashdash);
        this.lightBridgeDataRateButton.setEnabled(false);
        this.lightBridgeDataRateText.setEnabled(false);
        String charSequence = this.lightBridgeDataRateText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a LightBridge data rate");
            this.lightBridgeDataRateValue.setText("Select a LightBridge data rate");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String lightBridgeDataRate = serviceConnection.setLightBridgeDataRate(charSequence);
                if (TextUtils.isEmpty(lightBridgeDataRate)) {
                    this.lightBridgeDataRateValue.setTextColor(TaskEdit.viewColor);
                    this.lightBridgeDataRateValue.setText(String.valueOf(charSequence));
                } else {
                    this.lightBridgeDataRateValue.setTextColor(-65536);
                    this.lightBridgeDataRateValue.setText(lightBridgeDataRate);
                    setMessage("Set LightBridge data rate returned ERROR", 2);
                }
            } else {
                this.lightBridgeDataRateValue.setTextColor(-65536);
                this.lightBridgeDataRateValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set LightBridge data rate failed", 2);
            }
        }
        this.lightBridgeDataRateButton.setEnabled(true);
        this.lightBridgeDataRateText.setEnabled(true);
    }

    private String getLightBridgeTransmissionMode(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String lightBridgeTransmissionMode = serviceConnection.getLightBridgeTransmissionMode();
                if (!TextUtils.isEmpty(lightBridgeTransmissionMode)) {
                    this.lightBridgeTransmissionModeValue.setText(lightBridgeTransmissionMode);
                    this.lightBridgeTransmissionModeValue.setTextColor(TaskEdit.viewColor);
                    this.lightBridgeTransmissionModeText.setText(lightBridgeTransmissionMode);
                    this.lightBridgeTransmissionModeText.setEnabled(true);
                    this.lightBridgeTransmissionModeButton.setEnabled(true);
                } else {
                    this.lightBridgeTransmissionModeValue.setText("not supported");
                    this.lightBridgeTransmissionModeValue.setTextColor(-256);
                    this.lightBridgeTransmissionModeText.setText("");
                    this.lightBridgeTransmissionModeText.setEnabled(false);
                    this.lightBridgeTransmissionModeButton.setEnabled(false);
                }
                return lightBridgeTransmissionMode;
            }
            this.lightBridgeTransmissionModeValue.setText("No UAS connected");
            this.lightBridgeTransmissionModeValue.setTextColor(-65536);
            this.lightBridgeTransmissionModeText.setText("");
            this.lightBridgeTransmissionModeText.setEnabled(false);
            this.lightBridgeTransmissionModeButton.setEnabled(false);
            return "";
        }
        this.lightBridgeTransmissionModeValue.setText("not available");
        this.lightBridgeTransmissionModeValue.setTextColor(-256);
        this.lightBridgeTransmissionModeText.setText("");
        this.lightBridgeTransmissionModeText.setEnabled(false);
        this.lightBridgeTransmissionModeButton.setEnabled(false);
        return "";
    }

    /* access modifiers changed from: private */
    public void setLightBridgeTransmissionMode() {
        this.lightBridgeTransmissionModeValue.setTextColor(-256);
        this.lightBridgeTransmissionModeValue.setText(C1877R.string.dashdashdash);
        this.lightBridgeTransmissionModeButton.setEnabled(false);
        this.lightBridgeTransmissionModeText.setEnabled(false);
        String charSequence = this.lightBridgeChannelModeText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a transmission mode");
            this.lightBridgeTransmissionModeValue.setText("Select a transmission mode");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String lightBridgeTransmissionMode = serviceConnection.setLightBridgeTransmissionMode(charSequence);
                if (TextUtils.isEmpty(lightBridgeTransmissionMode)) {
                    this.lightBridgeTransmissionModeValue.setTextColor(TaskEdit.viewColor);
                    this.lightBridgeTransmissionModeValue.setText(String.valueOf(charSequence));
                } else {
                    this.lightBridgeTransmissionModeValue.setTextColor(-65536);
                    this.lightBridgeTransmissionModeValue.setText(lightBridgeTransmissionMode);
                    setMessage("Set LightBridge Transmission Mode returned ERROR", 2);
                }
            } else {
                this.lightBridgeTransmissionModeValue.setTextColor(-65536);
                this.lightBridgeTransmissionModeValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set LightBridge Transmission Mode failed", 2);
            }
        }
        this.lightBridgeTransmissionModeButton.setEnabled(true);
        this.lightBridgeTransmissionModeText.setEnabled(true);
    }

    private String getLightBridgeFrequencyBand(boolean z) {
        if (z) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String lightBridgeFrequencyBand = serviceConnection.getLightBridgeFrequencyBand();
                this.lightBridgeFrequencyBandValue.setText(lightBridgeFrequencyBand);
                this.lightBridgeFrequencyBandValue.setTextColor(TaskEdit.viewColor);
                this.lightBridgeFrequencyBandText.setText(lightBridgeFrequencyBand);
                this.lightBridgeFrequencyBandText.setEnabled(true);
                this.lightBridgeFrequencyBandButton.setEnabled(true);
                this.lightBridgeFrequencyBandArray = getLightBridgeFrequencyBands();
                return lightBridgeFrequencyBand;
            }
            this.lightBridgeFrequencyBandValue.setText("No UAS connected");
            this.lightBridgeFrequencyBandValue.setTextColor(-65536);
            this.lightBridgeFrequencyBandText.setText("");
            this.lightBridgeFrequencyBandText.setEnabled(false);
            this.lightBridgeFrequencyBandButton.setEnabled(false);
            return "";
        }
        this.lightBridgeFrequencyBandValue.setText("not available");
        this.lightBridgeFrequencyBandValue.setTextColor(-256);
        this.lightBridgeFrequencyBandText.setText("");
        this.lightBridgeFrequencyBandText.setEnabled(false);
        this.lightBridgeFrequencyBandButton.setEnabled(false);
        return "";
    }

    private String[] getLightBridgeFrequencyBands() {
        String[] strArr = {"none"};
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        return serviceConnection != null ? serviceConnection.getLightBridgeFrequencyBands() : strArr;
    }

    /* access modifiers changed from: private */
    public void chooseLightBridgeFrequencyBand() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("LightBridge Frequency Band");
        builder.setItems(this.lightBridgeFrequencyBandArray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISettingsScreen.this.lightBridgeFrequencyBandText.setText(DJISettingsScreen.this.lightBridgeFrequencyBandArray[i]);
            }
        });
        AlertDialog create = builder.create();
        this.lightBridgeFrequencyBandDialog = create;
        create.show();
    }

    /* access modifiers changed from: private */
    public void setLightBridgeFrequencyBand() {
        this.lightBridgeFrequencyBandValue.setTextColor(-256);
        this.lightBridgeFrequencyBandValue.setText(C1877R.string.dashdashdash);
        this.lightBridgeFrequencyBandButton.setEnabled(false);
        this.lightBridgeFrequencyBandText.setEnabled(false);
        String charSequence = this.lightBridgeFrequencyBandText.getText().toString();
        String charSequence2 = this.lightBridgeChannelModeText.getText().toString();
        if (TextUtils.isEmpty(charSequence)) {
            toast("Please select a frequency band");
            this.lightBridgeFrequencyBandValue.setText("Select a frequency band");
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String lightBridgeFrequencyBand = serviceConnection.setLightBridgeFrequencyBand(charSequence);
                if (TextUtils.isEmpty(lightBridgeFrequencyBand)) {
                    this.lightBridgeFrequencyBandValue.setTextColor(TaskEdit.viewColor);
                    this.lightBridgeFrequencyBandValue.setText(String.valueOf(charSequence));
                } else {
                    this.lightBridgeFrequencyBandValue.setTextColor(-65536);
                    this.lightBridgeFrequencyBandValue.setText(lightBridgeFrequencyBand);
                    setMessage("Set LightBridge Frequency Band returned ERROR", 2);
                }
                getLightBridgeChannelNumber(true, charSequence2);
            } else {
                this.lightBridgeFrequencyBandValue.setTextColor(-65536);
                this.lightBridgeFrequencyBandValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set LightBridge Frequency Band failed", 2);
            }
        }
        this.lightBridgeFrequencyBandButton.setEnabled(true);
        this.lightBridgeFrequencyBandText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public void getResFPSList() {
        this.rezFPSMap = new HashMap<>();
        new ArrayList();
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            List<String> resFPSList = serviceConnection.getResFPSList();
            if (resFPSList != null && resFPSList.size() > 0) {
                for (String next : resFPSList) {
                    String[] split = next.split(",");
                    this.rezFPSMap.put(next, split[0].replace("RESOLUTION_", "") + "/" + split[1].replace("FRAME_RATE_", "").replace("_DOT_", ".").replace("_FPS", ""));
                }
                return;
            }
            return;
        }
        setMessage("Get Res FPS List failed", 2);
    }

    /* access modifiers changed from: private */
    public void setResFPS() {
        this.rezFPSValue.setTextColor(-256);
        this.rezFPSValue.setText(C1877R.string.dashdashdash);
        this.rezFPSButton.setEnabled(false);
        this.rezFPSText.setEnabled(false);
        String findRezFPSString = findRezFPSString(this.rezFPSText.getText().toString());
        if (TextUtils.isEmpty(findRezFPSString)) {
            toast("Please select a res/fps");
            this.rezFPSValue.setText("Unable to query UAS res/fps list");
            this.rezFPSValue.setTextColor(-65536);
        } else {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                String resFPS = serviceConnection.setResFPS(findRezFPSString);
                if (TextUtils.isEmpty(resFPS)) {
                    this.rezFPSValue.setTextColor(TaskEdit.viewColor);
                    this.rezFPSValue.setText(convertDJIResFPS(findRezFPSString));
                } else {
                    this.rezFPSValue.setTextColor(-65536);
                    this.rezFPSValue.setText(resFPS);
                    setMessage("Set Res FPS returned ERROR", 2);
                }
            } else {
                this.rezFPSValue.setTextColor(-65536);
                this.rezFPSValue.setText(shortenErrorMsg("No UAS connected"));
                setMessage("Set Res FPS failed", 2);
            }
        }
        this.rezFPSButton.setEnabled(true);
        this.rezFPSText.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public String getResFPS() {
        this.rezFPSValue.setTextColor(-256);
        this.rezFPSValue.setText(C1877R.string.dashdashdash);
        this.rezFPSButton.setEnabled(false);
        this.rezFPSText.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        String str = "";
        if (serviceConnection != null) {
            str = serviceConnection.getResFPS();
            this.rezFPSText.setText(convertDJIResFPS(str));
            this.rezFPSValue.setTextColor(TaskEdit.viewColor);
            this.rezFPSValue.setText(convertDJIResFPS(str));
        } else {
            this.rezFPSText.setText(str);
            this.rezFPSValue.setTextColor(-65536);
            this.rezFPSValue.setText(shortenErrorMsg("No UAS connected"));
            setMessage("Get Res FPS failed", 2);
        }
        this.rezFPSButton.setEnabled(true);
        this.rezFPSText.setEnabled(true);
        return str;
    }

    private String convertDJIResFPS(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(",");
        return split[0].replace("RESOLUTION_", "") + "/" + split[1].replace("FRAME_RATE_", "").replace("_DOT_", ".").replace("_FPS", "");
    }

    /* access modifiers changed from: private */
    public void showRezFPSDialog() {
        HashMap<String, String> hashMap = this.rezFPSMap;
        if (hashMap == null || hashMap.size() < 1) {
            toast("Error retrieving Resolution/FPS from UAS");
            return;
        }
        final String[] strArr = new String[this.rezFPSMap.size()];
        int i = 0;
        for (String str : this.rezFPSMap.values()) {
            strArr[i] = str;
            i++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Resolution / Frame Rate");
        builder.setItems(strArr, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISettingsScreen.this.rezFPSText.setText(strArr[i]);
            }
        });
        builder.show();
    }

    private String findRezFPSString(String str) {
        HashMap<String, String> hashMap = this.rezFPSMap;
        String str2 = null;
        if (hashMap != null && hashMap.size() >= 1) {
            for (Map.Entry next : this.rezFPSMap.entrySet()) {
                if (((String) next.getValue()).equals(str)) {
                    str2 = (String) next.getKey();
                }
            }
        }
        return str2;
    }

    /* access modifiers changed from: private */
    public void askSDCardFormat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Format UAS SD Card?");
        builder.setMessage("Formatting the SD card on the UAS will erase all data on the card." + "\n\nContinue formatting?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISettingsScreen.this.formatSDCardStart();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void formatSDCardStart() {
        this.formatSDValue.setText("formatting...");
        this.formatSDValue.setTextColor(-256);
        this.formatSDButton.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.formatSDCardStart();
            return;
        }
        this.formatSDValue.setTextColor(-65536);
        this.formatSDValue.setText(shortenErrorMsg("No UAS connected"));
        this.formatSDButton.setEnabled(true);
        setMessage("Format SD Card failed", 2);
    }

    public void formatSDCardDone(String str) {
        if (TextUtils.isEmpty(str)) {
            this.formatSDValue.setTextColor(TaskEdit.viewColor);
            this.formatSDValue.setText("format successful");
        } else {
            this.formatSDValue.setTextColor(-65536);
            this.formatSDValue.setText(str);
            setMessage("Format SD Card failed", 2);
        }
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                DJISettingsScreen.this.formatSDButton.setEnabled(true);
            }
        });
    }

    /* access modifiers changed from: private */
    public void askInternalFormat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setTitle("Format UAS Internal Storage?");
        builder.setMessage("Formatting the internal storage on the UAS will erase all data." + "\n\nContinue formatting?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                DJISettingsScreen.this.formatInternalStart();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void formatInternalStart() {
        this.formatStorageValue.setText("formatting...");
        this.formatStorageValue.setTextColor(-256);
        this.formatStorageButton.setEnabled(false);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.formatInternalStart();
            return;
        }
        this.formatStorageValue.setTextColor(-65536);
        this.formatStorageValue.setText(shortenErrorMsg("No UAS connected"));
        this.formatStorageButton.setEnabled(true);
        setMessage("Format Internal Storage failed", 2);
    }

    public void formatInternalDone(String str) {
        if (TextUtils.isEmpty(str)) {
            this.formatStorageValue.setTextColor(TaskEdit.viewColor);
            this.formatStorageValue.setText("format successful");
        } else {
            this.formatStorageValue.setTextColor(-65536);
            this.formatStorageValue.setText(str);
            setMessage("Format Internal Storage failed", 2);
        }
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                DJISettingsScreen.this.formatStorageButton.setEnabled(true);
            }
        });
    }

    /* access modifiers changed from: private */
    public void setMessage(String str, int i) {
        if (i == 1) {
            this.msgsText.setTextColor(-256);
        } else if (i == 2) {
            this.msgsText.setTextColor(-65536);
        } else {
            this.msgsText.setTextColor(-1);
        }
        if (TextUtils.isEmpty(str)) {
            this.msgsText.setText("");
            return;
        }
        TextView textView = this.msgsText;
        textView.setText("(" + str + ")");
    }

    private String shortenErrorMsg(String str) {
        return str.equals("Execution of this process has timed out") ? "Timed out" : str;
    }

    /* access modifiers changed from: private */
    public void showHelp(String str, String str2) {
        UASToolDropDownReceiver.getInstance().helpPopup(str, str2);
    }

    public void init(UASItem uASItem, UASToolFragment uASToolFragment) {
        super.init(uASItem, uASToolFragment);
    }

    /* access modifiers changed from: private */
    public void showCustomButtons() {
        this.myParentFragment.setCurrentScreen((DJIButtonsScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.dji_button_layout, (ViewGroup) null), this.uasItem, this.myParentFragment);
    }

    /* access modifiers changed from: private */
    public void showAccelCalib() {
        this.myParentFragment.setCurrentScreen((DJIAccelCalibScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.dji_accel_screen, (ViewGroup) null), this.uasItem, this.myParentFragment);
    }

    /* access modifiers changed from: private */
    public void showGyroCalib() {
        this.myParentFragment.setCurrentScreen((DJIGyroCalibScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.dji_gyro_screen, (ViewGroup) null), this.uasItem, this.myParentFragment);
    }

    /* access modifiers changed from: private */
    public void showCompassCalib() {
        this.myParentFragment.setCurrentScreen((DJICompassCalibScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.dji_compass_screen, (ViewGroup) null), this.uasItem, this.myParentFragment);
    }

    /* access modifiers changed from: private */
    public void showGimbalCalib() {
        this.myParentFragment.setCurrentScreen((DJIGimbalCalibScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.dji_gimbal_screen, (ViewGroup) null), this.uasItem, this.myParentFragment);
    }

    public void destroy() {
        super.destroy();
    }
}
