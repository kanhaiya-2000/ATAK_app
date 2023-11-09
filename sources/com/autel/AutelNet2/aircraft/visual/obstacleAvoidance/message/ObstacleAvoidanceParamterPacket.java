package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message;

import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.VisualSettingAckInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.AutelNet2.utils.BytesUtils;
import com.autel.AutelNet2.utils.CommandParamsFactory;
import com.autel.common.camera.visual.TargetArea;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.camera.visual.VisualOrbitParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ObstacleAvoidanceParamterPacket extends BaseMsgPacket {
    private int Command;
    private int[] Data = new int[32];
    private VisualSettingAckInfo visualSettingAckInfo;

    public ObstacleAvoidanceParamterPacket() {
    }

    public VisualSettingAckInfo getVisualSettingAckInfo() {
        return this.visualSettingAckInfo;
    }

    public ObstacleAvoidanceParamterPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public void setTouchPointLocation(int i, int i2) {
        int[] iArr = this.Data;
        iArr[0] = 0;
        iArr[1] = i;
        iArr[2] = i2;
    }

    public void setTouchPointLocation(int i, int i2, int i3, int i4) {
        byte[] unsignedBytes = BytesUtils.getUnsignedBytes(i3);
        byte[] unsignedBytes2 = BytesUtils.getUnsignedBytes(i4);
        int[] iArr = this.Data;
        iArr[0] = 0;
        iArr[1] = i;
        iArr[2] = i2;
        iArr[3] = unsignedBytes[0];
        iArr[4] = unsignedBytes[1];
        iArr[5] = unsignedBytes2[0];
        iArr[6] = unsignedBytes2[1];
    }

    public void setFlyAngle(int i) {
        int[] iArr = this.Data;
        iArr[0] = 1;
        iArr[1] = i;
    }

    public void setResolutionAngle(int i, int i2) {
        byte[] unsignedBytes = BytesUtils.getUnsignedBytes(i);
        byte[] unsignedBytes2 = BytesUtils.getUnsignedBytes(i2);
        int[] iArr = this.Data;
        iArr[0] = 0;
        iArr[1] = unsignedBytes2[0];
        iArr[2] = unsignedBytes2[1];
        iArr[3] = unsignedBytes[0];
        iArr[4] = unsignedBytes[1];
    }

    public void setResolution(int i, int i2) {
        byte[] unsignedBytes = BytesUtils.getUnsignedBytes(i);
        byte[] unsignedBytes2 = BytesUtils.getUnsignedBytes(i2);
        int[] iArr = this.Data;
        iArr[0] = 3;
        iArr[1] = unsignedBytes[0];
        iArr[2] = unsignedBytes[1];
        iArr[3] = unsignedBytes2[0];
        iArr[4] = unsignedBytes2[1];
    }

    public void setTrackArea(TrackingTarget trackingTarget) {
        byte[] bytes = BytesUtils.getBytes(trackingTarget.xRatio);
        byte[] bytes2 = BytesUtils.getBytes(trackingTarget.yRatio);
        byte[] bytes3 = BytesUtils.getBytes(trackingTarget.widthRatio);
        byte[] bytes4 = BytesUtils.getBytes(trackingTarget.heightRatio);
        byte[] bytes5 = BytesUtils.getBytes(trackingTarget.targetType);
        int i = CommandParamsFactory.f8441id;
        CommandParamsFactory.f8441id = i + 1;
        byte[] bytes6 = BytesUtils.getBytes(i);
        int[] iArr = this.Data;
        iArr[0] = bytes[0];
        iArr[1] = bytes[1];
        iArr[2] = bytes[2];
        iArr[3] = bytes[3];
        iArr[4] = bytes2[0];
        iArr[5] = bytes2[1];
        iArr[6] = bytes2[2];
        iArr[7] = bytes2[3];
        iArr[8] = bytes3[0];
        iArr[9] = bytes3[1];
        iArr[10] = bytes3[2];
        iArr[11] = bytes3[3];
        iArr[12] = bytes4[0];
        iArr[13] = bytes4[1];
        iArr[14] = bytes4[2];
        iArr[15] = bytes4[3];
        iArr[16] = bytes5[0];
        iArr[17] = bytes5[1];
        iArr[18] = bytes5[2];
        iArr[19] = bytes5[3];
        iArr[20] = bytes6[0];
        iArr[21] = bytes6[1];
        iArr[22] = bytes6[2];
        iArr[23] = bytes6[3];
    }

    public void setTargetArea(TargetArea targetArea) {
        byte[] bytes = BytesUtils.getBytes(targetArea.xRatio);
        byte[] bytes2 = BytesUtils.getBytes(targetArea.yRatio);
        byte[] bytes3 = BytesUtils.getBytes(targetArea.widthRatio);
        byte[] bytes4 = BytesUtils.getBytes(targetArea.heightRatio);
        int[] iArr = this.Data;
        iArr[0] = bytes[0];
        iArr[1] = bytes[1];
        iArr[2] = bytes[2];
        iArr[3] = bytes[3];
        iArr[4] = bytes2[0];
        iArr[5] = bytes2[1];
        iArr[6] = bytes2[2];
        iArr[7] = bytes2[3];
        iArr[8] = bytes3[0];
        iArr[9] = bytes3[1];
        iArr[10] = bytes3[2];
        iArr[11] = bytes3[3];
        iArr[12] = bytes4[0];
        iArr[13] = bytes4[1];
        iArr[14] = bytes4[2];
        iArr[15] = bytes4[3];
    }

    public void setOrbitParams(VisualOrbitParams visualOrbitParams) {
        byte[] bytes = BytesUtils.getBytes(visualOrbitParams.height);
        byte[] bytes2 = BytesUtils.getBytes(visualOrbitParams.radius);
        byte[] bytes3 = BytesUtils.getBytes(visualOrbitParams.speed);
        byte[] bytes4 = BytesUtils.getBytes(visualOrbitParams.direct.getValue());
        int[] iArr = this.Data;
        iArr[0] = bytes[0];
        iArr[1] = bytes[1];
        iArr[2] = bytes[2];
        iArr[3] = bytes[3];
        iArr[4] = bytes2[0];
        iArr[5] = bytes2[1];
        iArr[6] = bytes2[2];
        iArr[7] = bytes2[3];
        iArr[8] = bytes3[0];
        iArr[9] = bytes3[1];
        iArr[10] = bytes3[2];
        iArr[11] = bytes3[3];
        iArr[12] = bytes4[0];
        iArr[13] = bytes4[1];
        iArr[14] = bytes4[2];
        if (visualOrbitParams.radius > 0.0f) {
            this.Data[15] = bytes4[3] | 240;
        } else {
            this.Data[15] = bytes4[3] | 16;
        }
    }

    public void setData(int i) {
        this.Data[0] = i;
    }

    public void setDigitalZoom(int i) {
        byte[] bytes = BytesUtils.getBytes(i);
        int[] iArr = this.Data;
        iArr[0] = bytes[0];
        iArr[1] = bytes[1];
        iArr[2] = bytes[2];
        iArr[3] = bytes[3];
    }

    public int getType() {
        return this.Command;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_IFLY_COMMAND;
        this.msg_head.msg_dst = 32;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "IFLY_COMMAND");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("Command", this.Command);
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int[] iArr = this.Data;
                if (i >= iArr.length) {
                    break;
                }
                jSONArray.put(i, iArr[i]);
                i++;
            }
            jSONObject2.put("Data", jSONArray);
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public BaseMsgPacket parseBody() {
        VisualSettingAckInfo visualSettingAckInfo2 = (VisualSettingAckInfo) this.messageParser.getObject(getBodyJson().getString("params"), VisualSettingAckInfo.class);
        this.visualSettingAckInfo = visualSettingAckInfo2;
        this.Command = visualSettingAckInfo2.getCommand();
        return this;
    }

    public int getCommand() {
        return this.Command;
    }

    public void setCommand(int i) {
        this.Command = i;
    }
}
