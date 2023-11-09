package com.autel.AutelNet2.aircraft.firmware.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;

public class UpgradeStartRespPacket extends BaseMsgPacket {
    private int startStatus;

    public int getType() {
        return 28558246;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public UpgradeStartRespPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        this.startStatus = getBodyJson().getInt(DownloadTask.STATUS);
        return this;
    }

    public int getStartStatus() {
        return this.startStatus;
    }
}
