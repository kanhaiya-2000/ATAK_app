package com.atakmap.android.uastool.prefs.controllersetup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.atakmap.android.uastool.plugin.C1877R;

public class ControllerSetupView extends View implements View.OnGenericMotionListener {
    private final RectF agnosticFeedbackRect;
    private final RectF agnosticRect;
    private String axisText;
    private final Paint controlStickPaint;
    private final float controlStickRadius = 20.0f;
    private final RectF controllerRect;
    private String controllerText;
    private final float currentCtlRadius = 50.0f;
    private final Circle currentLeftCtlPos;
    private final Circle currentRightCtlPos;
    private final Paint feedbackElementPaint;
    private final Circle leftControlStick;
    private final Circle leftControlStickOutline;
    private final RectF leftControlTarget;
    private final RectF ltFeedbackRect;
    private final RectF ltRect;
    private final Paint outlinePaint;
    private final Circle rightControlStick;
    private final Circle rightControlStickOutline;
    private final RectF rightControlTarget;
    private final RectF rtFeedbackRect;
    private final RectF rtRect;
    public String setupGuidanceMessage;
    private final float stickOutlineRadius = 100.0f;
    private final Paint textPaint;

    public ControllerSetupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.outlinePaint = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint();
        this.controlStickPaint = paint2;
        paint2.setColor(context.getResources().getColor(C1877R.color.lightBlue));
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint3 = new Paint();
        this.feedbackElementPaint = paint3;
        paint3.setColor(-1);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        TextPaint textPaint2 = new TextPaint();
        this.textPaint = textPaint2;
        textPaint2.setTextSize(25.0f);
        textPaint2.setColor(-1);
        this.axisText = "";
        this.controllerText = "";
        this.setupGuidanceMessage = "";
        this.controllerRect = new RectF();
        this.ltRect = new RectF();
        this.rtRect = new RectF();
        this.ltFeedbackRect = new RectF();
        this.rtFeedbackRect = new RectF();
        this.agnosticRect = new RectF();
        this.agnosticFeedbackRect = new RectF();
        this.leftControlStickOutline = new Circle();
        this.rightControlStickOutline = new Circle();
        this.leftControlStick = new Circle();
        this.rightControlStick = new Circle();
        this.currentLeftCtlPos = new Circle();
        this.currentRightCtlPos = new Circle();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
        this.leftControlTarget = new RectF();
        this.rightControlTarget = new RectF();
        setOnGenericMotionListener(this);
        requestFocus();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(C1877R.color.alpha_dark_gray));
        int width = getWidth() / 6;
        int height = getHeight() / 6;
        int width2 = getWidth() - width;
        float height2 = (float) (getHeight() - height);
        this.controllerRect.set((float) width, (float) height, (float) width2, height2);
        float f = (float) 15;
        canvas.drawRoundRect(this.controllerRect, f, f, this.outlinePaint);
        drawLtRtFeedback(canvas);
        drawAgnosticFeedback(canvas);
        float width3 = this.controllerRect.width() / 4.0f;
        float centerX = this.controllerRect.centerX() - width3;
        float centerX2 = this.controllerRect.centerX() + width3;
        float f2 = height2 - 150.0f;
        canvas.drawCircle(centerX, f2, 100.0f, this.outlinePaint);
        canvas.drawCircle(centerX2, f2, 100.0f, this.outlinePaint);
        this.leftControlStickOutline.setCircle(centerX, f2, 100.0f);
        this.rightControlStickOutline.setCircle(centerX2, f2, 100.0f);
        setStickUIState(centerX, f2, centerX2, f2);
        setLtRtPromptState(canvas);
        canvas.drawCircle(this.currentLeftCtlPos.getCenterX(), this.currentLeftCtlPos.getCenterY(), this.currentLeftCtlPos.getRadius(), this.feedbackElementPaint);
        canvas.drawCircle(this.currentRightCtlPos.getCenterX(), this.currentRightCtlPos.getCenterY(), this.currentRightCtlPos.getRadius(), this.feedbackElementPaint);
        canvas.drawCircle(this.leftControlStick.getCenterX(), this.leftControlStick.getCenterY(), 20.0f, this.controlStickPaint);
        canvas.drawCircle(this.rightControlStick.getCenterX(), this.rightControlStick.getCenterY(), 20.0f, this.controlStickPaint);
        requestFocus();
    }

    private void drawAgnosticFeedback(Canvas canvas) {
        float height = ((float) canvas.getHeight()) - ((((float) canvas.getHeight()) - this.controllerRect.bottom) / 2.0f);
        this.agnosticRect.set(this.controllerRect.centerX() - 50.0f, height - 10.0f, this.controllerRect.centerX() + 50.0f, 10.0f + height);
        if (ControllerSetupVM.getInstance().getLastEvent() == null) {
            this.agnosticFeedbackRect.set(this.agnosticRect.centerX() - 5.0f, height - 20.0f, this.agnosticRect.centerX() + 5.0f, height + 20.0f);
        }
        canvas.drawRect(this.agnosticRect, this.outlinePaint);
        canvas.drawRect(this.agnosticFeedbackRect, this.feedbackElementPaint);
        canvas.drawText(this.axisText, this.agnosticRect.left, this.agnosticRect.bottom + 25.0f, this.textPaint);
        canvas.drawText(this.controllerText, this.controllerRect.left + 25.0f, this.controllerRect.top + 50.0f, this.textPaint);
        canvas.drawText(this.setupGuidanceMessage, this.controllerRect.left + 25.0f, this.controllerRect.top + 175.0f, this.textPaint);
    }

    private void setStickUIState(float f, float f2, float f3, float f4) {
        int calibrationStep = ControllerSetupVM.getInstance().getCalibrationStep();
        if (calibrationStep != 13) {
            switch (calibrationStep) {
                case 0:
                    break;
                case 1:
                    this.leftControlStick.setCircle(f, f2 - 100.0f, 20.0f);
                    this.rightControlStick.setCircle(f3, f4, 20.0f);
                    return;
                case 2:
                    this.leftControlStick.setCircle(f, f2 + 100.0f, 20.0f);
                    this.rightControlStick.setCircle(f3, f4, 20.0f);
                    return;
                case 3:
                    this.leftControlStick.setCircle(f + 100.0f, f2, 20.0f);
                    this.rightControlStick.setCircle(f3, f4, 20.0f);
                    return;
                case 4:
                    this.leftControlStick.setCircle(f - 100.0f, f2, 20.0f);
                    this.rightControlStick.setCircle(f3, f4, 20.0f);
                    return;
                case 5:
                    this.leftControlStick.setCircle(f, f2, 20.0f);
                    this.rightControlStick.setCircle(f3 + 100.0f, f4, 20.0f);
                    return;
                case 6:
                    this.leftControlStick.setCircle(f, f2, 20.0f);
                    this.rightControlStick.setCircle(f3 - 100.0f, f4, 20.0f);
                    return;
                case 7:
                    this.leftControlStick.setCircle(f, f2, 20.0f);
                    this.rightControlStick.setCircle(f3, f4 - 100.0f, 20.0f);
                    return;
                case 8:
                    this.leftControlStick.setCircle(f, f2, 20.0f);
                    this.rightControlStick.setCircle(f3, f4 + 100.0f, 20.0f);
                    return;
                case 9:
                    this.leftControlStick.setCircle(f, f2, 20.0f);
                    this.rightControlStick.setCircle(f3, f4, 20.0f);
                    return;
                default:
                    return;
            }
        }
        this.leftControlStick.setCircle(f, f2, 20.0f);
        this.rightControlStick.setCircle(f3, f4, 20.0f);
        if (ControllerSetupVM.getInstance().getLastEvent() == null) {
            this.currentLeftCtlPos.setCircle(this.leftControlStickOutline.getCenterX(), this.leftControlStickOutline.getCenterY(), 50.0f);
            this.currentRightCtlPos.setCircle(this.rightControlStickOutline.getCenterX(), this.rightControlStickOutline.getCenterY(), 50.0f);
        }
    }

    private void drawLtRtFeedback(Canvas canvas) {
        int width = canvas.getWidth();
        canvas.getHeight();
        float f = this.controllerRect.left / 2.0f;
        float f2 = this.controllerRect.top;
        float f3 = (float) width;
        float f4 = f3 - ((f3 - this.controllerRect.right) / 2.0f);
        float f5 = this.controllerRect.top;
        float height = (this.controllerRect.height() / 6.0f) + f2;
        this.ltRect.set(f - 5.0f, f2, f + 5.0f, height);
        this.rtRect.set(f4 - 5.0f, f5, f4 + 5.0f, height);
        if (ControllerSetupVM.getInstance().getLastEvent() == null) {
            this.ltFeedbackRect.set(this.ltRect.left - 20.0f, this.ltRect.centerY() - 5.0f, this.ltRect.right + 20.0f, this.ltRect.centerY() + 5.0f);
            this.rtFeedbackRect.set(this.rtRect.left - 20.0f, this.rtRect.centerY() - 5.0f, this.rtRect.right + 20.0f, this.rtRect.centerY() + 5.0f);
        }
        canvas.drawRect(this.ltRect, this.outlinePaint);
        canvas.drawRect(this.rtRect, this.outlinePaint);
        canvas.drawRect(this.ltFeedbackRect, this.feedbackElementPaint);
        canvas.drawRect(this.rtFeedbackRect, this.feedbackElementPaint);
    }

    private void setLtRtPromptState(Canvas canvas) {
        switch (ControllerSetupVM.getInstance().getCalibrationStep()) {
            case 9:
                this.leftControlTarget.set(this.ltRect.left - 10.0f, (this.ltRect.centerY() - 5.0f) - (this.ltRect.height() / 2.0f), this.ltRect.right + 10.0f, (this.ltRect.centerY() + 5.0f) - (this.ltRect.height() / 2.0f));
                this.rightControlTarget.set(this.rtRect.left - 10.0f, this.rtRect.centerY() - 5.0f, this.rtRect.right + 10.0f, this.rtRect.centerY() + 5.0f);
                break;
            case 10:
                this.leftControlTarget.set(this.ltRect.left - 10.0f, (this.ltRect.centerY() - 5.0f) + (this.ltRect.height() / 2.0f), this.ltRect.right + 10.0f, this.ltRect.centerY() + 5.0f + (this.ltRect.height() / 2.0f));
                this.rightControlTarget.set(this.rtRect.left - 10.0f, this.rtRect.centerY() - 5.0f, this.rtRect.right + 10.0f, this.rtRect.centerY() + 5.0f);
                break;
            case 11:
                this.leftControlTarget.set(this.ltRect.left - 10.0f, this.ltRect.centerY() - 5.0f, this.ltRect.right + 10.0f, this.ltRect.centerY() + 5.0f);
                this.rightControlTarget.set(this.rtRect.left - 10.0f, (this.rtRect.centerY() - 5.0f) - (this.rtRect.height() / 2.0f), this.rtRect.right + 10.0f, (this.rtRect.centerY() + 5.0f) - (this.rtRect.height() / 2.0f));
                break;
            case 12:
                this.leftControlTarget.set(this.ltRect.left - 10.0f, this.ltRect.centerY() - 5.0f, this.ltRect.right + 10.0f, this.ltRect.centerY() + 5.0f);
                this.rightControlTarget.set(this.rtRect.left - 10.0f, (this.rtRect.centerY() - 5.0f) + (this.rtRect.height() / 2.0f), this.rtRect.right + 10.0f, this.rtRect.centerY() + 5.0f + (this.rtRect.height() / 2.0f));
                break;
            default:
                this.leftControlTarget.set(this.ltRect.left - 10.0f, this.ltRect.centerY() - 5.0f, this.ltRect.right + 10.0f, this.ltRect.centerY() + 5.0f);
                this.rightControlTarget.set(this.rtRect.left - 10.0f, this.rtRect.centerY() - 5.0f, this.rtRect.right + 10.0f, this.rtRect.centerY() + 5.0f);
                break;
        }
        canvas.drawRect(this.leftControlTarget, this.controlStickPaint);
        canvas.drawRect(this.rightControlTarget, this.controlStickPaint);
    }

    private boolean axisIsActivated(float f, int i, MotionEvent motionEvent) {
        if (motionEvent.getDevice().getMotionRange(i, motionEvent.getSource()) != null && Math.abs(f) > motionEvent.getDevice().getMotionRange(i, motionEvent.getSource()).getFlat()) {
            return true;
        }
        return false;
    }

    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        String str;
        if ((motionEvent.getSource() & 16777232) != 16777232 || motionEvent.getAction() != 2) {
            return false;
        }
        String name = motionEvent.getDevice().getName();
        if (name.isEmpty()) {
            name = "PARROT_ANAFI_MPP3";
        }
        ControllerConfig controllerConfig = ControllerConfigStore.getControllerConfig(name);
        int axis = ControllerSetupVM.getInstance().getAxis(motionEvent);
        float centerX = this.leftControlStickOutline.getCenterX() + (this.leftControlStickOutline.getRadius() * (motionEvent.getAxisValue(controllerConfig.leftXAxis) / controllerConfig.maxLeftXValue()));
        float centerY = this.leftControlStickOutline.getCenterY() + (this.leftControlStickOutline.getRadius() * (motionEvent.getAxisValue(controllerConfig.leftYAxis) / controllerConfig.maxLeftYValue()));
        float centerX2 = this.rightControlStickOutline.getCenterX() + (this.rightControlStickOutline.getRadius() * (motionEvent.getAxisValue(controllerConfig.rightXAxis) / controllerConfig.maxRightXValue()));
        float centerY2 = this.rightControlStickOutline.getCenterY() + (this.rightControlStickOutline.getRadius() * (motionEvent.getAxisValue(controllerConfig.rightYAxis) / controllerConfig.maxRightYValue()));
        float centerY3 = this.ltRect.centerY() - ((this.ltRect.height() / 2.0f) * (motionEvent.getAxisValue(controllerConfig.leftTriggerAxis) / controllerConfig.maxLeftTriggerValue()));
        float centerY4 = this.rtRect.centerY() - ((this.rtRect.height() / 2.0f) * (motionEvent.getAxisValue(controllerConfig.rightTriggerAxis) / controllerConfig.maxRightTriggerValue()));
        float centerX3 = this.agnosticRect.centerX() + ((this.agnosticRect.width() / 2.0f) * motionEvent.getAxisValue(axis));
        StringBuilder sb = new StringBuilder();
        sb.append("Axis: ");
        if (axisIsActivated(motionEvent.getAxisValue(axis), axis, motionEvent)) {
            str = axis + "(" + String.format("%.2f", new Object[]{Float.valueOf(motionEvent.getAxisValue(axis))}) + ")";
        } else {
            str = "";
        }
        sb.append(str);
        this.axisText = sb.toString();
        this.controllerText = name;
        this.agnosticFeedbackRect.set(centerX3 - 5.0f, this.agnosticRect.centerY() - 20.0f, centerX3 + 5.0f, this.agnosticRect.centerY() + 20.0f);
        this.currentLeftCtlPos.setCircle(centerX, centerY, 50.0f);
        this.currentRightCtlPos.setCircle(centerX2, centerY2, 50.0f);
        this.ltFeedbackRect.set(this.ltRect.left - 20.0f, centerY3 - 5.0f, this.ltRect.right + 20.0f, centerY3 + 5.0f);
        this.rtFeedbackRect.set(this.rtRect.left - 20.0f, centerY4 - 5.0f, this.rtRect.right + 20.0f, centerY4 + 5.0f);
        ControllerSetupVM.getInstance().updateMotionEvent(MotionEvent.obtain(motionEvent));
        invalidate();
        return true;
    }
}
