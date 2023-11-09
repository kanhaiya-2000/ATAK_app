package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_ptz_update_state extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_PTZ_UPDATE_CMD = 219;
    public static final int MAVLINK_MSG_LENGTH = 2;
    private static final long serialVersionUID = 219;
    public byte device_id;
    public byte dowload_flag;

    public void unpack(MAVLinkPayload mAVLinkPayload) {
    }

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 2;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 219;
        mAVLinkPacket.payload.putByte(this.device_id);
        mAVLinkPacket.payload.putByte(this.dowload_flag);
        return mAVLinkPacket;
    }
}
