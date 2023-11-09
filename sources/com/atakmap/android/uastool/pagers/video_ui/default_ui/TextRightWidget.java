package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.plugin.C1877R;

public class TextRightWidget extends MovableWidget {
    public static final String TAG = "TextRightWidget";
    /* access modifiers changed from: private */
    public TextView uasObstacleText;
    /* access modifiers changed from: private */
    public TextView uasSpeedText;
    /* access modifiers changed from: private */
    public TextView uasTimeText;

    public TextRightWidget(Context context) {
        super(context);
    }

    public TextRightWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextRightWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.uasSpeedText = (TextView) findViewById(C1877R.C1878id.textright_uas_speed);
        this.uasTimeText = (TextView) findViewById(C1877R.C1878id.textright_uas_time);
        this.uasObstacleText = (TextView) findViewById(C1877R.C1878id.textright_uas_obstaclerange);
    }

    public void init(VideoUIView videoUIView, final UASItem uASItem) {
        super.init(videoUIView, uASItem);
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (uASItem.supportsSpeed()) {
                        TextRightWidget.this.uasSpeedText.setVisibility(0);
                    } else {
                        TextRightWidget.this.uasSpeedText.setVisibility(8);
                    }
                    if (uASItem.supportsTimeInFlight()) {
                        TextRightWidget.this.uasTimeText.setVisibility(0);
                    } else {
                        TextRightWidget.this.uasTimeText.setVisibility(8);
                    }
                    if (uASItem.supportsObstacleRange()) {
                        TextRightWidget.this.uasObstacleText.setVisibility(0);
                    } else {
                        TextRightWidget.this.uasObstacleText.setVisibility(8);
                    }
                }
            });
        }
    }

    public void updateOSD() {
        if (this.uasItem.isStale()) {
            this.uasSpeedText.setText(C1877R.string.dashdashdash);
            if (this.uasItem.supportsTimeInFlight()) {
                this.uasTimeText.setText(C1877R.string.dashdashdash);
            }
            if (this.uasItem.supportsObstacleRange()) {
                this.uasObstacleText.setText(C1877R.string.dashdashdash);
                return;
            }
            return;
        }
        this.uasSpeedText.setText(VideoUIBase.getSpeedDisplay(this.uasItem));
        if (this.uasItem.supportsTimeInFlight()) {
            TextView textView = this.uasTimeText;
            textView.setText(VideoUIBase.getFlightTimeMinsDisplay(this.uasItem) + "/" + VideoUIBase.getFlightTimeRemainingMinsDisplay(this.uasItem));
        }
        if (this.uasItem.supportsObstacleRange()) {
            this.uasObstacleText.setText(VideoUIBase.getObstacleRangeInchesDisplay(this.uasItem));
        }
    }
}
