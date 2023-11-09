package org.droidplanner.services.android.impl.utils.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import atakplugin.UASTool.cqb;
import com.o3dr.android.client.utils.connection.IpConnectionListener;
import com.o3dr.android.client.utils.connection.UdpConnection;
import com.o3dr.android.client.utils.video.DecoderListener;
import com.o3dr.android.client.utils.video.MediaCodecManager;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.communication.model.DataLink;

public class VideoManager implements IpConnectionListener {
    public static final int ARTOO_UDP_PORT = 5600;
    private static final SimpleDateFormat FILE_DATE_FORMAT = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
    private static final String NO_VIDEO_OWNER = "no_video_owner";
    protected static final long RECONNECT_COUNTDOWN = 1000;
    /* access modifiers changed from: private */
    public static final String TAG = "VideoManager";
    private static final int UDP_BUFFER_SIZE = 1500;
    protected final Handler handler;
    private final AtomicBoolean isStarted = new AtomicBoolean(false);
    protected UdpConnection linkConn;
    private LinkListener linkListener;
    private int linkPort = -1;
    /* access modifiers changed from: private */
    public final DataLink.DataLinkProvider linkProvider;
    /* access modifiers changed from: private */
    public final MediaCodecManager mediaCodecManager;
    /* access modifiers changed from: private */
    public final Runnable reconnectTask = new Runnable() {
        public void run() {
            VideoManager.this.handler.removeCallbacks(VideoManager.this.reconnectTask);
            if (VideoManager.this.linkConn != null) {
                VideoManager.this.linkConn.connect(VideoManager.this.linkProvider.getConnectionExtras());
            }
        }
    };
    private final StreamRecorder streamRecorder;
    private final AtomicReference<String> videoOwnerId = new AtomicReference<>(NO_VIDEO_OWNER);
    private final AtomicBoolean videoStreamObserverUsed = new AtomicBoolean(false);
    private final AtomicReference<String> videoTagRef = new AtomicReference<>("");
    private final AtomicBoolean wasConnected = new AtomicBoolean(false);

    public interface LinkListener {
        void onLinkConnected();

        void onLinkDisconnected();
    }

    /* access modifiers changed from: protected */
    public boolean shouldReconnect() {
        return true;
    }

    public VideoManager(Context context, Handler handler2, DataLink.DataLinkProvider dataLinkProvider) {
        StreamRecorder streamRecorder2 = new StreamRecorder(context);
        this.streamRecorder = streamRecorder2;
        this.handler = handler2;
        MediaCodecManager mediaCodecManager2 = new MediaCodecManager(handler2);
        this.mediaCodecManager = mediaCodecManager2;
        mediaCodecManager2.setNaluChunkListener(streamRecorder2);
        this.linkProvider = dataLinkProvider;
    }

    private void enableLocalRecording(String str) {
        this.streamRecorder.enableRecording(str);
    }

    private void disableLocalRecording() {
        this.streamRecorder.disableRecording();
    }

    public void startDecoding(int i, final Surface surface, final DecoderListener decoderListener) {
        start(i, (LinkListener) null);
        if (surface != this.mediaCodecManager.getSurface()) {
            Log.i(TAG, "Setting up video stream decoding.");
            this.mediaCodecManager.stopDecoding(new DecoderListener() {
                public void onDecodingError() {
                }

                public void onDecodingStarted() {
                }

                public void onDecodingEnded() {
                    try {
                        Log.i(VideoManager.TAG, "Video decoding set up complete. Starting...");
                        VideoManager.this.mediaCodecManager.startDecoding(surface, decoderListener);
                    } catch (IOException | IllegalStateException e) {
                        Log.e(VideoManager.TAG, "Unable to create media codec.", e);
                        DecoderListener decoderListener = decoderListener;
                        if (decoderListener != null) {
                            decoderListener.onDecodingError();
                        }
                    }
                }
            });
        } else if (decoderListener != null) {
            decoderListener.onDecodingStarted();
        }
    }

    public void reset() {
        cqb.m12007b("Resetting video tag (%s) and owner id (%s)", this.videoTagRef.get(), this.videoOwnerId.get());
        this.videoTagRef.set("");
        this.videoOwnerId.set(NO_VIDEO_OWNER);
        disableLocalRecording();
        stopDecoding((DecoderListener) null);
    }

    public void stopDecoding(DecoderListener decoderListener) {
        Log.i(TAG, "Aborting video decoding process.");
        this.mediaCodecManager.stopDecoding(decoderListener);
        stop();
    }

    public boolean isLinkConnected() {
        UdpConnection udpConnection = this.linkConn;
        return udpConnection != null && udpConnection.getConnectionStatus() == 2;
    }

