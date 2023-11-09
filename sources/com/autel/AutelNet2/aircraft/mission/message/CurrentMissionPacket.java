package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.mission.engine.CurrentMission;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class CurrentMissionPacket extends BaseMsgPacket {
    private CurrentMission currentMission;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public CurrentMissionPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public CurrentMission getCurrentMission() {
        return this.currentMission;
    }

    public BaseMsgPacket parseBody() {
        this.currentMission = (CurrentMission) this.messageParser.getObject(getBodyJson().getString("params"), CurrentMission.class);
        return this;
    }
}
