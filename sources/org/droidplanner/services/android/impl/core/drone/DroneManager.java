package org.droidplanner.services.android.impl.core.drone;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.o3dr.services.android.lib.drone.action.ControlActions;
import com.o3dr.services.android.lib.drone.action.GimbalActions;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import com.o3dr.services.android.lib.drone.property.Parameter;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.ConcurrentHashMap;
import org.droidplanner.services.android.impl.api.DroneApi;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.autopilot.Drone;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.ArduSolo;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.SoloComp;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.utils.CommonApiUtils;

public class DroneManager<T extends Drone, D> implements DataLink.DataLinkListener<D>, DroneInterfaces.AttributeEventListener, DroneInterfaces.OnDroneListener, DroneInterfaces.OnParameterManagerListener, LogMessageListener {
    public static final String EXTRA_CLIENT_APP_ID = "extra_client_app_id";
    private static final String TAG = "DroneManager";
    protected final ConcurrentHashMap<String, DroneApi> connectedApps = new ConcurrentHashMap<>();
    protected final ConnectionParameter connectionParameter;
    protected final Context context;
    protected T drone;
    protected final Handler handler;

    /* access modifiers changed from: protected */
    public void doConnect(String str, DroneApi droneApi, ConnectionParameter connectionParameter2) {
    }

    public void notifyReceivedData(D d) {
    }

    public static DroneManager generateDroneManager(Context context2, ConnectionParameter connectionParameter2, Handler handler2) {
        connectionParameter2.getConnectionType();
        return new MavLinkDroneManager(context2, connectionParameter2, handler2);
    }

    protected DroneManager(Context context2, ConnectionParameter connectionParameter2, Handler handler2) {
        this.context = context2;
        this.handler = handler2;
        this.connectionParameter = connectionParameter2;
    }

    private void destroyAutopilot() {
        T t = this.drone;
        if (t != null) {
            t.destroy();
            this.drone = null;
        }
    }

    public void destroy() {
        Log.d(TAG, "Destroying drone manager.");
        disconnect();
        destroyAutopilot();
        this.connectedApps.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void connect(java.lang.String r2, org.droidplanner.services.android.impl.api.DroneApi r3, com.o3dr.services.android.lib.drone.connection.ConnectionParameter r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 == 0) goto L_0x0017
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0017
        L_0x000a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, org.droidplanner.services.android.impl.api.DroneApi> r0 = r1.connectedApps     // Catch:{ all -> 0x0014 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0014 }
            r1.doConnect(r2, r3, r4)     // Catch:{ all -> 0x0014 }
            monitor-exit(r1)
            return
        L_0x0014:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0017:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.DroneManager.connect(java.lang.String, org.droidplanner.services.android.impl.api.DroneApi, com.o3dr.services.android.lib.drone.connection.ConnectionParameter):void");
    }