    private void start(int i, LinkListener linkListener2) {
        if (this.linkConn == null || i != this.linkPort) {
            if (this.isStarted.get()) {
                stop();
            }
            UdpConnection udpConnection = new UdpConnection(this.handler, i, UDP_BUFFER_SIZE, true, 42);
            this.linkConn = udpConnection;
            udpConnection.setIpConnectionListener(this);
            this.linkPort = i;
        }
        Log.d(TAG, "Starting video manager");
        this.handler.removeCallbacks(this.reconnectTask);
        this.isStarted.set(true);
        this.streamRecorder.startConverterThread();
        this.linkConn.connect(this.linkProvider.getConnectionExtras());
        this.linkListener = linkListener2;
    }

    private void stop() {
        Log.d(TAG, "Stopping video manager");
        this.handler.removeCallbacks(this.reconnectTask);
        this.isStarted.set(false);
        UdpConnection udpConnection = this.linkConn;
        if (udpConnection != null) {
            udpConnection.disconnect();
            this.linkConn = null;
        }
        this.linkPort = -1;
        this.streamRecorder.stopConverterThread();
    }

    public void onIpConnected() {
        Log.d(TAG, "Connected to video stream");
        this.handler.removeCallbacks(this.reconnectTask);
        this.wasConnected.set(true);
        LinkListener linkListener2 = this.linkListener;
        if (linkListener2 != null) {
            linkListener2.onLinkConnected();
        }
    }

    public void onIpDisconnected() {
        Log.d(TAG, "Video stream disconnected");
        if (this.isStarted.get()) {
            if (shouldReconnect()) {
                this.handler.postDelayed(this.reconnectTask, RECONNECT_COUNTDOWN);
            }
            if (this.linkListener != null && this.wasConnected.get()) {
                this.linkListener.onLinkDisconnected();
            }
            this.wasConnected.set(false);
        }
    }

    public void onPacketReceived(ByteBuffer byteBuffer) {
        if (!this.videoStreamObserverUsed.get()) {
            this.mediaCodecManager.onInputDataReceived(byteBuffer.array(), byteBuffer.limit());
        }
    }

