package org.droidplanner.services.android.impl.core.helpers.geoTools.spline;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;

public class SplinePath {
    private static final int SPLINE_DECIMATION = 20;
    private static final String TAG = "SplinePath";

    public static List<LatLong> process(List<LatLong> list) {
        int size = list.size();
        if (size < 4) {
            System.err.println("Not enough points!");
            return list;
        }
        List<LatLong> processPath = processPath(list);
        processPath.add(0, list.get(0));
        processPath.add(list.get(size - 1));
        return processPath;
    }

    private static List<LatLong> processPath(List<LatLong> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 3; i < list.size(); i++) {
            arrayList.addAll(processPathSegment(list.get(i - 3), list.get(i - 2), list.get(i - 1), list.get(i)));
        }
        return arrayList;
    }

    private static List<LatLong> processPathSegment(LatLong latLong, LatLong latLong2, LatLong latLong3, LatLong latLong4) {
        return new Spline(latLong, latLong2, latLong3, latLong4).generateCoordinates(20);
    }
}
