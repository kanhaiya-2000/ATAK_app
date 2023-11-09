package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gopro_get_response extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GOPRO_GET_RESPONSE = 217;
    public static final int MAVLINK_MSG_ID_GOPRO_GET_RESPONSE_CRC = 202;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = 217;
    public short cmd_id;
    public short status;
    public short[] value = new short[4];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(6);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 217;
        mAVLinkPacket.crc_extra = 202;
        mAVLinkPacket.payload.putUnsignedByte(this.cmd_id);
        mAVLinkPacket.payload.putUnsignedByte(this.status);
        for (short putUnsignedByte : this.value) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.cmd_id = mAVLinkPayload.getUnsignedByte();
        this.status = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            short[] sArr = this.value;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_gopro_get_response() {
        this.msgid = 217;
    }

    public msg_gopro_get_response(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 217;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GOPRO_GET_RESPONSE - sysid:" + this.sysid + " compid:" + this.compid + " cmd_id:" + this.cmd_id + " status:" + this.status + " value:" + this.value + "";
    }
}
