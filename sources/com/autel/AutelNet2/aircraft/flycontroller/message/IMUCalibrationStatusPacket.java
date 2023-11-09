package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.flycontroller.engine.ImuCalibrationStateInfo;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class IMUCalibrationStatusPacket extends BaseMsgPacket {
    private ImuCalibrationStateInfo imuCalibrationStateInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public IMUCalibrationStatusPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        this.imuCalibrationStateInfo = (ImuCalibrationStateInfo) this.messageParser.getObject(getBodyJson().getString("params"), ImuCalibrationStateInfo.class);
        return this;
    }

    public ImuCalibrationStateInfo getImuCalibrationStateInfo() {
        return this.imuCalibrationStateInfo;
    }
}
