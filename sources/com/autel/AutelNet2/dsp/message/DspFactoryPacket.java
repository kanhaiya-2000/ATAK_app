package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;
import org.json.JSONException;
import org.json.JSONObject;

public class DspFactoryPacket extends BaseMsgPacket {
    private int modeId;
    private int status = -1;

    public int getType() {
        return 43;
    }

    public DspFactoryPacket(int i) {
        this.modeId = i;
    }

    public DspFactoryPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 42;
        this.msg_head.msg_dst = 1024;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "FactoryReset");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ComponentID", this.modeId);
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

    public int getStatus() {
        return this.status;
    }
}
