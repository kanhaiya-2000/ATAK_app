package org.droidplanner.services.android.impl.core.gcs.location;

import com.o3dr.services.android.lib.coordinate.LatLongAlt;

public class Location {
    private LatLongAlt coordinate;
    private long fixTime;
    private double heading = 0.0d;
    private boolean isAccurate;
    private double speed = 0.0d;

    public interface LocationFinder {
        void disableLocationUpdates(String str);

        void enableLocationUpdates(String str, LocationReceiver locationReceiver);
    }

    public interface LocationReceiver {
        void onLocationUnavailable();

        void onLocationUpdate(Location location);
    }

    public Location(LatLongAlt latLongAlt, float f, float f2, boolean z, long j) {
        this.coordinate = latLongAlt;
        this.heading = (double) f;
        this.speed = (double) f2;
        this.isAccurate = z;
        this.fixTime = j;
    }

    public LatLongAlt getCoord() {
        return this.coordinate;
    }

    public boolean isAccurate() {
        return !isInvalid() && this.isAccurate;
    }

    private boolean isInvalid() {
        LatLongAlt latLongAlt = this.coordinate;
        return latLongAlt == null || (latLongAlt.getLatitude() == 0.0d && this.coordinate.getLongitude() == 0.0d);
    }

    public double getBearing() {
        return this.heading;
    }

    public double getSpeed() {
        return this.speed;
    }

    public long getFixTime() {
        return this.fixTime;
    }
}
