package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalAngle;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class GimbalPryAnglePacket extends BaseMsgPacket {
    private GimbalAngle gimbalAngle;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public GimbalPryAnglePacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public GimbalAngle getGimbalAngle() {
        return this.gimbalAngle;
    }

    public BaseMsgPacket parseBody() {
        this.gimbalAngle = (GimbalAngle) this.messageParser.getObject(getBodyJson().getString("params"), GimbalAngle.class);
        return this;
    }
}
