package com.o3dr.android.client.apis;

import android.os.Bundle;
import android.view.Surface;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.drone.action.CameraActions;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.ConcurrentHashMap;

public class CameraApi extends Api {
    public static final String VIDEO_ENABLE_LOCAL_RECORDING = "extra_video_enable_local_recording";
    public static final String VIDEO_LOCAL_RECORDING_FILENAME = "extra_video_local_recording_filename";
    public static final String VIDEO_PROPS_UDP_PORT = "extra_video_props_udp_port";
    private static final Api.Builder<CameraApi> apiBuilder = new Api.Builder<CameraApi>() {
        public CameraApi build(Drone drone) {
            return new CameraApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, CameraApi> apiCache = new ConcurrentHashMap<>();
    private final Drone drone;

    public static CameraApi getApi(Drone drone2) {
        return (CameraApi) getApi(drone2, apiCache, apiBuilder);
    }

    private CameraApi(Drone drone2) {
        this.drone = drone2;
    }

    public void startVideoStream(Surface surface, String str, Bundle bundle, AbstractCommandListener abstractCommandListener) {
        if (surface == null || bundle == null) {
            postErrorEvent(4, abstractCommandListener);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(CameraActions.EXTRA_VIDEO_DISPLAY, surface);
        bundle2.putString(CameraActions.EXTRA_VIDEO_TAG, str);
        bundle2.putBundle(CameraActions.EXTRA_VIDEO_PROPERTIES, bundle);
        this.drone.performAsyncActionOnDroneThread(new Action(CameraActions.ACTION_START_VIDEO_STREAM, bundle2), abstractCommandListener);
    }

    public void stopVideoStream(String str, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putString(CameraActions.EXTRA_VIDEO_TAG, str);
        this.drone.performAsyncActionOnDroneThread(new Action(CameraActions.ACTION_STOP_VIDEO_STREAM, bundle), abstractCommandListener);
    }
}
