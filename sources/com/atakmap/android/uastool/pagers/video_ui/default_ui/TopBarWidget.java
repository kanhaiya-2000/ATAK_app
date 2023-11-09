package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.TaskEdit;

public class TopBarWidget extends MovableWidget {
    public static final String TAG = "TopBarWidget";
    /* access modifiers changed from: private */
    public ProgressBar batteryProgress;
    /* access modifiers changed from: private */
    public TextView batteryText;
    /* access modifiers changed from: private */
    public GimbalHeadingWidget gimbalHeadingWidget;
    /* access modifiers changed from: private */
    public RelativeLayout gimbalPitchLayout;
    private GimbalPitchWidget gimbalPitchWidget;
    private GradientDrawable gradientDrawable;
    public ImageView signalImage;
    /* access modifiers changed from: private */
    public TextView uasAltitudeText;
    public UASAttitudeWidget uasAttitudeWidget;
    /* access modifiers changed from: private */
    public TextView uasCallsignText;
    /* access modifiers changed from: private */
    public TextView uasCoordinatesText;
    /* access modifiers changed from: private */
    public TextView uasObstacleText;
    /* access modifiers changed from: private */
    public TextView uasRangeBearingText;
    /* access modifiers changed from: private */
    public TextView uasSpeedText;
    /* access modifiers changed from: private */
    public TextView uasTimeText;

    public TopBarWidget(Context context) {
        super(context);
    }

