package com.autel.AutelNet2.aircraft.camera.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class CameraStatusPacket extends BaseMsgPacket {
    private String response;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public CameraStatusPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        this.response = getBodyJson().toString();
        return this;
    }

    public String getResponse() {
        return this.response;
    }
}
