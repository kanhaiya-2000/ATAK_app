package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.mission.engine.FollowMeInfoInternal;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class CurrentFollowMePacket extends BaseMsgPacket {
    private FollowMeInfoInternal mFollowMeInfoInternal;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public CurrentFollowMePacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public FollowMeInfoInternal getFollowMeInfoInternal() {
        return this.mFollowMeInfoInternal;
    }

    public BaseMsgPacket parseBody() {
        this.mFollowMeInfoInternal = (FollowMeInfoInternal) this.messageParser.getObject(getBodyJson().getString("params"), FollowMeInfoInternal.class);
        return this;
    }
}
