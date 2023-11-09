package com.atakmap.android.uastool.mavlink;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.PopupWidget;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIButton;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.VideoUIView;
import com.atakmap.android.uastool.paladin.PaladinPayloadManager;
import com.atakmap.android.uastool.plugin.C1877R;

public class MavlinkButtonBarWidget extends PopupWidget {
    public static final String TAG = "MavlinkButtonBarWidget";
    public VideoUIButton armDisarmButton;
    public VideoUIButton gimbalLockButton;
    /* access modifiers changed from: private */
    public PaladinPayloadManager ppm;
    public VideoUIButton sarcosToolButton;
    /* access modifiers changed from: private */
    public MAVLinkUASItem selectedUASItem;
    public VideoUIButton switchCameraButton;

    public MavlinkButtonBarWidget(Context context) {
        super(context);
    }

    public MavlinkButtonBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MavlinkButtonBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VideoUIButton videoUIButton = (VideoUIButton) findViewById(C1877R.C1878id.mavlink_switch_camera_button);
        this.switchCameraButton = videoUIButton;
        if (videoUIButton != null) {
            String string = UASToolDropDownReceiver.getSharedPrefs().getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI2, "");
            if (string != null && !string.trim().isEmpty()) {
                this.switchCameraButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MavlinkButtonBarWidget.this.selectedUASItem.toggleVideo();
                    }
                });
                this.switchCameraButton.setVisibility(0);
            } else {
                this.switchCameraButton.setVisibility(8);
            }
        }
        VideoUIButton videoUIButton2 = (VideoUIButton) findViewById(C1877R.C1878id.mavlink_gimbal_lock_button);
        this.gimbalLockButton = videoUIButton2;
        videoUIButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z = !MavlinkButtonBarWidget.this.selectedUASItem.getGimbalLockOn();
                StringBuilder sb = new StringBuilder();
                sb.append("Gimbal Lock-");
                sb.append(z ? "on" : "off");
                UASToolDropDownReceiver.toast(sb.toString());
                MavlinkButtonBarWidget.this.selectedUASItem.setGimbalLockOn(z);
            }
        });
        VideoUIButton videoUIButton3 = (VideoUIButton) findViewById(C1877R.C1878id.mavlink_arm_button);
        this.armDisarmButton = videoUIButton3;
        videoUIButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final boolean isArmed = MavlinkButtonBarWidget.this.selectedUASItem.isArmed();
                AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                builder.setTitle(isArmed ? "Confirm Disarming" : "Confirm Arming");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MavlinkButtonBarWidget.this.selectedUASItem.sendArm(!isArmed);
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
        });
        VideoUIButton videoUIButton4 = (VideoUIButton) findViewById(C1877R.C1878id.mavlink_sarcos_button);
        this.sarcosToolButton = videoUIButton4;
        if (videoUIButton4 != null) {
            videoUIButton4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (MavlinkButtonBarWidget.this.ppm == null) {
                        PaladinPayloadManager unused = MavlinkButtonBarWidget.this.ppm = PaladinPayloadManager.getInstance();
                    } else {
                        MavlinkButtonBarWidget.this.ppm.resetUI();
                        MavlinkButtonBarWidget.this.ppm.connect();
                    }
                    if (!MavlinkButtonBarWidget.this.ppm.hasFeatures()) {
                        UASToolDropDownReceiver.toast("No Payload Features to display", 0);
                        return;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
                    builder.setTitle(UASToolDropDownReceiver.getInstance().getPluginContext().getString(C1877R.string.paladin_payload_title));
                    PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
                    builder.setView(MavlinkButtonBarWidget.this.ppm.getPayloadView());
                    builder.setCancelable(false);
                    builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MavlinkButtonBarWidget.this.ppm.cancel();
                            ((ViewGroup) MavlinkButtonBarWidget.this.ppm.getPayloadView().getParent()).removeView(MavlinkButtonBarWidget.this.ppm.getPayloadView());
                        }
                    });
                    builder.show();
                }
            });
        }
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        super.init(videoUIView, uASItem);
        if (uASItem != null && (uASItem instanceof MAVLinkUASItem)) {
            MAVLinkUASItem mAVLinkUASItem = (MAVLinkUASItem) uASItem;
            this.selectedUASItem = mAVLinkUASItem;
            this.gimbalLockButton.setOn(mAVLinkUASItem.getGimbalLockOn());
        }
        if (this.selectedUASItem.getAutoPilotType() == 20) {
            this.sarcosToolButton.setEnabled(true);
            this.sarcosToolButton.setVisibility(0);
            this.gimbalLockButton.setVisibility(8);
            this.armDisarmButton.setVisibility(8);
            return;
        }
        this.sarcosToolButton.setEnabled(false);
        this.sarcosToolButton.setVisibility(8);
        this.gimbalLockButton.setVisibility(0);
        this.armDisarmButton.setVisibility(0);
    }
}
