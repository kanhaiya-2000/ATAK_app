package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.mission.controller.MissionStateManager;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import org.json.JSONObject;

public class MissionStatusPacket extends BaseMsgPacket {
    public int hotpoint_lat;
    public int hotpoint_lng;
    public float radius;
    public int seq;
    public float velocity_sp;
    public int wp_mode;
    public int yaw_centered;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public MissionStatusPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        JSONObject jSONObject = getBodyJson().getJSONObject("params");
        this.velocity_sp = (float) jSONObject.getDouble("VelocitySp");
        this.hotpoint_lat = jSONObject.getInt("HotpointLat");
        this.hotpoint_lng = jSONObject.getInt("HotpointLon");
        this.radius = (float) jSONObject.getDouble("Radius");
        this.seq = jSONObject.getInt("Seq");
        this.wp_mode = jSONObject.getInt("WpMode");
        this.yaw_centered = jSONObject.getInt("YawCentered");
        MissionStateManager.getInstance().parseData(this);
        return this;
    }
}
