package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.mission.engine.MissionFileInfo;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;
import com.autel.util.log.AutelLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MissionTransferPacket extends BaseMsgPacket {
    private MissionFileInfo missionFileInfo;
    private int status;

    public int getType() {
        return 1432577291;
    }

    public MissionTransferPacket(MissionFileInfo missionFileInfo2) {
        this.missionFileInfo = missionFileInfo2;
    }

    public MissionTransferPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_TRANSFER_FILE_INFO_REQ;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", "transferfile_info");
            jSONObject.put("enpoint", "phone");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("filesize", this.missionFileInfo.getSize());
            jSONObject2.put("filetype", this.missionFileInfo.getType());
            jSONObject2.put("md5sum", this.missionFileInfo.getMd5());
            jSONObject2.put("filename", this.missionFileInfo.getFileName());
            jSONObject.put("params", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public BaseMsgPacket parseBody() {
        AutelLog.m15082d("MissionTransferPacket", "Receive msg: " + getBodyString());
        this.status = getBodyJson().getInt(DownloadTask.STATUS);
        return this;
    }

    public int getStatus() {
        return this.status;
    }
}
