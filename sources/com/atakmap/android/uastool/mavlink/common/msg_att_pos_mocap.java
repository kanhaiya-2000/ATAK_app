package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_att_pos_mocap extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ATT_POS_MOCAP = 138;
    public static final int MAVLINK_MSG_ID_ATT_POS_MOCAP_CRC = 109;
    public static final int MAVLINK_MSG_LENGTH = 36;
    private static final long serialVersionUID = 138;

    /* renamed from: q */
    public float[] f8247q = new float[4];
    public long time_usec;

    /* renamed from: x */
    public float f8248x;

    /* renamed from: y */
    public float f8249y;

    /* renamed from: z */
    public float f8250z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(36);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 138;
        mAVLinkPacket.crc_extra = 109;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        for (float putFloat : this.f8247q) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putFloat(this.f8248x);
        mAVLinkPacket.payload.putFloat(this.f8249y);
        mAVLinkPacket.payload.putFloat(this.f8250z);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        int i = 0;
        while (true) {
            float[] fArr = this.f8247q;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.f8248x = mAVLinkPayload.getFloat();
                this.f8249y = mAVLinkPayload.getFloat();
                this.f8250z = mAVLinkPayload.getFloat();
                return;
            }
        }
    }

    public msg_att_pos_mocap() {
        this.msgid = 138;
    }

    public msg_att_pos_mocap(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 138;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ATT_POS_MOCAP - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " q:" + this.f8247q + " x:" + this.f8248x + " y:" + this.f8249y + " z:" + this.f8250z + "";
    }
}
