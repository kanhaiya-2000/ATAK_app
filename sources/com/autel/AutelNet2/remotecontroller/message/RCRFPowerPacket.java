package com.autel.AutelNet2.remotecontroller.message;

import com.autel.common.remotecontroller.RFPower;
import org.json.JSONArray;

public class RCRFPowerPacket extends RCMsgPacket {
    private boolean isSucc = false;
    private RFPower mAutelRFPower;

    public RCRFPowerPacket() {
        setType(8);
    }

    public void setRFPower(RFPower rFPower) {
        setType(7);
        this.mAutelRFPower = rFPower;
        addData(rFPower.getValue());
    }

    public boolean isRFPowerSetSucc() {
        return this.isSucc;
    }

    public RFPower getRFPower() {
        return this.mAutelRFPower;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (i == 7) {
            this.isSucc = isResultSucc(jSONArray);
        } else if (i == 8) {
            this.mAutelRFPower = jSONArray.getInt(0) == RFPower.FCC.getValue() ? RFPower.FCC : RFPower.CE;
        }
    }
}
