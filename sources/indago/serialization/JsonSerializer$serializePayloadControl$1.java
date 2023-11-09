package indago.serialization;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bdl;
import atakplugin.UASTool.bfq;
import atakplugin.UASTool.bfr;
import indago.messages.PayloadControl;
import org.json.JSONObject;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo1538e = {"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"})
final class JsonSerializer$serializePayloadControl$1 extends bfr implements bdl<JSONObject, aqr> {
    final /* synthetic */ PayloadControl $payloadControl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsonSerializer$serializePayloadControl$1(PayloadControl payloadControl) {
        super(1);
        this.$payloadControl = payloadControl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return aqr.f2177a;
    }

    public final void invoke(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "$receiver");
        Double azimuthRate_percent = this.$payloadControl.getAzimuthRate_percent();
        if (azimuthRate_percent != null) {
            jSONObject.put(JsonKeyConstants.AZIMUTHRATE_PERCENT, azimuthRate_percent.doubleValue());
        }
        Double elevationRate_percent = this.$payloadControl.getElevationRate_percent();
        if (elevationRate_percent != null) {
            jSONObject.put(JsonKeyConstants.ELEVATIONRATE_PERCENT, elevationRate_percent.doubleValue());
        }
        Double zoomRate_percent = this.$payloadControl.getZoomRate_percent();
        if (zoomRate_percent != null) {
            jSONObject.put(JsonKeyConstants.ZOOMRATE_PERCENT, zoomRate_percent.doubleValue());
        }
    }
}
