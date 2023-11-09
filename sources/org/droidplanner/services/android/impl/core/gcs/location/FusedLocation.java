package org.droidplanner.services.android.impl.core.gcs.location;

import android.content.Context;
import android.os.Handler;
import atakplugin.UASTool.cqb;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.o3dr.services.android.lib.util.googleApi.GoogleApiClientManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.droidplanner.services.android.impl.core.gcs.follow.LocationRelay;
import org.droidplanner.services.android.impl.core.gcs.location.Location;

public class FusedLocation extends LocationCallback implements GoogleApiClientManager.ManagerListener, Location.LocationFinder {
    private static final float MIN_DISTANCE_M = 0.0f;
    private static final long MIN_TIME_MS = 16;
    private static final String TAG = "FusedLocation";
    private static final Api<? extends Api.ApiOptions.NotRequiredOptions>[] apisList = {LocationServices.API};
    private final Context context;
    private final GoogleApiClientManager gApiMgr;
    private final LocationRelay locationRelay;
    private boolean mLocationUpdatesEnabled;
    private final Map<String, Location.LocationReceiver> receivers;
    private final GoogleApiClientManager.GoogleApiClientTask removeLocationUpdate;
    private final GoogleApiClientManager.GoogleApiClientTask requestLocationUpdate;

    public void onManagerStopped() {
    }

    public FusedLocation(Context context2, Handler handler) {
        this(context2, handler, 100, MIN_TIME_MS, MIN_TIME_MS, 0.0f);
    }

    public FusedLocation(Context context2, Handler handler, int i, long j, long j2, float f) {
        this.mLocationUpdatesEnabled = false;
        this.removeLocationUpdate = new GoogleApiClientManager.GoogleApiClientTask() {
            /* access modifiers changed from: protected */
            public void doRun() {
                LocationServices.FusedLocationApi.removeLocationUpdates(getGoogleApiClient(), FusedLocation.this);
            }
        };
        this.receivers = new ConcurrentHashMap();
        this.context = context2;
        this.locationRelay = new LocationRelay();
        final int i2 = i;
        final long j3 = j;
        final long j4 = j2;
        final float f2 = f;
        final Handler handler2 = handler;
        this.requestLocationUpdate = new GoogleApiClientManager.GoogleApiClientTask() {
            /* access modifiers changed from: protected */
            public void doRun() {
                LocationRequest create = LocationRequest.create();
                create.setPriority(i2);
                create.setInterval(j3);
                create.setFastestInterval(j4);
                create.setSmallestDisplacement(f2);
                LocationServices.FusedLocationApi.requestLocationUpdates(getGoogleApiClient(), create, FusedLocation.this, handler2.getLooper());
            }
        };
        Handler handler3 = handler;
        GoogleApiClientManager googleApiClientManager = new GoogleApiClientManager(context2, handler, apisList);
        this.gApiMgr = googleApiClientManager;
        googleApiClientManager.setManagerListener(this);
    }

    public void enableLocationUpdates(String str, Location.LocationReceiver locationReceiver) {
        this.receivers.put(str, locationReceiver);
        if (!this.mLocationUpdatesEnabled) {
            this.gApiMgr.start();
            this.locationRelay.onFollowStart();
            this.mLocationUpdatesEnabled = true;
        }
    }

    public void disableLocationUpdates(String str) {
        if (this.mLocationUpdatesEnabled) {
            this.gApiMgr.addTask(this.removeLocationUpdate);
            this.gApiMgr.stopSafely();
            this.mLocationUpdatesEnabled = false;
        }
        this.receivers.remove(str);
    }

    public void onLocationAvailability(LocationAvailability locationAvailability) {
        FusedLocation.super.onLocationAvailability(locationAvailability);
    }

    public void onLocationResult(LocationResult locationResult) {
        Location gcsLocation;
        android.location.Location lastLocation = locationResult.getLastLocation();
        if (lastLocation != null && (gcsLocation = this.locationRelay.toGcsLocation(lastLocation)) != null) {
            cqb.m12007b("Location Lat/Long: " + LocationRelay.getLatLongFromLocation(lastLocation), new Object[0]);
            notifyLocationUpdate(gcsLocation);
        }
    }

    private void notifyLocationUpdate(Location location) {
        if (this.receivers.isEmpty()) {
            cqb.m12007b(TAG, "notifyLocationUpdate(): No receivers");
            return;
        }
        for (Location.LocationReceiver onLocationUpdate : this.receivers.values()) {
            onLocationUpdate.onLocationUpdate(location);
        }
    }

    public void onGoogleApiConnectionError(ConnectionResult connectionResult) {
        notifyLocationUnavailable();
        GooglePlayServicesUtil.showErrorNotification(connectionResult.getErrorCode(), this.context);
    }

    public void onUnavailableGooglePlayServices(int i) {
        notifyLocationUnavailable();
        GooglePlayServicesUtil.showErrorNotification(i, this.context);
    }

    private void notifyLocationUnavailable() {
        if (!this.receivers.isEmpty()) {
            for (Location.LocationReceiver onLocationUnavailable : this.receivers.values()) {
                onLocationUnavailable.onLocationUnavailable();
            }
        }
    }

    public void onManagerStarted() {
        this.gApiMgr.addTask(this.requestLocationUpdate);
    }
}