    /* access modifiers changed from: protected */
    public void postSuccessEvent(final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onSuccess();
                    } catch (RemoteException e) {
                        Log.e(VideoManager.TAG, e.getMessage(), e);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void postTimeoutEvent(final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onTimeout();
                    } catch (RemoteException e) {
                        Log.e(VideoManager.TAG, e.getMessage(), e);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void postErrorEvent(final int i, final ICommandListener iCommandListener) {
        Handler handler2 = this.handler;
        if (handler2 != null && iCommandListener != null) {
            handler2.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onError(i);
                    } catch (RemoteException e) {
                        Log.e(VideoManager.TAG, e.getMessage(), e);
                    }
                }
            });
        }
    }

    private void checkForLocalRecording(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            if (bundle.getBoolean("extra_video_enable_local_recording")) {
                String string = bundle.getString("extra_video_local_recording_filename");
                if (TextUtils.isEmpty(string)) {
                    string = str + "." + FILE_DATE_FORMAT.format(new Date());
                }
                if (!string.equalsIgnoreCase(this.streamRecorder.getRecordingFilename())) {
                    if (this.streamRecorder.isRecordingEnabled()) {
                        disableLocalRecording();
                    }
                    enableLocalRecording(string);
                    return;
                }
                return;
            }
            disableLocalRecording();
        }
    }

    public void startVideoStream(Bundle bundle, String str, String str2, Surface surface, final ICommandListener iCommandListener) {
        cqb.m12007b("Video stream start request from %s. Video owner is %s.", str, this.videoOwnerId.get());
        if (isAppIdValid(str, iCommandListener)) {
            int i = bundle.getInt("extra_video_props_udp_port", -1);
            if (surface == null || i == -1) {
                postErrorEvent(4, iCommandListener);
                return;
            }
            String str3 = "";
            if (str2 == null) {
                str2 = str3;
            }
            if (str.equals(this.videoOwnerId.get())) {
                String str4 = this.videoTagRef.get();
                if (str4 != null) {
                    str3 = str4;
                }
                if (str2.equals(str3)) {
                    checkForLocalRecording(str, bundle);
                    postSuccessEvent(iCommandListener);
                    return;
                }
            }
            if (this.videoOwnerId.compareAndSet(NO_VIDEO_OWNER, str)) {
                this.videoTagRef.set(str2);
                checkForLocalRecording(str, bundle);
                cqb.m12010c("Starting video decoding.", new Object[0]);
                startDecoding(i, surface, new DecoderListener() {
                    public void onDecodingStarted() {
                        cqb.m12010c("Video decoding started.", new Object[0]);
                        VideoManager.this.postSuccessEvent(iCommandListener);
                    }

                    public void onDecodingError() {
                        cqb.m12010c("Video decoding failed.", new Object[0]);
                        VideoManager.this.postErrorEvent(4, iCommandListener);
                        VideoManager.this.reset();
                    }

                    public void onDecodingEnded() {
                        cqb.m12010c("Video decoding ended successfully.", new Object[0]);
                        VideoManager.this.reset();
                    }
                });
                return;
            }
            postErrorEvent(2, iCommandListener);
        }
    }

    public void startVideoStreamForObserver(String str, String str2, ICommandListener iCommandListener) {
        cqb.m12007b("Video stream start request from %s. Video owner is %s.", str, this.videoOwnerId.get());
        if (isAppIdValid(str, iCommandListener)) {
            String str3 = "";
            if (str2 == null) {
                str2 = str3;
            }
            if (str.equals(this.videoOwnerId.get())) {
                String str4 = this.videoTagRef.get();
                if (str4 != null) {
                    str3 = str4;
                }
                if (str2.equals(str3)) {
                    postSuccessEvent(iCommandListener);
                    return;
                }
            }
            if (this.videoOwnerId.compareAndSet(NO_VIDEO_OWNER, str)) {
                this.videoTagRef.set(str2);
                cqb.m12010c("Successful lock obtained for app with id %s.", str);
                this.videoStreamObserverUsed.set(true);
                postSuccessEvent(iCommandListener);
                return;
            }
            postErrorEvent(2, iCommandListener);
        }
    }

    public void stopVideoStream(String str, String str2, final ICommandListener iCommandListener) {
        cqb.m12007b("Video stream stop request from %s. Video owner is %s.", str, this.videoOwnerId.get());
        if (isAppIdValid(str, iCommandListener)) {
            String str3 = this.videoOwnerId.get();
            if (NO_VIDEO_OWNER.equals(str3)) {
                cqb.m12007b("No video owner set. Nothing to do.", new Object[0]);
                disableLocalRecording();
                postSuccessEvent(iCommandListener);
                return;
            }
            if (str2 == null) {
                str2 = "";
            }
            if (!str.equals(str3) || !str2.equals(this.videoTagRef.get()) || !this.videoOwnerId.compareAndSet(str3, NO_VIDEO_OWNER)) {
                postErrorEvent(2, iCommandListener);
                return;
            }
            this.videoTagRef.set("");
            disableLocalRecording();
            cqb.m12007b("Stopping video decoding. Current owner is %s.", str3);
            cqb.m12010c("Stopping video decoding.", new Object[0]);
            stopDecoding(new DecoderListener() {
                public void onDecodingStarted() {
                }

                public void onDecodingError() {
                    VideoManager.this.postSuccessEvent(iCommandListener);
                }

                public void onDecodingEnded() {
                    VideoManager.this.postSuccessEvent(iCommandListener);
                }
            });
        }
    }

    public void stopVideoStreamForObserver(String str, String str2, ICommandListener iCommandListener) {
        cqb.m12007b("Video stream stop request from %s. Video owner is %s.", str, this.videoOwnerId.get());
        if (isAppIdValid(str, iCommandListener)) {
            String str3 = this.videoOwnerId.get();
            if (NO_VIDEO_OWNER.equals(str3)) {
                cqb.m12007b("No video owner set. Nothing to do.", new Object[0]);
                postSuccessEvent(iCommandListener);
                return;
            }
            if (str2 == null) {
                str2 = "";
            }
            if (!str.equals(str3) || !str2.equals(this.videoTagRef.get()) || !this.videoOwnerId.compareAndSet(str3, NO_VIDEO_OWNER)) {
                postErrorEvent(2, iCommandListener);
                return;
            }
            this.videoTagRef.set("");
            cqb.m12007b("Stopping video decoding. Current owner is %s.", str3);
            cqb.m12010c("Stop using video observer...", new Object[0]);
            this.videoStreamObserverUsed.set(false);
            postSuccessEvent(iCommandListener);
        }
    }

    public void tryStoppingVideoStream(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.videoOwnerId.get();
            if (!NO_VIDEO_OWNER.equals(str2) && str2.equals(str)) {
                cqb.m12007b("Stopping video owned by %s", str);
                if (this.videoStreamObserverUsed.get()) {
                    stopVideoStreamForObserver(str, this.videoTagRef.get(), (ICommandListener) null);
                } else {
                    stopVideoStream(str, this.videoTagRef.get(), (ICommandListener) null);
                }
            }
        }
    }

    private boolean isAppIdValid(String str, ICommandListener iCommandListener) {
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        cqb.m12012d("Owner id is empty.", new Object[0]);
        postErrorEvent(2, iCommandListener);
        return false;
    }
}
