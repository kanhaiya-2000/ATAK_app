package com.atakmap.android.uastool.mavlink;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.coremap.log.Log;
import com.bbn.ccast.mavlink.MavLinkThread;

public class MAVLinkCompassCalibScreen extends UASToolScreen {
    private final String MAV_CAL_DONE = "calibration done";
    private final String MAV_CAL_DOWN = "down orientation detected";
    private final String MAV_CAL_DOWN_DONE = "down side done";
    private final String MAV_CAL_FRONT = "front orientation detected";
    private final String MAV_CAL_FRONT_DONE = "front side done";
    private final String MAV_CAL_LEFT = "left orientation detected";
    private final String MAV_CAL_LEFT_DONE = "left side done";
    private final String MAV_CAL_STARTED = "calibration started";
    /* access modifiers changed from: private */
    public TextView compassStateValue;
    /* access modifiers changed from: private */
    public TextView helpText;
    /* access modifiers changed from: private */
    public final ImageView[] imageViews = new ImageView[3];
    /* access modifiers changed from: private */
    public Thread statusThread = null;
    /* access modifiers changed from: private */
    public MAVLinkUASItem uasItem;

    public MAVLinkCompassCalibScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.imageViews[0] = (ImageView) findViewById(C1877R.C1878id.mavlink_down_image);
        this.imageViews[1] = (ImageView) findViewById(C1877R.C1878id.mavlink_left_image);
        this.imageViews[2] = (ImageView) findViewById(C1877R.C1878id.mavlink_nosedown_image);
        this.helpText = (TextView) findViewById(C1877R.C1878id.mavlink_help_text);
        this.compassStateValue = (TextView) findViewById(C1877R.C1878id.mavlinksettings_calibcompass_value);
        startUASCalibCheck();
    }

    private void startUASCalibCheck() {
        try {
            MavLinkThread mavLinkThread = this.uasItem.getMavLinkThread();
            if (mavLinkThread != null && mavLinkThread.isConnected()) {
                mavLinkThread.startCompassCalibration();
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to calibrate MAVLink: ", e);
            UASToolDropDownReceiver.toast("Failed to calibrate", 0);
        }
        if (this.statusThread == null) {
            C15121 r0 = new Thread() {
                public void run() {
                    while (!MAVLinkCompassCalibScreen.this.statusThread.isInterrupted()) {
                        MavLinkThread mavLinkThread = MAVLinkCompassCalibScreen.this.uasItem.getMavLinkThread();
                        if (mavLinkThread == null) {
                            Log.e(MAVLinkCompassCalibScreen.TAG, "mavlinkThread is null");
                            return;
                        }
                        boolean z = false;
                        while (!mavLinkThread.getStatusText().contains("calibration done")) {
                            String statusText = mavLinkThread.getStatusText();
                            if (statusText.contains("calibration done")) {
                                MAVLinkCompassCalibScreen.this.setUI("Calibration Done", 2, TaskEdit.viewColor, C1877R.drawable.vehicle_nose_down);
                                if (MAVLinkCompassCalibScreen.this.compassStateValue != null) {
                                    MAVLinkCompassCalibScreen.this.compassStateValue.setText(C1877R.string.mav_cal_complete);
                                }
                                z = true;
                            }
                            if (!z) {
                                if (statusText.contains("down orientation detected")) {
                                    MAVLinkCompassCalibScreen.this.setUI("Rotate the drone in the down orientation", 0, -256, C1877R.drawable.vehicle_down_rotate);
                                }
                                if (statusText.contains("down side done")) {
                                    MAVLinkCompassCalibScreen.this.setUI("Place the drone left-side down", 0, TaskEdit.viewColor, C1877R.drawable.vehicle_down);
                                }
                                if (statusText.contains("left orientation detected")) {
                                    MAVLinkCompassCalibScreen.this.setUI("Rotate the drone in the left orientation", 1, -256, C1877R.drawable.vehicle_left_rotate);
                                }
                                if (statusText.contains("left side done")) {
                                    MAVLinkCompassCalibScreen.this.setUI("Place the drone front-side down", 1, TaskEdit.viewColor, C1877R.drawable.vehicle_left);
                                }
                                if (statusText.contains("front orientation detected")) {
                                    MAVLinkCompassCalibScreen.this.setUI("Rotate the drone in the front orientation", 2, -256, C1877R.drawable.vehicle_nose_down_rotate);
                                }
                                if (statusText.contains("front side done")) {
                                    MAVLinkCompassCalibScreen.this.setUI("Calibration Done", 2, TaskEdit.viewColor, C1877R.drawable.vehicle_nose_down);
                                    if (MAVLinkCompassCalibScreen.this.compassStateValue != null) {
                                        MAVLinkCompassCalibScreen.this.compassStateValue.setText(C1877R.string.mav_cal_complete);
                                    }
                                    z = true;
                                }
                            }
                        }
                    }
                }
            };
            this.statusThread = r0;
            r0.start();
            return;
        }
        Log.d(TAG, "Status thread NOT null");
    }

    /* access modifiers changed from: private */
    public void setUI(final String str, final int i, final int i2, int i3) {
        ((Activity) UASToolDropDownReceiver.getInstance().getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                MAVLinkCompassCalibScreen.this.helpText.setText(str);
                MAVLinkCompassCalibScreen.this.imageViews[i].setBackgroundColor(i2);
            }
        });
    }

    public void setUASItem(MAVLinkUASItem mAVLinkUASItem) {
        this.uasItem = mAVLinkUASItem;
    }
}
