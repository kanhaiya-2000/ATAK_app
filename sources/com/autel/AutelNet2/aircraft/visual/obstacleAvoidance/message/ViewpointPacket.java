package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message;

import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.ViewpointInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class ViewpointPacket extends BaseMsgPacket {
    private ViewpointInfo viewpointInfo;

    public int getType() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public ViewpointPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public ViewpointInfo getViewpointInfo() {
        return this.viewpointInfo;
    }

    public BaseMsgPacket parseBody() {
        this.viewpointInfo = (ViewpointInfo) this.messageParser.getObject(getBodyJson().optString("params"), ViewpointInfo.class);
        return this;
    }
}
