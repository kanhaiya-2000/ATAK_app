package com.autel.video;

import com.autel.video.engine.VideoIpConst;

public class AutelPlayer {
    private static AutelPlayer instance_;
    private long handle;
    private OnAutelPlayerListener onAutelPlayerListener;

    public interface OnAutelPlayerListener {
        void onPlayerRtmpVideoAttr(int i, int i2, int i3);
    }

    public static native int CloseStream(long j);

    public static native long OpenStream(String str);

    public static native int ParsePps(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public static native int ParseSps(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    private native int PlayerExposureDetectionEnable(int i);

    private native int PlayerInit();

    private native int PlayerQuit();

    private native int PlayerRender(int i, int i2);

    private native int PlayerRtmpStart(String str, String str2);

    private native int PlayerRtmpStop();

    private native int PlayerStart(String str);

    private native int PlayerStop();

    public static native int ReadStream(long j, byte[] bArr, int i, int i2);

    public static native int RtmpOnlineQuery();

    public static native int WriteAudioData(short[] sArr, int i);

    public native long PlayerRecordStart(String str, String str2);

    public native int PlayerRecordStop(long j);

    public native int PlayerSetPictureColour(int i);

    static {
        System.loadLibrary("AutelPlayer");
    }

    private AutelPlayer() {
    }

    private static AutelPlayer getInstance_() {
        if (instance_ == null) {
            instance_ = new AutelPlayer();
        }
        return instance_;
    }

    public static int init() {
        return getInstance_().PlayerInit();
    }

    public static int quit() {
        return getInstance_().PlayerQuit();
    }

    public static void playerRecordStart(String str) {
        if (getInstance_().handle == 0) {
            getInstance_().handle = getInstance_().PlayerRecordStart(VideoIpConst.getRtspHostAddr(), str);
        }
    }

    public static void playerRecordStop() {
        if (getInstance_().handle != 0) {
            getInstance_().PlayerRecordStop(getInstance_().handle);
            getInstance_().handle = 0;
        }
    }

    public static int rtmpStart(String str) {
        return getInstance_().PlayerRtmpStart(VideoIpConst.getRtspHostAddr(), str);
    }

    public static int rtmpStop() {
        return getInstance_().PlayerRtmpStop();
    }

    public static int writeAudioData(short[] sArr, int i) {
        getInstance_();
        return WriteAudioData(sArr, i);
    }

    public void PlayerRtmpVideoAttr(int i, int i2, int i3) {
        if (getInstance_().onAutelPlayerListener != null) {
            getInstance_().onAutelPlayerListener.onPlayerRtmpVideoAttr(i, i2, i3);
        }
    }

    public static int start() {
        return getInstance_().PlayerStart(VideoIpConst.getRtspHostAddr());
    }

    public static int setRenderColor(int i) {
        return getInstance_().PlayerSetPictureColour(i);
    }

    public static int render(int i, int i2) {
        return getInstance_().PlayerRender(i, i2);
    }

    public static int stop() {
        return getInstance_().PlayerStop();
    }

    public static int exposureDetectionEnable(int i) {
        return getInstance_().PlayerExposureDetectionEnable(i);
    }

    public static int rtmpOnlineQuery() {
        getInstance_();
        return RtmpOnlineQuery();
    }

    public static void setOnAutelPlayerListener(OnAutelPlayerListener onAutelPlayerListener2) {
        getInstance_().onAutelPlayerListener = onAutelPlayerListener2;
    }
}
