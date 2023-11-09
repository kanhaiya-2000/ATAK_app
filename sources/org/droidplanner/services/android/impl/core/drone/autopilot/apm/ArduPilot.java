package org.droidplanner.services.android.impl.core.drone.autopilot.apm;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import atakplugin.UASTool.C0964vm;
import atakplugin.UASTool.bxn;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_camera_feedback;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_configure;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_status;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_radio;
import com.atakmap.android.uastool.MAVLink.common.msg_named_value_int;
import com.atakmap.android.uastool.MAVLink.common.msg_raw_imu;
import com.atakmap.android.uastool.MAVLink.common.msg_rc_channels_raw;
import com.atakmap.android.uastool.MAVLink.common.msg_servo_output_raw;
import com.atakmap.android.uastool.MAVLink.common.msg_statustext;
import com.atakmap.android.uastool.MAVLink.common.msg_sys_status;
import com.atakmap.android.uastool.MAVLink.common.msg_vfr_hud;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.action.ControlActions;
import com.o3dr.services.android.lib.drone.action.ExperimentalActions;
import com.o3dr.services.android.lib.drone.action.GimbalActions;
import com.o3dr.services.android.lib.drone.action.ParameterActions;
import com.o3dr.services.android.lib.drone.action.StateActions;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.drone.attribute.AttributeEventExtra;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.mission.Mission;
import com.o3dr.services.android.lib.drone.mission.action.MissionActions;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import com.o3dr.services.android.lib.drone.property.Parameter;
import com.o3dr.services.android.lib.drone.property.Parameters;
import com.o3dr.services.android.lib.drone.property.VehicleMode;
import com.o3dr.services.android.lib.gcs.action.CalibrationActions;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkParameters;
import org.droidplanner.services.android.impl.core.MAVLink.WaypointManager;
import org.droidplanner.services.android.impl.core.MAVLink.command.doCmd.MavLinkDoCmds;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.LogMessageListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.variables.APMHeartBeat;
import org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.variables.ApmModes;
import org.droidplanner.services.android.impl.core.drone.variables.C5985RC;
import org.droidplanner.services.android.impl.core.drone.variables.Camera;
import org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;
import org.droidplanner.services.android.impl.core.drone.variables.Magnetometer;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.AccelCalibration;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.MagnetometerCalibrationImpl;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;
import org.droidplanner.services.android.impl.utils.CommonApiUtils;

public abstract class ArduPilot extends GenericMavLinkDrone {
    public static final int ARTOO_COMPONENT_ID = 0;
    public static final int AUTOPILOT_COMPONENT_ID = 1;
    public static final String FIRMWARE_VERSION_NUMBER_REGEX = "\\d+(\\.\\d{1,2})?";
    private final AccelCalibration accelCalibrationSetup;
    protected C0964vm firmwareVersionNumber = C0964vm.m14246a(0, 0, 0);
    private final Camera footprints;
    private final GuidedPoint guidedPoint;
    private final Magnetometer mag;
    private final MagnetometerCalibrationImpl magCalibration;
    private final MissionImpl missionImpl;

    /* renamed from: rc */
    private final C5985RC f8622rc;
    private final WaypointManager waypointManager;

    public ArduPilot(String str, Context context, DataLink.DataLinkProvider<MAVLinkMessage> dataLinkProvider, Handler handler, AutopilotWarningParser autopilotWarningParser, LogMessageListener logMessageListener) {
        super(str, context, handler, dataLinkProvider, autopilotWarningParser, logMessageListener);
        this.waypointManager = new WaypointManager(this, handler);
        this.f8622rc = new C5985RC(this);
        this.missionImpl = new MissionImpl(this);
        this.guidedPoint = new GuidedPoint(this, handler);
        this.accelCalibrationSetup = new AccelCalibration(this, handler);
        this.magCalibration = new MagnetometerCalibrationImpl(this);
        this.mag = new Magnetometer(this);
        this.footprints = new Camera(this);
    }

