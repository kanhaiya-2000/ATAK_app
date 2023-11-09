package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.bean.dsp.SignalStrengthReport;

public class SignalStrengthPacket extends BaseMsgPacket {
    private SignalStrengthReport signalStrengthReprot;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public SignalStrengthPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public SignalStrengthReport getSignalStrengthReport() {
        return this.signalStrengthReprot;
    }

    public BaseMsgPacket parseBody() {
        this.signalStrengthReprot = (SignalStrengthReport) this.messageParser.getObject(getBodyJson().optString("params"), SignalStrengthReport.class);
        return this;
    }
}
