package com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.version;

import com.autel.downloader.bean.DownloadTask;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmVersionManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmWareIpConst;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.base.Version;
import org.json.JSONException;
import org.json.JSONObject;

public class RCSNVersion extends Version {
    private static final int RequestId = 4;
    private static RCSNVersion instance_;

    public String getMethodName() {
        return "GetModulesSerialNum";
    }

    public static RCSNVersion getInstance_() {
        if (instance_ == null) {
            instance_ = new RCSNVersion();
        }
        return instance_;
    }

    private RCSNVersion() {
        setRequestId(4);
    }

    public String getSocketIp() {
        return AutelFirmWareIpConst.getFirmVersionRCSocketAddr();
    }

    public int getSocketPort() {
        return AutelFirmWareIpConst.FIRMVERSION_SOCKET_HOST_REMOTE_PORT;
    }

    public void jsonParser(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt(DownloadTask.STATUS) == 0) {
                int i = jSONObject.getInt("id");
                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                if (i == getRequestId()) {
                    AutelFirmVersionManager.getInstence().getRcsnVersionInfoInternal().setJson(str);
                    AutelFirmVersionManager.getInstence().getRcsnVersionInfoInternal().setRemoteControl(jSONObject2.optString("RemoteControl"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
