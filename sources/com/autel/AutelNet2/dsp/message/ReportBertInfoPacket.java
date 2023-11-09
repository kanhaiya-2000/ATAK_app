package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.bean.dsp.ReportBertInfo;

public class ReportBertInfoPacket extends BaseMsgPacket {
    private ReportBertInfo mReportBertInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public ReportBertInfoPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public ReportBertInfo getReportBertInfo() {
        return this.mReportBertInfo;
    }

    public BaseMsgPacket parseBody() {
        this.mReportBertInfo = (ReportBertInfo) this.messageParser.getObject(getBodyJson().getString("params"), ReportBertInfo.class);
        return this;
    }
}
