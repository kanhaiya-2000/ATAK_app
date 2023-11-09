package com.autel.AutelNet2.aircraft.mission.message;

import com.autel.AutelNet2.aircraft.mission.engine.MissionAllInternal;
import com.autel.AutelNet2.aircraft.mission.utils.ZipUtils;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.util.log.AutelLog;
import org.json.JSONObject;

public class RequestMissionAllSettingsPacket extends BaseMsgPacket {
    private MissionAllInternal missionSettingInfoInternal;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public RequestMissionAllSettingsPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public int getType() {
        return hashCode();
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_ALL_MISSION_DATA;
        this.msg_head.msg_dst = 8;
    }

    public BaseMsgPacket parseBody() {
        String deCompress = ZipUtils.deCompress(getBody());
        AutelLog.m15081d("downlaodMission json:" + deCompress);
        this.missionSettingInfoInternal = (MissionAllInternal) this.messageParser.getObject(new JSONObject(deCompress).getString("params"), MissionAllInternal.class);
        return this;
    }

    public MissionAllInternal getMissionAllInternal() {
        return this.missionSettingInfoInternal;
    }
}
