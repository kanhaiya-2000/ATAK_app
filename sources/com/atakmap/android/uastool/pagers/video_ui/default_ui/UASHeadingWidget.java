package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.utils.Utils;

public class UASHeadingWidget extends MovableWidget {
    public static final String TAG = "UASHeadingWidget";
    private Paint arcPaint;
    private float cameraHeading;
    private float drawBottom;
    private float drawLeft;
    private float drawRight;
    private float drawTop;
    private float endHFOV;
    /* access modifiers changed from: private */
    public TextView headingText;
    /* access modifiers changed from: private */
    public ImageView innerRing;
    /* access modifiers changed from: private */
    public boolean isLocked;
    private float outerRadius;
    private ImageView outerRing;
    private float outerWidth;
    /* access modifiers changed from: private */
    public ImageView plane;
    private float startHFOV;
    private float uasHeading;

    public UASHeadingWidget(Context context) {
        super(context);
    }

    public UASHeadingWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UASHeadingWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.halfLayoutParams.width = UIConstants.UASHEADING_SIZE_HALF;
            this.halfLayoutParams.height = UIConstants.UASHEADING_SIZE_HALF;
        }
        TextView textView = (TextView) findViewById(C1877R.C1878id.compass_heading_text);
        this.headingText = textView;
        textView.setTextAlignment(4);
        this.outerRing = (ImageView) findViewById(C1877R.C1878id.compass_outer_ring);
        ImageView imageView = (ImageView) findViewById(C1877R.C1878id.compass_inner_ring);
        this.innerRing = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UASHeadingWidget.this.toggleLock();
            }
        });
        this.plane = (ImageView) findViewById(C1877R.C1878id.compass_plane);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        if (!isInEditMode()) {
            this.isLocked = UASToolDropDownReceiver.getSharedPrefs().getBoolean(UIPreferenceFragment.PREF_UI_COMPASS_LOCKED, true);
        }
        Paint paint = new Paint();
        this.arcPaint = paint;
        paint.setARGB(100, 255, 255, 255);
        this.arcPaint.setStrokeWidth(6.0f);
        this.arcPaint.setStyle(Paint.Style.FILL);
        super.init(videoUIView, uASItem);
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (UASHeadingWidget.this.isFullScreen()) {
                        UASHeadingWidget.this.headingText.setTextSize((float) UIConstants.UASHEADING_TEXT_FULL);
                        UASHeadingWidget uASHeadingWidget = UASHeadingWidget.this;
                        uASHeadingWidget.setPadding(uASHeadingWidget.fullStartPad, UASHeadingWidget.this.fullTopPad, UASHeadingWidget.this.fullEndPad, UASHeadingWidget.this.fullBottomPad);
                        UASHeadingWidget.this.headingText.setVisibility(0);
                    } else {
                        UASHeadingWidget.this.headingText.setTextSize((float) UIConstants.UASHEADING_TEXT_HALF);
                        UASHeadingWidget.this.setPadding(UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF, UIConstants.WIDGET_PAD_HALF);
                        UASHeadingWidget.this.headingText.setVisibility(8);
                    }
                    UASHeadingWidget.this.invalidate();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (isInEditMode()) {
            return;
        }
        if (i != i3 || i2 != i4) {
            float measuredWidth = (float) getMeasuredWidth();
            this.outerWidth = measuredWidth;
            this.outerRadius = measuredWidth * 0.5f;
            float measuredWidth2 = (float) this.outerRing.getMeasuredWidth();
            float f = this.outerWidth - measuredWidth2;
            this.drawLeft = f;
            this.drawTop = f;
            this.drawRight = measuredWidth2;
            this.drawBottom = measuredWidth2;
        }
    }

    public void updateOSD() {
        if (this.uasItem == null || this.uasItem.isStale()) {
            this.headingText.setText(C1877R.string.dashdashdash);
        } else {
            this.uasHeading = (float) this.uasItem.getHeading();
            this.headingText.setText(Utils.formatHeading(this.uasItem.getGeoPoint(), (double) this.uasHeading));
            this.cameraHeading = (float) this.uasItem.getGimbalAngle();
            float gimbalAngle = ((float) this.uasItem.getGimbalAngle()) - this.uasHeading;
            float hfov = (float) this.uasItem.getHFOV();
            this.startHFOV = gimbalAngle - (0.5f * hfov);
            this.endHFOV = hfov;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public boolean toggleLock() {
        this.isLocked = !this.isLocked;
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (UASHeadingWidget.this.isLocked) {
                        UASHeadingWidget.this.innerRing.setRotation(0.0f);
                        UASHeadingWidget.this.toast("UAS Heading compass locked to north");
                    } else {
                        UASHeadingWidget.this.plane.setRotation(0.0f);
                        UASHeadingWidget.this.toast("UAS Heading compass unlocked");
                    }
                    UASHeadingWidget.this.invalidate();
                }
            });
        }
        SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
        edit.putBoolean(UIPreferenceFragment.PREF_UI_COMPASS_LOCKED, this.isLocked);
        edit.apply();
        return this.isLocked;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            return;
        }
        if (this.uasItem == null || this.uasItem.isStale()) {
            this.plane.setRotation(0.0f);
            return;
        }
        float f = this.outerRadius;
        canvas.rotate(-90.0f, f, f);
        if (this.isLocked) {
            this.plane.setRotation(this.uasHeading);
            float f2 = this.uasHeading;
            float f3 = this.outerRadius;
            canvas.rotate(f2, f3, f3);
        } else {
            this.innerRing.setRotation(-this.uasHeading);
        }
        canvas.drawArc(this.drawLeft, this.drawTop, this.drawRight, this.drawBottom, this.startHFOV, this.endHFOV, true, this.arcPaint);
        if (this.isLocked) {
            float f4 = this.outerRadius;
            canvas.rotate(-this.uasHeading, f4, f4);
        }
        float f5 = this.outerRadius;
        canvas.rotate(90.0f, f5, f5);
    }
}
