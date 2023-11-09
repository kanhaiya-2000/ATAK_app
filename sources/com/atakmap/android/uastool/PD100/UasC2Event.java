package com.atakmap.android.uastool.PD100;

import atakplugin.UASTool.adz;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.p000av.PayloadBlock;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import com.autel.downloader.bean.DownloadTask;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class UasC2Event {
    public GeoPoint airframeLocation = GeoPoint.ZERO_POINT;
    public AVDetail avDetail = null;
    public CommandedDataDetail commandedDataDetail = null;
    public ContactDetail contactDetail = new ContactDetail();
    public DJIDetail djiDetail = null;
    public EnvironmentDetail environmentDetail = new EnvironmentDetail();
    public LinkDetail linkDetail = null;
    public PayloadDetail payloadDetail = null;
    public PDDetail pdDetail = null;
    public PrecisionLocationDetail precisionLocationDetail = null;
    public RadioDetail radioDetail = new RadioDetail();
    public SensorDetail sensorDetail = new SensorDetail();
    public SpatialDetail spatialDetail = new SpatialDetail();
    public String tailNumber;
    public TrackDetail trackDetail = new TrackDetail();
    public UASToolDetail uasToolDetail = new UASToolDetail();
    public VehicleDetail vehicleDetail = new VehicleDetail();
    public VideoDetail videoDetail = null;
    public WaypointCollectionDetail waypointCollectionDetail = null;

    public static class UASToolDetail {
        public static final String detailName = "_uastool";
        public boolean activeRoute;
        public boolean extendedCot;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\t_uastool:");
            StringBuilder sb = new StringBuilder();
            sb.append("\t\tExtended CoT: ");
            sb.append(this.extendedCot ? "true" : "false");
            Log.println(i, str, sb.toString());
            Log.println(i, str, "\t\tActive Route: " + this.activeRoute);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("extendedCot", this.extendedCot ? "true" : "false");
            cotDetail.setAttribute("activeRoute", this.activeRoute ? "true" : "false");
            return cotDetail;
        }
    }

    public UASToolDetail acquireUASToolDetail() {
        if (this.uasToolDetail == null) {
            this.uasToolDetail = new UASToolDetail();
        }
        return this.uasToolDetail;
    }

    public static class AVDetail {
        public static final String detailName = "_AVinc_";
        public String flightMode;
        public List<PayloadDetail> payloadDetails;
        public int rangeToTarget;
        public String targetWaypoint;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\t_AVinc_:");
            Log.println(i, str, "\t\tFlight Mode: " + this.flightMode);
            String str2 = this.targetWaypoint;
            if (str2 != null && !str2.isEmpty()) {
                Log.println(i, str, "\t\tTarget Waypoint: " + this.targetWaypoint);
                Log.println(i, str, "\t\tRange To Target: " + this.rangeToTarget);
            }
            for (PayloadDetail Log : this.payloadDetails) {
                Log.Log(i, str);
            }
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("Flight_Mode", this.flightMode);
            String str = this.targetWaypoint;
            if (str != null && !str.isEmpty()) {
                cotDetail.setAttribute("Target_Waypoint", "Waypoint-" + this.targetWaypoint);
                cotDetail.setAttribute("Range_To_Target", Integer.toString(this.rangeToTarget));
            }
            for (PayloadDetail cotDetail2 : this.payloadDetails) {
                cotDetail.addChild(cotDetail2.toCotDetail());
            }
            return cotDetail;
        }
    }

    public AVDetail acquireAVDetail() {
        if (this.avDetail == null) {
            this.avDetail = new AVDetail();
        }
        return this.avDetail;
    }

    public static class PayloadDetail {
        public static final String detailName = "payload";
        PayloadBlock payload;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\tpayload:");
            Log.println(i, str, "\t\tModel: " + this.payload.getModel());
            Log.println(i, str, "\t\thfov: " + this.payload.getHfov());
            Log.println(i, str, "\t\tvfov: " + this.payload.getVfov());
            if (this.payload.getZoomCapable()) {
                Log.println(i, str, "\t\tzoomindex: " + this.payload.getZoomIndex());
                Log.println(i, str, "\t\tzoomlimit: " + this.payload.getZoomLimit());
            }
            if (this.payload.getPanCapable()) {
                Log.println(i, str, "\t\tpan: " + this.payload.getPan());
            }
            if (this.payload.getTiltCapable()) {
                Log.println(i, str, "\t\ttilt: " + this.payload.getTilt());
            }
            if (this.payload.getType() == PayloadBlock.PayloadType.GIMBAL) {
                Log.println(i, str, "\t\tstow: " + this.payload.getUnstow());
            }
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail("payload");
            cotDetail.setAttribute("model", this.payload.getModel());
            cotDetail.setAttribute("hfov", String.valueOf(this.payload.getHfov()));
            cotDetail.setAttribute("vfov", String.valueOf(this.payload.getVfov()));
            if (this.payload.getZoomCapable()) {
                cotDetail.setAttribute("zoomindex", String.valueOf(this.payload.getZoomIndex()));
                cotDetail.setAttribute("zoomlimit", String.valueOf(this.payload.getZoomLimit()));
            }
            if (this.payload.getPanCapable()) {
                cotDetail.setAttribute("pan", String.valueOf(this.payload.getPan()));
            }
            if (this.payload.getTiltCapable()) {
                cotDetail.setAttribute("tilt", String.valueOf(this.payload.getTilt()));
            }
            if (this.payload.getType() == PayloadBlock.PayloadType.GIMBAL) {
                cotDetail.setAttribute("stow", String.valueOf(this.payload.getUnstow()));
            }
            return cotDetail;
        }
    }

    public PayloadDetail acquirePayload() {
        if (this.payloadDetail == null) {
            this.payloadDetail = new PayloadDetail();
        }
        return this.payloadDetail;
    }

    public static class DJIDetail {
        public static final String detailName = "_DJI_";
        public double homelat;
        public double homelon;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\t_DJI_:");
            Log.println(i, str, "\t\tHome Lat: " + String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(this.homelat)}));
            Log.println(i, str, "\t\tHome Lon: " + String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(this.homelon)}));
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail("_DJI_");
            cotDetail.setAttribute("homelat", String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(this.homelat)}));
            cotDetail.setAttribute("homelon", String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(this.homelon)}));
            return cotDetail;
        }
    }

    public DJIDetail acquireDJIDetail() {
        if (this.djiDetail == null) {
            this.djiDetail = new DJIDetail();
        }
        return this.djiDetail;
    }

    public static class PDDetail {
        public static final String detailName = "_ProxDynamics_";
        public Double cameraPitch;
        public double groundStationCourse;
        public GeoPoint groundStationLocation;
        public double groundStationSpeed;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\t_ProxDynamics_:");
            Log.println(i, str, "\t\tGround Station Location: " + this.groundStationLocation.toString());
            Log.println(i, str, "\t\tGround Station Course: " + String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(this.groundStationCourse)}));
            Log.println(i, str, "\t\tGround Station Speed: " + String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(this.groundStationSpeed)}));
            if (this.cameraPitch != null) {
                Log.println(i, str, "\t\tCamera Pitch: " + String.format(Locale.US, "%01.1f", new Object[]{this.cameraPitch}));
            }
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            CotPoint cotPoint = new CotPoint(this.groundStationLocation);
            cotDetail.setAttribute("gsLat", String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getLat())}));
            cotDetail.setAttribute("gsLon", String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getLon())}));
            cotDetail.setAttribute("gsAlt", String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(cotPoint.getHae())}));
            cotDetail.setAttribute("gsCourse", String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(this.groundStationCourse)}));
            cotDetail.setAttribute("gsSpeed", String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(this.groundStationSpeed)}));
            if (this.cameraPitch != null) {
                cotDetail.setAttribute("cameraPitch", String.format(Locale.US, "%01.1f", new Object[]{this.cameraPitch}));
            }
            return cotDetail;
        }
    }

    public PDDetail acquirePDDetail() {
        if (this.pdDetail == null) {
            this.pdDetail = new PDDetail();
        }
        return this.pdDetail;
    }

    public static class ContactDetail {
        public static final String detailName = "contact";
        public String callsign;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "Callsign: " + this.callsign);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute(FlightLogger.LOG_CALLSIGN, this.callsign);
            return cotDetail;
        }
    }

    public static class TrackDetail {
        public static final String detailName = "track";
        public double course = 0.0d;
        public int eCourse = 5;
        public double eSlope = 0.1d;
        public double eSpeed = 0.1d;
        public double slope = 0.0d;
        public double speed = 0.0d;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\ttrack:");
            Log.println(i, str, "\t\tCourse: " + this.course);
            Log.println(i, str, "\t\tSpeed: " + this.speed);
            Log.println(i, str, "\t\tSlope: " + this.slope);
            Log.println(i, str, "\t\teCourse: " + this.eCourse);
            Log.println(i, str, "\t\teSpeed: " + this.eSpeed);
            Log.println(i, str, "\t\teSlope: " + this.eSlope);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("course", String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(this.course)}));
            cotDetail.setAttribute(UASPoint.COTDETAIL_SPEED, String.format(Locale.US, "%01.2f", new Object[]{Double.valueOf(this.speed)}));
            cotDetail.setAttribute("slope", String.format(Locale.US, "%01.2f", new Object[]{Double.valueOf(this.slope)}));
            cotDetail.setAttribute("eCourse", Integer.toString(this.eCourse));
            cotDetail.setAttribute("eSpeed", String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(this.eSpeed)}));
            cotDetail.setAttribute("eSlope", String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(this.eSlope)}));
            return cotDetail;
        }
    }

    public static class SensorDetail {
        public static final String detailName = "sensor";
        public double azimuth = 0.0d;
        public double elevation = 0.0d;
        public double fov = 0.0d;
        public String model = PD100UASItem.DISPLAY_NAME;
        public Double north = Double.valueOf(0.0d);
        public double range = 0.0d;
        public double roll = 0.0d;
        public String type = "r-e";
        public double version = 1.9d;
        public double vfov = 0.0d;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\tsensor:");
            Log.println(i, str, "\t\tAzimuth: " + this.azimuth);
            Log.println(i, str, "\t\tElevation: " + this.elevation);
            Log.println(i, str, "\t\tRoll: " + this.roll);
            Log.println(i, str, "\t\tFOV: " + this.fov);
            Log.println(i, str, "\t\tVFOV: " + this.vfov);
            Log.println(i, str, "\t\tNorth: " + this.north);
            Log.println(i, str, "\t\tVersion: " + this.version);
            Log.println(i, str, "\t\tModel: " + this.model);
            Log.println(i, str, "\t\tRange: " + this.range);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("azimuth", String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(this.azimuth)}));
            cotDetail.setAttribute("elevation", String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(this.elevation)}));
            cotDetail.setAttribute(adz.f608a, String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(this.roll)}));
            cotDetail.setAttribute("fov", String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(this.fov)}));
            cotDetail.setAttribute("vfov", String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(this.vfov)}));
            if (this.north != null) {
                cotDetail.setAttribute("north", String.format(Locale.US, "%01.3f", new Object[]{this.north}));
            }
            cotDetail.setAttribute("version", Double.toString(this.version));
            cotDetail.setAttribute("type", this.type);
            String str = this.model;
            if (str != null) {
                cotDetail.setAttribute("model", str);
            }
            cotDetail.setAttribute("range", String.format(Locale.US, "%01.0f", new Object[]{Double.valueOf(this.range)}));
            return cotDetail;
        }
    }

    public static class SpatialDetail {
        public static final String detailName = "spatial";
        public AttitudeDetail attitudeDetail = new AttitudeDetail();
        public SpinDetail spinDetail = new SpinDetail();

        public static class AttitudeDetail {
            public static final String detailName = "attitude";
            public Integer epitch = 10;
            public Integer eroll = 10;
            public Integer eyaw = 10;
            public double pitch;
            public double roll;
            public double yaw;

            public synchronized void Log(int i, String str) {
                Log.println(i, str, "\tattitude:");
                Log.println(i, str, "\t\tPitch: " + this.pitch);
                Log.println(i, str, "\t\tRoll: " + this.roll);
                Log.println(i, str, "\t\tYaw: " + this.yaw);
            }

            public synchronized CotDetail toCotDetail() {
                CotDetail cotDetail;
                cotDetail = new CotDetail(detailName);
                cotDetail.setAttribute("pitch", String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(this.pitch)}));
                cotDetail.setAttribute(adz.f608a, String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(this.roll)}));
                cotDetail.setAttribute("yaw", String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(this.yaw)}));
                Integer num = this.epitch;
                if (num != null) {
                    cotDetail.setAttribute("ePitch", Integer.toString(num.intValue()));
                }
                Integer num2 = this.eroll;
                if (num2 != null) {
                    cotDetail.setAttribute("eRoll", Integer.toString(num2.intValue()));
                }
                Integer num3 = this.eyaw;
                if (num3 != null) {
                    cotDetail.setAttribute("eYaw", Integer.toString(num3.intValue()));
                }
                return cotDetail;
            }
        }

        public static class SpinDetail {
            public static final String detailName = "spin";
            public Integer epitchRate = 2;
            public Integer erollRate = 2;
            public Integer eyawRate = 2;
            public double pitchRate;
            public double rollRate;
            public double yawRate;

            public synchronized void Log(int i, String str) {
                Log.println(i, str, "\tspin:");
                Log.println(i, str, "\t\tPitch Rate: " + this.pitchRate);
                Log.println(i, str, "\t\tRoll Rate: " + this.rollRate);
                Log.println(i, str, "\t\tYaw Rate: " + this.yawRate);
            }

            public synchronized CotDetail toCotDetail() {
                CotDetail cotDetail;
                cotDetail = new CotDetail(detailName);
                cotDetail.setAttribute("pitch", String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(this.pitchRate)}));
                cotDetail.setAttribute(adz.f608a, String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(this.rollRate)}));
                cotDetail.setAttribute("yaw", String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(this.yawRate)}));
                Integer num = this.epitchRate;
                if (num != null) {
                    cotDetail.setAttribute("ePitch", Integer.toString(num.intValue()));
                }
                Integer num2 = this.erollRate;
                if (num2 != null) {
                    cotDetail.setAttribute("eRoll", Integer.toString(num2.intValue()));
                }
                Integer num3 = this.eyawRate;
                if (num3 != null) {
                    cotDetail.setAttribute("eYaw", Integer.toString(num3.intValue()));
                }
                return cotDetail;
            }
        }

        public synchronized void Log(int i, String str) {
            this.attitudeDetail.Log(i, str);
            this.spinDetail.Log(i, str);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            AttitudeDetail attitudeDetail2 = this.attitudeDetail;
            if (attitudeDetail2 != null) {
                cotDetail.addChild(attitudeDetail2.toCotDetail());
            }
            SpinDetail spinDetail2 = this.spinDetail;
            if (spinDetail2 != null) {
                cotDetail.addChild(spinDetail2.toCotDetail());
            }
            return cotDetail;
        }
    }

    public static class VehicleDetail {
        public static final String detailName = "vehicle";
        public double batteryMaxCapacity = 100.0d;
        public double batteryRemainingCapacity;
        public short flightTime = 0;
        public String type;
        public String typeTag;
        public Double voltage;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\tvehicle:");
            Log.println(i, str, "\t\tTypeTag: " + this.typeTag);
            Log.println(i, str, "\t\tType: " + this.type);
            Log.println(i, str, "\t\tMax Battery Capacity: " + this.batteryMaxCapacity);
            Log.println(i, str, "\t\tBattery Remaining Capacity: " + this.batteryRemainingCapacity);
            Log.println(i, str, "\t\tFlight Time: " + this.flightTime);
            if (this.voltage != null) {
                Log.println(i, str, "\t\tVoltage: " + this.voltage);
            }
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("batteryMaxCapacity", String.format(Locale.US, "%01.0f", new Object[]{Double.valueOf(this.batteryMaxCapacity)}));
            cotDetail.setAttribute("batteryRemainingCapacity", String.format(Locale.US, "%01.2f", new Object[]{Double.valueOf(this.batteryRemainingCapacity)}));
            cotDetail.setAttribute("flightTime", Integer.toString(this.flightTime));
            if (this.voltage != null) {
                cotDetail.setAttribute("voltage", String.format(Locale.US, "%01.2f", new Object[]{this.voltage}));
            }
            cotDetail.setAttribute("type", this.type);
            cotDetail.setAttribute("typeTag", this.typeTag);
            return cotDetail;
        }
    }

    public static class EnvironmentDetail {
        public static final String detailName = "environment";
        public double temperature = 0.0d;
        public double windDirection = 0.0d;
        public double windSpeed = 0.0d;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\tenvironment:");
            Log.println(i, str, "\t\tWind Direction: " + this.windDirection);
            Log.println(i, str, "\t\tWind Speed: " + this.windSpeed);
            Log.println(i, str, "\t\tTemperature: " + this.temperature);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("windSpeed", String.format(Locale.US, "%01.1f", new Object[]{Double.valueOf(this.windSpeed)}));
            cotDetail.setAttribute("windDirection", String.format(Locale.US, "%01.2f", new Object[]{Double.valueOf(this.windDirection)}));
            cotDetail.setAttribute("temperature", String.format(Locale.US, "%01.2f", new Object[]{Double.valueOf(this.temperature)}));
            return cotDetail;
        }
    }

    public static class RadioDetail {
        public static final String detailName = "_radio";
        public int rssi = -100;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\t_radio:");
            Log.println(i, str, "\t\tRSSI: " + this.rssi);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("rssi", Integer.toString(this.rssi));
            return cotDetail;
        }
    }

    public static class WaypointDetail {
        public static final String detailName = "waypoint";
        public String description;
        public String name;
        public GeoPoint point;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\t\tWaypoint Name: " + this.name);
            Log.println(i, str, "\t\t\tWaypoint Description: " + this.description);
            Log.println(i, str, "\t\t\tWaypoint Location: " + this.point.toString());
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute(UASTask.COTDETAIL_NAME, "Waypoint-" + this.name);
            cotDetail.setAttribute("description", "point " + this.description);
            CotDetail cotDetail2 = new CotDetail("point");
            CotPoint cotPoint = new CotPoint(this.point);
            cotDetail2.setAttribute(FlightLogger.LOCS_LATITUDE, String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getLat())}));
            cotDetail2.setAttribute(FlightLogger.LOCS_LONGITUDE, String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getLon())}));
            cotDetail2.setAttribute("hae", String.format(Locale.US, "%01.0f", new Object[]{Double.valueOf(cotPoint.getHae())}));
            return cotDetail;
        }
    }

    public static class WaypointCollectionDetail {
        public static final String detailName = "waypointCollection";
        public List<WaypointDetail> waypoints;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\tWaypoints: ");
            List<WaypointDetail> list = this.waypoints;
            if (list != null) {
                if (!list.isEmpty()) {
                    for (WaypointDetail Log : this.waypoints) {
                        Log.Log(i, str);
                    }
                    return;
                }
            }
            Log.println(i, str, "\tNo Waypoints ");
        }

        public synchronized CotDetail toCotDetail() {
            List<WaypointDetail> list = this.waypoints;
            if (list != null) {
                if (!list.isEmpty()) {
                    CotDetail cotDetail = new CotDetail(detailName);
                    for (WaypointDetail cotDetail2 : this.waypoints) {
                        cotDetail.addChild(cotDetail2.toCotDetail());
                    }
                    return cotDetail;
                }
            }
            return null;
        }

        public synchronized void clear() {
            this.waypoints.clear();
        }

        public void AddWaypointDetail(String str, String str2, GeoPoint geoPoint) {
            WaypointDetail waypointDetail = new WaypointDetail();
            waypointDetail.name = str;
            waypointDetail.description = str2;
            waypointDetail.point = new GeoPoint(geoPoint);
            this.waypoints.add(waypointDetail);
        }
    }

    public WaypointCollectionDetail acquireWaypointCollectionDetail() {
        if (this.waypointCollectionDetail == null) {
            this.waypointCollectionDetail = new WaypointCollectionDetail();
        }
        return this.waypointCollectionDetail;
    }

    public static class CommandedDataDetail {
        public static final String detailName = "commandedData";
        public double climbRate;
        public GeoPoint point;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\tcommandedData:");
            Log.println(i, str, "\t\tClimb Rate: " + this.climbRate);
            Log.println(i, str, "\t\tPoint: " + this.point.toString());
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("climbRate", String.format(Locale.US, "%01.2f", new Object[]{Double.valueOf(this.climbRate)}));
            CotPoint cotPoint = new CotPoint(this.point);
            CotDetail cotDetail2 = new CotDetail("point");
            cotDetail2.setAttribute(FlightLogger.LOCS_LATITUDE, String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getLat())}));
            cotDetail2.setAttribute(FlightLogger.LOCS_LONGITUDE, String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getLon())}));
            cotDetail2.setAttribute("hae", String.format(Locale.US, "%01.6f", new Object[]{Double.valueOf(cotPoint.getHae())}));
            cotDetail2.setAttribute(UASPoint.COTDETAIL_CE, Double.toString(cotPoint.getCe()));
            cotDetail2.setAttribute(UASPoint.COTDETAIL_LE, Double.toString(cotPoint.getLe()));
            cotDetail.addChild(cotDetail2);
            return cotDetail;
        }
    }

    public CommandedDataDetail acquireCommandedDataDetail() {
        if (this.commandedDataDetail == null) {
            this.commandedDataDetail = new CommandedDataDetail();
        }
        return this.commandedDataDetail;
    }

    public static class VideoDetail {
        public static final String detailName = "__video";
        public String callsign = null;
        public String fragment = null;
        public String host = null;
        public boolean isBroadcasting = false;
        public String localUri;
        public String path = null;
        public int port = -1;
        public String query = null;
        public String scheme = "udp";
        public String url;
        public String userinfo = null;

        public String getAbsoluteUri() {
            try {
                String str = this.path;
                if (str != null && str.startsWith("/")) {
                    this.path = "/" + this.path;
                }
                return new URI(this.scheme, this.userinfo, this.host, this.port, this.path, this.query, this.fragment).toString();
            } catch (URISyntaxException unused) {
                return null;
            }
        }

        public String getUrl() {
            String str = this.url;
            if (str == null || str.isEmpty()) {
                return getAbsoluteUri();
            }
            return this.url;
        }

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\t__video:");
            Log.println(i, str, "\t\tURL: " + getUrl());
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            String url2 = getUrl();
            if ((this.isBroadcasting && url2 != null && !url2.isEmpty()) || this.localUri != null) {
                if (this.isBroadcasting) {
                    cotDetail.setAttribute(DownloadTask.URL, url2);
                } else {
                    cotDetail.setAttribute(DownloadTask.URL, this.localUri);
                }
                cotDetail.setAttribute(SensorDetail.detailName, this.callsign);
                cotDetail.setAttribute("spi", this.callsign + ".SPI1");
            }
            return cotDetail;
        }
    }

    public VideoDetail acquireVideoDetail() {
        if (this.videoDetail == null) {
            this.videoDetail = new VideoDetail();
        }
        return this.videoDetail;
    }

    public static class PrecisionLocationDetail {
        public static final String detailName = "precisionlocation";
        public String altsrc = "DTED0";
        public String calc = "Calc";

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\tprecisionlocation:");
            Log.println(i, str, "\t\tCalc: " + this.calc);
            Log.println(i, str, "\t\tAlt Src: " + this.altsrc);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("geopointsrc", this.calc);
            cotDetail.setAttribute("altsrc", this.altsrc);
            return cotDetail;
        }
    }

    public PrecisionLocationDetail acquirePrecisionLocationDetail() {
        if (this.precisionLocationDetail == null) {
            this.precisionLocationDetail = new PrecisionLocationDetail();
        }
        return this.precisionLocationDetail;
    }

    public static class LinkDetail {
        public static final String detailName = "link";
        public final String relation = "p-p";
        public final String type = "a-f-G-U-C";
        public String uid;

        public synchronized void Log(int i, String str) {
            Log.println(i, str, "\tlink:");
            Log.println(i, str, "\t\tUID: " + this.uid);
        }

        public synchronized CotDetail toCotDetail() {
            CotDetail cotDetail;
            cotDetail = new CotDetail(detailName);
            cotDetail.setAttribute("relation", "p-p");
            cotDetail.setAttribute(UASTask.COTDETAIL_UID, this.uid);
            cotDetail.setAttribute("type", "a-f-G-U-C");
            return cotDetail;
        }
    }

    public LinkDetail acquireLinkDetail() {
        if (this.linkDetail == null) {
            this.linkDetail = new LinkDetail();
        }
        return this.linkDetail;
    }

    public void Log(int i, String str) {
        this.contactDetail.Log(i, str);
        Log.println(i, str, "\tLongitude: " + this.airframeLocation.getLongitude());
        Log.println(i, str, "\tLatitude: " + this.airframeLocation.getLatitude());
        UASToolDetail uASToolDetail = this.uasToolDetail;
        if (uASToolDetail != null) {
            uASToolDetail.Log(i, str);
        }
        AVDetail aVDetail = this.avDetail;
        if (aVDetail != null) {
            aVDetail.Log(i, str);
        }
        DJIDetail dJIDetail = this.djiDetail;
        if (dJIDetail != null) {
            dJIDetail.Log(i, str);
        }
        PDDetail pDDetail = this.pdDetail;
        if (pDDetail != null) {
            pDDetail.Log(i, str);
        }
        TrackDetail trackDetail2 = this.trackDetail;
        if (trackDetail2 != null) {
            trackDetail2.Log(i, str);
        }
        SensorDetail sensorDetail2 = this.sensorDetail;
        if (sensorDetail2 != null) {
            sensorDetail2.Log(i, str);
        }
        SpatialDetail spatialDetail2 = this.spatialDetail;
        if (spatialDetail2 != null) {
            spatialDetail2.Log(i, str);
        }
        VehicleDetail vehicleDetail2 = this.vehicleDetail;
        if (vehicleDetail2 != null) {
            vehicleDetail2.Log(i, str);
        }
        EnvironmentDetail environmentDetail2 = this.environmentDetail;
        if (environmentDetail2 != null) {
            environmentDetail2.Log(i, str);
        }
        RadioDetail radioDetail2 = this.radioDetail;
        if (radioDetail2 != null) {
            radioDetail2.Log(i, str);
        }
        WaypointCollectionDetail waypointCollectionDetail2 = this.waypointCollectionDetail;
        if (waypointCollectionDetail2 != null) {
            waypointCollectionDetail2.Log(i, str);
        }
        CommandedDataDetail commandedDataDetail2 = this.commandedDataDetail;
        if (commandedDataDetail2 != null) {
            commandedDataDetail2.Log(i, str);
        }
        VideoDetail videoDetail2 = this.videoDetail;
        if (videoDetail2 != null) {
            videoDetail2.Log(i, str);
        }
        PrecisionLocationDetail precisionLocationDetail2 = this.precisionLocationDetail;
        if (precisionLocationDetail2 != null) {
            precisionLocationDetail2.Log(i, str);
        }
        LinkDetail linkDetail2 = this.linkDetail;
        if (linkDetail2 != null) {
            linkDetail2.Log(i, str);
        }
    }

    public CotEvent createCotUASEvent(CoordinatedTime coordinatedTime, String str, String str2) {
        CotEvent cotEvent = new CotEvent();
        cotEvent.setUID(str2);
        cotEvent.setType(str);
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(coordinatedTime.addMilliseconds(3500));
        cotEvent.setHow("m-g");
        cotEvent.setQos("1-r-c");
        cotEvent.setPoint(new CotPoint(this.airframeLocation));
        CotDetail cotDetail = new CotDetail();
        addOrUpdateCotFlowtags(cotDetail, "GCS");
        UASToolDetail uASToolDetail = this.uasToolDetail;
        if (uASToolDetail != null) {
            cotDetail.addChild(uASToolDetail.toCotDetail());
        }
        AVDetail aVDetail = this.avDetail;
        if (aVDetail != null) {
            cotDetail.addChild(aVDetail.toCotDetail());
        }
        DJIDetail dJIDetail = this.djiDetail;
        if (dJIDetail != null) {
            cotDetail.addChild(dJIDetail.toCotDetail());
        }
        ContactDetail contactDetail2 = this.contactDetail;
        if (contactDetail2 != null) {
            cotDetail.addChild(contactDetail2.toCotDetail());
        }
        PayloadDetail payloadDetail2 = this.payloadDetail;
        if (payloadDetail2 != null) {
            cotDetail.addChild(payloadDetail2.toCotDetail());
        }
        TrackDetail trackDetail2 = this.trackDetail;
        if (trackDetail2 != null) {
            cotDetail.addChild(trackDetail2.toCotDetail());
        }
        SensorDetail sensorDetail2 = this.sensorDetail;
        if (sensorDetail2 != null) {
            cotDetail.addChild(sensorDetail2.toCotDetail());
        }
        SpatialDetail spatialDetail2 = this.spatialDetail;
        if (spatialDetail2 != null) {
            cotDetail.addChild(spatialDetail2.toCotDetail());
        }
        VehicleDetail vehicleDetail2 = this.vehicleDetail;
        if (vehicleDetail2 != null) {
            cotDetail.addChild(vehicleDetail2.toCotDetail());
        }
        EnvironmentDetail environmentDetail2 = this.environmentDetail;
        if (environmentDetail2 != null) {
            cotDetail.addChild(environmentDetail2.toCotDetail());
        }
        RadioDetail radioDetail2 = this.radioDetail;
        if (radioDetail2 != null) {
            cotDetail.addChild(radioDetail2.toCotDetail());
        }
        WaypointCollectionDetail waypointCollectionDetail2 = this.waypointCollectionDetail;
        if (waypointCollectionDetail2 != null) {
            cotDetail.addChild(waypointCollectionDetail2.toCotDetail());
        }
        CommandedDataDetail commandedDataDetail2 = this.commandedDataDetail;
        if (commandedDataDetail2 != null) {
            cotDetail.addChild(commandedDataDetail2.toCotDetail());
        }
        VideoDetail videoDetail2 = this.videoDetail;
        if (videoDetail2 != null) {
            cotDetail.addChild(videoDetail2.toCotDetail());
        }
        LinkDetail linkDetail2 = this.linkDetail;
        if (linkDetail2 != null) {
            cotDetail.addChild(linkDetail2.toCotDetail());
        }
        PrecisionLocationDetail precisionLocationDetail2 = this.precisionLocationDetail;
        if (precisionLocationDetail2 != null) {
            cotDetail.addChild(precisionLocationDetail2.toCotDetail());
        }
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    public static String formatTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(date);
    }

    public static CotEvent createCotEvent(String str, String str2, GeoPoint geoPoint, String str3, String str4, List<CotDetail> list, int i) {
        CotEvent cotEvent = new CotEvent();
        cotEvent.setUID(str2);
        cotEvent.setType(str);
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CoordinatedTime addSeconds = coordinatedTime.addSeconds(i);
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(addSeconds);
        cotEvent.setHow("h-e");
        cotEvent.setPoint(new CotPoint(geoPoint));
        CotDetail cotDetail = new CotDetail();
        addOrUpdateCotFlowtags(cotDetail, "uastool_operator");
        addOrUpdateCotRequest(cotDetail, str4, str3);
        if (list != null && !list.isEmpty()) {
            for (CotDetail addChild : list) {
                cotDetail.addChild(addChild);
            }
        }
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    public static void addOrUpdateCotFlowtags(CotDetail cotDetail, String str) {
        if (str != null && !str.isEmpty()) {
            CotDetail firstChildByName = cotDetail.getFirstChildByName(0, "_flow-tags_");
            if (firstChildByName == null) {
                firstChildByName = new CotDetail("_flow-tags_");
                cotDetail.addChild(firstChildByName);
            }
            firstChildByName.setAttribute(str, formatTime(new Date()));
        }
    }

    public static void addOrUpdateCotContactCallsign(CotDetail cotDetail, String str) {
        if (str != null && !str.isEmpty()) {
            CotDetail firstChildByName = cotDetail.getFirstChildByName(0, ContactDetail.detailName);
            if (firstChildByName == null) {
                firstChildByName = new CotDetail(ContactDetail.detailName);
                cotDetail.addChild(firstChildByName);
            }
            firstChildByName.setAttribute(FlightLogger.LOG_CALLSIGN, str);
        }
    }

    public static void addOrUpdateCotLink(CotDetail cotDetail, String str, String str2, String str3) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            CotDetail firstChildByName = cotDetail.getFirstChildByName(0, LinkDetail.detailName);
            if (firstChildByName == null) {
                firstChildByName = new CotDetail(LinkDetail.detailName);
                cotDetail.addChild(firstChildByName);
            }
            if (str3 == null) {
                str3 = "p-p";
            }
            firstChildByName.setAttribute("relation", str3);
            firstChildByName.setAttribute("type", str2);
            firstChildByName.setAttribute(UASTask.COTDETAIL_UID, str);
        }
    }

    public static void addOrUpdateCotRequest(CotDetail cotDetail, String str, String str2) {
        if (!str2.isEmpty() && !str.isEmpty()) {
            CotDetail cotDetail2 = new CotDetail("request");
            cotDetail2.setAttribute("notify", str);
            cotDetail2.setAttribute("to", str2);
            cotDetail.addChild(cotDetail2);
        }
    }

    public static void addOrUpdateCotShapePolylineClosed(CotDetail cotDetail, boolean z) {
        CotDetail firstChildByName;
        CotDetail firstChildByName2 = cotDetail.getFirstChildByName(0, "shape");
        if (firstChildByName2 != null && (firstChildByName = firstChildByName2.getFirstChildByName(0, "polyline")) != null) {
            firstChildByName.setAttribute("closed", z ? "true" : "false");
        }
    }

    public static void ensureNonZeroAttitudePitchRollYaw(CotDetail cotDetail, double d, double d2, double d3) {
        CotDetail firstChildByName;
        CotDetail cotDetail2 = cotDetail;
        CotDetail firstChildByName2 = cotDetail.getFirstChildByName(0, SpatialDetail.detailName);
        if (firstChildByName2 != null && (firstChildByName = firstChildByName2.getFirstChildByName(0, SpatialDetail.AttitudeDetail.detailName)) != null) {
            Double attributeAsDouble = getAttributeAsDouble(firstChildByName, "pitch");
            Double attributeAsDouble2 = getAttributeAsDouble(firstChildByName, adz.f608a);
            Double attributeAsDouble3 = getAttributeAsDouble(firstChildByName, adz.f608a);
            if (attributeAsDouble.isNaN() || attributeAsDouble2.isNaN() || attributeAsDouble3.isNaN() || (attributeAsDouble.doubleValue() == 0.0d && attributeAsDouble2.doubleValue() == 0.0d && attributeAsDouble3.doubleValue() == 0.0d)) {
                firstChildByName.setAttribute("pitch", String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(d)}));
                firstChildByName.setAttribute(adz.f608a, String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(d2)}));
                firstChildByName.setAttribute("yaw", String.format(Locale.US, "%01.3f", new Object[]{Double.valueOf(d3)}));
            }
        }
    }

    private static Double getAttributeAsDouble(CotDetail cotDetail, String str) {
        try {
            String attribute = cotDetail.getAttribute(str);
            if (attribute != null && !attribute.isEmpty()) {
                return Double.valueOf(Double.parseDouble(attribute));
            }
        } catch (NumberFormatException unused) {
        }
        return Double.valueOf(Double.NaN);
    }
}
