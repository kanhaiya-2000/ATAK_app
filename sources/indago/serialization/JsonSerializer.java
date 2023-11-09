package indago.serialization;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.apu;
import atakplugin.UASTool.aqr;
import atakplugin.UASTool.bdl;
import atakplugin.UASTool.bfq;
import indago.datastructures.Vector3;
import indago.errors.InvalidDataException;
import indago.errors.InvalidPayloadException;
import indago.extensions.JSONObjectKt;
import indago.location.GeoLocation;
import indago.messages.ChangeFlightMode;
import indago.messages.CheckFlightReadiness;
import indago.messages.DesiredSearchArea;
import indago.messages.EventMessage;
import indago.messages.HomeGeolocation;
import indago.messages.LoadFlightPlan;
import indago.messages.LookAtPosition;
import indago.messages.MessageData;
import indago.messages.PayloadControl;
import indago.messages.SavedFlightPlans;
import indago.messages.UnsupportedMessageAdvisory;
import indago.messages.VehicleKinematicData;
import indago.messages.VehicleStatus;
import indago.messages.VideoGeolocation;
import indago.pose.CameraFieldOfView;
import indago.serialization.utilities.JsonSerializationUtilitiesKt;
import org.json.JSONException;
import org.json.JSONObject;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J;\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013H\u0002J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\nH\u0002J\"\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0/2\u0006\u00100\u001a\u00020\u000eH\u0002J\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0016H\u0016J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0019H\u0016J\u0010\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u001dH\u0016J\u0010\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u001fH\u0016J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020!H\u0016J\u0010\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020#H\u0016J\u0010\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020%H\u0016J\u0010\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020'H\u0016J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020)H\u0016J\u0010\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020+H\u0016J\u0010\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020-H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006M"}, mo1538e = {"Lindago/serialization/JsonSerializer;", "Lindago/serialization/MessageSerializer;", "()V", "deserializationCallback", "Lindago/serialization/MessageDeserializationCallback;", "getDeserializationCallback", "()Lindago/serialization/MessageDeserializationCallback;", "setDeserializationCallback", "(Lindago/serialization/MessageDeserializationCallback;)V", "buildStandardMessage", "Lorg/json/JSONObject;", "messageData", "Lindago/messages/MessageData;", "payloadType", "", "version", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "createStandardVersionedPayloadObject", "deserializeChangeFlightMode", "Lindago/messages/ChangeFlightMode;", "payload", "deserializeCheckFlightReadiness", "Lindago/messages/CheckFlightReadiness;", "deserializeData", "data", "deserializeDesiredSearchArea", "Lindago/messages/DesiredSearchArea;", "deserializeEventMessage", "Lindago/messages/EventMessage;", "deserializeHomeGeolocation", "Lindago/messages/HomeGeolocation;", "deserializeLoadFlightPlan", "Lindago/messages/LoadFlightPlan;", "deserializeSavedFlightPlans", "Lindago/messages/SavedFlightPlans;", "deserializeUnsupportedMessageAdvisory", "Lindago/messages/UnsupportedMessageAdvisory;", "deserializeVehicleKinematicData", "Lindago/messages/VehicleKinematicData;", "deserializeVehicleStatus", "Lindago/messages/VehicleStatus;", "deserializeVideoGeolocation", "Lindago/messages/VideoGeolocation;", "getMessageDataPayloadTypeAndPayload", "Lkotlin/Triple;", "document", "serializeChangeFlightMode", "changeFlightMode", "serializeCheckFlightReadiness", "checkFlightReadiness", "serializeDesiredSearchArea", "desiredSearchArea", "serializeEventMessage", "eventMessage", "serializeHomeGeolocation", "homeGeolocation", "serializeLoadFlightPlan", "loadFlightPlan", "serializeLookAtPosition", "lookAtPosition", "Lindago/messages/LookAtPosition;", "serializePayloadControl", "payloadControl", "Lindago/messages/PayloadControl;", "serializeSavedFlightPlans", "savedFlightPlans", "serializeUnsupportedMessageAdvisory", "unsupportedMessageAdvisory", "serializeVehicleKinematicData", "kinematicData", "serializeVehicleStatus", "vehicleStatus", "serializeVideoGeolocation", "videoGeolocation", "indago"})
public final class JsonSerializer implements MessageSerializer {
    private MessageDeserializationCallback deserializationCallback;

