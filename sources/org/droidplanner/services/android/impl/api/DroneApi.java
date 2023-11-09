package org.droidplanner.services.android.impl.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_progress;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mag_cal_report;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.action.CameraActions;
import com.o3dr.services.android.lib.drone.action.ConnectionActions;
import com.o3dr.services.android.lib.drone.action.ExperimentalActions;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.drone.attribute.AttributeEventExtra;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.drone.mission.Mission;
import com.o3dr.services.android.lib.drone.mission.action.MissionActions;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.drone.mission.item.command.ResetROI;
import com.o3dr.services.android.lib.drone.mission.item.spatial.RegionOfInterest;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import com.o3dr.services.android.lib.drone.property.Parameter;
import com.o3dr.services.android.lib.drone.property.State;
import com.o3dr.services.android.lib.gcs.event.GCSEvent;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import com.o3dr.services.android.lib.gcs.link.LinkEvent;
import com.o3dr.services.android.lib.gcs.link.LinkEventExtra;
import com.o3dr.services.android.lib.mavlink.MavlinkMessageWrapper;
import com.o3dr.services.android.lib.model.IApiListener;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.IDroneApi;
import com.o3dr.services.android.lib.model.IMavlinkObserver;
import com.o3dr.services.android.lib.model.IObserver;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneManager;
import org.droidplanner.services.android.impl.core.drone.autopilot.Drone;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.AccelCalibration;
import org.droidplanner.services.android.impl.core.drone.variables.calibration.MagnetometerCalibrationImpl;
import org.droidplanner.services.android.impl.exception.ConnectionException;
import org.droidplanner.services.android.impl.utils.CommonApiUtils;
import org.droidplanner.services.android.impl.utils.MissionUtils;

public final class DroneApi extends IDroneApi.Stub implements IBinder.DeathRecipient, DroneInterfaces.AttributeEventListener, DroneInterfaces.OnDroneListener, DroneInterfaces.OnParameterManagerListener, MagnetometerCalibrationImpl.OnMagnetometerCalibrationListener {
    private static final int RESET_ROI_LIB_VERSION = 206080;
    private final IApiListener apiListener;
    private final ClientInfo clientInfo;
    /* access modifiers changed from: private */
    public ConnectionParameter connectionParams;
    private final Context context;
    private DroneManager droneMgr;
    /* access modifiers changed from: private */
    public final ConcurrentLinkedQueue<EventInfo> eventsBuffer = new ConcurrentLinkedQueue<>();
    private final Runnable eventsDispatcher = new Runnable() {
        private final LinkedHashMap<String, Bundle> eventsFilter = new LinkedHashMap<>();

        public void run() {
            this.eventsFilter.clear();
            EventInfo eventInfo = (EventInfo) DroneApi.this.eventsBuffer.poll();
            while (eventInfo != null) {
                this.eventsFilter.put(eventInfo.event, eventInfo.extras);
                EventInfo.recycle(eventInfo);
                eventInfo = (EventInfo) DroneApi.this.eventsBuffer.poll();
            }
            for (Map.Entry next : this.eventsFilter.entrySet()) {
                DroneApi.this.dispatchAttributeEvent((String) next.getKey(), (Bundle) next.getValue());
            }
            this.eventsFilter.clear();
            DroneApi.this.handler.removeCallbacks(this);
            if (DroneApi.this.isEventsBufferingEnabled()) {
                DroneApi.this.handler.postDelayed(this, DroneApi.this.connectionParams.getEventsDispatchingPeriod());
            }
        }
    };
    /* access modifiers changed from: private */
    public final Handler handler;
    private final ConcurrentLinkedQueue<IMavlinkObserver> mavlinkObserversList;
    private final ConcurrentLinkedQueue<IObserver> observersList;
    private final String ownerId;
    private final DroidPlannerService service;

