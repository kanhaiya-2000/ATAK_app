package org.droidplanner.services.android.impl.core.survey;

import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_camera_feedback;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.util.MathUtils;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;

public class Footprint {
    private double meanGSD;
    private final List<LatLong> vertex;

    public Footprint(CameraInfo cameraInfo, double d) {
        this(cameraInfo, new LatLong(0.0d, 0.0d), (double) ((float) d), 0.0d, 0.0d, 0.0d);
    }

    public Footprint(CameraInfo cameraInfo, msg_camera_feedback msg_camera_feedback) {
        this(cameraInfo, new LatLong(((double) msg_camera_feedback.lat) / 1.0E7d, ((double) msg_camera_feedback.lng) / 1.0E7d), (double) msg_camera_feedback.alt_rel, (double) msg_camera_feedback.pitch, (double) msg_camera_feedback.roll, (double) msg_camera_feedback.yaw);
    }

    public Footprint(CameraInfo cameraInfo, LatLong latLong, double d, double d2, double d3, double d4) {
        ArrayList arrayList = new ArrayList();
        this.vertex = arrayList;
        double doubleValue = cameraInfo.getSensorLateralSize().doubleValue() / 2.0d;
        double doubleValue2 = cameraInfo.getSensorLongitudinalSize().doubleValue() / 2.0d;
        double doubleValue3 = cameraInfo.focalLength.doubleValue();
        double[][] dcmFromEuler = MathUtils.dcmFromEuler(Math.toRadians(d2), Math.toRadians((-d3) + 180.0d), Math.toRadians(-d4));
        double d5 = -doubleValue;
        double d6 = -doubleValue2;
        LatLong latLong2 = new LatLong(d5, d6);
        double[][] dArr = dcmFromEuler;
        double d7 = d6;
        double d8 = d;
        double d9 = d5;
        double d10 = doubleValue3;
        LatLong latLong3 = latLong;
        arrayList.add(cameraFrameToLocalFrame(latLong2, dArr, d8, d10, latLong3));
        arrayList.add(cameraFrameToLocalFrame(new LatLong(doubleValue, d7), dArr, d8, d10, latLong3));
        arrayList.add(cameraFrameToLocalFrame(new LatLong(doubleValue, doubleValue2), dArr, d8, d10, latLong3));
        arrayList.add(cameraFrameToLocalFrame(new LatLong(d9, doubleValue2), dArr, d8, d10, latLong3));
        this.meanGSD = ((getLateralSize() * 0.001d) * (doubleValue2 / doubleValue)) / Math.sqrt(cameraInfo.sensorResolution.doubleValue());
    }

    private static LatLong cameraFrameToLocalFrame(LatLong latLong, double[][] dArr, double d, double d2, LatLong latLong2) {
        double d3 = -d2;
        return GeoTools.moveCoordinate(latLong2, ((((dArr[0][0] * latLong.getLatitude()) + (dArr[1][0] * latLong.getLongitude())) + (dArr[2][0] * d3)) * d) / (((dArr[0][2] * latLong.getLatitude()) + (dArr[1][2] * latLong.getLongitude())) + (dArr[2][2] * d3)), (d * (((dArr[0][1] * latLong.getLatitude()) + (dArr[1][1] * latLong.getLongitude())) + (dArr[2][1] * d3))) / (((dArr[0][2] * latLong.getLatitude()) + (dArr[1][2] * latLong.getLongitude())) + (dArr[2][2] * d3)));
    }

    public double getLateralSize() {
        return (GeoTools.getDistance(this.vertex.get(0), this.vertex.get(1)) + GeoTools.getDistance(this.vertex.get(2), this.vertex.get(3))) / 2.0d;
    }

    public double getLongitudinalSize() {
        return (GeoTools.getDistance(this.vertex.get(0), this.vertex.get(3)) + GeoTools.getDistance(this.vertex.get(1), this.vertex.get(2))) / 2.0d;
    }

    public List<LatLong> getVertexInGlobalFrame() {
        return this.vertex;
    }

    public double getGSD() {
        return this.meanGSD;
    }
}
