package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_digicam_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DIGICAM_CONTROL = 155;
    public static final int MAVLINK_MSG_ID_DIGICAM_CONTROL_CRC = 22;
    public static final int MAVLINK_MSG_LENGTH = 13;
    private static final long serialVersionUID = 155;
    public short command_id;
    public short extra_param;
    public float extra_value;
    public short focus_lock;
    public short session;
    public short shot;
    public short target_component;
    public short target_system;
    public short zoom_pos;
    public byte zoom_step;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(13);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 155;
        mAVLinkPacket.crc_extra = 22;
        mAVLinkPacket.payload.putFloat(this.extra_value);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.session);
        mAVLinkPacket.payload.putUnsignedByte(this.zoom_pos);
        mAVLinkPacket.payload.putByte(this.zoom_step);
        mAVLinkPacket.payload.putUnsignedByte(this.focus_lock);
        mAVLinkPacket.payload.putUnsignedByte(this.shot);
        mAVLinkPacket.payload.putUnsignedByte(this.command_id);
        mAVLinkPacket.payload.putUnsignedByte(this.extra_param);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.extra_value = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.session = mAVLinkPayload.getUnsignedByte();
        this.zoom_pos = mAVLinkPayload.getUnsignedByte();
        this.zoom_step = mAVLinkPayload.getByte();
        this.focus_lock = mAVLinkPayload.getUnsignedByte();
        this.shot = mAVLinkPayload.getUnsignedByte();
        this.command_id = mAVLinkPayload.getUnsignedByte();
        this.extra_param = mAVLinkPayload.getUnsignedByte();
    }

    public msg_digicam_control() {
        this.msgid = 155;
    }

    public msg_digicam_control(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 155;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DIGICAM_CONTROL - sysid:" + this.sysid + " compid:" + this.compid + " extra_value:" + this.extra_value + " target_system:" + this.target_system + " target_component:" + this.target_component + " session:" + this.session + " zoom_pos:" + this.zoom_pos + " zoom_step:" + this.zoom_step + " focus_lock:" + this.focus_lock + " shot:" + this.shot + " command_id:" + this.command_id + " extra_param:" + this.extra_param + "";
    }
}
