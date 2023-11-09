package org.droidplanner.services.android.impl.core.helpers.geoTools;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PointTools {
    public static LatLong findFarthestPoint(ArrayList<LatLong> arrayList, LatLong latLong) {
        Iterator<LatLong> it = arrayList.iterator();
        double d = Double.NEGATIVE_INFINITY;
        LatLong latLong2 = null;
        while (it.hasNext()) {
            LatLong next = it.next();
            double doubleValue = GeoTools.getAproximatedDistance(next, latLong).doubleValue();
            if (doubleValue > d) {
                latLong2 = next;
                d = doubleValue;
            }
        }
        return latLong2;
    }

    private static LatLong findClosestPoint(LatLong latLong, List<LatLong> list) {
        LatLong latLong2 = null;
        double d = Double.MAX_VALUE;
        for (LatLong next : list) {
            double doubleValue = GeoTools.getAproximatedDistance(latLong, next).doubleValue();
            if (doubleValue < d) {
                latLong2 = next;
                d = doubleValue;
            }
        }
        return latLong2;
    }

    static int findClosestPair(LatLong latLong, List<LatLong> list) {
        LatLong latLong2;
        LatLong latLong3;
        double d = Double.MAX_VALUE;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 == list.size() - 1) {
                latLong3 = list.get(i2);
                latLong2 = list.get(0);
            } else {
                latLong3 = list.get(i2);
                latLong2 = list.get(i2 + 1);
            }
            double pointToLineDistance = pointToLineDistance(latLong3, latLong2, latLong);
            if (pointToLineDistance < d) {
                i = i2 + 1;
                d = pointToLineDistance;
            }
        }
        return i;
    }

    public static double pointToLineDistance(LatLong latLong, LatLong latLong2, LatLong latLong3) {
        double d;
        double d2;
        double latitude = latLong3.getLatitude() - latLong.getLatitude();
        double longitude = latLong3.getLongitude() - latLong.getLongitude();
        double latitude2 = latLong2.getLatitude() - latLong.getLatitude();
        double longitude2 = latLong2.getLongitude() - latLong.getLongitude();
        double d3 = ((latitude * latitude2) + (longitude * longitude2)) / ((latitude2 * latitude2) + (longitude2 * longitude2));
        if (d3 < 0.0d) {
            d2 = latLong.getLatitude();
            d = latLong.getLongitude();
        } else if (d3 > 1.0d) {
            d2 = latLong2.getLatitude();
            d = latLong2.getLongitude();
        } else {
            d = latLong.getLongitude() + (d3 * longitude2);
            d2 = latLong.getLatitude() + (latitude2 * d3);
        }
        return Math.hypot(d2 - latLong3.getLatitude(), d - latLong3.getLongitude());
    }
}
