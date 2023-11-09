package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_digicam_configure extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DIGICAM_CONFIGURE = 154;
    public static final int MAVLINK_MSG_LENGTH = 15;
    private static final long serialVersionUID = 154;
    public byte aperture;
    public byte command_id;
    public byte engine_cut_off;
    public byte exposure_type;
    public byte extra_param;
    public float extra_value;
    public byte iso;
    public byte mode;
    public short shutter_speed;
    public byte target_component;
    public byte target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 15;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 154;
        mAVLinkPacket.payload.putFloat(this.extra_value);
        mAVLinkPacket.payload.putShort(this.shutter_speed);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.target_component);
        mAVLinkPacket.payload.putByte(this.mode);
        mAVLinkPacket.payload.putByte(this.aperture);
        mAVLinkPacket.payload.putByte(this.iso);
        mAVLinkPacket.payload.putByte(this.exposure_type);
        mAVLinkPacket.payload.putByte(this.command_id);
        mAVLinkPacket.payload.putByte(this.engine_cut_off);
        mAVLinkPacket.payload.putByte(this.extra_param);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.extra_value = mAVLinkPayload.getFloat();
        this.shutter_speed = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.target_component = mAVLinkPayload.getByte();
        this.mode = mAVLinkPayload.getByte();
        this.aperture = mAVLinkPayload.getByte();
        this.iso = mAVLinkPayload.getByte();
        this.exposure_type = mAVLinkPayload.getByte();
        this.command_id = mAVLinkPayload.getByte();
        this.engine_cut_off = mAVLinkPayload.getByte();
        this.extra_param = mAVLinkPayload.getByte();
    }

    public msg_digicam_configure() {
        this.msgid = 154;
    }

    public msg_digicam_configure(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 154;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DIGICAM_CONFIGURE - extra_value:" + this.extra_value + " shutter_speed:" + this.shutter_speed + " target_system:" + this.target_system + " target_component:" + this.target_component + " mode:" + this.mode + " aperture:" + this.aperture + " iso:" + this.iso + " exposure_type:" + this.exposure_type + " command_id:" + this.command_id + " engine_cut_off:" + this.engine_cut_off + " extra_param:" + this.extra_param + "";
    }
}
