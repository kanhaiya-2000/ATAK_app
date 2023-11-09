package com.autel.sdk.video;

import com.autel.common.FailedCallback;

public interface AutelCodecListener extends FailedCallback {
    void onCanceled();

    void onFrameStream(byte[] bArr, boolean z, int i, long j);
}
