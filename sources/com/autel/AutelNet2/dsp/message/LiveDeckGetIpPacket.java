package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class LiveDeckGetIpPacket extends BaseMsgPacket {

    /* renamed from: ip */
    private String f8438ip;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public LiveDeckGetIpPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 74;
        this.msg_head.msg_dst = 1024;
    }

    public BaseMsgPacket parseBody() {
        this.f8438ip = getBodyJson().getString("IP");
        return null;
    }

    public String getIp() {
        return this.f8438ip;
    }
}
