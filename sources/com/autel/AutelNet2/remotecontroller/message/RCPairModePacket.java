package com.autel.AutelNet2.remotecontroller.message;

import com.autel.common.remotecontroller.RemoteControllerPairState;
import org.json.JSONArray;

public class RCPairModePacket extends RCMsgPacket {
    private boolean isSucc = false;
    private RemoteControllerPairState mPairMode;

    public RCPairModePacket() {
        setType(6);
    }

    public void setRCBind(boolean z) {
        if (z) {
            setType(5);
        }
    }

    public boolean isRCBindSucc() {
        return this.isSucc;
    }

    public RemoteControllerPairState getPairMode() {
        return this.mPairMode;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (i == 5) {
            this.isSucc = isResultSucc(jSONArray);
        } else if (i == 6) {
            this.mPairMode = RemoteControllerPairState.find(jSONArray.getInt(0));
        }
    }
}
