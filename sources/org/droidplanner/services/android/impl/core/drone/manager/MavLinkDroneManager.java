package org.droidplanner.services.android.impl.core.drone.manager;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_progress;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_report;
import com.atakmap.android.uastool.MAVLink.common.msg_command_ack;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.drone.action.GimbalActions;
import com.o3dr.services.android.lib.drone.action.StateActions;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import com.o3dr.services.android.lib.gcs.action.FollowMeActions;
import com.o3dr.services.android.lib.gcs.follow.FollowLocationSource;
import com.o3dr.services.android.lib.gcs.follow.FollowType;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import com.o3dr.services.android.lib.gcs.returnToMe.ReturnToMeState;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.droidplanner.services.android.impl.api.DroneApi;
import org.droidplanner.services.android.impl.communication.service.MAVLinkClient;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkMsgHandler;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneManager;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.ArduCopter;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.ArduPlane;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.ArduRover;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.ArduSolo;
import org.droidplanner.services.android.impl.core.drone.autopilot.generic.GenericMavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.autopilot.px4.Px4Native;
import org.droidplanner.services.android.impl.core.drone.profiles.ParameterManager;
import org.droidplanner.services.android.impl.core.drone.variables.StreamRates;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.MagnetometerCalibrationImpl;
import org.droidplanner.services.android.impl.core.firmware.FirmwareType;
import org.droidplanner.services.android.impl.core.gcs.GCSHeartbeat;
import org.droidplanner.services.android.impl.core.gcs.ReturnToMe;
import org.droidplanner.services.android.impl.core.gcs.follow.Follow;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.FusedLocation;
import org.droidplanner.services.android.impl.utils.AndroidApWarningParser;
import org.droidplanner.services.android.impl.utils.CommonApiUtils;
import org.droidplanner.services.android.impl.utils.SoloApiUtils;

public class MavLinkDroneManager extends DroneManager<MavLinkDrone, MAVLinkPacket> implements MagnetometerCalibrationImpl.OnMagnetometerCalibrationListener {
    private static final int DEFAULT_STREAM_RATE = 2;
    private final DroneCommandTracker commandTracker;
    private AtomicInteger droneStreamRate = new AtomicInteger(2);
    private Follow followMe;
    private final GCSHeartbeat gcsHeartbeat;
    private final MAVLinkClient mavClient;
    private final MavLinkMsgHandler mavLinkMsgHandler;
    private ReturnToMe returnToMe;

    public MavLinkDroneManager(Context context, ConnectionParameter connectionParameter, Handler handler) {
        super(context, connectionParameter, handler);
        DroneCommandTracker droneCommandTracker = new DroneCommandTracker(handler);
        this.commandTracker = droneCommandTracker;
        MAVLinkClient mAVLinkClient = new MAVLinkClient(context, this, connectionParameter, droneCommandTracker);
        this.mavClient = mAVLinkClient;
        this.gcsHeartbeat = new GCSHeartbeat(mAVLinkClient, 1);
        this.mavLinkMsgHandler = new MavLinkMsgHandler(this);
        updateDroneStreamRate(connectionParameter);
    }

