package com.autel.video;

import android.util.Log;

public class NetWorkProxyJni {
    private NativeDataListener dataListener;

    public interface NativeDataListener {
        void onDataRecv(byte[] bArr, int i, int i2, boolean z, int i3, int i4);
    }

    public static native int CloseStream(long j);

    private static native void DisconNotify();

    public static native void ForceKeyFrame(int i);

    private static native int FreqGet();

    private static native int FreqSet(int i);

    public static native long OpenStream();

    public static native int ParsePps(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    public static native int ParseSps(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    private static native int ReadProxyData(byte[] bArr, int i, int i2);

    public static native int ReadStream(long j, byte[] bArr, int i, int i2);

    private static native int SignalStrengthGet();

    private static native void StartProxy();

    private static native void StopProxy();

    private static native int WriteProxyData(byte[] bArr, int i);

    public void onFrameDataRcv(long j, byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
    }

    static {
        System.loadLibrary("NetWorkProxy");
    }

    public static void startProxy() {
        Log.v("connectDebug", "startProxy");
        StartProxy();
    }

    public static void stopProxy() {
        Log.v("connectDebug", "stopProxy");
        StopProxy();
    }

    public static void writeProxyData(byte[] bArr, int i) {
        WriteProxyData(bArr, i);
    }

    public static int readProxyData(byte[] bArr, int i, int i2) {
        return ReadProxyData(bArr, i, i2);
    }

    public static int getCurrentRouteHz() {
        return FreqGet();
    }

    public static int setCurRouteHz(int i) {
        return FreqSet(i);
    }

    public static int GetSingalStrength() {
        return SignalStrengthGet();
    }

    public static void disconNotify() {
        DisconNotify();
    }

    public void setDataListener(NativeDataListener nativeDataListener) {
        this.dataListener = nativeDataListener;
    }
}
