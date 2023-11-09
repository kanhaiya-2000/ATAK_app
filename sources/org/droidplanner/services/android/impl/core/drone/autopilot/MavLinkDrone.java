package org.droidplanner.services.android.impl.core.drone.autopilot;

import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.MAVLink.WaypointManager;
import org.droidplanner.services.android.impl.core.drone.profiles.ParameterManager;
import org.droidplanner.services.android.impl.core.drone.variables.Camera;
import org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint;
import org.droidplanner.services.android.impl.core.drone.variables.MissionStats;
import org.droidplanner.services.android.impl.core.drone.variables.State;
import org.droidplanner.services.android.impl.core.drone.variables.StreamRates;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.AccelCalibration;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.MagnetometerCalibrationImpl;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;

public interface MavLinkDrone extends Drone {
    public static final String ACTION_REQUEST_HOME_UPDATE = "org.droidplanner.services.android.core.drone.autopilot.action.REQUEST_HOME_UPDATE";
    public static final String PACKAGE_NAME = "org.droidplanner.services.android.core.drone.autopilot";

    AccelCalibration getCalibrationSetup();

    Camera getCamera();

    short getCompid();

    FirmwareType getFirmwareType();

    String getFirmwareVersion();

    GuidedPoint getGuidedPoint();

    MagnetometerCalibrationImpl getMagnetometerCalibration();

    DataLink.DataLinkProvider<MAVLinkMessage> getMavClient();

    int getMavlinkVersion();

    MissionImpl getMission();

    MissionStats getMissionStats();

    ParameterManager getParameterManager();

    State getState();

    StreamRates getStreamRates();

    short getSysid();

    int getType();

    WaypointManager getWaypointManager();

    boolean isConnectionAlive();

    void onMavLinkMessageReceived(MAVLinkMessage mAVLinkMessage);
}
