package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.C1877R;

public class GimbalPitchWidget extends VideoWidget {
    public static final String TAG = "GimbalPitchWidget";
    private Paint arcPaint;
    private float gimbalPitch;
    private float gimbalVFOV;
    private Paint pitchPaint;
    private float ringBottom;
    private float ringCenterX;
    private float ringCenterY;
    private float ringEndX;
    private float ringEndY;
    private float ringLeft;
    private float ringRadius;
    private float ringRight;
    private float ringTop;
    private float startAngle;
    private float sweepAngle;

    public GimbalPitchWidget(Context context) {
        super(context);
    }

    public GimbalPitchWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GimbalPitchWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.arcPaint = paint;
        paint.setARGB(80, 255, 255, 255);
        this.arcPaint.setStrokeWidth(6.0f);
        this.arcPaint.setAntiAlias(true);
        this.arcPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.pitchPaint = paint2;
        paint2.setColor(RED);
        this.pitchPaint.setStrokeWidth(6.0f);
        this.pitchPaint.setAntiAlias(true);
        this.pitchPaint.setStyle(Paint.Style.FILL);
        super.init(videoUIView, uASItem);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ImageView imageView = (ImageView) findViewById(C1877R.C1878id.gimbal_pitch_ring);
        this.ringLeft = (float) imageView.getLeft();
        this.ringTop = (float) imageView.getTop();
        this.ringRight = (float) imageView.getRight();
        this.ringBottom = (float) imageView.getBottom();
        float f = this.ringRight;
        float f2 = this.ringLeft;
        float f3 = (f - f2) * 0.5f;
        this.ringRadius = f3;
        this.ringCenterX = f2 + f3;
        this.ringCenterY = this.ringTop + f3;
    }

    public void updateOSD() {
        this.gimbalPitch = (float) this.uasItem.getGimbalPitch();
        float vfov = (float) this.uasItem.getVFOV();
        this.gimbalVFOV = vfov;
        float f = this.gimbalPitch;
        this.startAngle = (-f) - (0.5f * vfov);
        this.sweepAngle = vfov;
        this.ringEndX = this.ringCenterX + ((float) (((double) this.ringRadius) * Math.cos(Math.toRadians((double) f))));
        this.ringEndY = this.ringCenterY - ((float) (((double) this.ringRadius) * Math.sin(Math.toRadians((double) this.gimbalPitch))));
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.uasItem != null && !this.uasItem.isStale()) {
            canvas.drawArc(this.ringLeft, this.ringTop, this.ringRight, this.ringBottom, this.startAngle, this.sweepAngle, true, this.arcPaint);
            canvas.drawLine(this.ringCenterX, this.ringCenterY, this.ringEndX, this.ringEndY, this.pitchPaint);
        }
    }
}
