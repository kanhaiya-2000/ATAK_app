package com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.version;

import com.autel.downloader.bean.DownloadTask;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmVersionManager;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.AutelFirmWareIpConst;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.base.Version;
import org.json.JSONException;
import org.json.JSONObject;

public class RCVersion extends Version {
    private static final int RequestId = 3;
    private static RCVersion instance_;

    public String getMethodName() {
        return "GetModulesVersion";
    }

    public static RCVersion getInstance_() {
        if (instance_ == null) {
            instance_ = new RCVersion();
        }
        return instance_;
    }

    private RCVersion() {
        setRequestId(3);
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
                    AutelFirmVersionManager.getInstence().getRcVersionInfoInternal().setJson(str);
                    AutelFirmVersionManager.getInstence().getRcVersionInfoInternal().setRepeaterVersion(jSONObject2.optString("Rootfs"));
                    AutelFirmVersionManager.getInstence().getRcVersionInfoInternal().setRfTx(jSONObject2.optString("RfTx"));
                    AutelFirmVersionManager.getInstence().getRcVersionInfoInternal().setRemoteControl(jSONObject2.optString("RemoteControl"));
                    AutelFirmVersionManager.getInstence().getRcVersionInfoInternal().setRootfs(jSONObject2.optString("Repeater"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
