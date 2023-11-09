package indago.serialization;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bdl;
import atakplugin.UASTool.bfq;
import atakplugin.UASTool.bfr;
import indago.messages.CheckFlightReadiness;
import org.json.JSONObject;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo1538e = {"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"})
final class JsonSerializer$serializeCheckFlightReadiness$1 extends bfr implements bdl<JSONObject, aqr> {
    final /* synthetic */ CheckFlightReadiness $checkFlightReadiness;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsonSerializer$serializeCheckFlightReadiness$1(CheckFlightReadiness checkFlightReadiness) {
        super(1);
        this.$checkFlightReadiness = checkFlightReadiness;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return aqr.f2177a;
    }

    public final void invoke(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "$receiver");
        jSONObject.put(JsonKeyConstants.OBSERVED_TRUE_HEADING, this.$checkFlightReadiness.getObservedTrueHeading());
    }
}
