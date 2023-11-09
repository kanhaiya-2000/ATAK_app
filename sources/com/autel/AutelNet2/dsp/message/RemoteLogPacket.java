package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.util.log.AutelLog;

public class RemoteLogPacket extends BaseMsgPacket {
    private String data;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public RemoteLogPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        this.data = new String(getBody(), 0, this.msg_head.length - 16);
        AutelLog.debug_i("NWP_DDL", getBody().length + "" + this.data);
        return this;
    }

    public String getData() {
        return this.data;
    }
}
