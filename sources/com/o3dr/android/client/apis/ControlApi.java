package com.o3dr.android.client.apis;

import android.os.Bundle;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.action.ControlActions;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.ConcurrentHashMap;

public class ControlApi extends Api {
    private static final Api.Builder<ControlApi> apiBuilder = new Api.Builder<ControlApi>() {
        public ControlApi build(Drone drone) {
            return new ControlApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, ControlApi> apiCache = new ConcurrentHashMap<>();
    private final Drone drone;

    public interface ManualControlStateListener {
        void onManualControlToggled(boolean z);
    }

    private static boolean isWithinBounds(float f, float f2, float f3) {
        return f <= f3 && f >= f2;
    }

    public static ControlApi getApi(Drone drone2) {
        return (ControlApi) getApi(drone2, apiCache, apiBuilder);
    }

    private ControlApi(Drone drone2) {
        this.drone = drone2;
    }

    public void takeoff(double d, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putDouble(ControlActions.EXTRA_ALTITUDE, d);
        this.drone.performAsyncActionOnDroneThread(new Action(ControlActions.ACTION_DO_GUIDED_TAKEOFF, bundle), abstractCommandListener);
    }

    public void pauseAtCurrentLocation(AbstractCommandListener abstractCommandListener) {
        this.drone.performAsyncActionOnDroneThread(new Action(ControlActions.ACTION_SEND_BRAKE_VEHICLE, new Bundle()), abstractCommandListener);
    }

    public void goTo(LatLong latLong, boolean z, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ControlActions.EXTRA_FORCE_GUIDED_POINT, z);
        bundle.putParcelable(ControlActions.EXTRA_GUIDED_POINT, latLong);
        this.drone.performAsyncActionOnDroneThread(new Action(ControlActions.ACTION_SEND_GUIDED_POINT, bundle), abstractCommandListener);
    }

    public void lookAt(LatLongAlt latLongAlt, boolean z, AbstractCommandListener abstractCommandListener) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ControlActions.EXTRA_FORCE_GUIDED_POINT, z);
        bundle.putParcelable(ControlActions.EXTRA_LOOK_AT_TARGET, latLongAlt);
        this.drone.performAsyncActionOnDroneThread(new Action(ControlActions.ACTION_LOOK_AT_TARGET, bundle), abstractCommandListener);
    }

    public void climbTo(double d) {
        Bundle bundle = new Bundle();
        bundle.putDouble(ControlActions.EXTRA_ALTITUDE, d);
        this.drone.performAsyncAction(new Action(ControlActions.ACTION_SET_GUIDED_ALTITUDE, bundle));
    }

    public void turnTo(float f, float f2, boolean z, AbstractCommandListener abstractCommandListener) {
        if (!isWithinBounds(f, 0.0f, 360.0f) || !isWithinBounds(f2, -1.0f, 1.0f)) {
            postErrorEvent(4, abstractCommandListener);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putFloat(ControlActions.EXTRA_YAW_TARGET_ANGLE, f);
        bundle.putFloat(ControlActions.EXTRA_YAW_CHANGE_RATE, f2);
        bundle.putBoolean(ControlActions.EXTRA_YAW_IS_RELATIVE, z);
        this.drone.performAsyncActionOnDroneThread(new Action(ControlActions.ACTION_SET_CONDITION_YAW, bundle), abstractCommandListener);
    }

    public void manualControl(float f, float f2, float f3, AbstractCommandListener abstractCommandListener) {
        if (!isWithinBounds(f, -1.0f, 1.0f) || !isWithinBounds(f2, -1.0f, 1.0f) || !isWithinBounds(f3, -1.0f, 1.0f)) {
            postErrorEvent(4, abstractCommandListener);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putFloat(ControlActions.EXTRA_VELOCITY_X, f);
        bundle.putFloat(ControlActions.EXTRA_VELOCITY_Y, f2);
        bundle.putFloat(ControlActions.EXTRA_VELOCITY_Z, f3);
        this.drone.performAsyncActionOnDroneThread(new Action(ControlActions.ACTION_SET_VELOCITY, bundle), abstractCommandListener);
    }

    public void enableManualControl(final boolean z, final ManualControlStateListener manualControlStateListener) {
        C57402 r5;
        if (manualControlStateListener == null) {
            r5 = null;
        } else {
            r5 = new AbstractCommandListener() {
                public void onSuccess() {
                    if (z) {
                        manualControlStateListener.onManualControlToggled(true);
                    } else {
                        manualControlStateListener.onManualControlToggled(false);
                    }
                }

                public void onError(int i) {
                    if (z) {
                        manualControlStateListener.onManualControlToggled(false);
                    }
                }

                public void onTimeout() {
                    if (z) {
                        manualControlStateListener.onManualControlToggled(false);
                    }
                }
            };
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(ControlActions.EXTRA_DO_ENABLE, z);
        this.drone.performAsyncActionOnDroneThread(new Action(ControlActions.ACTION_ENABLE_MANUAL_CONTROL, bundle), r5);
    }
}
