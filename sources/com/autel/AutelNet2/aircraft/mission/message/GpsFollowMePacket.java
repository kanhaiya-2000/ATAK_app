package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.GpsFollowMeInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class GpsFollowMePacket extends BaseMsgPacket {
    private RequestBean<GpsFollowMeInfo> requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public GpsFollowMePacket(GpsFollowMeInfo gpsFollowMeInfo) {
        this.requestBean = new RequestBean<>(gpsFollowMeInfo);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_GPS_TRACE_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("GPSTraceInfoSetting");
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }
}
