package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;

public class SetZteRemoteLogPacket extends BaseMsgPacket {
    private boolean isOpenLog;
    private int status;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public SetZteRemoteLogPacket(boolean z) {
        this.isOpenLog = z;
    }

    public SetZteRemoteLogPacket(MsgHead msgHead, byte[] bArr, boolean z) {
        setHead(msgHead);
        setBody(bArr);
        this.isOpenLog = z;
    }

    public int getType() {
        return this.isOpenLog ? 53 : 54;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        if (this.isOpenLog) {
            this.msg_head.msg_type = 53;
        } else {
            this.msg_head.msg_type = 54;
        }
        this.msg_head.msg_dst = 1024;
    }

    public BaseMsgPacket parseBody() {
        this.status = getBodyJson().getInt(DownloadTask.STATUS);
        return this;
    }

    public int getStatus() {
        return this.status;
    }
}
