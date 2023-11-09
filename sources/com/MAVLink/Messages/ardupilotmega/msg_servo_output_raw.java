package com.MAVLink.Messages.ardupilotmega;

import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkPayload;

public class msg_servo_output_raw extends MAVLinkMessage {
    public static final int MAVLINK_MSG_ID_SERVO_OUTPUT_RAW = 36;
    public static final int MAVLINK_MSG_LENGTH = 21;
    private static final long serialVersionUID = 36;
    public byte port;
    public short servo1_raw;
    public short servo2_raw;
    public short servo3_raw;
    public short servo4_raw;
    public short servo5_raw;
    public short servo6_raw;
    public short servo7_raw;
    public short servo8_raw;
    public int time_usec;

    public MAVLinkPacket pack() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.len = 21;
        mAVLinkPacket.sysid = 255;
        mAVLinkPacket.compid = 190;
        mAVLinkPacket.msgid = 36;
        mAVLinkPacket.payload.putInt(this.time_usec);
        mAVLinkPacket.payload.putShort(this.servo1_raw);
        mAVLinkPacket.payload.putShort(this.servo2_raw);
        mAVLinkPacket.payload.putShort(this.servo3_raw);
        mAVLinkPacket.payload.putShort(this.servo4_raw);
        mAVLinkPacket.payload.putShort(this.servo5_raw);
        mAVLinkPacket.payload.putShort(this.servo6_raw);
        mAVLinkPacket.payload.putShort(this.servo7_raw);
        mAVLinkPacket.payload.putShort(this.servo8_raw);
        mAVLinkPacket.payload.putByte(this.port);
        return mAVLinkPacket;
    }

    public void unpack(MAVLinkPayload mAVLinkPayload) {
        mAVLinkPayload.resetIndex();
        this.time_usec = mAVLinkPayload.getInt();
        this.servo1_raw = mAVLinkPayload.getShort();
        this.servo2_raw = mAVLinkPayload.getShort();
        this.servo3_raw = mAVLinkPayload.getShort();
        this.servo4_raw = mAVLinkPayload.getShort();
        this.servo5_raw = mAVLinkPayload.getShort();
        this.servo6_raw = mAVLinkPayload.getShort();
        this.servo7_raw = mAVLinkPayload.getShort();
        this.servo8_raw = mAVLinkPayload.getShort();
        this.port = mAVLinkPayload.getByte();
    }

    public msg_servo_output_raw() {
        this.msgid = 36;
    }

    public msg_servo_output_raw(MAVLinkPacket mAVLinkPacket) {
        this.sysid = mAVLinkPacket.sysid;
        this.compid = mAVLinkPacket.compid;
        this.msgid = 36;
        unpack(mAVLinkPacket.payload);
    }

    public String toString() {
        return "MAVLINK_MSG_ID_SERVO_OUTPUT_RAW - time_usec:" + this.time_usec + " servo1_raw:" + this.servo1_raw + " servo2_raw:" + this.servo2_raw + " servo3_raw:" + this.servo3_raw + " servo4_raw:" + this.servo4_raw + " servo5_raw:" + this.servo5_raw + " servo6_raw:" + this.servo6_raw + " servo7_raw:" + this.servo7_raw + " servo8_raw:" + this.servo8_raw + " port:" + this.port + "";
    }
}
