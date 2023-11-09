package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.bean.dsp.VideoRateInfoImpl;

public class VideoRateInfoPacket extends BaseMsgPacket {
    private VideoRateInfoImpl mVideoRateInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public VideoRateInfoPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public VideoRateInfoImpl getVideoRateInfo() {
        return this.mVideoRateInfo;
    }

    public BaseMsgPacket parseBody() {
        this.mVideoRateInfo = (VideoRateInfoImpl) this.messageParser.getObject(getBodyJson().getString("params"), VideoRateInfoImpl.class);
        return this;
    }
}
