package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_home_position extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HOME_POSITION = 242;
    public static final int MAVLINK_MSG_ID_HOME_POSITION_CRC = 104;
    public static final int MAVLINK_MSG_LENGTH = 52;
    private static final long serialVersionUID = 242;
    public int altitude;
    public float approach_x;
    public float approach_y;
    public float approach_z;
    public int latitude;
    public int longitude;

    /* renamed from: q */
    public float[] f8290q = new float[4];

    /* renamed from: x */
    public float f8291x;

    /* renamed from: y */
    public float f8292y;

    /* renamed from: z */
    public float f8293z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(52);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 242;
        mAVLinkPacket.crc_extra = 104;
        mAVLinkPacket.payload.putInt(this.latitude);
        mAVLinkPacket.payload.putInt(this.longitude);
        mAVLinkPacket.payload.putInt(this.altitude);
        mAVLinkPacket.payload.putFloat(this.f8291x);
        mAVLinkPacket.payload.putFloat(this.f8292y);
        mAVLinkPacket.payload.putFloat(this.f8293z);
        for (float putFloat : this.f8290q) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putFloat(this.approach_x);
        mAVLinkPacket.payload.putFloat(this.approach_y);
        mAVLinkPacket.payload.putFloat(this.approach_z);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.latitude = mAVLinkPayload.getInt();
        this.longitude = mAVLinkPayload.getInt();
        this.altitude = mAVLinkPayload.getInt();
        this.f8291x = mAVLinkPayload.getFloat();
        this.f8292y = mAVLinkPayload.getFloat();
        this.f8293z = mAVLinkPayload.getFloat();
        int i = 0;
        while (true) {
            float[] fArr = this.f8290q;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.approach_x = mAVLinkPayload.getFloat();
                this.approach_y = mAVLinkPayload.getFloat();
                this.approach_z = mAVLinkPayload.getFloat();
                return;
            }
        }
    }

    public msg_home_position() {
        this.msgid = 242;
    }

    public msg_home_position(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 242;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HOME_POSITION - sysid:" + this.sysid + " compid:" + this.compid + " latitude:" + this.latitude + " longitude:" + this.longitude + " altitude:" + this.altitude + " x:" + this.f8291x + " y:" + this.f8292y + " z:" + this.f8293z + " q:" + this.f8290q + " approach_x:" + this.approach_x + " approach_y:" + this.approach_y + " approach_z:" + this.approach_z + "";
    }
}
