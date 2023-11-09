package com.atakmap.android.uastool.utils;

import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.coremap.conversions.Span;
import com.atakmap.coremap.conversions.SpanUtilities;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.cot.event.CotPoint;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.DirectionType;
import com.atakmap.coremap.maps.coords.DistanceCalculations;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import com.autel.downloader.bean.DownloadTask;
import indago.serialization.JsonValueConstants;

public final class UASItemUtils {
    private static final String TAG = "UASItemUtils";

    public static CotEvent buildCotEventFromUasItem(UASItem uASItem, boolean z, boolean z2, String str) {
        String callsign = uASItem.getCallsign();
        String videoBroadcastDestinationUrl = UASToolDropDownReceiver.getInstance().getVideoBroadcastDestinationUrl();
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CotEvent cotEvent = new CotEvent();
        cotEvent.setVersion("2.0");
        cotEvent.setUID(uASItem.getUid());
        cotEvent.setType(uASItem.getType());
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(coordinatedTime.addMilliseconds(3500));
        cotEvent.setHow("m-g");
        cotEvent.setQos("1-r-c");
        cotEvent.setPoint(new CotPoint(uASItem.getGeoPoint()));
        CotDetail cotDetail = new CotDetail();
        CotDetail cotDetail2 = new CotDetail("_flow-tags_");
        cotDetail2.setAttribute("GCS", coordinatedTime.toString());
        cotDetail.addChild(cotDetail2);
        CotDetail cotDetail3 = new CotDetail(UasC2Event.UASToolDetail.detailName);
        cotDetail3.setAttribute("extendedCot", "true");
        cotDetail.addChild(cotDetail3);
        CotDetail cotDetail4 = new CotDetail(UasC2Event.ContactDetail.detailName);
        cotDetail4.setAttribute(FlightLogger.LOG_CALLSIGN, callsign);
        cotDetail.addChild(cotDetail4);
        CotDetail cotDetail5 = new CotDetail(UasC2Event.VideoDetail.detailName);
        if (z2 || str != null) {
            if (z2) {
                cotDetail5.setAttribute(DownloadTask.URL, videoBroadcastDestinationUrl);
            } else {
                cotDetail5.setAttribute(DownloadTask.URL, str);
            }
            cotDetail5.setAttribute(UasC2Event.SensorDetail.detailName, callsign);
            cotDetail5.setAttribute("spi", callsign + ".SPI1");
        }
        cotDetail.addChild(cotDetail5);
        CotDetail cotDetail6 = new CotDetail(UasC2Event.LinkDetail.detailName);
        cotDetail6.setAttribute("relation", "p-p");
        cotDetail6.setAttribute(UASTask.COTDETAIL_UID, MapView.getDeviceUid());
        cotDetail6.setAttribute("type", "a-f-G-U-C");
        cotDetail.addChild(cotDetail6);
        CotDetail cotDetail7 = new CotDetail(UasC2Event.PrecisionLocationDetail.detailName);
        cotDetail7.setAttribute("geopointsrc", "Calc");
        cotDetail7.setAttribute("altsrc", "DTED0");
        cotDetail.addChild(buildVehicleTag(uASItem));
        CotDetail cotDetail8 = new CotDetail(UasC2Event.SensorDetail.detailName);
        cotDetail8.setAttribute("azimuth", String.format(LocaleUtil.US, "%.1f", new Object[]{Double.valueOf(uASItem.getGimbalAngle())}));
        cotDetail8.setAttribute("elevation", String.format(LocaleUtil.US, "%.1f", new Object[]{Double.valueOf(uASItem.getGimbalPitch())}));
        cotDetail8.setAttribute("fov", String.format(LocaleUtil.US, "%.1f", new Object[]{Double.valueOf(uASItem.getHFOV())}));
        cotDetail8.setAttribute("version", "0.3");
        cotDetail8.setAttribute("type", "r-e");
        cotDetail.addChild(cotDetail8);
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    private static CotDetail buildVehicleTag(UASItem uASItem) {
        CotDetail cotDetail = new CotDetail(UasC2Event.VehicleDetail.detailName);
        cotDetail.setAttribute("typeTag", uASItem.PLATFORM_DETAIL_TAG);
        cotDetail.setAttribute("type", uASItem.getPlatformType());
        cotDetail.setAttribute("batteryMaxCapacity", UIPreferenceFragment.DEFAULT_UI_SCALE);
        cotDetail.setAttribute("batteryRemainingCapacity", String.format("%.2f", new Object[]{Double.valueOf(uASItem.getBatteryPercent() * 100.0d)}));
        return cotDetail;
    }

    public static CotEvent buildSPICotEvent(UASItem uASItem, FieldOfView fieldOfView) {
        GeoPoint sPoIPoint = uASItem.getSPoIPoint();
        if (sPoIPoint == null) {
            Log.d(TAG, "Cannot create a SPI event without point information");
            return null;
        }
        CoordinatedTime coordinatedTime = new CoordinatedTime();
        CotEvent cotEvent = new CotEvent();
        cotEvent.setVersion("2.0");
        cotEvent.setUID(uASItem.getUid() + ".SPI1");
        cotEvent.setType("b-m-p-s-p-i");
        cotEvent.setTime(coordinatedTime);
        cotEvent.setStart(coordinatedTime);
        cotEvent.setStale(coordinatedTime.addMilliseconds(3500));
        cotEvent.setHow("m-g");
        cotEvent.setPoint(new CotPoint(sPoIPoint));
        CotDetail cotDetail = new CotDetail();
        CotDetail cotDetail2 = new CotDetail(UasC2Event.ContactDetail.detailName);
        cotDetail2.setAttribute(FlightLogger.LOG_CALLSIGN, uASItem.getCallsign() + ".SPI1");
        cotDetail.addChild(cotDetail2);
        CotDetail cotDetail3 = new CotDetail(UasC2Event.LinkDetail.detailName);
        cotDetail3.setAttribute("relation", "p-p");
        cotDetail3.setAttribute(UASTask.COTDETAIL_UID, uASItem.getUid());
        cotDetail3.setAttribute("type", UASToolConstants.UAS_FIXED_TYPE);
        cotDetail.addChild(cotDetail3);
        if (fieldOfView == null || !fieldOfView.isValid()) {
            Log.d(TAG, "No SPI View Bounds");
        } else {
            Log.d(TAG, "Building SPI View Bounds");
            cotDetail.addChild(fieldOfView.getSpiShape());
        }
        CotDetail cotDetail4 = new CotDetail(UasC2Event.PrecisionLocationDetail.detailName);
        cotDetail4.setAttribute("geopointsrc", "Calc");
        cotDetail4.setAttribute("altsrc", "DTED0");
        cotEvent.setDetail(cotDetail);
        return cotEvent;
    }

    public static String getString(Double d) {
        if (d.isNaN()) {
            return JsonValueConstants.VERSION;
        }
        double pow = Math.pow(10.0d, -5.0d);
        if (d.doubleValue() >= (-pow) && d.doubleValue() <= pow) {
            return JsonValueConstants.VERSION;
        }
        return String.format("%.10f", new Object[]{d});
    }

    public static String getRangeToAircraftDisplay(UASItem uASItem) {
        GeoPoint C;
        int rangeFormat = UASToolDropDownReceiver.getRangeFormat();
        GeoPoint geoPoint = uASItem.getGeoPoint();
        if (!(geoPoint == null || (C = MapView.getMapView().getSelfMarker().C()) == null)) {
            double distanceTo = C.distanceTo(geoPoint);
            if (!Double.isNaN(distanceTo)) {
                return SpanUtilities.formatType(rangeFormat, distanceTo, Span.METER);
            }
        }
        return UASToolConstants.DASHES;
    }

    public static String getBearingToAircraftDisplay(UASItem uASItem) {
        GeoPoint C;
        GeoPoint geoPoint = uASItem.getGeoPoint();
        if (!(geoPoint == null || (C = MapView.getMapView().getSelfMarker().C()) == null)) {
            double bearingTo = C.bearingTo(geoPoint);
            if (!Double.isNaN(bearingTo)) {
                return DirectionType.getDirection(bearingTo).getAbbreviation() + " " + Utils.formatHeading(C, bearingTo);
            }
        }
        return UASToolConstants.DASHES;
    }

    public static String getSlantRangeToTarget(UASItem uASItem) {
        GeoPoint sPoIPoint;
        int rangeFormat = UASToolDropDownReceiver.getRangeFormat();
        GeoPoint geoPoint = uASItem.getGeoPoint();
        if (!(geoPoint == null || (sPoIPoint = uASItem.getSPoIPoint()) == null)) {
            double calculateSlantRange = DistanceCalculations.calculateSlantRange(geoPoint, sPoIPoint);
            if (!Double.isNaN(calculateSlantRange)) {
                return SpanUtilities.formatType(rangeFormat, calculateSlantRange, Span.METER);
            }
        }
        return UASToolConstants.DASHES;
    }

    public static String getBearingToTarget(UASItem uASItem) {
        GeoPoint sPoIPoint;
        GeoPoint geoPoint = uASItem.getGeoPoint();
        if (!(geoPoint == null || (sPoIPoint = uASItem.getSPoIPoint()) == null)) {
            double bearingTo = geoPoint.bearingTo(sPoIPoint);
            if (!Double.isNaN(bearingTo)) {
                return Utils.formatHeading(geoPoint, bearingTo);
            }
        }
        return UASToolConstants.DASHES;
    }
}
