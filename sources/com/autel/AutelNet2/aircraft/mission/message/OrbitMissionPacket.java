package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.OrbitInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class OrbitMissionPacket extends BaseMsgPacket {
    private RequestBean<OrbitInfo> requestBean;

    public int getType() {
        return -1201121531;
    }

    public BaseMsgPacket parseBody() {
        return null;
    }

    public OrbitMissionPacket(OrbitInfo orbitInfo) {
        this.requestBean = new RequestBean<>(orbitInfo);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_ORBIT_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("OrbitInfo");
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }
}
