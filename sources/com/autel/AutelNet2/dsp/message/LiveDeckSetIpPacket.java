package com.autel.AutelNet2.dsp.message;

import android.text.TextUtils;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveDeckSetIpPacket extends BaseMsgPacket {
    private static final String METHOD = "SetLiveDeckIpInfo";

    /* renamed from: ip */
    private String f8439ip;

    public BaseMsgPacket parseBody() {
        return null;
    }

    public LiveDeckSetIpPacket(String str) {
        this.f8439ip = str;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 73;
        this.msg_head.msg_dst = 1024;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f8439ip)) {
                jSONObject.put("method", METHOD);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("IP", this.f8439ip);
                jSONObject.put("params", jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
