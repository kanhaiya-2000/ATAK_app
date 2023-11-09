package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_limits_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LIMITS_STATUS = 167;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = 167;
    public short breach_count;
    public int last_action;
    public int last_clear;
    public int last_recovery;
    public int last_trigger;
    public byte limits_state;
    public byte mods_enabled;
    public byte mods_required;
    public byte mods_triggered;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 22;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 167;
        mAVLinkPacket.payload.putInt(this.last_trigger);
        mAVLinkPacket.payload.putInt(this.last_action);
        mAVLinkPacket.payload.putInt(this.last_recovery);
        mAVLinkPacket.payload.putInt(this.last_clear);
        mAVLinkPacket.payload.putShort(this.breach_count);
        mAVLinkPacket.payload.putByte(this.limits_state);
        mAVLinkPacket.payload.putByte(this.mods_enabled);
        mAVLinkPacket.payload.putByte(this.mods_required);
        mAVLinkPacket.payload.putByte(this.mods_triggered);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.last_trigger = mAVLinkPayload.getInt();
        this.last_action = mAVLinkPayload.getInt();
        this.last_recovery = mAVLinkPayload.getInt();
        this.last_clear = mAVLinkPayload.getInt();
        this.breach_count = mAVLinkPayload.getShort();
        this.limits_state = mAVLinkPayload.getByte();
        this.mods_enabled = mAVLinkPayload.getByte();
        this.mods_required = mAVLinkPayload.getByte();
        this.mods_triggered = mAVLinkPayload.getByte();
    }

    public msg_limits_status() {
        this.msgid = 167;
    }

    public msg_limits_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 167;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_LIMITS_STATUS - last_trigger:" + this.last_trigger + " last_action:" + this.last_action + " last_recovery:" + this.last_recovery + " last_clear:" + this.last_clear + " breach_count:" + this.breach_count + " limits_state:" + this.limits_state + " mods_enabled:" + this.mods_enabled + " mods_required:" + this.mods_required + " mods_triggered:" + this.mods_triggered + "";
    }
}
