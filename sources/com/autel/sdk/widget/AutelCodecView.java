package com.autel.sdk.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.autel.common.video.OnRenderFrameInfoListener;
import com.autel.internal.video.core.decoder2.CodecManager;
import com.autel.internal.video.widget.AutelCodecView2;

public class AutelCodecView extends AutelCodecView2 {
    public AutelCodecView(Context context) {
        super(context);
    }

    public AutelCodecView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static boolean isOverExposureEnabled() {
        return CodecManager.getInstance().isOverExposureEnabled();
    }

    public static void pause() {
        CodecManager.getInstance().pauseRender();
    }

    public static void resume() {
        CodecManager.getInstance().resumeRender();
    }

    public static void setOnRenderFrameInfoListener(OnRenderFrameInfoListener onRenderFrameInfoListener) {
        CodecManager.getInstance().setOnRenderFrameInfoListener(onRenderFrameInfoListener);
    }

    public static void startDecode(SurfaceTexture surfaceTexture, int i, int i2, boolean z) {
        CodecManager.getInstance().startDecode(surfaceTexture, i, i2, z);
    }

    public static void stopCodec() {
        needStop.set(false);
        CodecManager.getInstance().stopCodec();
    }

    public static void setOverExposure(boolean z, int i) {
        CodecManager.getInstance().setOverExpo(z, i);
    }

    public static void surfaceSizeChanged(int i, int i2) {
        CodecManager.getInstance().surfaceSizeChanged(i, i2);
    }
}
