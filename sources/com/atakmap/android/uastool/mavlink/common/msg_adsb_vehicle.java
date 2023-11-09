package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_adsb_vehicle extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_ADSB_VEHICLE = 246;
    public static final int MAVLINK_MSG_ID_ADSB_VEHICLE_CRC = 184;
    public static final int MAVLINK_MSG_LENGTH = 38;
    private static final long serialVersionUID = 246;
    public long ICAO_address;
    public int altitude;
    public short altitude_type;
    public byte[] callsign = new byte[9];
    public short emitter_type;
    public int flags;
    public int heading;
    public int hor_velocity;
    public int lat;
    public int lon;
    public int squawk;
    public short tslc;
    public short ver_velocity;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(38);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 246;
        mAVLinkPacket.crc_extra = 184;
        mAVLinkPacket.payload.putUnsignedInt(this.ICAO_address);
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putInt(this.altitude);
        mAVLinkPacket.payload.putUnsignedShort(this.heading);
        mAVLinkPacket.payload.putUnsignedShort(this.hor_velocity);
        mAVLinkPacket.payload.putShort(this.ver_velocity);
        mAVLinkPacket.payload.putUnsignedShort(this.flags);
        mAVLinkPacket.payload.putUnsignedShort(this.squawk);
        mAVLinkPacket.payload.putUnsignedByte(this.altitude_type);
        for (byte putByte : this.callsign) {
            mAVLinkPacket.payload.putByte(putByte);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.emitter_type);
        mAVLinkPacket.payload.putUnsignedByte(this.tslc);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.ICAO_address = mAVLinkPayload.getUnsignedInt();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.altitude = mAVLinkPayload.getInt();
        this.heading = mAVLinkPayload.getUnsignedShort();
        this.hor_velocity = mAVLinkPayload.getUnsignedShort();
        this.ver_velocity = mAVLinkPayload.getShort();
        this.flags = mAVLinkPayload.getUnsignedShort();
        this.squawk = mAVLinkPayload.getUnsignedShort();
        this.altitude_type = mAVLinkPayload.getUnsignedByte();
        int i = 0;
        while (true) {
            byte[] bArr = this.callsign;
            if (i < bArr.length) {
                bArr[i] = mAVLinkPayload.getByte();
                i++;
            } else {
                this.emitter_type = mAVLinkPayload.getUnsignedByte();
                this.tslc = mAVLinkPayload.getUnsignedByte();
                return;
            }
        }
    }

    public msg_adsb_vehicle() {
        this.msgid = 246;
    }

    public msg_adsb_vehicle(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 246;
        unpack(mAVLinkPacket.payload);
    }

    public void setCallsign(String str) {
        int min = Math.min(str.length(), 9);
        for (int i = 0; i < min; i++) {
            this.callsign[i] = (byte) str.charAt(i);
        }
        while (min < 9) {
            this.callsign[min] = 0;
            min++;
        }
    }

    public String getCallsign() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            byte[] bArr = this.callsign;
            if (bArr[i] == 0) {
                break;
            }
            stringBuffer.append((char) bArr[i]);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ADSB_VEHICLE - sysid:" + this.sysid + " compid:" + this.compid + " ICAO_address:" + this.ICAO_address + " lat:" + this.lat + " lon:" + this.lon + " altitude:" + this.altitude + " heading:" + this.heading + " hor_velocity:" + this.hor_velocity + " ver_velocity:" + this.ver_velocity + " flags:" + this.flags + " squawk:" + this.squawk + " altitude_type:" + this.altitude_type + " callsign:" + this.callsign + " emitter_type:" + this.emitter_type + " tslc:" + this.tslc + "";
    }
}
