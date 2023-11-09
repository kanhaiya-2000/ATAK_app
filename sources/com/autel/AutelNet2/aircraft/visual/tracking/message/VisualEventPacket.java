package com.autel.AutelNet2.aircraft.visual.tracking.message;

import com.autel.AutelNet2.aircraft.visual.tracking.entity.VisualWarningInfoImpl;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class VisualEventPacket extends BaseMsgPacket {
    private VisualWarningInfoImpl mVisualWarningInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public VisualEventPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public VisualWarningInfoImpl getVisualWarningInfo() {
        return this.mVisualWarningInfo;
    }

    public BaseMsgPacket parseBody() {
        this.mVisualWarningInfo = (VisualWarningInfoImpl) this.messageParser.getObject(getBodyJson().getString("params"), VisualWarningInfoImpl.class);
        return this;
    }
}
