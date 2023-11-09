package com.autel.AutelNet2.remotecontroller.message;

import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import org.json.JSONArray;

public class RCStickCalibratePacket extends RCMsgPacket {
    private RemoteControllerStickCalibration remoteControllerStickCalibration;

    public RCStickCalibratePacket() {
        setType(25);
    }

    public RemoteControllerStickCalibration getRemoteControllerStickCalibration() {
        return this.remoteControllerStickCalibration;
    }

    public void parseData(int i, JSONArray jSONArray) {
        if (i == 25) {
            this.remoteControllerStickCalibration = RemoteControllerStickCalibration.find(jSONArray.getInt(0));
        }
    }
}
