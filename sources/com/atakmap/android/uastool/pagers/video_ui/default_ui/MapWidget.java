package com.atakmap.android.uastool.pagers.video_ui.default_ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.coremap.log.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MapWidget extends MovableWidget {
    public static final String TAG = MapWidget.class.getSimpleName();
    private static final ScheduledExecutorService captureScheduler = Executors.newSingleThreadScheduledExecutor();
    private static Future<?> captureSchedulerHandle = null;
    /* access modifiers changed from: private */
    public ImageView bitmapView;
    private final TakeScreenshotCaptureListener captureListener = new TakeScreenshotCaptureListener() {
        public void onCaptureStarted() {
        }

        public void onCaptureCompleted(final Bitmap bitmap) {
            if (bitmap != null) {
                ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        MapWidget.this.bitmapView.setImageBitmap(bitmap);
                    }
                });
            } else {
                Log.e(MapWidget.TAG, "Minimap capture null bitmap");
            }
        }

        public void onCaptureFailed(String str) {
            String str2 = MapWidget.TAG;
            Log.e(str2, "Minimap capture failed: " + str);
        }
    };
    /* access modifiers changed from: private */
    public TakeScreenshot takeSS;

    public MapWidget(Context context) {
        super(context);
    }

    public MapWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MapWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        isInEditMode();
        this.bitmapView = (ImageView) findViewById(C1877R.C1878id.bitmap_view);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!isInEditMode()) {
            hideMap();
        }
    }

    public void updateSize() {
        super.updateSize();
        if (!isInEditMode()) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    if (!MapWidget.this.isFullScreen()) {
                        MapWidget.this.setVisibility(4);
                    } else if (MapWidget.this.videoUIView.isOSDVisible()) {
                        MapWidget.this.setVisibility(0);
                    }
                    MapWidget.this.invalidate();
                }
            });
        }
    }

    public void setVisibility(int i) {
        if (Build.VERSION.SDK_INT < 25) {
            i = 4;
        }
        super.setVisibility(i);
        if (i == 0) {
            showMap();
        } else {
            hideMap();
        }
    }

    private void showMap() {
        startCapture();
    }

    private void hideMap() {
        stopCapture();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0 && getVisibility() == 0) {
            showMap();
        }
    }

    public void startCapture() {
        if (this.takeSS == null && !isInEditMode()) {
            this.takeSS = new TakeScreenshot(this.captureListener);
        }
        Future<?> future = captureSchedulerHandle;
        if (future != null) {
            future.cancel(false);
            captureSchedulerHandle = null;
        }
        captureSchedulerHandle = captureScheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    if (!MapWidget.this.isInEditMode()) {
                        MapWidget.this.takeSS.snap();
                    }
                } catch (Exception e) {
                    Log.e(MapWidget.TAG, "Minimap capture crash: ", e);
                }
            }
        }, 500, 500, TimeUnit.MILLISECONDS);
    }

    public void stopCapture() {
        Future<?> future = captureSchedulerHandle;
        if (future != null) {
            future.cancel(false);
            captureSchedulerHandle = null;
        }
    }
}
