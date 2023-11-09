package org.droidplanner.services.android.impl.core.drone.autopilot.generic;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_ekf_status_report;
import com.atakmap.android.uastool.MAVLink.common.msg_attitude;
import com.atakmap.android.uastool.MAVLink.common.msg_global_position_int;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_raw_int;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_current;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item_reached;
import com.atakmap.android.uastool.MAVLink.common.msg_mount_orientation;
import com.atakmap.android.uastool.MAVLink.common.msg_nav_controller_output;
import com.atakmap.android.uastool.MAVLink.common.msg_radio_status;
import com.atakmap.android.uastool.MAVLink.common.msg_sys_status;
import com.atakmap.android.uastool.MAVLink.common.msg_vibration;
import com.o3dr.services.android.lib.drone.action.CapabilityActions;
import com.o3dr.services.android.lib.drone.action.ControlActions;
import com.o3dr.services.android.lib.drone.action.ExperimentalActions;
import com.o3dr.services.android.lib.drone.action.StateActions;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.drone.attribute.AttributeEventExtra;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.mission.action.MissionActions;
import com.o3dr.services.android.lib.drone.property.Altitude;
import com.o3dr.services.android.lib.drone.property.Attitude;
import com.o3dr.services.android.lib.drone.property.Battery;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import com.o3dr.services.android.lib.drone.property.Gps;
import com.o3dr.services.android.lib.drone.property.Home;
import com.o3dr.services.android.lib.drone.property.Parameter;
import com.o3dr.services.android.lib.drone.property.Parameters;
import com.o3dr.services.android.lib.drone.property.Signal;
import com.o3dr.services.android.lib.drone.property.Speed;
import com.o3dr.services.android.lib.drone.property.VehicleMode;
import com.o3dr.services.android.lib.drone.property.Vibration;
import com.o3dr.services.android.lib.mavlink.MavlinkMessageWrapper;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import com.o3dr.services.android.lib.util.MathUtils;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkCommands;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkWaypoint;
import org.droidplanner.services.android.impl.core.MAVLink.WaypointManager;
import org.droidplanner.services.android.impl.core.drone.DroneEvents;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.LogMessageListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.profiles.ParameterManager;
import org.droidplanner.services.android.impl.core.drone.variables.ApmModes;
import org.droidplanner.services.android.impl.core.drone.variables.Camera;
import org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;
import org.droidplanner.services.android.impl.core.drone.variables.MissionStats;
import org.droidplanner.services.android.impl.core.drone.variables.State;
import org.droidplanner.services.android.impl.core.drone.variables.StreamRates;
import org.droidplanner.services.android.impl.core.drone.variables.Type;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.AccelCalibration;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.MagnetometerCalibrationImpl;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.model.AutopilotWarningParser;
import org.droidplanner.services.android.impl.utils.CommonApiUtils;
import org.droidplanner.services.android.impl.utils.video.VideoManager;

public class GenericMavLinkDrone implements MavLinkDrone {
    public static final int SiK_RADIO_FIXED_COMPID = 68;
    public static final int SiK_RADIO_FIXED_SYSID = 51;
    protected final Altitude altitude = new Altitude();
    protected final Attitude attitude = new Attitude();
    private DroneInterfaces.AttributeEventListener attributeListener;
    protected final Battery battery = new Battery();
    private final String droneId;
    private final DroneEvents events;
    /* access modifiers changed from: protected */
    public final Handler handler;
    private final HeartBeat heartbeat;
    private final LogMessageListener logListener;
    private final DataLink.DataLinkProvider<MAVLinkMessage> mavClient;
    private final MissionStats missionStats;
    private final ParameterManager parameterManager;
    private final Parameters parameters = new Parameters();
    protected final Signal signal = new Signal();
    protected final Speed speed = new Speed();
    private final State state;
    private final StreamRates streamRates;
    protected final Type type;
    private final Gps vehicleGps = new Gps();
    private final Home vehicleHome = new Home();
    protected final Vibration vibration = new Vibration();
    protected final VideoManager videoMgr;

    /* access modifiers changed from: protected */
    public double SikValueToDB(int i) {
        return (((double) i) / 1.9d) - 127.0d;
    }

    public AccelCalibration getCalibrationSetup() {
        return null;
    }

    public Camera getCamera() {
        return null;
    }

