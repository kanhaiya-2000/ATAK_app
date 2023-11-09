package com.atakmap.android.uastool.tflite.tracking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import com.atakmap.android.uastool.tflite.Detector;
import com.atakmap.android.uastool.tflite.env.BorderedText;
import com.atakmap.android.uastool.tflite.env.ImageUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultiBoxTracker {
    private static final int[] COLORS = {-16776961, -65536, -16711936, -256, -16711681, -65281, -1, Color.parseColor("#55FF55"), Color.parseColor("#FFA500"), Color.parseColor("#FF8888"), Color.parseColor("#AAAAFF"), Color.parseColor("#FFFFAA"), Color.parseColor("#55AAAA"), Color.parseColor("#AA33AA"), Color.parseColor("#0D0068")};
    private static final float MIN_SIZE = 16.0f;
    private static final float TEXT_SIZE_DIP = 18.0f;
    private final Queue<Integer> availableColors = new LinkedList();
    private final BorderedText borderedText;
    private final Paint boxPaint = new Paint();
    private int frameHeight;
    private Matrix frameToCanvasMatrix;
    private int frameWidth;
    final List<Pair<Float, RectF>> screenRects = new LinkedList();
    private int sensorOrientation;
    private final float textSizePx;
    private final List<TrackedRecognition> trackedObjects = new LinkedList();
    private int videoHeight;
    private int videoWidth;

    public MultiBoxTracker(Context context) {
        for (int valueOf : COLORS) {
            this.availableColors.add(Integer.valueOf(valueOf));
        }
        this.boxPaint.setColor(-65536);
        this.boxPaint.setStyle(Paint.Style.STROKE);
        this.boxPaint.setStrokeWidth(10.0f);
        this.boxPaint.setStrokeCap(Paint.Cap.ROUND);
        this.boxPaint.setStrokeJoin(Paint.Join.ROUND);
        this.boxPaint.setStrokeMiter(100.0f);
        float applyDimension = TypedValue.applyDimension(1, TEXT_SIZE_DIP, context.getResources().getDisplayMetrics());
        this.textSizePx = applyDimension;
        this.borderedText = new BorderedText(applyDimension);
    }

    public synchronized void setFrameConfiguration(int i, int i2, int i3) {
        this.frameWidth = i;
        this.frameHeight = i2;
        this.sensorOrientation = i3;
    }

    public synchronized void setVideoConfiguration(int i, int i2) {
        this.videoWidth = i;
        this.videoHeight = i2;
    }

    public synchronized void drawDebug(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize(60.0f);
        Paint paint2 = new Paint();
        paint2.setColor(-65536);
        paint2.setAlpha(200);
        paint2.setStyle(Paint.Style.STROKE);
        for (Pair next : this.screenRects) {
            RectF rectF = (RectF) next.second;
            canvas.drawRect(rectF, paint2);
            canvas.drawText("" + next.first, rectF.left, rectF.top, paint);
            BorderedText borderedText2 = this.borderedText;
            float centerX = rectF.centerX();
            float centerY = rectF.centerY();
            borderedText2.drawText(canvas, centerX, centerY, "" + next.first);
        }
    }

    public synchronized void trackResults(List<Detector.Recognition> list, long j) {
        processResults(list);
    }

    private Matrix getFrameToCanvasMatrix() {
        return this.frameToCanvasMatrix;
    }

    public synchronized void draw(Canvas canvas) {
        String str;
        canvas.drawColor(0);
        boolean z = this.sensorOrientation % 180 == 90;
        float min = Math.min(((float) canvas.getHeight()) / ((float) (z ? this.frameWidth : this.frameHeight)), ((float) canvas.getWidth()) / ((float) (z ? this.frameHeight : this.frameWidth)));
        int i = this.frameWidth;
        int i2 = this.frameHeight;
        this.frameToCanvasMatrix = ImageUtils.getTransformationMatrix(i, i2, (int) (((float) (z ? i2 : i)) * min), (int) (min * ((float) (z ? i : i2))), this.sensorOrientation, false);
        for (TrackedRecognition next : this.trackedObjects) {
            RectF rectF = new RectF(next.location);
            getFrameToCanvasMatrix().mapRect(rectF);
            this.boxPaint.setColor(next.color);
            rectF.bottom *= ((float) this.frameHeight) / ((float) this.videoHeight);
            rectF.top *= ((float) this.frameHeight) / ((float) this.videoHeight);
            rectF.left *= ((float) this.frameWidth) / ((float) this.videoWidth);
            rectF.right *= ((float) this.frameWidth) / ((float) this.videoWidth);
            float min2 = Math.min(rectF.width(), rectF.height()) / 8.0f;
            canvas.drawRoundRect(rectF, min2, min2, this.boxPaint);
            if (!TextUtils.isEmpty(next.title)) {
                str = String.format("%s %.2f", new Object[]{next.title, Float.valueOf(next.detectionConfidence * 100.0f)});
            } else {
                str = String.format("%.2f", new Object[]{Float.valueOf(next.detectionConfidence * 100.0f)});
            }
            this.borderedText.drawText(canvas, rectF.left + min2, rectF.top, str + "%", this.boxPaint);
        }
    }

    private void processResults(List<Detector.Recognition> list) {
        LinkedList<Pair> linkedList = new LinkedList<>();
        this.screenRects.clear();
        Matrix matrix = new Matrix(getFrameToCanvasMatrix());
        for (Detector.Recognition next : list) {
            if (next.getLocation() != null) {
                RectF rectF = new RectF(next.getLocation());
                RectF rectF2 = new RectF();
                matrix.mapRect(rectF2, rectF);
                this.screenRects.add(new Pair(next.getConfidence(), rectF2));
                if (rectF.width() >= MIN_SIZE && rectF.height() >= MIN_SIZE) {
                    linkedList.add(new Pair(next.getConfidence(), next));
                }
            }
        }
        this.trackedObjects.clear();
        if (!linkedList.isEmpty()) {
            for (Pair pair : linkedList) {
                TrackedRecognition trackedRecognition = new TrackedRecognition();
                trackedRecognition.detectionConfidence = ((Float) pair.first).floatValue();
                trackedRecognition.location = new RectF(((Detector.Recognition) pair.second).getLocation());
                trackedRecognition.title = ((Detector.Recognition) pair.second).getTitle();
                int[] iArr = COLORS;
                trackedRecognition.color = iArr[this.trackedObjects.size()];
                this.trackedObjects.add(trackedRecognition);
                if (this.trackedObjects.size() >= iArr.length) {
                    return;
                }
            }
        }
    }

    private static class TrackedRecognition {
        int color;
        float detectionConfidence;
        RectF location;
        String title;

        private TrackedRecognition() {
        }
    }
}
