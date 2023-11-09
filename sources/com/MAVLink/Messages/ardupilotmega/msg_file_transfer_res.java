package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_file_transfer_res extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_FILE_TRANSFER_RES = 112;
    public static final int MAVLINK_MSG_LENGTH = 9;
    private static final long serialVersionUID = 112;
    public byte result;
    public long transfer_uid;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 9;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 112;
        mAVLinkPacket.payload.putLong(this.transfer_uid);
        mAVLinkPacket.payload.putByte(this.result);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.transfer_uid = mAVLinkPayload.getLong();
        this.result = mAVLinkPayload.getByte();
    }

    public msg_file_transfer_res() {
        this.msgid = 112;
    }

    public msg_file_transfer_res(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 112;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FILE_TRANSFER_RES - transfer_uid:" + this.transfer_uid + " result:" + this.result + "";
    }
}
