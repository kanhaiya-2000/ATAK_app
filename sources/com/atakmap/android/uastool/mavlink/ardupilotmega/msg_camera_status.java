package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_camera_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_CAMERA_STATUS = 179;
    public static final int MAVLINK_MSG_ID_CAMERA_STATUS_CRC = 189;
    public static final int MAVLINK_MSG_LENGTH = 29;
    private static final long serialVersionUID = 179;
    public short cam_idx;
    public short event_id;
    public int img_idx;

    /* renamed from: p1 */
    public float f8239p1;

    /* renamed from: p2 */
    public float f8240p2;

    /* renamed from: p3 */
    public float f8241p3;

    /* renamed from: p4 */
    public float f8242p4;
    public short target_system;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(29);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 179;
        mAVLinkPacket.crc_extra = 189;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.f8239p1);
        mAVLinkPacket.payload.putFloat(this.f8240p2);
        mAVLinkPacket.payload.putFloat(this.f8241p3);
        mAVLinkPacket.payload.putFloat(this.f8242p4);
        mAVLinkPacket.payload.putUnsignedShort(this.img_idx);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        mAVLinkPacket.payload.putUnsignedByte(this.cam_idx);
        mAVLinkPacket.payload.putUnsignedByte(this.event_id);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.f8239p1 = mAVLinkPayload.getFloat();
        this.f8240p2 = mAVLinkPayload.getFloat();
        this.f8241p3 = mAVLinkPayload.getFloat();
        this.f8242p4 = mAVLinkPayload.getFloat();
        this.img_idx = mAVLinkPayload.getUnsignedShort();
        this.target_system = mAVLinkPayload.getUnsignedByte();
        this.cam_idx = mAVLinkPayload.getUnsignedByte();
        this.event_id = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_CAMERA_STATUS - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " p1:" + this.f8239p1 + " p2:" + this.f8240p2 + " p3:" + this.f8241p3 + " p4:" + this.f8242p4 + " img_idx:" + this.img_idx + " target_system:" + this.target_system + " cam_idx:" + this.cam_idx + " event_id:" + this.event_id + "";
    }
}
