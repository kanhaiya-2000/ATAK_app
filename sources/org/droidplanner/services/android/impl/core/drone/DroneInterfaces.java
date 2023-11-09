package org.droidplanner.services.android.impl.core.drone;

import android.os.Bundle;
import com.o3dr.services.android.lib.drone.property.Parameter;
import org.droidplanner.services.android.impl.core.MAVLink.WaypointManager;
import org.droidplanner.services.android.impl.core.drone.autopilot.Drone;

public class DroneInterfaces {

    public interface AttributeEventListener {
        void onAttributeEvent(String str, Bundle bundle);
    }

    public enum DroneEventsType {
        ALTITUDE,
        ORIENTATION,
        SPEED,
        BATTERY,
        GUIDEDPOINT,
        ATTITUDE,
        RADIO,
        RC_IN,
        RC_OUT,
        ARMING,
        AUTOPILOT_WARNING,
        MODE,
        STATE,
        MISSION_UPDATE,
        MISSION_RECEIVED,
        TYPE,
        HOME,
        CALIBRATION_IMU,
        CALIBRATION_TIMEOUT,
        HEARTBEAT_TIMEOUT,
        HEARTBEAT_FIRST,
        HEARTBEAT_RESTORED,
        DISCONNECTED,
        CONNECTED,
        CONNECTING,
        MISSION_SENT,
        ARMING_STARTED,
        INVALID_POLYGON,
        MISSION_WP_UPDATE,
        WARNING_SIGNAL_WEAK,
        FIRMWARE,
        WARNING_NO_GPS,
        MAGNETOMETER,
        FOOTPRINT,
        EKF_STATUS_UPDATE,
        EKF_POSITION_STATE_UPDATE,
        MISSION_WP_REACHED
    }

    public interface OnDroneListener<T extends Drone> {
        void onDroneEvent(DroneEventsType droneEventsType, T t);
    }

    public interface OnParameterManagerListener {
        void onBeginReceivingParameters();

        void onEndReceivingParameters();

        void onParameterReceived(Parameter parameter, int i, int i2);
    }

    public interface OnWaypointManagerListener {
        void onBeginWaypointEvent(WaypointManager.WaypointEvent_Type waypointEvent_Type);

        void onEndWaypointEvent(WaypointManager.WaypointEvent_Type waypointEvent_Type);

        void onWaypointEvent(WaypointManager.WaypointEvent_Type waypointEvent_Type, int i, int i2);
    }
}
