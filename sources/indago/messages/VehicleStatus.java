package indago.messages;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.serialization.JsonKeyConstants;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\b\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\u0010HÆ\u0003J|\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\tHÖ\u0001J\t\u00106\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001d¨\u00067"}, mo1538e = {"Lindago/messages/VehicleStatus;", "", "messageData", "Lindago/messages/MessageData;", "batteryVoltage", "", "batteryChargeState", "Lindago/messages/BatteryState;", "batteryPercentRemaining", "", "flightTimeRemaining", "communicating", "", "readyForFlight", "motorsArmed", "flightMode", "Lindago/messages/FlightMode;", "flightPlan", "", "(Lindago/messages/MessageData;Ljava/lang/Double;Lindago/messages/BatteryState;Ljava/lang/Integer;Ljava/lang/Integer;ZZZLindago/messages/FlightMode;Ljava/lang/String;)V", "getBatteryChargeState", "()Lindago/messages/BatteryState;", "getBatteryPercentRemaining", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBatteryVoltage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCommunicating", "()Z", "getFlightMode", "()Lindago/messages/FlightMode;", "getFlightPlan", "()Ljava/lang/String;", "getFlightTimeRemaining", "getMessageData", "()Lindago/messages/MessageData;", "getMotorsArmed", "getReadyForFlight", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lindago/messages/MessageData;Ljava/lang/Double;Lindago/messages/BatteryState;Ljava/lang/Integer;Ljava/lang/Integer;ZZZLindago/messages/FlightMode;Ljava/lang/String;)Lindago/messages/VehicleStatus;", "equals", "other", "hashCode", "toString", "indago"})
public final class VehicleStatus {
    private final BatteryState batteryChargeState;
    private final Integer batteryPercentRemaining;
    private final Double batteryVoltage;
    private final boolean communicating;
    private final FlightMode flightMode;
    private final String flightPlan;
    private final Integer flightTimeRemaining;
    private final MessageData messageData;
    private final boolean motorsArmed;
    private final boolean readyForFlight;

    public static /* synthetic */ VehicleStatus copy$default(VehicleStatus vehicleStatus, MessageData messageData2, Double d, BatteryState batteryState, Integer num, Integer num2, boolean z, boolean z2, boolean z3, FlightMode flightMode2, String str, int i, Object obj) {
        VehicleStatus vehicleStatus2 = vehicleStatus;
        int i2 = i;
        return vehicleStatus.copy((i2 & 1) != 0 ? vehicleStatus2.messageData : messageData2, (i2 & 2) != 0 ? vehicleStatus2.batteryVoltage : d, (i2 & 4) != 0 ? vehicleStatus2.batteryChargeState : batteryState, (i2 & 8) != 0 ? vehicleStatus2.batteryPercentRemaining : num, (i2 & 16) != 0 ? vehicleStatus2.flightTimeRemaining : num2, (i2 & 32) != 0 ? vehicleStatus2.communicating : z, (i2 & 64) != 0 ? vehicleStatus2.readyForFlight : z2, (i2 & 128) != 0 ? vehicleStatus2.motorsArmed : z3, (i2 & 256) != 0 ? vehicleStatus2.flightMode : flightMode2, (i2 & 512) != 0 ? vehicleStatus2.flightPlan : str);
    }

    public final MessageData component1() {
        return this.messageData;
    }

    public final String component10() {
        return this.flightPlan;
    }

    public final Double component2() {
        return this.batteryVoltage;
    }

    public final BatteryState component3() {
        return this.batteryChargeState;
    }

    public final Integer component4() {
        return this.batteryPercentRemaining;
    }

    public final Integer component5() {
        return this.flightTimeRemaining;
    }

    public final boolean component6() {
        return this.communicating;
    }

    public final boolean component7() {
        return this.readyForFlight;
    }

    public final boolean component8() {
        return this.motorsArmed;
    }

    public final FlightMode component9() {
        return this.flightMode;
    }

