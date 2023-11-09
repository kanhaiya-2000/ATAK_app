package com.autel.AutelNet2.aircraft.battery.message;

import com.autel.AutelNet2.aircraft.battery.engine.BatteryInfoInternal;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class BatteryStatusPacket extends BaseMsgPacket {
    private BatteryInfoInternal mBatteryInfoInternal;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public BatteryStatusPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BatteryInfoInternal getBatteryInfoInternal() {
        return this.mBatteryInfoInternal;
    }

    public BaseMsgPacket parseBody() {
        BatteryInfoInternal batteryInfoInternal = (BatteryInfoInternal) this.messageParser.getObject(getBodyJson().getString("params"), BatteryInfoInternal.class);
        this.mBatteryInfoInternal = batteryInfoInternal;
        BatteryInfoInternal.setBatteryInfoInternal(batteryInfoInternal);
        return this;
    }
}
