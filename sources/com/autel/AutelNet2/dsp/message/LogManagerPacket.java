package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;
import org.json.JSONException;
import org.json.JSONObject;

public class LogManagerPacket extends BaseMsgPacket {
    private int log;
    private int status;
    private int zteLog;

    public LogManagerPacket(int i, int i2) {
        this.log = i;
        this.zteLog = i2;
    }

    public LogManagerPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 4;
        this.msg_head.msg_dst = MsgType.AU_BUTTON_PHOTO_RECORD_RESP;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "LogManage");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("log", this.log);
            jSONObject2.put("ztelog", this.zteLog);
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
