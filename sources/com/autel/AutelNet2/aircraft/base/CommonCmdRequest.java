package com.autel.AutelNet2.aircraft.base;

import com.autel.AutelNet2.aircraft.flycontroller.util.TransformUtils;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.google.gson.Gson;
import java.lang.reflect.Type;

public class CommonCmdRequest extends BaseMsgPacket {
    private RequestCmdBean requestCmdBean;

    public BaseMsgPacket parseBody() {
        return this;
    }

    public void setRequestCmdBean(RequestCmdBean requestCmdBean2) {
        this.requestCmdBean = requestCmdBean2;
        int i = TransformUtils.msgId + 1;
        TransformUtils.msgId = i;
        requestCmdBean2.setId(i);
    }

    public CommonCmdRequest(RequestCmdBean requestCmdBean2) {
        setRequestCmdBean(requestCmdBean2);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_COMMAND;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestCmdBean.setMethod("COMMON_COMMAND");
        Gson gson = this.messageParser.gsonParser;
        RequestCmdBean requestCmdBean2 = this.requestCmdBean;
        return gson.toJson((Object) requestCmdBean2, (Type) requestCmdBean2.getClass());
    }

    public int getType() {
        return this.requestCmdBean.getCommand().hashCode();
    }
}
