package com.autel.libupdrage.upgrade.message;

import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.util.log.AutelLog;

public class UpgradePacket extends BaseMsgPacket {
    private long fileSize;
    private String fineName;
    private String jsonHeadStr;
    private long totalSize;

    public int getType() {
        return 28558246;
    }

    public BaseMsgPacket parseBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = 770;
        this.msg_head.msg_dst = 1024;
    }

    public UpgradePacket(String str) {
        this.jsonHeadStr = str;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        String str = "{\"method\":\"start_upgrade\",\"enpoint\":\"android\",\"params\":" + this.jsonHeadStr + "}";
        AutelLog.m15083e("CYK:UpgradePacket:loadBody  : " + str);
        return str;
    }
}
