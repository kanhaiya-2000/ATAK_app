package com.autel.AutelNet2.remotecontroller.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;
import org.json.JSONException;
import org.json.JSONObject;

public class RcSetCustomKeyPacket extends BaseMsgPacket {
    private String customKey;
    private int keyFunction;
    private int status;

    public RcSetCustomKeyPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public RcSetCustomKeyPacket() {
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_CUSTOM_BUTTON_SET_FUNC;
        this.msg_head.msg_dst = 1024;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "SetCustomKey");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", this.customKey);
            jSONObject2.put("func", this.keyFunction);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public BaseMsgPacket parseBody() {
        this.status = getBodyJson().getInt(DownloadTask.STATUS);
        return this;
    }

    public boolean isSuc() {
        return this.status == 0;
    }

    public void setCustomKey(String str) {
        this.customKey = str;
    }

    public void setCustomFunction(int i) {
        this.keyFunction = i;
    }
}