    private void disconnect() {
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi clientInfo : this.connectedApps.values()) {
                disconnect(clientInfo.getClientInfo());
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isCompanionComputerEnabled() {
        int connectionType = this.connectionParameter.getConnectionType();
        if (this.drone instanceof ArduSolo) {
            return true;
        }
        if ((connectionType != 1 || !SoloComp.isAvailable(this.context)) && connectionType != 101) {
            return false;
        }
        return true;
    }

    public int getConnectedAppsCount() {
        return this.connectedApps.size();
    }

    public void disconnect(DroneApi.ClientInfo clientInfo) {
        String str = clientInfo.appId;
        if (!TextUtils.isEmpty(str)) {
            String str2 = TAG;
            Log.d(str2, "Disconnecting client " + str);
            doDisconnect(str, this.connectedApps.remove(str));
        }
    }

    /* access modifiers changed from: protected */
    public void doDisconnect(String str, DroneApi droneApi) {
        if (isConnected() && droneApi != null) {
            droneApi.onDroneEvent(DroneInterfaces.DroneEventsType.DISCONNECTED, this.drone);
        }
        if (this.connectedApps.isEmpty()) {
            executeAsyncAction((DroneApi.ClientInfo) null, new Action(GimbalActions.ACTION_RESET_GIMBAL_MOUNT_MODE), (ICommandListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public void notifyDroneEvent(DroneInterfaces.DroneEventsType droneEventsType) {
        T t = this.drone;
        if (t != null) {
            t.notifyDroneEvent(droneEventsType);
        }
    }

    public void onConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
        String statusCode = linkConnectionStatus.getStatusCode();
        statusCode.hashCode();
        if (statusCode.equals(LinkConnectionStatus.CONNECTING)) {
            notifyDroneEvent(DroneInterfaces.DroneEventsType.CONNECTING);
        } else if (statusCode.equals(LinkConnectionStatus.DISCONNECTED)) {
            notifyDroneEvent(DroneInterfaces.DroneEventsType.DISCONNECTED);
        }
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onConnectionStatus : this.connectedApps.values()) {
                onConnectionStatus.onConnectionStatus(linkConnectionStatus);
            }
        }
    }

    public T getDrone() {
        return this.drone;
    }

    public boolean isConnected() {
        T t = this.drone;
        return t != null && t.isConnected();
    }

    public DroneAttribute getAttribute(DroneApi.ClientInfo clientInfo, String str) {
        str.hashCode();
        T t = this.drone;
        if (t == null) {
            return null;
        }
        return t.getAttribute(str);
    }

    /* access modifiers changed from: protected */
    public boolean executeAsyncAction(Action action, ICommandListener iCommandListener) {
        String type = action.getType();
        type.hashCode();
        if (!type.equals(ControlActions.ACTION_ENABLE_MANUAL_CONTROL)) {
            T t = this.drone;
            if (t != null) {
                return t.executeAsyncAction(action, iCommandListener);
            }
            CommonApiUtils.postErrorEvent(4, iCommandListener);
            return true;
        }
        T t2 = this.drone;
        if (t2 != null) {
            t2.executeAsyncAction(action, iCommandListener);
        } else {
            CommonApiUtils.postErrorEvent(4, iCommandListener);
        }
        return true;
    }

    public boolean executeAsyncAction(DroneApi.ClientInfo clientInfo, Action action, ICommandListener iCommandListener) {
        String type = action.getType();
        Bundle data = action.getData();
        type.hashCode();
        if (type.equals(ControlActions.ACTION_ENABLE_MANUAL_CONTROL)) {
            data.putString(EXTRA_CLIENT_APP_ID, clientInfo.appId);
        }
        return executeAsyncAction(action, iCommandListener);
    }

    /* access modifiers changed from: protected */
    public void notifyDroneAttributeEvent(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && !this.connectedApps.isEmpty()) {
            for (DroneApi onAttributeEvent : this.connectedApps.values()) {
                onAttributeEvent.onAttributeEvent(str, bundle);
            }
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.DroneManager$1 */
    /* synthetic */ class C59311 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8620x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r0 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8620x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8620x7e1461ff     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.DroneManager.C59311.<clinit>():void");
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, Drone drone2) {
        int i = C59311.f8620x7e1461ff[droneEventsType.ordinal()];
        if (i == 1 || i == 2) {
            droneEventsType = DroneInterfaces.DroneEventsType.CONNECTED;
        }
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onDroneEvent : this.connectedApps.values()) {
                onDroneEvent.onDroneEvent(droneEventsType, drone2);
            }
        }
    }

    public void onBeginReceivingParameters() {
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onBeginReceivingParameters : this.connectedApps.values()) {
                onBeginReceivingParameters.onBeginReceivingParameters();
            }
        }
    }

    public void onParameterReceived(Parameter parameter, int i, int i2) {
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onParameterReceived : this.connectedApps.values()) {
                onParameterReceived.onParameterReceived(parameter, i, i2);
            }
        }
    }

    public void onEndReceivingParameters() {
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onEndReceivingParameters : this.connectedApps.values()) {
                onEndReceivingParameters.onEndReceivingParameters();
            }
        }
    }

    public ConnectionParameter getConnectionParameter() {
        return this.connectionParameter;
    }

    public void onMessageLogged(int i, String str) {
        if (!this.connectedApps.isEmpty()) {
            for (DroneApi onMessageLogged : this.connectedApps.values()) {
                onMessageLogged.onMessageLogged(i, str);
            }
        }
    }

    public void onAttributeEvent(String str, Bundle bundle) {
        notifyDroneAttributeEvent(str, bundle);
    }
}
