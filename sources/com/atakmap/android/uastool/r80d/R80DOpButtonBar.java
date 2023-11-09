package com.atakmap.android.uastool.r80d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.aeryon.java.types.Aircraft;
import com.aeryon.java.types.LwirPalette;
import com.aeryon.java.types.SensorType;
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ButtonBar;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;

public class R80DOpButtonBar extends ButtonBar {
    public static final String TAG = "R80DOpButtonBar";
    private VideoUIButton authButton;
    private VideoUIButton cameraButton;
    public VideoUIButton navButton;
    /* access modifiers changed from: private */
    public VideoUIButton ospreyButton;
    public VideoUIButton payloadButton;
    private VideoUIButton thermalButton;

    public R80DOpButtonBar(Context context) {
        super(context);
    }

    public R80DOpButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public R80DOpButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_r80d_camera);
        this.cameraButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80DOpButtonBar.this.toggleCameraBar();
            }
        });
        this.ospreyButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_r80d_osprey);
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_r80d_thermal);
        this.thermalButton = videoUIButton2;
        videoUIButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    R80dUASItem r80dUASItem = (R80dUASItem) R80DOpButtonBar.this.uasItem;
                    if (r80dUASItem.currentCameraStream == null || !r80dUASItem.currentCameraStream.getUrl().contains("front")) {
                        R80DOpButtonBar.this.toggleThermalBar();
                    } else {
                        R80DOpButtonBar.this.toggleFrontCameraBar();
                    }
                } catch (Exception unused) {
                    UASToolDropDownReceiver.toast("Camera does not support palette");
                }
            }
        });
        VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_r80d_auth);
        this.authButton = videoUIButton3;
        videoUIButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                R80DOpButtonBar.this.toggleAuthBar();
            }
        });
        VideoUIButton videoUIButton4 = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_auth_nav_button);
        this.navButton = videoUIButton4;
        videoUIButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    R80dUASItem r80dUASItem = (R80dUASItem) R80DOpButtonBar.this.uasItem;
                    if (r80dUASItem.isNavAuthorized()) {
                        r80dUASItem.releaseNavigationControl();
                    } else {
                        r80dUASItem.requestNavigationControl();
                    }
                } catch (Exception unused) {
                    UASToolDropDownReceiver.toast("Camera does not support palette");
                }
            }
        });
        VideoUIButton videoUIButton5 = (VideoUIButton) findViewById(C1877R.C1878id.r80d_camera_auth_payload_button);
        this.payloadButton = videoUIButton5;
        videoUIButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    R80dUASItem r80dUASItem = (R80dUASItem) R80DOpButtonBar.this.uasItem;
                    if (r80dUASItem.isPayloadAuthorized()) {
                        r80dUASItem.releaseCameraControl();
                    } else {
                        r80dUASItem.requestCameraControl();
                    }
                } catch (Exception unused) {
                    UASToolDropDownReceiver.toast("Camera does not support palette");
                }
            }
        });
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.cameraButton.init();
        this.ospreyButton.init();
        this.thermalButton.init();
        this.ospreyButton.setOnTouchListener(new R80dPayloadOnTouchListener(uASItem));
        this.navButton.init();
        this.payloadButton.init();
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    public void updateOSD() {
        super.updateOSD();
    }

    public void onAccessoryChange() {
        updateButtons();
    }

    private void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                Aircraft connection = ((R80dUASItem) R80DOpButtonBar.this.uasItem).getConnection();
                if (connection != null) {
                    if (connection.hasOfsprey()) {
                        R80DOpButtonBar.this.ospreyButton.setVisibility(0);
                    } else {
                        R80DOpButtonBar.this.ospreyButton.setVisibility(8);
                    }
                    if (connection.isNavAuthorized()) {
                        R80DOpButtonBar.this.navButton.setOn(true);
                    } else if (((R80dUASItem) R80DOpButtonBar.this.uasItem).navControlPending) {
                        R80DOpButtonBar.this.navButton.setPending(true);
                    } else {
                        R80DOpButtonBar.this.navButton.setOn(false);
                    }
                    if (connection.isPayloadAuthorized()) {
                        R80DOpButtonBar.this.payloadButton.setOn(true);
                    } else if (((R80dUASItem) R80DOpButtonBar.this.uasItem).cameraControlPending) {
                        R80DOpButtonBar.this.payloadButton.setPending(true);
                    } else {
                        R80DOpButtonBar.this.payloadButton.setOn(false);
                    }
                    R80DOpButtonBar.this.invalidate();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void toggleAuthBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_r80d_authbar));
    }

    /* access modifiers changed from: private */
    public void toggleCameraBar() {
        this.videoUIView.toggleSideBar(Integer.valueOf(C1877R.layout.video_ui_r80d_camerabar));
    }

    /* access modifiers changed from: private */
    public void toggleThermalBar() {
        View inflate = LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.evo_palette_selector, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setView(inflate);
        final PluginSpinner findViewById = inflate.findViewById(C1877R.C1878id.evo_palette_spinner);
        String lwirPalette = LwirPalette.Unknown.toString();
        if (this.uasItem instanceof R80dUASItem) {
            LwirPalette irMode = ((R80dUASItem) this.uasItem).getIrMode();
            if (irMode == null || irMode == LwirPalette.Unknown) {
                UASToolDropDownReceiver.toast("Palette not supported");
                return;
            }
            lwirPalette = irMode.toString();
        }
        populateIrModes(findViewById, lwirPalette);
        builder.setTitle("Change Mode:");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                R80DOpButtonBar.this.switchThermal(((TextView) findViewById.getSelectedView()).getText().toString());
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void toggleFrontCameraBar() {
        View inflate = LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.evo_palette_selector, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        builder.setView(inflate);
        final PluginSpinner findViewById = inflate.findViewById(C1877R.C1878id.evo_palette_spinner);
        populateFrontModes(findViewById, ((R80dUASItem) this.uasItem).getSensorType().toString());
        builder.setTitle("Change Mode:");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                R80DOpButtonBar.this.switchFrontMode(((TextView) findViewById.getSelectedView()).getText().toString());
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void switchThermal(String str) {
        if (this.uasItem instanceof R80dUASItem) {
            ((R80dUASItem) this.uasItem).setIrMode(str);
        }
    }

    /* access modifiers changed from: private */
    public void switchFrontMode(String str) {
        if (this.uasItem instanceof R80dUASItem) {
            ((R80dUASItem) this.uasItem).setSensorType(str);
        }
    }

    private void populateIrModes(PluginSpinner pluginSpinner, String str) {
        String[] names = LwirPalette.getNames();
        ArrayAdapter arrayAdapter = new ArrayAdapter(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, names);
        arrayAdapter.setDropDownViewResource(17367049);
        pluginSpinner.setAdapter(arrayAdapter);
        if (str != null) {
            for (int i = 0; i < names.length; i++) {
                if (str.equals(names[i])) {
                    pluginSpinner.setSelection(i);
                }
            }
        }
    }

    private void populateFrontModes(PluginSpinner pluginSpinner, String str) {
        String[] names = SensorType.getNames();
        ArrayAdapter arrayAdapter = new ArrayAdapter(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, names);
        arrayAdapter.setDropDownViewResource(17367049);
        pluginSpinner.setAdapter(arrayAdapter);
        if (str != null) {
            for (int i = 0; i < names.length; i++) {
                if (str.equals(names[i])) {
                    pluginSpinner.setSelection(i);
                }
            }
        }
    }
}
