package com.bbn.ccast.mavlink;

import com.atakmap.android.uastool.MAVLink.common.msg_global_position_int;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import com.atakmap.coremap.log.Log;
import com.bbn.ccast.mavlink.MavLinkDialectInterface;
import com.bbn.ccast.mavlink.MavLinkThread;
import com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle;
import com.bbn.vehicleinterface.types.ResultCallback;
import java.io.IOException;

public class ArduPlaneDialect extends ArduPilotDialect {
    private static final String TAG = "ArduPlaneDialect";

    public ArduPlaneDialect(MavLinkThread mavLinkThread) {
        super(mavLinkThread);
    }

    public void startTakeoffProcess(Double d, MavLinkThread.TakeoffCallback takeoffCallback) {
        if (!this.isInTakeoffProcess.getAndSet(true)) {
            if (this.mavlinkThread.getCurrentMode() != ((long) MavLinkDialectInterface.CustomRoverMode.GUIDED.getValue())) {
                Log.d(TAG, "MVT. Changing to Guided");
                changetoGuided(MavLinkDialectInterface.CustomRoverMode.GUIDED);
            }
            if (this.mavlinkThread.isArmed()) {
                if (this.mavlinkThread.getCurrentMode() != ((long) MavLinkDialectInterface.CustomRoverMode.GUIDED.getValue())) {
                    Log.d(TAG, "MVT. Changing mode to then takeoff");
                    sendArmAndTakeoffHelper(false, d, takeoffCallback);
                    changetoGuided(MavLinkDialectInterface.CustomRoverMode.GUIDED);
                    sendArmAndTakeoffHelper(true, d, takeoffCallback);
                }
                Log.d(TAG, "MVT. Attempting doTakeoff");
                doTakeoff(d, takeoffCallback);
                return;
            }
            Log.d(TAG, "MVT. Arming first");
            sendArmAndTakeoffHelper(true, d, takeoffCallback);
        }
    }

    public boolean inAir() {
        msg_global_position_int msg_global_position_int = (msg_global_position_int) this.mavlinkThread.getLatestMessage(msg_global_position_int.class);
        if (msg_global_position_int == null || ((double) msg_global_position_int.relative_alt) / 1000.0d <= 2.0d) {
            return false;
        }
        return true;
    }

    public void enterMissionMode(ResultCallback resultCallback) {
        try {
            this.mavlinkThread.sendChangeCustomMode(MavLinkDialectInterface.CustomRoverMode.AUTO.getValue());
        } catch (IOException e) {
            MavlinkVehicle.handleExceptionCallback(e, resultCallback);
        }
    }

    public void enterReturnToHomeMode(ResultCallback<Void> resultCallback) {
        try {
            this.mavlinkThread.sendChangeCustomMode(MavLinkDialectInterface.CustomRoverMode.RTL.getValue());
        } catch (IOException e) {
            MavlinkVehicle.handleExceptionCallback(e, resultCallback);
        }
    }

    public void enterPositionHoldMode() {
        this.mavlinkThread.sendChangeCustomMode(MavLinkDialectInterface.CustomRoverMode.GUIDED.getValue());
    }

    public boolean inPositionHoldMode() {
        msg_heartbeat msg_heartbeat = (msg_heartbeat) this.mavlinkThread.getLatestMessage(msg_heartbeat.class);
        if (msg_heartbeat != null && msg_heartbeat.custom_mode == ((long) MavLinkDialectInterface.CustomRoverMode.GUIDED.getValue())) {
            return true;
        }
        return false;
    }
}
