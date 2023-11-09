package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.PanoramaInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class PanoramaPacket extends BaseMsgPacket {
    private RequestBean<PanoramaInfo> requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public PanoramaPacket(PanoramaInfo panoramaInfo) {
        this.requestBean = new RequestBean<>(panoramaInfo);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_PANORAMA_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("PanoramaInfo");
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }
}
