package com.autel.AutelNet2.aircraft.base;

import android.text.TextUtils;
import com.autel.AutelNet2.aircraft.engine.ParamsInfo;
import com.autel.AutelNet2.constant.FmuCmdConstant;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.google.gson.Gson;
import java.lang.reflect.Type;

public class ParamsSetPacket extends BaseMsgPacket {
    private String broadName = "";
    private RequestBean requestBean;

    public BaseMsgPacket parseBody() {
        return this;
    }

    public void setRequestBean(RequestBean requestBean2) {
        this.requestBean = requestBean2;
    }

    public ParamsSetPacket(RequestBean requestBean2) {
        setRequestBean(requestBean2);
        this.broadName = ((ParamsInfo) requestBean2.getParams()).getParamId();
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_PARAM_SET;
        this.msg_head.msg_dst = 8;
    }

    public String loadBody() {
        this.requestBean.setMethod(FmuCmdConstant.METHOD_FMU_PARAM_SET);
        Gson gson = this.messageParser.gsonParser;
        RequestBean requestBean2 = this.requestBean;
        return gson.toJson((Object) requestBean2, (Type) requestBean2.getClass());
    }

    public int getType() {
        if (TextUtils.isEmpty(this.broadName)) {
            return 0;
        }
        return this.broadName.hashCode();
    }
}
