package com.autel.internal.video.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.autel.internal.video.core.decoder1.VideoDecoder;
import com.autel.util.log.AutelLog;

public class AutelCodecView1 extends TextureView {
    /* access modifiers changed from: private */
    public VideoDecoder mDecoder = null;

    public AutelCodecView1(Context context) {
        super(context);
    }

    public AutelCodecView1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        init();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private void init() {
        setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, final int i, final int i2) {
                VideoDecoder unused = AutelCodecView1.this.mDecoder = VideoDecoder.getInstance();
                AutelCodecView1.this.mDecoder.setOnVideoDecoderListener(new VideoDecoder.OnVideoDecoderListener() {
                    public void onVideoDecoderStop() {
                        AutelLog.m15083e("videoDecoder available == " + AutelCodecView1.this.isAvailable());
                        if (AutelCodecView1.this.isAvailable()) {
                            AutelCodecView1.this.mDecoder.setSurfaceTexture(surfaceTexture);
                            AutelCodecView1.this.mDecoder.setScreenSize(i, i2);
                            AutelCodecView1.this.mDecoder.start();
                        }
                    }
                });
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                if (AutelCodecView1.this.mDecoder != null) {
                    AutelCodecView1.this.mDecoder.setScreenSize(i, i2);
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (AutelCodecView1.this.mDecoder == null) {
                    return false;
                }
                AutelCodecView1.this.mDecoder.stop();
                VideoDecoder unused = AutelCodecView1.this.mDecoder = null;
                return false;
            }
        });
    }

    public void setOverExposure(boolean z, int i) {
        VideoDecoder videoDecoder = this.mDecoder;
        if (videoDecoder != null) {
            videoDecoder.setOverExpo(i, z);
        }
    }

    public boolean isOverExposureEnabled() {
        VideoDecoder videoDecoder = this.mDecoder;
        return videoDecoder != null && videoDecoder.isOverExposureEnabled();
    }

    public void pause() {
        VideoDecoder videoDecoder = this.mDecoder;
        if (videoDecoder != null) {
            videoDecoder.pause();
        }
    }

    public void resume() {
        VideoDecoder videoDecoder = this.mDecoder;
        if (videoDecoder != null) {
            videoDecoder.start();
        }
    }
}
