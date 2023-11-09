package com.atakmap.android.uastool.evo;

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
import com.atakmap.android.gui.PluginSpinner;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ButtonBar;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public class EvoOpButtonBar extends ButtonBar {
    public static final String TAG = "EvoOpButtonBar";
    /* access modifiers changed from: private */
    public VideoUIButton switchCameraButton;
    /* access modifiers changed from: private */
    public VideoUIButton thermalButton;

    public EvoOpButtonBar(Context context) {
        super(context);
    }

    public EvoOpButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EvoOpButtonBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_evo_switchcamera);
        this.switchCameraButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EvoOpButtonBar.this.switchCamera();
            }
        });
        C14772 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                View inflate = LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.evo_palette_selector, (ViewGroup) null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                builder.setView(inflate);
                final PluginSpinner findViewById = inflate.findViewById(C1877R.C1878id.evo_palette_spinner);
                EvoOpButtonBar.this.populateIrModes(findViewById, SoloControllerUnits.UNKNOWN);
                builder.setTitle("Change Mode:");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EvoOpButtonBar.this.switchThermal(((TextView) findViewById.getSelectedView()).getText().toString());
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
        };
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.bottom_op_evo_thermal);
        this.thermalButton = videoUIButton2;
        videoUIButton2.setOnClickListener(r0);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.switchCameraButton.init();
        this.thermalButton.init();
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
    }

    public void onAccessoryChange() {
        updateButtons();
    }

    private void updateButtons() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                if (EvoOpButtonBar.this.getNumCameras() > 1) {
                    EvoOpButtonBar.this.switchCameraButton.setVisibility(0);
                    EvoOpButtonBar.this.thermalButton.setVisibility(0);
                } else {
                    EvoOpButtonBar.this.switchCameraButton.setVisibility(8);
                    EvoOpButtonBar.this.thermalButton.setVisibility(8);
                }
                EvoOpButtonBar.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: private */
    public int getNumCameras() {
        try {
            return EvoMonitor.getNumCameras();
        } catch (Exception e) {
            toast("Failed to get number of cameras: " + e.getLocalizedMessage());
            Log.e(TAG, "Failed to get number of cameras: ", e);
            return 2;
        }
    }

    /* access modifiers changed from: private */
    public void switchCamera() {
        try {
            EvoMonitor.switchToNextCamera();
        } catch (Exception e) {
            toast("Failed to switch cameras: " + e.getLocalizedMessage());
            Log.e(TAG, "Failed to switch cameras: ", e);
        }
    }

    /* access modifiers changed from: private */
    public void switchThermal(String str) {
        try {
            EvoMonitor.actionCustom(EvoMonitor.ACTION_IR_PALETTE, str);
        } catch (Exception e) {
            toast("Failed to switch Thermal Mode: " + e.getLocalizedMessage());
            Log.e(TAG, "Failed to switch Thermal Mode: ", e);
        }
    }

    /* access modifiers changed from: private */
    public void populateIrModes(PluginSpinner pluginSpinner, String str) {
        String[] strArr = {"WhiteHot", "BlackHot", "RainBow", "RaingHC", "IronBow", "Lava", "Arctic", "GlowBow", "GradedFire", "HotTest"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(UASToolDropDownReceiver.getInstance().getPluginContext(), C1877R.layout.spinner_text_white_view, strArr);
        arrayAdapter.setDropDownViewResource(17367049);
        pluginSpinner.setAdapter(arrayAdapter);
        if (str != null) {
            for (int i = 0; i < 10; i++) {
                if (str.equals(strArr[i])) {
                    pluginSpinner.setSelection(i);
                }
            }
        }
        if (str != null) {
            for (int i2 = 0; i2 < 10; i2++) {
                if (str.equals(strArr[i2])) {
                    pluginSpinner.setSelection(i2);
                }
            }
        }
    }
}
