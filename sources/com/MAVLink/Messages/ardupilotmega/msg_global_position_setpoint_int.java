package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_global_position_setpoint_int extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_GLOBAL_POSITION_SETPOINT_INT = 52;
    public static final int MAVLINK_MSG_LENGTH = 15;
    private static final long serialVersionUID = 52;
    public int altitude;
    public byte coordinate_frame;
    public int latitude;
    public int longitude;
    public short yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 15;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 52;
        mAVLinkPacket.payload.putInt(this.latitude);
        mAVLinkPacket.payload.putInt(this.longitude);
        mAVLinkPacket.payload.putInt(this.altitude);
        mAVLinkPacket.payload.putShort(this.yaw);
        mAVLinkPacket.payload.putByte(this.coordinate_frame);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.latitude = mAVLinkPayload.getInt();
        this.longitude = mAVLinkPayload.getInt();
        this.altitude = mAVLinkPayload.getInt();
        this.yaw = mAVLinkPayload.getShort();
        this.coordinate_frame = mAVLinkPayload.getByte();
    }

    public msg_global_position_setpoint_int() {
        this.msgid = 52;
    }

    public msg_global_position_setpoint_int(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 52;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GLOBAL_POSITION_SETPOINT_INT - latitude:" + this.latitude + " longitude:" + this.longitude + " altitude:" + this.altitude + " yaw:" + this.yaw + " coordinate_frame:" + this.coordinate_frame + "";
    }
}
