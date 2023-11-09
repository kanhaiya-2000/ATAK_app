package com.atakmap.android.uastool.tasks.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.utils.UasMapItemIconUtil;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.assets.Icon;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import java.util.HashMap;
import java.util.Map;

public abstract class UASPoint extends ao implements Parcelable {
    public static final String COTDETAIL_AGL = "agl";
    public static final String COTDETAIL_ALT = "altitude";
    public static final String COTDETAIL_CE = "ce";
    public static final String COTDETAIL_GIMBALPITCH = "gimbalpitch";
    public static final String COTDETAIL_INDEX = "index";
    public static final String COTDETAIL_LAT = "latitude";
    public static final String COTDETAIL_LE = "le";
    public static final String COTDETAIL_LON = "longitude";
    public static final String COTDETAIL_LOOKATPOINT = "lookAtPoint";
    public static final String COTDETAIL_SPEED = "speed";
    public static final String COTDETAIL_TAKEOFF = "takeOff";
    public static final Parcelable.Creator<UASPoint> CREATOR = new Parcelable.Creator<UASPoint>() {
        public UASPoint createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            if (readString.equals(OrbitPoint.class.getSimpleName())) {
                return new OrbitPoint(parcel);
            }
            if (readString.equals(WayPoint.class.getSimpleName())) {
                return new WayPoint(parcel);
            }
            return new SentinelPoint(parcel);
        }

