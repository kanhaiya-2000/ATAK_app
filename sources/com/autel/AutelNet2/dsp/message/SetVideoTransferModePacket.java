package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.constant.MsgTypeConstant;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.bean.dsp.VideoTransferModeInfo;
import com.google.gson.Gson;
import java.lang.reflect.Type;

public class SetVideoTransferModePacket extends BaseMsgPacket {
    private String METHOD_SET_VIDEO_TRANSFER_MODE = MsgTypeConstant.TYPE_SET_VIDEO_TRANSFER_MODE;
    private boolean isSuccess;
    private RequestBean<VideoTransferModeInfo> requestBean;

    public int getType() {
        return 414894119;
    }

    public SetVideoTransferModePacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public SetVideoTransferModePacket(RequestBean<VideoTransferModeInfo> requestBean2) {
        this.requestBean = requestBean2;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_VIDEO_SET_TRANSF_MODE;
        this.msg_head.msg_dst = 2;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBean.setMethod(this.METHOD_SET_VIDEO_TRANSFER_MODE);
        Gson gson = this.messageParser.gsonParser;
        RequestBean<VideoTransferModeInfo> requestBean2 = this.requestBean;
        return gson.toJson((Object) requestBean2, (Type) requestBean2.getClass());
    }

    public BaseMsgPacket parseBody() {
        this.isSuccess = isResultSucc(getBodyJson());
        return this;
    }
}
