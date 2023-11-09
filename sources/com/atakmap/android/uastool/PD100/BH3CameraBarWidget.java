package com.atakmap.android.uastool.PD100;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.PD100.PD100Monitor;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.coremap.log.Log;

public class BH3CameraBarWidget extends PopupWidget {
    public static final String TAG = "BH3CameraBarWidget";
    public VideoUIButton eoButton;
    public VideoUIButton gcsButton;
    public VideoUIButton irButton;

    public BH3CameraBarWidget(Context context) {
        super(context);
    }

    public BH3CameraBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BH3CameraBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eoButton = (VideoUIButton) findViewById(C1877R.C1878id.bh3_camera_eo_button);
        this.irButton = (VideoUIButton) findViewById(C1877R.C1878id.bh3_camera_ir_button);
        this.gcsButton = (VideoUIButton) findViewById(C1877R.C1878id.bh3_camera_gcs_button);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                BH3CameraBarWidget bH3CameraBarWidget = BH3CameraBarWidget.this;
                bH3CameraBarWidget.setupCameraButton(bH3CameraBarWidget.eoButton, "eo");
                BH3CameraBarWidget bH3CameraBarWidget2 = BH3CameraBarWidget.this;
                bH3CameraBarWidget2.setupCameraButton(bH3CameraBarWidget2.irButton, "ir");
                BH3CameraBarWidget bH3CameraBarWidget3 = BH3CameraBarWidget.this;
                bH3CameraBarWidget3.setupCameraButton(bH3CameraBarWidget3.gcsButton, "gcs");
                BH3CameraBarWidget.this.setEOPayloadVisibility();
                BH3CameraBarWidget.this.setIRPayloadVisibility();
                BH3CameraBarWidget.this.setGCSPayloadVisibility();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setupCameraButton(VideoUIButton videoUIButton, final String str) {
        videoUIButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                String str = BH3CameraBarWidget.TAG;
                Log.d(str, "setupCameraButton.ACTION_UP " + str);
                UASToolDropDownReceiver.toast(str + " selected", 0);
                PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
                if (platformMonitor != null && (platformMonitor instanceof PD100Monitor)) {
                    PD100Monitor pD100Monitor = (PD100Monitor) platformMonitor;
                    String str2 = str;
                    if (str2 != null) {
                        str2.hashCode();
                        char c = 65535;
                        switch (str2.hashCode()) {
                            case 3242:
                                if (str2.equals("eo")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 3369:
                                if (str2.equals("ir")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 102167:
                                if (str2.equals("gcs")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                pD100Monitor.setActiveCamera(PD100Monitor.BH3CameraType.EO);
                                break;
                            case 1:
                                pD100Monitor.setActiveCamera(PD100Monitor.BH3CameraType.IR);
                                break;
                            case 2:
                                pD100Monitor.setActiveCamera(PD100Monitor.BH3CameraType.GCS);
                                break;
                        }
                    }
                }
                view.setPressed(false);
                BH3CameraBarWidget.this.updateButtons();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void setEOPayloadVisibility() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor != null && (platformMonitor instanceof PD100Monitor)) {
            PD100Monitor pD100Monitor = (PD100Monitor) platformMonitor;
            boolean z = false;
            if (pD100Monitor.isEOStreamAvailable()) {
                this.eoButton.setEnabled(true);
                VideoUIButton videoUIButton = this.eoButton;
                if (pD100Monitor.getActiveCamera() == PD100Monitor.BH3CameraType.EO) {
                    z = true;
                }
                videoUIButton.setOn(z);
                return;
            }
            this.eoButton.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public void setIRPayloadVisibility() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor != null && (platformMonitor instanceof PD100Monitor)) {
            PD100Monitor pD100Monitor = (PD100Monitor) platformMonitor;
            boolean z = false;
            if (pD100Monitor.isIRStreamAvailable()) {
                this.irButton.setEnabled(true);
                VideoUIButton videoUIButton = this.irButton;
                if (pD100Monitor.getActiveCamera() == PD100Monitor.BH3CameraType.IR) {
                    z = true;
                }
                videoUIButton.setOn(z);
                return;
            }
            this.irButton.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public void setGCSPayloadVisibility() {
        PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
        if (platformMonitor != null && (platformMonitor instanceof PD100Monitor)) {
            PD100Monitor pD100Monitor = (PD100Monitor) platformMonitor;
            boolean z = false;
            if (pD100Monitor.isGCSStreamAvailable()) {
                this.gcsButton.setEnabled(true);
                VideoUIButton videoUIButton = this.gcsButton;
                if (pD100Monitor.getActiveCamera() == PD100Monitor.BH3CameraType.GCS) {
                    z = true;
                }
                videoUIButton.setOn(z);
                return;
            }
            this.gcsButton.setEnabled(false);
        }
    }

    public void onAccessoryChange() {
        updateButtons();
    }
}
