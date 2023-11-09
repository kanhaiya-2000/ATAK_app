package com.autel.internal.video.core.decoder1;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.autel.internal.video.core.decoder2.common.VideoDefaultParams;
import com.autel.util.log.AutelLog;
import com.autel.util.log.LocallogSave;
import com.autel.video.AutelPlayer;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VideoDecoder {
    private static VideoDecoder instance;
    public static MediaCodec.BufferInfo minfo;
    private final int PLAYER_PAUSE = 2;
    private final int PLAYER_START = 1;
    private final int PLAYER_STOP = 0;
    private final String TAG = "AutelVideoDecoder";
    /* access modifiers changed from: private */
    public boolean isAllVideoDatasUpdating = false;
    /* access modifiers changed from: private */
    public boolean isInputBufferIdValid = false;
    /* access modifiers changed from: private */
    public MediaCodec mDecoder;
    /* access modifiers changed from: private */
    public volatile boolean mDecoderInit = false;
    /* access modifiers changed from: private */
    public int mFormatHeight = VideoDefaultParams.mFormatHeight;
    /* access modifiers changed from: private */
    public int mFormatWidth = VideoDefaultParams.mFormatWidth;
    /* access modifiers changed from: private */
    public ImageHandle mImageHandle;
    /* access modifiers changed from: private */
    public ByteBuffer[] mInputBuffers;
    /* access modifiers changed from: private */
    public Object mInputMutex = new Object();
    /* access modifiers changed from: private */
    public DecodeInput mInputThread;
    /* access modifiers changed from: private */
    public Object mMutex = new Object();
    /* access modifiers changed from: private */
    public Object mOutputMutex = new Object();
    /* access modifiers changed from: private */
    public DecodeOutput mOutputThread;
    /* access modifiers changed from: private */
    public boolean mOverExpo = false;
    /* access modifiers changed from: private */
    public int mPlayStatus = 0;
    /* access modifiers changed from: private */
    public int mResId;
    /* access modifiers changed from: private */
    public int mScreenHeight;
    /* access modifiers changed from: private */
    public int mScreenWidth;
    private int mShowViewHeight;
    private int mShowViewWidth;
    /* access modifiers changed from: private */
    public long mStreamHandle = 0;
    /* access modifiers changed from: private */
    public Object mStreamHandleMutex = new Object();
    /* access modifiers changed from: private */
    public Surface mSurface;
    /* access modifiers changed from: private */
    public boolean mThreadExit = false;
    /* access modifiers changed from: private */
    public String mUrl;

    /* renamed from: mX */
    private int f8489mX;

    /* renamed from: mY */
    private int f8490mY;
    private ExecutorService mainThreadPool = Executors.newSingleThreadExecutor();
    private OnVideoDecoderListener onVideoDecoderListener;
    /* access modifiers changed from: private */
    public SurfaceTexture surface;

    public interface OnVideoDecoderListener {
        void onVideoDecoderStop();
    }

    private boolean isNormalVideoSize() {
        return true;
    }

    public static VideoDecoder getInstance() {
        if (instance == null) {
            instance = new VideoDecoder();
        }
        return instance;
    }

    private VideoDecoder() {
        AutelLog.m15084e("AutelVideoDecoder", "videoDecoder object create successful.");
    }

    public void setOnVideoDecoderListener(OnVideoDecoderListener onVideoDecoderListener2) {
        this.onVideoDecoderListener = onVideoDecoderListener2;
        onStopCallback();
    }

    /* access modifiers changed from: private */
    public void onStopCallback() {
        OnVideoDecoderListener onVideoDecoderListener2 = this.onVideoDecoderListener;
        if (onVideoDecoderListener2 != null && this.mPlayStatus == 0) {
            onVideoDecoderListener2.onVideoDecoderStop();
            this.onVideoDecoderListener = null;
        }
    }

    public boolean pause() {
        if (this.mPlayStatus != 1) {
            return false;
        }
        this.mPlayStatus = 2;
        AutelLog.m15084e("AutelVideoDecoder", "videoDecoder pause.");
        LocallogSave.writeNecessaryLog("AutelVideoDecoder", "videoDecoder pause.");
        return true;
    }

    public boolean setOverExpo(int i, boolean z) {
        if (this.mPlayStatus == 0) {
            return false;
        }
        this.mOverExpo = z;
        ImageHandle imageHandle = this.mImageHandle;
        if (imageHandle == null) {
            return true;
        }
        imageHandle.setOverExposure(i, z);
        return true;
    }

    public boolean isOverExposureEnabled() {
        ImageHandle imageHandle = this.mImageHandle;
        return imageHandle != null && imageHandle.isOverExposureEnabled();
    }

    public synchronized void start() {
        AutelLog.m15084e("AutelVideoDecoder", "videoDecoder fire.");
        if (this.mPlayStatus == 0) {
            LocallogSave.writeNecessaryLog("AutelVideoDecoder", " ====  videoDecoder fire. ====", true, false);
            this.mPlayStatus = 1;
            this.mainThreadPool.execute(new startRunnable());
        } else {
            LocallogSave.writeNecessaryLog("AutelVideoDecoder", " ====  videoDecoder resume. ====");
            this.mPlayStatus = 1;
        }
    }

    class startRunnable implements Runnable {
        startRunnable() {
        }

        public void run() {
            VideoDecoder videoDecoder = VideoDecoder.this;
            long unused = videoDecoder.mStreamHandle = AutelPlayer.OpenStream(videoDecoder.mUrl);
            if (VideoDecoder.this.mStreamHandle == 0) {
                int unused2 = VideoDecoder.this.mPlayStatus = 0;
                return;
            }
            DecodeOutput unused3 = VideoDecoder.this.mOutputThread = new DecodeOutput();
            VideoDecoder.this.mOutputThread.start();
            DecodeInput unused4 = VideoDecoder.this.mInputThread = new DecodeInput();
            VideoDecoder.this.mInputThread.start();
            int unused5 = VideoDecoder.this.mPlayStatus = 1;
        }
    }

    public void stop() {
        if (this.mPlayStatus == 0) {
            onStopCallback();
        } else {
            this.mainThreadPool.execute(new stopRunnable());
        }
    }

    class stopRunnable implements Runnable {
        stopRunnable() {
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0052 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                r1 = 1
                boolean unused = r0.mThreadExit = r1
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                r2 = 0
                boolean unused = r0.isAllVideoDatasUpdating = r2
            L_0x000c:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                com.autel.internal.video.core.decoder1.VideoDecoder$DecodeInput r0 = r0.mInputThread
                boolean r0 = r0.isAlive()
                if (r0 != 0) goto L_0x00e1
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                com.autel.internal.video.core.decoder1.VideoDecoder$DecodeOutput r0 = r0.mOutputThread
                boolean r0 = r0.isAlive()
                if (r0 == 0) goto L_0x0026
                goto L_0x00e1
            L_0x0026:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                long r3 = r0.mStreamHandle
                r5 = 0
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 == 0) goto L_0x0040
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                long r3 = r0.mStreamHandle
                com.autel.video.AutelPlayer.CloseStream(r3)
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                long unused = r0.mStreamHandle = r5
            L_0x0040:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                android.media.MediaCodec r0 = r0.mDecoder
                r3 = 0
                if (r0 == 0) goto L_0x0060
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0052 }
                android.media.MediaCodec r0 = r0.mDecoder     // Catch:{ Exception -> 0x0052 }
                r0.flush()     // Catch:{ Exception -> 0x0052 }
            L_0x0052:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x005b }
                android.media.MediaCodec r0 = r0.mDecoder     // Catch:{ Exception -> 0x005b }
                r0.release()     // Catch:{ Exception -> 0x005b }
            L_0x005b:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                android.media.MediaCodec unused = r0.mDecoder = r3
            L_0x0060:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                android.view.Surface r0 = r0.mSurface
                if (r0 == 0) goto L_0x0076
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0071 }
                android.view.Surface r0 = r0.mSurface     // Catch:{ Exception -> 0x0071 }
                r0.release()     // Catch:{ Exception -> 0x0071 }
            L_0x0071:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                android.view.Surface unused = r0.mSurface = r3
            L_0x0076:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                com.autel.internal.video.core.decoder1.ImageHandle r0 = r0.mImageHandle
                if (r0 == 0) goto L_0x008c
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                com.autel.internal.video.core.decoder1.ImageHandle r0 = r0.mImageHandle
                r0.release()
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                com.autel.internal.video.core.decoder1.ImageHandle unused = r0.mImageHandle = r3
            L_0x008c:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                android.graphics.SurfaceTexture r0 = r0.surface
                java.lang.String r4 = "AutelVideoDecoder"
                if (r0 == 0) goto L_0x00c2
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bd }
                r0.<init>()     // Catch:{ Exception -> 0x00bd }
                java.lang.String r5 = "videoDecoder stop. surface.hashcode == "
                r0.append(r5)     // Catch:{ Exception -> 0x00bd }
                com.autel.internal.video.core.decoder1.VideoDecoder r5 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x00bd }
                android.graphics.SurfaceTexture r5 = r5.surface     // Catch:{ Exception -> 0x00bd }
                int r5 = r5.hashCode()     // Catch:{ Exception -> 0x00bd }
                r0.append(r5)     // Catch:{ Exception -> 0x00bd }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00bd }
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x00bd }
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x00bd }
                android.graphics.SurfaceTexture r0 = r0.surface     // Catch:{ Exception -> 0x00bd }
                r0.release()     // Catch:{ Exception -> 0x00bd }
            L_0x00bd:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                android.graphics.SurfaceTexture unused = r0.surface = r3
            L_0x00c2:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                boolean unused = r0.mDecoderInit = r2
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                boolean unused = r0.mThreadExit = r2
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                int unused = r0.mPlayStatus = r2
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                r0.onStopCallback()
                java.lang.String r0 = "videoDecoder stop."
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r4, (java.lang.String) r0)
                java.lang.String r0 = "  ====  videoDecoder stop. ===="
                com.autel.util.log.LocallogSave.writeNecessaryLog(r4, r0, r2, r1)
                return
            L_0x00e1:
                r3 = 20
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x00e8 }
                goto L_0x000c
            L_0x00e8:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x000c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.video.core.decoder1.VideoDecoder.stopRunnable.run():void");
        }
    }

    public void setScreenSize(int i, int i2) {
        this.mShowViewWidth = Math.max(i, i2);
        this.mShowViewHeight = Math.min(i, i2);
        updataSize();
    }

    public void updataSize() {
        ImageHandle imageHandle;
        this.mScreenWidth = this.mShowViewWidth;
        this.mScreenHeight = this.mShowViewHeight;
        Log.e("AutelVideoDecoder", "***** mScreenWidth == " + this.mScreenWidth + "   mScreenHeight == " + this.mScreenHeight);
        int i = this.mScreenWidth;
        int i2 = this.mFormatHeight;
        int i3 = i * i2;
        int i4 = this.mScreenHeight;
        int i5 = this.mFormatWidth;
        if (i3 > i4 * i5) {
            this.f8489mX = (i - ((i4 * i5) / i2)) / 2;
            this.f8490mY = 0;
            this.mScreenWidth = (i4 * i5) / i2;
        } else if (i * i2 < i4 * i5) {
            AutelLog.m15084e("AutelVideoDecoder", "***** isNormalVideoSize() == " + isNormalVideoSize());
            if (isNormalVideoSize()) {
                this.f8489mX = 0;
                int i6 = this.mScreenHeight;
                int i7 = this.mScreenWidth;
                int i8 = this.mFormatHeight;
                int i9 = this.mFormatWidth;
                this.f8490mY = (i6 - ((i7 * i8) / i9)) / 2;
                this.mScreenHeight = (i7 * i8) / i9;
            } else {
                this.f8490mY = 0;
                int i10 = this.mScreenWidth;
                int i11 = (this.mFormatWidth * this.mScreenHeight) / this.mFormatHeight;
                this.mScreenWidth = i11;
                this.f8489mX = (-(i11 - i10)) / 2;
            }
        } else {
            this.f8489mX = 0;
            this.f8490mY = 0;
        }
        AutelLog.m15084e("AutelVideoDecoder", "***** mX == " + this.f8489mX + "   mY == " + this.f8490mY);
        if (this.mPlayStatus != 0 && (imageHandle = this.mImageHandle) != null) {
            imageHandle.VideoWinSet(this.f8489mX, this.f8490mY, this.mScreenWidth, this.mScreenHeight);
        }
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.surface = surfaceTexture;
        this.mUrl = PlayerIpConst.getAutelPlayerUrl();
        AutelLog.m15084e("AutelVideoDecoder", "videoDecoder setSurfaceTexture. surface.hashcode == " + surfaceTexture.hashCode());
    }

    public synchronized void updateAllVideoDatas() {
        String str;
        if (this.mPlayStatus != 0 && !this.isAllVideoDatasUpdating && (str = this.mUrl) != null && !str.equals(PlayerIpConst.getAutelPlayerUrl())) {
            this.isAllVideoDatasUpdating = true;
            this.mainThreadPool.execute(new updateRunnable());
        }
    }

    class updateRunnable implements Runnable {
        updateRunnable() {
        }

        public void run() {
            while (VideoDecoder.this.isAllVideoDatasUpdating) {
                long OpenStream = AutelPlayer.OpenStream(PlayerIpConst.getAutelPlayerUrl());
                if (OpenStream != 0) {
                    if (OpenStream != VideoDecoder.this.mStreamHandle) {
                        synchronized (VideoDecoder.this.mStreamHandleMutex) {
                            AutelPlayer.CloseStream(VideoDecoder.this.mStreamHandle);
                            String unused = VideoDecoder.this.mUrl = PlayerIpConst.getAutelPlayerUrl();
                            long unused2 = VideoDecoder.this.mStreamHandle = OpenStream;
                        }
                    }
                    boolean unused3 = VideoDecoder.this.isAllVideoDatasUpdating = false;
                    return;
                }
                try {
                    Thread.sleep(20);
                } catch (Exception unused4) {
                    boolean unused5 = VideoDecoder.this.isAllVideoDatasUpdating = false;
                    return;
                }
            }
        }
    }

    private class DecodeInput extends Thread {
        public DecodeInput() {
            super("DecodeInputThread");
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            	at java.base/java.util.Objects.checkIndex(Objects.java:372)
            	at java.base/java.util.ArrayList.get(ArrayList.java:458)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public void run() {
            /*
                r23 = this;
                r1 = r23
                r2 = 1048576(0x100000, float:1.469368E-39)
                byte[] r3 = new byte[r2]
                r4 = 8
                byte[] r5 = new byte[r4]
                int r0 = android.os.Process.myTid()
                r6 = -15
                android.os.Process.setThreadPriority(r0, r6)
                java.lang.String r0 = "video/avc"
                r6 = 1280(0x500, float:1.794E-42)
                r7 = 720(0x2d0, float:1.009E-42)
                android.media.MediaFormat r6 = android.media.MediaFormat.createVideoFormat(r0, r6, r7)
                r7 = 1024(0x400, float:1.435E-42)
                byte[] r8 = new byte[r7]
                byte[] r9 = new byte[r7]
                r10 = 0
                r11 = 0
            L_0x0025:
                r12 = 0
            L_0x0026:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                boolean r0 = r0.mThreadExit
                if (r0 != 0) goto L_0x024f
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                boolean r0 = r0.isAllVideoDatasUpdating
                if (r0 == 0) goto L_0x0038
                goto L_0x0244
            L_0x0038:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                boolean r0 = r0.mThreadExit
                if (r0 == 0) goto L_0x0042
                goto L_0x024f
            L_0x0042:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                java.lang.Object r13 = r0.mStreamHandleMutex
                monitor-enter(r13)
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x024c }
                long r14 = r0.mStreamHandle     // Catch:{ all -> 0x024c }
                r0 = 50
                int r0 = com.autel.video.AutelPlayer.ReadStream(r14, r3, r2, r0)     // Catch:{ all -> 0x024c }
                monitor-exit(r13)     // Catch:{ all -> 0x024c }
                if (r0 <= 0) goto L_0x01fa
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                r13 = 1
                boolean unused = r0.isInputBufferIdValid = r13
                r0 = 4
                java.lang.System.arraycopy(r3, r4, r5, r10, r0)
                int r14 = com.autel.internal.video.core.decoder1.ByteUtils.getInt(r5)
                r15 = 12
                java.lang.System.arraycopy(r3, r15, r5, r10, r0)
                int r0 = com.autel.internal.video.core.decoder1.ByteUtils.getInt(r5)
                r15 = 16
                java.lang.System.arraycopy(r3, r15, r5, r10, r4)
                long r20 = com.autel.internal.video.core.decoder1.ByteUtils.getLong(r5)
                r15 = 24
                if (r11 != 0) goto L_0x0169
                com.autel.internal.video.core.decoder1.VideoDecoder r2 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                java.lang.Object r2 = r2.mMutex
                monitor-enter(r2)
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0166 }
                com.autel.internal.video.core.decoder1.ImageHandle r4 = r4.mImageHandle     // Catch:{ all -> 0x0166 }
                if (r4 != 0) goto L_0x008e
                monitor-exit(r2)     // Catch:{ all -> 0x0166 }
                goto L_0x0244
            L_0x008e:
                if (r14 != 0) goto L_0x0093
                monitor-exit(r2)     // Catch:{ all -> 0x0166 }
                goto L_0x0244
            L_0x0093:
                java.lang.String r4 = "xxxxxxx"
                java.lang.String r14 = " ====== initIFrameDecoder() ====== "
                android.util.Log.e(r4, r14)     // Catch:{ all -> 0x0166 }
                r4 = 0
                com.autel.internal.video.core.decoder1.VideoDecoder r14 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x015a }
                java.lang.String r16 = "video/avc"
                android.media.MediaCodec r13 = android.media.MediaCodec.createDecoderByType(r16)     // Catch:{ Exception -> 0x015a }
                android.media.MediaCodec unused = r14.mDecoder = r13     // Catch:{ Exception -> 0x015a }
                int r13 = com.autel.video.NetWorkProxyJni.ParseSps(r3, r15, r0, r8, r7)     // Catch:{ all -> 0x0166 }
                int r14 = com.autel.video.NetWorkProxyJni.ParsePps(r3, r15, r0, r9, r7)     // Catch:{ all -> 0x0166 }
                java.lang.String r7 = "csd-0"
                java.nio.ByteBuffer r13 = java.nio.ByteBuffer.wrap(r8, r10, r13)     // Catch:{ all -> 0x0166 }
                r6.setByteBuffer(r7, r13)     // Catch:{ all -> 0x0166 }
                java.lang.String r7 = "csd-1"
                java.nio.ByteBuffer r13 = java.nio.ByteBuffer.wrap(r9, r10, r14)     // Catch:{ all -> 0x0166 }
                r6.setByteBuffer(r7, r13)     // Catch:{ all -> 0x0166 }
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0166 }
                com.autel.internal.video.core.decoder1.ImageHandle r7 = r7.mImageHandle     // Catch:{ all -> 0x0166 }
                android.graphics.SurfaceTexture r7 = r7.getSurfaceTexture()     // Catch:{ all -> 0x0166 }
                if (r7 != 0) goto L_0x00d4
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0166 }
                android.media.MediaCodec unused = r0.mDecoder = r4     // Catch:{ all -> 0x0166 }
                monitor-exit(r2)     // Catch:{ all -> 0x0166 }
                goto L_0x0244
            L_0x00d4:
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0152 }
                android.view.Surface r7 = r7.mSurface     // Catch:{ Exception -> 0x0152 }
                if (r7 != 0) goto L_0x00f0
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0152 }
                android.view.Surface r13 = new android.view.Surface     // Catch:{ Exception -> 0x0152 }
                com.autel.internal.video.core.decoder1.VideoDecoder r14 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0152 }
                com.autel.internal.video.core.decoder1.ImageHandle r14 = r14.mImageHandle     // Catch:{ Exception -> 0x0152 }
                android.graphics.SurfaceTexture r14 = r14.getSurfaceTexture()     // Catch:{ Exception -> 0x0152 }
                r13.<init>(r14)     // Catch:{ Exception -> 0x0152 }
                android.view.Surface unused = r7.mSurface = r13     // Catch:{ Exception -> 0x0152 }
            L_0x00f0:
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0152 }
                android.media.MediaCodec r7 = r7.mDecoder     // Catch:{ Exception -> 0x0152 }
                com.autel.internal.video.core.decoder1.VideoDecoder r13 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0152 }
                android.view.Surface r13 = r13.mSurface     // Catch:{ Exception -> 0x0152 }
                r7.configure(r6, r13, r4, r10)     // Catch:{ Exception -> 0x0152 }
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0152 }
                android.media.MediaCodec r7 = r7.mDecoder     // Catch:{ Exception -> 0x0152 }
                r7.start()     // Catch:{ Exception -> 0x0152 }
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x0152 }
                android.media.MediaCodec r13 = r7.mDecoder     // Catch:{ Exception -> 0x0152 }
                java.nio.ByteBuffer[] r13 = r13.getInputBuffers()     // Catch:{ Exception -> 0x0152 }
                java.nio.ByteBuffer[] unused = r7.mInputBuffers = r13     // Catch:{ Exception -> 0x0152 }
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0166 }
                r7 = 1
                boolean unused = r4.mDecoderInit = r7     // Catch:{ all -> 0x0166 }
                monitor-exit(r2)     // Catch:{ all -> 0x0166 }
                java.lang.String r2 = "AutelVideoDecoder"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r11 = r23.getName()
                r4.append(r11)
                java.lang.String r11 = " Mediacodec create successful."
                r4.append(r11)
                java.lang.String r4 = r4.toString()
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r2, (java.lang.String) r4)
                java.lang.String r2 = "AutelVideoDecoder"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r11 = r23.getName()
                r4.append(r11)
                java.lang.String r11 = " Mediacodec create successful."
                r4.append(r11)
                java.lang.String r4 = r4.toString()
                com.autel.util.log.LocallogSave.writeNecessaryLog(r2, r4)
                r11 = 1
                goto L_0x0169
            L_0x0152:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0166 }
                android.media.MediaCodec unused = r0.mDecoder = r4     // Catch:{ all -> 0x0166 }
                monitor-exit(r2)     // Catch:{ all -> 0x0166 }
                goto L_0x0244
            L_0x015a:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ all -> 0x0166 }
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0166 }
                android.media.MediaCodec unused = r0.mDecoder = r4     // Catch:{ all -> 0x0166 }
                monitor-exit(r2)     // Catch:{ all -> 0x0166 }
                goto L_0x0244
            L_0x0166:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0166 }
                throw r0
            L_0x0169:
                r2 = 100
                if (r12 < r2) goto L_0x01a1
                java.lang.String r2 = "AutelVideoDecoder"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r7 = r23.getName()
                r4.append(r7)
                java.lang.String r7 = " video stream is online."
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r2, (java.lang.String) r4)
                java.lang.String r2 = "AutelVideoDecoder"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r7 = r23.getName()
                r4.append(r7)
                java.lang.String r7 = " video stream is online."
                r4.append(r7)
                java.lang.String r4 = r4.toString()
                com.autel.util.log.LocallogSave.writeNecessaryLog(r2, r4)
            L_0x01a1:
                com.autel.internal.video.core.decoder1.VideoDecoder r2 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                java.lang.Object r2 = r2.mOutputMutex
                monitor-enter(r2)
                r4 = 0
            L_0x01a9:
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x01f7 }
                boolean r7 = r7.mThreadExit     // Catch:{ all -> 0x01f7 }
                if (r7 != 0) goto L_0x01ee
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01ea }
                android.media.MediaCodec r7 = r7.mDecoder     // Catch:{ Exception -> 0x01ea }
                r12 = 50000(0xc350, double:2.47033E-319)
                int r7 = r7.dequeueInputBuffer(r12)     // Catch:{ Exception -> 0x01ea }
                if (r7 < 0) goto L_0x01e0
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01ea }
                java.nio.ByteBuffer[] r4 = r4.mInputBuffers     // Catch:{ Exception -> 0x01ea }
                r4 = r4[r7]     // Catch:{ Exception -> 0x01ea }
                r4.clear()     // Catch:{ Exception -> 0x01ea }
                r4.put(r3, r15, r0)     // Catch:{ Exception -> 0x01ea }
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01ea }
                android.media.MediaCodec r16 = r4.mDecoder     // Catch:{ Exception -> 0x01ea }
                r18 = 0
                r22 = 0
                r17 = r7
                r19 = r0
                r16.queueInputBuffer(r17, r18, r19, r20, r22)     // Catch:{ Exception -> 0x01ea }
                goto L_0x01ee
            L_0x01e0:
                r12 = -1
                if (r7 != r12) goto L_0x01a9
                int r4 = r4 + 1
                r7 = 20
                if (r4 > r7) goto L_0x01ee
                goto L_0x01a9
            L_0x01ea:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ all -> 0x01f7 }
            L_0x01ee:
                monitor-exit(r2)     // Catch:{ all -> 0x01f7 }
                r2 = 1048576(0x100000, float:1.469368E-39)
                r4 = 8
                r7 = 1024(0x400, float:1.435E-42)
                goto L_0x0025
            L_0x01f7:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x01f7 }
                throw r0
            L_0x01fa:
                if (r0 != 0) goto L_0x0244
                int r12 = r12 + 1
                int r0 = r12 % 50
                if (r0 != 0) goto L_0x0226
                java.lang.String r0 = "AutelVideoDecoder"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = r23.getName()
                r2.append(r4)
                java.lang.String r4 = " video stream is offline.---"
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r0, (java.lang.String) r2)
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                boolean unused = r0.isInputBufferIdValid = r10
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                r0.updateAllVideoDatas()
            L_0x0226:
                int r0 = r12 % 200
                if (r0 != 0) goto L_0x0244
                java.lang.String r0 = "AutelVideoDecoder"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = r23.getName()
                r2.append(r4)
                java.lang.String r4 = " No video stream data.---"
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                com.autel.util.log.LocallogSave.writeNecessaryLog(r0, r2)
            L_0x0244:
                r2 = 1048576(0x100000, float:1.469368E-39)
                r4 = 8
                r7 = 1024(0x400, float:1.435E-42)
                goto L_0x0026
            L_0x024c:
                r0 = move-exception
                monitor-exit(r13)     // Catch:{ all -> 0x024c }
                throw r0
            L_0x024f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.video.core.decoder1.VideoDecoder.DecodeInput.run():void");
        }
    }

    /* access modifiers changed from: private */
    public void resetDecoder() {
        Log.e("xxxxxx", " resetDecoder ***** ");
        if (this.mDecoder != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.mDecoder.flush();
                }
            } catch (Exception e) {
                AutelLog.m15084e("AutelVideoDecoder", "flush error.");
                LocallogSave.writeNecessaryLog("AutelVideoDecoder", "flush error.");
                e.printStackTrace();
            }
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.mDecoder.release();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                this.mDecoder = null;
                throw th;
            }
            this.mDecoder = null;
        }
        Surface surface2 = this.mSurface;
        if (surface2 != null) {
            surface2.release();
            this.mSurface = null;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(VideoDefaultParams.VIDEO_ENCODING_FORMAT, VideoDefaultParams.mFormatWidth, VideoDefaultParams.mFormatHeight);
        createVideoFormat.setInteger("color-format", 2130708361);
        if (Build.VERSION.SDK_INT < 21) {
            createVideoFormat.setInteger("color-format", 21);
        }
        try {
            synchronized (this.mMutex) {
                if (this.mImageHandle != null) {
                    this.mSurface = new Surface(this.mImageHandle.getSurfaceTexture());
                    MediaCodec createDecoderByType = MediaCodec.createDecoderByType(VideoDefaultParams.VIDEO_ENCODING_FORMAT);
                    this.mDecoder = createDecoderByType;
                    createDecoderByType.configure(createVideoFormat, this.mSurface, (MediaCrypto) null, 0);
                    this.mDecoder.start();
                    this.mInputBuffers = this.mDecoder.getInputBuffers();
                }
            }
        } catch (Exception unused) {
            AutelLog.m15084e("AutelVideoDecoder", "fire failed, do it again");
            LocallogSave.writeNecessaryLog("AutelVideoDecoder", "fire failed, do it again");
        }
    }

    private class DecodeOutput extends Thread {
        public DecodeOutput() {
            super("DecodeOutputThread");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:49:0x019d, code lost:
            if (com.autel.internal.video.core.decoder1.VideoDecoder.access$1400(r10.this$0) != false) goto L_0x01e5;
         */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x01e9 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x005c A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
                int r0 = android.os.Process.myTid()
                r1 = -15
                android.os.Process.setThreadPriority(r0, r1)
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                java.lang.Object r0 = r0.mMutex
                monitor-enter(r0)
                com.autel.internal.video.core.decoder1.VideoDecoder r1 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.ImageHandle r2 = new com.autel.internal.video.core.decoder1.ImageHandle     // Catch:{ all -> 0x0239 }
                int r3 = r1.mResId     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0239 }
                android.graphics.SurfaceTexture r4 = r4.surface     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.VideoDecoder r5 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0239 }
                boolean r5 = r5.mOverExpo     // Catch:{ all -> 0x0239 }
                r2.<init>(r3, r4, r5)     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.ImageHandle unused = r1.mImageHandle = r2     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.VideoDecoder r1 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.ImageHandle r1 = r1.mImageHandle     // Catch:{ all -> 0x0239 }
                boolean r1 = r1.ImageHandleInit()     // Catch:{ all -> 0x0239 }
                r2 = 0
                if (r1 != 0) goto L_0x003d
                com.autel.internal.video.core.decoder1.VideoDecoder r1 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0239 }
                r1.resetDecoder()     // Catch:{ all -> 0x0239 }
                goto L_0x0052
            L_0x003d:
                com.autel.internal.video.core.decoder1.VideoDecoder r1 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.ImageHandle r1 = r1.mImageHandle     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.VideoDecoder r3 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0239 }
                int r3 = r3.mScreenWidth     // Catch:{ all -> 0x0239 }
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0239 }
                int r4 = r4.mScreenHeight     // Catch:{ all -> 0x0239 }
                r1.VideoWinSet(r2, r2, r3, r4)     // Catch:{ all -> 0x0239 }
            L_0x0052:
                monitor-exit(r0)     // Catch:{ all -> 0x0239 }
                android.media.MediaCodec$BufferInfo r0 = new android.media.MediaCodec$BufferInfo
                r0.<init>()
                com.autel.internal.video.core.decoder1.VideoDecoder.minfo = r0
                r0 = 0
            L_0x005b:
                r1 = 0
            L_0x005c:
                com.autel.internal.video.core.decoder1.VideoDecoder r3 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                boolean r3 = r3.mThreadExit
                r4 = 0
                if (r3 != 0) goto L_0x0217
                com.autel.internal.video.core.decoder1.VideoDecoder r3 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                boolean r3 = r3.mDecoderInit
                if (r3 != 0) goto L_0x0078
                r3 = 10
                java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0073 }
                goto L_0x005c
            L_0x0073:
                r3 = move-exception
                r3.printStackTrace()
                goto L_0x005c
            L_0x0078:
                com.autel.internal.video.core.decoder1.VideoDecoder r3 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                java.lang.Object r3 = r3.mInputMutex
                monitor-enter(r3)
                r5 = 1
                com.autel.internal.video.core.decoder1.VideoDecoder r6 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                android.media.MediaCodec r6 = r6.mDecoder     // Catch:{ Exception -> 0x01a2 }
                android.media.MediaCodec$BufferInfo r7 = com.autel.internal.video.core.decoder1.VideoDecoder.minfo     // Catch:{ Exception -> 0x01a2 }
                r8 = 50000(0xc350, double:2.47033E-319)
                int r6 = r6.dequeueOutputBuffer(r7, r8)     // Catch:{ Exception -> 0x01a2 }
                r7 = 40
                if (r6 < 0) goto L_0x00f5
                if (r0 < r7) goto L_0x00c9
                java.lang.String r7 = "AutelVideoDecoder"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a2 }
                r8.<init>()     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r9 = r10.getName()     // Catch:{ Exception -> 0x01a2 }
                r8.append(r9)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r9 = " video decoder is online."
                r8.append(r9)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x01a2 }
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = "AutelVideoDecoder"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a2 }
                r8.<init>()     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r9 = r10.getName()     // Catch:{ Exception -> 0x01a2 }
                r8.append(r9)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r9 = " video decoder is online."
                r8.append(r9)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x01a2 }
                com.autel.util.log.LocallogSave.writeNecessaryLog(r7, r8)     // Catch:{ Exception -> 0x01a2 }
            L_0x00c9:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x00f1 }
                int r0 = r0.mPlayStatus     // Catch:{ Exception -> 0x00f1 }
                r7 = 2
                if (r0 != r7) goto L_0x00dc
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x00f1 }
                android.media.MediaCodec r0 = r0.mDecoder     // Catch:{ Exception -> 0x00f1 }
                r0.releaseOutputBuffer(r6, r2)     // Catch:{ Exception -> 0x00f1 }
                goto L_0x00ee
            L_0x00dc:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x00f1 }
                android.media.MediaCodec r0 = r0.mDecoder     // Catch:{ Exception -> 0x00f1 }
                r0.releaseOutputBuffer(r6, r5)     // Catch:{ Exception -> 0x00f1 }
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x00f1 }
                com.autel.internal.video.core.decoder1.ImageHandle r0 = r0.mImageHandle     // Catch:{ Exception -> 0x00f1 }
                r0.onFrameAvailable(r4)     // Catch:{ Exception -> 0x00f1 }
            L_0x00ee:
                r0 = 0
                goto L_0x01e6
            L_0x00f1:
                r1 = move-exception
                r0 = 0
                goto L_0x01a3
            L_0x00f5:
                r4 = -3
                if (r6 != r4) goto L_0x00fa
                goto L_0x01e6
            L_0x00fa:
                r4 = -2
                if (r6 != r4) goto L_0x014e
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                android.media.MediaCodec r4 = r4.mDecoder     // Catch:{ Exception -> 0x01a2 }
                android.media.MediaFormat r4 = r4.getOutputFormat()     // Catch:{ Exception -> 0x01a2 }
                com.autel.internal.video.core.decoder1.VideoDecoder r6 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = "width"
                int r7 = r4.getInteger(r7)     // Catch:{ Exception -> 0x01a2 }
                int unused = r6.mFormatWidth = r7     // Catch:{ Exception -> 0x01a2 }
                com.autel.internal.video.core.decoder1.VideoDecoder r6 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = "height"
                int r4 = r4.getInteger(r7)     // Catch:{ Exception -> 0x01a2 }
                int unused = r6.mFormatHeight = r4     // Catch:{ Exception -> 0x01a2 }
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                r4.updataSize()     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r4 = "xxxxxx"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a2 }
                r6.<init>()     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = "INFO_OUTPUT_FORMAT_CHANGED::  w == "
                r6.append(r7)     // Catch:{ Exception -> 0x01a2 }
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                int r7 = r7.mFormatWidth     // Catch:{ Exception -> 0x01a2 }
                r6.append(r7)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = "    h == "
                r6.append(r7)     // Catch:{ Exception -> 0x01a2 }
                com.autel.internal.video.core.decoder1.VideoDecoder r7 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                int r7 = r7.mFormatHeight     // Catch:{ Exception -> 0x01a2 }
                r6.append(r7)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01a2 }
                android.util.Log.e(r4, r6)     // Catch:{ Exception -> 0x01a2 }
                goto L_0x01e6
            L_0x014e:
                r4 = -1
                if (r6 != r4) goto L_0x01e6
                int r0 = r0 + 1
                if (r0 != r7) goto L_0x0193
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                com.autel.internal.video.core.decoder1.ImageHandle r4 = r4.mImageHandle     // Catch:{ Exception -> 0x01a2 }
                r4.renderLastFrame()     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r4 = "AutelVideoDecoder"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a2 }
                r6.<init>()     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = r10.getName()     // Catch:{ Exception -> 0x01a2 }
                r6.append(r7)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = " video decoder is offline."
                r6.append(r7)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01a2 }
                android.util.Log.e(r4, r6)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r4 = "AutelVideoDecoder"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a2 }
                r6.<init>()     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = r10.getName()     // Catch:{ Exception -> 0x01a2 }
                r6.append(r7)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r7 = " video decoder is offline."
                r6.append(r7)     // Catch:{ Exception -> 0x01a2 }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01a2 }
                com.autel.util.log.LocallogSave.writeNecessaryLog(r4, r6)     // Catch:{ Exception -> 0x01a2 }
                goto L_0x01e6
            L_0x0193:
                int r4 = r0 % 120
                if (r4 != 0) goto L_0x01e6
                com.autel.internal.video.core.decoder1.VideoDecoder r4 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ Exception -> 0x01a2 }
                boolean r4 = r4.isInputBufferIdValid     // Catch:{ Exception -> 0x01a2 }
                if (r4 == 0) goto L_0x01e6
                goto L_0x01e5
            L_0x01a0:
                r0 = move-exception
                goto L_0x0215
            L_0x01a2:
                r1 = move-exception
            L_0x01a3:
                java.lang.String r4 = "AutelVideoDecoder"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
                r6.<init>()     // Catch:{ all -> 0x01a0 }
                java.lang.String r7 = r10.getName()     // Catch:{ all -> 0x01a0 }
                r6.append(r7)     // Catch:{ all -> 0x01a0 }
                java.lang.String r7 = " dequeueOutputBuffer error ***** "
                r6.append(r7)     // Catch:{ all -> 0x01a0 }
                java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x01a0 }
                r6.append(r7)     // Catch:{ all -> 0x01a0 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01a0 }
                android.util.Log.e(r4, r6)     // Catch:{ all -> 0x01a0 }
                java.lang.String r4 = "AutelVideoDecoder"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a0 }
                r6.<init>()     // Catch:{ all -> 0x01a0 }
                java.lang.String r7 = r10.getName()     // Catch:{ all -> 0x01a0 }
                r6.append(r7)     // Catch:{ all -> 0x01a0 }
                java.lang.String r7 = " dequeueOutputBuffer error ***** "
                r6.append(r7)     // Catch:{ all -> 0x01a0 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01a0 }
                r6.append(r1)     // Catch:{ all -> 0x01a0 }
                java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x01a0 }
                com.autel.util.log.LocallogSave.writeNecessaryLog(r4, r1)     // Catch:{ all -> 0x01a0 }
            L_0x01e5:
                r1 = 1
            L_0x01e6:
                monitor-exit(r3)     // Catch:{ all -> 0x01a0 }
                if (r1 == 0) goto L_0x005c
                com.autel.internal.video.core.decoder1.VideoDecoder r1 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                java.lang.Object r3 = r1.mOutputMutex
                monitor-enter(r3)
                com.autel.internal.video.core.decoder1.VideoDecoder r1 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0212 }
                r1.resetDecoder()     // Catch:{ all -> 0x0212 }
                java.lang.String r1 = "AutelVideoDecoder"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0212 }
                r4.<init>()     // Catch:{ all -> 0x0212 }
                java.lang.String r5 = r10.getName()     // Catch:{ all -> 0x0212 }
                r4.append(r5)     // Catch:{ all -> 0x0212 }
                java.lang.String r5 = " resetDecoder()"
                r4.append(r5)     // Catch:{ all -> 0x0212 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0212 }
                com.autel.util.log.LocallogSave.writeNecessaryLog(r1, r4)     // Catch:{ all -> 0x0212 }
                monitor-exit(r3)     // Catch:{ all -> 0x0212 }
                goto L_0x005b
            L_0x0212:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0212 }
                throw r0
            L_0x0215:
                monitor-exit(r3)     // Catch:{ all -> 0x01a0 }
                throw r0
            L_0x0217:
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this
                java.lang.Object r1 = r0.mMutex
                monitor-enter(r1)
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0236 }
                com.autel.internal.video.core.decoder1.ImageHandle r0 = r0.mImageHandle     // Catch:{ all -> 0x0236 }
                if (r0 == 0) goto L_0x0234
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0236 }
                com.autel.internal.video.core.decoder1.ImageHandle r0 = r0.mImageHandle     // Catch:{ all -> 0x0236 }
                r0.release()     // Catch:{ all -> 0x0236 }
                com.autel.internal.video.core.decoder1.VideoDecoder r0 = com.autel.internal.video.core.decoder1.VideoDecoder.this     // Catch:{ all -> 0x0236 }
                com.autel.internal.video.core.decoder1.ImageHandle unused = r0.mImageHandle = r4     // Catch:{ all -> 0x0236 }
            L_0x0234:
                monitor-exit(r1)     // Catch:{ all -> 0x0236 }
                return
            L_0x0236:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0236 }
                throw r0
            L_0x0239:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0239 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.video.core.decoder1.VideoDecoder.DecodeOutput.run():void");
        }
    }
}
