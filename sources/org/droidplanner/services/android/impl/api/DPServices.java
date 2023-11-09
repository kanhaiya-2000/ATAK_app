package org.droidplanner.services.android.impl.api;

import android.os.Bundle;
import android.util.Log;
import com.o3dr.android.client.BuildConfig;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.gcs.event.GCSEvent;
import com.o3dr.services.android.lib.model.IApiListener;
import com.o3dr.services.android.lib.model.IDroidPlannerServices;
import com.o3dr.services.android.lib.model.IDroneApi;
import com.o3dr.services.android.lib.util.version.VersionUtils;
import java.util.ArrayList;

final class DPServices extends IDroidPlannerServices.Stub {
    private static final String TAG = "DPServices";
    private DroidPlannerService serviceRef;

    public int getServiceVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    DPServices(DroidPlannerService droidPlannerService) {
        this.serviceRef = droidPlannerService;
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        this.serviceRef = null;
    }

    public int getApiVersionCode() {
        return VersionUtils.getCoreLibVersion(this.serviceRef.getApplicationContext());
    }

    public IDroneApi registerDroneApi(IApiListener iApiListener, String str) {
        return this.serviceRef.registerDroneApi(iApiListener, str);
    }

    public Bundle[] getConnectedApps(String str) {
        String str2 = TAG;
        Log.d(str2, "List of connected apps request from " + str);
        ArrayList arrayList = new ArrayList();
        for (DroneApi next : this.serviceRef.droneApiStore.values()) {
            if (next.isConnected() && next.getDroneManager() != null) {
                ConnectionParameter clone = next.getDroneManager().getConnectionParameter().clone();
                Bundle bundle = new Bundle();
                bundle.putString(GCSEvent.EXTRA_APP_ID, next.getOwnerId());
                bundle.putParcelable(GCSEvent.EXTRA_VEHICLE_CONNECTION_PARAMETER, clone);
                arrayList.add(bundle);
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public void releaseDroneApi(IDroneApi iDroneApi) {
        Log.d(TAG, "Releasing acquired drone api handle.");
        if (iDroneApi instanceof DroneApi) {
            this.serviceRef.releaseDroneApi(((DroneApi) iDroneApi).getOwnerId());
        }
    }
}
