package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.mission.engine.HotPointInfoInternal;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class CurrentHotPointPacket extends BaseMsgPacket {
    private HotPointInfoInternal mHotPointInfoInternal;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public CurrentHotPointPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public HotPointInfoInternal getHotPointInfoInternal() {
        return this.mHotPointInfoInternal;
    }

    public BaseMsgPacket parseBody() {
        this.mHotPointInfoInternal = (HotPointInfoInternal) this.messageParser.getObject(getBodyJson().getString("params"), HotPointInfoInternal.class);
        return this;
    }
}
