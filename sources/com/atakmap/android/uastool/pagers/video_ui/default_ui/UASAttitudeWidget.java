package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.atakmap.android.uastool.UASItem;

public class UASAttitudeWidget extends VideoWidget {
    public static final int DRAW_ALPHA = 120;
    public static final int GROUND_COLOR_GREEN = -8343515;
    public static final int GROUND_COLOR_RED = -3324860;
    public static final int GROUND_COLOR_YELLOW = -2633167;
    private static final float INTERNAL_RADIUS = 0.9f;
    private static final int PITCH_RANGE = 45;
    private static final float PITCH_TICK_LINE_LENGTH = 0.4f;
    private static final int PITCH_TICK_PADDING = 2;
    private static final int PITCH_TICK_SPACING = 15;
    private static final float PLANE_BODY_SIZE = 0.2f;
    private static final float PLANE_SIZE = 0.8f;
    private static final float PLANE_WING_WIDTH = 5.0f;
    private static final float RING_WIDTH = 3.0f;
    private static final float RING_WIDTH_HALF = 1.5f;
    public static final int SKY_COLOR = -10307119;
    public static final int STALE_ALPHA = 40;
    public static final String TAG = "UASAttitudeWidget";
    private static final float YAW_ARROW_ANGLE = 4.5f;
    private static final float YAW_ARROW_SIZE = 1.2f;
    private Paint groundPaint;
    private final Path groundPath = new Path();
    private float halfHeight;
    private float halfWidth;
    private RectF internalBounds;
    private float pitch;
    private Paint planeCenterPaint;
    private Paint planeFinPaint;
    private Paint planePaint;
    private float radiusExternal;
    private float radiusInternal;
    private final RectF radiusOval = new RectF();
    private Paint ringPaint;
    private float roll;
    private Paint skyPaint;
    private Paint tickPaint;
    private Paint yawCirclePaint;
    private Paint yawPaint;
    private Paint yawTopPaint;

    public UASAttitudeWidget(Context context) {
        super(context);
    }

