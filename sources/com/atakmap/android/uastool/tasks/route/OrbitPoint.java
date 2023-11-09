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
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.assets.Icon;
import com.atakmap.coremap.maps.coords.GeoCalculations;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.UUID;
import org.w3c.dom.Element;

public class OrbitPoint extends UASPoint {
    public static final String COTDETAIL_OP_FINISHACTION = "finish_action";
    public static final String COTDETAIL_OP_HEADING = "heading";
    public static final String COTDETAIL_ORBITCLOCKWISE = "orbitClockwise";
    public static final String COTDETAIL_ORBITCOUNT = "orbitCount";
    public static final String COTDETAIL_ORBITRADIUS = "orbitRadius";
    public static final String COTDETAIL_ORBITSPEED = "orbitSpeed";
    public static final String COT_TAG = "OrbitPoint";
    public static final String ORBITSPEED_UNITS_ANGULAR = "ANGULAR";
    public static final String ORBITSPEED_UNITS_LINEAR = "LINEAR";
    public static final String PREFIX = "OP-";
    private static final String TAG = "OrbitPoint";
    protected String heading;
    protected boolean orbitClockwise;
    protected int orbitCount;
    protected float orbitRadius;
    protected float orbitSpeed;

    public OrbitPoint(String str, String str2, int i, float f, float f2, boolean z, boolean z2, GeoPoint geoPoint, float f3, float f4, int i2, boolean z3) {
        super(str, str2, i, f, f2, z, z2, geoPoint, C1877R.drawable.orbitpoint, UASPoint.POINTTYPE.ORBITPOINT);
        init(f3, f4, i2, z3, "Towards Point", UASPoint.FINISH_ACTION.NO_ACTION);
    }