    public void onVehicleTypeReceived(FirmwareType firmwareType) {
        if (this.drone == null) {
            String str = this.connectionParameter.getUniqueId() + ":" + firmwareType.getType();
            switch (C59721.f8627x1c620bb0[firmwareType.ordinal()]) {
                case 1:
                    if (!isCompanionComputerEnabled()) {
                        cqb.m12010c("Instantiating ArduCopter autopilot.", new Object[0]);
                        this.drone = new ArduCopter(str, this.context, this.mavClient, this.handler, new AndroidApWarningParser(), this);
                        break;
                    } else {
                        onVehicleTypeReceived(FirmwareType.ARDU_SOLO);
                        return;
                    }
                case 2:
                    cqb.m12010c("Instantiating ArduSolo autopilot.", new Object[0]);
                    this.drone = new ArduSolo(str, this.context, this.mavClient, this.handler, new AndroidApWarningParser(), this);
                    break;
                case 3:
                    cqb.m12010c("Instantiating ArduPlane autopilot.", new Object[0]);
                    this.drone = new ArduPlane(str, this.context, this.mavClient, this.handler, new AndroidApWarningParser(), this);
                    break;
                case 4:
                    cqb.m12010c("Instantiating ArduPlane autopilot.", new Object[0]);
                    this.drone = new ArduRover(str, this.context, this.mavClient, this.handler, new AndroidApWarningParser(), this);
                    break;
                case 5:
                    cqb.m12010c("Instantiating PX4 Native autopilot.", new Object[0]);
                    this.drone = new Px4Native(str, this.context, this.handler, this.mavClient, new AndroidApWarningParser(), this);
                    break;
                case 6:
                    cqb.m12010c("Instantiating Generic mavlink autopilot.", new Object[0]);
                    this.drone = new GenericMavLinkDrone(str, this.context, this.handler, this.mavClient, new AndroidApWarningParser(), this);
                    break;
            }
            this.followMe = new Follow(this, this.handler, new FusedLocation(this.context, this.handler));
            this.returnToMe = new ReturnToMe(this, new FusedLocation(this.context, this.handler, 100, 1000, 1000, 5.0f), this);
            StreamRates streamRates = ((MavLinkDrone) this.drone).getStreamRates();
            if (streamRates != null) {
                streamRates.setRates(new StreamRates.Rates(this.droneStreamRate.get()));
            }
            ((MavLinkDrone) this.drone).addDroneListener(this);
            ((MavLinkDrone) this.drone).setAttributeListener(this);
            ParameterManager parameterManager = ((MavLinkDrone) this.drone).getParameterManager();
            if (parameterManager != null) {
                parameterManager.setParameterListener(this);
            }
            MagnetometerCalibrationImpl magnetometerCalibration = ((MavLinkDrone) this.drone).getMagnetometerCalibration();
            if (magnetometerCalibration != null) {
                magnetometerCalibration.setListener(this);
            }
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager$1 */
    /* synthetic */ class C59721 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$firmware$FirmwareType */
        static final /* synthetic */ int[] f8627x1c620bb0;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.droidplanner.services.android.impl.core.firmware.FirmwareType[] r0 = org.droidplanner.services.android.impl.core.firmware.FirmwareType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8627x1c620bb0 = r0
                org.droidplanner.services.android.impl.core.firmware.FirmwareType r1 = org.droidplanner.services.android.impl.core.firmware.FirmwareType.ARDU_COPTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8627x1c620bb0     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.firmware.FirmwareType r1 = org.droidplanner.services.android.impl.core.firmware.FirmwareType.ARDU_SOLO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8627x1c620bb0     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.firmware.FirmwareType r1 = org.droidplanner.services.android.impl.core.firmware.FirmwareType.ARDU_PLANE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8627x1c620bb0     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.droidplanner.services.android.impl.core.firmware.FirmwareType r1 = org.droidplanner.services.android.impl.core.firmware.FirmwareType.ARDU_ROVER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8627x1c620bb0     // Catch:{ NoSuchFieldError -> 0x003e }
                org.droidplanner.services.android.impl.core.firmware.FirmwareType r1 = org.droidplanner.services.android.impl.core.firmware.FirmwareType.PX4_NATIVE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8627x1c620bb0     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.droidplanner.services.android.impl.core.firmware.FirmwareType r1 = org.droidplanner.services.android.impl.core.firmware.FirmwareType.GENERIC     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager.C59721.<clinit>():void");
        }
    }

    public void destroy() {
        super.destroy();
        Follow follow = this.followMe;
        if (follow != null && follow.isEnabled()) {
            this.followMe.disableFollowMe();
        }
        ReturnToMe returnToMe2 = this.returnToMe;
        if (returnToMe2 != null) {
            returnToMe2.disable();
        }
    }

