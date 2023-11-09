package com.autel.camera.protocol.protocol10.engine;

import android.text.TextUtils;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.base.AutelCameraSettingInternal;
import org.json.JSONArray;
import org.json.JSONObject;

public class AutelCameraSettingWithParser10 extends AutelCameraSettingInternal {
    private AutelCameraSettingWithParser10() {
    }

    public static AutelCameraSettingWithParser10 instance() {
        return AutelCameraSettingWithParser10Holder.s_instance;
    }

    private static class AutelCameraSettingWithParser10Holder {
        /* access modifiers changed from: private */
        public static final AutelCameraSettingWithParser10 s_instance = new AutelCameraSettingWithParser10();

        private AutelCameraSettingWithParser10Holder() {
        }
    }

    public void parserParams(BaseCameraMsgParser baseCameraMsgParser) {
        String param = baseCameraMsgParser.getParam(CameraCommandMessage.PARAM_PARAM);
        try {
            if (!TextUtils.isEmpty(param) && param.contains("[{")) {
                paramsSettingMap.clear();
                JSONArray jSONArray = new JSONArray(param);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    for (int i2 = 0; i2 < jSONObject.names().length(); i2++) {
                        String str = (String) jSONObject.names().get(i2);
                        paramsSettingMap.put(str, jSONObject.getString(str));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
