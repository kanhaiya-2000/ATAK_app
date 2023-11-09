package indago.location;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.serialization.JsonKeyConstants;
import java.util.Set;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo1538e = {"Lindago/location/GeoPolygon;", "", "points", "", "Lindago/location/GeoLocation;", "(Ljava/util/Set;)V", "getPoints", "()Ljava/util/Set;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class GeoPolygon {
    private final Set<GeoLocation> points;

    public static /* synthetic */ GeoPolygon copy$default(GeoPolygon geoPolygon, Set<GeoLocation> set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = geoPolygon.points;
        }
        return geoPolygon.copy(set);
    }

    public final Set<GeoLocation> component1() {
        return this.points;
    }

    public final GeoPolygon copy(Set<GeoLocation> set) {
        bfq.m6567f(set, JsonKeyConstants.POINTS);
        return new GeoPolygon(set);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof GeoPolygon) && bfq.m6552a((Object) this.points, (Object) ((GeoPolygon) obj).points);
        }
        return true;
    }

    public int hashCode() {
        Set<GeoLocation> set = this.points;
        if (set != null) {
            return set.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "GeoPolygon(points=" + this.points + ")";
    }

    public GeoPolygon(Set<GeoLocation> set) {
        bfq.m6567f(set, JsonKeyConstants.POINTS);
        this.points = set;
    }

    public final Set<GeoLocation> getPoints() {
        return this.points;
    }
}
