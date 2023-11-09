package com.atakmap.android.uastool.tflite;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.util.Size;
import android.util.TypedValue;
import atak.core.agl;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.tflite.Detector;
import com.atakmap.android.uastool.tflite.customview.OverlayView;
import com.atakmap.android.uastool.tflite.env.BorderedText;
import com.atakmap.android.uastool.tflite.env.ImageUtils;
import com.atakmap.android.uastool.tflite.tracking.DetectedItemsList;
import com.atakmap.android.uastool.tflite.tracking.MultiBoxTracker;
import com.atakmap.android.uastool.utils.GLVideoConsumer;
import com.atakmap.coremap.log.Log;
import com.atakmap.math.PointD;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetectorActivity {
    private static final Size DESIRED_PREVIEW_SIZE = new Size(640, 480);
    private static final boolean MAINTAIN_ASPECT = false;
    private static final float MINIMUM_CONFIDENCE_TF_OD_API = 0.55f;
    /* access modifiers changed from: private */
    public static final DetectorMode MODE = DetectorMode.TF_OD_API;
    private static final boolean SAVE_PREVIEW_BITMAP = false;
    /* access modifiers changed from: private */
    public static final String TAG = "DetectorActivity";
    private static final float TEXT_SIZE_DIP = 10.0f;
    private static final int TF_OD_API_INPUT_SIZE = 300;
    private static final boolean TF_OD_API_IS_QUANTIZED = true;
    private static final String TF_OD_API_LABELS_FILE = "tflite/labelmap.txt";
    private static final String TF_OD_API_MODEL_FILE = "tflite/detect.tflite";
    private BorderedText borderedText;
    /* access modifiers changed from: private */
    public boolean computingDetection = false;
    /* access modifiers changed from: private */
    public Bitmap cropCopyBitmap = null;
    /* access modifiers changed from: private */
    public Matrix cropToFrameTransform;
    /* access modifiers changed from: private */
    public Bitmap croppedBitmap = null;
    public DetectedItemsList detectedItemsList;
    /* access modifiers changed from: private */
    public Detector detector;
    private Matrix frameToCropTransform;
    private GLVideoConsumer glVideoConsumer;
    /* access modifiers changed from: private */
    public long lastProcessingTimeMs;
    protected int previewHeight = 0;
    protected int previewWidth = 0;
    protected UASItem selectedUASItem;
    private Integer sensorOrientation;
    private long timestamp = 0;
    public MultiBoxTracker tracker;

    private enum DetectorMode {
        TF_OD_API
    }

    /* access modifiers changed from: protected */
    public int getScreenOrientation() {
        return 90;
    }

    static /* synthetic */ long access$004(DetectorActivity detectorActivity) {
        long j = detectorActivity.timestamp + 1;
        detectorActivity.timestamp = j;
        return j;
    }

    public boolean isReady() {
        return this.previewHeight > 0 && this.previewWidth > 0;
    }

    public void dispose() {
        stopOffscreenVideoConsumer();
        if (this.tracker != null) {
            MapView.getMapView().postDelayed(new Runnable() {
                public void run() {
                    DetectorActivity.this.tracker.trackResults(new ArrayList(), DetectorActivity.access$004(DetectorActivity.this));
                    if (UASToolDropDownReceiver.getControlFragment().trackingView != null) {
                        UASToolDropDownReceiver.getControlFragment().trackingView.postInvalidate();
                    }
                }
            }, 500);
        }
    }

    public void init() {
        startOffscreenVideoConsumer();
        if (this.detectedItemsList == null) {
            this.detectedItemsList = new DetectedItemsList();
        }
    }

    public void setUASItem(UASItem uASItem) {
        this.selectedUASItem = uASItem;
    }

    private void startOffscreenVideoConsumer() {
        try {
            this.glVideoConsumer = new GLVideoConsumer(UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(), UASToolDropDownReceiver.getReflector().usesYUVTexture());
        } catch (agl unused) {
            Log.e(TAG, "VideoConsumer init failed");
        }
        try {
            this.glVideoConsumer.start();
        } catch (GLVideoConsumer.VideoConsumerException unused2) {
            this.glVideoConsumer = null;
            Log.e(TAG, "VideoConsumer start failed");
        }
        UASToolDropDownReceiver.getInstance().getOffscreenDirector().a(this.glVideoConsumer);
    }

    private void stopOffscreenVideoConsumer() {
        if (this.glVideoConsumer != null) {
            UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(this.glVideoConsumer);
            this.glVideoConsumer.stop();
            this.glVideoConsumer = null;
        }
    }

    public void init_detector(int i, int i2, int i3) {
        if (i != 0 && i2 != 0) {
            BorderedText borderedText2 = new BorderedText(TypedValue.applyDimension(1, TEXT_SIZE_DIP, MapView.getMapView().getContext().getResources().getDisplayMetrics()));
            this.borderedText = borderedText2;
            borderedText2.setTypeface(Typeface.MONOSPACE);
            if (this.tracker == null) {
                this.tracker = new MultiBoxTracker(UASToolDropDownReceiver.getInstance().getPluginContext());
            }
            try {
                this.detector = TFLiteObjectDetectionAPIModel.create(UASToolDropDownReceiver.getInstance().getPluginContext(), TF_OD_API_MODEL_FILE, TF_OD_API_LABELS_FILE, 300, true);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, "Exception initializing Detector!", e);
                UASToolDropDownReceiver.toast("Detector could not be initialized", 0);
            }
            this.previewWidth = i;
            this.previewHeight = i2;
            C22032 r9 = new OverlayView.DrawCallback() {
                public void drawCallback(Canvas canvas) {
                    DetectorActivity.this.tracker.draw(canvas);
                }
            };
            if (UASToolDropDownReceiver.getControlFragment().trackingView != null) {
                this.tracker.setFrameConfiguration(UASToolDropDownReceiver.getControlFragment().trackingView.getWidth(), UASToolDropDownReceiver.getControlFragment().trackingView.getHeight(), 0);
                UASToolDropDownReceiver.getControlFragment().trackingView.addCallback(r9);
                this.tracker.setVideoConfiguration(this.previewWidth, this.previewHeight);
            } else {
                this.tracker.setFrameConfiguration(this.previewWidth, this.previewHeight, 0);
                this.tracker.setVideoConfiguration(this.previewWidth, this.previewHeight);
            }
            this.sensorOrientation = Integer.valueOf(i3 - getScreenOrientation());
            String str = TAG;
            Log.i(str, "Initializing at size " + this.previewWidth + "x" + this.previewHeight);
            this.croppedBitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
            this.frameToCropTransform = ImageUtils.getTransformationMatrix(this.previewWidth, this.previewHeight, 300, 300, this.sensorOrientation.intValue(), false);
            Matrix matrix = new Matrix();
            this.cropToFrameTransform = matrix;
            this.frameToCropTransform.invert(matrix);
        }
    }

    public void processImage(Bitmap bitmap) {
        String str = TAG;
        Log.d(str, "processImage()");
        final long j = this.timestamp + 1;
        this.timestamp = j;
        if (this.computingDetection) {
            Log.d(str, "Skipping detection, busy");
            return;
        }
        this.computingDetection = true;
        Log.d(str, "Preparing image " + j + " for detection in bg thread.");
        final Bitmap currentBitmap = this.glVideoConsumer.getCurrentBitmap();
        if (currentBitmap == null) {
            Log.d(str, "Bitmap is null");
            this.computingDetection = false;
            return;
        }
        if (!(this.previewHeight == currentBitmap.getHeight() && this.previewWidth == currentBitmap.getWidth())) {
            init_detector(currentBitmap.getWidth(), currentBitmap.getHeight(), 90);
        }
        try {
            new Canvas(this.croppedBitmap).drawBitmap(currentBitmap, this.frameToCropTransform, (Paint) null);
            runInBackground(new Runnable() {
                public void run() {
                    String access$100 = DetectorActivity.TAG;
                    Log.i(access$100, "Running detection on image " + j);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    List<Detector.Recognition> recognizeImage = DetectorActivity.this.detector.recognizeImage(DetectorActivity.this.croppedBitmap);
                    long unused = DetectorActivity.this.lastProcessingTimeMs = SystemClock.uptimeMillis() - uptimeMillis;
                    DetectorActivity detectorActivity = DetectorActivity.this;
                    Bitmap unused2 = detectorActivity.cropCopyBitmap = Bitmap.createBitmap(detectorActivity.croppedBitmap);
                    Canvas canvas = new Canvas(DetectorActivity.this.cropCopyBitmap);
                    Paint paint = new Paint();
                    paint.setColor(-65536);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(2.0f);
                    int i = C22054.f8417xd8f3a076[DetectorActivity.MODE.ordinal()];
                    ArrayList arrayList = new ArrayList();
                    Float.valueOf(0.0f);
                    Log.d(DetectorActivity.TAG, "");
                    for (Detector.Recognition next : recognizeImage) {
                        RectF location = next.getLocation();
                        if (location != null && next.getConfidence().floatValue() >= DetectorActivity.MINIMUM_CONFIDENCE_TF_OD_API) {
                            canvas.drawRect(location, paint);
                            DetectorActivity.this.cropToFrameTransform.mapRect(location);
                            next.setLocation(location);
                            arrayList.add(next);
                            if (!(DetectorActivity.this.selectedUASItem == null || DetectorActivity.this.selectedUASItem.getGeoPoint() == null)) {
                                DetectorActivity.this.detectedItemsList.add(UASToolDropDownReceiver.getInstance().getOperatorPager().getOperatorControlFragment().getArOverlay().clickToGeoPoint(new PointD((double) location.centerX(), (double) location.centerY()), true), next, currentBitmap, DetectorActivity.this.selectedUASItem);
                            }
                        }
                    }
                    currentBitmap.recycle();
                    DetectorActivity.this.tracker.trackResults(arrayList, j);
                    if (UASToolDropDownReceiver.getControlFragment().trackingView != null) {
                        UASToolDropDownReceiver.getControlFragment().trackingView.postInvalidate();
                    }
                    boolean unused3 = DetectorActivity.this.computingDetection = false;
                    DetectorActivity.this.cropCopyBitmap.recycle();
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "exception caught", e);
            this.computingDetection = false;
        }
    }

    /* renamed from: com.atakmap.android.uastool.tflite.DetectorActivity$4 */
    /* synthetic */ class C22054 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$tflite$DetectorActivity$DetectorMode */
        static final /* synthetic */ int[] f8417xd8f3a076;

        static {
            int[] iArr = new int[DetectorMode.values().length];
            f8417xd8f3a076 = iArr;
            try {
                iArr[DetectorMode.TF_OD_API.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void runInBackground(Runnable runnable) {
        new Thread(runnable).start();
    }
}
