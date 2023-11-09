package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_camera_feedback extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CAMERA_FEEDBACK = 180;
    public static final int MAVLINK_MSG_ID_CAMERA_FEEDBACK_CRC = 52;
    public static final int MAVLINK_MSG_LENGTH = 45;
    private static final long serialVersionUID = 180;
    public float alt_msl;
    public float alt_rel;
    public short cam_idx;
    public short flags;
    public float foc_len;
    public int img_idx;
    public int lat;
    public int lng;
    public float pitch;
    public float roll;
    public short target_system;
    public long time_usec;
    public float yaw;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(45);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 180;
        mAVLinkPacket.crc_extra = 52;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lng);
        mAVLinkPacket.payload.putFloat(this.alt_msl);
        mAVLinkPacket.payload.putFloat(this.alt_rel);
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.foc_len);
        mAVLinkPacket.payload.putUnsignedShort(this.img_idx);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.cam_idx);
        mAVLinkPacket.payload.putUnsignedByte(this.flags);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.lat = mAVLinkPayload.getInt();
        this.lng = mAVLinkPayload.getInt();
        this.alt_msl = mAVLinkPayload.getFloat();
        this.alt_rel = mAVLinkPayload.getFloat();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.foc_len = mAVLinkPayload.getFloat();
        this.img_idx = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.cam_idx = mAVLinkPayload.getUnsignedByte();
        this.flags = mAVLinkPayload.getUnsignedByte();
    }

    public msg_camera_feedback() {
        this.msgid = 180;
    }

    public msg_camera_feedback(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 180;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CAMERA_FEEDBACK - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " lat:" + this.lat + " lng:" + this.lng + " alt_msl:" + this.alt_msl + " alt_rel:" + this.alt_rel + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " foc_len:" + this.foc_len + " img_idx:" + this.img_idx + " target_system:" + this.target_system + " cam_idx:" + this.cam_idx + " flags:" + this.flags + "";
    }
}
