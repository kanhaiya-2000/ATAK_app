package com.autel.AutelNet2.aircraft.firmware.message;

import com.autel.AutelNet2.aircraft.firmware.bean.DeviceStatusInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class DeviceInfoStatusPacket extends BaseMsgPacket {
    private DeviceStatusInfo deviceStatusInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public DeviceInfoStatusPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public DeviceStatusInfo getDeviceStatusInfo() {
        return this.deviceStatusInfo;
    }

    public BaseMsgPacket parseBody() {
        this.deviceStatusInfo = (DeviceStatusInfo) this.messageParser.getObject(getBodyJson().getString("params"), DeviceStatusInfo.class);
        return this;
    }
}
