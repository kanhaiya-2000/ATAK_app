package com.o3dr.android.client.apis;

import android.os.Bundle;
import com.o3dr.android.client.Drone;
import com.o3dr.android.client.apis.Api;
import com.o3dr.android.client.interfaces.DroneListener;
import com.o3dr.services.android.lib.drone.action.GimbalActions;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.drone.attribute.AttributeEventExtra;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.property.Type;
import com.o3dr.services.android.lib.model.SimpleCommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class GimbalApi extends Api implements DroneListener {
    private static final Api.Builder<GimbalApi> apiBuilder = new Api.Builder<GimbalApi>() {
        public GimbalApi build(Drone drone) {
            return new GimbalApi(drone);
        }
    };
    private static final ConcurrentHashMap<Drone, GimbalApi> gimbalApiCache = new ConcurrentHashMap<>();
    private final Drone drone;
    private final ConcurrentLinkedQueue<GimbalOrientationListener> gimbalListeners;
    private final GimbalOrientation gimbalOrientation;

    public interface GimbalOrientationListener {
        void onGimbalOrientationCommandError(int i);

        void onGimbalOrientationUpdate(GimbalOrientation gimbalOrientation);
    }

    public void onDroneServiceInterrupted(String str) {
    }

    public static GimbalApi getApi(Drone drone2) {
        return (GimbalApi) getApi(drone2, gimbalApiCache, apiBuilder);
    }

    public static class GimbalOrientation {
        /* access modifiers changed from: private */
        public float pitch;
        /* access modifiers changed from: private */
        public float roll;
        /* access modifiers changed from: private */
        public float yaw;

        public float getPitch() {
            return this.pitch;
        }

        public float getRoll() {
            return this.roll;
        }

        public float getYaw() {
            return this.yaw;
        }

        /* access modifiers changed from: private */
        public void updateOrientation(float f, float f2, float f3) {
            this.pitch = f;
            this.roll = f2;
            this.yaw = f3;
        }

        private GimbalOrientation() {
        }

        private GimbalOrientation(GimbalOrientation gimbalOrientation) {
            this.pitch = gimbalOrientation.pitch;
            this.roll = gimbalOrientation.roll;
            this.yaw = gimbalOrientation.yaw;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GimbalOrientation)) {
                return false;
            }
            GimbalOrientation gimbalOrientation = (GimbalOrientation) obj;
            if (Float.compare(gimbalOrientation.pitch, this.pitch) == 0 && Float.compare(gimbalOrientation.roll, this.roll) == 0 && Float.compare(gimbalOrientation.yaw, this.yaw) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            float f = this.pitch;
            int i = 0;
            int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.roll;
            int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.yaw;
            if (f3 != 0.0f) {
                i = Float.floatToIntBits(f3);
            }
            return floatToIntBits2 + i;
        }

        public String toString() {
            return "GimbalOrientation{pitch=" + this.pitch + ", roll=" + this.roll + ", yaw=" + this.yaw + '}';
        }
    }

    private GimbalApi(Drone drone2) {
        this.gimbalListeners = new ConcurrentLinkedQueue<>();
        this.gimbalOrientation = new GimbalOrientation();
        this.drone = drone2;
        drone2.registerDroneListener(this);
    }

    public GimbalOrientation getGimbalOrientation() {
        return new GimbalOrientation(this.gimbalOrientation);
    }

    public void startGimbalControl(final GimbalOrientationListener gimbalOrientationListener) {
        Objects.requireNonNull(gimbalOrientationListener, "Listener can't be null.");
        if (((Type) this.drone.getAttribute(AttributeType.TYPE)).getDroneType() != 2) {
            this.drone.post(new Runnable() {
                public void run() {
                    gimbalOrientationListener.onGimbalOrientationCommandError(3);
                }
            });
            return;
        }
        this.gimbalListeners.add(gimbalOrientationListener);
        configureGimbalMountMode(gimbalOrientationListener);
    }

    private void configureGimbalMountMode(final GimbalOrientationListener gimbalOrientationListener) {
        Bundle bundle = new Bundle(1);
        bundle.putInt(GimbalActions.GIMBAL_MOUNT_MODE, 2);
        this.drone.performAsyncActionOnDroneThread(new Action(GimbalActions.ACTION_SET_GIMBAL_MOUNT_MODE, bundle), new SimpleCommandListener() {
            public void onTimeout() {
                gimbalOrientationListener.onGimbalOrientationCommandError(4);
            }

            public void onError(int i) {
                gimbalOrientationListener.onGimbalOrientationCommandError(i);
            }
        });
    }

    public void stopGimbalControl(final GimbalOrientationListener gimbalOrientationListener) {
        Objects.requireNonNull(gimbalOrientationListener, "Listener can't be null.");
        if (!this.gimbalListeners.contains(gimbalOrientationListener)) {
            this.drone.post(new Runnable() {
                public void run() {
                    gimbalOrientationListener.onGimbalOrientationCommandError(2);
                }
            });
            return;
        }
        this.gimbalListeners.remove(gimbalOrientationListener);
        Bundle bundle = new Bundle(1);
        bundle.putInt(GimbalActions.GIMBAL_MOUNT_MODE, 3);
        this.drone.performAsyncActionOnDroneThread(new Action(GimbalActions.ACTION_SET_GIMBAL_MOUNT_MODE, bundle), new SimpleCommandListener() {
            public void onTimeout() {
                gimbalOrientationListener.onGimbalOrientationCommandError(4);
            }

            public void onError(int i) {
                gimbalOrientationListener.onGimbalOrientationCommandError(i);
            }
        });
    }

    public void updateGimbalOrientation(GimbalOrientation gimbalOrientation2, GimbalOrientationListener gimbalOrientationListener) {
        updateGimbalOrientation(gimbalOrientation2.pitch, gimbalOrientation2.roll, gimbalOrientation2.yaw, gimbalOrientationListener);
    }

    public void updateGimbalOrientation(float f, float f2, float f3, final GimbalOrientationListener gimbalOrientationListener) {
        Objects.requireNonNull(gimbalOrientationListener, "Listener must be non-null.");
        if (!this.gimbalListeners.contains(gimbalOrientationListener)) {
            this.drone.post(new Runnable() {
                public void run() {
                    gimbalOrientationListener.onGimbalOrientationCommandError(2);
                }
            });
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putFloat(GimbalActions.GIMBAL_PITCH, f);
        bundle.putFloat(GimbalActions.GIMBAL_ROLL, f2);
        bundle.putFloat(GimbalActions.GIMBAL_YAW, f3);
        this.drone.performAsyncActionOnDroneThread(new Action(GimbalActions.ACTION_SET_GIMBAL_ORIENTATION, bundle), new SimpleCommandListener() {
            public void onTimeout() {
                gimbalOrientationListener.onGimbalOrientationCommandError(4);
            }

            public void onError(int i) {
                gimbalOrientationListener.onGimbalOrientationCommandError(i);
            }
        });
    }

    private void notifyGimbalOrientationUpdated(GimbalOrientation gimbalOrientation2) {
        if (!this.gimbalListeners.isEmpty()) {
            Iterator<GimbalOrientationListener> it = this.gimbalListeners.iterator();
            while (it.hasNext()) {
                it.next().onGimbalOrientationUpdate(gimbalOrientation2);
            }
        }
    }

    public void onDroneEvent(String str, Bundle bundle) {
        str.hashCode();
        if (str.equals(AttributeEvent.GIMBAL_ORIENTATION_UPDATED)) {
            this.gimbalOrientation.updateOrientation(bundle.getFloat(AttributeEventExtra.EXTRA_GIMBAL_ORIENTATION_PITCH), bundle.getFloat(AttributeEventExtra.EXTRA_GIMBAL_ORIENTATION_ROLL), bundle.getFloat(AttributeEventExtra.EXTRA_GIMBAL_ORIENTATION_YAW));
            notifyGimbalOrientationUpdated(this.gimbalOrientation);
        }
    }
}
