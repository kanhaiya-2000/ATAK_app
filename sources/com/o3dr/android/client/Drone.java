package com.o3dr.android.client;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.o3dr.android.client.apis.MissionApi;
import com.o3dr.android.client.apis.VehicleApi;
import com.o3dr.android.client.interfaces.DroneListener;
import com.o3dr.android.client.interfaces.LinkListener;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.calibration.magnetometer.MagnetometerCalibrationStatus;
import com.o3dr.services.android.lib.drone.companion.solo.SoloAttributes;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.drone.mission.Mission;
import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.drone.property.Altitude;
import com.o3dr.services.android.lib.drone.property.Attitude;
import com.o3dr.services.android.lib.drone.property.Battery;
import com.o3dr.services.android.lib.drone.property.Gps;
import com.o3dr.services.android.lib.drone.property.GuidedState;
import com.o3dr.services.android.lib.drone.property.Home;
import com.o3dr.services.android.lib.drone.property.Parameter;
import com.o3dr.services.android.lib.drone.property.Parameters;
import com.o3dr.services.android.lib.drone.property.Signal;
import com.o3dr.services.android.lib.drone.property.Speed;
import com.o3dr.services.android.lib.drone.property.State;
import com.o3dr.services.android.lib.drone.property.Type;
import com.o3dr.services.android.lib.gcs.follow.FollowState;
import com.o3dr.services.android.lib.gcs.link.LinkEvent;
import com.o3dr.services.android.lib.gcs.returnToMe.ReturnToMeState;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.IDroneApi;
import com.o3dr.services.android.lib.model.IObserver;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class Drone {
    public static final String ACTION_GROUND_COLLISION_IMMINENT;
    private static final String CLAZZ_NAME = "com.o3dr.android.client.Drone";
    public static final double COLLISION_DANGEROUS_SPEED_METERS_PER_SECOND = -3.0d;
    public static final double COLLISION_SAFE_ALTITUDE_METERS = 1.0d;
    public static final int COLLISION_SECONDS_BEFORE_COLLISION = 2;
    public static final String EXTRA_IS_GROUND_COLLISION_IMMINENT = "extra_is_ground_collision_imminent";
    /* access modifiers changed from: private */
    public static final String TAG = "Drone";
    private ExecutorService asyncScheduler;
    private final IBinder.DeathRecipient binderDeathRecipient = new IBinder.DeathRecipient() {
        public void binderDied() {
            Drone.this.notifyDroneServiceInterrupted("Lost access to the drone api.");
        }
    };
    private ConnectionParameter connectionParameter;
    private final Context context;
    private final ClassLoader contextClassLoader;
    private final AtomicReference<IDroneApi> droneApiRef = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public final ConcurrentLinkedQueue<DroneListener> droneListeners = new ConcurrentLinkedQueue<>();
    private DroneObserver droneObserver;
    private long elapsedFlightTime = 0;
    /* access modifiers changed from: private */
    public Handler handler;
    /* access modifiers changed from: private */
    public LinkListener linkListener;
    private ControlTower serviceMgr;
    private long startTime = 0;

    public static class AttributeRetrievedListener<T extends Parcelable> implements OnAttributeRetrievedCallback<T> {
        public void onRetrievalFailed() {
        }

        public void onRetrievalSucceed(T t) {
        }
    }

    public interface OnAttributeRetrievedCallback<T extends Parcelable> {
        void onRetrievalFailed();

        void onRetrievalSucceed(T t);
    }

    public interface OnMissionItemsBuiltCallback<T extends MissionItem> {
        void onMissionItemsBuilt(MissionItem.ComplexItem<T>[] complexItemArr);
    }

    static {
        String name = Drone.class.getName();
        ACTION_GROUND_COLLISION_IMMINENT = name + ".ACTION_GROUND_COLLISION_IMMINENT";
    }

    public Drone(Context context2) {
        this.context = context2;
        this.contextClassLoader = context2.getClassLoader();
    }

    /* access modifiers changed from: package-private */
    public void init(ControlTower controlTower, Handler handler2) {
        this.handler = handler2;
        this.serviceMgr = controlTower;
        this.droneObserver = new DroneObserver(this);
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        throw new java.lang.IllegalStateException("Unable to retrieve a valid drone handle.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void start() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.o3dr.android.client.ControlTower r0 = r4.serviceMgr     // Catch:{ all -> 0x0059 }
            boolean r0 = r0.isTowerConnected()     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0051
            java.util.concurrent.atomic.AtomicReference<com.o3dr.services.android.lib.model.IDroneApi> r0 = r4.droneApiRef     // Catch:{ all -> 0x0059 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0059 }
            com.o3dr.services.android.lib.model.IDroneApi r0 = (com.o3dr.services.android.lib.model.IDroneApi) r0     // Catch:{ all -> 0x0059 }
            boolean r0 = r4.isStarted(r0)     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0019
            monitor-exit(r4)
            return
        L_0x0019:
            com.o3dr.android.client.ControlTower r0 = r4.serviceMgr     // Catch:{ RemoteException -> 0x0049 }
            com.o3dr.services.android.lib.model.IDroneApi r0 = r0.registerDroneApi()     // Catch:{ RemoteException -> 0x0049 }
            android.os.IBinder r1 = r0.asBinder()     // Catch:{ RemoteException -> 0x0049 }
            android.os.IBinder$DeathRecipient r2 = r4.binderDeathRecipient     // Catch:{ RemoteException -> 0x0049 }
            r3 = 0
            r1.linkToDeath(r2, r3)     // Catch:{ RemoteException -> 0x0049 }
            java.util.concurrent.ExecutorService r1 = r4.asyncScheduler     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r1.isShutdown()     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x003a
        L_0x0033:
            r1 = 1
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newFixedThreadPool(r1)     // Catch:{ all -> 0x0059 }
            r4.asyncScheduler = r1     // Catch:{ all -> 0x0059 }
        L_0x003a:
            com.o3dr.android.client.DroneObserver r1 = r4.droneObserver     // Catch:{ all -> 0x0059 }
            r4.addAttributesObserver(r0, r1)     // Catch:{ all -> 0x0059 }
            r4.resetFlightTimer()     // Catch:{ all -> 0x0059 }
            java.util.concurrent.atomic.AtomicReference<com.o3dr.services.android.lib.model.IDroneApi> r1 = r4.droneApiRef     // Catch:{ all -> 0x0059 }
            r1.set(r0)     // Catch:{ all -> 0x0059 }
            monitor-exit(r4)
            return
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "Unable to retrieve a valid drone handle."
            r0.<init>(r1)     // Catch:{ all -> 0x0059 }
            throw r0     // Catch:{ all -> 0x0059 }
        L_0x0051:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "Service manager must be connected."
            r0.<init>(r1)     // Catch:{ all -> 0x0059 }
            throw r0     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.o3dr.android.client.Drone.start():void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void destroy() {
        IDroneApi iDroneApi = this.droneApiRef.get();
        removeAttributesObserver(iDroneApi, this.droneObserver);
        try {
            if (isStarted(iDroneApi)) {
                iDroneApi.asBinder().unlinkToDeath(this.binderDeathRecipient, 0);
                this.serviceMgr.releaseDroneApi(iDroneApi);
            }
        } catch (RemoteException | NoSuchElementException e) {
            Log.e(TAG, e.getMessage(), e);
        }
        ExecutorService executorService = this.asyncScheduler;
        if (executorService != null) {
            executorService.shutdownNow();
            this.asyncScheduler = null;
        }
        this.droneApiRef.set((Object) null);
    }

    private void checkForGroundCollision() {
        Speed speed = (Speed) getAttribute(AttributeType.SPEED);
        Altitude altitude = (Altitude) getAttribute(AttributeType.ALTITUDE);
        if (speed != null && altitude != null) {
            double verticalSpeed = speed.getVerticalSpeed();
            double altitude2 = altitude.getAltitude();
            boolean z = (2.0d * verticalSpeed) + altitude2 < 0.0d && verticalSpeed < -3.0d && altitude2 > 1.0d;
            Bundle bundle = new Bundle(1);
            bundle.putBoolean(EXTRA_IS_GROUND_COLLISION_IMMINENT, z);
            notifyAttributeUpdated(ACTION_GROUND_COLLISION_IMMINENT, bundle);
        }
    }

    private void handleRemoteException(RemoteException remoteException) {
        IDroneApi iDroneApi = this.droneApiRef.get();
        if (iDroneApi != null && !iDroneApi.asBinder().pingBinder()) {
            String message = remoteException.getMessage();
            Log.e(TAG, message, remoteException);
            notifyDroneServiceInterrupted(message);
        }
    }

    public double getSpeedParameter() {
        Parameter parameter;
        Parameters parameters = (Parameters) getAttribute(AttributeType.PARAMETERS);
        if (parameters == null || (parameter = parameters.getParameter("WPNAV_SPEED")) == null) {
            return 0.0d;
        }
        return parameter.getValue();
    }

    public void post(Runnable runnable) {
        Handler handler2 = this.handler;
        if (handler2 != null && runnable != null) {
            handler2.post(runnable);
        }
    }

    public void resetFlightTimer() {
        this.elapsedFlightTime = 0;
        this.startTime = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: private */
    public void stopTimer() {
        this.elapsedFlightTime += SystemClock.elapsedRealtime() - this.startTime;
        this.startTime = SystemClock.elapsedRealtime();
    }

    public long getFlightTime() {
        State state = (State) getAttribute(AttributeType.STATE);
        if (state != null && state.isFlying()) {
            this.elapsedFlightTime += SystemClock.elapsedRealtime() - this.startTime;
            this.startTime = SystemClock.elapsedRealtime();
        }
        return this.elapsedFlightTime / 1000;
    }

    public <T extends Parcelable> T getAttribute(String str) {
        Bundle bundle;
        IDroneApi iDroneApi = this.droneApiRef.get();
        if (!isStarted(iDroneApi) || str == null) {
            return getAttributeDefaultValue(str);
        }
        T t = null;
        try {
            bundle = iDroneApi.getAttribute(str);
        } catch (RemoteException e) {
            handleRemoteException(e);
            bundle = null;
        }
        if (bundle != null) {
            try {
                bundle.setClassLoader(this.contextClassLoader);
                t = bundle.getParcelable(str);
            } catch (Exception e2) {
                Log.e(TAG, e2.getMessage(), e2);
            }
        }
        if (t == null) {
            return getAttributeDefaultValue(str);
        }
        return t;
    }

    public <T extends Parcelable> void getAttributeAsync(final String str, final OnAttributeRetrievedCallback<T> onAttributeRetrievedCallback) {
        if (onAttributeRetrievedCallback == null) {
            throw new IllegalArgumentException("Callback must be non-null.");
        } else if (!isStarted(this.droneApiRef.get())) {
            this.handler.post(new Runnable() {
                public void run() {
                    onAttributeRetrievedCallback.onRetrievalFailed();
                }
            });
        } else {
            this.asyncScheduler.execute(new Runnable() {
                public void run() {
                    final Parcelable attribute = Drone.this.getAttribute(str);
                    Drone.this.handler.post(new Runnable() {
                        public void run() {
                            if (attribute == null) {
                                onAttributeRetrievedCallback.onRetrievalFailed();
                            } else {
                                onAttributeRetrievedCallback.onRetrievalSucceed(attribute);
                            }
                        }
                    });
                }
            });
        }
    }

    private <T extends Parcelable> T getAttributeDefaultValue(String str) {
        if (str == null) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1711199360:
                if (str.equals(AttributeType.CAMERA)) {
                    c = 15;
                    break;
                }
                break;
            case -1702552468:
                if (str.equals(AttributeType.SPEED)) {
                    c = 4;
                    break;
                }
                break;
            case -1702436682:
                if (str.equals(AttributeType.STATE)) {
                    c = 2;
                    break;
                }
                break;
            case -1614425999:
                if (str.equals(SoloAttributes.SOLO_STATE)) {
                    c = 16;
                    break;
                }
                break;
            case -1598946243:
                if (str.equals(AttributeType.ALTITUDE)) {
                    c = 0;
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
                    c = 9;
                    break;
                }
                break;
            case -998663554:
                if (str.equals(AttributeType.FOLLOW_STATE)) {
                    c = 12;
                    break;
                }
                break;
            case -987487119:
                if (str.equals(AttributeType.MISSION)) {
                    c = 8;
                    break;
                }
                break;
            case -835416121:
                if (str.equals(AttributeType.MAGNETOMETER_CALIBRATION_STATUS)) {
                    c = 13;
                    break;
                }
                break;
            case -828014987:
                if (str.equals(AttributeType.GUIDED_STATE)) {
                    c = 10;
                    break;
                }
                break;
            case -699501670:
                if (str.equals(AttributeType.RETURN_TO_ME_STATE)) {
                    c = 14;
                    break;
                }
                break;
            case -430574716:
                if (str.equals(SoloAttributes.SOLO_GOPRO_STATE_V2)) {
                    c = 18;
                    break;
                }
                break;
            case 744584719:
                if (str.equals(AttributeType.GPS)) {
                    c = 1;
                    break;
                }
                break;
            case 968230999:
                if (str.equals(SoloAttributes.SOLO_GOPRO_STATE)) {
                    c = 17;
                    break;
                }
                break;
            case 1206115909:
                if (str.equals(AttributeType.ATTITUDE)) {
                    c = 5;
                    break;
                }
                break;
            case 1607318522:
                if (str.equals(AttributeType.HOME)) {
                    c = 6;
                    break;
                }
                break;
            case 1607685717:
                if (str.equals(AttributeType.TYPE)) {
                    c = 11;
                    break;
                }
                break;
            case 1906790642:
                if (str.equals(AttributeType.BATTERY)) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new Altitude();
            case 1:
                return new Gps();
            case 2:
                return new State();
            case 3:
                return new Parameters();
            case 4:
                return new Speed();
            case 5:
                return new Attitude();
            case 6:
                return new Home();
            case 7:
                return new Battery();
            case 8:
                return new Mission();
            case 9:
                return new Signal();
            case 10:
                return new GuidedState();
            case 11:
                return new Type();
            case 12:
                return new FollowState();
            case 13:
                return new MagnetometerCalibrationStatus();
            case 14:
                return new ReturnToMeState();
            default:
                return null;
        }
    }

    public void connect(ConnectionParameter connectionParameter2) {
        connect(connectionParameter2, (LinkListener) null);
    }

    public void connect(ConnectionParameter connectionParameter2, LinkListener linkListener2) {
        VehicleApi.getApi(this).connect(connectionParameter2);
        this.connectionParameter = connectionParameter2;
        this.linkListener = linkListener2;
    }

    public void disconnect() {
        VehicleApi.getApi(this).disconnect();
        this.connectionParameter = null;
        this.linkListener = null;
    }

    private static AbstractCommandListener wrapListener(final Handler handler2, final AbstractCommandListener abstractCommandListener) {
        return (handler2 == null || abstractCommandListener == null) ? abstractCommandListener : new AbstractCommandListener() {
            public void onSuccess() {
                handler2.post(new Runnable() {
                    public void run() {
                        abstractCommandListener.onSuccess();
                    }
                });
            }

            public void onError(final int i) {
                handler2.post(new Runnable() {
                    public void run() {
                        abstractCommandListener.onError(i);
                    }
                });
            }

            public void onTimeout() {
                handler2.post(new Runnable() {
                    public void run() {
                        abstractCommandListener.onTimeout();
                    }
                });
            }
        };
    }

    public boolean performAction(Action action) {
        return performActionOnDroneThread(action, (AbstractCommandListener) null);
    }

    public boolean performActionOnDroneThread(Action action, AbstractCommandListener abstractCommandListener) {
        return performActionOnHandler(action, this.handler, abstractCommandListener);
    }

    public boolean performActionOnHandler(Action action, Handler handler2, AbstractCommandListener abstractCommandListener) {
        IDroneApi iDroneApi = this.droneApiRef.get();
        if (!isStarted(iDroneApi)) {
            return false;
        }
        try {
            iDroneApi.executeAction(action, wrapListener(handler2, abstractCommandListener));
            return true;
        } catch (RemoteException e) {
            handleRemoteException(e);
            return false;
        }
    }

    public boolean performAsyncAction(Action action) {
        return performAsyncActionOnDroneThread(action, (AbstractCommandListener) null);
    }

    public boolean performAsyncActionOnDroneThread(Action action, AbstractCommandListener abstractCommandListener) {
        return performAsyncActionOnHandler(action, this.handler, abstractCommandListener);
    }

    public boolean performAsyncActionOnHandler(Action action, Handler handler2, AbstractCommandListener abstractCommandListener) {
        IDroneApi iDroneApi = this.droneApiRef.get();
        if (!isStarted(iDroneApi)) {
            return false;
        }
        try {
            iDroneApi.executeAsyncAction(action, wrapListener(handler2, abstractCommandListener));
            return true;
        } catch (RemoteException e) {
            handleRemoteException(e);
            return false;
        }
    }

    private boolean isStarted(IDroneApi iDroneApi) {
        return iDroneApi != null && iDroneApi.asBinder().pingBinder();
    }

    public boolean isStarted() {
        return isStarted(this.droneApiRef.get());
    }

    public boolean isConnected() {
        return isStarted(this.droneApiRef.get()) && ((State) getAttribute(AttributeType.STATE)).isConnected();
    }

    public ConnectionParameter getConnectionParameter() {
        return this.connectionParameter;
    }

    public <T extends MissionItem> void buildMissionItemsAsync(final MissionItem.ComplexItem<T>[] complexItemArr, final OnMissionItemsBuiltCallback<T> onMissionItemsBuiltCallback) {
        if (onMissionItemsBuiltCallback == null) {
            throw new IllegalArgumentException("Callback must be non-null.");
        } else if (complexItemArr != null && complexItemArr.length != 0) {
            this.asyncScheduler.execute(new Runnable() {
                public void run() {
                    for (MissionItem.ComplexItem buildMissionItem : complexItemArr) {
                        MissionApi.getApi(Drone.this).buildMissionItem(buildMissionItem);
                    }
                    Drone.this.handler.post(new Runnable() {
                        public void run() {
                            onMissionItemsBuiltCallback.onMissionItemsBuilt(complexItemArr);
                        }
                    });
                }
            });
        }
    }

    public void registerDroneListener(DroneListener droneListener) {
        if (droneListener != null && !this.droneListeners.contains(droneListener)) {
            this.droneListeners.add(droneListener);
        }
    }

    private void addAttributesObserver(IDroneApi iDroneApi, IObserver iObserver) {
        if (isStarted(iDroneApi)) {
            try {
                iDroneApi.addAttributesObserver(iObserver);
            } catch (RemoteException e) {
                handleRemoteException(e);
            }
        }
    }

    public void addMavlinkObserver(MavlinkObserver mavlinkObserver) {
        IDroneApi iDroneApi = this.droneApiRef.get();
        if (isStarted(iDroneApi)) {
            try {
                iDroneApi.addMavlinkObserver(mavlinkObserver);
            } catch (RemoteException e) {
                handleRemoteException(e);
            }
        }
    }

    public void removeMavlinkObserver(MavlinkObserver mavlinkObserver) {
        IDroneApi iDroneApi = this.droneApiRef.get();
        if (isStarted(iDroneApi)) {
            try {
                iDroneApi.removeMavlinkObserver(mavlinkObserver);
            } catch (RemoteException e) {
                handleRemoteException(e);
            }
        }
    }

    public void unregisterDroneListener(DroneListener droneListener) {
        if (droneListener != null) {
            this.droneListeners.remove(droneListener);
        }
    }

    private void removeAttributesObserver(IDroneApi iDroneApi, IObserver iObserver) {
        if (isStarted(iDroneApi)) {
            try {
                iDroneApi.removeAttributesObserver(iObserver);
            } catch (RemoteException e) {
                handleRemoteException(e);
            }
        }
    }

    public Handler getHandler() {
        return this.handler;
    }

    public ExecutorService getAsyncScheduler() {
        return this.asyncScheduler;
    }

    /* access modifiers changed from: package-private */
    public void notifyAttributeUpdated(String str, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.contextClassLoader);
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -729272240:
                if (str.equals(LinkEvent.LINK_STATE_UPDATED)) {
                    c = 0;
                    break;
                }
                break;
            case -286151170:
                if (str.equals(AttributeEvent.STATE_UPDATED)) {
                    c = 1;
                    break;
                }
                break;
            case 1059836852:
                if (str.equals(AttributeEvent.SPEED_UPDATED)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                sendLinkEventToListener(bundle);
                return;
            case 1:
                getAttributeAsync(AttributeType.STATE, new OnAttributeRetrievedCallback<State>() {
                    public void onRetrievalSucceed(State state) {
                        if (state.isFlying()) {
                            Drone.this.resetFlightTimer();
                        } else {
                            Drone.this.stopTimer();
                        }
                    }

                    public void onRetrievalFailed() {
                        Drone.this.stopTimer();
                    }
                });
                break;
            case 2:
                checkForGroundCollision();
                break;
        }
        sendDroneEventToListeners(str, bundle);
    }

    private void sendDroneEventToListeners(final String str, final Bundle bundle) {
        if (!this.droneListeners.isEmpty()) {
            this.handler.post(new Runnable() {
                public void run() {
                    Iterator it = Drone.this.droneListeners.iterator();
                    while (it.hasNext()) {
                        try {
                            ((DroneListener) it.next()).onDroneEvent(str, bundle);
                        } catch (Exception e) {
                            Log.e(Drone.TAG, e.getMessage(), e);
                        }
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r3 = (com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus) r3.getParcelable(com.o3dr.services.android.lib.gcs.link.LinkEventExtra.EXTRA_CONNECTION_STATUS);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendLinkEventToListener(android.os.Bundle r3) {
        /*
            r2 = this;
            com.o3dr.android.client.interfaces.LinkListener r0 = r2.linkListener
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            if (r3 == 0) goto L_0x001b
            java.lang.String r0 = "com.o3dr.services.android.lib.gcs.link.event.extra.CONNECTION_STATUS"
            android.os.Parcelable r3 = r3.getParcelable(r0)
            com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus r3 = (com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus) r3
            if (r3 == 0) goto L_0x001b
            android.os.Handler r0 = r2.handler
            com.o3dr.android.client.Drone$8 r1 = new com.o3dr.android.client.Drone$8
            r1.<init>(r3)
            r0.post(r1)
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.o3dr.android.client.Drone.sendLinkEventToListener(android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    public void notifyDroneServiceInterrupted(final String str) {
        if (!this.droneListeners.isEmpty()) {
            this.handler.post(new Runnable() {
                public void run() {
                    Iterator it = Drone.this.droneListeners.iterator();
                    while (it.hasNext()) {
                        ((DroneListener) it.next()).onDroneServiceInterrupted(str);
                    }
                }
            });
        }
    }
}
