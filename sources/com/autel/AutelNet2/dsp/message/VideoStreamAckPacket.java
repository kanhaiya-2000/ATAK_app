package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;

public class VideoStreamAckPacket extends BaseMsgPacket {
    private boolean isOpen;
    private boolean isSuccess;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public VideoStreamAckPacket(boolean z, MsgHead msgHead, byte[] bArr) {
        this.isOpen = z;
        setHead(msgHead);
        setBody(bArr);
    }

    public int getType() {
        return this.isOpen ? 14051107 : -175234543;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public BaseMsgPacket parseBody() {
        boolean z = true;
        if (getBodyJson().getInt(DownloadTask.STATUS) != 1) {
            z = false;
        }
        this.isSuccess = z;
        return this;
    }
}
