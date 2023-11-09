package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.utils.Utils;

public class GimbalHeadingWidget extends VideoWidget {
    public static final String TAG = "GimbalHeadingWidget";
    private int currentDegreesBackBufferX;
    private int currentDegreesBackBufferY;
    private Paint currentDegreesBackPaint;
    private RectF currentDegreesRect;
    private String currentDegreesText;
    private Rect currentDegreesTextBounds;
    /* access modifiers changed from: private */
    public Paint currentDegreesTextPaint;
    /* access modifiers changed from: private */
    public int currentDegreesTextSize;
    private int currentDegreesTextWidth;
    private float currentDegreesX;
    private float currentDegreesY;
    private float gimbalHFOV;
    private float gimbalHeading;
    /* access modifiers changed from: private */
    public Paint horizontalRulePaint;
    /* access modifiers changed from: private */
    public int horizontalRuleThickness;
    private float horizontalRuleY;
    /* access modifiers changed from: private */
    public int majorDegrees;
    private int majorDegreesCount;
    private Rect majorDegreesTextBounds;
    /* access modifiers changed from: private */
    public Paint majorDegreesTextPaint;
    /* access modifiers changed from: private */
    public int majorDegreesTextSize;
    private float majorDegreesTextY;
    /* access modifiers changed from: private */
    public Paint majorDegreesTickPaint;
    /* access modifiers changed from: private */
    public int majorDegreesTickThickness;
    private int measuredHeight;
    private int measuredWidth;
    private int needleCenterX;
    private String staleText;
    private int startMajorDegrees;
    private float windowStartDegrees;

    public GimbalHeadingWidget(Context context) {
        super(context);
    }

