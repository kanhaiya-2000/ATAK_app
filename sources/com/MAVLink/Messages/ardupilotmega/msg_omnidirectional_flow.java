package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_omnidirectional_flow extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_OMNIDIRECTIONAL_FLOW = 106;
    public static final int MAVLINK_MSG_LENGTH = 54;
    private static final long serialVersionUID = 106;
    public float front_distance_m;
    public short[] left = new short[10];
    public byte quality;
    public short[] right = new short[10];
    public byte sensor_id;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 54;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 106;
        mAVLinkPacket.payload.putLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.front_distance_m);
        for (short putShort : this.left) {
            mAVLinkPacket.payload.putShort(putShort);
        }
        for (short putShort2 : this.right) {
            mAVLinkPacket.payload.putShort(putShort2);
        }
        mAVLinkPacket.payload.putByte(this.sensor_id);
        mAVLinkPacket.payload.putByte(this.quality);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getLong();
        this.front_distance_m = mAVLinkPayload.getFloat();
        int i = 0;
        int i2 = 0;
        while (true) {
            short[] sArr = this.left;
            if (i2 >= sArr.length) {
                break;
            }
            sArr[i2] = mAVLinkPayload.getShort();
            i2++;
        }
        while (true) {
            short[] sArr2 = this.right;
            if (i < sArr2.length) {
                sArr2[i] = mAVLinkPayload.getShort();
                i++;
            } else {
                this.sensor_id = mAVLinkPayload.getByte();
                this.quality = mAVLinkPayload.getByte();
                return;
            }
        }
    }

    public msg_omnidirectional_flow() {
        this.msgid = 106;
    }

    public msg_omnidirectional_flow(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 106;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_OMNIDIRECTIONAL_FLOW - time_usec:" + this.time_usec + " front_distance_m:" + this.front_distance_m + " left:" + this.left + " right:" + this.right + " sensor_id:" + this.sensor_id + " quality:" + this.quality + "";
    }
}
