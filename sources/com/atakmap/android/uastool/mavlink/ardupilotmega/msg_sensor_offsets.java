package com.atakmap.android.uastool.MAVLink.ardupilotmega;

import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkPayload;

public class msg_sensor_offsets extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SENSOR_OFFSETS = 150;
    public static final int MAVLINK_MSG_ID_SENSOR_OFFSETS_CRC = 134;
    public static final int MAVLINK_MSG_LENGTH = 42;
    private static final long serialVersionUID = 150;
    public float accel_cal_x;
    public float accel_cal_y;
    public float accel_cal_z;
    public float gyro_cal_x;
    public float gyro_cal_y;
    public float gyro_cal_z;
    public float mag_declination;
    public short mag_ofs_x;
    public short mag_ofs_y;
    public short mag_ofs_z;
    public int raw_press;
    public int raw_temp;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket(42);
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 150;
        mAVLinkPacket.crc_extra = 134;
        mAVLinkPacket.payload.putFloat(this.mag_declination);
        mAVLinkPacket.payload.putInt(this.raw_press);
        mAVLinkPacket.payload.putInt(this.raw_temp);
        mAVLinkPacket.payload.putFloat(this.gyro_cal_x);
        mAVLinkPacket.payload.putFloat(this.gyro_cal_y);
        mAVLinkPacket.payload.putFloat(this.gyro_cal_z);
        mAVLinkPacket.payload.putFloat(this.accel_cal_x);
        mAVLinkPacket.payload.putFloat(this.accel_cal_y);
        mAVLinkPacket.payload.putFloat(this.accel_cal_z);
        mAVLinkPacket.payload.putShort(this.mag_ofs_x);
        mAVLinkPacket.payload.putShort(this.mag_ofs_y);
        mAVLinkPacket.payload.putShort(this.mag_ofs_z);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.mag_declination = mAVLinkPayload.getFloat();
        this.raw_press = mAVLinkPayload.getInt();
        this.raw_temp = mAVLinkPayload.getInt();
        this.gyro_cal_x = mAVLinkPayload.getFloat();
        this.gyro_cal_y = mAVLinkPayload.getFloat();
        this.gyro_cal_z = mAVLinkPayload.getFloat();
        this.accel_cal_x = mAVLinkPayload.getFloat();
        this.accel_cal_y = mAVLinkPayload.getFloat();
        this.accel_cal_z = mAVLinkPayload.getFloat();
        this.mag_ofs_x = mAVLinkPayload.getShort();
        this.mag_ofs_y = mAVLinkPayload.getShort();
        this.mag_ofs_z = mAVLinkPayload.getShort();
    }

    public msg_sensor_offsets() {
        this.msgid = 150;
    }

    public msg_sensor_offsets(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 150;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SENSOR_OFFSETS - sysid:" + this.sysid + " compid:" + this.compid + " mag_declination:" + this.mag_declination + " raw_press:" + this.raw_press + " raw_temp:" + this.raw_temp + " gyro_cal_x:" + this.gyro_cal_x + " gyro_cal_y:" + this.gyro_cal_y + " gyro_cal_z:" + this.gyro_cal_z + " accel_cal_x:" + this.accel_cal_x + " accel_cal_y:" + this.accel_cal_y + " accel_cal_z:" + this.accel_cal_z + " mag_ofs_x:" + this.mag_ofs_x + " mag_ofs_y:" + this.mag_ofs_y + " mag_ofs_z:" + this.mag_ofs_z + "";
    }
}
