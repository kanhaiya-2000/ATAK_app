package org.droidplanner.services.android.impl.core.drone;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class DroneEvents extends DroneVariable<MavLinkDrone> {
    private final ConcurrentLinkedQueue<DroneInterfaces.OnDroneListener> droneListeners = new ConcurrentLinkedQueue<>();

    public DroneEvents(MavLinkDrone mavLinkDrone) {
        super(mavLinkDrone);
    }

    public void addDroneListener(DroneInterfaces.OnDroneListener onDroneListener) {
        if ((true ^ this.droneListeners.contains(onDroneListener)) && (onDroneListener != null)) {
            this.droneListeners.add(onDroneListener);
        }
    }

    public void removeDroneListener(DroneInterfaces.OnDroneListener onDroneListener) {
        if (onDroneListener != null && this.droneListeners.contains(onDroneListener)) {
            this.droneListeners.remove(onDroneListener);
        }
    }

    public void removeAllDroneListeners() {
        this.droneListeners.clear();
    }

    public void notifyDroneEvent(DroneInterfaces.DroneEventsType droneEventsType) {
        if (droneEventsType != null && !this.droneListeners.isEmpty()) {
            Iterator<DroneInterfaces.OnDroneListener> it = this.droneListeners.iterator();
            while (it.hasNext()) {
                it.next().onDroneEvent(droneEventsType, this.myDrone);
            }
        }
    }
}
