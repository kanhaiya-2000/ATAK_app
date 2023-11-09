package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.AutelNet2.utils.AutelMathUtils;
import com.autel.common.dsp.AppAction;
import com.autel.common.dsp.AppActionParam;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DspAppMsgPacket extends BaseMsgPacket {
    AppAction appAction;
    AppActionParam appActionParam;
    private JSONArray data;
    String uuid;

    public int getType() {
        return 43;
    }

    public DspAppMsgPacket(AppAction appAction2, AppActionParam appActionParam2) {
        JSONArray jSONArray = new JSONArray();
        this.data = jSONArray;
        this.appAction = appAction2;
        this.appActionParam = appActionParam2;
        jSONArray.put(appActionParam2.getValue());
    }

    public DspAppMsgPacket(MsgHead msgHead, byte[] bArr) {
        this.data = new JSONArray();
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 57;
        this.msg_head.msg_dst = 1;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", this.appAction.getValue());
            jSONObject.put("params", this.data);
            jSONObject.put("id", AutelMathUtils.getUUID());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public BaseMsgPacket parseBody() {
        AppInfo appInfo = (AppInfo) this.messageParser.getObject(getBodyString(), AppInfo.class);
        if (appInfo != null) {
            this.appAction = AppAction.find(appInfo.getAction());
            this.appActionParam = AppActionParam.find(appInfo.getParams()[0]);
            this.uuid = appInfo.getId();
        }
        return this;
    }

    public AppAction getAppAction() {
        return this.appAction;
    }

    public AppActionParam getAppActionParam() {
        return this.appActionParam;
    }

    public String getUuid() {
        return this.uuid;
    }
}
