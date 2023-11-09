package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import org.json.JSONException;
import org.json.JSONObject;

public class SetFrepPacket extends BaseMsgPacket {
    private static final String METHOD = "IphoneSetFreq";
    private boolean isSucc = false;
    private int mFrep;

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_FREQ_SET_REQ;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", METHOD);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("SetFreqValue", this.mFrep);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void setFrep(int i) {
        this.mFrep = i;
    }

    public boolean isSetSucc() {
        return this.isSucc;
    }

    public BaseMsgPacket parseBody() {
        this.isSucc = isResultSucc(getBodyJson());
        return this;
    }
}
