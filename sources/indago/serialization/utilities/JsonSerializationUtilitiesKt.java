package indago.serialization.utilities;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.aou;
import atakplugin.UASTool.bfq;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.google.common.net.HttpHeaders;
import indago.datastructures.Vector3;
import indago.errors.InvalidFormatException;
import indago.extensions.JSONObjectKt;
import indago.location.GeoLocation;
import indago.location.GeoPolygon;
import indago.messages.BatteryState;
import indago.messages.FlightAction;
import indago.messages.FlightMode;
import indago.messages.HomeGeolocationMode;
import indago.messages.MessageData;
import indago.messages.MessagePriority;
import indago.messages.VideoPoint;
import indago.messages.VideoPointType;
import indago.pose.CameraFieldOfView;
import indago.pose.FieldOfView;
import indago.serialization.JsonKeyConstants;
import indago.serialization.JsonValueConstants;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0016\u0010\"\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001eH\u0000\u001a\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010&\u001a\u00020\u0007*\u00020\u0017H\u0000\u001a\f\u0010'\u001a\u00020\u0013*\u00020\u0011H\u0000\u001a\u0012\u0010'\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0000\u001a\f\u0010(\u001a\u00020\u0007*\u00020\u000fH\u0000\u001a\f\u0010(\u001a\u00020\u0007*\u00020 H\u0000\u001a\f\u0010(\u001a\u00020\u0007*\u00020\u0005H\u0000\u001a\f\u0010(\u001a\u00020\u0007*\u00020\tH\u0000\u001a\f\u0010)\u001a\u00020\u0003*\u00020\u0001H\u0000\u001a\f\u0010)\u001a\u00020\u0003*\u00020\u000bH\u0000\u001a\f\u0010)\u001a\u00020\u0003*\u00020\rH\u0000\u001a\f\u0010)\u001a\u00020\u0003*\u00020\u0015H\u0000\u001a\f\u0010)\u001a\u00020\u0003*\u00020\u0019H\u0000\u001a\f\u0010)\u001a\u00020\u0003*\u00020%H\u0000\u001a\f\u0010*\u001a\u00020\u0007*\u00020\u001bH\u0000\u001a\f\u0010+\u001a\u00020\u0007*\u00020\u001bH\u0000¨\u0006,"}, mo1538e = {"batteryStateFromStringOrThrow", "Lindago/messages/BatteryState;", "value", "", "cameraFieldOfViewFromJson", "Lindago/pose/CameraFieldOfView;", "json", "Lorg/json/JSONObject;", "fieldOfViewFromJson", "Lindago/pose/FieldOfView;", "flightActionFromStringOrThrow", "Lindago/messages/FlightAction;", "flightModeFromStringOrThrow", "Lindago/messages/FlightMode;", "geoLocationFromJson", "Lindago/location/GeoLocation;", "geoPolygonFromJsonArrayOrThrow", "Lindago/location/GeoPolygon;", "array", "Lorg/json/JSONArray;", "homeGeolocationModeFromStringOrThrow", "Lindago/messages/HomeGeolocationMode;", "messageDataFromJson", "Lindago/messages/MessageData;", "messagePriorityModeFromStringOrThrow", "Lindago/messages/MessagePriority;", "rollPitchYawVectorFromJson", "Lindago/datastructures/Vector3;", "speedVectorFromJson", "stringSetFromJsonArrayOrThrow", "", "videoPointFromJson", "Lindago/messages/VideoPoint;", "videoPointSetFromJsonArrayOrThrow", "videoPointSetToJsonArray", "points", "videoPointTypeFromStringOrThrow", "Lindago/messages/VideoPointType;", "toJson", "toJsonArray", "toJsonObject", "toJsonValue", "toRollPitchYawJsonObject", "toSpeedJsonObject", "indago"})
public final class JsonSerializationUtilitiesKt {

