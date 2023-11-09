package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_set_home_position extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SET_HOME_POSITION = 243;
    public static final int MAVLINK_MSG_ID_SET_HOME_POSITION_CRC = 85;
    public static final int MAVLINK_MSG_LENGTH = 53;
    private static final long serialVersionUID = 243;
    public int altitude;
    public float approach_x;
    public float approach_y;
    public float approach_z;
    public int latitude;
    public int longitude;

    /* renamed from: q */
    public float[] f8335q = new float[4];
    public short target_system;

    /* renamed from: x */
    public float f8336x;

    /* renamed from: y */
    public float f8337y;

    /* renamed from: z */
    public float f8338z;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(53);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 243;
        mAVLinkPacket.crc_extra = 85;
        mAVLinkPacket.payload.putInt(this.latitude);
        mAVLinkPacket.payload.putInt(this.longitude);
        mAVLinkPacket.payload.putInt(this.altitude);
        mAVLinkPacket.payload.putFloat(this.f8336x);
        mAVLinkPacket.payload.putFloat(this.f8337y);
        mAVLinkPacket.payload.putFloat(this.f8338z);
        for (float putFloat : this.f8335q) {
            mAVLinkPacket.payload.putFloat(putFloat);
        }
        mAVLinkPacket.payload.putFloat(this.approach_x);
        mAVLinkPacket.payload.putFloat(this.approach_y);
        mAVLinkPacket.payload.putFloat(this.approach_z);
        mAVLinkPacket.payload.putUnsignedByte(this.target_system);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.latitude = mAVLinkPayload.getInt();
        this.longitude = mAVLinkPayload.getInt();
        this.altitude = mAVLinkPayload.getInt();
        this.f8336x = mAVLinkPayload.getFloat();
        this.f8337y = mAVLinkPayload.getFloat();
        this.f8338z = mAVLinkPayload.getFloat();
        int i = 0;
        while (true) {
            float[] fArr = this.f8335q;
            if (i < fArr.length) {
                fArr[i] = mAVLinkPayload.getFloat();
                i++;
            } else {
                this.approach_x = mAVLinkPayload.getFloat();
                this.approach_y = mAVLinkPayload.getFloat();
                this.approach_z = mAVLinkPayload.getFloat();
                this.target_system = mAVLinkPayload.getUnsignedByte();
                return;
            }
        }
    }

    public msg_set_home_position() {
        this.msgid = 243;
    }

    public msg_set_home_position(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 243;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SET_HOME_POSITION - sysid:" + this.sysid + " compid:" + this.compid + " latitude:" + this.latitude + " longitude:" + this.longitude + " altitude:" + this.altitude + " x:" + this.f8336x + " y:" + this.f8337y + " z:" + this.f8338z + " q:" + this.f8335q + " approach_x:" + this.approach_x + " approach_y:" + this.approach_y + " approach_z:" + this.approach_z + " target_system:" + this.target_system + "";
    }
}
