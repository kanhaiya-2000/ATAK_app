package com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.version;

import com.autel.downloader.bean.DownloadTask;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmVersionManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmWareIpConst;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.base.Version;
import org.json.JSONException;
import org.json.JSONObject;

public class AircraftComponentSNVersion extends Version {
    private static final int RequestId = 2;
    private static AircraftComponentSNVersion instance_;

    public String getMethodName() {
        return "GetModulesSerialNum";
    }

    public static AircraftComponentSNVersion getInstance_() {
        if (instance_ == null) {
            instance_ = new AircraftComponentSNVersion();
        }
        return instance_;
    }

    private AircraftComponentSNVersion() {
        setRequestId(2);
    }

    public String getSocketIp() {
        return AutelFirmWareIpConst.getFirmVersionAircraftComponentSocketAddr();
    }

    public int getSocketPort() {
        return AutelFirmWareIpConst.FIRMVERSION_SOCKET_HOST_AIRCRAFT_PORT;
    }

    public void jsonParser(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt(DownloadTask.STATUS) == 0) {
                int i = jSONObject.getInt("id");
                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                if (i == getRequestId()) {
                    AutelFirmVersionManager.getInstence().getAircraftComponentSNVersionInfoInternal().setJson(str);
                    AutelFirmVersionManager.getInstence().getAircraftComponentSNVersionInfoInternal().setFMU(jSONObject2.optString("FMU"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentSNVersionInfoInternal().setBattery(jSONObject2.optString("Battery"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentSNVersionInfoInternal().setGimbal(jSONObject2.optString("Gimbal"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
