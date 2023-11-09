package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_digicam_control extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DIGICAM_CONTROL = 155;
    public static final int MAVLINK_MSG_LENGTH = 13;
    private static final long serialVersionUID = 155;
    public byte command_id;
    public byte extra_param;
    public float extra_value;
    public byte focus_lock;
    public byte session;
    public byte shot;
    public byte target_component;
    public byte target_system;
    public byte zoom_pos;
    public byte zoom_step;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 13;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 155;
        mAVLinkPacket.payload.putFloat(this.extra_value);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.session);
        mAVLinkPacket.payload.putByte(this.zoom_pos);
        mAVLinkPacket.payload.putByte(this.zoom_step);
        mAVLinkPacket.payload.putByte(this.focus_lock);
        mAVLinkPacket.payload.putByte(this.shot);
        mAVLinkPacket.payload.putByte(this.command_id);
        mAVLinkPacket.payload.putByte(this.extra_param);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.extra_value = mAVLinkPayload.getFloat();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.session = mAVLinkPayload.getByte();
        this.zoom_pos = mAVLinkPayload.getByte();
        this.zoom_step = mAVLinkPayload.getByte();
        this.focus_lock = mAVLinkPayload.getByte();
        this.shot = mAVLinkPayload.getByte();
        this.command_id = mAVLinkPayload.getByte();
        this.extra_param = mAVLinkPayload.getByte();
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
        return "MAVLINK_MSG_ID_DIGICAM_CONTROL - extra_value:" + this.extra_value + " target_system:" + this.target_system + " target_component:" + this.target_component + " session:" + this.session + " zoom_pos:" + this.zoom_pos + " zoom_step:" + this.zoom_step + " focus_lock:" + this.focus_lock + " shot:" + this.shot + " command_id:" + this.command_id + " extra_param:" + this.extra_param + "";
    }
}
