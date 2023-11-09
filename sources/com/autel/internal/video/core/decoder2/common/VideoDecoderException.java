package com.autel.internal.video.core.decoder2.common;

public class VideoDecoderException extends Exception {
    private int errorCode;

    public VideoDecoderException() {
        super("MediaCodec error, to reset now");
    }

    public VideoDecoderException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