    public MessageDeserializationCallback getDeserializationCallback() {
        return this.deserializationCallback;
    }

    public void setDeserializationCallback(MessageDeserializationCallback messageDeserializationCallback) {
        this.deserializationCallback = messageDeserializationCallback;
    }

    public void deserializeData(String str) {
        bfq.m6567f(str, "data");
        MessageDeserializationCallback deserializationCallback2 = getDeserializationCallback();
        if (deserializationCallback2 != null) {
            apu<MessageData, String, JSONObject> messageDataPayloadTypeAndPayload = getMessageDataPayloadTypeAndPayload(str);
            MessageData d = messageDataPayloadTypeAndPayload.mo1569d();
            String e = messageDataPayloadTypeAndPayload.mo1570e();
            JSONObject f = messageDataPayloadTypeAndPayload.mo1572f();
            switch (e.hashCode()) {
                case -1866928455:
                    if (e.equals(JsonPayloadValueConstants.VEHICLE_KINEMATIC_DATA)) {
                        deserializationCallback2.onVehicleKinematicDataDeserialized(deserializeVehicleKinematicData(d, f));
                        return;
                    }
                    break;
                case -1669196383:
                    if (e.equals(JsonPayloadValueConstants.VIDEO_GEOLOCATION)) {
                        deserializationCallback2.onVideoGeolocationDeserialized(deserializeVideoGeolocation(d, f));
                        return;
                    }
                    break;
                case -495944957:
                    if (e.equals(JsonPayloadValueConstants.CHANGE_FLIGHT_MODE)) {
                        deserializationCallback2.onChangeFlightModeDeserialized(deserializeChangeFlightMode(d, f));
                        return;
                    }
                    break;
                case -281873453:
                    if (e.equals(JsonPayloadValueConstants.SAVED_FLIGHT_PLANS)) {
                        deserializationCallback2.onSavedFlightPlansDeserialized(deserializeSavedFlightPlans(d, f));
                        return;
                    }
                    break;
                case -261162083:
                    if (e.equals(JsonPayloadValueConstants.UNSUPPORTED_MESSAGE_ADVISORY)) {
                        deserializationCallback2.onUnsupportedMessageAdvisoryDeserialized(deserializeUnsupportedMessageAdvisory(d, f));
                        return;
                    }
                    break;
                case 80861938:
                    if (e.equals(JsonPayloadValueConstants.CHECK_FLIGHT_READINESS)) {
                        deserializationCallback2.onCheckFlightReadinessDeserialized(deserializeCheckFlightReadiness(d, f));
                        return;
                    }
                    break;
                case 165774405:
                    if (e.equals(JsonPayloadValueConstants.HOME_GEOLOCATION)) {
                        deserializationCallback2.onHomeGeolocationDeserialized(deserializeHomeGeolocation(d, f));
                        return;
                    }
                    break;
                case 1248847039:
                    if (e.equals(JsonPayloadValueConstants.LOAD_FLIGHT_PLAN)) {
                        deserializationCallback2.onLoadFlightPlanDeserialized(deserializeLoadFlightPlan(d, f));
                        return;
                    }
                    break;
                case 1380424769:
                    if (e.equals(JsonPayloadValueConstants.EVENT_MESSAGE)) {
                        deserializationCallback2.onEventMessageDeserialized(deserializeEventMessage(d, f));
                        return;
                    }
                    break;
                case 1581397926:
                    if (e.equals(JsonPayloadValueConstants.VEHICLE_STATUS)) {
                        deserializationCallback2.onVehicleStatusDeserialized(deserializeVehicleStatus(d, f));
                        return;
                    }
                    break;
                case 1900198751:
                    if (e.equals(JsonPayloadValueConstants.DESIRED_SEARCH_AREA)) {
                        deserializationCallback2.onDesiredSearchAreaDeserialized(deserializeDesiredSearchArea(d, f));
                        return;
                    }
                    break;
            }
            new InvalidPayloadException("Payload '" + e + "' not supported");
        }
    }

