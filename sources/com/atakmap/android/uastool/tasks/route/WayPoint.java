package com.atakmap.android.uastool.tasks.route;

import android.content.SharedPreferences;
import android.os.Parcel;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.TasksFragment;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.utils.UasMapItemIconUtil;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.assets.Icon;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.UUID;
import org.w3c.dom.Element;

public class WayPoint extends UASPoint {
    public static final String COTDETAIL_WP_FINISHACTION = "finish_action";
    public static final String COTDETAIL_WP_FLIGHTMODE = "flight_mode";
    public static final String COTDETAIL_WP_GOTOMODE = "goto_mode";
    public static final String COTDETAIL_WP_HEADING = "heading";
    public static final String COT_TAG = "WayPoint";
    public static final String PREFIX = "WP-";
    private static final String TAG = "WayPoint";
    protected String flightMode;
    protected String gotoMode;
    protected String heading;

    public WayPoint(String str, String str2, int i, float f, float f2, boolean z, boolean z2, GeoPoint geoPoint) {
        super(str, str2, i, f, f2, z, z2, geoPoint, C1877R.drawable.waypoint, UASPoint.POINTTYPE.WAYPOINT);
        init("Normal", UASPoint.GOTO_SAFELY, "Remote Controller", UASPoint.FINISH_ACTION.NO_ACTION);
    }

    public WayPoint(String str, String str2, int i, float f, float f2, boolean z, boolean z2, GeoPoint geoPoint, String str3, String str4, String str5, UASPoint.FINISH_ACTION finish_action) {
        super(str, str2, i, f, f2, z, z2, geoPoint, C1877R.drawable.waypoint, UASPoint.POINTTYPE.WAYPOINT);
        init(str4, str5, str3, finish_action);
    }

