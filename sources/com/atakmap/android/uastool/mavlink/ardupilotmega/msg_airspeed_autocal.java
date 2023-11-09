package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_airspeed_autocal extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AIRSPEED_AUTOCAL = 174;
    public static final int MAVLINK_MSG_ID_AIRSPEED_AUTOCAL_CRC = 167;
    public static final int MAVLINK_MSG_LENGTH = 48;
    private static final long serialVersionUID = 174;
    public float EAS2TAS;
    public float Pax;
    public float Pby;
    public float Pcz;
    public float diff_pressure;
    public float ratio;
    public float state_x;
    public float state_y;
    public float state_z;

    /* renamed from: vx */
    public float f8236vx;

    /* renamed from: vy */
    public float f8237vy;

    /* renamed from: vz */
    public float f8238vz;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(48);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 174;
        mAVLinkPacket.crc_extra = 167;
        mAVLinkPacket.payload.putFloat(this.f8236vx);
        mAVLinkPacket.payload.putFloat(this.f8237vy);
        mAVLinkPacket.payload.putFloat(this.f8238vz);
        mAVLinkPacket.payload.putFloat(this.diff_pressure);
        mAVLinkPacket.payload.putFloat(this.EAS2TAS);
        mAVLinkPacket.payload.putFloat(this.ratio);
        mAVLinkPacket.payload.putFloat(this.state_x);
        mAVLinkPacket.payload.putFloat(this.state_y);
        mAVLinkPacket.payload.putFloat(this.state_z);
        mAVLinkPacket.payload.putFloat(this.Pax);
        mAVLinkPacket.payload.putFloat(this.Pby);
        mAVLinkPacket.payload.putFloat(this.Pcz);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.f8236vx = mAVLinkPayload.getFloat();
        this.f8237vy = mAVLinkPayload.getFloat();
        this.f8238vz = mAVLinkPayload.getFloat();
        this.diff_pressure = mAVLinkPayload.getFloat();
        this.EAS2TAS = mAVLinkPayload.getFloat();
        this.ratio = mAVLinkPayload.getFloat();
        this.state_x = mAVLinkPayload.getFloat();
        this.state_y = mAVLinkPayload.getFloat();
        this.state_z = mAVLinkPayload.getFloat();
        this.Pax = mAVLinkPayload.getFloat();
        this.Pby = mAVLinkPayload.getFloat();
        this.Pcz = mAVLinkPayload.getFloat();
    }

    public msg_airspeed_autocal() {
        this.msgid = 174;
    }

    public msg_airspeed_autocal(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 174;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AIRSPEED_AUTOCAL - sysid:" + this.sysid + " compid:" + this.compid + " vx:" + this.f8236vx + " vy:" + this.f8237vy + " vz:" + this.f8238vz + " diff_pressure:" + this.diff_pressure + " EAS2TAS:" + this.EAS2TAS + " ratio:" + this.ratio + " state_x:" + this.state_x + " state_y:" + this.state_y + " state_z:" + this.state_z + " Pax:" + this.Pax + " Pby:" + this.Pby + " Pcz:" + this.Pcz + "";
    }
}
