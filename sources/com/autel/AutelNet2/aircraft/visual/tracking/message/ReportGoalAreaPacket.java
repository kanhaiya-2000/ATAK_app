package com.autel.AutelNet2.aircraft.visual.tracking.message;

import com.autel.AutelNet2.aircraft.visual.tracking.entity.ReportGoalArea;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class ReportGoalAreaPacket extends BaseMsgPacket {
    private ReportGoalArea uploadGoalArea;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public ReportGoalAreaPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        ReportGoalArea reportGoalArea = (ReportGoalArea) this.messageParser.getObject(getBodyString(), ReportGoalArea.class);
        this.uploadGoalArea = reportGoalArea;
        reportGoalArea.setId(getBodyJson().getInt("id"));
        return this;
    }

    public ReportGoalArea getReportGoalArea() {
        return this.uploadGoalArea;
    }
}
