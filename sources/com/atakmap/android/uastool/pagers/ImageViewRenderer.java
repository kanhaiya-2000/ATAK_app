package com.atakmap.android.uastool.pagers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.video.i;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.log.Log;
import com.partech.pgscmedia.MediaException;
import com.partech.pgscmedia.VideoMediaFormat;
import com.partech.pgscmedia.consumers.VideoConsumer;
import com.partech.pgscmedia.frameaccess.NativeIntArray;
import com.partech.pgscmedia.frameaccess.VideoFrameConverter;
import com.partech.pgscmedia.frameaccess.VideoFrameData;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageViewRenderer implements VideoConsumer, Runnable {
    public static final String TAG = "ImageViewRenderer";
    private static Paint paint = new Paint();

    /* renamed from: r */
    private static Rect f8395r = new Rect();
    private static SimpleDateFormat timeBarFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", LocaleUtil.getCurrent());
    private long LIVECLOSEENOUGH = 3000;
    /* access modifiers changed from: private */
    public Bitmap bitmap = null;
    private Canvas canvas = null;
    private VideoFrameConverter converter = null;
    private long currentTime = 0;
    private VideoMediaFormat fmt;
    /* access modifiers changed from: private */
    public int height;
    /* access modifiers changed from: private */
    public ImageView imageView = null;
    private long maxTime = 0;
    private long minTime = 0;
    private boolean mock = false;
    private int offset;
    private NativeIntArray output;
    private final SeekBar seekBar;
    private boolean seekBarUpdatesPaused = false;
    private boolean setPixelsInUse = false;
    private boolean showing = true;
    private int stride;
    private TextView timeText = null;

    /* renamed from: vo */
    private final i f8396vo;
    /* access modifiers changed from: private */
    public int width;

    public ImageViewRenderer(ImageView imageView2, VideoMediaFormat videoMediaFormat, TextView textView, SeekBar seekBar2, i iVar, boolean z) {
        this.imageView = imageView2;
        this.timeText = textView;
        this.fmt = videoMediaFormat;
        this.seekBar = seekBar2;
        this.f8396vo = iVar;
        this.mock = z;
        if (textView != null) {
            textView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    Context context = MapView.getMapView().getContext();
                    Toast.makeText(context, "(" + ImageViewRenderer.this.width + "x" + ImageViewRenderer.this.height + ")", 0).show();
                    return false;
                }
            });
        }
        reinitConverter(videoMediaFormat.frameWidth, videoMediaFormat.frameHeight);
    }

    private void reinitConverter(int i, int i2) {
        this.width = i;
        this.height = i2;
        try {
            VideoMediaFormat videoMediaFormat = new VideoMediaFormat(this.fmt.trackNum, this.fmt.frameFormat, this.fmt.aspectRatio, this.width, this.height);
            this.fmt = videoMediaFormat;
            VideoFrameConverter videoFrameConverter = new VideoFrameConverter(videoMediaFormat, VideoMediaFormat.PixelFormat.PIXELS_RGB_PACKED);
            this.converter = videoFrameConverter;
            videoFrameConverter.setScaleForAspect(false);
        } catch (MediaException e) {
            Log.e(TAG, "Error initializing video renderer.", e);
        }
        this.width = this.converter.getScaleOutputWidth();
        int scaleOutputHeight = this.converter.getScaleOutputHeight();
        this.height = scaleOutputHeight;
        final Bitmap bitmap2 = this.bitmap;
        Bitmap createBitmap = Bitmap.createBitmap(this.width, scaleOutputHeight, Bitmap.Config.ARGB_8888);
        this.bitmap = createBitmap;
        createBitmap.setHasAlpha(false);
        this.canvas = new Canvas(this.bitmap);
        VideoFrameConverter videoFrameConverter2 = this.converter;
        if (videoFrameConverter2 != null) {
            this.output = videoFrameConverter2.getOutputArray();
            this.offset = this.converter.getOutputOffsets()[0];
            this.stride = this.converter.getOutputStrides()[0];
        }
        this.imageView.post(new Runnable() {
            public void run() {
                ImageViewRenderer.this.imageView.setImageBitmap(ImageViewRenderer.this.bitmap);
                Bitmap bitmap = bitmap2;
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        });
        this.imageView.post(this);
        Log.d(TAG, "finished initializing video frame to: " + this.width + "x" + this.height);
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setShowing(boolean z) {
        this.showing = z;
    }

    public void mediaVideoFrame(VideoFrameData videoFrameData) {
        if (this.showing || this.f8396vo.c()) {
            if (!(videoFrameData.getWidth() == this.width && videoFrameData.getHeight() == this.height)) {
                Log.d(TAG, "video frame size changed from: " + this.width + "x" + this.height + " to: " + videoFrameData.getWidth() + "x" + videoFrameData.getHeight());
                reinitConverter(videoFrameData.getWidth(), videoFrameData.getHeight());
            }
            try {
                this.converter.convert(videoFrameData);
                if (this.showing) {
                    nextFrame();
                } else {
                    this.f8396vo.d();
                }
            } catch (MediaException e) {
                Log.e(TAG, "Error encountered when rendering video frame", e);
            }
        }
    }

    public void clearImageView() {
        if (this.imageView != null) {
            int i = 0;
            while (i < this.width) {
                try {
                    for (int i2 = 0; i2 < this.height; i2++) {
                        if (!this.setPixelsInUse) {
                            this.bitmap.setPixel(i, i2, -16777216);
                        }
                    }
                    i++;
                } catch (Exception unused) {
                }
            }
            this.imageView.post(new Runnable() {
                public void run() {
                    ImageViewRenderer.this.imageView.setImageMatrix(new Matrix());
                    ImageViewRenderer.this.imageView.invalidate();
                }
            });
        }
    }

    public void destroy() {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            try {
                bitmap2.recycle();
            } catch (Exception e) {
                Log.d(TAG, "error occurred recycling the image", e);
            }
        }
    }

    public void nextFrame() {
        this.setPixelsInUse = true;
        this.bitmap.setPixels(this.output.intArray, this.offset + this.output.offset, this.stride, 0, 0, this.width, this.height);
        this.setPixelsInUse = false;
        this.imageView.postInvalidate();
    }

    private static String formatTime(long j) {
        return timeBarFormat.format(new Date(j));
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(long j) {
        setCurrentTime(j, false);
    }

    public void setCurrentTime(long j, boolean z) {
        if (!this.seekBarUpdatesPaused || z) {
            this.currentTime = j;
            this.imageView.post(this);
        }
    }

    public void pauseSeekBarUpdates() {
        this.seekBarUpdatesPaused = true;
    }

    public long getMinTime() {
        return this.minTime;
    }

    public long getMaxTime() {
        return this.maxTime;
    }

    public void setMinMaxTime(long j, long j2) {
        this.minTime = j;
        this.maxTime = j2;
        this.imageView.post(this);
    }

    public void run() {
        SeekBar seekBar2;
        long j = this.currentTime;
        if (j != 0) {
            TextView textView = this.timeText;
            if (textView != null) {
                textView.setText(formatTime(j));
            }
            if (this.minTime != 0 && this.maxTime != 0 && (seekBar2 = this.seekBar) != null) {
                long j2 = this.currentTime;
                long j3 = this.minTime;
                long max = (((long) seekBar2.getMax()) * (j2 - j3)) / (this.maxTime - j3);
                SeekBar seekBar3 = this.seekBar;
                if (seekBar3 != null) {
                    seekBar3.setProgress((int) max);
                }
            }
        }
    }
}
