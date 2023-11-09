package com.autel.AutelNet2.aircraft.gimbal.message;

import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalAngleRangeImpl;
import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalCmdType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class GimbalAngleRangeAckPacket extends BaseMsgPacket {
    private GimbalAngleRangeImpl gimbalAngleRange;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public GimbalAngleRangeAckPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public int getType() {
        return GimbalCmdType.RANGE.getValue();
    }

    public GimbalAngleRangeImpl getGimbalAngleRange() {
        return this.gimbalAngleRange;
    }

    public BaseMsgPacket parseBody() {
        this.gimbalAngleRange = (GimbalAngleRangeImpl) this.messageParser.getObject(getBodyJson().getString("params"), GimbalAngleRangeImpl.class);
        return this;
    }
}
