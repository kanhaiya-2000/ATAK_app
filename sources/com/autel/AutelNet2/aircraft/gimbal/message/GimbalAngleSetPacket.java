package com.autel.AutelNet2.aircraft.gimbal.message;

import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.gimbal.evo.GimbalAngleData;
import org.json.JSONException;
import org.json.JSONObject;

public class GimbalAngleSetPacket extends BaseMsgPacket {
    private GimbalAngleData requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public GimbalAngleSetPacket(GimbalAngleData gimbalAngleData) {
        this.requestBean = gimbalAngleData;
    }

    public int getType() {
        return hashCode();
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_GIMBAL_SET_ANGLE;
        this.msg_head.msg_dst = 4;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", FmuCmdConstant.GIMBAL_ANGLE_SET);
            JSONObject jSONObject2 = new JSONObject();
            if (2.14748365E9f != this.requestBean.getPitch()) {
                jSONObject2.put("Pitch", (double) (this.requestBean.getPitch() * 100.0f));
            }
            if (2.14748365E9f != this.requestBean.getYaw()) {
                jSONObject2.put("Yaw", (double) (this.requestBean.getYaw() * 100.0f));
            }
            if (2.14748365E9f != this.requestBean.getRoll()) {
                jSONObject2.put("Roll", (double) (this.requestBean.getRoll() * 100.0f));
            }
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
