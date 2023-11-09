package com.atakmap.android.uastool.pagers.joystick_ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.UIConstants;
import com.atakmap.coremap.log.Log;
import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JoystickUISticksView extends JoystickUIBase implements View.OnTouchListener {
    private static final float DEADZONE_PCT = 0.1f;
    private static final long REPORT_DELAY_MILLIS = 1000;
    private static final long REPORT_PERIOD_MILLIS = 100;
    public static final String TAG = "JoystickUISticksView";
    private float currentLeftTouchX;
    private float currentLeftTouchY;
    private float currentRightTouchX;
    private float currentRightTouchY;
    private Paint deadzonePaint;
    private float deadzoneRadius;
    private DecimalFormat debugFormat = new DecimalFormat("0.00");
    private boolean debugTest = false;
    private Paint debugTextPaint;
    private int halfScreenX;
    private int halfScreenY;
    private boolean hasVibrator;
    private boolean isLeftPastLimit;
    private boolean isRightPastLimit;
    private boolean isVibrating;
    private int leftPointerId;
    private Paint limitPaint;
    private float limitRadius;
    private float origLeftTouchX;
    private float origLeftTouchY;
    private float origRightTouchX;
    private float origRightTouchY;
    private int quarterScreenX;
    private final ScheduledExecutorService reportScheduler = Executors.newSingleThreadScheduledExecutor();
    private Future<?> reportSchedulerHandle = null;
    private int rightPointerId;
    private Paint stickPaint;
    private float stickRadius;
    private float valueLeftX;
    private float valueLeftY;
    private float valueRightX;
    private float valueRightY;
    private Vibrator vibrator;
    private int[] vibratorAmps = {20};
    private long[] vibratorPattern = {0, REPORT_DELAY_MILLIS, 0};
    private long[] vibratorTimings = {1000};

    /* access modifiers changed from: protected */
    public long getAnimDelay() {
        return REPORT_DELAY_MILLIS;
    }

    /* access modifiers changed from: protected */
    public long getAnimDuration() {
        return REPORT_DELAY_MILLIS;
    }

    /* access modifiers changed from: protected */
    public float getAnimEndAlpha() {
        return 0.3f;
    }

    /* access modifiers changed from: protected */
    public float getAnimStartAlpha() {
        return 0.8f;
    }

    public JoystickUISticksView(Context context) {
        super(context);
    }

    public JoystickUISticksView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public JoystickUISticksView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void toast(String str) {
        UASToolDropDownReceiver.toast(str);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.valueLeftX = 0.0f;
        this.valueLeftY = 0.0f;
        this.valueRightX = 0.0f;
        this.valueRightY = 0.0f;
        this.leftPointerId = -1;
        this.rightPointerId = -1;
        this.origLeftTouchX = -1.0f;
        this.origLeftTouchY = -1.0f;
        this.origRightTouchX = -1.0f;
        this.origRightTouchY = -1.0f;
        this.currentLeftTouchX = -1.0f;
        this.currentLeftTouchY = -1.0f;
        this.currentRightTouchX = -1.0f;
        this.currentRightTouchY = -1.0f;
        this.isLeftPastLimit = false;
        this.isRightPastLimit = false;
        this.stickRadius = (float) UIConstants.JOYSTICK_STICKS_STICK_RADIUS;
        Paint paint = new Paint();
        this.stickPaint = paint;
        paint.setAntiAlias(true);
        this.stickPaint.setStyle(Paint.Style.FILL);
        this.stickPaint.setARGB(255, 255, 255, 255);
        this.limitRadius = (float) UIConstants.JOYSTICK_STICKS_LIMIT_RADIUS;
        Paint paint2 = new Paint();
        this.limitPaint = paint2;
        paint2.setAntiAlias(true);
        this.limitPaint.setStyle(Paint.Style.STROKE);
        this.limitPaint.setStrokeWidth(3.0f);
        this.limitPaint.setARGB(255, 255, 255, 255);
        this.deadzoneRadius = this.limitRadius * DEADZONE_PCT;
        Paint paint3 = new Paint();
        this.deadzonePaint = paint3;
        paint3.setAntiAlias(true);
        this.deadzonePaint.setStyle(Paint.Style.STROKE);
        this.deadzonePaint.setStrokeWidth(3.0f);
        this.deadzonePaint.setARGB(255, 255, 255, 0);
        Paint paint4 = new Paint();
        this.debugTextPaint = paint4;
        paint4.setAntiAlias(true);
        this.debugTextPaint.setTextAlign(Paint.Align.RIGHT);
        this.debugTextPaint.setTextSize(42.0f);
        this.debugTextPaint.setARGB(255, 255, 255, 255);
        Vibrator vibrator2 = (Vibrator) this.pluginContext.getSystemService("vibrator");
        this.vibrator = vibrator2;
        this.hasVibrator = false;
        if (vibrator2 != null && vibrator2.hasVibrator()) {
            this.hasVibrator = true;
        }
        this.isVibrating = false;
        setWillNotDraw(false);
        setOnTouchListener(this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        int i5 = width / 2;
        this.halfScreenX = i5;
        int i6 = i5 / 2;
        this.quarterScreenX = i6;
        int i7 = height / 2;
        this.halfScreenY = i7;
        this.origLeftTouchX = (float) (i5 - i6);
        this.origLeftTouchY = (float) i7;
        this.origRightTouchX = (float) (i5 + i6);
        this.origRightTouchY = (float) i7;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.valueLeftX = 0.0f;
        this.valueLeftY = 0.0f;
        this.valueRightX = 0.0f;
        this.valueRightY = 0.0f;
        reportJoystickPositions();
        vibrateStop();
        enableReporting(false);
        setOnTouchListener((View.OnTouchListener) null);
    }

    public void init(UASItem uASItem) {
        super.init(uASItem);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                ((RelativeLayout.LayoutParams) JoystickUISticksView.this.getLayoutParams()).setMargins(UIConstants.JOYSTICK_STICKS_LEFT_OFFSET_FULL, UIConstants.JOYSTICK_STICKS_TOP_OFFSET_FULL, 0, UIConstants.JOYSTICK_STICKS_BOTTOM_OFFSET_FULL);
                JoystickUISticksView.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void enableTouches(boolean z) {
        enableReporting(z);
        if (z) {
            setOnTouchListener(this);
            return;
        }
        setOnTouchListener((View.OnTouchListener) null);
        vibrateStop();
    }

    private void enableReporting(boolean z) {
        if (z) {
            try {
                this.reportSchedulerHandle = this.reportScheduler.scheduleAtFixedRate(new Runnable() {
                    public void run() {
                        try {
                            JoystickUISticksView.this.reportJoystickPositions();
                        } catch (Exception e) {
                            Log.d(JoystickUISticksView.TAG, "JoystickUI Report Scheduler Exception: ", e);
                        }
                    }
                }, REPORT_DELAY_MILLIS, REPORT_PERIOD_MILLIS, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                Log.e(TAG, "JoystickUI Report scheduleAtFixedRate Exception: ", e);
            }
        } else {
            Future<?> future = this.reportSchedulerHandle;
            if (future != null) {
                future.cancel(false);
                this.reportSchedulerHandle = null;
            }
            ScheduledExecutorService scheduledExecutorService = this.reportScheduler;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    onTouchMove(motionEvent);
                    return true;
                } else if (actionMasked == 3) {
                    onCancel();
                    return true;
                } else if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return false;
                    }
                }
            }
            onTouchUp(motionEvent);
            return true;
        }
        onTouchDown(motionEvent);
        return true;
    }

    private void onTouchDown(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        if (x <= ((float) this.halfScreenX)) {
            if (this.leftPointerId < 0) {
                this.leftPointerId = pointerId;
                this.valueLeftX = 0.0f;
                this.valueLeftY = 0.0f;
                this.origLeftTouchX = x;
                this.origLeftTouchY = y;
                this.currentLeftTouchX = x;
                this.currentLeftTouchY = y;
            }
        } else if (this.rightPointerId < 0) {
            this.rightPointerId = pointerId;
            this.valueRightX = 0.0f;
            this.valueRightY = 0.0f;
            this.origRightTouchX = x;
            this.origRightTouchY = y;
            this.currentRightTouchX = x;
            this.currentRightTouchY = y;
        }
        startAnimation(this.alphaAnim);
        invalidate();
    }

    private void onTouchUp(MotionEvent motionEvent) {
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (pointerId == this.leftPointerId) {
            this.leftPointerId = -1;
            this.valueLeftX = 0.0f;
            this.valueLeftY = 0.0f;
            this.currentLeftTouchX = -1.0f;
            this.currentLeftTouchY = -1.0f;
            this.isLeftPastLimit = false;
        } else if (pointerId == this.rightPointerId) {
            this.rightPointerId = -1;
            this.valueRightX = 0.0f;
            this.valueRightY = 0.0f;
            this.currentRightTouchX = -1.0f;
            this.currentRightTouchY = -1.0f;
            this.isRightPastLimit = false;
        }
        if (this.isLeftPastLimit || this.isRightPastLimit) {
            vibrateStart();
        } else {
            vibrateStop();
        }
        invalidate();
    }

    private void onTouchMove(MotionEvent motionEvent) {
        int i;
        MotionEvent motionEvent2 = motionEvent;
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2 = i + 1) {
            int pointerId = motionEvent2.getPointerId(i2);
            int findPointerIndex = motionEvent2.findPointerIndex(pointerId);
            float x = motionEvent2.getX(findPointerIndex);
            float y = motionEvent2.getY(findPointerIndex);
            if (pointerId == this.leftPointerId) {
                double d = (double) (x - this.origLeftTouchX);
                double d2 = (double) (y - this.origLeftTouchY);
                double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
                i = i2;
                if (sqrt < ((double) this.deadzoneRadius)) {
                    this.currentLeftTouchX = x;
                    this.currentLeftTouchY = y;
                    this.isLeftPastLimit = false;
                    this.valueLeftX = 0.0f;
                    this.valueLeftY = 0.0f;
                } else {
                    if (sqrt < ((double) this.limitRadius)) {
                        this.currentLeftTouchX = x;
                        this.currentLeftTouchY = y;
                        this.isLeftPastLimit = false;
                    } else {
                        double atan2 = Math.atan2(d2, d);
                        this.currentLeftTouchX = this.origLeftTouchX + ((float) (((double) this.limitRadius) * Math.cos(atan2)));
                        this.currentLeftTouchY = this.origLeftTouchY + ((float) (((double) this.limitRadius) * Math.sin(atan2)));
                        this.isLeftPastLimit = true;
                    }
                    float f = this.currentLeftTouchX - this.origLeftTouchX;
                    float f2 = this.limitRadius;
                    this.valueLeftX = f / f2;
                    this.valueLeftY = (this.origLeftTouchY - this.currentLeftTouchY) / f2;
                }
            } else {
                i = i2;
                if (pointerId == this.rightPointerId) {
                    double d3 = (double) (x - this.origRightTouchX);
                    double d4 = (double) (y - this.origRightTouchY);
                    double sqrt2 = Math.sqrt(Math.pow(d3, 2.0d) + Math.pow(d4, 2.0d));
                    if (sqrt2 < ((double) this.deadzoneRadius)) {
                        this.currentRightTouchX = x;
                        this.currentRightTouchY = y;
                        this.isRightPastLimit = false;
                        this.valueRightX = 0.0f;
                        this.valueRightY = 0.0f;
                    } else {
                        if (sqrt2 < ((double) this.limitRadius)) {
                            this.currentRightTouchX = x;
                            this.currentRightTouchY = y;
                            this.isRightPastLimit = false;
                        } else {
                            double atan22 = Math.atan2(d4, d3);
                            this.currentRightTouchX = this.origRightTouchX + ((float) (((double) this.limitRadius) * Math.cos(atan22)));
                            this.currentRightTouchY = this.origRightTouchY + ((float) (((double) this.limitRadius) * Math.sin(atan22)));
                            this.isRightPastLimit = true;
                        }
                        float f3 = this.currentRightTouchX - this.origRightTouchX;
                        float f4 = this.limitRadius;
                        this.valueRightX = f3 / f4;
                        this.valueRightY = (this.origRightTouchY - this.currentRightTouchY) / f4;
                    }
                }
            }
        }
        if (this.isLeftPastLimit || this.isRightPastLimit) {
            vibrateStart();
        } else {
            vibrateStop();
        }
        invalidate();
    }

    private void onCancel() {
        this.valueLeftX = 0.0f;
        this.valueLeftY = 0.0f;
        this.valueRightX = 0.0f;
        this.valueRightY = 0.0f;
        this.leftPointerId = -1;
        this.rightPointerId = -1;
        int i = this.halfScreenX;
        int i2 = this.quarterScreenX;
        this.origLeftTouchX = (float) (i - i2);
        int i3 = this.halfScreenY;
        this.origLeftTouchY = (float) i3;
        this.origRightTouchX = (float) (i + i2);
        this.origRightTouchY = (float) i3;
        this.currentLeftTouchX = -1.0f;
        this.currentLeftTouchY = -1.0f;
        this.currentRightTouchX = -1.0f;
        this.currentRightTouchY = -1.0f;
        this.isLeftPastLimit = false;
        this.isRightPastLimit = false;
        vibrateStop();
        invalidate();
    }

    private void vibrateStart() {
        if (this.hasVibrator && !this.isVibrating) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.vibrator.vibrate(VibrationEffect.createWaveform(this.vibratorTimings, this.vibratorAmps, 0));
            } else {
                this.vibrator.vibrate(this.vibratorPattern, 0);
            }
            this.isVibrating = true;
        }
    }

    private void vibrateStop() {
        if (this.hasVibrator && this.isVibrating) {
            this.vibrator.cancel();
        }
        this.isVibrating = false;
    }

    /* access modifiers changed from: private */
    public void reportJoystickPositions() {
        if (this.uasItem != null) {
            this.uasItem.joystickPosition(this.valueLeftX, this.valueLeftY, this.valueRightX, this.valueRightY);
        } else {
            toast("Null UASItem");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.origLeftTouchX, this.origLeftTouchY, this.limitRadius, this.limitPaint);
        canvas.drawCircle(this.origRightTouchX, this.origRightTouchY, this.limitRadius, this.limitPaint);
        canvas.drawCircle(this.origLeftTouchX, this.origLeftTouchY, this.deadzoneRadius, this.deadzonePaint);
        canvas.drawCircle(this.origRightTouchX, this.origRightTouchY, this.deadzoneRadius, this.deadzonePaint);
        if (this.leftPointerId >= 0) {
            canvas.drawCircle(this.currentLeftTouchX, this.currentLeftTouchY, this.stickRadius, this.stickPaint);
        } else {
            canvas.drawCircle(this.origLeftTouchX, this.origLeftTouchY, this.stickRadius, this.stickPaint);
        }
        if (this.rightPointerId >= 0) {
            canvas.drawCircle(this.currentRightTouchX, this.currentRightTouchY, this.stickRadius, this.stickPaint);
        } else {
            canvas.drawCircle(this.origRightTouchX, this.origRightTouchY, this.stickRadius, this.stickPaint);
        }
        if (this.debugTest) {
            if (this.leftPointerId >= 0) {
                canvas.drawText(this.debugFormat.format((double) this.valueLeftX), this.origLeftTouchX, (this.origLeftTouchY - this.limitRadius) - 42.0f, this.debugTextPaint);
                canvas.drawText(this.debugFormat.format((double) this.valueLeftY), this.origLeftTouchX, (this.origLeftTouchY - this.limitRadius) - 8.0f, this.debugTextPaint);
            }
            if (this.rightPointerId >= 0) {
                canvas.drawText(this.debugFormat.format((double) this.valueRightX), this.origRightTouchX, (this.origRightTouchY - this.limitRadius) - 42.0f, this.debugTextPaint);
                canvas.drawText(this.debugFormat.format((double) this.valueRightY), this.origRightTouchX, (this.origRightTouchY - this.limitRadius) - 8.0f, this.debugTextPaint);
            }
        }
    }
}
