package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.serialization.JsonKeyConstants;
import java.util.Set;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo1538e = {"Lindago/messages/SavedFlightPlans;", "", "messageData", "Lindago/messages/MessageData;", "flightPlans", "", "", "(Lindago/messages/MessageData;Ljava/util/Set;)V", "getFlightPlans", "()Ljava/util/Set;", "getMessageData", "()Lindago/messages/MessageData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "indago"})
public final class SavedFlightPlans {
    private final Set<String> flightPlans;
    private final MessageData messageData;

    public static /* synthetic */ SavedFlightPlans copy$default(SavedFlightPlans savedFlightPlans, MessageData messageData2, Set<String> set, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = savedFlightPlans.messageData;
        }
        if ((i & 2) != 0) {
            set = savedFlightPlans.flightPlans;
        }
        return savedFlightPlans.copy(messageData2, set);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final Set<String> component2() {
        return this.flightPlans;
    }

    public final SavedFlightPlans copy(MessageData messageData2, Set<String> set) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(set, JsonKeyConstants.FLIGHT_PLANS);
        return new SavedFlightPlans(messageData2, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SavedFlightPlans)) {
            return false;
        }
        SavedFlightPlans savedFlightPlans = (SavedFlightPlans) obj;
        return bfq.m6552a((Object) this.messageData, (Object) savedFlightPlans.messageData) && bfq.m6552a((Object) this.flightPlans, (Object) savedFlightPlans.flightPlans);
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int i = 0;
        int hashCode = (messageData2 != null ? messageData2.hashCode() : 0) * 31;
        Set<String> set = this.flightPlans;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SavedFlightPlans(messageData=" + this.messageData + ", flightPlans=" + this.flightPlans + ")";
    }

    public SavedFlightPlans(MessageData messageData2, Set<String> set) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(set, JsonKeyConstants.FLIGHT_PLANS);
        this.messageData = messageData2;
        this.flightPlans = set;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final Set<String> getFlightPlans() {
        return this.flightPlans;
    }
}
