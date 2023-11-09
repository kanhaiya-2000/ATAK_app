package com.autel.AutelNet2.aircraft.visual.tracking.message;

import com.autel.AutelNet2.aircraft.visual.tracking.entity.ReportOrbitInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class OrbitStatusPacket extends BaseMsgPacket {
    private ReportOrbitInfo reportOrbitInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public OrbitStatusPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        this.reportOrbitInfo = (ReportOrbitInfo) this.messageParser.getObject(getBodyJson().getString("params"), ReportOrbitInfo.class);
        return this;
    }

    public ReportOrbitInfo getReportOrbitInfo() {
        return this.reportOrbitInfo;
    }
}