    public UASAttitudeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UASAttitudeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint.setAlpha(25);
        this.yawPaint = new Paint(paint);
        this.yawTopPaint = new Paint(paint);
        Paint paint3 = new Paint(paint2);
        this.yawCirclePaint = paint3;
        paint3.setStrokeWidth(1.0f);
        this.yawPaint.setColor(DARK_GRAY);
        this.yawPaint.setAlpha(10);
        this.yawTopPaint.setColor(LITE_GRAY);
        this.yawTopPaint.setAlpha(10);
        this.yawCirclePaint.setColor(BLACK);
        this.yawCirclePaint.setAlpha(10);
        Paint paint4 = new Paint(paint);
        this.skyPaint = paint4;
        paint4.setColor(SKY_COLOR);
        this.skyPaint.setAlpha(120);
        Paint paint5 = new Paint(paint);
        this.groundPaint = paint5;
        paint5.setColor(GROUND_COLOR_GREEN);
        this.groundPaint.setAlpha(120);
        Paint paint6 = new Paint(paint);
        this.planePaint = paint6;
        paint6.setColor(WHITE);
        this.planePaint.setStrokeWidth(PLANE_WING_WIDTH);
        this.planePaint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint7 = new Paint(this.planePaint);
        this.planeCenterPaint = paint7;
        paint7.setColor(RED);
        Paint paint8 = new Paint(this.planePaint);
        this.planeFinPaint = paint8;
        paint8.setStrokeWidth(2.5f);
        this.planeFinPaint.setAlpha(10);
        Paint paint9 = new Paint(paint2);
        this.ringPaint = paint9;
        paint9.setColor(WHITE);
        this.ringPaint.setStrokeWidth(RING_WIDTH);
        this.ringPaint.setStrokeCap(Paint.Cap.ROUND);
        this.ringPaint.setAlpha(255);
        this.ringPaint.setShadowLayer(UIConstants.TEXTSHADOW_DX, UIConstants.TEXTSHADOW_DY, UIConstants.TEXTSHADOW_RADIUS, UIConstants.TEXTSHADOW_COLOR);
        Paint paint10 = new Paint(paint);
        this.tickPaint = paint10;
        paint10.setColor(WHITE);
        this.tickPaint.setStrokeWidth(2.0f);
        this.tickPaint.setShadowLayer(UIConstants.TEXTSHADOW_DX, UIConstants.TEXTSHADOW_DY, UIConstants.TEXTSHADOW_RADIUS, UIConstants.TEXTSHADOW_COLOR);
        super.init(videoUIView, uASItem);
    }

    public void updateOSD() {
        if (this.uasItem == null || this.uasItem.isStale()) {
            this.roll = 0.0f;
            this.pitch = 0.0f;
            this.skyPaint.setAlpha(40);
            this.groundPaint.setAlpha(40);
        } else {
            this.roll = (float) this.uasItem.getRoll();
            this.pitch = (float) this.uasItem.getPitch();
            this.skyPaint.setAlpha(120);
            this.groundPaint.setAlpha(120);
        }
        this.groundPath.reset();
        float degrees = (float) Math.toDegrees(Math.acos((double) (this.pitch / 45.0f)));
        RectF rectF = this.internalBounds;
        if (rectF != null) {
            this.groundPath.addArc(rectF, (90.0f - degrees) - this.roll, degrees * 2.0f);
        }
        invalidate();
    }

    public void setGroundColor(int i) {
        this.groundPaint.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = ((float) i2) / 2.0f;
        this.halfHeight = f;
        float f2 = ((float) i) / 2.0f;
        this.halfWidth = f2;
        float min = Math.min(f, f2) / YAW_ARROW_SIZE;
        this.radiusExternal = min;
        this.radiusInternal = min * INTERNAL_RADIUS;
        float f3 = this.radiusInternal;
        this.internalBounds = new RectF(-f3, -f3, f3, f3);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode()) {
            canvas.translate(this.halfWidth, this.halfHeight);
            drawYaw(canvas);
            drawSkyAndGround(canvas);
            drawPitchTicks(canvas);
            drawPlane(canvas);
        }
    }

    private void drawYaw(Canvas canvas) {
        canvas.drawCircle(0.0f, 0.0f, this.radiusInternal + RING_WIDTH, this.ringPaint);
        canvas.drawCircle(0.0f, 0.0f, this.radiusExternal, this.yawPaint);
        RectF rectF = this.radiusOval;
        float f = this.radiusExternal;
        rectF.set(-f, -f, f, f);
        canvas.drawArc(this.radiusOval, 180.0f, 180.0f, false, this.yawTopPaint);
        canvas.drawCircle(0.0f, 0.0f, this.radiusInternal + 1.0f, this.yawCirclePaint);
        canvas.drawCircle(0.0f, 0.0f, this.radiusExternal, this.yawCirclePaint);
    }

    private void radialLineTo(Path path, float f, float f2) {
        double d = (double) f;
        path.lineTo(((float) Math.sin(d)) * f2, ((float) Math.cos(d)) * f2);
    }

    private void drawSkyAndGround(Canvas canvas) {
        canvas.drawCircle(0.0f, 0.0f, this.radiusInternal, this.skyPaint);
        canvas.drawPath(this.groundPath, this.groundPaint);
    }

    private void drawPitchTicks(Canvas canvas) {
        float f = this.pitch;
        int i = (int) (((f + 45.0f) - 2.0f) / 15.0f);
        if (i % 2 != 0) {
            i--;
        }
        for (int i2 = (int) (((-45.0f + f) + 2.0f) / 15.0f); i2 <= i; i2++) {
            float f2 = (-this.pitch) + ((float) (i2 * 15));
            float abs = (((float) Math.abs(i2)) * 0.1f) + PITCH_TICK_LINE_LENGTH;
            float cos = ((float) (Math.cos(Math.toRadians((double) (-this.roll))) * ((double) this.radiusInternal))) * abs;
            float sin = ((float) (Math.sin(Math.toRadians((double) (-this.roll))) * ((double) this.radiusInternal))) * abs;
            float cos2 = ((float) ((Math.cos(Math.toRadians((double) ((-this.roll) - 90.0f))) * ((double) this.radiusInternal)) / 45.0d)) * f2;
            float sin2 = ((float) ((Math.sin(Math.toRadians((double) ((-this.roll) - 90.0f))) * ((double) this.radiusInternal)) / 45.0d)) * f2;
            canvas.drawLine(cos + cos2, sin + sin2, (-cos) + cos2, (-sin) + sin2, this.tickPaint);
        }
    }

    private void drawPlane(Canvas canvas) {
        float f = this.radiusInternal;
        canvas.drawLine(f * PLANE_SIZE, 0.0f, (-f) * PLANE_SIZE, 0.0f, this.planePaint);
        canvas.drawCircle(0.0f, 0.0f, ((this.radiusInternal * PLANE_SIZE) * PLANE_BODY_SIZE) / 2.0f, this.planePaint);
    }
}
