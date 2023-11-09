package org.droidplanner.services.android.impl.core.drone.autopilot.apm.variables;

import android.os.Handler;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.ArduPilot;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class APMHeartBeat extends HeartBeat {
    private static final long HEARTBEAT_IMU_CALIBRATION_TIMEOUT = 35000;
    protected static final int IMU_CALIBRATION = 3;

    public APMHeartBeat(ArduPilot arduPilot, Handler handler) {
        super(arduPilot, handler);
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.autopilot.apm.variables.APMHeartBeat$1 */
    /* synthetic */ class C59681 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8624x7e1461ff;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f8624x7e1461ff = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.CALIBRATION_IMU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        if (C59681.f8624x7e1461ff[droneEventsType.ordinal()] != 1) {
            super.onDroneEvent(droneEventsType, mavLinkDrone);
            return;
        }
        this.heartbeatState = 3;
        restartWatchdog(HEARTBEAT_IMU_CALIBRATION_TIMEOUT);
    }

    /* access modifiers changed from: protected */
    public void onHeartbeatTimeout() {
        if (this.heartbeatState != 3) {
            super.onHeartbeatTimeout();
            return;
        }
        restartWatchdog(HEARTBEAT_IMU_CALIBRATION_TIMEOUT);
        this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.CALIBRATION_TIMEOUT);
    }
}
