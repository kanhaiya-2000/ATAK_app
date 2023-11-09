package com.autel.AutelNet2.aircraft.gimbal.message;

import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.gimbal.evo.GimbalAngleSpeed;
import org.json.JSONException;
import org.json.JSONObject;

public class GimbalAngleSpeedPacket extends BaseMsgPacket {
    private GimbalAngleSpeed requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public GimbalAngleSpeedPacket(GimbalAngleSpeed gimbalAngleSpeed) {
        this.requestBean = gimbalAngleSpeed;
    }

    public int getType() {
        return hashCode();
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_GIMBAL_SET_ANGLE_SPEED;
        this.msg_head.msg_dst = 4;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", FmuCmdConstant.GIMBAL_ANGLE_SPEED_SET);
            JSONObject jSONObject2 = new JSONObject();
            if (0.0f != this.requestBean.getPitchSpeed()) {
                jSONObject2.put("PitchSpeed", (int) (this.requestBean.getPitchSpeed() * 100.0f));
            }
            if (this.requestBean.getYawSpeed() != 0) {
                jSONObject2.put("YawSpeed", this.requestBean.getYawSpeed() * 100);
            }
            if (this.requestBean.getRollSpeed() != 0) {
                jSONObject2.put("RollSpeed", this.requestBean.getRollSpeed() * 100);
            }
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
