package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.bean.dsp.VideoTransferModeInfo;

public class VideoTransferModePacket extends BaseMsgPacket {
    private VideoTransferModeInfo videoTransfMode;

    public int getType() {
        return 1025817523;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public VideoTransferModePacket() {
    }

    public VideoTransferModePacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public VideoTransferModeInfo getVideoTransfMode() {
        return this.videoTransfMode;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_VIDEO_GET_TRANSF_MODE;
        this.msg_head.msg_dst = 2;
    }

    public BaseMsgPacket parseBody() {
        this.videoTransfMode = (VideoTransferModeInfo) this.messageParser.getObject(getBodyJson().getString("result"), VideoTransferModeInfo.class);
        return this;
    }
}
