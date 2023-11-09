package com.atakmap.android.uastool.utils;

import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.bb;
import com.atakmap.android.routes.e;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.coords.GeoPointMetaData;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.drone.mission.Mission;
import com.o3dr.services.android.lib.drone.mission.item.complex.CameraDetail;
import com.o3dr.services.android.lib.drone.mission.item.complex.SplineSurvey;
import com.o3dr.services.android.lib.drone.mission.item.complex.SurveyDetail;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.droidplanner.services.android.impl.core.polygon.Polygon;
import org.droidplanner.services.android.impl.core.survey.SurveyData;
import org.droidplanner.services.android.impl.core.survey.grid.GridBuilder;

public class Survey {
    private static final double DEFAULT_ALTITUDE = 100.0d;
    private static final double DEFAULT_ANGLE = 45.0d;
    private static final double DEFAULT_OVERLAP = 50.0d;
    private static final double DEFAULT_SIDELAP = 60.0d;
    private static final String TAG = "Survey";
    private double altitude = DEFAULT_ALTITUDE;
    private double angle = DEFAULT_ANGLE;
    private final bb area;
    private String cameraName = "Unknown";
    private double focalLength = 5.0d;
    private boolean isInLandscapeOrientation = true;
    private double overlap = DEFAULT_OVERLAP;
    private double sensorHeight = 4.22d;
    private double sensorResolution = 12.1d;
    private double sensorWidth = 6.12d;
    private double sidelap = DEFAULT_SIDELAP;

    public Survey(bb bbVar, Double d, Double d2, Double d3, Double d4) {
        this.area = bbVar;
        if (d != null) {
            this.altitude = d.doubleValue();
        }
        if (d2 != null) {
            this.angle = d2.doubleValue();
        }
        if (d3 != null) {
            this.overlap = d3.doubleValue();
        }
        if (d4 != null) {
            this.sidelap = d4.doubleValue();
        }
    }

    public void setCameraDetail(String str, double d, double d2, double d3, double d4, boolean z) {
        this.cameraName = str;
        this.sensorWidth = d;
        this.sensorHeight = d2;
        this.sensorResolution = d3;
        this.focalLength = d4;
        this.isInLandscapeOrientation = z;
    }

    public e buildSurveyRoute(boolean z, boolean z2) {
        try {
            Mission createMissionFromArea = createMissionFromArea(Double.valueOf(this.altitude), Double.valueOf(this.angle), Double.valueOf(this.overlap), Double.valueOf(this.sidelap));
            if (createMissionFromArea == null) {
                UASToolDropDownReceiver.toast("Could not make mission to survey area", 1);
                return null;
            }
            try {
                SurveyDetail surveyDetail = ((SplineSurvey) createMissionFromArea.getMissionItem(0)).getSurveyDetail();
                e routeFromLatLongList = routeFromLatLongList(getCameraLocations(surveyDetail.getAngle(), surveyDetail.getAltitude(), surveyDetail.getOverlap(), surveyDetail.getSidelap(), surveyDetail.getLockOrientation()), Double.valueOf(this.altitude), z);
                if (z) {
                    ag c = MapView.getMapView().getRootGroup().c("Route");
                    ag c2 = c.c(TAG);
                    if (c2 == null) {
                        c2 = c.a(TAG);
                    }
                    Log.d(TAG, "Adding Survey Route: " + routeFromLatLongList + " to " + c2);
                    c2.d(routeFromLatLongList);
                    c2.a(true);
                }
                return routeFromLatLongList;
            } catch (Exception e) {
                Log.w(TAG, e.getMessage(), e);
                return null;
            }
        } catch (Exception e2) {
            Log.w(TAG, "Exception during route create", e2);
            UASToolDropDownReceiver.toast("Problem creating mission", 1);
        }
    }

    private e routeFromLatLongList(List<LatLong> list, Double d, boolean z) {
        e eVar = new e(MapView.getMapView(), "Survey-" + this.area.getTitle(), -16776961, TAG, UUID.randomUUID().toString() + "survey");
        int i = 1;
        for (LatLong next : list) {
            Log.d(TAG, "Adding route point: " + i);
            GeoPoint geoPoint = new GeoPoint(next.getLatitude(), next.getLongitude(), d.doubleValue(), GeoPoint.AltitudeReference.AGL);
            if (z) {
                GeoPointMetaData wrap = GeoPointMetaData.wrap(geoPoint);
                StringBuilder sb = new StringBuilder();
                sb.append("Survey ");
                int i2 = i + 1;
                sb.append(i);
                ao a = e.a(wrap, sb.toString());
                a.setMetaString(FlightLogger.LOG_CALLSIGN, "Survey " + i2);
                eVar.addMarker(a);
                i = i2;
            } else {
                eVar.addPoint(GeoPointMetaData.wrap(geoPoint));
            }
        }
        if (z) {
            eVar.setVisible(true);
        }
        return eVar;
    }

    private Mission createMissionFromArea(Double d, Double d2, Double d3, Double d4) {
        SplineSurvey splineSurvey = new SplineSurvey();
        LinkedList linkedList = new LinkedList();
        for (GeoPoint geoPoint : this.area.getPoints()) {
            linkedList.add(new LatLong(geoPoint.getLatitude(), geoPoint.getLongitude()));
        }
        splineSurvey.setPolygonPoints(linkedList);
        SurveyDetail surveyDetail = new SurveyDetail();
        surveyDetail.setAltitude(d.doubleValue());
        surveyDetail.setAngle(d2.doubleValue());
        surveyDetail.setOverlap(d3.doubleValue());
        surveyDetail.setSidelap(d4.doubleValue());
        surveyDetail.setCameraDetail(new CameraDetail(this.cameraName, this.sensorWidth, this.sensorHeight, this.sensorResolution, this.focalLength, d3.doubleValue(), d4.doubleValue(), this.isInLandscapeOrientation));
        splineSurvey.setSurveyDetail(surveyDetail);
        try {
            Mission mission = new Mission();
            mission.addMissionItem(splineSurvey);
            return mission;
        } catch (Exception e) {
            Log.w(TAG, "Error creating mission from area survey " + this.area, e);
            return null;
        }
    }

    private List<LatLong> getCameraLocations(double d, double d2, double d3, double d4, boolean z) {
        SurveyData surveyData = new SurveyData();
        surveyData.update(d, d2, d3, d4, z);
        Polygon polygon = new Polygon();
        polygon.addPoints(areaToPolygon());
        return new GridBuilder(polygon, surveyData, new LatLong(0.0d, 0.0d)).generate(true).gridPoints;
    }

    private List<LatLong> areaToPolygon() {
        LinkedList linkedList = new LinkedList();
        for (GeoPoint geoPoint : this.area.getPoints()) {
            linkedList.add(new LatLong(geoPoint.getLatitude(), geoPoint.getLongitude()));
        }
        return linkedList;
    }
}
