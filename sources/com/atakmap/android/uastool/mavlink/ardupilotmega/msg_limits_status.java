package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_limits_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_LIMITS_STATUS = 167;
    public static final int MAVLINK_MSG_ID_LIMITS_STATUS_CRC = 144;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = 167;
    public int breach_count;
    public long last_action;
    public long last_clear;
    public long last_recovery;
    public long last_trigger;
    public short limits_state;
    public short mods_enabled;
    public short mods_required;
    public short mods_triggered;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(22);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 167;
        mAVLinkPacket.crc_extra = 144;
        mAVLinkPacket.payload.putUnsignedInt(this.last_trigger);
        mAVLinkPacket.payload.putUnsignedInt(this.last_action);
        mAVLinkPacket.payload.putUnsignedInt(this.last_recovery);
        mAVLinkPacket.payload.putUnsignedInt(this.last_clear);
        mAVLinkPacket.payload.putUnsignedShort(this.breach_count);
        mAVLinkPacket.payload.putUnsignedByte(this.limits_state);
        mAVLinkPacket.payload.putUnsignedByte(this.mods_enabled);
        mAVLinkPacket.payload.putUnsignedByte(this.mods_required);
        mAVLinkPacket.payload.putUnsignedByte(this.mods_triggered);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.last_trigger = mAVLinkPayload.getUnsignedInt();
        this.last_action = mAVLinkPayload.getUnsignedInt();
        this.last_recovery = mAVLinkPayload.getUnsignedInt();
        this.last_clear = mAVLinkPayload.getUnsignedInt();
        this.breach_count = mAVLinkPayload.getUnsignedShort();
        this.limits_state = mAVLinkPayload.getUnsignedByte();
        this.mods_enabled = mAVLinkPayload.getUnsignedByte();
        this.mods_required = mAVLinkPayload.getUnsignedByte();
        this.mods_triggered = mAVLinkPayload.getUnsignedByte();
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
        return "MAVLINK_MSG_ID_LIMITS_STATUS - sysid:" + this.sysid + " compid:" + this.compid + " last_trigger:" + this.last_trigger + " last_action:" + this.last_action + " last_recovery:" + this.last_recovery + " last_clear:" + this.last_clear + " breach_count:" + this.breach_count + " limits_state:" + this.limits_state + " mods_enabled:" + this.mods_enabled + " mods_required:" + this.mods_required + " mods_triggered:" + this.mods_triggered + "";
    }
}