    public final VehicleStatus copy(MessageData messageData2, Double d, BatteryState batteryState, Integer num, Integer num2, boolean z, boolean z2, boolean z3, FlightMode flightMode2, String str) {
        bfq.m6567f(messageData2, "messageData");
        FlightMode flightMode3 = flightMode2;
        bfq.m6567f(flightMode3, JsonKeyConstants.FLIGHT_MODE);
        return new VehicleStatus(messageData2, d, batteryState, num, num2, z, z2, z3, flightMode3, str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof VehicleStatus) {
                VehicleStatus vehicleStatus = (VehicleStatus) obj;
                if (bfq.m6552a((Object) this.messageData, (Object) vehicleStatus.messageData) && bfq.m6552a((Object) this.batteryVoltage, (Object) vehicleStatus.batteryVoltage) && bfq.m6552a((Object) this.batteryChargeState, (Object) vehicleStatus.batteryChargeState) && bfq.m6552a((Object) this.batteryPercentRemaining, (Object) vehicleStatus.batteryPercentRemaining) && bfq.m6552a((Object) this.flightTimeRemaining, (Object) vehicleStatus.flightTimeRemaining)) {
                    if (this.communicating == vehicleStatus.communicating) {
                        if (this.readyForFlight == vehicleStatus.readyForFlight) {
                            if (!(this.motorsArmed == vehicleStatus.motorsArmed) || !bfq.m6552a((Object) this.flightMode, (Object) vehicleStatus.flightMode) || !bfq.m6552a((Object) this.flightPlan, (Object) vehicleStatus.flightPlan)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        MessageData messageData2 = this.messageData;
        int i = 0;
        int hashCode = (messageData2 != null ? messageData2.hashCode() : 0) * 31;
        Double d = this.batteryVoltage;
        int hashCode2 = (hashCode + (d != null ? d.hashCode() : 0)) * 31;
        BatteryState batteryState = this.batteryChargeState;
        int hashCode3 = (hashCode2 + (batteryState != null ? batteryState.hashCode() : 0)) * 31;
        Integer num = this.batteryPercentRemaining;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.flightTimeRemaining;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z = this.communicating;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode5 + (z ? 1 : 0)) * 31;
        boolean z3 = this.readyForFlight;
        if (z3) {
            z3 = true;
        }
        int i3 = (i2 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.motorsArmed;
        if (!z4) {
            z2 = z4;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        FlightMode flightMode2 = this.flightMode;
        int hashCode6 = (i4 + (flightMode2 != null ? flightMode2.hashCode() : 0)) * 31;
        String str = this.flightPlan;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "VehicleStatus(messageData=" + this.messageData + ", batteryVoltage=" + this.batteryVoltage + ", batteryChargeState=" + this.batteryChargeState + ", batteryPercentRemaining=" + this.batteryPercentRemaining + ", flightTimeRemaining=" + this.flightTimeRemaining + ", communicating=" + this.communicating + ", readyForFlight=" + this.readyForFlight + ", motorsArmed=" + this.motorsArmed + ", flightMode=" + this.flightMode + ", flightPlan=" + this.flightPlan + ")";
    }

    public VehicleStatus(MessageData messageData2, Double d, BatteryState batteryState, Integer num, Integer num2, boolean z, boolean z2, boolean z3, FlightMode flightMode2, String str) {
        bfq.m6567f(messageData2, "messageData");
        bfq.m6567f(flightMode2, JsonKeyConstants.FLIGHT_MODE);
        this.messageData = messageData2;
        this.batteryVoltage = d;
        this.batteryChargeState = batteryState;
        this.batteryPercentRemaining = num;
        this.flightTimeRemaining = num2;
        this.communicating = z;
        this.readyForFlight = z2;
        this.motorsArmed = z3;
        this.flightMode = flightMode2;
        this.flightPlan = str;
    }

    public final MessageData getMessageData() {
        return this.messageData;
    }

    public final Double getBatteryVoltage() {
        return this.batteryVoltage;
    }

    public final BatteryState getBatteryChargeState() {
        return this.batteryChargeState;
    }

    public final Integer getBatteryPercentRemaining() {
        return this.batteryPercentRemaining;
    }

    public final Integer getFlightTimeRemaining() {
        return this.flightTimeRemaining;
    }

    public final boolean getCommunicating() {
        return this.communicating;
    }

    public final boolean getReadyForFlight() {
        return this.readyForFlight;
    }

    public final boolean getMotorsArmed() {
        return this.motorsArmed;
    }

    public final FlightMode getFlightMode() {
        return this.flightMode;
    }

    public final String getFlightPlan() {
        return this.flightPlan;
    }
}
