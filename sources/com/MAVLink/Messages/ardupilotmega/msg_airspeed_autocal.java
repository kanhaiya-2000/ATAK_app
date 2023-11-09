package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_airspeed_autocal extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_AIRSPEED_AUTOCAL = 174;
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
    public float f8117vx;

    /* renamed from: vy */
    public float f8118vy;

    /* renamed from: vz */
    public float f8119vz;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 48;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 174;
        mAVLinkPacket.payload.putFloat(this.f8117vx);
        mAVLinkPacket.payload.putFloat(this.f8118vy);
        mAVLinkPacket.payload.putFloat(this.f8119vz);
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
        this.f8117vx = mAVLinkPayload.getFloat();
        this.f8118vy = mAVLinkPayload.getFloat();
        this.f8119vz = mAVLinkPayload.getFloat();
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
        return "MAVLINK_MSG_ID_AIRSPEED_AUTOCAL - vx:" + this.f8117vx + " vy:" + this.f8118vy + " vz:" + this.f8119vz + " diff_pressure:" + this.diff_pressure + " EAS2TAS:" + this.EAS2TAS + " ratio:" + this.ratio + " state_x:" + this.state_x + " state_y:" + this.state_y + " state_z:" + this.state_z + " Pax:" + this.Pax + " Pby:" + this.Pby + " Pcz:" + this.Pcz + "";
    }
}
