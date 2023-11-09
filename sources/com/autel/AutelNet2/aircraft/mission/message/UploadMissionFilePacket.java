package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import java.io.FileInputStream;

public class UploadMissionFilePacket extends BaseMsgPacket {
    private FileInputStream fileInputStream;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public BaseMsgPacket parseBody() {
        return null;
    }

    public UploadMissionFilePacket(FileInputStream fileInputStream2) {
        this.fileInputStream = fileInputStream2;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_TRANSFER_FILE_DATA;
        this.msg_head.msg_dst = 8;
    }

    public FileInputStream loadFileInputStream() {
        return this.fileInputStream;
    }
}
