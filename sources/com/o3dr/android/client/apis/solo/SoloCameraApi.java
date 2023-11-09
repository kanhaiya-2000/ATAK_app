package com.o3dr.android.client.apis.solo;

import android.os.Bundle;
import android.view.Surface;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.android.client.apis.CameraApi;
import com.o3dr.android.client.apis.CapabilityApi;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproRecord;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproSetExtendedRequest;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloGoproSetRequest;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class SoloCameraApi extends SoloApi {
    /* access modifiers changed from: private */
    public static final SimpleDateFormat FILE_DATE_FORMAT = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
    private static final int SOLO_STREAM_UDP_PORT = 5600;
    private static final Api.Builder<SoloCameraApi> apiBuilder = new Api.Builder<SoloCameraApi>() {
        public SoloCameraApi build(Drone drone) {
            return new SoloCameraApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, SoloCameraApi> soloCameraApiCache = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final CameraApi cameraApi;
    private final CapabilityApi capabilityChecker;

    public static SoloCameraApi getApi(Drone drone) {
        return (SoloCameraApi) getApi(drone, soloCameraApiCache, apiBuilder);
    }

    private SoloCameraApi(Drone drone) {
        super(drone);
        this.capabilityChecker = CapabilityApi.getApi(drone);
        this.cameraApi = CameraApi.getApi(drone);
    }

    public void takePhoto(final AbstractCommandListener abstractCommandListener) {
        switchCameraCaptureMode((byte) 1, new AbstractCommandListener() {
            public void onSuccess() {
                SoloCameraApi.this.sendMessage(new SoloGoproRecord(1), abstractCommandListener);
            }

            public void onError(int i) {
                AbstractCommandListener abstractCommandListener = abstractCommandListener;
                if (abstractCommandListener != null) {
                    abstractCommandListener.onError(i);
                }
            }

            public void onTimeout() {
                AbstractCommandListener abstractCommandListener = abstractCommandListener;
                if (abstractCommandListener != null) {
                    abstractCommandListener.onTimeout();
                }
            }
        });
    }

    public void toggleVideoRecording(AbstractCommandListener abstractCommandListener) {
        sendVideoRecordingCommand(2, abstractCommandListener);
    }

    public void startVideoRecording(AbstractCommandListener abstractCommandListener) {
        sendVideoRecordingCommand(1, abstractCommandListener);
    }

    public void stopVideoRecording(AbstractCommandListener abstractCommandListener) {
        sendVideoRecordingCommand(0, abstractCommandListener);
    }

    private void sendVideoRecordingCommand(final int i, final AbstractCommandListener abstractCommandListener) {
        switchCameraCaptureMode((byte) 0, new AbstractCommandListener() {
            public void onSuccess() {
                SoloCameraApi.this.sendMessage(new SoloGoproRecord(i), abstractCommandListener);
            }

            public void onError(int i) {
                AbstractCommandListener abstractCommandListener = abstractCommandListener;
                if (abstractCommandListener != null) {
                    abstractCommandListener.onError(i);
                }
            }

            public void onTimeout() {
                AbstractCommandListener abstractCommandListener = abstractCommandListener;
                if (abstractCommandListener != null) {
                    abstractCommandListener.onTimeout();
                }
            }
        });
    }

    public void startVideoStream(Surface surface, String str, AbstractCommandListener abstractCommandListener) {
        startVideoStream(surface, str, false, abstractCommandListener);
    }

    public void startVideoStream(Surface surface, String str, boolean z, AbstractCommandListener abstractCommandListener) {
        if (surface == null) {
            postErrorEvent(4, abstractCommandListener);
            return;
        }
        final boolean z2 = z;
        final Surface surface2 = surface;
        final String str2 = str;
        final AbstractCommandListener abstractCommandListener2 = abstractCommandListener;
        this.capabilityChecker.checkFeatureSupport(CapabilityApi.FeatureIds.SOLO_VIDEO_STREAMING, new CapabilityApi.FeatureSupportListener() {
            public void onFeatureSupportResult(String str, int i, Bundle bundle) {
                if (i == 0) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("extra_video_props_udp_port", 5600);
                    bundle2.putBoolean("extra_video_enable_local_recording", z2);
                    if (z2) {
                        bundle2.putString("extra_video_local_recording_filename", "solo_stream_" + SoloCameraApi.FILE_DATE_FORMAT.format(new Date()));
                    }
                    SoloCameraApi.this.cameraApi.startVideoStream(surface2, str2, bundle2, abstractCommandListener2);
                } else if (i != 1) {
                    SoloCameraApi.postErrorEvent(4, abstractCommandListener2);
                } else {
                    SoloCameraApi.postErrorEvent(3, abstractCommandListener2);
                }
            }
        });
    }

    public void startVideoStream(Surface surface, AbstractCommandListener abstractCommandListener) {
        startVideoStream(surface, "", abstractCommandListener);
    }

    public void stopVideoStream(AbstractCommandListener abstractCommandListener) {
        stopVideoStream("", abstractCommandListener);
    }

    public void stopVideoStream(final String str, final AbstractCommandListener abstractCommandListener) {
        this.capabilityChecker.checkFeatureSupport(CapabilityApi.FeatureIds.SOLO_VIDEO_STREAMING, new CapabilityApi.FeatureSupportListener() {
            public void onFeatureSupportResult(String str, int i, Bundle bundle) {
                if (i == 0) {
                    SoloCameraApi.this.cameraApi.stopVideoStream(str, abstractCommandListener);
                } else if (i != 1) {
                    SoloCameraApi.postErrorEvent(4, abstractCommandListener);
                } else {
                    SoloCameraApi.postErrorEvent(3, abstractCommandListener);
                }
            }
        });
    }

    public void switchCameraCaptureMode(byte b, AbstractCommandListener abstractCommandListener) {
        sendMessage(new SoloGoproSetRequest(1, (short) b), abstractCommandListener);
    }

    private void sendExtendedRequest(AbstractCommandListener abstractCommandListener, int i, byte b, byte b2, byte b3, byte b4) {
        sendMessage(new SoloGoproSetExtendedRequest((short) i, new byte[]{b, b2, b3, b4}), abstractCommandListener);
    }

    private void sendExtendedRequest(AbstractCommandListener abstractCommandListener, int i, byte b) {
        sendExtendedRequest(abstractCommandListener, i, b, (byte) 0, (byte) 0, (byte) 0);
    }

    public void updateVideoSettings(byte b, byte b2, byte b3, byte b4, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 5, b, b2, b3, b4);
    }

    public void setCameraPhotoResolution(byte b, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 7, b);
    }

    public void enableCameraLowLight(boolean z, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 6, z ? (byte) 1 : 0);
    }

    public void setCameraPhotoBurstRate(byte b, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 8, b);
    }

    public void enableCameraProtune(boolean z, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 9, z ? (byte) 1 : 0);
    }

    public void setCameraProtuneWhiteBalance(byte b, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 10, b);
    }

    public void setCameraProtuneColour(byte b, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 11, b);
    }

    public void setCameraProtuneGain(byte b, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 12, b);
    }

    public void setCameraProtuneSharpness(byte b, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 13, b);
    }

    public void setCameraProtuneExposure(byte b, AbstractCommandListener abstractCommandListener) {
        sendExtendedRequest(abstractCommandListener, 14, b);
    }
}
