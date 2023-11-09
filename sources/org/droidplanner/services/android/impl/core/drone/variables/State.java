package org.droidplanner.services.android.impl.core.drone.variables;

import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ekf_status_report;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkCommands;
import org.droidplanner.services.android.impl.core.MAVLink.WaypointManager;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;

public class State extends DroneVariable<GenericMavLinkDrone> {
    private static final long ERROR_TIMEOUT = 5000;
    private static final Action requestHomeUpdateAction = new Action(MavLinkDrone.ACTION_REQUEST_HOME_UPDATE);
    private boolean armed = false;
    private msg_ekf_status_report ekfStatus;
    private String errorId;
    private final Handler handler;
    private boolean isEkfPositionOk;
    private boolean isFlying = false;
    private ApmModes mode = ApmModes.UNKNOWN;
    private long startTime = 0;
    private final AutopilotWarningParser warningParser;
    private final Runnable watchdogCallback = new Runnable() {
        public void run() {
            State.this.resetWarning();
        }
    };

    public State(GenericMavLinkDrone genericMavLinkDrone, Handler handler2, AutopilotWarningParser autopilotWarningParser) {
        super(genericMavLinkDrone);
        this.handler = handler2;
        this.warningParser = autopilotWarningParser;
        this.errorId = autopilotWarningParser.getDefaultWarning();
        resetFlightStartTime();
    }

    public boolean isArmed() {
        return this.armed;
    }

    public boolean isFlying() {
        return this.isFlying;
    }

    public ApmModes getMode() {
        return this.mode;
    }

    public String getErrorId() {
        return this.errorId;
    }

    public void setIsFlying(boolean z) {
        if (z != this.isFlying) {
            this.isFlying = z;
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.STATE);
            if (this.isFlying) {
                resetFlightStartTime();
            }
        }
    }

    public boolean parseAutopilotError(String str) {
        String parseWarning = this.warningParser.parseWarning(this.myDrone, str);
        if (parseWarning == null || parseWarning.trim().isEmpty()) {
            return false;
        }
        if (!parseWarning.equals(this.errorId)) {
            this.errorId = parseWarning;
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING);
        }
        this.handler.removeCallbacks(this.watchdogCallback);
        this.handler.postDelayed(this.watchdogCallback, 5000);
        return true;
    }

    public void repeatWarning() {
        String str = this.errorId;
        if (str != null && str.length() != 0 && !this.errorId.equals(this.warningParser.getDefaultWarning())) {
            this.handler.removeCallbacks(this.watchdogCallback);
            this.handler.postDelayed(this.watchdogCallback, 5000);
        }
    }

    public void setArmed(boolean z) {
        WaypointManager waypointManager;
        if (this.armed != z) {
            this.armed = z;
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.ARMING);
            if (z && (waypointManager = ((GenericMavLinkDrone) this.myDrone).getWaypointManager()) != null) {
                waypointManager.getWaypoints();
            }
        }
        checkEkfPositionState(this.ekfStatus);
    }

    public void setMode(ApmModes apmModes) {
        if (this.mode != apmModes) {
            this.mode = apmModes;
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.MODE);
        }
    }

    public void changeFlightMode(ApmModes apmModes, final ICommandListener iCommandListener) {
        if (this.mode == apmModes) {
            if (iCommandListener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        try {
                            iCommandListener.onSuccess();
                        } catch (RemoteException e) {
                            cqb.m12015e(e, e.getMessage(), new Object[0]);
                        }
                    }
                });
            }
        } else if (ApmModes.isValid(apmModes)) {
            MavLinkCommands.changeFlightMode(this.myDrone, apmModes, iCommandListener);
        } else if (iCommandListener != null) {
            this.handler.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onError(4);
                    } catch (RemoteException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void resetWarning() {
        String defaultWarning = this.warningParser.getDefaultWarning();
        if (defaultWarning == null) {
            defaultWarning = "";
        }
        if (!defaultWarning.equals(this.errorId)) {
            this.errorId = defaultWarning;
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING);
        }
    }

    private void resetFlightStartTime() {
        this.startTime = SystemClock.elapsedRealtime();
    }

    public long getFlightStartTime() {
        return this.startTime;
    }

    public msg_ekf_status_report getEkfStatus() {
        return this.ekfStatus;
    }

    public void setEkfStatus(msg_ekf_status_report msg_ekf_status_report) {
        msg_ekf_status_report msg_ekf_status_report2 = this.ekfStatus;
        if (msg_ekf_status_report2 == null || !areEkfStatusEquals(msg_ekf_status_report2, msg_ekf_status_report)) {
            this.ekfStatus = msg_ekf_status_report;
            ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.EKF_STATUS_UPDATE);
        }
    }

    private void checkEkfPositionState(msg_ekf_status_report msg_ekf_status_report) {
        if (msg_ekf_status_report != null) {
            int i = msg_ekf_status_report.flags;
            boolean z = false;
            if (!this.armed ? !((i & 16) == 0 && (i & 512) == 0) : (i & 16) != 0 && (i & 128) == 0) {
                z = true;
            }
            if (this.isEkfPositionOk != z) {
                this.isEkfPositionOk = z;
                ((GenericMavLinkDrone) this.myDrone).notifyDroneEvent(DroneInterfaces.DroneEventsType.EKF_POSITION_STATE_UPDATE);
                if (this.isEkfPositionOk) {
                    ((GenericMavLinkDrone) this.myDrone).executeAsyncAction(requestHomeUpdateAction, (ICommandListener) null);
                }
            }
        }
    }

    private static boolean areEkfStatusEquals(msg_ekf_status_report msg_ekf_status_report, msg_ekf_status_report msg_ekf_status_report2) {
        return msg_ekf_status_report == msg_ekf_status_report2 || !(msg_ekf_status_report == null || msg_ekf_status_report2 == null || !msg_ekf_status_report.toString().equals(msg_ekf_status_report2.toString()));
    }

    public boolean isEkfPositionOk() {
        return this.isEkfPositionOk;
    }
}
