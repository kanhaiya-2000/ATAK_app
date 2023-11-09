package com.autel.AutelNet2.aircraft.flycontroller.message;

import android.text.format.Time;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class SystemDateAndTimePacket extends BaseMsgPacket {
    public BaseMsgPacket parseBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 22;
        this.msg_head.msg_dst = MsgType.AU_BUTTON_PHOTO_RECORD_RESP;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            Time time = new Time();
            time.setToNow();
            String format = time.format("%Y-%m-%d %H:%M:%S");
            jSONObject.put("method", CameraParamsConfig.method_SetSystemDateAndTime);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CameraParamsConfig.param_TimeZone, TimeZone.getDefault().getRawOffset() / 1000);
            jSONObject2.put(CameraParamsConfig.param_DateTime, format);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
