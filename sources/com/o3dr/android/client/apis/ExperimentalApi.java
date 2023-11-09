package com.o3dr.android.client.apis;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.android.client.apis.CapabilityApi;
import com.o3dr.android.client.utils.connection.IpConnectionListener;
import com.o3dr.android.client.utils.connection.UdpConnection;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.action.CameraActions;
import com.o3dr.services.android.lib.drone.action.ExperimentalActions;
import com.o3dr.services.android.lib.mavlink.MavlinkMessageWrapper;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ExperimentalApi extends Api {
    private static final Api.Builder<ExperimentalApi> apiBuilder = new Api.Builder<ExperimentalApi>() {
        public ExperimentalApi build(Drone drone) {
            return new ExperimentalApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, ExperimentalApi> experimentalApiCache = new ConcurrentHashMap<>();
    private final CapabilityApi capabilityChecker;
    private final Drone drone;
    /* access modifiers changed from: private */
    public final VideoStreamObserver videoStreamObserver;

    public interface IVideoStreamCallback {
        void onAsyncVideoStreamPacketReceived(byte[] bArr, int i);

        void onError(int i);

        void onTimeout();

        void onVideoStreamConnected();

        void onVideoStreamConnecting();

        void onVideoStreamDisconnected();

        void onVideoStreamDisconnecting();
    }

    public static ExperimentalApi getApi(Drone drone2) {
        return (ExperimentalApi) getApi(drone2, experimentalApiCache, apiBuilder);
    }

    private ExperimentalApi(Drone drone2) {
        this.drone = drone2;
        this.capabilityChecker = CapabilityApi.getApi(drone2);
        this.videoStreamObserver = new VideoStreamObserver(drone2.getHandler());
    }

    public void triggerCamera() {
        this.drone.performAsyncAction(new Action(ExperimentalActions.ACTION_TRIGGER_CAMERA));
    }

    public void setROI(LatLongAlt latLongAlt) {
        setROI(latLongAlt, (AbstractCommandListener) null);
    }

    public void setROI(LatLongAlt latLongAlt, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ExperimentalActions.EXTRA_SET_ROI_LAT_LONG_ALT, latLongAlt);
        this.drone.performAsyncActionOnDroneThread(new Action(ExperimentalActions.ACTION_SET_ROI, bundle), abstractCommandListener);
    }

    public void sendMavlinkMessage(MavlinkMessageWrapper mavlinkMessageWrapper) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ExperimentalActions.EXTRA_MAVLINK_MESSAGE, mavlinkMessageWrapper);
        this.drone.performAsyncAction(new Action(ExperimentalActions.ACTION_SEND_MAVLINK_MESSAGE, bundle));
    }

    public void setRelay(int i, boolean z) {
        setRelay(i, z, (AbstractCommandListener) null);
    }

    public void setRelay(int i, boolean z, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle(2);
        bundle.putInt(ExperimentalActions.EXTRA_RELAY_NUMBER, i);
        bundle.putBoolean(ExperimentalActions.EXTRA_IS_RELAY_ON, z);
        this.drone.performAsyncActionOnDroneThread(new Action(ExperimentalActions.ACTION_SET_RELAY, bundle), abstractCommandListener);
    }

    public void setServo(int i, int i2) {
        setServo(i, i2, (AbstractCommandListener) null);
    }

    public void setServo(int i, int i2, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle(2);
        bundle.putInt(ExperimentalActions.EXTRA_SERVO_CHANNEL, i);
        bundle.putInt(ExperimentalActions.EXTRA_SERVO_PWM, i2);
        this.drone.performAsyncActionOnDroneThread(new Action(ExperimentalActions.ACTION_SET_SERVO, bundle), abstractCommandListener);
    }

    public void startVideoStream(final String str, final IVideoStreamCallback iVideoStreamCallback) {
        Objects.requireNonNull(iVideoStreamCallback, "Video stream callback can't be null");
        this.capabilityChecker.checkFeatureSupport(CapabilityApi.FeatureIds.SOLO_VIDEO_STREAMING, new CapabilityApi.FeatureSupportListener() {
            public void onFeatureSupportResult(String str, int i, Bundle bundle) {
                C57431 r1 = new AbstractCommandListener() {
                    public void onSuccess() {
                        ExperimentalApi.this.videoStreamObserver.setCallback(iVideoStreamCallback);
                        ExperimentalApi.this.videoStreamObserver.start();
                        ExperimentalApi.this.videoStreamObserver.getCallback().onVideoStreamConnecting();
                    }

                    public void onError(int i) {
                        ExperimentalApi.this.videoStreamObserver.getCallback().onError(i);
                    }

                    public void onTimeout() {
                        ExperimentalApi.this.videoStreamObserver.getCallback().onTimeout();
                    }
                };
                if (i == 0) {
                    ExperimentalApi.this.startVideoStreamForObserver(str, r1);
                } else if (i != 1) {
                    Api.postErrorEvent(4, r1);
                } else {
                    Api.postErrorEvent(3, r1);
                }
            }
        });
    }

    public void stopVideoStream(final String str) {
        this.capabilityChecker.checkFeatureSupport(CapabilityApi.FeatureIds.SOLO_VIDEO_STREAMING, new CapabilityApi.FeatureSupportListener() {
            public void onFeatureSupportResult(String str, int i, Bundle bundle) {
                C57451 r1 = new AbstractCommandListener() {
                    public void onSuccess() {
                        ExperimentalApi.this.videoStreamObserver.getCallback().onVideoStreamDisconnecting();
                        ExperimentalApi.this.videoStreamObserver.stop();
                    }

                    public void onError(int i) {
                        ExperimentalApi.this.videoStreamObserver.getCallback().onError(i);
                    }

                    public void onTimeout() {
                        ExperimentalApi.this.videoStreamObserver.getCallback().onTimeout();
                    }
                };
                if (i == 0) {
                    ExperimentalApi.this.stopVideoStreamForObserver(str, r1);
                } else if (i != 1) {
                    Api.postErrorEvent(4, r1);
                } else {
                    Api.postErrorEvent(3, r1);
                }
            }
        });
    }

    private String getObserverTag(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("observer");
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        sb.append(str2);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void startVideoStreamForObserver(String str, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putString(CameraActions.EXTRA_VIDEO_TAG, getObserverTag(str));
        this.drone.performAsyncActionOnDroneThread(new Action(ExperimentalActions.ACTION_START_VIDEO_STREAM_FOR_OBSERVER, bundle), abstractCommandListener);
    }

    /* access modifiers changed from: private */
    public void stopVideoStreamForObserver(String str, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putString(CameraActions.EXTRA_VIDEO_TAG, getObserverTag(str));
        this.drone.performAsyncActionOnDroneThread(new Action(ExperimentalActions.ACTION_STOP_VIDEO_STREAM_FOR_OBSERVER, bundle), abstractCommandListener);
    }

    private static class VideoStreamObserver implements IpConnectionListener {
        private static final long RECONNECT_COUNTDOWN_IN_MILLIS = 1000;
        private static final int SOLO_STREAM_UDP_PORT = 5600;
        private static final int UDP_BUFFER_SIZE = 1500;
        private final String TAG = VideoStreamObserver.class.getSimpleName();
        /* access modifiers changed from: private */
        public IVideoStreamCallback callback;
        /* access modifiers changed from: private */
        public final Handler handler;
        /* access modifiers changed from: private */
        public UdpConnection linkConn;
        private final Runnable onVideoStreamConnected = new Runnable() {
            public void run() {
                VideoStreamObserver.this.handler.removeCallbacks(this);
                if (VideoStreamObserver.this.callback != null) {
                    VideoStreamObserver.this.callback.onVideoStreamConnected();
                }
            }
        };
        private final Runnable onVideoStreamDisconnected = new Runnable() {
            public void run() {
                VideoStreamObserver.this.handler.removeCallbacks(this);
                if (VideoStreamObserver.this.callback != null) {
                    VideoStreamObserver.this.callback.onVideoStreamDisconnected();
                }
            }
        };
        /* access modifiers changed from: private */
        public final Runnable reconnectTask = new Runnable() {
            public void run() {
                VideoStreamObserver.this.handler.removeCallbacks(VideoStreamObserver.this.reconnectTask);
                if (VideoStreamObserver.this.linkConn != null) {
                    VideoStreamObserver.this.linkConn.connect((Bundle) null);
                }
            }
        };

        public VideoStreamObserver(Handler handler2) {
            this.handler = handler2;
        }

        public void setCallback(IVideoStreamCallback iVideoStreamCallback) {
            this.callback = iVideoStreamCallback;
        }

        /* access modifiers changed from: private */
        public IVideoStreamCallback getCallback() {
            return this.callback;
        }

        public void start() {
            if (this.linkConn == null) {
                UdpConnection udpConnection = new UdpConnection(this.handler, 5600, UDP_BUFFER_SIZE, true, 42);
                this.linkConn = udpConnection;
                udpConnection.setIpConnectionListener(this);
            }
            this.handler.removeCallbacks(this.reconnectTask);
            Log.d(this.TAG, "Connecting to video stream...");
            this.linkConn.connect((Bundle) null);
        }

        public void stop() {
            Log.d(this.TAG, "Stopping video manager");
            this.handler.removeCallbacks(this.reconnectTask);
            UdpConnection udpConnection = this.linkConn;
            if (udpConnection != null) {
                udpConnection.disconnect();
                this.linkConn = null;
            }
        }

        public void onIpConnected() {
            Log.d(this.TAG, "Connected to video stream");
            this.handler.post(this.onVideoStreamConnected);
            this.handler.removeCallbacks(this.reconnectTask);
        }

        public void onIpDisconnected() {
            Log.d(this.TAG, "Video stream disconnected");
            this.handler.post(this.onVideoStreamDisconnected);
            this.handler.postDelayed(this.reconnectTask, RECONNECT_COUNTDOWN_IN_MILLIS);
        }

        public void onPacketReceived(ByteBuffer byteBuffer) {
            this.callback.onAsyncVideoStreamPacketReceived(byteBuffer.array(), byteBuffer.limit());
        }
    }
}