    public GuidedPoint getGuidedPoint() {
        return null;
    }

    public MagnetometerCalibrationImpl getMagnetometerCalibration() {
        return null;
    }

    public MissionImpl getMission() {
        return null;
    }

    public WaypointManager getWaypointManager() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isFeatureSupported(String str) {
        return false;
    }

    public GenericMavLinkDrone(String str, Context context, Handler handler2, DataLink.DataLinkProvider<MAVLinkMessage> dataLinkProvider, AutopilotWarningParser autopilotWarningParser, LogMessageListener logMessageListener) {
        this.droneId = str;
        this.handler = handler2;
        this.mavClient = dataLinkProvider;
        this.logListener = logMessageListener;
        this.events = new DroneEvents(this);
        this.heartbeat = initHeartBeat(handler2);
        this.type = new Type(this);
        this.missionStats = new MissionStats(this);
        this.streamRates = new StreamRates(this);
        this.state = new State(this, handler2, autopilotWarningParser);
        this.parameterManager = new ParameterManager(this, context, handler2);
        this.videoMgr = new VideoManager(context, handler2, dataLinkProvider);
    }

    public String getId() {
        return this.droneId;
    }

    public void setAttributeListener(DroneInterfaces.AttributeEventListener attributeEventListener) {
        this.attributeListener = attributeEventListener;
    }

    public MissionStats getMissionStats() {
        return this.missionStats;
    }

