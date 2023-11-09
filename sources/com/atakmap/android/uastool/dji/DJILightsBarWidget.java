package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;

public class DJILightsBarWidget extends PopupWidget {
    public static final Integer BRIGHT_DEFAULT = 50;
    public static final Integer BRIGHT_MAX = 100;
    public static final Integer BRIGHT_MIN = 1;
    public static final String TAG = DJILightsBarWidget.class.getSimpleName();
    /* access modifiers changed from: private */
    public VideoUIButton auxBottomButton;
    /* access modifiers changed from: private */
    public VideoUIButton auxTopButton;
    /* access modifiers changed from: private */
    public VideoUIButton brightnessButton;
    /* access modifiers changed from: private */
    public VideoUIButton ledsButton;
    /* access modifiers changed from: private */
    public VideoUIButton spotlightButton;

    public static boolean hasLEDs() {
        return true;
    }

    public DJILightsBarWidget(Context context) {
        super(context);
    }

    public DJILightsBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJILightsBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.dji_lights_leds_button);
        this.ledsButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJILightsBarWidget.this.toggleLEDs();
            }
        });
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.dji_lights_spotlight_button);
        this.spotlightButton = videoUIButton2;
        videoUIButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJILightsBarWidget.this.toggleLight();
            }
        });
        VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.dji_lights_brightness_button);
        this.brightnessButton = videoUIButton3;
        videoUIButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJILightsBarWidget.this.adjustSpotlightBrightness();
            }
        });
        VideoUIButton videoUIButton4 = (VideoUIButton) findViewById(C1877R.C1878id.dji_lights_auxtop_button);
        this.auxTopButton = videoUIButton4;
        videoUIButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJILightsBarWidget.this.toggleAuxLightTop();
            }
        });
        VideoUIButton videoUIButton5 = (VideoUIButton) findViewById(C1877R.C1878id.dji_lights_auxbottom_button);
        this.auxBottomButton = videoUIButton5;
        videoUIButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJILightsBarWidget.this.toggleAuxLightBottom();
            }
        });
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void onAccessoryChange() {
        updateButtons();
        if (!hasBeacon()) {
            hasSpotlight();
        }
    }

    private void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (DJILightsBarWidget.hasLEDs()) {
                    DJILightsBarWidget.this.ledsButton.setVisibility(0);
                } else {
                    DJILightsBarWidget.this.ledsButton.setVisibility(8);
                }
                if (DJILightsBarWidget.hasSpotlight() || DJILightsBarWidget.hasBeacon()) {
                    DJILightsBarWidget.this.spotlightButton.setVisibility(0);
                } else {
                    DJILightsBarWidget.this.spotlightButton.setVisibility(8);
                }
                if (DJILightsBarWidget.hasSpotlight()) {
                    DJILightsBarWidget.this.brightnessButton.setVisibility(0);
                } else {
                    DJILightsBarWidget.this.brightnessButton.setVisibility(8);
                }
                if (DJILightsBarWidget.hasAuxLightTop()) {
                    DJILightsBarWidget.this.auxTopButton.setVisibility(0);
                } else {
                    DJILightsBarWidget.this.auxTopButton.setVisibility(8);
                }
                if (DJILightsBarWidget.hasAuxLightBottom()) {
                    DJILightsBarWidget.this.auxBottomButton.setVisibility(0);
                } else {
                    DJILightsBarWidget.this.auxBottomButton.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void toggleLEDs() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.toggleLEDs();
        }
    }

    /* access modifiers changed from: private */
    public void toggleLight() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.toggleLight();
        }
    }

    /* access modifiers changed from: private */
    public void adjustSpotlightBrightness() {
        int intValue = BRIGHT_DEFAULT.intValue();
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        SeekBar seekBar = new SeekBar(MapView.getMapView().getContext());
        seekBar.setMax(BRIGHT_MAX.intValue());
        seekBar.setProgress(intValue);
        builder.setMessage("Spotlight brightness: " + intValue);
        builder.setCancelable(true);
        builder.setView(seekBar);
        final AlertDialog create = builder.create();
        create.getWindow().setGravity(85);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                int access$1000 = DJILightsBarWidget.this.limitBrightness(seekBar.getProgress());
                AlertDialog alertDialog = create;
                alertDialog.setMessage("Spotlight brightness: " + access$1000);
                DJILightsBarWidget.this.setBrightness(access$1000);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                DJILightsBarWidget.this.setBrightness(DJILightsBarWidget.this.limitBrightness(seekBar.getProgress()));
            }
        });
        create.show();
    }

    /* access modifiers changed from: private */
    public int limitBrightness(int i) {
        Integer num = BRIGHT_MIN;
        if (i < num.intValue()) {
            return num.intValue();
        }
        Integer num2 = BRIGHT_MAX;
        return i > num2.intValue() ? num2.intValue() : i;
    }

    /* access modifiers changed from: private */
    public void setBrightness(int i) {
        int limitBrightness = limitBrightness(i);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.spotlightBrightness(limitBrightness);
        }
    }

    /* access modifiers changed from: private */
    public void toggleAuxLightTop() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.toggleAuxLightTop();
        }
    }

    /* access modifiers changed from: private */
    public void toggleAuxLightBottom() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.toggleAuxLightBottom();
        }
    }

    public static boolean hasLight() {
        return hasLightAccessory() || hasLEDs() || hasAuxLightTop() || hasAuxLightBottom();
    }

    public static boolean hasLightAccessory() {
        return hasSpotlight() || hasBeacon();
    }

    public static boolean hasSpotlight() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.hasSpotlight();
        }
        return false;
    }

    public static boolean hasBeacon() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.hasBeacon();
        }
        return false;
    }

    public static boolean hasAuxLightTop() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.hasAuxLightTop();
        }
        return false;
    }

    public static boolean hasAuxLightBottom() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.hasAuxLightBottom();
        }
        return false;
    }
}
