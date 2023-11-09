package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.serialization.JsonKeyConstants;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo1538e = {"Lindago/messages/LoadFlightPlan;", "", "messageData", "Lindago/messages/MessageData;", "flightPlan", "", "(Lindago/messages/MessageData;Ljava/lang/String;)V", "getFlightPlan", "()Ljava/lang/String;", "getMessageData", "()Lindago/messages/MessageData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "indago"})
public final class LoadFlightPlan {
    private final String flightPlan;
    private final MessageData messageData;

    public static /* synthetic */ LoadFlightPlan copy$default(LoadFlightPlan loadFlightPlan, MessageData messageData2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = loadFlightPlan.messageData;
        }
        if ((i & 2) != 0) {
            str = loadFlightPlan.flightPlan;
        }
        return loadFlightPlan.copy(messageData2, str);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final String component2() {
        return this.flightPlan;
    }

    public final LoadFlightPlan copy(MessageData messageData2, String str) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(str, JsonKeyConstants.FLIGHT_PLAN);
        return new LoadFlightPlan(messageData2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadFlightPlan)) {
            return false;
        }
        LoadFlightPlan loadFlightPlan = (LoadFlightPlan) obj;
        return bfq.m6552a((Object) this.messageData, (Object) loadFlightPlan.messageData) && bfq.m6552a((Object) this.flightPlan, (Object) loadFlightPlan.flightPlan);
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int i = 0;
        int hashCode = (messageData2 != null ? messageData2.hashCode() : 0) * 31;
        String str = this.flightPlan;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LoadFlightPlan(messageData=" + this.messageData + ", flightPlan=" + this.flightPlan + ")";
    }

    public LoadFlightPlan(MessageData messageData2, String str) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(str, JsonKeyConstants.FLIGHT_PLAN);
        this.messageData = messageData2;
        this.flightPlan = str;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final String getFlightPlan() {
        return this.flightPlan;
    }
}
