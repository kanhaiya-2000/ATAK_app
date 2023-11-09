package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.flycontroller.engine.ImuStateInfoImpl;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import org.json.JSONObject;

public class IMUStatusPacket extends BaseMsgPacket {
    private ImuStateInfoImpl mImuStatusInfo;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public IMUStatusPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public ImuStateInfoImpl getImuStatusInfo() {
        return this.mImuStatusInfo;
    }

    public BaseMsgPacket parseBody() {
        JSONObject bodyJson = getBodyJson();
        this.mImuStatusInfo = new ImuStateInfoImpl();
        this.mImuStatusInfo = (ImuStateInfoImpl) this.messageParser.getObject(bodyJson.getString("params"), ImuStateInfoImpl.class);
        return this;
    }
}
