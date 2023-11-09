package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_gopro_set_response extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GOPRO_SET_RESPONSE = 219;
    public static final int MAVLINK_MSG_ID_GOPRO_SET_RESPONSE_CRC = 162;
    public static final int MAVLINK_MSG_LENGTH = 2;
    private static final long serialVersionUID = 219;
    public short cmd_id;
    public short status;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(2);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 219;
        mAVLinkPacket.crc_extra = 162;
        mAVLinkPacket.payload.putUnsignedByte(this.cmd_id);
        mAVLinkPacket.payload.putUnsignedByte(this.status);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.cmd_id = mAVLinkPayload.getUnsignedByte();
        this.status = mAVLinkPayload.getUnsignedByte();
    }

    public msg_gopro_set_response() {
        this.msgid = 219;
    }

    public msg_gopro_set_response(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 219;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GOPRO_SET_RESPONSE - sysid:" + this.sysid + " compid:" + this.compid + " cmd_id:" + this.cmd_id + " status:" + this.status + "";
    }
}
