package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ButtonBar;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.operator.OperatorUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;

public class DJIOpButtonBar extends ButtonBar {
    public static final String TAG = "DJIOpButtonBar";
    /* access modifiers changed from: private */
    public VideoUIButton lightsButton;
    /* access modifiers changed from: private */
    public VideoUIButton speakerButton;
    /* access modifiers changed from: private */
    public VideoUIButton switchCameraButton;
    /* access modifiers changed from: private */
    public VideoUIButton thermalButton;
    /* access modifiers changed from: private */
    public VideoUIButton triggersButton;

    public DJIOpButtonBar(Context context) {
        super(context);
    }

    public DJIOpButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DJIOpButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_dji_switchcamera);
        this.switchCameraButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIOpButtonBar.this.switchCamera();
            }
        });
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_dji_thermal);
        this.thermalButton = videoUIButton2;
        videoUIButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIOpButtonBar.this.toggleThermalBar();
            }
        });
        VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_dji_op_lights);
        this.lightsButton = videoUIButton3;
        videoUIButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIOpButtonBar.this.toggleLightsBar();
            }
        });
        VideoUIButton videoUIButton4 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_dji_op_speaker);
        this.speakerButton = videoUIButton4;
        videoUIButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIOpButtonBar.this.toggleSpeakerBar();
            }
        });
        VideoUIButton videoUIButton5 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_dji_op_triggers);
        this.triggersButton = videoUIButton5;
        videoUIButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DJIOpButtonBar.this.toggleTriggersBar();
            }
        });
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.switchCameraButton.init();
        this.thermalButton.init();
        this.lightsButton.init();
        this.speakerButton.init();
        this.triggersButton.init();
        super.init(videoUIView, uASItem);
        updateButtons();
        if (DJIThermalSettingsLayout.isMetering()) {
            DJIThermalSettingsLayout.turnOnMetering();
            this.videoUIView.startThermalMetering();
        }
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                String sideBarName = ((OperatorUIView) DJIOpButtonBar.this.videoUIView).getSideBarName();
                if (sideBarName != null) {
                    sideBarName.hashCode();
                    char c = 65535;
                    switch (sideBarName.hashCode()) {
                        case -890818301:
                            if (sideBarName.equals(DJIThermalBarWidget.TAG)) {
                                c = 0;
                                break;
                            }
                            break;
                        case -547005029:
                            if (sideBarName.equals("DJISpeakerBarWidget")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 905487255:
                            if (sideBarName.equals("DJILightsBarWidget")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 2001704569:
                            if (sideBarName.equals(DJITriggersBarWidget.TAG)) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            ((OperatorUIView) DJIOpButtonBar.this.videoUIView).setSideBarName((String) null);
                            DJIOpButtonBar.this.toggleThermalBar();
                            break;
                        case 1:
                            ((OperatorUIView) DJIOpButtonBar.this.videoUIView).setSideBarName((String) null);
                            DJIOpButtonBar.this.toggleSpeakerBar();
                            break;
                        case 2:
                            ((OperatorUIView) DJIOpButtonBar.this.videoUIView).setSideBarName((String) null);
                            DJIOpButtonBar.this.toggleLightsBar();
                            break;
                        case 3:
                            ((OperatorUIView) DJIOpButtonBar.this.videoUIView).setSideBarName((String) null);
                            DJIOpButtonBar.this.toggleTriggersBar();
                            break;
                    }
                }
                DJIOpButtonBar.this.invalidate();
            }
        });
    }

    public void onAccessoryChange() {
        updateButtons();
    }

    private void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (!DJIOpButtonBar.this.uasItem.getModelName().toUpperCase().contains("MATRICE") && !DJIOpButtonBar.this.uasItem.getModelName().toUpperCase().contains("INSPIRE_2")) {
                    DJIOpButtonBar.this.switchCameraButton.setVisibility(8);
                } else if (DJIOpButtonBar.this.getNumCameras() > 1) {
                    DJIOpButtonBar.this.switchCameraButton.setVisibility(0);
                } else {
                    DJIOpButtonBar.this.switchCameraButton.setVisibility(8);
                }
                if (DJIThermalBarWidget.hasThermalCamera()) {
                    DJIOpButtonBar.this.thermalButton.setVisibility(0);
                } else {
                    DJIOpButtonBar.this.thermalButton.setVisibility(8);
                }
                if (DJILightsBarWidget.hasLight()) {
                    DJIOpButtonBar.this.lightsButton.setVisibility(0);
                } else {
                    DJIOpButtonBar.this.lightsButton.setVisibility(8);
                }
                if (DJISpeakerBarWidget.hasSpeaker()) {
                    DJIOpButtonBar.this.speakerButton.setVisibility(0);
                } else {
                    DJIOpButtonBar.this.speakerButton.setVisibility(8);
                }
                if (DJITriggersBarWidget.hasTriggers()) {
                    DJIOpButtonBar.this.triggersButton.setVisibility(0);
                } else {
                    DJIOpButtonBar.this.triggersButton.setVisibility(8);
                }
                DJIOpButtonBar.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: private */
    public int getNumCameras() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection == null) {
            return 0;
        }
        try {
            return serviceConnection.getService().getNumCameras();
        } catch (Exception e) {
            toast("Failed to get number of cameras: " + e.getLocalizedMessage());
            Log.e(TAG, "Failed to get number of cameras: ", e);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void switchCamera() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            try {
                serviceConnection.getService().switchToNextCamera();
            } catch (Exception e) {
                toast("Failed to switch cameras: " + e.getLocalizedMessage());
                Log.e(TAG, "Failed to switch cameras: ", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void toggleThermalBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_dji_thermalbar));
    }

    /* access modifiers changed from: private */
    public void toggleLightsBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_dji_lightsbar));
    }

    /* access modifiers changed from: private */
    public void toggleSpeakerBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_dji_speakerbar));
    }

    /* access modifiers changed from: private */
    public void toggleTriggersBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_dji_triggersbar));
    }
}
