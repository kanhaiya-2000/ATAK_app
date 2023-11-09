package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_remote_log_data_block extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_REMOTE_LOG_DATA_BLOCK = 184;
    public static final int MAVLINK_MSG_ID_REMOTE_LOG_DATA_BLOCK_CRC = 159;
    public static final int MAVLINK_MSG_LENGTH = 206;
    private static final long serialVersionUID = 184;
    public short[] data = new short[200];
    public long seqno;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(206);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 184;
        mAVLinkPacket.crc_extra = 159;
        mAVLinkPacket.payload.putUnsignedInt(this.seqno);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        for (short putUnsignedByte : this.data) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.seqno = mAVLinkPayload.getUnsignedInt();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            short[] sArr = this.data;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_remote_log_data_block() {
        this.msgid = 184;
    }

    public msg_remote_log_data_block(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 184;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_REMOTE_LOG_DATA_BLOCK - sysid:" + this.sysid + " compid:" + this.compid + " seqno:" + this.seqno + " target_system:" + this.target_system + " target_component:" + this.target_component + " data:" + this.data + "";
    }
}
