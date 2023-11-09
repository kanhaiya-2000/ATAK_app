package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_camera_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CAMERA_STATUS = 179;
    public static final int MAVLINK_MSG_LENGTH = 29;
    private static final long serialVersionUID = 179;
    public byte cam_idx;
    public byte event_id;
    public short img_idx;

    /* renamed from: p1 */
    public float f8127p1;

    /* renamed from: p2 */
    public float f8128p2;

    /* renamed from: p3 */
    public float f8129p3;

    /* renamed from: p4 */
    public float f8130p4;
    public byte target_system;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 29;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 179;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.f8127p1);
        mAVLinkPacket.payload.putFloat(this.f8128p2);
        mAVLinkPacket.payload.putFloat(this.f8129p3);
        mAVLinkPacket.payload.putFloat(this.f8130p4);
        mAVLinkPacket.payload.putShort(this.img_idx);
        mAVLinkPacket.payload.putByte(this.target_system);
        mAVLinkPacket.payload.putByte(this.cam_idx);
        mAVLinkPacket.payload.putByte(this.event_id);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.f8127p1 = mAVLinkPayload.getFloat();
        this.f8128p2 = mAVLinkPayload.getFloat();
        this.f8129p3 = mAVLinkPayload.getFloat();
        this.f8130p4 = mAVLinkPayload.getFloat();
        this.img_idx = mAVLinkPayload.getShort();
        this.target_system = mAVLinkPayload.getByte();
        this.cam_idx = mAVLinkPayload.getByte();
        this.event_id = mAVLinkPayload.getByte();
    }

    public msg_camera_status() {
        this.msgid = 179;
    }

    public msg_camera_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 179;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_CAMERA_STATUS - time_usec:" + this.time_usec + " p1:" + this.f8127p1 + " p2:" + this.f8128p2 + " p3:" + this.f8129p3 + " p4:" + this.f8130p4 + " img_idx:" + this.img_idx + " target_system:" + this.target_system + " cam_idx:" + this.cam_idx + " event_id:" + this.event_id + "";
    }
}
