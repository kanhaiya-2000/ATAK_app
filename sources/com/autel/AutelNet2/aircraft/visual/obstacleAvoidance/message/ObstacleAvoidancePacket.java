package com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.message;

import com.autel.AutelNet2.aircraft.visual.obstacleAvoidance.entity.ObstacleAvoidance;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;

public class ObstacleAvoidancePacket extends BaseMsgPacket {
    private ObstacleAvoidance obstacleAvoidance;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
    }

    public ObstacleAvoidancePacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    public ObstacleAvoidance getObstacleAvoidance() {
        return this.obstacleAvoidance;
    }

    public BaseMsgPacket parseBody() {
        this.obstacleAvoidance = (ObstacleAvoidance) this.messageParser.getObject(getBodyJson().getString("params"), ObstacleAvoidance.class);
        return this;
    }
}
