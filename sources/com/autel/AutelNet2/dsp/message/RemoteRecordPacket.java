package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.bean.dsp.RecordGpsInfo;

public class RemoteRecordPacket extends BaseMsgPacket {
    private RecordGpsInfo data;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public RemoteRecordPacket() {
    }

    public RemoteRecordPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 72;
        this.msg_head.msg_dst = 1024;
    }

    public BaseMsgPacket parseBody() {
        this.data = (RecordGpsInfo) this.messageParser.getObject(getBodyJson().getString("params"), RecordGpsInfo.class);
        return this;
    }

    public RecordGpsInfo getRecordGpsInfo() {
        return this.data;
    }
}
