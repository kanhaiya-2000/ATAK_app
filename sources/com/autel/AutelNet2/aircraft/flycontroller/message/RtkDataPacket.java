package com.autel.AutelNet2.aircraft.flycontroller.message;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.autel.AutelNet2.constant.MsgType;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.util.log.AutelLog;

public class RtkDataPacket extends BaseMsgPacket {
    private byte[] data = new byte[MAV_CMD.MAV_CMD_GET_MESSAGE_INTERVAL];
    private byte[] recData;

    /* access modifiers changed from: protected */
    public String loadBody() {
        return null;
    }

    public RtkDataPacket(byte[] bArr) {
        this.data = bArr;
    }

    public RtkDataPacket(MsgHead msgHead, byte[] bArr) {
        setHead(msgHead);
        setBody(bArr);
    }

    /* access modifiers changed from: protected */
    public void loadHead() {
        this.msg_head.msg_type = MsgType.AU_MAV_FMU_RTK_DATA;
        this.msg_head.msg_dst = 8;
    }

    /* access modifiers changed from: protected */
    public byte[] loadBodyToByte() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[(bArr.length + 2)];
        bArr2[0] = 1;
        bArr2[1] = 1;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    public BaseMsgPacket parseBody() {
        byte[] body = getBody();
        AutelLog.debug_i("RtkDataPacket", "parseBody " + body.length);
        byte[] bArr = new byte[(body.length - 2)];
        this.recData = bArr;
        System.arraycopy(body, 2, bArr, 0, body.length - 2);
        return this;
    }

    public byte[] getData() {
        return this.recData;
    }
}
