package org.droidplanner.services.android.impl.core.drone.variables;

import com.atakmap.android.uastool.MAVLink.common.msg_raw_imu;
import com.o3dr.services.android.lib.drone.property.Parameter;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class Magnetometer extends DroneVariable {

    /* renamed from: x */
    private int f8632x;

    /* renamed from: y */
    private int f8633y;

    /* renamed from: z */
    private int f8634z;

    public Magnetometer(MavLinkDrone mavLinkDrone) {
        super(mavLinkDrone);
    }

    public void newData(msg_raw_imu msg_raw_imu) {
        this.f8632x = msg_raw_imu.xmag;
        this.f8633y = msg_raw_imu.ymag;
        this.f8634z = msg_raw_imu.zmag;
        this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.MAGNETOMETER);
    }

    public int[] getVector() {
        return new int[]{this.f8632x, this.f8633y, this.f8634z};
    }

    public int getX() {
        return this.f8632x;
    }

    public int getY() {
        return this.f8633y;
    }

    public int getZ() {
        return this.f8634z;
    }

    public int[] getOffsets() {
        Parameter parameter = this.myDrone.getParameterManager().getParameter("COMPASS_OFS_X");
        Parameter parameter2 = this.myDrone.getParameterManager().getParameter("COMPASS_OFS_Y");
        Parameter parameter3 = this.myDrone.getParameterManager().getParameter("COMPASS_OFS_Z");
        if (parameter == null || parameter2 == null || parameter3 == null) {
            return null;
        }
        return new int[]{(int) parameter.getValue(), (int) parameter2.getValue(), (int) parameter3.getValue()};
    }
}
