package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_optical_flow_rad extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_OPTICAL_FLOW_RAD = 106;
    public static final int MAVLINK_MSG_ID_OPTICAL_FLOW_RAD_CRC = 138;
    public static final int MAVLINK_MSG_LENGTH = 44;
    private static final long serialVersionUID = 106;
    public float distance;
    public float integrated_x;
    public float integrated_xgyro;
    public float integrated_y;
    public float integrated_ygyro;
    public float integrated_zgyro;
    public long integration_time_us;
    public short quality;
    public short sensor_id;
    public short temperature;
    public long time_delta_distance_us;
    public long time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(44);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 106;
        mAVLinkPacket.crc_extra = 138;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putUnsignedInt(this.integration_time_us);
        mAVLinkPacket.payload.putFloat(this.integrated_x);
        mAVLinkPacket.payload.putFloat(this.integrated_y);
        mAVLinkPacket.payload.putFloat(this.integrated_xgyro);
        mAVLinkPacket.payload.putFloat(this.integrated_ygyro);
        mAVLinkPacket.payload.putFloat(this.integrated_zgyro);
        mAVLinkPacket.payload.putUnsignedInt(this.time_delta_distance_us);
        mAVLinkPacket.payload.putFloat(this.distance);
        mAVLinkPacket.payload.putShort(this.temperature);
        mAVLinkPacket.payload.putUnsignedByte(this.sensor_id);
        mAVLinkPacket.payload.putUnsignedByte(this.quality);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.integration_time_us = mAVLinkPayload.getUnsignedInt();
        this.integrated_x = mAVLinkPayload.getFloat();
        this.integrated_y = mAVLinkPayload.getFloat();
        this.integrated_xgyro = mAVLinkPayload.getFloat();
        this.integrated_ygyro = mAVLinkPayload.getFloat();
        this.integrated_zgyro = mAVLinkPayload.getFloat();
        this.time_delta_distance_us = mAVLinkPayload.getUnsignedInt();
        this.distance = mAVLinkPayload.getFloat();
        this.temperature = mAVLinkPayload.getShort();
        this.sensor_id = mAVLinkPayload.getUnsignedByte();
        this.quality = mAVLinkPayload.getUnsignedByte();
    }

    public msg_optical_flow_rad() {
        this.msgid = 106;
    }

    public msg_optical_flow_rad(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 106;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_OPTICAL_FLOW_RAD - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " integration_time_us:" + this.integration_time_us + " integrated_x:" + this.integrated_x + " integrated_y:" + this.integrated_y + " integrated_xgyro:" + this.integrated_xgyro + " integrated_ygyro:" + this.integrated_ygyro + " integrated_zgyro:" + this.integrated_zgyro + " time_delta_distance_us:" + this.time_delta_distance_us + " distance:" + this.distance + " temperature:" + this.temperature + " sensor_id:" + this.sensor_id + " quality:" + this.quality + "";
    }
}