    public OrbitPoint(String str, String str2, int i, float f, float f2, boolean z, boolean z2, GeoPoint geoPoint, float f3, float f4, int i2, boolean z3, String str3, UASPoint.FINISH_ACTION finish_action) {
        super(str, str2, i, f, f2, z, z2, geoPoint, C1877R.drawable.orbitpoint, UASPoint.POINTTYPE.ORBITPOINT);
        init(f3, f4, i2, z3, str3, finish_action);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrbitPoint(UASPoint uASPoint, String str) {
        super(uASPoint.getUID(), uASPoint.getName(), uASPoint.getIndex(), uASPoint.getSpeed(), uASPoint.getAGL(), uASPoint.getLookAtPoint(), uASPoint.getTakeoff(), uASPoint.C(), C1877R.drawable.orbitpoint, UASPoint.POINTTYPE.ORBITPOINT);
        UASPoint uASPoint2 = uASPoint;
        String str2 = str;
        float capabilityValueDouble = (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_SPEED_MIN, 0.0d);
        float capabilityValueDouble2 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_SPEED_MAX, 0.0d);
        float speed = getSpeed();
        if (speed < capabilityValueDouble) {
            setSpeed(capabilityValueDouble);
        }
        if (speed > capabilityValueDouble2) {
            setSpeed(capabilityValueDouble2);
        }
        float capabilityValueDouble3 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_AGL_MIN, 0.0d);
        float capabilityValueDouble4 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_AGL_MAX, 0.0d);
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
        if (uASPoint2 instanceof OrbitPoint) {
            OrbitPoint orbitPoint = (OrbitPoint) uASPoint2;
            float capabilityValueDouble5 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MIN, 0.0d);
            float capabilityValueDouble6 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MAX, 0.0d);
            float orbitRadius2 = orbitPoint.getOrbitRadius();
            capabilityValueDouble5 = orbitRadius2 >= capabilityValueDouble5 ? orbitRadius2 : capabilityValueDouble5;
            capabilityValueDouble5 = capabilityValueDouble5 > capabilityValueDouble6 ? capabilityValueDouble6 : capabilityValueDouble5;
            float capabilityValueDouble7 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MIN, 0.0d);
            float capabilityValueDouble8 = (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MAX, 0.0d);
            float orbitSpeed2 = orbitPoint.getOrbitSpeed();
            capabilityValueDouble7 = orbitSpeed2 >= capabilityValueDouble7 ? orbitSpeed2 : capabilityValueDouble7;
            capabilityValueDouble8 = capabilityValueDouble7 <= capabilityValueDouble8 ? capabilityValueDouble7 : capabilityValueDouble8;
            int capabilityValueInt = UASItem.getCapabilityValueInt((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MIN, 0);
            int capabilityValueInt2 = UASItem.getCapabilityValueInt((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MAX, 0);
            int orbitCount2 = orbitPoint.getOrbitCount();
            capabilityValueInt = orbitCount2 >= capabilityValueInt ? orbitCount2 : capabilityValueInt;
            init(capabilityValueDouble5, capabilityValueDouble8, capabilityValueInt > capabilityValueInt2 ? capabilityValueInt2 : capabilityValueInt, orbitPoint.getOrbitClockwise(), orbitPoint.getHeading(), orbitPoint.getFinishAction());
            return;
        }
        if (uASPoint.usingPrefixName()) {
            super.setTitle(PREFIX + this.index);
        }
        init((float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_DEFAULT, 0.0d), (float) UASItem.getCapabilityValueDouble((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_DEFAULT, 0.0d), UASItem.getCapabilityValueInt((UASItem) null, str2, UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_DEFAULT, 0), false, "Towards Point", UASPoint.FINISH_ACTION.NO_ACTION);
    }

    private void init(float f, float f2, int i, boolean z, String str, UASPoint.FINISH_ACTION finish_action) {
        this.orbitRadius = f;
        this.orbitSpeed = f2;
        this.orbitCount = i;
        this.orbitClockwise = z;
        this.heading = str;
        this.finishAction = finish_action;
    }

    protected OrbitPoint(Parcel parcel) {
        super(parcel);
        init(parcel.readFloat(), parcel.readFloat(), parcel.readInt(), parcel.readByte() != 1 ? false : true, parcel.readString(), UASPoint.FINISH_ACTION.fromCotValue(parcel.readString()));
    }

    public String getMapPointDescription() {
        return String.format("%s\nOR:%s", new Object[]{super.getMapPointDescription(), Utils.formatRange((double) getOrbitRadius())});
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

    public static OrbitPoint fromScratch(UASItem uASItem, int i, GeoPoint geoPoint, String str) {
        boolean z;
        float f;
        UASItem uASItem2 = uASItem;
        int i2 = i;
        String str2 = str;
        String uuid = UUID.randomUUID().toString();
        boolean booleanValue = UASItem.checkCapability(uASItem2, str2, UASItemCapabilities.CAPABILITY_ROUTE_POINT_TAKEOFF).booleanValue();
        float capabilityValueDouble = (float) UASItem.getCapabilityValueDouble(uASItem2, str2, UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, 0.0d);
        float capabilityValueDouble2 = (float) UASItem.getCapabilityValueDouble(uASItem2, str2, UASItemCapabilities.VALUE_ROUTE_AGL_DEFAULT, 0.0d);
        float capabilityValueDouble3 = (float) UASItem.getCapabilityValueDouble(uASItem2, str2, UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_DEFAULT, 0.0d);
        float capabilityValueDouble4 = (float) UASItem.getCapabilityValueDouble(uASItem2, str2, UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_DEFAULT, 0.0d);
        int capabilityValueInt = UASItem.getCapabilityValueInt(uASItem2, str2, UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_DEFAULT, 0);
        GeoPoint geoPoint2 = new GeoPoint(geoPoint.getLatitude(), geoPoint.getLongitude(), geoPoint.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE);
        boolean z2 = i2 == 1 && booleanValue;
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        float f2 = (float) sharedPrefs.getInt(UASToolPreferenceFragment.ROUTE_PREF_UASPOINT_ALTITUDE, (int) capabilityValueDouble2);
        float f3 = (float) sharedPrefs.getInt(UASToolPreferenceFragment.ROUTE_PREF_UASPOINT_SPEED, (int) capabilityValueDouble);
        float f4 = (float) sharedPrefs.getInt(UASToolPreferenceFragment.ROUTE_PREF_ORBIT_SPEED, (int) capabilityValueDouble4);
        float f5 = (float) sharedPrefs.getInt(UASToolPreferenceFragment.ROUTE_PREF_ORBIT_RADIUS, (int) capabilityValueDouble3);
        if (f5 < 0.0f) {
            f = f5 * -1.0f;
            z = false;
        } else {
            f = f5;
            z = true;
        }
        return new OrbitPoint(uuid, PREFIX + i2, i, f3, f2, false, z2, geoPoint2, f, f4, capabilityValueInt, z);
    }

    public static OrbitPoint fromCot(Element element, String str) {
        return fromCot(element);
    }

    public static OrbitPoint fromCot(Element element) {
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
        OrbitPoint orbitPoint = r2;
        OrbitPoint orbitPoint2 = new OrbitPoint(attribute, attribute2, parseInt, parseFloat, parseFloat2, parseBoolean, parseBoolean2, new GeoPoint((double) parseFloat3, (double) parseFloat4, (double) Float.parseFloat(element2.getAttribute(UASPoint.COTDETAIL_ALT)), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE), Float.parseFloat(element2.getAttribute(COTDETAIL_ORBITRADIUS)), Float.parseFloat(element2.getAttribute(COTDETAIL_ORBITSPEED)), Integer.parseInt(element2.getAttribute(COTDETAIL_ORBITCOUNT)), Boolean.parseBoolean(element2.getAttribute(COTDETAIL_ORBITCLOCKWISE)), element2.getAttribute("heading"), UASPoint.FINISH_ACTION.fromCotValue(element2.getAttribute("finish_action")));
        if (element2.hasAttribute(UASPoint.COTDETAIL_GIMBALPITCH)) {
            orbitPoint.setGimbalPitch(Integer.parseInt(element2.getAttribute(UASPoint.COTDETAIL_GIMBALPITCH)));
        }
        return orbitPoint;
    }

    public static OrbitPoint fromCot(CotDetail cotDetail, String str) {
        return fromCot(cotDetail);
    }

    public static OrbitPoint fromCot(CotDetail cotDetail) {
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
        OrbitPoint orbitPoint = r2;
        OrbitPoint orbitPoint2 = new OrbitPoint(attribute, attribute2, parseInt, parseFloat, parseFloat2, parseBoolean, parseBoolean2, new GeoPoint((double) parseFloat3, (double) parseFloat4, (double) Float.parseFloat(cotDetail2.getAttribute(UASPoint.COTDETAIL_ALT)), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE), Float.parseFloat(cotDetail2.getAttribute(COTDETAIL_ORBITRADIUS)), Float.parseFloat(cotDetail2.getAttribute(COTDETAIL_ORBITSPEED)), Integer.parseInt(cotDetail2.getAttribute(COTDETAIL_ORBITCOUNT)), Boolean.parseBoolean(cotDetail2.getAttribute(COTDETAIL_ORBITCLOCKWISE)), cotDetail2.getAttribute("heading"), UASPoint.FINISH_ACTION.fromCotValue(cotDetail2.getAttribute("finish_action")));
        if (cotDetail2.getAttribute(UASPoint.COTDETAIL_GIMBALPITCH) != null) {
            orbitPoint.setGimbalPitch(Integer.parseInt(cotDetail2.getAttribute(UASPoint.COTDETAIL_GIMBALPITCH)));
        }
        return orbitPoint;
    }

    public CotDetail toCot() {
        CotDetail cotDetail = new CotDetail("OrbitPoint");
        cotDetail.setAttribute(COTDETAIL_ORBITRADIUS, String.valueOf(this.orbitRadius));
        cotDetail.setAttribute(COTDETAIL_ORBITSPEED, String.valueOf(this.orbitSpeed));
        cotDetail.setAttribute(COTDETAIL_ORBITCOUNT, String.valueOf(this.orbitCount));
        cotDetail.setAttribute(COTDETAIL_ORBITCLOCKWISE, Boolean.toString(this.orbitClockwise));
        cotDetail.setAttribute("heading", this.heading);
        cotDetail.setAttribute("finish_action", this.finishAction.getCotValue());
        return super.toCot(cotDetail);
    }

    public OrbitPoint copy(String str, int i, boolean z) {
        String uid = getUID();
        if (z) {
            uid = UUID.randomUUID().toString();
        }
        String str2 = uid;
        GeoPoint C = C();
        GeoPoint geoPoint = new GeoPoint(C.getLatitude(), C.getLongitude(), C.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE);
        OrbitPoint orbitPoint = new OrbitPoint(str2, str, i, this.speed, this.agl, this.lookAtPoint, this.takeOff, geoPoint, this.orbitRadius, this.orbitSpeed, this.orbitCount, this.orbitClockwise, this.heading, this.finishAction);
        orbitPoint.hal = this.hal;
        if (this.gimbalPitch != null) {
            orbitPoint.setGimbalPitch(this.gimbalPitch.intValue());
        }
        return orbitPoint;
    }

    public WayPoint copyAsWayPoint(String str, int i, boolean z) {
        String uid = getUID();
        if (z) {
            uid = UUID.randomUUID().toString();
        }
        String str2 = uid;
        GeoPoint C = C();
        WayPoint wayPoint = new WayPoint(str2, str, i, this.speed, this.agl, this.lookAtPoint, this.takeOff, new GeoPoint(C.getLatitude(), C.getLongitude(), C.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE), "Remote Controller", "Normal", UASPoint.GOTO_SAFELY, this.finishAction);
        wayPoint.hal = this.hal;
        return wayPoint;
    }

    public void copyFrom(UASPoint uASPoint) {
        super.copyFrom(uASPoint);
        if (uASPoint instanceof OrbitPoint) {
            OrbitPoint orbitPoint = (OrbitPoint) uASPoint;
            this.orbitRadius = orbitPoint.getOrbitRadius();
            this.orbitSpeed = orbitPoint.getOrbitSpeed();
            this.orbitCount = orbitPoint.getOrbitCount();
            this.orbitClockwise = orbitPoint.getOrbitClockwise();
            this.heading = orbitPoint.getHeading();
            this.finishAction = orbitPoint.getFinishAction();
            return;
        }
        this.orbitRadius = (float) UASItem.getCapabilityValueDouble((UASItem) null, "None Selected", UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_DEFAULT, 0.0d);
        this.orbitSpeed = (float) UASItem.getCapabilityValueDouble((UASItem) null, "None Selected", UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_DEFAULT, 0.0d);
        this.orbitCount = UASItem.getCapabilityValueInt((UASItem) null, "None Selected", UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_DEFAULT, 0);
        this.orbitClockwise = false;
        this.heading = "Towards Point";
        this.finishAction = UASPoint.FINISH_ACTION.NO_ACTION;
    }

    public float getOrbitRadius() {
        return this.orbitRadius;
    }

    public void setOrbitRadius(float f) {
        this.orbitRadius = f;
    }

    public float getOrbitSpeed() {
        return this.orbitSpeed;
    }

    public void setOrbitSpeed(float f) {
        this.orbitSpeed = f;
    }

    public int getOrbitCount() {
        return this.orbitCount;
    }

    public void setOrbitCount(int i) {
        this.orbitCount = i;
    }

    public boolean getOrbitClockwise() {
        return this.orbitClockwise;
    }

    public void setOrbitClockwise(boolean z) {
        this.orbitClockwise = z;
    }

    public Icon getIcon(UasMapItemIconUtil.ICON_SIZE icon_size, int i) {
        return UasMapItemIconUtil.buildIcon(C1877R.drawable.orbitpoint, icon_size, UasMapItemIconUtil.ICON_ANCHOR.BOTTOM_CENTER, i);
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

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(OrbitPoint.class.getSimpleName(), parcel, i);
        parcel.writeFloat(this.orbitRadius);
        parcel.writeFloat(this.orbitSpeed);
        parcel.writeInt(this.orbitCount);
        parcel.writeByte((byte) (this.orbitClockwise ? 1 : 2));
        parcel.writeString(this.heading);
        parcel.writeString(getFinishAction().getCotValue());
    }

    public static int closestOrbitPoint(GeoPoint geoPoint, GeoPoint geoPoint2, double d) {
        double d2 = Double.MAX_VALUE;
        int i = 0;
        for (int i2 = 0; i2 <= 360; i2 += 15) {
            double distanceTo = GeoCalculations.pointAtDistance(geoPoint2, (double) (i2 % 360), d).distanceTo(geoPoint);
            if (distanceTo < d2) {
                i = i2;
                d2 = distanceTo;
            }
        }
        return i;
    }
}
