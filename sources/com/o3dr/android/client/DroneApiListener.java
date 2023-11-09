package com.o3dr.android.client;

import android.content.Context;
import com.o3dr.services.android.lib.drone.connection.ConnectionResult;
import com.o3dr.services.android.lib.model.IApiListener;
import com.o3dr.services.android.lib.util.version.VersionUtils;

public class DroneApiListener extends IApiListener.Stub {
    private final Context context;

    public int getClientVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public DroneApiListener(Context context2) {
        this.context = context2;
    }

    public int getApiVersionCode() {
        return VersionUtils.getCoreLibVersion(this.context);
    }
}
