package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.flycontroller.parser.GPSInfoInternal;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class GPSInfoPacket extends BaseMsgPacket {
    private GPSInfoInternal mGPSInfoInternalParser2;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public GPSInfoPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public GPSInfoInternal getGPSInfo() {
        return this.mGPSInfoInternalParser2;
    }

    public BaseMsgPacket parseBody() {
        this.mGPSInfoInternalParser2 = (GPSInfoInternal) this.messageParser.getObject(getBodyJson().getString("params"), GPSInfoInternal.class);
        return this;
    }
}
