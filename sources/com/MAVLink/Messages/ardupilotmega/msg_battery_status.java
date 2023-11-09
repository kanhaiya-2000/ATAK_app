package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_battery_status extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_BATTERY_STATUS = 147;
    public static final int MAVLINK_MSG_LENGTH = 36;
    private static final long serialVersionUID = 147;
    public byte battery_remaining;
    public short current_battery;
    public int current_consumed;
    public int energy_consumed;
    public byte function;

    /* renamed from: id */
    public byte f8126id;
    public short temperature;
    public byte type;
    public short[] voltages = new short[10];

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 36;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 147;
        mAVLinkPacket.payload.putInt(this.current_consumed);
        mAVLinkPacket.payload.putInt(this.energy_consumed);
        mAVLinkPacket.payload.putShort(this.temperature);
        for (short putShort : this.voltages) {
            mAVLinkPacket.payload.putShort(putShort);
        }
        mAVLinkPacket.payload.putShort(this.current_battery);
        mAVLinkPacket.payload.putByte(this.f8126id);
        mAVLinkPacket.payload.putByte(this.function);
        mAVLinkPacket.payload.putByte(this.type);
        mAVLinkPacket.payload.putByte(this.battery_remaining);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.current_consumed = mAVLinkPayload.getInt();
        this.energy_consumed = mAVLinkPayload.getInt();
        this.temperature = mAVLinkPayload.getShort();
        int i = 0;
        while (true) {
            short[] sArr = this.voltages;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getShort();
                i++;
            } else {
                this.current_battery = mAVLinkPayload.getShort();
                this.f8126id = mAVLinkPayload.getByte();
                this.function = mAVLinkPayload.getByte();
                this.type = mAVLinkPayload.getByte();
                this.battery_remaining = mAVLinkPayload.getByte();
                return;
            }
        }
    }

    public msg_battery_status() {
        this.msgid = 147;
    }

    public msg_battery_status(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 147;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_BATTERY_STATUS - current_consumed:" + this.current_consumed + " energy_consumed:" + this.energy_consumed + " temperature:" + this.temperature + " voltages:" + this.voltages + " current_battery:" + this.current_battery + " id:" + this.f8126id + " function:" + this.function + " type:" + this.type + " battery_remaining:" + this.battery_remaining + "";
    }
}
