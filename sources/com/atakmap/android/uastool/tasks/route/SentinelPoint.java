package com.atakmap.android.uastool.tasks.route;

import android.os.Parcel;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.utils.UasMapItemIconUtil;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.maps.assets.Icon;
import com.atakmap.coremap.maps.coords.GeoPoint;
import java.util.UUID;

public class SentinelPoint extends UASPoint {
    public static final String COT_TAG = "SentinelPoint";
    public static final String PREFIX = "SP-";
    private static final String TAG = "SentinelPoint";

    public static SentinelPoint fromScratch(UASItem uASItem, int i, GeoPoint geoPoint, String str) {
        return null;
    }

    public SentinelPoint(String str, String str2, int i, float f, float f2, boolean z, boolean z2, GeoPoint geoPoint) {
        super(str, str2, i, f, f2, z, z2, geoPoint, C1877R.drawable.orbitpoint, UASPoint.POINTTYPE.SENTINELPOINT);
    }

    public SentinelPoint(Parcel parcel) {
        super(parcel);
    }

    public String getDescription(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.index);
        sb.append(" / ");
        sb.append("SentinelPoint");
        sb.append(" / ");
        sb.append(this.takeOff ? "TakeOff!" : "");
        return sb.toString();
    }

    public UASPoint.FINISH_ACTION getFinishAction() {
        return UASPoint.FINISH_ACTION.NO_ACTION;
    }

    public CotDetail toCot() {
        return super.toCot(new CotDetail("SentinelPoint"));
    }

    public SentinelPoint copy(String str, int i, boolean z) {
        String uid = getUID();
        if (z) {
            uid = UUID.randomUUID().toString();
        }
        String str2 = uid;
        GeoPoint C = C();
        String str3 = str;
        int i2 = i;
        SentinelPoint sentinelPoint = new SentinelPoint(str2, str3, i2, this.speed, this.agl, this.lookAtPoint, this.takeOff, new GeoPoint(C.getLatitude(), C.getLongitude(), C.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE));
        sentinelPoint.hal = this.hal;
        if (this.gimbalPitch != null) {
            sentinelPoint.setGimbalPitch(this.gimbalPitch.intValue());
        }
        return sentinelPoint;
    }

    public WayPoint copyAsWayPoint(String str, int i, boolean z) {
        String uid = getUID();
        if (z) {
            uid = UUID.randomUUID().toString();
        }
        String str2 = uid;
        GeoPoint C = C();
        WayPoint wayPoint = new WayPoint(str2, str, i, this.speed, this.agl, this.lookAtPoint, this.takeOff, new GeoPoint(C.getLatitude(), C.getLongitude(), C.getAltitude(), GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d, GeoPoint.Access.READ_WRITE), "Remote Controller", "Normal", UASPoint.GOTO_SAFELY, UASPoint.FINISH_ACTION.NO_ACTION);
        wayPoint.hal = this.hal;
        return wayPoint;
    }

    public void copyFrom(UASPoint uASPoint) {
        super.copyFrom(uASPoint);
    }

    public Icon getIcon(UasMapItemIconUtil.ICON_SIZE icon_size, int i) {
        return UasMapItemIconUtil.buildIcon(C1877R.drawable.sentinelpoint, icon_size, UasMapItemIconUtil.ICON_ANCHOR.BOTTOM_CENTER, i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(SentinelPoint.class.getSimpleName(), parcel, i);
    }
}
