package org.droidplanner.services.android.impl.core.drone.variables;

import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class Type extends DroneVariable<MavLinkDrone> implements DroneInterfaces.OnDroneListener<MavLinkDrone> {
    private static final int DEFAULT_TYPE = 0;
    private String firmwareVersion = null;
    private int type = 0;

    public static boolean isCopter(int i) {
        if (i == 2 || i == 4) {
            return true;
        }
        switch (i) {
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    public static boolean isPlane(int i) {
        return i == 1;
    }

    public static boolean isRover(int i) {
        return i == 10;
    }

    public Type(MavLinkDrone mavLinkDrone) {
        super(mavLinkDrone);
        mavLinkDrone.addDroneListener(this);
    }

    public void setType(int i) {
        if (this.type != i) {
            this.type = i;
            this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.TYPE);
        }
    }

    public int getType() {
        return this.type;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public void setFirmwareVersion(String str) {
        String str2 = this.firmwareVersion;
        if (str2 == null || !str2.equals(str)) {
            this.firmwareVersion = str;
            this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.FIRMWARE);
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.variables.Type$1 */
    /* synthetic */ class C59901 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8637x7e1461ff;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f8637x7e1461ff = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        if (C59901.f8637x7e1461ff[droneEventsType.ordinal()] == 1) {
            setType(0);
        }
    }
}
