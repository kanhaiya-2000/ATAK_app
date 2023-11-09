package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.flycontroller.engine.RtkIntenal;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class RtkInfoReportPacket extends BaseMsgPacket {
    private RtkIntenal rtkIntenal;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public RtkInfoReportPacket() {
    }

    public RtkInfoReportPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_RTK_DATA;
        this.msg_head.msg_dst = 8;
    }

    public BaseMsgPacket parseBody() {
        this.rtkIntenal = (RtkIntenal) this.messageParser.getObject(getBodyJson().getString("params"), RtkIntenal.class);
        return this;
    }

    public RtkIntenal getRtkIntenal() {
        return this.rtkIntenal;
    }
}