    public WayPoint(UASPoint uASPoint, String str) {
        super(uASPoint.getUID(), uASPoint.getName(), uASPoint.getIndex(), uASPoint.getSpeed(), uASPoint.getAGL(), uASPoint.getLookAtPoint(), uASPoint.getTakeoff(), uASPoint.C(), C1877R.drawable.waypoint, UASPoint.POINTTYPE.WAYPOINT);
        float capabilityValueDouble = (float) UASItem.getCapabilityValueDouble((UASItem) null, str, UASItemCapabilities.VALUE_ROUTE_SPEED_MIN, 0.0d);
        float capabilityValueDouble2 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str, UASItemCapabilities.VALUE_ROUTE_SPEED_MAX, 0.0d);
        float speed = getSpeed();
        if (speed < capabilityValueDouble) {
            setSpeed(capabilityValueDouble);
        }
        if (speed > capabilityValueDouble2) {
            setSpeed(capabilityValueDouble2);
        }
        float capabilityValueDouble3 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str, UASItemCapabilities.VALUE_ROUTE_AGL_MIN, 0.0d);
        float capabilityValueDouble4 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str, UASItemCapabilities.VALUE_ROUTE_AGL_MAX, 0.0d);
        float agl = getAGL();
        if (agl < capabilityValueDouble3) {
            setAGL(capabilityValueDouble3);
        }
        if (agl > capabilityValueDouble4) {
            setAGL(capabilityValueDouble4);
        }
        if (uASPoint.getGimbalPitch() != null) {
            setGimbalPitch(uASPoint.getGimbalPitch().intValue());
        }
        if (uASPoint instanceof WayPoint) {
            WayPoint wayPoint = (WayPoint) uASPoint;
            init(wayPoint.getFlightMode(), wayPoint.getGotoMode(), wayPoint.getHeading(), wayPoint.getFinishAction());
            return;
        }
        if (uASPoint.usingPrefixName()) {
            super.setTitle(PREFIX + this.index);
        }
        init("Normal", UASPoint.GOTO_SAFELY, "Remote Controller", UASPoint.FINISH_ACTION.NO_ACTION);
    }

    private void init(String str, String str2, String str3, UASPoint.FINISH_ACTION finish_action) {
        this.flightMode = str;
        this.gotoMode = str2;
        this.heading = str3;
        this.finishAction = finish_action;
    }

    public WayPoint(Parcel parcel) {
        super(parcel);
        init(parcel.readString(), parcel.readString(), parcel.readString(), UASPoint.FINISH_ACTION.fromCotValue(parcel.readString()));
    }

    public String getDescription(String str) {
        boolean booleanValue = UASItem.checkCapability((UASItem) null, str, UASItemCapabilities.CAPABILITY_ROUTE_POINT_TAKEOFF).booleanValue();
        boolean booleanValue2 = UASItem.checkCapability((UASItem) null, str, UASItemCapabilities.CAPABILITY_ROUTE_POINT_ALTITUDE).booleanValue();
        boolean booleanValue3 = UASItem.checkCapability((UASItem) null, str, UASItemCapabilities.CAPABILITY_ROUTE_POINT_FINISHACTION).booleanValue();
        String valueOf = String.valueOf(this.index);
        if (booleanValue2) {
            valueOf = valueOf + " / " + TasksFragment.convertAltitudeToDisplay(this) + " " + UASToolDropDownReceiver.getAltitudeUnitsFormatLabel();
        }
        String str2 = "";
        if (booleanValue) {
            StringBuilder sb = new StringBuilder();
            sb.append(valueOf);
            sb.append(this.takeOff ? " / TakeOff!" : str2);
            valueOf = sb.toString();
        }
        if (!booleanValue3 || this.finishAction == null) {
            return valueOf;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(valueOf);
        if (this.finishAction != UASPoint.FINISH_ACTION.NO_ACTION) {
            str2 = " / " + this.finishAction.getCotValue();
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public static WayPoint fromScratch(UASItem uASItem, int i, GeoPoint geoPoint, String str) {
        UASItem uASItem2 = uASItem;
        int i2 = i;
        String str2 = str;
        String uuid = UUID.randomUUID().toString();
        boolean booleanValue = UASItem.checkCapability(uASItem2, str2, UASItemCapabilities.CAPABILITY_ROUTE_POINT_TAKEOFF).booleanValue();
        boolean booleanValue2 = UASItem.checkCapability(uASItem2, str2, UASItemCapabilities.CAPABILITY_ROUTE_POINT_ALTITUDE).booleanValue();
        UASItem.checkCapability(uASItem2, str2, UASItemCapabilities.CAPABILITY_ROUTE_POINT_LOOKATPOINT).booleanValue();
        float f = 0.0f;
        float capabilityValueDouble = UASItem.checkCapability(uASItem2, str2, UASItemCapabilities.CAPABILITY_ROUTE_POINT_SPEED).booleanValue() ? (float) UASItem.getCapabilityValueDouble(uASItem2, str2, UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, 0.0d) : 0.0f;
        if (booleanValue2) {
            f = (float) UASItem.getCapabilityValueDouble(uASItem2, str2, UASItemCapabilities.VALUE_ROUTE_AGL_DEFAULT, 0.0d);
        }
        GeoPoint geoPoint2 = new GeoPoint(geoPoint.getLatitude(), geoPoint.getLongitude(), geoPoint.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE);
        boolean z = i2 == 1 && booleanValue;
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        float f2 = (float) sharedPrefs.getInt(UASToolPreferenceFragment.ROUTE_PREF_UASPOINT_ALTITUDE, (int) f);
        float f3 = (float) sharedPrefs.getInt(UASToolPreferenceFragment.ROUTE_PREF_UASPOINT_SPEED, (int) capabilityValueDouble);
        return new WayPoint(uuid, PREFIX + i2, i, f3, f2, false, z, geoPoint2);
    }

    public static WayPoint fromCot(Element element, String str) {
        return fromCot(element);
    }

    public static WayPoint fromCot(Element element) {
        Element element2 = element;
        if (!element.hasAttributes()) {
            return null;
        }
        String attribute = element2.getAttribute(UASTask.COTDETAIL_UID);
        String attribute2 = element2.getAttribute(UASTask.COTDETAIL_NAME);
        int parseInt = Integer.parseInt(element2.getAttribute(UASPoint.COTDETAIL_INDEX));
        float parseFloat = Float.parseFloat(element2.getAttribute(UASPoint.COTDETAIL_SPEED));
        float parseFloat2 = Float.parseFloat(element2.getAttribute(UASPoint.COTDETAIL_AGL));
        boolean parseBoolean = Boolean.parseBoolean(element2.getAttribute(UASPoint.COTDETAIL_LOOKATPOINT));
        boolean parseBoolean2 = Boolean.parseBoolean(element2.getAttribute(UASPoint.COTDETAIL_TAKEOFF));
        float parseFloat3 = Float.parseFloat(element2.getAttribute(UASPoint.COTDETAIL_LAT));
        float parseFloat4 = Float.parseFloat(element2.getAttribute(UASPoint.COTDETAIL_LON));
        WayPoint wayPoint = new WayPoint(attribute, attribute2, parseInt, parseFloat, parseFloat2, parseBoolean, parseBoolean2, new GeoPoint((double) parseFloat3, (double) parseFloat4, (double) Float.parseFloat(element2.getAttribute(UASPoint.COTDETAIL_ALT)), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE), element2.getAttribute("heading"), element2.getAttribute(COTDETAIL_WP_FLIGHTMODE), element2.getAttribute(COTDETAIL_WP_GOTOMODE), UASPoint.FINISH_ACTION.fromCotValue(element2.getAttribute("finish_action")));
        if (!element2.hasAttribute(UASPoint.COTDETAIL_GIMBALPITCH)) {
            return wayPoint;
        }
        wayPoint.setGimbalPitch(Integer.parseInt(element2.getAttribute(UASPoint.COTDETAIL_GIMBALPITCH)));
        return wayPoint;
    }

    public static WayPoint fromCot(CotDetail cotDetail, String str) {
        return fromCot(cotDetail);
    }

    public static WayPoint fromCot(CotDetail cotDetail) {
        CotDetail cotDetail2 = cotDetail;
        String attribute = cotDetail2.getAttribute(UASTask.COTDETAIL_UID);
        String attribute2 = cotDetail2.getAttribute(UASTask.COTDETAIL_NAME);
        int parseInt = Integer.parseInt(cotDetail2.getAttribute(UASPoint.COTDETAIL_INDEX));
        float parseFloat = Float.parseFloat(cotDetail2.getAttribute(UASPoint.COTDETAIL_SPEED));
        float parseFloat2 = Float.parseFloat(cotDetail2.getAttribute(UASPoint.COTDETAIL_AGL));
        boolean parseBoolean = Boolean.parseBoolean(cotDetail2.getAttribute(UASPoint.COTDETAIL_LOOKATPOINT));
        boolean parseBoolean2 = Boolean.parseBoolean(cotDetail2.getAttribute(UASPoint.COTDETAIL_TAKEOFF));
        float parseFloat3 = Float.parseFloat(cotDetail2.getAttribute(UASPoint.COTDETAIL_LAT));
        float parseFloat4 = Float.parseFloat(cotDetail2.getAttribute(UASPoint.COTDETAIL_LON));
        WayPoint wayPoint = new WayPoint(attribute, attribute2, parseInt, parseFloat, parseFloat2, parseBoolean, parseBoolean2, new GeoPoint((double) parseFloat3, (double) parseFloat4, (double) Float.parseFloat(cotDetail2.getAttribute(UASPoint.COTDETAIL_ALT)), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE), cotDetail2.getAttribute("heading"), cotDetail2.getAttribute(COTDETAIL_WP_FLIGHTMODE), cotDetail2.getAttribute(COTDETAIL_WP_GOTOMODE), UASPoint.FINISH_ACTION.fromCotValue(cotDetail2.getAttribute("finish_action")));
        if (cotDetail2.getAttribute(UASPoint.COTDETAIL_GIMBALPITCH) != null) {
            wayPoint.setGimbalPitch(Integer.parseInt(cotDetail2.getAttribute(UASPoint.COTDETAIL_GIMBALPITCH)));
        }
        return wayPoint;
    }

    public CotDetail toCot() {
        CotDetail cotDetail = new CotDetail("WayPoint");
        cotDetail.setAttribute("heading", this.heading);
        cotDetail.setAttribute(COTDETAIL_WP_FLIGHTMODE, this.flightMode);
        cotDetail.setAttribute(COTDETAIL_WP_GOTOMODE, this.gotoMode);
        cotDetail.setAttribute("finish_action", this.finishAction.getCotValue());
        return super.toCot(cotDetail);
    }

    public WayPoint copy(String str, int i, boolean z) {
        String uid = getUID();
        if (z) {
            uid = UUID.randomUUID().toString();
        }
        String str2 = uid;
        GeoPoint C = C();
        WayPoint wayPoint = new WayPoint(str2, str, i, this.speed, this.agl, this.lookAtPoint, this.takeOff, new GeoPoint(C.getLatitude(), C.getLongitude(), C.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE), this.heading, this.flightMode, this.gotoMode, this.finishAction);
        wayPoint.hal = this.hal;
        if (this.gimbalPitch != null) {
            wayPoint.setGimbalPitch(this.gimbalPitch.intValue());
        }
        return wayPoint;
    }

    public WayPoint copyAsWayPoint(String str, int i, boolean z) {
        return copy(str, i, z);
    }

    public void copyFrom(UASPoint uASPoint) {
        super.copyFrom(uASPoint);
        if (uASPoint instanceof WayPoint) {
            WayPoint wayPoint = (WayPoint) uASPoint;
            this.heading = wayPoint.getHeading();
            this.flightMode = wayPoint.getFlightMode();
            this.gotoMode = wayPoint.getGotoMode();
            this.finishAction = wayPoint.getFinishAction();
        } else {
            this.heading = "Remote Controller";
            this.flightMode = "Normal";
            this.gotoMode = UASPoint.GOTO_SAFELY;
            this.finishAction = UASPoint.FINISH_ACTION.NO_ACTION;
        }
        this.hal = uASPoint.getHAL();
    }

    public Icon getIcon(UasMapItemIconUtil.ICON_SIZE icon_size, int i) {
        return UasMapItemIconUtil.buildIcon(C1877R.drawable.waypoint, icon_size, UasMapItemIconUtil.ICON_ANCHOR.BOTTOM_CENTER, i);
    }

    public boolean usingPrefixName() {
        return getName().startsWith(PREFIX);
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public String getFlightMode() {
        return this.flightMode;
    }

    public void setFlightMode(String str) {
        this.flightMode = str;
    }

    public String getGotoMode() {
        return this.gotoMode;
    }

    public void setGotoMode(String str) {
        this.gotoMode = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(WayPoint.class.getSimpleName(), parcel, i);
        parcel.writeString(this.flightMode);
        parcel.writeString(this.gotoMode);
        parcel.writeString(this.heading);
        parcel.writeString(getFinishAction().getCotValue());
    }
}
