package com.autel.AutelNet2.aircraft.firmware.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import org.json.JSONObject;

public class UpgradeNotifyPacket extends BaseMsgPacket {
    int seekPosition;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public UpgradeNotifyPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        JSONObject jSONObject = getBodyJson().getJSONObject("result");
        if (jSONObject != null) {
            this.seekPosition = jSONObject.getInt("SeekPosition");
        }
        return this;
    }

    public int getSeekPosition() {
        return this.seekPosition;
    }
}
