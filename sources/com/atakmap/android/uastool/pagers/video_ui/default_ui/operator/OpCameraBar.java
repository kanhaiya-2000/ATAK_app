package com.atakmap.android.uastool.pagers.video_ui.default_ui.operator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.CameraBarWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.NetworkPreferenceFragment;
import java.text.DecimalFormat;

public class OpCameraBar extends CameraBarWidget {
    public static final String TAG = OpCameraBar.class.getSimpleName();
    public static final DecimalFormat oneDecimalFormat = new DecimalFormat("#.#");
    private VideoUIButton cameraShotButton;
    /* access modifiers changed from: private */
    public VideoUIButton recordButton;
    private VideoUIButton uasVideoMapOverlayButton;
    /* access modifiers changed from: private */
    public VideoUIButton videoDataRateButton;

    public OpCameraBar(Context context) {
        super(context);
    }

    public OpCameraBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OpCameraBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.zoomInButton = (VideoUIButton) findViewById(C1877R.C1878id.camera_op_zoomin_button);
        this.zoomInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OpCameraBar.this.zoomIn();
            }
        });
        this.zoomOutButton = (VideoUIButton) findViewById(C1877R.C1878id.camera_op_zoomout_button);
        this.zoomOutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OpCameraBar.this.zoomOut();
            }
        });
        this.mapShotButton = (VideoUIButton) findViewById(C1877R.C1878id.camera_op_mapshot_button);
        this.mapShotButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OpCameraBar.this.mapShot();
            }
        });
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.camera_op_camerashot_button);
        this.cameraShotButton = videoUIButton;
        videoUIButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OpCameraBar.this.cameraShot();
            }
        });
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.camera_op_record_button);
        this.recordButton = videoUIButton2;
        videoUIButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z = false;
                try {
                    Reflector reflector = UASToolDropDownReceiver.getReflector();
                    if (reflector != null) {
                        z = reflector.isRecording();
                    }
                } catch (Exception unused) {
                }
                OpCameraBar.this.recordButton(!z);
            }
        });
        VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.camera_op_rate_button);
        this.videoDataRateButton = videoUIButton3;
        videoUIButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OpCameraBar.this.adjustVideoDataRate();
            }
        });
        VideoUIButton videoUIButton4 = (VideoUIButton) findViewById(C1877R.C1878id.camera_op_video_map_overlay_button);
        this.uasVideoMapOverlayButton = videoUIButton4;
        videoUIButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OpCameraBar.this.toggleUASVideoMapOverlay();
            }
        });
        if (!isInEditMode()) {
            this.uasVideoMapOverlayButton.setOn(UASToolDropDownReceiver.getInstance().isUASVideoMapOverlayRunning());
        }
    }

    /* access modifiers changed from: private */
    public void recordButton(boolean z) {
        Reflector reflector = UASToolDropDownReceiver.getReflector();
        if (reflector != null) {
            reflector.record(z);
        }
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        this.cameraShotButton.init();
        this.recordButton.init();
        this.videoDataRateButton.init();
        this.uasVideoMapOverlayButton.init();
        super.init(videoUIView, uASItem);
        updateButtons();
    }

    /* access modifiers changed from: private */
    public void zoomIn() {
        this.videoUIView.zoomPlus();
    }

    /* access modifiers changed from: private */
    public void zoomOut() {
        this.videoUIView.zoomMinus();
    }

    /* access modifiers changed from: private */
    public void cameraShot() {
        this.videoUIView.cameraShot();
    }

    public void onAccessoryChange() {
        super.onAccessoryChange();
        updateButtons();
    }

    /* access modifiers changed from: protected */
    public void updateButtons() {
        if (this.uasItem == null || !this.uasItem.supportsCameraShot()) {
            this.cameraShotButton.setVisibility(8);
        } else {
            this.cameraShotButton.setVisibility(0);
        }
        if (this.recordButton != null && UASToolDropDownReceiver.getReflector() != null) {
            final Context pluginContext = UASToolDropDownReceiver.getInstance().getPluginContext();
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (UASToolDropDownReceiver.getInstance() != null && OpCameraBar.this.recordButton != null) {
                        UASToolDropDownReceiver.getReflector().canRecord();
                        if (UASToolDropDownReceiver.getReflector().canRecord()) {
                            boolean isRecording = UASToolDropDownReceiver.getReflector().isRecording();
                            OpCameraBar.this.recordButton.setVisibility(0);
                            if (isRecording) {
                                OpCameraBar.this.recordButton.setImageDrawable(pluginContext.getDrawable(C1877R.drawable.video_ui_camera_recording));
                                OpCameraBar.this.recordButton.setOn(true);
                            } else {
                                OpCameraBar.this.recordButton.setImageDrawable(pluginContext.getDrawable(C1877R.drawable.video_ui_camera_record));
                                OpCameraBar.this.recordButton.setOn(false);
                            }
                        } else {
                            OpCameraBar.this.recordButton.setImageDrawable(pluginContext.getDrawable(C1877R.drawable.video_ui_camera_record));
                            OpCameraBar.this.recordButton.setOn(false);
                            OpCameraBar.this.recordButton.setVisibility(8);
                        }
                        if (OpCameraBar.this.uasItem == null || !OpCameraBar.this.uasItem.supportsVideoDataRate()) {
                            OpCameraBar.this.videoDataRateButton.setVisibility(8);
                        } else {
                            OpCameraBar.this.videoDataRateButton.setVisibility(0);
                        }
                        OpCameraBar.this.invalidate();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void adjustVideoDataRate() {
        if (this.uasItem != null) {
            float minVideoDataRate = this.uasItem.getMinVideoDataRate();
            float maxVideoDataRate = this.uasItem.getMaxVideoDataRate();
            float videoDataRate = this.uasItem.getVideoDataRate();
            float f = (float) 10;
            final int round = Math.round(minVideoDataRate * f);
            int round2 = Math.round(maxVideoDataRate * f);
            AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
            SeekBar seekBar = new SeekBar(MapView.getMapView().getContext());
            seekBar.setMax(round2 - round);
            seekBar.setProgress(Math.round(f * videoDataRate) - round);
            builder.setMessage("Video Data Rate: " + oneDecimalFormat.format((double) videoDataRate) + " Mbps");
            builder.setCancelable(true);
            builder.setView(seekBar);
            final AlertDialog create = builder.create();
            create.getWindow().setGravity(85);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(10) {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        AlertDialog alertDialog = create;
                        alertDialog.setMessage("Video Data Rate: " + OpCameraBar.oneDecimalFormat.format((double) (((float) (i + round)) / ((float) 10))) + " Mbps");
                    }
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                    OpCameraBar.this.setVideoDataRate(((float) (seekBar.getProgress() + round)) / ((float) 10));
                }
            });
            create.show();
            return;
        }
        toast("No connected UAS to adjust video data rate");
    }

    /* access modifiers changed from: private */
    public void setVideoDataRate(float f) {
        if (this.uasItem != null) {
            PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext()).edit().putFloat(NetworkPreferenceFragment.PREF_BROADCAST_VIDEODATARATE, f).apply();
            this.uasItem.setVideoDataRate(f);
            return;
        }
        toast("No connected UAS to set video data rate");
    }

    /* access modifiers changed from: private */
    public void toggleUASVideoMapOverlay() {
        if (this.uasItem == null) {
            toast("No connected UAS to to toggle video map overlay");
        } else if (UASToolDropDownReceiver.getInstance().isUASVideoMapOverlayRunning()) {
            UASToolDropDownReceiver.getInstance().stopUASVideoMapOverlay();
            this.uasVideoMapOverlayButton.setOn(false);
        } else {
            UASToolDropDownReceiver.getInstance().initAndRunUASVideoMapOverlay(this.uasItem);
            this.uasVideoMapOverlayButton.setOn(true);
        }
    }
}
