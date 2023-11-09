package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.base.RequestBean;
import com.autel.AutelNet2.aircraft.mission.engine.MissionAllInternal;
import com.autel.AutelNet2.aircraft.mission.utils.ZipUtils;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.downloader.bean.DownloadTask;
import com.autel.util.log.AutelLog;

public class UploadMissionAllSettingsPacket extends BaseMsgPacket {

    /* renamed from: id */
    private static int f8433id;
    private final String TAG = "uploadMission";
    private RequestBean<MissionAllInternal> requestBean;
    private int status;

    public int getType() {
        return -569294973;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public UploadMissionAllSettingsPacket() {
    }

    public UploadMissionAllSettingsPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_ALL_MISSION_DATA;
        this.msg_head.msg_dst = 8;
    }

    public byte[] loadBodyToByte() {
        this.requestBean.setMethod("FMUMissionData");
        RequestBean<MissionAllInternal> requestBean2 = this.requestBean;
        int i = f8433id + 1;
        f8433id = i;
        requestBean2.setId(i);
        String json = this.messageParser.gsonParser.toJson((Object) this.requestBean);
        AutelLog.debug_i("UploadMission", "loadBodyToByte Mission prepared data " + json);
        return ZipUtils.compress(json);
    }

    public RequestBean<MissionAllInternal> getRequestBean() {
        return this.requestBean;
    }

    public BaseMsgPacket parseBody() {
        this.status = getBodyJson().getInt(DownloadTask.STATUS);
        AutelLog.debug_i("UploadMission", "parseBody Mission status " + this.status);
        return this;
    }

    public int getStatus() {
        return this.status;
    }

    public void setRequestBean(RequestBean<MissionAllInternal> requestBean2) {
        this.requestBean = requestBean2;
    }
}
