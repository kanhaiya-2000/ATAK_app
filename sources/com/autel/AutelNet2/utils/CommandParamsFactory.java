package com.autel.AutelNet2.utils;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class CommandParamsFactory {

    /* renamed from: id */
    public static int f8441id = 0;
    private static CommandParamsFactory instance = null;
    public static final String method_GetTrackStatus = "GetTrackStatus";
    public static final String method_SetGoalArea = "SetGoalArea";
    public static final String method_SetTrackPattern = "SetTrackPattern";
    public static final String method_StopTracking = "StopTracking";
    public static final String param_Action = "action";
    public static final String param_Height = "Hight";
    public static final String param_StartX = "StartX";
    public static final String param_StartY = "StartY";
    public static final String param_TargetType = "TargetType";
    public static final String param_Width = "Width";

    private CommandParamsFactory() {
    }

    public static CommandParamsFactory instance() {
        if (instance == null) {
            instance = new CommandParamsFactory();
        }
        return instance;
    }

    public String buildSetGoalArea(float f, float f2, float f3, float f4, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("StartX", Float.valueOf(f));
        hashMap.put("StartY", Float.valueOf(f2));
        hashMap.put("Width", Float.valueOf(f3));
        hashMap.put("Hight", Float.valueOf(f4));
        hashMap.put("TargetType", Integer.valueOf(i));
        return buildParamByMap("SetGoalArea", hashMap);
    }

    public String buildStopTrack() {
        return buildParamByMap("StopTracking", (Map<String, Object>) null);
    }

    public String buildGetTrackState() {
        return buildParamByMap("GetTrackStatus", (Map<String, Object>) null);
    }

    public String buildSetTrackMode(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        return buildParamByMap("SetTrackPattern", hashMap);
    }

    private String buildParamByMap(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", str);
            if (map != null) {
                jSONObject.put("params", new JSONObject(map));
            }
            int i = f8441id + 1;
            f8441id = i;
            jSONObject.put("id", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
