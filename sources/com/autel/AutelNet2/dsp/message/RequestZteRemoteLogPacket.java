package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class RequestZteRemoteLogPacket extends BaseMsgPacket {
    private byte[] bytes;

    public int getType() {
        return 1926743752;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public RequestZteRemoteLogPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        this.bytes = getMsgBody();
        return this;
    }

    public byte[] getData() {
        return this.bytes;
    }
}
