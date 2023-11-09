package com.autel.AutelNet2.remotecontroller.message;

import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.downloader.bean.DownloadTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RCMsgPacket extends BaseMsgPacket {
    private static final String METHOD = "IphoneSettingParam";
    private static final String TAG = "RCMsgPacket";
    private JSONArray data = new JSONArray();
    private int type;

    public void parseData(int i, JSONArray jSONArray) {
    }

    public RCMsgPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public RCMsgPacket() {
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_BUTTON_SET_PARAS_REQ;
    }

    public BaseMsgPacket parseBody() {
        JSONObject bodyJson = getBodyJson();
        if (bodyJson.getInt(DownloadTask.STATUS) == 0) {
            JSONObject jSONObject = bodyJson.getJSONObject("result");
            int i = jSONObject.getInt(CameraParamsConfig.param_SetShutter_Type);
            setType(i);
            try {
                this.data = jSONObject.getJSONArray("Data");
            } catch (Exception unused) {
            }
            RCMsgPacket rCMsgPacket = null;
            switch (i) {
                case 1:
                case 2:
                    rCMsgPacket = new RCGimbalWheelAdjustSpeedPacket();
                    break;
                case 3:
                case 4:
                    rCMsgPacket = new RCLanguagePacket();
                    break;
                case 5:
                case 6:
                    rCMsgPacket = new RCPairModePacket();
                    break;
                case 7:
                case 8:
                    rCMsgPacket = new RCRFPowerPacket();
                    break;
                case 9:
                case 10:
                    rCMsgPacket = new RCTeachStuModePacket();
                    break;
                case 12:
                    rCMsgPacket = new RCGimbalAnglePacket();
                    break;
                case 13:
                    rCMsgPacket = new RCCalibrationPacket();
                    break;
                case 14:
                    rCMsgPacket = new RCUploadDataPacket();
                    break;
                case 15:
                    rCMsgPacket = new RCInfoPacket();
                    break;
                case 16:
                    rCMsgPacket = new RCVersionDataPacket();
                    break;
                case 17:
                case 20:
                    rCMsgPacket = new RCLengthUnitPacket();
                    break;
                case 18:
                case 19:
                    rCMsgPacket = new RCCommandStickModePacket();
                    break;
                case 21:
                    rCMsgPacket = new RCresetWifiPacket();
                    break;
                case 25:
                    rCMsgPacket = new RCStickCalibratePacket();
                    break;
            }
            if (rCMsgPacket == null) {
                rCMsgPacket = this;
            }
            rCMsgPacket.setHead(getHead());
            rCMsgPacket.setBody(getBody());
            rCMsgPacket.setType(i);
            rCMsgPacket.parseData(i, this.data);
            return rCMsgPacket;
        }
        throw new Exception("status is not 0");
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", METHOD);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CameraParamsConfig.param_SetShutter_Type, this.type);
            JSONArray jSONArray = this.data;
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject2.put("Length", this.data.length());
                jSONObject2.put("Data", this.data);
            }
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public void addData(int i) {
        this.data.put(i);
    }

    /* access modifiers changed from: protected */
    public JSONArray getData() {
        return this.data;
    }
}
