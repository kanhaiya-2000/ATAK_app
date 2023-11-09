package org.droidplanner.services.android.impl.core.drone.autopilot;

import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;

public interface Drone {
    void addDroneListener(DroneInterfaces.OnDroneListener onDroneListener);

    void destroy();

    boolean executeAsyncAction(Action action, ICommandListener iCommandListener);

    DroneAttribute getAttribute(String str);

    String getId();

    boolean isConnected();

    void notifyDroneEvent(DroneInterfaces.DroneEventsType droneEventsType);

    void removeDroneListener(DroneInterfaces.OnDroneListener onDroneListener);

    void setAttributeListener(DroneInterfaces.AttributeEventListener attributeEventListener);
}
