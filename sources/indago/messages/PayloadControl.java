package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ<\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, mo1538e = {"Lindago/messages/PayloadControl;", "", "messageData", "Lindago/messages/MessageData;", "azimuthRate_percent", "", "elevationRate_percent", "zoomRate_percent", "(Lindago/messages/MessageData;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getAzimuthRate_percent", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getElevationRate_percent", "getMessageData", "()Lindago/messages/MessageData;", "getZoomRate_percent", "component1", "component2", "component3", "component4", "copy", "(Lindago/messages/MessageData;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lindago/messages/PayloadControl;", "equals", "", "other", "hashCode", "", "toString", "", "indago"})
public final class PayloadControl {
    private final Double azimuthRate_percent;
    private final Double elevationRate_percent;
    private final MessageData messageData;
    private final Double zoomRate_percent;

    public static /* synthetic */ PayloadControl copy$default(PayloadControl payloadControl, MessageData messageData2, Double d, Double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            messageData2 = payloadControl.messageData;
        }
        if ((i & 2) != 0) {
            d = payloadControl.azimuthRate_percent;
        }
        if ((i & 4) != 0) {
            d2 = payloadControl.elevationRate_percent;
        }
        if ((i & 8) != 0) {
            d3 = payloadControl.zoomRate_percent;
        }
        return payloadControl.copy(messageData2, d, d2, d3);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final Double component2() {
        return this.azimuthRate_percent;
    }

    public final Double component3() {
        return this.elevationRate_percent;
    }

    public final Double component4() {
        return this.zoomRate_percent;
    }

    public final PayloadControl copy(MessageData messageData2, Double d, Double d2, Double d3) {
        bfq.m6567f(messageData2, "messageData");
        return new PayloadControl(messageData2, d, d2, d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayloadControl)) {
            return false;
        }
        PayloadControl payloadControl = (PayloadControl) obj;
        return bfq.m6552a((Object) this.messageData, (Object) payloadControl.messageData) && bfq.m6552a((Object) this.azimuthRate_percent, (Object) payloadControl.azimuthRate_percent) && bfq.m6552a((Object) this.elevationRate_percent, (Object) payloadControl.elevationRate_percent) && bfq.m6552a((Object) this.zoomRate_percent, (Object) payloadControl.zoomRate_percent);
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int i = 0;
        int hashCode = (messageData2 != null ? messageData2.hashCode() : 0) * 31;
        Double d = this.azimuthRate_percent;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        Double d2 = this.elevationRate_percent;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.zoomRate_percent;
        if (d3 != null) {
            i = d3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PayloadControl(messageData=" + this.messageData + ", azimuthRate_percent=" + this.azimuthRate_percent + ", elevationRate_percent=" + this.elevationRate_percent + ", zoomRate_percent=" + this.zoomRate_percent + ")";
    }

    public PayloadControl(MessageData messageData2, Double d, Double d2, Double d3) {
        bfq.m6567f(messageData2, "messageData");
        this.messageData = messageData2;
        this.azimuthRate_percent = d;
        this.elevationRate_percent = d2;
        this.zoomRate_percent = d3;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final Double getAzimuthRate_percent() {
        return this.azimuthRate_percent;
    }

    public final Double getElevationRate_percent() {
        return this.elevationRate_percent;
    }

    public final Double getZoomRate_percent() {
        return this.zoomRate_percent;
    }
}
