package com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.version;

import com.autel.downloader.bean.DownloadTask;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmVersionManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmWareIpConst;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.base.Version;
import org.json.JSONException;
import org.json.JSONObject;

public class AircraftComponentVersion extends Version {
    private static AircraftComponentVersion instance_;
    private final int RequestId = 1;

    public String getMethodName() {
        return "GetModulesVersion";
    }

    public static AircraftComponentVersion getInstance_() {
        if (instance_ == null) {
            instance_ = new AircraftComponentVersion();
        }
        return instance_;
    }

    private AircraftComponentVersion() {
        setRequestId(1);
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
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setJson(str);
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setDSP(jSONObject2.optString("DSP"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setFmu(jSONObject2.optString("FMU"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setBattery(jSONObject2.optString("Battery"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setCamera(jSONObject2.optString("Camera"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setLensVersion(jSONObject2.optString("Lens"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setRouter(jSONObject2.optString("Router"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setGimbal(jSONObject2.optString("Gimbal"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setOpticalFlow(jSONObject2.optString("OpticalFlow"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setGimbalBootloader(jSONObject2.optString("GimbalBootloader"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setGimbalPitchESC(jSONObject2.optString("GimbalPitchESC"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setGimbalRollESC(jSONObject2.optString("GimbalRollESC"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setGimbalYawESC(jSONObject2.optString("GimbalYawESC"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setSonar(jSONObject2.optString("Sonar"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setRfRx(jSONObject2.optString("RfRx"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setTB(jSONObject2.optString("TB"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setFocESC1(jSONObject2.optString("FocESC1"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setFocESC2(jSONObject2.optString("FocESC2"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setFocESC3(jSONObject2.optString("FocESC3"));
                    AutelFirmVersionManager.getInstence().getAircraftComponentVersionInfoInternal().setFocESC4(jSONObject2.optString("FocESC4"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
