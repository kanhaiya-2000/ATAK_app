package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.CylinderInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class CylinderMissionPacket extends BaseMsgPacket {
    private RequestBean<CylinderInfo> requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public CylinderMissionPacket(CylinderInfo cylinderInfo) {
        this.requestBean = new RequestBean<>(cylinderInfo);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_CYLINDER_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("OrbitInfo");
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }
}
