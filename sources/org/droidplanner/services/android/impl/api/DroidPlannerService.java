package org.droidplanner.services.android.impl.api;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import atakplugin.UASTool.cqb;
import com.o3dr.android.client.C5729R;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.drone.mission.item.complex.CameraDetail;
import com.o3dr.services.android.lib.model.IApiListener;
import com.o3dr.services.android.lib.model.IDroidPlannerServices;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.droidplanner.services.android.impl.api.DroneApi;
import org.droidplanner.services.android.impl.core.drone.DroneManager;
import org.droidplanner.services.android.impl.core.survey.CameraInfo;
import org.droidplanner.services.android.impl.utils.file.p013IO.CameraInfoLoader;

public class DroidPlannerService extends Service {
    public static final String ACTION_DRONE_CREATED = "org.droidplanner.services.android.ACTION_DRONE_CREATED";
    public static final String ACTION_DRONE_DESTROYED = "org.droidplanner.services.android.ACTION_DRONE_DESTROYED";
    public static final String ACTION_RELEASE_API_INSTANCE = "org.droidplanner.services.android.action.RELEASE_API_INSTANCE";
    public static final String EXTRA_API_INSTANCE_APP_ID = "extra_api_instance_app_id";
    private static final int FOREGROUND_ID = 101;
    private List<CameraDetail> cachedCameraDetails;
    private CameraInfoLoader cameraInfoLoader;
    private DPServices dpServices;
    final ConcurrentHashMap<String, DroneApi> droneApiStore = new ConcurrentHashMap<>();
    final ConcurrentHashMap<ConnectionParameter, DroneManager> droneManagers = new ConcurrentHashMap<>();
    private LocalBroadcastManager lbm;

    /* access modifiers changed from: package-private */
    public DroneApi registerDroneApi(IApiListener iApiListener, String str) {
        if (iApiListener == null) {
            return null;
        }
        DroneApi droneApi = new DroneApi(this, iApiListener, str);
        this.droneApiStore.put(str, droneApi);
        this.lbm.sendBroadcast(new Intent(ACTION_DRONE_CREATED));
        updateForegroundNotification();
        return droneApi;
    }

    /* access modifiers changed from: package-private */
    public void releaseDroneApi(String str) {
        DroneApi remove;
        if (str != null && (remove = this.droneApiStore.remove(str)) != null) {
            cqb.m12007b("Releasing drone api instance for " + str, new Object[0]);
            remove.destroy();
            this.lbm.sendBroadcast(new Intent(ACTION_DRONE_DESTROYED));
            updateForegroundNotification();
        }
    }

    /* access modifiers changed from: package-private */
    public DroneManager connectDroneManager(ConnectionParameter connectionParameter, String str, DroneApi droneApi) {
        if (connectionParameter == null || TextUtils.isEmpty(str) || droneApi == null) {
            return null;
        }
        DroneManager droneManager = this.droneManagers.get(connectionParameter);
        if (droneManager == null) {
            droneManager = DroneManager.generateDroneManager(getApplicationContext(), connectionParameter, new Handler(Looper.getMainLooper()));
            DroneManager putIfAbsent = this.droneManagers.putIfAbsent(connectionParameter, droneManager);
            if (putIfAbsent == null) {
                cqb.m12007b("Generating new drone manager.", new Object[0]);
            } else {
                droneManager.destroy();
                droneManager = putIfAbsent;
            }
        }
        cqb.m12007b("Drone manager connection for " + str, new Object[0]);
        droneManager.connect(str, droneApi, connectionParameter);
        return droneManager;
    }

    /* access modifiers changed from: package-private */
    public void disconnectDroneManager(DroneManager droneManager, DroneApi.ClientInfo clientInfo) {
        if (droneManager != null && clientInfo != null && !TextUtils.isEmpty(clientInfo.appId)) {
            String str = clientInfo.appId;
            cqb.m12007b("Drone manager disconnection for " + str, new Object[0]);
            droneManager.disconnect(clientInfo);
            if (droneManager.getConnectedAppsCount() == 0) {
                cqb.m12007b("Destroying drone manager.", new Object[0]);
                droneManager.destroy();
                this.droneManagers.remove(droneManager.getConnectionParameter());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized List<CameraDetail> getCameraDetails() {
        List<CameraDetail> list;
        synchronized (this) {
            if (this.cachedCameraDetails == null) {
                List<String> cameraInfoList = this.cameraInfoLoader.getCameraInfoList();
                ArrayList arrayList = new ArrayList(cameraInfoList.size());
                for (String openFile : cameraInfoList) {
                    try {
                        arrayList.add(this.cameraInfoLoader.openFile(openFile));
                    } catch (Exception e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    CameraInfo cameraInfo = (CameraInfo) it.next();
                    Iterator it2 = it;
                    CameraDetail cameraDetail = r4;
                    CameraDetail cameraDetail2 = new CameraDetail(cameraInfo.name, cameraInfo.sensorWidth.doubleValue(), cameraInfo.sensorHeight.doubleValue(), cameraInfo.sensorResolution.doubleValue(), cameraInfo.focalLength.doubleValue(), cameraInfo.overlap.doubleValue(), cameraInfo.sidelap.doubleValue(), cameraInfo.isInLandscapeOrientation);
                    arrayList2.add(cameraDetail);
                    it = it2;
                }
                this.cachedCameraDetails = arrayList2;
            }
            list = this.cachedCameraDetails;
        }
        return list;
    }

    public IBinder onBind(Intent intent) {
        cqb.m12007b("Binding intent: " + intent, new Object[0]);
        if (IDroidPlannerServices.class.getName().equals(intent.getAction())) {
            return this.dpServices;
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        cqb.m12007b("Creating DroneKit-Android.", new Object[0]);
        Context applicationContext = getApplicationContext();
        this.dpServices = new DPServices(this);
        this.lbm = LocalBroadcastManager.getInstance(applicationContext);
        this.cameraInfoLoader = new CameraInfoLoader(applicationContext);
        updateForegroundNotification();
    }

    private void updateForegroundNotification() {
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(getApplicationContext()).setContentTitle("DroneKit-Android").setPriority(-2).setSmallIcon(C5729R.drawable.ic_stat_notify);
        int size = this.droneApiStore.size();
        if (size > 1) {
            smallIcon.setContentText(size + " connected apps");
        }
        startForeground(101, smallIcon.build());
    }

    public void onDestroy() {
        super.onDestroy();
        cqb.m12007b("Destroying DroneKit-Android.", new Object[0]);
        for (DroneApi destroy : this.droneApiStore.values()) {
            destroy.destroy();
        }
        this.droneApiStore.clear();
        for (DroneManager destroy2 : this.droneManagers.values()) {
            destroy2.destroy();
        }
        this.droneManagers.clear();
        this.dpServices.destroy();
        stopForeground(true);
        enableDroidPlannerService(getApplicationContext(), false);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String action = intent.getAction();
            action.hashCode();
            if (action.equals(ACTION_RELEASE_API_INSTANCE)) {
                releaseDroneApi(intent.getStringExtra(EXTRA_API_INSTANCE_APP_ID));
            }
        }
        stopSelf();
        return 2;
    }

    public static void enableDroidPlannerService(Context context, boolean z) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, DroidPlannerService.class), z ? 1 : 2, 1);
    }
}
