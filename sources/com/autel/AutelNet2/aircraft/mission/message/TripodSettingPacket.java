package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.TripodInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;

public class TripodSettingPacket extends BaseMsgPacket {
    private RequestBean<TripodInfo> requestBean;
    private int status;

    public TripodSettingPacket(TripodInfo tripodInfo) {
        this.requestBean = new RequestBean<>(tripodInfo);
    }

    public TripodSettingPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_SET_TRIPOD_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("TripodInfo");
        return this.messageParser.gsonParser.toJson((Object) this.requestBean);
    }

    public BaseMsgPacket parseBody() {
        this.status = getBodyJson().optInt(DownloadTask.STATUS);
        return this;
    }

    public int getStatus() {
        return this.status;
    }
}
