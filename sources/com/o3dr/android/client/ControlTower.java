package com.o3dr.android.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.o3dr.android.client.interfaces.TowerListener;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.model.IDroidPlannerServices;
import com.o3dr.services.android.lib.model.IDroneApi;
import java.util.concurrent.atomic.AtomicBoolean;

public class ControlTower {
    private static final String TAG = "ControlTower";
    private final DroneApiListener apiListener;
    /* access modifiers changed from: private */
    public final IBinder.DeathRecipient binderDeathRecipient = new IBinder.DeathRecipient() {
        public void binderDied() {
            ControlTower.this.notifyTowerDisconnected();
        }
    };
    private final Context context;
    /* access modifiers changed from: private */
    public final AtomicBoolean isServiceConnecting = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public IDroidPlannerServices o3drServices;
    private final ServiceConnection o3drServicesConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ControlTower.this.isServiceConnecting.set(false);
            IDroidPlannerServices unused = ControlTower.this.o3drServices = IDroidPlannerServices.Stub.asInterface(iBinder);
            try {
                ControlTower.this.o3drServices.asBinder().linkToDeath(ControlTower.this.binderDeathRecipient, 0);
                ControlTower.this.notifyTowerConnected();
            } catch (RemoteException unused2) {
                ControlTower.this.notifyTowerDisconnected();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ControlTower.this.isServiceConnecting.set(false);
            ControlTower.this.notifyTowerDisconnected();
        }
    };
    private TowerListener towerListener;

    public ControlTower(Context context2) {
        this.context = context2;
        this.apiListener = new DroneApiListener(context2);
    }

    public boolean isTowerConnected() {
        IDroidPlannerServices iDroidPlannerServices = this.o3drServices;
        return iDroidPlannerServices != null && iDroidPlannerServices.asBinder().pingBinder();
    }

    /* access modifiers changed from: package-private */
    public void notifyTowerConnected() {
        TowerListener towerListener2 = this.towerListener;
        if (towerListener2 != null) {
            towerListener2.onTowerConnected();
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyTowerDisconnected() {
        TowerListener towerListener2 = this.towerListener;
        if (towerListener2 != null) {
            towerListener2.onTowerDisconnected();
        }
    }

    public Bundle[] getConnectedApps() {
        Bundle[] bundleArr = new Bundle[0];
        if (isTowerConnected()) {
            try {
                bundleArr = this.o3drServices.getConnectedApps(getApplicationId());
                if (bundleArr != null) {
                    ClassLoader classLoader = ConnectionParameter.class.getClassLoader();
                    for (Bundle classLoader2 : bundleArr) {
                        classLoader2.setClassLoader(classLoader);
                    }
                }
            } catch (RemoteException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
        return bundleArr;
    }

    public void registerDrone(Drone drone, Handler handler) {
        if (drone != null) {
            if (isTowerConnected()) {
                drone.init(this, handler);
                drone.start();
                return;
            }
            throw new IllegalStateException("Control Tower must be connected.");
        }
    }

    public void unregisterDrone(Drone drone) {
        if (drone != null) {
            drone.destroy();
        }
    }

    public void connect(TowerListener towerListener2) {
        if (this.towerListener != null && (this.isServiceConnecting.get() || isTowerConnected())) {
            return;
        }
        if (towerListener2 != null) {
            this.towerListener = towerListener2;
            if (!isTowerConnected() && !this.isServiceConnecting.get()) {
                this.isServiceConnecting.set(this.context.bindService(ApiAvailability.getInstance().getAvailableServicesInstance(this.context), this.o3drServicesConnection, 1));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ServiceListener argument cannot be null.");
    }

    public void disconnect() {
        IDroidPlannerServices iDroidPlannerServices = this.o3drServices;
        if (iDroidPlannerServices != null) {
            iDroidPlannerServices.asBinder().unlinkToDeath(this.binderDeathRecipient, 0);
            this.o3drServices = null;
        }
        notifyTowerDisconnected();
        this.towerListener = null;
        try {
            this.context.unbindService(this.o3drServicesConnection);
        } catch (Exception unused) {
            Log.e(TAG, "Error occurred while unbinding from DroneKit-Android.");
        }
    }

    /* access modifiers changed from: package-private */
    public IDroneApi registerDroneApi() {
        return this.o3drServices.registerDroneApi(this.apiListener, getApplicationId());
    }

    /* access modifiers changed from: package-private */
    public void releaseDroneApi(IDroneApi iDroneApi) {
        this.o3drServices.releaseDroneApi(iDroneApi);
    }

    private String getApplicationId() {
        return this.context.getPackageName();
    }
}
