package indago.extensions;

import atakplugin.UASTool.aot;
import atakplugin.UASTool.bfq;
import indago.errors.InvalidFormatException;
import indago.errors.MissingElementException;
import indago.time.CoordinatedTime;
import org.json.JSONArray;
import org.json.JSONObject;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a \u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0011\u001a\u0014\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0015\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u001a"}, mo1538e = {"getBooleanOrNull", "", "Lorg/json/JSONObject;", "key", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "getBooleanOrThrow", "getCoordinatedTimeOrNull", "Lindago/time/CoordinatedTime;", "throwIfInvalidFormat", "getCoordinatedTimeOrThrow", "getDoubleOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Double;", "getDoubleOrThrow", "getIntOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "getIntOrThrow", "getJSONArrayOrNull", "Lorg/json/JSONArray;", "getJSONArrayOrThrow", "getJSONObjectOrNull", "getJSONObjectOrThrow", "getStringOrNull", "getStringOrThrow", "indago"})
public final class JSONObjectKt {
    public static final String getStringOrNull(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getStringOrNull");
        bfq.m6567f(str, "key");
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Integer getIntOrNull(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getIntOrNull");
        bfq.m6567f(str, "key");
        try {
            return Integer.valueOf(jSONObject.getInt(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Double getDoubleOrNull(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getDoubleOrNull");
        bfq.m6567f(str, "key");
        try {
            return Double.valueOf(jSONObject.getDouble(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Boolean getBooleanOrNull(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getBooleanOrNull");
        bfq.m6567f(str, "key");
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ CoordinatedTime getCoordinatedTimeOrNull$default(JSONObject jSONObject, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getCoordinatedTimeOrNull(jSONObject, str, z);
    }

    public static final CoordinatedTime getCoordinatedTimeOrNull(JSONObject jSONObject, String str, boolean z) {
        bfq.m6567f(jSONObject, "$this$getCoordinatedTimeOrNull");
        bfq.m6567f(str, "key");
        try {
            String stringOrNull = getStringOrNull(jSONObject, str);
            if (stringOrNull != null) {
                return z ? CoordinatedTime.Companion.parse(stringOrNull) : CoordinatedTime.Companion.tryParse(stringOrNull);
            }
            return null;
        } catch (Exception unused) {
            throw new InvalidFormatException(str, "CoordinatedTime", getStringOrNull(jSONObject, str));
        }
    }

    public static final JSONObject getJSONObjectOrNull(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getJSONObjectOrNull");
        bfq.m6567f(str, "key");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            if (!bfq.m6552a((Object) jSONObject2, JSONObject.NULL)) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final JSONArray getJSONArrayOrNull(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getJSONArrayOrNull");
        bfq.m6567f(str, "key");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (!bfq.m6552a((Object) jSONArray, JSONObject.NULL)) {
                return jSONArray;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getStringOrThrow(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getStringOrThrow");
        bfq.m6567f(str, "key");
        try {
            String string = jSONObject.getString(str);
            bfq.m6554b(string, "this.getString(key)");
            return string;
        } catch (Exception unused) {
            throw new MissingElementException(str);
        }
    }

    public static final int getIntOrThrow(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getIntOrThrow");
        bfq.m6567f(str, "key");
        try {
            return jSONObject.getInt(str);
        } catch (Exception unused) {
            if (jSONObject.has(str)) {
                throw new InvalidFormatException(str, "Int", getStringOrNull(jSONObject, str));
            }
            throw new MissingElementException(str);
        }
    }

    public static final double getDoubleOrThrow(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getDoubleOrThrow");
        bfq.m6567f(str, "key");
        try {
            return jSONObject.getDouble(str);
        } catch (Exception unused) {
            if (jSONObject.has(str)) {
                throw new InvalidFormatException(str, "Double", getStringOrNull(jSONObject, str));
            }
            throw new MissingElementException(str);
        }
    }

    public static final boolean getBooleanOrThrow(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getBooleanOrThrow");
        bfq.m6567f(str, "key");
        try {
            return jSONObject.getBoolean(str);
        } catch (Exception unused) {
            if (jSONObject.has(str)) {
                throw new InvalidFormatException(str, "Boolean", getStringOrNull(jSONObject, str));
            }
            throw new MissingElementException(str);
        }
    }

    public static final CoordinatedTime getCoordinatedTimeOrThrow(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getCoordinatedTimeOrThrow");
        bfq.m6567f(str, "key");
        try {
            return CoordinatedTime.Companion.parse(getStringOrThrow(jSONObject, str));
        } catch (Exception unused) {
            if (jSONObject.has(str)) {
                throw new InvalidFormatException(str, "CoordinatedTime", getStringOrNull(jSONObject, str));
            }
            throw new MissingElementException(str);
        }
    }

    public static final JSONObject getJSONObjectOrThrow(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getJSONObjectOrThrow");
        bfq.m6567f(str, "key");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            if (!bfq.m6552a((Object) jSONObject2, JSONObject.NULL)) {
                bfq.m6554b(jSONObject2, "obj");
                return jSONObject2;
            }
            throw new InvalidFormatException(str, "JSONObject", "Null");
        } catch (Exception unused) {
            throw new MissingElementException(str);
        }
    }

    public static final JSONArray getJSONArrayOrThrow(JSONObject jSONObject, String str) {
        bfq.m6567f(jSONObject, "$this$getJSONArrayOrThrow");
        bfq.m6567f(str, "key");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (!bfq.m6552a((Object) jSONArray, JSONObject.NULL)) {
                bfq.m6554b(jSONArray, "obj");
                return jSONArray;
            }
            throw new InvalidFormatException(str, "JSONObject", "Null");
        } catch (Exception unused) {
            throw new MissingElementException(str);
        }
    }
}
