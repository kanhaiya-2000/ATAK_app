package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message;

import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualHeartInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class VisualHeartPacket extends BaseMsgPacket {
    private VisualHeartInfo visualHeartInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public VisualHeartPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public VisualHeartInfo getVisualHeartInfo() {
        return this.visualHeartInfo;
    }

    public BaseMsgPacket parseBody() {
        this.visualHeartInfo = (VisualHeartInfo) this.messageParser.getObject(getBodyJson().optString("params"), VisualHeartInfo.class);
        return this;
    }
}
