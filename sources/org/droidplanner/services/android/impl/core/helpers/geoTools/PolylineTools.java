package org.droidplanner.services.android.impl.core.helpers.geoTools;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.List;

public class PolylineTools {
    public static double getPolylineLength(List<LatLong> list) {
        double d = 0.0d;
        for (int i = 1; i < list.size(); i++) {
            LatLong latLong = list.get(i - 1);
            if (latLong != null) {
                d += GeoTools.getDistance(list.get(i), latLong);
            }
        }
        return d;
    }
}