    @aot(mo1534a = 3, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            int[] iArr = new int[VideoPointType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[VideoPointType.TARGET_TRACK.ordinal()] = 1;
            iArr[VideoPointType.FRAME_CENTER.ordinal()] = 2;
            iArr[VideoPointType.UPPER_LEFT_CORNER.ordinal()] = 3;
            iArr[VideoPointType.UPPER_RIGHT_CORNER.ordinal()] = 4;
            iArr[VideoPointType.LOWER_RIGHT_CORNER.ordinal()] = 5;
            iArr[VideoPointType.LOWER_LEFT_CORNER.ordinal()] = 6;
            int[] iArr2 = new int[BatteryState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[BatteryState.HIGH.ordinal()] = 1;
            iArr2[BatteryState.MEDIUM.ordinal()] = 2;
            iArr2[BatteryState.LOW.ordinal()] = 3;
            iArr2[BatteryState.VERY_LOW.ordinal()] = 4;
            int[] iArr3 = new int[FlightAction.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[FlightAction.EXECUTE_FLIGHT_PLAN.ordinal()] = 1;
            iArr3[FlightAction.HOLD_POSITION.ordinal()] = 2;
            iArr3[FlightAction.LAND_AT_HOME.ordinal()] = 3;
            int[] iArr4 = new int[FlightMode.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[FlightMode.ON_GROUND.ordinal()] = 1;
            iArr4[FlightMode.TAKING_OFF.ordinal()] = 2;
            iArr4[FlightMode.NAVIGATING_FLIGHT_PLAN.ordinal()] = 3;
            iArr4[FlightMode.HOLDING_POSITION.ordinal()] = 4;
            iArr4[FlightMode.FOLLOWING_GROUND_STATION.ordinal()] = 5;
            iArr4[FlightMode.FOLLOWING_TARGET.ordinal()] = 6;
            iArr4[FlightMode.MANUAL_CONTROL.ordinal()] = 7;
            iArr4[FlightMode.RETURNING_HOME.ordinal()] = 8;
            iArr4[FlightMode.LANDING.ordinal()] = 9;
            iArr4[FlightMode.EMERGENCY.ordinal()] = 10;
            int[] iArr5 = new int[HomeGeolocationMode.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[HomeGeolocationMode.MANUAL_TAKEOFF_LOCATION.ordinal()] = 1;
            iArr5[HomeGeolocationMode.FOLLOW_GROUND_CONTROL_STATION.ordinal()] = 2;
            int[] iArr6 = new int[MessagePriority.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[MessagePriority.DEBUG.ordinal()] = 1;
            iArr6[MessagePriority.INFORMATIONAL.ordinal()] = 2;
            iArr6[MessagePriority.WARNING.ordinal()] = 3;
            iArr6[MessagePriority.ERROR.ordinal()] = 4;
            iArr6[MessagePriority.FAILURE.ordinal()] = 5;
        }
    }

    public static final JSONObject toJson(MessageData messageData) {
        bfq.m6567f(messageData, "$this$toJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", JsonValueConstants.VERSION);
        jSONObject.put(JsonKeyConstants.SOURCE, messageData.getSourceDevice());
        jSONObject.put(JsonKeyConstants.DESTINATION, messageData.getDestinationDevice());
        jSONObject.put(JsonKeyConstants.TRANSMISSION_TIME, messageData.getTransmissionTime());
        jSONObject.put(JsonKeyConstants.MESSAGE_NUMBER, messageData.getMessageNumber());
        Integer inReplyToMessageNumber = messageData.getInReplyToMessageNumber();
        if (inReplyToMessageNumber != null) {
            jSONObject.put(JsonKeyConstants.IN_REPLY_TO_MESSAGE_NUMBER, inReplyToMessageNumber.intValue());
        }
        return jSONObject;
    }

    public static final MessageData messageDataFromJson(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "json");
        return new MessageData(JSONObjectKt.getStringOrThrow(jSONObject, JsonKeyConstants.SOURCE), JSONObjectKt.getStringOrThrow(jSONObject, JsonKeyConstants.DESTINATION), JSONObjectKt.getIntOrThrow(jSONObject, JsonKeyConstants.MESSAGE_NUMBER), JSONObjectKt.getStringOrNull(jSONObject, JsonKeyConstants.TRANSMISSION_TIME), JSONObjectKt.getIntOrNull(jSONObject, JsonKeyConstants.IN_REPLY_TO_MESSAGE_NUMBER));
    }

    public static final JSONObject toJsonObject(GeoLocation geoLocation) {
        bfq.m6567f(geoLocation, "$this$toJsonObject");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKeyConstants.POINT_LATITUDE, geoLocation.getLat());
        jSONObject.put(JsonKeyConstants.POINT_LONGITUDE, geoLocation.getLon());
        Double msl = geoLocation.getMsl();
        if (msl != null) {
            jSONObject.put(JsonKeyConstants.POINT_ALTITUDE, msl.doubleValue());
        }
        return jSONObject;
    }

    public static final GeoLocation geoLocationFromJson(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "json");
        return new GeoLocation(JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.POINT_LATITUDE), JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.POINT_LONGITUDE), JSONObjectKt.getDoubleOrNull(jSONObject, JsonKeyConstants.POINT_ALTITUDE));
    }

