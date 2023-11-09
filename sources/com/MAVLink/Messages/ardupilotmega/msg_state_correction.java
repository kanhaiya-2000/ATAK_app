package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_state_correction extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_STATE_CORRECTION = 64;
    public static final int MAVLINK_MSG_LENGTH = 36;
    private static final long serialVersionUID = 64;
    public float pitchErr;
    public float rollErr;
    public float vxErr;
    public float vyErr;
    public float vzErr;
    public float xErr;
    public float yErr;
    public float yawErr;
    public float zErr;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 36;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 64;
        mAVLinkPacket.payload.putFloat(this.xErr);
        mAVLinkPacket.payload.putFloat(this.yErr);
        mAVLinkPacket.payload.putFloat(this.zErr);
        mAVLinkPacket.payload.putFloat(this.rollErr);
        mAVLinkPacket.payload.putFloat(this.pitchErr);
        mAVLinkPacket.payload.putFloat(this.yawErr);
        mAVLinkPacket.payload.putFloat(this.vxErr);
        mAVLinkPacket.payload.putFloat(this.vyErr);
        mAVLinkPacket.payload.putFloat(this.vzErr);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.xErr = mAVLinkPayload.getFloat();
        this.yErr = mAVLinkPayload.getFloat();
        this.zErr = mAVLinkPayload.getFloat();
        this.rollErr = mAVLinkPayload.getFloat();
        this.pitchErr = mAVLinkPayload.getFloat();
        this.yawErr = mAVLinkPayload.getFloat();
        this.vxErr = mAVLinkPayload.getFloat();
        this.vyErr = mAVLinkPayload.getFloat();
        this.vzErr = mAVLinkPayload.getFloat();
    }

    public msg_state_correction() {
        this.msgid = 64;
    }

    public msg_state_correction(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 64;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_STATE_CORRECTION - xErr:" + this.xErr + " yErr:" + this.yErr + " zErr:" + this.zErr + " rollErr:" + this.rollErr + " pitchErr:" + this.pitchErr + " yawErr:" + this.yawErr + " vxErr:" + this.vxErr + " vyErr:" + this.vyErr + " vzErr:" + this.vzErr + "";
    }
}
