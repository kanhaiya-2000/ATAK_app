package com.autel.AutelNet2.remotecontroller.message;

import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import org.json.JSONArray;

public class RCCalibrationPacket extends RCMsgPacket {
    private RemoteControllerStickCalibration mAutelRCStickCalibration;

    public RCCalibrationPacket() {
        setType(13);
    }

    public void setStep(RemoteControllerStickCalibration remoteControllerStickCalibration) {
        this.mAutelRCStickCalibration = remoteControllerStickCalibration;
        addData(remoteControllerStickCalibration.getValue());
    }

    public RemoteControllerStickCalibration getResultData() {
        return this.mAutelRCStickCalibration;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.mAutelRCStickCalibration = RemoteControllerStickCalibration.find(jSONArray.getInt(0));
        }
    }
}
