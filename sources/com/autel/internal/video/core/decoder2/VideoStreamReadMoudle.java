package com.autel.internal.video.core.decoder2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.autel.internal.video.core.decoder2.common.StreamData;
import com.autel.internal.video.core.decoder2.common.VideoIpConst;
import com.autel.internal.video.core.decoder2.common.VideoStreamReadListener;
import com.autel.internal.video.core.decoder2.utils.HandlerThreadUtils;
import com.autel.internal.video.core.decoder2.utils.VideoDecoderLogUtils;
import com.autel.video.AutelPlayer;
import java.util.concurrent.ConcurrentHashMap;

public class VideoStreamReadMoudle {
    private static VideoStreamReadMoudle instance_;
    private final int MSG_CLOSE_STREAM = 2;
    private final int MSG_OPEN_STREAM = 0;
    private final int MSG_READ_STREAM = 1;
    private final int MSG_REOPEN_STREAM = 3;
    private boolean hasVideoStreamComeIn;
    /* access modifiers changed from: private */
    public boolean isVideoStreamReadStart;
    private final ConcurrentHashMap<Integer, MapObject> listeners = new ConcurrentHashMap<>();
    private long mStreamHandle;
    /* access modifiers changed from: private */
    public Handler readStreamHandler;
    private HandlerThread readStreamHandlerThread;
    private int timeout_cnt = 0;

    class MapObject {
        public Handler handler;
        public VideoStreamReadListener listener;
        public int mapKey;

        public MapObject(VideoStreamReadListener videoStreamReadListener, Handler handler2) {
            this.mapKey = videoStreamReadListener.hashCode();
            this.listener = videoStreamReadListener;
            this.handler = handler2;
        }
    }

    public static VideoStreamReadMoudle getInstance() {
        if (instance_ == null) {
            synchronized (VideoStreamReadMoudle.class) {
                if (instance_ == null) {
                    instance_ = new VideoStreamReadMoudle();
                }
            }
        }
        return instance_;
    }

    private VideoStreamReadMoudle() {
    }

    public void addVideoStreamReadListener(VideoStreamReadListener videoStreamReadListener, Handler handler) {
        if (this.listeners.get(Integer.valueOf(videoStreamReadListener.hashCode())) == null) {
            this.listeners.put(Integer.valueOf(videoStreamReadListener.hashCode()), new MapObject(videoStreamReadListener, handler));
        }
        if (this.listeners.size() == 1 && !this.isVideoStreamReadStart) {
            startReadStreamDataHandler();
        }
    }

    public void removeVideoStreamReadListener(VideoStreamReadListener videoStreamReadListener) {
        if (videoStreamReadListener != null) {
            this.listeners.remove(Integer.valueOf(videoStreamReadListener.hashCode()));
            if (this.listeners.isEmpty()) {
                this.isVideoStreamReadStart = false;
            }
        }
    }

    public boolean hasVideoStreamComeIn() {
        return this.hasVideoStreamComeIn;
    }

    private void startReadStreamDataHandler() {
        if (!this.isVideoStreamReadStart) {
            HandlerThread handlerThread = new HandlerThread("VideoStreamReadMoudle read stream data handler thread");
            this.readStreamHandlerThread = handlerThread;
            handlerThread.start();
            C49121 r0 = new Handler(this.readStreamHandlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 0) {
                        boolean unused = VideoStreamReadMoudle.this.isVideoStreamReadStart = true;
                        if (VideoStreamReadMoudle.this.openStream()) {
                            sendEmptyMessage(1);
                        } else {
                            sendEmptyMessageDelayed(0, 100);
                        }
                    } else if (i == 1) {
                        VideoStreamReadMoudle.this.readStreamHandler.removeCallbacksAndMessages((Object) null);
                        if (VideoStreamReadMoudle.this.isVideoStreamReadStart) {
                            long access$300 = VideoStreamReadMoudle.this.readStream();
                            long j = 0;
                            if (access$300 < 0) {
                                VideoStreamReadMoudle.this.readStreamHandler.sendEmptyMessage(3);
                                return;
                            }
                            Handler access$200 = VideoStreamReadMoudle.this.readStreamHandler;
                            if (access$300 <= 15) {
                                j = 15 - access$300;
                            }
                            access$200.sendEmptyMessageDelayed(1, j);
                            return;
                        }
                        VideoStreamReadMoudle.this.readStreamHandler.sendEmptyMessage(2);
                    } else if (i == 2) {
                        VideoStreamReadMoudle.this.destroy();
                    } else if (i == 3) {
                        VideoStreamReadMoudle.this.reOpenStream();
                    }
                }
            };
            this.readStreamHandler = r0;
            r0.sendEmptyMessage(0);
        }
    }

    /* access modifiers changed from: private */
    public boolean openStream() {
        if (this.mStreamHandle == 0) {
            this.mStreamHandle = AutelPlayer.OpenStream(VideoIpConst.getRtspHostAddr());
            Log.e("vvvvvv", "mStreamHandle == " + this.mStreamHandle);
        }
        return this.mStreamHandle != 0;
    }

    /* access modifiers changed from: private */
    public void reOpenStream() {
        Log.e("vvvvvv", "==== reOpenStream ====");
        this.readStreamHandler.removeCallbacksAndMessages((Object) null);
        long j = this.mStreamHandle;
        if (j != 0) {
            AutelPlayer.CloseStream(j);
        }
        this.mStreamHandle = 0;
        this.readStreamHandler.sendEmptyMessage(0);
    }

    /* access modifiers changed from: private */
    public long readStream() {
        if (this.listeners.isEmpty()) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = new byte[1048576];
        int ReadStream = AutelPlayer.ReadStream(this.mStreamHandle, bArr, 1048576, 50);
        if (ReadStream > 0) {
            try {
                StreamData streamData = new StreamData();
                streamData.parseData(bArr);
                callback(streamData);
                if (this.timeout_cnt >= 100) {
                    VideoDecoderLogUtils.writeNecessaryLog("***** video stream is online.");
                }
                this.timeout_cnt = 0;
                this.hasVideoStreamComeIn = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ReadStream == 0) {
            int i = this.timeout_cnt + 1;
            this.timeout_cnt = i;
            if (i % 150 == 0) {
                VideoDecoderLogUtils.writeNecessaryLog("No video stream data.---");
                this.hasVideoStreamComeIn = false;
                return -1;
            }
        }
        return System.currentTimeMillis() - currentTimeMillis;
    }

    private void callback(final StreamData streamData) {
        for (final MapObject next : this.listeners.values()) {
            if (next.handler != null) {
                next.handler.post(new Runnable() {
                    public void run() {
                        next.listener.onDataRecv(streamData);
                    }
                });
            } else {
                next.listener.onDataRecv(streamData);
            }
        }
    }

    /* access modifiers changed from: private */
    public void destroy() {
        long j = this.mStreamHandle;
        if (j != 0) {
            AutelPlayer.CloseStream(j);
        }
        this.mStreamHandle = 0;
        HandlerThreadUtils.cancelHandlerThread(this.readStreamHandlerThread, this.readStreamHandler);
    }
}
