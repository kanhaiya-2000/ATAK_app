package com.autel.AutelNet2.aircraft.base;

import android.text.TextUtils;
import com.autel.AutelNet2.aircraft.flycontroller.engine.ParamsAckInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.util.log.AutelLog;

public class ParamsAckPacket extends BaseMsgPacket {
    private String mName;
    private ParamsAckInfo paramsAckInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public ParamsAckPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public ParamsAckInfo getParamsAckInfo() {
        return this.paramsAckInfo;
    }

    public BaseMsgPacket parseBody() {
        AutelLog.debug_i("Params", "Command receiver " + getBodyString());
        ParamsAckInfo paramsAckInfo2 = (ParamsAckInfo) this.messageParser.getObject(getBodyJson().getString("params"), ParamsAckInfo.class);
        this.paramsAckInfo = paramsAckInfo2;
        this.mName = paramsAckInfo2.getParamId();
        return this;
    }

    public int getType() {
        if (TextUtils.isEmpty(this.mName)) {
            return 0;
        }
        return this.mName.hashCode();
    }
}