    public static final JSONObject toSpeedJsonObject(Vector3 vector3) {
        bfq.m6567f(vector3, "$this$toSpeedJsonObject");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKeyConstants.V_EAST, vector3.getX());
        jSONObject.put(JsonKeyConstants.V_NORTH, vector3.getY());
        jSONObject.put(JsonKeyConstants.V_UP, vector3.getZ());
        return jSONObject;
    }

    public static final Vector3 speedVectorFromJson(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "json");
        return new Vector3(JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.V_EAST), JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.V_NORTH), JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.V_UP));
    }

    public static final JSONObject toRollPitchYawJsonObject(Vector3 vector3) {
        bfq.m6567f(vector3, "$this$toRollPitchYawJsonObject");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKeyConstants.ROLL, vector3.getX());
        jSONObject.put(JsonKeyConstants.PITCH, vector3.getY());
        jSONObject.put(JsonKeyConstants.YAW, vector3.getZ());
        return jSONObject;
    }

    public static final Vector3 rollPitchYawVectorFromJson(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "json");
        return new Vector3(JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.ROLL), JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.PITCH), JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.YAW));
    }

    public static final JSONObject toJsonObject(FieldOfView fieldOfView) {
        bfq.m6567f(fieldOfView, "$this$toJsonObject");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKeyConstants.FOV_HORIZONTAL, fieldOfView.getHorizontal());
        jSONObject.put(JsonKeyConstants.FOV_VERTICAL, fieldOfView.getVertical());
        return jSONObject;
    }

    public static final FieldOfView fieldOfViewFromJson(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "json");
        return new FieldOfView(JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.FOV_HORIZONTAL), JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.FOV_VERTICAL));
    }

    public static final JSONObject toJsonObject(CameraFieldOfView cameraFieldOfView) {
        bfq.m6567f(cameraFieldOfView, "$this$toJsonObject");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKeyConstants.GIMBAL_AZIMUTH, cameraFieldOfView.getGimbalAzimuth());
        jSONObject.put(JsonKeyConstants.GIMBAL_ROLL, cameraFieldOfView.getGimbalRoll());
        jSONObject.put(JsonKeyConstants.GIMBAL_ELEVATION, cameraFieldOfView.getGimbalElevation());
        jSONObject.put(JsonKeyConstants.FOV_SNAPSHOT, toJsonObject(cameraFieldOfView.getSnapshotFov()));
        jSONObject.put(JsonKeyConstants.FOV_VIDEO, toJsonObject(cameraFieldOfView.getVideoFov()));
        jSONObject.put(JsonKeyConstants.ZOOM_LEVEL, cameraFieldOfView.getZoomLevel());
        return jSONObject;
    }

    public static final CameraFieldOfView cameraFieldOfViewFromJson(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "json");
        return new CameraFieldOfView(JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.GIMBAL_AZIMUTH), JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.GIMBAL_ROLL), JSONObjectKt.getDoubleOrThrow(jSONObject, JsonKeyConstants.GIMBAL_ELEVATION), fieldOfViewFromJson(JSONObjectKt.getJSONObjectOrThrow(jSONObject, JsonKeyConstants.FOV_SNAPSHOT)), fieldOfViewFromJson(JSONObjectKt.getJSONObjectOrThrow(jSONObject, JsonKeyConstants.FOV_VIDEO)), JSONObjectKt.getIntOrThrow(jSONObject, JsonKeyConstants.ZOOM_LEVEL));
    }

    public static final JSONObject toJsonObject(VideoPoint videoPoint) {
        bfq.m6567f(videoPoint, "$this$toJsonObject");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKeyConstants.VIDEO_POINT_TYPE, toJsonValue(videoPoint.getType()));
        jSONObject.put(JsonKeyConstants.VIDEO_GEOLOCATION, toJsonObject(videoPoint.getGeoLocation()));
        return jSONObject;
    }

    public static final VideoPoint videoPointFromJson(JSONObject jSONObject) {
        bfq.m6567f(jSONObject, "json");
        return new VideoPoint(geoLocationFromJson(JSONObjectKt.getJSONObjectOrThrow(jSONObject, JsonKeyConstants.VIDEO_GEOLOCATION)), videoPointTypeFromStringOrThrow(JSONObjectKt.getStringOrThrow(jSONObject, JsonKeyConstants.VIDEO_POINT_TYPE)));
    }

    public static final JSONArray toJsonArray(GeoPolygon geoPolygon) {
        bfq.m6567f(geoPolygon, "$this$toJsonArray");
        JSONArray jSONArray = new JSONArray();
        for (GeoLocation jsonObject : geoPolygon.getPoints()) {
            jSONArray.put(toJsonObject(jsonObject));
        }
        return jSONArray;
    }

    public static final GeoPolygon geoPolygonFromJsonArrayOrThrow(JSONArray jSONArray) {
        bfq.m6567f(jSONArray, "array");
        int length = jSONArray.length();
        HashSet hashSet = new HashSet(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            bfq.m6554b(jSONObject, "array.getJSONObject(i)");
            hashSet.add(geoLocationFromJson(jSONObject));
        }
        return new GeoPolygon(hashSet);
    }

    public static final JSONArray toJsonArray(Set<String> set) {
        bfq.m6567f(set, "$this$toJsonArray");
        JSONArray jSONArray = new JSONArray();
        for (String put : set) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    public static final Set<String> stringSetFromJsonArrayOrThrow(JSONArray jSONArray) {
        bfq.m6567f(jSONArray, "array");
        int length = jSONArray.length();
        HashSet hashSet = new HashSet(length);
        for (int i = 0; i < length; i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return hashSet;
    }

    public static final JSONArray videoPointSetToJsonArray(Set<VideoPoint> set) {
        bfq.m6567f(set, JsonKeyConstants.POINTS);
        JSONArray jSONArray = new JSONArray();
        for (VideoPoint jsonObject : set) {
            jSONArray.put(toJsonObject(jsonObject));
        }
        return jSONArray;
    }

    public static final Set<VideoPoint> videoPointSetFromJsonArrayOrThrow(JSONArray jSONArray) {
        bfq.m6567f(jSONArray, "array");
        int length = jSONArray.length();
        HashSet hashSet = new HashSet(length);
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            bfq.m6554b(jSONObject, "array.getJSONObject(i)");
            hashSet.add(videoPointFromJson(jSONObject));
        }
        return hashSet;
    }

    public static final String toJsonValue(VideoPointType videoPointType) {
        bfq.m6567f(videoPointType, "$this$toJsonValue");
        switch (WhenMappings.$EnumSwitchMapping$0[videoPointType.ordinal()]) {
            case 1:
                return "Target Track";
            case 2:
                return "Frame Center";
            case 3:
                return "Corner 1 (Upper Left)";
            case 4:
                return "Corner 2 (Upper Right)";
            case 5:
                return "Corner 3 (Lower Right)";
            case 6:
                return "Corner 4 (Lower Left)";
            default:
                throw new aou();
        }
    }

    public static final VideoPointType videoPointTypeFromStringOrThrow(String str) {
        bfq.m6567f(str, "value");
        switch (str.hashCode()) {
            case -1865897476:
                if (str.equals("Target Track")) {
                    return VideoPointType.TARGET_TRACK;
                }
                break;
            case -1729249508:
                if (str.equals("Corner 3 (Lower Right)")) {
                    return VideoPointType.LOWER_RIGHT_CORNER;
                }
                break;
            case -12812494:
                if (str.equals("Corner 4 (Lower Left)")) {
                    return VideoPointType.LOWER_LEFT_CORNER;
                }
                break;
            case 706201256:
                if (str.equals("Frame Center")) {
                    return VideoPointType.FRAME_CENTER;
                }
                break;
            case 1798553626:
                if (str.equals("Corner 2 (Upper Right)")) {
                    return VideoPointType.UPPER_RIGHT_CORNER;
                }
                break;
            case 2081936182:
                if (str.equals("Corner 1 (Upper Left)")) {
                    return VideoPointType.UPPER_LEFT_CORNER;
                }
                break;
        }
        throw new InvalidFormatException("VideoGeolocation", "VideoPointType", str);
    }

    public static final String toJsonValue(BatteryState batteryState) {
        bfq.m6567f(batteryState, "$this$toJsonValue");
        int i = WhenMappings.$EnumSwitchMapping$1[batteryState.ordinal()];
        if (i == 1) {
            return "High";
        }
        if (i == 2) {
            return UIPreferenceFragment.DEFAULT_RETICLE_SIZE;
        }
        if (i == 3) {
            return "Low";
        }
        if (i == 4) {
            return "Very Low";
        }
        throw new aou();
    }

    public static final BatteryState batteryStateFromStringOrThrow(String str) {
        bfq.m6567f(str, "value");
        switch (str.hashCode()) {
            case -1994163307:
                if (str.equals(UIPreferenceFragment.DEFAULT_RETICLE_SIZE)) {
                    return BatteryState.MEDIUM;
                }
                break;
            case -1917076118:
                if (str.equals("Very Low")) {
                    return BatteryState.VERY_LOW;
                }
                break;
            case 76596:
                if (str.equals("Low")) {
                    return BatteryState.LOW;
                }
                break;
            case 2249154:
                if (str.equals("High")) {
                    return BatteryState.HIGH;
                }
                break;
        }
        throw new InvalidFormatException("BatteryState", "VideoPointType", str);
    }

    public static final String toJsonValue(FlightAction flightAction) {
        bfq.m6567f(flightAction, "$this$toJsonValue");
        int i = WhenMappings.$EnumSwitchMapping$2[flightAction.ordinal()];
        if (i == 1) {
            return JsonValueConstants.FLIGHT_ACTION_EXECUTE_FLIGHT_PLAN;
        }
        if (i == 2) {
            return JsonValueConstants.FLIGHT_ACTION_HOLD_POSITION;
        }
        if (i == 3) {
            return JsonValueConstants.FLIGHT_ACTION_LAND_AT_HOME;
        }
        throw new aou();
    }

    public static final FlightAction flightActionFromStringOrThrow(String str) {
        bfq.m6567f(str, "value");
        int hashCode = str.hashCode();
        if (hashCode != -1040499570) {
            if (hashCode != 1627848554) {
                if (hashCode == 1692949431 && str.equals(JsonValueConstants.FLIGHT_ACTION_LAND_AT_HOME)) {
                    return FlightAction.LAND_AT_HOME;
                }
            } else if (str.equals(JsonValueConstants.FLIGHT_ACTION_HOLD_POSITION)) {
                return FlightAction.HOLD_POSITION;
            }
        } else if (str.equals(JsonValueConstants.FLIGHT_ACTION_EXECUTE_FLIGHT_PLAN)) {
            return FlightAction.EXECUTE_FLIGHT_PLAN;
        }
        throw new InvalidFormatException("FlightMode", "FlightModeType", str);
    }

    public static final String toJsonValue(FlightMode flightMode) {
        bfq.m6567f(flightMode, "$this$toJsonValue");
        switch (WhenMappings.$EnumSwitchMapping$3[flightMode.ordinal()]) {
            case 1:
                return "On Ground";
            case 2:
                return "Taking Off";
            case 3:
                return "Navigating Flight Plan";
            case 4:
                return "Holding Position";
            case 5:
                return "Following Ground Station";
            case 6:
                return "Following Target";
            case 7:
                return "Manual Control";
            case 8:
                return "Returning Home";
            case 9:
                return "Landing";
            case 10:
                return "Emergency";
            default:
                throw new aou();
        }
    }

    public static final FlightMode flightModeFromStringOrThrow(String str) {
        bfq.m6567f(str, "value");
        switch (str.hashCode()) {
            case -2142652696:
                if (str.equals("On Ground")) {
                    return FlightMode.ON_GROUND;
                }
                break;
            case -2117191731:
                if (str.equals("Returning Home")) {
                    return FlightMode.RETURNING_HOME;
                }
                break;
            case -2110961366:
                if (str.equals("Following Ground Station")) {
                    return FlightMode.FOLLOWING_GROUND_STATION;
                }
                break;
            case -661985935:
                if (str.equals("Emergency")) {
                    return FlightMode.EMERGENCY;
                }
                break;
            case -33668544:
                if (str.equals("Following Target")) {
                    return FlightMode.FOLLOWING_TARGET;
                }
                break;
            case 9573926:
                if (str.equals("Holding Position")) {
                    return FlightMode.HOLDING_POSITION;
                }
                break;
            case 889423571:
                if (str.equals("Taking Off")) {
                    return FlightMode.TAKING_OFF;
                }
                break;
            case 991970759:
                if (str.equals("Navigating Flight Plan")) {
                    return FlightMode.NAVIGATING_FLIGHT_PLAN;
                }
                break;
            case 1593714435:
                if (str.equals("Manual Control")) {
                    return FlightMode.MANUAL_CONTROL;
                }
                break;
            case 1612501495:
                if (str.equals("Landing")) {
                    return FlightMode.LANDING;
                }
                break;
        }
        throw new InvalidFormatException("FlightMode", "FlightModeType", str);
    }

    public static final String toJsonValue(HomeGeolocationMode homeGeolocationMode) {
        bfq.m6567f(homeGeolocationMode, "$this$toJsonValue");
        int i = WhenMappings.$EnumSwitchMapping$4[homeGeolocationMode.ordinal()];
        if (i == 1) {
            return "Manual/Takeoff Location";
        }
        if (i == 2) {
            return "Follow Ground Control Station";
        }
        throw new aou();
    }

    public static final HomeGeolocationMode homeGeolocationModeFromStringOrThrow(String str) {
        bfq.m6567f(str, "value");
        int hashCode = str.hashCode();
        if (hashCode != -938000234) {
            if (hashCode == 234536423 && str.equals("Follow Ground Control Station")) {
                return HomeGeolocationMode.FOLLOW_GROUND_CONTROL_STATION;
            }
        } else if (str.equals("Manual/Takeoff Location")) {
            return HomeGeolocationMode.MANUAL_TAKEOFF_LOCATION;
        }
        throw new InvalidFormatException("HomeGeolocationMode", "HomeGeolocationMode", str);
    }

    public static final String toJsonValue(MessagePriority messagePriority) {
        bfq.m6567f(messagePriority, "$this$toJsonValue");
        int i = WhenMappings.$EnumSwitchMapping$5[messagePriority.ordinal()];
        if (i == 1) {
            return "Debug";
        }
        if (i == 2) {
            return "Informational";
        }
        if (i == 3) {
            return HttpHeaders.WARNING;
        }
        if (i == 4) {
            return "Error";
        }
        if (i == 5) {
            return "Failure";
        }
        throw new aou();
    }

    public static final MessagePriority messagePriorityModeFromStringOrThrow(String str) {
        bfq.m6567f(str, "value");
        switch (str.hashCode()) {
            case -1505867908:
                if (str.equals(HttpHeaders.WARNING)) {
                    return MessagePriority.WARNING;
                }
                break;
            case -1456662985:
                if (str.equals("Informational")) {
                    return MessagePriority.INFORMATIONAL;
                }
                break;
            case 65906227:
                if (str.equals("Debug")) {
                    return MessagePriority.DEBUG;
                }
                break;
            case 67232232:
                if (str.equals("Error")) {
                    return MessagePriority.ERROR;
                }
                break;
            case 578079082:
                if (str.equals("Failure")) {
                    return MessagePriority.FAILURE;
                }
                break;
        }
        throw new InvalidFormatException("MessagePriority", "MessagePriority", str);
    }
}
