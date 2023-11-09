package com.autel.AutelNet2.dsp.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;

public class VideoStreamPacket extends BaseMsgPacket {
    private boolean isOpenVideoStream;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public BaseMsgPacket parseBody() {
        return null;
    }

    public VideoStreamPacket(boolean z) {
        this.isOpenVideoStream = z;
    }

    public int getType() {
        return this.isOpenVideoStream ? 14051107 : -175234543;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        if (this.isOpenVideoStream) {
            this.msg_head.msg_type = 512;
        } else {
            this.msg_head.msg_type = MsgType.AU_VIDEO_STOP;
        }
        this.msg_head.msg_dst = 2;
    }
}