    /* access modifiers changed from: protected */
    public HeartBeat initHeartBeat(Handler handler) {
        return new APMHeartBeat(this, handler);
    }

    /* access modifiers changed from: protected */
    public void setAltitudeGroundAndAirSpeeds(double d, double d2, double d3, double d4) {
        if (this.altitude.getAltitude() != d) {
            this.altitude.setAltitude(d);
            notifyDroneEvent(DroneInterfaces.DroneEventsType.ALTITUDE);
        }
        if (this.speed.getGroundSpeed() != d2 || this.speed.getAirSpeed() != d3 || this.speed.getVerticalSpeed() != d4) {
            this.speed.setGroundSpeed(d2);
            this.speed.setAirSpeed(d3);
            this.speed.setVerticalSpeed(d4);
            notifyDroneEvent(DroneInterfaces.DroneEventsType.SPEED);
        }
    }

    public WaypointManager getWaypointManager() {
        return this.waypointManager;
    }

    public MissionImpl getMission() {
        return this.missionImpl;
    }

    public GuidedPoint getGuidedPoint() {
        return this.guidedPoint;
    }

    public AccelCalibration getCalibrationSetup() {
        return this.accelCalibrationSetup;
    }

    public MagnetometerCalibrationImpl getMagnetometerCalibration() {
        return this.magCalibration;
    }

    public Camera getCamera() {
        return this.footprints;
    }

