package indago.serialization;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bdl;
import atakplugin.UASTool.bfq;
import atakplugin.UASTool.bfr;
import indago.location.GeoLocation;
import indago.messages.VehicleKinematicData;
import indago.pose.CameraFieldOfView;
import indago.serialization.utilities.JsonSerializationUtilitiesKt;
import org.json.JSONObject;

@aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo1538e = {"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"})
final class JsonSerializer$serializeVehicleKinematicData$1 extends bfr implements bdl<JSONObject, aqr> {
    final /* synthetic */ VehicleKinematicData $kinematicData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsonSerializer$serializeVehicleKinematicData$1(VehicleKinematicData vehicleKinematicData) {
        super(1);
        this.$kinematicData = vehicleKinematicData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return aqr.f2177a;
    }

    public final void invoke(JSONObject jSONObject) {
        Object obj;
        bfq.m6567f(jSONObject, "$receiver");
        Object time = this.$kinematicData.getTime();
        if (time == null) {
            time = JSONObject.NULL;
        }
        jSONObject.put(JsonKeyConstants.UTC_TIME, time);
        GeoLocation position = this.$kinematicData.getPosition();
        if (position == null || (obj = JsonSerializationUtilitiesKt.toJsonObject(position)) == null) {
            obj = JSONObject.NULL;
        }
        jSONObject.put(JsonKeyConstants.POSITION, obj);
        jSONObject.put(JsonKeyConstants.GROUND_SPEED, JsonSerializationUtilitiesKt.toSpeedJsonObject(this.$kinematicData.getGroundSpeed()));
        jSONObject.put(JsonKeyConstants.ROLL_PITCH_YAW, JsonSerializationUtilitiesKt.toRollPitchYawJsonObject(this.$kinematicData.getRollPitchYaw()));
        CameraFieldOfView cameraFieldOfView = this.$kinematicData.getCameraFieldOfView();
        if (cameraFieldOfView != null) {
            jSONObject.put(JsonKeyConstants.CAMERA_FIELD_OF_VIEW, JsonSerializationUtilitiesKt.toJsonObject(cameraFieldOfView));
        }
    }
}
