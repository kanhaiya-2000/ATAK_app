package org.droidplanner.services.android.impl.core.gcs.follow;

import android.location.Location;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;

public class LocationRelay {
    private static final float JUMP_FACTOR = 4.0f;
    private static final float LOCATION_ACCURACY_THRESHOLD = 10.0f;
    static final String TAG = "LocationRelay";
    private static boolean VERBOSE = false;
    private Location mLastLocation;
    private int mSpeedReadings = 0;
    private float mTotalSpeed = 0.0f;

    public static String getLatLongFromLocation(Location location) {
        return Location.convert(location.getLatitude(), 0) + " " + Location.convert(location.getLongitude(), 0);
    }

    public void onFollowStart() {
        this.mTotalSpeed = 0.0f;
        this.mSpeedReadings = 0;
        this.mLastLocation = null;
    }

    public org.droidplanner.services.android.impl.core.gcs.location.Location toGcsLocation(Location location) {
        Location location2 = location;
        org.droidplanner.services.android.impl.core.gcs.location.Location location3 = null;
        if (location2 == null) {
            return null;
        }
        if (VERBOSE) {
            cqb.m12007b("toGcsLocation(): followLoc=" + location2, new Object[0]);
        }
        float f = 0.0f;
        if (!location.hasBearing()) {
            if (this.mLastLocation != null) {
                location2.setBearing((float) GeoTools.getHeadingFromCoordinates(new LatLong(this.mLastLocation.getLatitude(), this.mLastLocation.getLongitude()), new LatLong(location.getLatitude(), location.getLongitude())));
            } else {
                location2.setBearing(0.0f);
            }
        }
        if (!(location.hasAccuracy() && location.hasBearing() && location.getTime() > 0)) {
            cqb.m12012d("toGcsLocation(): Location needs accuracy, bearing, and time.", new Object[0]);
        } else {
            float f2 = -1.0f;
            long j = -1;
            long time = location.getTime();
            Location location4 = this.mLastLocation;
            if (location4 != null) {
                f2 = location2.distanceTo(location4);
                j = time - this.mLastLocation.getTime();
            }
            if (f2 > 0.0f && j > 0) {
                f = (1000.0f * f2) / ((float) j);
            }
            boolean isLocationAccurate = isLocationAccurate(location.getAccuracy(), f);
            if (VERBOSE) {
                cqb.m12007b("toLocation(): distancetoLast=%.2f timeToLast=%d currSpeed=%.2f accurate=%s", Float.valueOf(f2), Long.valueOf(j), Float.valueOf(f), Boolean.valueOf(isLocationAccurate));
            }
            location3 = new org.droidplanner.services.android.impl.core.gcs.location.Location(new LatLongAlt(location.getLatitude(), location.getLongitude(), location.getAltitude()), location.getBearing(), location.getSpeed(), isLocationAccurate, location.getTime());
            this.mLastLocation = location2;
            if (VERBOSE) {
                cqb.m12007b("External location lat/lng=" + getLatLongFromLocation(location), new Object[0]);
            }
        }
        return location3;
    }

    private boolean isLocationAccurate(float f, float f2) {
        if (f >= LOCATION_ACCURACY_THRESHOLD) {
            cqb.m12012d("isLocationAccurate() -- High/bad accuracy: " + f, new Object[0]);
            return false;
        }
        float f3 = this.mTotalSpeed + f2;
        this.mTotalSpeed = f3;
        int i = this.mSpeedReadings + 1;
        this.mSpeedReadings = i;
        float f4 = f3 / ((float) i);
        if (f2 <= 0.0f || ((double) f4) < 1.0d || f2 < f4 * JUMP_FACTOR) {
            return true;
        }
        cqb.m12012d("isLocationAccurate() -- High current speed: " + f2, new Object[0]);
        return false;
    }
}
