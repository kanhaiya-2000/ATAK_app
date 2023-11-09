package org.droidplanner.services.android.impl.core.drone.variables;

import org.droidplanner.services.android.impl.core.MAVLink.MavLinkStreamRates;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class StreamRates extends DroneVariable<MavLinkDrone> implements DroneInterfaces.OnDroneListener<MavLinkDrone> {
    private Rates rates;

    public StreamRates(MavLinkDrone mavLinkDrone) {
        super(mavLinkDrone);
        mavLinkDrone.addDroneListener(this);
    }

    public void setRates(Rates rates2) {
        Rates rates3 = this.rates;
        if (rates3 == null || !rates3.equals(rates2)) {
            this.rates = rates2;
            if (this.myDrone.isConnected() && this.myDrone.isConnectionAlive()) {
                setupStreamRatesFromPref();
            }
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.variables.StreamRates$1 */
    /* synthetic */ class C59891 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8636x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r0 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8636x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8636x7e1461ff     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8636x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.variables.StreamRates.C59891.<clinit>():void");
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        int i = C59891.f8636x7e1461ff[droneEventsType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setupStreamRatesFromPref();
        }
    }

    private void setupStreamRatesFromPref() {
        if (this.rates != null) {
            MavLinkStreamRates.setupStreamRates(this.myDrone.getMavClient(), this.myDrone.getSysid(), this.myDrone.getCompid(), this.rates.extendedStatus, this.rates.extra1, this.rates.extra2, this.rates.extra3, this.rates.position, this.rates.rcChannels, this.rates.rawSensors, this.rates.rawController);
        }
    }

    public static class Rates {
        public int extendedStatus;
        public int extra1;
        public int extra2;
        public int extra3;
        public int position;
        public int rawController;
        public int rawSensors;
        public int rcChannels;

        public Rates(int i) {
            this.extendedStatus = i;
            this.extra1 = i;
            this.extra2 = i;
            this.extra3 = i;
            this.position = i;
            this.rcChannels = i;
            this.rawSensors = i;
            this.rawController = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Rates)) {
                return false;
            }
            Rates rates = (Rates) obj;
            if (this.extendedStatus == rates.extendedStatus && this.extra1 == rates.extra1 && this.extra2 == rates.extra2 && this.extra3 == rates.extra3 && this.position == rates.position && this.rcChannels == rates.rcChannels && this.rawSensors == rates.rawSensors && this.rawController == rates.rawController) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((this.extendedStatus * 31) + this.extra1) * 31) + this.extra2) * 31) + this.extra3) * 31) + this.position) * 31) + this.rcChannels) * 31) + this.rawSensors) * 31) + this.rawController;
        }
    }
}
