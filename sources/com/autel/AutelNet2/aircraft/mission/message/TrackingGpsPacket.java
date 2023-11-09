package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.GpsTargetInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class TrackingGpsPacket extends BaseMsgPacket {
    private RequestBean<GpsTargetInfo> requestBean;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public TrackingGpsPacket(GpsTargetInfo gpsTargetInfo) {
        this.requestBean = new RequestBean<>(gpsTargetInfo);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_GPS_TRACE_OBJECT_DATA;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("GPSTraceObjectData");
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }
}
