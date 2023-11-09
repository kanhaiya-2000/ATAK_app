package org.droidplanner.services.android.impl.core.model;

import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public interface AutopilotWarningParser {
    String getDefaultWarning();

    String parseWarning(MavLinkDrone mavLinkDrone, String str);
}
