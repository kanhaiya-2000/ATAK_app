package com.atakmap.android.uastool.MAVLink.common;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_hil_sensor extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_HIL_SENSOR = 107;
    public static final int MAVLINK_MSG_ID_HIL_SENSOR_CRC = 108;
    public static final int MAVLINK_MSG_LENGTH = 64;
    private static final long serialVersionUID = 107;
    public float abs_pressure;
    public float diff_pressure;
    public long fields_updated;
    public float pressure_alt;
    public float temperature;
    public long time_usec;
    public float xacc;
    public float xgyro;
    public float xmag;
    public float yacc;
    public float ygyro;
    public float ymag;
    public float zacc;
    public float zgyro;
    public float zmag;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(64);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 107;
        mAVLinkPacket.crc_extra = 108;
        mAVLinkPacket.payload.putUnsignedLong(this.time_usec);
        mAVLinkPacket.payload.putFloat(this.xacc);
        mAVLinkPacket.payload.putFloat(this.yacc);
        mAVLinkPacket.payload.putFloat(this.zacc);
        mAVLinkPacket.payload.putFloat(this.xgyro);
        mAVLinkPacket.payload.putFloat(this.ygyro);
        mAVLinkPacket.payload.putFloat(this.zgyro);
        mAVLinkPacket.payload.putFloat(this.xmag);
        mAVLinkPacket.payload.putFloat(this.ymag);
        mAVLinkPacket.payload.putFloat(this.zmag);
        mAVLinkPacket.payload.putFloat(this.abs_pressure);
        mAVLinkPacket.payload.putFloat(this.diff_pressure);
        mAVLinkPacket.payload.putFloat(this.pressure_alt);
        mAVLinkPacket.payload.putFloat(this.temperature);
        mAVLinkPacket.payload.putUnsignedInt(this.fields_updated);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getUnsignedLong();
        this.xacc = mAVLinkPayload.getFloat();
        this.yacc = mAVLinkPayload.getFloat();
        this.zacc = mAVLinkPayload.getFloat();
        this.xgyro = mAVLinkPayload.getFloat();
        this.ygyro = mAVLinkPayload.getFloat();
        this.zgyro = mAVLinkPayload.getFloat();
        this.xmag = mAVLinkPayload.getFloat();
        this.ymag = mAVLinkPayload.getFloat();
        this.zmag = mAVLinkPayload.getFloat();
        this.abs_pressure = mAVLinkPayload.getFloat();
        this.diff_pressure = mAVLinkPayload.getFloat();
        this.pressure_alt = mAVLinkPayload.getFloat();
        this.temperature = mAVLinkPayload.getFloat();
        this.fields_updated = mAVLinkPayload.getUnsignedInt();
    }

    public msg_hil_sensor() {
        this.msgid = 107;
    }

    public msg_hil_sensor(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 107;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_HIL_SENSOR - sysid:" + this.sysid + " compid:" + this.compid + " time_usec:" + this.time_usec + " xacc:" + this.xacc + " yacc:" + this.yacc + " zacc:" + this.zacc + " xgyro:" + this.xgyro + " ygyro:" + this.ygyro + " zgyro:" + this.zgyro + " xmag:" + this.xmag + " ymag:" + this.ymag + " zmag:" + this.zmag + " abs_pressure:" + this.abs_pressure + " diff_pressure:" + this.diff_pressure + " pressure_alt:" + this.pressure_alt + " temperature:" + this.temperature + " fields_updated:" + this.fields_updated + "";
    }
}
