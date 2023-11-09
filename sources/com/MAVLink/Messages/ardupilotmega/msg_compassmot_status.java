package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_compassmot_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_COMPASSMOT_STATUS = 177;
    public static final int MAVLINK_MSG_LENGTH = 20;
    private static final long serialVersionUID = 177;
    public float CompensationX;
    public float CompensationY;
    public float CompensationZ;
    public float current;
    public short interference;
    public short throttle;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 20;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 177;
        mAVLinkPacket.payload.putFloat(this.current);
        mAVLinkPacket.payload.putFloat(this.CompensationX);
        mAVLinkPacket.payload.putFloat(this.CompensationY);
        mAVLinkPacket.payload.putFloat(this.CompensationZ);
        mAVLinkPacket.payload.putShort(this.throttle);
        mAVLinkPacket.payload.putShort(this.interference);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.current = mAVLinkPayload.getFloat();
        this.CompensationX = mAVLinkPayload.getFloat();
        this.CompensationY = mAVLinkPayload.getFloat();
        this.CompensationZ = mAVLinkPayload.getFloat();
        this.throttle = mAVLinkPayload.getShort();
        this.interference = mAVLinkPayload.getShort();
    }

    public msg_compassmot_status() {
        this.msgid = 177;
    }

    public msg_compassmot_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 177;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMPASSMOT_STATUS - current:" + this.current + " CompensationX:" + this.CompensationX + " CompensationY:" + this.CompensationY + " CompensationZ:" + this.CompensationZ + " throttle:" + this.throttle + " interference:" + this.interference + "";
    }
}
