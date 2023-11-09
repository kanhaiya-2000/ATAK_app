package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_extended_sys_state extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_EXTENDED_SYS_STATE = 245;
    public static final int MAVLINK_MSG_ID_EXTENDED_SYS_STATE_CRC = 130;
    public static final int MAVLINK_MSG_LENGTH = 2;
    private static final long serialVersionUID = 245;
    public short landed_state;
    public short vtol_state;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(2);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 245;
        mAVLinkPacket.crc_extra = 130;
        mAVLinkPacket.payload.putUnsignedByte(this.vtol_state);
        mAVLinkPacket.payload.putUnsignedByte(this.landed_state);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.vtol_state = mAVLinkPayload.getUnsignedByte();
        this.landed_state = mAVLinkPayload.getUnsignedByte();
    }

    public msg_extended_sys_state() {
        this.msgid = 245;
    }

    public msg_extended_sys_state(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 245;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_EXTENDED_SYS_STATE - sysid:" + this.sysid + " compid:" + this.compid + " vtol_state:" + this.vtol_state + " landed_state:" + this.landed_state + "";
    }
}
