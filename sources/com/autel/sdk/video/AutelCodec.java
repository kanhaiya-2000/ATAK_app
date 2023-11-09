package com.autel.sdk.video;

import android.os.Handler;

public interface AutelCodec {
    void cancel();

    void setCodecListener(AutelCodecListener autelCodecListener, Handler handler);
}