    public DroneAttribute getAttribute(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -987487119:
                    if (str.equals(AttributeType.MISSION)) {
                        c = 0;
                        break;
                    }
                    break;
                case -835416121:
                    if (str.equals(AttributeType.MAGNETOMETER_CALIBRATION_STATUS)) {
                        c = 1;
                        break;
                    }
                    break;
                case -828014987:
                    if (str.equals(AttributeType.GUIDED_STATE)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return CommonApiUtils.getMission(this);
                case 1:
                    return CommonApiUtils.getMagnetometerCalibrationStatus(this);
                case 2:
                    return CommonApiUtils.getGuidedState(this);
            }
        }
        return super.getAttribute(str);
    }

    public boolean executeAsyncAction(Action action, final ICommandListener iCommandListener) {
        String type = action.getType();
        Bundle data = action.getData();
        if (data == null) {
            data = new Bundle();
        }
        type.hashCode();
        char c = 65535;
        switch (type.hashCode()) {
            case -2063748772:
                if (type.equals(CalibrationActions.ACTION_CANCEL_MAGNETOMETER_CALIBRATION)) {
                    c = 0;
                    break;
                }
                break;
            case -2043532828:
                if (type.equals(ExperimentalActions.ACTION_TRIGGER_CAMERA)) {
                    c = 1;
                    break;
                }
                break;
            case -1908732552:
                if (type.equals(ControlActions.ACTION_SEND_GUIDED_POINT)) {
                    c = 2;
                    break;
                }
                break;
            case -1890326490:
                if (type.equals(ParameterActions.ACTION_REFRESH_PARAMETERS)) {
                    c = 3;
                    break;
                }
                break;
            case -1678595273:
                if (type.equals(MissionActions.ACTION_SET_MISSION)) {
                    c = 4;
                    break;
                }
                break;
            case -1185294780:
                if (type.equals(GimbalActions.ACTION_SET_GIMBAL_ORIENTATION)) {
                    c = 5;
                    break;
                }
                break;
            case -977675449:
                if (type.equals(StateActions.ACTION_SET_VEHICLE_HOME)) {
                    c = 6;
                    break;
                }
                break;
            case -962617604:
                if (type.equals(ExperimentalActions.ACTION_SET_RELAY)) {
                    c = 7;
                    break;
                }
                break;
            case -961687676:
                if (type.equals(ExperimentalActions.ACTION_SET_SERVO)) {
                    c = 8;
                    break;
                }
                break;
            case -747781369:
                if (type.equals(CalibrationActions.ACTION_START_IMU_CALIBRATION)) {
                    c = 9;
                    break;
                }
                break;
            case -671611573:
                if (type.equals(ControlActions.ACTION_LOOK_AT_TARGET)) {
                    c = 10;
                    break;
                }
                break;
            case -509536842:
                if (type.equals(ExperimentalActions.ACTION_EPM_COMMAND)) {
                    c = 11;
                    break;
                }
                break;
            case -154457455:
                if (type.equals(MissionActions.ACTION_LOAD_WAYPOINTS)) {
                    c = 12;
                    break;
                }
                break;
            case -50395506:
                if (type.equals(CalibrationActions.ACTION_ACCEPT_MAGNETOMETER_CALIBRATION)) {
                    c = 13;
                    break;
                }
                break;
            case 282984679:
                if (type.equals(CalibrationActions.ACTION_SEND_IMU_CALIBRATION_ACK)) {
                    c = 14;
                    break;
                }
                break;
            case 368780599:
                if (type.equals(MissionActions.ACTION_START_MISSION)) {
                    c = 15;
                    break;
                }
                break;
            case 500960021:
                if (type.equals(GimbalActions.ACTION_SET_GIMBAL_MOUNT_MODE)) {
                    c = 16;
                    break;
                }
                break;
            case 1578735108:
                if (type.equals(CalibrationActions.ACTION_START_MAGNETOMETER_CALIBRATION)) {
                    c = 17;
                    break;
                }
                break;
            case 1629342370:
                if (type.equals(ParameterActions.ACTION_WRITE_PARAMETERS)) {
                    c = 18;
                    break;
                }
                break;
            case 1683912951:
                if (type.equals(ExperimentalActions.ACTION_SET_ROI)) {
                    c = 19;
                    break;
                }
                break;
            case 1900229570:
                if (type.equals(GimbalActions.ACTION_RESET_GIMBAL_MOUNT_MODE)) {
                    c = 20;
                    break;
                }
                break;
            case 2136963812:
                if (type.equals(ControlActions.ACTION_SET_GUIDED_ALTITUDE)) {
                    c = 21;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                CommonApiUtils.cancelMagnetometerCalibration(this);
                return true;
            case 1:
                CommonApiUtils.triggerCamera(this);
                return true;
            case 2:
                data.setClassLoader(LatLong.class.getClassLoader());
                CommonApiUtils.sendGuidedPoint(this, (LatLong) data.getParcelable(ControlActions.EXTRA_GUIDED_POINT), data.getBoolean(ControlActions.EXTRA_FORCE_GUIDED_POINT), iCommandListener);
                return true;
            case 3:
                CommonApiUtils.refreshParameters(this);
                return true;
            case 4:
                data.setClassLoader(Mission.class.getClassLoader());
                CommonApiUtils.setMission(this, (Mission) data.getParcelable(MissionActions.EXTRA_MISSION), data.getBoolean(MissionActions.EXTRA_PUSH_TO_DRONE));
                return true;
            case 5:
                MavLinkDoCmds.setGimbalOrientation(this, data.getFloat(GimbalActions.GIMBAL_PITCH), data.getFloat(GimbalActions.GIMBAL_ROLL), data.getFloat(GimbalActions.GIMBAL_YAW), iCommandListener);
                return true;
            case 6:
                LatLongAlt latLongAlt = (LatLongAlt) data.getParcelable(StateActions.EXTRA_VEHICLE_HOME_LOCATION);
                if (latLongAlt != null) {
                    MavLinkDoCmds.setVehicleHome(this, latLongAlt, new AbstractCommandListener() {
                        public void onSuccess() {
                            CommonApiUtils.postSuccessEvent(iCommandListener);
                            ArduPilot.this.requestHomeUpdate();
                        }

                        public void onError(int i) {
                            CommonApiUtils.postErrorEvent(i, iCommandListener);
                            ArduPilot.this.requestHomeUpdate();
                        }

                        public void onTimeout() {
                            CommonApiUtils.postTimeoutEvent(iCommandListener);
                            ArduPilot.this.requestHomeUpdate();
                        }
                    });
                } else {
                    CommonApiUtils.postErrorEvent(4, iCommandListener);
                }
                return true;
            case 7:
                MavLinkDoCmds.setRelay(this, data.getInt(ExperimentalActions.EXTRA_RELAY_NUMBER), data.getBoolean(ExperimentalActions.EXTRA_IS_RELAY_ON), iCommandListener);
                return true;
            case 8:
                MavLinkDoCmds.setServo(this, data.getInt(ExperimentalActions.EXTRA_SERVO_CHANNEL), data.getInt(ExperimentalActions.EXTRA_SERVO_PWM), iCommandListener);
                return true;
            case 9:
                CommonApiUtils.startIMUCalibration(this, iCommandListener);
                return true;
            case 10:
                CommonApiUtils.sendLookAtTarget(this, (LatLongAlt) data.getParcelable(ControlActions.EXTRA_LOOK_AT_TARGET), data.getBoolean(ControlActions.EXTRA_FORCE_GUIDED_POINT), iCommandListener);
                return true;
            case 11:
                CommonApiUtils.epmCommand(this, data.getBoolean(ExperimentalActions.EXTRA_EPM_RELEASE), iCommandListener);
                return true;
            case 12:
                CommonApiUtils.loadWaypoints(this);
                return true;
            case 13:
                CommonApiUtils.acceptMagnetometerCalibration(this);
                return true;
            case 14:
                CommonApiUtils.sendIMUCalibrationAck(this, data.getInt(CalibrationActions.EXTRA_IMU_STEP));
                return true;
            case 15:
                CommonApiUtils.startMission(this, data.getBoolean(MissionActions.EXTRA_FORCE_MODE_CHANGE), data.getBoolean(MissionActions.EXTRA_FORCE_ARM), iCommandListener);
                return true;
            case 16:
            case 20:
                int i = data.getInt(GimbalActions.GIMBAL_MOUNT_MODE, 3);
                cqb.m12010c("Setting gimbal mount mode: %d", Integer.valueOf(i));
                if (getParameterManager().getParameter("MNT_MODE") == null) {
                    msg_mount_configure msg_mount_configure = new msg_mount_configure();
                    msg_mount_configure.target_system = getSysid();
                    msg_mount_configure.target_component = getCompid();
                    msg_mount_configure.mount_mode = (short) ((byte) i);
                    msg_mount_configure.stab_pitch = 0;
                    msg_mount_configure.stab_roll = 0;
                    msg_mount_configure.stab_yaw = 0;
                    getMavClient().sendMessage(msg_mount_configure, iCommandListener);
                } else {
                    MavLinkParameters.sendParameter(this, "MNT_MODE", 1, (float) i);
                }
                return true;
            case 17:
                CommonApiUtils.startMagnetometerCalibration(this, data.getBoolean(CalibrationActions.EXTRA_RETRY_ON_FAILURE, false), data.getBoolean(CalibrationActions.EXTRA_SAVE_AUTOMATICALLY, true), data.getInt(CalibrationActions.EXTRA_START_DELAY, 0));
                return true;
            case 18:
                data.setClassLoader(Parameters.class.getClassLoader());
                CommonApiUtils.writeParameters(this, (Parameters) data.getParcelable(ParameterActions.EXTRA_PARAMETERS));
                return true;
            case 19:
                LatLongAlt latLongAlt2 = (LatLongAlt) data.getParcelable(ExperimentalActions.EXTRA_SET_ROI_LAT_LONG_ALT);
                if (latLongAlt2 != null) {
                    MavLinkDoCmds.setROI(this, latLongAlt2, iCommandListener);
                }
                return true;
            case 21:
                CommonApiUtils.setGuidedAltitude(this, data.getDouble(ControlActions.EXTRA_ALTITUDE));
                return true;
            default:
                return super.executeAsyncAction(action, iCommandListener);
        }
    }

    /* access modifiers changed from: protected */
    public boolean enableManualControl(Bundle bundle, ICommandListener iCommandListener) {
        CommonApiUtils.postErrorEvent(3, iCommandListener);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean performArming(Bundle bundle, ICommandListener iCommandListener) {
        CommonApiUtils.arm(this, bundle.getBoolean(StateActions.EXTRA_ARM), bundle.getBoolean(StateActions.EXTRA_EMERGENCY_DISARM), iCommandListener);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setVehicleMode(Bundle bundle, ICommandListener iCommandListener) {
        bundle.setClassLoader(VehicleMode.class.getClassLoader());
        CommonApiUtils.changeVehicleMode(this, (VehicleMode) bundle.getParcelable(StateActions.EXTRA_VEHICLE_MODE), iCommandListener);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setVelocity(Bundle bundle, ICommandListener iCommandListener) {
        CommonApiUtils.postErrorEvent(3, iCommandListener);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean performTakeoff(Bundle bundle, ICommandListener iCommandListener) {
        CommonApiUtils.doGuidedTakeoff(this, bundle.getDouble(ControlActions.EXTRA_ALTITUDE), iCommandListener);
        return true;
    }

    public void onMavLinkMessageReceived(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.sysid == getSysid() || isMavLinkMessageException(mAVLinkMessage)) {
            int i = mAVLinkMessage.compid;
            if (i == 1 || i == 0 || i == 68) {
                if (!getParameterManager().processMessage(mAVLinkMessage)) {
                    getWaypointManager().processMessage(mAVLinkMessage);
                    getCalibrationSetup().processMessage(mAVLinkMessage);
                    int i2 = mAVLinkMessage.msgid;
                    if (i2 == 27) {
                        this.mag.newData((msg_raw_imu) mAVLinkMessage);
                    } else if (i2 == 74) {
                        processVfrHud((msg_vfr_hud) mAVLinkMessage);
                    } else if (i2 == 158) {
                        processMountStatus((msg_mount_status) mAVLinkMessage);
                    } else if (i2 == 166) {
                        msg_radio msg_radio = (msg_radio) mAVLinkMessage;
                        processSignalUpdate(msg_radio.rxerrors, msg_radio.fixed, msg_radio.rssi, msg_radio.remrssi, msg_radio.txbuf, msg_radio.noise, msg_radio.remnoise);
                    } else if (i2 == 180) {
                        getCamera().newImageLocation((msg_camera_feedback) mAVLinkMessage);
                    } else if (i2 == 35) {
                        this.f8622rc.setRcInputValues((msg_rc_channels_raw) mAVLinkMessage);
                    } else if (i2 == 36) {
                        this.f8622rc.setRcOutputValues((msg_servo_output_raw) mAVLinkMessage);
                    } else if (i2 == 191 || i2 == 192) {
                        getMagnetometerCalibration().processCalibrationMessage(mAVLinkMessage);
                    } else if (i2 == 252) {
                        processNamedValueInt((msg_named_value_int) mAVLinkMessage);
                    } else if (i2 == 253) {
                        processStatusText((msg_statustext) mAVLinkMessage);
                    }
                }
                super.onMavLinkMessageReceived(mAVLinkMessage);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processSysStatus(msg_sys_status msg_sys_status) {
        super.processSysStatus(msg_sys_status);
        checkControlSensorsHealth(msg_sys_status);
    }

    /* access modifiers changed from: protected */
    public final void setFirmwareVersion(String str) {
        super.setFirmwareVersion(str);
        setFirmwareVersionNumber(str);
    }

    /* access modifiers changed from: protected */
    public C0964vm getFirmwareVersionNumber() {
        return this.firmwareVersionNumber;
    }

    private void setFirmwareVersionNumber(String str) {
        this.firmwareVersionNumber = extractVersionNumber(str);
    }

    protected static C0964vm extractVersionNumber(String str) {
        C0964vm a = C0964vm.m14246a(0, 0, 0);
        Matcher matcher = Pattern.compile(FIRMWARE_VERSION_NUMBER_REGEX).matcher(str);
        if (!matcher.find()) {
            return a;
        }
        try {
            return C0964vm.m14247a(matcher.group(0) + ".0");
        } catch (Exception e) {
            cqb.m12015e(e, "Firmware version invalid", new Object[0]);
            return a;
        }
    }

    private void checkControlSensorsHealth(msg_sys_status msg_sys_status) {
        if ((msg_sys_status.onboard_control_sensors_health & bxn.f4206a) == 0) {
            getState().parseAutopilotError("RC FAILSAFE");
        }
    }

    /* access modifiers changed from: protected */
    public void processVfrHud(msg_vfr_hud msg_vfr_hud) {
        if (msg_vfr_hud != null) {
            setAltitudeGroundAndAirSpeeds((double) msg_vfr_hud.alt, (double) msg_vfr_hud.groundspeed, (double) msg_vfr_hud.airspeed, (double) msg_vfr_hud.climb);
        }
    }

    /* access modifiers changed from: protected */
    public void processMountStatus(msg_mount_status msg_mount_status) {
        this.footprints.updateMountOrientation(msg_mount_status);
        Bundle bundle = new Bundle(3);
        bundle.putFloat(AttributeEventExtra.EXTRA_GIMBAL_ORIENTATION_PITCH, ((float) msg_mount_status.pointing_a) / 100.0f);
        bundle.putFloat(AttributeEventExtra.EXTRA_GIMBAL_ORIENTATION_ROLL, ((float) msg_mount_status.pointing_b) / 100.0f);
        bundle.putFloat(AttributeEventExtra.EXTRA_GIMBAL_ORIENTATION_YAW, ((float) msg_mount_status.pointing_c) / 100.0f);
        notifyAttributeListener(AttributeEvent.GIMBAL_ORIENTATION_UPDATED, bundle);
    }

    private void processNamedValueInt(msg_named_value_int msg_named_value_int) {
        if (msg_named_value_int != null) {
            String name = msg_named_value_int.getName();
            name.hashCode();
            if (name.equals("ARMMASK")) {
                ApmModes mode = getState().getMode();
                if (ApmModes.isCopter(mode.getType())) {
                    int i = msg_named_value_int.value;
                    int number = (int) mode.getNumber();
                    boolean z = true;
                    if ((i & (1 << number)) == 0) {
                        z = false;
                    }
                    logMessage(4, z ? "READY TO ARM" : "UNREADY FOR ARMING");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processStatusText(msg_statustext msg_statustext) {
        String text = msg_statustext.getText();
        if (!TextUtils.isEmpty(text)) {
            if (text.startsWith("ArduCopter") || text.startsWith("ArduPlane") || text.startsWith("ArduRover") || text.startsWith("Solo") || text.startsWith("APM:Copter") || text.startsWith("APM:Plane") || text.startsWith("APM:Rover")) {
                setFirmwareVersion(text);
            } else if (!getState().parseAutopilotError(text)) {
                short s = msg_statustext.severity;
                int i = 5;
                if (s == 2) {
                    i = 4;
                } else if (s != 3) {
                    i = s != 4 ? s != 5 ? 2 : 3 : 6;
                }
                logMessage(i, text);
            }
        }
    }

    public Double getBattDischarge(double d) {
        Parameter parameter = getParameterManager().getParameter("BATT_CAPACITY");
        if (parameter == null || d == -1.0d) {
            return null;
        }
        return Double.valueOf((1.0d - (d / 100.0d)) * parameter.getValue());
    }

    /* access modifiers changed from: protected */
    public void processBatteryUpdate(double d, double d2, double d3) {
        if (this.battery.getBatteryRemain() != d2) {
            this.battery.setBatteryDischarge(getBattDischarge(d2));
        }
        super.processBatteryUpdate(d, d2, d3);
    }
}
