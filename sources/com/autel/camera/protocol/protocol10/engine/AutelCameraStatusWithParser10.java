package com.autel.camera.protocol.protocol10.engine;

import android.text.TextUtils;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.base.AutelCameraStatusInternal;
import org.json.JSONArray;
import org.json.JSONObject;

public class AutelCameraStatusWithParser10 extends AutelCameraStatusInternal {
    private static AutelCameraStatusWithParser10 s_instance;

    private AutelCameraStatusWithParser10() {
    }

    public static AutelCameraStatusWithParser10 instance() {
        if (s_instance == null) {
            s_instance = new AutelCameraStatusWithParser10();
        }
        return s_instance;
    }

    public void parserParams(BaseCameraMsgParser baseCameraMsgParser) {
        String param = baseCameraMsgParser.getParam(CameraCommandMessage.PARAM_PARAM);
        try {
            if (!TextUtils.isEmpty(param) && param.contains("[{")) {
                paramsStatusMap.clear();
                JSONArray jSONArray = new JSONArray(param);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    for (int i2 = 0; i2 < jSONObject.names().length(); i2++) {
                        String str = (String) jSONObject.names().get(i2);
                        paramsStatusMap.put(str, jSONObject.getString(str));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
