package com.autel.AutelNet2.aircraft.gimbal.message;

import com.autel.AutelNet2.aircraft.gimbal.engine.GimbalCmdInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.util.log.AutelLog;

public class GimbalCmdAckPacket extends BaseMsgPacket {
    private GimbalCmdInfo gimbalCmdInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public GimbalCmdAckPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public GimbalCmdInfo getGimbalCmdInfo() {
        return this.gimbalCmdInfo;
    }

    public int getType() {
        return this.gimbalCmdInfo.getAck();
    }

    public BaseMsgPacket parseBody() {
        AutelLog.debug_i("Gimbal", "Command receiver " + getBodyString());
        this.gimbalCmdInfo = (GimbalCmdInfo) this.messageParser.getObject(getBodyJson().getString("params"), GimbalCmdInfo.class);
        return this;
    }
}
