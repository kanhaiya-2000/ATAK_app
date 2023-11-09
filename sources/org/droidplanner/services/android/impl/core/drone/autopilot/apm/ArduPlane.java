package org.droidplanner.services.android.impl.core.drone.autopilot.apm;

import android.content.Context;
import android.os.Handler;
import atakplugin.UASTool.C0964vm;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_global_position_int;
import com.atakmap.android.uastool.MAVLink.common.msg_vfr_hud;
import com.o3dr.android.client.apis.CapabilityApi;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.LogMessageListener;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;

public class ArduPlane extends ArduPilot {
    private static final C0964vm ARDU_PLANE_V3_3 = C0964vm.m14246a(3, 3, 0);
    private static final C0964vm ARDU_PLANE_V3_4;
    private static final C0964vm COMPASS_CALIBRATION_MIN_VERSION;

    public int getType() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void processVfrHud(msg_vfr_hud msg_vfr_hud) {
    }

    /* access modifiers changed from: protected */
    public void setType(int i) {
    }

    static {
        C0964vm a = C0964vm.m14246a(3, 4, 0);
        ARDU_PLANE_V3_4 = a;
        COMPASS_CALIBRATION_MIN_VERSION = a;
    }

    public ArduPlane(String str, Context context, DataLink.DataLinkProvider<MAVLinkMessage> dataLinkProvider, Handler handler, AutopilotWarningParser autopilotWarningParser, LogMessageListener logMessageListener) {
        super(str, context, dataLinkProvider, handler, autopilotWarningParser, logMessageListener);
    }

    public FirmwareType getFirmwareType() {
        return FirmwareType.ARDU_PLANE;
    }

    /* access modifiers changed from: protected */
    public void processGlobalPositionInt(msg_global_position_int msg_global_position_int) {
        if (msg_global_position_int != null) {
            super.processGlobalPositionInt(msg_global_position_int);
            double d = ((double) msg_global_position_int.relative_alt) / 1000.0d;
            double sqrt = Math.sqrt(Math.pow(((double) msg_global_position_int.f8267vx) / 100.0d, 2.0d) + Math.pow(((double) msg_global_position_int.f8268vy) / 100.0d, 2.0d));
            setAltitudeGroundAndAirSpeeds(d, sqrt, sqrt, ((double) msg_global_position_int.f8269vz) / 100.0d);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFeatureSupported(String str) {
        str.hashCode();
        if (!str.equals(CapabilityApi.FeatureIds.COMPASS_CALIBRATION)) {
            return super.isFeatureSupported(str);
        }
        return getFirmwareVersionNumber().mo6049b(COMPASS_CALIBRATION_MIN_VERSION);
    }
}
