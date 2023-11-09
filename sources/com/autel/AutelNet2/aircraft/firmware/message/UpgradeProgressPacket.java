package com.autel.AutelNet2.aircraft.firmware.message;

import com.autel.AutelNet2.aircraft.firmware.bean.UpgradeStatus;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class UpgradeProgressPacket extends BaseMsgPacket {
    private UpgradeStatus upgradeStatus;

    public int getType() {
        return 28558246;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public UpgradeProgressPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        this.upgradeStatus = (UpgradeStatus) this.messageParser.getObject(getBodyJson().getString("params"), UpgradeStatus.class);
        return this;
    }

    public UpgradeStatus getUpgradeStatus() {
        return this.upgradeStatus;
    }
}
