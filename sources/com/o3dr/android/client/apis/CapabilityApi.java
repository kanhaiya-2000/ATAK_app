package com.o3dr.android.client.apis;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.drone.action.CapabilityActions;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.ConcurrentHashMap;

public class CapabilityApi extends Api {
    public static final int FEATURE_ERROR_DRONE_DISCONNECTED = -1;
    public static final int FEATURE_SUPPORTED = 0;
    public static final int FEATURE_UNSUPPORTED = 1;
    private static final Api.Builder<CapabilityApi> apiBuilder = new Api.Builder<CapabilityApi>() {
        public CapabilityApi build(Drone drone) {
            return new CapabilityApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, CapabilityApi> capabilityApiCache = new ConcurrentHashMap<>();
    private final Drone drone;

    public interface FeatureSupportListener {
        void onFeatureSupportResult(String str, int i, Bundle bundle);
    }

    public static CapabilityApi getApi(Drone drone2) {
        return (CapabilityApi) getApi(drone2, capabilityApiCache, apiBuilder);
    }

    private CapabilityApi(Drone drone2) {
        this.drone = drone2;
    }

    public void checkFeatureSupport(final String str, final FeatureSupportListener featureSupportListener) {
        if (!TextUtils.isEmpty(str) && featureSupportListener != null) {
            if (!this.drone.isConnected()) {
                this.drone.post(new Runnable() {
                    public void run() {
                        featureSupportListener.onFeatureSupportResult(str, -1, (Bundle) null);
                    }
                });
                return;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1514241229:
                    if (str.equals(FeatureIds.IMU_CALIBRATION)) {
                        c = 0;
                        break;
                    }
                    break;
                case 445623148:
                    if (str.equals(FeatureIds.KILL_SWITCH)) {
                        c = 1;
                        break;
                    }
                    break;
                case 960109428:
                    if (str.equals(FeatureIds.COMPASS_CALIBRATION)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1572072423:
                    if (str.equals(FeatureIds.SOLO_VIDEO_STREAMING)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.drone.post(new Runnable() {
                        public void run() {
                            featureSupportListener.onFeatureSupportResult(str, 0, (Bundle) null);
                        }
                    });
                    return;
                case 1:
                case 2:
                    break;
                case 3:
                    if (Build.VERSION.SDK_INT < 18) {
                        this.drone.post(new Runnable() {
                            public void run() {
                                featureSupportListener.onFeatureSupportResult(str, 1, (Bundle) null);
                            }
                        });
                        return;
                    }
                    break;
                default:
                    this.drone.post(new Runnable() {
                        public void run() {
                            featureSupportListener.onFeatureSupportResult(str, 1, (Bundle) null);
                        }
                    });
                    return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(CapabilityActions.EXTRA_FEATURE_ID, str);
            this.drone.performAsyncActionOnDroneThread(new Action(CapabilityActions.ACTION_CHECK_FEATURE_SUPPORT, bundle), new AbstractCommandListener() {
                public void onSuccess() {
                    featureSupportListener.onFeatureSupportResult(str, 0, (Bundle) null);
                }

                public void onError(int i) {
                    featureSupportListener.onFeatureSupportResult(str, 1, (Bundle) null);
                }

                public void onTimeout() {
                    featureSupportListener.onFeatureSupportResult(str, 1, (Bundle) null);
                }
            });
        }
    }

    public static final class FeatureIds {
        public static final String COMPASS_CALIBRATION = "feature_compass_calibration";
        public static final String IMU_CALIBRATION = "feature_imu_calibration";
        public static final String KILL_SWITCH = "feature_kill_switch";
        public static final String SOLO_VIDEO_STREAMING = "feature_solo_video_streaming";

        private FeatureIds() {
        }
    }
}
