package com.autel.AutelNet2.aircraft.firmware.message;

import com.autel.AutelNet2.aircraft.firmware.bean.FirmwareDeviceInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;

public class FirmwarePacket extends BaseMsgPacket {
    private FirmwareDeviceInfo firmwareDeviceInfo;

    public int getType() {
        return -1104535791;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public FirmwarePacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public FirmwarePacket() {
    }

    public FirmwareDeviceInfo getFirmwareDeviceInfo() {
        return this.firmwareDeviceInfo;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_UPGRADE_DEVICE_INFO_REQ;
        this.msg_head.msg_dst = MsgType.AU_BUTTON_SET_PARAS_RESP;
    }

    public BaseMsgPacket parseBody() {
        AutelLog.debug_i(AutelLogTags.TAG_FIRMWARE, "receiver FirmwareDeviceInfo success");
        this.firmwareDeviceInfo = (FirmwareDeviceInfo) this.messageParser.getObject(getBodyJson().getString("params"), FirmwareDeviceInfo.class);
        return this;
    }
}