    /* access modifiers changed from: protected */
    public void doConnect(String str, DroneApi droneApi, ConnectionParameter connectionParameter) {
        if (this.mavClient.isDisconnected()) {
            cqb.m12010c("Opening connection for %s", str);
            this.mavClient.openConnection();
        } else if (isConnected()) {
            droneApi.onDroneEvent(DroneInterfaces.DroneEventsType.CONNECTED, this.drone);
            if (!((MavLinkDrone) this.drone).isConnectionAlive()) {
                droneApi.onDroneEvent(DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT, this.drone);
            }
        }
        this.mavClient.registerForTLogLogging(str, connectionParameter.getTLogLoggingUri());
        updateDroneStreamRate(connectionParameter);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r0 = r4.droneStreamRate.compareAndSet(r1, r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateDroneStreamRate(com.o3dr.services.android.lib.drone.connection.ConnectionParameter r5) {
        /*
            r4 = this;
            long r0 = r5.getEventsDispatchingPeriod()
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x000b
            return
        L_0x000b:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r0
            float r5 = (float) r2
            int r5 = java.lang.Math.round(r5)
        L_0x0013:
            r0 = 1
            java.util.concurrent.atomic.AtomicInteger r1 = r4.droneStreamRate
            int r1 = r1.get()
            if (r5 <= r1) goto L_0x0040
            java.util.concurrent.atomic.AtomicInteger r0 = r4.droneStreamRate
            boolean r0 = r0.compareAndSet(r1, r5)
            if (r0 == 0) goto L_0x0040
            org.droidplanner.services.android.impl.core.drone.autopilot.Drone r1 = r4.drone
            if (r1 == 0) goto L_0x0040
            org.droidplanner.services.android.impl.core.drone.autopilot.Drone r1 = r4.drone
            org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone r1 = (org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone) r1
            org.droidplanner.services.android.impl.core.drone.variables.StreamRates r1 = r1.getStreamRates()
            if (r1 == 0) goto L_0x0040
            org.droidplanner.services.android.impl.core.drone.variables.StreamRates$Rates r2 = new org.droidplanner.services.android.impl.core.drone.variables.StreamRates$Rates
            java.util.concurrent.atomic.AtomicInteger r3 = r4.droneStreamRate
            int r3 = r3.get()
            r2.<init>(r3)
            r1.setRates(r2)
        L_0x0040:
            if (r0 == 0) goto L_0x0013
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager.updateDroneStreamRate(com.o3dr.services.android.lib.drone.connection.ConnectionParameter):void");
    }

    /* access modifiers changed from: protected */
    public void doDisconnect(String str, DroneApi droneApi) {
        if (this.drone instanceof GenericMavLinkDrone) {
            ((GenericMavLinkDrone) this.drone).tryStoppingVideoStream(str);
        }
        if (droneApi != null) {
            this.mavClient.unregisterForTLogLogging(str);
            if (isConnected()) {
                droneApi.onDroneEvent(DroneInterfaces.DroneEventsType.DISCONNECTED, this.drone);
            }
        }
        if (this.mavClient.isConnected() && this.connectedApps.isEmpty()) {
            executeAsyncAction(new Action(GimbalActions.ACTION_RESET_GIMBAL_MOUNT_MODE), (ICommandListener) null);
            this.mavClient.closeConnection();
        }
    }

    private void handleCommandAck(msg_command_ack msg_command_ack) {
        if (msg_command_ack != null) {
            this.commandTracker.onCommandAck(77, msg_command_ack);
        }
    }

    public void notifyReceivedData(MAVLinkPacket mAVLinkPacket) {
        MAVLinkMessage unpack = mAVLinkPacket.unpack();
        if (unpack != null) {
            if (unpack.msgid == 77) {
                handleCommandAck((msg_command_ack) unpack);
            } else {
                this.mavLinkMsgHandler.receiveData(unpack);
                if (this.drone != null) {
                    ((MavLinkDrone) this.drone).onMavLinkMessageReceived(unpack);
                }
            }
            if (!this.connectedApps.isEmpty()) {
                for (DroneApi onReceivedMavLinkMessage : this.connectedApps.values()) {
                    onReceivedMavLinkMessage.onReceivedMavLinkMessage(unpack);
                }
            }
        }
    }

    public void onConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
        super.onConnectionStatus(linkConnectionStatus);
        String statusCode = linkConnectionStatus.getStatusCode();
        statusCode.hashCode();
        if (statusCode.equals(LinkConnectionStatus.CONNECTED)) {
            this.gcsHeartbeat.setActive(true);
        } else if (statusCode.equals(LinkConnectionStatus.DISCONNECTED)) {
            this.gcsHeartbeat.setActive(false);
        }
    }

    public DroneAttribute getAttribute(DroneApi.ClientInfo clientInfo, String str) {
        str.hashCode();
        if (str.equals(AttributeType.FOLLOW_STATE)) {
            return CommonApiUtils.getFollowState(this.followMe);
        }
        if (!str.equals(AttributeType.RETURN_TO_ME_STATE)) {
            return super.getAttribute(clientInfo, str);
        }
        ReturnToMe returnToMe2 = this.returnToMe;
        return returnToMe2 == null ? new ReturnToMeState() : returnToMe2.getState();
    }

    /* access modifiers changed from: protected */
    public boolean executeAsyncAction(Action action, ICommandListener iCommandListener) {
        Location location;
        String type = action.getType();
        Bundle data = action.getData();
        cqb.m12007b("executeAsyncAction(): action=%s", type);
        type.hashCode();
        char c = 65535;
        switch (type.hashCode()) {
            case -1565932190:
                if (type.equals(FollowMeActions.ACTION_ENABLE_FOLLOW_ME)) {
                    c = 0;
                    break;
                }
                break;
            case 99845879:
                if (type.equals(FollowMeActions.ACTION_DISABLE_FOLLOW_ME)) {
                    c = 1;
                    break;
                }
                break;
            case 175959057:
                if (type.equals(StateActions.ACTION_ENABLE_RETURN_TO_ME)) {
                    c = 2;
                    break;
                }
                break;
            case 666735894:
                if (type.equals(FollowMeActions.ACTION_UPDATE_FOLLOW_PARAMS)) {
                    c = 3;
                    break;
                }
                break;
            case 1751775090:
                if (type.equals(FollowMeActions.ACTION_NEW_EXTERNAL_LOCATION)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                data.setClassLoader(FollowType.class.getClassLoader());
                FollowLocationSource followLocationSource = (FollowLocationSource) data.getParcelable(FollowMeActions.EXTRA_LOCATION_SOURCE);
                if (followLocationSource == null) {
                    followLocationSource = FollowLocationSource.INTERNAL;
                }
                enableFollowMe((FollowType) data.getParcelable(FollowMeActions.EXTRA_FOLLOW_TYPE), followLocationSource, iCommandListener);
                return true;
            case 1:
                CommonApiUtils.disableFollowMe(this.followMe);
                return true;
            case 2:
                boolean z = data.getBoolean(StateActions.EXTRA_IS_RETURN_TO_ME_ENABLED, false);
                ReturnToMe returnToMe2 = this.returnToMe;
                if (returnToMe2 != null) {
                    if (z) {
                        returnToMe2.enable(iCommandListener);
                    } else {
                        returnToMe2.disable();
                    }
                    CommonApiUtils.postSuccessEvent(iCommandListener);
                } else {
                    CommonApiUtils.postErrorEvent(4, iCommandListener);
                }
                return true;
            case 3:
                if (this.followMe != null) {
                    data.setClassLoader(LatLong.class.getClassLoader());
                    FollowAlgorithm followAlgorithm = this.followMe.getFollowAlgorithm();
                    if (followAlgorithm != null) {
                        HashMap hashMap = new HashMap();
                        for (String str : data.keySet()) {
                            hashMap.put(str, data.get(str));
                        }
                        followAlgorithm.updateAlgorithmParams(hashMap);
                    }
                }
                return true;
            case 4:
                data.setClassLoader(Location.class.getClassLoader());
                if (!(this.followMe == null || data == null || (location = (Location) data.getParcelable(FollowMeActions.EXTRA_LOCATION)) == null)) {
                    cqb.m12010c("onNewLocation(%s)", location);
                    this.followMe.onFollowNewLocation(location);
                }
                return true;
            default:
                return super.executeAsyncAction(action, iCommandListener);
        }
    }

    private void enableFollowMe(FollowType followType, FollowLocationSource followLocationSource, ICommandListener iCommandListener) {
        cqb.m12007b("enableFollowMe(): followType=%s source=%s", followType, followLocationSource);
        FollowAlgorithm.FollowModes followTypeToMode = CommonApiUtils.followTypeToMode((MavLinkDrone) this.drone, followType);
        if (followTypeToMode != null) {
            Follow follow = this.followMe;
            if (follow == null) {
                cqb.m12007b("enableFollowMe(): followMe is null", new Object[0]);
                return;
            }
            cqb.m12007b("CURRENT: followMe.enabled=%s followMe.state=%s source=%s", Boolean.valueOf(follow.isEnabled()), this.followMe.getState(), followLocationSource);
            this.followMe.enableFollowMe(followLocationSource);
            if (this.followMe.getFollowAlgorithm().getType() != followTypeToMode) {
                if (followTypeToMode != FollowAlgorithm.FollowModes.SOLO_SHOT || SoloApiUtils.isSoloLinkFeatureAvailable(this.drone, iCommandListener)) {
                    FollowAlgorithm algorithmType = followTypeToMode.getAlgorithmType(this, this.handler);
                    cqb.m12007b("Setting followAlgorithm to %s", algorithmType);
                    this.followMe.setAlgorithm(algorithmType);
                    CommonApiUtils.postSuccessEvent(iCommandListener);
                } else {
                    cqb.m12012d("FollowType is SOLO_SHOT, but SoloLink is not available.", new Object[0]);
                    return;
                }
            }
            cqb.m12010c("AFTER: followMe.state=%s type=%s", this.followMe.getState(), followType);
        }
    }

    public void onCalibrationCancelled() {
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onCalibrationCancelled : this.connectedApps.values()) {
                onCalibrationCancelled.onCalibrationCancelled();
            }
        }
    }

    public void onCalibrationProgress(msg_mag_cal_progress msg_mag_cal_progress) {
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onCalibrationProgress : this.connectedApps.values()) {
                onCalibrationProgress.onCalibrationProgress(msg_mag_cal_progress);
            }
        }
    }

    public void onCalibrationCompleted(msg_mag_cal_report msg_mag_cal_report) {
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onCalibrationCompleted : this.connectedApps.values()) {
                onCalibrationCompleted.onCalibrationCompleted(msg_mag_cal_report);
            }
        }
    }
}
