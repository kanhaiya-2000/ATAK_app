package com.atakmap.android.uastool.tflite.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.atakmap.android.uastool.tflite.Detector;
import java.util.List;

public class RecognitionScoreView extends View implements ResultsView {
    private static final float TEXT_SIZE_DIP = 14.0f;
    private final Paint bgPaint;
    private final Paint fgPaint;
    private List<Detector.Recognition> results;
    private final float textSizePx;

    public RecognitionScoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float applyDimension = TypedValue.applyDimension(1, TEXT_SIZE_DIP, getResources().getDisplayMetrics());
        this.textSizePx = applyDimension;
        Paint paint = new Paint();
        this.fgPaint = paint;
        paint.setTextSize(applyDimension);
        Paint paint2 = new Paint();
        this.bgPaint = paint2;
        paint2.setColor(-868055564);
    }

    public void setResults(List<Detector.Recognition> list) {
        this.results = list;
        postInvalidate();
    }

    public void onDraw(Canvas canvas) {
        int textSize = (int) (this.fgPaint.getTextSize() * 1.5f);
        canvas.drawPaint(this.bgPaint);
        List<Detector.Recognition> list = this.results;
        if (list != null) {
            for (Detector.Recognition next : list) {
                canvas.drawText(next.getTitle() + ": " + next.getConfidence(), 10.0f, (float) textSize, this.fgPaint);
                textSize += (int) (this.fgPaint.getTextSize() * 1.5f);
            }
        }
    }
}
