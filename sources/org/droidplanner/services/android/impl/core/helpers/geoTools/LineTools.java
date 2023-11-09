package org.droidplanner.services.android.impl.core.helpers.geoTools;

import com.o3dr.services.android.lib.coordinate.LatLong;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.coordinates.CoordBounds;

public class LineTools {
    public static LineLatLong findExternalPoints(ArrayList<LatLong> arrayList) {
        LatLong findFarthestPoint = PointTools.findFarthestPoint(arrayList, new CoordBounds((List<LatLong>) arrayList).getMiddle());
        return new LineLatLong(findFarthestPoint, PointTools.findFarthestPoint(arrayList, findFarthestPoint));
    }

    public static LatLong FindLineIntersection(LineLatLong lineLatLong, LineLatLong lineLatLong2) {
        double latitude = ((lineLatLong.getEnd().getLatitude() - lineLatLong.getStart().getLatitude()) * (lineLatLong2.getEnd().getLongitude() - lineLatLong2.getStart().getLongitude())) - ((lineLatLong.getEnd().getLongitude() - lineLatLong.getStart().getLongitude()) * (lineLatLong2.getEnd().getLatitude() - lineLatLong2.getStart().getLatitude()));
        if (latitude == 0.0d) {
            return null;
        }
        double longitude = (((lineLatLong.getStart().getLongitude() - lineLatLong2.getStart().getLongitude()) * (lineLatLong2.getEnd().getLatitude() - lineLatLong2.getStart().getLatitude())) - ((lineLatLong.getStart().getLatitude() - lineLatLong2.getStart().getLatitude()) * (lineLatLong2.getEnd().getLongitude() - lineLatLong2.getStart().getLongitude()))) / latitude;
        double longitude2 = (((lineLatLong.getStart().getLongitude() - lineLatLong2.getStart().getLongitude()) * (lineLatLong.getEnd().getLatitude() - lineLatLong.getStart().getLatitude())) - ((lineLatLong.getStart().getLatitude() - lineLatLong2.getStart().getLatitude()) * (lineLatLong.getEnd().getLongitude() - lineLatLong.getStart().getLongitude()))) / latitude;
        if (longitude < 0.0d || longitude > 1.0d || longitude2 < 0.0d || longitude2 > 1.0d) {
            return null;
        }
        return new LatLong(lineLatLong.getStart().getLatitude() + ((lineLatLong.getEnd().getLatitude() - lineLatLong.getStart().getLatitude()) * longitude), lineLatLong.getStart().getLongitude() + (longitude * (lineLatLong.getEnd().getLongitude() - lineLatLong.getStart().getLongitude())));
    }

    public static LineLatLong findClosestLineToPoint(LatLong latLong, List<LineLatLong> list) {
        LineLatLong lineLatLong = list.get(0);
        double d = Double.MAX_VALUE;
        for (LineLatLong next : list) {
            LatLong start = GeoTools.getAproximatedDistance(latLong, next.getStart()).doubleValue() < GeoTools.getAproximatedDistance(latLong, next.getEnd()).doubleValue() ? next.getStart() : next.getEnd();
            if (d > GeoTools.getAproximatedDistance(latLong, start).doubleValue()) {
                d = GeoTools.getAproximatedDistance(latLong, start).doubleValue();
                lineLatLong = next;
            }
        }
        return lineLatLong;
    }
}
