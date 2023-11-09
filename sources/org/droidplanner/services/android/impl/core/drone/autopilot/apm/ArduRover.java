package org.droidplanner.services.android.impl.core.drone.autopilot.apm;

import android.content.Context;
import android.os.Handler;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.LogMessageListener;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;

public class ArduRover extends ArduPilot {
    public int getType() {
        return 10;
    }

    public void setType(int i) {
    }

    public ArduRover(String str, Context context, DataLink.DataLinkProvider<MAVLinkMessage> dataLinkProvider, Handler handler, AutopilotWarningParser autopilotWarningParser, LogMessageListener logMessageListener) {
        super(str, context, dataLinkProvider, handler, autopilotWarningParser, logMessageListener);
    }

    public FirmwareType getFirmwareType() {
        return FirmwareType.ARDU_ROVER;
    }
}
