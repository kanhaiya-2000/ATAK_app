package org.droidplanner.services.android.impl.core.helpers.geoTools;

import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.util.MathUtils;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.units.Area;
import org.droidplanner.services.android.impl.core.polygon.Polygon;

public class GeoTools {
    private static final double RADIUS_OF_EARTH = 6378137.0d;
    public List<LatLong> waypoints;

    public static double warpToPositiveAngle(double d) {
        return d >= 0.0d ? d : d + 360.0d;
    }

    public static Double getAproximatedDistance(LatLong latLong, LatLong latLong2) {
        return Double.valueOf(Math.hypot(latLong.getLatitude() - latLong2.getLatitude(), latLong.getLongitude() - latLong2.getLongitude()));
    }

    private static Double metersTolat(double d) {
        return Double.valueOf(Math.toDegrees(d / RADIUS_OF_EARTH));
    }

    public static Double latToMeters(double d) {
        return Double.valueOf(Math.toRadians(d) * RADIUS_OF_EARTH);
    }

    public static LatLong newCoordFromBearingAndDistance(LatLong latLong, double d, double d2) {
        return newCoordFromBearingAndDistance(latLong.getLatitude(), latLong.getLongitude(), d, d2);
    }

    private static LatLong newCoordFromBearingAndDistance(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d);
        double radians2 = Math.toRadians(d2);
        double radians3 = Math.toRadians(d3);
        double d5 = d4 / RADIUS_OF_EARTH;
        double asin = Math.asin((Math.sin(radians) * Math.cos(d5)) + (Math.cos(radians) * Math.sin(d5) * Math.cos(radians3)));
        return new LatLong(Math.toDegrees(asin), Math.toDegrees(radians2 + Math.atan2(Math.sin(radians3) * Math.sin(d5) * Math.cos(radians), Math.cos(d5) - (Math.sin(radians) * Math.sin(asin)))));
    }

    public static LatLong moveCoordinate(LatLong latLong, double d, double d2) {
        double longitude = latLong.getLongitude();
        double latitude = latLong.getLatitude();
        double radians = Math.toRadians(longitude);
        return new LatLong(Math.toDegrees(Math.toRadians(latitude) + Math.toRadians(metersTolat(d2).doubleValue())), Math.toDegrees(radians + Math.toRadians(metersTolat(d).doubleValue())));
    }

    static double getArcInRadians(LatLong latLong, LatLong latLong2) {
        double radians = Math.toRadians(latLong.getLatitude() - latLong2.getLatitude());
        double radians2 = Math.toRadians(latLong.getLongitude() - latLong2.getLongitude());
        double sin = Math.sin(radians * 0.5d);
        double sin2 = Math.sin(radians2 * 0.5d);
        return Math.toDegrees(Math.asin(Math.sqrt((sin * sin) + (Math.cos(Math.toRadians(latLong.getLatitude())) * Math.cos(Math.toRadians(latLong2.getLatitude())) * sin2 * sin2))) * 2.0d);
    }

    public static double getDistance(LatLong latLong, LatLong latLong2) {
        return Math.toRadians(getArcInRadians(latLong, latLong2)) * RADIUS_OF_EARTH;
    }

    public static double get3DDistance(LatLongAlt latLongAlt, LatLongAlt latLongAlt2) {
        return MathUtils.hypot(getDistance(latLongAlt, latLongAlt2), Math.abs(latLongAlt.getAltitude() - latLongAlt2.getAltitude()));
    }

    public static double getHeadingFromCoordinates(LatLong latLong, LatLong latLong2) {
        double radians = Math.toRadians(latLong.getLatitude());
        double radians2 = Math.toRadians(latLong.getLongitude());
        double radians3 = Math.toRadians(latLong2.getLatitude());
        double radians4 = Math.toRadians(latLong2.getLongitude()) - radians2;
        return warpToPositiveAngle(Math.toDegrees(Math.atan2(Math.sin(radians4) * Math.cos(radians3), (Math.cos(radians) * Math.sin(radians3)) - ((Math.sin(radians) * Math.cos(radians3)) * Math.cos(radians4)))));
    }

    public static Area getArea(Polygon polygon) {
        List<LatLong> points = polygon.getPoints();
        int size = points.size();
        double d = 0.0d;
        if (size < 3) {
            return new Area(0.0d);
        }
        LatLong latLong = points.get(size - 1);
        double tan = Math.tan((1.5707963267948966d - Math.toRadians(latLong.getLatitude())) / 2.0d);
        double radians = Math.toRadians(latLong.getLongitude());
        double d2 = tan;
        double d3 = radians;
        for (LatLong next : points) {
            double tan2 = Math.tan((1.5707963267948966d - Math.toRadians(next.getLatitude())) / 2.0d);
            double radians2 = Math.toRadians(next.getLongitude());
            d += polarTriangleArea(tan2, radians2, d2, d3);
            d2 = tan2;
            d3 = radians2;
        }
        return new Area(Math.abs(d * 4.0680631590769E13d));
    }

    private static double polarTriangleArea(double d, double d2, double d3, double d4) {
        double d5 = d2 - d4;
        double d6 = d * d3;
        return Math.atan2(Math.sin(d5) * d6, (d6 * Math.cos(d5)) + 1.0d) * 2.0d;
    }

    public static LatLong pointAlongTheLine(LatLong latLong, LatLong latLong2, int i) {
        return newCoordFromBearingAndDistance(latLong, getHeadingFromCoordinates(latLong, latLong2), (double) i);
    }
}
