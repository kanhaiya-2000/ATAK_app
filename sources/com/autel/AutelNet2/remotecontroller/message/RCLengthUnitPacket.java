package com.autel.AutelNet2.remotecontroller.message;

import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import org.json.JSONArray;

public class RCLengthUnitPacket extends RCMsgPacket {
    private boolean isSucc = false;
    private RemoteControllerParameterUnit mAutelRCLengthUnit;

    public RCLengthUnitPacket() {
        setType(20);
    }

    public void setLengthUnit(RemoteControllerParameterUnit remoteControllerParameterUnit) {
        setType(17);
        this.mAutelRCLengthUnit = remoteControllerParameterUnit;
        addData(remoteControllerParameterUnit.getValue());
    }

    public RemoteControllerParameterUnit getRCLengthUnit() {
        return this.mAutelRCLengthUnit;
    }

    public boolean isSetUnitSucc() {
        return this.isSucc;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (i == 17) {
            this.isSucc = isResultSucc(jSONArray);
        } else if (i == 20 && jSONArray != null && jSONArray.length() > 0) {
            this.mAutelRCLengthUnit = RemoteControllerParameterUnit.find(((Integer) jSONArray.get(0)).intValue());
        }
    }
}