    private final ChangeFlightMode deserializeChangeFlightMode(MessageData messageData, JSONObject jSONObject) {
        return new ChangeFlightMode(messageData, JsonSerializationUtilitiesKt.flightActionFromStringOrThrow(JSONObjectKt.getStringOrThrow(jSONObject, JsonKeyConstants.DESIRED_MODE)));
    }

    private final CheckFlightReadiness deserializeCheckFlightReadiness(MessageData messageData, JSONObject jSONObject) {
        return new CheckFlightReadiness(messageData, JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.OBSERVED_TRUE_HEADING));
    }

    private final DesiredSearchArea deserializeDesiredSearchArea(MessageData messageData, JSONObject jSONObject) {
        return new DesiredSearchArea(messageData, JsonSerializationUtilitiesKt.geoPolygonFromJsonArrayOrThrow(JSONObjectKt.getJSONArrayOrThrow(jSONObject, JsonKeyConstants.POLYGON)));
    }

    private final EventMessage deserializeEventMessage(MessageData messageData, JSONObject jSONObject) {
        return new EventMessage(messageData, JsonSerializationUtilitiesKt.messagePriorityModeFromStringOrThrow(JSONObjectKt.getStringOrThrow(jSONObject, JsonKeyConstants.MESSAGE_TYPE)), JSONObjectKt.getStringOrThrow(jSONObject, "message"));
    }

    private final HomeGeolocation deserializeHomeGeolocation(MessageData messageData, JSONObject jSONObject) {
        GeoLocation geoLocation;
        JSONObject jSONObjectOrNull = JSONObjectKt.getJSONObjectOrNull(jSONObject, JsonKeyConstants.POSITION);
        if (jSONObjectOrNull != null) {
            System.out.print("deserializeHomeGeolocation(messageData, payload)");
            geoLocation = JsonSerializationUtilitiesKt.geoLocationFromJson(jSONObjectOrNull);
        } else {
            geoLocation = null;
        }
        return new HomeGeolocation(messageData, geoLocation, JsonSerializationUtilitiesKt.homeGeolocationModeFromStringOrThrow(JSONObjectKt.getStringOrThrow(jSONObject, "mode")));
    }

    private final LoadFlightPlan deserializeLoadFlightPlan(MessageData messageData, JSONObject jSONObject) {
        return new LoadFlightPlan(messageData, JSONObjectKt.getStringOrThrow(jSONObject, JsonKeyConstants.FLIGHT_PLAN));
    }

    private final SavedFlightPlans deserializeSavedFlightPlans(MessageData messageData, JSONObject jSONObject) {
        return new SavedFlightPlans(messageData, JsonSerializationUtilitiesKt.stringSetFromJsonArrayOrThrow(JSONObjectKt.getJSONArrayOrThrow(jSONObject, JsonKeyConstants.FLIGHT_PLANS)));
    }

    private final UnsupportedMessageAdvisory deserializeUnsupportedMessageAdvisory(MessageData messageData, JSONObject jSONObject) {
        return new UnsupportedMessageAdvisory(messageData);
    }

    private final VehicleKinematicData deserializeVehicleKinematicData(MessageData messageData, JSONObject jSONObject) {
        CameraFieldOfView cameraFieldOfView;
        String stringOrNull = JSONObjectKt.getStringOrNull(jSONObject, JsonKeyConstants.UTC_TIME);
        JSONObject jSONObjectOrNull = JSONObjectKt.getJSONObjectOrNull(jSONObject, JsonKeyConstants.POSITION);
        GeoLocation geoLocationFromJson = jSONObjectOrNull != null ? JsonSerializationUtilitiesKt.geoLocationFromJson(jSONObjectOrNull) : null;
        Vector3 speedVectorFromJson = JsonSerializationUtilitiesKt.speedVectorFromJson(JSONObjectKt.getJSONObjectOrThrow(jSONObject, JsonKeyConstants.GROUND_SPEED));
        Vector3 rollPitchYawVectorFromJson = JsonSerializationUtilitiesKt.rollPitchYawVectorFromJson(JSONObjectKt.getJSONObjectOrThrow(jSONObject, JsonKeyConstants.ROLL_PITCH_YAW));
        JSONObject jSONObjectOrNull2 = JSONObjectKt.getJSONObjectOrNull(jSONObject, JsonKeyConstants.CAMERA_FIELD_OF_VIEW);
        if (jSONObjectOrNull2 != null) {
            cameraFieldOfView = JsonSerializationUtilitiesKt.cameraFieldOfViewFromJson(jSONObjectOrNull2);
        } else {
            cameraFieldOfView = null;
        }
        return new VehicleKinematicData(messageData, stringOrNull, geoLocationFromJson, speedVectorFromJson, rollPitchYawVectorFromJson, cameraFieldOfView);
    }

    private final VehicleStatus deserializeVehicleStatus(MessageData messageData, JSONObject jSONObject) {
        Double doubleOrNull = JSONObjectKt.getDoubleOrNull(jSONObject, JsonKeyConstants.BATTERY_VOLTAGE);
        String stringOrNull = JSONObjectKt.getStringOrNull(jSONObject, JsonKeyConstants.BATTERY_CHARGE_STATE);
        return new VehicleStatus(messageData, doubleOrNull, stringOrNull != null ? JsonSerializationUtilitiesKt.batteryStateFromStringOrThrow(stringOrNull) : null, JSONObjectKt.getIntOrNull(jSONObject, JsonKeyConstants.BATTERY_PERCENT_REMAINING), JSONObjectKt.getIntOrNull(jSONObject, JsonKeyConstants.FLIGHT_TIME_MINUTES_REMAINING), JSONObjectKt.getBooleanOrThrow(jSONObject, JsonKeyConstants.COMMUNICATING), JSONObjectKt.getBooleanOrThrow(jSONObject, JsonKeyConstants.READY_FOR_FLIGHT), JSONObjectKt.getBooleanOrThrow(jSONObject, JsonKeyConstants.MOTORS_ARMED), JsonSerializationUtilitiesKt.flightModeFromStringOrThrow(JSONObjectKt.getStringOrThrow(jSONObject, JsonKeyConstants.FLIGHT_MODE)), JSONObjectKt.getStringOrNull(jSONObject, JsonKeyConstants.FLIGHT_PLAN));
    }

    private final VideoGeolocation deserializeVideoGeolocation(MessageData messageData, JSONObject jSONObject) {
        return new VideoGeolocation(messageData, JsonSerializationUtilitiesKt.videoPointSetFromJsonArrayOrThrow(JSONObjectKt.getJSONArrayOrThrow(jSONObject, JsonKeyConstants.POINTS)));
    }

    private final apu<MessageData, String, JSONObject> getMessageDataPayloadTypeAndPayload(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            MessageData messageDataFromJson = JsonSerializationUtilitiesKt.messageDataFromJson(JSONObjectKt.getJSONObjectOrThrow(jSONObject, JsonKeyConstants.HEADER));
            JSONObject jSONObjectOrThrow = JSONObjectKt.getJSONObjectOrThrow(jSONObject, "payload");
            return new apu<>(messageDataFromJson, JSONObjectKt.getStringOrThrow(jSONObjectOrThrow, JsonKeyConstants.PAYLOAD_TYPE), jSONObjectOrThrow);
        } catch (JSONException unused) {
            throw new InvalidDataException("Invalid document: " + str);
        }
    }

    public String serializeChangeFlightMode(ChangeFlightMode changeFlightMode) {
        bfq.m6567f(changeFlightMode, "changeFlightMode");
        String jSONObject = buildStandardMessage$default(this, changeFlightMode.getMessageData(), JsonPayloadValueConstants.CHANGE_FLIGHT_MODE, (String) null, new JsonSerializer$serializeChangeFlightMode$1(changeFlightMode), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …e())\n        }.toString()");
        return jSONObject;
    }

    public String serializeCheckFlightReadiness(CheckFlightReadiness checkFlightReadiness) {
        bfq.m6567f(checkFlightReadiness, "checkFlightReadiness");
        String jSONObject = buildStandardMessage$default(this, checkFlightReadiness.getMessageData(), JsonPayloadValueConstants.CHECK_FLIGHT_READINESS, (String) null, new JsonSerializer$serializeCheckFlightReadiness$1(checkFlightReadiness), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …ing)\n        }.toString()");
        return jSONObject;
    }

    public String serializeDesiredSearchArea(DesiredSearchArea desiredSearchArea) {
        bfq.m6567f(desiredSearchArea, "desiredSearchArea");
        String jSONObject = buildStandardMessage$default(this, desiredSearchArea.getMessageData(), JsonPayloadValueConstants.DESIRED_SEARCH_AREA, (String) null, new JsonSerializer$serializeDesiredSearchArea$1(desiredSearchArea), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …y())\n        }.toString()");
        return jSONObject;
    }

    public String serializeEventMessage(EventMessage eventMessage) {
        bfq.m6567f(eventMessage, "eventMessage");
        String jSONObject = buildStandardMessage$default(this, eventMessage.getMessageData(), JsonPayloadValueConstants.EVENT_MESSAGE, (String) null, new JsonSerializer$serializeEventMessage$1(eventMessage), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …age)\n        }.toString()");
        return jSONObject;
    }

    public String serializeHomeGeolocation(HomeGeolocation homeGeolocation) {
        bfq.m6567f(homeGeolocation, "homeGeolocation");
        String jSONObject = buildStandardMessage$default(this, homeGeolocation.getMessageData(), JsonPayloadValueConstants.HOME_GEOLOCATION, (String) null, new JsonSerializer$serializeHomeGeolocation$1(homeGeolocation), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …e())\n        }.toString()");
        return jSONObject;
    }

    public String serializeLookAtPosition(LookAtPosition lookAtPosition) {
        bfq.m6567f(lookAtPosition, "lookAtPosition");
        String jSONObject = buildStandardMessage$default(this, lookAtPosition.getMessageData(), JsonPayloadValueConstants.LOOK_AT_POSITION, (String) null, new JsonSerializer$serializeLookAtPosition$1(lookAtPosition), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …t())\n        }.toString()");
        return jSONObject;
    }

    public String serializePayloadControl(PayloadControl payloadControl) {
        bfq.m6567f(payloadControl, "payloadControl");
        String jSONObject = buildStandardMessage$default(this, payloadControl.getMessageData(), JsonPayloadValueConstants.PAYLOAD_CONTROL, (String) null, new JsonSerializer$serializePayloadControl$1(payloadControl), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …) }\n\n        }.toString()");
        return jSONObject;
    }

    public String serializeLoadFlightPlan(LoadFlightPlan loadFlightPlan) {
        bfq.m6567f(loadFlightPlan, "loadFlightPlan");
        String jSONObject = buildStandardMessage$default(this, loadFlightPlan.getMessageData(), JsonPayloadValueConstants.LOAD_FLIGHT_PLAN, (String) null, new JsonSerializer$serializeLoadFlightPlan$1(loadFlightPlan), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …lan)\n        }.toString()");
        return jSONObject;
    }

    public String serializeSavedFlightPlans(SavedFlightPlans savedFlightPlans) {
        bfq.m6567f(savedFlightPlans, "savedFlightPlans");
        String jSONObject = buildStandardMessage$default(this, savedFlightPlans.getMessageData(), JsonPayloadValueConstants.SAVED_FLIGHT_PLANS, (String) null, new JsonSerializer$serializeSavedFlightPlans$1(savedFlightPlans), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …y())\n        }.toString()");
        return jSONObject;
    }

    public String serializeUnsupportedMessageAdvisory(UnsupportedMessageAdvisory unsupportedMessageAdvisory) {
        bfq.m6567f(unsupportedMessageAdvisory, "unsupportedMessageAdvisory");
        String jSONObject = buildStandardMessage$default(this, unsupportedMessageAdvisory.getMessageData(), JsonPayloadValueConstants.UNSUPPORTED_MESSAGE_ADVISORY, (String) null, JsonSerializer$serializeUnsupportedMessageAdvisory$1.INSTANCE, 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …Y\n        ) {}.toString()");
        return jSONObject;
    }

    public String serializeVehicleKinematicData(VehicleKinematicData vehicleKinematicData) {
        bfq.m6567f(vehicleKinematicData, "kinematicData");
        String jSONObject = buildStandardMessage$default(this, vehicleKinematicData.getMessageData(), JsonPayloadValueConstants.VEHICLE_KINEMATIC_DATA, (String) null, new JsonSerializer$serializeVehicleKinematicData$1(vehicleKinematicData), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …) }\n\n        }.toString()");
        return jSONObject;
    }

    public String serializeVehicleStatus(VehicleStatus vehicleStatus) {
        bfq.m6567f(vehicleStatus, "vehicleStatus");
        String jSONObject = buildStandardMessage$default(this, vehicleStatus.getMessageData(), JsonPayloadValueConstants.VEHICLE_STATUS, (String) null, new JsonSerializer$serializeVehicleStatus$1(vehicleStatus), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …) }\n\n        }.toString()");
        return jSONObject;
    }

    public String serializeVideoGeolocation(VideoGeolocation videoGeolocation) {
        bfq.m6567f(videoGeolocation, "videoGeolocation");
        String jSONObject = buildStandardMessage$default(this, videoGeolocation.getMessageData(), JsonPayloadValueConstants.VIDEO_GEOLOCATION, (String) null, new JsonSerializer$serializeVideoGeolocation$1(videoGeolocation), 4, (Object) null).toString();
        bfq.m6554b(jSONObject, "buildStandardMessage(\n  …   )\n        }.toString()");
        return jSONObject;
    }

    static /* synthetic */ JSONObject buildStandardMessage$default(JsonSerializer jsonSerializer, MessageData messageData, String str, String str2, bdl bdl, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = JsonValueConstants.VERSION;
        }
        return jsonSerializer.buildStandardMessage(messageData, str, str2, bdl);
    }

    private final JSONObject buildStandardMessage(MessageData messageData, String str, String str2, bdl<? super JSONObject, aqr> bdl) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKeyConstants.FORMAT, JsonValueConstants.FORMAT);
        jSONObject.put(JsonKeyConstants.HEADER, JsonSerializationUtilitiesKt.toJson(messageData));
        JSONObject createStandardVersionedPayloadObject = createStandardVersionedPayloadObject(str, str2);
        bdl.invoke(createStandardVersionedPayloadObject);
        jSONObject.put("payload", createStandardVersionedPayloadObject);
        return jSONObject;
    }

    static /* synthetic */ JSONObject createStandardVersionedPayloadObject$default(JsonSerializer jsonSerializer, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = JsonValueConstants.VERSION;
        }
        return jsonSerializer.createStandardVersionedPayloadObject(str, str2);
    }

    private final JSONObject createStandardVersionedPayloadObject(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", str2);
        jSONObject.put(JsonKeyConstants.PAYLOAD_TYPE, str);
        return jSONObject;
    }
}
