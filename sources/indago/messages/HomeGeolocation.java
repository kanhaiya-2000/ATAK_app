package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.location.GeoLocation;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo1538e = {"Lindago/messages/HomeGeolocation;", "", "messageData", "Lindago/messages/MessageData;", "location", "Lindago/location/GeoLocation;", "mode", "Lindago/messages/HomeGeolocationMode;", "(Lindago/messages/MessageData;Lindago/location/GeoLocation;Lindago/messages/HomeGeolocationMode;)V", "getLocation", "()Lindago/location/GeoLocation;", "getMessageData", "()Lindago/messages/MessageData;", "getMode", "()Lindago/messages/HomeGeolocationMode;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class HomeGeolocation {
    private final GeoLocation location;
    private final MessageData messageData;
    private final HomeGeolocationMode mode;

    public static /* synthetic */ HomeGeolocation copy$default(HomeGeolocation homeGeolocation, MessageData messageData2, GeoLocation geoLocation, HomeGeolocationMode homeGeolocationMode, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = homeGeolocation.messageData;
        }
        if ((i & 2) != 0) {
            geoLocation = homeGeolocation.location;
        }
        if ((i & 4) != 0) {
            homeGeolocationMode = homeGeolocation.mode;
        }
        return homeGeolocation.copy(messageData2, geoLocation, homeGeolocationMode);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final GeoLocation component2() {
        return this.location;
    }

    public final HomeGeolocationMode component3() {
        return this.mode;
    }

    public final HomeGeolocation copy(MessageData messageData2, GeoLocation geoLocation, HomeGeolocationMode homeGeolocationMode) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(homeGeolocationMode, "mode");
        return new HomeGeolocation(messageData2, geoLocation, homeGeolocationMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeGeolocation)) {
            return false;
        }
        HomeGeolocation homeGeolocation = (HomeGeolocation) obj;
        return bfq.m6552a((Object) this.messageData, (Object) homeGeolocation.messageData) && bfq.m6552a((Object) this.location, (Object) homeGeolocation.location) && bfq.m6552a((Object) this.mode, (Object) homeGeolocation.mode);
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int i = 0;
        int hashCode = (messageData2 != null ? messageData2.hashCode() : 0) * 31;
        GeoLocation geoLocation = this.location;
        int hashCode2 = (hashCode + (geoLocation != null ? geoLocation.hashCode() : 0)) * 31;
        HomeGeolocationMode homeGeolocationMode = this.mode;
        if (homeGeolocationMode != null) {
            i = homeGeolocationMode.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "HomeGeolocation(messageData=" + this.messageData + ", location=" + this.location + ", mode=" + this.mode + ")";
    }

    public HomeGeolocation(MessageData messageData2, GeoLocation geoLocation, HomeGeolocationMode homeGeolocationMode) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(homeGeolocationMode, "mode");
        this.messageData = messageData2;
        this.location = geoLocation;
        this.mode = homeGeolocationMode;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final GeoLocation getLocation() {
        return this.location;
    }

    public final HomeGeolocationMode getMode() {
        return this.mode;
    }
}
