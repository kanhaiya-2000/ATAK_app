package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_digicam_configure extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_DIGICAM_CONFIGURE = 154;
    public static final int MAVLINK_MSG_ID_DIGICAM_CONFIGURE_CRC = 84;
    public static final int MAVLINK_MSG_LENGTH = 15;
    private static final long serialVersionUID = 154;
    public short aperture;
    public short command_id;
    public short engine_cut_off;
    public short exposure_type;
    public short extra_param;
    public float extra_value;
    public short iso;
    public short mode;
    public int shutter_speed;
    public short target_component;
    public short target_system;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(15);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 154;
        mAVLinkPacket.crc_extra = 84;
        mAVLinkPacket.payload.putFloat(this.extra_value);
        mAVLinkPacket.payload.putUnsignedShort(this.shutter_speed);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.target_component);
        mAVLinkPacket.payload.putUnsignedByte(this.mode);
        mAVLinkPacket.payload.putUnsignedByte(this.aperture);
        mAVLinkPacket.payload.putUnsignedByte(this.iso);
        mAVLinkPacket.payload.putUnsignedByte(this.exposure_type);
        mAVLinkPacket.payload.putUnsignedByte(this.command_id);
        mAVLinkPacket.payload.putUnsignedByte(this.engine_cut_off);
        mAVLinkPacket.payload.putUnsignedByte(this.extra_param);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.extra_value = mAVLinkPayload.getFloat();
        this.shutter_speed = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.target_component = mAVLinkPayload.getUnsignedByte();
        this.mode = mAVLinkPayload.getUnsignedByte();
        this.aperture = mAVLinkPayload.getUnsignedByte();
        this.iso = mAVLinkPayload.getUnsignedByte();
        this.exposure_type = mAVLinkPayload.getUnsignedByte();
        this.command_id = mAVLinkPayload.getUnsignedByte();
        this.engine_cut_off = mAVLinkPayload.getUnsignedByte();
        this.extra_param = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_DIGICAM_CONFIGURE - sysid:" + this.sysid + " compid:" + this.compid + " extra_value:" + this.extra_value + " shutter_speed:" + this.shutter_speed + " target_system:" + this.target_system + " target_component:" + this.target_component + " mode:" + this.mode + " aperture:" + this.aperture + " iso:" + this.iso + " exposure_type:" + this.exposure_type + " command_id:" + this.command_id + " engine_cut_off:" + this.engine_cut_off + " extra_param:" + this.extra_param + "";
    }
}
