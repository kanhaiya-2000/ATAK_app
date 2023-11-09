package com.autel.AutelNet2.aircraft.visual.tracking.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;

public class TrackingCmdPacket extends BaseMsgPacket {
    private String jsonData;
    private short msg_type;
    private int status;

    public TrackingCmdPacket(String str, short s) {
        this.jsonData = str;
        this.msg_type = s;
    }

    public TrackingCmdPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = this.msg_type;
        this.msg_head.msg_dst = 2;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return this.jsonData;
    }

    public BaseMsgPacket parseBody() {
        this.status = getBodyJson().getInt(DownloadTask.STATUS);
        return this;
    }

    public int getResult() {
        return this.status;
    }
}
