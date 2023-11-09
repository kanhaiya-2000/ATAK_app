package indago.serialization;

import atakplugin.UASTool.aot;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo1538e = {"Lindago/serialization/JsonValueConstants;", "", "()V", "FLIGHT_ACTION_EXECUTE_FLIGHT_PLAN", "", "FLIGHT_ACTION_HOLD_POSITION", "FLIGHT_ACTION_LAND_AT_HOME", "FORMAT", "VERSION", "indago"})
public final class JsonValueConstants {
    public static final String FLIGHT_ACTION_EXECUTE_FLIGHT_PLAN = "Execute Flight Plan";
    public static final String FLIGHT_ACTION_HOLD_POSITION = "Hold Position";
    public static final String FLIGHT_ACTION_LAND_AT_HOME = "Land at Home";
    public static final String FORMAT = "VCT JSON 0.0";
    public static final JsonValueConstants INSTANCE = new JsonValueConstants();
    public static final String VERSION = "0.0";

    private JsonValueConstants() {
    }
}
