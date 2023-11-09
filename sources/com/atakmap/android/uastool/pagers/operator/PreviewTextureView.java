package com.atakmap.android.uastool.pagers.operator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.partech.mobilevid.SharedGLSurfaceView;

public class PreviewTextureView extends SharedGLSurfaceView {
    private static final String TAG = "PreviewTextureView";
    /* access modifiers changed from: private */
    public ControlFragment controlFragment;
    private ScaleCallback onScaleChangedCallback;
    private UASItem selectedUASItem;

    public interface ScaleCallback {
        void onScaleChanged(float f);
    }

    public PreviewTextureView(Context context) {
        super(context);
    }

    public PreviewTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setUASItem(UASItem uASItem) {
        this.selectedUASItem = uASItem;
    }

    public Bitmap getBitmap(boolean z, boolean z2) {
        int i;
        int i2;
        Bitmap bitmap;
        int i3;
        Bitmap bitmap2;
        Bitmap bitmap3 = PreviewTextureView.super.getBitmap();
        if (!z && !z2) {
            return bitmap3;
        }
        int width = bitmap3.getWidth();
        int height = bitmap3.getHeight();
        int i4 = 0;
        if (z2) {
            bitmap = UASToolDropDownReceiver.loadBitmapFromView(this.controlFragment.getArOverlay());
            i2 = bitmap.getWidth();
            i = bitmap.getHeight();
        } else {
            bitmap = null;
            i2 = 0;
            i = 0;
        }
        if (z) {
            Bitmap bitmap4 = this.controlFragment.getVideoUI().getBitmap();
            int width2 = bitmap4.getWidth();
            i3 = bitmap4.getHeight();
            int i5 = width2;
            bitmap2 = bitmap4;
            i4 = i5;
        } else {
            bitmap2 = null;
            i3 = 0;
        }
        int max = Math.max(i4, Math.max(i2, width));
        int max2 = Math.max(i3, Math.max(i, width));
        Bitmap createBitmap = Bitmap.createBitmap(max, max2, bitmap3.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap3, width < max ? ((float) (max - width)) * 0.5f : 0.0f, height < max2 ? ((float) (max2 - height)) * 0.5f : 0.0f, (Paint) null);
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, i2 < max ? ((float) (max - i2)) * 0.5f : 0.0f, i < max2 ? ((float) (max2 - i)) * 0.5f : 0.0f, (Paint) null);
        }
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, i4 < max ? ((float) (max - i4)) * 0.5f : 0.0f, i3 < max2 ? ((float) (max2 - i3)) * 0.5f : 0.0f, (Paint) null);
        }
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        final int defaultSize = getDefaultSize(this.b, i);
        final int defaultSize2 = getDefaultSize(this.c, i2);
        if (this.b > 0 && this.c > 0) {
            if (this.b * defaultSize2 > this.c * defaultSize) {
                defaultSize2 = (this.c * defaultSize) / this.b;
            } else if (this.b * defaultSize2 < this.c * defaultSize) {
                defaultSize = (this.b * defaultSize2) / this.c;
            }
        }
        if (!isInEditMode()) {
            MapView.getMapView().post(new Runnable() {
                public void run() {
                    ArOverlayView arOverlay = PreviewTextureView.this.controlFragment.getArOverlay();
                    if (arOverlay != null) {
                        arOverlay.setDimension(defaultSize, defaultSize2);
                    }
                    PreviewTextureView.this.setMeasuredDimension(defaultSize, defaultSize2);
                }
            });
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setScale(float f) {
        ScaleCallback scaleCallback = this.onScaleChangedCallback;
        if (scaleCallback != null) {
            scaleCallback.onScaleChanged(f);
        }
        PreviewTextureView.super.setScale(f);
    }

    public void setOnScaleChangedCallback(ScaleCallback scaleCallback) {
        this.onScaleChangedCallback = scaleCallback;
    }

    public void setPanOffset(int i, int i2) {
        PreviewTextureView.super.setPanOffset(i, i2);
    }

    public void setControlFragment(ControlFragment controlFragment2) {
        this.controlFragment = controlFragment2;
    }
}