    public TopBarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopBarWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.halfLayoutParams.width = -1;
            this.halfLayoutParams.height = UIConstants.TOPBAR_HEIGHT_HALF;
        }
        this.batteryText = (TextView) findViewById(C1877R.C1878id.top_uas_battery_text);
        ProgressBar progressBar = (ProgressBar) findViewById(C1877R.C1878id.top_uas_battery_progress);
        this.batteryProgress = progressBar;
        this.gradientDrawable = (GradientDrawable) ((RotateDrawable) ((LayerDrawable) progressBar.getProgressDrawable().mutate()).findDrawableByLayerId(C1877R.C1878id.progress).mutate()).getDrawable().mutate();
        this.batteryProgress.setIndeterminate(false);
        this.batteryProgress.setSecondaryProgress(100);
        this.batteryProgress.setMax(100);
        this.signalImage = (ImageView) findViewById(C1877R.C1878id.top_uas_signalstrength);
        this.uasCallsignText = (TextView) findViewById(C1877R.C1878id.top_uas_callsign);
        this.uasCoordinatesText = (TextView) findViewById(C1877R.C1878id.top_uas_coordinates);
        this.uasRangeBearingText = (TextView) findViewById(C1877R.C1878id.top_uas_rangebearing);
        this.uasAltitudeText = (TextView) findViewById(C1877R.C1878id.top_uas_altitude);
        this.gimbalHeadingWidget = (GimbalHeadingWidget) findViewById(C1877R.C1878id.top_gimbal_heading);
        this.gimbalPitchWidget = (GimbalPitchWidget) findViewById(C1877R.C1878id.top_gimbal_pitch);
        this.gimbalPitchLayout = (RelativeLayout) findViewById(C1877R.C1878id.top_gimbal_layout);
        this.uasSpeedText = (TextView) findViewById(C1877R.C1878id.top_uas_speed);
        this.uasTimeText = (TextView) findViewById(C1877R.C1878id.top_uas_time);
        this.uasObstacleText = (TextView) findViewById(C1877R.C1878id.top_uas_obstaclerange);
        this.uasAttitudeWidget = (UASAttitudeWidget) findViewById(C1877R.C1878id.top_uas_attitude);
    }

    public void init(VideoUIView videoUIView, final UASItem uASItem) {
        this.gimbalHeadingWidget.init(this.videoUIView, uASItem);
        this.gimbalPitchWidget.init(this.videoUIView, uASItem);
        this.uasAttitudeWidget.init(this.videoUIView, uASItem);
        super.init(videoUIView, uASItem);
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    TopBarWidget.this.setCallsign();
                    boolean isFullscreenVideo = UASToolDropDownReceiver.getInstance().isFullscreenVideo();
                    if (uASItem.supportsBatteryLevel()) {
                        TopBarWidget.this.batteryProgress.setVisibility(0);
                        TopBarWidget.this.batteryText.setVisibility(0);
                    } else {
                        TopBarWidget.this.batteryProgress.setVisibility(4);
                        TopBarWidget.this.batteryText.setVisibility(4);
                    }
                    if (uASItem.supportsSignalStrength()) {
                        TopBarWidget.this.signalImage.setVisibility(0);
                    } else {
                        TopBarWidget.this.signalImage.setVisibility(4);
                    }
                    int i = 8;
                    if (uASItem.supportsAltitude()) {
                        TopBarWidget.this.uasAltitudeText.setVisibility(isFullscreenVideo ? 0 : 8);
                    } else {
                        TopBarWidget.this.uasAltitudeText.setVisibility(isFullscreenVideo ? 4 : 8);
                    }
                    if (uASItem.supportsSpeed()) {
                        TopBarWidget.this.uasSpeedText.setVisibility(isFullscreenVideo ? 0 : 8);
                    } else {
                        TopBarWidget.this.uasSpeedText.setVisibility(isFullscreenVideo ? 4 : 8);
                    }
                    if (uASItem.supportsTimeInFlight()) {
                        TopBarWidget.this.uasTimeText.setVisibility(isFullscreenVideo ? 0 : 8);
                    } else {
                        TopBarWidget.this.uasTimeText.setVisibility(isFullscreenVideo ? 4 : 8);
                    }
                    if (uASItem.supportsObstacleRange()) {
                        TextView access$600 = TopBarWidget.this.uasObstacleText;
                        if (isFullscreenVideo) {
                            i = 0;
                        }
                        access$600.setVisibility(i);
                    } else {
                        TextView access$6002 = TopBarWidget.this.uasObstacleText;
                        if (isFullscreenVideo) {
                            i = 4;
                        }
                        access$6002.setVisibility(i);
                    }
                    if (uASItem.supportsAttitude()) {
                        TopBarWidget.this.uasAttitudeWidget.setVisibility(0);
                    } else {
                        TopBarWidget.this.uasAttitudeWidget.setVisibility(4);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    int i;
                    int i2;
                    int i3;
                    if (TopBarWidget.this.isFullScreen()) {
                        TopBarWidget.this.batteryText.setTextSize(0, (float) UIConstants.TOPBAR_BATTERY_TEXT_FULL);
                        i3 = UIConstants.TOPBAR_HEIGHT_FULL;
                        i2 = UIConstants.TOPBAR_HEIGHT_FULL;
                        i = UIConstants.GIMBALPITCH_PADDING_FULL;
                        TopBarWidget.this.uasCallsignText.setVisibility(0);
                        TopBarWidget.this.uasCoordinatesText.setVisibility(0);
                        TopBarWidget.this.uasRangeBearingText.setVisibility(0);
                        TopBarWidget.this.uasAltitudeText.setVisibility(0);
                        TopBarWidget.this.uasSpeedText.setVisibility(0);
                        TopBarWidget.this.uasTimeText.setVisibility(0);
                        TopBarWidget.this.uasObstacleText.setVisibility(0);
                    } else {
                        TopBarWidget.this.batteryText.setTextSize(0, (float) UIConstants.TOPBAR_BATTERY_TEXT_HALF);
                        i3 = UIConstants.TOPBAR_HEIGHT_HALF;
                        i2 = UIConstants.TOPBAR_HEIGHT_HALF;
                        i = UIConstants.GIMBALPITCH_PADDING_HALF;
                        TopBarWidget.this.uasCallsignText.setVisibility(8);
                        TopBarWidget.this.uasCoordinatesText.setVisibility(8);
                        TopBarWidget.this.uasRangeBearingText.setVisibility(8);
                        TopBarWidget.this.uasAltitudeText.setVisibility(8);
                        TopBarWidget.this.uasSpeedText.setVisibility(8);
                        TopBarWidget.this.uasTimeText.setVisibility(8);
                        TopBarWidget.this.uasObstacleText.setVisibility(8);
                    }
                    TopBarWidget.this.batteryProgress.getLayoutParams().width = i3;
                    TopBarWidget.this.batteryProgress.getLayoutParams().height = i2;
                    TopBarWidget.this.signalImage.getLayoutParams().width = i3;
                    TopBarWidget.this.signalImage.getLayoutParams().height = i2;
                    TopBarWidget.this.gimbalHeadingWidget.getLayoutParams().width = i3;
                    TopBarWidget.this.gimbalHeadingWidget.getLayoutParams().height = i2;
                    TopBarWidget.this.gimbalPitchLayout.getLayoutParams().width = i3;
                    TopBarWidget.this.gimbalPitchLayout.getLayoutParams().height = i2;
                    TopBarWidget.this.gimbalPitchLayout.setPadding(i, i, i, i);
                    TopBarWidget.this.uasAttitudeWidget.getLayoutParams().width = i3;
                    TopBarWidget.this.uasAttitudeWidget.getLayoutParams().height = i2;
                    TopBarWidget.this.invalidate();
                }
            });
        }
    }

    public void updateOSD() {
        if (this.uasItem.isStale()) {
            this.batteryProgress.setProgress(0);
            this.gradientDrawable.setColor(Color.parseColor("#999999"));
            this.batteryText.setText(C1877R.string.dashdashdash);
        } else {
            int batteryPercent = (int) (this.uasItem.getBatteryPercent() * 100.0d);
            this.batteryProgress.setProgress(batteryPercent);
            this.gradientDrawable.setColorFilter(batteryPercent > 66 ? TaskEdit.viewColor : batteryPercent > 33 ? -256 : -65536, PorterDuff.Mode.SRC_ATOP);
            this.batteryText.setText(this.uasItem.getBatteryDisplay());
            if (this.uasItem.getBatteryPercent() <= 0.2d) {
                this.uasCallsignText.setTextColor(-65536);
            } else {
                this.uasCallsignText.setTextColor(this.defaultTextColor);
            }
        }
        if (this.uasItem.supportsSignalStrength()) {
            if (this.uasItem.isStale()) {
                this.signalImage.setImageResource(C1877R.drawable.signal_0_shadow);
            } else {
                this.signalImage.setImageResource(this.uasItem.getSignalStrengthImageId(true));
            }
        }
        if (this.uasItem.isStale()) {
            this.uasCoordinatesText.setText(C1877R.string.dashdashdash);
            this.uasRangeBearingText.setText(C1877R.string.dashdashdash);
            this.uasAltitudeText.setText(C1877R.string.dashdashdash);
        } else {
            this.uasCoordinatesText.setText(VideoUIBase.getAircraftCoordsDisplay(this.uasItem));
            this.uasRangeBearingText.setText(VideoUIBase.getRaBToAircraftDisplay(this.uasItem));
            this.uasAltitudeText.setText(VideoUIBase.getAltitudeDisplay(this.uasItem));
        }
        if (this.uasItem.isStale()) {
            this.uasSpeedText.setText(C1877R.string.dashdashdash);
            if (this.uasItem.supportsTimeInFlight()) {
                this.uasTimeText.setText(C1877R.string.dashdashdash);
            }
            if (this.uasItem.supportsObstacleRange()) {
                this.uasObstacleText.setText(C1877R.string.dashdashdash);
            }
        } else {
            this.uasSpeedText.setText(VideoUIBase.getSpeedDisplay(this.uasItem));
            if (this.uasItem.supportsTimeInFlight()) {
                TextView textView = this.uasTimeText;
                textView.setText(VideoUIBase.getFlightTimeMinsDisplay(this.uasItem) + "/" + VideoUIBase.getFlightTimeRemainingMinsDisplay(this.uasItem));
            }
            if (this.uasItem.supportsObstacleRange()) {
                this.uasObstacleText.setText(VideoUIBase.getObstacleRangeInchesDisplay(this.uasItem));
            }
        }
        this.gimbalHeadingWidget.updateOSD();
        this.gimbalPitchWidget.updateOSD();
        this.uasAttitudeWidget.updateOSD();
    }

    /* access modifiers changed from: private */
    public void setCallsign() {
        this.uasCallsignText.setText(this.uasItem.getCallsign());
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        super.onSharedPreferenceChanged(sharedPreferences, str);
        str.hashCode();
        if (str.equals(UASToolPreferenceFragment.PREF_CALLSIGN)) {
            setCallsign();
        }
    }
}
