package com.autel.AutelNet2.remotecontroller.message;

import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import org.json.JSONArray;

public class RCCommandStickModePacket extends RCMsgPacket {
    private boolean isSucc = false;
    private RemoteControllerCommandStickMode mMode;

    public RCCommandStickModePacket() {
        setType(19);
    }

    public void setCommandStickMode(RemoteControllerCommandStickMode remoteControllerCommandStickMode) {
        setType(18);
        this.mMode = remoteControllerCommandStickMode;
        addData(remoteControllerCommandStickMode.getValue());
    }

    public RemoteControllerCommandStickMode getMode() {
        return this.mMode;
    }

    public boolean isSetModeSucc() {
        return this.isSucc;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (i == 18) {
            this.isSucc = isResultSucc(jSONArray);
        } else if (i == 19 && jSONArray != null && jSONArray.length() > 0) {
            int i2 = jSONArray.getInt(0);
            if (i2 == RemoteControllerCommandStickMode.CHINA.getValue()) {
                this.mMode = RemoteControllerCommandStickMode.CHINA;
            } else if (i2 == RemoteControllerCommandStickMode.USA.getValue()) {
                this.mMode = RemoteControllerCommandStickMode.USA;
            } else if (i2 == RemoteControllerCommandStickMode.JAPAN.getValue()) {
                this.mMode = RemoteControllerCommandStickMode.JAPAN;
            }
        }
    }
}
