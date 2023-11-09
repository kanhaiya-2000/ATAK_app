package com.autel.AutelNet2.remotecontroller.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.AutelNet2.remotecontroller.engine.CustomKeyInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class RcGetCustomKeyPacket extends BaseMsgPacket {
    private CustomKeyInfo customKeyInfo;

    /* renamed from: id */
    private int f8440id;

    public RcGetCustomKeyPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public RcGetCustomKeyPacket() {
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_CUSTOM_BUTTON_GET_FUNC;
        this.msg_head.msg_dst = 1024;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "GetCustomKey");
            int i = this.f8440id;
            this.f8440id = i + 1;
            jSONObject.put("deviceId", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public BaseMsgPacket parseBody() {
        this.customKeyInfo = (CustomKeyInfo) this.messageParser.getObject(getBodyString(), CustomKeyInfo.class);
        return this;
    }

    public CustomKeyInfo getCustomKeyInfo() {
        return this.customKeyInfo;
    }
}
