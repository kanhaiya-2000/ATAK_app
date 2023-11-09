package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.atakmap.android.uastool.UASToolDropDownReceiver;

public class TaskProgressBar extends ProgressBar {
    private float barHeight;
    private float barLeft;
    private float barTop;
    private float barWidth;
    private Paint dividerPaint;
    private float dividerWidth;
    private int stageCnt = 1;

    public TaskProgressBar(Context context) {
        super(context);
    }

    public TaskProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TaskProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TaskProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setBarHeight(int i) {
        getLayoutParams().height = (int) (((float) i) * VideoUIView.SCALE);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.barLeft = (float) getPaddingStart();
            this.barTop = (float) getPaddingTop();
            this.barWidth = (float) getWidth();
            this.barHeight = (float) getHeight();
            this.dividerWidth = Math.max(1.0f, Math.min(5.0f, this.barWidth / 100.0f));
            Paint paint = new Paint();
            this.dividerPaint = paint;
            paint.setARGB(255, 255, 255, 255);
            this.dividerPaint.setStrokeWidth(this.dividerWidth);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.stageCnt;
        if (i > 1) {
            float f = this.barWidth / ((float) i);
            for (int i2 = 1; i2 < this.stageCnt; i2++) {
                float f2 = this.barLeft;
                float f3 = ((float) i2) * f;
                float f4 = this.barTop;
                canvas.drawLine(f2 + f3, f4, f2 + f3, f4 + this.barHeight, this.dividerPaint);
            }
        }
    }

    public void setStageCnt(int i) {
        if (i < 1) {
            UASToolDropDownReceiver.toast("Task progress stage count must be greater than 0 (setting to 1)", 0);
            i = 1;
        }
        this.stageCnt = i;
    }

    public int getStageCnt() {
        return this.stageCnt;
    }

    public void setStageProgress(int i, int i2) {
        int i3 = 100 / this.stageCnt;
        setProgress(((i - 1) * i3) + ((int) ((((float) i2) / 100.0f) * ((float) i3))));
    }
}
