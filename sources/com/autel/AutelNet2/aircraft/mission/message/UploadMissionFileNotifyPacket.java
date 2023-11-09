package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.mission.engine.TransferNotifyInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.util.log.AutelLog;

public class UploadMissionFileNotifyPacket extends BaseMsgPacket {
    private TransferNotifyInfo notifyInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public UploadMissionFileNotifyPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        this.notifyInfo = (TransferNotifyInfo) this.messageParser.gsonParser.fromJson(getBodyString(), TransferNotifyInfo.class);
        AutelLog.m15081d("receiver data:" + this.notifyInfo.getPercent() + " status:" + this.notifyInfo.getStatus());
        return this;
    }

    public TransferNotifyInfo getTransferNotifyInfo() {
        return this.notifyInfo;
    }
}
