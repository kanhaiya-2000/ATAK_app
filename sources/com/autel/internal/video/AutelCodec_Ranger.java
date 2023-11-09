package com.autel.internal.video;

import android.os.Handler;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.video.core.decoder2.CodecManager;
import com.autel.internal.video.core.decoder2.common.StreamData;
import com.autel.internal.video.core.decoder2.common.VideoStreamReadListener;
import com.autel.sdk.video.AutelCodecListener;

public class AutelCodec_Ranger implements CodecService {
    /* access modifiers changed from: private */
    public AutelCodecListener autelCodecListener;
    private VideoStreamReadListener videoStreamReadListener = new VideoStreamReadListener() {
        public void onDataRecv(StreamData streamData) {
            if (AutelCodec_Ranger.this.autelCodecListener != null) {
                AutelCodec_Ranger.this.autelCodecListener.onFrameStream(streamData.getFrameData(), streamData.isIframe(), streamData.getSize(), streamData.getPts());
            }
        }
    };

    public void connect() {
    }

    public void disconnect() {
    }

    public void init(IAutelStateManager iAutelStateManager) {
    }

    public void destroy() {
        cancel();
    }

    public void setCodecListener(AutelCodecListener autelCodecListener2, Handler handler) {
        this.autelCodecListener = autelCodecListener2;
        CodecManager.getInstance().setVideoStreamReadListener(this.videoStreamReadListener);
    }

    public void cancel() {
        CodecManager.getInstance().setVideoStreamReadListener((VideoStreamReadListener) null);
        AutelCodecListener autelCodecListener2 = this.autelCodecListener;
        if (autelCodecListener2 != null) {
            autelCodecListener2.onCanceled();
        }
        this.autelCodecListener = null;
    }
}
