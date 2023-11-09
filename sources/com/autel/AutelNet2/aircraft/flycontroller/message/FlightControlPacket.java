package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.autel.AutelNet2.aircraft.base.RequestBeanNoID;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.AutelNet2.remotecontroller.engine.FlightcontrolInfo;
import com.autel.downloader.bean.DownloadTask;
import java.io.PrintStream;

public class FlightControlPacket extends BaseMsgPacket {
    private RequestBeanNoID<FlightcontrolInfo> requestBeanNoID;
    private int status = -1;

    public FlightControlPacket(RequestBeanNoID<FlightcontrolInfo> requestBeanNoID2) {
        this.requestBeanNoID = requestBeanNoID2;
    }

    public FlightControlPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FLIGHT_CONTROL;
        this.msg_head.msg_dst = 2048;
    }

    /* access modifiers changed from: protected */
    public String loadBody() {
        this.requestBeanNoID.setMethod("AU_BUTTON_FLIGHT_CONTROL");
        String json = this.messageParser.gsonParser.toJson((Object) this.requestBeanNoID);
        PrintStream printStream = System.out;
        printStream.println("send msg:" + json);
        return json;
    }

    public BaseMsgPacket parseBody() {
        this.status = getBodyJson().getInt(DownloadTask.STATUS);
        return this;
    }

    public boolean isSuccess() {
        return this.status == 0;
    }
}
