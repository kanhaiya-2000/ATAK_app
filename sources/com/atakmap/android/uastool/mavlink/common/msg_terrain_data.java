package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_terrain_data extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_TERRAIN_DATA = 134;
    public static final int MAVLINK_MSG_ID_TERRAIN_DATA_CRC = 229;
    public static final int MAVLINK_MSG_LENGTH = 43;
    private static final long serialVersionUID = 134;
    public short[] data = new short[16];
    public int grid_spacing;
    public short gridbit;
    public int lat;
    public int lon;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(43);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 134;
        mAVLinkPacket.crc_extra = 229;
        mAVLinkPacket.payload.putInt(this.lat);
        mAVLinkPacket.payload.putInt(this.lon);
        mAVLinkPacket.payload.putUnsignedShort(this.grid_spacing);
        for (short putShort : this.data) {
            mAVLinkPacket.payload.putShort(putShort);
        }
        mAVLinkPacket.payload.putUnsignedByte(this.gridbit);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.lat = mAVLinkPayload.getInt();
        this.lon = mAVLinkPayload.getInt();
        this.grid_spacing = mAVLinkPayload.getUnsignedShort();
        int i = 0;
        while (true) {
            short[] sArr = this.data;
            if (i < sArr.length) {
                sArr[i] = mAVLinkPayload.getShort();
                i++;
            } else {
                this.gridbit = mAVLinkPayload.getUnsignedByte();
                return;
            }
        }
    }

    public msg_terrain_data() {
        this.msgid = 134;
    }

    public msg_terrain_data(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 134;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_DATA - sysid:" + this.sysid + " compid:" + this.compid + " lat:" + this.lat + " lon:" + this.lon + " grid_spacing:" + this.grid_spacing + " data:" + this.data + " gridbit:" + this.gridbit + "";
    }
}
