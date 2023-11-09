package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.flycontroller.engine.AttitudeInfoInternal;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class AttitudePacket extends BaseMsgPacket {
    private AttitudeInfoInternal attitudeInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public AttitudePacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public AttitudeInfoInternal getAttitudeInfo() {
        return this.attitudeInfo;
    }

    public BaseMsgPacket parseBody() {
        this.attitudeInfo = (AttitudeInfoInternal) this.messageParser.getObject(getBodyJson().getString("params"), AttitudeInfoInternal.class);
        return this;
    }
}
