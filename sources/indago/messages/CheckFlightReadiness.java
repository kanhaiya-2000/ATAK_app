package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo1538e = {"Lindago/messages/CheckFlightReadiness;", "", "messageData", "Lindago/messages/MessageData;", "observedTrueHeading", "", "(Lindago/messages/MessageData;D)V", "getMessageData", "()Lindago/messages/MessageData;", "getObservedTrueHeading", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class CheckFlightReadiness {
    private final MessageData messageData;
    private final double observedTrueHeading;

    public static /* synthetic */ CheckFlightReadiness copy$default(CheckFlightReadiness checkFlightReadiness, MessageData messageData2, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = checkFlightReadiness.messageData;
        }
        if ((i & 2) != 0) {
            d = checkFlightReadiness.observedTrueHeading;
        }
        return checkFlightReadiness.copy(messageData2, d);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final double component2() {
        return this.observedTrueHeading;
    }

    public final CheckFlightReadiness copy(MessageData messageData2, double d) {
        bfq.m6567f(messageData2, "messageData");
        return new CheckFlightReadiness(messageData2, d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckFlightReadiness)) {
            return false;
        }
        CheckFlightReadiness checkFlightReadiness = (CheckFlightReadiness) obj;
        return bfq.m6552a((Object) this.messageData, (Object) checkFlightReadiness.messageData) && Double.compare(this.observedTrueHeading, checkFlightReadiness.observedTrueHeading) == 0;
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int hashCode = messageData2 != null ? messageData2.hashCode() : 0;
        long doubleToLongBits = Double.doubleToLongBits(this.observedTrueHeading);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        return "CheckFlightReadiness(messageData=" + this.messageData + ", observedTrueHeading=" + this.observedTrueHeading + ")";
    }

    public CheckFlightReadiness(MessageData messageData2, double d) {
        bfq.m6567f(messageData2, "messageData");
        this.messageData = messageData2;
        this.observedTrueHeading = d;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final double getObservedTrueHeading() {
        return this.observedTrueHeading;
    }
}
