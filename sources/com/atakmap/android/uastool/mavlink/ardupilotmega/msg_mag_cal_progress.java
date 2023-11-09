package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_mag_cal_progress extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_MAG_CAL_PROGRESS = 191;
    public static final int MAVLINK_MSG_ID_MAG_CAL_PROGRESS_CRC = 92;
    public static final int MAVLINK_MSG_LENGTH = 27;
    private static final long serialVersionUID = 191;
    public short attempt;
    public short cal_mask;
    public short cal_status;
    public short compass_id;
    public short[] completion_mask = new short[10];
    public short completion_pct;
    public float direction_x;
    public float direction_y;
    public float direction_z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(27);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 191;
        mAVLinkPacket.crc_extra = 92;
        mAVLinkPacket.payload.putFloat(this.direction_x);
        mAVLinkPacket.payload.putFloat(this.direction_y);
        mAVLinkPacket.payload.putFloat(this.direction_z);
        mAVLinkPacket.payload.putUnsignedByte(this.compass_id);
        mAVLinkPacket.payload.putUnsignedByte(this.cal_mask);
        mAVLinkPacket.payload.putUnsignedByte(this.cal_status);
        mAVLinkPacket.payload.putUnsignedByte(this.attempt);
        mAVLinkPacket.payload.putUnsignedByte(this.completion_pct);
        for (short putUnsignedByte : this.completion_mask) {
            mAVLinkPacket.payload.putUnsignedByte(putUnsignedByte);
        }
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.direction_x = mAVLinkPayload.getFloat();
        this.direction_y = mAVLinkPayload.getFloat();
        this.direction_z = mAVLinkPayload.getFloat();
        this.compass_id = mAVLinkPayload.getUnsignedByte();
        this.cal_mask = mAVLinkPayload.getUnsignedByte();
        this.cal_status = mAVLinkPayload.getUnsignedByte();
        this.attempt = mAVLinkPayload.getUnsignedByte();
        this.completion_pct = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            short[] sArr = this.completion_mask;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getUnsignedByte();
                i++;
            } else {
                return;
            }
        }
    }

    public msg_mag_cal_progress() {
        this.msgid = 191;
    }

    public msg_mag_cal_progress(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 191;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_MAG_CAL_PROGRESS - sysid:" + this.sysid + " compid:" + this.compid + " direction_x:" + this.direction_x + " direction_y:" + this.direction_y + " direction_z:" + this.direction_z + " compass_id:" + this.compass_id + " cal_mask:" + this.cal_mask + " cal_status:" + this.cal_status + " attempt:" + this.attempt + " completion_pct:" + this.completion_pct + " completion_mask:" + this.completion_mask + "";
    }
}
