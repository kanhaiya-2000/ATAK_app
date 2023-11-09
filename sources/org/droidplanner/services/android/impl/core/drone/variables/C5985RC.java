package org.droidplanner.services.android.impl.core.drone.variables;

import com.atakmap.android.uastool.MAVLink.common.msg_rc_channels_raw;
import com.atakmap.android.uastool.MAVLink.common.msg_servo_output_raw;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

/* renamed from: org.droidplanner.services.android.impl.core.drone.variables.RC */
public class C5985RC extends DroneVariable {

    /* renamed from: in */
    public int[] f8635in = new int[8];
    public int[] out = new int[8];

    public C5985RC(MavLinkDrone mavLinkDrone) {
        super(mavLinkDrone);
    }

    public void setRcInputValues(msg_rc_channels_raw msg_rc_channels_raw) {
        this.f8635in[0] = msg_rc_channels_raw.chan1_raw;
        this.f8635in[1] = msg_rc_channels_raw.chan2_raw;
        this.f8635in[2] = msg_rc_channels_raw.chan3_raw;
        this.f8635in[3] = msg_rc_channels_raw.chan4_raw;
        this.f8635in[4] = msg_rc_channels_raw.chan5_raw;
        this.f8635in[5] = msg_rc_channels_raw.chan6_raw;
        this.f8635in[6] = msg_rc_channels_raw.chan7_raw;
        this.f8635in[7] = msg_rc_channels_raw.chan8_raw;
        this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.RC_IN);
    }

    public void setRcOutputValues(msg_servo_output_raw msg_servo_output_raw) {
        this.out[0] = msg_servo_output_raw.servo1_raw;
        this.out[1] = msg_servo_output_raw.servo2_raw;
        this.out[2] = msg_servo_output_raw.servo3_raw;
        this.out[3] = msg_servo_output_raw.servo4_raw;
        this.out[4] = msg_servo_output_raw.servo5_raw;
        this.out[5] = msg_servo_output_raw.servo6_raw;
        this.out[6] = msg_servo_output_raw.servo7_raw;
        this.out[7] = msg_servo_output_raw.servo8_raw;
        this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.RC_OUT);
    }
}
