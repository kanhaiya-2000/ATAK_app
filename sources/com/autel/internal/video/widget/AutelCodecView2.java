package com.autel.internal.video.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.autel.internal.video.core.decoder2.CodecManager;
import com.autel.internal.video.core.decoder2.VideoDecoderNew;
import java.util.concurrent.atomic.AtomicBoolean;

public class AutelCodecView2 extends TextureView {
    protected static AtomicBoolean needStop = new AtomicBoolean(false);
    private VideoDecoderNew mDecoder = null;

    public AutelCodecView2(Context context) {
        super(context);
    }

    public AutelCodecView2(Context context, AttributeSet attributeSet) {
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

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.v("decodePerformance", "onSurfaceTextureAvailable");
                AutelCodecView2.needStop.set(true);
                CodecManager.getInstance().startDecode(surfaceTexture, i, i2, true);
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                CodecManager.getInstance().surfaceSizeChanged(i, i2);
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (!AutelCodecView2.needStop.get()) {
                    return false;
                }
                CodecManager.getInstance().stopCodec();
                return false;
            }
        });
    }
}
