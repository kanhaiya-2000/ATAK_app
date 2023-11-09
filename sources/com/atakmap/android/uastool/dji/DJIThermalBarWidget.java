package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;

public class DJIThermalBarWidget extends PopupWidget {
    public static final String TAG = "DJIThermalBarWidget";
    /* access modifiers changed from: private */
    public VideoUIButton settingsButton;
    /* access modifiers changed from: private */
    public VideoUIButton tempsButton;
    /* access modifiers changed from: private */
    public VideoUIButton toggleButton;

    public DJIThermalBarWidget(Context context) {
        super(context);
    }

    public DJIThermalBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJIThermalBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.dji_thermal_toggle_button);
        this.toggleButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIThermalBarWidget.this.toggleThermal();
            }
        });
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.dji_thermal_settings_button);
        this.settingsButton = videoUIButton2;
        videoUIButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIThermalBarWidget.this.showSettings();
            }
        });
        VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.dji_thermal_temps_button);
        this.tempsButton = videoUIButton3;
        videoUIButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIThermalBarWidget.this.changeTemps();
            }
        });
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void onAccessoryChange() {
        updateButtons();
        if (!hasThermalCamera()) {
            setVisibility(8);
            hidePopup();
        }
    }

    private void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (DJIThermalBarWidget.hasThermalCamera()) {
                    DJIThermalBarWidget.this.toggleButton.setEnabled(true);
                    DJIThermalBarWidget.this.settingsButton.setEnabled(true);
                    DJIThermalBarWidget.this.tempsButton.setEnabled(true);
                    return;
                }
                DJIThermalBarWidget.this.toggleButton.setEnabled(false);
                DJIThermalBarWidget.this.settingsButton.setEnabled(false);
                DJIThermalBarWidget.this.tempsButton.setEnabled(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void toggleThermal() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.toggleThermal();
        }
    }

    /* access modifiers changed from: private */
    public void showSettings() {
        DJIThermalSettingsLayout dJIThermalSettingsLayout = (DJIThermalSettingsLayout) LayoutInflater.from(getContext()).inflate(C1877R.layout.video_ui_dji_thermal_settings, (ViewGroup) null);
        dJIThermalSettingsLayout.init(this.videoUIView, this.uasItem);
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setCancelable(true);
        builder.setView(dJIThermalSettingsLayout);
        AlertDialog create = builder.create();
        create.getWindow().setGravity(85);
        create.show();
    }

    /* access modifiers changed from: private */
    public void changeTemps() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setCancelable(true);
        builder.setView((DJIThermalTempsLayout) LayoutInflater.from(getContext()).inflate(C1877R.layout.video_ui_dji_thermal_temps, (ViewGroup) null));
        AlertDialog create = builder.create();
        create.getWindow().setGravity(85);
        create.show();
    }

    public static boolean hasThermalCamera() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.hasThermalCamera();
        }
        return false;
    }
}
