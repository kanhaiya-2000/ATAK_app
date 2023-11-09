package com.autel.AutelNet2.dsp.message;

import android.text.TextUtils;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.bean.dsp.BandModeWidthInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class BandModeWidthInfoPacket extends BaseMsgPacket {
    private String METHOD_SET_BAND_MODE_WIDTH_INFO = "SetBandModeWidthInfo";
    private BandModeWidthInfo modeWidthInfo;

    public BandModeWidthInfoPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BandModeWidthInfoPacket(BandModeWidthInfo bandModeWidthInfo) {
        this.modeWidthInfo = bandModeWidthInfo;
    }

    public BandModeWidthInfo getModeWidthInfo() {
        return this.modeWidthInfo;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_TRANS_SET_PARAS_REQ;
        this.msg_head.msg_dst = 1024;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", this.METHOD_SET_BAND_MODE_WIDTH_INFO);
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.modeWidthInfo.getBandMode())) {
                jSONObject2.put("BandMode", this.modeWidthInfo.getBandMode());
            }
            if (!TextUtils.isEmpty(this.modeWidthInfo.getBandWidth())) {
                jSONObject2.put("BandWidth", this.modeWidthInfo.getBandWidth());
            }
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public BaseMsgPacket parseBody() {
        this.modeWidthInfo = (BandModeWidthInfo) this.messageParser.getObject(getBodyJson().getString("params"), BandModeWidthInfo.class);
        return this;
    }
}
