package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.mission.engine.BreakPointFlyInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class BreakPointMissionPacket extends BaseMsgPacket {
    private BreakPointFlyInfo currentMission;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public BreakPointMissionPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BreakPointFlyInfo getBreakPointFlyInfo() {
        return this.currentMission;
    }

    public BaseMsgPacket parseBody() {
        this.currentMission = (BreakPointFlyInfo) this.messageParser.getObject(getBodyJson().getString("params"), BreakPointFlyInfo.class);
        return this;
    }
}
