package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.MotionDelayInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;

public class MotionDelaySettingPacket extends BaseMsgPacket {
    private RequestBean<MotionDelayInfo> requestBean;
    private int status;

    public MotionDelaySettingPacket(MotionDelayInfo motionDelayInfo) {
        this.requestBean = new RequestBean<>(motionDelayInfo);
    }

    public MotionDelaySettingPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_SET_MOTION_DELAY_INFO;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod("TimelapsePhotoSetting");
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
