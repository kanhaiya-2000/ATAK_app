package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.WaypointBean;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class WayPointInfoPacket extends BaseMsgPacket {
    private RequestBean<WaypointBean> requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public WayPointInfoPacket(WaypointBean waypointBean) {
        this.requestBean = new RequestBean<>(waypointBean);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_WAYPOINT_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("WaypointsInfo");
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }
}
