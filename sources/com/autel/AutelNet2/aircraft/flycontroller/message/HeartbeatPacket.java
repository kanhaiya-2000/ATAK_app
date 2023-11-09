package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.flycontroller.parser.HeartBeatInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class HeartbeatPacket extends BaseMsgPacket {
    private HeartBeatInfo mHeartBeatInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public HeartbeatPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public HeartBeatInfo getHeartBeatInfo() {
        return this.mHeartBeatInfo;
    }

    public BaseMsgPacket parseBody() {
        this.mHeartBeatInfo = (HeartBeatInfo) this.messageParser.getObject(getBodyJson().optString("params"), HeartBeatInfo.class);
        return this;
    }
}
