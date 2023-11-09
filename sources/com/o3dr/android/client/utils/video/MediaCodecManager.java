package com.o3dr.android.client.utils.video;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class MediaCodecManager {
    public static final int DEFAULT_VIDEO_HEIGHT = 1080;
    public static final int DEFAULT_VIDEO_WIDTH = 1920;
    private static final String MIME_TYPE = "video/avc";
    /* access modifiers changed from: private */
    public static final String TAG = "MediaCodecManager";
    /* access modifiers changed from: private */
    public final AtomicBoolean decodedFirstFrame = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicReference<DecoderListener> decoderListenerRef = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final Runnable decodingEndedNotification = new Runnable() {
        public void run() {
            DecoderListener decoderListener = (DecoderListener) MediaCodecManager.this.decoderListenerRef.get();
            if (decoderListener != null) {
                decoderListener.onDecodingEnded();
            }
        }
    };
    private final Runnable decodingErrorNotification = new Runnable() {
        public void run() {
            DecoderListener decoderListener = (DecoderListener) MediaCodecManager.this.decoderListenerRef.get();
            if (decoderListener != null) {
                decoderListener.onDecodingError();
            }
        }
    };
    private final Runnable decodingStartedNotification = new Runnable() {
        public void run() {
            DecoderListener decoderListener = (DecoderListener) MediaCodecManager.this.decoderListenerRef.get();
            if (decoderListener != null) {
                decoderListener.onDecodingStarted();
            }
        }
    };
    /* access modifiers changed from: private */
    public DequeueCodec dequeueRunner;
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public final AtomicBoolean isDecoding = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicReference<MediaCodec> mediaCodecRef = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final NaluChunkAssembler naluChunkAssembler;
    private final AtomicReference<NaluChunkListener> naluChunkListenerRef = new AtomicReference<>();
    /* access modifiers changed from: private */
    public final AtomicBoolean processInputData = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean sendCompletionFlag = new AtomicBoolean(false);
    private final Runnable stopSafely = new Runnable() {
        public void run() {
            MediaCodecManager.this.processInputData.set(false);
            MediaCodecManager.this.sendCompletionFlag.set(false);
            MediaCodecManager.this.naluChunkAssembler.reset();
            if (MediaCodecManager.this.dequeueRunner != null && MediaCodecManager.this.dequeueRunner.isAlive()) {
                Log.d(MediaCodecManager.TAG, "Interrupting dequeue runner thread.");
                MediaCodecManager.this.dequeueRunner.interrupt();
            }
            DequeueCodec unused = MediaCodecManager.this.dequeueRunner = null;
            MediaCodec mediaCodec = (MediaCodec) MediaCodecManager.this.mediaCodecRef.get();
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                } catch (IllegalStateException e) {
                    Log.e(MediaCodecManager.TAG, "Error while stopping media codec.", e);
                }
                mediaCodec.release();
                MediaCodecManager.this.mediaCodecRef.set((Object) null);
            }
            MediaCodecManager.this.surfaceRef.set((Object) null);
            MediaCodecManager.this.isDecoding.set(false);
            MediaCodecManager.this.handler.post(MediaCodecManager.this.decodingEndedNotification);
        }
    };
    /* access modifiers changed from: private */
    public final AtomicReference<Surface> surfaceRef = new AtomicReference<>();

    public interface NaluChunkListener {
        void onNaluChunkUpdated(NaluChunk naluChunk, NaluChunk naluChunk2);
    }

    public MediaCodecManager(Handler handler2) {
        this.handler = handler2;
        this.naluChunkAssembler = new NaluChunkAssembler();
    }

    public void setNaluChunkListener(NaluChunkListener naluChunkListener) {
        this.naluChunkListenerRef.set(naluChunkListener);
    }

    public Surface getSurface() {
        return this.surfaceRef.get();
    }

    public void startDecoding(Surface surface, DecoderListener decoderListener) {
        if (surface == null) {
            throw new IllegalStateException("Surface argument must be non-null.");
        } else if (this.isDecoding.compareAndSet(false, true)) {
            Log.i(TAG, "Starting decoding...");
            this.naluChunkAssembler.reset();
            this.decoderListenerRef.set(decoderListener);
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", DEFAULT_VIDEO_WIDTH, DEFAULT_VIDEO_HEIGHT);
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType("video/avc");
            createDecoderByType.configure(createVideoFormat, surface, (MediaCrypto) null, 0);
            createDecoderByType.start();
            this.surfaceRef.set(surface);
            this.mediaCodecRef.set(createDecoderByType);
            this.processInputData.set(true);
            DequeueCodec dequeueCodec = new DequeueCodec();
            this.dequeueRunner = dequeueCodec;
            dequeueCodec.start();
        }
    }

    public void stopDecoding(DecoderListener decoderListener) {
        Log.i(TAG, "Stopping input data processing...");
        this.decoderListenerRef.set(decoderListener);
        if (!this.isDecoding.get()) {
            if (decoderListener != null) {
                notifyDecodingEnded();
            }
        } else if (!this.decodedFirstFrame.get()) {
            this.handler.post(this.stopSafely);
        } else if (this.processInputData.compareAndSet(true, false)) {
            this.sendCompletionFlag.set(!processNALUChunk(this.naluChunkAssembler.getEndOfStream()));
        }
    }

    public void onInputDataReceived(byte[] bArr, int i) {
        if (!this.isDecoding.get()) {
            return;
        }
        if (this.processInputData.get()) {
            NaluChunk assembleNALUChunk = this.naluChunkAssembler.assembleNALUChunk(bArr, i);
            if (assembleNALUChunk != null) {
                processNALUChunk(assembleNALUChunk);
            }
        } else if (this.sendCompletionFlag.get()) {
            Log.d(TAG, "Sending end of stream data.");
            this.sendCompletionFlag.set(!processNALUChunk(this.naluChunkAssembler.getEndOfStream()));
        }
    }

    private boolean processNALUChunk(NaluChunk naluChunk) {
        MediaCodec mediaCodec;
        ByteBuffer byteBuffer;
        if (naluChunk == null || (mediaCodec = this.mediaCodecRef.get()) == null) {
            return false;
        }
        try {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1);
            if (dequeueInputBuffer < 0) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                byteBuffer = mediaCodec.getInputBuffer(dequeueInputBuffer);
            } else {
                byteBuffer = mediaCodec.getInputBuffers()[dequeueInputBuffer];
            }
            if (byteBuffer == null) {
                return false;
            }
            byteBuffer.clear();
            int i = 0;
            for (ByteBuffer byteBuffer2 : naluChunk.payloads) {
                if (byteBuffer2.capacity() != 0) {
                    byteBuffer.order(byteBuffer2.order());
                    int position = byteBuffer2.position();
                    byteBuffer.put(byteBuffer2.array(), 0, position);
                    i += position;
                }
            }
            NaluChunkListener naluChunkListener = this.naluChunkListenerRef.get();
            if (naluChunkListener != null) {
                naluChunkListener.onNaluChunkUpdated(this.naluChunkAssembler.getParametersSet(), naluChunk);
            }
            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, naluChunk.presentationTime, naluChunk.flags);
            return true;
        } catch (IllegalStateException e) {
            Log.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void notifyDecodingStarted() {
        this.handler.post(this.decodingStartedNotification);
    }

    /* access modifiers changed from: private */
    public void notifyDecodingError() {
        this.handler.post(this.decodingErrorNotification);
    }

    /* access modifiers changed from: private */
    public void notifyDecodingEnded() {
        this.handler.post(this.stopSafely);
    }

    private class DequeueCodec extends Thread {
        private DequeueCodec() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
            if (isInterrupted() != false) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b3, code lost:
            if (isInterrupted() == false) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b5, code lost:
            com.o3dr.android.client.utils.video.MediaCodecManager.access$1500(r8.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ba, code lost:
            android.util.Log.i(com.o3dr.android.client.utils.video.MediaCodecManager.access$400(), "Stopping dequeue codec runner.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c1, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                com.o3dr.android.client.utils.video.MediaCodecManager r0 = com.o3dr.android.client.utils.video.MediaCodecManager.this
                java.util.concurrent.atomic.AtomicReference r0 = r0.mediaCodecRef
                java.lang.Object r0 = r0.get()
                android.media.MediaCodec r0 = (android.media.MediaCodec) r0
                if (r0 == 0) goto L_0x00c2
                java.lang.String r1 = com.o3dr.android.client.utils.video.MediaCodecManager.TAG
                java.lang.String r2 = "Starting dequeue codec runner."
                android.util.Log.i(r1, r2)
                android.media.MediaCodec$BufferInfo r1 = new android.media.MediaCodec$BufferInfo
                r1.<init>()
                com.o3dr.android.client.utils.video.MediaCodecManager r2 = com.o3dr.android.client.utils.video.MediaCodecManager.this
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.decodedFirstFrame
                r3 = 0
                r2.set(r3)
                r2 = 1
                r4 = 1
            L_0x0028:
                java.lang.String r5 = "Stopping dequeue codec runner."
                if (r4 == 0) goto L_0x00af
                r6 = -1
                int r6 = r0.dequeueOutputBuffer(r1, r6)     // Catch:{ IllegalStateException -> 0x0080 }
                if (r6 < 0) goto L_0x0028
                int r4 = r1.size     // Catch:{ IllegalStateException -> 0x0080 }
                if (r4 == 0) goto L_0x003a
                r4 = 1
                goto L_0x003b
            L_0x003a:
                r4 = 0
            L_0x003b:
                r0.releaseOutputBuffer(r6, r4)     // Catch:{ IllegalStateException -> 0x0080 }
                com.o3dr.android.client.utils.video.MediaCodecManager r4 = com.o3dr.android.client.utils.video.MediaCodecManager.this     // Catch:{ IllegalStateException -> 0x0080 }
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.decodedFirstFrame     // Catch:{ IllegalStateException -> 0x0080 }
                boolean r4 = r4.compareAndSet(r3, r2)     // Catch:{ IllegalStateException -> 0x0080 }
                if (r4 == 0) goto L_0x0069
                com.o3dr.android.client.utils.video.MediaCodecManager r4 = com.o3dr.android.client.utils.video.MediaCodecManager.this     // Catch:{ IllegalStateException -> 0x0080 }
                r4.notifyDecodingStarted()     // Catch:{ IllegalStateException -> 0x0080 }
                java.lang.String r4 = com.o3dr.android.client.utils.video.MediaCodecManager.TAG     // Catch:{ IllegalStateException -> 0x0080 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0080 }
                r6.<init>()     // Catch:{ IllegalStateException -> 0x0080 }
                java.lang.String r7 = "Received first decoded frame of size "
                r6.append(r7)     // Catch:{ IllegalStateException -> 0x0080 }
                int r7 = r1.size     // Catch:{ IllegalStateException -> 0x0080 }
                r6.append(r7)     // Catch:{ IllegalStateException -> 0x0080 }
                java.lang.String r6 = r6.toString()     // Catch:{ IllegalStateException -> 0x0080 }
                android.util.Log.i(r4, r6)     // Catch:{ IllegalStateException -> 0x0080 }
            L_0x0069:
                int r4 = r1.flags     // Catch:{ IllegalStateException -> 0x0080 }
                r4 = r4 & 4
                if (r4 != 0) goto L_0x0071
                r4 = 1
                goto L_0x0072
            L_0x0071:
                r4 = 0
            L_0x0072:
                if (r4 != 0) goto L_0x0028
                java.lang.String r6 = com.o3dr.android.client.utils.video.MediaCodecManager.TAG     // Catch:{ IllegalStateException -> 0x0080 }
                java.lang.String r7 = "Received end of stream flag."
                android.util.Log.i(r6, r7)     // Catch:{ IllegalStateException -> 0x0080 }
                goto L_0x0028
            L_0x007e:
                r0 = move-exception
                goto L_0x009c
            L_0x0080:
                r0 = move-exception
                boolean r1 = r8.isInterrupted()     // Catch:{ all -> 0x007e }
                if (r1 != 0) goto L_0x0095
                java.lang.String r1 = com.o3dr.android.client.utils.video.MediaCodecManager.TAG     // Catch:{ all -> 0x007e }
                java.lang.String r2 = "Decoding error!"
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x007e }
                com.o3dr.android.client.utils.video.MediaCodecManager r0 = com.o3dr.android.client.utils.video.MediaCodecManager.this     // Catch:{ all -> 0x007e }
                r0.notifyDecodingError()     // Catch:{ all -> 0x007e }
            L_0x0095:
                boolean r0 = r8.isInterrupted()
                if (r0 != 0) goto L_0x00ba
                goto L_0x00b5
            L_0x009c:
                boolean r1 = r8.isInterrupted()
                if (r1 != 0) goto L_0x00a7
                com.o3dr.android.client.utils.video.MediaCodecManager r1 = com.o3dr.android.client.utils.video.MediaCodecManager.this
                r1.notifyDecodingEnded()
            L_0x00a7:
                java.lang.String r1 = com.o3dr.android.client.utils.video.MediaCodecManager.TAG
                android.util.Log.i(r1, r5)
                throw r0
            L_0x00af:
                boolean r0 = r8.isInterrupted()
                if (r0 != 0) goto L_0x00ba
            L_0x00b5:
                com.o3dr.android.client.utils.video.MediaCodecManager r0 = com.o3dr.android.client.utils.video.MediaCodecManager.this
                r0.notifyDecodingEnded()
            L_0x00ba:
                java.lang.String r0 = com.o3dr.android.client.utils.video.MediaCodecManager.TAG
                android.util.Log.i(r0, r5)
                return
            L_0x00c2:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "Start decoding hasn't been called yet."
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.o3dr.android.client.utils.video.MediaCodecManager.DequeueCodec.run():void");
        }
    }
}
