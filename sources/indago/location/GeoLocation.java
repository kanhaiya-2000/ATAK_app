package indago.location;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, mo1538e = {"Lindago/location/GeoLocation;", "", "lat", "", "lon", "msl", "(DDLjava/lang/Double;)V", "getLat", "()D", "getLon", "getMsl", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "copy", "(DDLjava/lang/Double;)Lindago/location/GeoLocation;", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class GeoLocation {
    private final double lat;
    private final double lon;
    private final Double msl;

    public static /* synthetic */ GeoLocation copy$default(GeoLocation geoLocation, double d, double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            d = geoLocation.lat;
        }
        double d4 = d;
        if ((i & 2) != 0) {
            d2 = geoLocation.lon;
        }
        double d5 = d2;
        if ((i & 4) != 0) {
            d3 = geoLocation.msl;
        }
        return geoLocation.copy(d4, d5, d3);
    }

    public final double component1() {
        return this.lat;
    }

    public final double component2() {
        return this.lon;
    }

    public final Double component3() {
        return this.msl;
    }

    public final GeoLocation copy(double d, double d2, Double d3) {
        return new GeoLocation(d, d2, d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeoLocation)) {
            return false;
        }
        GeoLocation geoLocation = (GeoLocation) obj;
        return Double.compare(this.lat, geoLocation.lat) == 0 && Double.compare(this.lon, geoLocation.lon) == 0 && bfq.m6552a((Object) this.msl, (Object) geoLocation.msl);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.lat);
        long doubleToLongBits2 = Double.doubleToLongBits(this.lon);
        int i = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        Double d = this.msl;
        return i + (d != null ? d.hashCode() : 0);
    }

    public String toString() {
        return "GeoLocation(lat=" + this.lat + ", lon=" + this.lon + ", msl=" + this.msl + ")";
    }

    public GeoLocation(double d, double d2, Double d3) {
        this.lat = d;
        this.lon = d2;
        this.msl = d3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GeoLocation(double d, double d2, Double d3, int i, bfd bfd) {
        this(d, d2, (i & 4) != 0 ? null : d3);
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLon() {
        return this.lon;
    }

    public final Double getMsl() {
        return this.msl;
    }
}