        public UASPoint[] newArray(int i) {
            return new UASPoint[i];
        }
    };
    public static final String GOTO_POINT_TO_POINT = "Point to Point";
    public static final String GOTO_SAFELY = "Safely";
    private static final String TAG = "UASPoint";
    protected float agl;
    protected ao atakPt;
    protected FINISH_ACTION finishAction;
    protected Integer gimbalPitch;
    protected float hal;
    protected int iconId;
    protected int index;
    private boolean isSelected = false;
    protected boolean lookAtPoint;
    protected POINTTYPE pointType;
    protected float speed;
    protected boolean takeOff;

    public abstract UASPoint copy(String str, int i, boolean z);

    public abstract WayPoint copyAsWayPoint(String str, int i, boolean z);

    public int describeContents() {
        return 0;
    }

    public abstract String getDescription(String str);

    public String getGotoMode() {
        return GOTO_SAFELY;
    }

    public abstract Icon getIcon(UasMapItemIconUtil.ICON_SIZE icon_size, int i);

    public abstract CotDetail toCot();

    public boolean usingPrefixName() {
        return false;
    }

    public void setGimbalPitch(int i) {
        this.gimbalPitch = Integer.valueOf(i);
    }

    public Integer getGimbalPitch() {
        return this.gimbalPitch;
    }

    public enum POINTTYPE {
        WAYPOINT(0),
        ORBITPOINT(1),
        SENTINELPOINT(2);
        
        private static final Map map = null;
        private final int value;

        static {
            int i;
            map = new HashMap();
            for (POINTTYPE pointtype : values()) {
                map.put(Integer.valueOf(pointtype.value), pointtype);
            }
        }

        private POINTTYPE(int i) {
            this.value = i;
        }

        public static POINTTYPE valueOf(int i) {
            return (POINTTYPE) map.get(Integer.valueOf(i));
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum FINISH_ACTION {
        NO_ACTION("No Action"),
        GO_HOME_LAND("Go Home and Land"),
        LAND_AT_LAST("Land at Last Waypoint"),
        HOVER_AT_FIRST_WAYPOINT("Hover at First Waypoint");
        
        private static final HashMap<String, FINISH_ACTION> map = null;
        private final String stringVal;

        static {
            int i;
            map = new HashMap<>();
            for (FINISH_ACTION finish_action : values()) {
                map.put(finish_action.stringVal, finish_action);
            }
        }

        private FINISH_ACTION(String str) {
            this.stringVal = str;
        }

        public static FINISH_ACTION fromCotValue(String str) {
            if (str == null) {
                return NO_ACTION;
            }
            FINISH_ACTION finish_action = map.get(str);
            return finish_action == null ? NO_ACTION : finish_action;
        }

        public String getCotValue() {
            return this.stringVal;
        }

        public String toString() {
            return this.stringVal;
        }
    }

    public String getMapPointDescription() {
        return String.format("%s\n%s HAL", new Object[]{getName(), Utils.formatAlt((double) getAGL())});
    }

    public FINISH_ACTION getFinishAction() {
        FINISH_ACTION finish_action = this.finishAction;
        return finish_action == null ? FINISH_ACTION.NO_ACTION : finish_action;
    }

    public UASPoint(String str, String str2, int i, float f, float f2, boolean z, boolean z2, GeoPoint geoPoint, int i2, POINTTYPE pointtype) {
        super(geoPoint, str);
        this.index = i;
        this.speed = f;
        this.agl = f2;
        this.hal = f2;
        this.lookAtPoint = z;
        this.takeOff = z2;
        this.iconId = i2;
        this.pointType = pointtype;
        setMarkerValues(this, str2);
    }

    /* renamed from: com.atakmap.android.uastool.tasks.route.UASPoint$2 */
    /* synthetic */ class C21372 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$tasks$route$UASPoint$POINTTYPE */
        static final /* synthetic */ int[] f8414x5ed4c682;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE[] r0 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8414x5ed4c682 = r0
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r1 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8414x5ed4c682     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r1 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.ORBITPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8414x5ed4c682     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r1 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.SENTINELPOINT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.tasks.route.UASPoint.C21372.<clinit>():void");
        }
    }

    public static UASPoint fromScratch(POINTTYPE pointtype, UASItem uASItem, int i, GeoPoint geoPoint, String str) {
        int i2 = C21372.f8414x5ed4c682[pointtype.ordinal()];
        if (i2 == 1) {
            return WayPoint.fromScratch(uASItem, i, geoPoint, str);
        }
        if (i2 == 2) {
            return OrbitPoint.fromScratch(uASItem, i, geoPoint, str);
        }
        if (i2 == 3) {
            return SentinelPoint.fromScratch(uASItem, i, geoPoint, str);
        }
        UASToolDropDownReceiver.toast("Unable to create unknown point type: " + pointtype.name(), 0);
        return null;
    }

    private void setMarkerValues(ao aoVar, String str) {
        aoVar.setTitle(str);
        aoVar.setType(UASRoute.WAYPOINT_TYPE);
        aoVar.a(getIcon(UasMapItemIconUtil.ICON_SIZE.SMALL, -1));
        aoVar.e(0);
        aoVar.b(true);
        aoVar.setClickable(false);
        aoVar.setEditable(false);
        aoVar.setMovable(false);
        aoVar.c(true);
        aoVar.setTouchable(false);
        aoVar.setVisible(true);
        aoVar.a(false);
        aoVar.setMetaBoolean("removable", false);
        aoVar.setMetaBoolean("markerIcon", true);
        aoVar.setMetaString("menu", "");
        aoVar.setMetaBoolean("adapt_marker_icon", false);
        aoVar.setMetaBoolean("nevercot", true);
        aoVar.setMetaBoolean("archive", false);
    }

    public boolean equals(UASPoint uASPoint) {
        return uASPoint.getPointType().equals(this.pointType) && uASPoint.getUID().equals(getUID());
    }

    public int compareTo(UASPoint uASPoint) {
        if (this.index < uASPoint.getIndex()) {
            return -1;
        }
        return this.index > uASPoint.getIndex() ? 1 : 0;
    }

    public POINTTYPE getPointType() {
        return this.pointType;
    }

    public void copyFrom(UASPoint uASPoint) {
        setMetaString(UASTask.COTDETAIL_UID, uASPoint.getUID());
        setTitle(uASPoint.getTitle());
        a(uASPoint.C());
        setType(uASPoint.getType());
        this.pointType = uASPoint.getPointType();
        this.index = uASPoint.getIndex();
        this.speed = uASPoint.getSpeed();
        this.agl = uASPoint.getAGL();
        this.hal = uASPoint.hal;
        this.lookAtPoint = uASPoint.getLookAtPoint();
        this.takeOff = uASPoint.getTakeoff();
        this.iconId = uASPoint.getIconId();
        this.gimbalPitch = uASPoint.getGimbalPitch();
    }

    public void setFinishAction(FINISH_ACTION finish_action) {
        this.finishAction = finish_action;
    }

    public void setFinishAction(String str) {
        this.finishAction = FINISH_ACTION.fromCotValue(str);
    }

    public boolean getSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String getName() {
        return getTitle();
    }

    public void setName(String str) {
        setTitle(str);
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public float getAGL() {
        return this.agl;
    }

    public void setAGL(float f) {
        setHAL(f);
        this.agl = f;
    }

    public boolean getLookAtPoint() {
        return this.lookAtPoint;
    }

    public void setLookAtPoint(boolean z) {
        this.lookAtPoint = z;
    }

    public boolean getTakeoff() {
        return this.takeOff;
    }

    public void setTakeoff(boolean z) {
        this.takeOff = z;
    }

    public void panTo() {
        MapView.getMapView().getMapController().panTo(C(), true);
    }

    public int getIconId() {
        return this.iconId;
    }

    public float getHAL(double d) {
        if (C() != null && !Double.isNaN(C().getAltitude()) && !Double.isNaN(d)) {
            double a = ElevationManager.a(C().getLatitude(), C().getLongitude(), (ElevationManager.b) null);
            if (a != 0.0d) {
                float f = (float) ((a + ((double) this.agl)) - d);
                this.hal = f;
                return f;
            }
        }
        float f2 = this.agl;
        this.hal = f2;
        return f2;
    }

    public float getHAL() {
        return this.hal;
    }

    public void setHAL(float f) {
        this.hal = f;
    }

    public ao getAsATAKMarker(boolean z, boolean z2) {
        GeoPoint geoPoint;
        if (z || this.atakPt == null) {
            GeoPoint C = C();
            if (z2) {
                geoPoint = new GeoPoint(C.getLatitude(), C.getLongitude(), ((double) this.agl) + C.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_ONLY);
            } else {
                geoPoint = new GeoPoint(C.getLatitude(), C.getLongitude(), C.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_ONLY);
            }
            ao aoVar = new ao(geoPoint, getUID());
            this.atakPt = aoVar;
            setMarkerValues(aoVar, getMapPointDescription());
        }
        return this.atakPt;
    }

    public CotDetail toCot(CotDetail cotDetail) {
        cotDetail.setAttribute(UASTask.COTDETAIL_UID, getUID());
        cotDetail.setAttribute(UASTask.COTDETAIL_NAME, getTitle());
        cotDetail.setAttribute(COTDETAIL_INDEX, String.valueOf(this.index));
        cotDetail.setAttribute(COTDETAIL_SPEED, String.valueOf(this.speed));
        cotDetail.setAttribute(COTDETAIL_AGL, String.valueOf(this.agl));
        cotDetail.setAttribute(COTDETAIL_LOOKATPOINT, String.valueOf(this.lookAtPoint));
        cotDetail.setAttribute(COTDETAIL_TAKEOFF, String.valueOf(this.takeOff));
        cotDetail.setAttribute(COTDETAIL_LAT, String.valueOf(C().getLatitude()));
        cotDetail.setAttribute(COTDETAIL_LON, String.valueOf(C().getLongitude()));
        cotDetail.setAttribute(COTDETAIL_ALT, String.valueOf(C().getAltitude()));
        cotDetail.setAttribute(COTDETAIL_CE, String.valueOf(C().getCE()));
        cotDetail.setAttribute(COTDETAIL_LE, String.valueOf(C().getLE()));
        if (this.gimbalPitch != null) {
            cotDetail.setAttribute(COTDETAIL_GIMBALPITCH, String.valueOf(getGimbalPitch()));
        }
        return cotDetail;
    }

    protected UASPoint(Parcel parcel) {
        super(new GeoPoint(parcel.readDouble(), parcel.readDouble(), parcel.readDouble()), parcel.readString());
        boolean z = false;
        setTitle(parcel.readString());
        this.pointType = POINTTYPE.valueOf(parcel.readInt());
        this.index = parcel.readInt();
        this.speed = parcel.readFloat();
        this.agl = parcel.readFloat();
        this.lookAtPoint = parcel.readByte() == 1;
        this.takeOff = parcel.readByte() == 1 ? true : z;
        this.iconId = parcel.readInt();
        this.hal = parcel.readFloat();
        this.gimbalPitch = (Integer) parcel.readSerializable();
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(UASPoint.class.getSimpleName(), parcel, i);
    }

    public void writeToParcel(String str, Parcel parcel, int i) {
        parcel.writeString(str);
        parcel.writeDouble(C().getLatitude());
        parcel.writeDouble(C().getLongitude());
        parcel.writeDouble(C().getAltitude());
        parcel.writeString(getUID());
        parcel.writeString(getTitle());
        parcel.writeInt(this.pointType.getValue());
        parcel.writeInt(this.index);
        parcel.writeFloat(this.speed);
        parcel.writeFloat(this.agl);
        int i2 = 1;
        parcel.writeByte((byte) (this.lookAtPoint ? 1 : 2));
        if (!this.takeOff) {
            i2 = 2;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.iconId);
        parcel.writeFloat(this.hal);
        parcel.writeSerializable(this.gimbalPitch);
    }
}
