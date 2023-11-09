package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import java.util.Set;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo1538e = {"Lindago/messages/VideoGeolocation;", "", "messageData", "Lindago/messages/MessageData;", "videoPoints", "", "Lindago/messages/VideoPoint;", "(Lindago/messages/MessageData;Ljava/util/Set;)V", "getMessageData", "()Lindago/messages/MessageData;", "getVideoPoints", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class VideoGeolocation {
    private final MessageData messageData;
    private final Set<VideoPoint> videoPoints;

    public static /* synthetic */ VideoGeolocation copy$default(VideoGeolocation videoGeolocation, MessageData messageData2, Set<VideoPoint> set, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = videoGeolocation.messageData;
        }
        if ((i & 2) != 0) {
            set = videoGeolocation.videoPoints;
        }
        return videoGeolocation.copy(messageData2, set);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final Set<VideoPoint> component2() {
        return this.videoPoints;
    }

    public final VideoGeolocation copy(MessageData messageData2, Set<VideoPoint> set) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(set, "videoPoints");
        return new VideoGeolocation(messageData2, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoGeolocation)) {
            return false;
        }
        VideoGeolocation videoGeolocation = (VideoGeolocation) obj;
        return bfq.m6552a((Object) this.messageData, (Object) videoGeolocation.messageData) && bfq.m6552a((Object) this.videoPoints, (Object) videoGeolocation.videoPoints);
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int i = 0;
        int hashCode = (messageData2 != null ? messageData2.hashCode() : 0) * 31;
        Set<VideoPoint> set = this.videoPoints;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VideoGeolocation(messageData=" + this.messageData + ", videoPoints=" + this.videoPoints + ")";
    }

    public VideoGeolocation(MessageData messageData2, Set<VideoPoint> set) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(set, "videoPoints");
        this.messageData = messageData2;
        this.videoPoints = set;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final Set<VideoPoint> getVideoPoints() {
        return this.videoPoints;
    }
}
