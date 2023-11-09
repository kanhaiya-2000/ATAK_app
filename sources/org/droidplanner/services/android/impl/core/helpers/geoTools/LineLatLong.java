package org.droidplanner.services.android.impl.core.helpers.geoTools;

import com.o3dr.services.android.lib.coordinate.LatLong;

public class LineLatLong {
    private final LatLong end;
    private final LatLong start;

    public LineLatLong(LatLong latLong, LatLong latLong2) {
        this.start = latLong;
        this.end = latLong2;
    }

    public LineLatLong(LineLatLong lineLatLong) {
        this(lineLatLong.start, lineLatLong.end);
    }

    public LatLong getStart() {
        return this.start;
    }

    public LatLong getEnd() {
        return this.end;
    }

    public double getHeading() {
        return GeoTools.getHeadingFromCoordinates(this.start, this.end);
    }

    public LatLong getFarthestEndpointTo(LatLong latLong) {
        if (getClosestEndpointTo(latLong).equals(this.start)) {
            return this.end;
        }
        return this.start;
    }

    public LatLong getClosestEndpointTo(LatLong latLong) {
        if (getDistanceToStart(latLong).doubleValue() < getDistanceToEnd(latLong).doubleValue()) {
            return this.start;
        }
        return this.end;
    }

    private Double getDistanceToEnd(LatLong latLong) {
        return GeoTools.getAproximatedDistance(this.end, latLong);
    }

    private Double getDistanceToStart(LatLong latLong) {
        return GeoTools.getAproximatedDistance(this.start, latLong);
    }

    public String toString() {
        return "from:" + this.start.toString() + "to:" + this.end.toString();
    }
}
