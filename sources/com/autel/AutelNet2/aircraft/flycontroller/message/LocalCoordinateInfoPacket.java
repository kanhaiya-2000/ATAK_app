package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.flycontroller.engine.LocalCoordinateInfoImpl;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class LocalCoordinateInfoPacket extends BaseMsgPacket {
    private LocalCoordinateInfoImpl mLocalCoordinateInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public LocalCoordinateInfoPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public LocalCoordinateInfoImpl getLocalCoordinateInfo() {
        return this.mLocalCoordinateInfo;
    }

    public BaseMsgPacket parseBody() {
        this.mLocalCoordinateInfo = (LocalCoordinateInfoImpl) this.messageParser.getObject(getBodyJson().getString("params"), LocalCoordinateInfoImpl.class);
        return this;
    }
}
