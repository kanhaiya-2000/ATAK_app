package com.atakmap.android.uastool.trillium;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.trillium.TrilliumUASItem;
import com.atakmap.coremap.log.Log;
import com.trilliumeng.android.orion.sdk.OrionSdk;

public class TrilliumCameraBarWidget extends PopupWidget implements View.OnTouchListener {
    public static final String TAG = "TrilliumCameraBarWidget";
    public VideoUIButton eoButton;
    public VideoUIButton geoButton;
    public VideoUIButton homeButton;
    public VideoUIButton irButton;
    public VideoUIButton scnButton;
    public VideoUIButton stowButton;

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        view.setPressed(false);
        try {
            OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
            if (orionSdk != null) {
                if (view == this.homeButton) {
                    orionSdk.commandGimbalHome();
                } else if (view == this.stowButton) {
                    orionSdk.commandGimbalStow();
                } else if (view == this.scnButton) {
                    orionSdk.commandGimbal(TrilliumUASItem.OrionMode.ORION_MODE_SCENE.value, 0.0f, 0.0f, true, 0.0f);
                } else if (view != this.geoButton) {
                    UASToolDropDownReceiver.toast("Unknown button selected");
                } else if (!orionSdk.geoPointAtCurrentImgPos()) {
                    UASToolDropDownReceiver.toast("Geopoint not commanded: IMG Pos unknown.");
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to execute button: ", e);
        }
        return true;
    }

    enum CameraButtonTypes {
        EO(0),
        IR(1);
        
        int value;

        private CameraButtonTypes(int i) {
            this.value = i;
        }
    }

    public TrilliumCameraBarWidget(Context context) {
        super(context);
    }

    public TrilliumCameraBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TrilliumCameraBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eoButton = (VideoUIButton) findViewById(C1877R.C1878id.trillium_camera_eo_button);
        this.irButton = (VideoUIButton) findViewById(C1877R.C1878id.trillium_camera_ir_button);
        this.homeButton = (VideoUIButton) findViewById(C1877R.C1878id.trillium_camera_my_home_button);
        this.stowButton = (VideoUIButton) findViewById(C1877R.C1878id.trillium_camera_my_stow_button);
        this.scnButton = (VideoUIButton) findViewById(C1877R.C1878id.trillium_camera_my_scn_button);
        this.geoButton = (VideoUIButton) findViewById(C1877R.C1878id.trillium_camera_my_geo_button);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                TrilliumCameraBarWidget trilliumCameraBarWidget = TrilliumCameraBarWidget.this;
                trilliumCameraBarWidget.setupCameraButton(trilliumCameraBarWidget.eoButton, CameraButtonTypes.EO);
                TrilliumCameraBarWidget trilliumCameraBarWidget2 = TrilliumCameraBarWidget.this;
                trilliumCameraBarWidget2.setupCameraButton(trilliumCameraBarWidget2.irButton, CameraButtonTypes.IR);
                TrilliumCameraBarWidget.this.homeButton.setOnTouchListener(TrilliumCameraBarWidget.this);
                TrilliumCameraBarWidget.this.stowButton.setOnTouchListener(TrilliumCameraBarWidget.this);
                TrilliumCameraBarWidget.this.scnButton.setOnTouchListener(TrilliumCameraBarWidget.this);
                TrilliumCameraBarWidget.this.geoButton.setOnTouchListener(TrilliumCameraBarWidget.this);
                TrilliumUASItem trilliumUASItem = null;
                try {
                    if (TrilliumCameraBarWidget.this.uasItem instanceof TrilliumUASItem) {
                        trilliumUASItem = (TrilliumUASItem) TrilliumCameraBarWidget.this.uasItem;
                    }
                    if (trilliumUASItem != null) {
                        boolean z = true;
                        TrilliumCameraBarWidget.this.scnButton.setOn(trilliumUASItem.getCurrentGimbalMode() == TrilliumUASItem.OrionMode.ORION_MODE_SCENE);
                        VideoUIButton videoUIButton = TrilliumCameraBarWidget.this.geoButton;
                        if (trilliumUASItem.getCurrentGimbalMode() != TrilliumUASItem.OrionMode.ORION_MODE_GEOPOINT) {
                            z = false;
                        }
                        videoUIButton.setOn(z);
                    }
                } catch (Exception e) {
                    Log.d(TrilliumCameraBarWidget.TAG, "Failed to set gimbal mode button state: ", e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setupCameraButton(VideoUIButton videoUIButton, final CameraButtonTypes cameraButtonTypes) {
        videoUIButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                UASToolDropDownReceiver.toast(cameraButtonTypes.toString() + " selected", 0);
                try {
                    UASToolDropDownReceiver.getInstance().setPreviewEnabled(false);
                    OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
                    if (orionSdk != null) {
                        orionSdk.setActiveCamera(cameraButtonTypes.value);
                    }
                    if (view == TrilliumCameraBarWidget.this.eoButton) {
                        TrilliumCameraBarWidget.this.irButton.setPressed(false);
                    } else if (view == TrilliumCameraBarWidget.this.irButton) {
                        TrilliumCameraBarWidget.this.eoButton.setPressed(false);
                    }
                } catch (Exception e) {
                    Log.d(TrilliumCameraBarWidget.TAG, "Failed to execute camera change: ", e);
                }
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        UASToolDropDownReceiver.getInstance().setPreviewEnabled(true);
                    }
                }, 2500);
                return true;
            }
        });
    }

    public void onAccessoryChange() {
        updateButtons();
    }
}
