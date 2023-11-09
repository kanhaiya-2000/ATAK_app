package com.o3dr.services.android.lib.util;

import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MathUtils {
    private static final double RADIUS_OF_EARTH_IN_METERS = 6378137.0d;
    public static final int SIGNAL_MAX_FADE_MARGIN = 50;
    public static final int SIGNAL_MIN_FADE_MARGIN = 6;

    public static double getDistance3D(LatLongAlt latLongAlt, LatLongAlt latLongAlt2) {
        if (latLongAlt == null || latLongAlt2 == null) {
            return -1.0d;
        }
        return Math.sqrt(Math.pow(latLongAlt2.getAltitude() - latLongAlt.getAltitude(), 2.0d) + Math.pow(getDistance2D(latLongAlt, latLongAlt2), 2.0d));
    }

    public static double getDistance2D(LatLong latLong, LatLong latLong2) {
        if (latLong == null || latLong2 == null) {
            return -1.0d;
        }
        return Math.toRadians(getArcInRadians(latLong, latLong2)) * RADIUS_OF_EARTH_IN_METERS;
    }

    public static LatLong addDistance(LatLong latLong, double d, double d2) {
        double latitude = latLong.getLatitude();
        double longitude = latLong.getLongitude();
        return new LatLong(latitude + (((d2 / RADIUS_OF_EARTH_IN_METERS) * 180.0d) / 3.141592653589793d), longitude + (((d / (Math.cos((latitude * 3.141592653589793d) / 180.0d) * RADIUS_OF_EARTH_IN_METERS)) * 180.0d) / 3.141592653589793d));
    }

    public static double getArcInRadians(LatLong latLong, LatLong latLong2) {
        double radians = Math.toRadians(latLong.getLatitude() - latLong2.getLatitude());
        double radians2 = Math.toRadians(latLong.getLongitude() - latLong2.getLongitude());
        double sin = Math.sin(radians * 0.5d);
        double sin2 = Math.sin(radians2 * 0.5d);
        return Math.toDegrees(Math.asin(Math.sqrt((sin * sin) + (Math.cos(Math.toRadians(latLong.getLatitude())) * Math.cos(Math.toRadians(latLong2.getLatitude())) * sin2 * sin2))) * 2.0d);
    }

    public static int getSignalStrength(double d, double d2) {
        return (int) (normalize(Math.min(d, d2), 6.0d, 50.0d) * 100.0d);
    }

    public static double normalize(double d, double d2, double d3) {
        return (constrain(d, d2, d3) - d2) / (d3 - d2);
    }

    private static double constrain(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }

    public static double angleDiff(double d, double d2) {
        double IEEEremainder = Math.IEEEremainder((d2 - d) + 180.0d, 360.0d);
        if (IEEEremainder < 0.0d) {
            IEEEremainder += 360.0d;
        }
        return IEEEremainder - 180.0d;
    }

    public static double constrainAngle(double d) {
        double IEEEremainder = Math.IEEEremainder(d, 360.0d);
        return IEEEremainder < 0.0d ? IEEEremainder + 360.0d : IEEEremainder;
    }

    public static double bisectAngle(double d, double d2, double d3) {
        return constrainAngle(d + (angleDiff(d, d2) * d3));
    }

    public static double hypot(double d, double d2) {
        return Math.hypot(d, d2);
    }

    public static double[][] dcmFromEuler(double d, double d2, double d3) {
        double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        double cos = Math.cos(d2);
        double sin = Math.sin(d2);
        double sin2 = Math.sin(d);
        double cos2 = Math.cos(d);
        double sin3 = Math.sin(d3);
        double cos3 = Math.cos(d3);
        dArr[0][0] = cos * cos3;
        double d4 = sin2 * sin;
        dArr[1][0] = (d4 * cos3) - (cos2 * sin3);
        double d5 = cos2 * sin;
        dArr[2][0] = (d5 * cos3) + (sin2 * sin3);
        dArr[0][1] = cos * sin3;
        dArr[1][1] = (d4 * sin3) + (cos2 * cos3);
        dArr[2][1] = (d5 * sin3) - (cos3 * sin2);
        dArr[0][2] = -sin;
        dArr[1][2] = sin2 * cos;
        dArr[2][2] = cos2 * cos;
        return dArr;
    }

    public static List<LatLong> simplify(List<? extends LatLong> list, double d) {
        int size = list.size() - 1;
        double d2 = 0.0d;
        int i = 0;
        for (int i2 = 1; i2 < size; i2++) {
            double pointToLineDistance = pointToLineDistance((LatLong) list.get(0), (LatLong) list.get(size), (LatLong) list.get(i2));
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

    public static class SplinePath {
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

    public static class Spline {
        private static final float SPLINE_TENSION = 1.6f;

        /* renamed from: a */
        private LatLong f8609a;

        /* renamed from: b */
        private LatLong f8610b;

        /* renamed from: p0 */
        private LatLong f8611p0;
        private LatLong p0_prime;

        public Spline(LatLong latLong, LatLong latLong2, LatLong latLong3, LatLong latLong4) {
            this.f8611p0 = latLong2;
            this.p0_prime = latLong3.subtract(latLong).dot(0.625d);
            LatLong dot = latLong4.subtract(this.f8611p0).dot(0.625d);
            this.f8609a = LatLong.sum(this.f8611p0.dot(2.0d), latLong3.dot(-2.0d), this.p0_prime, dot);
            this.f8610b = LatLong.sum(this.f8611p0.dot(-3.0d), latLong3.dot(3.0d), this.p0_prime.dot(-2.0d), dot.negate());
        }

        public List<LatLong> generateCoordinates(int i) {
            ArrayList arrayList = new ArrayList();
            float f = 1.0f / ((float) i);
            for (float f2 = 0.0f; f2 < 1.0f; f2 += f) {
                arrayList.add(evaluate(f2));
            }
            return arrayList;
        }

        private LatLong evaluate(float f) {
            float f2 = f * f;
            return LatLong.sum(this.f8609a.dot((double) (f2 * f)), this.f8610b.dot((double) f2), this.p0_prime.dot((double) f), this.f8611p0);
        }
    }

    public static double getHeadingFromCoordinates(LatLong latLong, LatLong latLong2) {
        double radians = Math.toRadians(latLong.getLatitude());
        double radians2 = Math.toRadians(latLong.getLongitude());
        double radians3 = Math.toRadians(latLong2.getLatitude());
        double radians4 = Math.toRadians(latLong2.getLongitude()) - radians2;
        double degrees = Math.toDegrees(Math.atan2(Math.sin(radians4) * Math.cos(radians3), (Math.cos(radians) * Math.sin(radians3)) - ((Math.sin(radians) * Math.cos(radians3)) * Math.cos(radians4))));
        return degrees >= 0.0d ? degrees : degrees + 360.0d;
    }

    public static LatLong newCoordFromBearingAndDistance(LatLong latLong, double d, double d2) {
        double latitude = latLong.getLatitude();
        double longitude = latLong.getLongitude();
        double radians = Math.toRadians(latitude);
        double radians2 = Math.toRadians(longitude);
        double radians3 = Math.toRadians(d);
        double d3 = d2 / RADIUS_OF_EARTH_IN_METERS;
        double asin = Math.asin((Math.sin(radians) * Math.cos(d3)) + (Math.cos(radians) * Math.sin(d3) * Math.cos(radians3)));
        return new LatLong(Math.toDegrees(asin), Math.toDegrees(radians2 + Math.atan2(Math.sin(radians3) * Math.sin(d3) * Math.cos(radians), Math.cos(d3) - (Math.sin(radians) * Math.sin(asin)))));
    }

    public static double getPolylineLength(List<LatLong> list) {
        double d = 0.0d;
        for (int i = 1; i < list.size(); i++) {
            LatLong latLong = list.get(i - 1);
            if (latLong != null) {
                d += getDistance2D(list.get(i), latLong);
            }
        }
        return d;
    }
}