    DroneApi(DroidPlannerService droidPlannerService, IApiListener iApiListener, String str) {
        int i;
        this.service = droidPlannerService;
        this.context = droidPlannerService.getApplicationContext();
        this.handler = new Handler(Looper.getMainLooper());
        this.ownerId = str;
        this.observersList = new ConcurrentLinkedQueue<>();
        this.mavlinkObserversList = new ConcurrentLinkedQueue<>();
        this.apiListener = iApiListener;
        int i2 = -1;
        try {
            iApiListener.asBinder().linkToDeath(this, 0);
            checkForSelfRelease();
            i = iApiListener.getApiVersionCode();
            try {
                i2 = iApiListener.getClientVersionCode();
            } catch (RemoteException e) {
                e = e;
                cqb.m12015e(e, e.getMessage(), new Object[0]);
                droidPlannerService.releaseDroneApi(this.ownerId);
                this.clientInfo = new ClientInfo(this.ownerId, i, i2);
            }
        } catch (RemoteException e2) {
            e = e2;
            i = -1;
            cqb.m12015e(e, e.getMessage(), new Object[0]);
            droidPlannerService.releaseDroneApi(this.ownerId);
            this.clientInfo = new ClientInfo(this.ownerId, i, i2);
        }
        this.clientInfo = new ClientInfo(this.ownerId, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        cqb.m12007b("Destroying drone api instance for %s", this.ownerId);
        this.observersList.clear();
        this.mavlinkObserversList.clear();
        try {
            this.apiListener.asBinder().unlinkToDeath(this, 0);
        } catch (NoSuchElementException e) {
            cqb.m12015e(e, e.getMessage(), new Object[0]);
        }
        this.service.disconnectDroneManager(this.droneMgr, this.clientInfo);
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public DroneManager getDroneManager() {
        return this.droneMgr;
    }

    private Drone getDrone() {
        DroneManager droneManager = this.droneMgr;
        if (droneManager == null) {
            return null;
        }
        return droneManager.getDrone();
    }

    /* access modifiers changed from: private */
    public boolean isEventsBufferingEnabled() {
        ConnectionParameter connectionParameter = this.connectionParams;
        return connectionParameter != null && connectionParameter.getEventsDispatchingPeriod() > 0;
    }

    public Bundle getAttribute(String str) {
        DroneAttribute attribute;
        Bundle bundle = new Bundle();
        str.hashCode();
        if (!str.equals(AttributeType.CAMERA)) {
            DroneManager droneManager = this.droneMgr;
            if (!(droneManager == null || (attribute = droneManager.getAttribute(this.clientInfo, str)) == null)) {
                if (this.clientInfo.clientVersionCode < RESET_ROI_LIB_VERSION && (attribute instanceof Mission)) {
                    List<MissionItem> missionItems = ((Mission) attribute).getMissionItems();
                    int size = missionItems.size();
                    for (int i = 0; i < size; i++) {
                        if (missionItems.get(i) instanceof ResetROI) {
                            missionItems.remove(i);
                            RegionOfInterest regionOfInterest = new RegionOfInterest();
                            regionOfInterest.setCoordinate(new LatLongAlt(0.0d, 0.0d, 0.0d));
                            missionItems.add(i, regionOfInterest);
                        }
                    }
                }
                bundle.putParcelable(str, attribute);
            }
        } else {
            bundle.putParcelable(str, CommonApiUtils.getCameraProxy(getDrone(), this.service.getCameraDetails()));
        }
        return bundle;
    }

    public boolean isConnected() {
        DroneManager droneManager = this.droneMgr;
        return droneManager != null && droneManager.isConnected();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r0 = org.droidplanner.services.android.impl.communication.connection.SoloConnection.getSoloConnectionParameterFromUdp(r1.context, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.o3dr.services.android.lib.drone.connection.ConnectionParameter checkConnectionParameter(com.o3dr.services.android.lib.drone.connection.ConnectionParameter r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0014
            android.content.Context r0 = r1.context
            boolean r0 = org.droidplanner.services.android.impl.communication.connection.SoloConnection.isUdpSoloConnection(r0, r2)
            if (r0 == 0) goto L_0x0013
            android.content.Context r0 = r1.context
            com.o3dr.services.android.lib.drone.connection.ConnectionParameter r0 = org.droidplanner.services.android.impl.communication.connection.SoloConnection.getSoloConnectionParameterFromUdp(r0, r2)
            if (r0 == 0) goto L_0x0013
            return r0
        L_0x0013:
            return r2
        L_0x0014:
            org.droidplanner.services.android.impl.exception.ConnectionException r2 = new org.droidplanner.services.android.impl.exception.ConnectionException
            java.lang.String r0 = "Invalid connection parameters"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.api.DroneApi.checkConnectionParameter(com.o3dr.services.android.lib.drone.connection.ConnectionParameter):com.o3dr.services.android.lib.drone.connection.ConnectionParameter");
    }

    public void connect(ConnectionParameter connectionParameter) {
        try {
            ConnectionParameter checkConnectionParameter = checkConnectionParameter(connectionParameter);
            ConnectionParameter connectionParameter2 = this.connectionParams;
            if (connectionParameter2 != null) {
                connectionParameter2 = checkConnectionParameter(connectionParameter2);
            }
            if (checkConnectionParameter.equals(connectionParameter2)) {
                return;
            }
            if (this.droneMgr != null) {
                onConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(-6, "Connection already started with different connection parameters"));
                return;
            }
            this.connectionParams = checkConnectionParameter;
            this.droneMgr = this.service.connectDroneManager(checkConnectionParameter, this.ownerId, this);
            if (isEventsBufferingEnabled()) {
                this.eventsBuffer.clear();
                this.handler.postDelayed(this.eventsDispatcher, this.connectionParams.getEventsDispatchingPeriod());
            }
        } catch (ConnectionException e) {
            onConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(-4, e.getMessage()));
            disconnect();
        }
    }

    public void disconnect() {
        this.service.disconnectDroneManager(this.droneMgr, this.clientInfo);
        this.connectionParams = null;
        this.droneMgr = null;
        this.handler.removeCallbacks(this.eventsDispatcher);
    }

    private void checkForSelfRelease() {
        if (!this.apiListener.asBinder().pingBinder()) {
            cqb.m12012d("Client is not longer available.", new Object[0]);
            this.context.startService(new Intent(this.context, DroidPlannerService.class).setAction(DroidPlannerService.ACTION_RELEASE_API_INSTANCE).putExtra(DroidPlannerService.EXTRA_API_INSTANCE_APP_ID, this.ownerId));
        }
    }

    public void addAttributesObserver(IObserver iObserver) {
        if (iObserver != null) {
            cqb.m12007b("Adding attributes observer.", new Object[0]);
            this.observersList.add(iObserver);
        }
    }

    public void removeAttributesObserver(IObserver iObserver) {
        if (iObserver != null) {
            cqb.m12007b("Removing attributes observer.", new Object[0]);
            this.observersList.remove(iObserver);
            checkForSelfRelease();
        }
    }

    public void addMavlinkObserver(IMavlinkObserver iMavlinkObserver) {
        if (iMavlinkObserver != null) {
            this.mavlinkObserversList.add(iMavlinkObserver);
        }
    }

    public void removeMavlinkObserver(IMavlinkObserver iMavlinkObserver) {
        if (iMavlinkObserver != null) {
            this.mavlinkObserversList.remove(iMavlinkObserver);
            checkForSelfRelease();
        }
    }

    public void executeAction(Action action, ICommandListener iCommandListener) {
        String type;
        Mission loadMission;
        if (action != null && (type = action.getType()) != null) {
            Bundle data = action.getData();
            if (data != null) {
                data.setClassLoader(this.context.getClassLoader());
            }
            Drone drone = getDrone();
            type.hashCode();
            char c = 65535;
            switch (type.hashCode()) {
                case -1890132007:
                    if (type.equals(ExperimentalActions.ACTION_START_VIDEO_STREAM_FOR_OBSERVER)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1509511970:
                    if (type.equals(MissionActions.ACTION_BUILD_COMPLEX_MISSION_ITEM)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1036752832:
                    if (type.equals(CameraActions.ACTION_START_VIDEO_STREAM)) {
                        c = 2;
                        break;
                    }
                    break;
                case -919786677:
                    if (type.equals(MissionActions.ACTION_LOAD_MISSION)) {
                        c = 3;
                        break;
                    }
                    break;
                case -664145196:
                    if (type.equals(ConnectionActions.ACTION_DISCONNECT)) {
                        c = 4;
                        break;
                    }
                    break;
                case 648987026:
                    if (type.equals(ConnectionActions.ACTION_CONNECT)) {
                        c = 5;
                        break;
                    }
                    break;
                case 682234587:
                    if (type.equals(ExperimentalActions.ACTION_STOP_VIDEO_STREAM_FOR_OBSERVER)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1964405154:
                    if (type.equals(CameraActions.ACTION_STOP_VIDEO_STREAM)) {
                        c = 7;
                        break;
                    }
                    break;
                case 2027004130:
                    if (type.equals(MissionActions.ACTION_SAVE_MISSION)) {
                        c = 8;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    CommonApiUtils.startVideoStreamForObserver(drone, this.ownerId, data.getString(CameraActions.EXTRA_VIDEO_TAG, ""), iCommandListener);
                    return;
                case 1:
                    if ((drone instanceof MavLinkDrone) || drone == null) {
                        CommonApiUtils.buildComplexMissionItem((MavLinkDrone) drone, data);
                        return;
                    } else {
                        CommonApiUtils.postErrorEvent(3, iCommandListener);
                        return;
                    }
                case 2:
                    Surface surface = (Surface) data.getParcelable(CameraActions.EXTRA_VIDEO_DISPLAY);
                    String string = data.getString(CameraActions.EXTRA_VIDEO_TAG, "");
                    Bundle bundle = data.getBundle(CameraActions.EXTRA_VIDEO_PROPERTIES);
                    if (bundle == null) {
                        bundle = new Bundle();
                        bundle.putInt("extra_video_props_udp_port", 5600);
                    }
                    CommonApiUtils.startVideoStream(drone, bundle, this.ownerId, string, surface, iCommandListener);
                    return;
                case 3:
                    Uri uri = (Uri) data.getParcelable(MissionActions.EXTRA_LOAD_MISSION_URI);
                    boolean z = data.getBoolean(MissionActions.EXTRA_SET_LOADED_MISSION, false);
                    if (uri != null && (loadMission = MissionUtils.loadMission(this.context, uri)) != null) {
                        data.putParcelable(MissionActions.EXTRA_MISSION, loadMission);
                        if (z) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable(MissionActions.EXTRA_MISSION, loadMission);
                            bundle2.putBoolean(MissionActions.EXTRA_PUSH_TO_DRONE, false);
                            executeAction(new Action(MissionActions.ACTION_SET_MISSION, bundle2), iCommandListener);
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    disconnect();
                    return;
                case 5:
                    connect((ConnectionParameter) data.getParcelable(ConnectionActions.EXTRA_CONNECT_PARAMETER));
                    return;
                case 6:
                    CommonApiUtils.stopVideoStreamForObserver(drone, this.ownerId, data.getString(CameraActions.EXTRA_VIDEO_TAG, ""), iCommandListener);
                    return;
                case 7:
                    CommonApiUtils.stopVideoStream(drone, this.ownerId, data.getString(CameraActions.EXTRA_VIDEO_TAG, ""), iCommandListener);
                    return;
                case 8:
                    Mission mission = (Mission) data.getParcelable(MissionActions.EXTRA_MISSION);
                    Uri uri2 = (Uri) data.getParcelable(MissionActions.EXTRA_SAVE_MISSION_URI);
                    if (uri2 == null) {
                        CommonApiUtils.postErrorEvent(4, iCommandListener);
                        return;
                    } else {
                        MissionUtils.saveMission(this.context, mission, uri2, iCommandListener);
                        return;
                    }
                default:
                    DroneManager droneManager = this.droneMgr;
                    if (droneManager != null) {
                        droneManager.executeAsyncAction(this.clientInfo, action, iCommandListener);
                        return;
                    } else {
                        CommonApiUtils.postErrorEvent(4, iCommandListener);
                        return;
                    }
            }
        }
    }

    public void executeAsyncAction(Action action, ICommandListener iCommandListener) {
        executeAction(action, iCommandListener);
    }

    public void performAction(Action action) {
        executeAction(action, (ICommandListener) null);
    }

    public void performAsyncAction(Action action) {
        performAction(action);
    }

    private void notifyAttributeUpdate(List<Pair<String, Bundle>> list) {
        if (!this.observersList.isEmpty() && list != null && !list.isEmpty()) {
            for (Pair next : list) {
                notifyAttributeUpdate((String) next.first, (Bundle) next.second);
            }
        }
    }

    private void notifyAttributeUpdate(String str, Bundle bundle) {
        if (!this.observersList.isEmpty() && str != null) {
            if (AttributeEvent.STATE_CONNECTED.equals(str) || AttributeEvent.STATE_DISCONNECTED.equals(str) || !isEventsBufferingEnabled()) {
                dispatchAttributeEvent(str, bundle);
            } else {
                this.eventsBuffer.add(EventInfo.obtain(str, bundle));
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchAttributeEvent(String str, Bundle bundle) {
        Iterator<IObserver> it = this.observersList.iterator();
        while (it.hasNext()) {
            IObserver next = it.next();
            try {
                next.onAttributeUpdated(str, bundle);
            } catch (RemoteException e) {
                cqb.m12015e(e, e.getMessage(), new Object[0]);
                try {
                    removeAttributesObserver(next);
                } catch (RemoteException e2) {
                    cqb.m12015e(e, e2.getMessage(), new Object[0]);
                }
            }
        }
    }

    public void onReceivedMavLinkMessage(MAVLinkMessage mAVLinkMessage) {
        if (!this.mavlinkObserversList.isEmpty() && mAVLinkMessage != null) {
            MavlinkMessageWrapper mavlinkMessageWrapper = new MavlinkMessageWrapper(mAVLinkMessage);
            Iterator<IMavlinkObserver> it = this.mavlinkObserversList.iterator();
            while (it.hasNext()) {
                IMavlinkObserver next = it.next();
                try {
                    next.onMavlinkMessageReceived(mavlinkMessageWrapper);
                } catch (RemoteException e) {
                    cqb.m12015e(e, e.getMessage(), new Object[0]);
                    try {
                        removeMavlinkObserver(next);
                    } catch (RemoteException e2) {
                        cqb.m12015e(e2, e2.getMessage(), new Object[0]);
                    }
                }
            }
        }
    }

    public void onMessageLogged(int i, String str) {
        Bundle bundle = new Bundle(2);
        bundle.putInt(AttributeEventExtra.EXTRA_AUTOPILOT_MESSAGE_LEVEL, i);
        bundle.putString(AttributeEventExtra.EXTRA_AUTOPILOT_MESSAGE, str);
        notifyAttributeUpdate(AttributeEvent.AUTOPILOT_MESSAGE, bundle);
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public void onAttributeEvent(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            notifyAttributeUpdate(str, bundle);
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, Drone drone) {
        Bundle bundle = new Bundle();
        bundle.putString(AttributeEventExtra.EXTRA_VEHICLE_ID, drone != null ? drone.getId() : "");
        String str = null;
        ArrayList arrayList = new ArrayList();
        switch (C59182.f8617x7e1461ff[droneEventsType.ordinal()]) {
            case 1:
                this.context.sendBroadcast(new Intent(GCSEvent.ACTION_VEHICLE_DISCONNECTION).putExtra(GCSEvent.EXTRA_APP_ID, this.ownerId));
                this.eventsBuffer.clear();
                str = AttributeEvent.STATE_DISCONNECTED;
                break;
            case 2:
                str = AttributeEvent.GUIDED_POINT_UPDATED;
                break;
            case 3:
                str = AttributeEvent.SIGNAL_UPDATED;
                break;
            case 6:
            case 7:
                str = AttributeEvent.STATE_ARMING;
                break;
            case 8:
                State state = (State) drone.getAttribute(AttributeType.STATE);
                if (state != null) {
                    bundle.putString(AttributeEventExtra.EXTRA_AUTOPILOT_ERROR_ID, state.getAutopilotErrorId());
                }
                str = AttributeEvent.AUTOPILOT_ERROR;
                break;
            case 9:
                str = AttributeEvent.STATE_VEHICLE_MODE;
                break;
            case 10:
            case 11:
                str = AttributeEvent.ATTITUDE_UPDATED;
                break;
            case 12:
                str = AttributeEvent.SPEED_UPDATED;
                break;
            case 13:
                str = AttributeEvent.BATTERY_UPDATED;
                break;
            case 14:
                str = AttributeEvent.STATE_UPDATED;
                break;
            case 15:
                str = AttributeEvent.MISSION_UPDATED;
                break;
            case 16:
                str = AttributeEvent.MISSION_RECEIVED;
                break;
            case 17:
            case 18:
                str = AttributeEvent.TYPE_UPDATED;
                break;
            case 19:
                str = AttributeEvent.HOME_UPDATED;
                break;
            case 20:
                if (drone instanceof MavLinkDrone) {
                    bundle.putString(AttributeEventExtra.EXTRA_CALIBRATION_IMU_MESSAGE, ((MavLinkDrone) drone).getCalibrationSetup().getMessage());
                    str = AttributeEvent.CALIBRATION_IMU;
                    break;
                }
                break;
            case 21:
                if (drone instanceof MavLinkDrone) {
                    AccelCalibration calibrationSetup = ((MavLinkDrone) drone).getCalibrationSetup();
                    String message = calibrationSetup.getMessage();
                    if (!calibrationSetup.isCalibrating() || !TextUtils.isEmpty(message)) {
                        bundle.putString(AttributeEventExtra.EXTRA_CALIBRATION_IMU_MESSAGE, message);
                        str = AttributeEvent.CALIBRATION_IMU_TIMEOUT;
                        break;
                    } else {
                        calibrationSetup.cancelCalibration();
                    }
                }
                break;
            case 22:
                str = AttributeEvent.HEARTBEAT_TIMEOUT;
                break;
            case 23:
                str = AttributeEvent.STATE_CONNECTING;
                break;
            case 24:
                Bundle bundle2 = new Bundle();
                bundle2.putString(AttributeEventExtra.EXTRA_VEHICLE_ID, drone.getId());
                if (drone instanceof MavLinkDrone) {
                    bundle2.putInt(AttributeEventExtra.EXTRA_MAVLINK_VERSION, ((MavLinkDrone) drone).getMavlinkVersion());
                }
                arrayList.add(Pair.create(AttributeEvent.HEARTBEAT_FIRST, bundle2));
                break;
            case 25:
                break;
            case 26:
                if (drone instanceof MavLinkDrone) {
                    bundle.putInt(AttributeEventExtra.EXTRA_MAVLINK_VERSION, ((MavLinkDrone) drone).getMavlinkVersion());
                }
                str = AttributeEvent.HEARTBEAT_RESTORED;
                break;
            case 27:
                str = AttributeEvent.MISSION_SENT;
                break;
            case 29:
                if (drone instanceof MavLinkDrone) {
                    bundle.putInt(AttributeEventExtra.EXTRA_MISSION_CURRENT_WAYPOINT, ((MavLinkDrone) drone).getMissionStats().getCurrentWP());
                    str = AttributeEvent.MISSION_ITEM_UPDATED;
                    break;
                }
                break;
            case 30:
                if (drone instanceof MavLinkDrone) {
                    bundle.putInt(AttributeEventExtra.EXTRA_MISSION_LAST_REACHED_WAYPOINT, ((MavLinkDrone) drone).getMissionStats().getLastReachedWP());
                    str = AttributeEvent.MISSION_ITEM_REACHED;
                    break;
                }
                break;
            case 31:
                str = AttributeEvent.ALTITUDE_UPDATED;
                break;
            case 32:
                str = AttributeEvent.SIGNAL_WEAK;
                break;
            case 33:
                str = AttributeEvent.WARNING_NO_GPS;
                break;
            case 35:
                str = AttributeEvent.CAMERA_FOOTPRINTS_UPDATED;
                break;
            case 36:
                str = AttributeEvent.STATE_EKF_REPORT;
                break;
            case 37:
                str = AttributeEvent.STATE_EKF_POSITION;
                break;
        }
        this.context.sendBroadcast(new Intent(GCSEvent.ACTION_VEHICLE_CONNECTION).putExtra(GCSEvent.EXTRA_APP_ID, this.ownerId).putExtra(GCSEvent.EXTRA_VEHICLE_CONNECTION_PARAMETER, this.connectionParams.clone()));
        arrayList.add(Pair.create(AttributeEvent.STATE_CONNECTED, bundle));
        if (str != null) {
            notifyAttributeUpdate(str, bundle);
        }
        if (!arrayList.isEmpty()) {
            notifyAttributeUpdate(arrayList);
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.api.DroneApi$2 */
    /* synthetic */ class C59182 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8617x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|(3:73|74|76)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|76) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0150 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x015c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0174 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0180 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x018c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0198 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x01a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x01b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r0 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8617x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.GUIDEDPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.RADIO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.RC_IN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x003e }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.RC_OUT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.ARMING_STARTED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.ARMING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.AUTOPILOT_WARNING     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x006c }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.ATTITUDE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.ORIENTATION     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.SPEED     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x009c }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.BATTERY     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.STATE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MISSION_UPDATE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MISSION_RECEIVED     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.FIRMWARE     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x00d8 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.TYPE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x00e4 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HOME     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x00f0 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.CALIBRATION_IMU     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x00fc }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.CALIBRATION_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0108 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0114 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0120 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x012c }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0138 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0144 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MISSION_SENT     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0150 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.INVALID_POLYGON     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x015c }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MISSION_WP_UPDATE     // Catch:{ NoSuchFieldError -> 0x015c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0168 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MISSION_WP_REACHED     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0174 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.ALTITUDE     // Catch:{ NoSuchFieldError -> 0x0174 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0174 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0174 }
            L_0x0174:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0180 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.WARNING_SIGNAL_WEAK     // Catch:{ NoSuchFieldError -> 0x0180 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0180 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0180 }
            L_0x0180:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x018c }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.WARNING_NO_GPS     // Catch:{ NoSuchFieldError -> 0x018c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018c }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x018c }
            L_0x018c:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0198 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MAGNETOMETER     // Catch:{ NoSuchFieldError -> 0x0198 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0198 }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0198 }
            L_0x0198:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x01a4 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.FOOTPRINT     // Catch:{ NoSuchFieldError -> 0x01a4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a4 }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01a4 }
            L_0x01a4:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x01b0 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.EKF_STATUS_UPDATE     // Catch:{ NoSuchFieldError -> 0x01b0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b0 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01b0 }
            L_0x01b0:
                int[] r0 = f8617x7e1461ff     // Catch:{ NoSuchFieldError -> 0x01bc }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.EKF_POSITION_STATE_UPDATE     // Catch:{ NoSuchFieldError -> 0x01bc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01bc }
                r2 = 37
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01bc }
            L_0x01bc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.api.DroneApi.C59182.<clinit>():void");
        }
    }

    public void onBeginReceivingParameters() {
        notifyAttributeUpdate(AttributeEvent.PARAMETERS_REFRESH_STARTED, (Bundle) null);
    }

    public void onParameterReceived(Parameter parameter, int i, int i2) {
        Bundle bundle = new Bundle(4);
        bundle.putInt(AttributeEventExtra.EXTRA_PARAMETER_INDEX, i);
        bundle.putInt(AttributeEventExtra.EXTRA_PARAMETERS_COUNT, i2);
        bundle.putString(AttributeEventExtra.EXTRA_PARAMETER_NAME, parameter.getName());
        bundle.putDouble(AttributeEventExtra.EXTRA_PARAMETER_VALUE, parameter.getValue());
        notifyAttributeUpdate(AttributeEvent.PARAMETER_RECEIVED, bundle);
    }

    public void onEndReceivingParameters() {
        notifyAttributeUpdate(AttributeEvent.PARAMETERS_REFRESH_COMPLETED, (Bundle) null);
    }

    public void onConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
        String statusCode = linkConnectionStatus.getStatusCode();
        statusCode.hashCode();
        if (statusCode.equals(LinkConnectionStatus.DISCONNECTED)) {
            disconnect();
            checkForSelfRelease();
        } else if (statusCode.equals(LinkConnectionStatus.FAILED)) {
            disconnect();
            checkForSelfRelease();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(LinkEventExtra.EXTRA_CONNECTION_STATUS, linkConnectionStatus);
        notifyAttributeUpdate(LinkEvent.LINK_STATE_UPDATED, bundle);
    }

    public void binderDied() {
        checkForSelfRelease();
    }

    public void onCalibrationCancelled() {
        notifyAttributeUpdate(AttributeEvent.CALIBRATION_MAG_CANCELLED, (Bundle) null);
    }

    public void onCalibrationProgress(msg_mag_cal_progress msg_mag_cal_progress) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(AttributeEventExtra.EXTRA_CALIBRATION_MAG_PROGRESS, CommonApiUtils.getMagnetometerCalibrationProgress(msg_mag_cal_progress));
        notifyAttributeUpdate(AttributeEvent.CALIBRATION_MAG_PROGRESS, bundle);
    }

    public void onCalibrationCompleted(msg_mag_cal_report msg_mag_cal_report) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(AttributeEventExtra.EXTRA_CALIBRATION_MAG_RESULT, CommonApiUtils.getMagnetometerCalibrationResult(msg_mag_cal_report));
        notifyAttributeUpdate(AttributeEvent.CALIBRATION_MAG_COMPLETED, bundle);
    }

    public static class ClientInfo {
        public final int apiVersionCode;
        public final String appId;
        public final int clientVersionCode;

        public ClientInfo(String str, int i, int i2) {
            this.apiVersionCode = i;
            this.appId = str;
            this.clientVersionCode = i2;
        }
    }

    private static class EventInfo {
        private static final ConcurrentLinkedQueue<EventInfo> sPool = new ConcurrentLinkedQueue<>();
        String event;
        Bundle extras;

        private EventInfo() {
        }

        static EventInfo obtain(String str, Bundle bundle) {
            EventInfo poll = sPool.poll();
            if (poll == null) {
                poll = new EventInfo();
            }
            poll.event = str;
            poll.extras = bundle;
            return poll;
        }

        static void recycle(EventInfo eventInfo) {
            if (eventInfo != null) {
                eventInfo.event = null;
                eventInfo.extras = null;
                sPool.offer(eventInfo);
            }
        }
    }
}
