package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.WaypointActionInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class WaypointActionPacket extends BaseMsgPacket {
    private RequestBean<WaypointActionInfo> requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public WaypointActionPacket(WaypointActionInfo waypointActionInfo) {
        this.requestBean = new RequestBean<>(waypointActionInfo);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_ACTION_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("ActionInfo");
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }
}
