package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicBoolean;

public class DJIThermalTempsLayout extends RelativeLayout {
    public static final String PREF_PRESET = "uastool.dji.thermal.temp.preset";
    public static final String TAG = DJIThermalTempsLayout.class.getSimpleName();
    private static final String TEMP_UNITS_CELSIUS = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.dji_thermal_temp_units_celsius);
    private static final String TEMP_UNITS_FAHRENHEIT = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.dji_thermal_temp_units_fahrenheit);
    private static final String TEMP_UNITS_PERCENT = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.dji_thermal_temp_units_percent);
    private static final String TEMP_UNITS_UNKNOWN = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.dji_thermal_temp_units_unknown);
    /* access modifiers changed from: private */
    public static final AtomicBoolean isUpdating = new AtomicBoolean(false);
    public static final DecimalFormat oneDecimalFormat = new DecimalFormat("#.#");
    /* access modifiers changed from: private */
    public int currentHigh;
    /* access modifiers changed from: private */
    public int currentLow;
    /* access modifiers changed from: private */
    public CheckBox enableCheck;
    /* access modifiers changed from: private */
    public EditText highTempInput;
    /* access modifiers changed from: private */
    public SeekBar highTempSeek;
    private TextView highTempValue;
    /* access modifiers changed from: private */
    public EditText lowTempInput;
    /* access modifiers changed from: private */
    public SeekBar lowTempSeek;
    private TextView lowTempValue;
    private int maxTemp;
    /* access modifiers changed from: private */
    public int minTemp;
    /* access modifiers changed from: private */
    public String[] presets;
    private String tempUnits;
    private String tempUnitsLabel;
    /* access modifiers changed from: private */
    public RelativeLayout tempsLayout;

    public DJIThermalTempsLayout(Context context) {
        super(context);
    }

    public DJIThermalTempsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJIThermalTempsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r8 = this;
            super.onAttachedToWindow()
            r0 = 2131034281(0x7f0500a9, float:1.7679075E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r8.tempsLayout = r0
            r0 = 2131034285(0x7f0500ad, float:1.7679083E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.lowTempValue = r0
            r0 = 2131034283(0x7f0500ab, float:1.767908E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.SeekBar r0 = (android.widget.SeekBar) r0
            r8.lowTempSeek = r0
            r0 = 2131034282(0x7f0500aa, float:1.7679077E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r8.lowTempInput = r0
            r0 = 2131034280(0x7f0500a8, float:1.7679073E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.highTempValue = r0
            r0 = 2131034278(0x7f0500a6, float:1.767907E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.SeekBar r0 = (android.widget.SeekBar) r0
            r8.highTempSeek = r0
            r0 = 2131034277(0x7f0500a5, float:1.7679067E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r8.highTempInput = r0
            r0 = 2131034276(0x7f0500a4, float:1.7679065E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r8.enableCheck = r0
            com.atakmap.android.uastool.UASToolDropDownReceiver.getSharedPrefs()
            java.lang.String r0 = r8.getThermalIsothermTempUnits()
            r8.tempUnits = r0
            int r1 = r0.hashCode()
            r2 = -1966947682(0xffffffff8ac2c29e, float:-1.8754727E-32)
            r3 = 1
            if (r1 == r2) goto L_0x008d
            r2 = 1071632058(0x3fdfceba, float:1.7484963)
            if (r1 == r2) goto L_0x0083
            r2 = 1379812394(0x523e442a, float:2.04296847E11)
            if (r1 == r2) goto L_0x0079
            goto L_0x0097
        L_0x0079:
            java.lang.String r1 = "Unknown"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0097
            r0 = 1
            goto L_0x0098
        L_0x0083:
            java.lang.String r1 = "Percentage"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0097
            r0 = 0
            goto L_0x0098
        L_0x008d:
            java.lang.String r1 = "Celsius"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0097
            r0 = 2
            goto L_0x0098
        L_0x0097:
            r0 = -1
        L_0x0098:
            if (r0 == 0) goto L_0x00b6
            if (r0 == r3) goto L_0x00b1
            java.lang.String r0 = TEMP_UNITS_CELSIUS
            r8.tempUnitsLabel = r0
            java.lang.String r0 = com.atakmap.android.uastool.dji.DJIThermalSettingsLayout.getUnits()
            java.lang.String r1 = "Fahrenheit"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00ba
            java.lang.String r0 = TEMP_UNITS_FAHRENHEIT
            r8.tempUnitsLabel = r0
            goto L_0x00ba
        L_0x00b1:
            java.lang.String r0 = TEMP_UNITS_UNKNOWN
            r8.tempUnitsLabel = r0
            goto L_0x00ba
        L_0x00b6:
            java.lang.String r0 = TEMP_UNITS_PERCENT
            r8.tempUnitsLabel = r0
        L_0x00ba:
            boolean r0 = r8.getThermalIsothermEnabled()
            int r1 = r8.getThermalIsoTempMin()
            r8.minTemp = r1
            int r1 = r8.getThermalIsoTempMax()
            r8.maxTemp = r1
            int r1 = r8.getThermalIsoTempLow()
            r8.currentLow = r1
            int r1 = r8.getThermalIsoTempHigh()
            r8.currentHigh = r1
            android.widget.EditText r1 = r8.lowTempInput
            int r2 = r8.currentLow
            float r2 = (float) r2
            float r2 = r8.convertTempDisplay(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.setText(r2)
            android.widget.EditText r1 = r8.highTempInput
            int r2 = r8.currentHigh
            float r2 = (float) r2
            float r2 = r8.convertTempDisplay(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.setText(r2)
            android.widget.SeekBar r1 = r8.lowTempSeek
            int r2 = r8.maxTemp
            int r4 = r8.minTemp
            int r2 = r2 - r4
            r1.setMax(r2)
            android.widget.SeekBar r1 = r8.highTempSeek
            int r2 = r8.maxTemp
            int r4 = r8.minTemp
            int r2 = r2 - r4
            r1.setMax(r2)
            android.widget.SeekBar r1 = r8.lowTempSeek
            int r2 = r8.currentLow
            int r4 = r8.minTemp
            int r2 = r2 - r4
            r1.setProgress(r2)
            android.widget.TextView r1 = r8.lowTempValue
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r4 = r8.currentLow
            float r4 = (float) r4
            float r4 = r8.convertTempDisplay(r4)
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            java.lang.String r5 = r8.tempUnitsLabel
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            android.widget.SeekBar r1 = r8.highTempSeek
            int r2 = r8.currentHigh
            int r5 = r8.minTemp
            int r2 = r2 - r5
            r1.setProgress(r2)
            android.widget.TextView r1 = r8.highTempValue
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r5 = r8.currentHigh
            float r5 = (float) r5
            float r5 = r8.convertTempDisplay(r5)
            r2.append(r5)
            r2.append(r4)
            java.lang.String r4 = r8.tempUnitsLabel
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            android.widget.SeekBar r1 = r8.lowTempSeek
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$1 r2 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$1
            r2.<init>()
            r1.setOnSeekBarChangeListener(r2)
            android.widget.SeekBar r1 = r8.highTempSeek
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$2 r2 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$2
            r2.<init>()
            r1.setOnSeekBarChangeListener(r2)
            android.widget.CheckBox r1 = r8.enableCheck
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$3 r2 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$3
            r2.<init>()
            r1.setOnCheckedChangeListener(r2)
            android.widget.EditText r1 = r8.lowTempInput
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$4 r2 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$4
            r2.<init>()
            r1.setOnEditorActionListener(r2)
            android.widget.EditText r1 = r8.lowTempInput
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$5 r2 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$5
            r2.<init>()
            r1.setOnFocusChangeListener(r2)
            android.widget.EditText r1 = r8.highTempInput
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$6 r2 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$6
            r2.<init>()
            r1.setOnEditorActionListener(r2)
            android.widget.EditText r1 = r8.highTempInput
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$7 r2 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$7
            r2.<init>()
            r1.setOnFocusChangeListener(r2)
            com.atakmap.android.uastool.UASToolDropDownReceiver r1 = com.atakmap.android.uastool.UASToolDropDownReceiver.getInstance()
            android.content.Context r1 = r1.getPluginContext()
            android.content.res.Resources r2 = r1.getResources()
            r4 = 2130771977(0x7f010009, float:1.714706E38)
            java.lang.String[] r2 = r2.getStringArray(r4)
            r8.presets = r2
            java.lang.String r2 = r8.getPreset()
            r4 = 2131034287(0x7f0500af, float:1.7679087E38)
            android.view.View r4 = r8.findViewById(r4)
            com.atakmap.android.gui.PluginSpinner r4 = (com.atakmap.android.gui.PluginSpinner) r4
            android.widget.ArrayAdapter r5 = new android.widget.ArrayAdapter
            r6 = 2131165248(0x7f070040, float:1.7944708E38)
            java.lang.String[] r7 = r8.presets
            r5.<init>(r1, r6, r7)
            r1 = 17367049(0x1090009, float:2.516295E-38)
            r5.setDropDownViewResource(r1)
            r4.setAdapter(r5)
            java.lang.String[] r1 = r8.presets
            java.util.List r1 = java.util.Arrays.asList(r1)
            int r1 = r1.indexOf(r2)
            r4.setSelection(r1, r3)
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$8 r1 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$8
            r1.<init>()
            r4.setOnItemSelectedListener(r1)
            android.widget.RelativeLayout r1 = r8.tempsLayout
            r8.enableTemps(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJIThermalTempsLayout.onAttachedToWindow():void");
    }

    /* access modifiers changed from: private */
    public void hideKeyboard(EditText editText) {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /* access modifiers changed from: private */
    public void enableTemps(final View view, final boolean z) {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                View view = view;
                if (view instanceof SeekBar) {
                    view.setEnabled(z);
                    return;
                }
                if (view instanceof EditText) {
                    if (z) {
                        ((EditText) view).setEnabled(true);
                        ((EditText) view).setBackgroundColor(-1);
                        return;
                    }
                    ((EditText) view).setEnabled(false);
                    ((EditText) view).setBackgroundColor(-12303292);
                } else if (view instanceof TextView) {
                    if (z) {
                        ((TextView) view).setTextColor(-1);
                    } else {
                        ((TextView) view).setTextColor(-7829368);
                    }
                } else if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        DJIThermalTempsLayout.this.enableTemps(viewGroup.getChildAt(i), z);
                    }
                }
            }
        });
    }

    private String getThermalIsothermTempUnits() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        return serviceConnection != null ? serviceConnection.getThermalIsoTempUnits() : "Celsius";
    }

    private int getThermalIsoTempMin() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getThermalIsoTempMin();
        }
        return 0;
    }

    private int getThermalIsoTempMax() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getThermalIsoTempMax();
        }
        return 0;
    }

    private int getThermalIsoTempLow() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getThermalIsoTempLow();
        }
        return 0;
    }

    private int getThermalIsoTempHigh() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getThermalIsoTempHigh();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public int updateLowTemp(int i) {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            this.currentLow = serviceConnection.setThermalIsoTempLow(i);
            TextView textView = this.lowTempValue;
            textView.setText(convertTempDisplay((float) this.currentLow) + " " + this.tempUnitsLabel);
            this.lowTempInput.setText(String.valueOf(convertTempDisplay((float) this.currentLow)));
            this.lowTempSeek.setProgress(this.currentLow - this.minTemp);
        }
        return this.currentLow;
    }

    /* access modifiers changed from: private */
    public int updateHighTemp(int i) {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            this.currentHigh = serviceConnection.setThermalIsoTempHigh(i);
            TextView textView = this.highTempValue;
            textView.setText(convertTempDisplay((float) this.currentHigh) + " " + this.tempUnitsLabel);
            this.highTempInput.setText(String.valueOf(convertTempDisplay((float) this.currentHigh)));
            this.highTempSeek.setProgress(this.currentHigh - this.minTemp);
        }
        return this.currentHigh;
    }

    private boolean getThermalIsothermEnabled() {
        boolean z;
        AtomicBoolean atomicBoolean = isUpdating;
        atomicBoolean.set(true);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            z = serviceConnection.getThermalIsoEnabled();
            this.enableCheck.setChecked(z);
            enableTemps(this.tempsLayout, z);
        } else {
            z = false;
        }
        atomicBoolean.set(false);
        return z;
    }

    /* access modifiers changed from: private */
    public void setThermalIsothermEnabled(boolean z) {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            enableTemps(this.tempsLayout, serviceConnection.setThermalIsoEnabled(z));
        }
    }

    private String getPreset() {
        return UASToolDropDownReceiver.getSharedPrefs().getString(PREF_PRESET, this.presets[0]);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPreset(java.lang.String r6) {
        /*
            r5 = this;
            android.content.SharedPreferences r0 = com.atakmap.android.uastool.UASToolDropDownReceiver.getSharedPrefs()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = "uastool.dji.thermal.temp.preset"
            android.content.SharedPreferences$Editor r0 = r0.putString(r1, r6)
            r0.apply()
            int r0 = r6.hashCode()
            r1 = -1907941713(0xffffffff8e471eaf, float:-2.4543417E-30)
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x003b
            r1 = 2189910(0x216a56, float:3.068718E-39)
            if (r0 == r1) goto L_0x0031
            r1 = 2433880(0x252358, float:3.410592E-39)
            if (r0 == r1) goto L_0x0027
            goto L_0x0045
        L_0x0027:
            java.lang.String r0 = "None"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0045
            r6 = 2
            goto L_0x0046
        L_0x0031:
            java.lang.String r0 = "Fire"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0045
            r6 = 0
            goto L_0x0046
        L_0x003b:
            java.lang.String r0 = "People"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0045
            r6 = 1
            goto L_0x0046
        L_0x0045:
            r6 = -1
        L_0x0046:
            r0 = 0
            if (r6 == 0) goto L_0x005a
            if (r6 == r2) goto L_0x004d
            r6 = r0
            goto L_0x0066
        L_0x004d:
            r6 = 26
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r6 = 41
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0066
        L_0x005a:
            r6 = 65
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r6 = 538(0x21a, float:7.54E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
        L_0x0066:
            if (r0 == 0) goto L_0x00b0
            if (r6 == 0) goto L_0x00b0
            int r1 = r5.minTemp
            r5.updateLowTemp(r1)
            int r1 = r5.maxTemp
            r5.updateHighTemp(r1)
            int r0 = r0.intValue()
            int r1 = r5.minTemp
            int r0 = java.lang.Math.max(r0, r1)
            int r6 = r6.intValue()
            int r1 = r5.maxTemp
            int r6 = java.lang.Math.min(r6, r1)
            android.widget.RelativeLayout r1 = r5.tempsLayout
            r5.enableTemps(r1, r3)
            android.widget.CheckBox r1 = r5.enableCheck
            r1.setEnabled(r3)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$10 r2 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$10
            r2.<init>(r0)
            r3 = 1000(0x3e8, double:4.94E-321)
            r1.postDelayed(r2, r3)
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            com.atakmap.android.uastool.dji.DJIThermalTempsLayout$11 r1 = new com.atakmap.android.uastool.dji.DJIThermalTempsLayout$11
            r1.<init>(r6)
            r2 = 2000(0x7d0, double:9.88E-321)
            r0.postDelayed(r1, r2)
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJIThermalTempsLayout.setPreset(java.lang.String):void");
    }

    private float convertTempDisplay(float f) {
        return this.tempUnitsLabel.equals(TEMP_UNITS_FAHRENHEIT) ? Float.parseFloat(oneDecimalFormat.format((double) ((f * 1.8f) + 32.0f))) : f;
    }
}
