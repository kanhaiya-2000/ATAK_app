package indago.serialization;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bdl;
import atakplugin.UASTool.bfq;
import atakplugin.UASTool.bfr;
import indago.messages.BatteryState;
import indago.messages.VehicleStatus;
import indago.serialization.utilities.JsonSerializationUtilitiesKt;
import org.json.JSONObject;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo1538e = {"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"})
final class JsonSerializer$serializeVehicleStatus$1 extends bfr implements bdl<JSONObject, aqr> {
    final /* synthetic */ VehicleStatus $vehicleStatus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsonSerializer$serializeVehicleStatus$1(VehicleStatus vehicleStatus) {
        super(1);
        this.$vehicleStatus = vehicleStatus;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return aqr.f2177a;
    }

    public final void invoke(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "$receiver");
        jSONObject.put(JsonKeyConstants.COMMUNICATING, this.$vehicleStatus.getCommunicating());
        jSONObject.put(JsonKeyConstants.READY_FOR_FLIGHT, this.$vehicleStatus.getReadyForFlight());
        jSONObject.put(JsonKeyConstants.MOTORS_ARMED, this.$vehicleStatus.getMotorsArmed());
        jSONObject.put(JsonKeyConstants.FLIGHT_MODE, JsonSerializationUtilitiesKt.toJsonValue(this.$vehicleStatus.getFlightMode()));
        Double batteryVoltage = this.$vehicleStatus.getBatteryVoltage();
        if (batteryVoltage != null) {
            jSONObject.put(JsonKeyConstants.BATTERY_VOLTAGE, batteryVoltage.doubleValue());
        }
        BatteryState batteryChargeState = this.$vehicleStatus.getBatteryChargeState();
        if (batteryChargeState != null) {
            jSONObject.put(JsonKeyConstants.BATTERY_CHARGE_STATE, JsonSerializationUtilitiesKt.toJsonValue(batteryChargeState));
        }
        Integer batteryPercentRemaining = this.$vehicleStatus.getBatteryPercentRemaining();
        if (batteryPercentRemaining != null) {
            jSONObject.put(JsonKeyConstants.BATTERY_PERCENT_REMAINING, batteryPercentRemaining.intValue());
        }
        Integer flightTimeRemaining = this.$vehicleStatus.getFlightTimeRemaining();
        if (flightTimeRemaining != null) {
            jSONObject.put(JsonKeyConstants.FLIGHT_TIME_MINUTES_REMAINING, flightTimeRemaining.intValue());
        }
        String flightPlan = this.$vehicleStatus.getFlightPlan();
        if (flightPlan != null) {
            jSONObject.put(JsonKeyConstants.FLIGHT_PLAN, flightPlan);
        }
    }
}