    public GimbalHeadingWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GimbalHeadingWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.halfLayoutParams.setMarginStart(4);
            this.halfLayoutParams.setMarginEnd(10);
        }
    }

    public void init(VideoUIView videoUIView, UASItem uASItem) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(paint);
        this.horizontalRulePaint = paint2;
        paint2.setColor(WHITE);
        this.horizontalRuleThickness = 14;
        this.horizontalRulePaint.setStrokeWidth((float) 14);
        this.horizontalRulePaint.setShadowLayer(UIConstants.TEXTSHADOW_DX, UIConstants.TEXTSHADOW_DY, UIConstants.TEXTSHADOW_RADIUS, UIConstants.TEXTSHADOW_COLOR);
        Paint paint3 = new Paint(paint);
        this.majorDegreesTickPaint = paint3;
        paint3.setColor(WHITE);
        this.majorDegreesTickThickness = 2;
        this.majorDegreesTickPaint.setStrokeWidth((float) 2);
        this.majorDegreesTickPaint.setShadowLayer(UIConstants.TEXTSHADOW_DX, UIConstants.TEXTSHADOW_DY, UIConstants.TEXTSHADOW_RADIUS, UIConstants.TEXTSHADOW_COLOR);
        Paint paint4 = new Paint(paint);
        this.majorDegreesTextPaint = paint4;
        paint4.setColor(this.defaultTextColor);
        if (isFullScreen()) {
            this.majorDegreesTextSize = UIConstants.GIMBALHEADING_TEXT_FULL;
        } else {
            this.majorDegreesTextSize = UIConstants.GIMBALHEADING_TEXT_HALF;
        }
        this.majorDegreesTextPaint.setTextSize((float) this.majorDegreesTextSize);
        this.majorDegreesTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.majorDegrees = 10;
        Rect rect = new Rect();
        this.majorDegreesTextBounds = rect;
        this.majorDegreesTextPaint.getTextBounds("0123456789", 0, 10, rect);
        this.majorDegreesTextPaint.setShadowLayer(UIConstants.TEXTSHADOW_DX, UIConstants.TEXTSHADOW_DY, UIConstants.TEXTSHADOW_RADIUS, UIConstants.TEXTSHADOW_COLOR);
        Paint paint5 = new Paint(paint);
        this.currentDegreesBackPaint = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.currentDegreesBackPaint.setColor(Color.parseColor("#BB000000"));
        this.currentDegreesBackBufferX = 10;
        this.currentDegreesBackBufferY = 10;
        this.currentDegreesText = "";
        Paint paint6 = new Paint(paint);
        this.currentDegreesTextPaint = paint6;
        paint6.setColor(this.defaultTextColor);
        if (isFullScreen()) {
            this.currentDegreesTextSize = UIConstants.GIMBALHEADING_TEXT_FULL;
        } else {
            this.currentDegreesTextSize = UIConstants.GIMBALHEADING_TEXT_HALF;
        }
        this.currentDegreesTextPaint.setTextSize((float) this.currentDegreesTextSize);
        this.currentDegreesTextPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.currentDegreesTextWidth = (int) this.currentDegreesTextPaint.measureText(this.currentDegreesText);
        Rect rect2 = new Rect();
        this.currentDegreesTextBounds = rect2;
        this.currentDegreesTextPaint.getTextBounds("0123456789", 0, 10, rect2);
        this.currentDegreesRect = new RectF();
        if (!isInEditMode()) {
            this.staleText = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getString(C1877R.string.dashdashdash);
        }
        this.gimbalHFOV = 60.0f;
        super.init(videoUIView, uASItem);
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (GimbalHeadingWidget.this.isFullScreen()) {
                        int unused = GimbalHeadingWidget.this.horizontalRuleThickness = 7;
                        int unused2 = GimbalHeadingWidget.this.majorDegreesTickThickness = 2;
                        int unused3 = GimbalHeadingWidget.this.majorDegreesTextSize = UIConstants.GIMBALHEADING_TEXT_FULL;
                        int unused4 = GimbalHeadingWidget.this.majorDegrees = 10;
                        int unused5 = GimbalHeadingWidget.this.currentDegreesTextSize = UIConstants.GIMBALHEADING_TEXT_FULL;
                    } else {
                        int unused6 = GimbalHeadingWidget.this.horizontalRuleThickness = 7;
                        int unused7 = GimbalHeadingWidget.this.majorDegreesTickThickness = 2;
                        int unused8 = GimbalHeadingWidget.this.majorDegreesTextSize = UIConstants.GIMBALHEADING_TEXT_HALF;
                        int unused9 = GimbalHeadingWidget.this.majorDegrees = 20;
                        int unused10 = GimbalHeadingWidget.this.currentDegreesTextSize = UIConstants.GIMBALHEADING_TEXT_HALF;
                    }
                    GimbalHeadingWidget.this.horizontalRulePaint.setStrokeWidth((float) GimbalHeadingWidget.this.horizontalRuleThickness);
                    GimbalHeadingWidget.this.majorDegreesTickPaint.setStrokeWidth((float) GimbalHeadingWidget.this.majorDegreesTickThickness);
                    GimbalHeadingWidget.this.majorDegreesTextPaint.setTextSize((float) GimbalHeadingWidget.this.majorDegreesTextSize);
                    GimbalHeadingWidget.this.currentDegreesTextPaint.setTextSize((float) GimbalHeadingWidget.this.currentDegreesTextSize);
                    GimbalHeadingWidget.this.invalidate();
                }
            });
        }
    }

    public void updateOSD() {
        this.gimbalHFOV = 60.0f;
        float convertTrueToPrefDisplay = (float) Utils.convertTrueToPrefDisplay(this.uasItem.getGeoPoint(), this.uasItem.getGimbalAngle());
        this.gimbalHeading = convertTrueToPrefDisplay;
        if (convertTrueToPrefDisplay < 0.0f) {
            this.gimbalHeading = convertTrueToPrefDisplay + 360.0f;
        }
        this.measuredWidth = getMeasuredWidth();
        int measuredHeight2 = getMeasuredHeight();
        this.measuredHeight = measuredHeight2;
        this.horizontalRuleY = ((float) measuredHeight2) * 0.5f;
        float f = this.gimbalHFOV;
        int i = this.majorDegrees;
        this.majorDegreesCount = (int) (f / ((float) i));
        float f2 = this.gimbalHeading - (f / 2.0f);
        this.windowStartDegrees = f2;
        this.startMajorDegrees = (int) (((float) i) * ((float) Math.floor((double) (f2 / ((float) i)))));
        this.majorDegreesTextY = (float) (this.measuredHeight - 10);
        int i2 = this.measuredWidth / 2;
        this.needleCenterX = i2;
        this.currentDegreesRect.set((float) ((i2 - ((int) (((float) this.currentDegreesTextWidth) * 0.5f))) - this.currentDegreesBackBufferX), ((this.horizontalRuleY - (((float) this.horizontalRuleThickness) * 2.0f)) - (((float) this.currentDegreesTextBounds.height()) * 0.5f)) - ((float) this.currentDegreesBackBufferY), (float) (this.needleCenterX + ((int) (((float) this.currentDegreesTextWidth) * 0.5f)) + this.currentDegreesBackBufferX), (this.horizontalRuleY - (((float) this.horizontalRuleThickness) * 2.0f)) + (((float) this.currentDegreesTextBounds.height()) * 0.5f) + ((float) this.currentDegreesBackBufferY));
        this.currentDegreesX = ((float) this.needleCenterX) - (((float) this.currentDegreesTextWidth) / 2.0f);
        this.currentDegreesY = (this.horizontalRuleY - (((float) this.horizontalRuleThickness) * 2.0f)) + (((float) this.currentDegreesTextBounds.height()) * 0.5f);
        if (this.uasItem == null || this.uasItem.isStale()) {
            this.currentDegreesText = this.staleText;
        } else {
            this.currentDegreesText = Utils.formatHeading(this.uasItem.getGeoPoint(), this.uasItem.getGimbalAngle());
        }
        this.currentDegreesTextWidth = (int) this.currentDegreesTextPaint.measureText(this.currentDegreesText);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void setTextColor(int i) {
        super.setTextColor(i);
        this.majorDegreesTextPaint.setColor(this.defaultTextColor);
        this.currentDegreesTextPaint.setColor(this.defaultTextColor);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode()) {
            drawHorizontalRule(canvas);
            drawMajorDegrees(canvas);
            drawCurrentDegree(canvas);
        }
    }

    private void drawHorizontalRule(Canvas canvas) {
        float f = this.horizontalRuleY;
        canvas.drawLine(0.0f, f, (float) this.measuredWidth, f, this.horizontalRulePaint);
    }

    private void drawMajorDegrees(Canvas canvas) {
        for (int i = 0; i <= this.majorDegreesCount + 1; i++) {
            float f = (float) (this.startMajorDegrees + (this.majorDegrees * i));
            float f2 = (f - this.windowStartDegrees) * (((float) this.measuredWidth) / this.gimbalHFOV);
            if (f < 0.0f) {
                f += 360.0f;
            } else if (f >= 360.0f) {
                f -= 360.0f;
            }
            String valueOf = String.valueOf((int) f);
            int i2 = this.majorDegreesTickThickness;
            float f3 = this.horizontalRuleY;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f2 - (((float) i2) * 0.5f), f3 - 8.0f, f2 - (((float) i2) * 0.5f), f3 + 16.0f, this.majorDegreesTickPaint);
            canvas.drawText(valueOf, f2 - (((float) ((int) this.majorDegreesTextPaint.measureText(valueOf))) / 2.0f), this.majorDegreesTextY, this.majorDegreesTextPaint);
        }
    }

    private void drawCurrentDegree(Canvas canvas) {
        canvas.drawRoundRect(this.currentDegreesRect, 12.0f, 12.0f, this.currentDegreesBackPaint);
        canvas.drawText(this.currentDegreesText, this.currentDegreesX, this.currentDegreesY, this.currentDegreesTextPaint);
    }
}
