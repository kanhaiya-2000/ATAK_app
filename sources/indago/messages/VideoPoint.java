package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.location.GeoLocation;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo1538e = {"Lindago/messages/VideoPoint;", "", "geoLocation", "Lindago/location/GeoLocation;", "type", "Lindago/messages/VideoPointType;", "(Lindago/location/GeoLocation;Lindago/messages/VideoPointType;)V", "getGeoLocation", "()Lindago/location/GeoLocation;", "getType", "()Lindago/messages/VideoPointType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class VideoPoint {
    private final GeoLocation geoLocation;
    private final VideoPointType type;

    public static /* synthetic */ VideoPoint copy$default(VideoPoint videoPoint, GeoLocation geoLocation2, VideoPointType videoPointType, int i, Object obj) {
        if ((i & 1) != 0) {
            geoLocation2 = videoPoint.geoLocation;
        }
        if ((i & 2) != 0) {
            videoPointType = videoPoint.type;
        }
        return videoPoint.copy(geoLocation2, videoPointType);
    }

    public final GeoLocation component1() {
        return this.geoLocation;
    }

    public final VideoPointType component2() {
        return this.type;
    }

    public final VideoPoint copy(GeoLocation geoLocation2, VideoPointType videoPointType) {
        bfq.m6567f(geoLocation2, "geoLocation");
        bfq.m6567f(videoPointType, "type");
        return new VideoPoint(geoLocation2, videoPointType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoPoint)) {
            return false;
        }
        VideoPoint videoPoint = (VideoPoint) obj;
        return bfq.m6552a((Object) this.geoLocation, (Object) videoPoint.geoLocation) && bfq.m6552a((Object) this.type, (Object) videoPoint.type);
    }

    public int hashCode() {
        GeoLocation geoLocation2 = this.geoLocation;
        int i = 0;
        int hashCode = (geoLocation2 != null ? geoLocation2.hashCode() : 0) * 31;
        VideoPointType videoPointType = this.type;
        if (videoPointType != null) {
            i = videoPointType.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VideoPoint(geoLocation=" + this.geoLocation + ", type=" + this.type + ")";
    }

    public VideoPoint(GeoLocation geoLocation2, VideoPointType videoPointType) {
        bfq.m6567f(geoLocation2, "geoLocation");
        bfq.m6567f(videoPointType, "type");
        this.geoLocation = geoLocation2;
        this.type = videoPointType;
    }

    public final GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    public final VideoPointType getType() {
        return this.type;
    }
}
