package org.droidplanner.services.android.impl.core.drone.autopilot.apm;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import atakplugin.UASTool.C0964vm;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.o3dr.android.client.apis.CapabilityApi;
import com.o3dr.services.android.lib.drone.action.ControlActions;
import com.o3dr.services.android.lib.drone.property.Parameter;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.concurrent.ConcurrentHashMap;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkCommands;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneManager;
import org.droidplanner.services.android.impl.core.drone.LogMessageListener;
import org.droidplanner.services.android.impl.core.drone.profiles.ParameterManager;
import org.droidplanner.services.android.impl.core.drone.variables.ApmModes;
import org.droidplanner.services.android.impl.core.drone.variables.State;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;
import org.droidplanner.services.android.impl.utils.CommonApiUtils;

public class ArduCopter extends ArduPilot {
    private static final C0964vm ARDU_COPTER_V3_3;
    private static final C0964vm ARDU_COPTER_V3_4;
    private static final C0964vm BRAKE_FEATURE_FIRMWARE_VERSION;
    private static final C0964vm COMPASS_CALIBRATION_MIN_VERSION;
    private final ConcurrentHashMap<String, ICommandListener> manualControlStateListeners = new ConcurrentHashMap<>();

    static {
        C0964vm a = C0964vm.m14246a(3, 3, 0);
        ARDU_COPTER_V3_3 = a;
        C0964vm a2 = C0964vm.m14246a(3, 4, 0);
        ARDU_COPTER_V3_4 = a2;
        BRAKE_FEATURE_FIRMWARE_VERSION = a;
        COMPASS_CALIBRATION_MIN_VERSION = a2;
    }

    public ArduCopter(String str, Context context, DataLink.DataLinkProvider<MAVLinkMessage> dataLinkProvider, Handler handler, AutopilotWarningParser autopilotWarningParser, LogMessageListener logMessageListener) {
        super(str, context, dataLinkProvider, handler, autopilotWarningParser, logMessageListener);
    }

    public FirmwareType getFirmwareType() {
        return FirmwareType.ARDU_COPTER;
    }

    /* access modifiers changed from: protected */
    public boolean setVelocity(Bundle bundle, ICommandListener iCommandListener) {
        double d;
        double d2;
        float f = bundle.getFloat(ControlActions.EXTRA_VELOCITY_X);
        float f2 = bundle.getFloat(ControlActions.EXTRA_VELOCITY_Y);
        float f3 = bundle.getFloat(ControlActions.EXTRA_VELOCITY_Z);
        double radians = Math.toRadians(this.attitude.getYaw());
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d3 = (double) f;
        double d4 = (double) f2;
        float f4 = ((float) (d3 * cos)) - ((float) (d4 * sin));
        float f5 = ((float) (d3 * sin)) + ((float) (d4 * cos));
        ParameterManager parameterManager = getParameterManager();
        Parameter parameter = parameterManager.getParameter("WPNAV_SPEED");
        if (parameter == null) {
            d = (double) 5.0f;
        } else {
            d = parameter.getValue() / 100.0d;
        }
        Parameter parameter2 = parameterManager.getParameter(f3 >= 0.0f ? "WPNAV_SPEED_UP" : "WPNAV_SPEED_DN");
        if (parameter2 == null) {
            d2 = (double) 5.0f;
        } else {
            d2 = parameter2.getValue() / 100.0d;
        }
        MavLinkCommands.setVelocityInLocalFrame(this, (float) (((double) f4) * d), (float) (((double) f5) * d), (float) (((double) f3) * d2), iCommandListener);
        return true;
    }

    public void destroy() {
        super.destroy();
        this.manualControlStateListeners.clear();
    }

    /* access modifiers changed from: protected */
    public boolean enableManualControl(Bundle bundle, ICommandListener iCommandListener) {
        boolean z = bundle.getBoolean(ControlActions.EXTRA_DO_ENABLE);
        String string = bundle.getString(DroneManager.EXTRA_CLIENT_APP_ID);
        State state = getState();
        ApmModes mode = state.getMode();
        if (z) {
            if (mode == ApmModes.ROTOR_GUIDED) {
                CommonApiUtils.postSuccessEvent(iCommandListener);
            } else {
                state.changeFlightMode(ApmModes.ROTOR_GUIDED, iCommandListener);
            }
            if (iCommandListener == null) {
                return true;
            }
            this.manualControlStateListeners.put(string, iCommandListener);
            return true;
        }
        this.manualControlStateListeners.remove(string);
        if (mode != ApmModes.ROTOR_GUIDED) {
            CommonApiUtils.postSuccessEvent(iCommandListener);
            return true;
        }
        state.changeFlightMode(ApmModes.ROTOR_LOITER, iCommandListener);
        return true;
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.autopilot.apm.ArduCopter$1 */
    /* synthetic */ class C59351 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8621x7e1461ff;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f8621x7e1461ff = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void notifyDroneEvent(DroneInterfaces.DroneEventsType droneEventsType) {
        if (C59351.f8621x7e1461ff[droneEventsType.ordinal()] == 1) {
            ApmModes mode = getState().getMode();
            for (ICommandListener next : this.manualControlStateListeners.values()) {
                if (mode == ApmModes.ROTOR_GUIDED) {
                    CommonApiUtils.postSuccessEvent(next);
                } else {
                    CommonApiUtils.postErrorEvent(4, next);
                }
            }
        }
        super.notifyDroneEvent(droneEventsType);
    }

    /* access modifiers changed from: protected */
    public boolean isFeatureSupported(String str) {
        str.hashCode();
        if (str.equals(CapabilityApi.FeatureIds.KILL_SWITCH)) {
            return CommonApiUtils.isKillSwitchSupported(this);
        }
        if (!str.equals(CapabilityApi.FeatureIds.COMPASS_CALIBRATION)) {
            return super.isFeatureSupported(str);
        }
        return getFirmwareVersionNumber().mo6049b(COMPASS_CALIBRATION_MIN_VERSION);
    }

    /* access modifiers changed from: protected */
    public boolean brakeVehicle(ICommandListener iCommandListener) {
        if (getFirmwareVersionNumber().mo6049b(BRAKE_FEATURE_FIRMWARE_VERSION)) {
            getState().changeFlightMode(ApmModes.ROTOR_BRAKE, iCommandListener);
            return true;
        }
        super.brakeVehicle(iCommandListener);
        return true;
    }
}
