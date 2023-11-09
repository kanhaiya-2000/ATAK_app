package org.droidplanner.services.android.impl.core.helpers.coordinates;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;

public class CoordBounds {
    public LatLong ne_1quadrant;
    public LatLong sw_3quadrant;

    public CoordBounds(LatLong latLong) {
        include(latLong);
    }

    public CoordBounds(List<LatLong> list) {
        for (LatLong include : list) {
            include(include);
        }
    }

    public void include(LatLong latLong) {
        if (this.sw_3quadrant == null || this.ne_1quadrant == null) {
            this.ne_1quadrant = new LatLong(latLong);
            this.sw_3quadrant = new LatLong(latLong);
            return;
        }
        if (latLong.getLongitude() > this.ne_1quadrant.getLongitude()) {
            this.ne_1quadrant.setLongitude(latLong.getLongitude());
        }
        if (latLong.getLatitude() > this.ne_1quadrant.getLatitude()) {
            this.ne_1quadrant.setLatitude(latLong.getLatitude());
        }
        if (latLong.getLongitude() < this.sw_3quadrant.getLongitude()) {
            this.sw_3quadrant.setLongitude(latLong.getLongitude());
        }
        if (latLong.getLatitude() < this.sw_3quadrant.getLatitude()) {
            this.sw_3quadrant.setLatitude(latLong.getLatitude());
        }
    }

    public double getDiag() {
        return GeoTools.latToMeters(GeoTools.getAproximatedDistance(this.ne_1quadrant, this.sw_3quadrant).doubleValue()).doubleValue();
    }

    public LatLong getMiddle() {
        return new LatLong((this.ne_1quadrant.getLatitude() + this.sw_3quadrant.getLatitude()) / 2.0d, (this.ne_1quadrant.getLongitude() + this.sw_3quadrant.getLongitude()) / 2.0d);
    }
}
