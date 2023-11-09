package org.droidplanner.services.android.impl.core.helpers.geoTools;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;

public class Simplify {
    public static List<LatLong> simplify(List<LatLong> list, double d) {
        int size = list.size() - 1;
        double d2 = 0.0d;
        int i = 0;
        for (int i2 = 1; i2 < size; i2++) {
            double pointToLineDistance = PointTools.pointToLineDistance(list.get(0), list.get(size), list.get(i2));
            if (pointToLineDistance > d2) {
                i = i2;
                d2 = pointToLineDistance;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (d2 > d) {
            List<LatLong> simplify = simplify(list.subList(0, i + 1), d);
            List<LatLong> simplify2 = simplify(list.subList(i, size + 1), d);
            simplify.remove(simplify.size() - 1);
            arrayList.addAll(simplify);
            arrayList.addAll(simplify2);
        } else {
            arrayList.add(list.get(0));
            arrayList.add(list.get(size));
        }
        return arrayList;
    }
}
