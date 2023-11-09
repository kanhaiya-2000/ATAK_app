package org.droidplanner.services.android.impl.core.helpers.geoTools;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;

public class LineSampler {
    private List<LatLong> points;
    private List<LatLong> sampledPoints = new ArrayList();

    public LineSampler(List<LatLong> list) {
        this.points = list;
    }

    public LineSampler(LatLong latLong, LatLong latLong2) {
        ArrayList arrayList = new ArrayList();
        this.points = arrayList;
        arrayList.add(latLong);
        this.points.add(latLong2);
    }

    public List<LatLong> sample(double d) {
        for (int i = 1; i < this.points.size(); i++) {
            LatLong latLong = this.points.get(i - 1);
            if (latLong != null) {
                this.sampledPoints.addAll(sampleLine(latLong, this.points.get(i), d));
            }
        }
        LatLong last = getLast(this.points);
        if (last != null) {
            this.sampledPoints.add(last);
        }
        return this.sampledPoints;
    }

    private List<LatLong> sampleLine(LatLong latLong, LatLong latLong2, double d) {
        ArrayList arrayList = new ArrayList();
        double headingFromCoordinates = GeoTools.getHeadingFromCoordinates(latLong, latLong2);
        double distance = GeoTools.getDistance(latLong, latLong2);
        double d2 = 0.0d;
        while (d2 < distance) {
            arrayList.add(GeoTools.newCoordFromBearingAndDistance(latLong, headingFromCoordinates, d2));
            d2 += d;
        }
        return arrayList;
    }

    private LatLong getLast(List<LatLong> list) {
        return list.get(list.size() - 1);
    }
}
