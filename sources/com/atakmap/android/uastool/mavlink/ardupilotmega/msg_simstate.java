package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_simstate extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SIMSTATE = 164;
    public static final int MAVLINK_MSG_ID_SIMSTATE_CRC = 154;
    public static final int MAVLINK_MSG_LENGTH = 44;
    private static final long serialVersionUID = 164;
    public int lat;
    public int lng;
    public float pitch;
    public float roll;
    public float xacc;
    public float xgyro;
    public float yacc;
    public float yaw;
    public float ygyro;
    public float zacc;
    public float zgyro;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(44);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 164;
        mAVLinkPacket.crc_extra = 154;
        mAVLinkPacket.payload.putFloat(this.roll);
        mAVLinkPacket.payload.putFloat(this.pitch);
        mAVLinkPacket.payload.putFloat(this.yaw);
        mAVLinkPacket.payload.putFloat(this.xacc);
        mAVLinkPacket.payload.putFloat(this.yacc);
        mAVLinkPacket.payload.putFloat(this.zacc);
        mAVLinkPacket.payload.putFloat(this.xgyro);
        mAVLinkPacket.payload.putFloat(this.ygyro);
        mAVLinkPacket.payload.putFloat(this.zgyro);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lng);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.roll = mAVLinkPayload.getFloat();
        this.pitch = mAVLinkPayload.getFloat();
        this.yaw = mAVLinkPayload.getFloat();
        this.xacc = mAVLinkPayload.getFloat();
        this.yacc = mAVLinkPayload.getFloat();
        this.zacc = mAVLinkPayload.getFloat();
        this.xgyro = mAVLinkPayload.getFloat();
        this.ygyro = mAVLinkPayload.getFloat();
        this.zgyro = mAVLinkPayload.getFloat();
        this.lat = mAVLinkPayload.getInt();
        this.lng = mAVLinkPayload.getInt();
    }

    public msg_simstate() {
        this.msgid = 164;
    }

    public msg_simstate(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 164;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SIMSTATE - sysid:" + this.sysid + " compid:" + this.compid + " roll:" + this.roll + " pitch:" + this.pitch + " yaw:" + this.yaw + " xacc:" + this.xacc + " yacc:" + this.yacc + " zacc:" + this.zacc + " xgyro:" + this.xgyro + " ygyro:" + this.ygyro + " zgyro:" + this.zgyro + " lat:" + this.lat + " lng:" + this.lng + "";
    }
}
