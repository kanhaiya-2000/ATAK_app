package org.droidplanner.services.android.impl.core.drone.autopilot.px4;

import android.content.Context;
import android.os.Handler;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.LogMessageListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;

public class Px4Native extends GenericMavLinkDrone {
    public Px4Native(String str, Context context, Handler handler, DataLink.DataLinkProvider<MAVLinkMessage> dataLinkProvider, AutopilotWarningParser autopilotWarningParser, LogMessageListener logMessageListener) {
        super(str, context, handler, dataLinkProvider, autopilotWarningParser, logMessageListener);
    }

    public FirmwareType getFirmwareType() {
        return FirmwareType.PX4_NATIVE;
    }
}