    public void destroy() {
        ParameterManager parameterManager2 = getParameterManager();
        if (parameterManager2 != null) {
            parameterManager2.setParameterListener((DroneInterfaces.OnParameterManagerListener) null);
        }
        MagnetometerCalibrationImpl magnetometerCalibration = getMagnetometerCalibration();
        if (magnetometerCalibration != null) {
            magnetometerCalibration.setListener((MagnetometerCalibrationImpl.OnMagnetometerCalibrationListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public HeartBeat initHeartBeat(Handler handler2) {
        return new HeartBeat(this, handler2);
    }

    public FirmwareType getFirmwareType() {
        return FirmwareType.GENERIC;
    }

    public String getFirmwareVersion() {
        return this.type.getFirmwareVersion();
    }

    /* access modifiers changed from: protected */
    public void setFirmwareVersion(String str) {
        this.type.setFirmwareVersion(str);
    }

    public ParameterManager getParameterManager() {
        return this.parameterManager;
    }

    /* access modifiers changed from: protected */
    public void logMessage(int i, String str) {
        LogMessageListener logMessageListener = this.logListener;
        if (logMessageListener != null) {
            logMessageListener.onMessageLogged(i, str);
        }
    }

    public State getState() {
        return this.state;
    }

    public boolean isConnected() {
        return this.mavClient.isConnected() && this.heartbeat.hasHeartbeat();
    }

    public boolean isConnectionAlive() {
        return this.heartbeat.isConnectionAlive();
    }

    public short getSysid() {
        return this.heartbeat.getSysid();
    }

    public short getCompid() {
        return this.heartbeat.getCompid();
    }

    public int getMavlinkVersion() {
        return this.heartbeat.getMavlinkVersion();
    }

    public void addDroneListener(DroneInterfaces.OnDroneListener onDroneListener) {
        this.events.addDroneListener(onDroneListener);
    }

    public StreamRates getStreamRates() {
        return this.streamRates;
    }

    public void removeDroneListener(DroneInterfaces.OnDroneListener onDroneListener) {
        this.events.removeDroneListener(onDroneListener);
    }

    public void startVideoStream(Bundle bundle, String str, String str2, Surface surface, ICommandListener iCommandListener) {
        this.videoMgr.startVideoStream(bundle, str, str2, surface, iCommandListener);
    }

    public void stopVideoStream(String str, String str2, ICommandListener iCommandListener) {
        this.videoMgr.stopVideoStream(str, str2, iCommandListener);
    }

    public void startVideoStreamForObserver(String str, String str2, ICommandListener iCommandListener) {
        this.videoMgr.startVideoStreamForObserver(str, str2, iCommandListener);
    }

    public void stopVideoStreamForObserver(String str, String str2, ICommandListener iCommandListener) {
        this.videoMgr.stopVideoStreamForObserver(str, str2, iCommandListener);
    }

    public void tryStoppingVideoStream(String str) {
        this.videoMgr.tryStoppingVideoStream(str);
    }

    /* access modifiers changed from: protected */
    public void notifyAttributeListener(String str) {
        notifyAttributeListener(str, (Bundle) null);
    }

    /* access modifiers changed from: protected */
    public void notifyAttributeListener(String str, Bundle bundle) {
        if (this.attributeListener != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(AttributeEventExtra.EXTRA_VEHICLE_ID, getId());
            this.attributeListener.onAttributeEvent(str, bundle);
        }
    }

    public void notifyDroneEvent(DroneInterfaces.DroneEventsType droneEventsType) {
        if (C59691.f8626x7e1461ff[droneEventsType.ordinal()] == 1) {
            this.signal.setValid(false);
        }
        this.events.notifyDroneEvent(droneEventsType);
    }

    public DataLink.DataLinkProvider<MAVLinkMessage> getMavClient() {
        return this.mavClient;
    }

    public boolean executeAsyncAction(Action action, ICommandListener iCommandListener) {
        Parameter parameter;
        String type2 = action.getType();
        Bundle data = action.getData();
        type2.hashCode();
        char c = 65535;
        switch (type2.hashCode()) {
            case -1691754218:
                if (type2.equals(ControlActions.ACTION_ENABLE_MANUAL_CONTROL)) {
                    c = 0;
                    break;
                }
                break;
            case -1313237467:
                if (type2.equals(MissionActions.ACTION_GOTO_WAYPOINT)) {
                    c = 1;
                    break;
                }
                break;
            case -1157849295:
                if (type2.equals(StateActions.ACTION_UPDATE_VEHICLE_DATA_STREAM_RATE)) {
                    c = 2;
                    break;
                }
                break;
            case -1109285507:
                if (type2.equals(MissionActions.ACTION_CHANGE_MISSION_SPEED)) {
                    c = 3;
                    break;
                }
                break;
            case -977526773:
                if (type2.equals(StateActions.ACTION_SET_VEHICLE_MODE)) {
                    c = 4;
                    break;
                }
                break;
            case -812873169:
                if (type2.equals(ControlActions.ACTION_SEND_BRAKE_VEHICLE)) {
                    c = 5;
                    break;
                }
                break;
            case -809011301:
                if (type2.equals(MissionActions.ACTION_GENERATE_DRONIE)) {
                    c = 6;
                    break;
                }
                break;
            case -220562419:
                if (type2.equals(ControlActions.ACTION_DO_GUIDED_TAKEOFF)) {
                    c = 7;
                    break;
                }
                break;
            case -175746076:
                if (type2.equals(ControlActions.ACTION_SET_CONDITION_YAW)) {
                    c = 8;
                    break;
                }
                break;
            case 280474807:
                if (type2.equals(CapabilityActions.ACTION_CHECK_FEATURE_SUPPORT)) {
                    c = 9;
                    break;
                }
                break;
            case 1137507978:
                if (type2.equals(MavLinkDrone.ACTION_REQUEST_HOME_UPDATE)) {
                    c = 10;
                    break;
                }
                break;
            case 1224404069:
                if (type2.equals(ExperimentalActions.ACTION_SEND_MAVLINK_MESSAGE)) {
                    c = 11;
                    break;
                }
                break;
            case 1859797604:
                if (type2.equals(ControlActions.ACTION_SET_VELOCITY)) {
                    c = 12;
                    break;
                }
                break;
            case 2103271172:
                if (type2.equals(StateActions.ACTION_ARM)) {
                    c = 13;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return enableManualControl(data, iCommandListener);
            case 1:
                CommonApiUtils.gotoWaypoint(this, data.getInt(MissionActions.EXTRA_MISSION_ITEM_INDEX), iCommandListener);
                return true;
            case 2:
                return updateVehicleDataStreamRate(data, iCommandListener);
            case 3:
                MavLinkCommands.changeMissionSpeed(this, data.getFloat(MissionActions.EXTRA_MISSION_SPEED), iCommandListener);
                return true;
            case 4:
                return setVehicleMode(data, iCommandListener);
            case 5:
                return brakeVehicle(iCommandListener);
            case 6:
                float generateDronie = CommonApiUtils.generateDronie(this);
                if (generateDronie != -1.0f) {
                    Bundle bundle = new Bundle(1);
                    bundle.putFloat(AttributeEventExtra.EXTRA_MISSION_DRONIE_BEARING, generateDronie);
                    notifyAttributeListener(AttributeEvent.MISSION_DRONIE_CREATED, bundle);
                }
                return true;
            case 7:
                return performTakeoff(data, iCommandListener);
            case 8:
                float f = 2.0f;
                ParameterManager parameterManager2 = getParameterManager();
                if (!(parameterManager2 == null || (parameter = parameterManager2.getParameter("ACRO_YAW_P")) == null)) {
                    f = (float) parameter.getValue();
                }
                float f2 = data.getFloat(ControlActions.EXTRA_YAW_TARGET_ANGLE);
                float f3 = data.getFloat(ControlActions.EXTRA_YAW_CHANGE_RATE);
                MavLinkCommands.setConditionYaw(this, f2, Math.abs(f3) * f, f3 >= 0.0f, data.getBoolean(ControlActions.EXTRA_YAW_IS_RELATIVE), iCommandListener);
                return true;
            case 9:
                return checkFeatureSupport(data, iCommandListener);
            case 10:
                requestHomeUpdate();
                return true;
            case 11:
                data.setClassLoader(MavlinkMessageWrapper.class.getClassLoader());
                CommonApiUtils.sendMavlinkMessage(this, (MavlinkMessageWrapper) data.getParcelable(ExperimentalActions.EXTRA_MAVLINK_MESSAGE));
                return true;
            case 12:
                return setVelocity(data, iCommandListener);
            case 13:
                return performArming(data, iCommandListener);
            default:
                CommonApiUtils.postErrorEvent(3, iCommandListener);
                return true;
        }
    }

    private boolean updateVehicleDataStreamRate(Bundle bundle, ICommandListener iCommandListener) {
        StreamRates streamRates2 = getStreamRates();
        if (streamRates2 != null) {
            int i = bundle.getInt(StateActions.EXTRA_VEHICLE_DATA_STREAM_RATE, -1);
            if (i != -1) {
                streamRates2.setRates(new StreamRates.Rates(i));
            }
            CommonApiUtils.postSuccessEvent(iCommandListener);
            return true;
        }
        CommonApiUtils.postErrorEvent(3, iCommandListener);
        return false;
    }

    private boolean checkFeatureSupport(Bundle bundle, ICommandListener iCommandListener) {
        String string = bundle.getString(CapabilityActions.EXTRA_FEATURE_ID);
        if (TextUtils.isEmpty(string)) {
            CommonApiUtils.postErrorEvent(4, iCommandListener);
            return true;
        } else if (isFeatureSupported(string)) {
            CommonApiUtils.postSuccessEvent(iCommandListener);
            return true;
        } else {
            CommonApiUtils.postErrorEvent(3, iCommandListener);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean enableManualControl(Bundle bundle, ICommandListener iCommandListener) {
        if (bundle.getBoolean(ControlActions.EXTRA_DO_ENABLE)) {
            CommonApiUtils.postSuccessEvent(iCommandListener);
            return true;
        }
        CommonApiUtils.postErrorEvent(3, iCommandListener);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean performArming(Bundle bundle, ICommandListener iCommandListener) {
        boolean z = bundle.getBoolean(StateActions.EXTRA_ARM);
        boolean z2 = bundle.getBoolean(StateActions.EXTRA_EMERGENCY_DISARM);
        if (z || !z2) {
            MavLinkCommands.sendArmMessage(this, z, false, iCommandListener);
            return true;
        }
        MavLinkCommands.sendFlightTermination(this, iCommandListener);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setVehicleMode(Bundle bundle, ICommandListener iCommandListener) {
        bundle.setClassLoader(VehicleMode.class.getClassLoader());
        VehicleMode vehicleMode = (VehicleMode) bundle.getParcelable(StateActions.EXTRA_VEHICLE_MODE);
        if (vehicleMode != null) {
            int i = C59691.f8625x2b93d897[vehicleMode.ordinal()];
            if (i == 1) {
                MavLinkCommands.sendNavLand(this, iCommandListener);
            } else if (i == 2) {
                MavLinkCommands.sendNavRTL(this, iCommandListener);
            } else if (i == 3) {
                MavLinkCommands.sendPause(this, iCommandListener);
            } else if (i == 4) {
                MavLinkCommands.startMission(this, iCommandListener);
            }
        }
        return true;
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone$1 */
    /* synthetic */ class C59691 {

        /* renamed from: $SwitchMap$com$o3dr$services$android$lib$drone$property$VehicleMode */
        static final /* synthetic */ int[] f8625x2b93d897;

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8626x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|(2:7|8)|9|(3:11|12|14)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|(2:7|8)|9|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.o3dr.services.android.lib.drone.property.VehicleMode[] r0 = com.o3dr.services.android.lib.drone.property.VehicleMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8625x2b93d897 = r0
                r1 = 1
                com.o3dr.services.android.lib.drone.property.VehicleMode r2 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_LAND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8625x2b93d897     // Catch:{ NoSuchFieldError -> 0x001d }
                com.o3dr.services.android.lib.drone.property.VehicleMode r2 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_RTL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r3 = 2
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8625x2b93d897     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.o3dr.services.android.lib.drone.property.VehicleMode r2 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_GUIDED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3 = 3
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8625x2b93d897     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.o3dr.services.android.lib.drone.property.VehicleMode r2 = com.o3dr.services.android.lib.drone.property.VehicleMode.COPTER_AUTO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r3 = 4
                r0[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r0 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8626x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r2 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone.C59691.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public boolean setVelocity(Bundle bundle, ICommandListener iCommandListener) {
        MavLinkCommands.sendManualControl(this, (short) ((int) (bundle.getFloat(ControlActions.EXTRA_VELOCITY_X) * 1000.0f)), (short) ((int) (bundle.getFloat(ControlActions.EXTRA_VELOCITY_Y) * 1000.0f)), (short) ((int) (bundle.getFloat(ControlActions.EXTRA_VELOCITY_Z) * 1000.0f)), 0, 0, iCommandListener);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean performTakeoff(Bundle bundle, ICommandListener iCommandListener) {
        MavLinkCommands.sendTakeoff(this, bundle.getDouble(ControlActions.EXTRA_ALTITUDE), iCommandListener);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean brakeVehicle(ICommandListener iCommandListener) {
        getGuidedPoint().pauseAtCurrentLocation(iCommandListener);
        return true;
    }

    public DroneAttribute getAttribute(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1702552468:
                if (str.equals(AttributeType.SPEED)) {
                    c = 0;
                    break;
                }
                break;
            case -1702436682:
                if (str.equals(AttributeType.STATE)) {
                    c = 1;
                    break;
                }
                break;
            case -1598946243:
                if (str.equals(AttributeType.ALTITUDE)) {
                    c = 2;
                    break;
                }
                break;
            case -1445036859:
                if (str.equals(AttributeType.PARAMETERS)) {
                    c = 3;
                    break;
                }
                break;
            case -1245915389:
                if (str.equals(AttributeType.SIGNAL)) {
                    c = 4;
                    break;
                }
                break;
            case 744584719:
                if (str.equals(AttributeType.GPS)) {
                    c = 5;
                    break;
                }
                break;
            case 1206115909:
                if (str.equals(AttributeType.ATTITUDE)) {
                    c = 6;
                    break;
                }
                break;
            case 1607318522:
                if (str.equals(AttributeType.HOME)) {
                    c = 7;
                    break;
                }
                break;
            case 1607685717:
                if (str.equals(AttributeType.TYPE)) {
                    c = 8;
                    break;
                }
                break;
            case 1906790642:
                if (str.equals(AttributeType.BATTERY)) {
                    c = 9;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.speed;
            case 1:
                return CommonApiUtils.getState(this, isConnected(), this.vibration);
            case 2:
                return this.altitude;
            case 3:
                ParameterManager parameterManager2 = getParameterManager();
                if (parameterManager2 != null) {
                    this.parameters.setParametersList(parameterManager2.getParameters().values());
                }
                return this.parameters;
            case 4:
                return this.signal;
            case 5:
                return this.vehicleGps;
            case 6:
                return this.attitude;
            case 7:
                return this.vehicleHome;
            case 8:
                return CommonApiUtils.getType(this);
            case 9:
                return this.battery;
            default:
                return null;
        }
    }

    private void onHeartbeat(MAVLinkMessage mAVLinkMessage) {
        this.heartbeat.onHeartbeat(mAVLinkMessage);
    }

    /* access modifiers changed from: protected */
    public boolean isMavLinkMessageException(MAVLinkMessage mAVLinkMessage) {
        return mAVLinkMessage.sysid == 51 && mAVLinkMessage.compid == 68;
    }

    public void onMavLinkMessageReceived(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.sysid == getSysid() || isMavLinkMessageException(mAVLinkMessage)) {
            onHeartbeat(mAVLinkMessage);
            int i = mAVLinkMessage.msgid;
            if (i == 0) {
                processHeartbeat((msg_heartbeat) mAVLinkMessage);
            } else if (i != 1) {
                switch (i) {
                    case 24:
                        processGpsState((msg_gps_raw_int) mAVLinkMessage);
                        return;
                    case 30:
                        processAttitude((msg_attitude) mAVLinkMessage);
                        return;
                    case 33:
                        processGlobalPositionInt((msg_global_position_int) mAVLinkMessage);
                        return;
                    case 39:
                        processHomeUpdate((msg_mission_item) mAVLinkMessage);
                        return;
                    case 42:
                        this.missionStats.setWpno(((msg_mission_current) mAVLinkMessage).seq);
                        return;
                    case 46:
                        this.missionStats.setLastReachedWaypointNumber(((msg_mission_item_reached) mAVLinkMessage).seq);
                        return;
                    case 62:
                        msg_nav_controller_output msg_nav_controller_output = (msg_nav_controller_output) mAVLinkMessage;
                        setDisttowpAndSpeedAltErrors((double) msg_nav_controller_output.wp_dist, (double) msg_nav_controller_output.alt_error, (double) msg_nav_controller_output.aspd_error);
                        return;
                    case 109:
                        msg_radio_status msg_radio_status = (msg_radio_status) mAVLinkMessage;
                        processSignalUpdate(msg_radio_status.rxerrors, msg_radio_status.fixed, msg_radio_status.rssi, msg_radio_status.remrssi, msg_radio_status.txbuf, msg_radio_status.noise, msg_radio_status.remnoise);
                        return;
                    case 193:
                        processEfkStatus((msg_ekf_status_report) mAVLinkMessage);
                        return;
                    case 241:
                        processVibrationMessage((msg_vibration) mAVLinkMessage);
                        return;
                    case msg_mount_orientation.MAVLINK_MSG_ID_MOUNT_ORIENTATION:
                        System.err.println(((msg_mount_orientation) mAVLinkMessage).toString());
                        return;
                    default:
                        return;
                }
            } else {
                processSysStatus((msg_sys_status) mAVLinkMessage);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processSysStatus(msg_sys_status msg_sys_status) {
        processBatteryUpdate(((double) msg_sys_status.voltage_battery) / 1000.0d, (double) msg_sys_status.battery_remaining, ((double) msg_sys_status.current_battery) / 100.0d);
    }

    private void processHeartbeat(msg_heartbeat msg_heartbeat) {
        setType(msg_heartbeat.type);
        checkIfFlying(msg_heartbeat);
        processState(msg_heartbeat);
        processVehicleMode(msg_heartbeat);
    }

    private void processVehicleMode(msg_heartbeat msg_heartbeat) {
        this.state.setMode(ApmModes.getMode(msg_heartbeat.custom_mode, getType()));
    }

    private void processState(msg_heartbeat msg_heartbeat) {
        checkArmState(msg_heartbeat);
        checkFailsafe(msg_heartbeat);
    }

    private void checkFailsafe(msg_heartbeat msg_heartbeat) {
        if (msg_heartbeat.system_status == 5 || msg_heartbeat.system_status == 6) {
            this.state.repeatWarning();
        }
    }

    private void checkArmState(msg_heartbeat msg_heartbeat) {
        this.state.setArmed((msg_heartbeat.base_mode & 128) == 128);
    }

    private void checkIfFlying(msg_heartbeat msg_heartbeat) {
        short s = msg_heartbeat.system_status;
        this.state.setIsFlying(s == 4 || (this.state.isFlying() && (s == 5 || s == 6)));
    }

    private void setDisttowpAndSpeedAltErrors(double d, double d2, double d3) {
        this.missionStats.setDistanceToWp(d);
        Altitude altitude2 = this.altitude;
        altitude2.setTargetAltitude(altitude2.getAltitude() + d2);
        notifyDroneEvent(DroneInterfaces.DroneEventsType.ORIENTATION);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processHomeUpdate(com.atakmap.android.uastool.MAVLink.common.msg_mission_item r13) {
        /*
            r12 = this;
            int r0 = r13.seq
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            float r0 = r13.f8319x
            float r1 = r13.f8320y
            float r13 = r13.f8321z
            r2 = 0
            com.o3dr.services.android.lib.drone.property.Home r3 = r12.vehicleHome
            com.o3dr.services.android.lib.coordinate.LatLongAlt r3 = r3.getCoordinate()
            r4 = 1
            if (r3 != 0) goto L_0x0025
            com.o3dr.services.android.lib.drone.property.Home r2 = r12.vehicleHome
            com.o3dr.services.android.lib.coordinate.LatLongAlt r3 = new com.o3dr.services.android.lib.coordinate.LatLongAlt
            double r6 = (double) r0
            double r8 = (double) r1
            double r10 = (double) r13
            r5 = r3
            r5.<init>(r6, r8, r10)
            r2.setCoordinate(r3)
        L_0x0023:
            r2 = 1
            goto L_0x004c
        L_0x0025:
            double r5 = r3.getLatitude()
            double r7 = (double) r0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0040
            double r5 = r3.getLongitude()
            double r9 = (double) r1
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 != 0) goto L_0x0040
            double r5 = r3.getAltitude()
            double r9 = (double) r13
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x004c
        L_0x0040:
            r3.setLatitude(r7)
            double r0 = (double) r1
            r3.setLongitude(r0)
            double r0 = (double) r13
            r3.setAltitude(r0)
            goto L_0x0023
        L_0x004c:
            if (r2 == 0) goto L_0x0053
            org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r13 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HOME
            r12.notifyDroneEvent(r13)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone.processHomeUpdate(com.atakmap.android.uastool.MAVLink.common.msg_mission_item):void");
    }

    /* access modifiers changed from: protected */
    public void processBatteryUpdate(double d, double d2, double d3) {
        if (this.battery.getBatteryVoltage() != d || this.battery.getBatteryRemain() != d2 || this.battery.getBatteryCurrent() != d3) {
            this.battery.setBatteryVoltage(d);
            this.battery.setBatteryRemain(d2);
            this.battery.setBatteryCurrent(d3);
            notifyDroneEvent(DroneInterfaces.DroneEventsType.BATTERY);
        }
    }

    private void processVibrationMessage(msg_vibration msg_vibration) {
        boolean z;
        boolean z2 = true;
        if (this.vibration.getVibrationX() != msg_vibration.vibration_x) {
            this.vibration.setVibrationX(msg_vibration.vibration_x);
            z = true;
        } else {
            z = false;
        }
        if (this.vibration.getVibrationY() != msg_vibration.vibration_y) {
            this.vibration.setVibrationY(msg_vibration.vibration_y);
            z = true;
        }
        if (this.vibration.getVibrationZ() != msg_vibration.vibration_z) {
            this.vibration.setVibrationZ(msg_vibration.vibration_z);
            z = true;
        }
        if (this.vibration.getFirstAccelClipping() != msg_vibration.clipping_0) {
            this.vibration.setFirstAccelClipping(msg_vibration.clipping_0);
            z = true;
        }
        if (this.vibration.getSecondAccelClipping() != msg_vibration.clipping_1) {
            this.vibration.setSecondAccelClipping(msg_vibration.clipping_1);
            z = true;
        }
        if (this.vibration.getThirdAccelClipping() != msg_vibration.clipping_2) {
            this.vibration.setThirdAccelClipping(msg_vibration.clipping_2);
        } else {
            z2 = z;
        }
        if (z2) {
            notifyAttributeListener(AttributeEvent.STATE_VEHICLE_VIBRATION);
        }
    }

    /* access modifiers changed from: protected */
    public void setType(int i) {
        this.type.setType(i);
    }

    public int getType() {
        return this.type.getType();
    }

    private void processAttitude(msg_attitude msg_attitude) {
        this.attitude.setRoll(Math.toDegrees((double) msg_attitude.roll));
        this.attitude.setRollSpeed((float) Math.toDegrees((double) msg_attitude.rollspeed));
        this.attitude.setPitch(Math.toDegrees((double) msg_attitude.pitch));
        this.attitude.setPitchSpeed((float) Math.toDegrees((double) msg_attitude.pitchspeed));
        this.attitude.setYaw(Math.toDegrees((double) msg_attitude.yaw));
        this.attitude.setYawSpeed((float) Math.toDegrees((double) msg_attitude.yawspeed));
        notifyDroneEvent(DroneInterfaces.DroneEventsType.ATTITUDE);
    }

    /* access modifiers changed from: protected */
    public void processSignalUpdate(int i, int i2, short s, short s2, short s3, short s4, short s5) {
        this.signal.setValid(true);
        this.signal.setRxerrors(i & 65535);
        this.signal.setFixed(i2 & 65535);
        this.signal.setRssi(SikValueToDB(s & 255));
        this.signal.setRemrssi(SikValueToDB(s2 & 255));
        this.signal.setNoise(SikValueToDB(s4 & 255));
        this.signal.setRemnoise(SikValueToDB(s5 & 255));
        this.signal.setTxbuf(s3 & 255);
        Signal signal2 = this.signal;
        signal2.setSignalStrength((double) MathUtils.getSignalStrength(signal2.getFadeMargin(), this.signal.getRemFadeMargin()));
        notifyDroneEvent(DroneInterfaces.DroneEventsType.RADIO);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processGlobalPositionInt(com.atakmap.android.uastool.MAVLink.common.msg_global_position_int r10) {
        /*
            r9 = this;
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r10.lat
            double r0 = (double) r0
            r2 = 4711630319722168320(0x416312d000000000, double:1.0E7)
            double r0 = r0 / r2
            int r10 = r10.lon
            double r4 = (double) r10
            double r4 = r4 / r2
            r10 = 0
            com.o3dr.services.android.lib.drone.property.Gps r2 = r9.vehicleGps
            com.o3dr.services.android.lib.coordinate.LatLong r2 = r2.getPosition()
            r3 = 1
            if (r2 != 0) goto L_0x0026
            com.o3dr.services.android.lib.coordinate.LatLong r10 = new com.o3dr.services.android.lib.coordinate.LatLong
            r10.<init>(r0, r4)
            com.o3dr.services.android.lib.drone.property.Gps r0 = r9.vehicleGps
            r0.setPosition(r10)
        L_0x0024:
            r10 = 1
            goto L_0x003d
        L_0x0026:
            double r6 = r2.getLatitude()
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 != 0) goto L_0x0036
            double r6 = r2.getLongitude()
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x003d
        L_0x0036:
            r2.setLatitude(r0)
            r2.setLongitude(r4)
            goto L_0x0024
        L_0x003d:
            if (r10 == 0) goto L_0x0044
            java.lang.String r10 = "com.o3dr.services.android.lib.attribute.event.GPS_POSITION"
            r9.notifyAttributeListener(r10)
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone.processGlobalPositionInt(com.atakmap.android.uastool.MAVLink.common.msg_global_position_int):void");
    }

    private void processEfkStatus(msg_ekf_status_report msg_ekf_status_report) {
        this.state.setEkfStatus(msg_ekf_status_report);
        this.vehicleGps.setVehicleArmed(this.state.isArmed());
        this.vehicleGps.setEkfStatus(CommonApiUtils.generateEkfStatus(msg_ekf_status_report));
        notifyAttributeListener(AttributeEvent.GPS_POSITION);
    }

    private void processGpsState(msg_gps_raw_int msg_gps_raw_int) {
        if (msg_gps_raw_int != null) {
            double d = ((double) msg_gps_raw_int.eph) / 100.0d;
            if (!(this.vehicleGps.getSatellitesCount() == msg_gps_raw_int.satellites_visible && this.vehicleGps.getGpsEph() == d)) {
                this.vehicleGps.setSatCount(msg_gps_raw_int.satellites_visible);
                this.vehicleGps.setGpsEph(d);
                notifyAttributeListener(AttributeEvent.GPS_COUNT);
            }
            if (this.vehicleGps.getFixType() != msg_gps_raw_int.fix_type) {
                this.vehicleGps.setFixType(msg_gps_raw_int.fix_type);
                notifyAttributeListener(AttributeEvent.GPS_FIX);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void requestHomeUpdate() {
        requestHomeUpdate(this);
    }

    private static void requestHomeUpdate(MavLinkDrone mavLinkDrone) {
        MavLinkWaypoint.requestWayPoint(mavLinkDrone, 0);
    }
}
