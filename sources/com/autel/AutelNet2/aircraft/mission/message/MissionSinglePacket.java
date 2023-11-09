package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.MissionSingleInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class MissionSinglePacket extends BaseMsgPacket {
    private RequestBean<MissionSingleInfo> requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public void setRequestBean(MissionSingleInfo missionSingleInfo) {
        RequestBean<MissionSingleInfo> requestBean2 = new RequestBean<>(missionSingleInfo);
        this.requestBean = requestBean2;
        requestBean2.setMethod("MissionInfo");
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_MISSION_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }
}
