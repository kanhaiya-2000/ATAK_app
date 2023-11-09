package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_high_latency extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIGH_LATENCY = 234;
    public static final int MAVLINK_MSG_ID_HIGH_LATENCY_CRC = 150;
    public static final int MAVLINK_MSG_LENGTH = 40;
    private static final long serialVersionUID = 234;
    public short airspeed;
    public short airspeed_sp;
    public short altitude_amsl;
    public short altitude_sp;
    public short base_mode;
    public short battery_remaining;
    public byte climb_rate;
    public long custom_mode;
    public short failsafe;
    public short gps_fix_type;
    public short gps_nsat;
    public short groundspeed;
    public int heading;
    public short heading_sp;
    public short landed_state;
    public int latitude;
    public int longitude;
    public short pitch;
    public short roll;
    public byte temperature;
    public byte temperature_air;
    public byte throttle;
    public int wp_distance;
    public short wp_num;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(40);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 234;
        mAVLinkPacket.crc_extra = 150;
        mAVLinkPacket.payload.putUnsignedInt(this.custom_mode);
        mAVLinkPacket.payload.putInt(this.latitude);
        mAVLinkPacket.payload.putInt(this.longitude);
        mAVLinkPacket.payload.putShort(this.roll);
        mAVLinkPacket.payload.putShort(this.pitch);
        mAVLinkPacket.payload.putUnsignedShort(this.heading);
        mAVLinkPacket.payload.putShort(this.heading_sp);
        mAVLinkPacket.payload.putShort(this.altitude_amsl);
        mAVLinkPacket.payload.putShort(this.altitude_sp);
        mAVLinkPacket.payload.putUnsignedShort(this.wp_distance);
        mAVLinkPacket.payload.putUnsignedByte(this.base_mode);
        mAVLinkPacket.payload.putUnsignedByte(this.landed_state);
        mAVLinkPacket.payload.putByte(this.throttle);
        mAVLinkPacket.payload.putUnsignedByte(this.airspeed);
        mAVLinkPacket.payload.putUnsignedByte(this.airspeed_sp);
        mAVLinkPacket.payload.putUnsignedByte(this.groundspeed);
        mAVLinkPacket.payload.putByte(this.climb_rate);
        mAVLinkPacket.payload.putUnsignedByte(this.gps_nsat);
        mAVLinkPacket.payload.putUnsignedByte(this.gps_fix_type);
        mAVLinkPacket.payload.putUnsignedByte(this.battery_remaining);
        mAVLinkPacket.payload.putByte(this.temperature);
        mAVLinkPacket.payload.putByte(this.temperature_air);
        mAVLinkPacket.payload.putUnsignedByte(this.failsafe);
        mAVLinkPacket.payload.putUnsignedByte(this.wp_num);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.custom_mode = mAVLinkPayload.getUnsignedInt();
        this.latitude = mAVLinkPayload.getInt();
        this.longitude = mAVLinkPayload.getInt();
        this.roll = mAVLinkPayload.getShort();
        this.pitch = mAVLinkPayload.getShort();
        this.heading = mAVLinkPayload.getUnsignedShort();
        this.heading_sp = mAVLinkPayload.getShort();
        this.altitude_amsl = mAVLinkPayload.getShort();
        this.altitude_sp = mAVLinkPayload.getShort();
        this.wp_distance = mAVLinkPayload.getUnsignedShort();
        this.base_mode = mAVLinkPayload.getUnsignedByte();
        this.landed_state = mAVLinkPayload.getUnsignedByte();
        this.throttle = mAVLinkPayload.getByte();
        this.airspeed = mAVLinkPayload.getUnsignedByte();
        this.airspeed_sp = mAVLinkPayload.getUnsignedByte();
        this.groundspeed = mAVLinkPayload.getUnsignedByte();
        this.climb_rate = mAVLinkPayload.getByte();
        this.gps_nsat = mAVLinkPayload.getUnsignedByte();
        this.gps_fix_type = mAVLinkPayload.getUnsignedByte();
        this.battery_remaining = mAVLinkPayload.getUnsignedByte();
        this.temperature = mAVLinkPayload.getByte();
        this.temperature_air = mAVLinkPayload.getByte();
        this.failsafe = mAVLinkPayload.getUnsignedByte();
        this.wp_num = mAVLinkPayload.getUnsignedByte();
    }

    public msg_high_latency() {
        this.msgid = 234;
    }

    public msg_high_latency(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 234;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIGH_LATENCY - sysid:" + this.sysid + " compid:" + this.compid + " custom_mode:" + this.custom_mode + " latitude:" + this.latitude + " longitude:" + this.longitude + " roll:" + this.roll + " pitch:" + this.pitch + " heading:" + this.heading + " heading_sp:" + this.heading_sp + " altitude_amsl:" + this.altitude_amsl + " altitude_sp:" + this.altitude_sp + " wp_distance:" + this.wp_distance + " base_mode:" + this.base_mode + " landed_state:" + this.landed_state + " throttle:" + this.throttle + " airspeed:" + this.airspeed + " airspeed_sp:" + this.airspeed_sp + " groundspeed:" + this.groundspeed + " climb_rate:" + this.climb_rate + " gps_nsat:" + this.gps_nsat + " gps_fix_type:" + this.gps_fix_type + " battery_remaining:" + this.battery_remaining + " temperature:" + this.temperature + " temperature_air:" + this.temperature_air + " failsafe:" + this.failsafe + " wp_num:" + this.wp_num + "";
    }
}
