package com.o3dr.android.client.utils.video;

public interface DecoderListener {
    void onDecodingEnded();

    void onDecodingError();

    void onDecodingStarted();
}
