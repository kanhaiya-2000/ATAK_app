package com.autel.AutelNet2.aircraft.visual.tracking.message;

import com.autel.AutelNet2.aircraft.visual.tracking.entity.UploadGoalArea;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import org.json.JSONObject;

public class UploadGoalAreaPacket extends BaseMsgPacket {
    private UploadGoalArea uploadGoalArea;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public UploadGoalAreaPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public BaseMsgPacket parseBody() {
        JSONObject bodyJson = getBodyJson();
        this.uploadGoalArea = (UploadGoalArea) this.messageParser.getObject(bodyJson.getString("params"), UploadGoalArea.class);
        if (bodyJson.has("id")) {
            this.uploadGoalArea.setId(bodyJson.getInt("id"));
        }
        return this;
    }

    public UploadGoalArea getUploadGoalArea() {
        return this.uploadGoalArea;
    }
}
