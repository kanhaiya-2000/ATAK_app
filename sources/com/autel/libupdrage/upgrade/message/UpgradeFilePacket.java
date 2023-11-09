package com.autel.libupdrage.upgrade.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import java.io.FileInputStream;

public class UpgradeFilePacket extends BaseMsgPacket {
    private FileInputStream fileInputStream;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public BaseMsgPacket parseBody() {
        return null;
    }

    public UpgradeFilePacket(FileInputStream fileInputStream2) {
        this.fileInputStream = fileInputStream2;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_UPGRADE_DOWNLOAD_DATA;
        this.msg_head.msg_dst = 1024;
    }

    public FileInputStream loadFileInputStream() {
        return this.fileInputStream;
    }
}
