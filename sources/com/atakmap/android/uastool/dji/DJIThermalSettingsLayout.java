package com.atakmap.android.uastool.dji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import java.util.Arrays;

public class DJIThermalSettingsLayout extends RelativeLayout {
    public static final String PREF_UNITS = "uastool.dji.thermal.units";
    public static final String TAG = "DJIThermalSettingsLayout";
    /* access modifiers changed from: private */
    public static String[] units;
    /* access modifiers changed from: private */
    public String[] gains;
    /* access modifiers changed from: private */
    public Button measureButton;
    /* access modifiers changed from: private */
    public String[] palettes;
    /* access modifiers changed from: private */
    public String[] rois;
    /* access modifiers changed from: private */
    public String[] scenes;
    private UASItem uasItem;
    private VideoUIView videoUIView;

    public DJIThermalSettingsLayout(Context context) {
        super(context);
    }

    public DJIThermalSettingsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJIThermalSettingsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            Context pluginContext = UASToolDropDownReceiver.getInstance().getPluginContext();
            this.palettes = pluginContext.getResources().getStringArray(C1877R.array.dji_thermal_palette_modes);
            String palette = getPalette();
            PluginSpinner findViewById = findViewById(C1877R.C1878id.djithermal_palette_value);
            ArrayAdapter arrayAdapter = new ArrayAdapter(pluginContext, C1877R.layout.spinner_text_white_view, this.palettes);
            arrayAdapter.setDropDownViewResource(17367049);
            findViewById.setAdapter(arrayAdapter);
            findViewById.setSelection(Arrays.asList(this.palettes).indexOf(palette), true);
            findViewById.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    DJIThermalSettingsLayout dJIThermalSettingsLayout = DJIThermalSettingsLayout.this;
                    dJIThermalSettingsLayout.setPalette(dJIThermalSettingsLayout.palettes[i]);
                }
            });
            this.scenes = pluginContext.getResources().getStringArray(C1877R.array.dji_thermal_scene_modes);
            String scene = getScene();
            PluginSpinner findViewById2 = findViewById(C1877R.C1878id.djithermal_scene_value);
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(pluginContext, C1877R.layout.spinner_text_white_view, this.scenes);
            arrayAdapter2.setDropDownViewResource(17367049);
            findViewById2.setAdapter(arrayAdapter2);
            findViewById2.setSelection(Arrays.asList(this.scenes).indexOf(scene), true);
            findViewById2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    DJIThermalSettingsLayout dJIThermalSettingsLayout = DJIThermalSettingsLayout.this;
                    dJIThermalSettingsLayout.setScene(dJIThermalSettingsLayout.scenes[i]);
                }
            });
            this.gains = pluginContext.getResources().getStringArray(C1877R.array.dji_thermal_gain_modes);
            String gain = getGain();
            PluginSpinner findViewById3 = findViewById(C1877R.C1878id.djithermal_gain_value);
            ArrayAdapter arrayAdapter3 = new ArrayAdapter(pluginContext, C1877R.layout.spinner_text_white_view, this.gains);
            arrayAdapter3.setDropDownViewResource(17367049);
            findViewById3.setAdapter(arrayAdapter3);
            findViewById3.setSelection(Arrays.asList(this.gains).indexOf(gain), true);
            findViewById3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    DJIThermalSettingsLayout dJIThermalSettingsLayout = DJIThermalSettingsLayout.this;
                    dJIThermalSettingsLayout.setGain(dJIThermalSettingsLayout.gains[i]);
                }
            });
            this.rois = pluginContext.getResources().getStringArray(C1877R.array.dji_thermal_roi_modes);
            String roi = getROI();
            PluginSpinner findViewById4 = findViewById(C1877R.C1878id.djithermal_roi_value);
            ArrayAdapter arrayAdapter4 = new ArrayAdapter(pluginContext, C1877R.layout.spinner_text_white_view, this.rois);
            arrayAdapter4.setDropDownViewResource(17367049);
            findViewById4.setAdapter(arrayAdapter4);
            findViewById4.setSelection(Arrays.asList(this.rois).indexOf(roi), true);
            findViewById4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    DJIThermalSettingsLayout dJIThermalSettingsLayout = DJIThermalSettingsLayout.this;
                    dJIThermalSettingsLayout.setROI(dJIThermalSettingsLayout.rois[i]);
                }
            });
            Button button = (Button) findViewById(C1877R.C1878id.djithermal_measure_button);
            this.measureButton = button;
            button.setText(getMeteringText(isMetering()));
            this.measureButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Button access$1000 = DJIThermalSettingsLayout.this.measureButton;
                    DJIThermalSettingsLayout dJIThermalSettingsLayout = DJIThermalSettingsLayout.this;
                    access$1000.setText(dJIThermalSettingsLayout.getMeteringText(dJIThermalSettingsLayout.toggleMetering()));
                }
            });
            units = pluginContext.getResources().getStringArray(C1877R.array.dji_thermal_units);
            String units2 = getUnits();
            PluginSpinner findViewById5 = findViewById(C1877R.C1878id.djithermal_units_value);
            ArrayAdapter arrayAdapter5 = new ArrayAdapter(pluginContext, C1877R.layout.spinner_text_white_view, units);
            arrayAdapter5.setDropDownViewResource(17367049);
            findViewById5.setAdapter(arrayAdapter5);
            findViewById5.setSelection(Arrays.asList(units).indexOf(units2), true);
            findViewById5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    DJIThermalSettingsLayout.setUnits(DJIThermalSettingsLayout.units[i]);
                }
            });
            SeekBar seekBar = (SeekBar) findViewById(C1877R.C1878id.djithermal_msx_seek);
            seekBar.setMax(100);
            seekBar.setProgress(getMSXLevel());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        DJIThermalSettingsLayout.this.setMSXLevel(i);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void init(VideoUIView videoUIView2, UASItem uASItem) {
        this.videoUIView = videoUIView2;
        this.uasItem = uASItem;
    }

    private String getPalette() {
        AtakGoServiceConnection serviceConnection;
        String str = this.palettes[0];
        if (isInEditMode() || (serviceConnection = DJIMonitor.getServiceConnection()) == null) {
            return str;
        }
        String thermalPalette = serviceConnection.getThermalPalette();
        return thermalPalette == null ? this.palettes[0] : thermalPalette;
    }

    /* access modifiers changed from: private */
    public void setPalette(String str) {
        AtakGoServiceConnection serviceConnection;
        if (!isInEditMode() && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            serviceConnection.setThermalPalette(str);
        }
    }

    private String getScene() {
        AtakGoServiceConnection serviceConnection;
        String str = this.scenes[0];
        if (isInEditMode() || (serviceConnection = DJIMonitor.getServiceConnection()) == null) {
            return str;
        }
        String thermalScene = serviceConnection.getThermalScene();
        return thermalScene == null ? this.scenes[0] : thermalScene;
    }

    /* access modifiers changed from: private */
    public void setScene(String str) {
        AtakGoServiceConnection serviceConnection;
        if (!isInEditMode() && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            serviceConnection.setThermalScene(str);
        }
    }

    private String getGain() {
        AtakGoServiceConnection serviceConnection;
        String str = this.gains[0];
        if (isInEditMode() || (serviceConnection = DJIMonitor.getServiceConnection()) == null) {
            return str;
        }
        String thermalGain = serviceConnection.getThermalGain();
        return thermalGain == null ? this.gains[0] : thermalGain;
    }

    /* access modifiers changed from: private */
    public void setGain(String str) {
        AtakGoServiceConnection serviceConnection;
        if (!isInEditMode() && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            serviceConnection.setThermalGain(str);
        }
    }

    private String getROI() {
        AtakGoServiceConnection serviceConnection;
        String str = this.rois[0];
        if (isInEditMode() || (serviceConnection = DJIMonitor.getServiceConnection()) == null) {
            return str;
        }
        String thermalROI = serviceConnection.getThermalROI();
        return thermalROI == null ? this.rois[0] : thermalROI;
    }

    /* access modifiers changed from: private */
    public void setROI(String str) {
        AtakGoServiceConnection serviceConnection;
        if (!isInEditMode() && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            serviceConnection.setThermalROI(str);
        }
    }

    public static String getUnits() {
        return UASToolDropDownReceiver.getSharedPrefs().getString(PREF_UNITS, UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getStringArray(C1877R.array.dji_thermal_units)[0]);
    }

    public static void setUnits(String str) {
        UASToolDropDownReceiver.getSharedPrefs().edit().putString(PREF_UNITS, str).apply();
    }

    public static boolean isMetering() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getThermalMetering();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public String getMeteringText(boolean z) {
        if (z) {
            return getContext().getResources().getString(C1877R.string.dji_thermal_measure_on);
        }
        return getContext().getResources().getString(C1877R.string.dji_thermal_measure_off);
    }

    /* access modifiers changed from: private */
    public boolean toggleMetering() {
        AtakGoServiceConnection serviceConnection;
        UASItem uASItem = this.uasItem;
        if (uASItem == null || !uASItem.supportsThermalMetering()) {
            UASToolDropDownReceiver.toast("UAS doesn't support thermal area metering");
        } else if (!isInEditMode() && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            boolean z = serviceConnection.toggleThermalMetering();
            showMetering(z);
            return z;
        }
        return false;
    }

    private void showMetering(boolean z) {
        if (z) {
            this.videoUIView.startThermalMetering();
        } else {
            this.videoUIView.stopThermalMetering();
        }
    }

    private int getMSXLevel() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getMSXLevel();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void setMSXLevel(int i) {
        AtakGoServiceConnection serviceConnection;
        if (!isInEditMode() && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            serviceConnection.setMSXLevel(i);
        }
    }

    public static void turnOnMetering() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.turnOnThermalMetering();
        }
    }
}
